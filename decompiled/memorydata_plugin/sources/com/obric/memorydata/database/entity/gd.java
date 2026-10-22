package com.obric.memorydata.database.entity;

import com.bytedance.crash.entity.EventBody;
import com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatype;
import com.google.gson.JsonParseException;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.capabilitykit.entity.app.FileEntity;
import com.obric.memorydata.annotation.Type;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.ttnet.org.chromium.net.NetError;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000bH\u0002J\u0006\u0010\u000e\u001a\u00020\u0005J:\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00012\b\u0010\u0012\u001a\u0004\u0018\u00010\u00012\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0016\u001a\u00020\u0010J \u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u0005J6\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u00052\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00050\"J\"\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010%\u001a\u00020&H\u0002J<\u0010'\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00012\b\u0010\u0012\u001a\u0004\u0018\u00010\u00012\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0016\u001a\u00020\u0010H\u0002J(\u0010(\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00012\b\u0010\u0012\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u0005H\u0002J(\u0010*\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00012\b\u0010\u0012\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0005H\u0002J\u001c\u0010+\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001H\u0002J\u001c\u0010,\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001H\u0002J\u001a\u0010-\u001a\u00020\u00052\b\u0010.\u001a\u0004\u0018\u00010\u00052\u0006\u0010/\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/obric/memorydata/database/entity/RawEntityIndexUtil;", "", "<init>", "()V", "TAG", "", "PHOTO_ALBUM_PACKAGE_NAME", "RANDOM_STRING_CHARSET", "lastGeneratorEntityIdTimeStamp", "", "generatorCounter", "", "generateRandomString", XSDatatype.FACET_LENGTH, "generateEntityId", "rawEntityEquals", "", "oldValue", "newValue", "semanticType", "Lcom/obric/memorydata/annotation/Type;", "jsonField", "isArray", "updateCommonPhotoEntities", "", "entity", "Lcom/obric/memorydata/database/entity/AbstractRawDbEntity;", "column", "fileEntityListJson", "deleteInvalidateCommonPhotoEntity", "entityId", "entityType", ObricMemoryConstants.KEY_PACKAGE_NAME, "validateEntityIds", "", "updateCommonPhotoEntity", "Lcom/obric/memorydata/database/entity/RawCommonPhotoEntity;", "fileEntity", "Lcom/obric/capabilitykit/entity/app/FileEntity;", "innerRawEntityEquals", "extractFieldEquals", "extractField", "checkStringJsonArrayEquals", "rawFileEntityArrayEquals", "rawFileEntityEquals", "getFieldValue", "json", "key", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class gd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final gd f9146a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static long f9147b;
    private static int c;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f9148a = null;

        static {
            int[] r0 = new int[Type.values().length];
            r0[Type.TEXT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L21:
            r0[Type.OCR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L31:
            r0[Type.CAPTION.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L23:
            r0[Type.FILE_CONTENT_TEXT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L25:
            r0[Type.EXTRACT.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L19:
            r0[Type.FILE_ENTITY.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L27:
            r0[Type.VIDEO_FRAME.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L10:
            f9148a = r0;
        }
    }

    static {
        f9146a = new gd();
    }

    private gd() {
    }

    private final ft a(d r27, String r28, FileEntity r29) {
        String r0 = r27.getType() + '_' + r27.getEntityId() + '_' + r28 + '_' + r29.getContentUrl();
        String r1 = com.obric.memorydata.database.index.t.f9438a.a(r29.getMimeType());
        if (Intrinsics.areEqual(r1, "image") == false) goto L7;
        String r2 = "PHOTO";
    L5:
        String r17 = r2;
    L11:
        if (r17 != null) goto L14;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityIndexHelper", "not support fileType: " + r1 + ", id: " + r0, null, 4, null);
        return null;
    L14:
        ft r3 = new ft(0, r0, r29.getCreateTime(), r29.getLastModifiedTime(), NetError.ERR_UNSAFE_REDIRECT, 0, r27.getPackageName(), 0, null, r29.toString(), r17, null, null, r27.getType(), r27.getEntityId(), r28, 289, null);
        if (com.obric.memorydata.database.a.C0451a.a((com.obric.memorydata.database.a) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.database.a.class, "com.obric.memorydata.plugin"), false, 1, null) == false) goto L17;
        return r3;
    L17:
        return null;
    L7:
        if (Intrinsics.areEqual(r1, "video") == false) goto L9;
        r2 = "VIDEO";
        goto L5
    L9:
        r17 = null;
        goto L11
    }

    private final String a(int r11) {
        Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast(new IntRange(1, r11), Iterable.class, "com.obric.memorydata.plugin");
        Collection r12 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r13 = r10.iterator();
    L4:
        if (r13.hasNext() == false) goto L7;
        ((IntIterator) ZeusTransformUtils.preCheckCast(r13, IntIterator.class, "com.obric.memorydata.plugin")).nextInt();
        r12.add(Character.valueOf(StringsKt.random((CharSequence) ZeusTransformUtils.preCheckCast("ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789", CharSequence.class, "com.obric.memorydata.plugin"), (Random) ZeusTransformUtils.preCheckCast(Random.Default, Random.class, "com.obric.memorydata.plugin"))));
        goto L4
    L7:
        return CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r12, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null);
    }

    private final String a(String r1, String r2) {
        if (r1 == null) goto L5;
        String r0 = new JSONObject(r1).optString(r2);
        if (r0 == null) goto L5;
        return r0;
    L5:
        return "";
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final Unit a(Ref.ObjectRef r1, String r2) {
        Intrinsics.checkNotNullParameter(r2, EventBody.KEY_VALUE);
        r1.element = r2;
        return Unit.INSTANCE;
    }

    private final boolean a(Object r7, Object r8) {
        if (r7 != null) goto L6;
        if (r8 != null) goto L6;
        return true;
    L6:
        String r3 = null;
        if (ZeusTransformUtils.instanceOf(r7, String.class) == false) goto L9;
        String r9 = (String) ZeusTransformUtils.preCheckCast(r7, String.class, "com.obric.memorydata.plugin");
    L11:
        if (ZeusTransformUtils.instanceOf(r8, String.class) == false) goto L14;
        r3 = (String) ZeusTransformUtils.preCheckCast(r8, String.class, "com.obric.memorydata.plugin");
    L14:
        if (r9 == null) goto L29;
        if (r3 == null) goto L29;
        JSONArray r1 = new JSONArray(r9);
        JSONArray r10 = new JSONArray(r3);
        if (r1.length() == r10.length()) goto L20;
        return false;
    L20:
        int r2 = r1.length();
        int r4 = 0;
        boolean r5 = true;
    L21:
        if (r4 >= r2) goto L28;
        if (r5 == true) goto L24;
    L26:
        r5 = false;
    L27:
        r4 = r4 + 1;
        goto L21
    L24:
        if (b(r1.get(r4).toString(), r10.get(r4).toString()) == false) goto L26;
        r5 = true;
        goto L27
    L28:
        return r5;
    L29:
        return false;
    L9:
        r9 = null;
        goto L11
    }

    private final boolean a(Object r5, Object r6, String r7) {
        boolean r4 = Intrinsics.areEqual(r5, r6);
        if (r7 != null) goto L5;
        return r4;
    L5:
        if (r4 == false) goto L8;
        return true;
    L8:
        String r1 = null;
        if (ZeusTransformUtils.instanceOf(r5, String.class) == false) goto L11;
        String r8 = (String) ZeusTransformUtils.preCheckCast(r5, String.class, "com.obric.memorydata.plugin");
    L13:
        if (ZeusTransformUtils.instanceOf(r6, String.class) == false) goto L16;
        r1 = (String) ZeusTransformUtils.preCheckCast(r6, String.class, "com.obric.memorydata.plugin");
    L16:
        if (r8 == null) goto L25;
        if (r1 == null) goto L25;
        final Ref.ObjectRef r9 = new Ref.ObjectRef();
        boolean r10 = com.obric.memorydata.database.index.t.f9438a.a(r8, r7, new $$Lambda$gd$XUBf_C0X6CzDDsCPEf0pyUt9U_w(r9));
        final Ref.ObjectRef r0 = new Ref.ObjectRef();
        boolean r11 = com.obric.memorydata.database.index.t.f9438a.a(r1, r7, new $$Lambda$gd$6cgyrJfJWDsLrtyw5Dc6KxvqLec(r0));
        if (r10 == false) goto L25;
        if (r11 == false) goto L25;
        return Intrinsics.areEqual(r9.element, r0.element);
    L25:
        return false;
    L11:
        r8 = null;
        goto L13
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final Unit b(Ref.ObjectRef r1, String r2) {
        Intrinsics.checkNotNullParameter(r2, EventBody.KEY_VALUE);
        r1.element = r2;
        return Unit.INSTANCE;
    }

    private final boolean b(Object r6, Object r7) {
        if (r6 != null) goto L6;
        if (r7 != null) goto L6;
        return true;
    L6:
        String r2 = null;
        if (ZeusTransformUtils.instanceOf(r6, String.class) == false) goto L9;
        String r8 = (String) ZeusTransformUtils.preCheckCast(r6, String.class, "com.obric.memorydata.plugin");
    L11:
        if (ZeusTransformUtils.instanceOf(r7, String.class) == false) goto L14;
        r2 = (String) ZeusTransformUtils.preCheckCast(r7, String.class, "com.obric.memorydata.plugin");
    L14:
        if (r8 == null) goto L35;
        if (r2 == null) goto L35;
        FileEntity r0 = com.obric.memorydata.personalcontext.util.f.c(r8);
        if (r0 == null) goto L34;
        FileEntity r9 = com.obric.memorydata.personalcontext.util.f.c(r2);
        if (r9 == null) goto L32;
        if (Intrinsics.areEqual(r0.getContentUrl(), r9.getContentUrl()) == true) goto L25;
        return false;
    L25:
        if (r0.getFileSize() == r9.getFileSize()) goto L28;
        return false;
    L28:
        if (r0.getLastModifiedTime() == r9.getLastModifiedTime()) goto L30;
        return false;
    L30:
        return true;
    L32:
        throw new JsonParseException("parse newFileEntity error: " + r2);
    L34:
        throw new JsonParseException("parse oldFileEntity error: " + r8);
    L35:
        return false;
    L9:
        r8 = null;
        goto L11
    }

    private final boolean b(Object r2, Object r3, Type r4, String r5, boolean r6) {
        if (r4 != null) goto L6;
        return Intrinsics.areEqual(r2, r3);
    L6:
        switch(a.f9148a[r4.ordinal()]) {
            case 1: goto L17;
            case 2: goto L17;
            case 3: goto L17;
            case 4: goto L17;
            case 5: goto L16;
            case 6: goto L11;
            case 7: goto L9;
            default: goto L7;
        };
    L7:
        return false;
    L9:
        return true;
    L11:
        if (r6 == false) goto L14;
        return a(r2, r3);
    L14:
        return b(r2, r3);
    L17:
        if (r6 == true) goto L19;
        String r7 = null;
        if (r5 == null) goto L30;
        gd r8 = f9146a;
        if (ZeusTransformUtils.instanceOf(r2, String.class) == false) goto L25;
        String r0 = (String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.memorydata.plugin");
    L26:
        String r9 = r8.a(r0, r5);
        if (r9 == null) goto L30;
        r2 = r9;
        goto L30
    L25:
        r0 = null;
    L30:
        if (r5 == null) goto L39;
        gd r10 = f9146a;
        if (ZeusTransformUtils.instanceOf(r3, String.class) == false) goto L34;
        r7 = (String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin");
    L34:
        String r1 = r10.a(r7, r5);
        if (r1 == null) goto L39;
        r3 = r1;
    L39:
        return Intrinsics.areEqual(r2, r3);
    L19:
        return b(r2, r3, r5);
    L16:
        return a(r2, r3, r5);
    }

    private final boolean b(Object r7, Object r8, String r9) {
        if (Intrinsics.areEqual(r7, r8) == false) goto L5;
        return true;
    L5:
        String r1 = null;
        if (ZeusTransformUtils.instanceOf(r7, String.class) == false) goto L8;
        String r6 = (String) ZeusTransformUtils.preCheckCast(r7, String.class, "com.obric.memorydata.plugin");
    L10:
        if (ZeusTransformUtils.instanceOf(r8, String.class) == false) goto L13;
        r1 = (String) ZeusTransformUtils.preCheckCast(r8, String.class, "com.obric.memorydata.plugin");
    L13:
        if (r6 == null) goto L40;
        if (r1 == null) goto L40;
        JSONArray r10 = new JSONArray(r6);
        JSONArray r11 = new JSONArray(r1);
        if (r10.length() == r11.length()) goto L19;
        return false;
    L19:
        int r2 = r10.length();
        int r3 = 0;
        boolean r4 = true;
    L20:
        if (r3 >= r2) goto L39;
        CharSequence r5 = (CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L24;
    L27:
        boolean r12 = true;
    L28:
        if (r12 == false) goto L34;
        if (r4 == true) goto L31;
    L33:
        r4 = false;
    L38:
        r3 = r3 + 1;
        goto L20
    L31:
        if (Intrinsics.areEqual(r10.optString(r3), r11.optString(r3)) == false) goto L33;
    L32:
        r4 = true;
        goto L38
    L34:
        if (r4 == false) goto L33;
        if (Intrinsics.areEqual(r10.optJSONObject(r3).optString(r9), r11.optJSONObject(r3).optString(r9)) == false) goto L33;
    L24:
        if (r5.length() == 0) goto L27;
        r12 = false;
        goto L28
    L39:
        return r4;
    L40:
        return false;
    L8:
        r6 = null;
        goto L10
    }

    public static /* synthetic */ Unit lambda$6cgyrJfJWDsLrtyw5Dc6KxvqLec(Ref.ObjectRef r0, String r1) {
        return b(r0, r1);
    }

    public static /* synthetic */ Unit lambda$XUBf_C0X6CzDDsCPEf0pyUt9U_w(Ref.ObjectRef r0, String r1) {
        return a(r0, r1);
    }

    public final synchronized String a() {
        monitor-enter(this);
        long r0 = System.currentTimeMillis();     // Catch: Throwable -> L10
        if (r0 != f9147b) goto L6;
        int r2 = c + 1;     // Catch: Throwable -> L10
        c = r2;     // Catch: Throwable -> L10
        c = r2 % 10;     // Catch: Throwable -> L10
    L7:
        f9147b = r0;     // Catch: Throwable -> L10
        String r1 = a(2) + c + '_' + r0;     // Catch: Throwable -> L10
        monitor-exit(this);
        return r1;
    L6:
        c = 0;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public final void a(d r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, "entity");
        Intrinsics.checkNotNullParameter(r11, "column");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityIndexHelper", "updateCommonPhotoEntityArray id: " + r10.getId() + " type: " + r10.getType() + " column: " + r11, false, 4, null);
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L26;
    L13:
        List<FileEntity> r13 = CollectionsKt.emptyList();
    L14:
        List<String> r8 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        if (r13 == null) goto L24;
        Iterator r14 = ((Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L18:
        if (r14.hasNext() == false) goto L24;
        ft r2 = f9146a.a(r10, r11, (FileEntity) ZeusTransformUtils.preCheckCast(r14.next(), FileEntity.class, "com.obric.memorydata.plugin"));
        if (r2 == null) goto L18;
        String r3 = r2.getEntityId();
        if (r3 == null) goto L18;
        r8.add(r3);
    L24:
        a(r10.getEntityId(), r10.getType(), r10.getPackageName(), r11, r8);
        return;
    L26:
        r13 = com.obric.memorydata.personalcontext.util.f.a(r12);     // Catch: JsonParseException -> L12
    L12:
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "RawEntityIndexUtil", "updateCommonPhotoEntities parse json error", null, 4, null);
        goto L13
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    public final void a(String r2, int r3, String r4, String r5, List<String> r6) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "entityId");
        Intrinsics.checkNotNullParameter(r4, ObricMemoryConstants.KEY_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(r1, "validateEntityIds");
        if (r5 == null) goto L5;
        List<ft> r7 = MemoryDbEngine.INSTANCE.getGlobalDbEngine().getCommonPhotoRawDbDao().queryEntitiesByOriginalEntityAndColumn(r3, r2, r5, r4);
    L6:
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin");
        Collection r9 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r10 = r8.iterator();
    L8:
        if (r10.hasNext() == false) goto L12;
        Object r11 = r10.next();
        if ((!r1.contains(((ft) ZeusTransformUtils.preCheckCast(r11, ft.class, "com.obric.memorydata.plugin")).getEntityId())) == false) goto L8;
        r9.add(r11);
        goto L8
    L12:
        Iterator r12 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r9, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L14:
        if (r12.hasNext() == false) goto L16;
        ((ft) ZeusTransformUtils.preCheckCast(r12.next(), ft.class, "com.obric.memorydata.plugin")).delete();
        goto L14
    L16:
        return;
    L5:
        r7 = MemoryDbEngine.INSTANCE.getGlobalDbEngine().getCommonPhotoRawDbDao().queryEntitiesByOriginalEntity(r3, r2, r4);
        goto L6
    }

    public final boolean a(Object r1, Object r2, Type r3, String r4, boolean r5) {
        return b(r1, r2, r3, r4, r5);
    L4:
        e = move-exception;
        RunLog.INSTANCE.error("RawEntityIndexUtil", "rawEntityEquals error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        return false;
    }
}
