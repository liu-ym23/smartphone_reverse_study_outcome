package com.larus.bmhome.music.widget;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.collection.LruCache;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewpager2.widget.ViewPager2;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonReader;
import com.larus.bmhome.bigimg.download.CommonDownLoadLayout;
import com.larus.bmhome.bigimg.template.CommonTemplateLayout;
import com.larus.bmhome.chat.tips.GuidePriority;
import com.larus.bmhome.music.databinding.LarusFragmentMusicPlayerDetailBinding;
import com.larus.bmhome.music.databinding.LarusMusicCoverViewHolderBinding;
import com.larus.bmhome.music.databinding.LarusViewMusicPlayerSlidingInfoBinding;
import com.larus.bmhome.music.edit.MusicEditDialogFragment;
import com.larus.bmhome.music.edit.MusicInfoEditHelper;
import com.larus.bmhome.music.protocol.MusicShareApi;
import com.larus.bmhome.share.ShareScene;
import com.larus.bmhome.social.userchat.model.TriggerSendLoading;
import com.larus.bmhome.view.CreationOperateContainerView;
import com.larus.common.apphost.AppHost;
import com.larus.common_res.common_ui.databinding.LarusCreationOperateContainerLayoutBinding;
import com.larus.common_ui.fragment.CommonSlideDialogFragment;
import com.larus.common_ui.fragment.helper.EditPanelType;
import com.larus.common_ui.video.progress.PlayerProgressView;
import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.LyricsSeekContent;
import com.larus.im.bean.message.block.MusicCreationContent;
import com.larus.network.http.HttpExtKt;
import com.larus.platform.api.IFlowChatThemeConfigProvider;
import com.larus.platform.api.ModifiedUserCreationMusic;
import com.larus.platform.model.apptheme.AdaptThemeFeatureKey;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.skydoves.balloon.Balloon;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.io.StringReader;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import org.json.JSONException;
import org.json.JSONObject;
import v19.i5;
import v19.j5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000î\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b&\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001b\u0018\u0000 Í\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0002Í\u0001B\u0089\u0001\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\u0012\b\u0002\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u000f\u0012\u0016\b\u0002\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\b\b\u0002\u0010\u0017\u001a\u00020\r\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u000b¢\u0006\u0004\b\u0019\u0010\u001aB\t\b\u0016¢\u0006\u0004\b\u0019\u0010\u001bJ\b\u0010V\u001a\u00020\u0016H\u0002J\b\u0010W\u001a\u00020\u0014H\u0002J\b\u0010X\u001a\u00020\u0014H\u0002J\u0010\u0010Y\u001a\u00020\u00142\u0006\u0010Z\u001a\u00020\u000bH\u0002J\u0018\u0010[\u001a\u00020\u00162\b\u0010K\u001a\u0004\u0018\u00010\u0016H\u0082@¢\u0006\u0002\u0010\\J\u0006\u0010]\u001a\u00020\u0016J\u0006\u0010^\u001a\u00020\u0016J\u0014\u0010_\u001a\u0004\u0018\u00010`2\b\b\u0002\u0010a\u001a\u00020\rH\u0002J\b\u0010b\u001a\u00020\u0014H\u0002J$\u0010c\u001a\u00020\u00142\b\u0010K\u001a\u0004\u0018\u00010\u00162\b\u0010d\u001a\u0004\u0018\u00010\u00162\u0006\u0010e\u001a\u00020\rH\u0002J\b\u0010f\u001a\u00020\u0014H\u0016J\u0010\u0010g\u001a\u00020\u00142\u0006\u0010h\u001a\u00020\rH\u0002J\b\u0010i\u001a\u00020\u0014H\u0002J\u0010\u0010j\u001a\u00020\u00142\u0006\u0010h\u001a\u00020\rH\u0002J\b\u0010o\u001a\u00020\u0014H\u0016J\u0006\u0010p\u001a\u00020\u0014J\u0006\u0010q\u001a\u00020\u0014J\b\u0010r\u001a\u00020\u0014H\u0002J\u0012\u0010s\u001a\u00020\u00142\b\u0010t\u001a\u0004\u0018\u00010uH\u0016J&\u0010v\u001a\u0004\u0018\u00010&2\u0006\u0010w\u001a\u00020x2\b\u0010y\u001a\u0004\u0018\u00010z2\b\u0010t\u001a\u0004\u0018\u00010uH\u0016J\u001a\u0010{\u001a\u00020\u00142\u0006\u0010|\u001a\u00020&2\b\u0010t\u001a\u0004\u0018\u00010uH\u0016J\b\u0010}\u001a\u00020\u0014H\u0002J\b\u0010~\u001a\u00020\u0014H\u0002J\b\u0010\u007f\u001a\u00020FH\u0002J\u0016\u0010\u0080\u0001\u001a\u00020\u00142\u000b\b\u0002\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u0016H\u0002J\t\u0010\u0082\u0001\u001a\u00020\u0014H\u0002J\t\u0010\u0083\u0001\u001a\u00020\u0014H\u0002J\u0017\u0010\u0084\u0001\u001a\u00020\u00142\u0006\u0010Z\u001a\u00020\u000b2\u0006\u0010d\u001a\u00020\u0016J\u0010\u0010\u0085\u0001\u001a\u00020\u00142\u0007\u0010\u0086\u0001\u001a\u00020\rJ\u0012\u0010\u0087\u0001\u001a\u00020\u00142\u0007\u0010\u0088\u0001\u001a\u00020\u000bH\u0002J\u0011\u0010\u0089\u0001\u001a\u00020\u00142\u0006\u0010\b\u001a\u00020\tH\u0002J\u0019\u0010\u008a\u0001\u001a\u00020\u00142\u0007\u0010\u008b\u0001\u001a\u00020\r2\u0007\u0010\u008c\u0001\u001a\u00020\rJ\t\u0010\u008d\u0001\u001a\u00020\u0014H\u0002J\t\u0010\u008e\u0001\u001a\u00020\u0014H\u0002J$\u0010\u008f\u0001\u001a\u00020\u00142\u0007\u0010\u0090\u0001\u001a\u00020\t2\u0007\u0010\u0091\u0001\u001a\u00020\r2\u0007\u0010\u0092\u0001\u001a\u00020\rH\u0002J\u0010\u0010\u0093\u0001\u001a\u00020\u00142\u0007\u0010\u0094\u0001\u001a\u00020\tJ:\u0010\u0095\u0001\u001a\u00020\u00072\t\u0010\u0096\u0001\u001a\u0004\u0018\u00010\u00072\u0007\u0010\u0097\u0001\u001a\u00020\t2\t\u0010\u0098\u0001\u001a\u0004\u0018\u00010\u00052\u0007\u0010\u0091\u0001\u001a\u00020\r2\u0007\u0010\u0092\u0001\u001a\u00020\rH\u0002J\t\u0010\u0099\u0001\u001a\u00020\u0014H\u0016J\t\u0010\u009a\u0001\u001a\u00020\u0014H\u0016J\t\u0010\u009b\u0001\u001a\u00020\u0014H\u0016J\t\u0010\u009c\u0001\u001a\u00020\u0014H\u0016J\t\u0010\u009d\u0001\u001a\u00020\u0014H\u0016J\t\u0010\u009e\u0001\u001a\u00020\u0014H\u0016J\u001c\u0010\u009f\u0001\u001a\u00020\u00142\b\u0010 \u0001\u001a\u00030¡\u00012\u0007\u0010¢\u0001\u001a\u00020\rH\u0016J\t\u0010£\u0001\u001a\u00020\u0014H\u0016J\t\u0010¤\u0001\u001a\u00020\u0014H\u0016J\n\u0010¥\u0001\u001a\u00030¦\u0001H\u0016J\t\u0010§\u0001\u001a\u00020\u0014H\u0002J\u0012\u0010¨\u0001\u001a\u00020\u00142\u0007\u0010\u0094\u0001\u001a\u00020\tH\u0002J\u001d\u0010©\u0001\u001a\u00020\u00142\u0007\u0010\u0094\u0001\u001a\u00020\t2\t\b\u0002\u0010ª\u0001\u001a\u00020\rH\u0002J\u0012\u0010«\u0001\u001a\u00020\u00142\u0007\u0010\u0094\u0001\u001a\u00020\tH\u0002J\u001d\u0010¬\u0001\u001a\u00020\u0014*\u00020\u001f2\u000e\u0010\u00ad\u0001\u001a\t\u0012\u0004\u0012\u00020\u000b0®\u0001H\u0002J\u001a\u0010¯\u0001\u001a\u00020\u0014*\u00020\u001f2\u000b\b\u0002\u0010°\u0001\u001a\u0004\u0018\u00010\tH\u0002J\t\u0010±\u0001\u001a\u00020\u0014H\u0003J\u0017\u0010²\u0001\u001a\u00020\u0014*\u00030³\u00012\u0007\u0010°\u0001\u001a\u00020\tH\u0002J\u0017\u0010´\u0001\u001a\u00020\u0014*\u00030³\u00012\u0007\u0010°\u0001\u001a\u00020\tH\u0002J\u0015\u0010µ\u0001\u001a\u00020\u0014*\u00020\u001f2\u0006\u0010\b\u001a\u00020\tH\u0002J\t\u0010¶\u0001\u001a\u00020&H\u0002J\t\u0010¸\u0001\u001a\u00020\u0014H\u0002J\t\u0010¹\u0001\u001a\u00020\rH\u0002J\u0012\u0010º\u0001\u001a\u00020\u00142\u0007\u0010»\u0001\u001a\u00020\rH\u0002J\t\u0010¼\u0001\u001a\u00020\u0014H\u0002J\u0012\u0010½\u0001\u001a\u00020\u00142\u0007\u0010°\u0001\u001a\u00020\tH\u0002J\u000b\u0010¾\u0001\u001a\u0004\u0018\u00010zH\u0002J\u0016\u0010¿\u0001\u001a\u00020\u0014*\u00020\u001f2\u0007\u0010°\u0001\u001a\u00020\tH\u0002J\t\u0010À\u0001\u001a\u00020\u0014H\u0016J\u0016\u0010Â\u0001\u001a\u00020\u0014*\u00020\u001f2\u0007\u0010°\u0001\u001a\u00020\tH\u0002J#\u0010Ã\u0001\u001a\u00020\u0014*\u00020\u001f2\u000b\b\u0002\u0010Ä\u0001\u001a\u0004\u0018\u00010\u00162\u0007\u0010°\u0001\u001a\u00020\tH\u0002J#\u0010Å\u0001\u001a\u00020\u0014*\u00020\u001f2\u000b\b\u0002\u0010Æ\u0001\u001a\u0004\u0018\u00010\u00162\u0007\u0010°\u0001\u001a\u00020\tH\u0002J\u0016\u0010Ç\u0001\u001a\u00020\r2\u000b\b\u0002\u0010È\u0001\u001a\u0004\u0018\u00010\u0016H\u0002J#\u0010É\u0001\u001a\u00020\u0014*\u00020\u001f2\u000b\b\u0002\u0010Ê\u0001\u001a\u0004\u0018\u00010\u00162\u0007\u0010°\u0001\u001a\u00020\tH\u0002J\t\u0010Ë\u0001\u001a\u00020\u0014H\u0002J\t\u0010Ì\u0001\u001a\u00020\u0014H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010$\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u000201X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u000201X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u000204X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u00107\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u001a\u0010<\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u0014\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00160BX\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010C\u001a\b\u0012\u0004\u0012\u00020D0BX\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010E\u001a\u00020F8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bI\u0010J\u001a\u0004\bG\u0010HR\u000e\u0010K\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010L\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010M\u001a\u0004\u0018\u00010N8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bQ\u0010J\u001a\u0004\bO\u0010PR\u001b\u0010R\u001a\u00020&8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bU\u0010J\u001a\u0004\bS\u0010TR\u0014\u0010k\u001a\u00020l8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bm\u0010nR\u000f\u0010·\u0001\u001a\u000204X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010Á\u0001\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006Î\u0001"}, d2 = {"Lcom/larus/bmhome/music/widget/MusicPlayerDetailFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/larus/bmhome/music/player/BoxMusicPlayer$PlayerView;", "Lcom/larus/common_ui/fragment/helper/IContainerFunctionInterface;", "bindSongToLyricsMessage", "Lcom/larus/im/bean/message/Message;", "initMusicPlayerDataState", "Lcom/larus/bmhome/music/player/MusicPlayerData;", "initState", "Lcom/larus/im/bean/message/block/MusicCreationContent;", "initCurrentPausePercent", "", "outPullingFinished", "", "bindShareContainerRef", "Ljava/lang/ref/WeakReference;", "Landroid/widget/FrameLayout;", "useTemplateCallback", "Lkotlin/Function1;", "Lcom/larus/bmhome/instruction/core/model/music/MusicGenTemplate;", "", "enterFrom", "", "isMusicAppletDetail", "parentSlideDirection", "<init>", "(Lcom/larus/im/bean/message/Message;Lcom/larus/bmhome/music/player/MusicPlayerData;Lcom/larus/im/bean/message/block/MusicCreationContent;IZLjava/lang/ref/WeakReference;Lkotlin/jvm/functions/Function1;Ljava/lang/String;ZI)V", "()V", "player", "Lcom/larus/bmhome/music/player/BoxMusicPlayer;", "binding", "Lcom/larus/bmhome/music/databinding/LarusFragmentMusicPlayerDetailBinding;", "playlistViewPagerAdapter", "Lcom/larus/bmhome/music/widget/PlaylistViewPagerAdapter;", "mState", "mPlayerState", "behavior", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "Landroid/view/View;", "lyricsSeekContent", "Lcom/larus/im/bean/message/block/LyricsSeekContent;", "musicCreationContentPollingJob", "Lkotlinx/coroutines/Job;", "destroyed", "draging", "currentPosition", "currentLyricContent", "currentFallbackContent", "waitingForVidTiming", "", "waitingForVidProgress", "latestDragSeekTime", "", "clickFromNext", "clickFromPrevious", "currentCreationButtonStatus", "getCurrentCreationButtonStatus", "()I", "setCurrentCreationButtonStatus", "(I)V", "currentCreationId", "getCurrentCreationId", "()Ljava/lang/String;", "setCurrentCreationId", "(Ljava/lang/String;)V", "editCoverLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "editCoverNewLauncher", "Landroid/content/Intent;", "coverEditCallback", "Lcom/larus/bmhome/music/edit/IMusicInfoEditCallback;", "getCoverEditCallback", "()Lcom/larus/bmhome/music/edit/IMusicInfoEditCallback;", "coverEditCallback$delegate", "Lkotlin/Lazy;", "messageId", "latestCreationPrivateStatus", "loadingDialog", "Lcom/larus/common_ui/dialog/CommonLoadDialog;", "getLoadingDialog", "()Lcom/larus/common_ui/dialog/CommonLoadDialog;", "loadingDialog$delegate", "moreMenu", "getMoreMenu", "()Landroid/view/View;", "moreMenu$delegate", "getCurrentItemId", "initButtonClickListener", "publishCreation", "refreshButtonStatus", "status", "getLatestCreationId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getItemName", "getCurrentStatus", "buildMusicAppletDetailMobParams", "Lorg/json/JSONObject;", "includeFromEntrance", "addCreation", "reportMusicAddCreation", "creationId", "success", "onResume", "openPrivacyDialog", "private", "deleteCreation", "setCreationPrivacy", "viewContext", "Landroid/content/Context;", "getViewContext", "()Landroid/content/Context;", "onDestroy", "pauseForAppletBackground", "abandonPlaybackControlForAppletBackground", "dismissFragment", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "applyMusicAppletDetailStyle", "initResultLauncher", "buildCoverEditCallback", "uploadCoverFailed", "message", "onEditCoverSuccess", "initPlaylistViewPager", "updateCurrentCreationButtonStatus", "enableCreationOperator", "enable", "onMusicContentSwitched", "position", "initAction", "updateClickFrom", "clickNext", "clickPrevious", "playNextAction", "playPreviousAction", "shuffleAction", "nextState", "next", "previous", "appendNewCreation", "newState", "buildNewMusicPlayState", "previousState", "musicContentState", "musicMessage", "hideLoadingView", "showLoadingView", "hidePlayIcon", "showPlayIcon", "hideProgressBarView", "showProgressBarView", "setProgressV2", "percent", "", "smooth", "showReadyState", "showPlayingState", "getScope", "Lkotlinx/coroutines/CoroutineScope;", "launchMusicCreationContentPollingJob", "acquireDurationAndInitProgressBar", "applyState", "byDiff", "applyCoverImageState", "initProgressBar", "duration", "Lkotlin/Function0;", "applyDetailTintState", "state", "setUIToDark", "bindCoverImageState", "Lcom/larus/bmhome/music/databinding/LarusMusicCoverViewHolderBinding;", "setCoverClickListener", "initClickListeners", "buildMoreMenu", "lastClickTime", "showEditCoverDialog", "isQuickClick", "showLoadingDialog", "show", "launchEditMusicName", "doShareAction", "resolveShareContainer", "applyCanShareState", "onShareClick", "downloading", "applyDownloadState", "applyCreatorNameState", "specifiedCreator", "applySongState", "specifiedTitle", "canEditMusicName", "title", "applyLyricsState", "specifiedLyrics", "closeSelf", "onMoreClick", "Companion", "music_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MusicPlayerDetailFragment extends Fragment implements com.larus.bmhome.music.player.a.InterfaceC0021a, g19.a {
    public static final /* synthetic */ int O = 0;
    public long A;
    public boolean B;
    public boolean C;
    public int D;
    public String E;
    public ActivityResultLauncher<String> F;
    public ActivityResultLauncher<Intent> G;
    public final Lazy H;
    public final String I;
    public int J;
    public final Lazy K;
    public final Lazy L;
    public long M;
    public boolean N;
    public final Message d;
    public final com.larus.bmhome.music.player.j e;
    public final MusicCreationContent f;
    public final int g;
    public final boolean h;
    public final WeakReference<FrameLayout> i;
    public final Function1<bq8.a, Unit> j;
    public final boolean k;
    public final int l;
    public final com.larus.bmhome.music.player.a m;
    public LarusFragmentMusicPlayerDetailBinding n;
    public PlaylistViewPagerAdapter o;
    public MusicCreationContent p;
    public com.larus.bmhome.music.player.j q;
    public LyricsSeekContent r;
    public Job s;
    public boolean t;
    public boolean u;
    public int v;
    public String w;
    public String x;
    public double y;
    public double z;

    public static final class a {
    }

    public static final class b implements com.larus.bmhome.music.edit.a {
        public final /* synthetic */ MusicPlayerDetailFragment a;

        @Override // com.larus.bmhome.music.edit.a
        public final void b(ModifiedUserCreationMusic r1) {
        }

        @Override // com.larus.bmhome.music.edit.a
        public final com.larus.bmhome.music.edit.j c() {
            com.larus.bmhome.music.player.j r1 = this.a.q;
            if (r1 == null) goto L6;
            String r2 = r1.j();
            if (r2 == null) goto L6;
        L8:
            return new com.larus.bmhome.music.edit.j(r2, "", this.a.p);
        L6:
            r2 = "";
            goto L8
        }

        public b(MusicPlayerDetailFragment r1) {
            this.a = r1;
        }

        @Override // com.larus.bmhome.music.edit.a
        public final void a(com.larus.bmhome.music.edit.v r3) {
            Intrinsics.checkNotNullParameter(r3, "status");
            MusicPlayerDetailFragment r0 = this.a;
            int r1 = MusicPlayerDetailFragment.O;
            r0.ja0(false);
            if ((r3 instanceof com.larus.bmhome.music.edit.v.a) == false) goto L6;
            t19.s r2 = t19.s.a;
            Context r4 = this.a.getViewContext();
            String r5 = ((com.larus.bmhome.music.edit.v.a) r3).a;
            r2.getClass();
            t19.s.c(r4, r5);
            return;
        }
    }

    static {
    }

    public MusicPlayerDetailFragment() {
        this(null, null, null, 0, false, null, null, false, 1);
        Y90();     // Catch: IllegalStateException -> L5
        return;
    L5:
        FLogger.a.e("MusicPlayerDetailFragment", "fallback by dismiss failed");
    }

    public final void FU(int r1) {
    }

    public final void Oh() {
    }

    public final void VT() {
    }

    public final boolean dc() {
        return false;
    }

    @Override // com.larus.bmhome.music.player.a.InterfaceC0021a
    public final void mP(int r1, boolean r2) {
    }

    public final void u() {
    }

    @Override // com.larus.bmhome.music.player.a.InterfaceC0021a
    public final void FK() {
        FLogger.a.d("MusicPlayerDetailFragment", "[showReadyState]");
        LarusFragmentMusicPlayerDetailBinding r0 = this.n;
        if (r0 == null) goto L10;
        MusicPlayerSlidingInfoView r1 = r0.g;
        if (r1 == null) goto L11;
        LarusViewMusicPlayerSlidingInfoBinding r2 = r1.getBinding();
        if (r2 == null) goto L12;
        com.larus.utils.e1.x(r2.h);
        com.larus.utils.e1.o(r2.g);
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // com.larus.bmhome.music.player.a.InterfaceC0021a
    public final void Lf() {
        FLogger.a.d("MusicPlayerDetailFragment", "[hideProgressBarView]");
    }

    @Override // com.larus.bmhome.music.player.a.InterfaceC0021a
    public final void Lr() {
        FLogger.a.d("MusicPlayerDetailFragment", "[showPlayIcon]");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new MusicPlayerDetailFragment$showPlayIcon$1(this, null), 3, null);
    }

    @Override // com.larus.bmhome.music.player.a.InterfaceC0021a
    public final void OK() {
        FLogger.a.d("MusicPlayerDetailFragment", "[hidePlayIcon]");
        LarusFragmentMusicPlayerDetailBinding r0 = this.n;
        if (r0 == null) goto L10;
        MusicPlayerSlidingInfoView r1 = r0.g;
        if (r1 == null) goto L11;
        LarusViewMusicPlayerSlidingInfoBinding r2 = r1.getBinding();
        if (r2 == null) goto L12;
        com.larus.utils.e1.o(r2.h);
        com.larus.utils.e1.x(r2.g);
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // com.larus.bmhome.music.player.a.InterfaceC0021a
    public final void UY() {
        FLogger.a.d("MusicPlayerDetailFragment", "[showProgressBarView]");
    }

    public final void Y90() {
        if (this.k == false) goto L5;
        return;
    L5:
        MusicDetailPagerFragment r0 = getParentFragment();
        if ((r0 instanceof MusicDetailPagerFragment) == false) goto L8;
        MusicDetailPagerFragment r1 = r0;
    L9:
        if (r1 == null) goto L12;
        CommonSlideDialogFragment.V90(r1, null, 3);
        return;
    L12:
        return;
    L8:
        r1 = null;
        goto L9
    }

    public final String aa0() {
        MusicCreationContent r0 = this.p;
        boolean r1 = false;
        if (r0 == null) goto L8;
        if (r0.isBlock() != true) goto L8;
        r1 = true;
    L8:
        if (r1 == false) goto L16;
        MusicCreationContent r2 = this.p;
        if (r2 == null) goto L33;
        String r3 = r2.getUniqueTaskId();
        if (r3 != null) goto L15;
        return TriggerSendLoading.NO_LOADING;
    L15:
        return r3;
    L33:
        return TriggerSendLoading.NO_LOADING;
    L16:
        MusicCreationContent r4 = this.p;
        if (r4 == null) goto L21;
        ad9.b r5 = r4.getPlayList();
        if (r5 == null) goto L21;
        String r6 = r5.getItemId();
    L23:
        if (com.larus.utils.o0.d(r6) == false) goto L35;
        MusicCreationContent r7 = this.p;
        if (r7 == null) goto L36;
        ad9.b r8 = r7.getPlayList();
        if (r8 == null) goto L37;
        String r9 = r8.getItemId();
        if (r9 != null) goto L32;
        return TriggerSendLoading.NO_LOADING;
    L32:
        return r9;
    L37:
        return TriggerSendLoading.NO_LOADING;
    L36:
        return TriggerSendLoading.NO_LOADING;
    L35:
        return TriggerSendLoading.NO_LOADING;
    L21:
        r6 = null;
        goto L23
    }

    public final String ba0() {
        int r0 = this.D;
        if (r0 != 1) goto L5;
        return "-1";
    L5:
        if (r0 != 2) goto L7;
        return TriggerSendLoading.NO_LOADING;
    L7:
        if (r0 == 3) goto L9;
        return "";
    L9:
        return "1";
    }

    public final String ca0() {
        int r0 = this.D;
        if (r0 != 1) goto L5;
        return "go_public";
    L5:
        if (r0 != 2) goto L7;
        return "go_public";
    L7:
        if (r0 == 3) goto L9;
        return "";
    L9:
        return "already_public";
    }

    public final void d70() {
        if (this.p == null) goto L55;
        String r2 = null;
        if (this.k == false) goto L13;
        LarusFragmentMusicPlayerDetailBinding r1 = this.n;
        if (r1 == null) goto L11;
        FrameLayout r3 = r1.j;
        if (r3 == null) goto L11;
    L17:
        FrameLayout r4 = r3;
    L19:
        if (r4 == null) goto L56;
        final MusicCreationContent r11 = this.p;
        if (r11 == null) goto L57;
        LifecycleCoroutineScope r5 = LifecycleOwnerKt.getLifecycleScope(this);
        if (this.k == false) goto L36;
        MusicDetailPagerFragment r6 = getParentFragment();
        if ((r6 instanceof MusicDetailPagerFragment) == false) goto L29;
        MusicDetailPagerFragment r7 = r6;
    L30:
        if (r7 == null) goto L33;
        kr8.o r8 = r7.oa0(r11, this.q);
    L32:
        final kr8.o r15 = r8;
    L37:
        LruCache<String, wc9.e> r9 = ko8.a.a;
        long r10 = ko8.a.e;
        String r19 = ko8.a.h(r10);
        String r21 = ko8.a.e(r10);
        com.larus.bmhome.music.player.j r12 = this.q;
        if (r12 == null) goto L40;
        String r22 = r12.d();
    L41:
        String r13 = this.I;
        Message r14 = this.d;
        if (this.k == false) goto L44;
        Function0 r25 = new o1(r15, r11);
    L45:
        com.larus.bmhome.share.panel.h r16 = new com.larus.bmhome.share.panel.h(null, null, r19, "music_detail", r21, r22, r13, null, r25, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, r14, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, -761, -257, 1023);
        MusicShareApi r17 = MusicShareApi.a;
        com.larus.common_ui.dialog.l0 r18 = (com.larus.common_ui.dialog.l0) this.K.getValue();
        com.larus.bmhome.music.player.j r20 = this.q;
        if (r20 == null) goto L49;
        String r23 = r20.j();
        if (r23 == null) goto L49;
    L50:
        String r24 = r23;
        Message r110 = this.d;
        ShareScene r111 = ShareScene.MUSIC_VIDEO;
        com.larus.bmhome.music.player.j r26 = this.q;
        if (r26 == null) goto L53;
        r2 = r26.d();
    L53:
        MusicShareApi.d(r4, r5, r18, "music_detail", "click_music_detail", r24, r110, r11, r111, r16, r2, r15, 1024);
        return;
    L49:
        r23 = "";
        goto L50
    L44:
        r25 = null;
        goto L45
    L40:
        r22 = null;
        goto L41
    L33:
        com.larus.bmhome.music.player.j r27 = this.q;
        if (r27 == null) goto L36;
        r8 = r27.d;
        goto L32
    L29:
        r7 = null;
    L36:
        r15 = null;
        goto L37
    L57:
        return;
    L56:
        return;
    L11:
        if (r1 == null) goto L18;
        FrameLayout r28 = r1.a;
    L16:
        r3 = r28;
    L18:
        r4 = null;
        goto L19
    L13:
        WeakReference<FrameLayout> r29 = this.i;
        if (r29 == null) goto L18;
        r28 = r29.get();
        goto L16
    }

    @Override // com.larus.bmhome.music.player.a.InterfaceC0021a
    public final void f20() {
        FLogger.a.d("MusicPlayerDetailFragment", "[showPlayingState]");
        LarusFragmentMusicPlayerDetailBinding r0 = this.n;
        if (r0 == null) goto L10;
        MusicPlayerSlidingInfoView r1 = r0.g;
        if (r1 == null) goto L11;
        LarusViewMusicPlayerSlidingInfoBinding r2 = r1.getBinding();
        if (r2 == null) goto L12;
        com.larus.utils.e1.o(r2.h);
        com.larus.utils.e1.x(r2.g);
        return;
    L12:
        return;
    L11:
        return;
    }

    public final void ha0() {
        LarusFragmentMusicPlayerDetailBinding r0 = this.n;
        if (r0 == null) goto L11;
        MusicPlayerSlidingInfoView r1 = r0.g;
        if (r1 == null) goto L11;
        LarusViewMusicPlayerSlidingInfoBinding r2 = r1.getBinding();
        if (r2 == null) goto L11;
        TextView r3 = r2.j;
        if (r3 == null) goto L11;
        r3.setTextColor(ContextCompat.getColor(m2.a, 2131103681));
    L11:
        LarusFragmentMusicPlayerDetailBinding r4 = this.n;
        if (r4 == null) goto L20;
        MusicPlayerSlidingInfoView r5 = r4.g;
        if (r5 == null) goto L20;
        LarusViewMusicPlayerSlidingInfoBinding r6 = r5.getBinding();
        if (r6 == null) goto L20;
        TextView r7 = r6.b;
        if (r7 == null) goto L20;
        r7.setTextColor(ContextCompat.getColor(m2.a, 2131106539));
    L20:
        LarusFragmentMusicPlayerDetailBinding r8 = this.n;
        if (r8 == null) goto L25;
        AppCompatImageView r9 = r8.c;
        if (r9 == null) goto L25;
        r9.setImageResource(2131239329);
    L25:
        LarusFragmentMusicPlayerDetailBinding r10 = this.n;
        if (r10 == null) goto L31;
        PlayerProgressView r11 = r10.h;
        if (r11 == null) goto L32;
        r11.Z5();
        return;
    L32:
        return;
    }

    @Override // com.larus.bmhome.music.player.a.InterfaceC0021a
    public final void hideLoadingView() {
        FLogger.a.d("MusicPlayerDetailFragment", "[hideLoadingView]");
        LarusFragmentMusicPlayerDetailBinding r0 = this.n;
        if (r0 == null) goto L8;
        PlayerProgressView r1 = r0.h;
        if (r1 == null) goto L9;
        r1.c6();
        return;
    L9:
        return;
    }

    public final void ia0() {
        MusicCreationContent r2 = this.p;
        if (r2 == null) goto L6;
        String r3 = r2.getVid();
        if (r3 == null) goto L6;
    L7:
        kr8.c r1 = new kr8.c("music_detail", r3, 1);
        FragmentActivity r4 = null;
        kr8.l.a.b(r1, null, 3);
        MusicCreationContent r5 = this.p;
        if (r5 != null) goto L10;
        r5 = new MusicCreationContent();
    L10:
        MusicCreationContent r6 = r5;
        LyricsSeekContent r7 = this.r;
        com.larus.bmhome.music.player.j r8 = this.q;
        if (r8 == null) goto L16;
        String r9 = r8.j();
        if (r9 == null) goto L16;
        String r10 = r9;
    L17:
        Message r11 = this.d;
        LarusFragmentMusicPlayerDetailBinding r12 = this.n;
        if (r12 == null) goto L20;
        FrameLayout r13 = r12.j;
    L21:
        MusicEditDialogFragment r14 = new MusicEditDialogFragment(r6, r7, r10, null, r11, r13, LifecycleOwnerKt.getLifecycleScope(this), null, null, null, 904);
        Context r15 = getContext();
        if ((r15 instanceof FragmentActivity) == false) goto L24;
        r4 = (FragmentActivity) r15;
    L24:
        if (r4 == null) goto L34;
        FragmentManager r16 = r4.getSupportFragmentManager();
        LandscapeRestrictionOperation r17 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r14, "inviteBotDialog", r17);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r16, r14, r17) == true) goto L35;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L31
    L29:
        r14.show(r16, "inviteBotDialog");
        return;
    L35:
        return;
    L34:
        return;
    L20:
        r13 = null;
    L16:
        r10 = "";
    L6:
        r3 = "";
        goto L7
    }

    public final void o1() {
        LarusFragmentMusicPlayerDetailBinding r0 = this.n;
        if (r0 == null) goto L18;
        FrameLayout r1 = r0.k;
        if (r1 == null) goto L19;
        Balloon r2 = com.larus.bmhome.view.screenmenu.d.a(com.larus.bmhome.view.screenmenu.d.a, r1, (View) this.L.getValue(), false, null, null, null, null, 124);
        ViewGroup.LayoutParams r3 = ((View) this.L.getValue()).getLayoutParams();
        if ((r3 instanceof ViewGroup.MarginLayoutParams) == false) goto L9;
        ViewGroup.MarginLayoutParams r4 = (ViewGroup.MarginLayoutParams) r3;
    L10:
        if (r4 == null) goto L14;
        r4.setMarginEnd((-i5.Q()) + i5.r0());
    L14:
        if (com.larus.utils.i.h(getViewContext()) == false) goto L16;
        r2.x(r1, -r1.getMeasuredWidth(), -i5.Q());
        return;
    L16:
        r2.x(r1, r1.getMeasuredWidth(), -i5.Q());
        return;
    L9:
        r4 = null;
        goto L10
    L19:
        return;
    }

    @Override // com.larus.bmhome.music.player.a.InterfaceC0021a
    public final void showLoadingView() {
        FLogger.a.d("MusicPlayerDetailFragment", "[showLoadingView]");
        LarusFragmentMusicPlayerDetailBinding r0 = this.n;
        if (r0 == null) goto L8;
        PlayerProgressView r1 = r0.h;
        if (r1 == null) goto L9;
        r1.c6();
        return;
    L9:
        return;
    }

    public final void ea0() {
        FragmentActivity r0 = getViewContext();
        kr8.o r2 = null;
        if ((r0 instanceof FragmentActivity) == false) goto L5;
        FragmentActivity r1 = r0;
    L6:
        if (r1 != null) goto L9;
        FLogger.a.e("MusicPlayerDetailFragment", "[launchEditMusicName] viewContext is not FragmentActivity");
        return;
    L9:
        MusicInfoEditHelper r3 = MusicInfoEditHelper.a;
        b r4 = new b(this);
        boolean r5 = this.k;
        if (r5 == false) goto L14;
        com.larus.bmhome.music.player.j r6 = this.q;
        if (r6 == null) goto L14;
        r2 = r6.d;
    L14:
        MusicInfoEditHelper.f(r1, r4, r5, r2);
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.larus.bmhome.music.player.a.InterfaceC0021a
    public final CoroutineScope getScope() {
        return LifecycleOwnerKt.getLifecycleScope(this);
    }

    @Override // com.larus.bmhome.music.player.a.InterfaceC0021a
    public final Context getViewContext() {
        Context r0 = getContext();
        if (r0 == null) goto L5;
        return r0;
    L5:
        return AppHost.a.getApplication();
    }

    public final void onDestroy() {
        super.onDestroy();
        this.t = true;
    }

    public final void onResume() {
        super.onResume();
        boolean r1 = true;
        if (this.k == false) goto L23;
        MusicDetailPagerFragment r0 = getParentFragment();
        if ((r0 instanceof MusicDetailPagerFragment) == false) goto L7;
        MusicDetailPagerFragment r2 = r0;
    L9:
        if (r2 != null) goto L11;
    L19:
        boolean r3 = false;
    L20:
        if (r3 == true) goto L23;
        r1 = false;
        goto L23
    L11:
        if (r2.B == false) goto L16;
        CopyOnWriteArraySet<ir8.c.a> r4 = ir8.c.a;
        if (ir8.c.a(r2.E) == true) goto L16;
        boolean r5 = false;
    L17:
        if (r5 != true) goto L19;
        r3 = true;
    L16:
        r5 = true;
        goto L17
    L7:
        r2 = null;
    L23:
        if (r1 == false) goto L35;
        MusicCreationContent r6 = this.p;
        if (r6 == null) goto L27;
    L28:
        if (r6 == null) goto L32;
        MusicCreationContent r7 = this.p;
        if (r7 == null) goto L35;
        da0(r7);
        goto L35
    L32:
        MusicCreationContent r8 = this.f;
        if (r8 == null) goto L35;
        da0(r8);
        goto L35
    L27:
        if (this.f != null) goto L28;
    L35:
        LarusFragmentMusicPlayerDetailBinding r9 = this.n;
        if (r9 == null) goto L41;
        ConstraintLayout r10 = r9.a;
        if (r10 == null) goto L42;
        r10.postDelayed(new r1(this), 500);
        return;
    L42:
        return;
    }

    @Override // com.larus.bmhome.music.player.a.InterfaceC0021a
    public final void F6() {
        com.larus.bmhome.music.player.a.InterfaceC0021a.C0022a.b();
    }

    public final EditPanelType SQ() {
        return EditPanelType.NONE;
    }

    public static void S90(com.larus.common_ui.dialog.l0 r3) {
        Handler r0 = DialogLancet.resolveDialogHandler(r3);
        if (r0 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r3);
        r3.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L17:
        DialogLancet.afterDialogDismiss(r3);
        return;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r1 == null) goto L17;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r3);
        throw th;
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L8;
        r0.post(DialogLancet.createDismissRunnable(r3));
    }

    @Override // com.larus.bmhome.music.player.a.InterfaceC0021a
    public final void GP(Map<String, String> r1) {
        com.larus.bmhome.music.player.a.InterfaceC0021a.C0022a.d(r1);
    }

    @Override // com.larus.bmhome.music.player.a.InterfaceC0021a
    public final void Ij(Map<String, String> r1) {
        com.larus.bmhome.music.player.a.InterfaceC0021a.C0022a.c(r1);
    }

    public final void U90(MusicCreationContent r5) {
        if (r5 == null) goto L4;
        String r6 = r5.getCoverMainColor();
    L6:
        if (TextUtils.isEmpty(r6) == false) goto L8;
        r6 = "#0E9189";
    L8:
        boolean r0 = false;
        if (r6 != null) goto L11;
    L16:
        if (r0 == false) goto L32;
        int r7 = Color.parseColor(r6);     // Catch: Exception -> L24
        LarusFragmentMusicPlayerDetailBinding r1 = this.n;     // Catch: Exception -> L24
        if (r1 == null) goto L22;
        ConstraintLayout r2 = r1.b;     // Catch: Exception -> L24
        if (r2 == null) goto L22;
        r2.setBackgroundColor(r7);     // Catch: Exception -> L24
    L22:
        ha0();     // Catch: Exception -> L24
        Unit r8 = Unit.INSTANCE;     // Catch: Exception -> L24
        return;
    L24:
        FLogger.a.e("MusicPlayerDetailFragment", "Wrong color string format");
        if (getContext() == null) goto L41;
        LarusFragmentMusicPlayerDetailBinding r9 = this.n;
        if (r9 == null) goto L42;
        ConstraintLayout r10 = r9.b;
        if (r10 == null) goto L43;
        r10.setBackgroundColor(ColorProtector.parseColor("#0E9189"));
        Unit r11 = Unit.INSTANCE;
        return;
    L43:
        return;
    L42:
        return;
    L41:
        return;
    L32:
        if (getContext() == null) goto L45;
        LarusFragmentMusicPlayerDetailBinding r12 = this.n;
        if (r12 == null) goto L46;
        ConstraintLayout r13 = r12.b;
        if (r13 == null) goto L47;
        r13.setBackgroundColor(ColorProtector.parseColor("#0E9189"));
        return;
    L47:
        return;
    L46:
        return;
    L45:
        return;
    L11:
        if (r6.length() <= 0) goto L13;
        boolean r3 = true;
    L14:
        if (r3 != true) goto L16;
        r0 = true;
        goto L16
    L13:
        r3 = false;
        goto L14
    L4:
        r6 = null;
        goto L6
    }

    public final void Z90(boolean r4) {
        LarusFragmentMusicPlayerDetailBinding r0 = this.n;
        if (r0 == null) goto L12;
        CreationOperateContainerView r1 = r0.e;
        if (r1 == null) goto L13;
        ConstraintLayout r2 = r1.getBinding().e;
        if (r4 == false) goto L9;
        float r3 = 1.0f;
    L10:
        r2.setAlpha(r3);
        r1.getBinding().e.setEnabled(r4);
        return;
    L9:
        r3 = 0.3f;
        goto L10
    L13:
        return;
    }

    public final void da0(MusicCreationContent r43) {
        FLogger r2 = FLogger.a;
        r2.d("MusicPlayerDetailFragment", "[initAction]");
        final LarusFragmentMusicPlayerDetailBinding r4 = this.n;
        if (r4 == null) goto L12;
        X90(r43, false);
        LarusFragmentMusicPlayerDetailBinding r6 = this.n;
        if (r6 == null) goto L7;
        Function0 r7 = new i1(this);
        r6.h.k6(GuidePriority.MINOR_GUIDE_PRIORITY);
        r6.h.Y5(r7, new b2(this, r6), 0);
    L7:
        this.m.j(r43.getVideoModel(), new j1(this));
        r4.c.setOnClickListener(new v0(this));
        r4.c.setVisibility(8);
        if ((r43 instanceof bq8.a) == false) goto L10;
        com.larus.utils.e1.q(r4.d);
    L11:
        r4.g.getBinding().h.setOnClickListener(new x0(this));
        r4.g.getBinding().g.setOnClickListener(new y0(this));
        goto L12
    L10:
        r4.d.setOnClickListener(new w0(r4, this));
    L12:
        com.larus.bmhome.music.player.j r8 = this.e;
        if (r8 == null) goto L22;
        com.larus.bmhome.music.player.j r24 = com.larus.bmhome.music.player.j.a(r8, null, null, true, true, null, 30, null, null, false, null, null, null, this.B, this.C, null, 54523135);
        if (TextUtils.isEmpty(r24.p()) == false) goto L20;
        String r1 = r43.getVideoModel();
        if (r1 != null) goto L19;
        r1 = "";
    L19:
        r24 = com.larus.bmhome.music.player.j.a(r24, r1, null, false, false, null, 0, null, null, false, null, null, null, false, false, null, 67108799);
    L20:
        com.larus.bmhome.music.player.j r3 = r24;
        this.m.d(r3);
        this.q = r3;
    L22:
        if (this.g == 0) goto L25;
        r2.i("MusicPlayerDetailFragment", "[initAction] initCurrentPausePercent=" + this.g);
        this.m.b((float) this.g);
        return;
    }

    @Override // com.larus.bmhome.music.player.a.InterfaceC0021a
    public final void eb(Map<String, String> r1) {
        com.larus.bmhome.music.player.a.InterfaceC0021a.C0022a.a(r1);
    }

    public final void fa0(int r4) {
        this.D = r4;
        if (com.larus.bmhome.utils.u.h() == true) goto L5;
    L7:
        boolean r0 = false;
    L8:
        LarusFragmentMusicPlayerDetailBinding r2 = this.n;
        if (r2 == null) goto L16;
        CreationOperateContainerView r3 = r2.e;
        if (r3 == null) goto L16;
        if (r0 == true) goto L15;
        r4 = 0;
    L15:
        r3.r1(r4);
    L16:
        IFlowChatThemeConfigProvider r5 = (IFlowChatThemeConfigProvider) ServiceManager.get().getService(IFlowChatThemeConfigProvider.class);
        if (r5 == null) goto L24;
        LarusFragmentMusicPlayerDetailBinding r1 = this.n;
        if (r1 == null) goto L21;
        ConstraintLayout r6 = r1.e;
    L22:
        r5.b(r6, AdaptThemeFeatureKey.CHAT_CARD_SONG_DETAIL_PUBLISH);
        return;
    L21:
        r6 = null;
        goto L22
    L24:
        return;
    L5:
        if (AccountService.a.isLogin().booleanValue() == false) goto L7;
        r0 = true;
        goto L8
    }

    public final void fy(boolean r30) {
        if (r30 == false) goto L5;
        int r4 = 3;
    L7:
        if (r30 == false) goto L9;
        int r3 = 2;
    L10:
        if (r30 == false) goto L12;
        int r5 = 2;
    L13:
        fa0(r5);
        LarusFragmentMusicPlayerDetailBinding r0 = this.n;
        if (r0 == null) goto L18;
        ConstraintLayout r1 = r0.a;
        if (r1 == null) goto L18;
        r1.postDelayed(new k1(this), 500);
    L18:
        String r12 = this.E;
        String r13 = aa0();
        String r14 = this.I;
        if (r30 == false) goto L21;
        String r16 = "1";
    L22:
        if (r30 == false) goto L24;
        String r17 = TriggerSendLoading.NO_LOADING;
    L25:
        Message r2 = this.d;
        JSONObject r7 = null;
        kr8.o r8 = null;
        if (r2 == null) goto L30;
        Map r6 = r2.getExt();
        if (r6 == null) goto L30;
        String r22 = (String) r6.get("gen_music_create_way");
    L31:
        tx9.o0 r9 = new tx9.o0("music_detail", "chat", r12, r13, r14, "music", r16, r17, null, null, null, null, r22, null, null, null, null, null, 515585);
        if (this.k == false) goto L37;
        kr8.n r10 = kr8.n.a;
        com.larus.bmhome.music.player.j r11 = this.q;
        if (r11 == null) goto L36;
        r8 = r11.d;
    L36:
        r7 = kr8.n.c(r8, "music_detail", true);
    L37:
        tx9.e2.a.b(r9, r7, 1);
        BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new MusicPlayerDetailFragment$setCreationPrivacy$2(this, r3, r5, r4, null), 3, null);
        return;
    L30:
        r22 = null;
        goto L31
    L24:
        r17 = "1";
        goto L25
    L21:
        r16 = TriggerSendLoading.NO_LOADING;
        goto L22
    L12:
        r5 = 3;
        goto L13
    L9:
        r3 = 1;
        goto L10
    L5:
        r4 = 2;
        goto L7
    }

    public final void ja0(boolean r2) {
        if (r2 == false) goto L10;
        com.larus.common_ui.dialog.l0 r3 = (com.larus.common_ui.dialog.l0) this.K.getValue();
        if (r3 != null) goto L6;
        return;
    L6:
        if (DialogLancet.shouldBlockDialogShow(r3) == false) goto L22;
        DialogLancet.handleBlockedDialogShow(r3);
        return;
    L22:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L21
    L9:
        DialogLancet.beforeDialogShow(r3);
        r3.show();
        DialogLancet.afterDialogShow(r3);
        return;
    L10:
        com.larus.common_ui.dialog.l0 r4 = (com.larus.common_ui.dialog.l0) this.K.getValue();
        if (r4 == null) goto L15;
        boolean r0 = true;
        if (r4.isShowing() != true) goto L15;
    L16:
        if (r0 == false) goto L27;
        com.larus.common_ui.dialog.l0 r5 = (com.larus.common_ui.dialog.l0) this.K.getValue();
        if (r5 == null) goto L28;
        S90(r5);
        return;
    L28:
        return;
    L27:
        return;
    L15:
        r0 = false;
        goto L16
    }

    public final void onCreate(Bundle r1) {
        super.onCreate(r1);
        this.J = this.D;
    }

    @Override // com.larus.bmhome.music.player.a.InterfaceC0021a
    public final void Pe(float r8, boolean r9) {
        if (this.u == false) goto L6;
        return;
    L6:
        if (this.A <= (System.currentTimeMillis() - ((long) 500))) goto L9;
        return;
    L9:
        if (this.y != 0.0d) goto L11;
        boolean r0 = true;
    L13:
        if (r0 == true) goto L18;
        LarusFragmentMusicPlayerDetailBinding r10 = this.n;
        if (r10 == null) goto L22;
        FLogger.a.d("MusicPlayerDetailFragment", "[setProgressV2] waitingForVidProgress=" + ((float) this.z) + ", duration " + this.m.j(null, null));
        r10.h.J1(((float) 100) * ((float) this.z), r9);
        return;
    L22:
        return;
    L18:
        LarusFragmentMusicPlayerDetailBinding r1 = this.n;
        if (r1 == null) goto L23;
        FLogger.a.d("MusicPlayerDetailFragment", "[setProgressV2] percent=" + r8 + ", duration " + this.m.j(null, null));
        r1.h.J1(r8, r9);
        r1.g.getBinding().e.Y5((int) ((r8 * ((float) this.m.j(null, null))) * ((float) 10)));
        return;
    L23:
        return;
    L11:
        r0 = false;
        goto L13
    }

    public final void X90(final MusicCreationContent r41, boolean r42) {
        LyricsSeekContent r0 = this.r;
        boolean r4 = true;
        boolean r5 = false;
        if (r0 == null) goto L14;
        List r1 = r0.getUtterances();
        if (r1 != null) goto L7;
    L10:
        boolean r2 = true;
    L11:
        if (r2 == true) goto L14;
        boolean r3 = false;
    L15:
        MusicDetailPagerFragment r6 = null;
        if (r42 == true) goto L18;
        this.p = null;
    L18:
        com.larus.bmhome.music.player.b.a r7 = com.larus.bmhome.music.player.b.a;
        ad9.b r8 = r41.getPlayList();
        com.larus.bmhome.music.player.j r9 = this.q;
        if (r9 == null) goto L22;
        String r10 = r9.j();
        if (r10 == null) goto L22;
    L23:
        r7.getClass();
        com.larus.bmhome.music.player.b.a.a(r8, r10);
        MusicCreationContent r11 = this.p;     // Catch: Exception -> L109
        if (r11 != null) goto L27;
        FLogger.a.i("MusicPlayerDetailFragment", "[handleMusicCreationContentPollingResp] refreshAllVariableComponents");     // Catch: Exception -> L109
        this.p = r41;     // Catch: Exception -> L109
        if (this.n == null) goto L78;
        U90(r41);     // Catch: Exception -> L109
    L78:
        LarusFragmentMusicPlayerDetailBinding r12 = this.n;     // Catch: Exception -> L109
        if (r12 == null) goto L81;
        V90(r12, null, r41);     // Catch: Exception -> L109
    L81:
        LarusFragmentMusicPlayerDetailBinding r13 = this.n;     // Catch: Exception -> L109
        if (r13 == null) goto L84;
        T90(r13, null, r41);     // Catch: Exception -> L109
    L84:
        LarusFragmentMusicPlayerDetailBinding r14 = this.n;     // Catch: Exception -> L109
        if (r14 == null) goto L88;
        W90(r14, null, r41);     // Catch: Exception -> L109
    L88:
        if (this.n == null) goto L95;
        MusicDetailPagerFragment r15 = getParentFragment();     // Catch: Exception -> L109
        if ((r15 instanceof MusicDetailPagerFragment) == false) goto L92;
        MusicDetailPagerFragment r16 = r15;     // Catch: Exception -> L109
    L93:
        if (r16 == null) goto L95;
        r16.Z90(true ^ TextUtils.isEmpty(r41.getVideoModel()));     // Catch: Exception -> L109
        goto L95
    L92:
        r16 = null;
    L95:
        final LarusFragmentMusicPlayerDetailBinding r17 = this.n;     // Catch: Exception -> L109
        if (r17 == null) goto L98;
        com.larus.utils.e1.d(r17.f, new a1(this, r17, r41));     // Catch: Exception -> L109
    L98:
        PlaylistViewPagerAdapter r18 = this.o;     // Catch: Exception -> L109
        if (r18 == null) goto L101;
        r18.z2();     // Catch: Exception -> L109
    L101:
        Fragment r19 = getParentFragment();     // Catch: Exception -> L109
        if ((r19 instanceof MusicDetailPagerFragment) == false) goto L104;
        r6 = (MusicDetailPagerFragment) r19;     // Catch: Exception -> L109
    L104:
        if (r6 == null) goto L111;
        MusicDetailPagerFragment.MusicDetailPagerAdapter r20 = r6.j;     // Catch: Exception -> L109
        if (r20 == null) goto L111;
        r20.B2();     // Catch: Exception -> L109
    L111:
        if (r5 == false) goto L116;
        this.p = r41;
        return;
    L116:
        return;
    L27:
        if (TextUtils.isEmpty(r41.getVideoModel()) == false) goto L29;
    L38:
        Image r21 = r41.getCover();     // Catch: Exception -> L109
        if (r21 == null) goto L41;
        String r22 = r21.key;     // Catch: Exception -> L109
    L42:
        Image r23 = r11.getCover();     // Catch: Exception -> L109
        if (r23 == null) goto L45;
        String r24 = r23.key;     // Catch: Exception -> L109
    L47:
        if (Intrinsics.areEqual(r22, r24) == true) goto L53;
        FLogger.a.i("MusicPlayerDetailFragment", "[handleMusicCreationContentPollingResp] loadCoverImage");     // Catch: Exception -> L109
        PlaylistViewPagerAdapter r25 = this.o;     // Catch: Exception -> L109
        if (r25 == null) goto L51;
        r25.A2(r41);     // Catch: Exception -> L109
    L51:
        r5 = true;
    L53:
        if (Intrinsics.areEqual(r41.getCoverMainColor(), r11.getCoverMainColor()) == true) goto L58;
        FLogger.a.i("MusicPlayerDetailFragment", "[handleMusicCreationContentPollingResp] loadDetailTint");     // Catch: Exception -> L109
        if (this.n == null) goto L58;
        U90(r41);     // Catch: Exception -> L109
    L58:
        if (Intrinsics.areEqual(r41.getCreator(), r11.getCreator()) == true) goto L64;
        FLogger.a.i("MusicPlayerDetailFragment", "[handleMusicCreationContentPollingResp] loadCreatorName");     // Catch: Exception -> L109
        LarusFragmentMusicPlayerDetailBinding r26 = this.n;     // Catch: Exception -> L109
        if (r26 == null) goto L62;
        T90(r26, r41.getCreator(), r41);     // Catch: Exception -> L109
    L62:
        r5 = true;
    L64:
        if (Intrinsics.areEqual(r41.getTitle(), r11.getTitle()) == true) goto L69;
        FLogger.a.i("MusicPlayerDetailFragment", "[handleMusicCreationContentPollingResp] loadSongTitle");     // Catch: Exception -> L109
        LarusFragmentMusicPlayerDetailBinding r27 = this.n;     // Catch: Exception -> L109
        if (r27 == null) goto L68;
        W90(r27, r41.getTitle(), r41);     // Catch: Exception -> L109
    L68:
        r5 = true;
    L69:
        if (r3 == false) goto L73;
        FLogger.a.i("MusicPlayerDetailFragment", "[handleMusicCreationContentPollingResp] loadLyrics");     // Catch: Exception -> L109
        LarusFragmentMusicPlayerDetailBinding r28 = this.n;     // Catch: Exception -> L109
        if (r28 == null) goto L74;
        V90(r28, r41.getLyricsSeekContent(), r41);     // Catch: Exception -> L109
    L74:
        r5 = r4;
        goto L98
    L73:
        r4 = r5;
        goto L74
    L45:
        r24 = null;
        goto L47
    L41:
        r22 = null;
        goto L42
    L29:
        if (this.y != 0.0d) goto L31;
        boolean r29 = true;
    L32:
        if (r29 == true) goto L38;
        this.m.k(true);     // Catch: Exception -> L109
        com.larus.bmhome.music.player.a r30 = this.m;     // Catch: Exception -> L109
        String r110 = r41.getVid();     // Catch: Exception -> L109
        String r31 = r41.getVideoModel();     // Catch: Exception -> L109
        if (r31 != null) goto L36;
        String r111 = "";
    L37:
        r30.e(new com.larus.bmhome.music.player.j(null, null, null, null, null, 0, r111, r110, false, false, null, 0, null, null, null, false, null, null, null, false, false, null, false, false, null, null, 67108671));     // Catch: Exception -> L109
        final double r32 = this.z;     // Catch: Exception -> L109
        this.A = System.currentTimeMillis();     // Catch: Exception -> L109
        this.m.j(r41.getVideoModel(), new v1(this, r32));     // Catch: Exception -> L109
        goto L38
    L36:
        r111 = r31;
        goto L37
    L31:
        r29 = false;
    L109:
        e = move-exception;
        FLogger.a.i("MusicPlayerDetailFragment", "[handleMusicCreationContentPollingResp] " + e);
    L22:
        r10 = "";
        goto L23
    L7:
        if (r1.isEmpty() == true) goto L10;
        r2 = false;
    L14:
        r3 = true;
        goto L15
    }

    public final void ga0(LarusMusicCoverViewHolderBinding r1, MusicCreationContent r2) {
        if ((r2 instanceof bq8.a) == false) goto L6;
        SimpleDraweeView r3 = r1.c;
        r3.setOnClickListener(new m1());
        r3.setOnLongClickListener(new n1());
        return;
    L6:
        SimpleDraweeView r4 = r1.c;
        r4.setOnClickListener(new p1(this));
        r4.setOnLongClickListener(new q1(this));
    }

    public final void onViewCreated(View r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r8, "view");
        if (this.f != null) goto L5;
        return;
    L5:
        da0(this.f);
        LarusFragmentMusicPlayerDetailBinding r10 = this.n;
        if (r10 == null) goto L8;
        PlaylistViewPagerAdapter r0 = new PlaylistViewPagerAdapter(new a2(this), true);
        this.o = r0;
        this.v = r0.d;
        ViewPager2 r11 = r10.g.getBinding().i;
        r11.setAdapter(this.o);
        r11.setOffscreenPageLimit(-1);
        r11.registerOnPageChangeCallback(new MusicPlayerDetailFragment$initPlaylistViewPager$1$2$1(this));
        r11.setUserInputEnabled(false);
        r11.setCurrentItem(this.v, false);
    L8:
        MusicInfoEditHelper r12 = MusicInfoEditHelper.a;
        this.F = MusicInfoEditHelper.h(this, (com.larus.bmhome.music.edit.a) this.H.getValue());
        this.G = MusicInfoEditHelper.i(this, (com.larus.bmhome.music.edit.a) this.H.getValue());
        Job r13 = this.s;
        MusicDetailPagerFragment r1 = null;
        if (r13 == null) goto L12;
        Job.DefaultImpls.cancel$default(r13, null, 1, null);
    L12:
        if (this.d == null) goto L15;
        this.s = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), Dispatchers.getIO().plus(kr8.t.a), null, new MusicPlayerDetailFragment$launchMusicCreationContentPollingJob$1(this, null), 2, null);
    L15:
        LarusFragmentMusicPlayerDetailBinding r14 = this.n;
        if (r14 == null) goto L21;
        MusicPlayerSlidingInfoView r15 = r14.g;
        if (r15 == null) goto L21;
        r15.setDismissCallback(new w1(this));
        r15.setParentSlideDirection(this.l);
    L21:
        if (this.j == null) goto L48;
        LarusFragmentMusicPlayerDetailBinding r16 = this.n;
        if (r16 == null) goto L27;
        CommonTemplateLayout r17 = r16.i;
        if (r17 == null) goto L27;
        com.larus.utils.e1.x(r17);
    L27:
        LarusFragmentMusicPlayerDetailBinding r18 = this.n;
        if (r18 == null) goto L32;
        CommonTemplateLayout r19 = r18.i;
        if (r19 == null) goto L32;
        com.larus.utils.e1.d(r19, new x1(this));
    L32:
        LarusFragmentMusicPlayerDetailBinding r20 = this.n;
        if (r20 == null) goto L37;
        CommonDownLoadLayout r21 = r20.f;
        if (r21 == null) goto L37;
        com.larus.utils.e1.o(r21);
    L37:
        LarusFragmentMusicPlayerDetailBinding r22 = this.n;
        if (r22 == null) goto L53;
        CommonTemplateLayout r23 = r22.i;
        if (r23 == null) goto L53;
        int r24 = com.larus.utils.w0.a;
        Context r25 = getContext();
        if (r25 == null) goto L46;
        Resources r26 = r25.getResources();
        if (r26 == null) goto L46;
        Integer r27 = Integer.valueOf(r26.getColor(2131103298));
    L47:
        r23.setBackground(com.larus.utils.w0.b(r27, Float.valueOf(i5.h()), 0.2f, null, 8));
    L46:
        r27 = null;
    L53:
        LarusFragmentMusicPlayerDetailBinding r28 = this.n;
        if (r28 == null) goto L58;
        ConstraintLayout r29 = r28.a;
        if (r29 == null) goto L58;
        com.larus.utils.i0.a.getClass();
        int r30 = com.larus.utils.i0.e() + i5.h();
        int r2 = r29.getPaddingStart();
        int r3 = r29.getPaddingTop();
        int r4 = r29.getPaddingEnd();
        FLogger.a.i("updatePaddingRelative", "view:" + r29.getClass().getSimpleName() + ",source:,start:" + r2 + ",top:" + r3 + ",end:" + r4 + ",bottom:" + r30);
        r29.setPaddingRelative(r2, r3, r4, r30);
    L58:
        LarusFragmentMusicPlayerDetailBinding r31 = this.n;
        if (r31 == null) goto L67;
        FrameLayout r32 = r31.k;
        if (r32 == null) goto L67;
        ViewGroup.LayoutParams r33 = r32.getLayoutParams();
        if (r33 == null) goto L66;
        ViewGroup.MarginLayoutParams r34 = (ViewGroup.MarginLayoutParams) r33;
        com.larus.utils.i0.a.getClass();
        r34.topMargin = com.larus.utils.i0.g() + i5.r0();
        r32.setLayoutParams(r34);
        goto L67
    L66:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L67:
        LarusFragmentMusicPlayerDetailBinding r35 = this.n;
        if (r35 == null) goto L72;
        CommonDownLoadLayout r36 = r35.f;
        if (r36 == null) goto L72;
        r36.setBackgroundResource(2131238693);
    L72:
        LarusFragmentMusicPlayerDetailBinding r37 = this.n;
        if (r37 == null) goto L82;
        CreationOperateContainerView r38 = r37.e;
        if (r38 == null) goto L82;
        LarusCreationOperateContainerLayoutBinding r39 = r38.getBinding();
        if (r39 == null) goto L82;
        ConstraintLayout r40 = r39.c;
        if (r40 == null) goto L82;
        r40.setBackgroundResource(2131238693);
    L82:
        if (this.k == false) goto L89;
        Fragment r41 = getParentFragment();
        if ((r41 instanceof MusicDetailPagerFragment) == false) goto L86;
        r1 = (MusicDetailPagerFragment) r41;
    L86:
        if (r1 == null) goto L90;
        r1.na0();
        return;
    L90:
        return;
    L89:
        return;
    L48:
        LarusFragmentMusicPlayerDetailBinding r42 = this.n;
        if (r42 == null) goto L53;
        CommonTemplateLayout r43 = r42.i;
        if (r43 == null) goto L53;
        com.larus.utils.e1.o(r43);
        goto L53
    }

    @Override // com.larus.bmhome.music.player.a.InterfaceC0021a
    public final void r30(String r1, Map<String, String> r2) {
        com.larus.bmhome.music.player.a.InterfaceC0021a.C0022a.e(r1, r2);
    }

    public final void T90(LarusFragmentMusicPlayerDetailBinding r5, String r6, MusicCreationContent r7) {
        if (r6 != null) goto L4;
        r6 = r7.getCreator();
    L4:
        String r0 = "";
        String r2 = null;
        if ((r7 instanceof bq8.a) == false) goto L25;
        if (AppHost.a.isOversea() == false) goto L11;
        Context r8 = getContext();
        if (r8 == null) goto L14;
        String r9 = j5.a(r8, 2131894310, 2131901969);
    L15:
        TextView r10 = r5.g.getBinding().b;
        if (r6 != null) goto L18;
    L23:
        r10.setText(r2);
        return;
    L18:
        if (StringsKt.isBlank(r6) == false) goto L22;
        if (r9 != null) goto L21;
        r6 = "";
        goto L22
    L21:
        r6 = r9;
    L22:
        r2 = r6;
    L14:
        r9 = null;
        goto L15
    L11:
        Context r11 = getContext();
        if (r11 == null) goto L14;
        r9 = r11.getString(2131908040);
        goto L15
    L25:
        if (AppHost.a.isOversea() == false) goto L29;
        Context r12 = getContext();
        if (r12 == null) goto L33;
        r2 = j5.b(r12, AccountService.a.getNickname());
    L33:
        TextView r13 = r5.g.getBinding().b;
        if (r2 == null) goto L36;
        r0 = r2;
    L36:
        r13.setText(r0);
        return;
    L29:
        StringBuilder r14 = new StringBuilder();
        r14.append(AccountService.a.getNickname());
        r14.append(" / ");
        Context r15 = getContext();
        if (r15 == null) goto L32;
        r2 = r15.getString(2131908040);
    L32:
        r14.append(r2);
        r2 = r14.toString();
        goto L33
    }

    public final void V90(LarusFragmentMusicPlayerDetailBinding r16, String r17, MusicCreationContent r18) {
        if (r17 != null) goto L5;
        String r4 = r18.getLyricsSeekContent();
    L6:
        boolean r5 = true;
    L11:
        e = move-exception;
        FLogger.a.e("MusicPlayerDetailFragment", "error json addLyricsView", e);
    L15:
        LyricsSeekContent r0 = this.r;
        if (r0 == null) goto L26;
        List r1 = r0.getUtterances();
        if (r1 != null) goto L20;
    L22:
        boolean r2 = false;
    L23:
        if (r2 == true) goto L26;
        boolean r3 = false;
    L28:
        if (r3 == true) goto L30;
        int r6 = 3;
    L42:
        if (r6 == 2) goto L45;
        if (r6 == 3) goto L45;
    L54:
        int r9 = r6;
    L56:
        if (r9 == 2) goto L60;
        if (r9 == 3) goto L60;
    L71:
        FLogger.a.i("MusicPlayerDetailFragment", "[addLyricsView] lyricState:" + r9 + ", lyricsContent:" + r4 + ", lyricsSeekContent:" + this.r);
        if (r18.getMusicGenType() == 2) goto L74;
    L76:
        String r10 = "";
    L77:
        MusicPlayerLyricView r8 = r16.g.getBinding().e;
        LyricsSeekContent r11 = this.r;
        String r7 = r18.getLyrics();
        if (r7 != null) goto L80;
        String r12 = "";
    L81:
        r8.S5(r9, r10, r11, r12, new t0(), new u0());
        return;
    L80:
        r12 = r7;
        goto L81
    L74:
        if (TextUtils.isEmpty(r18.getUseTemplateId()) == false) goto L76;
        r10 = getViewContext().getString(2131907946) + "" + AccountService.a.getNickname();
    L60:
        if (TextUtils.equals(this.w, r4) == true) goto L62;
    L64:
        if (r4 != null) goto L66;
        String r13 = "";
    L67:
        this.w = r13;
        String r14 = r18.getLyrics();
        if (r14 != null) goto L70;
        r14 = "";
    L70:
        this.x = r14;
        goto L71
    L66:
        r13 = r4;
        goto L67
    L62:
        if (TextUtils.equals(this.x, r18.getLyrics()) == false) goto L64;
        return;
    L45:
        if (com.larus.bmhome.music.protocol.a.a(r18) == true) goto L54;
        Message r15 = this.d;
        if (r15 != null) goto L49;
    L51:
        r5 = false;
    L52:
        if (r5 == false) goto L54;
        r9 = 0;
        goto L56
    L49:
        if (com.larus.bmhome.chat.bean.d.j0(r15) == true) goto L51;
    L30:
        if (TextUtils.isEmpty(r18.getLyrics()) == false) goto L40;
        Message r19 = this.d;
        if (r19 != null) goto L34;
    L36:
        boolean r20 = false;
    L37:
        if (r20 == false) goto L39;
        r6 = 1;
        goto L42
    L39:
        r6 = 0;
        goto L42
    L34:
        if (com.larus.bmhome.chat.bean.d.j0(r19) != true) goto L36;
        r20 = true;
        goto L37
    L40:
        r6 = 2;
        goto L42
    L20:
        if (r1.isEmpty() != true) goto L22;
        r2 = true;
    L26:
        r3 = true;
    L13:
        e = move-exception;
        FLogger.a.e("MusicPlayerDetailFragment", "error json addLyricsView", e);
        goto L15
    L8:
        if (TextUtils.isEmpty(r4) == true) goto L15;
        JsonReader r21 = new JsonReader(new StringReader(r4));     // Catch: JsonSyntaxException -> L11 JSONException -> L13
        r21.setLenient(true);     // Catch: JsonSyntaxException -> L11 JSONException -> L13
        this.r = (LyricsSeekContent) GsonProtectorUtils.fromJson(HttpExtKt.f, r21, LyricsSeekContent.class);     // Catch: JsonSyntaxException -> L11 JSONException -> L13
    L5:
        r4 = r17;
        goto L6
    }

    public final void W90(LarusFragmentMusicPlayerDetailBinding r3, String r4, MusicCreationContent r5) {
        if (r4 != null) goto L4;
        r4 = r5.getTitle();
    L4:
        com.larus.bmhome.music.player.j r6 = this.e;
        if (r6 == null) goto L7;
        String r7 = r6.j();
    L8:
        r3.g.getBinding().j.setText(r4);
        if (this.k == false) goto L29;
        if (TextUtils.isEmpty(r4) == true) goto L19;
        com.larus.bmhome.music.player.j r8 = this.e;
        if (r8 == null) goto L15;
        String r9 = r8.j();
    L17:
        if (TextUtils.isEmpty(r9) == true) goto L19;
        boolean r10 = true;
    L20:
        ImageView r11 = r3.g.getBinding().c;
        if (r10 == false) goto L23;
        Intrinsics.checkNotNull(r11);
        com.larus.utils.e1.x(r11);
        com.larus.utils.e1.d(r11, new c1(this));
    L24:
        if (r10 == true) goto L27;
        r3.g.getBinding().j.setOnClickListener(null);
        return;
    L27:
        r3.g.getBinding().j.setOnClickListener(new e1(this));
        return;
    L23:
        Intrinsics.checkNotNull(r11);
        com.larus.utils.e1.o(r11);
        r11.setOnClickListener(null);
        goto L24
    L15:
        r9 = null;
    L19:
        r10 = false;
        goto L20
    L29:
        if (TextUtils.isEmpty(r4) == false) goto L31;
        return;
    L31:
        if (TextUtils.isEmpty(r7) == true) goto L37;
        r3.g.getBinding().j.setOnClickListener(new f1(this));
        return;
    L37:
        return;
    L7:
        r7 = null;
        goto L8
    }

    public final void ka0(MusicCreationContent r44, boolean r45, boolean r46) {
        FLogger.a.d("MusicPlayerDetailFragment", "[shuffleAction] next state patching");
        com.larus.bmhome.music.player.j r1 = this.q;
        Message r2 = this.d;
        if (r2 == null) goto L8;
        String r4 = r2.getMessageId();
        if (r4 == null) goto L8;
        String r9 = r4;
    L9:
        if (r2 == null) goto L14;
        String r5 = r2.getConversationId();
        if (r5 == null) goto L14;
        String r10 = r5;
    L15:
        if (r1 == null) goto L20;
        String r6 = r1.d();
        if (r6 == null) goto L20;
        String r11 = r6;
    L21:
        if (r1 == null) goto L26;
        String r7 = r1.k();
        if (r7 == null) goto L26;
        String r12 = r7;
    L27:
        LifecycleCoroutineScope r19 = LifecycleOwnerKt.getLifecycleScope(this);
        if (r1 == null) goto L30;
        String r22 = r1.c;
    L31:
        String r16 = r44.getVid();
        String r8 = r44.getVideoModel();
        if (r8 != null) goto L34;
        String r15 = "";
    L35:
        LruCache<String, wc9.e> r13 = ko8.a.a;
        String r26 = ko8.a.e(ko8.a.e);
        String r14 = r44.getTitle();
        if (r14 != null) goto L38;
        String r27 = "";
    L39:
        String r17 = r44.getChunkUrl();
        if (r17 != null) goto L42;
        String r28 = "";
    L43:
        ad9.b r31 = r44.getPlayList();
        boolean r3 = this.p instanceof bq8.a;
        if (this.k == false) goto L51;
        MusicDetailPagerFragment r18 = getParentFragment();
        if ((r18 instanceof MusicDetailPagerFragment) == false) goto L48;
        MusicDetailPagerFragment r20 = r18;
    L49:
        if (r20 == null) goto L51;
        kr8.o r23 = r20.oa0(r44, r1);
    L52:
        com.larus.bmhome.music.player.j r21 = new com.larus.bmhome.music.player.j(r9, r10, r11, r12, "", -1, r15, r16, true, true, r19, 30, r22, r23, "chat", true, r26, r27, r28, r3, false, r31, r45, r46, r2, "music_gen", 1048576);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new MusicPlayerDetailFragment$shuffleAction$1(r21, r45, r46, r44, null), 3, null);
        X90(r44, false);
        this.q = r21;
        this.m.k(true);
        this.m.d(r21);
        return;
    L48:
        r20 = null;
    L51:
        r23 = null;
        goto L52
    L42:
        r28 = r17;
        goto L43
    L38:
        r27 = r14;
        goto L39
    L34:
        r15 = r8;
        goto L35
    L30:
        r22 = null;
    L26:
        r12 = "";
    L20:
        r11 = "";
    L14:
        r10 = "";
    L8:
        r9 = "";
        goto L9
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        LarusFragmentMusicPlayerDetailBinding r5 = LarusFragmentMusicPlayerDetailBinding.a(r2, r3);
        this.n = r5;
        CreationOperateContainerView r6 = r5.e;
        if (r6 == null) goto L9;
        LarusCreationOperateContainerLayoutBinding r7 = r6.getBinding();
        if (r7 == null) goto L9;
        ConstraintLayout r8 = r7.c;
        if (r8 == null) goto L9;
        com.larus.utils.e1.d(r8, new s0(this));
    L9:
        LarusFragmentMusicPlayerDetailBinding r9 = this.n;
        if (r9 == null) goto L16;
        CreationOperateContainerView r10 = r9.e;
        if (r10 == null) goto L16;
        LarusCreationOperateContainerLayoutBinding r11 = r10.getBinding();
        if (r11 == null) goto L16;
        ConstraintLayout r12 = r11.e;
    L17:
        com.larus.utils.e1.d(r12, new d1(this));
        fa0(this.D);
        Message r13 = this.d;
        if (r13 == null) goto L22;
        boolean r0 = true;
        if (com.larus.bmhome.chat.bean.d.j0(r13) != true) goto L22;
    L23:
        Z90(r0);
        if (r4 == null) goto L26;
        Y90();
    L26:
        LarusFragmentMusicPlayerDetailBinding r14 = this.n;
        if (r14 != null) goto L29;
        return null;
    L29:
        return r14.a;
    L22:
        r0 = false;
    L16:
        r12 = null;
        goto L17
    }

    public MusicPlayerDetailFragment(Message r1, com.larus.bmhome.music.player.j r2, MusicCreationContent r3, int r4, boolean r5, WeakReference r6, Function1 r7, boolean r8, int r9) {
        this.d = r1;
        this.e = r2;
        this.f = r3;
        this.g = r4;
        this.h = r5;
        this.i = r6;
        this.j = r7;
        this.k = r8;
        this.l = r9;
        com.larus.bmhome.music.player.f r10 = com.larus.bmhome.music.player.f.a;
        this.m = com.larus.bmhome.music.player.f.b(this, null);
        String r11 = "";
        this.w = "";
        this.x = "";
        this.E = "";
        this.H = LazyKt.lazy(new s1(this));
        if (r1 == null) goto L8;
        String r12 = r1.getMessageId();
        if (r12 == null) goto L8;
        r11 = r12;
    L8:
        this.I = r11;
        this.J = 2;
        this.K = LazyKt.lazy(new t1(this));
        this.L = LazyKt.lazy(new u1(this));
        this.M = System.currentTimeMillis();
    }
}
