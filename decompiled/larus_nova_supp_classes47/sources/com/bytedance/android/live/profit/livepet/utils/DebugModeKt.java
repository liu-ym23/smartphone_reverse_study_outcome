package com.bytedance.android.live.profit.livepet.utils;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.gift.IGiftService;
import com.bytedance.android.live.profit.livepet.container.LivePetContainerWidget;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.live.revenue.common.i;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import com.bytedance.android.livesdk.utils.w0;
import com.bytedance.android.scope.m;
import com.bytedance.android.scope.o;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.tools.kcp.spongepreference.runtime.SpongePreferenceManager;
import e01.l;
import io.reactivex.Single;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import jc1.k;
import kotlin.Unit;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class DebugModeKt {
    public static final /* synthetic */ KProperty[] a = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a b = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a c = null;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ Context a;

        /* JADX INFO: renamed from: com.bytedance.android.live.profit.livepet.utils.DebugModeKt$a$a, reason: collision with other inner class name */
        public static final class DialogInterfaceOnClickListenerC0027a implements DialogInterface.OnClickListener {
            public final /* synthetic */ EditText a;

            public DialogInterfaceOnClickListenerC0027a(EditText r1) {
                this.a = r1;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface r8, int r9) {
                List r10 = StringsKt.split$default(this.a.getText().toString(), new char[]{' ', ','}, false, 0, 6, null);
                ArrayList r12 = new ArrayList();
                Iterator r13 = r10.iterator();
            L4:
                if (r13.hasNext() == false) goto L8;
                Long r0 = StringsKt.toLongOrNull((String) r13.next());
                if (r0 == null) goto L4;
                r12.add(r0);
                goto L4
            L8:
                IGiftService r14 = k.f(IGiftService.class);
                if (r14 == null) goto L36;
                IAssetsManager r15 = r14.getAssetsManager();
                if (r15 == null) goto L37;
                Iterator r16 = r12.iterator();
            L14:
                boolean r1 = true;
                if (r16.hasNext() == false) goto L24;
                long r2 = ((Number) r16.next()).longValue();
                String r4 = r15.gn(r2, false);
                jy0.b.d("LivePet/Debug", "delete asset: id = " + r2 + ", path = " + r4);
                if (r4 != null) goto L19;
            L22:
                if (r1 == true) goto L14;
                FilesKt.deleteRecursively(new PolarisFileWrapper(r4));
                goto L14
            L19:
                if (r4.length() == 0) goto L22;
                r1 = false;
                goto L22
            L24:
                DebugModeKt.c.setValue(null, DebugModeKt.a[1], this.a.getText().toString());
                return;
            L37:
                return;
            }
        }

        public a(Context r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            EditText r5 = new EditText(this.a);
            r5.setText((String) DebugModeKt.c.getValue(null, DebugModeKt.a[1]));
            new AlertDialog.Builder(this.a).setView(r5).setTitle("Delete Assets By ID").setPositiveButton("Delete", new DialogInterfaceOnClickListenerC0027a(r5)).show();
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ Context a;
        public final /* synthetic */ ru0.a b;

        public static final class a implements DialogInterface.OnClickListener {
            public final /* synthetic */ b a;
            public final /* synthetic */ EditText b;
            public final /* synthetic */ EditText c;

            /* JADX INFO: renamed from: com.bytedance.android.live.profit.livepet.utils.DebugModeKt$b$a$a, reason: collision with other inner class name */
            public static final class C0028a<T> implements Consumer {
                public static final C0028a a = null;

                static {
                    a = new C0028a();
                }

                public C0028a() {
                }

                public final void accept(Object r3) {
                    int r0 = ToastUtil.a;
                    ToastUtil.b("image path: " + ((e01.b) r3).a(), 0);
                }
            }

            /* JADX INFO: renamed from: com.bytedance.android.live.profit.livepet.utils.DebugModeKt$b$a$b, reason: collision with other inner class name */
            public static final class C0029b<T> implements Consumer {
                public static final C0029b a = null;

                static {
                    a = new C0029b();
                }

                public C0029b() {
                }

                public final void accept(Object r3) {
                    int r0 = ToastUtil.a;
                    ToastUtil.b("error: " + ((Throwable) r3).getMessage(), 0);
                }
            }

            public a(b r1, EditText r2, EditText r3) {
                this.a = r1;
                this.b = r2;
                this.c = r3;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface r3, int r4) {
                e01.a r5 = new e01.a();
                r5.c(this.b.getText().toString());
                r5.d(Integer.valueOf(CastIntegerProtector.parseInt(this.c.getText().toString())));
                ru0.a r6 = this.a.b;
                l r7 = (l) m.e.d(r6, l.class);
                if (r7 == null) goto L9;
                Single<e01.b> r8 = r7.captureVideoFrame(r5);
                if (r8 == null) goto L10;
                r8.subscribe(C0028a.a, C0029b.a);
                return;
            L10:
                return;
            }
        }

        public b(Context r1, ru0.a r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r6) {
            LinearLayout r7 = new LinearLayout(this.a);
            r7.setOrientation(1);
            r7.setPadding(i.b(24), i.b(16), i.b(24), 0);
            EditText r0 = new EditText(this.a);
            r0.setHint("Format");
            r0.setText("jpg");
            LinearLayout.LayoutParams r1 = new LinearLayout.LayoutParams(-1, -2);
            r1.bottomMargin = i.b(16);
            Unit r2 = Unit.INSTANCE;
            r0.setLayoutParams(r1);
            EditText r3 = new EditText(this.a);
            r3.setHint("Quality");
            r3.setText("85");
            r3.setInputType(2);
            r3.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            r7.addView(r0);
            r7.addView(r3);
            new AlertDialog.Builder(this.a).setView(r7).setTitle("Capture Frame").setPositiveButton("OK", new a(this, r0, r3)).show();
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ ViewGroup a;

        public c(ViewGroup r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            ViewGroup r5 = this.a;
            Handler r0 = UtilityKotlinExtentionsKt.a;
            Intrinsics.checkNotNullParameter(r5, "$this$toggleVisibilityGone");
            if (r5.getVisibility() != 8) goto L5;
        L8:
            UIUtils.setViewVisibility(r5, 0);
            return;
        L5:
            if (r5.getVisibility() == 4) goto L8;
            UIUtils.setViewVisibility(r5, 8);
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ Context a;
        public final /* synthetic */ ru0.a b;

        public static final class a implements DialogInterface.OnClickListener {
            public final /* synthetic */ d a;
            public final /* synthetic */ EditText b;

            public a(d r1, EditText r2) {
                this.a = r1;
                this.b = r2;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface r4, int r5) {
                String r6 = this.b.getText().toString();
                com.bytedance.android.live.profit.livepet.instance.c r7 = new com.bytedance.android.live.profit.livepet.instance.c(1, r6, true);
                ru0.a r0 = this.a.b;
                m r1 = m.e;
                if (r0 == null) goto L11;
                Object r2 = r1.d(r0, com.bytedance.android.live.profit.livepet.instance.b.class);
                if (r2 == null) goto L9;
                ((com.bytedance.android.live.profit.livepet.instance.b) ((o) r2)).a(r7);
                DebugModeKt.b.setValue(null, DebugModeKt.a[0], r6);
                return;
            L9:
                throw new IllegalStateException(("Service " + Reflection.getOrCreateKotlinClass(com.bytedance.android.live.profit.livepet.instance.b.class) + " does not exist").toString());
            L11:
                throw new IllegalArgumentException("Scope is null".toString());
            }
        }

        public d(Context r1, ru0.a r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            EditText r5 = new EditText(this.a);
            r5.setText((String) DebugModeKt.b.getValue(null, DebugModeKt.a[0]));
            new AlertDialog.Builder(this.a).setView(r5).setTitle("Load URI").setPositiveButton("Go", new a(this, r5)).show();
        }
    }

    public static final class e implements View.OnClickListener {
        public final /* synthetic */ ViewGroup a;

        public e(ViewGroup r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            ViewGroup r4 = this.a;
            Handler r0 = UtilityKotlinExtentionsKt.a;
            Intrinsics.checkNotNullParameter(r4, "$this$toggleVisibilityInVisible");
            if (r4.getVisibility() != 8) goto L5;
        L8:
            UIUtils.setViewVisibility(r4, 0);
            return;
        L5:
            if (r4.getVisibility() == 4) goto L8;
            UIUtils.setViewVisibility(r4, 4);
        }
    }

    public static final class f implements View.OnClickListener {
        public final /* synthetic */ ru0.a a;

        public f(ru0.a r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            ru0.a r4 = this.a;
            m r0 = m.e;
            if (r4 == null) goto L11;
            Object r5 = r0.d(r4, com.bytedance.android.live.profit.livepet.instance.b.class);
            if (r5 == null) goto L9;
            ((com.bytedance.android.live.profit.livepet.instance.b) ((o) r5)).c();
            return;
        L9:
            throw new IllegalStateException(("Service " + Reflection.getOrCreateKotlinClass(com.bytedance.android.live.profit.livepet.instance.b.class) + " does not exist").toString());
        L11:
            throw new IllegalArgumentException("Scope is null".toString());
        }
    }

    static {
        a = new KProperty[]{Reflection.mutableProperty0(new MutablePropertyReference0Impl(DebugModeKt.class, "loadUriField", "getLoadUriField()Ljava/lang/String;", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(DebugModeKt.class, "assetIdsField", "getAssetIdsField()Ljava/lang/String;", 1))};
        b = SpongePreferenceManager.a().a("live_pet_debug_load_uri_field", "", String.class);
        c = SpongePreferenceManager.a().a("live_pet_debug_asset_ids_field", "", String.class);
    }

    /* JADX WARN: Type inference failed for: r13v2, types: [com.bytedance.android.live.profit.livepet.utils.DebugModeKt$enableLivePetDebugView$2] */
    public static final void a(final LivePetContainerWidget r12, ru0.a r13, ConstraintLayout r14, final ViewGroup r15) {
        Intrinsics.checkNotNullParameter(r12, "petContainerWidget");
        Intrinsics.checkNotNullParameter(r13, "petRoomScope");
        Intrinsics.checkNotNullParameter(r14, "parentView");
        Intrinsics.checkNotNullParameter(r15, "petContainer");
        final Context r0 = r14.getContext();
        LayoutInflater.from(r0).inflate(2131566863, r14, true);
        ViewGroup r1 = (ViewGroup) r14.findViewById(2131368621);
        r14.findViewById(2131368622).setOnClickListener(new c(r1));
        ?? r16 = new DebugModeKt$enableLivePetDebugView$2(r12);
        View r17 = r1.findViewById(2131364757);
        View r2 = r1.findViewById(2131364833);
        View r3 = r1.findViewById(2131364871);
        View r4 = r1.findViewById(2131364831);
        View r5 = r1.findViewById(2131364835);
        View r6 = r1.findViewById(2131364834);
        View r7 = r1.findViewById(2131364675);
        View r8 = r1.findViewById(2131364703);
        View r9 = r1.findViewById(2131364674);
        r17.setOnClickListener(new d(r0, r13));
        r2.setOnClickListener(new e(r15));
        r3.setOnClickListener(new f(r13));
        Function1<View, Unit> r18 = new DebugModeKt$enableLivePetDebugView$6(r15);
        Intrinsics.checkNotNullParameter(r18, "onClick");
        r4.setOnClickListener(new w0(r18, 1000));
        r16.invoke(r5, new DebugModeKt$enableLivePetDebugView$7(r13, r0, r15));
        r16.invoke(r6, new DebugModeKt$enableLivePetDebugView$8(r13, r0, r15));
        r7.setOnClickListener(new DebugModeKt$enableLivePetDebugView$9(r0));
        r8.setOnClickListener(new a(r0));
        r9.setOnClickListener(new b(r0, r13));
    }
}
