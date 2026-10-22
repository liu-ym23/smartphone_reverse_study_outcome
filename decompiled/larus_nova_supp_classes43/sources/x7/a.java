package x7;

import android.graphics.Bitmap;
import android.view.View;
import c9.c;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.annie.api.resource.AnnieResType;
import com.bytedance.android.annie.scheme.vo.refactor.BaseHybridParamVoNew;
import com.bytedance.android.annie.scheme.vo.refactor.CardParamVoNew;
import com.bytedance.ies.web.jsbridge2.c0;
import com.lynx.tasm.LynxView;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a implements com.bytedance.android.annie.card.base.b {
    public final c a;
    public final com.bytedance.android.annie.debug.service.c b;
    public final BaseHybridParamVoNew c;

    @Override // com.bytedance.android.annie.card.base.b
    public final void g(View r1, String r10) {
    }

    @Override // com.bytedance.android.annie.card.base.b
    public final void j(View r1, String r10, String r11) {
    }

    @Override // com.bytedance.android.annie.card.base.b
    public final void k(View r1, String r10, Bitmap r11, boolean r12) {
    }

    @Override // com.bytedance.android.annie.card.base.b
    public final /* synthetic */ void l(String r1, AnnieResType r10, IHybridComponent.HybridType r11, Map r12) {
        com.bytedance.android.annie.card.base.a.a(r1, r10, r11, r12);
    }

    @Override // com.bytedance.android.annie.card.base.b
    public final /* synthetic */ void m(boolean r1) {
    }

    @Override // com.bytedance.android.annie.card.base.b
    public final void n(LynxView r10) {
        Intrinsics.checkNotNullParameter(r10, "view");
    }

    @Override // com.bytedance.android.annie.card.base.b
    public final /* synthetic */ void onBeforeGlobalPropsInitialize() {
    }

    @Override // com.bytedance.android.annie.card.base.b
    public final /* synthetic */ void onBeforeInitialPropsInitialize() {
    }

    @Override // com.bytedance.android.annie.card.base.b
    public final /* synthetic */ void onBeforeJsbRegister() {
    }

    @Override // com.bytedance.android.annie.card.base.b
    public final void onBeforeLoadRequest(String r1, AnnieResType r10, IHybridComponent.HybridType r11, Map r12) {
        Intrinsics.checkNotNullParameter(r1, com.bytedance.android.ec.core.event.a.KEY_URL);
        Intrinsics.checkNotNullParameter(r10, "resType");
        Intrinsics.checkNotNullParameter(r11, "type");
    }

    @Override // com.bytedance.android.annie.card.base.b
    public final /* synthetic */ void onBeforeLynxEnvInitialize(boolean r1) {
    }

    @Override // com.bytedance.android.annie.card.base.b
    public final void onCardLoadStart() {
    }

    @Override // com.bytedance.android.annie.card.base.b
    public final void onCreateRenderData(View r10, Set r11) {
        Intrinsics.checkNotNullParameter(r10, "hybridView");
        Intrinsics.checkNotNullParameter(r11, "stateKeys");
    }

    @Override // com.bytedance.android.annie.card.base.b
    public final void onEngineLoadEnd() {
    }

    @Override // com.bytedance.android.annie.card.base.b
    public final void onEngineLoadStart() {
    }

    @Override // com.bytedance.android.annie.card.base.b
    public final /* synthetic */ void onGlobalPropsInitialized() {
    }

    @Override // com.bytedance.android.annie.card.base.b
    public final /* synthetic */ void onInitialPropsInitialized() {
    }

    @Override // com.bytedance.android.annie.card.base.b
    public final /* synthetic */ void onJsbRegistered() {
    }

    @Override // com.bytedance.android.annie.card.base.b
    public final /* synthetic */ void onLynxEnvInitialized() {
    }

    @Override // com.bytedance.android.annie.card.base.b
    public final /* synthetic */ void onTemplateLoaded(View r1, boolean r10) {
    }

    @Override // com.bytedance.android.annie.card.base.b
    public final void onRelease() {
        this.a.e(this.c);
        com.bytedance.android.annie.debug.service.c r0 = this.b;
        BaseHybridParamVoNew r1 = this.c;
        if (r1 == null) goto L5;
        String r10 = r1.b;
    L6:
        r0.onRelease(r10);
        return;
    L5:
        r10 = null;
        goto L6
    }

    @Override // com.bytedance.android.annie.card.base.b
    public final void b(c0 r10) {
        Intrinsics.checkNotNullParameter(r10, "call");
        this.a.b(r10);
    }

    @Override // com.bytedance.android.annie.card.base.b
    public final void onBeforeCreateRenderData(View r10) {
        Intrinsics.checkNotNullParameter(r10, "hybridView");
        c r11 = this.a;
        BaseHybridParamVoNew r0 = this.c;
        if (r0 == null) goto L5;
        String r1 = r0.b;
    L6:
        r11.a(r1);
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.bytedance.android.annie.card.base.b
    public final void c(JSONObject r10, c0 r11) {
        Intrinsics.checkNotNullParameter(r10, "data");
        Intrinsics.checkNotNullParameter(r11, "call");
        this.a.c(r10, r11);
    }

    @Override // com.bytedance.android.annie.card.base.b
    public final void h(View r10, com.bytedance.android.annie.card.web.resource.a r11) {
        Intrinsics.checkNotNullParameter(r11, "resourceInfo");
        Intrinsics.checkNotNullParameter(r11, "resourceInfo");
        this.b.h(r10, r11);
    }

    public a(c r10, com.bytedance.android.annie.debug.service.a r11, CardParamVoNew r12) {
        Intrinsics.checkNotNullParameter(r10, "debugService");
        Intrinsics.checkNotNullParameter(r11, "internalDebugInfoProvider");
        this.a = r10;
        this.b = r11;
        this.c = r12;
    }

    @Override // com.bytedance.android.annie.card.base.b
    public final void i(LynxView r1, String r10, String r11) {
        this.a.g(this.c);
        this.b.a(r10);
    }
}
