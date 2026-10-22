package com.larus.bmhome.miniartifact.template;

import android.view.View;
import android.widget.TextView;
import br8.l;
import com.larus.mainbot.api.miniartifact.MiniArtifactTemplateParams;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.larus.utils.e1;
import gr8.m;
import gr8.n;
import gr8.o;
import gr8.p;
import gr8.q;
import gr8.r;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u0000 ,2\u00060\u0001j\u0002`\u0002:\u0001,B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u001bH\u0016J\u0010\u0010'\u001a\u00020%2\u0006\u0010&\u001a\u00020\u001bH\u0002J\b\u0010(\u001a\u00020%H\u0002J\b\u0010)\u001a\u00020%H\u0002J\b\u0010*\u001a\u00020%H\u0002J\b\u0010+\u001a\u00020%H\u0016R\u001d\u0010\u0005\u001a\u0004\u0018\u00010\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\u000b\u001a\u0004\u0018\u00010\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u0010\u001a\u0004\u0018\u00010\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0015\u001a\u0004\u0018\u00010\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\n\u001a\u0004\b\u0017\u0010\u0018R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001e\u001a\u00020\u001fX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u0006-"}, d2 = {"Lcom/larus/bmhome/miniartifact/template/MiniArtifactTemplateMakeSameComponent;", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "Lcom/larus/ui/arch/component/external/ContentComponent;", "<init>", "()V", "inputAbility", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "getInputAbility", "()Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "inputAbility$delegate", "Lkotlin/Lazy;", "fragmentAbility", "Lcom/larus/bmhome/miniartifact/template/IMiniArtifactTemplateFragmentAbility;", "getFragmentAbility", "()Lcom/larus/bmhome/miniartifact/template/IMiniArtifactTemplateFragmentAbility;", "fragmentAbility$delegate", "miniInputAbility", "Lcom/larus/bmhome/miniartifact/input/IMiniArtifactInputAbility;", "getMiniInputAbility", "()Lcom/larus/bmhome/miniartifact/input/IMiniArtifactInputAbility;", "miniInputAbility$delegate", "miniArtifactTemplateParams", "Lcom/larus/mainbot/api/miniartifact/MiniArtifactTemplateParams;", "getMiniArtifactTemplateParams", "()Lcom/larus/mainbot/api/miniartifact/MiniArtifactTemplateParams;", "miniArtifactTemplateParams$delegate", "makeSameTemplateButton", "Landroid/view/View;", "inputContentId", "", "contentViewId", "", "getContentViewId", "()I", "setContentViewId", "(I)V", "onViewCreated", "", "view", "setupSubtitle", "setupMakeSameButton", "trackUseTemplate", "directSend", "onDestroy", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MiniArtifactTemplateMakeSameComponent extends BaseContentWidget {
    public static final /* synthetic */ int t = 0;
    public final Lazy m;
    public final Lazy n;
    public final Lazy o;
    public final Lazy p;
    public View q;
    public String r;
    public int s;

    public static final class a {
    }

    static {
    }

    public final MiniArtifactTemplateParams Y2() {
        return (MiniArtifactTemplateParams) this.p.getValue();
    }

    public final void onDestroy() {
        Lazy r0 = l.a;
        String r1 = this.r;
        Intrinsics.checkNotNullParameter(r1, "inputContentId");
        ((Map) l.a.getValue()).remove(r1);
    }

    public MiniArtifactTemplateMakeSameComponent() {
        this.m = LazyKt.lazy(new gr8.l(this));
        this.n = LazyKt.lazy(new m(this));
        this.o = LazyKt.lazy(new n(this));
        this.p = LazyKt.lazy(new o(this));
        this.r = "";
        this.s = 2131384813;
    }

    public final int U2() {
        return this.s;
    }

    public final void X2(int r1) {
        this.s = r1;
    }

    public final void onViewCreated(View r3) {
        Intrinsics.checkNotNullParameter(r3, "view");
        Intrinsics.checkNotNullParameter(r3, "view");
        View r0 = r3.findViewById(2131379482);
        this.q = r0;
        if (r0 == null) goto L5;
        r0.setOnClickListener(new r(this));
    L5:
        e1.d((TextView) r3.findViewById(2131387517), new q(this));
        br8.a r4 = (br8.a) this.o.getValue();
        if (r4 == null) goto L9;
        r4.xI(new p(this));
        return;
    }
}
