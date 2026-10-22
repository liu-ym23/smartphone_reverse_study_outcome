package com.bytedance.android.livesdk.gift.platform.core.ui.configuration;

import android.widget.Switch;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.bytedance.android.livesdk.gift.platform.core.ui.configuration.viewmodel.GiftEffectConfigurationViewModelForAnchor;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"initialCheckStatus", BuildConfig.FLAVOR, "switch", "Landroid/widget/Switch;", "invoke"}, k = 3, mv = {1, 4, 3})
final class GiftEffectConfigurationItemForAnchor$buildAnchorGameEffectSwitchItem$1 extends Lambda implements Function1<Switch, Unit> {
    final /* synthetic */ GiftEffectConfigurationItemForAnchor this$0;

    public static final class a<T> implements Observer {
        public final /* synthetic */ Switch a;

        public a(Switch r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            this.a.setChecked(((Boolean) r2).booleanValue());
        }
    }

    public GiftEffectConfigurationItemForAnchor$buildAnchorGameEffectSwitchItem$1(GiftEffectConfigurationItemForAnchor r1) {
        this.this$0 = r1;
        super(1);
    }

    public final void invoke(Switch r3) {
        Intrinsics.checkNotNullParameter(r3, "switch");
        r3.setChecked(ay1.d.a());
        GiftEffectConfigurationViewModelForAnchor r0 = this.this$0.b;
        if (r0 == null) goto L8;
        LiveData<Boolean> r1 = r0.getGameEffectSwitchStatus();
        if (r1 == null) goto L9;
        r1.observeForever(new a(r3));
        return;
    L9:
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((Switch) r1);
        return Unit.INSTANCE;
    }
}
