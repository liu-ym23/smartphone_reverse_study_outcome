package com.larus.voice_setting.voice.base;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.larus.bmhome.view.menu.CreateMenu;
import com.larus.im.bean.bot.AudioPreview;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.platform.model.SearchMobParam;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.larus.voice_setting.voice.VoiceItemAdapter;
import com.larus.voice_setting.voice.l2;
import com.larus.voice_setting.voice.o2;
import com.larus.voice_setting.voice.u2;
import com.lynx.tasm.event.LynxTouchEvent;
import com.skydoves.balloon.Balloon;
import com.skydoves.balloon.radius.RadiusLayout;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class i0 implements u2 {
    public final /* synthetic */ MyVoiceListFragment a;

    public i0(MyVoiceListFragment r1) {
        this.a = r1;
    }

    @Override // com.larus.voice_setting.voice.u2
    public final boolean a(o2 r2) {
        if (r2 != null) goto L6;
        return false;
    L6:
        return this.a.ma0(r2.a);
    }

    @Override // com.larus.voice_setting.voice.u2
    public final boolean d(o2 r3) {
        return VoiceListFragment.aa0(this.a, r3.a, 6);
    }

    @Override // com.larus.voice_setting.voice.u2
    public final void b(o2 r28, View r29) {
        Intrinsics.checkNotNullParameter(r29, "itemView");
        if (r28 != null) goto L5;
        return;
    L5:
        final MyVoiceListFragment r2 = this.a;
        int r3 = MyVoiceListFragment.K;
        r2.getClass();
        final SpeakerVoice r4 = r28.a;
        if (r4 == null) goto L93;
        boolean r5 = true;
        if (r4.getStatus() != 3) goto L11;
        boolean r6 = true;
    L12:
        String r8 = null;
        if (r6 == false) goto L23;
        int r7 = y2a.a.a;
        JSONObject r9 = new JSONObject();
        r9.put("is_scheme", y2a.b.b(r2.w));
        r9.put("enter_method", y2a.b.a(r2.s));
        r9.put("click_from", "ClickCreateFailVoice");
        y2a.a.c(r9);
        FLogger.a.i(r2.A, "[clickItem] recall, voice: " + r4);
        String r10 = l2.a;
        FragmentManager r14 = r2.getParentFragmentManager();
        Context r11 = r2.getContext();
        if (r11 == null) goto L17;
        r8 = r11.getString(2131911118);
    L17:
        String r15 = r8;
        String r12 = r2.z;
        SearchMobParam r13 = r2.F;
        String r16 = r2.G;
        String r19 = r2.ua0();
        String r17 = r2.s;
        if (r17 != null) goto L20;
        String r22 = "unknown";
    L21:
        l2.f(r14, r15, r12, r13, r16, r19, new u(r2, r4), false, r22, r2.w, "ClickCreateFailVoice", r2.u, LynxTouchEvent.kPseudoStateFocusTransition);
        return;
    L20:
        r22 = r17;
        goto L21
    L23:
        if (r28.a.getStatus() != 4) goto L25;
        FLogger.a.i(r2.A, "[clickItem] reviewing, voice: " + r4);
        t19.s r0 = t19.s.a;
        Context r18 = r2.getContext();
        r0.getClass();
        t19.s.b(r18, 2131911107, false);
        return;
    L25:
        int r20 = r28.c;
        if (r20 != 3) goto L36;
        int r21 = y2a.a.a;
        JSONObject r23 = new JSONObject();
        r23.put("is_scheme", y2a.b.b(r2.w));
        r23.put("enter_method", y2a.b.a(r2.s));
        r23.put("click_from", "ClickAuditFailVoice");
        y2a.a.c(r23);
        FLogger.a.i(r2.A, "[clickItem] fail, voice: " + r4);
        String r24 = l2.a;
        FragmentManager r110 = r2.getParentFragmentManager();
        Context r25 = r2.getContext();
        if (r25 == null) goto L30;
        r8 = r25.getString(2131911118);
    L30:
        String r111 = r8;
        String r26 = r2.z;
        SearchMobParam r27 = r2.F;
        String r30 = r2.G;
        String r112 = r2.ua0();
        String r31 = r2.s;
        if (r31 != null) goto L33;
        String r210 = "unknown";
    L34:
        l2.f(r110, r111, r26, r27, r30, r112, new v(r2, r4), false, r210, r2.w, "ClickAuditFailVoice", r2.u, LynxTouchEvent.kPseudoStateFocusTransition);
        return;
    L33:
        r210 = r31;
        goto L34
    L36:
        if (r20 != 2) goto L38;
    L80:
        FLogger.a.i(r2.A, "[clickItem] uploading, voice: " + r4);
        return;
    L38:
        if (r28.a.getStatus() == 10) goto L80;
        VoiceItemAdapter r1 = r2.ia0();
        if (r1 == null) goto L55;
        List<o2> r32 = r1.a;
        if (r32 == null) goto L55;
        Iterator<T> r33 = r32.iterator();
    L46:
        if (r33.hasNext() == false) goto L53;
        Object r34 = r33.next();
        if (((o2) r34).b != 20) goto L50;
        boolean r35 = true;
    L51:
        if (r35 == false) goto L46;
    L54:
        o2 r36 = (o2) r34;
    L56:
        if (r36 == null) goto L58;
        FLogger.a.i(r2.A, "[clickItem] selecting other item, voice: " + r4);
        return;
    L58:
        FLogger.a.i(r2.A, "voice clicked: " + r4);
        if (r2.D == false) goto L61;
    L79:
        f2a.c r37 = com.larus.voice_setting.voice.utils.k.a.b("click voice item");
        r37.e(new w(r4, r2));
        r37.c.b = CollectionsKt.listOf("VoicePlay");
        f2a.c.c(r37, null, 15);
        r2.ca0(r4);
        return;
    L61:
        if (r2.E == true) goto L65;
        if (com.larus.voice_setting.voice.utils.f.a.g() == true) goto L65;
    L67:
        r5 = false;
    L68:
        if (r5 == true) goto L79;
        if (z2.a.o3().a == true) goto L79;
        p2a.q.a().stopAudio();
        com.larus.audio.s0 r38 = p2a.q.a();
        String r113 = r4.getStyleId();
        AudioPreview r39 = r4.getPreview();
        if (r39 == null) goto L74;
        String r114 = r39.getPreviewAudio();
    L75:
        AudioPreview r40 = r4.getPreview();
        if (r40 == null) goto L78;
        r8 = r40.getMd5();
    L78:
        com.larus.audio.s0.a.a(r38, r113, r114, r8, null, r4.getId(), r4.getName(), 8);
        return;
    L74:
        r114 = null;
    L65:
        if (r2.ka0() == false) goto L67;
    L50:
        r35 = false;
        goto L51
    L53:
        r34 = null;
    L55:
        r36 = null;
        goto L56
    L11:
        r6 = false;
        goto L12
    }

    @Override // com.larus.voice_setting.voice.u2
    public final void c(final o2 r95, final View r96) {
        Intrinsics.checkNotNullParameter(r96, "itemView");
        if (r95 != null) goto L5;
        return;
    L5:
        final MyVoiceListFragment r11 = this.a;
        int r2 = MyVoiceListFragment.K;
        Context r3 = r11.getContext();
        if (r3 != null) goto L9;
    L33:
        g1 r1 = g1.a;
        String r4 = this.a.z;
        Intrinsics.checkNotNullParameter(r4, "enterFrom");
        com.larus.platform.service.o r5 = com.larus.platform.service.o.a;
        JSONObject r6 = new JSONObject();
        r6.put("enter_from", r4);
        Unit r7 = Unit.INSTANCE;
        r5.reportEvent("click_voice_setting", r6);
        return;
    L9:
        if (r11.D == false) goto L11;
        int r14 = 2131910768;
    L12:
        boolean r15 = false;
        View r13 = CreateMenu.f(new CreateMenu(r3), CollectionsKt.listOf(new com.larus.bmhome.view.screenmenu.l0[]{new com.larus.bmhome.view.screenmenu.l0(2131911105, r14, null, null, null, Integer.valueOf(v19.c.b(2130972079, r11.getContext(), 2131103136)), null, Integer.valueOf(v19.c.b(2130971821, r11.getContext(), 2131241952)), null, false, false, null, null, null, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -164, 127), new com.larus.bmhome.view.screenmenu.l0(2131901607, 2131901607, null, null, null, 2131102650, null, 2131241933, null, false, false, null, null, null, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -164, 127)}), 0, false, null, null, null, null, new a0(r11, r95, r96), 510);
        Balloon r8 = com.larus.bmhome.view.screenmenu.d.a(com.larus.bmhome.view.screenmenu.d.a, r96, r13, false, null, null, null, null, 124);
        ViewGroup.LayoutParams r9 = r13.getLayoutParams();
        a r10 = null;
        if ((r9 instanceof ViewGroup.MarginLayoutParams) == false) goto L15;
        ViewGroup.MarginLayoutParams r12 = (ViewGroup.MarginLayoutParams) r9;
    L16:
        if (r12 == null) goto L19;
        r12.rightMargin = (-i5.Q()) + i5.r0();
    L19:
        RadiusLayout r16 = r8.c.d;
        int[] r17 = new int[2];
        r96.getLocationInWindow(r17);
        int r18 = r96.getHeight();
        Fragment r19 = r11.getParentFragment();
        if ((r19 instanceof a) == false) goto L22;
        r10 = (a) r19;
    L22:
        if (r10 == null) goto L24;
        int r20 = r10.l();
    L25:
        if (r20 == 0) goto L30;
        r16.measure(0, 0);
        if (((r20 - r17[1]) - r18) >= (r16.getMeasuredHeight() - i5.l0())) goto L30;
        r15 = true;
    L30:
        if (r15 == false) goto L32;
        r8.v(r96, r96.getMeasuredWidth() - i5.r0(), i5.Q());
        goto L33
    L32:
        r8.x(r96, r96.getMeasuredWidth() - i5.r0(), -i5.Q());
        goto L33
    L24:
        r20 = 0;
        goto L25
    L15:
        r12 = null;
        goto L16
    L11:
        r14 = 2131911105;
        goto L12
    }
}
