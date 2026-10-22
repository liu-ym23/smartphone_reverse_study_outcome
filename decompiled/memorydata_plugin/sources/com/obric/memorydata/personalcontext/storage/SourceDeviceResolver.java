package com.obric.memorydata.personalcontext.storage;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.bytedance.crash.entity.EventBody;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.PhotoEntity;
import com.obric.capabilitykit.entity.app.RecordingEntity;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001:\u00013B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0013\u001a\u00020\u0014J\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u0005H\u0000¢\u0006\u0002\b\u0017J!\u0010\u0018\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0005H\u0000¢\u0006\u0002\b\u001cJ3\u0010\u0018\u001a\u0004\u0018\u00010\u00052\b\u0010\u001d\u001a\u0004\u0018\u00010\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u00052\u000e\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u001fH\u0000¢\u0006\u0002\b\u001cJ\u0019\u0010 \u001a\u0004\u0018\u00010\u00052\b\u0010!\u001a\u0004\u0018\u00010\u0005H\u0000¢\u0006\u0002\b\"J\u0019\u0010#\u001a\u0004\u0018\u00010\u00052\b\u0010\u001d\u001a\u0004\u0018\u00010\u0005H\u0000¢\u0006\u0002\b$J\u0014\u0010%\u001a\u0004\u0018\u00010\u00052\b\u0010&\u001a\u0004\u0018\u00010'H\u0002J\u0014\u0010(\u001a\u0004\u0018\u00010\u00052\b\u0010&\u001a\u0004\u0018\u00010\u0005H\u0002J\u000e\u0010)\u001a\u0004\u0018\u00010\u0005*\u00020'H\u0002J\u0012\u0010*\u001a\u0004\u0018\u00010\u00052\u0006\u0010+\u001a\u00020,H\u0002J\u0012\u0010-\u001a\u0004\u0018\u00010\u00052\u0006\u0010+\u001a\u00020,H\u0002J\u001a\u0010.\u001a\u0004\u0018\u00010\u00052\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u0005H\u0002J\u0014\u00102\u001a\u0004\u0018\u00010\u00052\b\u0010\u001d\u001a\u0004\u0018\u00010\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/obric/memorydata/personalcontext/storage/SourceDeviceResolver;", "", "<init>", "()V", "EXTRA_FILE_PATH", "", "EXTRA_SOURCE_DEVICE", "RECORDING_SOURCE_PACKAGE_PREFIX", "SOURCE_DEVICE_GLASS", "NOVA_PHOTO_FILE_PREFIX", "NOVA_PHOTO_RELATIVE_PREFIX", "modelsByHexId", "", "Lcom/obric/memorydata/personalcontext/storage/SourceDeviceResolver$DeviceModel;", "modelsByDecimalId", "", "photoPathModels", "", "resolve", "appEntity", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "resolvePhotoFromMediaPath", Params.FILE_PATH, "resolvePhotoFromMediaPath$personal_context_obricRelease", "resolvePhotoSourceDevice", "photoEntity", "Lcom/obric/capabilitykit/entity/app/PhotoEntity;", "existingSourceDevice", "resolvePhotoSourceDevice$personal_context_obricRelease", "extraData", "resolveFilePath", "Lkotlin/Function0;", "resolveRecordingFromSourcePackage", "sourceAppPackage", "resolveRecordingFromSourcePackage$personal_context_obricRelease", "resolveFromExtraData", "resolveFromExtraData$personal_context_obricRelease", "normalizeSourceDeviceValue", EventBody.KEY_VALUE, "Lcom/google/gson/JsonElement;", "normalizeSourceDeviceText", "asStringOrNull", "resolvePhotoPathFromUri", "uri", "Landroid/net/Uri;", "queryMediaStorePath", "readCursorString", "cursor", "Landroid/database/Cursor;", "columnName", "resolveExtraFilePath", "DeviceModel", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SourceDeviceResolver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SourceDeviceResolver f12339a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map<String, DeviceModel> f12340b = null;
    private static final Map<Integer, DeviceModel> c = null;
    private static final List<DeviceModel> d = null;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B=\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fj\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017¨\u0006\u0018"}, d2 = {"Lcom/obric/memorydata/personalcontext/storage/SourceDeviceResolver$DeviceModel;", "", "hexId", "", "decimalId", "", "sourceDeviceClass", "photoPathPrefix", "photoRelativePathPrefix", "<init>", "(Ljava/lang/String;ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getHexId", "()Ljava/lang/String;", "getDecimalId", "()I", "getSourceDeviceClass", "getPhotoPathPrefix", "getPhotoRelativePathPrefix", "DORA_G", "DORA_G2", "DORA_LITE", "FREE_CLIP2", "FREE_BUDS_PRO", "FREE_CLIP2_HE", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final enum DeviceModel extends Enum<DeviceModel> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ DeviceModel[] $VALUES = null;
        public static final DeviceModel DORA_G = null;
        public static final DeviceModel DORA_G2 = null;
        public static final DeviceModel DORA_LITE = null;
        public static final DeviceModel FREE_BUDS_PRO = null;
        public static final DeviceModel FREE_CLIP2 = null;
        public static final DeviceModel FREE_CLIP2_HE = null;
        private final int decimalId;
        private final String hexId;
        private final String photoPathPrefix;
        private final String photoRelativePathPrefix;
        private final String sourceDeviceClass;

        private static final /* synthetic */ DeviceModel[] $values() {
            return new DeviceModel[]{DORA_G, DORA_G2, DORA_LITE, FREE_CLIP2, FREE_BUDS_PRO, FREE_CLIP2_HE};
        }

        static {
            DORA_G = new DeviceModel("DORA_G", 0, "0x0010", 16, "Glass", "/storage/emulated/0/pictures/nova/files/doraG/", "pictures/nova/files/doraG/");
            DORA_G2 = new DeviceModel("DORA_G2", 1, "0x0011", 17, "Glass", "/storage/emulated/0/pictures/nova/files/doraG2/", "pictures/nova/files/doraG2/");
            DORA_LITE = new DeviceModel("DORA_LITE", 2, "0x00000001", 1, null, null, null, 28, null);
            String r6 = null;
            String r7 = null;
            String r8 = null;
            int r9 = 28;
            DefaultConstructorMarker r10 = null;
            FREE_CLIP2 = new DeviceModel("FREE_CLIP2", 3, "0x00100002", 1048578, r6, r7, r8, r9, r10);
            FREE_BUDS_PRO = new DeviceModel("FREE_BUDS_PRO", 4, "0x00000032", 50, null, null, null, 28, null);
            FREE_CLIP2_HE = new DeviceModel("FREE_CLIP2_HE", 5, "0x0000003", 3, r6, r7, r8, r9, r10);
            DeviceModel[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
        }

        private DeviceModel(String r1, int r2, String r3, int r4, String r5, String r6, String r7) {
            super(r1, r2);
            this.hexId = r3;
            this.decimalId = r4;
            this.sourceDeviceClass = r5;
            this.photoPathPrefix = r6;
            this.photoRelativePathPrefix = r7;
        }

        /* synthetic */ DeviceModel(String r11, int r12, String r13, int r14, String r15, String r16, String r17, int r18, DefaultConstructorMarker r19) {
            if ((r18 & 4) == 0) goto L5;
            String r7 = null;
        L7:
            if ((r18 & 8) == 0) goto L9;
            String r8 = null;
        L11:
            if ((r18 & 16) == 0) goto L13;
            String r9 = null;
        L14:
            this(r11, r12, r13, r14, r7, r8, r9);
            return;
        L13:
            r9 = r17;
            goto L14
        L9:
            r8 = r16;
            goto L11
        L5:
            r7 = r15;
            goto L7
        }

        public static EnumEntries<DeviceModel> getEntries() {
            return $ENTRIES;
        }

        public static DeviceModel valueOf(String r2) {
            return (DeviceModel) ZeusTransformUtils.preCheckCast(Enum.valueOf(DeviceModel.class, r2), DeviceModel.class, "com.obric.memorydata.plugin");
        }

        public static DeviceModel[] values() {
            return (DeviceModel[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), DeviceModel[].class, "com.obric.memorydata.plugin");
        }

        public final int getDecimalId() {
            return this.decimalId;
        }

        public final String getHexId() {
            return this.hexId;
        }

        public final String getPhotoPathPrefix() {
            return this.photoPathPrefix;
        }

        public final String getPhotoRelativePathPrefix() {
            return this.photoRelativePathPrefix;
        }

        public final String getSourceDeviceClass() {
            return this.sourceDeviceClass;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        f12339a = new SourceDeviceResolver();
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(DeviceModel.getEntries(), Iterable.class, "com.obric.memorydata.plugin");
        Map<String, DeviceModel> r3 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r0, 10)), 16)), Map.class, "com.obric.memorydata.plugin");
        Iterator r1 = r0.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        Object r5 = r1.next();
        String r6 = ((DeviceModel) ZeusTransformUtils.preCheckCast(r5, DeviceModel.class, "com.obric.memorydata.plugin")).getHexId().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(r6, "toLowerCase(...)");
        r3.put(r6, r5);
        goto L4
    L6:
        f12340b = r3;
        Iterable r2 = (Iterable) ZeusTransformUtils.preCheckCast(DeviceModel.getEntries(), Iterable.class, "com.obric.memorydata.plugin");
        Map<Integer, DeviceModel> r4 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r2, 10)), 16)), Map.class, "com.obric.memorydata.plugin");
        Iterator r7 = r2.iterator();
    L8:
        if (r7.hasNext() == false) goto L10;
        Object r8 = r7.next();
        r4.put(Integer.valueOf(((DeviceModel) ZeusTransformUtils.preCheckCast(r8, DeviceModel.class, "com.obric.memorydata.plugin")).getDecimalId()), r8);
        goto L8
    L10:
        c = r4;
        Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast(DeviceModel.getEntries(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r10 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r11 = r9.iterator();
    L12:
        if (r11.hasNext() == false) goto L19;
        Object r12 = r11.next();
        if (((DeviceModel) ZeusTransformUtils.preCheckCast(r12, DeviceModel.class, "com.obric.memorydata.plugin")).getPhotoPathPrefix() == null) goto L16;
        boolean r13 = true;
    L17:
        if (r13 == false) goto L12;
        r10.add(r12);
        goto L12
    L16:
        r13 = false;
        goto L17
    L19:
        d = (List) ZeusTransformUtils.preCheckCast(r10, List.class, "com.obric.memorydata.plugin");
    }

    private SourceDeviceResolver() {
    }

    private final String a(Cursor r2, String r3) {
        Cursor r1 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r2, Cursor.class, "com.obric.memorydata.plugin");
        int r4 = r1.getColumnIndex(r3);
        if (r4 >= 0) goto L5;
        return null;
    L5:
        String r5 = r1.getString(r4);
        if (r5 != null) goto L8;
        return null;
    L8:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L10;
        return null;
    L10:
        return r5;
    }

    private final String a(Uri r3) {
        if (Intrinsics.areEqual(r3.getScheme(), Params.CONTENT) == false) goto L5;
        String r2 = b(r3);
        if (r2 == null) goto L9;
        return r2;
    L9:
        return r3.getPath();
    L5:
        return r3.getPath();
    }

    private final String a(JsonElement r4) {
        if (r4 != null) goto L5;
        return null;
    L5:
        if (r4.isJsonNull() == false) goto L8;
        return null;
    L8:
        if (r4.isJsonArray() == false) goto L17;
        JsonArray r3 = r4.getAsJsonArray();
        Intrinsics.checkNotNullExpressionValue(r3, "getAsJsonArray(...)");
        Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L11:
        if (r5.hasNext() == false) goto L15;
        String r6 = f12339a.a((JsonElement) ZeusTransformUtils.preCheckCast(r5.next(), JsonElement.class, "com.obric.memorydata.plugin"));
        if (r6 == null) goto L11;
        return r6;
    L15:
        return null;
    L17:
        if (r4.isJsonPrimitive() == true) goto L20;
        r4 = null;
    L20:
        if (r4 == null) goto L29;
        String r7 = r4.getAsString();
        if (r7 != null) goto L24;
        return null;
    L24:
        return d(r7);
    L29:
        return null;
    }

    private static final String a(PhotoEntity r1) {
        return f12339a.a(r1.getFile().getContentUrl());
    }

    private final String b(Uri r11) {
        String[] r4 = {"_data", "relative_path"};
        Cursor r12 = ZeusProviderTransform.query(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getContentResolver(), r11, r4, null, null, null, "com.obric.memorydata.plugin");     // Catch: Throwable -> L21
        if (r12 == null) goto L20;
        Closeable r13 = (Closeable) ZeusTransformUtils.preCheckCast(r12, Closeable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L21
        Cursor r10 = (Cursor) ZeusTransformUtils.preCheckCast(r13, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L15
        if (r10.moveToFirst() == true) goto L10;
        CloseableKt.closeFinally(r13, null);     // Catch: Throwable -> L21 Throwable -> L21
        return null;
    L10:
        SourceDeviceResolver r2 = f12339a;     // Catch: Throwable -> L15
        String r0 = r2.a(r10, "_data");     // Catch: Throwable -> L15
        if (r0 != null) goto L13;
        r0 = r2.a(r10, "relative_path");     // Catch: Throwable -> L15
    L13:
        CloseableKt.closeFinally(r13, null);     // Catch: Throwable -> L21 Throwable -> L21
        return r0;
    L15:
        th = move-exception;
        throw th;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        CloseableKt.closeFinally(r13, th);     // Catch: Throwable -> L21 Throwable -> L21
        throw th;     // Catch: Throwable -> L21 Throwable -> L21
    L20:
        return null;
    L28:
        return null;
    }

    private final String b(JsonElement r3) {
        if (r3.isJsonPrimitive() == true) goto L6;
        r3 = null;
    L6:
        if (r3 == null) goto L13;
        String r2 = r3.getAsString();
        if (r2 != null) goto L10;
        return null;
    L10:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L12;
        return null;
    L12:
        return r2;
    L13:
        return null;
    }

    private final String d(String r9) {
        if (r9 == null) goto L20;
        List r10 = StringsKt.split$default((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin"), new String[]{","}, false, 0, 6, null);
        if (r10 == null) goto L20;
        Iterable r11 = (Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.memorydata.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r11, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r12 = r11.iterator();
    L8:
        if (r12.hasNext() == false) goto L10;
        r2.add(StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r12.next(), String.class, "com.obric.memorydata.plugin"), CharSequence.class, "com.obric.memorydata.plugin")).toString());
        goto L8
    L10:
        Iterable r13 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r14 = r13.iterator();
    L12:
        if (r14.hasNext() == false) goto L19;
        Object r4 = r14.next();
        if (((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.memorydata.plugin"), CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L16;
        boolean r5 = true;
    L17:
        if (r5 == false) goto L12;
        r3.add(r4);
        goto L12
    L16:
        r5 = false;
        goto L17
    L19:
        List r15 = (List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin");
    L21:
        if (r15 != null) goto L23;
        r15 = CollectionsKt.emptyList();
    L23:
        Iterator r16 = ((Iterable) ZeusTransformUtils.preCheckCast(r15, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L25:
        if (r16.hasNext() == false) goto L48;
        String r6 = (String) ZeusTransformUtils.preCheckCast(r16.next(), String.class, "com.obric.memorydata.plugin");
        String r7 = "Glass";
        if (StringsKt.equals(r6, "Glass", true) == true) goto L33;
        Map<String, DeviceModel> r8 = f12340b;
        String r17 = r6.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(r17, "toLowerCase(...)");
        DeviceModel r18 = (DeviceModel) ZeusTransformUtils.preCheckCast(r8.get(r17), DeviceModel.class, "com.obric.memorydata.plugin");
        if (r18 == null) goto L32;
        r7 = r18.getSourceDeviceClass();
        goto L33
    L32:
        r7 = null;
    L33:
        if (r7 == null) goto L25;
        return r7;
    L48:
        return null;
    L20:
        r15 = null;
        goto L21
    }

    private final String e(String r4) {
        if (r4 != null) goto L5;
        return null;
    L5:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L8;
        r4 = null;
    L8:
        if (r4 == null) goto L28;
        JsonElement r5 = JsonParser.parseString(r4);     // Catch: JsonParseException -> L21
        if (r5.isJsonObject() == true) goto L14;
        r5 = null;
    L14:
        if (r5 == null) goto L25;
        JsonObject r6 = r5.getAsJsonObject();     // Catch: JsonParseException -> L21
        if (r6 == null) goto L26;
        JsonElement r7 = r6.get(Params.FILE_PATH);
        if (r7 != null) goto L20;
        return null;
    L20:
        return b(r7);
    L26:
        return null;
    L25:
        return null;
    L29:
        return null;
    L28:
        return null;
    }

    public static /* synthetic */ String lambda$lP9li34kWEbLgD1ftO7JXjfSNRE(PhotoEntity r0) {
        return a(r0);
    }

    public final String a(AppEntity r3) {
        Intrinsics.checkNotNullParameter(r3, "appEntity");
        if (ZeusTransformUtils.instanceOf(r3, PhotoEntity.class) == false) goto L6;
        return a((PhotoEntity) ZeusTransformUtils.preCheckCast(r3, PhotoEntity.class, "com.obric.memorydata.plugin"), null);
    L6:
        if (ZeusTransformUtils.instanceOf(r3, RecordingEntity.class) == false) goto L12;
        String r0 = b(((RecordingEntity) ZeusTransformUtils.preCheckCast(r3, RecordingEntity.class, "com.obric.memorydata.plugin")).getSourceAppPackage());
        if (r0 == null) goto L12;
        return r0;
    L12:
        return c(r3.getExtraData());
    }

    public final String a(final PhotoEntity r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "photoEntity");
        return a(r3.getExtraData(), r4, new $$Lambda$SourceDeviceResolver$lP9li34kWEbLgD1ftO7JXjfSNRE(r3));
    }

    public final String a(String r10) {
        if (r10 == null) goto L34;
        String r11 = r10.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(r11, "toLowerCase(...)");
        if (r11 == null) goto L36;
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(d, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L9:
        if (r1.hasNext() == false) goto L24;
        Object r2 = r1.next();
        DeviceModel r4 = (DeviceModel) ZeusTransformUtils.preCheckCast(r2, DeviceModel.class, "com.obric.memorydata.plugin");
        String r5 = r4.getPhotoPathPrefix();
        String r6 = "";
        if (r5 != null) goto L13;
        r5 = "";
    L13:
        String r7 = r5.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(r7, "toLowerCase(...)");
        boolean r8 = false;
        if (StringsKt.startsWith$default(r11, r7, false, 2, null) == true) goto L21;
        String r9 = r4.getPhotoRelativePathPrefix();
        if (r9 == null) goto L19;
        r6 = r9;
    L19:
        String r12 = r6.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(r12, "toLowerCase(...)");
        if (StringsKt.startsWith$default(r11, r12, false, 2, null) == true) goto L21;
    L22:
        if (r8 == false) goto L9;
    L25:
        DeviceModel r13 = (DeviceModel) ZeusTransformUtils.preCheckCast(r2, DeviceModel.class, "com.obric.memorydata.plugin");
        if (r13 != null) goto L28;
        return null;
    L28:
        return r13.getSourceDeviceClass();
    L21:
        r8 = true;
        goto L22
    L24:
        r2 = null;
        goto L25
    L36:
        return null;
    L34:
        return null;
    }

    public final String a(String r3, String r4, Function0<String> r5) {
        Function0 r6 = (Function0) ZeusTransformUtils.wrapperContextForParams(r5, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "resolveFilePath");
        String r7 = a(e(r3));
        if (r7 == null) goto L5;
        return r7;
    L5:
        String r2 = a((String) ZeusTransformUtils.preCheckCast(r6.invoke(), String.class, "com.obric.memorydata.plugin"));
        if (r2 == null) goto L8;
        return r2;
    L8:
        return r4;
    }

    public final String b(String r4) {
        if (r4 != null) goto L5;
        return null;
    L5:
        if (StringsKt.startsWith$default(r4, "com.obric.wearable:", false, 2, null) == true) goto L8;
        r4 = null;
    L8:
        if (r4 == null) goto L18;
        String r5 = StringsKt.substringAfter$default(r4, "com.obric.wearable:", null, 2, null);
        if (r5 == null) goto L19;
        Integer r6 = StringsKt.toIntOrNull(r5);
        if (r6 == null) goto L20;
        DeviceModel r7 = (DeviceModel) ZeusTransformUtils.preCheckCast(c.get(Integer.valueOf(r6.intValue())), DeviceModel.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L16;
        return null;
    L16:
        return r7.getSourceDeviceClass();
    L20:
        return null;
    L19:
        return null;
    L18:
        return null;
    }

    public final String c(String r4) {
        if (r4 != null) goto L5;
    L26:
        return null;
    L5:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L8;
        r4 = null;
    L8:
        if (r4 == null) goto L26;
        JsonElement r5 = JsonParser.parseString(r4);     // Catch: JsonParseException -> L27
        if (r5.isJsonObject() == true) goto L14;
        r5 = null;
    L14:
        if (r5 == null) goto L26;
        JsonObject r6 = r5.getAsJsonObject();     // Catch: JsonParseException -> L27
        if (r6 == null) goto L26;
        JsonElement r0 = r6.get(Params.FILE_PATH);
        if (r0 == null) goto L25;
        String r1 = b(r0);
        if (r1 == null) goto L25;
        String r2 = f12339a.a(r1);
        if (r2 == null) goto L25;
        return r2;
    L25:
        return a(r6.get("sourceDevice"));
    }
}
