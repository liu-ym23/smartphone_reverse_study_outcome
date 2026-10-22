package com.larus.profile.impl.creation;

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
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.widget.AppCompatImageView;
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
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonReader;
import com.larus.bmhome.bigimg.download.CommonDownLoadLayout;
import com.larus.bmhome.bigimg.template.CommonTemplateLayout;
import com.larus.bmhome.chat.trace.ChatControlTrace;
import com.larus.bmhome.music.databinding.LarusFragmentMusicPlayerDetailBinding;
import com.larus.bmhome.music.databinding.LarusViewMusicPlayerSlidingInfoBinding;
import com.larus.bmhome.music.edit.MusicEditDialogFragment;
import com.larus.bmhome.music.edit.MusicInfoEditHelper;
import com.larus.bmhome.music.protocol.MusicShareApi;
import com.larus.bmhome.music.widget.MusicPlayerLyricView;
import com.larus.bmhome.music.widget.MusicPlayerSlidingInfoView;
import com.larus.bmhome.music.widget.PlaylistViewPagerAdapter;
import com.larus.bmhome.share.ShareScene;
import com.larus.bmhome.view.CreationOperateContainerView;
import com.larus.common.apphost.AppHost;
import com.larus.common_res.common_ui.databinding.LarusCreationOperateContainerLayoutBinding;
import com.larus.common_ui.fragment.CommonSlideFragment;
import com.larus.common_ui.fragment.helper.EditPanelType;
import com.larus.common_ui.video.progress.PlayerProgressView;
import com.larus.im.bean.message.ImageObj;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.LyricsSeekContent;
import com.larus.im.bean.message.block.MusicCreationContent;
import com.larus.network.http.HttpExtKt;
import com.larus.platform.api.Image;
import com.larus.platform.api.ImageInfo;
import com.larus.platform.api.ModifiedUserCreationMusic;
import com.larus.platform.api.creation.AuthorInfo;
import com.larus.platform.api.creation.TplTagType;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.skydoves.balloon.Balloon;
import com.tencent.open.log.TraceLevel;
import java.io.StringReader;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONException;
import v19.i5;
import v19.j5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000ð\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b3\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u001c\u0018\u0000 ¿\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0002¿\u0001B\u0087\u0001\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\b\b\u0002\u0010\u0018\u001a\u00020\f\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a¢\u0006\u0004\b\u001b\u0010\u001cB\t\b\u0016¢\u0006\u0004\b\u001b\u0010\u001dJ\b\u0010T\u001a\u00020.H\u0002J\b\u0010Y\u001a\u00020\u0011H\u0016J&\u0010Z\u001a\u0004\u0018\u00010.2\u0006\u0010[\u001a\u00020\\2\b\u0010]\u001a\u0004\u0018\u00010^2\b\u0010_\u001a\u0004\u0018\u00010`H\u0016J\b\u0010a\u001a\u00020\u0011H\u0002J\u0015\u0010b\u001a\u00020\u00152\b\u0010c\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010dJ\u0015\u0010e\u001a\u00020\u00152\b\u0010c\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010dJ\b\u0010f\u001a\u00020\u0011H\u0016J\b\u0010g\u001a\u00020FH\u0002J\u0014\u0010h\u001a\u00020\u00112\n\b\u0002\u0010i\u001a\u0004\u0018\u00010\u0015H\u0002J\b\u0010j\u001a\u00020\u0011H\u0002J\b\u0010k\u001a\u00020\u0011H\u0002J\b\u0010l\u001a\u00020\u0011H\u0002J\u0010\u0010m\u001a\u00020\u00112\u0006\u0010n\u001a\u00020\fH\u0002J\b\u0010o\u001a\u00020\u0011H\u0002J\b\u0010p\u001a\u00020\fH\u0002J\u0010\u0010q\u001a\u00020\u00112\u0006\u0010r\u001a\u00020\u000eH\u0002J\u001a\u0010s\u001a\u00020\u00112\u0006\u0010t\u001a\u00020.2\b\u0010_\u001a\u0004\u0018\u00010`H\u0016J\b\u0010u\u001a\u00020\u0011H\u0002J\b\u0010v\u001a\u00020\u0011H\u0002J\u0010\u0010w\u001a\u00020\u00112\u0006\u0010x\u001a\u00020\fH\u0002J\u0010\u0010y\u001a\u00020\u00112\u0006\u0010x\u001a\u00020\fH\u0002J\u0010\u0010z\u001a\u00020\u00112\u0006\u0010{\u001a\u00020\fH\u0016J\b\u0010|\u001a\u00020\fH\u0016J\u0010\u0010}\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\nH\u0002J\b\u0010~\u001a\u00020\u0011H\u0002J\b\u0010\u007f\u001a\u00020\u0011H\u0002J$\u0010\u0080\u0001\u001a\u00020\u00112\u0007\u0010\u0081\u0001\u001a\u00020\n2\u0007\u0010\u0082\u0001\u001a\u00020\u000e2\u0007\u0010\u0083\u0001\u001a\u00020\u000eH\u0002J\u0007\u0010\u0084\u0001\u001a\u00020\u0011J\t\u0010\u0085\u0001\u001a\u00020\u0011H\u0016J\u0010\u0010\u0086\u0001\u001a\u00020\u00112\u0007\u0010\u0087\u0001\u001a\u00020\nJ:\u0010\u0088\u0001\u001a\u00020\b2\t\u0010\u0089\u0001\u001a\u0004\u0018\u00010\b2\u0007\u0010\u008a\u0001\u001a\u00020\n2\t\u0010\u008b\u0001\u001a\u0004\u0018\u00010\u00062\u0007\u0010\u0082\u0001\u001a\u00020\u000e2\u0007\u0010\u0083\u0001\u001a\u00020\u000eH\u0002J\t\u0010\u008c\u0001\u001a\u00020\u0011H\u0016J\t\u0010\u008d\u0001\u001a\u00020\u0011H\u0016J\t\u0010\u008e\u0001\u001a\u00020\u0011H\u0016J\t\u0010\u008f\u0001\u001a\u00020\u0011H\u0016J\t\u0010\u0090\u0001\u001a\u00020\u0011H\u0016J\t\u0010\u0091\u0001\u001a\u00020\u0011H\u0016J\u001c\u0010\u0092\u0001\u001a\u00020\u00112\b\u0010\u0093\u0001\u001a\u00030\u0094\u00012\u0007\u0010\u0095\u0001\u001a\u00020\u000eH\u0016J\t\u0010\u0096\u0001\u001a\u00020\u0011H\u0016J\t\u0010\u0097\u0001\u001a\u00020\u0011H\u0016J\n\u0010\u0098\u0001\u001a\u00030\u0099\u0001H\u0016J\u0012\u0010\u009a\u0001\u001a\u00020\u00112\u0007\u0010\u0087\u0001\u001a\u00020\nH\u0002J\u001d\u0010\u009b\u0001\u001a\u00020\u00112\u0007\u0010\u0087\u0001\u001a\u00020\n2\t\b\u0002\u0010\u009c\u0001\u001a\u00020\u000eH\u0002J\u0012\u0010\u009d\u0001\u001a\u00020\u00112\u0007\u0010\u0087\u0001\u001a\u00020\nH\u0002J\u001c\u0010\u009e\u0001\u001a\u00020\u0011*\u00020'2\r\u0010\u009f\u0001\u001a\b\u0012\u0004\u0012\u00020\f0\u0010H\u0002J\u001a\u0010 \u0001\u001a\u00020\u0011*\u00020'2\u000b\b\u0002\u0010¡\u0001\u001a\u0004\u0018\u00010\nH\u0002J\t\u0010¢\u0001\u001a\u00020\u0011H\u0003J\u0017\u0010£\u0001\u001a\u00020\u0011*\u00030¤\u00012\u0007\u0010¡\u0001\u001a\u00020\nH\u0002J\u000e\u0010¥\u0001\u001a\u00020\u0011*\u00030¤\u0001H\u0002J\r\u0010¦\u0001\u001a\u00020\u0011*\u00020'H\u0002J\t\u0010¨\u0001\u001a\u00020\u0011H\u0002J\t\u0010©\u0001\u001a\u00020\u000eH\u0002J\u0012\u0010ª\u0001\u001a\u00020\u00112\u0007\u0010¡\u0001\u001a\u00020\nH\u0002J\t\u0010«\u0001\u001a\u00020\u0011H\u0016J\u0016\u0010¬\u0001\u001a\u00020\u0011*\u00020'2\u0007\u0010¡\u0001\u001a\u00020\nH\u0002J\u0012\u0010\u00ad\u0001\u001a\u00020\u00112\u0007\u0010¡\u0001\u001a\u00020\nH\u0002J\u0012\u0010®\u0001\u001a\u00020\u00112\u0007\u0010¡\u0001\u001a\u00020\nH\u0002J\u0016\u0010¯\u0001\u001a\u00020\u0011*\u00020'2\u0007\u0010¡\u0001\u001a\u00020\nH\u0002J#\u0010°\u0001\u001a\u00020\u0011*\u00020'2\u000b\b\u0002\u0010±\u0001\u001a\u0004\u0018\u00010\u00152\u0007\u0010¡\u0001\u001a\u00020\nH\u0002J#\u0010²\u0001\u001a\u00020\u0011*\u00020'2\u000b\b\u0002\u0010³\u0001\u001a\u0004\u0018\u00010\u00152\u0007\u0010¡\u0001\u001a\u00020\nH\u0002J\t\u0010´\u0001\u001a\u00020\u0011H\u0002J#\u0010µ\u0001\u001a\u00020\u0011*\u00020'2\u000b\b\u0002\u0010¶\u0001\u001a\u0004\u0018\u00010\u00152\u0007\u0010¡\u0001\u001a\u00020\nH\u0002J\u0016\u0010·\u0001\u001a\u00020\u0011*\u00020'2\u0007\u0010¡\u0001\u001a\u00020\nH\u0002J\t\u0010¸\u0001\u001a\u00020\u0011H\u0002J\u0011\u0010¹\u0001\u001a\u00020\u00112\u0006\u0010{\u001a\u00020\fH\u0016J\u001c\u0010º\u0001\u001a\u00020\u00112\u0006\u0010{\u001a\u00020\f2\t\u0010»\u0001\u001a\u0004\u0018\u00010\u0015H\u0016J\u0011\u0010¼\u0001\u001a\u00020\u00112\u0006\u0010{\u001a\u00020\fH\u0016J\t\u0010½\u0001\u001a\u00020\u0011H\u0016J\t\u0010¾\u0001\u001a\u00020\u0011H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0018\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u000e\u0010$\u001a\u00020%X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010,\u001a\n\u0012\u0004\u0012\u00020.\u0018\u00010-X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u000100X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u0004\u0018\u000102X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u000209X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u000209X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020<X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00150>X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010?\u001a\b\u0012\u0004\u0012\u00020@0>X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010A\u001a\u0004\u0018\u00010BX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010C\u001a\u0004\u0018\u00010DX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010E\u001a\u00020F8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bI\u0010J\u001a\u0004\bG\u0010HR\u001d\u0010K\u001a\u0004\u0018\u00010L8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bO\u0010J\u001a\u0004\bM\u0010NR\u001b\u0010P\u001a\u00020.8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bS\u0010J\u001a\u0004\bQ\u0010RR\u0014\u0010U\u001a\u00020V8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bW\u0010XR\u000f\u0010§\u0001\u001a\u00020<X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006À\u0001"}, d2 = {"Lcom/larus/profile/impl/creation/MusicDetailFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/larus/bmhome/music/player/BoxMusicPlayer$PlayerView;", "Lcom/larus/profile/impl/creation/ICreationOperatorInterface;", "Lcom/larus/common_ui/fragment/helper/IContainerFunctionInterface;", "bindSongToLyricsMessage", "Lcom/larus/im/bean/message/Message;", "initMusicPlayerDataState", "Lcom/larus/bmhome/music/player/MusicPlayerData;", "initState", "Lcom/larus/im/bean/message/block/MusicCreationContent;", "initCurrentPausePercent", "", "outPullingFinished", "", "selfDismissed", "Lkotlin/Function0;", "", "bindShareContainer", "Landroid/widget/FrameLayout;", "visitId", "", "userCreation", "Lcom/larus/platform/api/creation/UserCreation;", "creationMode", "creationPagerInitParams", "Lcom/larus/profile/api/model/CreationPagerInitParams;", "<init>", "(Lcom/larus/im/bean/message/Message;Lcom/larus/bmhome/music/player/MusicPlayerData;Lcom/larus/im/bean/message/block/MusicCreationContent;IZLkotlin/jvm/functions/Function0;Landroid/widget/FrameLayout;Ljava/lang/String;Lcom/larus/platform/api/creation/UserCreation;ILcom/larus/profile/api/model/CreationPagerInitParams;)V", "()V", "getCreationMode", "()I", "getCreationPagerInitParams", "()Lcom/larus/profile/api/model/CreationPagerInitParams;", "setCreationPagerInitParams", "(Lcom/larus/profile/api/model/CreationPagerInitParams;)V", "player", "Lcom/larus/bmhome/music/player/BoxMusicPlayer;", "binding", "Lcom/larus/bmhome/music/databinding/LarusFragmentMusicPlayerDetailBinding;", "playlistViewPagerAdapter", "Lcom/larus/bmhome/music/widget/PlaylistViewPagerAdapter;", "mState", "mPlayerState", "behavior", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "Landroid/view/View;", "lyricsSeekContent", "Lcom/larus/im/bean/message/block/LyricsSeekContent;", "musicCreationContentPollingJob", "Lkotlinx/coroutines/Job;", "destroyed", "draging", "currentPosition", "currentLyricContent", "currentFallbackContent", "waitingForVidTiming", "", "waitingForVidProgress", "latestDragSeekTime", "", "editCoverLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "editCoverNewLauncher", "Landroid/content/Intent;", "creationOperatorComponent", "Lcom/larus/profile/impl/creation/CreationOperatorComponent;", "creationTemplateComponent", "Lcom/larus/profile/impl/creation/CreationTemplateComponent;", "coverEditCallback", "Lcom/larus/bmhome/music/edit/IMusicInfoEditCallback;", "getCoverEditCallback", "()Lcom/larus/bmhome/music/edit/IMusicInfoEditCallback;", "coverEditCallback$delegate", "Lkotlin/Lazy;", "loadingDialog", "Lcom/larus/common_ui/dialog/CommonLoadDialog;", "getLoadingDialog", "()Lcom/larus/common_ui/dialog/CommonLoadDialog;", "loadingDialog$delegate", "moreMenu", "getMoreMenu", "()Landroid/view/View;", "moreMenu$delegate", "buildMoreMenu", "viewContext", "Landroid/content/Context;", "getViewContext", "()Landroid/content/Context;", "onDestroy", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "initResultLauncher", "getItemName", "private", "(Ljava/lang/Integer;)Ljava/lang/String;", "getCurrentStatus", "onResume", "buildCoverEditCallback", "uploadCoverFailed", "message", "onEditCoverSuccess", "initView", "initButtonClickListener", "updateButtonStatus", TplTagType.STYLE, "setPrivateButtonBackground", "getInitCreationButtonStatus", "showLoadingDialog", "show", "onViewCreated", "view", "adaptTheBar", "initPlaylistViewPager", "onMusicContentSwitched", "position", "switchToPosition", "scrollToInitPostion", "pos", "getCurrentIndex", "initAction", "playNextAction", "playPreviousAction", "shuffleAction", "nextState", "next", "previous", "resume", "onPause", "appendNewCreation", "newState", "buildNewMusicPlayState", "previousState", "musicContentState", "musicMessage", "hideLoadingView", "showLoadingView", "hidePlayIcon", "showPlayIcon", "hideProgressBarView", "showProgressBarView", "setProgressV2", "percent", "", "smooth", "showReadyState", "showPlayingState", "getScope", "Lkotlinx/coroutines/CoroutineScope;", "acquireDurationAndInitProgressBar", "applyState", "byDiff", "applyCoverImageState", "initProgressBar", "duration", "applyDetailTintState", "state", "setUIToDark", "bindCoverImageState", "Lcom/larus/bmhome/music/databinding/LarusMusicCoverViewHolderBinding;", "setCoverClickListener", "initClickListeners", "lastClickTime", "showEditCoverDialog", "isQuickClick", "doShareAction", "onShareClick", "applyCanShareState", "share", "download", "applyDownloadState", "applyCreatorNameState", "specifiedCreator", "applySongState", "specifiedTitle", "launchEditMusicName", "applyLyricsState", "specifiedLyrics", "applyShuffleState", "closeSelf", "downloadCreation", "shareCreation", "source", "deleteWithPosition", "doSameStyle", "onMoreClick", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class MusicDetailFragment extends Fragment implements com.larus.bmhome.music.player.a.a, g19.a {
    public static final /* synthetic */ int J = 0;
    public long A;
    public ActivityResultLauncher<String> B;
    public ActivityResultLauncher<Intent> C;
    public CreationOperatorComponent D;
    public u1 E;
    public final Lazy F;
    public final Lazy G;
    public final Lazy H;
    public long I;
    public final Message d;
    public final com.larus.bmhome.music.player.j e;
    public final MusicCreationContent f;
    public final int g;
    public final boolean h;
    public final Function0<Unit> i;
    public final FrameLayout j;
    public final String k;
    public final UserCreation l;
    public final int m;
    public final gs9.d n;
    public final com.larus.bmhome.music.player.a o;
    public LarusFragmentMusicPlayerDetailBinding p;
    public PlaylistViewPagerAdapter q;
    public MusicCreationContent r;
    public com.larus.bmhome.music.player.j s;
    public LyricsSeekContent t;
    public boolean u;
    public int v;
    public String w;
    public String x;
    public double y;
    public double z;

    public static final class a {
    }

    public static final class b implements com.larus.bmhome.music.edit.a {
        public final /* synthetic */ MusicDetailFragment a;

        public final com.larus.bmhome.music.edit.j c() {
            com.larus.bmhome.music.protocol.f r0 = this.a.r;
            Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.larus.bmhome.music.protocol.MusicGenCreation");
            String r1 = r0.a;
            com.larus.bmhome.music.player.j r2 = this.a.s;
            if (r2 == null) goto L6;
            String r3 = r2.j();
            if (r3 == null) goto L6;
        L8:
            return new com.larus.bmhome.music.edit.j(r3, r1, this.a.r);
        L6:
            r3 = "";
            goto L8
        }

        public b(MusicDetailFragment r1) {
            this.a = r1;
        }

        public final void a(com.larus.bmhome.music.edit.v r3) {
            Intrinsics.checkNotNullParameter(r3, "status");
            MusicDetailFragment r0 = this.a;
            int r1 = MusicDetailFragment.J;
            r0.ba0(false);
            if ((r3 instanceof com.larus.bmhome.music.edit.v.a) == false) goto L6;
            t19.s r2 = t19.s.a;
            Context r4 = this.a.getViewContext();
            String r5 = ((com.larus.bmhome.music.edit.v.a) r3).a;
            r2.getClass();
            t19.s.c(r4, r5);
            return;
        }

        public final void b(ModifiedUserCreationMusic r24) {
            if (r24 == null) goto L23;
            ImageInfo r3 = r24.b;
            if (r3 == null) goto L23;
            MusicDetailFragment r4 = this.a;
            MusicCreationContent r5 = r4.r;
            if (r5 == null) goto L17;
            String r7 = r3.e;
            Image r6 = r3.b;
            if (r6 == null) goto L11;
            ImageObj r9 = is9.a.a(r6);
        L12:
            Image r8 = r3.a;
            if (r8 == null) goto L15;
            ImageObj r10 = is9.a.a(r8);
        L16:
            r5.setCover(new com.larus.im.bean.message.Image(r7, null, r9, r10, null, null, null, null, null, null, null, null, null, null, 16370, null));
            goto L17
        L15:
            r10 = null;
            goto L16
        L11:
            r9 = null;
        L17:
            MusicCreationContent r2 = r4.r;
            if (r2 != null) goto L20;
            return;
        L20:
            PlaylistViewPagerAdapter r11 = r4.q;
            if (r11 == null) goto L23;
            r11.A2(r2);
        L23:
            if (r24 == null) goto L41;
            String r12 = r24.a;
            if (r12 == null) goto L41;
            MusicDetailFragment r13 = this.a;
            if (r12.length() != 0) goto L29;
            boolean r14 = true;
        L30:
            if (r14 == false) goto L32;
            return;
        L32:
            MusicCreationContent r15 = r13.r;
            if (r15 == null) goto L35;
            r15.setTitle(r12);
        L35:
            LarusFragmentMusicPlayerDetailBinding r16 = r13.p;
            if (r16 == null) goto L41;
            MusicCreationContent r17 = r13.r;
            if (r17 != null) goto L40;
            return;
        L40:
            r13.W90(r16, r12, r17);
            goto L41
        L29:
            r14 = false;
        L41:
            j2 r18 = this.a.getParentFragment();
            if ((r18 instanceof j2) == false) goto L44;
            j2 r19 = r18;
        L45:
            if (r19 == null) goto L48;
            r19.J50(r24);
            return;
        L48:
            return;
        L44:
            r19 = null;
            goto L45
        }
    }

    static {
    }

    public MusicDetailFragment() {
        this(null, null, 0, false, new d3(), null, "", null, 2, null);
        CreationGroupFragment r0 = getParentFragment();     // Catch: IllegalStateException -> L10
        if ((r0 instanceof CreationGroupFragment) == false) goto L6;
        CreationGroupFragment r1 = r0;     // Catch: IllegalStateException -> L10
    L7:
        if (r1 == null) goto L14;
        CommonSlideFragment.S90(r1);     // Catch: IllegalStateException -> L10
        return;
    L14:
        return;
    L6:
        r1 = null;
    L10:
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

    public final void mP(int r1, boolean r2) {
    }

    public final void u() {
    }

    public final void FK() {
        FLogger.a.d("MusicPlayerDetailFragment", "[showReadyState]");
        LarusFragmentMusicPlayerDetailBinding r0 = this.p;
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

    public final void Lf() {
        LarusFragmentMusicPlayerDetailBinding r0 = this.p;
        if (r0 == null) goto L7;
        PlayerProgressView r1 = r0.h;
        if (r1 == null) goto L7;
        r1.J1(0 * ((float) this.z), false);
    L7:
        FLogger.a.d("MusicPlayerDetailFragment", "[hideProgressBarView]");
    }

    public final void Lr() {
        FLogger.a.d("MusicPlayerDetailFragment", "[showPlayIcon]");
        LarusFragmentMusicPlayerDetailBinding r0 = this.p;
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

    public final void OK() {
        FLogger.a.d("MusicPlayerDetailFragment", "[hidePlayIcon]");
        LarusFragmentMusicPlayerDetailBinding r0 = this.p;
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

    public final void UY() {
        FLogger.a.d("MusicPlayerDetailFragment", "[showProgressBarView]");
    }

    public final void Z90() {
        LarusFragmentMusicPlayerDetailBinding r0 = this.p;
        if (r0 == null) goto L11;
        MusicPlayerSlidingInfoView r1 = r0.g;
        if (r1 == null) goto L11;
        LarusViewMusicPlayerSlidingInfoBinding r2 = r1.getBinding();
        if (r2 == null) goto L11;
        TextView r3 = r2.j;
        if (r3 == null) goto L11;
        r3.setTextColor(ContextCompat.getColor(com.larus.bmhome.music.widget.m2.a, 2131103681));
    L11:
        LarusFragmentMusicPlayerDetailBinding r4 = this.p;
        if (r4 == null) goto L20;
        MusicPlayerSlidingInfoView r5 = r4.g;
        if (r5 == null) goto L20;
        LarusViewMusicPlayerSlidingInfoBinding r6 = r5.getBinding();
        if (r6 == null) goto L20;
        TextView r7 = r6.b;
        if (r7 == null) goto L20;
        r7.setTextColor(ContextCompat.getColor(com.larus.bmhome.music.widget.m2.a, 2131106539));
    L20:
        LarusFragmentMusicPlayerDetailBinding r8 = this.p;
        if (r8 == null) goto L25;
        AppCompatImageView r9 = r8.c;
        if (r9 == null) goto L25;
        r9.setImageResource(2131239329);
    L25:
        LarusFragmentMusicPlayerDetailBinding r10 = this.p;
        if (r10 == null) goto L31;
        PlayerProgressView r11 = r10.h;
        if (r11 == null) goto L32;
        r11.Z5();
        return;
    L32:
        return;
    }

    public final void aa0() {
        MusicCreationContent r2 = this.r;
        if (r2 == null) goto L6;
        String r3 = r2.getVid();
        if (r3 == null) goto L6;
    L7:
        boolean r5 = true;
        kr8.c r1 = new kr8.c("music_detail", r3, 1);
        FragmentActivity r4 = null;
        kr8.l.a.b(r1, null, 3);
        MusicCreationContent r6 = this.r;
        if (r6 != null) goto L10;
        r6 = new MusicCreationContent();
    L10:
        MusicCreationContent r7 = r6;
        com.larus.bmhome.music.player.j r8 = this.s;
        if (r8 == null) goto L16;
        String r9 = r8.j();
        if (r9 == null) goto L16;
        String r10 = r9;
    L17:
        com.larus.bmhome.music.protocol.f r11 = this.r;
        if ((r11 instanceof com.larus.bmhome.music.protocol.f) == false) goto L20;
        com.larus.bmhome.music.protocol.f r12 = r11;
    L21:
        if (r12 == null) goto L23;
        String r13 = r12.a;
    L24:
        Message r14 = this.d;
        com.larus.bmhome.music.edit.a r15 = (com.larus.bmhome.music.edit.a) this.F.getValue();
        Boolean r16 = Boolean.TRUE;
        String r17 = this.k;
        if (r17 != null) goto L27;
    L30:
        MusicEditDialogFragment r18 = new MusicEditDialogFragment(r7, null, r10, r13, r14, null, null, r15, r16, Boolean.valueOf(r5), 98);
        Context r19 = getContext();
        if ((r19 instanceof FragmentActivity) == false) goto L33;
        r4 = (FragmentActivity) r19;
    L33:
        if (r4 == null) goto L43;
        FragmentManager r20 = r4.getSupportFragmentManager();
        LandscapeRestrictionOperation r21 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r18, "inviteBotDialog", r21);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r20, r18, r21) == true) goto L44;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L40
    L38:
        r18.show(r20, "inviteBotDialog");
        return;
    L44:
        return;
    L43:
        return;
    L27:
        if (r17.length() == 0) goto L30;
        r5 = false;
        goto L30
    L23:
        r13 = null;
        goto L24
    L20:
        r12 = null;
    L16:
        r10 = "";
    L6:
        r3 = "";
        goto L7
    }

    public final void d70() {
        MusicCreationContent r8 = this.r;
        if (r8 == null) goto L26;
        FrameLayout r1 = this.j;
        if (r1 == null) goto L27;
        LifecycleCoroutineScope r2 = LifecycleOwnerKt.getLifecycleScope(this);
        ChatControlTrace r3 = ChatControlTrace.b;
        r3.getClass();
        String r12 = r3.bb(ChatControlTrace.y);
        String r14 = r3.h(ChatControlTrace.y);
        com.larus.bmhome.music.player.j r4 = this.s;
        if (r4 == null) goto L10;
        String r15 = r4.d();
    L11:
        com.larus.bmhome.share.panel.h r84 = new com.larus.bmhome.share.panel.h(null, null, r12, "creation_detail", r14, r15, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, -121, -1, 1023);
        MusicShareApi r5 = MusicShareApi.a;
        com.larus.common_ui.dialog.l0 r6 = (com.larus.common_ui.dialog.l0) this.G.getValue();
        com.larus.bmhome.music.player.j r7 = this.s;
        if (r7 == null) goto L15;
        String r9 = r7.j();
        if (r9 == null) goto L15;
    L16:
        Message r10 = this.d;
        ShareScene r11 = ShareScene.MUSIC_VIDEO_REPORT;
        com.larus.bmhome.music.player.j r13 = this.s;
        if (r13 == null) goto L19;
        String r16 = r13.d();
    L20:
        MusicShareApi.d(r1, r2, r6, "music_detail", "click_music_detail", r9, r10, r8, r11, r84, r16, null, 4096);
        int r17 = x1.a;
        UserCreation r18 = this.l;
        gs9.d r19 = this.n;
        if (r19 == null) goto L23;
        gs9.b r20 = r19.f;
    L24:
        x1.b(r18, r20, null);
        return;
    L23:
        r20 = null;
        goto L24
    L19:
        r16 = null;
    L15:
        r9 = "";
        goto L16
    L10:
        r15 = null;
        goto L11
    L27:
        return;
    }

    public final void f20() {
        FLogger.a.d("MusicPlayerDetailFragment", "[showPlayingState]");
        LarusFragmentMusicPlayerDetailBinding r0 = this.p;
        if (r0 == null) goto L10;
        MusicPlayerSlidingInfoView r1 = r0.g;
        if (r1 == null) goto L11;
        LarusViewMusicPlayerSlidingInfoBinding r2 = r1.getBinding();
        if (r2 == null) goto L12;
        com.larus.utils.e1.o(r2.h);
        com.larus.utils.e1.x(r2.g);
        r2.e.U5();
        return;
    L12:
        return;
    L11:
        return;
    }

    public final void hideLoadingView() {
        FLogger.a.d("MusicPlayerDetailFragment", "[hideLoadingView]");
        LarusFragmentMusicPlayerDetailBinding r0 = this.p;
        if (r0 == null) goto L8;
        PlayerProgressView r1 = r0.h;
        if (r1 == null) goto L9;
        r1.c6();
        return;
    L9:
        return;
    }

    public final void o1() {
        LarusFragmentMusicPlayerDetailBinding r0 = this.p;
        if (r0 == null) goto L18;
        FrameLayout r1 = r0.k;
        if (r1 == null) goto L19;
        Balloon r2 = com.larus.bmhome.view.screenmenu.d.a(com.larus.bmhome.view.screenmenu.d.a, r1, (View) this.H.getValue(), false, null, null, null, null, 124);
        ViewGroup.LayoutParams r3 = ((View) this.H.getValue()).getLayoutParams();
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

    public final void showLoadingView() {
        FLogger.a.d("MusicPlayerDetailFragment", "[showLoadingView]");
        LarusFragmentMusicPlayerDetailBinding r0 = this.p;
        if (r0 == null) goto L8;
        PlayerProgressView r1 = r0.h;
        if (r1 == null) goto L9;
        r1.c6();
        return;
    L9:
        return;
    }

    public final void Y90() {
        FragmentActivity r0 = getViewContext();
        if ((r0 instanceof FragmentActivity) == false) goto L5;
        FragmentActivity r1 = r0;
    L6:
        if (r1 != null) goto L9;
        FLogger.a.e("MusicPlayerDetailFragment", "[launchEditMusicName] viewContext is not FragmentActivity");
        return;
    L9:
        MusicInfoEditHelper.f(r1, new b(this), false, null);
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final CoroutineScope getScope() {
        return LifecycleOwnerKt.getLifecycleScope(this);
    }

    public final Context getViewContext() {
        Context r0 = getContext();
        if (r0 == null) goto L5;
        return r0;
    L5:
        return AppHost.a.getApplication();
    }

    public final void onDestroy() {
        super.onDestroy();
        this.i.invoke();
        com.larus.bmhome.music.player.a r0 = this.o;
        if (r0 == null) goto L5;
        r0.onDestroyed();
    L5:
        com.larus.bmhome.music.player.b.a r1 = com.larus.bmhome.music.player.b.a;
        r1.getClass();
        com.larus.bmhome.music.player.b.a.g = true;
        r1.getClass();
        com.larus.bmhome.music.player.b.a.h = false;
        r1.getClass();
        com.larus.bmhome.music.player.b.a.i = true;
    }

    public final void onPause() {
        super.onPause();
        this.o.k(false);
        this.o.onPaused();
    }

    public final void onResume() {
        super.onResume();
        this.o.onResumed();
        this.o.i();
        UserCreation r0 = this.l;
        Integer r1 = null;
        if (r0 == null) goto L5;
        Integer r2 = r0.d;
    L6:
        String r3 = "";
        if (r2 != null) goto L10;
    L12:
        if (r2 != null) goto L15;
    L17:
        String r4 = "";
    L18:
        UserCreation r5 = this.l;
        if (r5 == null) goto L21;
        r1 = r5.d;
    L21:
        if (r1 != null) goto L24;
    L26:
        if (r1 != null) goto L29;
    L32:
        if (this.m != 2) goto L34;
        String r6 = "creation_private";
    L35:
        tx9.m0.c(r4, r3, "creation_detail", r6);
        return;
    L34:
        r6 = "creation_list";
        goto L35
    L29:
        if (r1.intValue() != 1) goto L32;
        r3 = "1";
        goto L32
    L24:
        if (r1.intValue() != 2) goto L26;
        r3 = "0";
        goto L32
    L15:
        if (r2.intValue() != 2) goto L17;
        r4 = "go_public";
        goto L18
    L10:
        if (r2.intValue() != 1) goto L12;
        r4 = "already_public";
        goto L18
    L5:
        r2 = null;
        goto L6
    }

    public final void F6() {
        com.larus.bmhome.music.player.a.a.a.b();
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

    public final void GP(Map<String, String> r1) {
        com.larus.bmhome.music.player.a.a.a.d(r1);
    }

    public final void Ij(Map<String, String> r1) {
        com.larus.bmhome.music.player.a.a.a.c(r1);
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
        LarusFragmentMusicPlayerDetailBinding r1 = this.p;     // Catch: Exception -> L24
        if (r1 == null) goto L22;
        ConstraintLayout r2 = r1.b;     // Catch: Exception -> L24
        if (r2 == null) goto L22;
        r2.setBackgroundColor(r7);     // Catch: Exception -> L24
    L22:
        Z90();     // Catch: Exception -> L24
        Unit r8 = Unit.INSTANCE;     // Catch: Exception -> L24
        return;
    L24:
        FLogger.a.e("MusicPlayerDetailFragment", "Wrong color string format");
        if (getContext() == null) goto L41;
        LarusFragmentMusicPlayerDetailBinding r9 = this.p;
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
        LarusFragmentMusicPlayerDetailBinding r12 = this.p;
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

    public final void ba0(boolean r2) {
        if (r2 == false) goto L10;
        com.larus.common_ui.dialog.l0 r3 = (com.larus.common_ui.dialog.l0) this.G.getValue();
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
        com.larus.common_ui.dialog.l0 r4 = (com.larus.common_ui.dialog.l0) this.G.getValue();
        if (r4 == null) goto L15;
        boolean r0 = true;
        if (r4.isShowing() != true) goto L15;
    L16:
        if (r0 == false) goto L27;
        com.larus.common_ui.dialog.l0 r5 = (com.larus.common_ui.dialog.l0) this.G.getValue();
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

    public final void eb(Map<String, String> r1) {
        com.larus.bmhome.music.player.a.a.a.a(r1);
    }

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
        LarusFragmentMusicPlayerDetailBinding r10 = this.p;
        if (r10 == null) goto L22;
        FLogger.a.d("MusicPlayerDetailFragment", "[setProgress] waitingForVidProgress=" + ((float) this.z) + ", duration " + this.o.j(null, null));
        r10.h.J1(((float) 100) * ((float) this.z), r9);
        return;
    L22:
        return;
    L18:
        LarusFragmentMusicPlayerDetailBinding r1 = this.p;
        if (r1 == null) goto L23;
        FLogger.a.d("MusicPlayerDetailFragment", "[setProgress] percent=" + r8 + ", duration " + this.o.j(null, null));
        r1.h.J1(r8, r9);
        r1.g.getBinding().e.Y5((int) ((r8 * ((float) this.o.j(null, null))) * ((float) 10)));
        return;
    L23:
        return;
    L11:
        r0 = false;
        goto L13
    }

    public final void X90(final MusicCreationContent r41, boolean r42) {
        LyricsSeekContent r0 = this.t;
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
        CreationPagerFragment r6 = null;
        this.r = null;
        com.larus.bmhome.music.player.b.a r7 = com.larus.bmhome.music.player.b.a;
        ad9.b r8 = r41.getPlayList();
        com.larus.bmhome.music.player.j r9 = this.s;
        if (r9 == null) goto L19;
        String r10 = r9.j();
        if (r10 == null) goto L19;
    L20:
        r7.getClass();
        com.larus.bmhome.music.player.b.a.a(r8, r10);
        MusicCreationContent r11 = this.r;     // Catch: Exception -> L107
        if (r11 != null) goto L24;
    L76:
        FLogger.a.i("MusicPlayerDetailFragment", "[handleMusicCreationContentPollingResp] refreshAllVariableComponents");     // Catch: Exception -> L107
        this.r = r41;     // Catch: Exception -> L107
        if (this.p == null) goto L79;
        U90(r41);     // Catch: Exception -> L107
    L79:
        LarusFragmentMusicPlayerDetailBinding r4 = this.p;     // Catch: Exception -> L107
        if (r4 == null) goto L82;
        V90(r4, null, r41);     // Catch: Exception -> L107
    L82:
        LarusFragmentMusicPlayerDetailBinding r12 = this.p;     // Catch: Exception -> L107
        if (r12 == null) goto L85;
        T90(r12, null, r41);     // Catch: Exception -> L107
    L85:
        LarusFragmentMusicPlayerDetailBinding r13 = this.p;     // Catch: Exception -> L107
        if (r13 == null) goto L89;
        W90(r13, null, r41);     // Catch: Exception -> L107
    L89:
        if (this.p == null) goto L100;
        CreationGroupFragment r14 = getParentFragment();     // Catch: Exception -> L107
        if ((r14 instanceof CreationGroupFragment) == false) goto L93;
        CreationGroupFragment r15 = r14;     // Catch: Exception -> L107
    L94:
        if (r15 == null) goto L100;
        boolean r16 = true ^ TextUtils.isEmpty(r41.getVideoModel());     // Catch: Exception -> L107
        Fragment r17 = r15.getParentFragment();     // Catch: Exception -> L107
        if ((r17 instanceof CreationPagerFragment) == false) goto L98;
        r6 = (CreationPagerFragment) r17;     // Catch: Exception -> L107
    L98:
        if (r6 == null) goto L100;
        r6.Z90(r16);     // Catch: Exception -> L107
        goto L100
    L93:
        r15 = null;
    L100:
        LarusFragmentMusicPlayerDetailBinding r18 = this.p;     // Catch: Exception -> L107
        if (r18 == null) goto L104;
        com.larus.utils.e1.d(r18.f, new s2(this, r41));     // Catch: Exception -> L107
    L104:
        if (this.p == null) goto L109;
        Unit r19 = Unit.INSTANCE;     // Catch: Exception -> L107
    L109:
        if (r5 == false) goto L114;
        this.r = r41;
        return;
    L114:
        return;
    L24:
        if (TextUtils.isEmpty(r41.getVideoModel()) == false) goto L26;
    L35:
        com.larus.im.bean.message.Image r20 = r41.getCover();     // Catch: Exception -> L107
        if (r20 == null) goto L38;
        String r21 = r20.key;     // Catch: Exception -> L107
    L39:
        com.larus.im.bean.message.Image r22 = r11.getCover();     // Catch: Exception -> L107
        if (r22 == null) goto L42;
        String r23 = r22.key;     // Catch: Exception -> L107
    L44:
        if (Intrinsics.areEqual(r21, r23) == true) goto L50;
        FLogger.a.i("MusicPlayerDetailFragment", "[handleMusicCreationContentPollingResp] loadCoverImage");     // Catch: Exception -> L107
        PlaylistViewPagerAdapter r24 = this.q;     // Catch: Exception -> L107
        if (r24 == null) goto L48;
        r24.A2(r41);     // Catch: Exception -> L107
    L48:
        r5 = true;
    L50:
        if (Intrinsics.areEqual(r41.getCoverMainColor(), r11.getCoverMainColor()) == true) goto L55;
        FLogger.a.i("MusicPlayerDetailFragment", "[handleMusicCreationContentPollingResp] loadDetailTint");     // Catch: Exception -> L107
        if (this.p == null) goto L55;
        U90(r41);     // Catch: Exception -> L107
    L55:
        if (Intrinsics.areEqual(r41.getCreator(), r11.getCreator()) == true) goto L61;
        FLogger.a.i("MusicPlayerDetailFragment", "[handleMusicCreationContentPollingResp] loadCreatorName");     // Catch: Exception -> L107
        LarusFragmentMusicPlayerDetailBinding r25 = this.p;     // Catch: Exception -> L107
        if (r25 == null) goto L59;
        T90(r25, r41.getCreator(), r41);     // Catch: Exception -> L107
    L59:
        r5 = true;
    L61:
        if (Intrinsics.areEqual(r41.getTitle(), r11.getTitle()) == true) goto L66;
        FLogger.a.i("MusicPlayerDetailFragment", "[handleMusicCreationContentPollingResp] loadSongTitle");     // Catch: Exception -> L107
        LarusFragmentMusicPlayerDetailBinding r26 = this.p;     // Catch: Exception -> L107
        if (r26 == null) goto L65;
        W90(r26, r41.getTitle(), r41);     // Catch: Exception -> L107
    L65:
        r5 = true;
    L66:
        if (r3 == false) goto L71;
        FLogger.a.i("MusicPlayerDetailFragment", "[handleMusicCreationContentPollingResp] loadLyrics");     // Catch: Exception -> L107
        LarusFragmentMusicPlayerDetailBinding r27 = this.p;     // Catch: Exception -> L107
        if (r27 == null) goto L70;
        V90(r27, r41.getLyricsSeekContent(), r41);     // Catch: Exception -> L107
    L70:
        r5 = true;
    L71:
        PlaylistViewPagerAdapter r28 = this.q;     // Catch: Exception -> L107
        if (r28 == null) goto L74;
        r28.z2();     // Catch: Exception -> L107
        Unit r29 = Unit.INSTANCE;     // Catch: Exception -> L107
    L75:
        if (r29 != null) goto L109;
    L74:
        r29 = null;
        goto L75
    L42:
        r23 = null;
        goto L44
    L38:
        r21 = null;
        goto L39
    L26:
        if (this.y != 0.0d) goto L28;
        boolean r30 = true;
    L29:
        if (r30 == true) goto L35;
        this.o.k(true);     // Catch: Exception -> L107
        com.larus.bmhome.music.player.a r31 = this.o;     // Catch: Exception -> L107
        String r110 = r41.getVid();     // Catch: Exception -> L107
        String r32 = r41.getVideoModel();     // Catch: Exception -> L107
        if (r32 != null) goto L33;
        String r111 = "";
    L34:
        r31.e(new com.larus.bmhome.music.player.j(null, null, null, null, null, 0, r111, r110, false, false, null, 0, null, null, null, false, null, null, null, false, false, null, false, false, null, null, 67108671));     // Catch: Exception -> L107
        final double r33 = this.z;     // Catch: Exception -> L107
        this.A = System.currentTimeMillis();     // Catch: Exception -> L107
        this.o.j(r41.getVideoModel(), new c3(this, r33));     // Catch: Exception -> L107
        goto L35
    L33:
        r111 = r32;
        goto L34
    L28:
        r30 = false;
    L107:
        e = move-exception;
        FLogger.a.i("MusicPlayerDetailFragment", "[handleMusicCreationContentPollingResp] " + e);
    L19:
        r10 = "";
        goto L20
    L7:
        if (r1.isEmpty() == true) goto L10;
        r2 = false;
    L14:
        r3 = true;
        goto L15
    }

    public final void onViewCreated(View r25, Bundle r26) {
        Intrinsics.checkNotNullParameter(r25, "view");
        if (this.f != null) goto L5;
        return;
    L5:
        MusicCreationContent r1 = this.f;
        FLogger r2 = FLogger.a;
        r2.d("MusicPlayerDetailFragment", "[initAction]");
        final LarusFragmentMusicPlayerDetailBinding r3 = this.p;
        if (r3 == null) goto L14;
        X90(r1, false);
        LarusFragmentMusicPlayerDetailBinding r6 = this.p;
        if (r6 == null) goto L10;
        Function0 r7 = new q2(this);
        r6.h.k6(2000);
        r6.h.Y5(r7, new m3(this, r6), 0);
    L10:
        this.o.j(r1.getVideoModel(), new r2(this));
        if (com.larus.utils.o0.d(this.k) == false) goto L13;
        r3.d.setVisibility(8);
    L13:
        r3.d.setOnClickListener(new f3(r3, this));
        r3.c.setOnClickListener(new g3(this));
        r3.g.getBinding().h.setOnClickListener(new h3(this));
        r3.g.getBinding().g.setOnClickListener(new i3(this));
    L14:
        com.larus.bmhome.music.player.j r8 = this.e;
        if (r8 == null) goto L18;
        com.larus.bmhome.music.player.j r4 = com.larus.bmhome.music.player.j.a(r8, null, null, false, false, null, 30, null, null, false, null, null, null, false, false, null, 67106815);
        this.o.onResumed();
        this.o.d(r4);
        this.s = r4;
    L18:
        if (this.g == 0) goto L20;
        r2.i("MusicPlayerDetailFragment", "[initAction] initCurrentPausePercent=" + this.g);
        this.o.b((float) this.g);
    L20:
        LarusFragmentMusicPlayerDetailBinding r5 = this.p;
        if (r5 == null) goto L23;
        PlaylistViewPagerAdapter r9 = new PlaylistViewPagerAdapter(new l3(this), false);
        this.q = r9;
        this.v = r9.d;
        ViewPager2 r10 = r5.g.getBinding().i;
        r10.setAdapter(this.q);
        r10.setOffscreenPageLimit(1);
        r10.registerOnPageChangeCallback(new MusicDetailFragment$initPlaylistViewPager$1$2$1(this));
        r10.setCurrentItem(this.v, false);
    L23:
        LarusFragmentMusicPlayerDetailBinding r11 = this.p;
        if (r11 == null) goto L28;
        ConstraintLayout r12 = r11.a;
        if (r12 == null) goto L28;
        com.larus.utils.i0.a.getClass();
        int r13 = com.larus.utils.i0.g();
        int r14 = com.larus.utils.i0.e();
        int r15 = r12.getPaddingStart();
        int r16 = r12.getPaddingEnd();
        r2.i("updatePaddingRelative", "view:" + r12.getClass().getSimpleName() + ",source:,start:" + r15 + ",top:" + r13 + ",end:" + r16 + ",bottom:" + r14);
        r12.setPaddingRelative(r15, r13, r16, r14);
    L28:
        LarusFragmentMusicPlayerDetailBinding r17 = this.p;
        if (r17 == null) goto L33;
        MusicPlayerSlidingInfoView r18 = r17.g;
        if (r18 == null) goto L33;
        r18.setDismissCallback(new e3(this));
    L33:
        LarusFragmentMusicPlayerDetailBinding r19 = this.p;
        if (r19 == null) goto L39;
        ConstraintLayout r20 = r19.a;
        if (r20 == null) goto L40;
        com.larus.utils.i0.a.getClass();
        int r21 = com.larus.utils.i0.e() + i5.h();
        int r110 = r20.getPaddingStart();
        int r111 = r20.getPaddingTop();
        int r112 = r20.getPaddingEnd();
        r2.i("updatePaddingRelative", "view:" + r20.getClass().getSimpleName() + ",source:,start:" + r110 + ",top:" + r111 + ",end:" + r112 + ",bottom:" + r21);
        r20.setPaddingRelative(r110, r111, r112, r21);
        return;
    L40:
        return;
    }

    public final void r30(String r1, Map<String, String> r2) {
        com.larus.bmhome.music.player.a.a.a.e(r1, r2);
    }

    public final void T90(LarusFragmentMusicPlayerDetailBinding r3, String r4, MusicCreationContent r5) {
        if (r4 != null) goto L4;
        r4 = r5.getCreator();
    L4:
        String r6 = "";
        if (r4 != null) goto L8;
        r4 = "";
    L8:
        if (r4.length() != 0) goto L10;
        boolean r0 = true;
    L11:
        String r1 = null;
        if (r0 == false) goto L22;
        UserCreation r7 = this.l;
        if (r7 == null) goto L18;
        AuthorInfo r8 = r7.g;
        if (r8 == null) goto L18;
        r4 = r8.a;
    L19:
        if (r4 != null) goto L22;
        r4 = "";
    L18:
        r4 = null;
    L22:
        if (AppHost.a.isOversea() == false) goto L26;
        Context r2 = getContext();
        if (r2 == null) goto L30;
        r1 = j5.b(r2, r4);
    L30:
        TextView r9 = r3.g.getBinding().b;
        if (r1 == null) goto L33;
        r6 = r1;
    L33:
        r9.setText(r6);
        return;
    L26:
        StringBuilder r10 = new StringBuilder();
        r10.append(r4);
        r10.append(" / ");
        Context r11 = getContext();
        if (r11 == null) goto L29;
        r1 = r11.getString(2131908040);
    L29:
        r10.append(r1);
        r1 = r10.toString();
        goto L30
    L10:
        r0 = false;
        goto L11
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
        LyricsSeekContent r0 = this.t;
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
        FLogger.a.i("MusicPlayerDetailFragment", "[addLyricsView] lyricState:" + r9 + ", lyricsContent:" + r4 + ", lyricsSeekContent:" + this.t);
        if (r18.getMusicGenType() != 2) goto L74;
        String r10 = getViewContext().getString(2131907946) + "" + AccountService.a.getNickname();
    L75:
        MusicPlayerLyricView r8 = r16.g.getBinding().e;
        LyricsSeekContent r11 = this.t;
        String r7 = r18.getLyrics();
        if (r7 != null) goto L78;
        String r12 = "";
    L79:
        r8.S5(r9, r10, r11, r12, new u2(), new v2());
        return;
    L78:
        r12 = r7;
        goto L79
    L74:
        r10 = "";
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
        this.t = (LyricsSeekContent) GsonProtectorUtils.fromJson(HttpExtKt.f, r21, LyricsSeekContent.class);     // Catch: JsonSyntaxException -> L11 JSONException -> L13
    L5:
        r4 = r17;
        goto L6
    }

    public final void W90(LarusFragmentMusicPlayerDetailBinding r3, String r4, MusicCreationContent r5) {
        if (r4 != null) goto L4;
        r4 = r5.getTitle();
    L4:
        String r1 = null;
        if ((r5 instanceof com.larus.bmhome.music.protocol.f) == false) goto L7;
        com.larus.bmhome.music.protocol.f r6 = (com.larus.bmhome.music.protocol.f) r5;
    L8:
        if (r6 == null) goto L10;
        r1 = r6.a;
    L10:
        r3.g.getBinding().j.setText(r4);
        if (TextUtils.isEmpty(r4) == false) goto L13;
        return;
    L13:
        if (TextUtils.isEmpty(r1) == true) goto L18;
        r3.g.getBinding().j.setOnClickListener(new t2(this));
        return;
    L18:
        return;
    L7:
        r6 = null;
        goto L8
    }

    public final void ca0(MusicCreationContent r33, boolean r34, boolean r35) {
        FLogger.a.d("MusicPlayerDetailFragment", "[shuffleAction] next state patching");
        this.o.k(true);
        com.larus.bmhome.music.player.j r1 = this.s;
        Message r13 = this.d;
        if (r13 == null) goto L6;
        String r3 = r13.getMessageId();
        if (r3 == null) goto L6;
    L7:
        if (r13 == null) goto L10;
        String r4 = r13.getConversationId();
        if (r4 == null) goto L10;
    L11:
        if (r1 == null) goto L14;
        String r5 = r1.d();
        if (r5 == null) goto L14;
    L15:
        if (r1 == null) goto L20;
        String r2 = r1.k();
        if (r2 == null) goto L20;
        String r6 = r2;
    L21:
        LifecycleCoroutineScope r7 = LifecycleOwnerKt.getLifecycleScope(this);
        String r10 = r33.getVid();
        String r8 = r33.getVideoModel();
        if (r8 != null) goto L24;
        String r9 = "";
    L25:
        ChatControlTrace r11 = ChatControlTrace.b;
        r11.getClass();
        String r20 = r11.h(ChatControlTrace.y);
        String r12 = r33.getTitle();
        if (r12 != null) goto L28;
        String r21 = "";
    L29:
        String r14 = r33.getChunkUrl();
        if (r14 != null) goto L32;
        String r22 = "";
    L33:
        com.larus.bmhome.music.player.j r15 = new com.larus.bmhome.music.player.j(r3, r4, r5, r6, "", -1, r9, r10, false, false, r7, 30, null, null, "creation_detail", false, r20, r21, r22, false, false, r33.getPlayList(), r34, r35, r13, "music_gen", 1585152);
        X90(r33, false);
        this.s = r15;
        this.o.d(r15);
        return;
    L32:
        r22 = r14;
        goto L33
    L28:
        r21 = r12;
        goto L29
    L24:
        r9 = r8;
    L20:
        r6 = "";
    L14:
        r5 = "";
    L10:
        r4 = "";
    L6:
        r3 = "";
        goto L7
    }

    public final View onCreateView(LayoutInflater r19, ViewGroup r20, Bundle r21) {
        Intrinsics.checkNotNullParameter(r19, "inflater");
        com.larus.bmhome.music.player.b.a.getClass();
        int r1 = 0;
        com.larus.bmhome.music.player.b.a.i = false;
        com.larus.bmhome.music.player.b.a.g = false;
        com.larus.bmhome.music.player.b.a.h = true;
        LarusFragmentMusicPlayerDetailBinding r2 = LarusFragmentMusicPlayerDetailBinding.a(r19, r20);
        this.p = r2;
        AppCompatImageView r3 = r2.c;
        if (r3 == null) goto L5;
        r3.setVisibility(8);
    L5:
        LarusFragmentMusicPlayerDetailBinding r4 = this.p;
        if (r4 == null) goto L10;
        MusicPlayerSlidingInfoView r5 = r4.g;
        if (r5 == null) goto L10;
        r5.e = true;
    L10:
        if (r4 == null) goto L18;
        MusicPlayerSlidingInfoView r6 = r4.g;
        if (r6 == null) goto L18;
        LarusViewMusicPlayerSlidingInfoBinding r7 = r6.getBinding();
        if (r7 == null) goto L18;
        ViewPager2 r8 = r7.i;
        if (r8 == null) goto L18;
        r8.setUserInputEnabled(false);
    L18:
        LarusFragmentMusicPlayerDetailBinding r9 = this.p;
        if (r9 == null) goto L21;
        CommonTemplateLayout r10 = r9.i;
    L22:
        com.larus.utils.w0.e(r10, j19.c.c(12));
        LarusFragmentMusicPlayerDetailBinding r11 = this.p;
        if (r11 == null) goto L33;
        CommonTemplateLayout r12 = r11.i;
        if (r12 == null) goto L33;
        Context r13 = getContext();
        if (r13 == null) goto L31;
        Resources r14 = r13.getResources();
        if (r14 == null) goto L31;
        Integer r15 = Integer.valueOf(r14.getColor(2131103298));
    L32:
        r12.setBackground(com.larus.utils.w0.b(r15, Float.valueOf(i5.h()), 0.2f, null, 8));
    L31:
        r15 = null;
    L33:
        Context r16 = getContext();
        if (r16 != null) goto L36;
        r16 = AppHost.a.getApplication();
    L36:
        Context r17 = r16;
        LarusFragmentMusicPlayerDetailBinding r18 = this.p;
        if (r18 == null) goto L39;
        CommonTemplateLayout r22 = r18.i;
    L40:
        if (r18 == null) goto L46;
        CreationOperateContainerView r23 = r18.e;
        if (r23 == null) goto L46;
        LarusCreationOperateContainerLayoutBinding r24 = r23.getBinding();
        if (r24 == null) goto L46;
        ViewGroup r25 = r24.c;
    L47:
        LarusFragmentMusicPlayerDetailBinding r26 = this.p;
        if (r26 == null) goto L50;
        CreationOperateContainerView r110 = r26.e;
    L51:
        UserCreation r111 = this.l;
        LifecycleCoroutineScope r112 = LifecycleOwnerKt.getLifecycleScope(this);
        int r27 = this.m;
        j2 r28 = getParentFragment();
        Intrinsics.checkNotNull(r28, "null cannot be cast to non-null type com.larus.profile.impl.creation.ICreationDelegateInterface");
        this.D = new CreationOperatorComponent(r17, r22, r25, r110, r111, r112, r28, Integer.valueOf(r27), null, false, 1792);
        Context r29 = getContext();
        if (r29 != null) goto L54;
        r29 = AppHost.a.getApplication();
    L54:
        Context r30 = r29;
        LarusFragmentMusicPlayerDetailBinding r31 = this.p;
        if (r31 == null) goto L57;
        View r32 = r31.i;
    L58:
        this.E = new u1(r30, r32, LifecycleOwnerKt.getLifecycleScope(this), this.l, false, false, null);
        if (com.larus.utils.o0.d(this.k) == false) goto L66;
        LarusFragmentMusicPlayerDetailBinding r33 = this.p;
        if (r33 == null) goto L66;
        CommonDownLoadLayout r34 = r33.f;
        if (r34 == null) goto L66;
        com.larus.utils.e1.o(r34);
    L66:
        if (com.larus.utils.o0.d(this.k) == false) goto L68;
        r1 = 4;
    L84:
        if (getContext() == null) goto L99;
        LarusFragmentMusicPlayerDetailBinding r35 = this.p;
        if (r35 == null) goto L94;
        CreationOperateContainerView r36 = r35.e;
        if (r36 == null) goto L94;
        LarusCreationOperateContainerLayoutBinding r37 = r36.getBinding();
        if (r37 == null) goto L94;
        ConstraintLayout r38 = r37.c;
        if (r38 == null) goto L94;
        r38.setBackgroundResource(2131238693);
    L94:
        LarusFragmentMusicPlayerDetailBinding r39 = this.p;
        if (r39 == null) goto L99;
        CommonDownLoadLayout r40 = r39.f;
        if (r40 == null) goto L99;
        r40.setBackgroundResource(2131238693);
    L99:
        u1 r41 = this.E;
        if (r41 == null) goto L102;
        r41.e(r1);
    L102:
        CreationOperatorComponent r42 = this.D;
        if (r42 == null) goto L105;
        r42.f(r1);
    L105:
        LarusFragmentMusicPlayerDetailBinding r43 = this.p;
        if (r43 == null) goto L114;
        CreationOperateContainerView r44 = r43.e;
        if (r44 == null) goto L114;
        LarusCreationOperateContainerLayoutBinding r45 = r44.getBinding();
        if (r45 == null) goto L114;
        ConstraintLayout r46 = r45.c;
        if (r46 == null) goto L114;
        com.larus.utils.e1.d(r46, new l2(this));
    L114:
        LarusFragmentMusicPlayerDetailBinding r47 = this.p;
        if (r47 == null) goto L123;
        CreationOperateContainerView r48 = r47.e;
        if (r48 == null) goto L123;
        LarusCreationOperateContainerLayoutBinding r49 = r48.getBinding();
        if (r49 == null) goto L123;
        ConstraintLayout r50 = r49.e;
        if (r50 == null) goto L123;
        com.larus.utils.e1.d(r50, new w2(this));
    L123:
        LarusFragmentMusicPlayerDetailBinding r51 = this.p;
        if (r51 == null) goto L126;
        CommonTemplateLayout r52 = r51.i;
    L127:
        com.larus.utils.e1.d(r52, new b3(this));
        MusicInfoEditHelper r53 = MusicInfoEditHelper.a;
        this.B = MusicInfoEditHelper.h(this, (com.larus.bmhome.music.edit.a) this.F.getValue());
        this.C = MusicInfoEditHelper.i(this, (com.larus.bmhome.music.edit.a) this.F.getValue());
        LarusFragmentMusicPlayerDetailBinding r54 = this.p;
        if (r54 != null) goto L130;
        return null;
    L130:
        return r54.a;
    L126:
        r52 = null;
        goto L127
    L68:
        UserCreation r55 = this.l;
        if (r55 == null) goto L71;
        Integer r56 = r55.d;
    L73:
        if (r56 != null) goto L76;
    L78:
        if (r56 == null) goto L84;
        if (r56.intValue() != 1) goto L84;
        r1 = 2;
        goto L84
    L76:
        if (r56.intValue() != 2) goto L78;
        r1 = 3;
        goto L84
    L71:
        r56 = null;
        goto L73
    L57:
        r32 = null;
        goto L58
    L50:
        r110 = null;
    L46:
        r25 = null;
        goto L47
    L39:
        r22 = null;
        goto L40
    L21:
        r10 = null;
        goto L22
    }

    public MusicDetailFragment(com.larus.bmhome.music.player.j r2, MusicCreationContent r3, int r4, boolean r5, Function0 r6, FrameLayout r7, String r8, UserCreation r9, int r10, gs9.d r11) {
        Intrinsics.checkNotNullParameter(r6, "selfDismissed");
        this.d = null;
        this.e = r2;
        this.f = r3;
        this.g = r4;
        this.h = r5;
        this.i = r6;
        this.j = r7;
        this.k = r8;
        this.l = r9;
        this.m = r10;
        this.n = r11;
        com.larus.bmhome.music.player.f r12 = com.larus.bmhome.music.player.f.a;
        this.o = com.larus.bmhome.music.player.f.b(this, null);
        this.w = "";
        this.x = "";
        this.A = System.currentTimeMillis();
        this.F = LazyKt.lazy(new n2(this));
        this.G = LazyKt.lazy(new o2(this));
        this.H = LazyKt.lazy(new p2(this));
        this.I = System.currentTimeMillis();
    }
}
