package gb8;

import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.ArtifactOPBlock;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.DisplayHeader;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class a extends jc8.a implements jc8.j {
    @Override // jc8.a
    public final String g() {
        return "ArtifactOpBlockBizModel";
    }

    @Override // jc8.j
    public final String c() {
        BlockContent r0 = this.a.getContent();
        if (r0 == null) goto L9;
        ArtifactOPBlock r1 = r0.getArtifactOpBlock();
        if (r1 == null) goto L9;
        DisplayHeader r2 = r1.getHeader();
        if (r2 == null) goto L9;
        String r3 = r2.getSummary();
    L10:
        if (r3 != null) goto L13;
        return "";
    L13:
        return r3;
    L9:
        r3 = null;
        goto L10
    }

    @Override // jc8.a
    public final int l() {
        int r0 = com.larus.bmhome.chat.deepresearch.view.j.a;
        return com.larus.bmhome.chat.deepresearch.view.j.V;
    }

    @Override // jc8.j
    public final String a(boolean r4) {
        BlockContent r0 = this.a.getContent();
        String r1 = null;
        if (r0 == null) goto L7;
        ArtifactOPBlock r2 = r0.getArtifactOpBlock();
        if (r2 == null) goto L7;
        DisplayHeader r3 = r2.getHeader();
    L9:
        if (r4 == false) goto L14;
        if (r3 == null) goto L12;
        r1 = r3.getIconUrlDark();
    L12:
        if (r1 != null) goto L19;
        return "";
    L19:
        return r1;
    L14:
        if (r3 == null) goto L16;
        r1 = r3.getIconUrl();
    L16:
        if (r1 != null) goto L19;
        return "";
    L7:
        r3 = null;
        goto L9
    }

    @Override // jc8.a
    public final boolean e(jc8.a r3) {
        if (r3 != null) goto L5;
        return false;
    L5:
        BlockContent r0 = this.a.getContent();
        Integer r1 = null;
        if (r0 == null) goto L10;
        ArtifactOPBlock r2 = r0.getArtifactOpBlock();
        if (r2 == null) goto L10;
        Integer r4 = Integer.valueOf(r2.hashCode());
    L11:
        BlockContent r5 = r3.a.getContent();
        if (r5 == null) goto L17;
        ArtifactOPBlock r6 = r5.getArtifactOpBlock();
        if (r6 == null) goto L17;
        r1 = Integer.valueOf(r6.hashCode());
    L17:
        return Intrinsics.areEqual(r4, r1);
    L10:
        r4 = null;
        goto L11
    }

    public a(Message r2, Block r3) {
        Intrinsics.checkNotNullParameter(r2, "message");
        Intrinsics.checkNotNullParameter(r3, "block");
        super(r2, r3);
    }
}
