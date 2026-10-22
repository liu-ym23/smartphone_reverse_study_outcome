package com.larus.bmhome.chat.sendimage;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.ImageContent;
import com.larus.im.bean.message.ImageObj;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.NestedFileContent;
import com.larus.im.bean.message.NestedFileLocalPath;
import com.larus.im.bean.message.SendFileContent;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.utils.l0;
import com.larus.utils.logger.FLogger;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import yc9.l1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class e {
    public static final Lazy a = null;
    public static final Lazy b = null;

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"com/larus/bmhome/chat/sendimage/ChatMessageExtKt$convertToNestedFileLocalList$typeToken$1", "Lcom/google/gson/reflect/TypeToken;", "", "Lcom/larus/im/bean/message/NestedFileLocalPath;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    public static final class a extends TypeToken<List<? extends NestedFileLocalPath>> {
        public a() {
        }
    }

    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"com/larus/bmhome/chat/sendimage/ChatMessageExtKt$sendImageContentType$2$1", "Lcom/google/gson/reflect/TypeToken;", "Lcom/larus/im/bean/message/ImageContent;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    public static final class b extends TypeToken<ImageContent> {
        public b() {
        }
    }

    static {
        a = LazyKt.lazy(new c());
        b = LazyKt.lazy(new d());
    }

    public static final Gson i() {
        return (Gson) b.getValue();
    }

    public static final String a(NestedFileContent r1) {
        Intrinsics.checkNotNullParameter(r1, "content");
        return GsonProtectorUtils.toJson(i(), r1);
    }

    public static final String d(NestedFileContent r5) {
        Intrinsics.checkNotNullParameter(r5, "content");
        Gson r0 = i();
        List r6 = r5.getEntities();
        if (r6 == null) goto L8;
        List r7 = r6;
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));
        Iterator r8 = r7.iterator();
    L6:
        if (r8.hasNext() == false) goto L10;
        UplinkFileEntity r2 = (UplinkFileEntity) r8.next();
        r1.add(new NestedFileLocalPath(r2.getFileIdentifier(), l1.d(r2)));
    L10:
        return GsonProtectorUtils.toJson(r0, r1);
    L8:
        r1 = null;
        goto L10
    }

    @Deprecated(message = "replaced by Message.convertNestedFileContent")
    public static final NestedFileContent e(String r9) {
        if (r9 != null) goto L4;
    L7:
        boolean r0 = true;
    L8:
        if (r0 == true) goto L10;
        NestedFileContent r10 = (NestedFileContent) i().fromJson(r9, NestedFileContent.class);     // Catch: Throwable -> L15
        if (r10 != null) goto L20;
        return new NestedFileContent(new ArrayList(), null, false, null, 14, null);
    L20:
        return r10;
    L15:
        th = move-exception;
        FLogger.a.e("ChatMessageExt", "convertNestedFileContent error " + th.getMessage());
        return new NestedFileContent(new ArrayList(), null, false, null, 14, null);
    L10:
        return new NestedFileContent(new ArrayList(), null, false, null, 14, null);
    L4:
        if (r9.length() == 0) goto L7;
        r0 = false;
        goto L8
    }

    public static final SendFileContent f(String r2) {
        if (r2 != null) goto L4;
    L7:
        boolean r0 = true;
    L8:
        if (r0 == true) goto L10;
        SendFileContent r3 = (SendFileContent) i().fromJson(r2, SendFileContent.class);     // Catch: Throwable -> L15
        if (r3 != null) goto L19;
        return new SendFileContent(new ArrayList());
    L19:
        return r3;
    L16:
        return new SendFileContent(new ArrayList());
    L10:
        return new SendFileContent(new ArrayList());
    L4:
        if (r2.length() == 0) goto L7;
        r0 = false;
        goto L8
    }

    public static final List<NestedFileLocalPath> g(final String r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        final Type r0 = new a().getType();
        int r1 = l0.a;
        return (List) l0.a(CollectionsKt.emptyList(), new com.larus.bmhome.chat.sendimage.b(r3, r0));
    }

    public static String c(String r26, String r27) {
        Intrinsics.checkNotNullParameter(r26, "tosKey");
        Intrinsics.checkNotNullParameter(r27, "serverUrl");
        ImageContent r1 = new ImageContent(CollectionsKt.arrayListOf(new Image[]{new Image(r26, null, null, new ImageObj(r27, 0, 0, null, null, 24, null), null, null, null, null, null, null, null, null, null, null, 16374, null)}), null, 2, null);
        Intrinsics.checkNotNullParameter(r1, "content");
        return GsonProtectorUtils.toJson(i(), r1);
    }

    public static final String h(Message r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, "fileIdentifier");
        Map r5 = r3.getBusinessExt();
        if (r5 == null) goto L22;
        String r6 = (String) r5.get("nested_file_local_path_list");
        if (r6 == null) goto L23;
        List<NestedFileLocalPath> r7 = g(r6);
        if (r7 == null) goto L24;
        Iterator<T> r8 = r7.iterator();
    L10:
        if (r8.hasNext() == false) goto L14;
        Object r1 = r8.next();
        if (Intrinsics.areEqual(((NestedFileLocalPath) r1).getIdentifier(), r4) == false) goto L10;
    L15:
        NestedFileLocalPath r2 = (NestedFileLocalPath) r1;
        if (r2 != null) goto L18;
        return null;
    L18:
        return r2.getPath();
    L14:
        r1 = null;
        goto L15
    L24:
        return null;
    L23:
        return null;
    L22:
        return null;
    }

    public static final String b(String r27, int r28, int r29, Boolean r30, String r31) {
        Intrinsics.checkNotNullParameter(r27, "localPath");
        boolean r0 = true;
        Image[] r12 = new Image[1];
        ImageObj r5 = new ImageObj(null, r29, r28, null, null, 25, null);
        if (r31 != null) goto L5;
    L13:
        ImageObj r1 = null;
    L14:
        r12[0] = new Image(null, null, null, r5, null, r27, null, null, r1, null, r30, null, null, null, 15063, null);
        ImageContent r2 = new ImageContent(CollectionsKt.arrayListOf(r12), null, 2, null);
        Intrinsics.checkNotNullParameter(r2, "content");
        return GsonProtectorUtils.toJson(i(), r2);
    L5:
        if (r31.length() > 0) goto L8;
        r0 = false;
    L8:
        if (r0 == false) goto L10;
        String r20 = r31;
    L11:
        if (r20 == null) goto L13;
        r1 = new ImageObj(r20, r29, r28, null, null, 24, null);
        goto L14
    L10:
        r20 = null;
        goto L11
    }
}
