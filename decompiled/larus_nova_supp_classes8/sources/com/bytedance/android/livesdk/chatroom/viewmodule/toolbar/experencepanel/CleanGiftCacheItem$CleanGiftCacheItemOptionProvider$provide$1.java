package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.experencepanel;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.android.live.gift.IGiftServiceExternal;
import com.bytedance.android.livesdk.config.e0;
import jc1.k;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lnp1/g;", "Lnp1/a;", "invoke", "(Lnp1/g;)Lnp1/a;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class CleanGiftCacheItem$CleanGiftCacheItemOptionProvider$provide$1 extends Lambda implements Function1<np1.g, np1.a> {
    final /* synthetic */ c.a this$0;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.experencepanel.CleanGiftCacheItem$CleanGiftCacheItemOptionProvider$provide$1$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lnp1/e;", "", "invoke", "(Lnp1/e;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
    public static final class AnonymousClass2 extends Lambda implements Function1<np1.e, Unit> {
        final /* synthetic */ CleanGiftCacheItem$CleanGiftCacheItemOptionProvider$provide$1 this$0;

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.experencepanel.CleanGiftCacheItem$CleanGiftCacheItemOptionProvider$provide$1$2$a */
        public static final class a implements np1.d<np1.a> {
            public final /* synthetic */ AnonymousClass2 a;

            /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.experencepanel.CleanGiftCacheItem$CleanGiftCacheItemOptionProvider$provide$1$2$a$a, reason: collision with other inner class name */
            public static final class ViewOnClickListenerC0072a implements View.OnClickListener {
                public final /* synthetic */ a a;
                public final /* synthetic */ TextView b;
                public final /* synthetic */ np1.a c;

                public ViewOnClickListenerC0072a(a r1, TextView r2, np1.a r3) {
                    this.a = r1;
                    this.b = r2;
                    this.c = r3;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View r3) {
                    c.a(this.a.a.this$0.this$0.a, "livesdk_live_opt_gift_cache_click", this.b.getText().toString());
                    this.a.a.this$0.this$0.a.getClass();
                    k.n(IGiftServiceExternal.class).cleanGiftDishCache();
                    this.c.c().closeSettingPanel();
                }
            }

            public a(AnonymousClass2 r1) {
                this.a = r1;
            }

            @Override // np1.d
            public final View a(ViewGroup r4) {
                Intrinsics.checkNotNullParameter(r4, "parentView");
                return LayoutInflater.from(r4.getContext()).inflate(2131567605, r4, false);
            }

            @Override // np1.d
            public final void b(np1.a r9, View r10) {
                Intrinsics.checkNotNullParameter(r9, "model");
                Intrinsics.checkNotNullParameter(r10, "itemView");
                TextView r0 = (TextView) r10.findViewById(2131365078);
                this.a.this$0.this$0.a.getClass();
                long r1 = k.n(IGiftServiceExternal.class).getGiftUseDiskCacheSize();
                if ((r1 / ((long) 1024)) <= 0) goto L7;
                StringBuilder r3 = new StringBuilder();     // Catch: Exception -> L15
                float r2 = 100;
                r3.append(String.valueOf(Math.round((r1 / 1024.0f) * r2) / r2));     // Catch: Exception -> L15
                r3.append("GB");     // Catch: Exception -> L15
                String r4 = r3.toString();     // Catch: Exception -> L15
            L11:
                if (r4 != null) goto L13;
                r4 = "0MB";
            L13:
                r0.setText(r4);
                c.a(this.a.this$0.this$0.a, "livesdk_live_opt_gift_cache_show", r0.getText().toString());
                r10.setOnClickListener(new ViewOnClickListenerC0072a(this, r0, r9));
                return;
            L7:
                if (r1 <= 0) goto L10;
                r4 = String.valueOf(r1) + "MB";     // Catch: Exception -> L15
                goto L11
            L18:
                r4 = null;
            L10:
                r4 = null;
                goto L11
            }
        }

        public AnonymousClass2(CleanGiftCacheItem$CleanGiftCacheItemOptionProvider$provide$1 r1) {
            this.this$0 = r1;
            super(1);
        }

        public final void invoke(np1.e r2) {
            Intrinsics.checkNotNullParameter(r2, "$receiver");
            r2.b = new a(this);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((np1.e) r1);
            return Unit.INSTANCE;
        }
    }

    public CleanGiftCacheItem$CleanGiftCacheItemOptionProvider$provide$1(c.a r1) {
        this.this$0 = r1;
        super(1);
    }

    public final np1.a invoke(final np1.g r3) {
        Intrinsics.checkNotNullParameter(r3, "$receiver");
        c.a r0 = this.this$0;
        np1.c r1 = r3.j;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "panelContext");
        if (((e0) j40.h.a.getValue()).getEnable() == true) goto L5;
        return null;
    L5:
        np1.a.C0403a r2 = np1.a.a;
        Function0<np1.e> r4 = new AnonymousClass1(r3);
        AnonymousClass2 r5 = new AnonymousClass2(this);
        r2.getClass();
        return np1.a.C0403a.a(r4, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((np1.g) r1);
    }
}
