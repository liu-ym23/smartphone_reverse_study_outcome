package com.obric.assistant.minormode;

import android.content.Context;
import android.view.View;
import android.view.ViewStub;
import android.widget.CheckBox;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.widget.UrlSpanTextView;
import com.larus.platform.service.q;
import com.larus.utils.f;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.spi.security.minormode.IObricMinorModeService;
import com.obric.assistant.t1;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\u0005H\u0016J\b\u0010\u000b\u001a\u00020\u0007H\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0007H\u0016J\"\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005H\u0016J\u001a\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u0007H\u0016J\u0010\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u001f\u001a\u00020\rH\u0016J\b\u0010 \u001a\u00020\u0007H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/obric/assistant/minormode/ObricMinorModeServiceImpl;", "Lcom/obric/assistant/spi/security/minormode/IObricMinorModeService;", "<init>", "()V", "TAG", "", "isMinorModeCustomizeEnabled", "", "getMinorSettingPolicySubTitle", "getMinorSettingAgreePolicyToastTitle", "getMinorPasswordSettingPolicySubTitle", "getObricMinorModeInstructionsReadByUser", "setObricMinorModeInstructionsReadByUser", "", "isChecked", "setupMinorSettingsSubTitle", "context", "Landroid/content/Context;", "subTitleView", "Lcom/larus/common_ui/widget/UrlSpanTextView;", "titleString", "savedCheckbox", "Landroid/widget/CheckBox;", "savedDisclaimerGroup", "Landroid/view/View;", "setupPasswordDisclaimer", "disclaimerStub", "Landroid/view/ViewStub;", "updatePasswordDisclaimerVisibility", "visible", "interceptPasswordSettingIfNeed", "releasePasswordDisclaimer", "isGenesisRProduct", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricMinorModeServiceImpl implements IObricMinorModeService {
    public final String a;
    public CheckBox b;
    public View c;

    public static final class a implements UrlSpanTextView.a {
        public final /* synthetic */ ObricMinorModeServiceImpl a;
        public final /* synthetic */ Context b;

        public final void a(String r5) {
            Intrinsics.checkNotNullParameter(r5, MemorySourceLinkType.URL);
            FLogger.a.i(this.a.a, "minorSubTitle, onUrlClick: " + r5);
            if (Intrinsics.areEqual(r5, "pp") == false) goto L6;
            q.a.e(this.b, f.c(new Pair[]{TuplesKt.to("link_url", "https://os.obriccloud.com/agreement/doubao_assistant_youthmode")}), null);
            return;
        }

        public a(ObricMinorModeServiceImpl r1, Context r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class b implements UrlSpanTextView.a {
        public final /* synthetic */ ObricMinorModeServiceImpl a;
        public final /* synthetic */ Context b;

        public final void a(String r5) {
            Intrinsics.checkNotNullParameter(r5, MemorySourceLinkType.URL);
            FLogger.a.i(this.a.a, "minorModeDisclaimer, onUrlClick: " + r5);
            if (Intrinsics.areEqual(r5, "pp") == false) goto L6;
            q.a.e(this.b, f.c(new Pair[]{TuplesKt.to("link_url", "https://os.obriccloud.com/agreement/doubao_assistant_youthmode")}), null);
            return;
        }

        public b(ObricMinorModeServiceImpl r1, Context r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    @Override // com.obric.assistant.spi.security.minormode.IObricMinorModeService
    public final boolean a() {
        return true;
    }

    @Override // com.obric.assistant.spi.security.minormode.IObricMinorModeService
    public final void f() {
        this.b = null;
        this.c = null;
    }

    public final boolean g() {
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
        String r2 = t9a.b.a().d();     // Catch: Throwable -> L5
        FLogger.a.i(this.a, "isGenesisRProduct " + r2);     // Catch: Throwable -> L5
        Object r0 = Result.constructor-impl(Boolean.valueOf(Intrinsics.areEqual(r2, "Genesis-R")));     // Catch: Throwable -> L5
    L7:
        Throwable r3 = Result.exceptionOrNull-impl(r0);
        if (r3 == null) goto L10;
        FLogger.a.w(this.a, "isGenesisRProduct failed: " + r3.getMessage(), r3);
    L10:
        Boolean r4 = Boolean.FALSE;
        if (Result.isFailure-impl(r0) == false) goto L14;
        r0 = r4;
    L14:
        return ((Boolean) r0).booleanValue();
    L5:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r0 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    public ObricMinorModeServiceImpl() {
        this.a = "ObricMinorModeService";
    }

    @Override // com.obric.assistant.spi.security.minormode.IObricMinorModeService
    public final void c(boolean r2) {
        View r0 = this.c;
        if (r0 == null) goto L9;
        if (r2 == false) goto L6;
        int r3 = 0;
    L7:
        r0.setVisibility(r3);
        return;
    L6:
        r3 = 8;
        goto L7
    }

    @Override // com.obric.assistant.spi.security.minormode.IObricMinorModeService
    public final boolean d(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        CheckBox r0 = this.b;
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L18;
        CheckBox r2 = this.b;
        if (r2 != null) goto L12;
    L14:
        boolean r3 = false;
    L15:
        if (r3 == false) goto L18;
        s r4 = s.a;
        String r6 = AppHost.a.getApplication().getString(2131912637);
        r4.getClass();
        s.k(r5, 2131243497, r6, null);
        return true;
    L12:
        if (r2.isEnabled() != true) goto L14;
        r3 = true;
    L18:
        return false;
    L5:
        if (r0.isChecked() == true) goto L7;
        r1 = true;
        goto L8
    }

    @Override // com.obric.assistant.spi.security.minormode.IObricMinorModeService
    public final View b(Context r5, ViewStub r6) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r6, "disclaimerStub");
        r6.setLayoutResource(2131564035);
        View r7 = r6.inflate();
        this.c = r7;
        CheckBox r0 = (CheckBox) r7.findViewById(2131365649);
        this.b = r0;
        UrlSpanTextView r1 = r7.findViewById(2131380156);
        r7.setVisibility(0);
        r0.setChecked(t1.a.y1());
        r0.setOnCheckedChangeListener(new tea.a(this));
        r1.setUrlSpannedText(AppHost.a.getApplication().getString(2131912639));
        if (g() == false) goto L5;
        r1.setLinkFakeBold(true);
    L6:
        r1.setOnClickListener(new b(this, r5));
        return r7;
    L5:
        r1.setLinkFakeBold(false);
        goto L6
    }

    @Override // com.obric.assistant.spi.security.minormode.IObricMinorModeService
    public final void e(Context r5, UrlSpanTextView r6, String r7) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r6, "subTitleView");
        StringCompanionObject r0 = StringCompanionObject.INSTANCE;
        r6.setUrlSpannedText(String.format(AppHost.a.getApplication().getString(2131912638), Arrays.copyOf(new Object[]{r7}, 1)));
        if (g() == false) goto L5;
        r6.setLinkFakeBold(true);
    L6:
        r6.setOnClickListener(new a(this, r5));
        return;
    L5:
        r6.setLinkFakeBold(false);
        goto L6
    }
}
