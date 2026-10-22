package ro8;

import com.larus.bmhome.chat.deepresearch.view.j;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.AppletBlock;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a extends jc8.a {

    /* JADX INFO: renamed from: ro8.a$a, reason: collision with other inner class name */
    public static final class C0131a {
    }

    static {
    }

    public final String g() {
        return "WidgetBlockBizModel";
    }

    public final int l() {
        int r0 = j.a;
        return j.H;
    }

    public final AppletBlock o() {
        BlockContent r0 = ((jc8.a) this).a.getContent();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getAppletBlock();
    }

    public final boolean e(jc8.a r11) {
        boolean r1 = false;
        if ((r11 instanceof a) == true) goto L5;
        return false;
    L5:
        AppletBlock r0 = o();
        a r12 = (a) r11;
        AppletBlock r2 = r12.o();
        Boolean r3 = null;
        if (r0 == null) goto L8;
        String r4 = r0.renderData;
    L9:
        if (r2 == null) goto L11;
        String r5 = r2.renderData;
    L12:
        boolean r6 = Intrinsics.areEqual(r4, r5);
        if (r0 == null) goto L15;
        Boolean r7 = r0.mixedBlock;
    L16:
        if (r2 == null) goto L18;
        Boolean r8 = r2.mixedBlock;
    L19:
        boolean r9 = Intrinsics.areEqual(r7, r8);
        if (n() != r12.n()) goto L22;
        boolean r10 = true;
    L23:
        if (r6 == false) goto L27;
        if (r9 == false) goto L27;
        if (r10 == false) goto L27;
        r1 = true;
    L27:
        FLogger r13 = FLogger.a;
        StringBuilder r14 = new StringBuilder("areContentsTheSame, messageId=");
        r14.append(j().getMessageId());
        r14.append(", oldBlockId=");
        r14.append(((jc8.a) this).a.getBlockId());
        r14.append(", newBlockId=");
        r14.append(((jc8.a) r12).a.getBlockId());
        r14.append(", oldStrategy=");
        BlockContent r15 = ((jc8.a) this).a.getContent();
        if (r15 == null) goto L32;
        AppletBlock r16 = r15.getAppletBlock();
        if (r16 == null) goto L32;
        Integer r17 = r16.renderDataUpdateStrategy;
    L33:
        r14.append(r17);
        r14.append(", newStrategy=");
        BlockContent r18 = ((jc8.a) r12).a.getContent();
        if (r18 == null) goto L38;
        AppletBlock r19 = r18.getAppletBlock();
        if (r19 == null) goto L38;
        Integer r110 = r19.renderDataUpdateStrategy;
    L39:
        r14.append(r110);
        r14.append(", oldMixedBlock=");
        if (r0 == null) goto L42;
        Boolean r111 = r0.mixedBlock;
    L43:
        r14.append(r111);
        r14.append(", newMixedBlock=");
        if (r2 == null) goto L46;
        r3 = r2.mixedBlock;
    L46:
        r14.append(r3);
        r14.append(", renderDataSame=");
        r14.append(r6);
        r14.append(", mixedBlockSame=");
        r14.append(r9);
        r14.append(", isLastBlockSame=");
        r14.append(r10);
        r14.append(", result=");
        r14.append(r1);
        r13.i("AppletRenderUpdate", r14.toString());
        return r1;
    L42:
        r111 = null;
    L38:
        r110 = null;
    L32:
        r17 = null;
        goto L33
    L22:
        r10 = false;
        goto L23
    L18:
        r8 = null;
        goto L19
    L15:
        r7 = null;
        goto L16
    L11:
        r5 = null;
        goto L12
    L8:
        r4 = null;
        goto L9
    }

    public final boolean f(jc8.a r12) {
        boolean r0 = false;
        if (r12 != null) goto L6;
        return false;
    L6:
        if ((r12 instanceof a) == true) goto L8;
        return false;
    L8:
        AppletBlock r1 = o();
        a r13 = (a) r12;
        AppletBlock r2 = r13.o();
        if (r2 == null) goto L16;
        Integer r4 = r2.renderDataUpdateStrategy;
        if (r4 == null) goto L16;
        if (r4.intValue() != 1) goto L16;
        boolean r5 = true;
    L17:
        int r6 = j.a;
        boolean r7 = Intrinsics.areEqual(((jc8.a) this).a.getBlockId(), ((jc8.a) r13).a.getBlockId());
        Integer r8 = null;
        if (r1 == null) goto L20;
        String r9 = r1.renderData;
    L21:
        if (r2 == null) goto L23;
        String r10 = r2.renderData;
    L24:
        boolean r11 = Intrinsics.areEqual(r9, r10);
        if (r7 == false) goto L29;
        if (r5 == true) goto L28;
        if (r11 == false) goto L29;
    L28:
        r0 = true;
    L29:
        FLogger r14 = FLogger.a;
        StringBuilder r15 = new StringBuilder("areItemsTheSame, messageId=");
        r15.append(r13.j().getMessageId());
        r15.append(", oldBlockId=");
        r15.append(((jc8.a) this).a.getBlockId());
        r15.append(", newBlockId=");
        r15.append(((jc8.a) r13).a.getBlockId());
        r15.append(", oldStrategy=");
        if (r1 == null) goto L32;
        Integer r16 = r1.renderDataUpdateStrategy;
    L33:
        r15.append(r16);
        r15.append(", newStrategy=");
        if (r2 == null) goto L36;
        r8 = r2.renderDataUpdateStrategy;
    L36:
        r15.append(r8);
        r15.append(", blockTypeSame=");
        r15.append(true);
        r15.append(", blockIdSame=");
        r15.append(r7);
        r15.append(", renderDataSame=");
        r15.append(r11);
        r15.append(", supportsRenderDataUpdate=");
        r15.append(r5);
        r15.append(", result=");
        r15.append(r0);
        r14.i("AppletRenderUpdate", r15.toString());
        return r0;
    L32:
        r16 = null;
        goto L33
    L23:
        r10 = null;
        goto L24
    L20:
        r9 = null;
    L16:
        r5 = false;
        goto L17
    }

    public a(Message r2, Block r3) {
        Intrinsics.checkNotNullParameter(r2, "message");
        Intrinsics.checkNotNullParameter(r3, "block");
        super(r2, r3);
    }
}
