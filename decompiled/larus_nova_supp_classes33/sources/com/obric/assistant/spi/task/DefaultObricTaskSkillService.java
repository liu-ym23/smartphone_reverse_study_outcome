package com.obric.assistant.spi.task;

import android.app.Activity;
import androidx.fragment.app.FragmentActivity;
import com.larus.bmhome.actionbar.model.ModelItemIdentity;
import com.larus.bmhome.actionbar.model.ReplyOption;
import com.larus.bmhome.actionbar.model.t0;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0014\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u0017\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0002\u0010\u0011J\u001a\u0010\u0012\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u000fH\u0016J\u0014\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\u0017\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u000fH\u0016¢\u0006\u0002\u0010\u001bJ\u0017\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001c\u001a\u00020\u0016H\u0016¢\u0006\u0002\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000fH\u0016J\u001c\u0010\u001f\u001a\u0004\u0018\u00010\b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u00162\u0006\u0010 \u001a\u00020\nH\u0016J\n\u0010!\u001a\u0004\u0018\u00010\bH\u0016J\n\u0010\"\u001a\u0004\u0018\u00010\bH\u0016J\u001c\u0010#\u001a\u0004\u0018\u00010\n2\b\u0010 \u001a\u0004\u0018\u00010\n2\u0006\u0010$\u001a\u00020%H\u0016J\u0012\u0010&\u001a\u00020\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u0016H\u0016J\u0012\u0010&\u001a\u00020\u00192\b\u0010'\u001a\u0004\u0018\u00010\bH\u0016J.\u0010(\u001a\u0004\u0018\u00010\b2\b\u0010)\u001a\u0004\u0018\u00010\b2\b\u0010*\u001a\u0004\u0018\u00010\b2\u0006\u0010+\u001a\u00020\b2\u0006\u0010,\u001a\u00020\u0019H\u0016J\n\u0010-\u001a\u0004\u0018\u00010\bH\u0016J\u001c\u0010.\u001a\u00020\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u00162\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\u001c\u00101\u001a\u00020\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u00162\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\u0018\u00102\u001a\u00020\u00052\u0006\u00103\u001a\u00020\u00192\u0006\u00104\u001a\u00020\u0019H\u0016J\u0016\u00105\u001a\u00020\u00052\f\u00106\u001a\b\u0012\u0004\u0012\u00020%07H\u0016J\n\u00108\u001a\u0004\u0018\u00010\u0016H\u0016¨\u00069"}, d2 = {"Lcom/obric/assistant/spi/task/DefaultObricTaskSkillService;", "Lcom/obric/assistant/spi/task/IObricTaskSkillService;", "<init>", "()V", "extendObricActionBarWhiteItems", "", "itemsConfig", "", "", "selectedDeepThinkStatus", "Lcom/larus/bmhome/actionbar/model/ModelItemIdentity;", "injectObricDefaultReplyModeMenuInfo", "", "menuInfo", "resolveDefaultReplyMode", "", "serverDefaultReplyMode", "(I)Ljava/lang/Integer;", "resolveDefaultModelItemKey", "defaultModelItemKey", "defaultReplyMode", "resolveDefaultReplyOption", "Lcom/larus/bmhome/actionbar/model/ReplyOption;", "defaultReplyOption", "saveObricDefaultReplyModeIfNeeded", "", "itemId", "(I)Ljava/lang/Boolean;", "replyOption", "(Lcom/larus/bmhome/actionbar/model/ReplyOption;)Ljava/lang/Boolean;", "isObricDefaultReplyModeAvailable", "getPhoneOperationModeIdIfSupportModel", "modelIdentity", "getModelItemsJson", "getDefaultModelItemJson", "getPhoneOperationModeSupportModel", "selectedMode", "Lcom/larus/bmhome/actionbar/model/ActiveSwitchMenuMode;", "isPhoneOperationMode", "modeId", "getBlueTagTextByOption", "modeKey", "modelKey", "menuSection", "isFromSettingPage", "getCurrentDisplayModel", "onSettingModelChanged", "activity", "Landroid/app/Activity;", "onActionBarModelChanged", "storeIsUsingMenuConfV2", "isUsingMenuConfV2", "useModeModelList", "markQuickModeModelsSize", "modeList", "", "getObricDefaultReplyOption", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DefaultObricTaskSkillService implements IObricTaskSkillService {
    public DefaultObricTaskSkillService() {
    }

    @Override // com.obric.assistant.spi.task.IObricTaskSkillService
    public final String a(String r1, String r2, String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "menuSection");
        return null;
    }

    @Override // com.obric.assistant.spi.task.IObricTaskSkillService
    public final Object b(Object r1) {
        return null;
    }

    @Override // com.obric.assistant.spi.task.IObricTaskSkillService
    public final boolean c(ReplyOption r1) {
        return false;
    }

    @Override // com.obric.assistant.spi.task.IObricTaskSkillService
    public final boolean d(String r1) {
        return false;
    }

    @Override // com.obric.assistant.spi.task.IObricTaskSkillService
    public final String e(ReplyOption r1, ModelItemIdentity r2) {
        Intrinsics.checkNotNullParameter(r2, "modelIdentity");
        return null;
    }

    @Override // com.obric.assistant.spi.task.IObricTaskSkillService
    public final String f() {
        return null;
    }

    @Override // com.obric.assistant.spi.task.IObricTaskSkillService
    public final ModelItemIdentity g(ModelItemIdentity r1, t0 r2) {
        Intrinsics.checkNotNullParameter(r2, "selectedMode");
        return null;
    }

    @Override // com.obric.assistant.spi.task.IObricTaskSkillService
    public final String getCurrentDisplayModel() {
        return null;
    }

    @Override // com.obric.assistant.spi.task.IObricTaskSkillService
    public final void h(List<t0> r2) {
        Intrinsics.checkNotNullParameter(r2, "modeList");
    }

    @Override // com.obric.assistant.spi.task.IObricTaskSkillService
    public final String i() {
        return null;
    }

    @Override // com.obric.assistant.spi.task.IObricTaskSkillService
    public final String j(String r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "defaultModelItemKey");
        return null;
    }

    @Override // com.obric.assistant.spi.task.IObricTaskSkillService
    public final void k(Set<String> r1, ModelItemIdentity r2) {
        Intrinsics.checkNotNullParameter(r1, "itemsConfig");
    }

    @Override // com.obric.assistant.spi.task.IObricTaskSkillService
    public final void l(ReplyOption r1, FragmentActivity r2) {
    }

    @Override // com.obric.assistant.spi.task.IObricTaskSkillService
    public final ReplyOption m() {
        return null;
    }

    @Override // com.obric.assistant.spi.task.IObricTaskSkillService
    public final Integer n(int r1) {
        return null;
    }

    @Override // com.obric.assistant.spi.task.IObricTaskSkillService
    public final Boolean o(int r1) {
        return null;
    }

    @Override // com.obric.assistant.spi.task.IObricTaskSkillService
    public final Boolean p(ReplyOption r2) {
        Intrinsics.checkNotNullParameter(r2, "replyOption");
        return null;
    }

    @Override // com.obric.assistant.spi.task.IObricTaskSkillService
    public final boolean q(int r1) {
        return false;
    }

    @Override // com.obric.assistant.spi.task.IObricTaskSkillService
    public final void r(boolean r1, boolean r2) {
    }

    @Override // com.obric.assistant.spi.task.IObricTaskSkillService
    public final ReplyOption s(ReplyOption r1) {
        return null;
    }

    @Override // com.obric.assistant.spi.task.IObricTaskSkillService
    public final void t(ReplyOption r1, Activity r2) {
    }
}
