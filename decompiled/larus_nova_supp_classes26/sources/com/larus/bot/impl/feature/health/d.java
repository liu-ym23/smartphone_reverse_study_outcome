package com.larus.bot.impl.feature.health;

import android.os.Bundle;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.larus.bot.impl.databinding.LarusLayoutChatHealthTipBinding;
import com.larus.search.api.IBrowserService;
import com.larus.settings.provider.health.HealthAgreementInfo;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import tx9.j1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class d extends ClickableSpan {
    public final /* synthetic */ HealthAgreementInfo a;
    public final /* synthetic */ ChatHealthTipFragment b;

    @Override // android.text.style.ClickableSpan
    public final void onClick(View r4) {
        Intrinsics.checkNotNullParameter(r4, "widget");
        Bundle r5 = com.larus.utils.f.c(new Pair[]{TuplesKt.to("link_url", this.a.getUrl())});
        LarusLayoutChatHealthTipBinding r0 = this.b.d;
        if (r0 == null) goto L9;
        ConstraintLayout r1 = r0.a;
        if (r1 == null) goto L9;
        IBrowserService r2 = (IBrowserService) ServiceManager.get().getService(IBrowserService.class);
        if (r2 == null) goto L9;
        r2.i(r1, r5, null);
    L9:
        j1.b(this.b.h, this.a.getTrackName(), "chat_dialog");
        j1.a(this.b.h, this.a.getTrackName(), "chat");
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r3) {
        Intrinsics.checkNotNullParameter(r3, "ds");
        super.updateDrawState(r3);
        r3.setUnderlineText(false);
        FragmentActivity r0 = this.b.getActivity();
        if (r0 == null) goto L6;
        r3.setColor(ContextCompat.getColor(r0, 2131103136));
        return;
    }

    public d(HealthAgreementInfo r1, ChatHealthTipFragment r2) {
        this.a = r1;
        this.b = r2;
    }
}
