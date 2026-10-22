package com.larus.common.venue.impl.venue.component;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.Observer;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.bytedance.router.SmartRouter;
import com.google.gson.Gson;
import com.larus.bmhome.actionbar.model.g1;
import com.larus.bmhome.actionbar.model.h1;
import com.larus.bmhome.actionbar.model.z0;
import com.larus.bmhome.chat.actionbar.IActionBarService;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.component.bottom.core.z8;
import com.larus.common.venue.api.AssistantStage;
import com.larus.common.venue.impl.venue.FlowCommonVenueDataCache;
import com.larus.common.venue.impl.venue.api.JumpSomewherePocket;
import com.larus.common.venue.impl.venue.api.KeyboardInputPocket;
import com.larus.common.venue.impl.venue.api.Pocket;
import com.larus.common_ui.dialog.l0;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.im.bean.message.NestedFileContent;
import com.larus.platform.api.e4;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.c1;
import com.larus.platform.spi.IAIChatUgcAIGCService;
import com.larus.ui.arch.component.external.api.provider.EmptyComponent;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.lynx.tasm.LynxEnv;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import tx9.l3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000¢\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 ´\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0002´\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010_\u001a\u00020`H\u0016J\u0016\u0010a\u001a\u00020`2\f\u0010b\u001a\b\u0012\u0004\u0012\u00020d0cH\u0002J\b\u0010e\u001a\u00020`H\u0016J\u0016\u0010f\u001a\u0010\u0012\u0004\u0012\u00020H\u0012\u0006\u0012\u0004\u0018\u00010S0RH\u0002J\b\u0010g\u001a\u00020`H\u0016J\b\u0010h\u001a\u00020HH\u0002J\u0018\u0010i\u001a\u00020`2\u0006\u0010j\u001a\u00020U2\u0006\u0010k\u001a\u00020HH\u0002J(\u0010l\u001a\u00020H2\u0016\u0010m\u001a\u0012\u0012\u0004\u0012\u00020H\u0012\u0006\u0012\u0004\u0018\u00010S\u0018\u00010R2\u0006\u0010n\u001a\u00020oH\u0002J \u0010p\u001a\u00020E2\u0016\u0010q\u001a\u0012\u0012\u0004\u0012\u00020H\u0012\u0006\u0012\u0004\u0018\u00010S\u0018\u00010RH\u0002J\u0010\u0010r\u001a\u00020`2\u0006\u0010j\u001a\u00020UH\u0002J\u0010\u0010s\u001a\u00020`2\u0006\u0010t\u001a\u00020UH\u0016J\b\u0010u\u001a\u00020`H\u0002J\b\u0010v\u001a\u00020`H\u0002J\b\u0010w\u001a\u00020xH\u0002J\b\u0010y\u001a\u00020`H\u0002J\u0010\u0010z\u001a\u00020`2\u0006\u0010t\u001a\u00020UH\u0002J\b\u0010{\u001a\u00020`H\u0016J=\u0010|\u001a\u00020`2\u0006\u0010}\u001a\u00020~2\u0014\u0010\u007f\u001a\u0010\u0012\u0004\u0012\u00020H\u0012\u0006\u0012\u0004\u0018\u00010S0R2\u0015\u0010\u0080\u0001\u001a\u0010\u0012\u0004\u0012\u00020H\u0012\u0006\u0012\u0004\u0018\u00010S0RH\u0002J)\u0010\u0081\u0001\u001a\u00020`2\b\u0010\u0082\u0001\u001a\u00030\u0083\u00012\b\u0010\u0084\u0001\u001a\u00030\u0083\u00012\n\u0010\u0085\u0001\u001a\u0005\u0018\u00010\u0086\u0001H\u0016J\u0012\u0010\u0087\u0001\u001a\u00020`2\u0007\u0010\u0088\u0001\u001a\u00020HH\u0002J>\u0010\u0089\u0001\u001a\u00020`2\u0006\u0010}\u001a\u00020~2\u0014\u0010\u007f\u001a\u0010\u0012\u0004\u0012\u00020H\u0012\u0006\u0012\u0004\u0018\u00010S0R2\u0015\u0010\u0080\u0001\u001a\u0010\u0012\u0004\u0012\u00020H\u0012\u0006\u0012\u0004\u0018\u00010S0RH\u0002J\u001f\u0010\u008a\u0001\u001a\u00020`2\u0014\u0010\u008b\u0001\u001a\u000f\u0012\u0004\u0012\u00020H\u0012\u0005\u0012\u00030\u008c\u00010RH\u0002J\u0016\u0010\u008d\u0001\u001a\u0005\u0018\u00010\u008e\u00012\b\u0010\u008f\u0001\u001a\u00030\u0083\u0001H\u0002JI\u0010\u0090\u0001\u001a\u00020`2\u0006\u0010}\u001a\u00020~2\u0014\u0010\u007f\u001a\u0010\u0012\u0004\u0012\u00020H\u0012\u0006\u0012\u0004\u0018\u00010S0R2\u0015\u0010\u0080\u0001\u001a\u0010\u0012\u0004\u0012\u00020H\u0012\u0006\u0012\u0004\u0018\u00010S0R2\t\b\u0002\u0010\u0091\u0001\u001a\u00020EH\u0002JI\u0010\u0092\u0001\u001a\u00020`2\u0006\u0010}\u001a\u00020~2\u0014\u0010\u007f\u001a\u0010\u0012\u0004\u0012\u00020H\u0012\u0006\u0012\u0004\u0018\u00010S0R2\u0015\u0010\u0080\u0001\u001a\u0010\u0012\u0004\u0012\u00020H\u0012\u0006\u0012\u0004\u0018\u00010S0R2\t\b\u0002\u0010\u0091\u0001\u001a\u00020EH\u0002JI\u0010\u0093\u0001\u001a\u00020`2\u0006\u0010}\u001a\u00020~2\u0014\u0010\u007f\u001a\u0010\u0012\u0004\u0012\u00020H\u0012\u0006\u0012\u0004\u0018\u00010S0R2\u0015\u0010\u0080\u0001\u001a\u0010\u0012\u0004\u0012\u00020H\u0012\u0006\u0012\u0004\u0018\u00010S0R2\t\b\u0002\u0010\u0091\u0001\u001a\u00020EH\u0002JA\u0010\u0094\u0001\u001a\u00020`2\u0014\u0010\u007f\u001a\u0010\u0012\u0004\u0012\u00020H\u0012\u0006\u0012\u0004\u0018\u00010S0R2\u0015\u0010\u0080\u0001\u001a\u0010\u0012\u0004\u0012\u00020H\u0012\u0006\u0012\u0004\u0018\u00010S0R2\t\b\u0002\u0010\u0091\u0001\u001a\u00020EH\u0002JC\u0010\u0095\u0001\u001a\u00020`2\n\u0010\u0096\u0001\u001a\u0005\u0018\u00010\u0097\u00012\u0015\u0010\u0085\u0001\u001a\u0010\u0012\u0004\u0012\u00020H\u0012\u0006\u0012\u0004\u0018\u00010S0R2\u0015\u0010\u0080\u0001\u001a\u0010\u0012\u0004\u0012\u00020H\u0012\u0006\u0012\u0004\u0018\u00010S0RH\u0016J\u0015\u0010\u0098\u0001\u001a\u00020`2\n\u0010\u0096\u0001\u001a\u0005\u0018\u00010\u0097\u0001H\u0016J\u000b\u0010\u0099\u0001\u001a\u0004\u0018\u00010NH\u0016J\f\u0010\u009a\u0001\u001a\u0005\u0018\u00010\u009b\u0001H\u0016J\t\u0010\u009c\u0001\u001a\u00020`H\u0016J\u0012\u0010\u009d\u0001\u001a\u00020`2\u0007\u0010\u009e\u0001\u001a\u00020NH\u0002J\u0012\u0010\u009f\u0001\u001a\u00020`2\u0007\u0010\u009e\u0001\u001a\u00020NH\u0002J\u0011\u0010 \u0001\u001a\u00020`2\u0006\u0010}\u001a\u00020NH\u0002J\u000b\u0010¡\u0001\u001a\u0004\u0018\u00010NH\u0002J\u000b\u0010¢\u0001\u001a\u0004\u0018\u00010NH\u0002J\u000b\u0010£\u0001\u001a\u0004\u0018\u00010NH\u0002J\t\u0010¤\u0001\u001a\u00020`H\u0002J\t\u0010¥\u0001\u001a\u00020`H\u0002J\t\u0010¦\u0001\u001a\u00020`H\u0002J\u000b\u0010§\u0001\u001a\u0004\u0018\u00010HH\u0002J\u000b\u0010¨\u0001\u001a\u0004\u0018\u00010HH\u0002J\u000b\u0010©\u0001\u001a\u0004\u0018\u00010HH\u0002J\u0014\u0010ª\u0001\u001a\u00020`2\t\u0010«\u0001\u001a\u0004\u0018\u00010HH\u0002J\u001e\u0010¬\u0001\u001a\u0005\u0018\u00010\u00ad\u00012\n\u0010®\u0001\u001a\u0005\u0018\u00010\u0083\u0001H\u0002¢\u0006\u0003\u0010¯\u0001J\u001e\u0010°\u0001\u001a\u0005\u0018\u00010\u00ad\u00012\n\u0010®\u0001\u001a\u0005\u0018\u00010\u0083\u0001H\u0002¢\u0006\u0003\u0010¯\u0001J\u000b\u0010±\u0001\u001a\u0004\u0018\u00010HH\u0016J\n\u0010²\u0001\u001a\u00030\u0083\u0001H\u0002J\u0015\u0010³\u0001\u001a\u00020`2\n\u0010\u0085\u0001\u001a\u0005\u0018\u00010\u0086\u0001H\u0016R\u001d\u0010\u0006\u001a\u0004\u0018\u00010\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001d\u0010\f\u001a\u0004\u0018\u00010\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0011\u001a\u0004\u0018\u00010\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0013\u0010\u0014R\u001d\u0010\u0016\u001a\u0004\u0018\u00010\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u0018\u0010\u0019R\u001d\u0010\u001b\u001a\u0004\u0018\u00010\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u000b\u001a\u0004\b\u001d\u0010\u001eR\u001d\u0010 \u001a\u0004\u0018\u00010!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\u000b\u001a\u0004\b\"\u0010#R\u001d\u0010%\u001a\u0004\u0018\u00010&8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010\u000b\u001a\u0004\b'\u0010(R\u001d\u0010*\u001a\u0004\u0018\u00010+8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010\u000b\u001a\u0004\b,\u0010-R\u001b\u0010/\u001a\u0002008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b3\u0010\u000b\u001a\u0004\b1\u00102R\u0010\u00104\u001a\u0004\u0018\u000105X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u00106\u001a\u0002078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b:\u0010\u000b\u001a\u0004\b8\u00109R\u0010\u0010;\u001a\u0004\u0018\u00010<X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010=\u001a\u0004\u0018\u00010>X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010?\u001a\u0004\u0018\u00010@8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bC\u0010\u000b\u001a\u0004\bA\u0010BR\u0012\u0010D\u001a\u0004\u0018\u00010EX\u0082\u000e¢\u0006\u0004\n\u0002\u0010FR\u0010\u0010G\u001a\u0004\u0018\u00010HX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020JX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010K\u001a\u00020JX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010L\u001a\u00020JX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010M\u001a\u0004\u0018\u00010NX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010O\u001a\u0004\u0018\u00010NX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010P\u001a\u0004\u0018\u00010NX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010Q\u001a\u0012\u0012\u0004\u0012\u00020H\u0012\u0006\u0012\u0004\u0018\u00010S\u0018\u00010RX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010T\u001a\u0004\u0018\u00010UX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010V\u001a\u00020W8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bZ\u0010\u000b\u001a\u0004\bX\u0010YR\u000e\u0010[\u001a\u00020\\X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010]\u001a\u00020^X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006µ\u0001"}, d2 = {"Lcom/larus/common/venue/impl/venue/component/FlowCommonVenueLynxComponent;", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "Lcom/larus/common/venue/impl/venue/ability/FlowCommonVenueLynxAbility;", "Lcom/larus/common/venue/impl/venue/OnMainVenueBridgeListener;", "<init>", "()V", "flowCommonVenueInputAbility", "Lcom/larus/common/venue/impl/venue/ability/FlowCommonVenueInputAbility;", "getFlowCommonVenueInputAbility", "()Lcom/larus/common/venue/impl/venue/ability/FlowCommonVenueInputAbility;", "flowCommonVenueInputAbility$delegate", "Lkotlin/Lazy;", "argumentData", "Lcom/larus/common/venue/impl/venue/launcher/FlowCommonVenueArgumentData;", "getArgumentData", "()Lcom/larus/common/venue/impl/venue/launcher/FlowCommonVenueArgumentData;", "argumentData$delegate", "coreInputAbility", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "getCoreInputAbility", "()Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "coreInputAbility$delegate", "chatInputUICoreAbility", "Lcom/larus/bmhome/ability/IChatInputUICoreAbility;", "getChatInputUICoreAbility", "()Lcom/larus/bmhome/ability/IChatInputUICoreAbility;", "chatInputUICoreAbility$delegate", "instructionAbility", "Lcom/larus/bmhome/instruction/IInstructionLogicAbility;", "getInstructionAbility", "()Lcom/larus/bmhome/instruction/IInstructionLogicAbility;", "instructionAbility$delegate", "instructionInputAbility", "Lcom/larus/bmhome/instruction/IInstructionInputAbility;", "getInstructionInputAbility", "()Lcom/larus/bmhome/instruction/IInstructionInputAbility;", "instructionInputAbility$delegate", "multiAttachmentSelectorAbility", "Lcom/larus/uaigc/bean/createpage/component/mediacontainer/IMultiAttachmentSelectorAbility;", "getMultiAttachmentSelectorAbility", "()Lcom/larus/uaigc/bean/createpage/component/mediacontainer/IMultiAttachmentSelectorAbility;", "multiAttachmentSelectorAbility$delegate", "reportAbility", "Lcom/larus/common/venue/impl/venue/ability/FlowCommonVenueReportAbility;", "getReportAbility", "()Lcom/larus/common/venue/impl/venue/ability/FlowCommonVenueReportAbility;", "reportAbility$delegate", "instructionEditorViewModel", "Lcom/larus/bmhome/view/actionbar/edit/IInstructionEditorViewModel;", "getInstructionEditorViewModel", "()Lcom/larus/bmhome/view/actionbar/edit/IInstructionEditorViewModel;", "instructionEditorViewModel$delegate", "lynxView", "Lcom/larus/platform/api/IvyPluginView;", "gson", "Lcom/google/gson/Gson;", "getGson", "()Lcom/google/gson/Gson;", "gson$delegate", "aiBeautifyPickPhotoHelper", "Lcom/larus/bmhome/instruction/helper/IAiBeautifyPickPhotoHelper;", "multiAttachmentSelectorController", "Lcom/larus/bmhome/instruction/IMultiAttachmentSelectorController;", "coreInputManager", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputManager;", "getCoreInputManager", "()Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputManager;", "coreInputManager$delegate", "lynxViewLoadResult", "", "Ljava/lang/Boolean;", "lynxViewLoadErrorMsg", "", "onLoadStartTimeMs", "", "nativeFirstFrameTimeMs", "lynxFirstFrameTimeMs", "currClickPocketInfo", "Lcom/larus/common/venue/impl/venue/component/ClickPocketInfo;", "albumClickPocketInfo", "avatarPendingPocketInf", "getPocketPageDataResponseDict", "", "", "rootView", "Landroid/view/View;", "loadingDialog", "Lcom/larus/common_ui/dialog/CommonLoadDialog;", "getLoadingDialog", "()Lcom/larus/common_ui/dialog/CommonLoadDialog;", "loadingDialog$delegate", "mainThreadHandler", "Landroid/os/Handler;", "showLoadingRunnable", "Ljava/lang/Runnable;", "onAttach", "", "onAlbumSelected", "uriList", "", "Landroid/net/Uri;", "onCreate", "getTraceInfo", "onResume", "getActualUrl", "initLynxView", "containerView", "pageData", "generateLynxPageDataJson", "pocketResponseDict", "stage", "Lcom/larus/common/venue/api/AssistantStage;", "isPocketPageDataInValid", "pocketResponseCacheDict", "initLynx", "onViewCreated", "view", "showLoadingByDelay", "blockAndHideLoading", "createIvyPluginViewLifeCycle", "Lcom/larus/platform/api/IvyPluginViewLifeCycle;", "registerObservers", "setGradientBackground", "onDestroy", "pocketJumpSomeWhere", "pocket", "Lcom/larus/common/venue/impl/venue/api/Pocket;", "originData", "extra", "handleOnActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "handleOpenSchema", "jumpSchemaUrl", "pocketUploadInput", "updateCoreInputByAttachmentsStatus", "statusMap", "Lcom/larus/uaigc/bean/createpage/component/mediacontainer/MultiMediaSelectorStatus;", "createMultiAttachmentSelectorActionBarInstructionItem", "Lcom/larus/bmhome/actionbar/model/ActionBarInstructionItem;", "maxNum", "pocketKeyboardInput", "isFromAvatarResult", "pocketSendMsg", "sendMessageWithPocket", "executeApplyPocket", "onApplyPocket", "ownerActivity", "Landroid/app/Activity;", "onPopNativePage", "getCurrentClickPocketInfo", "getCurrentNestedFileContent", "Lcom/larus/im/bean/message/NestedFileContent;", "clearCurrentClickPocketInfo", "setCurrClickPocket", "clickPocket", "setAlbumClickPocketInfo", "setAvatarPendingPocketInfo", "getCurrClickPocketInfo", "getAlbumClickPocketInfo", "getAvatarPendingPocketInfo", "clearCurrClickPocketInfo", "clearAlbumClickPocketInfo", "clearAvatarPendingPocketInfo", "getPocketPageDataIconUrl", "getPageInputPlaceholder", "getPageInputTintColor", "applyInputTintColor", "colorValue", "buildInputCursorDrawable", "Landroid/graphics/drawable/Drawable;", "tintColor", "(Ljava/lang/Integer;)Landroid/graphics/drawable/Drawable;", "buildActionSendDrawable", "getCommonVenuePageScene", "getInputBoxShowSetting", "onUploadDigitalAvatarResult", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FlowCommonVenueLynxComponent extends BaseContentWidget implements v09.b, com.larus.common.venue.impl.venue.i {
    public static final /* synthetic */ int K = 0;
    public String A;
    public long B;
    public long C;
    public long D;
    public ClickPocketInfo E;
    public Map<String, ? extends Object> F;
    public View G;
    public final Lazy H;
    public final Handler I;
    public final s J;
    public final Lazy m;
    public final Lazy n;
    public final Lazy o;
    public final Lazy p;
    public final Lazy q;
    public final Lazy r;
    public final Lazy s;
    public final Lazy t;
    public final Lazy u;
    public e4 v;
    public final Lazy w;
    public com.larus.bmhome.instruction.helper.f x;
    public final Lazy y;
    public Boolean z;

    public static final class a {
    }

    public static final class b implements Observer, FunctionAdapter {
        public final /* synthetic */ Function1 a;

        public b(z r2) {
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

    public static final class c implements Function0<v09.a> {
        public final /* synthetic */ AttachReceiver a;

        public c(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(v09.a.class));
        }
    }

    public static final class d implements Function0<ICoreInputAbility> {
        public final /* synthetic */ AttachReceiver a;

        public d(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(ICoreInputAbility.class));
        }
    }

    public static final class e implements Function0<va8.o> {
        public final /* synthetic */ AttachReceiver a;

        public e(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(va8.o.class));
        }
    }

    public static final class f implements Function0<com.larus.bmhome.instruction.h> {
        public final /* synthetic */ AttachReceiver a;

        public f(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(com.larus.bmhome.instruction.h.class));
        }
    }

    public static final class g implements Function0<com.larus.bmhome.instruction.g> {
        public final /* synthetic */ AttachReceiver a;

        public g(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(com.larus.bmhome.instruction.g.class));
        }
    }

    public static final class h implements Function0<ry9.h> {
        public final /* synthetic */ AttachReceiver a;

        public h(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(ry9.h.class));
        }
    }

    public static final class i implements Function0<v09.c> {
        public final /* synthetic */ AttachReceiver a;

        public i(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(v09.c.class));
        }
    }

    public static final class j implements Function0<x09.a> {
        public final /* synthetic */ AttachReceiver a;

        public j(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).g(Reflection.getOrCreateKotlinClass(x09.a.class));
        }
    }

    static {
    }

    @Override // v09.b
    public final NestedFileContent T() {
        return null;
    }

    public final void z3() {
        this.E = null;
        v09.c r0 = Q3();
        if (r0 == null) goto L5;
        r0.Gr();
    L5:
        FLogger.a.i("FlowCommonVenueComponent", "[clearCurrClickPocketInfo] finish, currClickPocketInfo = null");
    }

    public final x09.a C3() {
        return (x09.a) this.n.getValue();
    }

    public final va8.o D3() {
        return (va8.o) this.p.getValue();
    }

    public final ICoreInputAbility E3() {
        return (ICoreInputAbility) this.o.getValue();
    }

    public final v09.a G3() {
        return (v09.a) this.m.getValue();
    }

    public final com.larus.bmhome.view.actionbar.edit.c H3() {
        return (com.larus.bmhome.view.actionbar.edit.c) this.u.getValue();
    }

    public final v09.c Q3() {
        return (v09.c) this.t.getValue();
    }

    @Override // v09.b
    public final String nd() {
        Map<String, ? extends Object> r0 = this.F;
        if (r0 == null) goto L5;
        Object r1 = r0.get("pocket_page_data");
    L7:
        if ((r1 instanceof Map) == false) goto L9;
        Map r2 = (Map) r1;
    L10:
        if (r2 != null) goto L12;
        return null;
    L12:
        Object r3 = r2.get("page_scene");
        if ((r3 instanceof String) == true) goto L15;
        return null;
    L15:
        return (String) r3;
    L9:
        r2 = null;
        goto L10
    L5:
        r1 = null;
        goto L7
    }

    public final void onDestroy() {
        CopyOnWriteArrayList<com.larus.common.venue.impl.venue.i> r0 = com.larus.common.venue.impl.venue.a.a;
        Intrinsics.checkNotNullParameter(this, "listener");
        CopyOnWriteArrayList<com.larus.common.venue.impl.venue.i> r1 = com.larus.common.venue.impl.venue.a.a;
        if (r1.contains(this) == false) goto L5;
        FlowCommonVenueLynxComponent r2 = this;
    L6:
        if (r2 == null) goto L8;
        r1.remove(r2);
    L8:
        com.larus.bmhome.instruction.g r3 = vc();
        if (r3 == null) goto L11;
        r3.xy();
    L11:
        com.larus.bmhome.instruction.g r4 = vc();
        if (r4 == null) goto L14;
        r4.ls();
    L14:
        com.larus.bmhome.instruction.helper.f r5 = this.x;
        if (r5 == null) goto L17;
        r5.onDestroy();
    L17:
        e4 r6 = this.v;
        if (r6 == null) goto L20;
        r6.destroy();
    L20:
        this.v = null;
        CopyOnWriteArrayList<com.larus.common.venue.impl.venue.h> r7 = com.larus.common.venue.impl.venue.f.a;
        com.larus.common.venue.impl.venue.f.a.clear();
        LynxEnv.inst().addBehavior(com.larus.common.venue.impl.venue.f.c);
        this.I.removeCallbacksAndMessages(null);
        return;
    L5:
        r2 = null;
        goto L6
    }

    public final void onResume() {
        FLogger.a.i("FlowCommonVenueComponent", "[onResume] timeMs: " + System.currentTimeMillis());
    }

    public final com.larus.bmhome.instruction.g vc() {
        return (com.larus.bmhome.instruction.g) this.r.getValue();
    }

    public final void y2() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, v09.b.class);
        IAIChatUgcAIGCService.Companion r1 = IAIChatUgcAIGCService.a;
        Intrinsics.checkNotNullParameter(this, "<this>");
        com.larus.bmhome.instruction.helper.f r0 = r1.H0(com.larus.ui.arch.component.internal.attach.a.b(this, this));
        r0.b(new u(this));
        r0.c(new v(this));
        this.x = r0;
    }

    /* JADX WARN: Type inference failed for: r0v26, types: [com.larus.common.venue.impl.venue.component.s] */
    public FlowCommonVenueLynxComponent() {
        this.m = LazyKt.lazy(new c(this));
        this.n = LazyKt.lazy(new j(this));
        this.o = LazyKt.lazy(new d(this));
        this.p = LazyKt.lazy(new e(this));
        this.q = LazyKt.lazy(new f(this));
        this.r = LazyKt.lazy(new g(this));
        this.s = LazyKt.lazy(new h(this));
        this.t = LazyKt.lazy(new i(this));
        this.u = LazyKt.lazy(new o(this));
        this.w = LazyKt.lazy(new p());
        this.y = LazyKt.lazy(new q(this));
        this.B = -1;
        this.C = -1;
        this.D = -1;
        this.H = LazyKt.lazy(new r(this));
        this.I = new Handler(Looper.getMainLooper());
        this.J = new s(this);
    }

    public final Map<String, Object> V3() {
        x09.a r0 = C3();
        long r2 = -1;
        if (r0 == null) goto L11;
        Bundle r1 = r0.a;
        if (r1 == null) goto L7;
        long r4 = r1.getLong("click_action_bar_time");
    L8:
        Long r3 = Long.valueOf(r4);
        if (r3 == null) goto L11;
        long r5 = r3.longValue();
    L12:
        x09.a r6 = C3();
        if (r6 == null) goto L21;
        Bundle r7 = r6.a;
        if (r7 == null) goto L17;
        long r8 = r7.getLong("schema_handle_time");
    L18:
        Long r9 = Long.valueOf(r8);
        if (r9 == null) goto L21;
        r2 = r9.longValue();
        goto L21
    L17:
        r8 = -1;
    L21:
        Pair[] r10 = new Pair[7];
        x09.a r11 = C3();
        String r12 = null;
        if (r11 == null) goto L24;
        String r13 = r11.c();
    L25:
        r10[0] = TuplesKt.to(DoraObricDeviceHomeViewModel.PARAM_ENTER_METHOD, r13);
        r10[1] = TuplesKt.to("current_page", "common_venue");
        x09.a r14 = C3();
        if (r14 == null) goto L28;
        String r15 = r14.a();
    L29:
        r10[2] = TuplesKt.to("action_bar_key", r15);
        r10[3] = TuplesKt.to("click_action_bar_time", Long.valueOf(r5));
        r10[4] = TuplesKt.to("schema_handle_time", Long.valueOf(r2));
        r10[5] = TuplesKt.to("is_aweme_auth", Boolean.valueOf(AccountService.a.I()));
        x09.a r16 = C3();
        if (r16 == null) goto L34;
        Bundle r17 = r16.a;
        if (r17 == null) goto L34;
        r12 = r17.getString("enter_url");
    L34:
        r10[6] = TuplesKt.to("enter_url", r12);
        return MapsKt.mapOf(r10);
    L28:
        r15 = null;
        goto L29
    L24:
        r13 = null;
        goto L25
    L7:
        r4 = -1;
    L11:
        r5 = -1;
        goto L12
    }

    public final void onCreate() {
        super/*com.larus.ui.arch.component.external.delegate.BaseComponentWidget*/.onCreate();
        FLogger.a.i("FlowCommonVenueComponent", "[onCreate] timeMs: " + System.currentTimeMillis());
        CopyOnWriteArrayList<com.larus.common.venue.impl.venue.i> r0 = com.larus.common.venue.impl.venue.a.a;
        Intrinsics.checkNotNullParameter(this, "listener");
        CopyOnWriteArrayList<com.larus.common.venue.impl.venue.i> r1 = com.larus.common.venue.impl.venue.a.a;
        if ((!r1.contains(this)) == false) goto L5;
        FlowCommonVenueLynxComponent r2 = this;
    L6:
        if (r2 == null) goto L8;
        r1.add(r2);
    L8:
        CopyOnWriteArrayList<com.larus.common.venue.impl.venue.h> r3 = com.larus.common.venue.impl.venue.f.a;
        com.larus.common.venue.impl.venue.h r4 = new AnonymousClass1(this);
        Intrinsics.checkNotNullParameter(r4, "onInputVisibleChangeListener");
        com.larus.common.venue.impl.venue.f.a.add(r4);
        LynxEnv.inst().addBehavior(com.larus.common.venue.impl.venue.f.b);
        return;
    L5:
        r2 = null;
        goto L6
    }

    @Override // v09.b
    public final void K9() {
        z3();
    }

    @Override // v09.b
    public final ClickPocketInfo Ka() {
        return this.E;
    }

    public static final void Y2(FlowCommonVenueLynxComponent r4) {
        r4.getClass();
        FLogger.a.i("FlowCommonVenueComponent", "[blockAndHideLoading] start");
        r4.I.removeCallbacks(r4.J);
        l0 r5 = (l0) r4.H.getValue();
        Handler r0 = DialogLancet.resolveDialogHandler(r5);
        if (r0 != null) goto L5;
    L7:
        DialogLancet.beforeDialogDismiss(r5);
        r5.dismiss();     // Catch: Throwable -> L10 Exception -> L12
    L16:
        DialogLancet.afterDialogDismiss(r5);
    L17:
        FLogger.a.i("FlowCommonVenueComponent", "[blockAndHideLoading] end");
        return;
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
        if (r1 == null) goto L16;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r5);
        throw th;
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L7;
        r0.post(DialogLancet.createDismissRunnable(r5));
        goto L17
    }

    public final void W3(ClickPocketInfo r3) {
        this.E = r3;
        v09.c r4 = Q3();
        if (r4 == null) goto L5;
        r4.Gr();
    L5:
        FLogger.a.i("FlowCommonVenueComponent", "[setCurrClickPocket] finish, currClickPocketInfo = " + this.E);
    }

    public final void onViewCreated(View r110) {
        Intrinsics.checkNotNullParameter(r110, "view");
        this.G = r110;
        x09.a r0 = C3();
        if (r0 == null) goto L16;
        ArrayList r4 = new ArrayList();
        Bundle r5 = r0.a;
        if (r5 == null) goto L7;
        String r6 = r5.getString("linear_bg");
    L53:
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L14
        if (r6 == null) goto L11;
        Boolean r1 = Boolean.valueOf(r4.addAll(r0.d(r6)));     // Catch: Throwable -> L14
    L12:
        Result.constructor-impl(r1);     // Catch: Throwable -> L14
        List r8 = r4;
    L18:
        if (r8.isEmpty() == true) goto L31;
        int r9 = 0;
        if (r8.size() < 2) goto L30;
        ArrayList r2 = new ArrayList();
        ArrayList r10 = new ArrayList();
        Iterator r11 = r8.iterator();
    L24:
        if (r11.hasNext() == false) goto L29;
        Object r12 = r11.next();
        int r13 = r9 + 1;
        if (r9 >= 0) goto L28;
        CollectionsKt.throwIndexOverflow();
    L28:
        x09.d r14 = (x09.d) r12;
        r2.add(Integer.valueOf(ColorProtector.parseColor(r14.a)));
        r10.add(Float.valueOf(r14.b));
        r9 = r13;
        goto L24
    L29:
        LinearGradient r15 = new LinearGradient(0.0f, 0.0f, UIUtils.getScreenWidth(s1a.a.getActivity(this)), UIUtils.getScreenHeight(s1a.a.getActivity(this)), CollectionsKt.toIntArray(r2), CollectionsKt.toFloatArray(r10), Shader.TileMode.CLAMP);
        ShapeDrawable r3 = new ShapeDrawable(new RectShape());
        r3.getPaint().setShader(r15);
        r110.setBackground(r3);
        goto L31
    L30:
        r110.setBackgroundColor(ColorProtector.parseColor(((x09.d) ListProtector.get(r8, 0)).a));
    L31:
        this.I.postDelayed(this.J, 1000);
        x09.a r16 = C3();
        if (r16 == null) goto L34;
        Integer r17 = r16.b();
    L35:
        String r18 = B3(FlowCommonVenueDataCache.b(r17), AssistantStage.Init);
        c1 r20 = c1.a;
        if (r20.d() == true) goto L38;
        r20.f();
    L38:
        StringBuilder r21 = new StringBuilder("sslocal://lynxview?url=");
        x09.a r22 = C3();
        if (r22 == null) goto L43;
        Bundle r23 = r22.a;
        if (r23 == null) goto L43;
        String r24 = r23.getString("lynx_template_url");
    L44:
        r21.append(r24);
        r21.append("&loader_name=forest&forest_newly_builtin=1&bdhm_bid=z_activity");
        String r25 = r21.toString();
        Resources r26 = F2().getContext().getResources();
        int r27 = WindowDisplayMetricsOverride.apply(r26, r26.getDisplayMetrics()).widthPixels;
        e4 r28 = r20.g(r110.getContext(), r25 + "&lynx_preset_width=" + r27 + "&lynx_preset_width_spec=" + View.MeasureSpec.makeMeasureSpec(r27, 1073741824), r18, new x(this));
        this.v = r28;
        if (r28 == null) goto L51;
        View r30 = r28.getView();
        if (r30 == null) goto L51;
        ViewGroup r31 = (ViewGroup) r110.findViewById(2131372705);
        if ((r110 instanceof ViewGroup) == false) goto L51;
        r31.removeAllViews();
        r31.addView(r30, new ConstraintLayout.LayoutParams(-1, -1));
    L51:
        FLogger.a.e("FlowCommonVenueComponent", "[initLynx] init lynx by empty pocketPageData");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getMain().getImmediate(), null, new FlowCommonVenueLynxComponent$initLynx$1(r17, this, 1, null), 2, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new FlowCommonVenueLynxComponent$registerObservers$1(this, null), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new FlowCommonVenueLynxComponent$registerObservers$2(this, null), 3, null);
        this.C = System.currentTimeMillis();
        return;
    L43:
        r24 = null;
        goto L44
    L34:
        r17 = null;
        goto L35
    L11:
        r1 = null;
    L14:
        th = move-exception;
        Result.Companion r32 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        r8 = r4;
        goto L18
    L7:
        r6 = null;
        goto L53
    L16:
        r8 = CollectionsKt.emptyList();
        goto L18
    }

    public final String B3(Map<String, ? extends Object> r16, AssistantStage r17) {
        Object r2 = null;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L27
        v09.a r1 = G3();     // Catch: Throwable -> L27
        if (r1 == null) goto L6;
        int r5 = r1.K7();     // Catch: Throwable -> L27
    L8:
        if (r16 != null) goto L10;
        Map<String, ? extends Object> r4 = MapsKt.emptyMap();     // Catch: Throwable -> L27
    L11:
        Map<String, Object> r10 = V3();     // Catch: Throwable -> L27
        x09.a r3 = C3();     // Catch: Throwable -> L27
        if (r3 == null) goto L20;
        Bundle r6 = r3.a;     // Catch: Throwable -> L27
        if (r6 == null) goto L16;
        String r7 = r6.getString("enter_schema");     // Catch: Throwable -> L27
    L17:
        if (r7 == null) goto L20;
        String r11 = r7;
    L21:
        Object r8 = Result.constructor-impl(((Gson) this.w.getValue()).toJson(new LynxPageData(r4, r5, 0, 0, r10, r11, r17.getValue(), 12, null)));     // Catch: Throwable -> L25
    L31:
        if (Result.isFailure-impl(r8) == true) goto L34;
        r2 = r8;
    L34:
        String r9 = (String) r2;
        if (r9 != null) goto L38;
        return "";
    L38:
        return r9;
    L25:
        th = th;
    L29:
        Result.Companion r12 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L31
    L16:
        r7 = null;
    L20:
        r11 = "";
        goto L21
    L10:
        r4 = r16;
        goto L11
    L6:
        r5 = 0;
    L27:
        th = th;
        goto L29
    }

    @Override // v09.b
    public final void r3(int r2, Intent r3) {
        if (r2 != (-1)) goto L21;
        if (r3 == null) goto L7;
        String r4 = r3.getStringExtra("result_from");
        if (r4 == null) goto L7;
    L9:
        if (Intrinsics.areEqual(r4, "creation") == false) goto L22;
        com.larus.bmhome.instruction.g r5 = vc();
        if (r5 == null) goto L17;
        if (r3 == null) goto L15;
        Bundle r6 = r3.getExtras();
        if (r6 == null) goto L15;
    L16:
        r5.Nb(r6);
    L15:
        r6 = new Bundle();
    L17:
        v09.a r7 = G3();
        if (r7 == null) goto L23;
        r7.h6();
        return;
    L23:
        return;
    L22:
        return;
    L7:
        r4 = "";
        goto L9
    }

    @Override // com.larus.common.venue.impl.venue.i
    public final void b(Activity r12, Map<String, ? extends Object> r13, Map<String, ? extends Object> r14) {
        Intrinsics.checkNotNullParameter(r13, "data");
        Intrinsics.checkNotNullParameter(r14, "extra");
        Intrinsics.checkNotNullParameter(this, "<this>");
        if (Intrinsics.areEqual(com.larus.ui.arch.component.internal.attach.a.b(this, this).getActivity(), r12) == false) goto L6;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getMain().getImmediate(), null, new FlowCommonVenueLynxComponent$executeApplyPocket$1(r13, this, r14, false, null), 2, null);
        return;
    }

    public static final void h3(final FlowCommonVenueLynxComponent r17, Pocket r18, Map r110, Map r20) {
        FLogger.a.i("FlowCommonVenueComponent", "[pocketJumpSomeWhere] jumpSomewherePocket = " + r18.getJumpSomewherePocket());
        JumpSomewherePocket r1 = r18.getJumpSomewherePocket();
        int r2 = -1;
        String r3 = "";
        if (r1 == null) goto L51;
        String r5 = r1.getJumpInstructionId();
        Unit r8 = null;
        if (o0.d(r5) == false) goto L28;
        int r6 = l3.e(r5, 0);
        if (r6 <= 0) goto L27;
        com.larus.bmhome.instruction.g r7 = r17.vc();
        if (r7 == null) goto L11;
        r7.A1();
    L11:
        r17.W3(new ClickPocketInfo(r18, r110, r20, null, 8, null));
        z8 r9 = (z8) r17.y.getValue();
        if (r9 == null) goto L14;
        r9.a9(true);
    L14:
        z0 r10 = ((IActionBarService) ServiceManager.get().getService(IActionBarService.class)).e(r6);
        if (r10 == null) goto L50;
        String r4 = r1.getInsertPrompt();
        if (o0.d(r4) == false) goto L19;
        String r11 = r4;
    L20:
        if (r11 == null) goto L24;
        ICoreInputAbility r12 = r17.E3();
        if (r12 == null) goto L24;
        ICoreInputAbility.b.d(r12, r11, false, false, null, null, false, 62);
    L24:
        com.larus.bmhome.instruction.h r13 = (com.larus.bmhome.instruction.h) r17.q.getValue();
        if (r13 == null) goto L50;
        com.larus.bmhome.instruction.h.a.a(r13, r10, 5, new m(r17), 8);
        Unit r14 = Unit.INSTANCE;
    L39:
        r8 = r14;
        goto L50
    L19:
        r11 = null;
    L50:
        if (r8 == null) goto L51;
        return;
    L27:
        r8 = Unit.INSTANCE;
        goto L50
    L28:
        String r15 = r1.getJumpSchemaUrl();
        if (o0.d(r15) == true) goto L32;
        r15 = null;
    L32:
        if (r15 == null) goto L40;
        Bundle r16 = com.larus.utils.f.c(new Pair[]{TuplesKt.to("open_new_chat_page_on_send", Boolean.FALSE)});
        Uri r21 = UriProtector.parse(r15);
        Intrinsics.checkNotNullParameter(r17, "<this>");
        com.bytedance.router.i r22 = SmartRouter.buildRoute(com.larus.ui.arch.component.internal.attach.a.b(r17, r17).getContext(), r21.buildUpon().appendQueryParameter("android_no_clear_top", "1").build().toString());
        r22.c.putExtras(r16);
        r22.e(99323);
        v09.c r23 = r17.Q3();
        if (r23 == null) goto L36;
        r23.j3("enter_new_page");
        r14 = Unit.INSTANCE;
    L37:
        if (r14 != null) goto L39;
    L36:
        r14 = null;
    L40:
        v09.c r24 = r17.Q3();
        if (r24 == null) goto L50;
        String r25 = r18.getPocketId();
        if (r25 != null) goto L45;
        r25 = "";
    L45:
        Integer r26 = r18.getPocketType();
        if (r26 == null) goto L48;
        int r27 = r26.intValue();
    L49:
        r24.W7(r25, 0, r27, "invalid_data");
        r8 = Unit.INSTANCE;
        goto L50
    L48:
        r27 = -1;
    L51:
        v09.c r0 = r17.Q3();
        if (r0 == null) goto L63;
        String r28 = r18.getPocketId();
        if (r28 == null) goto L57;
        r3 = r28;
    L57:
        Integer r30 = r18.getPocketType();
        if (r30 == null) goto L60;
        r2 = r30.intValue();
    L60:
        r0.W7(r3, 0, r2, "invalid_pocket");
        Unit r31 = Unit.INSTANCE;
        return;
    }

    public static final void m3(final FlowCommonVenueLynxComponent r310, Pocket r40, Map r41, Map r42, boolean r43) {
        FLogger.a.i("FlowCommonVenueComponent", "[pocketKeyboardInput] keyboardInputPocket = " + r40.getKeyboardInputPocket());
        KeyboardInputPocket r1 = r40.getKeyboardInputPocket();
        int r2 = -1;
        String r3 = "";
        if (r1 == null) goto L52;
        ClickPocketInfo r4 = r310.E;
        String r5 = null;
        if (r4 == null) goto L9;
        Pocket r6 = r4.getPocket();
        if (r6 == null) goto L9;
        String r7 = r6.getPocketId();
    L10:
        ClickPocketInfo r8 = r310.E;
        if (r8 == null) goto L15;
        Pocket r9 = r8.getPocket();
        if (r9 == null) goto L15;
        Integer r10 = r9.getPocketType();
    L17:
        if (Intrinsics.areEqual(r7, r40.getPocketId()) == false) goto L19;
    L23:
        r310.W3(new ClickPocketInfo(r40, r41, r42, Boolean.valueOf(r43)));
        v09.c r11 = r310.Q3();
        if (r11 == null) goto L32;
        String r12 = r40.getPocketId();
        if (r12 != null) goto L28;
        r12 = "";
    L28:
        Integer r13 = r40.getPocketType();
        if (r13 == null) goto L31;
        r2 = r13.intValue();
    L31:
        r11.W7(r12, 1, r2, "");
    L32:
        z8 r14 = (z8) r310.y.getValue();
        if (r14 == null) goto L35;
        r14.a9(true);
    L35:
        Map<String, ? extends Object> r15 = r310.F;
        if (r15 == null) goto L38;
        Object r16 = r15.get("pocket_page_data");
    L40:
        if ((r16 instanceof Map) == false) goto L42;
        Map r17 = (Map) r16;
    L43:
        if (r17 == null) goto L48;
        Object r18 = r17.get("input_box_background_url");
        if ((r18 instanceof String) == false) goto L48;
        r5 = (String) r18;
    L48:
        String r20 = r5;
        z0 r21 = new z0(null, null, new g1(null, r20, null, null, 29), new g1(null, r20, null, null, 29), r1.getInputBoxTitle(), null, null, null, null, null, new com.larus.bmhome.actionbar.model.r(null, null, new h1(r1.getInputPlaceholder(), null, r1.getInputPlaceholderPrompt(), null, null, 1018), null, null, null, null, null, 4091), null, false, null, null, -65565, 15);
        com.larus.bmhome.instruction.h r22 = (com.larus.bmhome.instruction.h) r310.q.getValue();
        if (r22 == null) goto L51;
        r22.h50(r21, 5, new aq8.e(null, null, null, null, null, true, null, null, null, null, 991), new t(r310));
    L51:
        r310.H3().setActionBarInstructionInputSendReady(true);
        return;
    L42:
        r17 = null;
        goto L43
    L38:
        r16 = null;
        goto L40
    L19:
        if (Intrinsics.areEqual(r10, r40.getPocketType()) == true) goto L23;
        com.larus.bmhome.instruction.g r23 = r310.vc();
        if (r23 == null) goto L23;
        r23.A1();
    L15:
        r10 = null;
    L9:
        r7 = null;
        goto L10
    L52:
        r310.z3();
        v09.c r0 = r310.Q3();
        if (r0 == null) goto L64;
        String r24 = r40.getPocketId();
        if (r24 == null) goto L58;
        r3 = r24;
    L58:
        Integer r25 = r40.getPocketType();
        if (r25 == null) goto L61;
        r2 = r25.intValue();
    L61:
        r0.W7(r3, 0, r2, "invalid_pocket");
        return;
    }

    public static final void p3(FlowCommonVenueLynxComponent r40, Pocket r41, Map r42, Map r43, boolean r44) {
        FLogger.a.i("FlowCommonVenueComponent", "[sendMessageWithPocket] sendMsgPocket = " + r41.getSendMsgPocket());
        v09.c r0 = r40.Q3();
        if (r0 == null) goto L12;
        String r2 = r41.getPocketId();
        if (r2 != null) goto L7;
        r2 = "";
    L7:
        Integer r3 = r41.getPocketType();
        if (r3 == null) goto L10;
        int r4 = r3.intValue();
    L11:
        r0.W7(r2, 1, r4, "");
        goto L12
    L10:
        r4 = -1;
    L12:
        com.larus.bmhome.instruction.g r1 = r40.vc();
        if (r1 == null) goto L15;
        r1.A1();
    L15:
        r40.W3(new ClickPocketInfo(r41, r42, r43, Boolean.valueOf(r44)));
        String r5 = r41.getPromptForModel();
        if (r5 != null) goto L18;
        String r6 = "";
    L19:
        x09.a r7 = r40.C3();
        if (r7 == null) goto L25;
        String r8 = r7.c();
        if (r8 == null) goto L25;
        String r23 = r8;
    L26:
        ICoreInputAbility.OnSendParams r9 = new ICoreInputAbility.OnSendParams(r6, "", null, null, null, null, null, null, 8888, false, null, false, false, false, null, null, null, null, false, r23, null, null, null, null, null, null, null, null, null, null, null, null, null, -524608, 1, null);
        v09.a r10 = r40.G3();
        if (r10 == null) goto L30;
        v09.a.C0144a.a(r10, r9, "common_venue_sug", null, false, 12);
        return;
    L30:
        return;
    L25:
        r23 = "";
        goto L26
    L18:
        r6 = r5;
        goto L19
    }
}
