package com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.live.revenuelink.connect.n;
import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.live.revlink.impl.mergepk.pkdouble.PkDoubleAnchorDataContext;
import com.bytedance.android.live.revlink.impl.mergepk.pkdouble.g;
import com.bytedance.android.live.revlink.impl.model.BizType;
import com.bytedance.android.live.revlink.impl.multianchor.connect.AnchorRtcConnectManager;
import com.bytedance.android.live.revlink.impl.multianchor.connect.AnchorRtcConnectModel;
import com.bytedance.android.live.revlink.impl.multianchor.connect.UnexpectedFrameMonitor;
import com.bytedance.android.live.revlink.impl.multianchor.utils.d0;
import com.bytedance.android.live.revlink.impl.multianchor.utils.t;
import com.bytedance.android.live.revlink.impl.multianchor.utils.u;
import com.bytedance.android.live.revlink.impl.multianchor.vm.MultiLinkAnchorControlContext;
import com.bytedance.android.live.revlink.impl.pk.service.IPKLinkBizDataService;
import com.bytedance.android.live.revlink.impl.pk.utils.l;
import com.bytedance.android.live.revlink.impl.pk.vm.linkout.PkInviteLogDataContext;
import com.bytedance.android.live.revlink.link.biz.service.h;
import com.bytedance.android.live.revlink.link.biz.service.i;
import com.bytedance.android.live.revlink.link.biz.service.k;
import com.bytedance.android.livesdk.link.model.IBattleConfigSetting;
import com.bytedance.android.livesdk.link.model.IBattleRivalTag;
import com.bytedance.android.livesdk.link.model.aa;
import com.bytedance.android.livesdk.link.model.bridge.v1;
import com.bytedance.android.livesdk.link.model.d7;
import com.bytedance.android.livesdk.link.model.h9;
import com.bytedance.android.livesdk.link.model.o9;
import com.bytedance.android.livesdk.link.model.p;
import com.bytedance.android.livesdk.link.model.v3;
import com.bytedance.android.livesdk.link.model.w2;
import com.bytedance.android.livesdk.link.model.w3;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBase;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKtKt;
import com.bytedance.android.scope.m;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import cy0.j;
import dq2.w;
import fr2.j1;
import fr2.k1;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.TypesJVMKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000ì\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006BA\u0012\u000b\u0010§\u0001\u001a\u00060\tj\u0002`\n\u0012\b\u0010ª\u0001\u001a\u00030©\u0001\u0012\u0007\u0010®\u0001\u001a\u00020\u0005\u0012\n\u0010±\u0001\u001a\u0005\u0018\u00010°\u0001\u0012\n\u0010´\u0001\u001a\u0005\u0018\u00010³\u0001¢\u0006\u0006\b\u008b\u0002\u0010\u008c\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002Jd\u0010\u0019\u001a\u00020\u00182\u000e\u0010\u000b\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\n2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0014\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0016H\u0016J¶\u0001\u0010\u0019\u001a\u00060\u001fj\u0002` 2\u000e\u0010\u000b\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\n2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0014\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00162%\u0010\u001d\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u0014¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u001a2%\u0010\u001e\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u0014¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u001aH\u0016J\b\u0010\"\u001a\u00020!H\u0016J\b\u0010#\u001a\u00020\u0011H\u0016J\n\u0010%\u001a\u0004\u0018\u00010$H\u0016J\b\u0010&\u001a\u00020\u0018H\u0016J\b\u0010'\u001a\u00020\u0007H\u0016J\u001c\u0010*\u001a\u00020\u000e2\b\u0010(\u001a\u0004\u0018\u00010\u000e2\b\u0010)\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010-\u001a\u00020\u00182\b\u0010,\u001a\u0004\u0018\u00010+H\u0016J\b\u0010-\u001a\u00020\u0018H\u0016J\b\u0010.\u001a\u00020\u0007H\u0016J\n\u0010/\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u00101\u001a\u000200H\u0016J\u0018\u00105\u001a\u0012\u0012\u0004\u0012\u00020302j\b\u0012\u0004\u0012\u000203`4H\u0016J\u0010\u00107\u001a\u00020\u00182\u0006\u00106\u001a\u00020\u0007H\u0016J\b\u00108\u001a\u00020\u0007H\u0016J.\u0010;\u001a\u001e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\u0016j\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e`:2\b\u00109\u001a\u0004\u0018\u00010\u000eH\u0016J\n\u0010=\u001a\u0004\u0018\u00010<H\u0016Jk\u0010D\u001a\u00020\u00182\u0006\u0010\r\u001a\u00020\f2\b\u0010>\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010?\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u00112\u0006\u0010@\u001a\u00020\u000e2\u0006\u0010A\u001a\u00020\u000e2\u0014\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00162\u0006\u0010C\u001a\u00020BH\u0016¢\u0006\u0004\bD\u0010EJa\u0010D\u001a\u00020\u00182\u0006\u0010\r\u001a\u00020\f2\b\u0010>\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010?\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u00112\u0006\u0010F\u001a\u00020\u000e2\u0014\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00162\u0006\u0010G\u001a\u00020B¢\u0006\u0004\bD\u0010HJ\b\u0010I\u001a\u00020\u0007H\u0016J\n\u0010K\u001a\u0004\u0018\u00010JH\u0016J\u000e\u0010N\u001a\b\u0012\u0004\u0012\u00020M0LH\u0016J\b\u0010O\u001a\u00020\u0018H\u0016J\b\u0010P\u001a\u00020\u0018H\u0016J\n\u0010R\u001a\u0004\u0018\u00010QH\u0016J\n\u0010T\u001a\u0004\u0018\u00010SH\u0016J\u0010\u0010V\u001a\u00020\u00182\u0006\u0010U\u001a\u00020\u000eH\u0016J\u0010\u0010X\u001a\u00020\u00182\u0006\u0010W\u001a\u00020\u0011H\u0016J\b\u0010Y\u001a\u00020\u0007H\u0016J\b\u0010Z\u001a\u00020\u0007H\u0016J\b\u0010\\\u001a\u00020[H\u0016J\b\u0010^\u001a\u00020]H\u0016J\b\u0010`\u001a\u00020_H\u0016J\u0010\u0010a\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\nH\u0016J\n\u0010c\u001a\u0004\u0018\u00010bH\u0016J\n\u0010e\u001a\u0004\u0018\u00010dH\u0016J\b\u0010f\u001a\u00020\u0007H\u0016J\u0010\u0010j\u001a\u00020i2\u0006\u0010h\u001a\u00020gH\u0016J\b\u0010k\u001a\u00020\u000eH\u0016J\b\u0010l\u001a\u00020\u0007H\u0016J\b\u0010m\u001a\u00020\fH\u0016J\b\u0010n\u001a\u00020\u0007H\u0016J\b\u0010o\u001a\u00020\u000eH\u0016J\n\u0010q\u001a\u0004\u0018\u00010pH\u0016J\b\u0010r\u001a\u00020\u0011H\u0016J\n\u0010t\u001a\u0004\u0018\u00010sH\u0016J\n\u0010v\u001a\u0004\u0018\u00010uH\u0016J\b\u0010w\u001a\u00020\fH\u0016J\b\u0010x\u001a\u00020\u000eH\u0016J\b\u0010y\u001a\u00020\u000eH\u0016J\b\u0010z\u001a\u00020\u000eH\u0016J\n\u0010|\u001a\u0004\u0018\u00010{H\u0016J\n\u0010~\u001a\u0004\u0018\u00010}H\u0016J\t\u0010\u0080\u0001\u001a\u00020\u007fH\u0016J\u0012\u0010\u0082\u0001\u001a\u00020\u00182\u0007\u0010U\u001a\u00030\u0081\u0001H\u0016J\n\u0010\u0083\u0001\u001a\u00030\u0081\u0001H\u0016JG\u0010\u008b\u0001\u001a\u00020\u00182\u0007\u0010\u0084\u0001\u001a\u00020\u00112\u0017\u0010\u0087\u0001\u001a\u0012\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0085\u0001j\u0005\u0018\u0001`\u0086\u00012\u0007\u0010\u0088\u0001\u001a\u00020\u00072\u0007\u0010\u0089\u0001\u001a\u00020\u000e2\u0007\u0010\u008a\u0001\u001a\u00020\u0007H\u0096\u0001J\u0013\u0010\u008d\u0001\u001a\u00020\u00182\u0007\u0010\u008c\u0001\u001a\u00020\u000eH\u0096\u0001R)\u0010\u008e\u0001\u001a\u00020\u000e8\u0016@\u0016X\u0096\u000e¢\u0006\u0018\n\u0006\b\u008e\u0001\u0010\u008f\u0001\u001a\u0006\b\u0090\u0001\u0010\u0091\u0001\"\u0006\b\u0092\u0001\u0010\u0093\u0001R8\u0010\u0095\u0001\u001a\u0011\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0094\u00018\u0016@\u0016X\u0096\u000e¢\u0006\u0018\n\u0006\b\u0095\u0001\u0010\u0096\u0001\u001a\u0006\b\u0097\u0001\u0010\u0098\u0001\"\u0006\b\u0099\u0001\u0010\u009a\u0001R>\u0010\u009b\u0001\u001a\u0017\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u0094\u0001\u0018\u00010L8\u0016@\u0016X\u0096\u000e¢\u0006\u0018\n\u0006\b\u009b\u0001\u0010\u009c\u0001\u001a\u0006\b\u009d\u0001\u0010\u009e\u0001\"\u0006\b\u009f\u0001\u0010 \u0001R\u001a\u0010¢\u0001\u001a\u0005\u0018\u00010¡\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¢\u0001\u0010£\u0001R\u001c\u0010¥\u0001\u001a\u0005\u0018\u00010¤\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¥\u0001\u0010¦\u0001R\u001b\u0010§\u0001\u001a\u00060\tj\u0002`\n8\u0002X\u0082\u0004¢\u0006\b\n\u0006\b§\u0001\u0010¨\u0001R \u0010ª\u0001\u001a\u00030©\u00018\u0016X\u0096\u0004¢\u0006\u0010\n\u0006\bª\u0001\u0010«\u0001\u001a\u0006\b¬\u0001\u0010\u00ad\u0001R\u0017\u0010®\u0001\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\b\n\u0006\b®\u0001\u0010¯\u0001R\u001a\u0010±\u0001\u001a\u0005\u0018\u00010°\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b±\u0001\u0010²\u0001R\u001a\u0010´\u0001\u001a\u0005\u0018\u00010³\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b´\u0001\u0010µ\u0001R\u0018\u0010¹\u0001\u001a\u00030¶\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\b·\u0001\u0010¸\u0001R\u001a\u0010½\u0001\u001a\u0005\u0018\u00010º\u00018\u0016X\u0096\u0005¢\u0006\b\u001a\u0006\b»\u0001\u0010¼\u0001R\u0019\u0010À\u0001\u001a\u0004\u0018\u00010J8\u0016X\u0096\u0005¢\u0006\b\u001a\u0006\b¾\u0001\u0010¿\u0001R\u001a\u0010Ä\u0001\u001a\u0005\u0018\u00010Á\u00018\u0016X\u0096\u0005¢\u0006\b\u001a\u0006\bÂ\u0001\u0010Ã\u0001R$\u0010Ê\u0001\u001a\u0005\u0018\u00010Å\u00018\u0016@\u0016X\u0096\u000f¢\u0006\u0010\u001a\u0006\bÆ\u0001\u0010Ç\u0001\"\u0006\bÈ\u0001\u0010É\u0001R\u001a\u0010Î\u0001\u001a\u0005\u0018\u00010Ë\u00018\u0016X\u0096\u0005¢\u0006\b\u001a\u0006\bÌ\u0001\u0010Í\u0001R\"\u0010C\u001a\u0004\u0018\u00010B8\u0016@\u0016X\u0096\u000f¢\u0006\u0010\u001a\u0006\bÏ\u0001\u0010Ð\u0001\"\u0006\bÑ\u0001\u0010Ò\u0001R$\u0010Ø\u0001\u001a\u0005\u0018\u00010Ó\u00018\u0016@\u0016X\u0096\u000f¢\u0006\u0010\u001a\u0006\bÔ\u0001\u0010Õ\u0001\"\u0006\bÖ\u0001\u0010×\u0001R\u0018\u0010Ü\u0001\u001a\u00030Ù\u00018\u0016X\u0096\u0005¢\u0006\b\u001a\u0006\bÚ\u0001\u0010Û\u0001R\u001a\u0010à\u0001\u001a\u0005\u0018\u00010Ý\u00018\u0016X\u0096\u0005¢\u0006\b\u001a\u0006\bÞ\u0001\u0010ß\u0001R\u001a\u0010ä\u0001\u001a\u0005\u0018\u00010á\u00018\u0016X\u0096\u0005¢\u0006\b\u001a\u0006\bâ\u0001\u0010ã\u0001R\u0017\u0010ç\u0001\u001a\u00020<8\u0016X\u0096\u0005¢\u0006\b\u001a\u0006\bå\u0001\u0010æ\u0001R\u0019\u0010é\u0001\u001a\u0004\u0018\u00010J8\u0016X\u0096\u0005¢\u0006\b\u001a\u0006\bè\u0001\u0010¿\u0001R\u001b\u0010ì\u0001\u001a\u00060\tj\u0002`\n8\u0016X\u0096\u0005¢\u0006\b\u001a\u0006\bê\u0001\u0010ë\u0001R(\u0010ð\u0001\u001a\u0014\u0012\u0004\u0012\u00020!0í\u0001j\t\u0012\u0004\u0012\u00020!`î\u00018\u0016X\u0096\u0005¢\u0006\u0007\u001a\u0005\b\"\u0010ï\u0001R\u001a\u0010ô\u0001\u001a\u0005\u0018\u00010ñ\u00018\u0016X\u0096\u0005¢\u0006\b\u001a\u0006\bò\u0001\u0010ó\u0001R\u001a\u0010ø\u0001\u001a\u0005\u0018\u00010õ\u00018\u0016X\u0096\u0005¢\u0006\b\u001a\u0006\bö\u0001\u0010÷\u0001R\u001a\u0010ü\u0001\u001a\u0005\u0018\u00010ù\u00018\u0016X\u0096\u0005¢\u0006\b\u001a\u0006\bú\u0001\u0010û\u0001R$\u0010\u0082\u0002\u001a\u0005\u0018\u00010ý\u00018\u0016@\u0016X\u0096\u000f¢\u0006\u0010\u001a\u0006\bþ\u0001\u0010ÿ\u0001\"\u0006\b\u0080\u0002\u0010\u0081\u0002R!\u0010\u0086\u0002\u001a\f\u0012\u0007\u0012\u0005\u0018\u00010\u0083\u00020\u0085\u00018\u0016X\u0096\u0005¢\u0006\b\u001a\u0006\b\u0084\u0002\u0010\u0085\u0002R\u001a\u0010\u008a\u0002\u001a\u0005\u0018\u00010\u0087\u00028\u0016X\u0096\u0005¢\u0006\b\u001a\u0006\b\u0088\u0002\u0010\u0089\u0002¨\u0006\u008d\u0002"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/multianchor/widget/linkoutstrategy/DoubleLaunchCompactService;", "Lcom/bytedance/android/live/revlink/impl/pk/service/IPKLinkBizDataService;", "Lcom/bytedance/android/live/revlink/impl/pk/service/d;", "Lcom/bytedance/android/live/revlink/impl/pk/service/b;", "Lcom/bytedance/android/live/revlink/link/biz/service/k;", "Lcom/bytedance/android/live/revlink/impl/multianchor/widget/linkoutstrategy/c;", "Lcom/bytedance/live/datacontext/DataContext;", "", "canInvitePK", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomKt;", "targetRoom", "", "toRoomId", "", "toUserId", "secToUserId", "", "matchType", "inviteType", "Lcom/bytedance/android/live/revlink/impl/mergepk/pkdouble/f;", "inviteParams", "", "extraParams", "", "invite", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "onSuccess", "onFailed", "Lio/reactivex/disposables/Disposable;", "Lcom/bytedance/revenue/platform/api/core/rx/Disposable;", "Lq11/c;", "getPkLinkState", "getPeakSwitchPlayMode", "Lcom/bytedance/android/livesdk/link/model/aa;", "getPeakVoteSetting", "resetPeakData", "getIsInviteVote", "inviteeUid", "inviterUid", "getTransformReason", "Lcom/bytedance/android/live/revlink/impl/mergepk/pkdouble/g;", "switchToPkDataContext", "switchFromLink", "getIsSwitchFromLink", "getIsSwitchGameFromLink", "Lcom/bytedance/android/live/revlink/impl/pk/service/IPKLinkBizDataService$e;", "getPkInteactAudienceParams", "Ljava/util/ArrayList;", "Lcom/bytedance/android/livesdk/link/model/IBattleRivalTag;", "Lkotlin/collections/ArrayList;", "getPkBattleRivalTagsInfo", "isRandomReMatch", "setIsRandomReMatch", "getIsRandomReMatch", "targetUID", "Lcom/bytedance/revenue/platform/api/core/KmpMap;", "getFollowExtraParams", "Lcom/bytedance/android/live/revenuelink/connect/n;", "getLinkOutManagerFn", "secToUid", Constants.Keys.duration, "signExtra", "battleConfigSetting", "Lf41/a;", "jsbInvitePkCallback", "invitePkByJsb", "(JLjava/lang/String;Ljava/lang/String;ILjava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Lf41/a;)V", "battleConfigSettingStr", "callback", "(JLjava/lang/String;Ljava/lang/String;ILjava/lang/Integer;Ljava/lang/String;Ljava/util/Map;Lf41/a;)V", "isLinkWithAudience", "Li11/b;", "getLinkUserCenter", "", "Lcom/bytedance/android/livesdk/link/model/p;", "getCurrentAnchorList", "recordBroadcastCapInfo", "resetBroadcastCapInfo", "Lcom/bytedance/android/live/revlink/impl/pk/vm/linkout/PkInviteLogDataContext;", "getPkInviteLogContext", "Lcom/bytedance/android/live/revlink/impl/pk/vm/linkout/n;", "getPkConnectContext", "source", "cancelCurrentInvite", "replyStatus", "refuseCurrentInvite", "getIsStarter", "getSelfHasAudienceBeforePk", "Lcom/bytedance/android/live/revlink/impl/pk/service/IPKLinkBizDataService$c;", "getGuestInfo", "Lcom/bytedance/android/live/revlink/impl/pk/service/IPKLinkBizDataService$a;", "getActivityPkParams", "Lcom/bytedance/android/live/revlink/impl/pk/service/IPKLinkBizDataService$d;", "getLinkTypeParams", "getGuestRoom", "Lcom/bytedance/android/live/revlink/impl/pk/vm/pk/f;", "getLinkPunishInfo", "Lcom/bytedance/android/live/revlink/impl/mergepk/pkdouble/PkDoubleAnchorDataContext$d;", "getVoteSetting", "getIsBreakThrough", "Lcom/bytedance/android/livesdk/link/model/o9;", "switchSceneData", "Lcom/bytedance/android/live/revlink/impl/multianchor/utils/d0;", "getPkToMultiLinkParams", "getPkLinkConnectionType", "getLinkFromMultiInvite", "getLinkStartTime", "getIsRealOrganizer", "getFlexActivityId", "Lcom/bytedance/android/livesdk/link/model/h9;", "getSpecifyGiftConfig", "getBattleInviteType", "Lcom/bytedance/android/livesdk/link/model/w2;", "getBattleShellConfig", "Lcom/bytedance/android/livesdk/link/model/IBattleConfigSetting;", "getBattleConfigSetting", "channelId", "linkmicId", "guestLinkMicId", "getRtcInfo", "Lcom/bytedance/android/livesdk/link/model/d7;", "multiLiveCoreInfo", "Lcom/bytedance/android/livesdk/link/model/bridge/v1;", "multiRtcInfo", "Lcom/bytedance/android/live/revlink/impl/pk/service/d$a;", "getLinkOptParams", "Lm41/b;", "setUnLoadSource", "getUnLoadSource", "scene", "Lkotlin/Function0;", "Lcom/bytedance/android/live/revlink/impl/multianchor/service/AfterRunnable;", "runnable", "dismissDialog", "reqSrc", "waitResp", "finishMultiAnchor", "src", "reset", "followPromotedUID", "Ljava/lang/String;", "getFollowPromotedUID", "()Ljava/lang/String;", "setFollowPromotedUID", "(Ljava/lang/String;)V", "Lkotlin/Pair;", "broadcastCapSizeInfo", "Lkotlin/Pair;", "getBroadcastCapSizeInfo", "()Lkotlin/Pair;", "setBroadcastCapSizeInfo", "(Lkotlin/Pair;)V", "supportPreviewResolutionList", "Ljava/util/List;", "getSupportPreviewResolutionList", "()Ljava/util/List;", "setSupportPreviewResolutionList", "(Ljava/util/List;)V", "Lcom/bytedance/android/livesdk/revenue/room/a;", "roomContext", "Lcom/bytedance/android/livesdk/revenue/room/a;", "Lcom/bytedance/android/livesdk/revenue/pushstream/b;", "cameraResolutionListener", "Lcom/bytedance/android/livesdk/revenue/pushstream/b;", "room", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "Lcom/bytedance/android/live/revlink/impl/global/c;", "linkInstanceService", "Lcom/bytedance/android/live/revlink/impl/global/c;", "getLinkInstanceService", "()Lcom/bytedance/android/live/revlink/impl/global/c;", "layoutOutStrategyContext", "Lcom/bytedance/android/live/revlink/impl/multianchor/widget/linkoutstrategy/c;", "Lcom/bytedance/android/livesdk/revenue/service/room/c;", "roomService", "Lcom/bytedance/android/livesdk/revenue/service/room/c;", "Lcom/bytedance/android/live/revlink/impl/multianchor/widget/linkoutstrategy/e;", "linkOutStrategy", "Lcom/bytedance/android/live/revlink/impl/multianchor/widget/linkoutstrategy/e;", "Lcom/bytedance/android/live/revlink/impl/multianchor/utils/n;", "getLaunchTemplate", "()Lcom/bytedance/android/live/revlink/impl/multianchor/utils/n;", "launchTemplate", "Lcom/bytedance/android/live/revenuelink/connect/f;", "getAnchorConnectService", "()Lcom/bytedance/android/live/revenuelink/connect/f;", "anchorConnectService", "getAnchorLinkUserCenter", "()Li11/b;", "anchorLinkUserCenter", "Lcom/bytedance/android/live/revlink/impl/multianchor/utils/t;", "getConnectMonitor", "()Lcom/bytedance/android/live/revlink/impl/multianchor/utils/t;", "connectMonitor", "Lf21/a;", "getConnectionContext", "()Lf21/a;", "setConnectionContext", "(Lf21/a;)V", "connectionContext", "Lcom/bytedance/android/live/revlink/impl/multianchor/vm/MultiLinkAnchorControlContext;", "getControlContext", "()Lcom/bytedance/android/live/revlink/impl/multianchor/vm/MultiLinkAnchorControlContext;", "controlContext", "getJsbInvitePkCallback", "()Lf41/a;", "setJsbInvitePkCallback", "(Lf41/a;)V", "Lcom/bytedance/android/live/revlink/impl/multianchor/utils/u;", "getLaunchParameters", "()Lcom/bytedance/android/live/revlink/impl/multianchor/utils/u;", "setLaunchParameters", "(Lcom/bytedance/android/live/revlink/impl/multianchor/utils/u;)V", "launchParameters", "Lcom/bytedance/android/live/revlink/impl/multianchor/utils/u$a;", "getLaunchRecord", "()Lcom/bytedance/android/live/revlink/impl/multianchor/utils/u$a;", "launchRecord", "Lcom/bytedance/android/live/revlink/impl/multianchor/scope/c;", "getLinkDialogService", "()Lcom/bytedance/android/live/revlink/impl/multianchor/scope/c;", "linkDialogService", "Lld/a;", "getLinkInternalDataSet", "()Lld/a;", "linkInternalDataSet", "getLinkOutManager", "()Lcom/bytedance/android/live/revenuelink/connect/n;", "linkOutManager", "getMLinkUserCenter", "mLinkUserCenter", "getMRoom", "()Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "mRoom", "Landroidx/lifecycle/MutableLiveData;", "Lcom/bytedance/revenue/platform/api/core/android/lifecycle/MutableLiveData;", "()Landroidx/lifecycle/MutableLiveData;", "pkLinkState", "Lx11/a;", "getRevInternalLinkService", "()Lx11/a;", "revInternalLinkService", "Lwq2/f;", "getRoomDataCenterService", "()Lwq2/f;", "roomDataCenterService", "Lcom/bytedance/android/live/revlink/impl/multianchor/connect/AnchorRtcConnectManager;", "getRtcConnectManager", "()Lcom/bytedance/android/live/revlink/impl/multianchor/connect/AnchorRtcConnectManager;", "rtcConnectManager", "Lcom/bytedance/android/live/revlink/impl/multianchor/connect/AnchorRtcConnectModel;", "getRtcConnectModel", "()Lcom/bytedance/android/live/revlink/impl/multianchor/connect/AnchorRtcConnectModel;", "setRtcConnectModel", "(Lcom/bytedance/android/live/revlink/impl/multianchor/connect/AnchorRtcConnectModel;)V", "rtcConnectModel", "Lv51/b;", "getStreamInteractScopeFn", "()Lkotlin/jvm/functions/Function0;", "streamInteractScopeFn", "Lcom/bytedance/android/live/revlink/impl/multianchor/connect/UnexpectedFrameMonitor;", "getUnexpectedFrameMonitor", "()Lcom/bytedance/android/live/revlink/impl/multianchor/connect/UnexpectedFrameMonitor;", "unexpectedFrameMonitor", "<init>", "(Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;Lcom/bytedance/android/live/revlink/impl/global/c;Lcom/bytedance/android/live/revlink/impl/multianchor/widget/linkoutstrategy/c;Lcom/bytedance/android/livesdk/revenue/service/room/c;Lcom/bytedance/android/live/revlink/impl/multianchor/widget/linkoutstrategy/e;)V", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class DoubleLaunchCompactService extends DataContext implements IPKLinkBizDataService, com.bytedance.android.live.revlink.impl.pk.service.d, com.bytedance.android.live.revlink.impl.pk.service.b, k, c {
    private Pair<Integer, Integer> broadcastCapSizeInfo;
    private com.bytedance.android.livesdk.revenue.pushstream.b cameraResolutionListener;
    private String followPromotedUID;
    private final c layoutOutStrategyContext;
    private final com.bytedance.android.live.revlink.impl.global.c linkInstanceService;
    private final e linkOutStrategy;
    private final IRoom room;
    private final com.bytedance.android.livesdk.revenue.room.a roomContext;
    private final com.bytedance.android.livesdk.revenue.service.room.c roomService;
    private List<Pair<Integer, Integer>> supportPreviewResolutionList;

    public static final class a extends com.bytedance.android.livesdk.revenue.pushstream.b {
        public final /* synthetic */ DoubleLaunchCompactService b;

        public final void b() {
            this.b.setSupportPreviewResolutionList(null);
        }

        public a(DoubleLaunchCompactService r1) {
            this.b = r1;
        }
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.service.IPKLinkBizDataService
    public void cancelCurrentInvite(String r2) {
        Intrinsics.checkNotNullParameter(r2, "source");
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public void finishMultiAnchor(int r8, Function0<Unit> r9, boolean r10, String r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r12, "reqSrc");
        this.layoutOutStrategyContext.finishMultiAnchor(r8, r9, r10, r12, r13);
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public com.bytedance.android.live.revenuelink.connect.f getAnchorConnectService() {
        return this.layoutOutStrategyContext.getAnchorConnectService();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public i11.b getAnchorLinkUserCenter() {
        return this.layoutOutStrategyContext.getAnchorLinkUserCenter();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public t getConnectMonitor() {
        return this.layoutOutStrategyContext.getConnectMonitor();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public f21.a getConnectionContext() {
        return this.layoutOutStrategyContext.getConnectionContext();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public MultiLinkAnchorControlContext getControlContext() {
        return this.layoutOutStrategyContext.getControlContext();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public f41.a getJsbInvitePkCallback() {
        return this.layoutOutStrategyContext.getJsbInvitePkCallback();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public u getLaunchParameters() {
        return this.layoutOutStrategyContext.getLaunchParameters();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public u.a getLaunchRecord() {
        return this.layoutOutStrategyContext.getLaunchRecord();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public com.bytedance.android.live.revlink.impl.multianchor.scope.c getLinkDialogService() {
        return this.layoutOutStrategyContext.getLinkDialogService();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public ld.a getLinkInternalDataSet() {
        return this.layoutOutStrategyContext.getLinkInternalDataSet();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public n getLinkOutManager() {
        return this.layoutOutStrategyContext.getLinkOutManager();
    }

    public com.bytedance.android.live.revlink.impl.pk.vm.pk.f getLinkPunishInfo() {
        return null;
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.service.IPKLinkBizDataService
    public long getLinkStartTime() {
        return 0;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public i11.b getMLinkUserCenter() {
        return this.layoutOutStrategyContext.getMLinkUserCenter();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public IRoom getMRoom() {
        return this.layoutOutStrategyContext.getMRoom();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public MutableLiveData<q11.c> getPkLinkState() {
        return this.layoutOutStrategyContext.getPkLinkState();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public x11.a getRevInternalLinkService() {
        return this.layoutOutStrategyContext.getRevInternalLinkService();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public wq2.f getRoomDataCenterService() {
        return this.layoutOutStrategyContext.getRoomDataCenterService();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public AnchorRtcConnectManager getRtcConnectManager() {
        return this.layoutOutStrategyContext.getRtcConnectManager();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public AnchorRtcConnectModel getRtcConnectModel() {
        return this.layoutOutStrategyContext.getRtcConnectModel();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public Function0<v51.b> getStreamInteractScopeFn() {
        return this.layoutOutStrategyContext.getStreamInteractScopeFn();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public UnexpectedFrameMonitor getUnexpectedFrameMonitor() {
        return this.layoutOutStrategyContext.getUnexpectedFrameMonitor();
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.service.d
    public d7 multiLiveCoreInfo() {
        return null;
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.service.d
    public v1 multiRtcInfo() {
        return null;
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.service.IPKLinkBizDataService
    public void refuseCurrentInvite(int r1) {
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public void reset(String r2) {
        Intrinsics.checkNotNullParameter(r2, "src");
        this.layoutOutStrategyContext.reset(r2);
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public void setConnectionContext(f21.a r2) {
        this.layoutOutStrategyContext.setConnectionContext(r2);
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public void setJsbInvitePkCallback(f41.a r2) {
        this.layoutOutStrategyContext.setJsbInvitePkCallback(r2);
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public void setLaunchParameters(u r2) {
        this.layoutOutStrategyContext.setLaunchParameters(r2);
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public void setRtcConnectModel(AnchorRtcConnectModel r2) {
        this.layoutOutStrategyContext.setRtcConnectModel(r2);
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.service.d
    public void setUnLoadSource(m41.b r2) {
        Intrinsics.checkNotNullParameter(r2, "source");
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.service.IPKLinkBizDataService
    public void switchFromLink(g r1) {
    }

    private final boolean canInvitePK() {
        Intrinsics.checkNotNullParameter(this, "$this$modeMerge");
        int r0 = i.getContext(this).getModeMerge().a();
        if (r0 != 0) goto L5;
        return true;
    L5:
        if (r0 == 2) goto L7;
        return false;
    L7:
        if (isLinkWithAudience() == false) goto L14;
        return false;
    L14:
        return true;
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.service.IPKLinkBizDataService
    public IPKLinkBizDataService.c getGuestInfo() {
        z41.g r0 = z41.g.o;
        r0.getClass();
        long r1 = 0;
        if (((Boolean) z41.g.j.getValue(r0, z41.g.a[8])).booleanValue() == true) goto L5;
    L17:
        com.bytedance.android.live.revlink.impl.multianchor.utils.n r2 = getLaunchTemplate();
        IRoomBase r3 = r2.getGuestRoom();
        if (r3 == null) goto L21;
        r1 = IRoomKtKt.getId(r3);
    L21:
        return new IPKLinkBizDataService.c(r1, r2.a(), r2.getGuestUser(), r2.getGuestRoom(), r2.y3(), r2.j());
    L5:
        if (getLaunchParameters() == null) goto L17;
        com.bytedance.android.live.revlink.impl.global.c r4 = getLinkInstanceService();
        Function1<k, p> r5 = new DoubleLaunchCompactService$getGuestInfo$guestUser$1(this);
        Intrinsics.checkNotNullParameter(r4, "$this$enterScope");
        Intrinsics.checkNotNullParameter(r5, "scope");
        p r6 = (p) r5.invoke(new h(r4));
        if (r6 == null) goto L17;
        IBaseUser r7 = r6.getUser();
        if (r7 == null) goto L11;
        r1 = com.bytedance.android.live.base.model.user.n.a(r7);
    L11:
        long r8 = r1;
        IBaseUser r9 = r6.getUser();
        if (r9 == null) goto L14;
        String r10 = iz.a.a(r9);
    L16:
        return new IPKLinkBizDataService.c(r8, r10, r6.getUser(), getLaunchTemplate().getGuestRoom(), getLaunchTemplate().y3(), getLaunchTemplate().j());
    L14:
        r10 = null;
        goto L16
    }

    public com.bytedance.android.live.revlink.impl.pk.service.d.a getLinkOptParams() {
        return new com.bytedance.android.live.revlink.impl.pk.service.d.a(true);
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.service.IPKLinkBizDataService
    public com.bytedance.android.live.revlink.impl.pk.vm.linkout.n getPkConnectContext() {
        e r0 = this.linkOutStrategy;
        if (r0 == null) goto L5;
        boolean r2 = r0.a.a.a;
        boolean r3 = r0.getLaunchRecord().m;
        int r4 = r0.getLaunchRecord().n;
        r0.getLaunchRecord().getClass();
        r0.getLaunchRecord().getClass();
        return new com.bytedance.android.live.revlink.impl.pk.vm.linkout.n(r2, r4);
    L5:
        return null;
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.service.IPKLinkBizDataService
    public IPKLinkBizDataService.e getPkInteactAudienceParams() {
        return new IPKLinkBizDataService.e(getLaunchTemplate().getLinkerContentMap(), getLaunchTemplate().getInviterWithAudience(), getLaunchTemplate().getInviteeWithAudience());
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.service.IPKLinkBizDataService
    public PkInviteLogDataContext getPkInviteLogContext() {
        e r0 = this.linkOutStrategy;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.a.a;
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.service.IPKLinkBizDataService
    public String getPkLinkConnectionType() {
        LinkCrossRoomDataHolder.a r0 = LinkCrossRoomDataHolder.c;
        int r1 = getLaunchTemplate().getMatchType();
        if (r1 != 0) goto L6;
        return "manual_pk";
    L6:
        if (r1 != 1) goto L9;
    L17:
        return "random_pk";
    L9:
        if (r1 == 3) goto L17;
        if (r1 != 12) goto L14;
        return "game_matching";
    L14:
        return "";
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public boolean isLinkWithAudience() {
        cy0.e.a.getClass();
        j r1 = cy0.e.a.a;
        m.e.getClass();
        Object r0 = m.b(r1).b(com.bytedance.android.livesdk.revenue.service.interact.d.class);
        Intrinsics.checkNotNull(r0);
        w r2 = ((com.bytedance.live.kmp.core.c) r0).M1();
        if (r2 == null) goto L5;
        int r3 = r2.w();
    L6:
        if (r3 <= 0) goto L9;
        return true;
    L9:
        return false;
    L5:
        r3 = 0;
        goto L6
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.service.IPKLinkBizDataService
    public void recordBroadcastCapInfo() {
        if (r11.i.a(com.bytedance.android.live.revlink.impl.settings.live.b.p.a()) == true) goto L5;
        return;
    L5:
        com.bytedance.android.livesdk.revenue.room.a r0 = this.roomContext;
        if (r0 == null) goto L17;
        com.bytedance.android.livesdk.revenue.pushstream.a r1 = r0.getCommonLiveStream();
        if (r1 == null) goto L18;
        j1 r2 = r1.j();
        if (r2 == null) goto L12;
        k1 r3 = r2.getBuilder();
    L13:
        if (r3 == null) goto L15;
        setBroadcastCapSizeInfo(new Pair(Integer.valueOf(r3.m()), Integer.valueOf(r3.l())));
    L15:
        a r4 = new a(this);
        this.cameraResolutionListener = r4;
        r1.i(r4);
        return;
    L12:
        r3 = null;
        goto L13
    L18:
        return;
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.service.IPKLinkBizDataService
    public void resetBroadcastCapInfo() {
        if (r11.i.a(com.bytedance.android.live.revlink.impl.settings.live.b.p.a()) == true) goto L5;
        return;
    L5:
        Pair<Integer, Integer> r0 = getBroadcastCapSizeInfo();
        if (r0 != null) goto L8;
        return;
    L8:
        com.bytedance.android.livesdk.revenue.room.a r1 = this.roomContext;
        if (r1 == null) goto L19;
        com.bytedance.android.livesdk.revenue.pushstream.a r2 = r1.getCommonLiveStream();
        if (r2 == null) goto L20;
        j1 r3 = r2.j();
        if (r3 == null) goto L15;
        k1 r4 = r3.getBuilder();
    L16:
        if (r4 == null) goto L21;
        r4.r(((Number) r0.getFirst()).intValue());
        r4.p(((Number) r0.getSecond()).intValue());
        setBroadcastCapSizeInfo(null);
        return;
    L21:
        return;
    L15:
        r4 = null;
        goto L16
    L20:
        return;
    }

    private final com.bytedance.android.live.revlink.impl.multianchor.utils.n getLaunchTemplate() {
        u r0 = getLaunchParameters();
        if (r0 == null) goto L6;
        return r0;
    L6:
        return getLaunchRecord();
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.service.d
    public long channelId() {
        return getLaunchTemplate().G();
    }

    public IPKLinkBizDataService.a getActivityPkParams() {
        com.bytedance.android.live.revlink.impl.multianchor.utils.n r0 = getLaunchTemplate();
        return new IPKLinkBizDataService.a(r0.e(), r0.getActivityName());
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.service.IPKLinkBizDataService
    public IBattleConfigSetting getBattleConfigSetting() {
        return getLaunchTemplate().getBattleConfigSetting();
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.service.IPKLinkBizDataService
    public int getBattleInviteType() {
        return getLaunchTemplate().getInviteType();
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.service.IPKLinkBizDataService
    public w2 getBattleShellConfig() {
        IBattleConfigSetting r0 = getLaunchTemplate().getBattleConfigSetting();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getShellConfig();
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.service.b
    public List<p> getCurrentAnchorList() {
        i11.b r0 = getAnchorLinkUserCenter();
        if (r0 == null) goto L7;
        List<p> r1 = r0.getOnlineUserList();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return CollectionsKt.emptyList();
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.service.IPKLinkBizDataService
    public String getFlexActivityId() {
        IBattleConfigSetting r0 = getLaunchTemplate().getBattleConfigSetting();
        if (r0 == null) goto L6;
        String r1 = r0.getActivityId();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "";
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.service.IPKLinkBizDataService
    public IRoom getGuestRoom() {
        return getLaunchTemplate().getGuestRoom();
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.service.IPKLinkBizDataService
    public boolean getIsBreakThrough() {
        return getLaunchTemplate().k();
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.service.IPKLinkBizDataService
    public boolean getIsInviteVote() {
        return getLaunchTemplate().g();
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.service.IPKLinkBizDataService
    public boolean getIsRandomReMatch() {
        return getLaunchTemplate().n();
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.service.IPKLinkBizDataService
    public boolean getIsRealOrganizer() {
        if (getLaunchTemplate().getMatchType() != 1) goto L5;
        return false;
    L5:
        if (getLaunchTemplate().getInviteType() != 13) goto L8;
        return false;
    L8:
        return getLaunchTemplate().i();
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.service.IPKLinkBizDataService
    public boolean getIsStarter() {
        return getLaunchTemplate().d();
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.service.IPKLinkBizDataService
    public boolean getIsSwitchFromLink() {
        return getLaunchRecord().F;
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.service.IPKLinkBizDataService
    public String getIsSwitchGameFromLink() {
        return getLaunchTemplate().getGameAppId();
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.service.IPKLinkBizDataService
    public boolean getLinkFromMultiInvite() {
        return getLaunchTemplate().o();
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.service.b
    public n getLinkOutManagerFn() {
        return getLinkOutManager();
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.service.IPKLinkBizDataService
    public IPKLinkBizDataService.d getLinkTypeParams() {
        com.bytedance.android.live.revlink.impl.multianchor.utils.n r0 = getLaunchTemplate();
        return new IPKLinkBizDataService.d(r0.getMatchType(), r0.getInviteType(), r0.getDuration(), r0.getTheme(), "");
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.service.b
    public i11.b getLinkUserCenter() {
        return getAnchorLinkUserCenter();
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.service.IPKLinkBizDataService
    public int getPeakSwitchPlayMode() {
        return getLaunchTemplate().getPeakSwitchPlayMode();
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.service.IPKLinkBizDataService
    public aa getPeakVoteSetting() {
        return getLaunchTemplate().getPeakVoteSetting();
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.service.IPKLinkBizDataService
    public ArrayList<IBattleRivalTag> getPkBattleRivalTagsInfo() {
        return getLaunchTemplate().m();
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.service.IPKLinkBizDataService
    /* JADX INFO: renamed from: getPkLinkState, reason: collision with other method in class */
    public q11.c mo747getPkLinkState() {
        com.bytedance.android.live.revenuelink.connect.f r0 = getAnchorConnectService();
        if (r0 == null) goto L31;
        LiveData<ey.f> r1 = r0.connectState();
        if (r1 == null) goto L31;
        ey.f r2 = (ey.f) r1.getValue();
        if (r2 == null) goto L31;
        if (r2.c != BizType.PK.ordinal()) goto L29;
        if (r2.c != BizType.AnchorLink.ordinal()) goto L29;
        if ((r2 instanceof ey.f.d) == false) goto L18;
        return q11.c.b.b;
    L18:
        if ((r2 instanceof ey.f.e) == false) goto L21;
        return q11.c.C0296c.b;
    L21:
        if ((r2 instanceof ey.f.b) == false) goto L24;
        return q11.c.a.b;
    L24:
        if ((r2 instanceof ey.f.f) == false) goto L27;
        return q11.c.d.b;
    L27:
        return q11.c.b.b;
    L29:
        return q11.c.b.b;
    L31:
        return q11.c.b.b;
    }

    public String getRtcInfo() {
        String r0 = getLaunchTemplate().getRtcInfo();
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0;
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.service.IPKLinkBizDataService
    public boolean getSelfHasAudienceBeforePk() {
        return getLaunchTemplate().h();
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.service.IPKLinkBizDataService
    public h9 getSpecifyGiftConfig() {
        IBattleConfigSetting r0 = getLaunchTemplate().getBattleConfigSetting();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getSpecifyGiftConfig();
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.service.IPKLinkBizDataService
    public PkDoubleAnchorDataContext.d getVoteSetting() {
        return getLaunchTemplate().l();
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.service.d
    public String guestLinkMicId() {
        String r0 = getLaunchTemplate().f();
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0;
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.service.d
    public String linkmicId() {
        return getLaunchTemplate().c();
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.service.IPKLinkBizDataService
    public void resetPeakData() {
        getLaunchRecord().B = null;
        getLaunchRecord().C = 0;
        getLaunchRecord().D = null;
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.service.IPKLinkBizDataService
    public void switchFromLink() {
        getLaunchRecord().F = true;
    }

    public Pair<Integer, Integer> getBroadcastCapSizeInfo() {
        return this.broadcastCapSizeInfo;
    }

    public String getFollowPromotedUID() {
        return this.followPromotedUID;
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.k
    public com.bytedance.android.live.revlink.impl.global.c getLinkInstanceService() {
        return this.linkInstanceService;
    }

    public List<Pair<Integer, Integer>> getSupportPreviewResolutionList() {
        return this.supportPreviewResolutionList;
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.service.d
    public m41.b getUnLoadSource() {
        return m41.b.c.c;
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.service.IPKLinkBizDataService
    public Map<String, String> getFollowExtraParams(String r8) {
        com.bytedance.android.live.revlink.impl.service.internal.a r0 = i.p(this);
        if (r0 == null) goto L33;
        if (com.bytedance.android.live.utils.c.a(r0.getCurrentMode(), 4) == false) goto L7;
        LinkedHashMap r1 = new LinkedHashMap();
        if (getFollowPromotedUID().length() <= 0) goto L11;
        boolean r2 = true;
    L12:
        String r3 = DataType.TRUE;
        if (r2 == false) goto L15;
        Object r4 = DataType.TRUE;
    L16:
        r1.put("if_follow_guide", r4);
        if (Intrinsics.areEqual(i.W(this).a(), q11.b.c.b) == false) goto L19;
        Object r5 = DataType.TRUE;
    L20:
        r1.put("if_in_punish", r5);
        r1.put("from_user_id", String.valueOf(com.bytedance.android.live.revenuelink.connect.b.d()));
        if (i.Y(this).b() != true) goto L23;
        String r6 = "anchor";
    L24:
        r1.put("from_user_type", r6);
        r1.put("to_user_type", "anchor");
        if (i.Y(this).b() == true) goto L27;
    L29:
        r3 = DataType.FALSE;
    L30:
        r1.put("if_anchor_to_another_anchor", r3);
        return r1;
    L27:
        if (Intrinsics.areEqual(r8, getLaunchRecord().q) == false) goto L29;
    L23:
        r6 = "user";
        goto L24
    L19:
        r5 = DataType.FALSE;
        goto L20
    L15:
        r4 = DataType.FALSE;
        goto L16
    L11:
        r2 = false;
        goto L12
    L7:
        return new LinkedHashMap();
    L33:
        return new LinkedHashMap();
    }

    public d0 getPkToMultiLinkParams(o9 r16) {
        Intrinsics.checkNotNullParameter(r16, "switchSceneData");
        long r2 = getLaunchTemplate().G();
        int r4 = getLaunchTemplate().getMatchType();
        String r5 = getLaunchTemplate().c();
        String r1 = getLaunchTemplate().f();
        if (r1 != null) goto L6;
        r1 = "";
    L6:
        return new d0(r2, r4, r5, r1, getLaunchTemplate().getInviteType(), getPkLinkConnectionType(), getRtcInfo(), r16, getIsRealOrganizer(), i.W(this).h(), getLaunchTemplate().o());
    }

    public void setBroadcastCapSizeInfo(Pair<Integer, Integer> r1) {
        this.broadcastCapSizeInfo = r1;
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.service.IPKLinkBizDataService
    public void setFollowPromotedUID(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.followPromotedUID = r2;
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.service.IPKLinkBizDataService
    public void setIsRandomReMatch(boolean r2) {
        getLaunchRecord().G = r2;
    }

    public void setSupportPreviewResolutionList(List<Pair<Integer, Integer>> r1) {
        this.supportPreviewResolutionList = r1;
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.service.IPKLinkBizDataService
    public String getTransformReason(String r6, String r7) {
        List<String> r0 = getLaunchTemplate().getCannotPkAnchorIds();
        if (r0 != null) goto L5;
        return "";
    L5:
        cy0.e.a.getClass();
        j r3 = cy0.e.a.a;
        m.e.getClass();
        Object r2 = m.b(r3).b(com.bytedance.android.livesdk.revenue.service.user.a.class);
        Intrinsics.checkNotNull(r2);
        IBaseUser r4 = ((com.bytedance.live.kmp.core.c) r2).b();
        if (r4 == null) goto L9;
        String r5 = r4.getIdString();
        if (r5 == null) goto L9;
    L11:
        if (r6 != null) goto L13;
    L15:
        boolean r8 = false;
    L16:
        if (r8 == false) goto L29;
        if ((!r0.isEmpty()) == true) goto L20;
        return "";
    L20:
        if (r0.contains(r5) == false) goto L26;
        if (r7 == null) goto L26;
        if (r0.contains(r7) == false) goto L26;
    L35:
        return "both_limit";
    L26:
        if (r0.contains(r5) == true) goto L39;
    L38:
        return "inviter_limit";
    L39:
        return "invitee_limit";
    L29:
        if ((!r0.isEmpty()) == true) goto L31;
        return "";
    L31:
        if (r0.contains(r5) == false) goto L37;
        if (r6 == null) goto L37;
        if (r0.contains(r6) == true) goto L35;
    L37:
        if (r0.contains(r5) == false) goto L39;
    L13:
        if (Intrinsics.areEqual(r6, r5) == false) goto L15;
        r8 = true;
    L9:
        r5 = "";
        goto L11
    }

    public DoubleLaunchCompactService(IRoom r2, com.bytedance.android.live.revlink.impl.global.c r3, c r4, com.bytedance.android.livesdk.revenue.service.room.c r5, e r6) {
        Intrinsics.checkNotNullParameter(r2, "room");
        Intrinsics.checkNotNullParameter(r3, "linkInstanceService");
        Intrinsics.checkNotNullParameter(r4, "layoutOutStrategyContext");
        this.room = r2;
        this.linkInstanceService = r3;
        this.layoutOutStrategyContext = r4;
        this.roomService = r5;
        this.linkOutStrategy = r6;
        this.followPromotedUID = "";
        if (r5 == null) goto L5;
        com.bytedance.android.livesdk.revenue.room.a r7 = r5.getRoomContext();
    L6:
        this.roomContext = r7;
        return;
    L5:
        r7 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.service.IPKLinkBizDataService
    public void invite(IRoom r13, long r14, String r16, String r17, int r18, int r19, com.bytedance.android.live.revlink.impl.mergepk.pkdouble.f r20, Map<String, String> r22) {
        invite(r13, r14, r16, r17, r18, r19, r20, r22, null, null);
    }

    public final void invitePkByJsb(long r32, String r33, String r34, int r35, Integer r36, String r37, Map<String, String> r38, f41.a r39) {
        Intrinsics.checkNotNullParameter(r37, "battleConfigSettingStr");
        Intrinsics.checkNotNullParameter(r39, "callback");
        setJsbInvitePkCallback(r39);
        if (canInvitePK() == true) goto L8;
        int r0 = ToastUtil.a;
        int r1 = w11.a.a;
        ToastUtil.a(2131922650, 0);
        f41.a r2 = getJsbInvitePkCallback();
        if (r2 == null) goto L61;
        r2.b();
        return;
    L61:
        return;
    L8:
        w31.c r3 = i.T(this);
        IPKLinkBizDataService r4 = r3.g();
        if (r4 == null) goto L12;
        q11.c r5 = r4.mo747getPkLinkState();
        if (r5 == null) goto L12;
    L13:
        com.bytedance.android.live.revlink.impl.global.c r6 = r3.c;
        if (r6 == null) goto L16;
        ox0.a r7 = r6.getModeMerge();
    L17:
        if (r7 == null) goto L19;
        int r8 = r7.a();
    L20:
        boolean r9 = com.bytedance.android.live.utils.c.a(r8, 4);
        boolean r10 = true;
        if ((r5 instanceof q11.c.C0296c) == false) goto L23;
    L26:
        boolean r12 = true;
    L27:
        com.bytedance.android.livesdk.revenue.room.a r13 = r3.a;
        if (r13 == null) goto L30;
        boolean r14 = r13.getCommonIsAnchor();
    L31:
        if (r14 == false) goto L35;
        if (r12 == true) goto L37;
        if (r9 == false) goto L35;
    L37:
        if (r10 == false) goto L46;
        if (r36 != null) goto L41;
    L42:
        int r15 = ToastUtil.a;
        int r16 = w11.a.a;
        ToastUtil.a(2131922817, 0);
        f41.a r17 = getJsbInvitePkCallback();
        if (r17 == null) goto L62;
        r17.b();
        return;
    L62:
        return;
    L41:
        if (r36.intValue() != 109) goto L42;
    L46:
        IBattleConfigSetting r18 = (IBattleConfigSetting) GsonProtectorUtils.fromJson(l97.a.a, r37, TypesJVMKt.getJavaType(Reflection.typeOf(IBattleConfigSetting.class)));
        if (r35 > 0) goto L54;
        if (r36 != null) goto L51;
    L53:
        int r19 = l51.a.j();
    L56:
        if (r36 == null) goto L58;
        int r20 = r36.intValue();
    L59:
        Intrinsics.checkNotNullParameter(this, "$this$clientAttachedInfoObj");
        invite(null, r32, r34, r33, 0, r20, new com.bytedance.android.live.revlink.impl.mergepk.pkdouble.f(null, null, r19, null, 0, r18, null, 0, 0, e21.b.b(i.getContext(this).getClientAttachedInfoObj(), l.g.c, null, null, null, null, null, 124), null, null, 7099), r38);
        return;
    L58:
        r20 = 2;
        goto L59
    L51:
        if (r36.intValue() != 109) goto L53;
    L54:
        r19 = r35;
    L35:
        r10 = false;
        goto L37
    L30:
        r14 = false;
        goto L31
    L23:
        if ((r5 instanceof q11.c.a) == true) goto L26;
        r12 = false;
        goto L27
    L19:
        r8 = 0;
        goto L20
    L16:
        r7 = null;
    L12:
        r5 = q11.c.b.b;
        goto L13
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.service.b
    public void invitePkByJsb(long r12, String r14, String r15, int r16, Integer r17, String r18, String r19, Map<String, String> r20, f41.a r22) {
        Intrinsics.checkNotNullParameter(r18, "signExtra");
        Intrinsics.checkNotNullParameter(r19, "battleConfigSetting");
        Intrinsics.checkNotNullParameter(r22, "jsbInvitePkCallback");
        invitePkByJsb(r12, r14, r15, r16, r17, r19, r20, r22);
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.service.IPKLinkBizDataService
    public Disposable invite(IRoom r42, long r43, String r45, String r46, int r47, int r48, final com.bytedance.android.live.revlink.impl.mergepk.pkdouble.f r49, Map<String, String> r50, final Function1<? super com.bytedance.android.live.revlink.impl.mergepk.pkdouble.f, Unit> r52, final Function1<? super com.bytedance.android.live.revlink.impl.mergepk.pkdouble.f, Unit> r53) {
        if (r49 == null) goto L7;
        List<IBattleRivalTag> r1 = r49.a;
        if (r1 == null) goto L7;
        getLaunchRecord().H.clear();
        getLaunchRecord().H.addAll(r1);
    L7:
        boolean r2 = true;
        if (r49 == null) goto L14;
        IBattleConfigSetting r3 = r49.g;
        if (r3 == null) goto L14;
        if (r3.getVoteData() == null) goto L14;
        getLaunchRecord().I = true;
    L14:
        if (r49 == null) goto L18;
        IBattleConfigSetting r4 = r49.g;
        if (r4 == null) goto L18;
        getLaunchRecord().M = r4;
    L18:
        HashMap<String, String> r5 = null;
        if (r49 == null) goto L21;
        String r6 = r49.l;
    L23:
        if (r6 != null) goto L25;
    L28:
        if (r2 == true) goto L34;
        u.a r7 = getLaunchRecord();
        if (r49 == null) goto L32;
        String r8 = r49.l;
    L33:
        r7.E = r8;
    L35:
        u.a r9 = getLaunchRecord();
        long r10 = 0;
        if (r49 == null) goto L44;
        IBattleConfigSetting r12 = r49.g;
        if (r12 == null) goto L44;
        aa r13 = r12.getVoteData();
        if (r13 == null) goto L42;
        long r14 = r13.getDurationTime();
    L43:
        PkDoubleAnchorDataContext.d r15 = new PkDoubleAnchorDataContext.d(r14, r12.getVoteData(), 4);
    L45:
        r9.J = r15;
        if (getLaunchRecord().E != null) goto L48;
        BizType r16 = BizType.PK;
    L49:
        n r17 = getLinkOutManager();
        IRoomBase r18 = this.room;
        if (r18 == null) goto L52;
        Long r19 = Long.valueOf(IRoomKtKt.getId(r18));
    L53:
        long r20 = r19.longValue();
        int r110 = r16.ordinal();
        if (r49 == null) goto L57;
        String r22 = r49.b;
        if (r22 == null) goto L57;
    L58:
        String r111 = r22;
        if (r49 == null) goto L61;
        int r23 = r49.c;
    L62:
        int r24 = r23;
        String r25 = "";
        if (r49 == null) goto L68;
        String r26 = r49.d;
        if (r26 == null) goto L68;
        String r27 = r26;
    L70:
        if (r49 == null) goto L72;
        int r28 = r49.e;
    L73:
        if (r49 == null) goto L75;
        int r29 = r49.f;
    L76:
        Integer r210 = Integer.valueOf(r29);
        if (r49 == null) goto L79;
        IBattleConfigSetting r30 = r49.g;
    L80:
        String r211 = GsonProtectorUtils.toJson(l97.a.a, r30);
        if (r49 == null) goto L83;
        String r32 = r49.h;
    L84:
        int r33 = i.T(this).d();
        if (r49 == null) goto L87;
        int r34 = r49.i;
    L88:
        if (r49 == null) goto L90;
        r10 = r49.j;
    L90:
        long r35 = r10;
        if (r49 == null) goto L95;
        v3 r36 = r49.k;
        if (r36 == null) goto L95;
        String r37 = w3.a(r36);
    L96:
        String r38 = getLaunchRecord().E;
        if (r38 != null) goto L99;
        String r39 = "";
    L100:
        if (r49 == null) goto L102;
        r5 = r49.m;
    L102:
        Disposable r40 = r17.f(new d11.d(7, r20, r43, r48, r47, r45, r46, r42, r110, r111, r24, r27, 0, r28, r210, 0, null, r211, null, r32, r33, r34, r35, null, r37, r39, r5, null, 344195072), new DoubleLaunchCompactService$invite$disposable$1(r52, r49), new DoubleLaunchCompactService$invite$disposable$2(r53, r49), r50);
        u.a r44 = getLaunchRecord();
        if (r49 == null) goto L108;
        String r0 = r49.h;
        if (r0 == null) goto L108;
        r25 = r0;
    L108:
        r44.getClass();
        Intrinsics.checkNotNullParameter(r25, "<set-?>");
        r44.N = r25;
        return r40;
    L99:
        r39 = r38;
    L95:
        r37 = "";
        goto L96
    L87:
        r34 = 0;
        goto L88
    L83:
        r32 = null;
        goto L84
    L79:
        r30 = null;
        goto L80
    L75:
        r29 = 0;
        goto L76
    L72:
        r28 = 0;
    L68:
        r27 = "";
        goto L70
    L61:
        r23 = l51.a.j();
    L57:
        r22 = l51.a.m();
        goto L58
    L52:
        r19 = null;
        goto L53
    L48:
        r16 = BizType.OpenGame;
        goto L49
    L42:
        r14 = 0;
    L44:
        r15 = null;
        goto L45
    L32:
        r8 = null;
        goto L33
    L34:
        getLaunchRecord().E = null;
        goto L35
    L25:
        if (r6.length() == 0) goto L28;
        r2 = false;
        goto L28
    L21:
        r6 = null;
        goto L23
    }
}
