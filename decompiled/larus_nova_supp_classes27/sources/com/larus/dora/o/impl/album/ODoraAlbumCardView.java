package com.larus.dora.o.impl.album;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.avlink.api.IDoraAVLinkService;
import com.larus.dora.api.IDoraService;
import com.larus.dora.o.impl.databinding.DoraOViewAlbumCardBinding;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.oui.button.OButtonLink;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import t39.n;
import w88.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class ODoraAlbumCardView extends FrameLayout {
    public static final /* synthetic */ int m = 0;
    public final LifecycleOwner a;
    public final Function0<Unit> b;
    public final Function0<Unit> c;
    public final DoraOViewAlbumCardBinding d;
    public final List<b> e;
    public int f;
    public i g;
    public boolean h;
    public final com.larus.dora.o.impl.album.a i;
    public final d j;
    public final ODoraAlbumCardView$lifecycleObserver$1 k;
    public final c l;

    public static final class a {
    }

    public static final class b {
        public final FrameLayout a;
        public final SimpleDraweeView b;
        public final TextView c;
        public final View d;

        public b(FrameLayout r2, SimpleDraweeView r3, TextView r4, View r5) {
            Intrinsics.checkNotNullParameter(r2, "root");
            Intrinsics.checkNotNullParameter(r3, "imageView");
            Intrinsics.checkNotNullParameter(r4, "durationView");
            Intrinsics.checkNotNullParameter(r5, "progressMask");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }
    }

    public static final class c implements n {
        public final /* synthetic */ ODoraAlbumCardView a;

        public c(ODoraAlbumCardView r1) {
            this.a = r1;
        }

        public final void e(int r1, int r2, String r3, String r4) {
            Intrinsics.checkNotNullParameter(r3, "productName");
            if (r1 != 2) goto L6;
            final ODoraAlbumCardView r5 = this.a;
            r5.post(new f(r5));
            return;
        }
    }

    public static final class d implements w88.f {
        public final /* synthetic */ ODoraAlbumCardView a;

        public final void a() {
            ODoraAlbumCardView r0 = this.a;
            r0.removeCallbacks(r0.i);
            ODoraAlbumCardView r1 = this.a;
            r1.postDelayed(r1.i, 300);
        }

        public d(ODoraAlbumCardView r1) {
            this.a = r1;
        }
    }

    static {
    }

    public final void d() {
        Intent r0 = new Intent("gallery3d.intent.appintent.albumcommon");
        r0.setPackage("com.android.gallery3d");
        r0.putExtra("app_intent_param_album_key", "dorag");
        r0.putExtra("finish_host_activity_on_exit", true);
        r0.addCategory("android.intent.category.DEFAULT");
        getContext().startActivity(r0);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        FLogger.a.e("ODoraAlbumCardView", "openSystemAlbum failed: " + e.getMessage());
    }

    public final void e() {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.a), null, null, new ODoraAlbumCardView$refresh$1(this, null), 3, null);
    }

    public static String c(i r3) {
        if ((r3 instanceof i.c) == false) goto L6;
        return "Idle";
    L6:
        if ((r3 instanceof i.e) == false) goto L9;
        return "WifiConnecting";
    L9:
        if ((r3 instanceof i.d) == false) goto L12;
        return "Transferring(progress=" + ((i.d) r3).a + ')';
    L12:
        if ((r3 instanceof i.a) == false) goto L15;
        return "Completed";
    L15:
        if ((r3 instanceof i.b) == false) goto L19;
        return "Error(message=" + ((i.b) r3).a + ')';
    L19:
        throw new NoWhenBranchMatchedException();
    }

    public final int a(int r3) {
        Resources r0 = getResources();
        return (int) ((WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).density * r3) + 0.5f);
    }

    public final i b(i r5) {
        if ((r5 instanceof i.c) == false) goto L15;
        IDoraAVLinkService r0 = (IDoraAVLinkService) ServiceManager.get().getService(IDoraAVLinkService.class);
        if (r0 == null) goto L9;
        boolean r2 = true;
        if (r0.R0() != true) goto L9;
    L11:
        if (this.h == true) goto L13;
        if (r2 == true) goto L13;
        return r5;
    L13:
        FLogger.a.i("ODoraAlbumCardView", "getDisplaySyncState fallback Idle -> Transferring, hasInProgressPreview=" + this.h + ", isMediaTransferOrProcessing=" + r2);
        return new i.d(0);
    L9:
        r2 = false;
        goto L11
    L15:
        return r5;
    }

    public final void f(i r9) {
        DoraOViewAlbumCardBinding r0 = this.d;
        LinearLayout r1 = r0.h;
        ProgressBar r2 = r0.g;
        ImageView r3 = r0.f;
        TextView r4 = r0.i;
        TextView r5 = r0.e;
        if ((r9 instanceof i.c) == false) goto L9;
        if (this.f <= 0) goto L7;
        r1.setVisibility(0);
        r2.setVisibility(8);
        r3.setVisibility(8);
        r4.setText(getContext().getString(2131903383, new Object[]{Integer.valueOf(this.f)}));
        r5.setVisibility(0);
        return;
    L7:
        r1.setVisibility(8);
        return;
    L9:
        if ((r9 instanceof i.e) == false) goto L12;
        r1.setVisibility(0);
        r2.setVisibility(0);
        r3.setVisibility(8);
        r4.setText(getContext().getString(2131903386));
        r5.setVisibility(8);
        return;
    L12:
        if ((r9 instanceof i.d) == false) goto L15;
        r1.setVisibility(0);
        r2.setVisibility(0);
        r3.setVisibility(8);
        r4.setText(getContext().getString(2131902159));
        r5.setVisibility(8);
        return;
    L15:
        if ((r9 instanceof i.a) == false) goto L18;
        r1.setVisibility(0);
        r2.setVisibility(8);
        r3.setVisibility(0);
        r3.setImageResource(2131233950);
        r4.setText(getContext().getString(2131902158));
        r5.setVisibility(8);
        return;
    L18:
        if ((r9 instanceof i.b) == false) goto L59;
        r1.setVisibility(0);
        r2.setVisibility(8);
        r3.setVisibility(0);
        r3.setImageResource(2131233951);
        String r10 = ((i.b) r9).a;
        if (r10 != null) goto L22;
    L55:
        int r11 = 2131903384;
    L56:
        r4.setText(getContext().getString(r11));
        r5.setVisibility(8);
        return;
    L22:
        switch(r10.hashCode()) {
            case -1704747215: goto L52;
            case -1584470938: goto L48;
            case -687751078: goto L45;
            case 252770929: goto L41;
            case 473727070: goto L37;
            case 993558001: goto L33;
            case 993676552: goto L29;
            case 1670563574: goto L25;
            default: goto L55;
        };
    L25:
        if (r10.equals("vpn_enabled") == false) goto L55;
        r11 = 2131902089;
        goto L56
    L29:
        if (r10.equals("no_space") == false) goto L55;
        r11 = 2131902122;
        goto L56
    L33:
        if (r10.equals("recording") == false) goto L55;
        r11 = 2131902919;
        goto L56
    L37:
        if (r10.equals("wifi_error") == false) goto L55;
        r11 = 2131902093;
        goto L56
    L41:
        if (r10.equals("gps_disabled") == false) goto L55;
        r11 = 2131902113;
        goto L56
    L45:
        if (r10.equals("low_power") == false) goto L55;
        r11 = 2131902116;
        goto L56
    L48:
        if (r10.equals("wifi_disabled") == false) goto L55;
        r11 = 2131902107;
        goto L56
    L52:
        if (r10.equals("ap_enabled") == false) goto L55;
        r11 = 2131902087;
        goto L56
    L59:
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Type inference failed for: r11v10, types: [com.larus.dora.o.impl.album.ODoraAlbumCardView$lifecycleObserver$1] */
    /* JADX WARN: Type inference failed for: r11v8, types: [com.larus.dora.o.impl.album.a] */
    public ODoraAlbumCardView(Context r11, LifecycleOwner r12, Function0<Unit> r13, Function0<Unit> r14) {
        Intrinsics.checkNotNullParameter(r11, "context");
        Intrinsics.checkNotNullParameter(r12, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r13, "onAlbumEntryClick");
        Intrinsics.checkNotNullParameter(r14, "onSyncRequiresConnection");
        super(r11);
        this.a = r12;
        this.b = r13;
        this.c = r14;
        View r15 = LayoutInflater.from(r11).inflate(2131560161, this, false);
        addView(r15);
        int r16 = 2131362458;
        TextView r2 = (TextView) ViewBindings.findChildViewById(r15, 2131362458);
        if (r2 == null) goto L38;
        r16 = 2131362465;
        LinearLayout r17 = (LinearLayout) ViewBindings.findChildViewById(r15, 2131362465);
        if (r17 == null) goto L38;
        r16 = 2131362487;
        if (((TextView) ViewBindings.findChildViewById(r15, 2131362487)) == null) goto L38;
        r16 = 2131362492;
        OButtonLink r4 = ViewBindings.findChildViewById(r15, 2131362492);
        if (r4 == null) goto L38;
        r16 = 2131387956;
        TextView r5 = (TextView) ViewBindings.findChildViewById(r15, 2131387956);
        if (r5 == null) goto L38;
        r16 = 2131387963;
        ImageView r6 = (ImageView) ViewBindings.findChildViewById(r15, 2131387963);
        if (r6 == null) goto L38;
        r16 = 2131387964;
        ProgressBar r7 = (ProgressBar) ViewBindings.findChildViewById(r15, 2131387964);
        if (r7 == null) goto L38;
        r16 = 2131387965;
        LinearLayout r8 = (LinearLayout) ViewBindings.findChildViewById(r15, 2131387965);
        if (r8 == null) goto L38;
        r16 = 2131387966;
        TextView r9 = (TextView) ViewBindings.findChildViewById(r15, 2131387966);
        if (r9 == null) goto L38;
        this.d = new DoraOViewAlbumCardBinding((LinearLayout) r15, r2, r17, r4, r5, r6, r7, r8, r9);
        this.e = new ArrayList();
        this.g = i.c.a;
        this.i = new com.larus.dora.o.impl.album.a(this);
        this.j = new d(this);
        this.k = new ODoraAlbumCardView$lifecycleObserver$1(this);
        this.l = new c(this);
        int r18 = 0;
    L22:
        if (r18 >= 5) goto L30;
        FrameLayout r110 = new FrameLayout(getContext());
        View r0 = new SimpleDraweeView(getContext());
        GenericDraweeHierarchy r1 = r0.getHierarchy();
        if (r1 == null) goto L26;
        r1.setRoundingParams(RoundingParams.fromCornersRadius(a(8)));
    L26:
        r110.addView(r0, new FrameLayout.LayoutParams(-1, -1));
        TextView r3 = new TextView(getContext());
        r3.setTextColor(ContextCompat.getColor(r3.getContext(), 2131101355));
        r3.setTextSize(10.0f);
        r3.setVisibility(8);
        FrameLayout.LayoutParams r10 = new FrameLayout.LayoutParams(-2, -2);
        r10.gravity = 8388693;
        r10.rightMargin = a(4);
        r10.bottomMargin = a(4);
        Unit r20 = Unit.INSTANCE;
        r110.addView(r3, r10);
        View r21 = new View(getContext());
        r21.setBackgroundResource(2131233927);
        r21.setVisibility(8);
        r110.addView(r21, new FrameLayout.LayoutParams(-1, -1));
        LinearLayout.LayoutParams r22 = new LinearLayout.LayoutParams(0, a(55), 1.0f);
        if (r18 <= 0) goto L29;
        r22.setMarginStart(a(6));
    L29:
        r17.addView(r110, r22);
        ((ArrayList) this.e).add(new b(r110, r0, r3, r21));
        r18 = r18 + 1;
        goto L22
    L30:
        this.d.a.setOnClickListener(new com.larus.dora.o.impl.album.b(this));
        this.d.d.setOnTouchListener(new com.larus.dora.o.impl.album.c(this));
        this.d.e.setOnClickListener(new com.larus.dora.o.impl.album.d(this));
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.a), null, null, new ODoraAlbumCardView$observeSyncState$1(this, null), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.a), null, null, new ODoraAlbumCardView$observeAlbumCountChange$1(this, null), 3, null);
        this.a.getLifecycle().addObserver(this.k);
        IDoraService r111 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r111 == null) goto L33;
        r111.G(this.l);
    L33:
        IDoraAVLinkService r112 = (IDoraAVLinkService) ServiceManager.get().getService(IDoraAVLinkService.class);
        if (r112 == null) goto L42;
        r112.q1(this.j);
        return;
    L42:
        return;
    L38:
        throw new NullPointerException("Missing required view with ID: ".concat(r15.getResources().getResourceName(r16)));
    }
}
