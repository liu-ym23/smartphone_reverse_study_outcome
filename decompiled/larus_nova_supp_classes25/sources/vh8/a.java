package vh8;

import com.larus.im.bean.IMMetaInfo;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import wf9.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static boolean b(String r4) {
        Intrinsics.checkNotNullParameter(r4, "insertText");
        if (StringsKt.startsWith$default(r4, "<data-block", false, 2, null) == true) goto L5;
        return false;
    L5:
        if (StringsKt.startsWith$default(r4, "<data-block-full", false, 2, null) == true) goto L9;
        return true;
    L9:
        return false;
    }

    public static List c(List r7) {
        Intrinsics.checkNotNullParameter(r7, "originList");
        ArrayList r1 = new ArrayList();
        Iterator r0 = r7.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Object r2 = r0.next();
        if ((r2 instanceof IMMetaInfo.InsertTextReference) == false) goto L4;
        r1.add(r2);
        goto L4
    L8:
        LinkedHashMap r3 = new LinkedHashMap();
        Iterator r4 = r1.iterator();
    L10:
        if (r4.hasNext() == false) goto L15;
        Object r5 = r4.next();
        Integer r6 = ((IMMetaInfo.InsertTextReference) r5).getPos();
        Object r8 = r3.get(r6);
        if (r8 != null) goto L14;
        r8 = new ArrayList();
        r3.put(r6, r8);
    L14:
        ((List) r8).add(r5);
        goto L10
    L15:
        Collection r9 = r3.values();
        ArrayList r10 = new ArrayList();
        Iterator r11 = r9.iterator();
    L17:
        if (r11.hasNext() == false) goto L24;
        Object r12 = r11.next();
        boolean r13 = true;
        if (((List) r12).size() > 1) goto L22;
        r13 = false;
    L22:
        if (r13 == false) goto L17;
        r10.add(r12);
        goto L17
    L24:
        ArrayList r14 = new ArrayList();
        Iterator r15 = r10.iterator();
    L26:
        if (r15.hasNext() == false) goto L34;
        List r16 = (List) r15.next();
        ArrayList r17 = new ArrayList();
        Iterator r18 = r16.iterator();
    L29:
        if (r18.hasNext() == false) goto L33;
        Object r19 = r18.next();
        if (Intrinsics.areEqual(((IMMetaInfo.InsertTextReference) r19).getCanReplace(), Boolean.TRUE) == false) goto L29;
        r17.add(r19);
        goto L29
    L33:
        CollectionsKt.addAll(r14, r17);
        goto L26
    L34:
        List r20 = CollectionsKt.toMutableList(r7);
        Iterator r21 = r14.iterator();
    L36:
        if (r21.hasNext() == false) goto L38;
        r20.remove((IMMetaInfo.InsertTextReference) r21.next());
        goto L36
    L38:
        return r20;
    }

    public static byte[] a(byte[] r19, byte[] r20, IMMetaInfo.InsertTextReference r21, Message r22) {
        Intrinsics.checkNotNullParameter(r19, "source");
        Intrinsics.checkNotNullParameter(r20, "content");
        Intrinsics.checkNotNullParameter(r21, "insertMeta");
        String r5 = r21.getInsertText();
        if (r5 != null) goto L5;
    L8:
        boolean r6 = true;
    L9:
        if (r6 == false) goto L11;
        return r20;
    L11:
        Integer r12 = r21.getPos();
        if (r12 != null) goto L14;
    L83:
        return r20;
    L14:
        if (r12.intValue() < 0) goto L83;
        if (r12.intValue() > r20.length) goto L83;
        int r13 = r20.length;
        int r14 = r19.length;
        if (b(r5) == false) goto L74;
        Regex r7 = new Regex("type\\s*=\\s*\"(image-group|simple-image-group|video-group|video-group-v2|lynx_ruyi|mixed_media_card|applet|search_reference|creation|vlm_mixed_media_card|memory|block-container)\"");
        if (r14 != 0) goto L28;
        if (Intrinsics.areEqual(r21.getForceSeparate(), Boolean.TRUE) == true) goto L28;
        if (Intrinsics.areEqual(r21.getCardType(), "vlm_mixed_media_card") == true) goto L28;
        r5 = StringsKt.replace$default(r5, "data-block", "data-block-full", false, 4, null);
    L28:
        if (r7.containsMatchIn(r5) == false) goto L69;
        r5 = StringsKt.replace$default(r5, "data-block", "data-inline-no-margin", false, 4, null);
        if (r22 != null) goto L32;
    L34:
        boolean r8 = false;
    L35:
        if (r8 == false) goto L74;
        int r9 = b.a;
        Intrinsics.checkNotNullParameter(r22, "message");
        if (com.larus.im.bean.message.a.w0(r22) == true) goto L74;
        if (r12.intValue() != r14) goto L74;
        if (r5 != null) goto L42;
    L45:
        boolean r18 = true;
    L46:
        if (r18 == false) goto L48;
        r5 = "";
        goto L74
    L48:
        int r2 = r19.length;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L65
        byte r11 = r19[r2 - 1];     // Catch: Throwable -> L65
        if (r11 != 124) goto L53;
        String r0 = "\n\n" + r5;     // Catch: Throwable -> L65
    L64:
        r5 = r0;
        goto L74
    L53:
        if (r11 == 10) goto L55;
    L57:
        if (r11 == 10) goto L59;
    L61:
        if (r11 != 10) goto L63;
        r0 = "\n" + r5;     // Catch: Throwable -> L65
        goto L64
    L63:
        r0 = "\n\n" + r5;     // Catch: Throwable -> L65
        goto L64
    L59:
        if (r19[r2 - 2] != 10) goto L61;
    L55:
        if (r19[r2 - 2] != 124) goto L57;
        r0 = "\n" + r5;     // Catch: Throwable -> L65
    L65:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        Throwable r1 = Result.exceptionOrNull-impl(Result.constructor-impl(ResultKt.createFailure(th)));
        if (r1 == null) goto L74;
        FLogger.a.i("IM/MetaConcatenation", r1.toString());
        goto L74
    L42:
        if (r5.length() == 0) goto L45;
        r18 = false;
        goto L46
    L32:
        if (r22.getMessageStatusLocal() != 21) goto L34;
        r8 = true;
        goto L35
    L69:
        String r4 = "\n";
        StringBuilder r15 = new StringBuilder(r4);
        r15.append(r5);
        if (StringsKt.endsWith$default(r5, r4, false, 2, null) == false) goto L72;
        r4 = "";
    L72:
        r15.append(r4);
        r15.append(' ');
        r5 = r15.toString();
    L74:
        if (Intrinsics.areEqual(r21.getForceSeparate(), Boolean.TRUE) == false) goto L76;
        byte[] r16 = StringsKt.encodeToByteArray("\n\n" + r5 + "\n\n");
    L77:
        int r17 = r13 - (r14 - r12.intValue());
        if (r17 < 0) goto L83;
        if (r17 > r20.length) goto L83;
        return ArraysKt.plus(ArraysKt.plus(ArraysKt.copyOfRange(r20, 0, r17), r16), ArraysKt.copyOfRange(r20, r17, r13));
    L76:
        r16 = StringsKt.encodeToByteArray(r5);
        goto L77
    L5:
        if (r5.length() == 0) goto L8;
        r6 = false;
        goto L9
    }
}
