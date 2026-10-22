package com.bytedance.android.live.broadcastgame;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.Surface;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.base.exception.ApiException;
import com.bytedance.android.live.broadcastgame.api.AnchorGameContext;
import com.bytedance.android.live.broadcastgame.api.AudienceGameContext;
import com.bytedance.android.live.broadcastgame.api.IAnchorGameWidget;
import com.bytedance.android.live.broadcastgame.api.IAudienceGameWidget;
import com.bytedance.android.live.broadcastgame.api.InteractGameContext;
import com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService;
import com.bytedance.android.live.broadcastgame.api.interactgame.IMiddlewareInteractGameService;
import com.bytedance.android.live.broadcastgame.api.interactgame.InteractGameLocalStatusUtils;
import com.bytedance.android.live.broadcastgame.api.interactgame.JsFuncInjector;
import com.bytedance.android.live.broadcastgame.api.model.InteractEntranceCell;
import com.bytedance.android.live.broadcastgame.api.model.InteractID;
import com.bytedance.android.live.broadcastgame.api.xplay.XplayExternalContext;
import com.bytedance.android.live.broadcastgame.network.BroadcastGameApi;
import com.bytedance.android.live.broadcastgame.xplay.XplayGlobalServiceImpl;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.live.network.api.INetworkService;
import com.bytedance.android.live.openplatform.api.IOpenPlatformAudienceService;
import com.bytedance.android.live.openplatform.api.minigame.IOpenPlatformMgAnchorService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.widget.x0;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.hybridapi.IJsBridgeManager;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.google.gson.JsonObject;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.Observable;
import io.reactivex.Single;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import zg1.a2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0096\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0017\u0018\u0000 Þ\u00012\u00020\u0001:\u0002ß\u0001B\t¢\u0006\u0006\bÜ\u0001\u0010Ý\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J*\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000f\u001a\u00020\u0004H\u0016J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J,\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\u0010\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0010H\u0016J\u0012\u0010!\u001a\u0004\u0018\u00010 2\u0006\u0010\u001f\u001a\u00020\u001eH\u0016J\u001a\u0010$\u001a\u0004\u0018\u00010#2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\u0010H\u0016J<\u0010)\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00040&2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00040&H\u0016J\n\u0010*\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010+\u001a\u00020\u001eH\u0016J\u0010\u0010+\u001a\u00020\u001e2\u0006\u0010-\u001a\u00020,H\u0016J\b\u0010/\u001a\u00020.H\u0016J\u0010\u00101\u001a\u00020\u00042\u0006\u00100\u001a\u00020\u0010H\u0016J\n\u00103\u001a\u0004\u0018\u000102H\u0016J\u0018\u00105\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u00104\u001a\u00020\u001eH\u0016J6\u0010<\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020;0:092\u0006\u00106\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\u00107\u001a\u0004\u0018\u00010\u00102\u0006\u00108\u001a\u00020\u0002H\u0016JN\u0010B\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020A0:092\u0006\u00106\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010=\u001a\u00020\u00022\b\u0010>\u001a\u0004\u0018\u00010\u00102\u0006\u0010?\u001a\u00020\u001e2\u0006\u0010@\u001a\u00020.2\u0006\u00108\u001a\u00020\u0002H\u0016J\u0010\u0010D\u001a\u00020\u00042\u0006\u0010C\u001a\u00020\u0010H\u0016J\b\u0010E\u001a\u00020\u0004H\u0016J\u0010\u0010G\u001a\u00020\u00042\u0006\u0010F\u001a\u00020\u0010H\u0016J&\u0010J\u001a\u00020\u00042\u0006\u0010F\u001a\u00020\u00102\u0014\u0010I\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010A0HH\u0016J\u0016\u0010K\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0010\u0018\u00010HH\u0016J\u0011\u0010L\u001a\u0004\u0018\u00010\u001eH\u0016¢\u0006\u0004\bL\u0010MJ\u0010\u0010N\u001a\u00020\u00042\u0006\u0010F\u001a\u00020\u0010H\u0016J\u001a\u0010P\u001a\u0004\u0018\u00010O2\u0006\u0010C\u001a\u00020\u00102\u0006\u00104\u001a\u00020\u001eH\u0016J\n\u0010Q\u001a\u0004\u0018\u00010AH\u0016J\n\u0010S\u001a\u0004\u0018\u00010RH\u0016J \u0010W\u001a\u00020V2\u0006\u0010U\u001a\u00020T2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016J@\u0010]\u001a\u00020\u00042\u0006\u0010X\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010%\u001a\u00020\u00062\u0006\u0010Y\u001a\u00020.2\u0006\u0010[\u001a\u00020Z2\u000e\u0010\\\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010&H\u0016J0\u0010_\u001a\u00020\u00042\u0006\u0010X\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010%\u001a\u00020\u00062\u0006\u0010^\u001a\u00020\u001e2\u0006\u0010[\u001a\u00020ZH\u0016J\u001a\u0010`\u001a\u00020\u00042\u0006\u00104\u001a\u00020\u001e2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016Jb\u0010l\u001a\u0004\u0018\u00010R2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2>\u0010i\u001a:\u0012\u0013\u0012\u00110b¢\u0006\f\bc\u0012\b\bd\u0012\u0004\b\b(e\u0012\u0015\u0012\u0013\u0018\u00010f¢\u0006\f\bc\u0012\b\bd\u0012\u0004\b\b(g\u0012\u0006\u0012\u0004\u0018\u00010R0aj\u0002`h2\u0006\u0010k\u001a\u00020jH\u0016J\u001c\u0010p\u001a\u0004\u0018\u00010R2\u0006\u0010m\u001a\u00020\u00062\b\u0010o\u001a\u0004\u0018\u00010nH\u0016J\u0012\u0010r\u001a\u0004\u0018\u00010\u00102\u0006\u0010q\u001a\u00020\u0010H\u0016J,\u0010u\u001a\u00020\u001e2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010s\u001a\u00020\u00102\u0012\u0010t\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100HH\u0016J \u0010x\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020w\u0018\u00010v2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u001a\u0010z\u001a\u00020\u00042\u0006\u0010y\u001a\u00020\u00102\b\u0010\u001c\u001a\u0004\u0018\u00010\u0010H\u0016J\u001a\u0010}\u001a\u00020\u00042\u0006\u0010{\u001a\u00020\u001e2\b\u0010g\u001a\u0004\u0018\u00010|H\u0016J\u001a\u0010~\u001a\u00020\u00042\u0006\u0010{\u001a\u00020\u001e2\b\u0010g\u001a\u0004\u0018\u00010|H\u0016J\u0011\u0010\u0080\u0001\u001a\u00020\u00042\u0006\u0010\u007f\u001a\u00020\u001eH\u0016J\u0013\u0010\u0081\u0001\u001a\u00020\u00042\b\u0010F\u001a\u0004\u0018\u00010\u0010H\u0016J\t\u0010\u0082\u0001\u001a\u00020\u0004H\u0016J\u0015\u0010\u0085\u0001\u001a\u000e\u0012\t\u0012\u0007\u0012\u0002\b\u00030\u0084\u00010\u0083\u0001H\u0016J\u0011\u0010\u0086\u0001\u001a\u00020\u00042\u0006\u0010C\u001a\u00020\u0010H\u0016J\u0011\u0010\u0087\u0001\u001a\u00020\u00042\u0006\u0010C\u001a\u00020\u0010H\u0016J'\u0010\u008c\u0001\u001a\u00020\u00042\u0007\u0010\u0088\u0001\u001a\u00020\u001e2\n\u0010\u008a\u0001\u001a\u0005\u0018\u00010\u0089\u00012\u0007\u0010\u008b\u0001\u001a\u00020.H\u0016J\u0012\u0010\u008d\u0001\u001a\u00020\u00042\u0007\u0010\u0088\u0001\u001a\u00020\u001eH\u0016J\u0011\u0010\u008e\u0001\u001a\u00020.2\u0006\u0010C\u001a\u00020\u0010H\u0016J\u001a\u0010\u0090\u0001\u001a\u00020\u00042\u0006\u0010C\u001a\u00020\u00102\u0007\u0010\u008f\u0001\u001a\u00020.H\u0016J\u001b\u0010\u0091\u0001\u001a\u00020\u00042\u0006\u0010C\u001a\u00020\u00102\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u001b\u0010\u0094\u0001\u001a\u00020\u00042\u0006\u0010C\u001a\u00020\u00102\b\u0010\u0093\u0001\u001a\u00030\u0092\u0001H\u0016J\t\u0010\u0095\u0001\u001a\u00020\u0004H\u0016J\t\u0010\u0096\u0001\u001a\u00020\u001eH\u0016J\u0012\u0010\u0097\u0001\u001a\u00020\u00042\u0007\u0010\u0096\u0001\u001a\u00020\u001eH\u0016J\u0011\u0010\u0098\u0001\u001a\u00020\u00042\u0006\u00104\u001a\u00020\u001eH\u0016J\u0011\u0010\u0099\u0001\u001a\u00020\u00042\u0006\u00104\u001a\u00020\u001eH\u0016J#\u0010\u009a\u0001\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010C\u001a\u00020\u00102\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J(\u0010\u009c\u0001\u001a\t\u0012\u0004\u0012\u00020\u001e0\u009b\u00012\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010%\u001a\u00020\u0006H\u0016J\f\u0010\u009e\u0001\u001a\u0005\u0018\u00010\u009d\u0001H\u0016J\t\u0010\u009f\u0001\u001a\u00020\u0010H\u0016J\u0011\u0010 \u0001\u001a\u00020\u00102\u0006\u00104\u001a\u00020\u001eH\u0016J\t\u0010¡\u0001\u001a\u00020\u0010H\u0016J\f\u0010£\u0001\u001a\u0005\u0018\u00010¢\u0001H\u0016J\u0013\u0010¦\u0001\u001a\u00020\u00042\b\u0010¥\u0001\u001a\u00030¤\u0001H\u0016J\t\u0010§\u0001\u001a\u00020\u001eH\u0016J5\u0010\u00ad\u0001\u001a\u00020\u00042\u0007\u0010¨\u0001\u001a\u00020\u00102\b\u0010ª\u0001\u001a\u00030©\u00012\u0017\u0010¬\u0001\u001a\u0012\u0012\u0005\u0012\u00030©\u0001\u0012\u0004\u0012\u00020\u0004\u0018\u00010«\u0001H\u0016J\u001c\u0010¯\u0001\u001a\u0005\u0018\u00010®\u00012\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016R\u001b\u0010°\u0001\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b°\u0001\u0010±\u0001R(\u0010¸\u0001\u001a\n\u0012\u0005\u0012\u00030³\u00010²\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b´\u0001\u0010µ\u0001\u001a\u0006\b¶\u0001\u0010·\u0001R\u0019\u0010¹\u0001\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¹\u0001\u0010º\u0001R\u001b\u0010»\u0001\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b»\u0001\u0010¼\u0001R;\u0010¿\u0001\u001a$\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020.\u0018\u00010½\u0001j\u0011\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020.\u0018\u0001`¾\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¿\u0001\u0010À\u0001R=\u0010Á\u0001\u001a&\u0012\u0004\u0012\u00020\u0010\u0012\u0005\u0012\u00030\u0092\u0001\u0018\u00010½\u0001j\u0012\u0012\u0004\u0012\u00020\u0010\u0012\u0005\u0012\u00030\u0092\u0001\u0018\u0001`¾\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÁ\u0001\u0010À\u0001R\u0019\u0010\u0096\u0001\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0096\u0001\u0010º\u0001R8\u0010Ä\u0001\u001a\u0005\u0018\u00010Â\u00012\n\u0010Ã\u0001\u001a\u0005\u0018\u00010Â\u00018\u0006@GX\u0086\u000e¢\u0006\u0018\n\u0006\bÄ\u0001\u0010Å\u0001\u001a\u0006\bÆ\u0001\u0010Ç\u0001\"\u0006\bÈ\u0001\u0010É\u0001R:\u0010Ë\u0001\u001a\u0005\u0018\u00010Ê\u00012\f\b\u0001\u0010Ã\u0001\u001a\u0005\u0018\u00010Ê\u00018\u0006@GX\u0086\u000e¢\u0006\u0018\n\u0006\bË\u0001\u0010Ì\u0001\u001a\u0006\bÍ\u0001\u0010Î\u0001\"\u0006\bÏ\u0001\u0010Ð\u0001R:\u0010Ò\u0001\u001a\u0005\u0018\u00010Ñ\u00012\f\b\u0001\u0010Ã\u0001\u001a\u0005\u0018\u00010Ñ\u00018\u0006@GX\u0086\u000e¢\u0006\u0018\n\u0006\bÒ\u0001\u0010Ó\u0001\u001a\u0006\bÔ\u0001\u0010Õ\u0001\"\u0006\bÖ\u0001\u0010×\u0001R#\u0010Ú\u0001\u001a\f\u0012\u0005\u0012\u00030Ù\u0001\u0018\u00010Ø\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÚ\u0001\u0010Û\u0001¨\u0006à\u0001"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/InteractGameService;", "Lcom/bytedance/android/live/broadcastgame/api/interactgame/IInteractGameService;", "", "roomId", "", "runAnchorEnterRoomTask", "Lcom/bytedance/android/live/broadcastgame/api/model/u;", "game", "Lcom/bytedance/android/live/broadcastgame/api/interactgame/p;", "sonicPluginListener", "Landroid/content/Context;", "context", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "realLaunchGame", "stopRunningPlugin", "", "reason", "Lcom/bytedance/android/live/pushstream/d;", "liveStream", "Lcom/bytedance/android/livesdkapi/depend/model/live/Room;", NewBroadcastMonitor.PAGE.ROOM, "Landroidx/fragment/app/Fragment;", "fragment", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "Lcom/bytedance/android/live/broadcastgame/api/IAnchorGameWidget;", "getAnchorGameWidget", "seiMsg", "onSei", "", "isDegrade", "Lcom/bytedance/android/live/broadcastgame/api/IAudienceGameWidget;", "getAudienceGameWidget", "from", "Lcom/bytedance/android/live/broadcastgame/api/interactgame/h;", "getGameExitConformDialog", "gameItem", "Lkotlin/Function0;", "onSuccess", "onFail", "tryGetSwitchGameConfirmDialog", "getCurrentPlayingGame", "isPlayingGame", "Lcom/bytedance/android/live/broadcastgame/api/model/InteractID;", "gameType", "", "getCurrentPlayingGameId", "guideParams", "setGameGuideHelper", "Lcom/bytedance/android/live/broadcastgame/api/interactgame/d;", "getGameGuideHelper", "isAnchor", "initGameContext", "gameId", "openType", "gameToken", "Lio/reactivex/Observable;", "Lcom/bytedance/android/live/network/response/e;", "Lcom/bytedance/android/live/broadcastgame/api/model/e0;", "notifyServerGameStart", "playId", "gameData", "isCutShort", "stopReason", "", "notifyServerGameStop", "appId", "anchorLaunchGame", "audienceLaunchGame", "schema", "preloadOpenPlatformGame", "", "startParmaMap", "openOpenPlatformGame", "getOpenPlatformGameCommonLogMap", "isOpenPlatformGameOpeningLynxPanelInGame", "()Ljava/lang/Boolean;", "closeOpenPlatformGame", "Lcom/bytedance/android/live/broadcastgame/api/model/h;", "fetchGameIconInfo", "createOpenToolbarEntBehavior", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/c0$b;", "createOpenGameBehaivor", "Lcom/bytedance/android/livesdkapi/hybridapi/IJsBridgeManager;", "jsBridgeManager", "Lcom/bytedance/android/live/broadcastgame/api/interactgame/JsFuncInjector;", "createOpenJsFuncInject", "ctx", "code", "", "e", "retry", "confirmGameStartFailed", "anchor", "confirmGameException", "executeEnterRoomTask", "Lkotlin/Function2;", "Lcom/bytedance/android/live/broadcastgame/api/model/InteractEntranceCell;", "Lkotlin/ParameterName;", "name", "data", "Lcom/bytedance/android/live/broadcastgame/api/model/z;", "extra", "Lcom/bytedance/android/live/broadcastgame/api/model/LiveOpenFeatureBehaviorFactory;", "behaviorFactory", "Lcom/bytedance/android/live/broadcastgame/api/interactgame/g;", "createFactory", "getOpenPlatformBehavior", "item", "Lmh1/p;", "miniAppHelper", "getOpenPlatformItemBehavior", "cipherText", "decryptUserInfo", "location", "liveParams", "openMiniApp", "Le10/b;", "Le10/a$a;", "getLiveOpenFeatureSceneFilter", "key", "sendGameSeiData", "inCast", "Lorg/json/JSONObject;", "sendGameCastStatusSEI", "sendServerMergeCastStatusSEI", "isReady", "setAudienceMiniAppReady", "setAudienceMiniAppSchema", "stopGameCastToAudience", "", "Ljava/lang/Class;", "getAllOpenPlatformActivity", "addItemToDataCacheHelper", "deleteData", "success", "Landroid/view/Surface;", "surface", "fps", "notifyStartLinkCastResult", "notifyStopLinkCastResult", "getEntranceVisibility", "visibility", "cacheEntranceVisibility", "consumeCacheOpenPlatformMessage", "Lcom/bytedance/android/live/base/model/message/t;", "message", "cacheOpenPlatformMessage", "clearCache", "isGameCasting", "setGameCasting", "hidePlugin", "showPlugin", "startOpenPlatformSonicPlugin", "Lio/reactivex/Single;", "showOpenGameAuthDialog", "Lcom/bytedance/android/live/broadcastgame/api/openplatform/c;", "getOpenGameClient", "getCurrentSonicGameAppId", "getGameCategory", "getCurrentGameName", "Lcom/bytedance/android/live/broadcastgame/api/xplay/e;", "getXplayGlobalService", "Landroid/view/ViewGroup;", "view", "setAnchorInteractPlayContainer", "isInteractPlayRunning", "method", "Lcom/google/gson/JsonObject;", "param", "Lkotlin/Function1;", "callback", "handleAnchorPanelJSBInvoke", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/dynamic/a0;", "createToolbarComponentConfig", "gameGuideHelper", "Lcom/bytedance/android/live/broadcastgame/api/interactgame/d;", "", "Lcom/bytedance/android/live/browser/jsbridge/f;", "jsEventSender$delegate", "Lkotlin/Lazy;", "getJsEventSender", "()Ljava/util/List;", "jsEventSender", "isAudienceMiniAppReady", "Z", "audienceMiniAppSchema", "Ljava/lang/String;", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "entanceVisibilityMap", "Ljava/util/HashMap;", "cacheMessage", "Lcom/bytedance/android/live/broadcastgame/api/e;", "<set-?>", "gameAnchorService", "Lcom/bytedance/android/live/broadcastgame/api/e;", "getGameAnchorService", "()Lcom/bytedance/android/live/broadcastgame/api/e;", "setGameAnchorService", "(Lcom/bytedance/android/live/broadcastgame/api/e;)V", "Lcom/bytedance/android/live/broadcastgame/api/f;", "gameAudienceService", "Lcom/bytedance/android/live/broadcastgame/api/f;", "getGameAudienceService", "()Lcom/bytedance/android/live/broadcastgame/api/f;", "setGameAudienceService", "(Lcom/bytedance/android/live/broadcastgame/api/f;)V", "Lcom/bytedance/android/live/broadcastgame/f0;", "openPlatformService", "Lcom/bytedance/android/live/broadcastgame/f0;", "getOpenPlatformService", "()Lcom/bytedance/android/live/broadcastgame/f0;", "setOpenPlatformService", "(Lcom/bytedance/android/live/broadcastgame/f0;)V", "Ljava/lang/ref/WeakReference;", "Landroid/app/Dialog;", "exceptionDialog", "Ljava/lang/ref/WeakReference;", "<init>", "()V", "Companion", "a", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class InteractGameService implements IInteractGameService {
    public static final a Companion = null;
    private static final i10.h diComponent = null;
    private static InteractGameService interactGameService;
    private String audienceMiniAppSchema;
    private HashMap<String, com.bytedance.android.live.base.model.message.t> cacheMessage;
    private HashMap<String, Integer> entanceVisibilityMap;
    private WeakReference<Dialog> exceptionDialog;
    private com.bytedance.android.live.broadcastgame.api.e gameAnchorService;
    private com.bytedance.android.live.broadcastgame.api.f gameAudienceService;
    private com.bytedance.android.live.broadcastgame.api.interactgame.d gameGuideHelper;
    private boolean isAudienceMiniAppReady;
    private boolean isGameCasting;
    private final Lazy jsEventSender$delegate;
    private f0 openPlatformService;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements DialogInterface.OnClickListener {
        public final /* synthetic */ Throwable a;
        public final /* synthetic */ com.bytedance.android.live.broadcastgame.api.model.u b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ DataCenter d;

        public b(Throwable r1, com.bytedance.android.live.broadcastgame.api.model.u r2, boolean r3, DataCenter r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r3, int r4) {
            ALogger.i("AAM.InteractGameService", "game exit by error: " + this.a + ' ' + this.b);
            if (this.c == false) goto L5;
            this.d.put("cmd_broadcast_game_finish", 1000);
            this.d.put("cmd_interact_game_exception_exit", this.b);
        L5:
            r3.dismiss();
        }
    }

    public static final class c implements DialogInterface.OnClickListener {
        public final /* synthetic */ Function0 a;

        public c(Function0 r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r1, int r2) {
            r1.dismiss();
            this.a.invoke();
        }
    }

    public static final class d implements DialogInterface.OnClickListener {
        public final /* synthetic */ Throwable a;
        public final /* synthetic */ com.bytedance.android.live.broadcastgame.api.model.u b;
        public final /* synthetic */ DataCenter c;

        public d(Throwable r1, com.bytedance.android.live.broadcastgame.api.model.u r2, DataCenter r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r3, int r4) {
            ALogger.i("AAM.InteractGameService", "game exit by error: " + this.a + ' ' + this.b);
            this.c.put("cmd_broadcast_game_finish", 1000);
            this.c.put("cmd_interact_game_exception_exit", this.b);
            r3.dismiss();
        }
    }

    public static final class e implements w {
        public final /* synthetic */ InteractGameService a;
        public final /* synthetic */ com.bytedance.android.live.broadcastgame.api.interactgame.p b;
        public final /* synthetic */ Context c;
        public final /* synthetic */ DataCenter d;

        @Override // com.bytedance.android.live.broadcastgame.w
        public final void onFail() {
            com.bytedance.android.live.broadcastgame.api.interactgame.p r0 = this.b;
            if (r0 == null) goto L6;
            r0.onFail(new Throwable("load sonic plugin failed：game not found"));
            return;
        }

        @Override // com.bytedance.android.live.broadcastgame.w
        public final void a(com.bytedance.android.live.broadcastgame.api.model.u r5) {
            Intrinsics.checkNotNullParameter(r5, "gameItem");
            InteractGameService.access$realLaunchGame(this.a, r5, this.b, this.c, this.d);
        }

        public e(InteractGameService r1, com.bytedance.android.live.broadcastgame.api.interactgame.p r2, Context r3, DataCenter r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    private final List<com.bytedance.android.live.browser.jsbridge.f> getJsEventSender() {
        return (List) this.jsEventSender$delegate.getValue();
    }

    static {
        Companion = new a();
        diComponent = new i10.f(new i10.b(), new i10.c(), new p10.a(), new i10.a());
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService, com.bytedance.android.live.broadcastgame.api.interactgame.IMiddlewareInteractGameService
    public void audienceLaunchGame() {
        com.bytedance.android.live.broadcastgame.api.openplatform.f r0 = new com.bytedance.android.live.broadcastgame.api.openplatform.f("other");
        xs2.b.a().post(r0);
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public void clearCache() {
        HashMap<String, com.bytedance.android.live.base.model.message.t> r0 = this.cacheMessage;
        if (r0 == null) goto L5;
        r0.clear();
    L5:
        HashMap<String, Integer> r1 = this.entanceVisibilityMap;
        if (r1 == null) goto L9;
        r1.clear();
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b createOpenGameBehaivor() {
        f0 r0 = this.openPlatformService;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.j();
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public Object createOpenToolbarEntBehavior() {
        f0 r0 = this.openPlatformService;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.h();
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public List<Class<?>> getAllOpenPlatformActivity() {
        f0 r0 = this.openPlatformService;
        if (r0 == null) goto L7;
        List<Class<?>> r1 = r0.getAllOpenPlatformActivity();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return new ArrayList();
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public String getCurrentGameName() {
        return InteractGameContext.Companion.i();
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public com.bytedance.android.live.broadcastgame.api.model.u getCurrentPlayingGame() {
        com.bytedance.android.live.broadcastgame.api.e r0 = this.gameAnchorService;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getCurrentPlayingGame();
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IMiddlewareInteractGameService
    public int getCurrentPlayingGameId() {
        com.bytedance.android.live.broadcastgame.api.e r0 = this.gameAnchorService;
        if (r0 == null) goto L7;
        com.bytedance.android.live.broadcastgame.api.model.u r1 = r0.getCurrentPlayingGame();
        if (r1 == null) goto L7;
        return r1.interactId;
    L7:
        return 0;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public String getCurrentSonicGameAppId() {
        InteractGameContext r0 = InteractGameContext.Companion.getContext();
        if (r0 == null) goto L10;
        com.bytedance.live.datacontext.n<com.bytedance.android.live.broadcastgame.api.model.i0> r1 = r0.getCurrentOpenPlatformAppInfo();
        if (r1 == null) goto L10;
        com.bytedance.android.live.broadcastgame.api.model.i0 r2 = (com.bytedance.android.live.broadcastgame.api.model.i0) r1.getValue();
        if (r2 == null) goto L10;
        String r3 = r2.b;
        if (r3 == null) goto L10;
        return r3;
    L10:
        return "";
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public com.bytedance.android.live.broadcastgame.api.interactgame.d getGameGuideHelper() {
        com.bytedance.android.live.broadcastgame.api.interactgame.d r0 = this.gameGuideHelper;
        if (r0 != null) goto L5;
        return null;
    L5:
        if (r0.b == false) goto L8;
        return r0;
    L8:
        return null;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public com.bytedance.android.live.broadcastgame.api.openplatform.c getOpenGameClient() {
        f0 r0 = this.openPlatformService;
        if (r0 == null) goto L5;
        r0.getOpenGameClient();
        return com.bytedance.android.live.broadcastgame.opengame.network.x.a;
    L5:
        return null;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public Map<String, String> getOpenPlatformGameCommonLogMap() {
        IOpenPlatformMgAnchorService r0 = jc1.k.f(IOpenPlatformMgAnchorService.class);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getMiniGameLotteryCommonLogMap();
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService, com.bytedance.android.live.broadcastgame.api.interactgame.IMiddlewareInteractGameService
    public com.bytedance.android.live.broadcastgame.api.xplay.e getXplayGlobalService() {
        f0 r0 = this.openPlatformService;
        if (r0 == null) goto L5;
        r0.getXplayGlobalService();
        return XplayGlobalServiceImpl.c;
    L5:
        return null;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public boolean isInteractPlayRunning() {
        return InteractGameContext.Companion.g();
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public Boolean isOpenPlatformGameOpeningLynxPanelInGame() {
        IOpenPlatformMgAnchorService r0 = jc1.k.f(IOpenPlatformMgAnchorService.class);
        if (r0 != null) goto L7;
        return null;
    L7:
        return Boolean.valueOf(r0.isOpeningLynxPanelInGame());
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IMiddlewareInteractGameService
    public boolean isPlayingGame() {
        com.bytedance.android.live.broadcastgame.api.e r0 = this.gameAnchorService;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.isPlayingGame();
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public void stopGameCastToAudience() {
        com.bytedance.android.live.broadcastgame.api.e r0 = this.gameAnchorService;
        if (r0 == null) goto L6;
        r0.stopGameCastToAudience();
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public void stopRunningPlugin() {
        stopRunningPlugin("");
        com.bytedance.android.live.broadcastgame.api.xplay.n.b.e("");
    }

    public InteractGameService() {
        this.jsEventSender$delegate = LazyKt.lazy(InteractGameService$jsEventSender$2.INSTANCE);
        i10.f r0 = (i10.f) diComponent;
        setGameAnchorService((com.bytedance.android.live.broadcastgame.api.e) r0.b.get());
        setGameAudienceService((com.bytedance.android.live.broadcastgame.api.f) r0.c.get());
        setOpenPlatformService((f0) r0.d.get());
        jc1.k.l(IInteractGameService.class, this);
        jc1.k.l(IMiddlewareInteractGameService.class, this);
        LinkedHashMap r1 = new LinkedHashMap();
        wb.a.call("modelx");
        jc1.k.n(INetworkService.class).injectProtoDecoders(r1);
        this.entanceVisibilityMap = new HashMap();
        this.cacheMessage = new HashMap();
    }

    public static final /* synthetic */ i10.h access$getDiComponent$cp() {
        return diComponent;
    }

    public static final /* synthetic */ InteractGameService access$getInteractGameService$cp() {
        return interactGameService;
    }

    public final com.bytedance.android.live.broadcastgame.api.e getGameAnchorService() {
        return this.gameAnchorService;
    }

    public final com.bytedance.android.live.broadcastgame.api.f getGameAudienceService() {
        return this.gameAudienceService;
    }

    public final f0 getOpenPlatformService() {
        return this.openPlatformService;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public boolean isGameCasting() {
        return this.isGameCasting;
    }

    public static void INVOKEVIRTUAL_com_bytedance_android_live_broadcastgame_InteractGameService_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(x0 r1) {
        if (DialogLancet.shouldBlockDialogShow(r1) == false) goto L10;
        DialogLancet.handleBlockedDialogShow(r1);
        return;
    L10:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L7:
        DialogLancet.beforeDialogShow(r1);
        r1.show();
        DialogLancet.afterDialogShow(r1);
    }

    public static final /* synthetic */ void access$setInteractGameService$cp(InteractGameService r0) {
        interactGameService = r0;
    }

    private final void runAnchorEnterRoomTask(long r1) {
        InteractGameLocalStatusUtils.b(r1);
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public void addItemToDataCacheHelper(String r2) {
        Intrinsics.checkNotNullParameter(r2, "appId");
        f0 r0 = this.openPlatformService;
        if (r0 == null) goto L6;
        r0.addItemToDataCacheHelper(r2);
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService, com.bytedance.android.live.broadcastgame.api.interactgame.IMiddlewareInteractGameService
    public void anchorLaunchGame(String r4) {
        Intrinsics.checkNotNullParameter(r4, "appId");
        a2 r0 = new a2(null, r4, null, 5);
        xs2.b.a().post(r0);
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public void closeOpenPlatformGame(String r2) {
        Intrinsics.checkNotNullParameter(r2, "schema");
        f0 r0 = this.openPlatformService;
        if (r0 == null) goto L6;
        r0.closeOpenPlatformGame(r2);
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public String decryptUserInfo(String r2) {
        Intrinsics.checkNotNullParameter(r2, "cipherText");
        f0 r0 = this.openPlatformService;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.decryptUserInfo(r2);
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public void deleteData(String r2) {
        Intrinsics.checkNotNullParameter(r2, "appId");
        f0 r0 = this.openPlatformService;
        if (r0 == null) goto L6;
        r0.deleteData(r2);
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public IAudienceGameWidget getAudienceGameWidget(boolean r2) {
        com.bytedance.android.live.broadcastgame.api.f r0 = this.gameAudienceService;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getAudienceGameWidget(r2);
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IMiddlewareInteractGameService
    public int getEntranceVisibility(String r3) {
        Intrinsics.checkNotNullParameter(r3, "appId");
        if (Intrinsics.areEqual(r3, "") == false) goto L5;
        return -1;
    L5:
        HashMap<String, Integer> r0 = this.entanceVisibilityMap;
        if (r0 == null) goto L11;
        Integer r4 = r0.remove(r3);
        if (r4 != null) goto L10;
        return -1;
    L10:
        return r4.intValue();
    L11:
        return -1;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public String getGameCategory(boolean r2) {
        if (r2 == false) goto L9;
        com.bytedance.android.live.broadcastgame.api.e r3 = this.gameAnchorService;
        if (r3 == null) goto L16;
        String r4 = r3.getGameCategory();
        if (r4 != null) goto L15;
        return "";
    L15:
        return r4;
    L16:
        return "";
    L9:
        com.bytedance.android.live.broadcastgame.api.f r5 = this.gameAudienceService;
        if (r5 == null) goto L17;
        r4 = r5.getGameCategory();
        if (r4 != null) goto L15;
        return "";
    L17:
        return "";
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public e10.b<com.bytedance.android.live.broadcastgame.api.model.u, e10.a.C0226a> getLiveOpenFeatureSceneFilter(DataCenter r2) {
        com.bytedance.android.live.broadcastgame.api.e r0 = this.gameAnchorService;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getLiveOpenFeatureSceneFilter(r2);
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public void hidePlugin(boolean r1) {
        if (r1 == false) goto L6;
        com.bytedance.android.live.broadcastgame.api.e r2 = this.gameAnchorService;
        if (r2 == null) goto L10;
        r2.a();
        return;
    L10:
        return;
    L6:
        com.bytedance.android.live.broadcastgame.api.f r3 = this.gameAudienceService;
        if (r3 == null) goto L12;
        r3.a();
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IMiddlewareInteractGameService
    public boolean isPlayingGame(InteractID r2) {
        Intrinsics.checkNotNullParameter(r2, "gameType");
        com.bytedance.android.live.broadcastgame.api.e r0 = this.gameAnchorService;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.isPlayingGame(r2);
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService, com.bytedance.android.live.broadcastgame.api.interactgame.IMiddlewareInteractGameService
    public void notifyStopLinkCastResult(boolean r2) {
        com.bytedance.android.live.broadcastgame.api.e r0 = this.gameAnchorService;
        if (r0 == null) goto L6;
        r0.notifyStopLinkCastResult(r2);
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public void onSei(String r2) {
        Intrinsics.checkNotNullParameter(r2, "seiMsg");
        com.bytedance.android.live.broadcastgame.api.f r0 = this.gameAudienceService;
        if (r0 == null) goto L6;
        r0.onSei(r2);
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public void preloadOpenPlatformGame(String r2) {
        Intrinsics.checkNotNullParameter(r2, "schema");
        f0 r0 = this.openPlatformService;
        if (r0 == null) goto L6;
        r0.preloadOpenPlatformGame(r2);
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public void setAnchorInteractPlayContainer(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        XplayExternalContext r0 = XplayExternalContext.Companion.getContext();
        if (r0 == null) goto L8;
        com.bytedance.live.datacontext.n<ViewGroup> r1 = r0.getInteractPlayContainer();
        if (r1 == null) goto L9;
        r1.setValue(r2);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public void setAudienceMiniAppReady(boolean r1) {
        this.isAudienceMiniAppReady = r1;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public void setAudienceMiniAppSchema(String r1) {
        this.audienceMiniAppSchema = r1;
    }

    @Inject
    public final void setGameAnchorService(com.bytedance.android.live.broadcastgame.api.e r1) {
        this.gameAnchorService = r1;
    }

    @Inject
    public final void setGameAudienceService(com.bytedance.android.live.broadcastgame.api.f r1) {
        this.gameAudienceService = r1;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public void setGameCasting(boolean r1) {
        this.isGameCasting = r1;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public void setGameGuideHelper(String r2) {
        Intrinsics.checkNotNullParameter(r2, "guideParams");
        this.gameGuideHelper = new com.bytedance.android.live.broadcastgame.api.interactgame.d(r2);
    }

    @Inject
    public final void setOpenPlatformService(f0 r1) {
        this.openPlatformService = r1;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public void showPlugin(boolean r1) {
        if (r1 == false) goto L6;
        com.bytedance.android.live.broadcastgame.api.e r2 = this.gameAnchorService;
        if (r2 == null) goto L10;
        r2.b();
        return;
    L10:
        return;
    L6:
        com.bytedance.android.live.broadcastgame.api.f r3 = this.gameAudienceService;
        if (r3 == null) goto L12;
        r3.b();
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService, com.bytedance.android.live.broadcastgame.api.interactgame.IMiddlewareInteractGameService
    public void stopRunningPlugin(String r2) {
        Intrinsics.checkNotNullParameter(r2, "reason");
        com.bytedance.android.live.broadcastgame.api.e r0 = this.gameAnchorService;
        if (r0 == null) goto L5;
        r0.stopRunningPlugin(r2);
    L5:
        com.bytedance.android.live.broadcastgame.api.f r1 = this.gameAudienceService;
        if (r1 == null) goto L8;
        r1.stopRunningPlugin(r2);
    L8:
        com.bytedance.android.live.broadcastgame.api.xplay.n.b.e(r2);
        IOpenPlatformMgAnchorService r3 = jc1.k.f(IOpenPlatformMgAnchorService.class);
        if (r3 == null) goto L12;
        r3.unmount();
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public void cacheEntranceVisibility(String r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "appId");
        if (Intrinsics.areEqual(r2, "") == false) goto L5;
        return;
    L5:
        HashMap<String, Integer> r0 = this.entanceVisibilityMap;
        if (r0 == null) goto L9;
        r0.put(r2, Integer.valueOf(r3));
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IMiddlewareInteractGameService
    public void cacheOpenPlatformMessage(String r2, com.bytedance.android.live.base.model.message.t r3) {
        Intrinsics.checkNotNullParameter(r2, "appId");
        Intrinsics.checkNotNullParameter(r3, "message");
        if (Intrinsics.areEqual(r2, "") == false) goto L5;
        return;
    L5:
        HashMap<String, com.bytedance.android.live.base.model.message.t> r0 = this.cacheMessage;
        if (r0 == null) goto L9;
        r0.put(r2, r3);
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public void consumeCacheOpenPlatformMessage(String r3, DataCenter r4) {
        Intrinsics.checkNotNullParameter(r3, "appId");
        if (Intrinsics.areEqual(r3, "") == false) goto L5;
        return;
    L5:
        HashMap<String, com.bytedance.android.live.base.model.message.t> r0 = this.cacheMessage;
        if (r0 == null) goto L21;
        com.bytedance.android.live.base.model.message.t r1 = r0.remove(r3);
        if (r1 == null) goto L24;
        HashMap<String, Integer> r2 = this.entanceVisibilityMap;
        if (r2 == null) goto L13;
        Integer r5 = r2.remove(r3);
    L14:
        if (r5 != null) goto L17;
        return;
    L17:
        if (r5.intValue() != 1) goto L22;
        if (r4 == null) goto L23;
        r4.put("data_push_to_public_screen_open_platfrom_message", r1);
        return;
    L23:
        return;
    L22:
        return;
    L13:
        r5 = null;
        goto L14
    L24:
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0 createToolbarComponentConfig(DataCenter r2, Context r3) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        Intrinsics.checkNotNullParameter(r3, "context");
        return new com.bytedance.android.live.broadcastgame.opengame.behavior.g(r2, r3);
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public void executeEnterRoomTask(boolean r5, Room r6) {
        if (r5 == false) goto L14;
        if (r6 == null) goto L15;
        Long r7 = Long.valueOf(r6.id);
        if (r7.longValue() == 0) goto L7;
        boolean r8 = true;
    L8:
        if (r8 == true) goto L11;
        r7 = null;
    L11:
        if (r7 == null) goto L16;
        runAnchorEnterRoomTask(r7.longValue());
        return;
    L16:
        return;
    L7:
        r8 = false;
        goto L8
    L15:
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IMiddlewareInteractGameService
    public com.bytedance.android.live.broadcastgame.api.model.h fetchGameIconInfo(String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "appId");
        if (r4 == false) goto L16;
        AnchorGameContext.Companion.getClass();
        AnchorGameContext r5 = AnchorGameContext.a.a();
        if (r5 == null) goto L9;
        com.bytedance.live.datacontext.n<com.bytedance.android.live.broadcastgame.api.model.i0> r6 = r5.getCurrentOpenPlatformAppInfo();
        if (r6 == null) goto L9;
        com.bytedance.android.live.broadcastgame.api.model.i0 r7 = (com.bytedance.android.live.broadcastgame.api.model.i0) r6.getValue();
    L10:
        if (r7 != null) goto L12;
        return null;
    L12:
        if ((!Intrinsics.areEqual(r7.b, r3)) == false) goto L15;
        return null;
    L15:
        return new com.bytedance.android.live.broadcastgame.api.model.h(r3, r7.c, r7.a);
    L9:
        r7 = null;
        goto L10
    L16:
        AudienceGameContext.Companion.getClass();
        AudienceGameContext r8 = AudienceGameContext.a.a();
        if (r8 == null) goto L21;
        com.bytedance.live.datacontext.n<com.bytedance.android.live.broadcastgame.api.model.h> r9 = r8.getAnchorCurrentGameIconInfo();
        if (r9 == null) goto L21;
        com.bytedance.android.live.broadcastgame.api.model.h r11 = (com.bytedance.android.live.broadcastgame.api.model.h) r9.getValue();
    L22:
        if (r11 != null) goto L24;
    L27:
        return null;
    L24:
        if ((!Intrinsics.areEqual(r11.a, r3)) == true) goto L27;
        return r11;
    L21:
        r11 = null;
        goto L22
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public com.bytedance.android.live.broadcastgame.api.interactgame.h getGameExitConformDialog(Context r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "from");
        com.bytedance.android.live.broadcastgame.api.e r0 = this.gameAnchorService;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getGameExitConformDialog(r2, r3);
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b getOpenPlatformItemBehavior(com.bytedance.android.live.broadcastgame.api.model.u r2, mh1.p r3) {
        Intrinsics.checkNotNullParameter(r2, "item");
        f0 r0 = this.openPlatformService;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.a(r2, r3);
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public void initGameContext(Fragment r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r4, "fragment");
        com.bytedance.live.datacontext.d.c((XplayExternalContext) com.bytedance.live.datacontext.d.b(r4, null).a(XplayExternalContext.class), XplayExternalContext.CONTEXT_KEY);
        if (r5 == false) goto L5;
        com.bytedance.live.datacontext.d.c((AnchorGameContext) com.bytedance.live.datacontext.d.b(r4, null).a(AnchorGameContext.class), InteractGameContext.CONTEXT_KEY);
        return;
    L5:
        com.bytedance.live.datacontext.d.c((AudienceGameContext) com.bytedance.live.datacontext.d.b(r4, null).a(AudienceGameContext.class), InteractGameContext.CONTEXT_KEY);
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public void openOpenPlatformGame(String r2, Map<String, ? extends Object> r3) {
        Intrinsics.checkNotNullParameter(r2, "schema");
        Intrinsics.checkNotNullParameter(r3, "startParmaMap");
        f0 r0 = this.openPlatformService;
        if (r0 == null) goto L6;
        r0.openOpenPlatformGame(r2, r3);
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public void sendGameCastStatusSEI(boolean r2, JSONObject r3) {
        com.bytedance.android.live.broadcastgame.api.e r0 = this.gameAnchorService;
        if (r0 == null) goto L6;
        r0.sendGameCastStatusSEI(r2, r3);
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public void sendGameSeiData(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        com.bytedance.android.live.broadcastgame.api.e r0 = this.gameAnchorService;
        if (r0 == null) goto L6;
        r0.sendGameSeiData(r2, r3);
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public void sendServerMergeCastStatusSEI(boolean r2, JSONObject r3) {
        com.bytedance.android.live.broadcastgame.api.e r0 = this.gameAnchorService;
        if (r0 == null) goto L6;
        r0.sendServerMergeCastStatusSEI(r2, r3);
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public JsFuncInjector createOpenJsFuncInject(IJsBridgeManager r2, DataCenter r3, Context r4) {
        Intrinsics.checkNotNullParameter(r2, "jsBridgeManager");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        Intrinsics.checkNotNullParameter(r4, "context");
        return new com.bytedance.android.live.broadcastgame.channel.d(r2, r3, r4);
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public void handleAnchorPanelJSBInvoke(String r2, JsonObject r3, Function1<? super JsonObject, Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "method");
        Intrinsics.checkNotNullParameter(r3, "param");
        f0 r0 = this.openPlatformService;
        if (r0 == null) goto L6;
        r0.getXplayGlobalService();
        XplayGlobalServiceImpl.c.p(r2, r3, r4);
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService, com.bytedance.android.live.broadcastgame.api.interactgame.IMiddlewareInteractGameService
    public void notifyStartLinkCastResult(boolean r2, Surface r3, int r4) {
        com.bytedance.android.live.broadcastgame.api.e r0 = this.gameAnchorService;
        if (r0 == null) goto L6;
        r0.notifyStartLinkCastResult(r2, r3, r4);
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public boolean openMiniApp(Context r2, String r3, Map<String, String> r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "location");
        Intrinsics.checkNotNullParameter(r4, "liveParams");
        if (this.isAudienceMiniAppReady == true) goto L6;
        return false;
    L6:
        jc1.k.n(IOpenPlatformAudienceService.class).openMountedMiniApp(r3);
        return true;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public Single<Boolean> showOpenGameAuthDialog(Context r2, DataCenter r3, com.bytedance.android.live.broadcastgame.api.model.u r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        Intrinsics.checkNotNullParameter(r4, "gameItem");
        f0 r0 = this.openPlatformService;
        if (r0 == null) goto L7;
        Single<Boolean> r5 = r0.showOpenGameAuthDialog(r2, r3, r4);
        if (r5 == null) goto L7;
        return r5;
    L7:
        return Single.just(Boolean.FALSE);
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public void startOpenPlatformSonicPlugin(Context r6, String r7, com.bytedance.android.live.broadcastgame.api.interactgame.p r8) {
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r7, "appId");
        if (InteractGameContext.Companion.h(r7) == false) goto L7;
        if (r8 == null) goto L23;
        r8.onSuccess();
        return;
    L23:
        return;
    L7:
        DataCenter r4 = null;
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r0 == null) goto L12;
        com.bytedance.live.datacontext.n r1 = r0.getDataCenter();
        if (r1 == null) goto L12;
        r4 = (DataCenter) r1.getValue();
    L12:
        if (r4 != null) goto L16;
        if (r8 == null) goto L24;
        r8.onFail(new Throwable("load sonic plugin failed：dataCenter is null"));
        return;
    L24:
        return;
    L16:
        com.bytedance.android.live.broadcastgame.api.model.u r2 = com.bytedance.android.live.broadcastgame.api.interactgame.j.d(r7, r4);
        if (r2 == null) goto L19;
        realLaunchGame(r2, r8, r6, r4);
        return;
    L19:
        f0 r3 = this.openPlatformService;
        if (r3 == null) goto L26;
        r3.f(r6, r7, new e(this, r8, r6, r4));
        return;
    }

    private final void realLaunchGame(final com.bytedance.android.live.broadcastgame.api.model.u r8, final com.bytedance.android.live.broadcastgame.api.interactgame.p r9, Context r11, final DataCenter r12) {
        r8.getClass();
        Intrinsics.checkNotNullParameter("invite", "<set-?>");
        r8.i = "invite";
        ((IInteractGameService) jc1.k.n(IInteractGameService.class)).tryGetSwitchGameConfirmDialog(r8, r11, r12, new AnonymousClass1(r8, r9, r12), new AnonymousClass2(r9));
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public IAnchorGameWidget getAnchorGameWidget(com.bytedance.android.live.pushstream.d r2, Room r3, Fragment r4, FragmentManager r5) {
        Intrinsics.checkNotNullParameter(r3, NewBroadcastMonitor.PAGE.ROOM);
        Intrinsics.checkNotNullParameter(r4, "fragment");
        Intrinsics.checkNotNullParameter(r5, "fragmentManager");
        com.bytedance.android.live.broadcastgame.api.e r0 = this.gameAnchorService;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getAnchorGameWidget(r2, r3, r4, r5);
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b getOpenPlatformBehavior(Context r2, DataCenter r3, Function2<? super InteractEntranceCell, ? super com.bytedance.android.live.broadcastgame.api.model.z, ? extends com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b> r4, com.bytedance.android.live.broadcastgame.api.interactgame.g r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        Intrinsics.checkNotNullParameter(r4, "behaviorFactory");
        Intrinsics.checkNotNullParameter(r5, "createFactory");
        f0 r0 = this.openPlatformService;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.b(r2, r3, r4, r5);
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public Observable<com.bytedance.android.live.network.response.e<com.bytedance.android.live.broadcastgame.api.model.e0>> notifyServerGameStart(long r11, long r13, String r15, long r16) {
        ALogger.d(IInteractGameService.TAG, "game/status/start: gameId " + r11 + ", roomId: " + r13 + ", gameToken: " + r16);
        int r0 = g0.a;
        Intrinsics.checkNotNullParameter(BroadcastGameApi.class, "cls");
        BroadcastGameApi r2 = (BroadcastGameApi) com.bytedance.android.live.network.c.b().e(BroadcastGameApi.class);
        if (r15 != null) goto L5;
        String r7 = "";
    L7:
        return r2.notifyServerGameStart(r11, r13, r7, r16);
    L5:
        r7 = r15;
        goto L7
    }

    public static final /* synthetic */ void access$realLaunchGame(InteractGameService r0, com.bytedance.android.live.broadcastgame.api.model.u r1, com.bytedance.android.live.broadcastgame.api.interactgame.p r2, Context r3, DataCenter r4) {
        r0.realLaunchGame(r1, r2, r3, r4);
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public void confirmGameException(Context r4, DataCenter r5, com.bytedance.android.live.broadcastgame.api.model.u r6, boolean r7, Throwable r8) {
        Intrinsics.checkNotNullParameter(r4, "ctx");
        Intrinsics.checkNotNullParameter(r5, "dataCenter");
        Intrinsics.checkNotNullParameter(r6, "gameItem");
        Intrinsics.checkNotNullParameter(r8, "e");
        if ((r8 instanceof ApiException) == false) goto L5;
        int r0 = ((ApiException) r8).getErrorCode();
    L7:
        if (r0 == 4014029) goto L9;
        return;
    L9:
        WeakReference<Dialog> r1 = this.exceptionDialog;
        if (r1 == null) goto L16;
        Dialog r2 = r1.get();
        if (r2 == null) goto L16;
        if (r2.isShowing() != true) goto L16;
        return;
    L16:
        x0.d r3 = new x0.d();
        r3.b = r4;
        r3.a = 0;
        r3.a = 0;
        r3.d = r3.b.getText(2131923466);
        r3.c = r3.b.getText(2131923471);
        b r9 = new b(r8, r6, r7, r5);
        CharSequence r11 = r3.b.getText(2131923468);
        x0.c[] r12 = r3.g;
        x0.c r13 = r12[0];
        if (r13 != null) goto L19;
        r13 = new x0.c();
        r12[0] = r13;
    L19:
        r13.a = r11;
        r13.b = r9;
        r3.l = false;
        x0 r14 = new x0(r3.b, r3);
        this.exceptionDialog = new WeakReference(r14);
        INVOKEVIRTUAL_com_bytedance_android_live_broadcastgame_InteractGameService_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(r14);
        return;
    L5:
        r0 = -1;
        goto L7
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public void tryGetSwitchGameConfirmDialog(com.bytedance.android.live.broadcastgame.api.model.u r8, Context r9, DataCenter r11, Function0<Unit> r12, Function0<Unit> r13) {
        Intrinsics.checkNotNullParameter(r8, "gameItem");
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(r11, "dataCenter");
        Intrinsics.checkNotNullParameter(r12, "onSuccess");
        Intrinsics.checkNotNullParameter(r13, "onFail");
        com.bytedance.android.live.broadcastgame.api.e r1 = this.gameAnchorService;
        if (r1 == null) goto L6;
        r1.tryGetSwitchGameConfirmDialog(r8, r9, r11, r12, r13);
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public void confirmGameStartFailed(Context r4, DataCenter r5, com.bytedance.android.live.broadcastgame.api.model.u r6, int r7, Throwable r8, Function0<Unit> r9) {
        Intrinsics.checkNotNullParameter(r4, "ctx");
        Intrinsics.checkNotNullParameter(r5, "dataCenter");
        Intrinsics.checkNotNullParameter(r6, "gameItem");
        Intrinsics.checkNotNullParameter(r8, "e");
        if (r7 != 4014029) goto L5;
        int r1 = 2131923470;
    L6:
        if (r7 != 4014029) goto L8;
        int r11 = 2131923467;
    L9:
        x0.b r0 = new x0.b(r4, 0);
        r0.a.a = 0;
        r0.l(r1);
        r0.m(2131923471);
        r0.i(1, r11, new d(r8, r6, r5));
        r0.a.l = false;
        if (r9 == null) goto L12;
        r0.i(0, 2131923469, new c(r9));
    L12:
        r0.n();
        return;
    L8:
        r11 = 2131923468;
        goto L9
    L5:
        r1 = 2131923466;
        goto L6
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public Observable<com.bytedance.android.live.network.response.e<Object>> notifyServerGameStop(long r15, long r17, long r19, String r21, boolean r22, int r23, long r24) {
        ALogger.d(IInteractGameService.TAG, "game/status/stop: gameId " + r15 + ", roomId: " + r17 + ", gameToken: " + r24 + ", stopReason: " + r23);
        int r0 = g0.a;
        Intrinsics.checkNotNullParameter(BroadcastGameApi.class, "cls");
        BroadcastGameApi r2 = (BroadcastGameApi) com.bytedance.android.live.network.c.b().e(BroadcastGameApi.class);
        if (r21 != null) goto L5;
        String r9 = "";
    L7:
        return r2.notifyServerGameStop(r15, r17, r19, r9, r22, r23, r24);
    L5:
        r9 = r21;
        goto L7
    }
}
