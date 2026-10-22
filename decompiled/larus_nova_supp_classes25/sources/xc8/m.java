package xc8;

import com.larus.bmhome.chat.bean.d;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.TagEnum;
import com.larus.im.bean.message.TextTagInfo;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockMetaInfo;
import com.larus.im.bean.message.block.BlockType;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.r2;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class m {
    public static final String a(List<Message> r5) {
        List<Message> r0 = r5;
        boolean r1 = true;
        if (r0 != null) goto L5;
    L8:
        boolean r2 = true;
    L10:
        if (r2 == false) goto L12;
        return null;
    L12:
        IFlowSdkDepend r3 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r3 == null) goto L15;
        r2 r4 = r3.A0();
    L16:
        if (r4 == null) goto L18;
        int r6 = r4.q();
    L19:
        if (r6 > 0) goto L29;
        Message r7 = (Message) CollectionsKt.firstOrNull(r5);
        if (r7 != null) goto L23;
    L25:
        r1 = false;
    L26:
        if (r1 == true) goto L28;
        return null;
    L28:
        return r7.getMessageId();
    L23:
        if (c(r7) != true) goto L25;
    L29:
        Iterator r8 = CollectionsKt.take(r5, r6).iterator();
    L31:
        if (r8.hasNext() == false) goto L35;
        Object r9 = r8.next();
        if (c((Message) r9) == false) goto L31;
    L36:
        Message r10 = (Message) r9;
        if (r10 != null) goto L39;
        return null;
    L39:
        return r10.getMessageId();
    L35:
        r9 = null;
        goto L36
    L18:
        r6 = 0;
        goto L19
    L15:
        r4 = null;
        goto L16
    L5:
        if (r0.isEmpty() == true) goto L8;
        r2 = false;
        goto L10
    }

    public static final boolean c(Message r12) {
        Intrinsics.checkNotNullParameter(r12, "<this>");
        if (r12.getContentType() != 8) goto L6;
        return true;
    L6:
        if (r12.getContentType() == 1) goto L12;
        if (r12.getContentType() == 9999) goto L12;
        return false;
    L12:
        if (com.larus.im.bean.message.a.b0(r12) == false) goto L68;
        List r1 = com.larus.im.bean.message.a.d(r12);
        if ((r1 instanceof Collection) == true) goto L16;
    L18:
        Iterator r2 = r1.iterator();
    L20:
        if (r2.hasNext() == false) goto L17;
        if (((Block) r2.next()).getBlockType() != BlockType.BLOCK_TYPE_SEARCH_RICH_MEDIA.getValue()) goto L24;
        boolean r9 = true;
    L25:
        if (r9 == false) goto L20;
        boolean r3 = true;
    L27:
        if (r3 == false) goto L29;
        return true;
    L29:
        List r13 = com.larus.im.bean.message.a.J(r12, BlockType.BLOCK_TYPE_TEXT);
        if (r13.isEmpty() == true) goto L67;
        Iterator r14 = r13.iterator();
        if (r14.hasNext() == false) goto L67;
        List r15 = ((Block) r14.next()).getMetaInfo();
        if (r15 == null) goto L65;
        List r16 = r15;
        if ((r16 instanceof Collection) == true) goto L39;
    L41:
        Iterator r17 = r16.iterator();
    L43:
        if (r17.hasNext() == false) goto L40;
        BlockMetaInfo r4 = (BlockMetaInfo) r17.next();
        Set r10 = SetsKt.setOf(new Integer[]{Integer.valueOf(TagEnum.TagEnum_InsertText_BLOCK.value), Integer.valueOf(TagEnum.TagEnum_InsertText.value), Integer.valueOf(TagEnum.TagEnum_InsertText_V2.value)});
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r10, "set");
        if (r10.contains(Integer.valueOf(r4.type)) == false) goto L60;
        List r11 = CollectionsKt.listOf(new String[]{"video-group", "video-group-v2", "\"scene_type\":2"});
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r11, "set");
        String r5 = r4.getRealInfo();
        Iterator r18 = r11.iterator();
    L48:
        if (r18.hasNext() == false) goto L57;
        String r19 = (String) r18.next();
        if (r5 != null) goto L52;
    L54:
        boolean r110 = false;
    L55:
        if (r110 == false) goto L48;
        boolean r6 = true;
    L58:
        if (r6 == false) goto L60;
        boolean r7 = true;
    L61:
        if (r7 == false) goto L43;
        boolean r111 = true;
    L63:
        if (r111 != true) goto L65;
        return true;
    L52:
        if (StringsKt.contains$default(r5, r19, false, 2, null) != true) goto L54;
        r110 = true;
        goto L55
    L57:
        r6 = false;
    L60:
        r7 = false;
    L40:
        r111 = false;
        goto L63
    L39:
        if (r16.isEmpty() == false) goto L41;
    L65:
        return false;
    L67:
        return false;
    L24:
        r9 = false;
    L17:
        r3 = false;
        goto L27
    L16:
        if (r1.isEmpty() == false) goto L18;
    L68:
        List<TextTagInfo> r112 = d.C(r12);
        if (r112 == null) goto L99;
        List<TextTagInfo> r113 = r112;
        if ((r113 instanceof Collection) == true) goto L73;
    L75:
        Iterator<T> r114 = r113.iterator();
    L77:
        if (r114.hasNext() == false) goto L74;
        TextTagInfo r8 = (TextTagInfo) r114.next();
        Set r20 = SetsKt.setOf(Integer.valueOf(TagEnum.TagEnum_InsertText_APPLET.value));
        Intrinsics.checkNotNullParameter(r8, "<this>");
        Intrinsics.checkNotNullParameter(r20, "set");
        if (r20.contains(Integer.valueOf(r8.type)) == false) goto L94;
        List r21 = CollectionsKt.listOf(new String[]{"video-group", "video-group-v2"});
        Intrinsics.checkNotNullParameter(r8, "<this>");
        Intrinsics.checkNotNullParameter(r21, "set");
        Iterator r22 = r21.iterator();
    L82:
        if (r22.hasNext() == false) goto L91;
        String r115 = (String) r22.next();
        String r116 = r8.tagInfo;
        if (r116 != null) goto L86;
    L88:
        boolean r117 = false;
    L89:
        if (r117 == false) goto L82;
        boolean r23 = true;
    L92:
        if (r23 == false) goto L94;
        boolean r24 = true;
    L95:
        if (r24 == false) goto L77;
        boolean r118 = true;
    L97:
        if (r118 != true) goto L99;
        return true;
    L86:
        if (StringsKt.contains$default(r116, r115, false, 2, null) != true) goto L88;
        r117 = true;
        goto L89
    L91:
        r23 = false;
    L94:
        r24 = false;
    L74:
        r118 = false;
        goto L97
    L73:
        if (r113.isEmpty() == false) goto L75;
    L99:
        return false;
    }

    public static final boolean b(Message r8, List<Message> r9) {
        Intrinsics.checkNotNullParameter(r8, "<this>");
        IFlowSdkDepend r1 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r1 == null) goto L7;
        r2 r2 = r1.A0();
        if (r2 == null) goto L7;
        int r3 = r2.q();
    L8:
        String r4 = "";
        if (r3 > 0) goto L31;
        Intrinsics.checkNotNullParameter(r8, "<this>");
        if (r9 == null) goto L67;
        Iterator<T> r10 = r9.iterator();
    L14:
        if (r10.hasNext() == false) goto L18;
        Object r0 = r10.next();
        if ((!d.O0((Message) r0)) == false) goto L14;
    L19:
        Message r5 = (Message) r0;
        if (r5 == null) goto L68;
        String r11 = r5.getMessageId();
        if (r11 == null) goto L69;
        String r12 = r8.getMessageId();
        if (r12 == null) goto L28;
        r4 = r12;
    L28:
        if (StringsKt.contains$default(r11, r4, false, 2, null) != true) goto L70;
        return true;
    L70:
        return false;
    L69:
        return false;
    L68:
        return false;
    L18:
        r0 = null;
        goto L19
    L67:
        return false;
    L31:
        if (r9 != null) goto L33;
        return false;
    L33:
        Intrinsics.checkNotNullParameter(r9, "<this>");
        int r6 = RangesKt.coerceAtLeast(0, 0);     // Catch: Exception -> L57
        int r7 = RangesKt.coerceAtMost(r3, r9.size());     // Catch: Exception -> L57
        if (r6 < r7) goto L37;
        r9 = CollectionsKt.emptyList();     // Catch: Exception -> L57
    L58:
        goto L38
    L37:
        r9 = r9.subList(r6, r7);     // Catch: Exception -> L57
    L38:
        Iterator<T> r13 = r9.iterator();
    L40:
        if (r13.hasNext() == false) goto L44;
        Object r14 = r13.next();
        if (c((Message) r14) == false) goto L40;
    L45:
        Message r15 = (Message) r14;
        if (r15 == null) goto L71;
        String r16 = r15.getMessageId();
        if (r16 == null) goto L72;
        String r17 = r8.getMessageId();
        if (r17 == null) goto L54;
        r4 = r17;
    L54:
        if (StringsKt.contains$default(r16, r4, false, 2, null) != true) goto L73;
        return true;
    L73:
        return false;
    L72:
        return false;
    L71:
        return false;
    L44:
        r14 = null;
    L7:
        r3 = 0;
        goto L8
    }
}
