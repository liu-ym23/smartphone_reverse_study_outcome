package gf0;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.hamlet.HamletAvatarContext;
import com.bytedance.android.live.liveinteract.hamlet.model.k;
import com.bytedance.android.live.liveinteract.hamlet.model.p;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.n;
import gd0.g;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c implements d {
    public boolean a;
    public final HamletAvatarContext b;

    public static final class a {
    }

    static {
    }

    @Override // gf0.d
    public final void release() {
        this.a = false;
    }

    public c(HamletAvatarContext r1) {
        this.b = r1;
    }

    @Override // gf0.d
    public final void a(String r9) {
        Intrinsics.checkNotNullParameter(r9, "sei");
        int r3 = 0;
        if (r9.length() != 0) goto L6;
        boolean r1 = true;
    L7:
        if (r1 == false) goto L9;
        return;
    L9:
        p r10 = (p) GsonHelper.get().fromJson(r9, p.class);     // Catch: Exception -> L91
        Boolean r2 = null;
        if (r10 == null) goto L12;
        List<k> r4 = r10.a();     // Catch: Exception -> L91
    L13:
        if (r4 == null) goto L22;
        HamletAvatarContext r5 = this.b;     // Catch: Exception -> L91
        if (r5 == null) goto L17;
        r5.setHamletSeiAvatarList(GsonHelper.get().toJson(r10.a()));     // Catch: Exception -> L91
    L17:
        HamletAvatarContext r6 = this.b;     // Catch: Exception -> L91
        if (r6 == null) goto L22;
        n<List<k>> r7 = r6.getHamletAvatarUserInfos();     // Catch: Exception -> L91
        if (r7 == null) goto L22;
        r7.setValue(r10.a());     // Catch: Exception -> L91
    L22:
        if (r10 == null) goto L94;
        Integer r8 = r10.c();     // Catch: Exception -> L91
        if (r8 != null) goto L26;
    L28:
        boolean r11 = false;
    L29:
        Integer r12 = r10.b();     // Catch: Exception -> L91
        if (r12 == null) goto L32;
        int r13 = r12.intValue();     // Catch: Exception -> L91
    L33:
        HamletAvatarContext r14 = this.b;     // Catch: Exception -> L91
        if (r14 == null) goto L40;
        m<Integer> r15 = r14.getDirecting();     // Catch: Exception -> L91
        if (r15 == null) goto L40;
        Integer r16 = (Integer) r15.getValue();     // Catch: Exception -> L91
        if (r16 == null) goto L40;
        int r17 = r16.intValue();     // Catch: Exception -> L91
    L41:
        HamletAvatarContext r18 = this.b;     // Catch: Exception -> L91
        if (r18 == null) goto L48;
        m<Boolean> r19 = r18.isAvatarRending();     // Catch: Exception -> L91
        if (r19 == null) goto L48;
        Boolean r20 = (Boolean) r19.getValue();     // Catch: Exception -> L91
        if (r20 == null) goto L48;
        boolean r21 = r20.booleanValue();     // Catch: Exception -> L91
    L49:
        if (r21 != r11) goto L53;
        if (r17 != r13) goto L53;
        if (this.a == false) goto L53;
    L78:
        if (this.a == true) goto L95;
        HamletAvatarContext r0 = HamletAvatarContext.Companion.getContext();     // Catch: Exception -> L91
        if (r0 == null) goto L89;
        j<g> r22 = r0.getHamletAvatarService();     // Catch: Exception -> L91
        if (r22 == null) goto L89;
        g r23 = (g) r22.getValue();     // Catch: Exception -> L91
        if (r23 == null) goto L89;
        Integer r24 = r10.b();     // Catch: Exception -> L91
        if (r24 == null) goto L88;
        r3 = r24.intValue();     // Catch: Exception -> L91
    L88:
        r23.Zf(r11, r3);     // Catch: Exception -> L91
    L89:
        this.a = true;     // Catch: Exception -> L91
        return;
    L95:
        return;
    L53:
        HamletAvatarContext r25 = this.b;     // Catch: Exception -> L91
        if (r25 == null) goto L58;
        m<Boolean> r26 = r25.isAvatarRending();     // Catch: Exception -> L91
        if (r26 == null) goto L58;
        r26.setValue(Boolean.valueOf(r11));     // Catch: Exception -> L91
    L58:
        HamletAvatarContext r27 = this.b;     // Catch: Exception -> L91
        if (r27 == null) goto L63;
        m<Integer> r28 = r27.getDirecting();     // Catch: Exception -> L91
        if (r28 == null) goto L63;
        r28.setValue(Integer.valueOf(r13));     // Catch: Exception -> L91
    L63:
        if (r11 == true) goto L67;
        if (r13 > 0) goto L67;
        int r29 = 0;
    L68:
        com.bytedance.android.live.liveinteract.voicechat.d.s0.getClass();     // Catch: Exception -> L91
        com.bytedance.android.live.liveinteract.voicechat.d r30 = com.bytedance.android.live.liveinteract.voicechat.d.a.a();     // Catch: Exception -> L91
        if (r30 == null) goto L71;
        r30.Mi(r29);     // Catch: Exception -> L91
    L71:
        StringBuilder r31 = new StringBuilder("onXplaySeiProcess: sei rending value: ");     // Catch: Exception -> L91
        HamletAvatarContext r32 = this.b;     // Catch: Exception -> L91
        if (r32 == null) goto L76;
        m<Boolean> r33 = r32.isAvatarRending();     // Catch: Exception -> L91
        if (r33 == null) goto L76;
        r2 = (Boolean) r33.getValue();     // Catch: Exception -> L91
    L76:
        r31.append(r2);     // Catch: Exception -> L91
        ALogger.d("HamletAvatar", r31.toString());     // Catch: Exception -> L91
    L67:
        r29 = 1;
    L48:
        r21 = false;
    L40:
        r17 = 0;
        goto L41
    L32:
        r13 = 0;
        goto L33
    L26:
        if (r8.intValue() != 1) goto L28;
        r11 = true;
        goto L29
    L94:
        return;
    L12:
        r4 = null;
        goto L13
    L6:
        r1 = false;
    }
}
