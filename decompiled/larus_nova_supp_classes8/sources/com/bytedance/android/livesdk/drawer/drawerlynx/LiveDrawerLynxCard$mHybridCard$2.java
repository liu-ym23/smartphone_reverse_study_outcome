package com.bytedance.android.livesdk.drawer.drawerlynx;

import android.content.Context;
import com.bytedance.android.annie.api.card.HybridCard;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.browser.GsonMap;
import com.bytedance.android.live.browser.IBrowserService;
import com.bytedance.android.live.browser.UtilsKt;
import com.bytedance.ies.web.jsbridge2.f;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.LinkedHashMap;
import jc1.k;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/bytedance/android/annie/api/card/HybridCard;", "invoke"}, k = 3, mv = {1, 4, 3})
public final class LiveDrawerLynxCard$mHybridCard$2 extends Lambda implements Function0<HybridCard> {
    final /* synthetic */ Context $context;
    final /* synthetic */ LiveDrawerLynxCard this$0;

    public static final class a implements IHybridComponent.a {
        public final /* synthetic */ LiveDrawerLynxCard$mHybridCard$2 a;

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.drawer.drawerlynx.LiveDrawerLynxCard$mHybridCard$2$a$a, reason: collision with other inner class name */
        public static final class C0121a implements f.b {
            public final /* synthetic */ a a;

            public C0121a(a r1) {
                this.a = r1;
            }

            public final f<Object, Object> a() {
                LiveDrawerLynxCard r0 = this.a.a.this$0;
                int r1 = LiveDrawerLynxCard.n;
                r0.getClass();
                return new d(r0);
            }
        }

        public a(LiveDrawerLynxCard$mHybridCard$2 r1) {
            this.a = r1;
        }

        public final void onJSBridgeCreated(y6.c r3) {
            Intrinsics.checkNotNullParameter(r3, "manager");
            r3.registerMethod("community.drawerUnfollow", new C0121a(this));
        }
    }

    public static final class b extends b7.a {
        public b() {
        }
    }

    public LiveDrawerLynxCard$mHybridCard$2(LiveDrawerLynxCard r1, Context r2) {
        this.this$0 = r1;
        this.$context = r2;
        super(0);
    }

    public final HybridCard invoke() {
        HybridCard r0 = k.n(IBrowserService.class).getHybridCard(this.$context, LiveDrawerLynxCard.c(this.this$0), new b());
        if (r0 == null) goto L13;
        r0.setJSBridgeListener(new a(this));
        LinkedHashMap r2 = new LinkedHashMap();
        JsonElement r3 = GsonProtectorUtils.toJsonTree(GsonHelper.getDefault(), LiveDrawerLynxCard.b(this.this$0));
        if ((r3 instanceof JsonObject) == true) goto L7;
        r3 = null;
    L7:
        JsonObject r4 = (JsonObject) r3;
        if (r4 == null) goto L10;
        GsonMap r5 = UtilsKt.i(r4);
    L11:
        r2.put("container_payload", r5);
        Unit r6 = Unit.INSTANCE;
        r0.load(null, r2);
        return r0;
    L10:
        r5 = null;
        goto L11
    L13:
        return null;
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m538invoke() {
        return invoke();
    }
}
