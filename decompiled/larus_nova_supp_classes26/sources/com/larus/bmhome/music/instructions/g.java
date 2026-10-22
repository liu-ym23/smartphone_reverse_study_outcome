package com.larus.bmhome.music.instructions;

import android.content.Context;
import android.text.InputFilter;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.platform.service.z2;
import com.larus.platform.spi.IAIChatUgcAIGCService;
import com.larus.uaigc.music.applet.g1;
import com.larus.uaigc.music.applet.h1;
import com.larus.uaigc.music.applet.i1;
import com.larus.utils.j0;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Job;
import va8.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class g implements com.larus.bmhome.music.instructions.a {
    public static final /* synthetic */ int m = 0;
    public final t1a.b a;
    public final Context b;
    public final View c;
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;
    public final Lazy g;
    public String h;
    public boolean i;
    public int j;
    public Job k;
    public com.larus.bmhome.view.actionbar.edit.c l;

    public static final class a {
    }

    static {
    }

    public final o c() {
        return (o) this.e.getValue();
    }

    public final ICoreInputAbility d() {
        return (ICoreInputAbility) this.d.getValue();
    }

    public final void h() {
        if (d() == null) goto L27;
        View r0 = this.c;
        if (r0 == null) goto L7;
        boolean r1 = r0.isEnabled();
    L8:
        o r2 = c();
        if (r2 == null) goto L11;
        r2.L70(r1);
    L11:
        o r3 = c();
        if (r3 == null) goto L14;
        r3.SB(r1);
    L14:
        o r4 = c();
        if (r4 == null) goto L17;
        r4.qG(r1);
    L17:
        o r5 = c();
        if (r5 == null) goto L20;
        r5.vI(false);
    L20:
        o r6 = c();
        if (r6 == null) goto L23;
        r6.u60(false);
    L23:
        o r7 = c();
        if (r7 == null) goto L27;
        r7.C40(this.b.getResources().getColor(v19.c.b(2130972079, this.b, 2131103136)));
        goto L27
    L7:
        r1 = false;
    L27:
        if (this.i == false) goto L33;
        Job r8 = this.k;
        if (r8 == null) goto L31;
        Job.DefaultImpls.cancel$default(r8, null, 1, null);
    L31:
        this.i = false;
        return;
    }

    public final Context getContext() {
        return this.b;
    }

    public final void f(int r7) {
        this.j = r7;
        if (r7 != 1) goto L5;
        String r1 = "ai";
    L6:
        this.h = r1;
        if (r7 == 1) goto L40;
        if (r7 == 2) goto L10;
        FLogger.a.e("MusicCreateManager", "Process music instruction select tab error, unexpected tab selected: UNKNOWN");
    L49:
        if (r7 != 2) goto L51;
        final int r8 = z2.a.getMusicCreateConfig().a;
    L52:
        com.larus.bmhome.music.utils.a r2 = new com.larus.bmhome.music.utils.a(r8, new b(this, r8));
        o r9 = c();
        if (r9 == null) goto L55;
        r9.oD(new InputFilter[]{r2});
    L55:
        com.larus.bmhome.instruction.g r10 = (com.larus.bmhome.instruction.g) this.f.getValue();
        if (r10 == null) goto L58;
        r10.S7();
    L58:
        ys8.a r11 = (ys8.a) this.g.getValue();
        if (r11 == null) goto L62;
        r11.S7();
        return;
    L62:
        return;
    L51:
        r8 = z2.a.getMusicCreateConfig().c;
        goto L52
    L10:
        String r3 = this.b.getResources().getString(2131907193);
        ICoreInputAbility r4 = d();
        if (r4 == null) goto L13;
        r4.Yk(r3);
    L13:
        com.larus.bmhome.view.actionbar.edit.c r5 = this.l;
        if (r5 == null) goto L16;
        r5.onInputHintChanged(r3, "LyricsTypeChange, MUSIC CUSTOM");
    L16:
        ICoreInputAbility r6 = d();
        if (r6 != null) goto L19;
    L21:
        boolean r12 = false;
    L22:
        if (r12 == true) goto L37;
        ICoreInputAbility r13 = d();
        if (r13 != null) goto L26;
    L28:
        boolean r14 = false;
    L29:
        if (r14 == true) goto L37;
        ICoreInputAbility r15 = d();
        if (r15 != null) goto L33;
    L35:
        boolean r16 = false;
    L36:
        if (r16 == false) goto L49;
    L33:
        if (r15.Rp() != 4) goto L35;
        r16 = true;
        goto L36
    L26:
        if (r13.Rp() != 3) goto L28;
        r14 = true;
    L37:
        o r17 = c();
        if (r17 == null) goto L49;
        r17.vI(true);
        goto L49
    L19:
        if (r6.Rp() != 1) goto L21;
        r12 = true;
        goto L22
    L40:
        h();
        o r18 = c();
        if (r18 == null) goto L43;
        r18.vI(false);
    L43:
        String r19 = this.b.getResources().getString(2131907191);
        ICoreInputAbility r20 = d();
        if (r20 == null) goto L46;
        r20.Yk(r19);
    L46:
        com.larus.bmhome.view.actionbar.edit.c r21 = this.l;
        if (r21 == null) goto L49;
        r21.onInputHintChanged(r19, "LyricsTypeChange, AI_GENERATION");
        goto L49
    L5:
        r1 = "user";
        goto L6
    }

    public static final void b(g r7, boolean r8) {
        if (r8 == false) goto L31;
        ICoreInputAbility r9 = r7.d();
        if (r9 == null) goto L28;
        o r2 = r7.c();
        if (r2 == null) goto L9;
        r2.SB(false);
    L9:
        o r3 = r7.c();
        if (r3 == null) goto L12;
        r3.qG(false);
    L12:
        o r4 = r7.c();
        if (r4 == null) goto L15;
        r4.L70(false);
    L15:
        o r5 = r7.c();
        if (r5 == null) goto L18;
        r5.C40(r7.b.getResources().getColor(v19.c.b(2130972081, r7.b, 2131103143)));
    L18:
        o r6 = r7.c();
        if (r6 == null) goto L21;
        r6.vI(false);
    L21:
        o r10 = r7.c();
        if (r10 == null) goto L24;
        r10.u60(true);
    L24:
        o r11 = r7.c();
        if (r11 == null) goto L27;
        r11.XW(false);
    L27:
        r9.Yk(r7.b.getResources().getString(2131907197));
    L28:
        r7.i = true;
        com.larus.bmhome.instruction.g r12 = (com.larus.bmhome.instruction.g) r7.f.getValue();
        if (r12 == null) goto L64;
        r12.requestFocus();
        return;
    L64:
        return;
    L31:
        ICoreInputAbility r13 = r7.d();
        if (r13 == null) goto L62;
        View r14 = r7.c;
        if (r14 == null) goto L36;
        boolean r15 = r14.isEnabled();
    L37:
        o r16 = r7.c();
        if (r16 == null) goto L40;
        r16.L70(r15);
    L40:
        o r17 = r7.c();
        if (r17 == null) goto L43;
        r17.SB(r15);
    L43:
        o r18 = r7.c();
        if (r18 == null) goto L46;
        r18.qG(r15);
    L46:
        o r19 = r7.c();
        if (r19 == null) goto L49;
        r19.vI(true);
    L49:
        o r20 = r7.c();
        if (r20 == null) goto L52;
        r20.u60(false);
    L52:
        o r21 = r7.c();
        if (r21 == null) goto L55;
        r21.XW(true);
    L55:
        o r1 = r7.c();
        if (r1 == null) goto L58;
        r1.E40();
    L58:
        o r22 = r7.c();
        if (r22 == null) goto L61;
        r22.C40(r7.b.getResources().getColor(v19.c.b(2130972079, r7.b, 2131103136)));
    L61:
        r13.Yk(r7.b.getResources().getString(2131907193));
        goto L62
    L36:
        r15 = false;
    L62:
        r7.i = false;
    }

    public static String e(bq8.a r15, boolean r16) {
        String[] r0 = new String[3];
        bq8.e r1 = r15.b().a;
        String r2 = null;
        if (r1 == null) goto L5;
        String r3 = r1.b;
    L6:
        String r4 = "";
        if (r3 != null) goto L9;
        r3 = "";
    L9:
        r0[0] = r3;
        bq8.e r5 = r15.b().b;
        if (r5 == null) goto L12;
        String r6 = r5.b;
    L13:
        if (r6 != null) goto L15;
        r6 = "";
    L15:
        r0[1] = r6;
        bq8.e r7 = r15.b().c;
        if (r7 == null) goto L18;
        r2 = r7.b;
    L18:
        if (r2 != null) goto L20;
        r2 = "";
    L20:
        r0[2] = r2;
        List r8 = CollectionsKt.listOf(r0);
        ArrayList r9 = new ArrayList();
        Iterator r10 = r8.iterator();
    L22:
        if (r10.hasNext() == false) goto L26;
        Object r11 = r10.next();
        if (StringsKt.isBlank((String) r11) == true) goto L22;
        r9.add(r11);
        goto L22
    L26:
        IAIChatUgcAIGCService.Companion r12 = IAIChatUgcAIGCService.a;
        String r13 = CollectionsKt.joinToString$default(r9, r12.z0().c(), null, null, 0, null, null, 62, null);
        int r14 = j0.a;
        String r17 = j0.d(2131907950);
        String r18 = j0.d(2131907940);
        if (r16 == false) goto L41;
        StringCompanionObject r19 = StringCompanionObject.INSTANCE;
        Object[] r20 = new Object[1];
        String r21 = r15.d;
        if (r21 == null) goto L32;
        r4 = r21;
    L32:
        r20[0] = r4;
        String r22 = String.format(r17, Arrays.copyOf(r20, 1));
        if (o0.d(r18) == false) goto L52;
        if (r13.length() <= 0) goto L37;
        boolean r23 = true;
    L38:
        if (r23 == false) goto L52;
        r13 = String.format(r18, Arrays.copyOf(new Object[]{r13}, 1));
        goto L52
    L37:
        r23 = false;
    L52:
        return r12.z0().a(r22) + r12.z0().a(r13);
    L41:
        String r24 = j0.d(2131907948);
        StringCompanionObject r25 = StringCompanionObject.INSTANCE;
        String r26 = r12.z0().a(String.format(r17, Arrays.copyOf(new Object[]{String.format(r18, Arrays.copyOf(new Object[]{r13}, 1))}, 1)));
        if (o0.d(r24) == false) goto L44;
        String r27 = String.format(r24, Arrays.copyOf(new Object[]{r15.getLyrics()}, 1));
    L46:
        return r26 + "\n\n" + r27;
    L44:
        r27 = r15.getLyrics();
        goto L46
    L12:
        r6 = null;
        goto L13
    L5:
        r3 = null;
        goto L6
    }

    public final void g(Fragment r8, List r9) {
        Intrinsics.checkNotNullParameter(r8, "lifecycleOwner");
        this.k = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r8), null, null, new MusicCreateManager$onClickLyricsAiGen$1(this, r9, null), 3, null);
        this.h = "mix";
    }

    public g(t1a.b r2, Context r3, View r4) {
        Intrinsics.checkNotNullParameter(r2, "vContext");
        Intrinsics.checkNotNullParameter(r3, "context");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = LazyKt.lazy(new c(this));
        this.e = LazyKt.lazy(new d(this));
        this.f = LazyKt.lazy(new e(this));
        this.g = LazyKt.lazy(new f(this));
        this.h = "ai";
        this.j = 1;
    }

    @Override // com.larus.bmhome.music.instructions.a
    public final void a(Fragment r14, List r15, g1 r16, h1 r17, i1 r18) {
        Intrinsics.checkNotNullParameter(r14, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r16, "promptProvider");
        Intrinsics.checkNotNullParameter(r17, "onResult");
        Intrinsics.checkNotNullParameter(r18, "onLoadingChanged");
        this.k = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r14), null, null, new MusicCreateManager$onClickLyricsAiGen$2(this, r18, r16, r15, r17, null), 3, null);
        this.h = "mix";
    }
}
