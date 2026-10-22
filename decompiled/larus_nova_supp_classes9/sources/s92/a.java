package s92;

import aa2.w;
import com.bytedance.android.live.base.model.message.l4;
import com.bytedance.android.live.base.model.message.m0;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.api.m;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public class a {
    public long a;
    public int b;
    public final b c;
    public final IRoom d;
    public final m e;
    public final boolean f;
    public final int g;

    /* JADX INFO: renamed from: s92.a$a, reason: collision with other inner class name */
    public static final class C0277a {
    }

    static {
    }

    public final boolean a() {
        if (this.g != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean b(l4 r10, m r11, int r13) {
        boolean r1 = false;
        if (this.f == true) goto L5;
    L7:
        boolean r14 = false;
    L9:
        if (a() == false) goto L50;
        w r15 = (w) r11;
        if (r15.a() == false) goto L21;
        IRoomAuthStatus r0 = this.d.getRoomAuthStatus();
        if (r0 == null) goto L21;
        if (r0.isAnchorColdMessageTiled() != true) goto L21;
        m0 r2 = r10.getBaseMessage();
        if (r2 == null) goto L21;
        if (r2.getAnchorFoldTypeV2() != 3) goto L21;
    L23:
        if (r15.a() == true) goto L34;
        m0 r16 = r10.getBaseMessage();
        if (r16 != null) goto L27;
    L28:
        m0 r17 = r10.getBaseMessage();
        if (r17 == null) goto L34;
        if (r17.getAnchorFoldTypeV2() != 3) goto L34;
    L32:
        r1 = true;
        goto L34
    L27:
        if (r16.getAnchorFoldTypeV2() == 1) goto L32;
    L34:
        if (r15.b() == false) goto L53;
        m0 r18 = r10.getBaseMessage();
        if (r18 != null) goto L38;
    L39:
        m0 r19 = r10.getBaseMessage();
        if (r19 != null) goto L42;
    L43:
        m0 r110 = r10.getBaseMessage();
        if (r110 == null) goto L53;
        if (r110.getAnchorFoldTypeV2() != 3) goto L53;
        return true;
    L42:
        if (r19.getAnchorFoldTypeV2() != 2) goto L43;
        return true;
    L38:
        if (r18.getAnchorFoldTypeV2() != 1) goto L39;
        return true;
    L53:
        return r1;
    L21:
        r1 = r14;
        goto L23
    L50:
        return r14;
    L5:
        if (r13 != 2) goto L7;
        r14 = true;
        goto L9
    }

    public a(IRoom r2, w r3, boolean r4, int r5) {
        Intrinsics.checkNotNullParameter(r2, "room");
        Intrinsics.checkNotNullParameter(r3, "widget");
        this.d = r2;
        this.e = r3;
        this.f = r4;
        this.g = r5;
        this.c = new b(a());
    }
}
