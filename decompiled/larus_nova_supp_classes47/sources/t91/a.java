package t91;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdkapi.depend.model.live.AnchorTabLabel;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a extends e {
    public final IRoom a;

    /* JADX INFO: renamed from: t91.a$a, reason: collision with other inner class name */
    public static final class C0317a {
    }

    static {
    }

    public a(IRoom r1) {
        this.a = r1;
    }

    @Override // s91.c
    public final u91.a a(Object r5) {
        ((Number) r5).intValue();
        IRoom r6 = this.a;
        Integer r0 = null;
        if (r6 == null) goto L7;
        AnchorTabLabel r7 = r6.getAnchorTabLabel();
        if (r7 == null) goto L7;
        Integer r8 = Integer.valueOf(r7.getStyle());
    L8:
        AnchorTabLabel.Companion r1 = AnchorTabLabel.Companion;
        int r2 = r1.getIMAGE_STYLE();
        if (r8 != null) goto L12;
    L14:
        int r3 = r1.getIMAGE_AND_TEXT_STYLE();
        if (r8 != null) goto L18;
    L20:
        int r4 = r1.getTEXT_STYLE();
        if (r8 != null) goto L24;
    L26:
        StringBuilder r9 = new StringBuilder("illegal label style: ");
        IRoom r10 = this.a;
        if (r10 == null) goto L31;
        AnchorTabLabel r12 = r10.getAnchorTabLabel();
        if (r12 == null) goto L31;
        r0 = Integer.valueOf(r12.getStyle());
    L31:
        r9.append(r0);
        ALogger.i("AudienceMultiFormatInitDataLoader", r9.toString());
        return new u91.a(new o91.b.C0286b());
    L24:
        if (r8.intValue() != r4) goto L26;
        return new u91.a(new o91.b.d());
    L18:
        if (r8.intValue() != r3) goto L20;
        return new u91.a(new o91.b.c());
    L12:
        if (r8.intValue() != r2) goto L14;
        return new u91.a(new o91.b.C0286b());
    L7:
        r8 = null;
        goto L8
    }

    @Override // s91.c
    public final boolean b(boolean r3, int r4, Integer r5) {
        int r6 = r5.intValue();
        if (r3 == false) goto L5;
    L7:
        boolean r7 = false;
    L8:
        if (r7 == false) goto L25;
        IRoom r8 = this.a;
        if (r8 != null) goto L12;
    L14:
        boolean r9 = false;
    L15:
        if (r9 == false) goto L25;
        if (r6 != 8) goto L19;
    L22:
        boolean r10 = true;
    L23:
        if (r10 == false) goto L25;
        return true;
    L19:
        if (r6 == 9) goto L22;
        r10 = false;
        goto L23
    L12:
        if (r8.getAnchorTabLabel() == null) goto L14;
        r9 = true;
    L25:
        return false;
    L5:
        if (r4 != 2) goto L7;
        r7 = true;
        goto L8
    }
}
