package com.larus.bmhome.view.actionbar.edit.component;

import android.content.ClipData;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.viewbinding.ViewBindings;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.actionbar.model.ActionBarItemLocation;
import com.larus.bmhome.chat.ChatFragment;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.component.immerse.ImmerseComponent;
import com.larus.bmhome.chat.model.repo.ChatSender;
import com.larus.bmhome.chat.model.repo.RepoDispatcher;
import com.larus.bmhome.databinding.LarusLayoutActionBarEditorWidgetTextCommandBinding;
import com.larus.bmhome.instruction.base.AbsInstructionWidget;
import com.larus.bmhome.view.actionbar.edit.InstructionEditorViewModel;
import com.larus.common_ui.utils.ViewExtKt;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.platform.IFlowSdkDepend;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010%\n\u0002\b\n\u0018\u0000 I2\u00020\u0001:\u0001IB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010.\u001a\u00020+2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010/\u001a\u0004\u0018\u000100H\u0014J\u0010\u0010&\u001a\u00020+2\u0006\u00101\u001a\u00020'H\u0016J\n\u00102\u001a\u0004\u0018\u000103H\u0002J\b\u00104\u001a\u00020+H\u0016J\u0010\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\u000eH\u0002J\b\u00108\u001a\u00020+H\u0014J\u0010\u00109\u001a\u00020+2\u0006\u00107\u001a\u00020\u000eH\u0002J\u0010\u0010:\u001a\u00020+2\u0006\u00107\u001a\u00020\u000eH\u0002J\u0010\u0010;\u001a\u00020+2\u0006\u00107\u001a\u00020\u000eH\u0002J\u0010\u0010<\u001a\u00020+2\u0006\u00107\u001a\u00020\u000eH\u0002J\u0010\u0010=\u001a\u00020+2\u0006\u00107\u001a\u00020\u000eH\u0002J\u0010\u0010>\u001a\u0002062\u0006\u00107\u001a\u00020\u000eH\u0002J\u0018\u0010?\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020*0@*\u00020\u000eH\u0002J\u0010\u0010A\u001a\u0002062\u0006\u00107\u001a\u00020\u000eH\u0002J\u0010\u0010B\u001a\u0002062\u0006\u00107\u001a\u00020\u000eH\u0002J\u0010\u0010C\u001a\u0002062\u0006\u00107\u001a\u00020\u000eH\u0002J\u0010\u0010D\u001a\u0002062\u0006\u00107\u001a\u00020\u000eH\u0002J\u0010\u0010E\u001a\u00020+2\u0006\u00107\u001a\u00020\u000eH\u0002J\u0010\u0010F\u001a\u0002062\u0006\u00107\u001a\u00020\u000eH\u0002J\u0010\u0010G\u001a\u0002062\u0006\u00107\u001a\u00020\u000eH\u0002J\b\u0010H\u001a\u00020+H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\u0004\u0018\u00010\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\u0004\u0018\u00010\u000e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0016@BX\u0086.¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010(\u001a\u0010\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020+\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006J"}, d2 = {"Lcom/larus/bmhome/view/actionbar/edit/component/CommandWidget;", "Lcom/larus/bmhome/instruction/base/AbsInstructionWidget;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "selectedColor", "", "unSelectedColor", "controller", "Lcom/larus/bmhome/view/actionbar/edit/controller/CommandController;", "getController", "()Lcom/larus/bmhome/view/actionbar/edit/controller/CommandController;", "currentData", "Lcom/larus/bmhome/actionbar/model/ActionBarCommandOption;", "getCurrentData", "()Lcom/larus/bmhome/actionbar/model/ActionBarCommandOption;", "instructionViewModel", "Lcom/larus/bmhome/view/actionbar/edit/InstructionEditorViewModel;", "getInstructionViewModel", "()Lcom/larus/bmhome/view/actionbar/edit/InstructionEditorViewModel;", "value", "Lcom/larus/bmhome/databinding/LarusLayoutActionBarEditorWidgetTextCommandBinding;", "binding", "getBinding", "()Lcom/larus/bmhome/databinding/LarusLayoutActionBarEditorWidgetTextCommandBinding;", "instructionInputAbility", "Lcom/larus/bmhome/instruction/IInstructionInputAbility;", "coreInputAbility", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "chatInputUICoreAbility", "Lcom/larus/bmhome/ability/IChatInputUICoreAbility;", "chatConversationAbility", "Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;", "cameraAbility", "Lcom/larus/bmhome/camera/IChatCameraAbility;", "immerseComponent", "Lcom/larus/bmhome/chat/component/immerse/ImmerseComponent;", "bindFragment", "Landroidx/fragment/app/Fragment;", "sendGaokaoPreferenceMsgAction", "Lkotlin/Function1;", "", "", "hasReportShow", "", "init", "attrs", "Landroid/util/AttributeSet;", "fragment", "currentChatPageContext", "Lcom/larus/bmhome/chat/bean/ChatPageContext;", "onBindView", "refreshUI", "Lcom/larus/bmhome/actionbar/model/ActionBarInstructionParseResult;", "commandData", "onDetachedFromWindow", "trackCommandShow", "trackPodcastCommandShow", "trackCommandClick", "trackPodcastCommandClick", "tryRenderIcon", "parseOpenAlbum", "parseQueryExt", "", "parseSingleFile", "parsePasteUrl", "parseCollegeEntranceExam", "parseSendMessage", "handleUserSendMsg", "parseSyncCalendar", "parseGaokaoPreference", "reportShow", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CommandWidget extends AbsInstructionWidget {
    public static final /* synthetic */ int r = 0;
    public final int f;
    public final int g;
    public LarusLayoutActionBarEditorWidgetTextCommandBinding h;
    public com.larus.bmhome.instruction.g i;
    public ICoreInputAbility j;
    public va8.o k;
    public com.larus.bmhome.chat.component.cvs.y l;
    public zb8.e m;
    public ImmerseComponent n;
    public Fragment o;
    public Function1<? super String, Unit> p;
    public boolean q;

    public static final class a {
    }

    public static final class b implements Observer, FunctionAdapter {
        public final /* synthetic */ Function1 a;

        public b(q0 r2) {
            Intrinsics.checkNotNullParameter(r2, "function");
            this.a = r2;
        }

        public final boolean equals(Object r3) {
            if ((r3 instanceof Observer) == true) goto L5;
            return false;
        L5:
            if ((r3 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r3).getFunctionDelegate());
        }

        public final Function<?> getFunctionDelegate() {
            return this.a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        public final /* synthetic */ void onChanged(Object r2) {
            this.a.invoke(r2);
        }
    }

    static {
    }

    public final LarusLayoutActionBarEditorWidgetTextCommandBinding getBinding() {
        LarusLayoutActionBarEditorWidgetTextCommandBinding r0 = this.h;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    private final xs8.e getController() {
        return (xs8.e) getController();
    }

    private final com.larus.bmhome.actionbar.model.c getCurrentData() {
        xs8.e r0 = getController();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.m;
    }

    private final InstructionEditorViewModel getInstructionViewModel() {
        xs8.e r0 = getController();
        if (r0 == null) goto L5;
        com.larus.bmhome.view.actionbar.edit.c r1 = r0.c;
    L7:
        if ((r1 instanceof InstructionEditorViewModel) == true) goto L9;
        return null;
    L9:
        return (InstructionEditorViewModel) r1;
    L5:
        r1 = null;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v48, types: [com.larus.bmhome.view.actionbar.edit.component.u0] */
    /* JADX WARN: Type inference failed for: r3v23, types: [com.larus.bmhome.view.actionbar.edit.component.q0] */
    @Override // com.larus.bmhome.instruction.base.AbsInstructionWidget
    public final void Y5() {
        final com.larus.bmhome.actionbar.model.c r0 = getCurrentData();
        if (r0 == null) goto L122;
        String r1 = r0.d;
        if (r1 == null) goto L121;
        boolean r3 = false;
        switch(r1.hashCode()) {
            case -1732143341: goto L107;
            case -1391384679: goto L93;
            case -916614717: goto L79;
            case -369428202: goto L65;
            case 675262186: goto L51;
            case 893571170: goto L29;
            case 1031694963: goto L10;
            default: goto L121;
        };
    L10:
        if (r1.equals("gaokao_query_choice") == false) goto L121;
        String r2 = r0.b;
        if (r2 != null) goto L15;
    L16:
        r3 = true;
    L17:
        if (r3 == true) goto L123;
        l7(r0);
        if (r0.k == false) goto L22;
        V6(r0);
    L22:
        getBinding().a.setBackground(ContextCompat.getDrawable(getContext(), v19.c.b(2130970543, getContext(), 2131238559)));
        getBinding().d.setText(r0.b);
        com.larus.utils.e1.d(getBinding().a, new p0(this, r0));
        InstructionEditorViewModel r4 = getInstructionViewModel();
        if (r4 == null) goto L124;
        MutableLiveData<String> r5 = r4.getCollegeEntranceExamClickLiveData();
        if (r5 == null) goto L124;
        r5.observe(getViewLifecycleOwner(), new b(new q0(r0, this)));
    L124:
        return;
    L123:
        return;
    L15:
        if (r2.length() != 0) goto L17;
    L29:
        if (r1.equals("sync_calendar") == false) goto L121;
        String r6 = r0.b;
        if (r6 != null) goto L34;
    L35:
        r3 = true;
    L36:
        if (r3 == false) goto L39;
        return;
    L39:
        if (r0.k == false) goto L41;
        V6(r0);
    L41:
        final ?? r7 = new u0(this);
        l7(r0);
        getBinding().d.setText(r0.b);
        com.larus.utils.e1.d(getBinding().d, new v0(this, r0));
        if (((Boolean) r7.invoke()).booleanValue() == false) goto L44;
        com.larus.utils.e1.o(this);
    L44:
        Fragment r8 = getFragment();
        if (r8 == null) goto L126;
        Lifecycle r9 = r8.getLifecycle();
        if (r9 == null) goto L126;
        r9.addObserver(new CommandWidget$parseSyncCalendar$2(r7, this));
    L126:
        return;
    L34:
        if (r6.length() != 0) goto L36;
    L51:
        if (r1.equals("send_user_message") == false) goto L121;
        String r10 = r0.b;
        if (r10 != null) goto L56;
    L57:
        r3 = true;
    L58:
        if (r3 == true) goto L127;
        l7(r0);
        if (r0.k == false) goto L63;
        V6(r0);
    L63:
        getBinding().d.setText(r0.b);
        com.larus.utils.e1.d(getBinding().a, new o0(this, r0));
        return;
    L127:
        return;
    L56:
        if (r10.length() != 0) goto L58;
    L65:
        if (r1.equals("gaokao_preference") == false) goto L121;
        String r11 = r0.b;
        if (r11 != null) goto L70;
    L71:
        r3 = true;
    L72:
        if (r3 == true) goto L129;
        l7(r0);
        if (r0.k == false) goto L77;
        V6(r0);
    L77:
        getBinding().d.setText(r0.b);
        com.larus.utils.e1.d(getBinding().a, new r0(this, r0));
        return;
    L129:
        return;
    L70:
        if (r11.length() != 0) goto L72;
    L79:
        if (r1.equals("paste_url") == false) goto L121;
        String r12 = r0.b;
        if (r12 != null) goto L84;
    L85:
        r3 = true;
    L86:
        if (r3 == true) goto L131;
        l7(r0);
        if (r0.k == false) goto L91;
        f7(r0);
    L91:
        getBinding().a.setBackground(ContextCompat.getDrawable(getContext(), v19.c.b(2130970543, getContext(), 2131238559)));
        getBinding().d.setText(r0.b);
        com.larus.utils.e1.d(getBinding().a, new n0(this, r0));
        return;
    L131:
        return;
    L84:
        if (r12.length() != 0) goto L86;
    L93:
        if (r1.equals("universal_camera") == false) goto L121;
        String r13 = r0.b;
        if (r13 != null) goto L98;
    L99:
        r3 = true;
    L100:
        if (r3 == true) goto L133;
        l7(r0);
        if (r0.k == false) goto L105;
        V6(r0);
    L105:
        getBinding().d.setText(r0.b);
        com.larus.utils.e1.d(getBinding().a, new t0(this, r0));
        return;
    L133:
        return;
    L98:
        if (r13.length() != 0) goto L100;
    L107:
        if (r1.equals("single_file") == false) goto L121;
        String r14 = r0.b;
        if (r14 != null) goto L112;
    L113:
        r3 = true;
    L114:
        if (r3 == true) goto L135;
        l7(r0);
        if (r0.k == false) goto L119;
        f7(r0);
    L119:
        getBinding().a.setBackground(ContextCompat.getDrawable(getContext(), v19.c.b(2130970543, getContext(), 2131238559)));
        getBinding().d.setText(r0.b);
        com.larus.utils.e1.d(getBinding().a, new s0(this, r0));
        return;
    L135:
        return;
    L112:
        if (r14.length() != 0) goto L114;
    L121:
        return;
    }

    @Override // com.larus.bmhome.instruction.base.AbsInstructionWidget
    public final void b6() {
        com.larus.bmhome.actionbar.model.c r0 = getCurrentData();
        if (r0 == null) goto L6;
        V6(r0);
        return;
    }

    @Override // com.larus.bmhome.instruction.base.AbsInstructionWidget
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        InstructionEditorViewModel r0 = getInstructionViewModel();
        if (r0 == null) goto L8;
        MutableLiveData<String> r1 = r0.getCollegeEntranceExamClickLiveData();
        if (r1 == null) goto L9;
        r1.setValue("");
        return;
    L9:
        return;
    }

    public CommandWidget(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, null, 6, 0);
        this.f = ContextCompat.getColor(r4, v19.c.b(2130972123, r4, 2131103203));
        this.g = ContextCompat.getColor(r4, v19.c.b(2130972079, r4, 2131103136));
    }

    public static Map H6(com.larus.bmhome.actionbar.model.c r4) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L14
        LinkedHashMap r1 = new LinkedHashMap();     // Catch: Throwable -> L14
        HashMap r5 = r4.c;     // Catch: Throwable -> L14
        if (r5 == null) goto L13;
        String r6 = (String) r5.get("query_ext");     // Catch: Throwable -> L14
        if (r6 == null) goto L13;
        JSONObject r2 = new JSONObject(r6);     // Catch: Throwable -> L14
        Iterator<String> r7 = r2.keys();     // Catch: Throwable -> L14
    L8:
        if (r7.hasNext() == false) goto L13;
        String r3 = r7.next();     // Catch: Throwable -> L14
        Object r8 = r2.opt(r3);     // Catch: Throwable -> L14
        if (r8 == null) goto L8;
        r1.put(r3, r8.toString());     // Catch: Throwable -> L14
    L13:
        return r1;
    L14:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        Object r10 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r11 = Result.exceptionOrNull-impl(r10);
        if (r11 == null) goto L20;
        FLogger.a.e("CommandWidget", "parseQueryExt error:" + r11);
        r10 = new LinkedHashMap();
    L20:
        return (Map) r10;
    }

    public final void N6(com.larus.bmhome.actionbar.model.c r13) {
        Map r0 = wa8.c0.a;
        HashMap r1 = r13.c;
        ActionBarItemLocation r2 = ActionBarItemLocation.DETAIL_PANEL;
        xs8.e r3 = getController();
        String r4 = null;
        if (r3 == null) goto L5;
        Integer r5 = Integer.valueOf(r3.l + 1);
    L6:
        wa8.c0.a(r1, r2, r5);
        InstructionEditorViewModel r6 = getInstructionViewModel();
        if (r6 == null) goto L11;
        ChatParam r7 = r6.getChatParam();
        if (r7 == null) goto L11;
        String r8 = r7.b;
    L12:
        InstructionEditorViewModel r9 = getInstructionViewModel();
        if (r9 == null) goto L17;
        ChatParam r10 = r9.getChatParam();
        if (r10 == null) goto L17;
        String r11 = r10.e;
    L18:
        InstructionEditorViewModel r12 = getInstructionViewModel();
        if (r12 == null) goto L21;
        String r14 = r12.getTemplateType();
    L22:
        InstructionEditorViewModel r15 = getInstructionViewModel();
        if (r15 == null) goto L25;
        String r16 = r15.getActionBarType();
    L26:
        InstructionEditorViewModel r17 = getInstructionViewModel();
        if (r17 == null) goto L31;
        com.larus.bmhome.actionbar.model.z0 r18 = r17.getCurrentCustomActionBarItem();
        if (r18 == null) goto L31;
        r4 = r18.b;
    L31:
        String r19 = r4;
        String r20 = r13.b;
        String r110 = String.valueOf(r13.a);
        xs8.e r111 = getController();
        if (r111 == null) goto L34;
        int r112 = r111.l;
    L35:
        tx9.b.c(r8, r11, r14, r16, r19, r20, r110, Integer.valueOf(r112 + 1));
        return;
    L34:
        r112 = 0;
        goto L35
    L25:
        r16 = null;
        goto L26
    L21:
        r14 = null;
    L17:
        r11 = null;
    L11:
        r8 = null;
        goto L12
    L5:
        r5 = null;
        goto L6
    }

    @Override // com.larus.bmhome.instruction.base.AbsInstructionWidget
    public final void R5(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r2, "fragment");
        this.a = r2;
        t1a.b r0 = s1a.a.g(r2);
        this.o = r2;
        this.i = r0.getAbility(com.larus.bmhome.instruction.g.class);
        this.j = r0.getAbility(ICoreInputAbility.class);
        this.k = r0.getAbility(va8.o.class);
        this.l = r0.getAbility(com.larus.bmhome.chat.component.cvs.y.class);
        this.m = r0.getAbility(zb8.e.class);
        this.n = r0.getAbility(ImmerseComponent.class);
    }

    public final void V6(com.larus.bmhome.actionbar.model.c r14) {
        if (this.q == false) goto L5;
        return;
    L5:
        this.q = true;
        Map r1 = wa8.c0.a;
        HashMap r2 = r14.c;
        ActionBarItemLocation r3 = ActionBarItemLocation.DETAIL_PANEL;
        xs8.e r4 = getController();
        String r5 = null;
        if (r4 == null) goto L8;
        Integer r6 = Integer.valueOf(r4.l + 1);
    L9:
        wa8.c0.b(r2, r3, r6);
        InstructionEditorViewModel r7 = getInstructionViewModel();
        if (r7 == null) goto L14;
        ChatParam r8 = r7.getChatParam();
        if (r8 == null) goto L14;
        String r9 = r8.b;
    L15:
        InstructionEditorViewModel r10 = getInstructionViewModel();
        if (r10 == null) goto L20;
        ChatParam r11 = r10.getChatParam();
        if (r11 == null) goto L20;
        String r12 = r11.e;
    L21:
        InstructionEditorViewModel r13 = getInstructionViewModel();
        if (r13 == null) goto L24;
        String r15 = r13.getTemplateType();
    L25:
        InstructionEditorViewModel r16 = getInstructionViewModel();
        if (r16 == null) goto L28;
        String r17 = r16.getActionBarType();
    L29:
        InstructionEditorViewModel r18 = getInstructionViewModel();
        if (r18 == null) goto L34;
        com.larus.bmhome.actionbar.model.z0 r19 = r18.getCurrentCustomActionBarItem();
        if (r19 == null) goto L34;
        r5 = r19.b;
    L34:
        String r20 = r5;
        String r110 = r14.b;
        String r111 = String.valueOf(r14.a);
        xs8.e r112 = getController();
        if (r112 == null) goto L37;
        int r113 = r112.l;
    L38:
        tx9.b.d(r9, r12, r15, r17, r20, r110, r111, Integer.valueOf(r113 + 1));
        return;
    L37:
        r113 = 0;
        goto L38
    L28:
        r17 = null;
        goto L29
    L24:
        r15 = null;
    L20:
        r12 = null;
    L14:
        r9 = null;
        goto L15
    L8:
        r6 = null;
        goto L9
    }

    public final void W6(com.larus.bmhome.actionbar.model.c r46) {
        Map r1 = wa8.c0.a;
        HashMap r2 = r46.c;
        ActionBarItemLocation r3 = ActionBarItemLocation.DETAIL_PANEL;
        xs8.e r4 = getController();
        String r5 = null;
        if (r4 == null) goto L5;
        Integer r6 = Integer.valueOf(r4.l + 1);
    L6:
        wa8.c0.a(r2, r3, r6);
        Integer r7 = r46.a;
        if (r7 == null) goto L9;
        String r14 = r7.toString();
    L10:
        String r13 = r46.b;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L21
        InstructionEditorViewModel r8 = getInstructionViewModel();     // Catch: Throwable -> L21
        if (r8 == null) goto L18;
        ChatParam r9 = r8.getChatParam();     // Catch: Throwable -> L21
        if (r9 == null) goto L18;
        String r10 = r9.a;     // Catch: Throwable -> L21
        if (r10 == null) goto L18;
        Long r11 = Long.valueOf(CastLongProtector.parseLong(r10));     // Catch: Throwable -> L21
    L19:
        Object r12 = Result.constructor-impl(r11);     // Catch: Throwable -> L21
    L24:
        if (Result.isFailure-impl(r12) == false) goto L26;
        r12 = null;
    L26:
        Long r21 = (Long) r12;
        InstructionEditorViewModel r15 = getInstructionViewModel();
        if (r15 == null) goto L31;
        ChatParam r16 = r15.getChatParam();
        if (r16 == null) goto L31;
        String r17 = r16.b;
    L32:
        InstructionEditorViewModel r18 = getInstructionViewModel();
        if (r18 == null) goto L37;
        ChatParam r19 = r18.getChatParam();
        if (r19 == null) goto L37;
        r5 = r19.e;
    L37:
        String r20 = r5;
        xs8.e r22 = getController();
        if (r22 == null) goto L40;
        int r23 = r22.l;
    L41:
        tx9.b.e(r17, r20, null, null, null, null, null, r13, r14, null, 1, Integer.valueOf(r23 + 1), null, null, null, r21, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -36228, 127);
        return;
    L40:
        r23 = 0;
    L31:
        r17 = null;
    L18:
        r11 = null;
    L21:
        th = move-exception;
        Result.Companion r24 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L24
    L9:
        r14 = null;
        goto L10
    L5:
        r6 = null;
        goto L6
    }

    public final void f7(com.larus.bmhome.actionbar.model.c r31) {
        if (this.q == false) goto L5;
        return;
    L5:
        this.q = true;
        Map r3 = wa8.c0.a;
        HashMap r4 = r31.c;
        ActionBarItemLocation r5 = ActionBarItemLocation.DETAIL_PANEL;
        xs8.e r6 = getController();
        String r7 = null;
        if (r6 == null) goto L8;
        Integer r8 = Integer.valueOf(r6.l + 1);
    L9:
        wa8.c0.b(r4, r5, r8);
        Integer r9 = r31.a;
        if (r9 == null) goto L12;
        String r15 = r9.toString();
    L13:
        String r14 = r31.b;
        InstructionEditorViewModel r0 = getInstructionViewModel();
        if (r0 == null) goto L18;
        ChatParam r1 = r0.getChatParam();
        if (r1 == null) goto L18;
        String r10 = r1.b;
    L45:
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L29
        InstructionEditorViewModel r11 = getInstructionViewModel();     // Catch: Throwable -> L29
        if (r11 == null) goto L26;
        ChatParam r12 = r11.getChatParam();     // Catch: Throwable -> L29
        if (r12 == null) goto L26;
        String r13 = r12.a;     // Catch: Throwable -> L29
        if (r13 == null) goto L26;
        Long r16 = Long.valueOf(CastLongProtector.parseLong(r13));     // Catch: Throwable -> L29
    L27:
        Object r17 = Result.constructor-impl(r16);     // Catch: Throwable -> L29
    L32:
        if (Result.isFailure-impl(r17) == false) goto L34;
        r17 = null;
    L34:
        Long r20 = (Long) r17;
        InstructionEditorViewModel r18 = getInstructionViewModel();
        if (r18 == null) goto L39;
        ChatParam r19 = r18.getChatParam();
        if (r19 == null) goto L39;
        r7 = r19.e;
    L39:
        String r21 = r7;
        xs8.e r22 = getController();
        if (r22 == null) goto L42;
        int r23 = r22.l;
    L43:
        tx9.b.f(r10, r21, null, null, null, null, null, r14, r15, null, 1, Integer.valueOf(r23 + 1), null, r20, null, null, null, null, null, null, null, null, 8376956);
        return;
    L42:
        r23 = 0;
    L26:
        r16 = null;
    L29:
        th = move-exception;
        Result.Companion r24 = Result.Companion;
        r17 = Result.constructor-impl(ResultKt.createFailure(th));
    L18:
        r10 = null;
        goto L45
    L12:
        r15 = null;
        goto L13
    L8:
        r8 = null;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void l7(com.larus.bmhome.actionbar.model.c r7) {
        boolean r0 = v19.h.a;
        boolean r1 = v19.h.b(getContext());
        ImmerseComponent r2 = this.n;
        boolean r3 = true;
        if (r2 != null) goto L5;
    L7:
        boolean r4 = false;
    L8:
        if (r1 == true) goto L12;
        if (r4 == true) goto L12;
        boolean r5 = false;
    L13:
        String r6 = null;
        if (r5 == false) goto L18;
        com.larus.bmhome.actionbar.model.g1 r8 = r7.f;
        if (r8 != null) goto L20;
    L21:
        String r9 = null;
    L22:
        if (r5 == false) goto L26;
        com.larus.bmhome.actionbar.model.g1 r10 = r7.h;
        if (r10 != null) goto L28;
    L29:
        if (r9 != null) goto L31;
    L34:
        boolean r11 = true;
    L36:
        if (r11 == false) goto L38;
        com.larus.utils.e1.o(getBinding().b);
    L39:
        if (r6 != null) goto L41;
    L44:
        boolean r12 = true;
    L45:
        if (r12 == false) goto L47;
        com.larus.utils.e1.o(getBinding().c);
        return;
    L47:
        AppCompatTextView r13 = getBinding().d;
        ViewGroup.LayoutParams r14 = r13.getLayoutParams();
        if (r14 == null) goto L61;
        ConstraintLayout.LayoutParams r15 = (ConstraintLayout.LayoutParams) r14;
        if (r9 != null) goto L52;
    L55:
        if (r3 == false) goto L57;
        int r16 = i5.h();
    L58:
        r15.setMarginStart(r16);
        r15.setMarginEnd(0);
        r13.setLayoutParams(r15);
        com.larus.utils.e1.x(getBinding().c);
        ImageLoaderKt.u(getBinding().c, r6, "custom_actionbar_icon");
        return;
    L57:
        r16 = i5.j0();
        goto L58
    L52:
        if (r9.length() == 0) goto L55;
        r3 = false;
        goto L55
    L61:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L41:
        if (r6.length() == 0) goto L44;
        r12 = false;
        goto L45
    L38:
        com.larus.utils.e1.x(getBinding().b);
        ImageLoaderKt.u(getBinding().b, r9, "custom_actionbar_icon");
        goto L39
    L31:
        if (r9.length() == 0) goto L34;
        r11 = false;
    L28:
        r6 = r10.b;
        goto L29
    L26:
        r10 = r7.g;
        if (r10 == null) goto L29;
    L20:
        r9 = r8.b;
        goto L22
    L18:
        r8 = r7.e;
        if (r8 == null) goto L21;
    L12:
        r5 = true;
        goto L13
    L5:
        if (r2.pl() != true) goto L7;
        r4 = true;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.larus.bmhome.instruction.base.AbsInstructionWidget
    public final void V5(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        LayoutInflater.from(r3).inflate(2131562724, this);
        int r5 = 2131374692;
        SimpleDraweeView r6 = ViewBindings.findChildViewById(this, 2131374692);
        if (r6 == null) goto L11;
        r5 = 2131374696;
        SimpleDraweeView r0 = ViewBindings.findChildViewById(this, 2131374696);
        if (r0 == null) goto L11;
        r5 = 2131390830;
        AppCompatTextView r1 = ViewBindings.findChildViewById(this, 2131390830);
        if (r1 == null) goto L11;
        this.h = new LarusLayoutActionBarEditorWidgetTextCommandBinding(this, r6, r0, r1);
        return;
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r5)));
    }

    public static Unit C6(CommandWidget r1, com.larus.bmhome.actionbar.model.c r2, View r3) {
        Intrinsics.checkNotNullParameter(r3, "it");
        xs8.e r4 = r1.getController();
        if (r4 == null) goto L5;
        r4.s();
    L5:
        r1.W6(r2);
        com.larus.bmhome.view.actionbar.edit.n r5 = r1.getInputDepend();
        if (r5 == null) goto L12;
        String r6 = r2.d;
        if (r6 != null) goto L10;
        r6 = "";
    L10:
        r5.a(r6);
    L12:
        return Unit.INSTANCE;
    }

    public static Unit i6(com.larus.bmhome.actionbar.model.c r4, CommandWidget r5, String r6) {
        if (Intrinsics.areEqual(r6, r4.b) == false) goto L31;
        r5.getBinding().a.setSelected(!r5.getBinding().a.isSelected());
        HashMap r7 = r4.c;
        if (r7 == null) goto L8;
        String r8 = (String) r7.get("placeholder");
        if (r8 == null) goto L8;
    L10:
        if (r5.getBinding().a.isSelected() == true) goto L12;
    L20:
        InstructionEditorViewModel r9 = r5.getInstructionViewModel();
        if (r9 == null) goto L33;
        InstructionEditorViewModel r2 = r5.getInstructionViewModel();
        if (r2 == null) goto L29;
        com.larus.bmhome.actionbar.model.r r3 = r2.getCurrentInstructionConf();
        if (r3 == null) goto L29;
        com.larus.bmhome.actionbar.model.h1 r10 = r3.c;
        if (r10 == null) goto L29;
        String r11 = r10.a;
    L30:
        r9.onInputHintChanged(r11, "parseCollegeEntranceExam");
    L29:
        r11 = null;
    L33:
        if (r5.getBinding().a.isSelected() == false) goto L35;
        r5.getBinding().d.setTextColor(r5.f);
    L37:
        if (r5.getBinding().a.isSelected() == false) goto L39;
        int r12 = 1;
    L40:
        r4.i = r12;
        return Unit.INSTANCE;
    L39:
        r12 = 0;
        goto L40
    L35:
        r5.getBinding().d.setTextColor(r5.g);
        goto L37
    L12:
        if (r8.length() != 0) goto L14;
        boolean r13 = true;
    L15:
        if (r13 == true) goto L20;
        InstructionEditorViewModel r14 = r5.getInstructionViewModel();
        if (r14 == null) goto L33;
        r14.onInputHintChanged(r8, "parseCollegeEntranceExam");
        goto L33
    L14:
        r13 = false;
    L8:
        r8 = "";
        goto L10
    L31:
        r5.getBinding().a.setSelected(false);
        goto L33
    }

    public static Unit k6(CommandWidget r6, com.larus.bmhome.actionbar.model.c r7, View r8) {
        Intrinsics.checkNotNullParameter(r8, "it");
        xs8.e r9 = r6.getController();
        if (r9 == null) goto L5;
        r9.s();
    L5:
        r6.N6(r7);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r6.getViewLifecycleOwner()), Dispatchers.getMain(), null, new CommandWidget$parseGaokaoPreference$1$1(r6, r7, null), 2, null);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Unit n6(CommandWidget r8, com.larus.bmhome.actionbar.model.c r9, View r10) {
        Intrinsics.checkNotNullParameter(r10, "it");
        xs8.e r11 = r8.getController();
        if (r11 == null) goto L5;
        r11.s();
    L5:
        r8.N6(r9);
        HashMap r2 = new HashMap();
        InstructionEditorViewModel r12 = r8.getInstructionViewModel();
        if (r12 == null) goto L10;
        Integer r13 = r12.getInstructionType();
        if (r13 == null) goto L10;
        r2.put("action_bar_template_id", String.valueOf(r13.intValue()));
    L10:
        InstructionEditorViewModel r14 = r8.getInstructionViewModel();
        if (r14 == null) goto L17;
        com.larus.bmhome.actionbar.model.z0 r15 = r14.getCurrentCustomActionBarItem();
        if (r15 == null) goto L17;
        String r16 = r15.b;
        if (r16 == null) goto L17;
        r2.put("action_bar_key", r16);
    L17:
        ChatFragment r17 = r8.o;
        if ((r17 instanceof ChatFragment) == false) goto L20;
        ChatFragment r18 = r17;
    L21:
        if (r18 == null) goto L23;
        r2.put("chat_key", Long.valueOf(r18.getChatUniqueKey()));
    L23:
        InstructionEditorViewModel r19 = r8.getInstructionViewModel();
        if (r19 == null) goto L28;
        String r110 = r19.getTemplateType();
        if (r110 == null) goto L28;
        r2.put("action_bar_template_type", r110);
    L28:
        Map r111 = H6(r9);
        HashMap r0 = r9.c;
        if (r0 == null) goto L33;
        String r1 = (String) r0.get("disable_text_check");
        if (r1 == null) goto L33;
        String r3 = (String) r111.put("disable_text_check", r1);
    L33:
        HashMap r4 = r9.c;
        if (r4 == null) goto L37;
        String r5 = (String) r4.get("scene");
        if (r5 == null) goto L37;
    L38:
        String r6 = r5;
        r111.put("action_bar_command_id", String.valueOf(r9.a));
        if (Intrinsics.areEqual(r111.get("college_entrance_examination"), "1") == false) goto L41;
        r111.put("ban_action_bar_auto_shift", "1");
    L41:
        r2.put("extra_params", r111);
        HashMap r20 = r9.c;
        if (r20 == null) goto L45;
        String r21 = (String) r20.get("click_from");
        if (r21 == null) goto L45;
    L46:
        r2.put("click_from", r21);
        zb8.e r7 = r8.m;
        if (r7 == null) goto L49;
        zb8.e.a.b(r7, r6, r2, null, null, null, false, 120);
    L49:
        ViewExtKt.g(r8);
        return Unit.INSTANCE;
    L45:
        r21 = "health_explain";
    L37:
        r5 = "health_second_camera";
        goto L38
    L20:
        r18 = null;
        goto L21
    }

    public static Unit o6(CommandWidget r1, com.larus.bmhome.actionbar.model.c r2, View r3) {
        Intrinsics.checkNotNullParameter(r3, "it");
        xs8.e r4 = r1.getController();
        if (r4 == null) goto L5;
        r4.s();
    L5:
        r1.N6(r2);
        InstructionEditorViewModel r5 = r1.getInstructionViewModel();
        if (r5 == null) goto L11;
        MutableLiveData<String> r6 = r5.getCollegeEntranceExamClickLiveData();
        if (r6 == null) goto L11;
        r6.setValue(r2.b);
    L11:
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Unit s6(CommandWidget r4, com.larus.bmhome.actionbar.model.c r5, View r6) {
        Intrinsics.checkNotNullParameter(r6, "it");
        xs8.e r7 = r4.getController();
        if (r7 == null) goto L5;
        r7.s();
    L5:
        r4.W6(r5);
        ICoreInputAbility r8 = r4.j;
        boolean r9 = true;
        if (r8 == null) goto L8;
        r8.g2(1, true);
    L8:
        ICoreInputAbility r10 = r4.j;
        if (r10 == null) goto L44;
        ICoreInputAbility.b.e(r10, "CommandWidget.PASTE_URL", null, false, 6);
    L44:
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L37
        IFlowSdkDepend r12 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);     // Catch: Throwable -> L37
        if (r12 == null) goto L45;
        r12.d0();     // Catch: Throwable -> L37
        ClipData r13 = com.larus.home.impl.sdk.i1.a.e(r4.getContext(), "bpea-ai-podcast");     // Catch: Throwable -> L37
        if (r13 == null) goto L45;
        if (r13.getItemCount() <= 0) goto L31;
        CharSequence r14 = r13.getItemAt(0).getText();     // Catch: Throwable -> L37
        if (r14 != null) goto L24;
        r14 = "";
    L24:
        if (r14.length() <= 0) goto L26;
        boolean r1 = true;
    L27:
        if (r1 == false) goto L31;
        va8.o r0 = r4.k;     // Catch: Throwable -> L37
        if (r0 == null) goto L32;
        r0.Ug(r14.toString());     // Catch: Throwable -> L37
    L32:
        if (r9 == true) goto L34;
        t19.s r15 = t19.s.a;     // Catch: Throwable -> L37
        Context r16 = r4.getContext();     // Catch: Throwable -> L37
        r15.getClass();     // Catch: Throwable -> L37
        t19.s.s(r16, 2131899657);     // Catch: Throwable -> L37
    L34:
        Object r17 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L37
    L39:
        Throwable r18 = Result.exceptionOrNull-impl(r17);
        if (r18 == null) goto L43;
        FLogger.a.e("CommandWidget", "parsePasteUrl error:" + r18.getMessage(), r18);
    L43:
        return Unit.INSTANCE;
    L26:
        r1 = false;
    L31:
        r9 = false;
    L45:
        return Unit.INSTANCE;
    L37:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        r17 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L39
    }

    public static Unit u6(CommandWidget r21, com.larus.bmhome.actionbar.model.c r22, View r23) {
        Intrinsics.checkNotNullParameter(r23, "it");
        xs8.e r2 = r21.getController();
        if (r2 == null) goto L5;
        r2.s();
    L5:
        r21.N6(r22);
        ChatFragment r3 = r21.getFragment();
        ChatPageContext r4 = null;
        if ((r3 instanceof ChatFragment) == false) goto L8;
        ChatFragment r5 = r3;
    L9:
        if (r5 == null) goto L11;
        r5.m8();
    L11:
        HashMap r6 = r22.c;
        if (r6 == null) goto L14;
        String r7 = (String) r6.get("message_text");
    L16:
        if (com.larus.utils.o0.d(r7) == false) goto L46;
        String r12 = UUID.randomUUID().toString();
        com.larus.bmhome.chat.trace.z.a.d(r12);
        ChatFragment r8 = r21.getFragment();
        if ((r8 instanceof ChatFragment) == false) goto L20;
        ChatFragment r9 = r8;
    L21:
        if (r9 == null) goto L46;
        String r10 = r9.getConversationId();
        if (r10 == null) goto L46;
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new CommandWidget$handleUserSendMsg$1$1(r10, null), 3, null);
        FLogger.a.i("CommandWidget", "sendTextByUserMessageSenderComponent");
        Map r11 = H6(r22);
        r11.put("action_bar_command_id", String.valueOf(r22.a));
        com.larus.bmhome.instruction.g r13 = r21.i;
        if (r13 == null) goto L29;
        Map<String, String> r14 = r13.nK(null);
        if (r14 == null) goto L29;
        r11.putAll(r14);
    L29:
        com.larus.bmhome.instruction.g r15 = r21.i;
        if (r15 == null) goto L32;
        int r16 = r15.Q1();
    L34:
        if (r16 != 21) goto L36;
        String r17 = "deep_research_sug";
    L37:
        String r18 = r17;
        if (r7 == null) goto L46;
        RepoDispatcher.a.getClass();
        ChatSender r19 = RepoDispatcher.d.e;
        Fragment r20 = r21.o;
        if (r20 == null) goto L44;
        t1a.b r24 = s1a.a.g(r20);
        if (r24 == null) goto L44;
        r4 = (ChatPageContext) r24.a(ChatPageContext.class);
    L44:
        com.larus.bmhome.chat.model.repo.u1.a.f(r19, r7, r10, r18, r11, null, null, r12, false, null, "CommandWidget", null, r4, null, false, 27496);
        goto L46
    L36:
        r17 = "chat_action_bar";
        goto L37
    L32:
        r16 = 0;
        goto L34
    L20:
        r9 = null;
    L46:
        if (Intrinsics.areEqual(r22.j, Boolean.TRUE) == true) goto L50;
        com.larus.bmhome.instruction.g r1 = r21.i;
        if (r1 == null) goto L50;
        r1.A1();
    L50:
        ICoreInputAbility r0 = r21.j;
        if (r0 == null) goto L54;
        ICoreInputAbility.b.a(r0, 2);
    L54:
        return Unit.INSTANCE;
    L14:
        r7 = null;
        goto L16
    L8:
        r5 = null;
        goto L9
    }
}
