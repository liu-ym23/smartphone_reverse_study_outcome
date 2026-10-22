package com.larus.doc.sdk.impl.v2.plugins.extend;

import android.webkit.WebView;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.OfficeDocumentPlugin;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Job;
import vv4.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0012\u0010\f\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/larus/doc/sdk/impl/v2/plugins/extend/ContainerExtendPlugin;", "Lcom/bytedance/ee/bear/document/OfficeDocumentPlugin;", "<init>", "()V", "isFirstStart", "", "job", "Lkotlinx/coroutines/Job;", "onStart", "", "host", "Lcom/ss/android/lark/chameleon/pluginapi/ChameleonPluginHost;", "onStop", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ContainerExtendPlugin extends OfficeDocumentPlugin {
    private boolean isFirstStart;
    private Job job;

    /* JADX INFO: renamed from: com.larus.doc.sdk.impl.v2.plugins.extend.ContainerExtendPlugin$onStart$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.doc.sdk.impl.v2.plugins.extend.ContainerExtendPlugin$onStart$1", f = "ContainerExtendPlugin.kt", i = {}, l = {20}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ChameleonPluginHost $host;
        int label;

        public AnonymousClass1(ChameleonPluginHost r1, Continuation<? super AnonymousClass1> r2) {
            this.$host = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass1(this.$host, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r6);
        L11:
            ChameleonPluginHost r7 = this.$host;
            if (r7 == null) goto L19;
            k r8 = r7.getWeb();
            if (r8 == null) goto L19;
            WebView r9 = r8.getWebView();
            if (r9 == null) goto L19;
            r9.scrollBy(0, 1);
        L19:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            this.label = 1;
            if (DelayKt.delay(200, this) != r0) goto L11;
            return r0;
        }
    }

    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public ContainerExtendPlugin() {
        this.isFirstStart = true;
    }

    public void onStart(ChameleonPluginHost r9) {
        Intrinsics.checkNotNullParameter(r9, "host");
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onStart(r9);
        if (this.isFirstStart == true) goto L8;
        Job r0 = this.job;
        if (r0 == null) goto L7;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L7:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r9.getFragment()), null, null, new AnonymousClass1(r9, null), 3, null);
    L8:
        this.isFirstStart = false;
    }

    public void onStop(ChameleonPluginHost r3) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onStop(r3);
        Job r4 = this.job;
        if (r4 == null) goto L5;
        Job.DefaultImpls.cancel$default(r4, null, 1, null);
    L5:
        this.job = null;
    }

    public /* bridge */ /* synthetic */ void onStart(PluginHost r1) {
        onStart((ChameleonPluginHost) r1);
    }

    public /* bridge */ /* synthetic */ void onStop(PluginHost r1) {
        onStop((ChameleonPluginHost) r1);
    }
}
