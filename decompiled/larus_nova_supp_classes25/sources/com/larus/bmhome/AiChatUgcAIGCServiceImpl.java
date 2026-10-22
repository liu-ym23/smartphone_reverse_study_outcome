package com.larus.bmhome;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.ListAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.larus.asr.view.ChatSpeaker;
import com.larus.avlink.model.DoraCallStateCode;
import com.larus.bmhome.actionbar.model.z0;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.chat.ChatDoubleTabActivity;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.actionbar.IActionBarService;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.component.bottom.core.y8;
import com.larus.bmhome.chat.component.cvs.ChatConversationComponent;
import com.larus.bmhome.chat.layout.holder.helper.b1;
import com.larus.bmhome.chat.layout.holder.helper.d1;
import com.larus.bmhome.chat.layout.holder.helper.p2;
import com.larus.bmhome.chat.layout.holder.helper.t0;
import com.larus.bmhome.chat.layout.holder.helper.u0;
import com.larus.bmhome.chat.layout.holder.helper.w0;
import com.larus.bmhome.chat.layout.holder.helper.z2;
import com.larus.bmhome.chat.layout.holder.image.ImageHolderDispatcher;
import com.larus.bmhome.chat.layout.holder.image.ScrollImageViewHolder;
import com.larus.bmhome.chat.layout.holder.image.bean.ImageContentData;
import com.larus.bmhome.chat.layout.holder.image.utils.AiCreationEditUtils;
import com.larus.bmhome.chat.layout.holder.progressloading.GenImgLoadingResourceGetter;
import com.larus.bmhome.chat.layout.holder.progressloading.ISketchLoadingController;
import com.larus.bmhome.chat.layout.holder.progressloading.LoadingType;
import com.larus.bmhome.chat.layout.holder.progressloading.SketchLoadingController;
import com.larus.bmhome.chat.layout.holder.video.bean.AiGenVideoContentData;
import com.larus.bmhome.chat.list.cell.music.MusicCell;
import com.larus.bmhome.chat.list.cell.music.MusicCell$a;
import com.larus.bmhome.chat.model.ChatDraftItem;
import com.larus.bmhome.chat.trace.ChatRenderTrace;
import com.larus.bmhome.instruction.TemplatePrefetchHelper;
import com.larus.bmhome.instruction.c2;
import com.larus.bmhome.instruction.helper.AiBeautifyPickPhotoHelper;
import com.larus.bmhome.music.save_video.MusicVideoSaver;
import com.larus.bmhome.share.ShareScene;
import com.larus.bmhome.upload.ResourceUploader;
import com.larus.bmhome.utils.c4;
import com.larus.bmhome.utils.p1;
import com.larus.bmhome.video.fragment.AiGenVideoDetailFragment;
import com.larus.bmhome.video.fragment.BaseVideoDetailFragment;
import com.larus.bmhome.video.fragment.CreationDetailPromptVideoFragment;
import com.larus.bmhome.video.save_share.VideoGenerateSaver;
import com.larus.bmhome.video.save_share.VideoGenerateShareHelper;
import com.larus.bmhome.video.view.AiGenVideoPlayControlView;
import com.larus.bmhome.view.actionbar.custom.CustomActionBar;
import com.larus.bmhome.view.actionbar.custom.CustomActionBarAdapter;
import com.larus.bmhome.view.actionbar.custom.CustomActionBarViewModel;
import com.larus.bmhome.view.actionbar.custom.CustomActionBarViewModelFactory;
import com.larus.bmhome.view.actionbar.custom.RightLayoutManager;
import com.larus.bmhome.view.actionbar.custom.n;
import com.larus.bmhome.view.actionbar.custom.router.c;
import com.larus.bmhome.view.actionbar.custom.w2;
import com.larus.bmhome.view.actionbar.custom.x2;
import com.larus.bmhome.view.actionbar.edit.InstructionEditorViewModel;
import com.larus.bmhome.view.title.ChatTitle;
import com.larus.common_ui.video.VideoPlayView;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.LyricsSeekContent;
import com.larus.network.http.HttpExtKt;
import com.larus.platform.api.ImageInfo;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.api.creation.UserCreationContent;
import com.larus.platform.api.creation.UserCreationMusic;
import com.larus.platform.service.AccountService;
import com.larus.platform.spi.IAIChatUgcAIGCService;
import com.larus.uaigc.createpage.component.instruction.CreationEditorComponent;
import com.larus.uaigc.createpage.component.instruction.o1;
import com.larus.uaigc.nowatermark.CreationNoWatermarkManager;
import com.larus.uaigc.service.ICreationAttachmentService;
import com.larus.uaigc.service.IUgcAIGCService;
import com.larus.uaigc.service.IZLotteryService;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.io.Serializable;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.i1;
import org.json.JSONObject;
import ps8.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u0080\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001a\b\u0007\u0018\u0000 \u008e\u00022\u00020\u0001:\u0004\u008d\u0002\u008e\u0002B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0018\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\rH\u0016J \u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\rH\u0016J`\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\r2\b\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010'\u001a\u00020\r2\u0006\u0010(\u001a\u00020\r2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u000f2\u0012\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u001f0-H\u0016J*\u0010.\u001a\u00020\u001f2\u0006\u0010/\u001a\u00020\r2\u0012\u00100\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u001f0-H\u0096@¢\u0006\u0002\u00101J\u0010\u00102\u001a\u00020\u001f2\u0006\u00103\u001a\u000204H\u0016J\u0018\u00105\u001a\u0012\u0012\u0004\u0012\u00020706j\b\u0012\u0004\u0012\u000207`8H\u0016J\u0085\u0001\u00109\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010:\u001a\u00020;2\b\u0010<\u001a\u0004\u0018\u00010=2\u0006\u0010>\u001a\u00020\r2\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020B2\u0006\u0010)\u001a\u00020*2\u0006\u0010C\u001a\u00020D2\b\u0010E\u001a\u0004\u0018\u00010F2\b\u0010G\u001a\u0004\u0018\u00010\r2\b\u0010H\u001a\u0004\u0018\u0001042\u0014\u0010I\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0018\u00010JH\u0016¢\u0006\u0002\u0010KJ4\u0010L\u001a\u0004\u0018\u00010\t2\b\u0010M\u001a\u0004\u0018\u00010\t2\u0006\u0010N\u001a\u00020O2\u0006\u0010P\u001a\u0002042\u0006\u0010Q\u001a\u0002042\u0006\u0010R\u001a\u00020\u000fH\u0016J\u0010\u0010S\u001a\u00020@2\u0006\u0010 \u001a\u00020!H\u0016J\u0010\u0010T\u001a\u00020\u000f2\u0006\u0010U\u001a\u00020VH\u0016JF\u0010\\\u001a\u00020\u001f*\u00020@2\u0006\u0010N\u001a\u00020V2\b\u0010]\u001a\u0004\u0018\u00010^2\b\u0010_\u001a\u0004\u0018\u00010`2\b\u0010a\u001a\u0004\u0018\u00010#2\b\u0010b\u001a\u0004\u0018\u00010\r2\b\u0010c\u001a\u0004\u0018\u00010dH\u0016J\b\u0010e\u001a\u00020fH\u0016J\u0010\u0010g\u001a\u00020h2\u0006\u0010 \u001a\u00020!H\u0016Jö\u0001\u0010i\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010j\u001a\u00020F2\b\u0010k\u001a\u0004\u0018\u00010\r2\b\u0010l\u001a\u0004\u0018\u00010\r2\b\u0010m\u001a\u0004\u0018\u00010\r2\b\u0010n\u001a\u0004\u0018\u00010\r2\u0006\u0010o\u001a\u00020\u000f2~\u0010p\u001az\u0012\u0013\u0012\u00110F¢\u0006\f\br\u0012\b\bs\u0012\u0004\b\b(j\u0012\u0013\u0012\u00110\r¢\u0006\f\br\u0012\b\bs\u0012\u0004\b\b(t\u0012!\u0012\u001f\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0018\u00010J¢\u0006\f\br\u0012\b\bs\u0012\u0004\b\b(u\u0012!\u0012\u001f\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0018\u00010J¢\u0006\f\br\u0012\b\bs\u0012\u0004\b\b(v\u0012\u0004\u0012\u00020\u001f\u0018\u00010q2\u0014\u0010v\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0018\u00010J2\u0014\u0010w\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u001f\u0018\u00010-H\u0016JP\u0010x\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010y\u001a\u00020z2\b\u0010{\u001a\u0004\u0018\u00010|2\b\u0010)\u001a\u0004\u0018\u00010*2\b\u0010}\u001a\u0004\u0018\u00010~2\u0006\u0010\u007f\u001a\u0002042\u0006\u0010o\u001a\u00020\u000f2\b\u0010n\u001a\u0004\u0018\u00010\rH\u0016JØ\u0001\u0010x\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010y\u001a\u00020z2\b\u0010)\u001a\u0004\u0018\u00010*2\b\u0010}\u001a\u0004\u0018\u00010~2\u0006\u0010\u007f\u001a\u0002042\u0006\u0010o\u001a\u00020\u000f2\b\u0010n\u001a\u0004\u0018\u00010\r2\u0007\u0010\u0080\u0001\u001a\u00020\r2\t\u0010\u0081\u0001\u001a\u0004\u0018\u00010\r2\n\u0010\u0082\u0001\u001a\u0005\u0018\u00010\u0083\u00012\u0016\u0010\u0084\u0001\u001a\u0011\u0012\u0005\u0012\u00030\u0085\u0001\u0012\u0004\u0012\u00020\u001f\u0018\u00010-2-\u0010\u0086\u0001\u001a(\u0012\u0005\u0012\u00030\u0087\u0001\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0007\u0012\u0005\u0018\u00010\u0088\u0001\u0012\u0004\u0012\u00020\u001f\u0018\u00010q2\u0017\u0010\u0089\u0001\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010=\u0012\u0004\u0012\u00020\u001f\u0018\u00010-2\u0010\u0010\u008a\u0001\u001a\u000b\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u008b\u0001H\u0016J\u001f\u0010\u008c\u0001\u001a\u0004\u0018\u00010V2\b\u0010{\u001a\u0004\u0018\u00010|2\b\u0010>\u001a\u0004\u0018\u00010\rH\u0016J\u0016\u0010\u008d\u0001\u001a\u00030\u008e\u00012\n\u0010\u008f\u0001\u001a\u0005\u0018\u00010\u0090\u0001H\u0016J\n\u0010\u0091\u0001\u001a\u00030\u0092\u0001H\u0016J4\u0010\u0093\u0001\u001a\u00020\u001f*\u00020@2\u0006\u0010N\u001a\u00020V2\t\u0010E\u001a\u0005\u0018\u00010\u0094\u00012\b\u0010]\u001a\u0004\u0018\u00010^2\b\u0010c\u001a\u0004\u0018\u00010dH\u0016J\u001f\u0010\u0095\u0001\u001a\u00020\u001f*\u00020@2\u0006\u0010N\u001a\u00020V2\b\u0010]\u001a\u0004\u0018\u00010^H\u0016J\u0016\u0010\u0096\u0001\u001a\u0005\u0018\u00010\u0097\u00012\b\u0010U\u001a\u0004\u0018\u00010VH\u0016J\u0016\u0010\u0098\u0001\u001a\u0005\u0018\u00010\u0094\u00012\b\u0010U\u001a\u0004\u0018\u00010VH\u0016J§\u0001\u0010\u0099\u0001\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010E\u001a\u0004\u0018\u00010F2\u0007\u0010\u009a\u0001\u001a\u00020D2\u0007\u0010\u009b\u0001\u001a\u00020\r2\u0006\u0010)\u001a\u00020*2\u0007\u0010\u009c\u0001\u001a\u00020\u000f2\u0007\u0010\u009d\u0001\u001a\u00020\u000f2\t\u0010\u009e\u0001\u001a\u0004\u0018\u00010d2\u0014\u0010I\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0018\u00010J2\t\u0010\u009f\u0001\u001a\u0004\u0018\u00010\r2\u0007\u0010 \u0001\u001a\u00020\u000f2'\u0010¡\u0001\u001a\"\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\u0004\u0012\u00020\u001f0qH\u0016Jd\u0010¢\u0001\u001a\u00020\u001f2\b\u0010£\u0001\u001a\u00030¤\u00012\u0007\u0010¥\u0001\u001a\u00020\r2\u0007\u0010y\u001a\u00030\u0085\u00012\u0014\u0010¦\u0001\u001a\u000f\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0§\u00012'\u0010¨\u0001\u001a\"\u0012\u0007\u0012\u0005\u0018\u00010\u0085\u0001\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0004\u0012\u00020\u001f0©\u0001H\u0016J&\u0010ª\u0001\u001a\u00030«\u00012\b\u0010 \u001a\u0004\u0018\u00010!2\u0007\u0010¬\u0001\u001a\u0002042\u0007\u0010\u00ad\u0001\u001a\u00020\u000fH\u0016J\u0011\u0010®\u0001\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J]\u0010¯\u0001\u001a\u00020\u001f2\u0006\u0010\b\u001a\u00020\t2\u0011\u0010°\u0001\u001a\f\u0018\u00010±\u0001j\u0005\u0018\u0001`²\u00012\u0007\u0010³\u0001\u001a\u00020~2\t\u0010´\u0001\u001a\u0004\u0018\u00010\u000f2\u0007\u0010µ\u0001\u001a\u00020\u000f2\t\u0010¶\u0001\u001a\u0004\u0018\u00010\u00142\t\u0010·\u0001\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0003\u0010¸\u0001J\n\u0010¹\u0001\u001a\u00030º\u0001H\u0016JQ\u0010»\u0001\u001a\u0010\u0012\u0004\u0012\u00020~\u0012\u0005\u0012\u00030½\u00010¼\u00012\n\u0010¾\u0001\u001a\u0005\u0018\u00010¿\u00012\b\u0010À\u0001\u001a\u00030Á\u00012\u0007\u0010Â\u0001\u001a\u00020\u000f2\u000f\u0010Ã\u0001\u001a\n\u0012\u0005\u0012\u00030Å\u00010Ä\u00012\b\u0010Æ\u0001\u001a\u00030Ç\u0001H\u0016J\n\u0010È\u0001\u001a\u00030Ç\u0001H\u0016J\n\u0010É\u0001\u001a\u00030Ê\u0001H\u0016J7\u0010Ë\u0001\u001a\u00020\u001f2\u0007\u0010Ì\u0001\u001a\u00020@2\u0006\u0010N\u001a\u00020V2\b\u0010{\u001a\u0004\u0018\u00010|2\b\u0010]\u001a\u0004\u0018\u00010^2\u0007\u0010Í\u0001\u001a\u00020\u000fH\u0016J\u0012\u0010Ò\u0001\u001a\u00030Ó\u00012\u0006\u0010 \u001a\u00020!H\u0016J\n\u0010Ô\u0001\u001a\u00030Õ\u0001H\u0016J.\u0010Ö\u0001\u001a\u00020\u001f2\u0007\u0010Ì\u0001\u001a\u00020@2\u0006\u0010N\u001a\u00020V2\b\u0010{\u001a\u0004\u0018\u00010|2\b\u0010]\u001a\u0004\u0018\u00010^H\u0016J5\u0010×\u0001\u001a\u00020\u001f2\u0007\u0010Ø\u0001\u001a\u00020\r2\t\u0010\u0081\u0001\u001a\u0004\u0018\u00010\r2\n\u0010\u0082\u0001\u001a\u0005\u0018\u00010\u0083\u00012\n\u0010Ù\u0001\u001a\u0005\u0018\u00010Ú\u0001H\u0016JF\u0010Û\u0001\u001a\u00020\u001f2\u0007\u0010Ü\u0001\u001a\u00020\u000f2\t\u0010Ý\u0001\u001a\u0004\u0018\u00010\r2\u0006\u0010 \u001a\u00020!2\n\u0010Þ\u0001\u001a\u0005\u0018\u00010ß\u00012\n\u0010à\u0001\u001a\u0005\u0018\u00010Ú\u00012\u0007\u0010 \u0001\u001a\u00020\u000fH\u0016J\u001a\u0010á\u0001\u001a\u00020\u001f2\b\u0010â\u0001\u001a\u00030ã\u0001H\u0096@¢\u0006\u0003\u0010ä\u0001J\n\u0010å\u0001\u001a\u00030æ\u0001H\u0016J\t\u0010ç\u0001\u001a\u00020\u000fH\u0016J\u0012\u0010è\u0001\u001a\u000b\u0012\u0004\u0012\u00020\u000f\u0018\u00010Ï\u0001H\u0016J\t\u0010é\u0001\u001a\u00020\u000fH\u0016J\n\u0010ê\u0001\u001a\u00030ë\u0001H\u0016J\u001a\u0010ì\u0001\u001a\u00020\t2\u0006\u0010j\u001a\u00020F2\u0007\u0010í\u0001\u001a\u00020DH\u0016J)\u0010î\u0001\u001a\u00020\u001f2\u0007\u0010\u0080\u0001\u001a\u00020\r2\u0015\u0010ï\u0001\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\r0JH\u0016J\n\u0010ð\u0001\u001a\u00030ñ\u0001H\u0016J\t\u0010ò\u0001\u001a\u00020\u000fH\u0016J\u0017\u0010ó\u0001\u001a\u0004\u0018\u00010\r2\n\u0010ô\u0001\u001a\u0005\u0018\u00010õ\u0001H\u0016J\u0016\u0010ö\u0001\u001a\u0004\u0018\u00010&2\t\u0010÷\u0001\u001a\u0004\u0018\u00010&H\u0016J\u0018\u0010ø\u0001\u001a\u0005\u0018\u00010õ\u00012\n\u0010÷\u0001\u001a\u0005\u0018\u00010õ\u0001H\u0016J\u0015\u0010ù\u0001\u001a\u00020\u000f2\n\u0010ô\u0001\u001a\u0005\u0018\u00010õ\u0001H\u0016J\u0017\u0010ú\u0001\u001a\u0004\u0018\u00010\r2\n\u0010ô\u0001\u001a\u0005\u0018\u00010õ\u0001H\u0016J+\u0010û\u0001\u001a\u0004\u0018\u00010F2\b\u0010/\u001a\u0004\u0018\u00010\r2\t\u0010÷\u0001\u001a\u0004\u0018\u00010F2\t\u0010ü\u0001\u001a\u0004\u0018\u00010\rH\u0016J+\u0010ý\u0001\u001a\u0004\u0018\u00010F2\b\u0010/\u001a\u0004\u0018\u00010\r2\t\u0010÷\u0001\u001a\u0004\u0018\u00010F2\t\u0010ü\u0001\u001a\u0004\u0018\u00010\rH\u0016J\u0018\u0010þ\u0001\u001a\u0005\u0018\u00010õ\u00012\n\u0010÷\u0001\u001a\u0005\u0018\u00010õ\u0001H\u0016JG\u0010ÿ\u0001\u001a\u00020\r2\u0007\u0010\u0080\u0002\u001a\u00020\r2\u0006\u0010b\u001a\u00020\r2\u0007\u0010\u009f\u0001\u001a\u00020\r2\u0007\u0010\u0081\u0002\u001a\u00020\r2\u0007\u0010 \u0001\u001a\u00020\u000f2\t\u0010\u0082\u0002\u001a\u0004\u0018\u00010\rH\u0096@¢\u0006\u0003\u0010\u0083\u0002J-\u0010\u0084\u0002\u001a\u0004\u0018\u00010F2\u0006\u0010j\u001a\u00020F2\u0006\u0010b\u001a\u00020\r2\t\u0010ü\u0001\u001a\u0004\u0018\u00010\rH\u0096@¢\u0006\u0003\u0010\u0085\u0002J\t\u0010\u0086\u0002\u001a\u00020\u001fH\u0016J$\u0010\u0087\u0002\u001a\u00020\u001f2\u0007\u0010\u0080\u0001\u001a\u00020\r2\u0007\u0010\u0088\u0002\u001a\u00020\r2\u0007\u0010\u0089\u0002\u001a\u00020\rH\u0016J\u0012\u0010\u008a\u0002\u001a\u00020\u001f2\u0007\u0010\u008b\u0002\u001a\u00020\rH\u0016J\t\u0010\u008c\u0002\u001a\u00020\u001fH\u0016R\u0014\u0010W\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bX\u0010YR\u0014\u0010Z\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b[\u0010YR\u001e\u0010Î\u0001\u001a\t\u0012\u0004\u0012\u0002040Ï\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\bÐ\u0001\u0010Ñ\u0001¨\u0006\u008f\u0002"}, d2 = {"Lcom/larus/bmhome/AiChatUgcAIGCServiceImpl;", "Lcom/larus/platform/spi/IAIChatUgcAIGCService;", "<init>", "()V", "getInstructionUtils", "Lcom/larus/bmhome/instruction/IInstructionUtils;", "createInstructionEditorViewModel", "Lcom/larus/bmhome/view/actionbar/edit/IInstructionEditorViewModel;", "fragment", "Landroidx/fragment/app/Fragment;", "getOriginalRatioId", "", "getActionBarLanguage", "", "isChatDoubleTabActivity", "", "activity", "Landroid/app/Activity;", "handleCreationSendUiEventResult", "bundle", "Landroid/os/Bundle;", "createAiBeautifyPickPhotoHelper", "Lcom/larus/bmhome/instruction/helper/IAiBeautifyPickPhotoHelper;", "createTemplatePrefetchHelper", "Lcom/larus/bmhome/instruction/ITemplatePrefetchHelper;", "getBachDetectMessageExtKey", "openMusicDetailApplet", "arguments", "page", "routeMode", "saveMusicCreationAndLoading", "", "context", "Landroid/content/Context;", "viewParent", "Landroid/view/ViewGroup;", "downloadTaskKey", "userCreation", "Lcom/larus/platform/api/creation/UserCreation;", "currentPage", "clickFrom", "scope", "Lkotlinx/coroutines/CoroutineScope;", "sendMusicSave", "completeCallback", "Lkotlin/Function1;", "collectMusicDownLoadingStatus", "vid", "loadingAction", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setRedDotNotShow", "instructionType", "", "getActionBarRouterProcessors", "Ljava/util/ArrayList;", "Lcom/larus/bmhome/view/actionbar/custom/router/IOpenBySchemaRouterProcessor;", "Lkotlin/collections/ArrayList;", "shareVideo", "shareItemConfig", "Lcom/larus/platform/model/share/ShareItemConfig;", "shareFragment", "Landroidx/fragment/app/DialogFragment;", "messageId", "shareContainer", "Landroid/view/View;", "shareScene", "Lcom/larus/bmhome/share/ShareScene;", "eventParams", "Lcom/larus/bmhome/utils/VideoDetailEventParams;", "videoContent", "Lcom/larus/platform/model/video/VideoPlayData;", "initUrl", "reportType", "metaDataMap", "", "(Landroid/content/Context;Lcom/larus/platform/model/share/ShareItemConfig;Landroidx/fragment/app/DialogFragment;Ljava/lang/String;Landroid/view/View;Lcom/larus/bmhome/share/ShareScene;Lkotlinx/coroutines/CoroutineScope;Lcom/larus/bmhome/utils/VideoDetailEventParams;Lcom/larus/platform/model/video/VideoPlayData;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/Map;)V", "createMixedVideoDetailFragment", "parentFragment", "data", "Lcom/larus/bmhome/creation/bean/ICreationContentData;", "initPosition", "position", "isReadonlyForwardDetail", "createChatSpeakerView", "isShowProgressLoadingMsg", "message", "Lcom/larus/im/bean/message/Message;", "globalShowDownload", "getGlobalShowDownload", "()Z", "globalShowShare", "getGlobalShowShare", "bindImageLongClickHelper", "modelProvider", "Lcom/larus/bmhome/chat/api/MessageAdapter$ModelProvider;", "imageItemInfo", "Lcom/larus/bmhome/chat/layout/holder/image/bean/ImageItemInfo;", "parentScrollView", "scene", "extraParams", "Lorg/json/JSONObject;", "getVideoPlayerEngineManager", "Lcom/larus/bmhome/video/player/IVideoPlayerEngineManager;", "getIVideoPlayControl", "Lcom/larus/bmhome/video/view/IVideoPlayControl;", "handleVideoExtendAction", "videoPlayData", "msgId", "prompt", "refImageUrl", "creationTaskId", "openNewChatPage", "sendRemoteVideo", "Lkotlin/Function4;", "Lkotlin/ParameterName;", "name", ChatDraftItem.TYPE_TEXT, "extMap", "trackerExt", "onResult", "handleImageBeautifyAction", "params", "Lcom/larus/bmhome/chat/bean/AiEditFunctionParams;", "adapter", "Lcom/larus/bmhome/chat/api/MessageAdapter;", "actionBarItem", "Lcom/larus/bmhome/actionbar/model/CustomActionBarItem;", "imageBeautifyId", "cvsId", "botId", "conversation", "Lcom/larus/im/bean/conversation/Conversation;", "doSend", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility$OnSendParams;", "sendImageRemoveMessage", "Ljava/io/Serializable;", "Lcom/larus/bmhome/view/actionbar/edit/creationpage/data/IInstructionHitPoint;", "showDialogFragment", "dismissCreationPage", "Lkotlin/Function0;", "findMessageFromAdapter", "createSketchLoadingController", "Lcom/larus/bmhome/chat/layout/holder/progressloading/ISketchLoadingController;", "viewStub", "Landroid/view/ViewStub;", "getVideoGenerateSaver", "Lcom/larus/bmhome/video/save_share/IVideoGenerateSaver;", "bindVideoGenerateLongClickHelper", "Lcom/larus/bmhome/chat/layout/holder/video/bean/AiGenVideoContentData;", "bindSearchVideoLongClickHelper", "convertDataBean", "Lcom/larus/bmhome/chat/layout/holder/image/bean/ImageContentData;", "convertVideoGenerateDataBean", "saveVideoAndLoading", "videoDetailEventParams", "clickMethod", "needTrace", "enableUseSRDownLoad", "customTraceParams", "subScene", "isAIGC", "dismissLoadingCallback", "uploadBeforeSendNestedFiles", "dependency", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputDependency;", "originContent", "ext", "", "originalLogic", "Lkotlin/Function3;", "createRightLayoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "orientation", "reverseLayout", "getInstructionEditorViewModel", "executeOnClickCustomActionBarAction", "component", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "Lcom/larus/ui/arch/component/external/ContentComponent;", "item", "switchCheckState", "notReport", "bizArgs", "sendMsgMenuKey", "(Landroidx/fragment/app/Fragment;Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;Lcom/larus/bmhome/actionbar/model/CustomActionBarItem;Ljava/lang/Boolean;ZLandroid/os/Bundle;Ljava/lang/String;)V", "createInstructionBizAdapterFactory", "Lcom/larus/bmhome/instruction/biz/IInstructionBizAdapterFactory;", "createCustomActionBarAdapter", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/larus/bmhome/view/actionbar/BaseActionBarHolder;", "chatParam", "Lcom/larus/bmhome/chat/ChatParam;", "callback", "Lcom/larus/bmhome/view/actionbar/custom/CustomActionBarHolderCallback;", "isImmerseStyle", "segmentFactory", "", "Lcom/larus/bmhome/view/actionbar/api/IActionBarSegment;", "actionBarShowTipCache", "Lcom/larus/bmhome/view/actionbar/custom/IActionBarShowTipCache;", "createActionBarShowTipCache", "createActionBarRedDotCacheHelper", "Lcom/larus/bmhome/view/actionbar/custom/cache/IActionBarRedDotCacheHelper;", "bindCommonLongClickListener", "targetView", "useSimpleMenuGroupCreator", "curChatDoubleTabPageIndex", "Lkotlinx/coroutines/flow/StateFlow;", "getCurChatDoubleTabPageIndex", "()Lkotlinx/coroutines/flow/StateFlow;", "createChatTitle", "Lcom/larus/platform/api/IChatTitle;", "getLoadingResource", "Lcom/larus/bmhome/chat/layout/holder/progressloading/LoadingResource;", "bindLyricsToSongListBoxLongClickListener", "reportClickReEditEvent", "reeditType", "trackNode", "Lcom/ixigua/lib/track/ITrackNode;", "downloadImg", "share", "imgUrl", "sharePanelEventParam", "Lcom/larus/bmhome/share/panel/SharePanelEventParam;", "node", "uploadImage", "param", "Lcom/larus/platform/model/upload/ResourceUploadParam;", "(Lcom/larus/platform/model/upload/ResourceUploadParam;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getActionBarContentBuilder", "Lcom/larus/bmhome/view/actionbar/custom/IActionBarContentBuilder;", "isZDisableWcb", "zLotteryGuideMsgShowFlow", "canShowZLotteryGuideMsg", "getMediaMessageWatcher", "Lcom/larus/bmhome/chat/model/media/IMediaMessageWatcher;", "createCreationDetailPromptVideoFragment", "eventParam", "setSendMessageTrackExtMap", "sendMsgTrackMap", "getChatConversationComponent", "Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;", "isNoWatermarkEnabled", "resolveUserCreationVideoCoverResourceUri", "imageInfo", "Lcom/larus/platform/api/ImageInfo;", "selectUserCreation", "original", "resolveNoWatermarkUserCreationImageInfo", "isUserCreationImageNoWatermarkSelected", "getUserCreationNoWatermarkImageDownloadUrl", "selectVideoPlayData", "coverKey", "selectPreviewVideoPlayData", "resolvePreviewUserCreationImageInfo", "resolveFileFinalDownloadUrlIfNeeded", "url", "contentType", "resourceKey", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resolveNoWatermarkVideoPlayData", "(Lcom/larus/platform/model/video/VideoPlayData;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onMembershipStatusChanged", "setChatTraceCreationInfo", "creationId", "creationType", "logSendStart", "traceId", "tryBreakMusic", "ExtendVideoParam", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class AiChatUgcAIGCServiceImpl implements IAIChatUgcAIGCService {
    public static final /* synthetic */ int b = 0;

    public static final class a {
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJV\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\u0006HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u000f\u0010\rR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u001a\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0014\u0010\r¨\u0006#"}, d2 = {"Lcom/larus/bmhome/AiChatUgcAIGCServiceImpl$ExtendVideoParam;", "", "msgId", "", "uid", "vid", "", "refImgUrl", "refPrompt", "creationTaskId", "<init>", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)V", "getMsgId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getUid", "getVid", "()Ljava/lang/String;", "getRefImgUrl", "getRefPrompt", "getCreationTaskId", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)Lcom/larus/bmhome/AiChatUgcAIGCServiceImpl$ExtendVideoParam;", "equals", "", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    public static final class b {

        @SerializedName("task_id")
        private final Long creationTaskId;

        @SerializedName("msg_id")
        private final Long msgId;

        @SerializedName("ref_img_url")
        private final String refImgUrl;

        @SerializedName("ref_prompt")
        private final String refPrompt;

        @SerializedName("user_id")
        private final Long uid;

        @SerializedName("vid")
        private final String vid;

        public b() {
            this(null, null, null, null, null, null);
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.msgId, r6.msgId) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.uid, r6.uid) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.vid, r6.vid) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.refImgUrl, r6.refImgUrl) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.refPrompt, r6.refPrompt) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.creationTaskId, r6.creationTaskId) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            Long r0 = this.msgId;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            Long r4 = this.uid;
            if (r4 != null) goto L9;
            int r5 = 0;
        L10:
            int r6 = (r3 + r5) * 31;
            String r7 = this.vid;
            if (r7 != null) goto L13;
            int r8 = 0;
        L14:
            int r9 = (r6 + r8) * 31;
            String r10 = this.refImgUrl;
            if (r10 != null) goto L17;
            int r11 = 0;
        L18:
            int r12 = (r9 + r11) * 31;
            String r13 = this.refPrompt;
            if (r13 != null) goto L21;
            int r14 = 0;
        L22:
            int r15 = (r12 + r14) * 31;
            Long r16 = this.creationTaskId;
            if (r16 == null) goto L27;
            r1 = r16.hashCode();
        L27:
            return r15 + r1;
        L21:
            r14 = r13.hashCode();
            goto L22
        L17:
            r11 = r10.hashCode();
            goto L18
        L13:
            r8 = r7.hashCode();
            goto L14
        L9:
            r5 = r4.hashCode();
            goto L10
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "ExtendVideoParam(msgId=" + this.msgId + ", uid=" + this.uid + ", vid=" + this.vid + ", refImgUrl=" + this.refImgUrl + ", refPrompt=" + this.refPrompt + ", creationTaskId=" + this.creationTaskId + ')';
        }

        public b(Long r1, Long r2, String r3, String r4, String r5, Long r6) {
            this.msgId = r1;
            this.uid = r2;
            this.vid = r3;
            this.refImgUrl = r4;
            this.refPrompt = r5;
            this.creationTaskId = r6;
        }
    }

    static {
    }

    public AiChatUgcAIGCServiceImpl() {
    }

    public final String F0() {
        return "face_sign";
    }

    public final long R() {
        return 0;
    }

    public final i1<Boolean> E() {
        return IZLotteryService.a.E();
    }

    public final boolean E0() {
        return ((Boolean) ScrollImageViewHolder.r.getValue()).booleanValue();
    }

    public final void H() {
        CreationNoWatermarkManager r0 = CreationNoWatermarkManager.a;
        monitor-enter(r0);
        CreationNoWatermarkManager.t++;     // Catch: Throwable -> L7
        CreationNoWatermarkManager.w++;     // Catch: Throwable -> L7
        CreationNoWatermarkManager.g();     // Catch: Throwable -> L7
        monitor-exit(r0);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final boolean J() {
        IZLotteryService.Companion r0 = IZLotteryService.a;
        hy9.b r2 = r0.h(false);
        if (r2.a == false) goto L18;
        hy9.g r3 = r2.d;
        if (r3 == null) goto L12;
        Integer r4 = r3.f();
        if (r4 == null) goto L12;
        if (r4.intValue() != 1) goto L12;
        boolean r5 = true;
    L13:
        if (r5 == true) goto L15;
        return false;
    L15:
        if (r0.w(r2.b) == true) goto L20;
        return true;
    L20:
        return false;
    L12:
        r5 = false;
        goto L13
    L18:
        return false;
    }

    public final String K0() {
        int r0 = CustomActionBar.c0;
        return CustomActionBar.b.a();
    }

    public final vp8.i M() {
        return new vp8.k();
    }

    public final ArrayList<com.larus.bmhome.view.actionbar.custom.router.b> P() {
        ArrayList r0 = c.a;
        return c.a;
    }

    public final boolean U() {
        return CreationNoWatermarkManager.a.D();
    }

    public final x2 W() {
        return new n();
    }

    public final ComponentFeature X() {
        return new ChatConversationComponent();
    }

    public final com.larus.bmhome.view.actionbar.custom.cache.k f0() {
        return new com.larus.bmhome.view.actionbar.custom.cache.j();
    }

    public final boolean l0() {
        return ((Boolean) ScrollImageViewHolder.q.getValue()).booleanValue();
    }

    public final void n4() {
        int r0 = MusicCell.g;
        MusicCell$a.a();
    }

    public final com.larus.bmhome.instruction.m w0() {
        return new TemplatePrefetchHelper();
    }

    public final boolean y0() {
        return IZLotteryService.a.f();
    }

    public final com.larus.bmhome.chat.layout.holder.progressloading.e x0() {
        return GenImgLoadingResourceGetter.a();
    }

    public final com.larus.bmhome.video.save_share.a G() {
        return VideoGenerateSaver.a;
    }

    public final ps8.a L() {
        return d.a;
    }

    public final yh8.a b0() {
        return yh8.c.a;
    }

    public final com.larus.bmhome.instruction.j e0() {
        return c2.a;
    }

    public final i1<Integer> n0() {
        return com.larus.bmhome.chat.v.b;
    }

    public final w2 z0() {
        return com.larus.bmhome.view.actionbar.custom.e.a;
    }

    public final void A0(int r7) {
        com.larus.bmhome.view.actionbar.custom.cache.j r0 = new com.larus.bmhome.view.actionbar.custom.cache.j();
        com.larus.bmhome.chat.api.e0 r1 = (com.larus.bmhome.chat.api.e0) AuthModelDelegate.b.e().getValue();
        if (r1 == null) goto L8;
        LaunchInfo r2 = r1.a;
        if (r2 == null) goto L8;
        String r3 = r2.W();
        if (r3 == null) goto L8;
    L9:
        z0 r4 = ((IActionBarService) ServiceManager.get().getService(IActionBarService.class)).e(r7);
        if (r4 == null) goto L15;
        Long r5 = r4.a;
        if (r5 == null) goto L15;
        String r6 = r5.toString();
        if (r6 == null) goto L15;
    L16:
        FLogger.a.i("ActionBarRedDotCacheHelper", "setRedDotNotShow instructionType=" + r7 + ", itemId" + r6 + ",mainBotId:" + r3);
        r0.a(r3, r6);
        return;
    L15:
        r6 = "";
    L8:
        r3 = "7234781073513644036";
        goto L9
    }

    public final qs8.a B0(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        return new AiGenVideoPlayControlView(r5, null, 6, 0);
    }

    public final com.larus.bmhome.instruction.helper.f H0(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        return new AiBeautifyPickPhotoHelper(r2);
    }

    public final com.larus.bmhome.view.actionbar.edit.c I(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        return new ViewModelProvider(r2).get(InstructionEditorViewModel.class);
    }

    public final View K(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        ChatSpeaker r0 = new ChatSpeaker(r2);
        if (y48.h.a() == false) goto L5;
        int r3 = y48.f.h;
        r0.setSpec(y48.f.a.a().a());
    L5:
        return r0;
    }

    public final com.larus.platform.api.g0 O(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return new ChatTitle(r2);
    }

    public final ISketchLoadingController Y(ViewStub r2) {
        return new SketchLoadingController(r2);
    }

    public final String Z(ImageInfo r2) {
        CreationNoWatermarkManager.a.getClass();
        return CreationNoWatermarkManager.u0(r2);
    }

    public final void d(String r2) {
        Intrinsics.checkNotNullParameter(r2, "traceId");
        com.larus.bmhome.chat.trace.z.a.d(r2);
    }

    public final ImageContentData d0(Message r1) {
        return ImageHolderDispatcher.a(r1);
    }

    public final boolean g0(Message r3) {
        Intrinsics.checkNotNullParameter(r3, "message");
        Lazy r1 = com.larus.bmhome.chat.layout.holder.progressloading.h.a;
        Intrinsics.checkNotNullParameter(r3, "message");
        if (com.larus.bmhome.chat.layout.holder.progressloading.h.d(r3) == true) goto L5;
    L7:
        return false;
    L5:
        if (com.larus.bmhome.chat.layout.holder.progressloading.h.a(r3) == LoadingType.COMMON_LOADING) goto L7;
        return true;
    }

    public final boolean k0(ImageInfo r3) {
        CreationNoWatermarkManager r0 = CreationNoWatermarkManager.a;
        if (r0.D() == true) goto L6;
        return false;
    L6:
        return r0.y(CreationNoWatermarkManager.t0(r3));
    }

    public final ImageInfo o0(ImageInfo r4) {
        CreationNoWatermarkManager r0 = CreationNoWatermarkManager.a;
        r0.getClass();
        return (ImageInfo) r0.U(CreationNoWatermarkManager.t0(r4), r4, false).a;
    }

    public final AiGenVideoContentData r0(Message r2) {
        int r0 = com.larus.bmhome.chat.layout.holder.video.j.a;
        if (r2 == null) goto L5;
        String r3 = r2.getContent();
    L7:
        return com.larus.bmhome.chat.layout.holder.video.j.a(r3);
    L5:
        r3 = null;
        goto L7
    }

    public final boolean s0(FragmentActivity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        return r2 instanceof ChatDoubleTabActivity;
    }

    public final com.larus.bmhome.view.actionbar.edit.c u0(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        return new ViewModelProvider(r2).get(InstructionEditorViewModel.class);
    }

    public final LinearLayoutManager v0(Context r2) {
        return new RightLayoutManager(r2);
    }

    public final boolean F(Fragment r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r3, "bundle");
        ty9.b r4 = s1a.a.g(r2).getAbility(ty9.b.class);
        if (r4 != null) goto L5;
        return false;
    L5:
        if (r4.Ez(r3) != true) goto L9;
        return true;
    L9:
        return false;
    }

    public final Object I0(mr9.j r2, Continuation<? super Unit> r3) {
        Object r4 = ResourceUploader.a.j(r2, r3);
        if (r4 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r4;
    L6:
        return Unit.INSTANCE;
    }

    public final boolean N(Bundle r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "arguments");
        Intrinsics.checkNotNullParameter(r4, "page");
        Intrinsics.checkNotNullParameter("relaunch", "routeMode");
        return IUgcAIGCService.a.X(r3, r4, "relaunch");
    }

    public final Fragment V(nr9.g r2, c4 r3) {
        Intrinsics.checkNotNullParameter(r2, "videoPlayData");
        Intrinsics.checkNotNullParameter(r3, "eventParam");
        return new CreationDetailPromptVideoFragment(r2, r3);
    }

    public final void c(String r2, Map<String, String> r3) {
        Intrinsics.checkNotNullParameter(r2, "cvsId");
        Intrinsics.checkNotNullParameter(r3, "sendMsgTrackMap");
        ChatRenderTrace.b.c(r2, r3);
    }

    public final nr9.g D0(String r2, nr9.g r3, String r4) {
        return CreationNoWatermarkManager.a.c0(r2, r3, r4);
    }

    public final void M0(fn8.w r4, Message r5, q0.a r6) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r5, "data");
        b1.a(new p2(r5, r6.e(), r6, new z2()), r4);
    }

    public final void S(String r5, String r6, String r7) {
        Intrinsics.checkNotNullParameter(r5, "cvsId");
        Intrinsics.checkNotNullParameter(r6, "creationId");
        Intrinsics.checkNotNullParameter(r7, "creationType");
        ChatRenderTrace.b.getClass();
        Intrinsics.checkNotNullParameter(r5, "cvsId");
        Intrinsics.checkNotNullParameter(r6, "creationId");
        Intrinsics.checkNotNullParameter(r7, "creationType");
        ChatRenderTrace.m.put(r5, new Pair(r6, r7));
    }

    public final Object j0(String r2, com.larus.bmhome.bigimg.download.c r3, Continuation r4) {
        Object r5 = MusicVideoSaver.a.c(r2, r3, r4);
        if (r5 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r5;
    L6:
        return Unit.INSTANCE;
    }

    public final void p0(String r3, wc9.e r4, by7.e r5) {
        Intrinsics.checkNotNullParameter("music", "reeditType");
        com.larus.bmhome.chat.trace.n0.a("music", r3, r4, r5);
    }

    public final Object L0(nr9.g r5, String r6, String r7, Continuation<? super nr9.g> r8) {
        if ((r8 instanceof AiChatUgcAIGCServiceImpl$resolveNoWatermarkVideoPlayData$1) == false) goto L7;
        AiChatUgcAIGCServiceImpl$resolveNoWatermarkVideoPlayData$1 r0 = (AiChatUgcAIGCServiceImpl$resolveNoWatermarkVideoPlayData$1) r8;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r9 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        String r10 = (String) r0.L$2;
        r7 = (String) r0.L$1;
        nr9.g r11 = (nr9.g) r0.L$0;
        ResultKt.throwOnFailure(r9);
    L29:
        return CreationNoWatermarkManager.a.h0(r10, r11, r7);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r9);
        String r12 = r5.a;
        if (r12 != null) goto L17;
    L20:
        boolean r4 = true;
    L21:
        if (r4 == false) goto L24;
        return null;
    L24:
        CreationNoWatermarkManager r13 = CreationNoWatermarkManager.a;
        r0.L$0 = r5;
        r0.L$1 = r7;
        r0.L$2 = r12;
        r0.label = 1;
        if (r13.t(r12, r6, r0) != r2) goto L27;
        return r2;
    L27:
        r11 = r5;
        r10 = r12;
        goto L29
    L17:
        if (r12.length() == 0) goto L20;
        r4 = false;
    L7:
        r0 = new AiChatUgcAIGCServiceImpl$resolveNoWatermarkVideoPlayData$1(this, r8);
        goto L8
    }

    public final void h0(View r2, Message r3, q0 r4, q0.a r5) {
        Intrinsics.checkNotNullParameter(r2, "targetView");
        Intrinsics.checkNotNullParameter(r3, "data");
        b1.a(new d1(r3, r4, r5), r2);
    }

    public final ListAdapter m0(ChatParam r10, o1 r11, List r12, x2 r13) {
        Intrinsics.checkNotNullParameter(r11, "callback");
        Intrinsics.checkNotNullParameter(r12, "segmentFactory");
        Intrinsics.checkNotNullParameter(r13, "actionBarShowTipCache");
        return new CustomActionBarAdapter(r10, r11, false, r12, r13, null, 96);
    }

    public final void J0(String r9, Context r10, com.larus.bmhome.share.panel.h r11, by7.e r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r10, "context");
        p1.c(false, r9, r10, r11, r12, null, r13, 32);
    }

    public final void Q(View r13, Message r14, q0 r15, q0.a r16, boolean r17) {
        Intrinsics.checkNotNullParameter(r13, "targetView");
        Intrinsics.checkNotNullParameter(r14, "data");
        if (r17 == false) goto L5;
        t0 r3 = new com.larus.bmhome.chat.layout.holder.helper.x2();
    L6:
        w0 r4 = new w0(new com.larus.bmhome.chat.layout.holder.helper.o(r14, r15, r16, r3, null, null, null, DoraCallStateCode.DOUBAO_CMD_12));
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r13, "targetView");
        r13.setOnLongClickListener(r4);
        return;
    L5:
        r3 = new com.larus.bmhome.chat.layout.holder.helper.n0();
        goto L6
    }

    public final void T(View r8, Message r9, AiGenVideoContentData r10, q0.a r11, JSONObject r12) {
        Intrinsics.checkNotNullParameter(r8, "<this>");
        Intrinsics.checkNotNullParameter(r9, "data");
        if (r11 == null) goto L5;
        q0 r0 = r11.e();
    L6:
        b1.a(new gf8.c(r9, r0, r11, r10, r12), r8);
        return;
    L5:
        r0 = null;
        goto L6
    }

    public final void a(y8 r8, String r9, ICoreInputAbility.OnSendParams r10, Map r11, com.larus.bmhome.chat.component.bottom.core.o1 r12) {
        Intrinsics.checkNotNullParameter(r8, "dependency");
        Intrinsics.checkNotNullParameter(r9, "originContent");
        Intrinsics.checkNotNullParameter(r10, "params");
        Intrinsics.checkNotNullParameter(r11, "ext");
        Intrinsics.checkNotNullParameter(r12, "originalLogic");
        ICreationAttachmentService.a.a(r8, r9, r10, r11, r12);
    }

    public final Fragment q0(Fragment r15, zo8.a r16, int r17, int r18, boolean r19) {
        Intrinsics.checkNotNullParameter(r16, "data");
        AiGenVideoDetailFragment r2 = null;
        if ((r16 instanceof zo8.e) == false) goto L5;
        zo8.e r0 = (zo8.e) r16;
    L6:
        if (r0 == null) goto L12;
        r2 = new AiGenVideoDetailFragment(r0.c, r0.b, true, r0.k, r0.l, r0.m, r19, r0.h, r0.j, r0.i);
        com.larus.bmhome.video.fragment.a0.a r1 = new com.larus.bmhome.video.fragment.a0.a();
        int r3 = r0.d;
        com.larus.bmhome.video.fragment.a0 r4 = r1.a;
        r4.b = r3;
        if (r17 == r18) goto L10;
        boolean r5 = true;
    L11:
        r4.a = r5;
        String r6 = r0.e;
        Intrinsics.checkNotNullParameter(r6, "value");
        com.larus.bmhome.video.fragment.a0 r7 = r1.a;
        r7.getClass();
        Intrinsics.checkNotNullParameter(r6, "<set-?>");
        r7.c = r6;
        r1.b("ugc_video");
        r1.a("immersive_preview");
        VideoPlayView.a r8 = r0.f;
        com.larus.bmhome.video.fragment.a0 r9 = r1.a;
        r9.f = r8;
        r9.g = r0.g;
        r9.h = true;
        Intrinsics.checkNotNullParameter(r9, "config");
        ((BaseVideoDetailFragment) r2).u = r9;
        goto L12
    L10:
        r5 = false;
    L12:
        return r2;
    L5:
        r0 = null;
        goto L6
    }

    public final void C0(View r11, Message r12, q0.a r13, df8.a r14, ViewGroup r15, String r16, JSONObject r17) {
        Intrinsics.checkNotNullParameter(r11, "<this>");
        Intrinsics.checkNotNullParameter(r12, "data");
        if (r13 == null) goto L5;
        q0 r1 = r13.e();
    L6:
        q0 r4 = r1;
        if (Intrinsics.areEqual(r16, "homework_answer_action") == false) goto L9;
        com.larus.bmhome.chat.layout.holder.helper.f r8 = new com.larus.bmhome.chat.layout.holder.helper.f("homework_answer_action", new com.larus.bmhome.chat.layout.holder.helper.n0());
    L10:
        b1.a(new com.larus.bmhome.chat.layout.holder.image.p0(r12, r4, r13, r14, r15, r8, r17), r11);
        return;
    L9:
        r8 = new com.larus.bmhome.chat.layout.holder.helper.f("creativity_answer_action", new u0());
        goto L10
    L5:
        r1 = null;
        goto L6
    }

    public final Object D(String r9, String r10, String r11, String r12, boolean r13, String r14, Continuation<? super String> r15) {
        return IUgcAIGCService.a.D(r9, r10, r11, r12, r13, r14, r15);
    }

    public final void a0(Fragment r12, CreationEditorComponent r13, z0 r14, Boolean r15, boolean r16, Bundle r17, String r18) {
        Intrinsics.checkNotNullParameter(r12, "fragment");
        Intrinsics.checkNotNullParameter(r14, "item");
        CustomActionBarViewModel.executeOnClickAction$default(new ViewModelProvider(r12, new CustomActionBarViewModelFactory()).get(CustomActionBarViewModel.class), r13, r14, Boolean.FALSE, false, r17, null, 40, null);
    }

    public final void c0(final Context r16, ViewGroup r17, String r18, UserCreation r19, String r20, String r21, LifecycleCoroutineScope r22, boolean r23, final Function1 r24) {
        Intrinsics.checkNotNullParameter(r17, "viewParent");
        Intrinsics.checkNotNullParameter(r18, "downloadTaskKey");
        Intrinsics.checkNotNullParameter(r20, "currentPage");
        Intrinsics.checkNotNullParameter(r21, "clickFrom");
        Intrinsics.checkNotNullParameter(r22, "scope");
        Intrinsics.checkNotNullParameter(r24, "completeCallback");
        if (r19 == null) goto L24;
        UserCreationContent r2 = r19.e;
        if (r2 == null) goto L25;
        UserCreationMusic r3 = r2.b;
        if (r3 == null) goto L26;
        com.larus.bmhome.music.protocol.f r6 = com.larus.bmhome.music.protocol.h.a(r3, r19.a);
        String r0 = r6.getLyricsSeekContent();
        if (r0 != null) goto L11;
    L14:
        boolean r1 = true;
    L15:
        if (r1 == false) goto L22;
        return;
    L22:
        JsonReader r4 = new JsonReader(new StringReader(r6.getLyricsSeekContent()));     // Catch: Exception -> L19
        r4.setLenient(true);     // Catch: Exception -> L19
        MusicVideoSaver.k(r16, r17, r18, r6, (LyricsSeekContent) HttpExtKt.f.fromJson(r4, LyricsSeekContent.class), "creation_list", "click_creation_list", null, r22, null, new m(r24, r16), 1536);     // Catch: Exception -> L19
        return;
    L19:
        e = move-exception;
        FLogger.a.e("AiChatUgcAIGCServiceImpl", "error json lyricsSeekContent", e);
        r24.invoke(Boolean.FALSE);
        return;
    L11:
        if (r0.length() == 0) goto L14;
        r1 = false;
        goto L15
    L26:
        return;
    L25:
        return;
    }

    public final void G0(Context r17, nr9.g r18, String r19, String r20, String r21, String r22, boolean r23, Function4<? super nr9.g, ? super String, ? super Map<String, String>, ? super Map<String, String>, Unit> r24, Map<String, String> r25, Function1<? super Boolean, Unit> r26) {
        Intrinsics.checkNotNullParameter(r18, "videoPlayData");
        if (r17 != null) goto L5;
        return;
    L5:
        int r3 = com.larus.platform.service.z2.a.getCreationExtendVideoConfig().c();
        Double r4 = r18.e;
        if (r4 == null) goto L8;
        double r5 = r4.doubleValue();
    L10:
        if (r5 <= r3) goto L15;
        t19.s.a.g(r17, 2131905608, false);
        if (r26 == null) goto L37;
        r26.invoke(Boolean.FALSE);
        return;
    L37:
        return;
    L15:
        if (r23 == false) goto L19;
        Activity r1 = com.larus.utils.i.getActivity(r17);
        if (r1 == null) goto L34;
        com.larus.platform.service.e0.a.d(r1, r18, r19, r20, r21, r22, r25);
    L34:
        if (r26 == null) goto L38;
        r26.invoke(Boolean.TRUE);
        return;
    L38:
        return;
    L19:
        if (r24 == null) goto L34;
        String r0 = r17.getString(2131905606);
        if (r19 == null) goto L23;
        Long r6 = StringsKt.toLongOrNull(r19);
    L24:
        Long r10 = r6;
        Long r11 = StringsKt.toLongOrNull(AccountService.a.getUserId());
        String r12 = r18.a;
        if (r22 == null) goto L29;
        Long r7 = StringsKt.toLongOrNull(r22);
        if (r7 == null) goto L29;
        long r8 = r7.longValue();
    L30:
        String r9 = HttpExtKt.p(new b(r10, r11, r12, r21, r20, Long.valueOf(r8)));
        if (r9 != null) goto L33;
        r9 = "";
    L33:
        r24.invoke(r18, r0, MapsKt.mapOf(TuplesKt.to("extend_video_params", r9)), r25);
    L29:
        r8 = 0;
        goto L30
    L23:
        r6 = null;
        goto L24
    L8:
        r5 = 0.0d;
        goto L10
    }

    public final void t0(Context r16, jr9.a r17, String r18, View r19, ShareScene r20, CoroutineScope r21, c4 r22, nr9.g r23, Integer r24, Map r25) {
        Intrinsics.checkNotNullParameter(r17, "shareItemConfig");
        Intrinsics.checkNotNullParameter(r18, "messageId");
        Intrinsics.checkNotNullParameter(r19, "shareContainer");
        Intrinsics.checkNotNullParameter(r20, "shareScene");
        Intrinsics.checkNotNullParameter(r21, "scope");
        Intrinsics.checkNotNullParameter(r22, "eventParams");
        VideoGenerateShareHelper.a.getClass();
        VideoGenerateShareHelper.h(r16, null, r17, null, r18, r19, r20, r21, null, r22, r23, null, null, null, r25);
    }

    public final void b(Context r15, nr9.g r16, c4 r17, String r18, CoroutineScope r19, boolean r20, boolean r21, JSONObject r22, Map<String, String> r23, String r24, boolean r25, Function4<? super Integer, ? super String, ? super Long, ? super Boolean, Unit> r26) {
        Intrinsics.checkNotNullParameter(r17, "videoDetailEventParams");
        Intrinsics.checkNotNullParameter(r18, "clickMethod");
        Intrinsics.checkNotNullParameter(r19, "scope");
        Intrinsics.checkNotNullParameter(r26, "dismissLoadingCallback");
        VideoGenerateSaver.a.b(r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26);
    }

    public final void i0(Context r18, ic8.f r19, CoroutineScope r20, z0 r21, int r22, boolean r23, String r24, String r25, String r26, wc9.e r27, Function1<? super ICoreInputAbility.OnSendParams, Unit> r28, final Function4<? super Serializable, ? super String, ? super String, ? super zs8.a, Unit> r29, final Function1<? super DialogFragment, Unit> r30, Function0<Unit> r31) {
        Intrinsics.checkNotNullParameter(r18, "context");
        Intrinsics.checkNotNullParameter(r19, "params");
        Intrinsics.checkNotNullParameter(r25, "cvsId");
        AiCreationEditUtils r2 = AiCreationEditUtils.a;
        if (r29 == null) goto L5;
        Function4 r14 = new i(r29);
    L6:
        if (r30 == null) goto L8;
        Function1 r0 = new j(r30);
    L9:
        Function1 r15 = r0;
        if (r31 != null) goto L12;
        Function0<Unit> r16 = new l();
    L13:
        r2.getClass();
        AiCreationEditUtils.h(r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r14, r15, r16);
        return;
    L12:
        r16 = r31;
        goto L13
    L8:
        r0 = new k();
        goto L9
    L5:
        r14 = null;
        goto L6
    }
}
