package com.ss.android.lark.feed.shared.page;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.android.file.picker.lib.v2.ui.main.FilePickerViewModel;
import com.h6ah4i.android.widget.advrecyclerview.swipeable.SwipeableItemWrapperAdapter;
import com.larksuite.arch.jack.JackView;
import com.larksuite.arch.jack.JackViewModel;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.larksuite.framework.ui.StableLinearLayoutManager;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.eventbus.EventBus;
import com.ss.android.eventbus.Subscribe;
import com.ss.android.lark.abtest.api.IABTestService;
import com.ss.android.lark.api.bean.ForsetiMode;
import com.ss.android.lark.appcontext.applifecycle.LifecycleHandler;
import com.ss.android.lark.appcontext.applifecycle.w;
import com.ss.android.lark.appreciablelib.Biz;
import com.ss.android.lark.appreciablelib.Scene;
import com.ss.android.lark.biz.im.api.FeedCard;
import com.ss.android.lark.biz.im.api.extension.ImExtensionType;
import com.ss.android.lark.feed.app.entity.FeedFilter;
import com.ss.android.lark.feed.app.entity.FeedFolder;
import com.ss.android.lark.feed.app.entity.FeedFolderCompat;
import com.ss.android.lark.feed.app.entity.UIFeedCard;
import com.ss.android.lark.feed.export.feedcard.action.FeedActionStatus;
import com.ss.android.lark.feed.shared.data.LoadState;
import com.ss.android.lark.feed.shared.data.UpdateRecord;
import com.ss.android.lark.feed.shared.databinding.FragmentRefactorFeedListBinding;
import com.ss.android.lark.feed.shared.page.adapter.LarkFeedInBoxListAdapter;
import com.ss.android.lark.feed.shared.page.click_hint.FeedClickHintLogic;
import com.ss.android.lark.feed.shared.page.date.FeedDateTickObserver;
import com.ss.android.lark.feed.shared.page.experiment.FeedCallbackExecutor;
import com.ss.android.lark.feed.shared.page.experiment.FeedPreloadConfig;
import com.ss.android.lark.feed.shared.page.listener.FeedItemScrollListener;
import com.ss.android.lark.feed.shared.page.status.FeedBackgroundStatusView;
import com.ss.android.lark.flow.feed.status.FlowBackgroundPageStatusView;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.convention.PassportcConvention;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.recyclerview.CommonRecyclerView;
import com.ss.ttvideoengine.utils.ScreenUtils;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import dagger.hilt.android.dwarf.DwarfInjectPoint;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@DwarfInjectPoint(parent = e0c.l.class)
@Metadata(d1 = {"\u0000¼\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\b\u0006\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f*\u0010HX\u0081\u0001\u0084\u0001\u0087\u0001\u008f\u0001\u0095\u0001\u0098\u0001 \u0001\b\u0017\u0018\u0000 þ\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0004þ\u0001ÿ\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010v\u001a\u00020wH\u0016J\b\u0010x\u001a\u00020wH\u0016J \u0010y\u001a\u00020w2\u0006\u0010z\u001a\u00020{2\u0006\u0010|\u001a\u00020}2\u0006\u0010~\u001a\u00020\u007fH\u0002J\u0015\u0010¥\u0001\u001a\u00020w2\n\u0010¦\u0001\u001a\u0005\u0018\u00010§\u0001H\u0016J.\u0010¨\u0001\u001a\u0005\u0018\u00010©\u00012\b\u0010ª\u0001\u001a\u00030«\u00012\n\u0010¬\u0001\u001a\u0005\u0018\u00010\u00ad\u00012\n\u0010¦\u0001\u001a\u0005\u0018\u00010§\u0001H\u0016J\u001f\u0010®\u0001\u001a\u00020w2\b\u0010¯\u0001\u001a\u00030©\u00012\n\u0010¦\u0001\u001a\u0005\u0018\u00010§\u0001H\u0016J\u0013\u0010°\u0001\u001a\u00020w2\b\u0010±\u0001\u001a\u00030²\u0001H\u0007J\u0013\u0010³\u0001\u001a\u00020w2\b\u0010´\u0001\u001a\u00030µ\u0001H\u0007J\u0013\u0010¶\u0001\u001a\u00020w2\b\u0010·\u0001\u001a\u00030¸\u0001H\u0007J\t\u0010¹\u0001\u001a\u00020wH\u0002J\n\u0010º\u0001\u001a\u00030»\u0001H\u0016J\u0013\u0010¼\u0001\u001a\u00020w2\b\u0010½\u0001\u001a\u00030§\u0001H\u0016J\u0015\u0010¾\u0001\u001a\u00020w2\n\u0010¦\u0001\u001a\u0005\u0018\u00010§\u0001H\u0016J\t\u0010¿\u0001\u001a\u00020wH\u0002J\t\u0010À\u0001\u001a\u00020RH\u0002J\u000f\u0010Á\u0001\u001a\b\u0012\u0002\b\u0003\u0018\u00010UH\u0002J\t\u0010Â\u0001\u001a\u00020cH\u0002J\t\u0010Ã\u0001\u001a\u00020wH\u0016J\t\u0010Ä\u0001\u001a\u00020wH\u0016J\t\u0010Å\u0001\u001a\u00020,H\u0016J\f\u0010Æ\u0001\u001a\u0005\u0018\u00010Ç\u0001H\u0016J\t\u0010È\u0001\u001a\u00020wH\u0016J\t\u0010É\u0001\u001a\u00020,H\u0016J\t\u0010Ê\u0001\u001a\u00020,H\u0016J\t\u0010Ë\u0001\u001a\u00020wH\u0016J\t\u0010Ì\u0001\u001a\u00020wH\u0002J\t\u0010Í\u0001\u001a\u00020wH\u0002J\t\u0010Î\u0001\u001a\u00020wH\u0002J\t\u0010Ï\u0001\u001a\u00020wH\u0002J\t\u0010Ð\u0001\u001a\u00020wH\u0002J\u001c\u0010Ñ\u0001\u001a\u000b\u0012\u0004\u0012\u00020{\u0018\u00010Ò\u00012\b\u0010Ó\u0001\u001a\u00030Ô\u0001H\u0002J\t\u0010Õ\u0001\u001a\u00020wH\u0002J\u0013\u0010Ö\u0001\u001a\u00020,2\b\u0010Ó\u0001\u001a\u00030Ô\u0001H\u0002J\t\u0010×\u0001\u001a\u00020wH\u0002J\u0012\u0010Ø\u0001\u001a\u00020w2\u0007\u0010Ù\u0001\u001a\u00020,H\u0016J\u001b\u0010Ú\u0001\u001a\u00020w2\u0010\u0010Û\u0001\u001a\u000b\u0012\u0004\u0012\u00020,\u0018\u00010Ü\u0001H\u0016J\t\u0010Ý\u0001\u001a\u00020wH\u0016J\u0013\u0010Þ\u0001\u001a\u00020w2\b\u0010ß\u0001\u001a\u00030\u008c\u0001H\u0016J\u001f\u0010à\u0001\u001a\u00020w2\n\u0010á\u0001\u001a\u0005\u0018\u00010\u008a\u00012\b\u0010â\u0001\u001a\u00030ã\u0001H\u0002J%\u0010ä\u0001\u001a\u00020w2\b\u0010å\u0001\u001a\u00030\u008a\u00012\u0007\u0010æ\u0001\u001a\u00020,2\u0007\u0010ç\u0001\u001a\u00020,H\u0014J\u001c\u0010è\u0001\u001a\u00030é\u00012\u0007\u0010æ\u0001\u001a\u00020,2\u0007\u0010ç\u0001\u001a\u00020,H\u0004J\u0013\u0010ê\u0001\u001a\u00030ë\u00012\u0007\u0010ì\u0001\u001a\u00020FH\u0004J\u001b\u0010í\u0001\u001a\u00020w2\b\u0010î\u0001\u001a\u00030ï\u00012\b\u0010ð\u0001\u001a\u00030ñ\u0001J\u0015\u0010ò\u0001\u001a\u00020w2\n\u0010ó\u0001\u001a\u0005\u0018\u00010ë\u0001H\u0002J\t\u0010ô\u0001\u001a\u00020wH\u0016J\u0018\u0010õ\u0001\u001a\u00020w2\u000f\u0010ö\u0001\u001a\n\u0012\u0005\u0012\u00030¤\u00010Ò\u0001J\u0013\u0010÷\u0001\u001a\u00020w2\b\u0010ð\u0001\u001a\u00030ñ\u0001H\u0002J\u0010\u0010ø\u0001\u001a\u00020w2\u0007\u0010ù\u0001\u001a\u00020FJ\u000b\u0010ú\u0001\u001a\u0004\u0018\u00010{H\u0002J\t\u0010û\u0001\u001a\u00020wH\u0016J\t\u0010ü\u0001\u001a\u00020wH\u0016J\t\u0010ý\u0001\u001a\u00020wH\u0016R\u0016\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\b\n\u0000\u0012\u0004\b\n\u0010\u0007R\"\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0084\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\r\u0010\u0007\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u00138BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0016\u001a\u00020\u00178\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001e\u0010\u001c\u001a\u00020\u001d8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001c\u0010\"\u001a\u0004\u0018\u00010#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001a\u0010(\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020*0)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010-\u001a\u0004\u0018\u00010.X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001b\u00103\u001a\u00020,8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b6\u00107\u001a\u0004\b4\u00105R\u000e\u00108\u001a\u000209X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010:\u001a\u00020;8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u001b\u0010@\u001a\u00020A8DX\u0084\u0084\u0002¢\u0006\f\n\u0004\bD\u00107\u001a\u0004\bB\u0010CR\u000e\u0010E\u001a\u00020FX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010G\u001a\u00020HX\u0082\u000e¢\u0006\u0004\n\u0002\u0010IR\"\u0010J\u001a\u0004\u0018\u00010KX\u0084\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bL\u0010\u0007\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\u0016\u0010Q\u001a\u0004\u0018\u00010RX\u0082\u000e¢\u0006\b\n\u0000\u0012\u0004\bS\u0010\u0007R\u001a\u0010T\u001a\b\u0012\u0002\b\u0003\u0018\u00010UX\u0082\u000e¢\u0006\b\n\u0000\u0012\u0004\bV\u0010\u0007R\u001b\u0010W\u001a\u00020X8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b[\u00107\u001a\u0004\bY\u0010ZR\u0016\u0010\\\u001a\u0004\u0018\u00010]X\u0082\u000e¢\u0006\b\n\u0000\u0012\u0004\b^\u0010\u0007R\u0016\u0010_\u001a\u0004\u0018\u00010`X\u0082\u000e¢\u0006\b\n\u0000\u0012\u0004\ba\u0010\u0007R\u0016\u0010b\u001a\u0004\u0018\u00010cX\u0082\u000e¢\u0006\b\n\u0000\u0012\u0004\bd\u0010\u0007R\u001b\u0010e\u001a\u00020f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bi\u00107\u001a\u0004\bg\u0010hR\u001b\u0010j\u001a\u00020k8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bn\u00107\u001a\u0004\bl\u0010mR\u000e\u0010o\u001a\u00020pX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010q\u001a\u00020r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bu\u00107\u001a\u0004\bs\u0010tR\u0013\u0010\u0080\u0001\u001a\u00030\u0081\u0001X\u0082\u0004¢\u0006\u0005\n\u0003\u0010\u0082\u0001R\u0013\u0010\u0083\u0001\u001a\u00030\u0084\u0001X\u0082\u0004¢\u0006\u0005\n\u0003\u0010\u0085\u0001R\u0013\u0010\u0086\u0001\u001a\u00030\u0087\u0001X\u0082\u0004¢\u0006\u0005\n\u0003\u0010\u0088\u0001R\u0012\u0010\u0089\u0001\u001a\u0005\u0018\u00010\u008a\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u008b\u0001\u001a\u00030\u008c\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u008d\u0001\u001a\u00020,X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u008e\u0001\u001a\u00030\u008f\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u0092\u0001\u00107\u001a\u0006\b\u0090\u0001\u0010\u0091\u0001R\u000f\u0010\u0093\u0001\u001a\u00020,X\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u0094\u0001\u001a\u00030\u0095\u0001X\u0082\u0004¢\u0006\u0005\n\u0003\u0010\u0096\u0001R\u0013\u0010\u0097\u0001\u001a\u00030\u0098\u0001X\u0082\u0004¢\u0006\u0005\n\u0003\u0010\u0099\u0001R \u0010\u009a\u0001\u001a\u00030\u009b\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u009e\u0001\u00107\u001a\u0006\b\u009c\u0001\u0010\u009d\u0001R\u0013\u0010\u009f\u0001\u001a\u00030 \u0001X\u0082\u0004¢\u0006\u0005\n\u0003\u0010¡\u0001R\u0017\u0010¢\u0001\u001a\n\u0012\u0005\u0012\u00030¤\u00010£\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0080\u0002"}, d2 = {"Lcom/ss/android/lark/feed/shared/page/FeedItemsFragment;", "Lcom/ss/android/lark/feed/export/feedlist/BaseFeedFragment;", "Lcom/larksuite/arch/jack/JackView;", "Lcom/ss/android/lark/passportc/convention/view/UserScopeView;", "Lcom/ss/android/lark/feed/shared/page/swipe/ISwipeReseter;", "Lcom/ss/android/lark/feed/shared/page/FeedItemsAbility;", "<init>", "()V", "_binding", "Lcom/ss/android/lark/feed/shared/databinding/FragmentRefactorFeedListBinding;", "get_binding$annotations", "feedPageStatusView", "Lcom/ss/android/lark/feed/shared/page/status/FeedBackgroundStatusView;", "getFeedPageStatusView$annotations", "getFeedPageStatusView", "()Lcom/ss/android/lark/feed/shared/page/status/FeedBackgroundStatusView;", "setFeedPageStatusView", "(Lcom/ss/android/lark/feed/shared/page/status/FeedBackgroundStatusView;)V", "rvInbox", "Lcom/ss/android/lark/feed/shared/page/FeedRecyclerView;", "getRvInbox", "()Lcom/ss/android/lark/feed/shared/page/FeedRecyclerView;", "rustClient", "Lcom/bytedance/lark/rustclient/api/IRustClient;", "getRustClient", "()Lcom/bytedance/lark/rustclient/api/IRustClient;", "setRustClient", "(Lcom/bytedance/lark/rustclient/api/IRustClient;)V", "feedStrangerCache", "Lcom/ss/android/lark/feed/shared/data/stranger/IFeedStrangerDataCache;", "getFeedStrangerCache", "()Lcom/ss/android/lark/feed/shared/data/stranger/IFeedStrangerDataCache;", "setFeedStrangerCache", "(Lcom/ss/android/lark/feed/shared/data/stranger/IFeedStrangerDataCache;)V", "shortcutTouchDelegate", "Landroid/view/View$OnTouchListener;", "getShortcutTouchDelegate", "()Landroid/view/View$OnTouchListener;", "setShortcutTouchDelegate", "(Landroid/view/View$OnTouchListener;)V", "mLastVisibleFirstEndPosition", "Lkotlin/Pair;", "Ljava/util/concurrent/atomic/AtomicInteger;", "isListScrollingScene", BuildConfig.FLAVOR, "dependency", "Lcom/ss/android/lark/feed/shared/page/IFeedItemsDependency;", "getDependency", "()Lcom/ss/android/lark/feed/shared/page/IFeedItemsDependency;", "setDependency", "(Lcom/ss/android/lark/feed/shared/page/IFeedItemsDependency;)V", "disableDialogNoDismiss", "getDisableDialogNoDismiss", "()Z", "disableDialogNoDismiss$delegate", "Lkotlin/Lazy;", "frontToBackEventListener", "Lcom/ss/android/lark/appcontext/applifecycle/IFrontToBackEventListener;", "viewModelFactory", "Lcom/ss/android/lark/feed/shared/page/IFeedItemsViewModelFactory;", "getViewModelFactory", "()Lcom/ss/android/lark/feed/shared/page/IFeedItemsViewModelFactory;", "setViewModelFactory", "(Lcom/ss/android/lark/feed/shared/page/IFeedItemsViewModelFactory;)V", "feedItemsViewModel", "Lcom/ss/android/lark/feed/shared/page/IFeedItemsViewModel;", "getFeedItemsViewModel", "()Lcom/ss/android/lark/feed/shared/page/IFeedItemsViewModel;", "feedItemsViewModel$delegate", "feedFilter", "Lcom/ss/android/lark/feed/app/entity/FeedFolder;", "feedCardContext", "com/ss/android/lark/feed/shared/page/FeedItemsFragment$feedCardContext$1", "Lcom/ss/android/lark/feed/shared/page/FeedItemsFragment$feedCardContext$1;", "feedAdapter", "Lcom/ss/android/lark/feed/shared/page/adapter/LarkFeedInBoxListAdapter;", "getFeedAdapter$annotations", "getFeedAdapter", "()Lcom/ss/android/lark/feed/shared/page/adapter/LarkFeedInBoxListAdapter;", "setFeedAdapter", "(Lcom/ss/android/lark/feed/shared/page/adapter/LarkFeedInBoxListAdapter;)V", "mRecyclerViewSwipeManager", "Lcom/h6ah4i/android/widget/advrecyclerview/swipeable/RecyclerViewSwipeManager;", "getMRecyclerViewSwipeManager$annotations", "mWrappedAdapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "getMWrappedAdapter$annotations", "feedActionDependency", "com/ss/android/lark/feed/shared/page/FeedItemsFragment$feedActionDependency$2$1", "getFeedActionDependency", "()Lcom/ss/android/lark/feed/shared/page/FeedItemsFragment$feedActionDependency$2$1;", "feedActionDependency$delegate", "stateRecorder", "Lcom/ss/android/lark/feed/shared/page/scroll/IScrollStateRecorder;", "getStateRecorder$annotations", "unreadScrollHelper", "Lcom/ss/android/lark/feed/shared/page/unread/UnreadScrollHelper;", "getUnreadScrollHelper$annotations", "mDataContainerInit", "Lcom/ss/android/lark/feed/shared/page/FeedItemsViewInit;", "getMDataContainerInit$annotations", "clickHintLogic", "Lcom/ss/android/lark/feed/shared/page/click_hint/FeedClickHintLogic;", "getClickHintLogic", "()Lcom/ss/android/lark/feed/shared/page/click_hint/FeedClickHintLogic;", "clickHintLogic$delegate", "swipeActionStatusHandler", "Lcom/ss/android/lark/feed/shared/page/swipe/SwipeActionStatusHandler;", "getSwipeActionStatusHandler", "()Lcom/ss/android/lark/feed/shared/page/swipe/SwipeActionStatusHandler;", "swipeActionStatusHandler$delegate", "resetCurrentSwipeItemRunnable", "Ljava/lang/Runnable;", "dateTickObserver", "Lcom/ss/android/lark/feed/shared/page/date/FeedDateTickObserver;", "getDateTickObserver", "()Lcom/ss/android/lark/feed/shared/page/date/FeedDateTickObserver;", "dateTickObserver$delegate", "resetCurrentSwipeItem", BuildConfig.FLAVOR, "notifyDataSetChanged", "onDoneAction", Keys.API_RETURN_KEY_DATA, "Lcom/ss/android/lark/feed/app/entity/UIFeedCard;", "actionStatus", "Lcom/ss/android/lark/feed/export/feedcard/action/FeedActionStatus;", "event", "Lcom/ss/android/lark/feed/export/feedcard/action/FeedActionEvent;", "rvInboxPreDrawListener", "com/ss/android/lark/feed/shared/page/FeedItemsFragment$rvInboxPreDrawListener$1", "Lcom/ss/android/lark/feed/shared/page/FeedItemsFragment$rvInboxPreDrawListener$1;", "attachStateListener", "com/ss/android/lark/feed/shared/page/FeedItemsFragment$attachStateListener$1", "Lcom/ss/android/lark/feed/shared/page/FeedItemsFragment$attachStateListener$1;", "mUnreadScrollListener", "com/ss/android/lark/feed/shared/page/FeedItemsFragment$mUnreadScrollListener$1", "Lcom/ss/android/lark/feed/shared/page/FeedItemsFragment$mUnreadScrollListener$1;", "mLastUpdateRecord", "Lcom/ss/android/lark/feed/shared/data/UpdateRecord;", "bufferCount", BuildConfig.FLAVOR, "isNavMuteBadgeState", "feedItemListener", "com/ss/android/lark/feed/shared/page/FeedItemsFragment$feedItemListener$2$1", "getFeedItemListener", "()Lcom/ss/android/lark/feed/shared/page/FeedItemsFragment$feedItemListener$2$1;", "feedItemListener$delegate", "mDisableTouch", "rvInboxTouchListener", "com/ss/android/lark/feed/shared/page/FeedItemsFragment$rvInboxTouchListener$1", "Lcom/ss/android/lark/feed/shared/page/FeedItemsFragment$rvInboxTouchListener$1;", "mOnScrollListener", "com/ss/android/lark/feed/shared/page/FeedItemsFragment$mOnScrollListener$1", "Lcom/ss/android/lark/feed/shared/page/FeedItemsFragment$mOnScrollListener$1;", "itemsScrollListenerV2", "Lcom/ss/android/lark/feed/shared/page/listener/FeedItemScrollListener;", "getItemsScrollListenerV2", "()Lcom/ss/android/lark/feed/shared/page/listener/FeedItemScrollListener;", "itemsScrollListenerV2$delegate", "itemsScrollListener", "com/ss/android/lark/feed/shared/page/FeedItemsFragment$itemsScrollListener$1", "Lcom/ss/android/lark/feed/shared/page/FeedItemsFragment$itemsScrollListener$1;", "rvInBoxDecorations", BuildConfig.FLAVOR, "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "onChatActivityDestroyEvent", "chatActivityDestroyEvent", "Lcom/ss/android/lark/feed/export/event/ChatActivityDestroyNotifyFeedEvent;", "onChatPageResumeNotifyFeedEvent", "chatPageResumeNotifyFeedEvent", "Lcom/ss/android/lark/feed/export/event/ChatPageResumeNotifyFeedEvent;", "onForsetiPlaceHolderResumeNoticeFeedEvent", "placeHolderResumeNoticeFeedEvent", "Lcom/ss/android/lark/api/event/ForsetiPlaceHolderResumeNoticeFeedEvent;", "initListContextSubscribers", "provideUserSession", "Lcom/ss/android/lark/passportc/entity/UserSession;", "onSaveInstanceState", "outState", "onViewStateRestored", "initView", "getRecyclerViewSwipeManager", "getWrappedAdapter", "getDataContainerInit", "onStart", "onResume", "checkCanDoLoadMore", "provideRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "onLoadMoreHappened", "isFeedUIShowed", "isLayoutInSliding", "showNextUnreadItem", "registerRVScrollListener", "unregisterRVScrollListener", "initCommonView", "bindFeedBackgroundStatusView", "initFeedListView", "getCurrentPageShowedItems", BuildConfig.FLAVOR, "layoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "updateBufferCount", "showAtGuideTip", "initSubscribers", "setNavMuteBadgeState", "navMuteBadgeState", "updateIsStrangerAvailable", "isStrangerAvailable", "Lcom/larksuite/arch/jack/Event;", "refreshFeedItemsList", "updateFormatEvent", "formatStyle", "onInboxFeedDataChanged", "updateRecord", "source", "Lcom/ss/android/lark/feed/shared/page/FeedItemsFragment$UpdateSource;", "updateFeedItems", "feedItemEntities", "isLoading", "isEmpty", "getFeedPageStatus", "Lcom/ss/android/lark/feed/shared/page/status/FeedBackgroundStatusView$FeedPageStatus;", "generateEmptyTip", BuildConfig.FLAVOR, "currentFilter", "showClearBadgeConfirmDialog", "context", "Landroid/content/Context;", "feedPreview", "Lcom/ss/android/lark/feed/shared/data/preview/FeedPreview;", "showToast", "content", "recoverRecentInboxItemPosition", "registerFeedListItemDecoration", "decorations", "notifyItemDataChanged", "showMarkedForLaterFilterDialog", "filter", "getNextUnreadFeedItem", "onStop", "onDestroyView", "onDestroy", "Companion", "UpdateSource", "feed-shared_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class FeedItemsFragment extends Hilt_FeedItemsFragment implements JackView, d0c.c, dfb.d {
    public static final cfb.a Q = null;
    public k A;
    public final Lazy B;
    public final Lazy C;
    public final g D;
    public final Lazy E;
    public final h F;
    public final c G;
    public UpdateRecord H;
    public int I;
    public final Lazy J;
    public boolean K;
    public final i L;
    public final FeedItemsFragment$mOnScrollListener$1 M;
    public final Lazy N;
    public final FeedItemsFragment$itemsScrollListener$1 O;
    public final List<RecyclerView.ItemDecoration> P;
    public FragmentRefactorFeedListBinding h;
    public FeedBackgroundStatusView i;

    @Inject
    public com.bytedance.lark.rustclient.api.l j;

    @Inject
    public oeb.d k;
    public final Pair<? extends AtomicInteger, ? extends AtomicInteger> l;
    public boolean m;
    public q n;
    public final Lazy o;
    public final e p;

    @Inject
    public t q;
    public final Lazy r;
    public FeedFolder s;
    public final d t;
    public LarkFeedInBoxListAdapter u;
    public bw7.b v;
    public SwipeableItemWrapperAdapter w;
    public final Lazy x;
    public bfb.a y;
    public efb.a z;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0016j\u0002\b\u0004j\u0002\b\u0005¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/feed/shared/page/FeedItemsFragment$UpdateSource;", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "CACHE_UPDATE", "REFRESH_UI_EVENT", "toString", BuildConfig.FLAVOR, "feed-shared_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum UpdateSource extends Enum<UpdateSource> {
        public static final UpdateSource CACHE_UPDATE = null;
        public static final UpdateSource REFRESH_UI_EVENT = null;
        public static final /* synthetic */ UpdateSource[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[UpdateSource.values().length];
                r0[UpdateSource.CACHE_UPDATE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
            L9:
                r0[UpdateSource.REFRESH_UI_EVENT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
            L5:
                a = r0;
            }
        }

        public static EnumEntries<UpdateSource> getEntries() {
            return b;
        }

        static {
            UpdateSource r0 = new UpdateSource("CACHE_UPDATE", 0);
            CACHE_UPDATE = r0;
            UpdateSource r1 = new UpdateSource("REFRESH_UI_EVENT", 1);
            REFRESH_UI_EVENT = r1;
            UpdateSource[] r3 = {r0, r1};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
        }

        public static UpdateSource[] values() {
            return (UpdateSource[]) a.clone();
        }

        @Override // java.lang.Enum
        public String toString() {
            int r0 = a.a[ordinal()];
            if (r0 != 1) goto L5;
            return "cache_update";
        L5:
            if (r0 != 2) goto L8;
            return "refresh_ui_event";
        L8:
            throw new NoWhenBranchMatchedException();
        }

        public static UpdateSource valueOf(String r1) {
            return (UpdateSource) r27.a.a(UpdateSource.class, r1);
        }

        public UpdateSource(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[FeedActionStatus.values().length];
            r0[FeedActionStatus.START.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[FeedActionStatus.ERROR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[FeedActionStatus.END.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public static final class c implements View.OnAttachStateChangeListener {
        public final /* synthetic */ FeedItemsFragment a;

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r2) {
            Intrinsics.checkNotNullParameter(r2, "v");
        }

        public c(FeedItemsFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r2) {
            Intrinsics.checkNotNullParameter(r2, "v");
            r2.getViewTreeObserver().removeOnPreDrawListener(this.a.F);
        }
    }

    public static final class d implements com.ss.android.lark.feed.export.feedcard.d {
        public final /* synthetic */ FeedItemsFragment a;

        @Override // com.ss.android.lark.feed.export.feedcard.d
        public final com.ss.android.lark.feed.export.feedcard.g a() {
            return null;
        }

        @Override // com.ss.android.lark.feed.export.feedcard.d
        public final deb.d b() {
            return null;
        }

        @Override // com.ss.android.lark.feed.export.feedcard.d
        public final bw7.b d() {
            return null;
        }

        @Override // com.ss.android.lark.feed.export.feedcard.d
        public final s e() {
            return null;
        }

        @Override // com.ss.android.lark.feed.export.feedcard.d
        public final s c() {
            return this.a.W90();
        }

        @Override // com.ss.android.lark.feed.export.feedcard.d
        public final FeedFolder f() {
            ceb.a r0 = this.a.d;
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.a();
        }

        @Override // com.ss.android.lark.feed.export.feedcard.d
        public final com.bytedance.lark.rustclient.api.l g() {
            com.bytedance.lark.rustclient.api.l r0 = this.a.j;
            if (r0 != null) goto L7;
            Intrinsics.throwUninitializedPropertyAccessException("rustClient");
            return null;
        L7:
            return r0;
        }

        @Override // com.ss.android.lark.feed.export.feedcard.d
        public final Fragment getHost() {
            return this.a;
        }

        public d(FeedItemsFragment r1) {
            this.a = r1;
        }
    }

    public static final class e implements w {
        public static final e a = null;

        static {
            a = new e();
        }

        public e() {
        }

        public final void a(Class r2) {
            Log.i("FeedSharedModule_FeedItemsFragment", "feed items fragment front to back event");
            peb.b r3 = heb.a.a;
            heb.a.a.getFeedDependency().getClass();
        }
    }

    public static final class f implements k.b {
        public final /* synthetic */ FeedItemsFragment a;

        @Override // com.ss.android.lark.feed.shared.page.k.b
        public final void a() {
            this.a.So();
        }

        @Override // com.ss.android.lark.feed.shared.page.k.b
        public final void b() {
            this.a.K = false;
        }

        @Override // com.ss.android.lark.feed.shared.page.k.b
        public final void c() {
            this.a.K = true;
        }

        public f(FeedItemsFragment r1) {
            this.a = r1;
        }
    }

    public static final class g implements Runnable {
        public final /* synthetic */ FeedItemsFragment a;

        public g(FeedItemsFragment r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            LarkFeedInBoxListAdapter r0 = this.a.u;     // Catch: Throwable -> L6
            if (r0 == null) goto L9;
            r0.I2();     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public static final class h implements ViewTreeObserver.OnPreDrawListener {
        public final /* synthetic */ FeedItemsFragment a;

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public final boolean onPreDraw() {
            FeedItemsFragment r0 = this.a;
            cfb.a r1 = FeedItemsFragment.Q;
            CommonRecyclerView r2 = r0.X90();
            if (r2 != null) goto L5;
            return true;
        L5:
            Log.d("FeedSharedModule_FeedItemsFragment", "onPreDraw,childcount = " + r2.getChildCount());
            if (r2.getChildCount() <= 0) goto L11;
            r2.getViewTreeObserver().removeOnPreDrawListener(this);
            FeedItemsFragment r3 = this.a;
            k r4 = r3.A;
            if (r4 != null) goto L10;
            return true;
        L10:
            r3.W90().onItemsShowed(r4.h.findLastVisibleItemPosition(), FeedItemsFragment.T90(this.a, r4.h), false);
        L11:
            return true;
        }

        public h(FeedItemsFragment r1) {
            this.a = r1;
        }
    }

    public static final class i implements View.OnTouchListener {
        public final /* synthetic */ FeedItemsFragment a;

        public i(FeedItemsFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r1, MotionEvent r2) {
            FeedItemsFragment r3 = this.a;
            if (r3.K == false) goto L6;
            return true;
        L6:
            r3.getClass();
            return false;
        }
    }

    public final void afterUserOffline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final void afterUserOnline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final /* synthetic */ Object generatedComponent() {
        return DwarfComponentProvider.-CC.$default$generatedComponent(this);
    }

    public final LifecycleOwner getLifecycleOwner() {
        return this;
    }

    public final com.larksuite.arch.jack.i getLifecycleOwnerHolder() {
        return this;
    }

    public final /* synthetic */ com.ss.android.lark.passportc.api.m getPassport() {
        return d0c.b.a(this);
    }

    public final void onUserOffline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final void onUserOnline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final /* synthetic */ e0c.l provideComponent() {
        return d0c.b.b(this);
    }

    static {
        Map r0 = com.ss.android.lark.im.base.d.a;
        Q = (cfb.a) CollectionsKt.lastOrNull(com.ss.android.lark.im.base.d.b(ImExtensionType.FEED_BACKGROUND_STATUS_VIEW, cfb.a.class));
    }

    @Override // dfb.d
    public final void So() {
        if (com.ss.android.lark.feed.shared.fg.c.a.isEnable("lark.feed.feed_adapter_lifecycle") == true) goto L13;
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.CREATED) == true) goto L7;
        Log.e("FeedSharedModule_FeedItemsFragment", "recoverRecentInboxItemPosition currentState is under created");
        return;
    L7:
        if ((Y90() instanceof SwipeableItemWrapperAdapter) == false) goto L18;
        SwipeableItemWrapperAdapter r0 = Y90();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.h6ah4i.android.widget.advrecyclerview.swipeable.SwipeableItemWrapperAdapter<*>");
        bw7.f r1 = r0.f;
        if (r1 == null) goto L19;
        r1.z0(0.0f);
        return;
    L19:
        return;
    L18:
        return;
    L13:
        if ((Y90() instanceof SwipeableItemWrapperAdapter) == false) goto L22;
        SwipeableItemWrapperAdapter r2 = Y90();
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.h6ah4i.android.widget.advrecyclerview.swipeable.SwipeableItemWrapperAdapter<*>");
        bw7.f r3 = r2.f;
        if (r3 == null) goto L23;
        r3.z0(0.0f);
        return;
    L23:
        return;
    }

    public final k V90() {
        k r0 = this.A;
        if (r0 != null) goto L5;
        r0 = new k(requireContext(), X90(), this.u, Y90(), new f(this));
        this.A = r0;
    L5:
        FeedRecyclerView r1 = X90();
        if (r1 != null) goto L8;
    L10:
        return r0;
    L8:
        if (r0.b != null) goto L10;
        r0.b = r1;
        goto L10
    }

    public final s W90() {
        return (s) this.r.getValue();
    }

    public final FeedRecyclerView X90() {
        FragmentRefactorFeedListBinding r0 = this.h;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.b;
    }

    public final RecyclerView.Adapter<?> Y90() {
        Ref.ObjectRef r0 = new Ref.ObjectRef();
        SwipeableItemWrapperAdapter r1 = this.w;
        r0.element = r1;
        if (r1 != null) goto L11;
        LarkFeedInBoxListAdapter r2 = this.u;
        if (r2 == null) goto L11;
        bw7.b r3 = this.v;
        if (r3 != null) goto L9;
        r3 = new bw7.b();
        this.v = r3;
    L9:
        SwipeableItemWrapperAdapter r4 = r3.f(r2);
        r4.setStateRestorationPolicy(RecyclerView.Adapter.StateRestorationPolicy.PREVENT_WHEN_EMPTY);
        r0.element = r4;
        this.w = r4;
    L11:
        return (RecyclerView.Adapter) r0.element;
    }

    @Override // dfb.d
    public final void cH() {
        LarkFeedInBoxListAdapter r0 = this.u;
        if (r0 == null) goto L6;
        r0.I2();
        return;
    }

    public final void onDestroy() {
        StringBuilder r0 = new StringBuilder("onDestroy, feedFilterId=");
        FeedFolder r1 = this.s;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("feedFilter");
        r1 = null;
    L5:
        r0.append(r1.getId());
        Log.i("FeedSharedModule_FeedItemsFragment", r0.toString());
        super.onDestroy();
    }

    public final void onDestroyView() {
        StringBuilder r0 = new StringBuilder("on destroy view ");
        r0.append(this);
        r0.append(", feedFilter=");
        FeedFolder r1 = this.s;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("feedFilter");
        r1 = null;
    L5:
        r0.append(r1);
        Log.i("FeedSharedModule_FeedItemsFragment", r0.toString());
        LarkFeedInBoxListAdapter r2 = this.u;
        if (r2 == null) goto L8;
        r2.I2();
    L8:
        FeedRecyclerView r3 = X90();
        if (r3 == null) goto L11;
        r3.removeOnScrollListener(this.O);
    L11:
        FeedRecyclerView r4 = X90();
        if (r4 == null) goto L14;
        r4.removeOnScrollListener((FeedItemScrollListener) this.N.getValue());
    L14:
        CommonRecyclerView r5 = X90();
        if (r5 == null) goto L17;
        r5.removeOnAttachStateChangeListener(this.G);
    L17:
        FeedCallbackExecutor.a.getClass();
        FeedCallbackExecutor.b();
        FeedClickHintLogic r6 = (FeedClickHintLogic) this.B.getValue();
        r6.getClass();
        if (com.ss.android.lark.feed.shared.fg.c.c() == false) goto L23;
        jeb.b.a().od(r6.d);
        UICallbackExecutor.removeCallbacks(r6.e);
        tua.b r7 = (tua.b) r6.c.getValue();
        if (r7 == null) goto L23;
        r7.x(r6.f);
    L23:
        k r8 = this.A;
        if (r8 == null) goto L26;
        com.ss.android.lark.integrator.im.feed_shared.dependency.f r9 = heb.a.a.getFeedDependency();
        p r10 = r8.i;
        r9.getClass();
        Intrinsics.checkNotNullParameter(r10, "shortcutStatusListener");
    L26:
        this.A = null;
        LarkFeedInBoxListAdapter r11 = this.u;
        if (r11 == null) goto L29;
        r11.F2();
    L29:
        bw7.b r12 = this.v;
        if (r12 == null) goto L32;
        r12.l();
    L32:
        this.v = null;
        this.w = null;
        FeedRecyclerView r13 = X90();
        if (r13 == null) goto L35;
        r13.removeOnScrollListener(this.M);
    L35:
        this.u = null;
        FeedFolder r14 = this.t.f();
        FeedFolder r15 = this.s;
        if (r15 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("feedFilter");
        r15 = null;
    L39:
        if (Intrinsics.areEqual(r14, r15) == false) goto L41;
        W90().pauseDataChange();
    L41:
        e r16 = this.p;
        if (r16 != null) goto L44;
        List r17 = LifecycleHandler.a;
    L45:
        EventBus.getDefault().unregister(this);
        super.onDestroyView();
        this.h = null;
        this.i = null;
        return;
    L44:
        ((CopyOnWriteArrayList) LifecycleHandler.b).remove(r16);
        goto L45
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onStop() {
        Log.i("FeedSharedModule_FeedItemsFragment", "on stop " + this);
        super/*com.ss.android.lark.desktopmode.app.DesktopCompatFragment*/.onStop();
        CommonRecyclerView r0 = X90();
        if (r0 == null) goto L6;
        r0.removeCallbacks(this.D);
        return;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.ss.android.lark.feed.shared.page.FeedItemsFragment$itemsScrollListener$1] */
    /* JADX WARN: Type inference failed for: r1v22, types: [com.ss.android.lark.feed.shared.page.FeedItemsFragment$mOnScrollListener$1] */
    public FeedItemsFragment() {
        this.l = new Pair(new AtomicInteger(0), new AtomicInteger(0));
        LazyThreadSafetyMode r0 = LazyThreadSafetyMode.NONE;
        this.o = LazyKt.lazy(r0, FeedItemsFragment$disableDialogNoDismiss$2.INSTANCE);
        this.p = e.a;
        this.r = LazyKt.lazy(new FeedItemsFragment$feedItemsViewModel$2(this));
        this.t = new d(this);
        this.x = LazyKt.lazy(new FeedItemsFragment$feedActionDependency$2(this));
        this.B = LazyKt.lazy(new FeedItemsFragment$clickHintLogic$2(this));
        this.C = LazyKt.lazy(r0, new FeedItemsFragment$swipeActionStatusHandler$2(this));
        this.D = new g(this);
        this.E = LazyKt.lazy(new FeedItemsFragment$dateTickObserver$2(this));
        this.F = new h(this);
        this.G = new c(this);
        this.I = 20;
        this.J = LazyKt.lazy(r0, new FeedItemsFragment$feedItemListener$2(this));
        this.L = new i(this);
        this.M = new FeedItemsFragment$mOnScrollListener$1(this);
        this.N = LazyKt.lazy(r0, new FeedItemsFragment$itemsScrollListenerV2$2(this));
        this.O = new FeedItemsFragment$itemsScrollListener$1(this);
        this.P = new ArrayList();
    }

    public final UserSession e9() {
        return PassportcConvention.b(this);
    }

    public final void onResume() {
        super/*androidx.fragment.app.Fragment*/.onResume();
        com.ss.android.lark.forsetiutils.b r0 = com.ss.android.lark.forsetiutils.b.a;
        FragmentActivity r1 = getActivity();
        r0.getClass();
        if (r1 == null) goto L7;
        tua.b r2 = ((sua.a) ApiUtils.getApi(sua.a.class)).tryGetChainManager(r1);
        if (r2 == null) goto L7;
        ForsetiMode r3 = r2.T();
    L9:
        if (r3 != ForsetiMode.Compact) goto L15;
        FeedClickHintLogic r4 = (FeedClickHintLogic) this.B.getValue();
        r4.getClass();
        if (com.ss.android.lark.feed.shared.fg.c.c() == false) goto L15;
        LarkFeedInBoxListAdapter r5 = r4.a;
        if (r5 == null) goto L15;
        jeb.b.a().Xa();
        r5.notifyDataSetChanged();
    L15:
        Log.i("FeedSharedModule_FeedItemsFragment", "on resume " + this);
        return;
    L7:
        r3 = null;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onStart() {
        super/*com.ss.android.lark.desktopmode.app.DesktopCompatFragment*/.onStart();
        W90().resumeData();
        Log.i("FeedSharedModule_FeedItemsFragment", "on start " + this);
    }

    /* JADX INFO: renamed from: provideComponent, reason: collision with other method in class */
    public final /* bridge */ /* synthetic */ Object m1212provideComponent() {
        return provideComponent();
    }

    public static final dfb.e U90(FeedItemsFragment r0) {
        return (dfb.e) r0.C.getValue();
    }

    public final void aa0(StableLinearLayoutManager r3) {
        int r0 = r3.findFirstCompletelyVisibleItemPosition();
        int r4 = r3.findLastCompletelyVisibleItemPosition();
        if (r0 == (-1)) goto L9;
        if (r4 == (-1)) goto L10;
        if (r0 >= r4) goto L11;
        int r5 = com.ss.android.lark.feed.shared.page.guide.a.a;
        peb.b r6 = heb.a.a;
        r6.getGuideDependency().b();
        r6.getGuideDependency().b();
        r6.getGuideDependency().b();
        return;
    L11:
        return;
    L10:
        return;
    }

    @Subscribe
    public final void onChatActivityDestroyEvent(zdb.a r3) {
        Intrinsics.checkNotNullParameter(r3, "chatActivityDestroyEvent");
        if (com.ss.android.lark.feed.shared.fg.c.a() == true) goto L5;
        return;
    L5:
        if (com.ss.android.lark.feed.shared.fg.c.a.isCurrentEnable("im.feed.priority.messagesync") == false) goto L9;
        r3.getClass();
        return;
    }

    @Subscribe
    public final void onChatPageResumeNotifyFeedEvent(zdb.c r2) {
        Intrinsics.checkNotNullParameter(r2, "chatPageResumeNotifyFeedEvent");
        FeedClickHintLogic r0 = (FeedClickHintLogic) this.B.getValue();
        String r3 = r2.a;
        r0.getClass();
        if (com.ss.android.lark.feed.shared.fg.c.c() == false) goto L7;
        if (r3 == null) goto L8;
        jeb.b.a().k4(r3);
        return;
    L8:
        return;
    }

    @Override // com.ss.android.lark.feed.export.feedlist.BaseFeedFragment
    public final void onCreate(Bundle r5) {
        super.onCreate(r5);
        Bundle r6 = getArguments();
        if (r6 == null) goto L5;
        r6.getLong("lark.feed.app.refactor.FEED_FILTER", 0);
    L5:
        heb.a.a.getFeedDependency().getClass();
        this.s = FeedFolderCompat.INSTANCE.getMESSAGE_WITHOUT_DOUBAO();
        StringBuilder r7 = new StringBuilder("onCreate, feedFilter=");
        FeedFolder r0 = this.s;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("feedFilter");
        r0 = null;
    L8:
        r7.append(r0);
        Log.i("FeedSharedModule_FeedItemsFragment", r7.toString());
        s r8 = W90();
        FeedFolder r1 = this.s;
        if (r1 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("feedFilter");
        r1 = null;
    L11:
        r8.start(r1);
        e r9 = this.p;
        if (r9 != null) goto L14;
        List r10 = LifecycleHandler.a;
    L15:
        getLifecycle().addObserver((FeedDateTickObserver) this.E.getValue());
        s r11 = W90();
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(r11.recoverRecentItemPositionEvent(this), new FeedItemsFragment$initSubscribers$1$1(this, null)), LifecycleOwnerKt.getLifecycleScope(this));
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(r11.notifyItemChangedEvent(this), new FeedItemsFragment$initSubscribers$1$2(this, null)), LifecycleOwnerKt.getLifecycleScope(this));
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(r11.showMarkedLaterDialogEvent(this), new FeedItemsFragment$initSubscribers$1$3(this, null)), LifecycleOwnerKt.getLifecycleScope(this));
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(r11.handlePendingDeleteFeedEvent(this), new FeedItemsFragment$initSubscribers$1$4(this, null)), LifecycleOwnerKt.getLifecycleScope(this));
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(r11.showToastEvent(this), new FeedItemsFragment$initSubscribers$1$5(this, null)), LifecycleOwnerKt.getLifecycleScope(this));
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(r11.createFeedGroupActivityEvent(this), new FeedItemsFragment$initSubscribers$1$6(this, null)), LifecycleOwnerKt.getLifecycleScope(this));
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(r11.clearBadgeConfirmEvent(this), new FeedItemsFragment$initSubscribers$1$7(this, null)), LifecycleOwnerKt.getLifecycleScope(this));
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(r11.startAddFeedGroupActivityEvent(this), new FeedItemsFragment$initSubscribers$1$8(this, null)), LifecycleOwnerKt.getLifecycleScope(this));
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(r11.feedItemEntities(this), new FeedItemsFragment$initSubscribers$1$9(this, null)), LifecycleOwnerKt.getLifecycleScope(this));
        return;
    L14:
        ((CopyOnWriteArrayList) LifecycleHandler.b).add(r9);
        goto L15
    }

    @Subscribe
    public final void onForsetiPlaceHolderResumeNoticeFeedEvent(wua.a r2) {
        Intrinsics.checkNotNullParameter(r2, "placeHolderResumeNoticeFeedEvent");
        FeedClickHintLogic r3 = (FeedClickHintLogic) this.B.getValue();
        r3.getClass();
        if (com.ss.android.lark.feed.shared.fg.c.c() == false) goto L8;
        LarkFeedInBoxListAdapter r4 = r3.a;
        if (r4 == null) goto L9;
        jeb.b.a().Xa();
        r4.notifyDataSetChanged();
        return;
    L9:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onSaveInstanceState(Bundle r2) {
        Intrinsics.checkNotNullParameter(r2, "outState");
        super/*com.ss.android.lark.desktopmode.app.DesktopCompatFragment*/.onSaveInstanceState(r2);
        StringBuilder r3 = new StringBuilder("onSaveInstanceState, ");
        FeedFolder r0 = this.s;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("feedFilter");
        r0 = null;
    L5:
        r3.append(r0);
        Log.i("FeedSharedModule_FeedItemsFragment", r3.toString());
    }

    public final void onViewStateRestored(Bundle r2) {
        super/*androidx.fragment.app.Fragment*/.onViewStateRestored(r2);
        StringBuilder r3 = new StringBuilder("onViewStateRestored, ");
        FeedFolder r0 = this.s;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("feedFilter");
        r0 = null;
    L5:
        r3.append(r0);
        Log.i("FeedSharedModule_FeedItemsFragment", r3.toString());
    }

    public static final List T90(FeedItemsFragment r3, StableLinearLayoutManager r4) {
        List r0 = xeb.a.b((AtomicInteger) r3.l.getFirst(), (AtomicInteger) r3.l.getSecond(), r4, r3.u);
        if (r0 == null) goto L5;
        r3.aa0(r4);
    L5:
        return r0;
    }

    public final void Z90(UpdateRecord r18, UpdateSource r19) {
        if (r18 != null) goto L6;
        Log.w("FeedSharedModule_FeedItemsFragment", "onInboxFeedDataChanged updateRecord is invalid!");
        return;
    L6:
        boolean r3 = r18.c;
        boolean r4 = W90().isDataForceEmpty(r18.g);
        int r5 = 0;
        if (r3 == false) goto L15;
        if (r4 == true) goto L15;
        q r6 = this.n;
        if (r6 == null) goto L12;
        LoadState r7 = r6.a();
    L13:
        if (r7 == null) goto L15;
        boolean r8 = r7.a.get();
    L16:
        StringBuilder r9 = new StringBuilder("[FeedItems] onInboxFeedDataChanged, size=");
        List<UIFeedCard> r10 = r18.b;
        if (r10 == null) goto L19;
        r5 = ((ArrayList) r10).size();
    L19:
        r9.append(r5);
        r9.append(", ids=");
        List<UIFeedCard> r11 = r18.b;
        if (r11 != null) goto L22;
        r11 = CollectionsKt.emptyList();
    L22:
        r9.append(CollectionsKt.joinToString$default(r11, null, null, null, 0, null, FeedItemsFragment$onInboxFeedDataChanged$1.INSTANCE, 31, null));
        r9.append(", isDataEmpty=");
        r9.append(r3);
        r9.append(", source=");
        r9.append(r19);
        Log.i("FeedSharedModule_FeedItemsFragment", r9.toString());
        Intrinsics.checkNotNullParameter(r18, "feedItemEntities");
        heb.a.a.getFeedDependency().getClass();
        FeedFolderCompat r2 = FeedFolderCompat.INSTANCE;
        FeedFolder r12 = r2.getMESSAGE_WITHOUT_DOUBAO();
        LarkFeedInBoxListAdapter r13 = this.u;
        if (r13 == null) goto L25;
        r13.update(r18);
    L25:
        FeedBackgroundStatusView r1 = this.i;
        if (r1 == null) goto L40;
        if (r3 == true) goto L29;
        FeedBackgroundStatusView.FeedPageStatus r14 = FeedBackgroundStatusView.FeedPageStatus.HIDE;
    L32:
        Intrinsics.checkNotNullParameter(r12, "currentFilter");
        FeedFilter r15 = r12.getSystemPresetType();
        if (r15 != r2.getUNREAD().getSystemPresetType()) goto L36;
        int r16 = 2131890619;
    L39:
        r1.a(r14, UIHelper.getString(r16), null);
        goto L40
    L36:
        if (r15 != r2.getAT_ME().getSystemPresetType()) goto L38;
        r16 = 2131890588;
        goto L39
    L38:
        r16 = 2131891187;
        goto L39
    L29:
        if (r8 == false) goto L31;
        r14 = FeedBackgroundStatusView.FeedPageStatus.LOADING;
        goto L32
    L31:
        r14 = FeedBackgroundStatusView.FeedPageStatus.EMPTY;
    L40:
        q r17 = this.n;
        if (r17 == null) goto L44;
        r17.c(FeedCard.FeedType.INBOX);
        return;
    L44:
        return;
    L12:
        r7 = null;
    L15:
        r8 = false;
        goto L16
    }

    public void onViewCreated(View r14, Bundle r15) {
        Intrinsics.checkNotNullParameter(r14, "view");
        super.onViewCreated(r14, r15);
        int r16 = com.ss.android.lark.feed.shared.data.utils.c.a;
        Map r17 = com.ss.android.lark.im.base.d.a;
        reb.a r18 = new reb.a(com.ss.android.lark.im.base.d.c(ImExtensionType.FEED_CARD_FACTORY, com.ss.android.lark.feed.export.feedcard.e.class), com.ss.android.lark.feed.shared.page.e.a);
        d r0 = this.t;
        bw7.b r1 = this.v;
        if (r1 != null) goto L5;
        r1 = new bw7.b();
        this.v = r1;
    L5:
        this.u = new LarkFeedInBoxListAdapter(r18, r0, r1);
        FeedRecyclerView r19 = X90();
        if (r19 == null) goto L8;
        bfb.a r2 = new bfb.a(r19);
    L9:
        this.y = r2;
        this.z = new efb.a(this.u, X90());
        ViewConfiguration r110 = ViewConfiguration.get(requireContext());
        bw7.b r3 = this.v;
        if (r3 != null) goto L12;
        r3 = new bw7.b();
        this.v = r3;
    L12:
        r3.k = Math.max(r110.getScaledTouchSlop() * 40, r3.h);
        CommonRecyclerView r111 = X90();
        if (r111 == null) goto L15;
        r111.setWillNotDraw(false);
        r111.setHasFixedSize(true);
        r111.setMotionEventSplittingEnabled(false);
        r111.r(MapsKt.mapOf(new Pair[]{TuplesKt.to("biz", Integer.valueOf(Biz.Messenger.getValue())), TuplesKt.to("scene", Integer.valueOf(Scene.Feed.getValue()))}));
    L15:
        FeedRecyclerView r112 = X90();
        if (r112 == null) goto L18;
        FeedCallbackExecutor.a.getClass();
        FeedCallbackExecutor.a(r112);
    L18:
        k r113 = V90();
        ceb.a r4 = this.d;
        if (r4 == null) goto L21;
        r4.c();
    L21:
        r113.b(null);
        r113.a((FeedItemsFragment$feedItemListener$2.a) this.J.getValue());
        FeedRecyclerView r114 = X90();
        if (r114 == null) goto L27;
        bw7.b r5 = this.v;
        if (r5 != null) goto L26;
        r5 = new bw7.b();
        this.v = r5;
    L26:
        r5.c(r114);
    L27:
        FeedRecyclerView r115 = X90();
        if (r115 == null) goto L30;
        r115.t();
    L30:
        LarkFeedInBoxListAdapter r116 = this.u;
        if (r116 == null) goto L33;
        r116.r = new com.ss.android.lark.feed.shared.page.c(this);
    L33:
        if (r116 == null) goto L35;
        r116.l = new com.ss.android.lark.feed.shared.page.d(this);
    L35:
        CommonRecyclerView r117 = X90();
        if (r117 == null) goto L40;
        ViewTreeObserver r118 = r117.getViewTreeObserver();
        if (r118 == null) goto L40;
        r118.addOnPreDrawListener(this.F);
    L40:
        CommonRecyclerView r119 = X90();
        if (r119 == null) goto L44;
        r119.addOnAttachStateChangeListener(this.G);
    L44:
        if (web.b.a != null) goto L46;
        long r6 = SystemClock.elapsedRealtime();
        web.b.a = (FeedPreloadConfig) ((IABTestService) ApiUtils.getApi(IABTestService.class)).getAbTestValue(web.e.class, true);
        Log.i("FeedExperimentConfig", "getFeedPreloadConfig:" + web.b.a + ", cost = " + (SystemClock.elapsedRealtime() - r6));
    L46:
        FeedPreloadConfig r120 = web.b.a;
        if (r120 != null) goto L50;
        r120 = new FeedPreloadConfig(false, false, false, false, false, false, false, false, ScreenUtils.MAX_SYSTEM_BRIGHTNESS, null);
    L50:
        if (r120.isPreloadAtFeedPrefetch() == false) goto L57;
        FeedRecyclerView r121 = X90();
        if (r121 == null) goto L54;
        r121.addOnScrollListener((FeedItemScrollListener) this.N.getValue());
    L54:
        FeedRecyclerView r122 = X90();
        if (r122 == null) goto L60;
        r122.setOnFlingListener(new FeedItemsFragment$initFeedListView$9(this));
    L60:
        LarkFeedInBoxListAdapter r123 = this.u;
        if (r123 == null) goto L64;
        r123.m = new com.ss.android.lark.feed.shared.page.b(this);
    L64:
        if (((Boolean) this.o.getValue()).booleanValue() == false) goto L69;
        FeedRecyclerView r124 = X90();
        if (r124 == null) goto L69;
        r124.setOnSizeChangedListener(new FeedItemsFragment$initFeedListView$11(this));
    L69:
        if ((!((ArrayList) this.P).isEmpty()) == false) goto L76;
        Log.i("FeedSharedModule_FeedItemsFragment", "item decorations is not empty, install decorations");
        Iterator r125 = ((ArrayList) this.P).iterator();
    L72:
        if (r125.hasNext() == false) goto L76;
        RecyclerView.ItemDecoration r7 = (RecyclerView.ItemDecoration) r125.next();
        FeedRecyclerView r8 = X90();
        if (r8 == null) goto L72;
        r8.addItemDecoration(r7);
    L76:
        LarkFeedInBoxListAdapter r126 = this.u;
        if (r126 == null) goto L79;
        r126.k = new seb.b((FeedItemsFragment$feedActionDependency$2.a) this.x.getValue(), this.t);
    L79:
        CommonRecyclerView r127 = X90();
        if (r127 == null) goto L82;
        r127.setOnTouchListener(this.L);
    L82:
        com.ss.android.lark.feed.shared.data.appconfig.b r128 = com.ss.android.lark.feed.shared.data.appconfig.c.a.a.a;
        if (r128 == null) goto L87;
        int r129 = r128.a;
        if (r129 <= this.I) goto L87;
        this.I = r129;
    L87:
        FeedRecyclerView r130 = X90();
        if (r130 == null) goto L90;
        r130.addOnScrollListener(this.M);
    L90:
        FragmentRefactorFeedListBinding r131 = this.h;
        if (r131 == null) goto L100;
        cfb.a r9 = Q;
        if (r9 == null) goto L96;
        FlowBackgroundPageStatusView r10 = r9.create(r131.a.getContext());
    L97:
        this.i = r10;
        ConstraintLayout r132 = r131.a;
        ConstraintLayout.LayoutParams r11 = new ConstraintLayout.LayoutParams(-1, -1);
        r11.startToStart = 0;
        r11.endToEnd = 0;
        r11.topToTop = 0;
        r11.bottomToBottom = 0;
        Unit r12 = Unit.INSTANCE;
        r132.addView(r10, r11);
        FeedBackgroundStatusView r133 = this.i;
        if (r133 == null) goto L100;
        FeedBackgroundStatusView.FeedPageStatus r13 = FeedBackgroundStatusView.FeedPageStatus.LOADING;
        int r20 = FeedBackgroundStatusView.a;
        r133.a(r13, BuildConfig.FLAVOR, null);
        goto L100
    L96:
        r10 = null;
    L100:
        ceb.a r134 = this.d;
        if (r134 == null) goto L105;
        MutableLiveData r135 = r134.b();
        if (r135 == null) goto L105;
        r135.observe(getViewLifecycleOwner(), new com.ss.android.lark.feed.shared.page.f(this));
    L105:
        Z90(W90().getCurrentFeedItems(), UpdateSource.CACHE_UPDATE);
        FeedClickHintLogic r136 = (FeedClickHintLogic) this.B.getValue();
        r136.getClass();
        if (com.ss.android.lark.feed.shared.fg.c.c() == false) goto L114;
        jeb.b.a().g5(r136.d);
        LarkFeedInBoxListAdapter r137 = r136.a;
        if (r137 == null) goto L111;
        jeb.b.a().Xa();
        r137.notifyDataSetChanged();
    L111:
        tua.b r138 = (tua.b) r136.c.getValue();
        if (r138 == null) goto L114;
        tua.b.a.a(r138, r136.f);
    L114:
        EventBus.getDefault().register(this);
        return;
    L57:
        FeedRecyclerView r139 = X90();
        if (r139 == null) goto L60;
        r139.addOnScrollListener(this.O);
        goto L60
    L8:
        r2 = null;
        goto L9
    }

    public final <S extends com.larksuite.arch.jack.j> com.larksuite.arch.jack.c nH(JackViewModel<S> r1, com.larksuite.arch.jack.l<S> r2, Function1<? super S, Unit> r3) {
        return JackView.a.d(this, r1, r2, r3);
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        Log.i("FeedSharedModule_FeedItemsFragment", "onCreateView fragment=" + getClass().getSimpleName() + '@' + hashCode());
        FragmentRefactorFeedListBinding r5 = FragmentRefactorFeedListBinding.a(r2, r3);
        this.h = r5;
        return r5.a;
    }

    public final com.larksuite.arch.jack.c Ik(JackViewModel r1, PropertyReference1Impl r2, com.larksuite.arch.jack.l r3, Function1 r4) {
        return JackView.a.a(this, r1, r2, r3, r4);
    }

    public final com.larksuite.arch.jack.c Ki(JackViewModel r1, PropertyReference1Impl r2, PropertyReference1Impl r3, com.larksuite.arch.jack.l r4, Function1 r5) {
        return JackView.a.b(this, r1, r2, r3, r4, r5);
    }

    public final com.larksuite.arch.jack.c O60(FilePickerViewModel r1, PropertyReference1Impl r2, PropertyReference1Impl r3, PropertyReference1Impl r4, com.larksuite.arch.jack.l r5, Function1 r6) {
        return JackView.a.c(this, r1, r2, r3, r4, r5, r6);
    }
}
