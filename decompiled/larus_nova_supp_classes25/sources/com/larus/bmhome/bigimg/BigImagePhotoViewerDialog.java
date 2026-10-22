package com.larus.bmhome.bigimg;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.bigimg.download.CommonDownLoadLayout;
import com.larus.bmhome.chat.api.RenderLiteDelegate;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.bmhome.chat.search.SourceFrom;
import com.larus.bmhome.common_ui.image.CustomPhotoTransitionPagerAdapter;
import com.larus.bmhome.common_ui.image.CustomPhotoViewerDialog;
import com.larus.bmhome.dora.IDoraEService;
import com.larus.bmhome.share.api.ShareServiceDelegate;
import com.larus.bmhome.view.menu.CreateMenu;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.photoviewer.PhotoViewerDialog;
import com.larus.common_ui.widget.roundlayout.RoundConstraintLayout;
import com.larus.home.impl.sdk.SdkWatermarkServiceImpl;
import com.larus.im.bean.message.Message;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.e4;
import com.larus.platform.api.r2;
import com.larus.platform.api.v2;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.z2;
import com.larus.search.api.event.HybridEventParams;
import com.larus.utils.logger.FLogger;
import com.skydoves.balloon.Balloon;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.annotation.AnnotationRetention;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.json.JSONObject;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000þ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 º\u00012\u00020\u0001:\u0004º\u0001»\u0001BÍ\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\b\u0012\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005\u0012\u0012\b\u0002\u0010\u0014\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0015\u001a\u00020\f\u0012\b\b\u0002\u0010\u0016\u001a\u00020\f\u0012\b\b\u0002\u0010\u0017\u001a\u00020\f¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010s\u001a\u00020^2\u0006\u0010t\u001a\u00020=H\u0002J\u0010\u0010u\u001a\u00020^2\u0006\u0010v\u001a\u00020=H\u0002J\u0010\u0010w\u001a\u00020^2\u0006\u0010t\u001a\u00020=H\u0002J\u0010\u0010x\u001a\u00020^2\u0006\u0010t\u001a\u00020=H\u0002J\u0010\u0010y\u001a\u00020^2\u0006\u0010z\u001a\u00020\fH\u0002J\u0010\u0010{\u001a\u00020^2\u0006\u0010z\u001a\u00020\fH\u0002J\b\u0010|\u001a\u00020^H\u0016J\b\u0010}\u001a\u00020^H\u0016J\b\u0010~\u001a\u00020^H\u0002J\b\u0010\u007f\u001a\u00020^H\u0002J\u001a\u0010\u0080\u0001\u001a\u00020^2\u0006\u0010t\u001a\u00020=2\u0007\u0010\u0081\u0001\u001a\u00020\bH\u0002J'\u0010\u0082\u0001\u001a\u00020^2\b\u0010\u000f\u001a\u0004\u0018\u00010\b2\t\u0010\u0083\u0001\u001a\u0004\u0018\u00010\b2\u0007\u0010\u0084\u0001\u001a\u00020\fH\u0002J\u0011\u0010\u0085\u0001\u001a\u0004\u0018\u00010=H\u0016¢\u0006\u0003\u0010\u0086\u0001J\u0015\u0010\u0087\u0001\u001a\u00020^2\n\u0010\u0088\u0001\u001a\u0005\u0018\u00010\u0089\u0001H\u0002J\u0011\u0010\u008a\u0001\u001a\u00020^2\u0006\u0010t\u001a\u00020=H\u0002J\u0011\u0010\u008b\u0001\u001a\u00020^2\u0006\u0010t\u001a\u00020=H\u0002J\u0012\u0010\u008c\u0001\u001a\u00020\b2\u0007\u0010\u008d\u0001\u001a\u00020\bH\u0002JE\u0010\u008e\u0001\u001a\u00020^2\u0006\u0010t\u001a\u00020=2\u0007\u0010\u008d\u0001\u001a\u00020\b2#\b\u0002\u0010\u008f\u0001\u001a\u001c\b\u0001\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020^0\u0090\u0001\u0012\u0007\u0012\u0005\u0018\u00010\u0091\u0001\u0018\u00010]H\u0002¢\u0006\u0003\u0010\u0092\u0001JE\u0010\u0093\u0001\u001a\u00020^2\u0006\u0010t\u001a\u00020=2\u0007\u0010\u008d\u0001\u001a\u00020\b2#\b\u0002\u0010\u008f\u0001\u001a\u001c\b\u0001\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020^0\u0090\u0001\u0012\u0007\u0012\u0005\u0018\u00010\u0091\u0001\u0018\u00010]H\u0002¢\u0006\u0003\u0010\u0092\u0001J&\u0010\u0094\u0001\u001a\u00020^2\n\u0010\u0095\u0001\u001a\u0005\u0018\u00010\u0096\u00012\u0006\u0010t\u001a\u00020=2\u0007\u0010\u0097\u0001\u001a\u00020\bH\u0002J\u001a\u0010\u0098\u0001\u001a\u00020^2\u0007\u0010\u0099\u0001\u001a\u00020\b2\u0006\u0010t\u001a\u00020=H\u0002J\u001a\u0010\u009a\u0001\u001a\u00020^2\u0007\u0010\u0099\u0001\u001a\u00020\b2\u0006\u0010t\u001a\u00020=H\u0002J#\u0010\u009b\u0001\u001a\u00020^2\u0006\u0010t\u001a\u00020=2\u0007\u0010\u008d\u0001\u001a\u00020\b2\u0007\u0010\u0099\u0001\u001a\u00020\bH\u0002J#\u0010\u009c\u0001\u001a\u00020^2\u0006\u0010t\u001a\u00020=2\u0007\u0010\u008d\u0001\u001a\u00020\b2\u0007\u0010\u0099\u0001\u001a\u00020\bH\u0002JR\u0010\u009d\u0001\u001a\u00020^2\u0007\u0010\u008d\u0001\u001a\u00020\b2\b\b\u0002\u0010\u001e\u001a\u00020\f2\t\b\u0002\u0010\u0099\u0001\u001a\u00020\b2#\b\u0002\u0010\u008f\u0001\u001a\u001c\b\u0001\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020^0\u0090\u0001\u0012\u0007\u0012\u0005\u0018\u00010\u0091\u0001\u0018\u00010]H\u0002¢\u0006\u0003\u0010\u009e\u0001J\u001b\u0010\u009f\u0001\u001a\u00020^2\u0007\u0010 \u0001\u001a\u00020\b2\u0007\u0010\u0099\u0001\u001a\u00020\bH\u0002J\"\u0010¡\u0001\u001a\u00030¢\u00012\u000b\b\u0002\u0010£\u0001\u001a\u0004\u0018\u00010\b2\t\b\u0002\u0010\u0099\u0001\u001a\u00020\bH\u0002J\u0012\u0010¤\u0001\u001a\u00020^2\u0007\u0010¥\u0001\u001a\u000209H\u0002J\t\u0010¦\u0001\u001a\u00020^H\u0002JN\u0010§\u0001\u001a\u00020^2\u0006\u0010t\u001a\u00020=2\u0013\u0010¨\u0001\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020^0]2\u0016\u0010©\u0001\u001a\u0011\u0012\u0007\u0012\u0005\u0018\u00010\u0096\u0001\u0012\u0004\u0012\u00020^0]2\u000e\u0010ª\u0001\u001a\t\u0012\u0004\u0012\u00020^0«\u0001H\u0002J\u0012\u0010¬\u0001\u001a\u00020^2\u0007\u0010\u00ad\u0001\u001a\u00020=H\u0002J\u0012\u0010®\u0001\u001a\u00020\f2\u0007\u0010\u00ad\u0001\u001a\u00020=H\u0002J\u0011\u0010¯\u0001\u001a\u00020^2\u0006\u0010t\u001a\u00020=H\u0002J\u0011\u0010°\u0001\u001a\u00020^2\u0006\u0010t\u001a\u00020=H\u0002J\u0011\u0010±\u0001\u001a\u00020=2\u0006\u0010t\u001a\u00020=H\u0002J*\u0010²\u0001\u001a\u001a\u0012\u0004\u0012\u00020\b\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020=0N0M2\u0007\u0010³\u0001\u001a\u00020\bH\u0002J\u0016\u0010´\u0001\u001a\u0004\u0018\u00010\b2\t\u0010µ\u0001\u001a\u0004\u0018\u00010\bH\u0002J\u0011\u0010¶\u0001\u001a\u00020^2\u0006\u0010t\u001a\u00020=H\u0002J-\u0010·\u0001\u001a\u00020^2\u0007\u0010\u00ad\u0001\u001a\u00020=2\u0007\u0010¥\u0001\u001a\u0002092\u0007\u0010¸\u0001\u001a\u00020\f2\t\b\u0002\u0010¹\u0001\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0014\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0015\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0016\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u0011\u0010\u0017\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001bR\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00102\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u0004\u0018\u000105X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00106\u001a\u0004\u0018\u000107X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00108\u001a\u0004\u0018\u000109X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010:\u001a\u0004\u0018\u00010;X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020=X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020?X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010@\u001a\b\u0012\u0004\u0012\u00020=0AX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010B\u001a\b\u0012\u0004\u0012\u00020=0AX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010C\u001a\u0012\u0012\u0004\u0012\u00020=0Dj\b\u0012\u0004\u0012\u00020=`EX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010F\u001a\u00020G8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bJ\u0010K\u001a\u0004\bH\u0010IR(\u0010L\u001a\u001c\u0012\u0004\u0012\u00020\b\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020=0N\u0018\u00010MX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010O\u001a\u0004\u0018\u00010PX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR\u001c\u0010U\u001a\u0004\u0018\u00010VX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR\u000e\u0010[\u001a\u00020=X\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\\\u001a\u0010\u0012\u0004\u0012\u00020=\u0012\u0004\u0012\u00020^\u0018\u00010]X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bRC\u0010c\u001a+\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020^0]¢\u0006\f\bd\u0012\b\be\u0012\u0004\b\b(f\u0012\u0004\u0012\u00020^\u0018\u00010]X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bg\u0010`\"\u0004\bh\u0010bRC\u0010i\u001a+\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020^0]¢\u0006\f\bd\u0012\b\be\u0012\u0004\b\b(f\u0012\u0004\u0012\u00020^\u0018\u00010]X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bj\u0010`\"\u0004\bk\u0010bR`\u0010l\u001aH\u0012\u0013\u0012\u00110\b¢\u0006\f\bd\u0012\b\be\u0012\u0004\b\b(n\u0012'\u0012%\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020^0m¢\u0006\f\bd\u0012\b\be\u0012\u0004\b\b(f\u0012\u0004\u0012\u00020^\u0018\u00010mX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bo\u0010p\"\u0004\bq\u0010r¨\u0006¼\u0001"}, d2 = {"Lcom/larus/bmhome/bigimg/BigImagePhotoViewerDialog;", "Lcom/larus/bmhome/common_ui/image/CustomPhotoViewerDialog;", "context", "Landroid/content/Context;", "imageUrls", "", "Lcom/larus/bmhome/bigimg/ImagePreviewDownloadUrl;", "thumbImageUrls", "", "reportParams", "Lcom/larus/bmhome/common_ui/image/PhotoViewerReportParams;", "showIndicator", "", "hybridEventParams", "Lcom/larus/search/api/event/HybridEventParams;", "messageId", "messageCreationInfo", "templateURLs", "footInfo", "trackerInfo", "imageCaption", "showDownload", "showShare", "shouldEnableLongPress", "<init>", "(Landroid/content/Context;Ljava/util/List;Ljava/util/List;Lcom/larus/bmhome/common_ui/image/PhotoViewerReportParams;ZLcom/larus/search/api/event/HybridEventParams;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;ZZZ)V", "getShowDownload", "()Z", "getShowShare", "getShouldEnableLongPress", "share", "Landroid/widget/ImageView;", "descText", "Landroid/widget/TextView;", "download", "Lcom/larus/bmhome/bigimg/download/CommonDownLoadLayout;", "backIcon", "sourceLayout", "Landroid/view/ViewGroup;", "sourceIcon", "Lcom/facebook/drawee/view/SimpleDraweeView;", "sourceIconV2", "sourceText", "sourceDomainContainer", "sourceDomainText", "indicator", "captionText", "titleBar", "addButton", "Landroid/widget/Button;", "privacyContainer", "privacyText", "bottomToolsContainer", "Landroidx/constraintlayout/widget/ConstraintLayout;", "lynxFooterView", "Lcom/larus/platform/api/IvyPluginView;", "appletLynxView", "Landroid/view/View;", "lynxContainer", "Landroid/widget/FrameLayout;", "previousIndex", "", "startTime", "", "loadedIndexList", "", "filteredIndexList", "enterPicDetailEventHistory", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "awemeImageFilter", "Lcom/larus/bmhome/bigimg/AwemeImageFilter;", "getAwemeImageFilter", "()Lcom/larus/bmhome/bigimg/AwemeImageFilter;", "awemeImageFilter$delegate", "Lkotlin/Lazy;", "creationStatus", "", "Lkotlin/Pair;", "imageSourceProvider", "Lcom/larus/bmhome/bigimg/IBigImageSourceProvider;", "getImageSourceProvider", "()Lcom/larus/bmhome/bigimg/IBigImageSourceProvider;", "setImageSourceProvider", "(Lcom/larus/bmhome/bigimg/IBigImageSourceProvider;)V", "imageChangedByScrollListener", "Lcom/larus/bmhome/bigimg/BigCreationChangedByScrollListener;", "getImageChangedByScrollListener", "()Lcom/larus/bmhome/bigimg/BigCreationChangedByScrollListener;", "setImageChangedByScrollListener", "(Lcom/larus/bmhome/bigimg/BigCreationChangedByScrollListener;)V", "latestCreationPrivateStatus", "onUserScrollImageCallback", "Lkotlin/Function1;", "", "getOnUserScrollImageCallback", "()Lkotlin/jvm/functions/Function1;", "setOnUserScrollImageCallback", "(Lkotlin/jvm/functions/Function1;)V", "onDownloadInterceptor", "Lkotlin/ParameterName;", "name", "callback", "getOnDownloadInterceptor", "setOnDownloadInterceptor", "onShareInterceptor", "getOnShareInterceptor", "setOnShareInterceptor", "onWatermarkInterceptor", "Lkotlin/Function2;", "path", "getOnWatermarkInterceptor", "()Lkotlin/jvm/functions/Function2;", "setOnWatermarkInterceptor", "(Lkotlin/jvm/functions/Function2;)V", "updateImageCaption", "pos", "refreshButtonStatus", "status", "inflateLynxView", "updateLynxFootViewData", "openPrivacyDialog", "private", "setCreationPrivacy", "onAttachedToWindow", "onDetachedFromWindow", "deleteCreation", "addCreation", "reportEnterPicDetailEvent", "enterMethod", "reportPicAddCreation", "creationId", "success", "getExtraViewLayout", "()Ljava/lang/Integer;", "initIconListeners", "message", "Lcom/larus/im/bean/message/Message;", "onDownloadAction", "performDownloadAction", "generateWatermarkUrl", "imageUrl", "saveBitmapWithCheckWatermark", "checkBlock", "Lkotlin/coroutines/Continuation;", "", "(ILjava/lang/String;Lkotlin/jvm/functions/Function1;)V", "saveBitmapWithCheckBaseWatermark", "onCheckImageAuthDeny", "error", "", "methodTag", "onDoShareAction", "source", "performShareAction", "shareBitmapWithCheckWatermark", "shareBitmapWithCheckBaseWatermark", "saveBitmap", "(Ljava/lang/String;ZLjava/lang/String;Lkotlin/jvm/functions/Function1;)V", "openSystemShare", "cachedImageUrl", "transToSharePanelEventParam", "Lcom/larus/bmhome/share/panel/SharePanelEventParam;", "currentPage", "onOpenImageSourceAction", "view", "sendRichMediaPictureLinkCLickEvent", "tryCheckImageAuthWithWatermark", "onGranted", "onDeny", "defaultAction", "Lkotlin/Function0;", "updateIconStatus", "position", "isLocalComputerImage", "updateImageSourceV2", "updateImageSource", "getCurrentButtonStatus", "getCreationStatusFormJson", "creationStatusInfo", "extractDomainFromUrl", "url", "updateSourceDomain", "showAnimatedSafely", "enableRestoreTransition", "tag", "Companion", "UserCreationPrivateStatus", "image_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class BigImagePhotoViewerDialog extends CustomPhotoViewerDialog {
    public static final /* synthetic */ int V0 = 0;
    public final boolean A;
    public final ImageView B;
    public final TextView C;
    public final CommonDownLoadLayout D;
    public final ImageView E;
    public final ViewGroup F;
    public final ImageView G;
    public final ViewGroup H;
    public int H0;
    public final TextView I;
    public final TextView J;
    public final TextView K;
    public final ViewGroup L;
    public Function1<? super Integer, Unit> L0;
    public final Button M;
    public final ViewGroup N;
    public final TextView O;
    public final ConstraintLayout P;
    public Function2<? super String, ? super Function2<? super Boolean, ? super String, Unit>, Unit> P0;
    public e4 Q;
    public View R;
    public final FrameLayout S;
    public int T;
    public final long U;
    public final Set<Integer> V;
    public final Set<Integer> W;
    public final HashSet<Integer> X;
    public final Lazy Y;
    public Map<String, Pair<String, Integer>> Z;
    public k1 k0;
    public e p0;
    public final Context q;
    public final boolean r;
    public final HybridEventParams s;
    public final String t;
    public final List<String> u;
    public final List<String> v;
    public final List<String> w;
    public final List<String> x;
    public final boolean y;
    public final boolean z;

    /* JADX INFO: renamed from: com.larus.bmhome.bigimg.BigImagePhotoViewerDialog$9, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.bigimg.BigImagePhotoViewerDialog$9", f = "BigImagePhotoViewerDialog.kt", i = {2}, l = {261, 267, 268, 271}, m = "invokeSuspend", n = {"message"}, s = {"L$0"})
    final class AnonymousClass9 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.ObjectRef<Message> $realMessage;
        Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ BigImagePhotoViewerDialog this$0;

        /* JADX INFO: renamed from: com.larus.bmhome.bigimg.BigImagePhotoViewerDialog$9$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
        @DebugMetadata(c = "com.larus.bmhome.bigimg.BigImagePhotoViewerDialog$9$1", f = "BigImagePhotoViewerDialog.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ BigImagePhotoViewerDialog this$0;

            public AnonymousClass1(BigImagePhotoViewerDialog r1, Continuation<? super AnonymousClass1> r2) {
                this.this$0 = r1;
                super(2, r2);
            }

            public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
                return new AnonymousClass1(this.this$0, r3);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((CoroutineScope) r1, (Continuation) r2);
            }

            public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r2) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L7;
                ResultKt.throwOnFailure(r2);
                BigImagePhotoViewerDialog r3 = this.this$0;
                int r0 = BigImagePhotoViewerDialog.V0;
                r3.p(0);
                BigImagePhotoViewerDialog.i(this.this$0, null);
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: renamed from: com.larus.bmhome.bigimg.BigImagePhotoViewerDialog$9$2, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
        @DebugMetadata(c = "com.larus.bmhome.bigimg.BigImagePhotoViewerDialog$9$2", f = "BigImagePhotoViewerDialog.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Ref.ObjectRef<Message> $realMessage;
            int label;
            final /* synthetic */ BigImagePhotoViewerDialog this$0;

            public AnonymousClass2(BigImagePhotoViewerDialog r1, Ref.ObjectRef<Message> r2, Continuation<? super AnonymousClass2> r3) {
                this.this$0 = r1;
                this.$realMessage = r2;
                super(2, r3);
            }

            public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
                return new AnonymousClass2(this.this$0, this.$realMessage, r4);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((CoroutineScope) r1, (Continuation) r2);
            }

            public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r2) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L7;
                ResultKt.throwOnFailure(r2);
                BigImagePhotoViewerDialog r3 = this.this$0;
                int r0 = ((PhotoViewerDialog) r3).f;
                int r1 = BigImagePhotoViewerDialog.V0;
                r3.getClass();
                r3.p(0);
                BigImagePhotoViewerDialog.i(this.this$0, (Message) this.$realMessage.element);
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        public AnonymousClass9(BigImagePhotoViewerDialog r1, Ref.ObjectRef<Message> r2, Continuation<? super AnonymousClass9> r3) {
            this.this$0 = r1;
            this.$realMessage = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass9(this.this$0, this.$realMessage, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r13) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            String r5 = "";
            if (r1 == 0) goto L14;
            if (r1 == 1) goto L13;
            if (r1 == 2) goto L12;
            if (r1 == 3) goto L11;
            if (r1 != 4) goto L10;
            ResultKt.throwOnFailure(r13);
        L71:
            return Unit.INSTANCE;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L11:
            Ref.ObjectRef<Message> r2 = (Ref.ObjectRef) this.L$1;
            String r3 = (String) this.L$0;
            ResultKt.throwOnFailure(r13);
        L46:
            Message r14 = (Message) r13;
        L48:
            r2.element = r14;
            BigImagePhotoViewerDialog r15 = this.this$0;
            if (r3 == null) goto L52;
            r5 = r3;
        L52:
            int r4 = BigImagePhotoViewerDialog.V0;
            r15.getClass();
            LinkedHashMap r6 = new LinkedHashMap();
            JSONObject r7 = new JSONObject(r5);     // Catch: Exception -> L65
            ArrayList r8 = new ArrayList();     // Catch: Exception -> L65
            Iterator<String> r9 = r7.keys();     // Catch: Exception -> L65
        L55:
            if (r9.hasNext() == false) goto L58;
            r8.add(r9.next());     // Catch: Exception -> L65
            goto L55
        L58:
            if (r8.size() <= 1) goto L60;
            CollectionsKt.sortWith(r8, new g1());     // Catch: Exception -> L65
        L60:
            Iterator r10 = r8.iterator();     // Catch: Exception -> L65
        L61:
            if (r10.hasNext() == false) goto L67;
            String r11 = (String) r10.next();     // Catch: Exception -> L65
            JSONObject r12 = new JSONObject(r7.optString(r11));     // Catch: Exception -> L65
            r6.put(r11, new Pair(r12.optString("creation_id"), Integer.valueOf(r12.optInt("private_status"))));     // Catch: Exception -> L65
        L67:
            r15.Z = r6;
            MainCoroutineDispatcher r16 = Dispatchers.getMain();
            AnonymousClass2 r17 = new AnonymousClass2(this.this$0, this.$realMessage, null);
            this.L$0 = null;
            this.L$1 = null;
            this.label = 4;
            if (BuildersKt.withContext(r16, r17, this) != r0) goto L71;
            return r0;
        L65:
            e = move-exception;
            FLogger.a.e("BigImagePhotoViewer", "There have something wrong when parse!!!e=" + e.getMessage());
            goto L67
        L12:
            ResultKt.throwOnFailure(r13);
        L35:
            String r18 = (String) r13;
        L37:
            r2 = this.$realMessage;
            IChatRepoService r19 = RepoDispatcherDelegate.b.e();
            if (r19 == null) goto L47;
            String r20 = this.this$0.t;
            if (r20 != null) goto L42;
            r20 = "";
        L42:
            this.L$0 = r18;
            this.L$1 = r2;
            this.label = 3;
            Object r21 = r19.E1(r20, this);
            if (r21 != r0) goto L45;
            return r0;
        L45:
            r3 = r18;
            r13 = r21;
            goto L46
        L47:
            r3 = r18;
            r14 = null;
            goto L48
        L13:
            ResultKt.throwOnFailure(r13);
        L26:
            return Unit.INSTANCE;
        L14:
            ResultKt.throwOnFailure(r13);
            String r110 = this.this$0.t;
            if (r110 != null) goto L17;
        L20:
            boolean r111 = true;
        L21:
            if (r111 == false) goto L27;
            MainCoroutineDispatcher r112 = Dispatchers.getMain();
            AnonymousClass1 r22 = new AnonymousClass1(this.this$0, null);
            this.label = 1;
            if (BuildersKt.withContext(r112, r22, this) != r0) goto L26;
            return r0;
        L27:
            IChatRepoService r113 = RepoDispatcherDelegate.b.e();
            if (r113 == null) goto L36;
            String r23 = this.this$0.t;
            if (r23 != null) goto L32;
            r23 = "";
        L32:
            this.label = 2;
            r13 = r113.w1(r23, this);
            if (r13 != r0) goto L35;
            return r0;
        L36:
            r18 = null;
            goto L37
        L17:
            if (r110.length() == 0) goto L20;
            r111 = false;
            goto L21
        }
    }

    public static final class Companion {

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/larus/bmhome/bigimg/BigImagePhotoViewerDialog$Companion$ButtonStatus;", "", "Companion", "image_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
        @Retention(RetentionPolicy.SOURCE)
        @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
        public @interface ButtonStatus {
            public static final int AddedPrivate = 2;
            public static final int AddedPublic = 3;
            public static final a Companion = null;
            public static final int Disable = 0;
            public static final int UnAdd = 1;

            public static final class a {
                public static final /* synthetic */ a a = null;

                static {
                    a = new a();
                }

                public a() {
                }
            }

            static {
                Companion = a.a;
            }
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/larus/bmhome/bigimg/BigImagePhotoViewerDialog$UserCreationPrivateStatus;", "", "Companion", "image_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface UserCreationPrivateStatus {
        public static final a Companion = null;
        public static final int PRIVATE = 2;
        public static final int PUBLIC = 1;
        public static final int UNKNOWN = 0;

        public static final class a {
            public static final /* synthetic */ a a = null;

            static {
                a = new a();
            }

            public a() {
            }
        }

        static {
            Companion = a.a;
        }
    }

    static {
    }

    public BigImagePhotoViewerDialog() {
        throw null;
    }

    public final Integer g() {
        return 2131562746;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onAttachedToWindow() {
        super/*android.app.Dialog*/.onAttachedToWindow();
        IFlowSdkDepend r0 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r0 == null) goto L5;
        r0.m0();
        SdkWatermarkServiceImpl.a.d(this);
    L5:
        g.a = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDetachedFromWindow() {
        super/*android.app.Dialog*/.onDetachedFromWindow();
        g.a = false;
        IFlowSdkDepend r0 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r0 == null) goto L6;
        r0.m0();
        SdkWatermarkServiceImpl.a.e(this);
        return;
    }

    public final boolean j(int r4) {
        k1 r0 = this.k0;
        if (r0 == null) goto L12;
        l r5 = r0.a(r4);
        if (r5 == null) goto L13;
        String r6 = r5.b;
        if (r6 != null) goto L9;
        return false;
    L9:
        if (StringsKt.startsWith(r6, "file://", true) != true) goto L15;
        return true;
    L15:
        return false;
    L13:
        return false;
    L12:
        return false;
    }

    public final void n(View r8) {
        IFlowSdkDepend r0 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        HybridEventParams r1 = null;
        if (r0 == null) goto L5;
        v2 r2 = r0.Y();
    L7:
        if (r2 != null) goto L9;
    L11:
        boolean r3 = false;
    L12:
        if (r3 == false) goto L14;
        return;
    L14:
        k1 r4 = this.k0;
        if (r4 != null) goto L17;
        return;
    L17:
        l r5 = r4.a(((PhotoViewerDialog) this).f);
        if (r5 == null) goto L20;
        String r6 = r5.i;
    L21:
        if (r6 != null) goto L23;
    L26:
        boolean r7 = true;
    L27:
        if (r7 == false) goto L29;
        return;
    L29:
        if (r5 == null) goto L31;
        String r9 = r5.i;
    L32:
        Uri r10 = UriProtector.parse(r9);
        IFlowSdkDepend r11 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r11 == null) goto L35;
        r2 r12 = r11.A0();
    L36:
        if (r12 == null) goto L40;
        Intrinsics.checkNotNull(r10);
        if (r12.j(r10) != true) goto L40;
        boolean r13 = true;
    L41:
        if (r13 == false) goto L67;
        JSONObject r14 = new JSONObject();
        HybridEventParams r15 = this.s;
        if (r15 == null) goto L47;
        String r16 = r15.a;
        if (r16 == null) goto L47;
        r14.put("enter_method", r16);
    L47:
        HybridEventParams r17 = this.s;
        if (r17 == null) goto L52;
        String r18 = r17.b;
        if (r18 == null) goto L52;
        r14.put("local_page", r18);
    L52:
        HybridEventParams r19 = this.s;
        if (r19 == null) goto L57;
        String r20 = r19.c;
        if (r20 == null) goto L57;
        r14.put("chat_type", r20);
    L57:
        HybridEventParams r21 = this.s;
        if (r21 == null) goto L65;
        Map r22 = r21.f;
        if (r22 == null) goto L65;
        Iterator r23 = r22.entrySet().iterator();
    L63:
        if (r23.hasNext() == false) goto L65;
        Map.Entry r24 = (Map.Entry) r23.next();
        r14.put((String) r24.getKey(), (String) r24.getValue());
    L65:
        Context r25 = r8.getContext();
        Intrinsics.checkNotNull(r10);
        r12.a(r25, r10);
        return;
    L67:
        by7.a r26 = new by7.a("rich_media_picture_link_click");
        r26.a.merge(new TrackParams().merge(h(((PhotoViewerDialog) this).f)));
        r26.b();
        com.larus.platform.service.q r27 = com.larus.platform.service.q.a;
        Context r28 = r8.getContext();
        Pair[] r29 = new Pair[2];
        if (r5 == null) goto L70;
        String r30 = r5.i;
    L71:
        r29[0] = TuplesKt.to("link_url", r30);
        r29[1] = TuplesKt.to("enable_bottom_share_style", String.valueOf(z2.a.S2()));
        Bundle r31 = com.larus.utils.f.c(r29);
        HybridEventParams r32 = this.s;
        if (r32 == null) goto L74;
        r32.e = Boolean.TRUE;
        r32.a(h(((PhotoViewerDialog) this).f));
        Unit r33 = Unit.INSTANCE;
        r1 = r32;
    L74:
        r27.e(r28, r31, r1);
        return;
    L70:
        r30 = null;
    L40:
        r13 = false;
        goto L41
    L35:
        r12 = null;
        goto L36
    L31:
        r9 = null;
        goto L32
    L23:
        if (r6.length() == 0) goto L26;
        r7 = false;
        goto L27
    L20:
        r6 = null;
        goto L21
    L9:
        if (r2.a(null) != true) goto L11;
        r3 = true;
        goto L12
    L5:
        r2 = null;
        goto L7
    }

    public final void o(boolean r87) {
        ArrayList r2 = new ArrayList();
        if (r87 == false) goto L5;
        int r5 = 2131899193;
    L6:
        if (r87 == false) goto L8;
        int r6 = 2131899193;
    L9:
        Integer r10 = Integer.valueOf(v19.c.b(2130972079, this.q, 2131103136));
        if (r87 == false) goto L12;
        int r3 = 2131240228;
    L13:
        int r4 = r5;
        int r7 = r6;
        r2.add(new com.larus.bmhome.view.screenmenu.l0(r4, r7, null, null, null, r10, null, Integer.valueOf(r3), null, false, false, null, null, null, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -164, 127));
        r2.add(new com.larus.bmhome.view.screenmenu.l0(2131908791, 2131908791, null, null, null, 2131102650, null, 2131240211, null, false, false, null, null, null, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -164, 127));
        View r1 = CreateMenu.f(new CreateMenu(this.q), r2, 0, false, null, null, null, null, new o0(this), 510);
        com.larus.bmhome.view.screenmenu.d r11 = com.larus.bmhome.view.screenmenu.d.a;
        View r8 = this.N;
        if (r8 != null) goto L16;
        r8 = ((PhotoViewerDialog) this).c;
    L16:
        Balloon r9 = com.larus.bmhome.view.screenmenu.d.a(r11, r8, r1, false, null, null, null, null, 124);
        ViewGroup.LayoutParams r12 = r1.getLayoutParams();
        if ((r12 instanceof ViewGroup.MarginLayoutParams) == false) goto L19;
        ViewGroup.MarginLayoutParams r13 = (ViewGroup.MarginLayoutParams) r12;
    L20:
        if (r13 == null) goto L23;
        r13.setMarginEnd((-i5.T()) + i5.h());
    L23:
        View r14 = this.N;
        if (r14 != null) goto L26;
        r14 = ((PhotoViewerDialog) this).c;
    L26:
        r9.v(r14, i5.Q(), i5.E());
        return;
    L19:
        r13 = null;
        goto L20
    L12:
        r3 = 2131240225;
        goto L13
    L8:
        r6 = 2131899197;
        goto L9
    L5:
        r5 = 2131899197;
        goto L6
    }

    public final void p(int r4) {
        if (com.larus.bmhome.utils.u.h() == true) goto L5;
    L49:
        ViewGroup r5 = this.N;
        if (r5 == null) goto L52;
        r5.setVisibility(4);
    L52:
        Button r6 = this.M;
        if (r6 == null) goto L61;
        r6.setVisibility(8);
        return;
    L61:
        return;
    L5:
        if (AccountService.a.isLogin().booleanValue() == false) goto L49;
        if (r4 != 1) goto L10;
        ViewGroup r7 = this.N;
        if (r7 == null) goto L42;
        r7.setVisibility(8);
    L42:
        Button r8 = this.M;
        if (r8 == null) goto L45;
        com.larus.utils.e1.x(r8);
    L45:
        Button r9 = this.M;
        if (r9 == null) goto L60;
        com.larus.utils.e1.d(r9, new b0(this));
        return;
    L60:
        return;
    L10:
        if (r4 != 2) goto L12;
        ViewGroup r10 = this.N;
        if (r10 == null) goto L32;
        com.larus.utils.e1.x(r10);
    L32:
        TextView r11 = this.O;
        if (r11 == null) goto L35;
        r11.setText(this.q.getResources().getString(2131899192));
    L35:
        Button r12 = this.M;
        if (r12 == null) goto L38;
        r12.setVisibility(8);
    L38:
        com.larus.utils.e1.d(this.N, new m0(this));
        return;
    L12:
        if (r4 == 3) goto L19;
        ViewGroup r13 = this.N;
        if (r13 == null) goto L16;
        r13.setVisibility(8);
    L16:
        Button r14 = this.M;
        if (r14 == null) goto L56;
        r14.setVisibility(8);
        return;
    L56:
        return;
    L19:
        ViewGroup r15 = this.N;
        if (r15 == null) goto L22;
        com.larus.utils.e1.x(r15);
    L22:
        TextView r16 = this.O;
        if (r16 == null) goto L25;
        r16.setText(this.q.getResources().getString(2131899189));
    L25:
        Button r17 = this.M;
        if (r17 == null) goto L28;
        r17.setVisibility(8);
    L28:
        com.larus.utils.e1.d(this.N, new x0(this));
    }

    public final void t(boolean r15) {
        if (r15 == false) goto L5;
        int r7 = 3;
    L6:
        if (r15 == false) goto L8;
        int r4 = 2;
    L9:
        if (r15 == false) goto L11;
        int r6 = 2;
    L12:
        p(r6);
        BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new BigImagePhotoViewerDialog$setCreationPrivacy$1(this, r4, r15, r6, r7, null), 3, null);
        return;
    L11:
        r6 = 3;
        goto L12
    L8:
        r4 = 1;
        goto L9
    L5:
        r7 = 2;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r5v2, types: [android.view.ViewGroup, com.larus.bmhome.bigimg.download.CommonDownLoadLayout] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void x(int r5) {
        if (r5 == ((PhotoViewerDialog) this).f) goto L5;
        return;
    L5:
        boolean r1 = true;
        if (this.V.contains(Integer.valueOf(r5)) == true) goto L8;
    L16:
        ConstraintLayout r0 = this.D;
        if (r0 == null) goto L19;
        r0.setEnabled(false);
    L19:
        ImageView r2 = this.B;
        if (r2 == null) goto L23;
        r2.setEnabled(false);
    L23:
        if (j(r5) == false) goto L30;
        ConstraintLayout r6 = this.D;
        if (r6 == null) goto L27;
        r6.setEnabled(false);
    L27:
        ImageView r7 = this.B;
        if (r7 == null) goto L30;
        r7.setEnabled(false);
    L30:
        ?? r8 = this.D;
        if (r8 == 0) goto L39;
        if (r8 != 0) goto L34;
    L36:
        r1 = false;
    L37:
        r8.setLayoutEnable(r1);
        return;
    L34:
        if (r8.isEnabled() != true) goto L36;
    L39:
        return;
    L8:
        if (this.W.contains(Integer.valueOf(r5)) == true) goto L16;
        ConstraintLayout r3 = this.D;
        if (r3 == null) goto L13;
        r3.setEnabled(true);
    L13:
        ImageView r4 = this.B;
        if (r4 == null) goto L23;
        r4.setEnabled(true);
        goto L23
    }

    public final void y(int r4) {
        List<String> r0 = this.v;
        if (r0 == null) goto L24;
        String r5 = (String) CollectionsKt.getOrNull(r0, r4);
        if (r5 == null) goto L25;
        FLogger.a.i("BigImagePhotoViewer", "updateData ".concat(r5));
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L9
        Object r6 = Result.constructor-impl(JSONObjectProtectorUtils.getString(new JSONObject(r5), "data"));     // Catch: Throwable -> L9
    L12:
        if (Result.exceptionOrNull-impl(r6) == null) goto L15;
        r6 = "";
    L15:
        String r7 = (String) r6;
        e4 r2 = this.Q;
        if (r2 == null) goto L18;
        Intrinsics.checkNotNull(r7);
        r2.updateData(r7);
    L18:
        View r3 = this.R;
        if (r3 == null) goto L26;
        RenderLiteDelegate r8 = RenderLiteDelegate.a;
        Intrinsics.checkNotNull(r7);
        r8.a(r3, r7);
        return;
    L26:
        return;
    L9:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L12
    L25:
        return;
    }

    public static final void i(final BigImagePhotoViewerDialog r4, Message r5) {
        if (r4.y == true) goto L7;
        ConstraintLayout r0 = r4.D;
        if (r0 == null) goto L7;
        r0.setVisibility(8);
    L7:
        ConstraintLayout r1 = r4.D;
        if (r1 == null) goto L10;
        com.larus.utils.e1.d(r1, new e1(r4));
    L10:
        boolean r2 = true;
        if (AppHost.a.isPlugin() == false) goto L13;
    L22:
        ImageView r3 = r4.B;
        if (r3 == null) goto L25;
        r3.setVisibility(8);
    L25:
        if (r5 != null) goto L27;
    L29:
        r2 = false;
    L30:
        if (r2 == false) goto L41;
        TextView r6 = r4.C;
        if (r6 == null) goto L34;
        r6.setVisibility(0);
    L34:
        TextView r7 = r4.C;
        if (r7 == null) goto L41;
        IDoraEService r8 = (IDoraEService) ServiceManager.get().getService(IDoraEService.class);
        if (r8 == null) goto L39;
        String r9 = r8.b(r5);
    L40:
        r7.setText(r9);
        goto L41
    L39:
        r9 = null;
    L41:
        ImageView r10 = r4.B;
        if (r10 == null) goto L44;
        com.larus.utils.e1.d(r10, new c0(r4));
    L44:
        ViewGroup r11 = r4.F;
        if (r11 == null) goto L47;
        com.larus.utils.e1.d(r11, new d0(r4));
    L47:
        com.larus.utils.e1.d(r4.G, new e0(r4));
        ImageView r12 = r4.E;
        if (r12 == null) goto L51;
        com.larus.utils.e1.d(r12, new f0(r4));
        return;
    L51:
        return;
    L27:
        if (hp8.a.d(r5) != true) goto L29;
    L13:
        if (r4.z == false) goto L22;
        if (r5 != null) goto L16;
    L18:
        boolean r13 = false;
    L19:
        if (r13 == false) goto L25;
        if (z2.a.e3().a == true) goto L25;
    L16:
        if (hp8.a.d(r5) != true) goto L18;
        r13 = true;
        goto L19
    }

    public final void m(final String r5, final int r6) {
        IFlowSdkDepend r0 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        int r1 = 0;
        if (r0 == null) goto L16;
        r0.D0();
        com.larus.home.impl.sdk.b1 r2 = com.larus.home.impl.sdk.b1.a;
        r2.c("office_task_generate_image_share");
        if (r6 < 0) goto L16;
        List r3 = ((CustomPhotoViewerDialog) this).n.k;
        if (r3 == null) goto L9;
        int r4 = r3.size();
    L10:
        if (r6 >= r4) goto L16;
        Uri r7 = ((CustomPhotoViewerDialog) this).n.A2(r6);
        if (r7 == null) goto L16;
        String r8 = r7.toString();
        if (r8 == null) goto L16;
        r2.d(r8);
        goto L16
    L9:
        r4 = 0;
    L16:
        ShareServiceDelegate r9 = ShareServiceDelegate.b;
        JSONObject r10 = h(r6);
        r10.put("click_method", r5);
        r9.w(r10);
        if (this.V.contains(Integer.valueOf(r6)) == true) goto L19;
        return;
    L19:
        if (this.W.contains(Integer.valueOf(r6)) == true) goto L38;
        if (r6 < 0) goto L36;
        List r11 = ((CustomPhotoViewerDialog) this).n.k;
        if (r11 == null) goto L25;
        r1 = r11.size();
    L25:
        if (r6 >= r1) goto L39;
        Uri r12 = ((CustomPhotoViewerDialog) this).n.A2(((PhotoViewerDialog) this).f);
        if (r12 == null) goto L40;
        final String r13 = r12.toString();
        if (this.P0 == null) goto L33;
        ImageSave r14 = ImageSave.a;
        Function1 r15 = new s0(this, r13, r6, r5);
        r14.getClass();
        ImageSave.m(r13, r15);
        return;
    L33:
        u(r6, r13, r5);
        return;
    L40:
        return;
    L39:
        return;
    L36:
        return;
    }

    public final void q(int r4, String r5) {
        if (this.X.contains(Integer.valueOf(r4)) == true) goto L5;
        com.larus.platform.service.o r0 = com.larus.platform.service.o.a;
        JSONObject r1 = h(r4);
        r1.put("enter_method", r5);
        Unit r6 = Unit.INSTANCE;
        r0.reportEvent("enter_picture_detail", r1);
        this.X.add(Integer.valueOf(r4));
    L5:
        uo8.l.a r7 = uo8.l.a;
        uo8.l.b(r4, h(r4));
    }

    public final void l(Throwable r2, int r3, String r4) {
        if ((r2 instanceof ImageAuthException) == true) goto L10;
        FLogger r5 = FLogger.a;
        StringBuilder r0 = new StringBuilder();
        r0.append(r4);
        r0.append(" onDeny called, error msg: ");
        if (r2 == null) goto L7;
        String r6 = r2.getMessage();
    L8:
        r0.append(r6);
        r5.e("BigImagePhotoViewer", r0.toString());
        return;
    L7:
        r6 = null;
        goto L8
    L10:
        int r7 = ((ImageAuthException) r2).getCode();
        if (r7 != (-3)) goto L13;
        t19.s r8 = t19.s.a;
        Application r9 = AppHost.a.getApplication();
        r8.getClass();
        t19.s.b(r9, 2131908080, false);
        return;
    L13:
        if (r7 != (-2)) goto L15;
    L17:
        this.W.add(Integer.valueOf(r3));
        x(r3);
        t19.s r10 = t19.s.a;
        Application r11 = AppHost.a.getApplication();
        r10.getClass();
        t19.s.b(r11, 2131906509, false);
        return;
    L15:
        if (r7 == (-1)) goto L17;
    }

    public final void s(final int r4, final String r5, final Function1<? super Continuation<? super Unit>, ? extends Object> r6) {
        w(r4, new j0(this, r6), new k0(this, r4), new l0(this, r5, r6));
    }

    public final void u(final int r4, final String r5, final String r6) {
        w(r4, new u0(this, r6), new v0(this, r4), new w0(r5, this, r6));
    }

    public final void v(int r3, View r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        Intrinsics.checkNotNullParameter(r5, "tag");
        f(r3, r4);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        FLogger.a.d(r5, "view showAnimated error: " + e);
    }

    public final void w(int r9, final Function1<? super String, Unit> r10, final Function1<? super Throwable, Unit> r11, Function0<Unit> r12) {
        k1 r0 = this.k0;
        String r1 = null;
        if (r0 == null) goto L5;
        l r13 = r0.a(r9);
    L6:
        if (r13 == null) goto L13;
        Integer r2 = r13.h;
        int r3 = SourceFrom.DouYin.value;
        if (r2 == null) goto L13;
        if (r2.intValue() != r3) goto L13;
        boolean r4 = true;
    L14:
        if (r4 == true) goto L17;
        r12.invoke();
        return;
    L17:
        AwemeImageFilter r5 = (AwemeImageFilter) this.Y.getValue();
        if (r13 == null) goto L20;
        String r6 = r13.a;
    L21:
        if (r13 == null) goto L23;
        String r7 = r13.c;
    L24:
        if (r13 == null) goto L26;
        r1 = r13.e;
    L26:
        r5.a(r6, r7, r1, new q0(r10), new r0(r11));
        return;
    L23:
        r7 = null;
        goto L24
    L20:
        r6 = null;
    L13:
        r4 = false;
        goto L14
    L5:
        r13 = null;
        goto L6
    }

    public static void r(final BigImagePhotoViewerDialog r18, String r19, boolean r20, String r21, Function1 r22, int r23) {
        if ((r23 & 2) == 0) goto L5;
        boolean r0 = false;
    L7:
        if ((r23 & 4) == 0) goto L9;
        final String r1 = "detail_click";
    L11:
        if ((r23 & 8) == 0) goto L13;
        Function1 r7 = null;
    L14:
        r18.getClass();
        if (r0 == false) goto L17;
        ImageSave.z(ImageSave.a, r19, null, null, null, true, true, null, new p0(r18, r1), 78);
        return;
    L17:
        ImageSave.x(ImageSave.a, r19, null, null, r7, true, 22);
        return;
    L13:
        r7 = r22;
        goto L14
    L9:
        r1 = r21;
        goto L11
    L5:
        r0 = r20;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BigImagePhotoViewerDialog(Context r18, List r19, List r20, uo8.k r21, boolean r22, HybridEventParams r23, String r24, List r25, List r26, List r27, List r28, boolean r29, boolean r30, boolean r31, int r32) {
        if ((r32 & 4) == 0) goto L5;
        List r5 = null;
    L7:
        if ((r32 & 16) == 0) goto L9;
        boolean r7 = false;
    L11:
        if ((r32 & 32) == 0) goto L13;
        HybridEventParams r9 = null;
    L15:
        if ((r32 & 64) == 0) goto L17;
        String r10 = null;
    L19:
        if ((r32 & 256) == 0) goto L21;
        List r11 = null;
    L23:
        if ((r32 & 512) == 0) goto L25;
        List r12 = null;
    L27:
        if ((r32 & 1024) == 0) goto L29;
        List r13 = null;
    L31:
        if ((r32 & 2048) == 0) goto L33;
        List r14 = null;
    L35:
        if ((r32 & 4096) == 0) goto L37;
        boolean r15 = true;
    L39:
        if ((r32 & 8192) == 0) goto L41;
        boolean r6 = true;
    L43:
        if ((r32 & 16384) == 0) goto L45;
        boolean r4 = true;
    L46:
        Intrinsics.checkNotNullParameter(r18, "context");
        Intrinsics.checkNotNullParameter(r19, "imageUrls");
        Intrinsics.checkNotNullParameter(r21, "reportParams");
        super(r18, r19, r5, r21);
        this.q = r18;
        this.r = r7;
        this.s = r9;
        this.t = r10;
        this.u = r11;
        this.v = r12;
        this.w = r13;
        this.x = r14;
        this.y = r15;
        this.z = r6;
        this.A = r4;
        this.T = -1;
        this.V = new LinkedHashSet();
        this.W = new LinkedHashSet();
        this.X = new HashSet();
        this.Y = LazyKt.lazy(new y0());
        this.H0 = 2;
        this.U = System.currentTimeMillis();
        CustomPhotoTransitionPagerAdapter r3 = ((CustomPhotoViewerDialog) this).n;
        Function1 r8 = new z0(this);
        r3.getClass();
        Intrinsics.checkNotNullParameter(r8, "<set-?>");
        r3.m = r8;
        ((CustomPhotoViewerDialog) this).n.o = new a1(this);
        ((PhotoViewerDialog) this).d = new f1(this, r19);
        setOnDismissListener(new b1(this));
        setOnShowListener(new c1(this));
        this.D = (CommonDownLoadLayout) ((PhotoViewerDialog) this).c.findViewById(2131370179);
        FrameLayout r2 = (FrameLayout) ((PhotoViewerDialog) this).c.findViewById(2131372776);
        this.S = r2;
        if ((r18 instanceof FragmentActivity) == false) goto L49;
        FragmentActivity r16 = (FragmentActivity) r18;
    L51:
        if (r16 == null) goto L59;
        int r17 = com.larus.utils.u.b(r16);
        if (r2 == null) goto L59;
        ViewGroup.LayoutParams r33 = r2.getLayoutParams();
        if (r33 == null) goto L58;
        Intrinsics.checkNotNull(r33, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ((ViewGroup.MarginLayoutParams) r33).bottomMargin = r17;
        r2.setLayoutParams(r33);
        goto L59
    L58:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L59:
        this.B = (ImageView) ((PhotoViewerDialog) this).c.findViewById(2131386047);
        this.C = (TextView) ((PhotoViewerDialog) this).c.findViewById(2131368840);
        this.E = (ImageView) ((PhotoViewerDialog) this).c.findViewById(2131363762);
        this.F = (ViewGroup) ((PhotoViewerDialog) this).c.findViewById(2131387007);
        ImageView r34 = (ImageView) ((PhotoViewerDialog) this).c.findViewById(2131387009);
        this.G = r34;
        if (r34 == null) goto L62;
        r34.setImageResource(f.a());
    L62:
        SimpleDraweeView r35 = ((PhotoViewerDialog) this).c.findViewById(2131387008);
        TextView r36 = (TextView) ((PhotoViewerDialog) this).c.findViewById(2131387011);
        this.H = (ViewGroup) ((PhotoViewerDialog) this).c.findViewById(2131387013);
        this.I = (TextView) ((PhotoViewerDialog) this).c.findViewById(2131387015);
        this.J = (TextView) ((PhotoViewerDialog) this).c.findViewById(2131375226);
        ViewGroup r37 = (ViewGroup) ((PhotoViewerDialog) this).c.findViewById(2131388775);
        this.L = r37;
        this.K = (TextView) ((PhotoViewerDialog) this).c.findViewById(2131390237);
        if (r37 == null) goto L69;
        ViewGroup.LayoutParams r38 = r37.getLayoutParams();
        if (r38 == null) goto L68;
        ViewGroup.MarginLayoutParams r39 = (ViewGroup.MarginLayoutParams) r38;
        com.larus.utils.i0.a.getClass();
        r39.topMargin = com.larus.utils.i0.g() + i5.r0();
        r37.setLayoutParams(r39);
        goto L69
    L68:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L69:
        Button r40 = (Button) ((PhotoViewerDialog) this).c.findViewById(2131362233);
        this.M = r40;
        RoundConstraintLayout r41 = (ViewGroup) ((PhotoViewerDialog) this).c.findViewById(2131383028);
        this.N = r41;
        if ((r41 instanceof RoundConstraintLayout) == false) goto L72;
        RoundConstraintLayout r42 = r41;
    L73:
        if (r42 == null) goto L75;
        Intrinsics.checkNotNullParameter(r42, "<this>");
        c29.a r43 = r42.getDelegate();
        int r44 = ColorProtector.parseColor("#F2404040");
        int r45 = ColorProtector.parseColor("#F2595959");
        r43.s = false;
        r43.e = r44;
        r43.g = r45;
        r43.c();
    L75:
        this.O = (TextView) ((PhotoViewerDialog) this).c.findViewById(2131383046);
        com.larus.utils.w0.e(r40, j19.c.c(12));
        ConstraintLayout r46 = ((PhotoViewerDialog) this).c.findViewById(2131364437);
        this.P = r46;
        if (r46 == null) goto L78;
        com.larus.utils.i0.a.getClass();
        int r47 = com.larus.utils.i0.e() + i5.h();
        int r48 = r46.getPaddingStart();
        int r49 = r46.getPaddingTop();
        int r50 = r46.getPaddingEnd();
        FLogger.a.i("updatePaddingRelative", "view:" + r46.getClass().getSimpleName() + ",source:,start:" + r48 + ",top:" + r49 + ",end:" + r50 + ",bottom:" + r47);
        r46.setPaddingRelative(r48, r49, r50, r47);
    L78:
        if (r40 == null) goto L84;
        Resources r1 = r18.getResources();
        if (r1 == null) goto L82;
        Integer r51 = Integer.valueOf(r1.getColor(2131103298));
    L83:
        r40.setBackground(com.larus.utils.w0.b(r51, null, 0.2f, null, 8));
        goto L84
    L82:
        r51 = null;
    L84:
        final Ref.ObjectRef r52 = new Ref.ObjectRef();
        ((CustomPhotoViewerDialog) this).n.n = new d1(r52, this);
        BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new AnonymousClass9(this, r52, null), 3, null);
        return;
    L72:
        r42 = null;
        goto L73
    L49:
        r16 = null;
        goto L51
    L45:
        r4 = r31;
        goto L46
    L41:
        r6 = r30;
        goto L43
    L37:
        r15 = r29;
        goto L39
    L33:
        r14 = r28;
        goto L35
    L29:
        r13 = r27;
        goto L31
    L25:
        r12 = r26;
        goto L27
    L21:
        r11 = r25;
        goto L23
    L17:
        r10 = r24;
        goto L19
    L13:
        r9 = r23;
        goto L15
    L9:
        r7 = r22;
        goto L11
    L5:
        r5 = r20;
        goto L7
    }
}
