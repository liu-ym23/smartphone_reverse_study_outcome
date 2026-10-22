package com.obric.assistant.component;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.PathInterpolator;
import android.widget.ImageView;
import android.widget.Space;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larus.bmhome.chat.component.bottom.attachment.g1;
import com.larus.bmhome.chat.component.bottom.bottommenu.f1;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.component.bottom.core.a;
import com.larus.ui.arch.component.external.api.provider.EmptyComponent;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import com.obric.assistant.chat.ObricChatService;
import com.obric.assistant.chat.x;
import com.obric.assistant.chat.y;
import com.obric.assistant.data.ObricFloatChatPageState;
import com.obric.assistant.interaction.api.IAssistantChatWindow;
import com.obric.assistant.interaction.api.IAssistantChatWindowKt;
import com.obric.assistant.spi.interact.ObricInteractDelegate;
import com.obric.assistant.state.api.multitask.ForegroundInteractionPhase;
import com.obric.assistant.state.api.multitask.ObricInteractionProjectionDelegate;
import com.obric.assistant.view.ObricIconSwipeUpView;
import com.obric.assistant.view.continuespeech.AudioGradientView;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import hca.b;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import laa.m;
import laa.n;
import va8.a0;
import va8.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000\u009e\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0007\u0018\u0000 Þ\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0004Þ\u0001ß\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\u0099\u0001\u001a\u00020]H\u0016J\t\u0010\u009a\u0001\u001a\u00020]H\u0002J\u0013\u0010\u009d\u0001\u001a\u00020]2\b\u0010\u009e\u0001\u001a\u00030\u009f\u0001H\u0016J\u0013\u0010 \u0001\u001a\u00020]2\b\u0010\u009e\u0001\u001a\u00030\u009f\u0001H\u0002J\n\u0010¡\u0001\u001a\u00030\u009f\u0001H\u0002J\t\u0010¢\u0001\u001a\u00020]H\u0016J\t\u0010£\u0001\u001a\u00020]H\u0016J\t\u0010¤\u0001\u001a\u00020]H\u0016J\u0013\u0010ª\u0001\u001a\u00020]2\b\u0010«\u0001\u001a\u00030\u009f\u0001H\u0016J\u0013\u0010¬\u0001\u001a\u00020]2\b\u0010«\u0001\u001a\u00030\u009f\u0001H\u0016J\u0013\u0010\u00ad\u0001\u001a\u00020]2\b\u0010«\u0001\u001a\u00030\u009f\u0001H\u0016J\u001d\u0010\u00ad\u0001\u001a\u00020]2\b\u0010«\u0001\u001a\u00030\u009f\u00012\b\u0010®\u0001\u001a\u00030\u009f\u0001H\u0016J4\u0010\u00ad\u0001\u001a\u00020]2\b\u0010«\u0001\u001a\u00030\u009f\u00012\b\u0010®\u0001\u001a\u00030\u009f\u00012\n\u0010¯\u0001\u001a\u0005\u0018\u00010°\u00012\t\u0010±\u0001\u001a\u0004\u0018\u00010`H\u0016J\u001d\u0010²\u0001\u001a\u00020]2\b\u0010«\u0001\u001a\u00030\u009f\u00012\b\u0010³\u0001\u001a\u00030´\u0001H\u0016J\u0013\u0010µ\u0001\u001a\u00020]2\b\u0010³\u0001\u001a\u00030´\u0001H\u0002J\u0013\u0010¶\u0001\u001a\u00020]2\b\u0010³\u0001\u001a\u00030´\u0001H\u0002J\n\u0010·\u0001\u001a\u00030\u009f\u0001H\u0002J\t\u0010¸\u0001\u001a\u00020]H\u0016J\u0017\u0010[\u001a\u00020]2\r\u0010¹\u0001\u001a\b\u0012\u0004\u0012\u00020]0\\H\u0016J\t\u0010º\u0001\u001a\u00020gH\u0002J\t\u0010»\u0001\u001a\u00020gH\u0002J\t\u0010¼\u0001\u001a\u00020gH\u0002J\u0019\u0010½\u0001\u001a\u00020g2\b\u0010¾\u0001\u001a\u00030¿\u0001H\u0016¢\u0006\u0003\u0010À\u0001J\u0013\u0010Á\u0001\u001a\u00020]2\b\u0010Â\u0001\u001a\u00030\u009f\u0001H\u0016J\u0013\u0010Ã\u0001\u001a\u00020]2\b\u0010«\u0001\u001a\u00030\u009f\u0001H\u0016J\u0013\u0010Ä\u0001\u001a\u00020]2\b\u0010Å\u0001\u001a\u00030\u009f\u0001H\u0016J\u001c\u0010Æ\u0001\u001a\u00020]2\u0007\u0010Ç\u0001\u001a\u00020g2\b\u0010È\u0001\u001a\u00030\u009f\u0001H\u0016JX\u0010É\u0001\u001a\u00020]2\u000e\u0010Ê\u0001\u001a\t\u0012\u0004\u0012\u00020D0Ë\u00012\u000e\u0010Ì\u0001\u001a\t\u0012\u0004\u0012\u00020t0Ë\u00012\u000f\u0010Í\u0001\u001a\n\u0012\u0005\u0012\u00030Î\u00010Ë\u00012\b\u0010Ï\u0001\u001a\u00030\u009f\u00012\b\u0010Ð\u0001\u001a\u00030\u009f\u00012\b\u0010Ñ\u0001\u001a\u00030\u009f\u0001H\u0002J\u001f\u0010Ò\u0001\u001a\u00020]2\b\u0010\u009e\u0001\u001a\u00030\u009f\u00012\n\b\u0002\u0010Å\u0001\u001a\u00030\u009f\u0001H\u0002J\f\u0010Ó\u0001\u001a\u0005\u0018\u00010\u008d\u0001H\u0016J\u0013\u0010Ô\u0001\u001a\u00020]2\b\u0010Õ\u0001\u001a\u00030\u009f\u0001H\u0002J\u0012\u0010Ö\u0001\u001a\u00020]2\u0007\u0010×\u0001\u001a\u00020gH\u0016J\r\u0010Ø\u0001\u001a\u00020]*\u00020DH\u0002J\u0019\u0010Ù\u0001\u001a\u00020]2\u0006\u0010c\u001a\u00020`2\u0006\u0010e\u001a\u00020dH\u0002J\u001b\u0010Ú\u0001\u001a\u00020]2\u0007\u0010Û\u0001\u001a\u00020g2\u0007\u0010Ü\u0001\u001a\u00020gH\u0002J\n\u0010m\u001a\u0004\u0018\u00010DH\u0016J\u0012\u0010Ý\u0001\u001a\u00030\u009f\u00012\u0006\u0010e\u001a\u00020dH\u0002R\u001d\u0010\u0006\u001a\u0004\u0018\u00010\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001d\u0010\f\u001a\u0004\u0018\u00010\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0011\u001a\u0004\u0018\u00010\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0013\u0010\u0014R\u001d\u0010\u0016\u001a\u0004\u0018\u00010\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u0018\u0010\u0019R\u001d\u0010\u001b\u001a\u0004\u0018\u00010\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u000b\u001a\u0004\b\u001d\u0010\u001eR\u001d\u0010 \u001a\u0004\u0018\u00010!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\u000b\u001a\u0004\b\"\u0010#R\u001d\u0010%\u001a\u0004\u0018\u00010&8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010\u000b\u001a\u0004\b'\u0010(R\u001d\u0010*\u001a\u0004\u0018\u00010+8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010\u000b\u001a\u0004\b,\u0010-R\u001d\u0010/\u001a\u0004\u0018\u0001008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b3\u0010\u000b\u001a\u0004\b1\u00102R\u001d\u00104\u001a\u0004\u0018\u0001058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b8\u0010\u000b\u001a\u0004\b6\u00107R\u001d\u00109\u001a\u0004\u0018\u00010:8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b=\u0010\u000b\u001a\u0004\b;\u0010<R\u001d\u0010>\u001a\u0004\u0018\u00010?8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bB\u0010\u000b\u001a\u0004\b@\u0010AR\u001d\u0010C\u001a\u0004\u0018\u00010D8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bG\u0010\u000b\u001a\u0004\bE\u0010FR\u0016\u0010H\u001a\u0004\u0018\u00010I8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bJ\u0010KR\u0016\u0010L\u001a\u0004\u0018\u00010?8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bM\u0010AR\u0016\u0010N\u001a\u0004\u0018\u00010?8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bO\u0010AR\u0016\u0010P\u001a\u0004\u0018\u00010D8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bQ\u0010FR\u001d\u0010R\u001a\u0004\u0018\u00010S8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bV\u0010\u000b\u001a\u0004\bT\u0010UR\u0016\u0010W\u001a\u0004\u0018\u00010?8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bX\u0010AR\u0016\u0010Y\u001a\u0004\u0018\u00010D8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bZ\u0010FR\u0016\u0010[\u001a\n\u0012\u0004\u0012\u00020]\u0018\u00010\\X\u0082\u000e¢\u0006\u0002\n\u0000R@\u0010^\u001a4\u0012\u0013\u0012\u00110`¢\u0006\f\ba\u0012\b\bb\u0012\u0004\b\b(c\u0012\u0013\u0012\u00110d¢\u0006\f\ba\u0012\b\bb\u0012\u0004\b\b(e\u0012\u0004\u0012\u00020]\u0018\u00010_X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010f\u001a\u00020gX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010h\u001a\u00020gX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010i\u001a\u00020gX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010j\u001a\u00020gX\u0082D¢\u0006\u0002\n\u0000R\u001b\u0010k\u001a\u00020l8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bo\u0010\u000b\u001a\u0004\bm\u0010nR\u001b\u0010p\u001a\u00020D8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\br\u0010\u000b\u001a\u0004\bq\u0010FR\u001b\u0010s\u001a\u00020t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bw\u0010\u000b\u001a\u0004\bu\u0010vR\u001b\u0010x\u001a\u00020D8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bz\u0010\u000b\u001a\u0004\by\u0010FR\u001b\u0010{\u001a\u00020|8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u007f\u0010\u000b\u001a\u0004\b}\u0010~R\u001e\u0010\u0080\u0001\u001a\u00020|8BX\u0082\u0084\u0002¢\u0006\u000e\n\u0005\b\u0082\u0001\u0010\u000b\u001a\u0005\b\u0081\u0001\u0010~R\u001e\u0010\u0083\u0001\u001a\u00020|8BX\u0082\u0084\u0002¢\u0006\u000e\n\u0005\b\u0085\u0001\u0010\u000b\u001a\u0005\b\u0084\u0001\u0010~R\u001e\u0010\u0086\u0001\u001a\u00020|8BX\u0082\u0084\u0002¢\u0006\u000e\n\u0005\b\u0088\u0001\u0010\u000b\u001a\u0005\b\u0087\u0001\u0010~R\u001e\u0010\u0089\u0001\u001a\u00020|8BX\u0082\u0084\u0002¢\u0006\u000e\n\u0005\b\u008b\u0001\u0010\u000b\u001a\u0005\b\u008a\u0001\u0010~R \u0010\u008c\u0001\u001a\u00030\u008d\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u0090\u0001\u0010\u000b\u001a\u0006\b\u008e\u0001\u0010\u008f\u0001R \u0010\u0091\u0001\u001a\u00030\u0092\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u0095\u0001\u0010\u000b\u001a\u0006\b\u0093\u0001\u0010\u0094\u0001R\u001e\u0010\u0096\u0001\u001a\u00020D8BX\u0082\u0084\u0002¢\u0006\u000e\n\u0005\b\u0098\u0001\u0010\u000b\u001a\u0005\b\u0097\u0001\u0010FR\u0010\u0010\u009b\u0001\u001a\u00030\u009c\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010¥\u0001\u001a\u00030\u009f\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010¦\u0001\u001a\u00030\u009f\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010§\u0001\u001a\u00030\u009f\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010¨\u0001\u001a\u0005\u0018\u00010©\u0001X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006à\u0001"}, d2 = {"Lcom/obric/assistant/component/OrionChatWindowComponent;", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "Lcom/obric/assistant/ability/IOrionChatWindowAbility;", "Lcom/obric/assistant/callback/IChatStyleChangedCallback;", "<init>", "()V", "photoActionAbility", "Lcom/obric/assistant/ability/IObricPhotoActionAbility;", "getPhotoActionAbility", "()Lcom/obric/assistant/ability/IObricPhotoActionAbility;", "photoActionAbility$delegate", "Lkotlin/Lazy;", "chatFragmentAbility", "Lcom/larus/bmhome/ability/IChatFragmentCoreAbility;", "getChatFragmentAbility", "()Lcom/larus/bmhome/ability/IChatFragmentCoreAbility;", "chatFragmentAbility$delegate", "pageStateAbility", "Lcom/obric/assistant/ability/IObricChatPageStateAbility;", "getPageStateAbility", "()Lcom/obric/assistant/ability/IObricChatPageStateAbility;", "pageStateAbility$delegate", "coreInputAbility", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "getCoreInputAbility", "()Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "coreInputAbility$delegate", "chatInputUICoreAbility", "Lcom/larus/bmhome/ability/IChatInputUICoreAbility;", "getChatInputUICoreAbility", "()Lcom/larus/bmhome/ability/IChatInputUICoreAbility;", "chatInputUICoreAbility$delegate", "conversationAbility", "Lcom/larus/bmhome/ability/IConversationCoreAbility;", "getConversationAbility", "()Lcom/larus/bmhome/ability/IConversationCoreAbility;", "conversationAbility$delegate", "attachmentPanelAbility", "Lcom/larus/bmhome/chat/component/bottom/attachment/IAttachmentPanelAbility;", "getAttachmentPanelAbility", "()Lcom/larus/bmhome/chat/component/bottom/attachment/IAttachmentPanelAbility;", "attachmentPanelAbility$delegate", "intercomAbility", "Lcom/obric/assistant/ability/IObricIntercomAbility;", "getIntercomAbility", "()Lcom/obric/assistant/ability/IObricIntercomAbility;", "intercomAbility$delegate", "instructionInputAbility", "Lcom/larus/bmhome/instruction/IInstructionInputAbility;", "getInstructionInputAbility", "()Lcom/larus/bmhome/instruction/IInstructionInputAbility;", "instructionInputAbility$delegate", "bottomMenuAbility", "Lcom/larus/bmhome/chat/component/bottom/bottommenu/IBottomMenuAbility;", "getBottomMenuAbility", "()Lcom/larus/bmhome/chat/component/bottom/bottommenu/IBottomMenuAbility;", "bottomMenuAbility$delegate", "binding", "Lcom/larus/bmhome/ability/IChatCoreBinding;", "getBinding", "()Lcom/larus/bmhome/ability/IChatCoreBinding;", "binding$delegate", "chatRoot", "Landroid/view/ViewGroup;", "getChatRoot", "()Landroid/view/ViewGroup;", "chatRoot$delegate", "input", "Landroid/view/View;", "getInput", "()Landroid/view/View;", "input$delegate", "inputUiContract", "Lcom/larus/bmhome/ability/ChatInputUiContract;", "getInputUiContract", "()Lcom/larus/bmhome/ability/ChatInputUiContract;", "inputArea", "getInputArea", "speakArea", "getSpeakArea", "actionSend", "getActionSend", "bottomLayout", "Landroid/widget/FrameLayout;", "getBottomLayout", "()Landroid/widget/FrameLayout;", "bottomLayout$delegate", "actionBarContainer", "getActionBarContainer", "actionFullScreen", "getActionFullScreen", "onCancel", "Lkotlin/Function0;", "", "onStateChange", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", DBDefinition.NAME, "botId", "Lcom/obric/assistant/state/api/multitask/ForegroundInteractionPhase;", "phase", "minLightAlpha", "", "maxLightAlpha", "minShadowAlpha", "maxShadowAlpha", "lightView", "Lcom/obric/assistant/view/continuespeech/AudioGradientView;", "getLightView", "()Lcom/obric/assistant/view/continuespeech/AudioGradientView;", "lightView$delegate", "lightReferView", "getLightReferView", "lightReferView$delegate", "bgView", "Landroid/widget/ImageView;", "getBgView", "()Landroid/widget/ImageView;", "bgView$delegate", "bgTopView", "getBgTopView", "bgTopView$delegate", "spaceLeft", "Landroid/widget/Space;", "getSpaceLeft", "()Landroid/widget/Space;", "spaceLeft$delegate", "spaceRight", "getSpaceRight", "spaceRight$delegate", "spaceTop", "getSpaceTop", "spaceTop$delegate", "spaceBottom", "getSpaceBottom", "spaceBottom$delegate", "gestureReferView", "getGestureReferView", "gestureReferView$delegate", "gestureView", "Lcom/obric/assistant/view/ObricIconSwipeUpView;", "getGestureView", "()Lcom/obric/assistant/view/ObricIconSwipeUpView;", "gestureView$delegate", "animator", "Landroid/animation/ValueAnimator;", "getAnimator", "()Landroid/animation/ValueAnimator;", "animator$delegate", "interceptView", "getInterceptView", "interceptView$delegate", "onParentViewCreated", "adaptChatRootView", "interactionProjectionObserver", "Lcom/obric/assistant/state/api/multitask/InteractionProjectionObserver;", "onChatStyleChanged", "isChatWindow", "", "updateGestureViewVisibility", "isAiKeyWakeupHolding", "onResume", "onStop", "onDestroy", "speakerVisible", "voiceVisible", "mockSpeakerVisible", "voiceViewAppearAnimator", "Landroid/animation/AnimatorSet;", "onSpeakerVisibilityChanged", "visible", "onMockSpeakerVisibleChanged", "setVoiceViewVisible", "isResumeClickTalk", "listeningUiHandle", "Lcom/obric/assistant/ability/ObricListeningUiHandle;", "startupAttemptId", "setVoiceViewVisibleAnimated", "duration", "", "animateVoiceViewAppear", "animateVoiceViewDisappear", "isSpeakerVisible", "setInputTextListener", "callback", "getShadowViewBaseAlpha", "getLightViewBaseAlpha", "getSpeakerBgViewBaseAlpha", "getBaseAlpha", "id", "", "(I)Ljava/lang/Float;", "onInstructionVisibleChanged", "instructionOpen", "onAttachmentPanelVisibleChanged", "onSpeakerStatusSwitch", "toCancel", "resetChatWindowLightAlpha", "alpha", "half", "setBottomMenuStyle", "areaViews", "", "iconArray", "textViews", "Landroid/widget/TextView;", "useNewStyle", "isImmerse", "isHalf", "updateLightViewAlpha", "getBottomGestureView", "onInputHeightChanged", "panelVisible", "updateBottomMenuProgress", "progress", "removeFromParent", "onStateChanged", "startAnimator", "startValue", "endValue", "isActivatePhase", "Companion", "InterceptView", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OrionChatWindowComponent extends BaseContentWidget implements m, b {
    public static final /* synthetic */ int T = 0;
    public Function0<Unit> A;
    public w5 B;
    public final Lazy C;
    public final Lazy D;
    public final Lazy E;
    public final Lazy F;
    public final Lazy G;
    public final Lazy H;
    public final Lazy I;
    public final Lazy J;
    public final Lazy K;
    public final Lazy L;
    public final Lazy M;
    public final Lazy N;
    public final e5 O;
    public boolean P;
    public boolean Q;
    public boolean R;
    public AnimatorSet S;
    public final Lazy m;
    public final Lazy n;
    public final Lazy o;
    public final Lazy p;
    public final Lazy q;
    public final Lazy r;
    public final Lazy s;
    public final Lazy t;
    public final Lazy u;
    public final Lazy v;
    public final Lazy w;
    public final Lazy x;
    public final Lazy y;
    public final Lazy z;

    public static final class c implements Function0<f1> {
        public final /* synthetic */ AttachReceiver a;

        public c(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(f1.class));
        }
    }

    public static final class d implements Function0<laa.h> {
        public final /* synthetic */ AttachReceiver a;

        public d(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(laa.h.class));
        }
    }

    public static final class e implements Function0<va8.m> {
        public final /* synthetic */ AttachReceiver a;

        public e(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(va8.m.class));
        }
    }

    public static final class f implements Function0<laa.d> {
        public final /* synthetic */ AttachReceiver a;

        public f(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(laa.d.class));
        }
    }

    public static final class g implements Function0<ICoreInputAbility> {
        public final /* synthetic */ AttachReceiver a;

        public g(AttachReceiver r1) {
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

    public static final class h implements Function0<o> {
        public final /* synthetic */ AttachReceiver a;

        public h(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(o.class));
        }
    }

    public static final class i implements Function0<a0> {
        public final /* synthetic */ AttachReceiver a;

        public i(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(a0.class));
        }
    }

    public static final class j implements Function0<g1> {
        public final /* synthetic */ AttachReceiver a;

        public j(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(g1.class));
        }
    }

    public static final class k implements Function0<laa.f> {
        public final /* synthetic */ AttachReceiver a;

        public k(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(laa.f.class));
        }
    }

    public static final class l implements Function0<com.larus.bmhome.instruction.g> {
        public final /* synthetic */ AttachReceiver a;

        public l(AttachReceiver r1) {
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

    static {
    }

    public final void C0(boolean r1, boolean r2) {
    }

    public final void Rb() {
        GC(false, false, null, null);
    }

    public final void Tb() {
        GC(true, true, null, null);
    }

    public final void a7(boolean r1) {
    }

    public final void B2() {
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("onViewCreated ");
        a r2 = p3();
        if (r2 == null) goto L5;
        ConstraintLayout r3 = r2.q();
    L6:
        r1.append(r3);
        r0.e("OrionWindowStyleComponent", r1.toString());
        this.B = new w5(this);
        laa.d r4 = B3();
        if (r4 != null) goto L9;
    L11:
        boolean r5 = false;
    L12:
        if (r5 == false) goto L21;
        G3((View) this.D.getValue());
        G3(z3());
        G3((Space) this.G.getValue());
        G3((Space) this.H.getValue());
        G3((Space) this.I.getValue());
        G3((Space) this.J.getValue());
        G3((View) this.F.getValue());
        ViewGroup r6 = (ViewGroup) this.x.getValue();
        if (r6 == null) goto L21;
        int r7 = r6.indexOfChild(m3()) - 1;
        Space r8 = (Space) this.G.getValue();
        ViewGroup.LayoutParams r9 = new ConstraintLayout.LayoutParams(v19.i5.m0(), 0);
        ((ConstraintLayout.LayoutParams) r9).endToStart = 2131375324;
        ((ConstraintLayout.LayoutParams) r9).topToTop = 2131375324;
        ((ConstraintLayout.LayoutParams) r9).bottomToBottom = 2131375324;
        Unit r10 = Unit.INSTANCE;
        r6.addView(r8, r7, r9);
        Space r11 = (Space) this.H.getValue();
        ViewGroup.LayoutParams r12 = new ConstraintLayout.LayoutParams(v19.i5.m0(), 0);
        ((ConstraintLayout.LayoutParams) r12).startToEnd = 2131375324;
        ((ConstraintLayout.LayoutParams) r12).topToTop = 2131375324;
        ((ConstraintLayout.LayoutParams) r12).bottomToBottom = 2131375324;
        r6.addView(r11, r7, r12);
        Space r13 = (Space) this.I.getValue();
        ViewGroup.LayoutParams r14 = new ConstraintLayout.LayoutParams(0, v19.i5.A());
        ((ConstraintLayout.LayoutParams) r14).bottomToTop = 2131375324;
        ((ConstraintLayout.LayoutParams) r14).startToStart = 2131375324;
        ((ConstraintLayout.LayoutParams) r14).endToEnd = 2131375324;
        r6.addView(r13, r7, r14);
        Space r15 = (Space) this.J.getValue();
        ViewGroup.LayoutParams r16 = new ConstraintLayout.LayoutParams(0, v19.i5.m0());
        ((ConstraintLayout.LayoutParams) r16).topToBottom = 2131375324;
        ((ConstraintLayout.LayoutParams) r16).startToStart = 2131375324;
        ((ConstraintLayout.LayoutParams) r16).endToEnd = 2131375324;
        r6.addView(r15, r7, r16);
        View r17 = (View) this.D.getValue();
        ViewGroup.LayoutParams r18 = new ConstraintLayout.LayoutParams(0, v19.i5.a0());
        ((ConstraintLayout.LayoutParams) r18).topToTop = 2131364480;
        ((ConstraintLayout.LayoutParams) r18).startToStart = 0;
        ((ConstraintLayout.LayoutParams) r18).endToEnd = 0;
        r6.addView(r17, r7, r18);
        View r19 = z3();
        ConstraintLayout.LayoutParams r20 = new ConstraintLayout.LayoutParams(0, 0);
        r20.startToStart = 2131381256;
        r20.endToEnd = 2131381257;
        r20.topToTop = 2131381258;
        r20.bottomToBottom = 2131381255;
        r20.setMarginStart(v19.i5.m());
        r20.setMarginEnd(v19.i5.m());
        ((ViewGroup.MarginLayoutParams) r20).topMargin = v19.i5.q();
        ((ViewGroup.MarginLayoutParams) r20).bottomMargin = v19.i5.m();
        r6.addView(r19, r7, r20);
        View r21 = (View) this.F.getValue();
        ConstraintLayout.LayoutParams r22 = new ConstraintLayout.LayoutParams(0, v19.i5.d());
        r22.bottomToTop = 2131375324;
        r22.startToStart = 2131375324;
        r22.endToEnd = 2131375324;
        ((ViewGroup.MarginLayoutParams) r22).bottomMargin = v19.i5.c0();
        r6.addView(r21, r7, r22);
        ImageView r23 = (ImageView) this.E.getValue();
        ViewGroup r24 = (ViewGroup) this.x.getValue();
        if (r24 == null) goto L19;
        float r25 = r24.getPaddingBottom();
    L20:
        r23.setTranslationY(r25);
        ViewGroup.LayoutParams r26 = new ConstraintLayout.LayoutParams(0, 0);
        ((ConstraintLayout.LayoutParams) r26).startToStart = 0;
        ((ConstraintLayout.LayoutParams) r26).endToEnd = 0;
        ((ConstraintLayout.LayoutParams) r26).topToTop = 2131381248;
        ((ConstraintLayout.LayoutParams) r26).bottomToBottom = 0;
        r6.addView(r23, r7, r26);
        Space r27 = (Space) this.K.getValue();
        ViewGroup.LayoutParams r28 = new ConstraintLayout.LayoutParams(0, v19.i5.h());
        ((ConstraintLayout.LayoutParams) r28).startToStart = 0;
        ((ConstraintLayout.LayoutParams) r28).topToTop = 2131375324;
        r6.addView(r27, 0, r28);
        View r29 = (ObricIconSwipeUpView) this.L.getValue();
        ViewGroup.LayoutParams r30 = new ConstraintLayout.LayoutParams(0, v19.c7.b(160));
        ((ConstraintLayout.LayoutParams) r30).startToStart = 0;
        ((ConstraintLayout.LayoutParams) r30).endToEnd = 0;
        ((ConstraintLayout.LayoutParams) r30).bottomToBottom = 2131381194;
        r6.addView(r29, r30);
        View r31 = (View) this.N.getValue();
        ViewGroup.LayoutParams r32 = new ConstraintLayout.LayoutParams(0, 0);
        ((ConstraintLayout.LayoutParams) r32).startToStart = 0;
        ((ConstraintLayout.LayoutParams) r32).endToEnd = 0;
        ((ConstraintLayout.LayoutParams) r32).topToTop = 0;
        ((ConstraintLayout.LayoutParams) r32).bottomToBottom = 0;
        r6.addView(r31, r32);
        goto L21
    L19:
        r25 = 0.0f;
    L21:
        laa.d r33 = B3();
        if (r33 == null) goto L25;
        r33.HU(this);
        return;
    L25:
        return;
    L9:
        if (r4.Da() != true) goto L11;
        r5 = true;
        goto L12
    L5:
        r3 = null;
        goto L6
    }

    public final laa.d B3() {
        return (laa.d) this.o.getValue();
    }

    public final ValueAnimator h3() {
        return (ValueAnimator) this.M.getValue();
    }

    public final View m3() {
        return (View) this.y.getValue();
    }

    public final void onDestroy() {
        ObricInteractionProjectionDelegate.b.c(this.O);
        laa.d r0 = B3();
        if (r0 == null) goto L6;
        r0.AN(this);
        return;
    }

    public final va8.c p3() {
        o r0 = (o) this.q.getValue();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.Uv();
    }

    public final ObricIconSwipeUpView qR() {
        return (ObricIconSwipeUpView) this.L.getValue();
    }

    public final AudioGradientView z3() {
        return (AudioGradientView) this.C.getValue();
    }

    /* JADX WARN: Type inference failed for: r0v52, types: [com.obric.assistant.component.e5] */
    public OrionChatWindowComponent() {
        this.m = LazyKt.lazy(new d(this));
        this.n = LazyKt.lazy(new e(this));
        this.o = LazyKt.lazy(new f(this));
        this.p = LazyKt.lazy(new g(this));
        this.q = LazyKt.lazy(new h(this));
        this.r = LazyKt.lazy(new i(this));
        this.s = LazyKt.lazy(new j(this));
        this.t = LazyKt.lazy(new k(this));
        this.u = LazyKt.lazy(new l(this));
        this.v = LazyKt.lazy(new c(this));
        this.w = LazyKt.lazy(new x5(this));
        this.x = LazyKt.lazy(new f5(this));
        this.y = LazyKt.lazy(new g5(this));
        this.z = LazyKt.lazy(new h5(this));
        this.C = LazyKt.lazy(new i5(this));
        this.D = LazyKt.lazy(new j5(this));
        this.E = LazyKt.lazy(new k5(this));
        this.F = LazyKt.lazy(new l5(this));
        this.G = LazyKt.lazy(new n5(this));
        this.H = LazyKt.lazy(new o5(this));
        this.I = LazyKt.lazy(new y5(this));
        this.J = LazyKt.lazy(new z5(this));
        this.K = LazyKt.lazy(new a6(this));
        this.L = LazyKt.lazy(new b6(this));
        this.M = LazyKt.lazy(new c5());
        this.N = LazyKt.lazy(new d5(this));
        this.O = new e5(this);
    }

    public final ViewGroup C3() {
        a r0 = p3();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.H();
    }

    public final View LD() {
        return z3();
    }

    public final View Y2() {
        a r0 = p3();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.y();
    }

    public final void onResume() {
        laa.d r0 = B3();
        boolean r1 = true;
        if (r0 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == false) goto L17;
        List r3 = ObricChatService.m;
        laa.d r4 = B3();
        if (r4 != null) goto L12;
    L14:
        r1 = false;
    L15:
        t0.a(new x(r1));
        return;
    L12:
        if (r4.aF() != true) goto L14;
    L17:
        return;
    L5:
        if (r0.Da() != true) goto L7;
        r2 = true;
        goto L8
    }

    public final void onStop() {
        laa.d r0 = B3();
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        if (r1 == false) goto L10;
        List r2 = ObricChatService.m;
        t0.a(new y());
        return;
    L10:
        return;
    L5:
        if (r0.Da() != true) goto L7;
        r1 = true;
        goto L7
    }

    public final void x8() {
        va8.c r0 = p3();
        if (r0 == null) goto L6;
        r0.g(new r5(this));
        return;
    }

    public final void D3(boolean r3) {
        if (((Space) this.I.getValue()).getParent() != null) goto L5;
        return;
    L5:
        if (((Space) this.I.getValue()).getLayoutParams() == null) goto L13;
        View r0 = m3();
        if (r0 == null) goto L12;
        r0.post(new u5(this, r3));
        return;
    L12:
        return;
    }

    public final void DH(boolean r14) {
        FLogger.a.i("OrionWindowStyleComponent", "setVoiceViewVisibleAnimated visible=" + r14 + ", duration=150");
        AnimatorSet r0 = this.S;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        this.S = null;
        boolean r2 = true;
        float r9 = 0.0f;
        if (r14 == false) goto L103;
        ICoreInputAbility r15 = (ICoreInputAbility) this.p.getValue();
        if (r15 == null) goto L10;
        r15.g2(2, true);
    L10:
        o r16 = (o) this.q.getValue();
        if (r16 == null) goto L13;
        r16.ra();
    L13:
        ICoreInputAbility r17 = (ICoreInputAbility) this.p.getValue();
        if (r17 == null) goto L16;
        r17.qp(false);
    L16:
        g1 r18 = (g1) this.s.getValue();
        if (r18 != null) goto L19;
    L21:
        boolean r19 = false;
    L22:
        if (r19 == false) goto L30;
        View r110 = Y2();
        if (r110 == null) goto L46;
        ViewGroup.LayoutParams r11 = r110.getLayoutParams();
        if (r11 == null) goto L29;
        r11.width = 0;
        r110.setLayoutParams(r11);
        goto L46
    L29:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L46:
        laa.f r111 = (laa.f) this.t.getValue();
        if (r111 != null) goto L49;
    L51:
        boolean r112 = false;
    L52:
        if (r112 == false) goto L78;
        laa.f r113 = (laa.f) this.t.getValue();
        if (r113 == null) goto L56;
        r113.LE(true);
    L56:
        laa.d r114 = B3();
        if (r114 == null) goto L59;
        r114.C00(true);
    L59:
        this.Q = true;
        ViewGroup r115 = C3();
        if (r115 == null) goto L62;
        r115.setScaleX(0.0f);
    L62:
        ViewGroup r116 = C3();
        if (r116 == null) goto L65;
        r116.setScaleY(0.0f);
    L65:
        laa.d r117 = B3();
        if (r117 != null) goto L68;
    L70:
        boolean r118 = false;
    L71:
        H3(r118);
        laa.d r119 = B3();
        if (r119 != null) goto L74;
    L76:
        r2 = false;
    L77:
        Q3(r2, false);
        return;
    L74:
        if (r119.aF() != true) goto L76;
    L68:
        if (r117.aF() != true) goto L70;
        r118 = true;
        goto L71
    L78:
        t0.d(new b5(this), 150);
        laa.d r120 = B3();
        if (r120 == null) goto L81;
        r120.C00(true);
    L81:
        this.Q = true;
        laa.d r121 = B3();
        if (r121 != null) goto L84;
    L86:
        boolean r122 = false;
    L87:
        H3(r122);
        ArrayList r123 = new ArrayList();
        ViewGroup r8 = C3();
        if (r8 == null) goto L90;
        r8.setAlpha(1.0f);
        r8.setScaleX(1.0f);
        r8.setScaleY(1.0f);
        ObjectAnimator r10 = ObjectAnimator.ofFloat(r8, View.ALPHA, new float[]{1.0f, 0.0f});
        r10.setDuration(150);
        r10.addListener(new c6(this, r8));
        r123.add(r10);
    L90:
        laa.d r12 = B3();
        if (r12 != null) goto L93;
    L95:
        boolean r13 = false;
    L96:
        boolean r20 = v19.h.a;
        boolean r21 = v19.h.b(getContext());
        if (r13 == false) goto L99;
        float r22 = 1.0f;
    L102:
        ObjectAnimator r3 = ObjectAnimator.ofFloat(z3(), View.ALPHA, new float[]{z3().getAlpha(), r22});
        r3.setDuration(150);
        r3.setStartDelay(150);
        r123.add(r3);
        AnimatorSet r4 = new AnimatorSet();
        r4.setInterpolator(new PathInterpolator(0.4f, 0.8f, 0.74f, 1.0f));
        r4.playTogether(r123);
        r4.addListener(new d6(this));
        r4.start();
        this.S = r4;
        return;
    L99:
        if (r21 == false) goto L101;
        r22 = 0.6f;
        goto L102
    L101:
        r22 = 0.32f;
        goto L102
    L93:
        if (r12.aF() != true) goto L95;
        r13 = true;
        goto L96
    L84:
        if (r121.aF() != true) goto L86;
        r122 = true;
        goto L87
    L49:
        if (r111.kT() != true) goto L51;
        r112 = true;
        goto L52
    L30:
        View r124 = Y2();
        if (r124 == null) goto L37;
        ViewGroup.LayoutParams r125 = r124.getLayoutParams();
        if (r125 == null) goto L37;
        if (r125.width != v19.i5.c0()) goto L37;
        boolean r126 = true;
    L38:
        if (r126 == true) goto L46;
        View r127 = Y2();
        if (r127 == null) goto L46;
        ViewGroup.LayoutParams r128 = r127.getLayoutParams();
        if (r128 == null) goto L45;
        r128.width = v19.i5.c0();
        r127.setLayoutParams(r128);
        goto L46
    L45:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L37:
        r126 = false;
        goto L38
    L19:
        if (r18.isVisible() != true) goto L21;
        r19 = true;
        goto L22
    L103:
        g1 r129 = (g1) this.s.getValue();
        if (r129 != null) goto L106;
    L108:
        boolean r130 = false;
    L109:
        if (r130 == true) goto L126;
        View r131 = Y2();
        if (r131 == null) goto L117;
        ViewGroup.LayoutParams r132 = r131.getLayoutParams();
        if (r132 == null) goto L117;
        if (r132.width != v19.i5.c0()) goto L117;
        boolean r133 = true;
    L118:
        if (r133 == true) goto L126;
        View r134 = Y2();
        if (r134 == null) goto L126;
        ViewGroup.LayoutParams r135 = r134.getLayoutParams();
        if (r135 == null) goto L125;
        r135.width = v19.i5.c0();
        r134.setLayoutParams(r135);
        goto L126
    L125:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L117:
        r133 = false;
    L126:
        Function0<Unit> r136 = this.A;
        if (r136 == null) goto L129;
        r136.invoke();
    L129:
        laa.d r137 = B3();
        if (r137 == null) goto L132;
        r137.C00(false);
    L132:
        this.Q = false;
        laa.d r138 = B3();
        if (r138 != null) goto L135;
    L137:
        boolean r139 = false;
    L138:
        H3(r139);
        ArrayList r140 = new ArrayList();
        ViewGroup r23 = C3();
        if (r23 == null) goto L141;
        r23.setAlpha(0.0f);
        r23.setScaleX(1.0f);
        r23.setScaleY(1.0f);
        ObjectAnimator r24 = ObjectAnimator.ofFloat(r23, View.ALPHA, new float[]{0.0f, 1.0f});
        r24.setDuration(150);
        r24.setStartDelay(150);
        r140.add(r24);
    L141:
        laa.d r25 = B3();
        if (r25 != null) goto L144;
    L146:
        boolean r26 = false;
    L147:
        if (r26 == false) goto L149;
        r9 = 0.4f;
    L149:
        ObjectAnimator r5 = ObjectAnimator.ofFloat(z3(), View.ALPHA, new float[]{z3().getAlpha(), r9});
        r5.setDuration(150);
        r140.add(r5);
        t0.d(new m5(this), 150);
        AnimatorSet r6 = new AnimatorSet();
        r6.setInterpolator(new PathInterpolator(0.4f, 0.8f, 0.74f, 1.0f));
        r6.playTogether(r140);
        r6.addListener(new e6(this));
        r6.start();
        this.S = r6;
        return;
    L144:
        if (r25.aF() != true) goto L146;
        r26 = true;
        goto L147
    L135:
        if (r138.aF() != true) goto L137;
        r139 = true;
        goto L138
    L106:
        if (r129.isVisible() != true) goto L108;
        r130 = true;
        goto L109
    }

    public final void E3(ForegroundInteractionPhase r7) {
        laa.d r0 = B3();
        boolean r1 = true;
        if (r0 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == true) goto L10;
        return;
    L10:
        Object r3 = h3().getAnimatedValue();
        if ((r3 instanceof Float) == false) goto L13;
        Float r4 = (Float) r3;
    L14:
        float r5 = 1.0f;
        if (r4 == null) goto L18;
        float r6 = r4.floatValue();
    L32:
        if (r7 != ForegroundInteractionPhase.Activate) goto L34;
    L41:
        if (r1 == true) goto L44;
        r5 = 0.0f;
    L44:
        t0.e(new t5(r6, r5, this));
        return;
    L34:
        if (r7 == ForegroundInteractionPhase.Connecting) goto L41;
        if (r7 == ForegroundInteractionPhase.Thinking) goto L41;
        if (r7 == ForegroundInteractionPhase.Listen) goto L41;
        r1 = false;
        goto L41
    L18:
        if (r7 != ForegroundInteractionPhase.Activate) goto L20;
    L27:
        boolean r8 = true;
    L28:
        if (r8 == false) goto L30;
        r6 = 0.0f;
        goto L32
    L30:
        r6 = 1.0f;
        goto L32
    L20:
        if (r7 == ForegroundInteractionPhase.Connecting) goto L27;
        if (r7 == ForegroundInteractionPhase.Thinking) goto L27;
        if (r7 == ForegroundInteractionPhase.Listen) goto L27;
        r8 = false;
        goto L28
    L13:
        r4 = null;
        goto L14
    L5:
        if (r0.aF() != true) goto L7;
        r2 = true;
        goto L8
    }

    public final void F0(boolean r3) {
        com.larus.bmhome.instruction.g r0 = (com.larus.bmhome.instruction.g) this.u.getValue();
        boolean r1 = false;
        if (r0 == null) goto L5;
        boolean r2 = r0.z0();
    L6:
        if (r2 == true) goto L8;
        if (r3 == true) goto L8;
    L9:
        D3(r1);
        return;
    L8:
        r1 = true;
        goto L9
    L5:
        r2 = false;
        goto L6
    }

    public final void G3(View r3) {
        if (r3.getParent() != null) goto L5;
        return;
    L5:
        if ((r3.getParent() instanceof ViewGroup) == false) goto L14;
        ViewParent r0 = r3.getParent();
        if ((r0 instanceof ViewGroup) == false) goto L9;
        ViewGroup r1 = (ViewGroup) r0;
    L10:
        if (r1 == null) goto L15;
        r1.removeView(r3);
        return;
    L15:
        return;
    L9:
        r1 = null;
        goto L10
    }

    public final void H3(boolean r7) {
        ObricInteractDelegate r0 = ObricInteractDelegate.b;
        Boolean r1 = r0.isAiKeyPressing();
        Boolean r2 = Boolean.TRUE;
        boolean r3 = true;
        if (Intrinsics.areEqual(r1, r2) == false) goto L5;
    L8:
        boolean r4 = true;
    L9:
        FLogger.a.i("OrionWindowStyleComponent", "updateGestureViewVisibility, isChatWindow=" + r7 + ", hideForAiKeyWakeup=" + r4);
        ObricIconSwipeUpView r5 = (ObricIconSwipeUpView) this.L.getValue();
        if (r7 == false) goto L13;
        if (r4 == true) goto L13;
    L14:
        r5.setEnabled(r3);
        if (r7 == false) goto L18;
        if (r4 == true) goto L18;
        e1.x((ObricIconSwipeUpView) this.L.getValue());
        return;
    L18:
        e1.o((ObricIconSwipeUpView) this.L.getValue());
        return;
    L13:
        r3 = false;
        goto L14
    L5:
        if (Intrinsics.areEqual(r0.isAiKeyLongPress(), r2) == true) goto L8;
        r4 = false;
        goto L9
    }

    public final void I2(Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        this.A = r2;
    }

    public final void L10(float r3) {
        laa.d r0 = B3();
        if (r0 == null) goto L7;
        boolean r1 = true;
        if (r0.aF() != true) goto L7;
    L8:
        if (r1 == true) goto L10;
        return;
    L10:
        if (r3 >= 0.0f) goto L13;
        r3 = 0.0f;
    L15:
        ((ImageView) this.E.getValue()).setAlpha(r3);
        return;
    L13:
        if (r3 <= 1.0f) goto L15;
        r3 = 1.0f;
    L7:
        r1 = false;
        goto L8
    }

    public final void MP(n r4) {
        GC(true, false, r4, null);
    }

    public final void N60(boolean r4) {
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("onSpeakerStatusSwitch toCancel ");
        r1.append(r4);
        r1.append(", pageState is ");
        laa.d r2 = B3();
        if (r2 == null) goto L5;
        ObricFloatChatPageState r3 = r2.getPageState();
    L6:
        r1.append(r3);
        r0.i("OrionWindowStyleComponent", r1.toString());
        z3().setWarning(r4);
        laa.d r5 = B3();
        boolean r6 = false;
        if (r5 != null) goto L9;
    L11:
        Q3(r6, r4);
        return;
    L9:
        if (r5.aF() != true) goto L11;
        r6 = true;
        goto L11
    L5:
        r3 = null;
        goto L6
    }

    public final void j1(boolean r4) {
        g1 r0 = (g1) this.s.getValue();
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == true) goto L10;
        if (r4 == true) goto L10;
    L11:
        D3(r1);
        return;
    L10:
        r1 = true;
        goto L11
    L5:
        if (r0.isVisible() != true) goto L7;
        r2 = true;
        goto L8
    }

    public final void r2(boolean r4) {
        FLogger.a.i("OrionWindowStyleComponent", "onChatStyleChanged isChatWindow = " + r4);
        if (r4 == false) goto L7;
        a0 r0 = (a0) this.r.getValue();
        if (r0 == null) goto L8;
        r0.Z7(new v5(this));
    L8:
        H3(r4);
        return;
    L7:
        ObricInteractionProjectionDelegate.b.c(this.O);
        goto L8
    }

    public final void rT(boolean r3) {
        this.R = r3;
        laa.d r4 = B3();
        if (r4 == null) goto L7;
        boolean r1 = true;
        if (r4.aF() != true) goto L7;
    L8:
        Q3(r1, false);
        return;
    L7:
        r1 = false;
        goto L8
    }

    public final void v00(boolean r3) {
        this.P = r3;
        laa.d r4 = B3();
        if (r4 == null) goto L7;
        boolean r1 = true;
        if (r4.aF() != true) goto L7;
    L8:
        Q3(r1, false);
        return;
    L7:
        r1 = false;
        goto L8
    }

    public final void x1(ObricFloatChatPageState r2) {
        Intrinsics.checkNotNullParameter(r2, "pageState");
    }

    public final void Q3(boolean r6, boolean r7) {
        IAssistantChatWindow r0 = IAssistantChatWindowKt.getAssistantChatWindow();
        boolean r1 = true;
        if (r0 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        float r3 = 0.0f;
        if (r2 == false) goto L12;
        z3().setAlpha(0.0f);
        z3().setVisibility(8);
        return;
    L12:
        z3().setVisibility(0);
        AudioGradientView r4 = z3();
        if (this.P == false) goto L15;
    L20:
        if (r1 == false) goto L29;
        boolean r5 = v19.h.a;
        boolean r8 = v19.h.b(getContext());
        if (r6 == false) goto L24;
        r3 = 1.0f;
    L31:
        r4.setAlpha(r3);
        return;
    L24:
        if (r7 == true) goto L28;
        if (r8 == true) goto L28;
        r3 = 0.32f;
    L28:
        r3 = 0.6f;
        goto L31
    L29:
        if (r6 == false) goto L31;
        r3 = 0.4f;
        goto L31
    L15:
        if (this.Q == true) goto L20;
        if (this.R == true) goto L20;
        r1 = false;
        goto L20
    L5:
        if (r0.isWindowMode() != true) goto L7;
        r2 = true;
        goto L8
    }

    public final void uA(float r5, boolean r6) {
        FLogger.a.i("OrionWindowStyleComponent", "resetChatWindowLightAlpha " + r5 + ' ' + r6);
        f1 r0 = (f1) this.v.getValue();
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L10;
        ((ImageView) this.E.getValue()).setAlpha(r5);
    L22:
        f1 r7 = (f1) this.v.getValue();
        if (r7 == null) goto L25;
        r7.t00(new p5(this, r6));
    L25:
        Q3(!r6, false);
        return;
    L10:
        if (r6 == false) goto L22;
        if (((ImageView) this.E.getValue()).getAlpha() != 0.0f) goto L14;
        boolean r2 = true;
    L15:
        if (r2 == true) goto L22;
        if (r5 != 0.0f) goto L19;
        boolean r3 = true;
    L20:
        if (r3 == false) goto L22;
        ((ImageView) this.E.getValue()).setAlpha(r5);
        goto L22
    L19:
        r3 = false;
        goto L20
    L14:
        r2 = false;
        goto L15
    L5:
        if (r0.sL() != true) goto L7;
        r1 = true;
        goto L8
    }

    public final void GC(boolean r6, boolean r7, n r8, String r9) {
        FLogger.a.i("OrionWindowStyleComponent", "setVoiceViewVisible " + r6 + ", playWelcomeAnimation " + r7);
        boolean r0 = true;
        if (r6 == false) goto L20;
        IAssistantChatWindow r2 = IAssistantChatWindowKt.getAssistantChatWindow();
        if (r2 != null) goto L7;
    L9:
        boolean r3 = false;
    L10:
        if (r3 == true) goto L20;
        ICoreInputAbility r4 = (ICoreInputAbility) this.p.getValue();
        if (r4 == null) goto L14;
        r4.g2(2, true);
    L14:
        o r5 = (o) this.q.getValue();
        if (r5 == null) goto L17;
        r5.ra();
    L17:
        ICoreInputAbility r10 = (ICoreInputAbility) this.p.getValue();
        if (r10 == null) goto L20;
        r10.qp(false);
        goto L20
    L7:
        if (r2.isWindowMode() != true) goto L9;
        r3 = true;
    L20:
        g1 r11 = (g1) this.s.getValue();
        if (r11 != null) goto L23;
    L25:
        boolean r12 = false;
    L27:
        if (r12 == false) goto L36;
        if (r6 == false) goto L36;
        View r13 = Y2();
        if (r13 == null) goto L52;
        ViewGroup.LayoutParams r14 = r13.getLayoutParams();
        if (r14 == null) goto L35;
        r14.width = 0;
        r13.setLayoutParams(r14);
        goto L52
    L35:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L52:
        float r15 = 1.0f;
        if (r6 == false) goto L55;
        float r16 = 0.0f;
    L56:
        ViewGroup r17 = C3();
        if (r17 == null) goto L59;
        r17.setScaleX(r16);
    L59:
        ViewGroup r18 = C3();
        if (r18 == null) goto L62;
        r18.setScaleY(r16);
    L62:
        a0 r19 = (a0) this.r.getValue();
        if (r19 == null) goto L65;
        wc9.e r20 = r19.h();
    L66:
        ViewGroup r21 = C3();
        if (r21 == null) goto L80;
        if (r20 != null) goto L70;
    L79:
        r21.setAlpha(r15);
        goto L80
    L70:
        if (com.larus.bmhome.utils.i.h(r20) == true) goto L79;
        ViewGroup r22 = C3();
        if (r22 != null) goto L74;
    L76:
        boolean r23 = false;
    L77:
        if (r23 == true) goto L79;
        r15 = 0.3f;
        goto L79
    L74:
        if (r22.isEnabled() != true) goto L76;
        r23 = true;
    L80:
        if (r6 == true) goto L84;
        Function0<Unit> r24 = this.A;
        if (r24 == null) goto L84;
        r24.invoke();
    L84:
        laa.f r25 = (laa.f) this.t.getValue();
        if (r25 == null) goto L87;
        r25.Fj(r6, r7, r8, r9);
    L87:
        laa.d r26 = B3();
        if (r26 == null) goto L90;
        r26.C00(r6);
    L90:
        this.Q = r6;
        laa.d r27 = B3();
        if (r27 != null) goto L93;
    L95:
        boolean r28 = false;
    L96:
        H3(r28);
        laa.d r29 = B3();
        if (r29 != null) goto L99;
    L101:
        r0 = false;
    L102:
        Q3(r0, false);
        return;
    L99:
        if (r29.aF() != true) goto L101;
    L93:
        if (r27.aF() != true) goto L95;
        r28 = true;
        goto L96
    L65:
        r20 = null;
        goto L66
    L55:
        r16 = 1.0f;
    L36:
        View r30 = Y2();
        if (r30 == null) goto L43;
        ViewGroup.LayoutParams r31 = r30.getLayoutParams();
        if (r31 == null) goto L43;
        if (r31.width != v19.i5.c0()) goto L43;
        boolean r32 = true;
    L44:
        if (r32 == true) goto L52;
        View r33 = Y2();
        if (r33 == null) goto L52;
        ViewGroup.LayoutParams r34 = r33.getLayoutParams();
        if (r34 == null) goto L51;
        r34.width = v19.i5.c0();
        r33.setLayoutParams(r34);
        goto L52
    L51:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L43:
        r32 = false;
        goto L44
    L23:
        if (r11.isVisible() != true) goto L25;
        r12 = true;
        goto L27
    }
}
