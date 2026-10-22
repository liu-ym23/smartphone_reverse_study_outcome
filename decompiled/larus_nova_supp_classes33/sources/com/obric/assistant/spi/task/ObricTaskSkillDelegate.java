package com.obric.assistant.spi.task;

import android.app.Activity;
import androidx.fragment.app.FragmentActivity;
import com.larus.bmhome.actionbar.model.ModelItemIdentity;
import com.larus.bmhome.actionbar.model.ReplyOption;
import com.larus.bmhome.actionbar.model.t0;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0096\u0001J/\u0010\u000b\u001a\u0004\u0018\u00010\b2\b\u0010\f\u001a\u0004\u0018\u00010\b2\b\u0010\r\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0096\u0001J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\bH\u0096\u0001J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\bH\u0096\u0001J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\bH\u0096\u0001J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0096\u0001J\u001d\u0010\u0016\u001a\u0004\u0018\u00010\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0018\u001a\u00020\nH\u0096\u0001J\u001d\u0010\u0019\u001a\u0004\u0018\u00010\n2\b\u0010\u0018\u001a\u0004\u0018\u00010\n2\u0006\u0010\u001a\u001a\u00020\u001bH\u0096\u0001J\u0015\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0096\u0001J\u0011\u0010\u001f\u001a\u00020\u00102\u0006\u0010 \u001a\u00020!H\u0096\u0001J\u0013\u0010\"\u001a\u00020\u00102\b\u0010#\u001a\u0004\u0018\u00010\bH\u0096\u0001J\u0013\u0010\"\u001a\u00020\u00102\b\u0010\u0017\u001a\u0004\u0018\u00010\u0015H\u0096\u0001J\u0017\u0010$\u001a\u00020\u00052\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001b0&H\u0096\u0001J\u001d\u0010'\u001a\u00020\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u00152\b\u0010(\u001a\u0004\u0018\u00010)H\u0096\u0001J\u001d\u0010*\u001a\u00020\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u00152\b\u0010(\u001a\u0004\u0018\u00010)H\u0096\u0001J\u001b\u0010+\u001a\u0004\u0018\u00010\b2\u0006\u0010,\u001a\u00020\b2\u0006\u0010-\u001a\u00020!H\u0096\u0001J\u0018\u0010.\u001a\u0004\u0018\u00010!2\u0006\u0010/\u001a\u00020!H\u0096\u0001¢\u0006\u0002\u00100J\u0015\u00101\u001a\u0004\u0018\u00010\u00152\b\u00102\u001a\u0004\u0018\u00010\u0015H\u0096\u0001J\u0018\u00103\u001a\u0004\u0018\u00010\u00102\u0006\u0010 \u001a\u00020!H\u0096\u0001¢\u0006\u0002\u00104J\u0018\u00103\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0017\u001a\u00020\u0015H\u0096\u0001¢\u0006\u0002\u00105J\u0019\u00106\u001a\u00020\u00052\u0006\u00107\u001a\u00020\u00102\u0006\u00108\u001a\u00020\u0010H\u0096\u0001¨\u00069"}, d2 = {"Lcom/obric/assistant/spi/task/ObricTaskSkillDelegate;", "Lcom/obric/assistant/spi/task/IObricTaskSkillService;", "<init>", "()V", "extendObricActionBarWhiteItems", "", "itemsConfig", "", "", "selectedDeepThinkStatus", "Lcom/larus/bmhome/actionbar/model/ModelItemIdentity;", "getBlueTagTextByOption", "modeKey", "modelKey", "menuSection", "isFromSettingPage", "", "getCurrentDisplayModel", "getDefaultModelItemJson", "getModelItemsJson", "getObricDefaultReplyOption", "Lcom/larus/bmhome/actionbar/model/ReplyOption;", "getPhoneOperationModeIdIfSupportModel", "replyOption", "modelIdentity", "getPhoneOperationModeSupportModel", "selectedMode", "Lcom/larus/bmhome/actionbar/model/ActiveSwitchMenuMode;", "injectObricDefaultReplyModeMenuInfo", "", "menuInfo", "isObricDefaultReplyModeAvailable", "itemId", "", "isPhoneOperationMode", "modeId", "markQuickModeModelsSize", "modeList", "", "onActionBarModelChanged", "activity", "Landroid/app/Activity;", "onSettingModelChanged", "resolveDefaultModelItemKey", "defaultModelItemKey", "defaultReplyMode", "resolveDefaultReplyMode", "serverDefaultReplyMode", "(I)Ljava/lang/Integer;", "resolveDefaultReplyOption", "defaultReplyOption", "saveObricDefaultReplyModeIfNeeded", "(I)Ljava/lang/Boolean;", "(Lcom/larus/bmhome/actionbar/model/ReplyOption;)Ljava/lang/Boolean;", "storeIsUsingMenuConfV2", "isUsingMenuConfV2", "useModeModelList", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricTaskSkillDelegate implements IObricTaskSkillService {
    public static final ObricTaskSkillDelegate b = null;
    public final /* synthetic */ IObricTaskSkillService a;

    static {
        b = new ObricTaskSkillDelegate();
    }

    @Override // com.obric.assistant.spi.task.IObricTaskSkillService
    public final String a(String r2, String r3, String r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r4, "menuSection");
        return this.a.a(r2, r3, r4, r5);
    }

    @Override // com.obric.assistant.spi.task.IObricTaskSkillService
    public final Object b(Object r2) {
        return this.a.b(r2);
    }

    @Override // com.obric.assistant.spi.task.IObricTaskSkillService
    public final boolean c(ReplyOption r2) {
        return this.a.c(r2);
    }

    @Override // com.obric.assistant.spi.task.IObricTaskSkillService
    public final boolean d(String r2) {
        return this.a.d(r2);
    }

    @Override // com.obric.assistant.spi.task.IObricTaskSkillService
    public final String e(ReplyOption r2, ModelItemIdentity r3) {
        Intrinsics.checkNotNullParameter(r3, "modelIdentity");
        return this.a.e(r2, r3);
    }

    @Override // com.obric.assistant.spi.task.IObricTaskSkillService
    public final String f() {
        return this.a.f();
    }

    @Override // com.obric.assistant.spi.task.IObricTaskSkillService
    public final ModelItemIdentity g(ModelItemIdentity r2, t0 r3) {
        Intrinsics.checkNotNullParameter(r3, "selectedMode");
        return this.a.g(r2, r3);
    }

    @Override // com.obric.assistant.spi.task.IObricTaskSkillService
    public final String getCurrentDisplayModel() {
        return this.a.getCurrentDisplayModel();
    }

    @Override // com.obric.assistant.spi.task.IObricTaskSkillService
    public final void h(List<t0> r2) {
        Intrinsics.checkNotNullParameter(r2, "modeList");
        this.a.h(r2);
    }

    @Override // com.obric.assistant.spi.task.IObricTaskSkillService
    public final String i() {
        return this.a.i();
    }

    @Override // com.obric.assistant.spi.task.IObricTaskSkillService
    public final String j(String r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "defaultModelItemKey");
        return this.a.j(r2, r3);
    }

    @Override // com.obric.assistant.spi.task.IObricTaskSkillService
    public final void k(Set<String> r2, ModelItemIdentity r3) {
        Intrinsics.checkNotNullParameter(r2, "itemsConfig");
        this.a.k(r2, r3);
    }

    @Override // com.obric.assistant.spi.task.IObricTaskSkillService
    public final void l(ReplyOption r2, FragmentActivity r3) {
        this.a.l(r2, r3);
    }

    @Override // com.obric.assistant.spi.task.IObricTaskSkillService
    public final ReplyOption m() {
        return this.a.m();
    }

    @Override // com.obric.assistant.spi.task.IObricTaskSkillService
    public final Integer n(int r2) {
        return this.a.n(r2);
    }

    @Override // com.obric.assistant.spi.task.IObricTaskSkillService
    public final Boolean o(int r2) {
        return this.a.o(r2);
    }

    @Override // com.obric.assistant.spi.task.IObricTaskSkillService
    public final Boolean p(ReplyOption r2) {
        Intrinsics.checkNotNullParameter(r2, "replyOption");
        return this.a.p(r2);
    }

    @Override // com.obric.assistant.spi.task.IObricTaskSkillService
    public final boolean q(int r2) {
        return this.a.q(r2);
    }

    @Override // com.obric.assistant.spi.task.IObricTaskSkillService
    public final void r(boolean r2, boolean r3) {
        this.a.r(r2, r3);
    }

    @Override // com.obric.assistant.spi.task.IObricTaskSkillService
    public final ReplyOption s(ReplyOption r2) {
        return this.a.s(r2);
    }

    @Override // com.obric.assistant.spi.task.IObricTaskSkillService
    public final void t(ReplyOption r2, Activity r3) {
        this.a.t(r2, r3);
    }

    private ObricTaskSkillDelegate() {
        this.a = (IObricTaskSkillService) ServiceManager.get().getService(IObricTaskSkillService.class);
    }
}
