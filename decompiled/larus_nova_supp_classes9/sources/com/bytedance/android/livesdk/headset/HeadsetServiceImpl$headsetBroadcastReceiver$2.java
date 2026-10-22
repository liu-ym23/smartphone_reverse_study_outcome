package com.bytedance.android.livesdk.headset;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdkapi.service.HeadsetType;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\t\n\u0000\n\u0002\b\u0003*\u0001\u0001\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "com/bytedance/android/livesdk/headset/HeadsetServiceImpl$headsetBroadcastReceiver$2$1", "invoke", "()Lcom/bytedance/android/livesdk/headset/HeadsetServiceImpl$headsetBroadcastReceiver$2$1;"}, k = 3, mv = {1, 4, 3})
public final class HeadsetServiceImpl$headsetBroadcastReceiver$2 extends Lambda implements Function0<AnonymousClass1> {
    final /* synthetic */ HeadsetServiceImpl this$0;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.headset.HeadsetServiceImpl$headsetBroadcastReceiver$2$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"com/bytedance/android/livesdk/headset/HeadsetServiceImpl$headsetBroadcastReceiver$2$1", "Landroid/content/BroadcastReceiver;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class AnonymousClass1 extends BroadcastReceiver {
        public final IntentFilter a;
        public final /* synthetic */ HeadsetServiceImpl$headsetBroadcastReceiver$2 b;

        public AnonymousClass1(HeadsetServiceImpl$headsetBroadcastReceiver$2 r2) {
            this.b = r2;
            IntentFilter r3 = new IntentFilter();
            this.a = r3;
            r3.addAction("android.intent.action.HEADSET_PLUG");
            r3.addAction("android.media.AUDIO_BECOMING_NOISY");
            r3.addAction("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED");
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context r8, Intent r9) {
            if (r8 != null) goto L4;
            return;
        L4:
            if (r9 != null) goto L6;
            return;
        L6:
            ALogger.i(HeadsetServiceImpl.TAG, "onReceive, intent is " + r9.getAction());
            final HeadsetType r10 = HeadsetServiceImpl.access$getCurrentType$p(this.b.this$0);
            String r1 = r9.getAction();
            if (r1 == null) goto L39;
            int r2 = r1.hashCode();
            if (r2 == (-1676458352)) goto L29;
            if (r2 == (-549244379)) goto L26;
            if (r2 != 545516589) goto L39;
            if (r1.equals("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED") == false) goto L39;
            int r11 = r9.getIntExtra("android.bluetooth.profile.extra.STATE", -1);
            if (r11 != 0) goto L21;
            HeadsetServiceImpl.access$setCurrentType$p(this.b.this$0, HeadsetType.UnKnow);
            goto L39
        L21:
            if (r11 != 2) goto L39;
            HeadsetServiceImpl.access$setCurrentType$p(this.b.this$0, HeadsetType.BluetoothSco);
            goto L39
        L26:
            if (r1.equals("android.media.AUDIO_BECOMING_NOISY") == false) goto L39;
            HeadsetServiceImpl.access$setCurrentType$p(this.b.this$0, HeadsetType.UnKnow);
            goto L39
        L29:
            if (r1.equals("android.intent.action.HEADSET_PLUG") == false) goto L39;
            HeadsetServiceImpl r3 = this.b.this$0;
            if (r9.getIntExtra("state", 0) == 1) goto L33;
            HeadsetType r13 = HeadsetType.UnKnow;
        L37:
            HeadsetServiceImpl.access$setCurrentType$p(r3, r13);
            goto L39
        L33:
            if (r9.getIntExtra("microphone", 0) != 1) goto L35;
            r13 = HeadsetType.WiredHeadPhones;
            goto L37
        L35:
            r13 = HeadsetType.WiredHeadSet;
        L39:
            if (r10 == HeadsetServiceImpl.access$getCurrentType$p(this.b.this$0)) goto L42;
            ALogger.i(HeadsetServiceImpl.TAG, "get headset type use receiver: " + HeadsetServiceImpl.access$getCurrentType$p(this.b.this$0).getTypeValue());
            UtilityKotlinExtentionsKt.s(0, false, false, new HeadsetServiceImpl$headsetBroadcastReceiver$2$1$onReceive$1(this, r10), 7);
            HeadsetServiceImpl.access$updateFeatureValue(this.b.this$0);
            return;
        }
    }

    public HeadsetServiceImpl$headsetBroadcastReceiver$2(HeadsetServiceImpl r1) {
        this.this$0 = r1;
        super(0);
    }

    public final AnonymousClass1 invoke() {
        return new AnonymousClass1(this);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m399invoke() {
        return invoke();
    }
}
