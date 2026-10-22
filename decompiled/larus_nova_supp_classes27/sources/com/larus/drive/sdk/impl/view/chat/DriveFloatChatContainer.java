package com.larus.drive.sdk.impl.view.chat;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import va8.g0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class DriveFloatChatContainer {
    public final Fragment a;
    public final String b;
    public final int c;
    public final Function0<Bundle> d;
    public final a e;
    public Fragment f;
    public c g;
    public int h;
    public final boolean i;
    public final boolean j;
    public final n k;
    public final o l;

    public interface a {
        void a(boolean r1, g0 r2);

        boolean b(String r1, boolean r2);
    }

    public static final class b {
    }

    public interface c {
        va8.r a();

        g0 b();

        com.larus.bmhome.chat.component.bottom.core.speaker.l c();

        r79.a d();

        r79.b e();

        com.larus.bmhome.chat.component.cvs.y u0();

        ICoreInputAbility v0();
    }

    static {
    }

    public final void a() {
        if (this.f == null) goto L6;
        FLogger.a.i("DriveFloatChatContainer", "[attach] Already attached, fragmentTag=" + this.b + ", containerId=" + this.c);
        return;
    L6:
        int r0 = this.h + 1;
        this.h = r0;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.a.getViewLifecycleOwner()), null, null, new DriveFloatChatContainer$attach$1(this, r0, null), 3, null);
    }

    public final void b(String r7) {
        c r0 = this.g;
        FLogger r1 = FLogger.a;
        StringBuilder r2 = new StringBuilder();
        r2.append(r7);
        r2.append(", hasProvider=");
        boolean r8 = false;
        if (r0 == null) goto L5;
        boolean r4 = true;
    L6:
        r2.append(r4);
        r2.append(", hasFold=");
        r79.a r5 = null;
        if (r0 == null) goto L9;
        g0 r6 = r0.b();
    L10:
        if (r6 == null) goto L12;
        boolean r9 = true;
    L13:
        r2.append(r9);
        r2.append(", hasCoreInput=");
        if (r0 == null) goto L16;
        ICoreInputAbility r10 = r0.v0();
    L17:
        if (r10 == null) goto L19;
        boolean r11 = true;
    L20:
        r2.append(r11);
        r2.append(", hasSpeaker=");
        if (r0 == null) goto L23;
        com.larus.bmhome.chat.component.bottom.core.speaker.l r12 = r0.c();
    L24:
        if (r12 == null) goto L26;
        boolean r13 = true;
    L27:
        r2.append(r13);
        r2.append(", hasDriveFloat=");
        if (r0 == null) goto L30;
        r79.b r14 = r0.e();
    L31:
        if (r14 == null) goto L33;
        boolean r15 = true;
    L34:
        r2.append(r15);
        r2.append(", hasReceive=");
        if (r0 == null) goto L37;
        r5 = r0.d();
    L37:
        if (r5 == null) goto L39;
        r8 = true;
    L39:
        r2.append(r8);
        r1.i("DriveFloatChatContainer", r2.toString());
        return;
    L33:
        r15 = false;
        goto L34
    L30:
        r14 = null;
        goto L31
    L26:
        r13 = false;
        goto L27
    L23:
        r12 = null;
        goto L24
    L19:
        r11 = false;
        goto L20
    L16:
        r10 = null;
        goto L17
    L12:
        r9 = false;
        goto L13
    L9:
        r6 = null;
        goto L10
    L5:
        r4 = false;
        goto L6
    }

    public DriveFloatChatContainer(Fragment r3, Function0 r4, com.larus.drive.sdk.impl.view.preview.k r5) {
        Intrinsics.checkNotNullParameter(r3, "parentFragment");
        Intrinsics.checkNotNullParameter("drive_preview_float_chat_fragment", "fragmentTag");
        Intrinsics.checkNotNullParameter(r5, "callback");
        this.a = r3;
        this.b = "drive_preview_float_chat_fragment";
        this.c = 2131370307;
        this.d = r4;
        this.e = r5;
        this.i = true;
        this.j = true;
        this.k = new n(this);
        this.l = new o(this);
    }
}
