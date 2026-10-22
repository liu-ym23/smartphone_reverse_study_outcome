package com.ss.android.lark.picker.base.widget;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import aoc.b;
import com.bytedance.lark.pb.basic.v1.ActionType;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.larksuite.framework.utils.ExternalKeyboardUtils;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.base.fragment.BaseFragment;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.desktopmode.utils.DesktopUtil;
import com.ss.android.lark.forsetiutils.ForsetiConfig;
import com.ss.android.lark.forsetiutils.ForsetiFGHelpers;
import com.ss.android.lark.im.sdk.service.h;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.picker.base.PickerImServices;
import com.ss.android.lark.picker.base.utils.SearchCommonUtils;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.picker.base.view.SearchResultView;
import com.ss.android.lark.picker.base.view.binder.CommonBinder;
import com.ss.android.lark.picker.base.view.binder.ICustomBinder;
import com.ss.android.lark.picker.base.view.binder.ICustomViewTypeResolver;
import com.ss.android.lark.picker.base.view.recommend.DefaultRecommendView;
import com.ss.android.lark.picker.base.widget.BasePicker;
import com.ss.android.lark.picker.base.widget.constants.PickerUseCategory;
import com.ss.android.lark.picker.base.widget.constants.PickerUsePage;
import com.ss.android.lark.picker.base.widget.dependency.PickerWidgetModuleDependency;
import com.ss.android.lark.picker.base.widget.params.BasePickerParams;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporter;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterDelegate;
import com.ss.android.lark.picker.base.widget.selectedview.SelectedAdapter;
import com.ss.android.lark.picker.base.widget.selectedview.SelectedMoreActivity;
import com.ss.android.lark.picker.base.widget.selectedview.SelectedMoreResponsiveActivity;
import com.ss.android.lark.picker.base.widget.utils.FG;
import com.ss.android.lark.profile.v2.entity.UserInfo;
import com.ss.android.lark.search.baseview.SearchFrameLayout;
import com.ss.android.lark.search.baseview.SearchInputView;
import com.ss.android.lark.search.dto.EntityType;
import com.ss.android.lark.search.dto.SearchResponse;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.search.dto.info.SearchChatInfo;
import com.ss.android.lark.search.dto.info.SearchChatterInfo;
import com.ss.android.lark.search.dto.service.SearchContext;
import com.ss.android.lark.utils.ContextsKt;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.recyclerview.CommonRecyclerView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.selects.SelectImplementation;
import y9c.d;
import z3c.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000¡\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0014\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b+\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b&\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\r\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0011*\u0001R\b&\u0018\u0000 \u009d\u0003*\b\b\u0000\u0010\u0001*\u00020\u0002*\u0014\b\u0001\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u00002\u00020\u00042\u00020\u0005:\u0016\u009d\u0003\u009e\u0003\u009f\u0003 \u0003¡\u0003¢\u0003£\u0003¤\u0003¥\u0003¦\u0003§\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tB\u001b\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\b\u0010\fJ\u0014\u0010\u008e\u0001\u001a\u00030\u008f\u00012\n\u0010\u0090\u0001\u001a\u0005\u0018\u00010\u008d\u0001J\n\u0010\u0099\u0001\u001a\u00030\u008f\u0001H\u0002J\b\u0010\u009a\u0001\u001a\u00030\u008f\u0001J\u0014\u0010\u009b\u0001\u001a\u00030\u008f\u00012\b\u0010\u009c\u0001\u001a\u00030\u009d\u0001H\u0002J \u0010\u009e\u0001\u001a\u00030\u008f\u00012\t\u0010\u009f\u0001\u001a\u0004\u0018\u00010\u000e2\t\b\u0002\u0010 \u0001\u001a\u000208H\u0002J\u001c\u0010§\u0001\u001a\u00030\u008f\u00012\u0007\u0010¨\u0001\u001a\u00020?2\u0007\u0010©\u0001\u001a\u00020?H\u0002J%\u0010ª\u0001\u001a\u0004\u0018\u00010\u000e2\u0007\u0010¨\u0001\u001a\u00020?2\b\u0010«\u0001\u001a\u00030¬\u0001H\u0082@¢\u0006\u0003\u0010\u00ad\u0001J%\u0010®\u0001\u001a\u0004\u0018\u00010\u000e2\u0007\u0010¨\u0001\u001a\u00020?2\b\u0010«\u0001\u001a\u00030¬\u0001H\u0082@¢\u0006\u0003\u0010\u00ad\u0001J\u0013\u0010¯\u0001\u001a\u00030\u008f\u00012\u0007\u0010©\u0001\u001a\u00020?H\u0014J)\u0010°\u0001\u001a\u00030\u008f\u00012\u0007\u0010©\u0001\u001a\u00020?2\u0007\u0010¨\u0001\u001a\u00020?2\r\u0010±\u0001\u001a\b\u0012\u0004\u0012\u00020\u000e0:J\u0013\u0010²\u0001\u001a\u00030¬\u00012\u0007\u0010©\u0001\u001a\u00020?H\u0002J$\u0010³\u0001\u001a\u00030¬\u00012\u0007\u0010©\u0001\u001a\u00020?2\t\u0010´\u0001\u001a\u0004\u0018\u00018\u0000H\u0002¢\u0006\u0003\u0010µ\u0001J%\u0010¶\u0001\u001a\u00030¬\u00012\b\u0010«\u0001\u001a\u00030¬\u00012\t\u0010·\u0001\u001a\u0004\u0018\u00018\u0000H&¢\u0006\u0003\u0010¸\u0001J\u001a\u0010¹\u0001\u001a\u0002082\t\u0010·\u0001\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0003\u0010º\u0001J\n\u0010»\u0001\u001a\u00030\u008f\u0001H\u0002J\u0013\u0010¼\u0001\u001a\u00030\u008f\u00012\u0007\u0010½\u0001\u001a\u00020?H\u0016J\u0012\u0010¾\u0001\u001a\u0002082\u0007\u0010½\u0001\u001a\u00020?H\u0016J\u0019\u0010¿\u0001\u001a\u00030\u008f\u00012\r\u0010À\u0001\u001a\b\u0012\u0004\u0012\u00020g0fH\u0014J\n\u0010Á\u0001\u001a\u00030\u008f\u0001H\u0016J\u0016\u0010Ä\u0001\u001a\u00028\u00012\u0007\u0010Å\u0001\u001a\u00020!¢\u0006\u0003\u0010Æ\u0001J\u0016\u0010Ç\u0001\u001a\u00028\u00012\u0007\u0010È\u0001\u001a\u00020!¢\u0006\u0003\u0010Æ\u0001J\u0016\u0010É\u0001\u001a\u00028\u00012\u0007\u0010Ê\u0001\u001a\u00020!¢\u0006\u0003\u0010Æ\u0001J\u0016\u0010Ì\u0001\u001a\u00028\u00012\u0007\u0010Í\u0001\u001a\u00020!¢\u0006\u0003\u0010Æ\u0001J#\u0010Î\u0001\u001a\u00028\u00012\u0007\u0010Ï\u0001\u001a\u00020!2\t\b\u0002\u0010Ð\u0001\u001a\u000208H\u0007¢\u0006\u0003\u0010Ñ\u0001J\u0016\u0010Ò\u0001\u001a\u00028\u00012\u0007\u0010Ó\u0001\u001a\u000208¢\u0006\u0003\u0010Ô\u0001J\u001e\u0010Õ\u0001\u001a\u00030\u008f\u00012\u0007\u0010Ó\u0001\u001a\u0002082\t\b\u0002\u0010Ö\u0001\u001a\u000208H\u0017J\u0014\u0010Ù\u0001\u001a\u00030\u008f\u00012\n\u0010Ú\u0001\u001a\u0005\u0018\u00010Ø\u0001J&\u0010Û\u0001\u001a\u00030\u008f\u00012\u0007\u0010Ü\u0001\u001a\u0002082\u0007\u0010Ý\u0001\u001a\u00020g2\b\u0010Þ\u0001\u001a\u00030ß\u0001H\u0002J\u001a\u0010à\u0001\u001a\u00030\u008f\u00012\u000e\u0010á\u0001\u001a\t\u0012\u0004\u0012\u00020g0\u0095\u0001H\u0002J\u0018\u0010â\u0001\u001a\u00028\u00012\t\u0010Ú\u0001\u001a\u0004\u0018\u00010P¢\u0006\u0003\u0010ã\u0001J\u0017\u0010î\u0001\u001a\u00028\u00012\b\u0010ï\u0001\u001a\u00030å\u0001¢\u0006\u0003\u0010ð\u0001J\u0012\u0010ñ\u0001\u001a\u00030\u008f\u00012\b\u0010ò\u0001\u001a\u00030é\u0001J\u0012\u0010ó\u0001\u001a\u00030\u008f\u00012\b\u0010ò\u0001\u001a\u00030é\u0001J\u0011\u0010ô\u0001\u001a\u00030\u008f\u00012\u0007\u0010õ\u0001\u001a\u000208J\u0013\u0010ö\u0001\u001a\u00030\u008f\u00012\t\u0010Ú\u0001\u001a\u0004\u0018\u00010JJ\n\u0010÷\u0001\u001a\u00030\u008f\u0001H\u0002J\n\u0010ø\u0001\u001a\u00030\u008f\u0001H\u0002J\b\u0010ù\u0001\u001a\u00030\u008f\u0001J\u0017\u0010\u0080\u0002\u001a\u00028\u00012\b\u0010\u0081\u0002\u001a\u00030û\u0001¢\u0006\u0003\u0010\u0082\u0002J\n\u0010\u0083\u0002\u001a\u00030\u008f\u0001H\u0017J\u0014\u0010\u0084\u0002\u001a\u00030\u008f\u00012\b\u0010\u0085\u0002\u001a\u00030\u0086\u0002H\u0016J6\u0010\u0087\u0002\u001a\u00030\u008f\u00012\b\u0010\u0088\u0002\u001a\u00030\u0086\u00022\b\u0010\u0089\u0002\u001a\u00030\u0086\u00022\n\b\u0001\u0010\u008a\u0002\u001a\u00030\u008b\u00022\n\b\u0001\u0010\u008c\u0002\u001a\u00030\u008b\u0002H\u0004J\u0013\u0010\u008d\u0002\u001a\u00030\u008f\u00012\t\b\u0002\u0010\u008e\u0002\u001a\u000208J\n\u0010\u008f\u0002\u001a\u00030\u008f\u0001H\u0016J&\u0010\u0090\u0002\u001a\u00030\u008f\u00012\u0007\u0010\u0091\u0002\u001a\u00020g2\u0007\u0010Ü\u0001\u001a\u0002082\b\u0010\u0092\u0002\u001a\u00030\u008b\u0002H\u0016J\u0011\u0010\u0093\u0002\u001a\u00030\u008f\u00012\u0007\u0010\u0094\u0002\u001a\u000208J\u0013\u0010\u0095\u0002\u001a\u00030\u008f\u00012\u0007\u0010\u0096\u0002\u001a\u000208H\u0002J\b\u0010\u0097\u0002\u001a\u00030\u008f\u0001J\u001d\u0010\u0098\u0002\u001a\u00030\u008f\u00012\u0007\u0010\u0099\u0002\u001a\u00020!2\b\u0010\u009a\u0002\u001a\u00030\u008b\u0002H\u0014J\n\u0010\u009d\u0002\u001a\u00030\u008f\u0001H\u0002J\t\u0010\u009e\u0002\u001a\u000208H&J\u000e\u0010\u009f\u0002\u001a\t\u0012\u0004\u0012\u00020g0\u0095\u0001J\u0010\u0010 \u0002\u001a\t\u0012\u0004\u0012\u00020?0\u0095\u0001H\u0004J\u001a\u0010¡\u0002\u001a\t\u0012\u0004\u0012\u00020?0\u0095\u00012\b\u0010¢\u0002\u001a\u00030\u008b\u0002H\u0004J&\u0010£\u0002\u001a\u00030\u008f\u00012\u0007\u0010\u0091\u0002\u001a\u00020g2\u0007\u0010Ü\u0001\u001a\u0002082\b\u0010Þ\u0001\u001a\u00030ß\u0001H\u0004J\n\u0010¤\u0002\u001a\u00030\u008f\u0001H\u0002J\n\u0010¥\u0002\u001a\u00030\u008f\u0001H\u0017J\u0013\u0010¦\u0002\u001a\u00030\u008f\u00012\u0007\u0010¦\u0002\u001a\u000208H\u0004J\u001b\u0010§\u0002\u001a\u00030\u008f\u00012\u0011\u0010¨\u0002\u001a\f\u0012\u0006\b\u0001\u0012\u00020g\u0018\u00010fJ\u0019\u0010©\u0002\u001a\u00030\u008f\u00012\u000f\u0010ª\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020g0fJ\u000f\u0010«\u0002\u001a\u00028\u0001H\u0004¢\u0006\u0003\u0010¬\u0002J\u0016\u0010\u00ad\u0002\u001a\u00028\u00012\u0007\u0010®\u0002\u001a\u00020p¢\u0006\u0003\u0010¯\u0002J\u0014\u0010°\u0002\u001a\u00030\u008f\u00012\b\u0010±\u0002\u001a\u00030²\u0002H\u0016J\u001d\u0010³\u0002\u001a\u00030\u008f\u00012\u0011\u0010´\u0002\u001a\f\u0012\u0005\u0012\u00030µ\u0002\u0018\u00010\u0095\u0001H\u0016J\u001b\u0010¶\u0002\u001a\u00028\u00012\n\u0010·\u0002\u001a\u0005\u0018\u00010\u0088\u0001H\u0016¢\u0006\u0003\u0010¸\u0002J\n\u0010¹\u0002\u001a\u00030\u008f\u0001H\u0014J&\u0010º\u0002\u001a\u00030\u008f\u00012\u001a\u0010»\u0002\u001a\u0015\u0012\u0005\u0012\u00030\u008b\u0002\u0012\t\u0012\u0007\u0012\u0002\b\u00030½\u00020¼\u0002H\u0016J\u0019\u0010¾\u0002\u001a\u00028\u00012\b\u0010¿\u0002\u001a\u00030À\u0002H\u0016¢\u0006\u0003\u0010Á\u0002J\u000f\u0010Â\u0002\u001a\u00028\u0001H\u0016¢\u0006\u0003\u0010¬\u0002J\u0007\u0010Ã\u0002\u001a\u00020?J\u0007\u0010Ä\u0002\u001a\u00020\u0014J\b\u0010Å\u0002\u001a\u00030\u0088\u0001J&\u0010Æ\u0002\u001a\u00030\u008f\u00012\u001c\u0010Ç\u0002\u001a\u0017\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020?\u0012\u0005\u0012\u00030É\u00020È\u00020\u0095\u0001J>\u0010Ê\u0002\u001a \u0012\u0004\u0012\u00020?\u0012\u0004\u0012\u00020g0Ë\u0002j\u000f\u0012\u0004\u0012\u00020?\u0012\u0004\u0012\u00020g`Ì\u00022\u000e\u0010Í\u0002\u001a\t\u0012\u0004\u0012\u00020?0\u0095\u0001H\u0082@¢\u0006\u0003\u0010Î\u0002J>\u0010Ï\u0002\u001a \u0012\u0004\u0012\u00020?\u0012\u0004\u0012\u00020g0Ë\u0002j\u000f\u0012\u0004\u0012\u00020?\u0012\u0004\u0012\u00020g`Ì\u00022\u000e\u0010Ð\u0002\u001a\t\u0012\u0004\u0012\u00020?0\u0095\u0001H\u0082@¢\u0006\u0003\u0010Î\u0002J\u001c\u0010Ñ\u0002\u001a\u00030\u008f\u00012\u0012\u0010Ò\u0002\u001a\r\u0012\u0006\b\u0001\u0012\u00020g\u0018\u00010\u0095\u0001J\u001f\u0010Ù\u0002\u001a\u00028\u00012\u0010\u0010Ú\u0002\u001a\u000b\u0012\u0004\u0012\u00028\u0000\u0018\u00010Ô\u0002¢\u0006\u0003\u0010Û\u0002J\u0017\u0010â\u0002\u001a\u00028\u00012\b\u0010ã\u0002\u001a\u00030Ý\u0002¢\u0006\u0003\u0010ä\u0002J\u0017\u0010ë\u0002\u001a\u00028\u00012\b\u0010ì\u0002\u001a\u00030æ\u0002¢\u0006\u0003\u0010í\u0002J\u0016\u0010ñ\u0002\u001a\u00028\u00012\u0007\u0010ò\u0002\u001a\u000208¢\u0006\u0003\u0010Ô\u0001J\u0011\u0010ó\u0002\u001a\u00030\u008f\u00012\u0007\u0010\u0091\u0002\u001a\u00020gJ\u0011\u0010©\u0002\u001a\u00030\u008f\u00012\u0007\u0010\u0091\u0002\u001a\u00020gJ\u0019\u0010ô\u0002\u001a\u00028\u00012\n\b\u0001\u0010õ\u0002\u001a\u00030\u008b\u0002¢\u0006\u0003\u0010ö\u0002J\u0016\u0010ô\u0002\u001a\u00028\u00012\u0007\u0010õ\u0002\u001a\u00020?¢\u0006\u0003\u0010÷\u0002J)\u0010ø\u0002\u001a\u00028\u00012\f\b\u0003\u0010ù\u0002\u001a\u0005\u0018\u00010\u008b\u00022\f\b\u0002\u0010ú\u0002\u001a\u0005\u0018\u00010û\u0002¢\u0006\u0003\u0010ü\u0002J\u0016\u0010ý\u0002\u001a\u00028\u00012\u0007\u0010þ\u0002\u001a\u000208¢\u0006\u0003\u0010Ô\u0001J\u0011\u0010ÿ\u0002\u001a\u00030\u008f\u00012\u0007\u0010\u0080\u0003\u001a\u000208J\u0016\u0010\u0081\u0003\u001a\u00028\u00012\u0007\u0010\u0084\u0001\u001a\u000208¢\u0006\u0003\u0010Ô\u0001J\u0011\u0010\u0082\u0003\u001a\u00030\u008f\u00012\u0007\u0010\u0083\u0003\u001a\u00020!J\u0016\u0010\u0087\u0003\u001a\u00028\u00012\u0007\u0010\u0084\u0003\u001a\u00020?¢\u0006\u0003\u0010÷\u0002J\u0016\u0010\u0088\u0003\u001a\u00028\u00012\u0007\u0010\u0089\u0003\u001a\u000208¢\u0006\u0003\u0010Ô\u0001J\u0015\u0010\u008a\u0003\u001a\u00028\u00012\u0006\u0010_\u001a\u000208¢\u0006\u0003\u0010Ô\u0001J\u0016\u0010\u008b\u0003\u001a\u00028\u00012\u0007\u0010\u008c\u0003\u001a\u000208¢\u0006\u0003\u0010Ô\u0001J\u0010\u0010\u008d\u0003\u001a\u00030\u008f\u00012\u0006\u0010A\u001a\u000208J\u001e\u0010\u008e\u0003\u001a\u00028\u00012\u000f\u0010\u0094\u0001\u001a\n\u0012\u0005\u0012\u00030\u0096\u00010\u0095\u0001¢\u0006\u0003\u0010\u008f\u0003J\b\u0010\u0090\u0003\u001a\u00030\u008f\u0001J\n\u0010\u0091\u0003\u001a\u00030\u008f\u0001H\u0017J\n\u0010\u0092\u0003\u001a\u00030\u008f\u0001H\u0017J\u001c\u0010ª\u0002\u001a\u00030\u008f\u00012\u0010\u0010ª\u0002\u001a\u000b\u0012\u0004\u0012\u00020g\u0018\u00010\u0095\u0001H\u0002J\n\u0010\u0093\u0003\u001a\u00030\u008f\u0001H\u0007J\u0007\u0010\u0094\u0003\u001a\u000208J\b\u0010\u0095\u0003\u001a\u00030\u008f\u0001J\n\u0010\u0096\u0003\u001a\u0005\u0018\u00010\u0097\u0003J\u0011\u0010\u0098\u0003\u001a\u00030\u008f\u00012\u0007\u0010Ú\u0001\u001a\u00020FJ\u0011\u0010\u0099\u0003\u001a\u00030\u008f\u00012\u0007\u0010Ú\u0001\u001a\u00020FJ\u0011\u0010\u009a\u0003\u001a\u00030\u008f\u00012\u0007\u0010Ú\u0001\u001a\u00020HJ\u0013\u0010\u009b\u0003\u001a\u00030\u008f\u00012\u0007\u0010\u009c\u0003\u001a\u00020gH\u0014R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u00020\u0014X\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u001aX\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u000e\u0010\u001f\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010#\u001a\u00020$X\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010)\u001a\u00020\u0004X\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u000e\u0010.\u001a\u00020/X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u000201X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020!X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020!X\u0082.¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u000206X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u000208X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00109\u001a\b\u0012\u0004\u0012\u00020\u000e0:X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u000208X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020=X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020?X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020?X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u000208X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010B\u001a\u0004\u0018\u00018\u0000X\u0082\u000e¢\u0006\u0004\n\u0002\u0010CR\u0014\u0010D\u001a\b\u0012\u0004\u0012\u00020F0EX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010G\u001a\u0004\u0018\u00010HX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010I\u001a\u0004\u0018\u00010JX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\u0010\u0010O\u001a\u0004\u0018\u00010PX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010Q\u001a\u00020RX\u0082\u0004¢\u0006\u0004\n\u0002\u0010SR$\u0010U\u001a\u0002082\u0006\u0010T\u001a\u000208@DX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR\u001a\u0010Z\u001a\u000208X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010W\"\u0004\b[\u0010YR\u001a\u0010\\\u001a\u000208X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b]\u0010W\"\u0004\b^\u0010YR\u001a\u0010_\u001a\u000208X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b`\u0010W\"\u0004\ba\u0010YR\u001a\u0010b\u001a\u000208X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bc\u0010W\"\u0004\bd\u0010YR \u0010e\u001a\b\u0012\u0004\u0012\u00020g0fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bh\u0010i\"\u0004\bj\u0010kR\u001a\u0010l\u001a\u000208X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bm\u0010W\"\u0004\bn\u0010YR\u001c\u0010o\u001a\u0004\u0018\u00010pX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bq\u0010r\"\u0004\bs\u0010tR\u001a\u0010u\u001a\u00020vX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bw\u0010x\"\u0004\by\u0010zR\u001a\u0010{\u001a\u00020vX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b|\u0010x\"\u0004\b}\u0010zR \u0010~\u001a\u0004\u0018\u00010\u007fX\u0084\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0080\u0001\u0010\u0081\u0001\"\u0006\b\u0082\u0001\u0010\u0083\u0001R\u000f\u0010\u0084\u0001\u001a\u000208X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u0085\u0001\u001a\u000208X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0085\u0001\u0010W\"\u0005\b\u0086\u0001\u0010YR\u001d\u0010\u0087\u0001\u001a\t\u0012\u0005\u0012\u00030\u0088\u00010fX\u0084\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0089\u0001\u0010iR\u0010\u0010\u008a\u0001\u001a\u00030\u008b\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u008c\u0001\u001a\u0005\u0018\u00010\u008d\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0091\u0001\u001a\u00030\u0088\u0001X\u0084\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u0092\u0001\u0010\u0093\u0001R'\u0010\u0094\u0001\u001a\f\u0012\u0005\u0012\u00030\u0096\u0001\u0018\u00010\u0095\u0001X\u0084\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0097\u0001\u0010i\"\u0005\b\u0098\u0001\u0010kR\u000f\u0010¡\u0001\u001a\u000208X\u0082\u000e¢\u0006\u0002\n\u0000R\u001f\u0010¢\u0001\u001a\u00020?X\u0084\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b£\u0001\u0010¤\u0001\"\u0006\b¥\u0001\u0010¦\u0001R\u000f\u0010Â\u0001\u001a\u000208X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010Ã\u0001\u001a\u000208X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010Ë\u0001\u001a\u000208X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010×\u0001\u001a\u0005\u0018\u00010Ø\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010ä\u0001\u001a\u000b\u0012\u0005\u0012\u00030å\u0001\u0018\u00010fX\u0084\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bæ\u0001\u0010i\"\u0005\bç\u0001\u0010kR(\u0010è\u0001\u001a\u000b\u0012\u0005\u0012\u00030é\u0001\u0018\u00010EX\u0084\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bê\u0001\u0010ë\u0001\"\u0006\bì\u0001\u0010í\u0001R\"\u0010ú\u0001\u001a\u0005\u0018\u00010û\u0001X\u0084\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bü\u0001\u0010ý\u0001\"\u0006\bþ\u0001\u0010ÿ\u0001R\u000f\u0010\u009b\u0002\u001a\u000208X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u009c\u0002\u001a\u000208X\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010Ó\u0002\u001a\u000b\u0012\u0004\u0012\u00028\u0000\u0018\u00010Ô\u0002X\u0084\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÕ\u0002\u0010Ö\u0002\"\u0006\b×\u0002\u0010Ø\u0002R \u0010Ü\u0002\u001a\u00030Ý\u0002X\u0084\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÞ\u0002\u0010ß\u0002\"\u0006\bà\u0002\u0010á\u0002R \u0010å\u0002\u001a\u00030æ\u0002X\u0084\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bç\u0002\u0010è\u0002\"\u0006\bé\u0002\u0010ê\u0002R\u001d\u0010î\u0002\u001a\u000208X\u0084\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bï\u0002\u0010W\"\u0005\bð\u0002\u0010YR\u001f\u0010\u0084\u0003\u001a\u00020?X\u0084\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0085\u0003\u0010¤\u0001\"\u0006\b\u0086\u0003\u0010¦\u0001¨\u0006¨\u0003"}, d2 = {"Lcom/ss/android/lark/picker/base/widget/BasePicker;", "P", "Lcom/ss/android/lark/picker/base/widget/params/BasePickerParams;", "PK", "Landroid/widget/FrameLayout;", "Landroidx/lifecycle/LifecycleObserver;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "oldSearchResponseFromSpotlight", "Lcom/ss/android/lark/search/dto/SearchResponse;", "mContext", "scope", "Lkotlinx/coroutines/CoroutineScope;", "searchHeaderContainer", "mSearchInputView", "Lcom/ss/android/lark/search/baseview/SearchInputView;", "getMSearchInputView", "()Lcom/ss/android/lark/search/baseview/SearchInputView;", "setMSearchInputView", "(Lcom/ss/android/lark/search/baseview/SearchInputView;)V", "cancelView", "Landroid/widget/TextView;", "getCancelView", "()Landroid/widget/TextView;", "setCancelView", "(Landroid/widget/TextView;)V", "mSearchCenterContainer", "mSearchTopContainer", "Landroid/view/View;", "mSearchTopContainerFl", "mSearchResultView", "Lcom/ss/android/lark/picker/base/view/SearchResultView;", "getMSearchResultView", "()Lcom/ss/android/lark/picker/base/view/SearchResultView;", "setMSearchResultView", "(Lcom/ss/android/lark/picker/base/view/SearchResultView;)V", "mDefaultViewContainer", "getMDefaultViewContainer", "()Landroid/widget/FrameLayout;", "setMDefaultViewContainer", "(Landroid/widget/FrameLayout;)V", "mSelectedView", "Landroidx/constraintlayout/widget/ConstraintLayout;", "mSelectedRV", "Lcom/ss/android/lark/widget/recyclerview/CommonRecyclerView;", "mSelectedMore", "mSelectedDivider", "mSelectedCountTV", "mSelectedAdapter", "Lcom/ss/android/lark/picker/base/widget/selectedview/SelectedAdapter;", "useDoubaoSelectedMoreStyle", "", "mCallback", "Lcom/larksuite/framework/callback/IGetDataCallback;", "mHasMore", "mOnLoadMore", "Lcom/ss/android/lark/picker/base/view/SearchResultView$IOnLoadMore;", "mRequestId", "", "spotlightRequestId", "enableAutoFocus", "mPickerParams", "Lcom/ss/android/lark/picker/base/widget/params/BasePickerParams;", "onSelectModeChangeListeners", "", "Lcom/ss/android/lark/picker/base/widget/BasePicker$IOnSelectModeChangeListener;", "onPickModeChangeListener", "Lcom/ss/android/lark/picker/base/widget/BasePicker$IOnPickModeChangeListener;", "onCancelListener", "Lcom/ss/android/lark/picker/base/widget/BasePicker$IOnCancelListener;", "getOnCancelListener", "()Lcom/ss/android/lark/picker/base/widget/BasePicker$IOnCancelListener;", "setOnCancelListener", "(Lcom/ss/android/lark/picker/base/widget/BasePicker$IOnCancelListener;)V", "onSearchErrorRetryClickListener", "Lcom/ss/android/lark/picker/base/widget/BasePicker$OnSearchErrorRetryClickListener;", "keyboardSelectionUIDependency", "com/ss/android/lark/picker/base/widget/BasePicker$keyboardSelectionUIDependency$1", "Lcom/ss/android/lark/picker/base/widget/BasePicker$keyboardSelectionUIDependency$1;", "value", "mIsMultiple", "getMIsMultiple", "()Z", "setMIsMultiple", "(Z)V", "isClearWhenSingleSelect", "setClearWhenSingleSelect", "mIsEnableChatPreview", "getMIsEnableChatPreview", "setMIsEnableChatPreview", "disableRightViewHolder", "getDisableRightViewHolder", "setDisableRightViewHolder", "forceNotifyDataSetChangedOnRefreshResult", "getForceNotifyDataSetChangedOnRefreshResult", "setForceNotifyDataSetChangedOnRefreshResult", "mSelectedList", "", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "getMSelectedList", "()Ljava/util/List;", "setMSelectedList", "(Ljava/util/List;)V", "mIsSearch", "getMIsSearch", "setMIsSearch", "mReporterDelegate", "Lcom/ss/android/lark/picker/base/widget/reporter/PickerReporterDelegate;", "getMReporterDelegate", "()Lcom/ss/android/lark/picker/base/widget/reporter/PickerReporterDelegate;", "setMReporterDelegate", "(Lcom/ss/android/lark/picker/base/widget/reporter/PickerReporterDelegate;)V", "mSearchLifecycleObserver", "Lcom/ss/android/lark/search/dto/service/ISearchLifecycleObserver;", "getMSearchLifecycleObserver", "()Lcom/ss/android/lark/search/dto/service/ISearchLifecycleObserver;", "setMSearchLifecycleObserver", "(Lcom/ss/android/lark/search/dto/service/ISearchLifecycleObserver;)V", "mSearchLifecycleObserver4Spotlight", "getMSearchLifecycleObserver4Spotlight", "setMSearchLifecycleObserver4Spotlight", "extras", "Landroid/os/Bundle;", "getExtras", "()Landroid/os/Bundle;", "setExtras", "(Landroid/os/Bundle;)V", "isLightStyle", "isPickerV2", "setPickerV2", "itemConsumes", "Lcom/ss/android/lark/picker/base/view/SearchResultView$IOnBusinessConsumeItem;", "getItemConsumes", "mCustomSearchResultItemManager", "Lcom/ss/android/lark/picker/base/widget/CustomSearchResultItemManager;", "searchResultAdapter", "Lcom/ss/android/lark/picker/base/widget/SearchResultAdapter;", "attachSearchResultAdapter", "", "adapter", "itemConsumeDelegate", "getItemConsumeDelegate", "()Lcom/ss/android/lark/picker/base/view/SearchResultView$IOnBusinessConsumeItem;", "permissions", "", "Lcom/bytedance/lark/pb/basic/v1/ActionType;", "getPermissions", "setPermissions", "initPicker", "selectedRvBg2Doubao", "handleSearchError", "err", "Lcom/larksuite/framework/callback/Entity/ErrorResult;", "handleSearchResponse", "response", "isFromSpotlight", "mInitSearch", "mSearchQuery", "getMSearchQuery", "()Ljava/lang/String;", "setMSearchQuery", "(Ljava/lang/String;)V", "searchWithSpotlightAndNet", "requestId", "queryKey", "getSpotlightSearchResult", "searchContext", "Lcom/ss/android/lark/search/dto/service/SearchContext;", "(Ljava/lang/String;Lcom/ss/android/lark/search/dto/service/SearchContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getNetSearchResult", "initialSearch", "customSearch", "callback", "transform2SearchContext", "transform2SearchContext4Spotlight", "spotlightPickerParam", "(Ljava/lang/String;Lcom/ss/android/lark/picker/base/widget/params/BasePickerParams;)Lcom/ss/android/lark/search/dto/service/SearchContext;", "transformByPickerParams", "pickerParams", "(Lcom/ss/android/lark/search/dto/service/SearchContext;Lcom/ss/android/lark/picker/base/widget/params/BasePickerParams;)Lcom/ss/android/lark/search/dto/service/SearchContext;", "spotLightSupportable", "(Lcom/ss/android/lark/picker/base/widget/params/BasePickerParams;)Z", "loadMore", "onStartSearch", AppbrandHostConstants.Schema_RESERVED_FIELD.QUERY, "onSearchEmpty", "onSearchSuccess", "infoList", "onSearchError", "mCenterCustomViewAttached", "mSelectedCustomViewAttached", "attachCenterCustomView", "centerView", "(Landroid/view/View;)Lcom/ss/android/lark/picker/base/widget/BasePicker;", "attachSelectedCustomView", "selectedView", "attachRecommendView", "view", "mTopCustomViewAttached", "attachHeaderCustomView", "headerView", "attachTopCustomView", "topView", "showSectionDivider", "(Landroid/view/View;Z)Lcom/ss/android/lark/picker/base/widget/BasePicker;", "attachMultiple", "isMultiple", "(Z)Lcom/ss/android/lark/picker/base/widget/BasePicker;", "switchMultipleStatus", "isForce", "mOnSelectedStatusChangeListener", "Lcom/ss/android/lark/picker/base/widget/BasePicker$IOnSelectedStatusChangeListener;", "setOnSelectedStatusChangeListener", "listener", "notifySelect", "isSelected", "info", "pickSourceType", "Lcom/ss/android/lark/picker/base/widget/BasePicker$PickSourceType;", "notifySelected", "infos", "attachOnSearchErrorRetryClickListener", "(Lcom/ss/android/lark/picker/base/widget/BasePicker$OnSearchErrorRetryClickListener;)Lcom/ss/android/lark/picker/base/widget/BasePicker;", "mOnPickNotifyList", "Lcom/ss/android/lark/picker/base/widget/BasePicker$IOnPickNotify;", "getMOnPickNotifyList", "setMOnPickNotifyList", "pickNotifies", "Lcom/ss/android/lark/picker/base/widget/BasePicker$IOnPickNotifyV2;", "getPickNotifies", "()Ljava/util/Set;", "setPickNotifies", "(Ljava/util/Set;)V", "attachOnPickerNotify", "onPickNotify", "(Lcom/ss/android/lark/picker/base/widget/BasePicker$IOnPickNotify;)Lcom/ss/android/lark/picker/base/widget/BasePicker;", "addOnPickNotifyV2", "onPickNotifyV2", "removeOnPickNotifyV2", "enableCancelView", "isEnable", "attachOnCancelListener", "refreshAll", "refreshSelectedView", "refreshResult", "mDependency", "Lcom/ss/android/lark/picker/base/widget/BasePicker$IViewDependency;", "getMDependency", "()Lcom/ss/android/lark/picker/base/widget/BasePicker$IViewDependency;", "setMDependency", "(Lcom/ss/android/lark/picker/base/widget/BasePicker$IViewDependency;)V", "attachDependency", "dependency", "(Lcom/ss/android/lark/picker/base/widget/BasePicker$IViewDependency;)Lcom/ss/android/lark/picker/base/widget/BasePicker;", "attachComplete", "showFragment", "fragment", "Lcom/ss/android/lark/base/fragment/BaseFragment;", "switchFragmentWithAnimations", "currentFragment", "targetFragment", "enterAnimation", "", "exitAnimation", "defaultMode", "softInputPopUp", "refreshDefault", "doItemClick", "data", "position", "resetFocus", "needResetKeyboardNavigation", "switchKeyboardNavigation", "isSearchMode", "searchMode", "onVisibilityChanged", "changedView", "visibility", "wasVisible", "isFirstTime", "checkVisibilityChange", "onBackPressed", "getSelectedList", "getSelectedIds", "getSelectedIdsByType", "type", "dealSelectAndDeselected", "updateSelectedCount", "destroy", "disableExternalChatter", "resetSelectedData", "selectedData", "removeSelectedData", "removeData", "self", "()Lcom/ss/android/lark/picker/base/widget/BasePicker;", "attachReporterDelegate", "reporterDelegate", "(Lcom/ss/android/lark/picker/base/widget/reporter/PickerReporterDelegate;)Lcom/ss/android/lark/picker/base/widget/BasePicker;", "setCustomBinder", "customBinder", "Lcom/ss/android/lark/picker/base/view/binder/ICustomBinder;", "setCustomViewTypeResolvers", "resolvers", "Lcom/ss/android/lark/picker/base/view/binder/ICustomViewTypeResolver;", "attachOnBusinessConsumeItem", "onBusinessConsumeItem", "(Lcom/ss/android/lark/picker/base/view/SearchResultView$IOnBusinessConsumeItem;)Lcom/ss/android/lark/picker/base/widget/BasePicker;", "initItemConsumer", "registerSearchCustomBinders", "customBinders", "", "Lcom/ss/android/lark/picker/base/view/binder/CommonBinder;", "attachCustomSearchResultItem", "customItem", "Lcom/ss/android/lark/picker/base/widget/CustomSearchResultItem;", "(Lcom/ss/android/lark/picker/base/widget/CustomSearchResultItem;)Lcom/ss/android/lark/picker/base/widget/BasePicker;", "clearCustomSearchResultItems", "getQuery", "getSearchInputView", "getBusinessConsumeDelegate", "updatePreSelectedListByIds", "preSelectedIdList", "Lkotlin/Pair;", "Lcom/ss/android/lark/search/dto/EntityType;", "getSearchEntityByChatIds", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "chatIds", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSearchEntityByChatterIds", "chatterIds", "updatePreSelectedList", "preSelectedList", "mOnPickerParamsLoader", "Lcom/ss/android/lark/picker/base/widget/BasePicker$OnPickerParamsLoader;", "getMOnPickerParamsLoader", "()Lcom/ss/android/lark/picker/base/widget/BasePicker$OnPickerParamsLoader;", "setMOnPickerParamsLoader", "(Lcom/ss/android/lark/picker/base/widget/BasePicker$OnPickerParamsLoader;)V", "attachOnPickerParamsLoader", "onPickerParamsLoader", "(Lcom/ss/android/lark/picker/base/widget/BasePicker$OnPickerParamsLoader;)Lcom/ss/android/lark/picker/base/widget/BasePicker;", "mPickerUsePage", "Lcom/ss/android/lark/picker/base/widget/constants/PickerUsePage;", "getMPickerUsePage", "()Lcom/ss/android/lark/picker/base/widget/constants/PickerUsePage;", "setMPickerUsePage", "(Lcom/ss/android/lark/picker/base/widget/constants/PickerUsePage;)V", "attachUsePage", "usePage", "(Lcom/ss/android/lark/picker/base/widget/constants/PickerUsePage;)Lcom/ss/android/lark/picker/base/widget/BasePicker;", "mPickerUseCategory", "Lcom/ss/android/lark/picker/base/widget/constants/PickerUseCategory;", "getMPickerUseCategory", "()Lcom/ss/android/lark/picker/base/widget/constants/PickerUseCategory;", "setMPickerUseCategory", "(Lcom/ss/android/lark/picker/base/widget/constants/PickerUseCategory;)V", "attachUseCategory", "useCategory", "(Lcom/ss/android/lark/picker/base/widget/constants/PickerUseCategory;)Lcom/ss/android/lark/picker/base/widget/BasePicker;", "mSoftInputInitPopup", "getMSoftInputInitPopup", "setMSoftInputInitPopup", "attachSoftInputInitPopup", "softInputInitPopup", "addSelectedData", "attachSearchHintText", "hint", "(I)Lcom/ss/android/lark/picker/base/widget/BasePicker;", "(Ljava/lang/String;)Lcom/ss/android/lark/picker/base/widget/BasePicker;", "attachSearchEmptyViewConfig", "emptyIconResId", "emptyHintText", "", "(Ljava/lang/Integer;Ljava/lang/CharSequence;)Lcom/ss/android/lark/picker/base/widget/BasePicker;", "attachConsumeResultLayoutClickWhenEmpty", "consume", "setDefaultContainerHideKeyboardOnTouch", "enabled", "attachChatCountStyle", "setHeadCustomView", "customView", "scene", "getScene", "setScene", "attachScene", "attachIsEnableChatPreview", "isEnableChatPreview", "attachDisableRightViewHolder", "attachForceRefreshResultNotifyDataSetChanged", "force", "attachEnableAutoFocus", "attachPermissions", "(Ljava/util/List;)Lcom/ss/android/lark/picker/base/widget/BasePicker;", "requestInputFocus", "onResume", "onCreate", "onStop", "isMultipleSelect", "startSelectedListActivity", "prepareForResultFragment", "Lcom/ss/android/lark/picker/base/widget/ForResultFragment;", "addSelectModeChangeListener", "removeSelectModeChangeListener", "setPickModeChangeListener", "onSearchHistoryRecordNeeded", "baseInfo", "Companion", "IOnSelectedStatusChangeListener", "IOnPickNotify", "IOnPickNotifyV2", "PickSourceType", "IOnSelectModeChangeListener", "IOnPickModeChangeListener", "IOnCancelListener", "OnSearchErrorRetryClickListener", "IViewDependency", "OnPickerParamsLoader", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public abstract class BasePicker<P extends BasePickerParams, PK extends BasePicker<P, PK>> extends FrameLayout implements LifecycleObserver {
    public static final Companion Companion = null;
    private static final String KEY_SCENE = "key_scene";
    public static final String RECOMMEND_FRAGMENT_TAG = "RecommendFragment";
    private static final List<SearchBaseInfo> REMOVED_DATA = null;
    public static final String SELECTED_MORE_REMOVED = "selected.removed";
    public static final int SELECTED_MORE_REQUEST_CODE = 1;
    private static final String TAG = "LarkSearch.SearchWidget.BasePicker";
    private static final String TAG_FOR_RESULT_FRAGMENT = "forResultFragment";
    private static final String TAG_SPOT = "BasePicker_spotlight";
    protected TextView cancelView;
    private boolean disableRightViewHolder;
    private boolean enableAutoFocus;
    private Bundle extras;
    private boolean forceNotifyDataSetChangedOnRefreshResult;
    private boolean isClearWhenSingleSelect;
    private boolean isFirstTime;
    private boolean isLightStyle;
    private boolean isPickerV2;
    private final SearchResultView.IOnBusinessConsumeItem itemConsumeDelegate;
    private final List<SearchResultView.IOnBusinessConsumeItem> itemConsumes;
    private final BasePicker$keyboardSelectionUIDependency$1 keyboardSelectionUIDependency;
    private IGetDataCallback<SearchResponse> mCallback;
    private boolean mCenterCustomViewAttached;
    private Context mContext;
    private final CustomSearchResultItemManager mCustomSearchResultItemManager;
    protected FrameLayout mDefaultViewContainer;
    private IViewDependency mDependency;
    private boolean mHasMore;
    private boolean mInitSearch;
    private boolean mIsEnableChatPreview;
    private boolean mIsMultiple;
    private boolean mIsSearch;
    private SearchResultView.IOnLoadMore mOnLoadMore;
    private List<IOnPickNotify> mOnPickNotifyList;
    private OnPickerParamsLoader<P> mOnPickerParamsLoader;
    private IOnSelectedStatusChangeListener mOnSelectedStatusChangeListener;
    private P mPickerParams;
    private PickerUseCategory mPickerUseCategory;
    private PickerUsePage mPickerUsePage;
    private PickerReporterDelegate mReporterDelegate;
    private String mRequestId;
    private FrameLayout mSearchCenterContainer;
    protected SearchInputView mSearchInputView;
    private a mSearchLifecycleObserver;
    private a mSearchLifecycleObserver4Spotlight;
    private String mSearchQuery;
    protected SearchResultView mSearchResultView;
    private View mSearchTopContainer;
    private FrameLayout mSearchTopContainerFl;
    private SelectedAdapter mSelectedAdapter;
    private TextView mSelectedCountTV;
    private boolean mSelectedCustomViewAttached;
    private View mSelectedDivider;
    private List<SearchBaseInfo> mSelectedList;
    private View mSelectedMore;
    private CommonRecyclerView mSelectedRV;
    private ConstraintLayout mSelectedView;
    private boolean mSoftInputInitPopup;
    private boolean mTopCustomViewAttached;
    private SearchResponse oldSearchResponseFromSpotlight;
    private IOnCancelListener onCancelListener;
    private IOnPickModeChangeListener onPickModeChangeListener;
    private OnSearchErrorRetryClickListener onSearchErrorRetryClickListener;
    private final Set<IOnSelectModeChangeListener> onSelectModeChangeListeners;
    private List<? extends ActionType> permissions;
    private Set<IOnPickNotifyV2> pickNotifies;
    private String scene;
    private final CoroutineScope scope;
    private FrameLayout searchHeaderContainer;
    private SearchResultAdapter searchResultAdapter;
    private String spotlightRequestId;
    private boolean useDoubaoSelectedMoreStyle;
    private boolean wasVisible;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/picker/base/widget/BasePicker$Companion;", "", "<init>", "()V", "TAG", "", "KEY_SCENE", "TAG_FOR_RESULT_FRAGMENT", "SELECTED_MORE_REQUEST_CODE", "", "SELECTED_MORE_REMOVED", "RECOMMEND_FRAGMENT_TAG", "TAG_SPOT", "REMOVED_DATA", "", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "getREMOVED_DATA", "()Ljava/util/List;", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final List<SearchBaseInfo> getREMOVED_DATA() {
            return BasePicker.access$getREMOVED_DATA$cp();
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/ss/android/lark/picker/base/widget/BasePicker$IOnCancelListener;", "", "onCanceled", "", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public interface IOnCancelListener {
        void onCanceled();
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/picker/base/widget/BasePicker$IOnPickModeChangeListener;", "", "onPickModeChanged", "", "isSearchMode", "", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public interface IOnPickModeChangeListener {
        void onPickModeChanged(boolean r1);
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010!\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J$\u0010\n\u001a\u00020\u00052\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\u000eH&J\u0018\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\u0010"}, d2 = {"Lcom/ss/android/lark/picker/base/widget/BasePicker$IOnPickNotify;", "", "<init>", "()V", "onSelected", "", "id", "", "info", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "onChanged", "ids", "", "infoList", "", "onDeSelected", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static abstract class IOnPickNotify {
        public IOnPickNotify() {
        }

        public abstract void onChanged(List<String> r1, List<SearchBaseInfo> r2);

        public void onDeSelected(String r2, SearchBaseInfo r3) {
            Intrinsics.checkNotNullParameter(r2, "id");
            Intrinsics.checkNotNullParameter(r3, "info");
        }

        public abstract void onSelected(String r1, SearchBaseInfo r2);
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J$\u0010\f\u001a\u00020\u00052\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\u000eH&J \u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\u0011"}, d2 = {"Lcom/ss/android/lark/picker/base/widget/BasePicker$IOnPickNotifyV2;", "", "<init>", "()V", "onSelected", "", "id", "", "info", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "pickSourceType", "Lcom/ss/android/lark/picker/base/widget/BasePicker$PickSourceType;", "onChanged", "ids", "", "infoList", "onDeSelected", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static abstract class IOnPickNotifyV2 {
        public IOnPickNotifyV2() {
        }

        public abstract void onChanged(List<String> r1, List<? extends SearchBaseInfo> r2);

        public void onDeSelected(String r2, SearchBaseInfo r3, PickSourceType r4) {
            Intrinsics.checkNotNullParameter(r2, "id");
            Intrinsics.checkNotNullParameter(r3, "info");
            Intrinsics.checkNotNullParameter(r4, "pickSourceType");
        }

        public abstract void onSelected(String r1, SearchBaseInfo r2, PickSourceType r3);
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/picker/base/widget/BasePicker$IOnSelectModeChangeListener;", "", "onSelectModeChanged", "", "isMultipleSelect", "", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public interface IOnSelectModeChangeListener {
        void onSelectModeChanged(boolean r1);
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/picker/base/widget/BasePicker$IOnSelectedStatusChangeListener;", "", "onSelectedStatusChange", "", "hasSelected", "", "selectedCount", "", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public interface IOnSelectedStatusChangeListener {
        void onSelectedStatusChange(boolean r1, int r2);
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/picker/base/widget/BasePicker$IViewDependency;", "", "getActivity", "Landroid/app/Activity;", "getFragmentManager", "Landroidx/fragment/app/FragmentManager;", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public interface IViewDependency {
        Activity getActivity();

        FragmentManager getFragmentManager();
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\bf\u0018\u0000*\u0004\b\u0002\u0010\u00012\u00020\u0002J\r\u0010\u0003\u001a\u00028\u0002H&¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/ss/android/lark/picker/base/widget/BasePicker$OnPickerParamsLoader;", "P", "", "onLoadPickerParams", "()Ljava/lang/Object;", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public interface OnPickerParamsLoader<P> {
        P onLoadPickerParams();
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/picker/base/widget/BasePicker$OnSearchErrorRetryClickListener;", "", "onRetryClick", "", AppbrandHostConstants.Schema_RESERVED_FIELD.QUERY, "", "err", "Lcom/larksuite/framework/callback/Entity/ErrorResult;", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public interface OnSearchErrorRetryClickListener {
        void onRetryClick(String r1, ErrorResult r2);
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/picker/base/widget/BasePicker$PickSourceType;", "", "<init>", "(Ljava/lang/String;I)V", "PRESELECT", "CLICK", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final enum PickSourceType extends Enum<PickSourceType> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ PickSourceType[] $VALUES = null;
        public static final PickSourceType CLICK = null;
        public static final PickSourceType PRESELECT = null;

        private static final /* synthetic */ PickSourceType[] $values() {
            return new PickSourceType[]{PRESELECT, CLICK};
        }

        public static EnumEntries<PickSourceType> getEntries() {
            return $ENTRIES;
        }

        static {
            PRESELECT = new PickSourceType("PRESELECT", 0);
            CLICK = new PickSourceType("CLICK", 1);
            PickSourceType[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = EnumEntriesKt.enumEntries(r0);
        }

        public static PickSourceType[] values() {
            return (PickSourceType[]) $VALUES.clone();
        }

        public static PickSourceType valueOf(String r1) {
            return (PickSourceType) r27.a.a(PickSourceType.class, r1);
        }

        private PickSourceType(String r1, int r2) {
            super(r1, r2);
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.picker.base.widget.BasePicker$getSearchEntityByChatIds$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u0004*\u00020\u0005H\n"}, d2 = {"<anonymous>", "Ljava/util/HashMap;", "", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "Lkotlin/collections/HashMap;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.picker.base.widget.BasePicker$getSearchEntityByChatIds$2", f = "BasePicker.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super HashMap<String, SearchBaseInfo>>, Object> {
        final /* synthetic */ List<String> $chatIds;
        int label;

        /* JADX INFO: renamed from: com.ss.android.lark.picker.base.widget.BasePicker$getSearchEntityByChatIds$2$WhenMappings */
        @Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

            static {
                int[] r0 = new int[Chat.Type.values().length];
                r0[Chat.Type.GROUP.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
            L9:
                r0[Chat.Type.P2P.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
            L5:
                $EnumSwitchMapping$0 = r0;
            }
        }

        public AnonymousClass2(List<String> r1, Continuation<? super AnonymousClass2> r2) {
            this.$chatIds = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass2(this.$chatIds, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super HashMap<String, SearchBaseInfo>> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r7) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L39;
            ResultKt.throwOnFailure(r7);
            HashMap r8 = new HashMap();
            Map<String, Chat> r0 = PickerWidgetModuleDependency.getDependency().getChatsByIds(this.$chatIds);
            ArrayList r1 = new ArrayList(r0.size());
            Iterator<Map.Entry<String, Chat>> r2 = r0.entrySet().iterator();
        L6:
            if (r2.hasNext() == false) goto L8;
            r1.add(r2.next().getValue());
            goto L6
        L8:
            HashMap r3 = new HashMap();
            Iterator r4 = r1.iterator();
        L10:
            if (r4.hasNext() == false) goto L22;
            Chat r5 = (Chat) r4.next();
            Chat.Type r6 = r5.getType();
            if (r6 != null) goto L14;
            int r9 = -1;
        L15:
            if (r9 != 1) goto L17;
            r3.put(r5.getId(), SearchCommonUtils.parseFromChatEntity(r5));
            goto L10
        L17:
            if (r9 != 2) goto L18;
            r8.put(r5.getP2pChatterId(), r5);
            goto L10
        L18:
            Log.e(BasePicker.TAG, "chat id: " + r5.getId() + ", chat type: " + r5.getType().getNumber());
            goto L10
        L14:
            r9 = WhenMappings.$EnumSwitchMapping$0[r6.ordinal()];
            goto L15
        L22:
            if ((!r8.isEmpty()) == false) goto L37;
            h r10 = PickerImServices.INSTANCE.getChatterService();
            if (r10 == null) goto L37;
            Map r11 = r10.l0(CollectionsKt.toList(r8.keySet()));
            if (r11 == null) goto L37;
            Collection r12 = r11.values();
            if (r12 == null) goto L37;
            Iterator r13 = r12.iterator();
        L31:
            if (r13.hasNext() == false) goto L37;
            Chatter r14 = (Chatter) r13.next();
            String r15 = null;
            SearchChatterInfo r16 = SearchCommonUtils.parseFromChatterEntity$default(r14, null, null, 6, null);
            Chat r17 = (Chat) r8.get(r14.getId());
            if (r17 == null) goto L35;
            r15 = r17.getId();
        L35:
            if (r15 == null) goto L31;
            r16.setP2pChatId(r17.getId());
            r3.put(r17.getId(), r16);
        L37:
            return r3;
        L39:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.picker.base.widget.BasePicker$getSearchEntityByChatterIds$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u0004*\u00020\u0005H\n"}, d2 = {"<anonymous>", "Ljava/util/HashMap;", "", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "Lkotlin/collections/HashMap;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.picker.base.widget.BasePicker$getSearchEntityByChatterIds$2", f = "BasePicker.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C03452 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super HashMap<String, SearchBaseInfo>>, Object> {
        final /* synthetic */ List<String> $chatterIds;
        int label;

        public C03452(List<String> r1, Continuation<? super C03452> r2) {
            this.$chatterIds = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C03452(this.$chatterIds, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super HashMap<String, SearchBaseInfo>> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r6) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L17;
            ResultKt.throwOnFailure(r6);
            h r7 = PickerImServices.INSTANCE.getChatterService();
            if (r7 == null) goto L15;
            Map r8 = r7.l0(this.$chatterIds);
            if (r8 == null) goto L15;
            Collection r9 = r8.values();
            if (r9 == null) goto L15;
            HashMap r0 = new HashMap();
            Iterator r10 = r9.iterator();
        L12:
            if (r10.hasNext() == false) goto L19;
            Chatter r1 = (Chatter) r10.next();
            r0.put(r1.getId(), SearchCommonUtils.parseFromChatterEntity$default(r1, null, null, 6, null));
            goto L12
        L19:
            return r0;
        L15:
            return new HashMap();
        L17:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.picker.base.widget.BasePicker$onCreate$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public /* synthetic */ class C03501 extends FunctionReferenceImpl implements Function1<List<? extends SearchBaseInfo>, Unit> {
        public C03501(Object r8) {
            super(1, r8, BasePicker.class, "removeData", "removeData(Ljava/util/List;)V", 0);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((List) r1);
            return Unit.INSTANCE;
        }

        public final void invoke(List<? extends SearchBaseInfo> r2) {
            BasePicker.access$removeData((BasePicker) ((CallableReference) this).receiver, r2);
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.picker.base.widget.BasePicker$searchWithSpotlightAndNet$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.picker.base.widget.BasePicker$searchWithSpotlightAndNet$1", f = "BasePicker.kt", i = {0, 0, 1}, l = {2291, 700, 701, 707}, m = "invokeSuspend", n = {"spotlightJob", "netJob", "netJob"}, s = {"L$0", "L$1", "L$0"})
    public static final class C03551 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $queryKey;
        final /* synthetic */ String $requestId;
        final /* synthetic */ P $spotlightPickerParam;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ BasePicker<P, PK> this$0;

        public C03551(BasePicker<P, PK> r1, String r2, P r3, String r4, Continuation<? super C03551> r5) {
            this.this$0 = r1;
            this.$queryKey = r2;
            this.$spotlightPickerParam = r3;
            this.$requestId = r4;
            super(2, r5);
        }

        public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
            C03551 r6 = new C03551(this.this$0, this.$queryKey, this.$spotlightPickerParam, this.$requestId, r9);
            r6.L$0 = r8;
            return r6;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r18) {
            Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = this.label;
            if (r2 == 0) goto L14;
            if (r2 == 1) goto L13;
            if (r2 == 2) goto L12;
            if (r2 == 3) goto L11;
            if (r2 != 4) goto L10;
            BasePicker<P, PK> r3 = (BasePicker) this.L$0;
            ResultKt.throwOnFailure(r18);
            Object r4 = r18;
        L34:
            BasePicker.handleSearchResponse$default(r3, (SearchResponse) r4, false, 2, null);
        L36:
            return Unit.INSTANCE;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L11:
            BasePicker<P, PK> r5 = (BasePicker) this.L$0;
            ResultKt.throwOnFailure(r18);
            Object r6 = r18;
        L27:
            BasePicker.handleSearchResponse$default(r5, (SearchResponse) r6, false, 2, null);
            goto L36
        L12:
            BasePicker<P, PK> r7 = (BasePicker) this.L$1;
            Deferred r8 = (Deferred) this.L$0;
            ResultKt.throwOnFailure(r18);
            Object r9 = r18;
        L23:
            BasePicker.access$handleSearchResponse(r7, (SearchResponse) r9, true);
            BasePicker<P, PK> r10 = this.this$0;
            this.L$0 = r10;
            this.L$1 = null;
            this.label = 3;
            r6 = r8.await(this);
            if (r6 != r1) goto L26;
            return r1;
        L26:
            r5 = r10;
            goto L27
        L13:
            Deferred r11 = (Deferred) this.L$1;
            Job r12 = (Deferred) this.L$0;
            ResultKt.throwOnFailure(r18);
            Job r15 = r12;
            Object r13 = r18;
        L17:
            Deferred r14 = (Deferred) r13;
            if (Intrinsics.areEqual(r14, r15) == false) goto L29;
            Log.i(BasePicker.TAG_SPOT, "firstFinishedJob: spotlight");
            BasePicker<P, PK> r16 = this.this$0;
            this.L$0 = r11;
            this.L$1 = r16;
            this.label = 2;
            r9 = r15.await(this);
            if (r9 != r1) goto L22;
            return r1;
        L22:
            r8 = r11;
            r7 = r16;
            goto L23
        L29:
            if (Intrinsics.areEqual(r14, r11) == false) goto L36;
            Log.i(BasePicker.TAG_SPOT, "firstFinishedJob: net");
            Job.DefaultImpls.cancel$default(r15, null, 1, null);
            BasePicker<P, PK> r17 = this.this$0;
            this.L$0 = r17;
            this.L$1 = null;
            this.label = 4;
            r4 = r11.await(this);
            if (r4 != r1) goto L33;
            return r1;
        L33:
            r3 = r17;
            goto L34
        L14:
            ResultKt.throwOnFailure(r18);
            CoroutineScope r19 = (CoroutineScope) this.L$0;
            r15 = BuildersKt.async$default(r19, Dispatchers.getIO(), null, new BasePicker$searchWithSpotlightAndNet$1$spotlightJob$1(this.this$0, this.$queryKey, this.$spotlightPickerParam, null), 2, null);
            r11 = BuildersKt.async$default(r19, Dispatchers.getIO(), null, new BasePicker$searchWithSpotlightAndNet$1$netJob$1(this.this$0, this.$requestId, this.$queryKey, null), 2, null);
            SelectImplementation r20 = new SelectImplementation(getContext());
            r20.d(r15.getOnAwait(), new BasePicker$searchWithSpotlightAndNet$1$firstFinishedJob$1$1(r15, null));
            r20.d(r11.getOnAwait(), new BasePicker$searchWithSpotlightAndNet$1$firstFinishedJob$1$2(r11, null));
            this.L$0 = r15;
            this.L$1 = r11;
            this.label = 1;
            r13 = r20.h(this);
            if (r13 != r1) goto L17;
            return r1;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.picker.base.widget.BasePicker$updatePreSelectedListByIds$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.picker.base.widget.BasePicker$updatePreSelectedListByIds$1", f = "BasePicker.kt", i = {0, 1}, l = {1756, 1757}, m = "invokeSuspend", n = {"chatterFuture", "chatResult"}, s = {"L$0", "L$0"})
    public static final class C03561 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<String> $chatIdList;
        final /* synthetic */ List<String> $chatterIdList;
        final /* synthetic */ List<Pair<String, EntityType>> $preSelectedIdList;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ BasePicker<P, PK> this$0;

        public C03561(List<? extends Pair<String, ? extends EntityType>> r1, BasePicker<P, PK> r2, List<String> r3, List<String> r4, Continuation<? super C03561> r5) {
            this.$preSelectedIdList = r1;
            this.this$0 = r2;
            this.$chatIdList = r3;
            this.$chatterIdList = r4;
            super(2, r5);
        }

        public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
            C03561 r6 = new C03561(this.$preSelectedIdList, this.this$0, this.$chatIdList, this.$chatterIdList, r9);
            r6.L$0 = r8;
            return r6;
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
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            HashMap r2 = (HashMap) this.L$0;
            ResultKt.throwOnFailure(r13);
        L18:
            HashMap r14 = (HashMap) r13;
            Log.i(BasePicker.TAG, "get chat && chatter: chatMap size: " + r2.size() + ", chatterMap size: " + r14.size());
            LinkedHashMap r3 = new LinkedHashMap();
            Iterator<T> r4 = this.$preSelectedIdList.iterator();
        L20:
            if (r4.hasNext() == false) goto L35;
            Pair r5 = (Pair) r4.next();
            Log.i(BasePicker.TAG, "before preSelected id: " + ((String) r5.getFirst()) + " <--> type: " + r5.getSecond() + '\n');
            if (r2.containsKey(r5.getFirst()) == false) goto L31;
            SearchBaseInfo r6 = (SearchBaseInfo) r2.get(r5.getFirst());
            if (r6 == null) goto L31;
            StringBuilder r9 = new StringBuilder("Add origin id: ");
            r9.append((String) r5.getFirst());
            r9.append(", real searchBaseInfo id: ");
            r9.append(r6.getId());
            r9.append(", ");
            if ((r6 instanceof SearchChatterInfo) == false) goto L28;
            String r10 = "chatterInfo";
        L29:
            r9.append(r10);
            Log.i(BasePicker.TAG, r9.toString());
            SearchBaseInfo r7 = (SearchBaseInfo) r3.put(r6.getId(), r6);
            goto L31
        L28:
            r10 = "chatInfo";
        L31:
            if (r14.containsKey(r5.getFirst()) == false) goto L20;
            SearchBaseInfo r8 = (SearchBaseInfo) r14.get(r5.getFirst());
            if (r8 == null) goto L20;
            Log.i(BasePicker.TAG, "Add origin id: " + ((String) r5.getFirst()) + ", real searchBaseInfo id: " + r8.getId() + ", chatterInfo");
            r3.put(r8.getId(), r8);
            goto L20
        L35:
            Log.i(BasePicker.TAG, "preSelectedList size " + r3.size());
            ArrayList r15 = new ArrayList(r3.size());
            Iterator r11 = r3.entrySet().iterator();
        L37:
            if (r11.hasNext() == false) goto L39;
            r15.add((SearchBaseInfo) ((Map.Entry) r11.next()).getValue());
            goto L37
        L39:
            BasePicker<P, PK> r12 = this.this$0;
            Iterator r16 = r15.iterator();
        L41:
            if (r16.hasNext() == false) goto L43;
            SearchBaseInfo r17 = (SearchBaseInfo) r16.next();
            Log.i(BasePicker.TAG, "after preSelected id: " + r17.getId() + '\n');
            r12.dealSelectAndDeselected(r17, true, PickSourceType.PRESELECT);
            goto L41
        L43:
            BasePicker.access$refreshAll(this.this$0);
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            Deferred r18 = (Deferred) this.L$0;
            ResultKt.throwOnFailure(r13);
        L14:
            HashMap r19 = (HashMap) r13;
            this.L$0 = r19;
            this.label = 2;
            Object r20 = r18.await(this);
            if (r20 != r0) goto L17;
            return r0;
        L17:
            r2 = r19;
            r13 = r20;
            goto L18
        L10:
            ResultKt.throwOnFailure(r13);
            CoroutineScope r110 = (CoroutineScope) this.L$0;
            Deferred r21 = BuildersKt.async$default(r110, null, null, new BasePicker$updatePreSelectedListByIds$1$chatFuture$1(this.this$0, this.$chatIdList, null), 3, null);
            Deferred r111 = BuildersKt.async$default(r110, null, null, new BasePicker$updatePreSelectedListByIds$1$chatterFuture$1(this.this$0, this.$chatterIdList, null), 3, null);
            this.L$0 = r111;
            this.label = 1;
            Object r22 = r21.await(this);
            if (r22 != r0) goto L13;
            return r0;
        L13:
            r18 = r111;
            r13 = r22;
            goto L14
        }
    }

    private final void loadMore() {
        this.mInitSearch = false;
        String r0 = com.ss.android.lark.sdk.a.a();
        this.mRequestId = r0;
        a r1 = this.mSearchLifecycleObserver;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mRequestId");
        r0 = null;
    L5:
        r1.onLoadMore(r0, null);
    }

    public final PK attachTopCustomView(View r4) {
        Intrinsics.checkNotNullParameter(r4, "topView");
        return (PK) attachTopCustomView$default(this, r4, false, 2, null);
    }

    public void destroy() {
        EditText r0 = null;
        this.searchResultAdapter = null;
        Context r1 = getContext();
        if (r1 == null) goto L5;
        Activity r2 = ContextsKt.findActivity(r1);
    L7:
        if ((r2 instanceof ComponentActivity) == false) goto L9;
        ComponentActivity r3 = (ComponentActivity) r2;
    L10:
        if (r3 == null) goto L12;
        r3.getLifecycle().removeObserver(this);
    L13:
        SearchInputView r4 = getMSearchInputView();
        EditText r5 = r4.b;
        if (r5 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchEdtTxt");
    L17:
        r0.removeTextChangedListener(r4.m);
        REMOVED_DATA.clear();
        return;
    L16:
        r0 = r5;
        goto L17
    L12:
        Log.w(TAG, "context is not compatible");
        goto L13
    L9:
        r3 = null;
        goto L10
    L5:
        r2 = null;
        goto L7
    }

    public abstract boolean onBackPressed();

    public boolean onSearchEmpty(String r2) {
        Intrinsics.checkNotNullParameter(r2, AppbrandHostConstants.Schema_RESERVED_FIELD.QUERY);
        return false;
    }

    public void onSearchError() {
    }

    public void onSearchHistoryRecordNeeded(SearchBaseInfo r2) {
        Intrinsics.checkNotNullParameter(r2, "baseInfo");
    }

    public void onStartSearch(String r2) {
        Intrinsics.checkNotNullParameter(r2, AppbrandHostConstants.Schema_RESERVED_FIELD.QUERY);
    }

    public void refreshDefault() {
    }

    public boolean spotLightSupportable(P r1) {
        return false;
    }

    public final void switchMultipleStatus(boolean r4) {
        switchMultipleStatus$default(this, r4, false, 2, null);
    }

    public abstract SearchContext transformByPickerParams(SearchContext r1, P r2);

    static {
        Companion = new Companion(null);
        REMOVED_DATA = new ArrayList();
    }

    private final void refreshSelectedView() {
        IOnSelectedStatusChangeListener r0 = this.mOnSelectedStatusChangeListener;
        if (r0 == null) goto L5;
        r0.onSelectedStatusChange(!this.mSelectedList.isEmpty(), this.mSelectedList.size());
    L5:
        updateSelectedCount();
        ConstraintLayout r2 = null;
        if (this.mPickerParams != null) goto L12;
        OnPickerParamsLoader<P> r1 = this.mOnPickerParamsLoader;
        if (r1 == null) goto L10;
        P r3 = r1.onLoadPickerParams();
    L11:
        this.mPickerParams = r3;
        goto L12
    L10:
        r3 = null;
    L12:
        P r4 = this.mPickerParams;
        if (r4 == null) goto L15;
        boolean r5 = r4.shouldShowSelectedView();
    L17:
        if ((true ^ this.mSelectedList.isEmpty()) == false) goto L34;
        if (r5 == false) goto L34;
        ViewGroup r6 = this.mSelectedView;
        if (r6 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("mSelectedView");
        r6 = null;
    L23:
        if (r6.getVisibility() != 8) goto L29;
        ConstraintLayout r7 = this.mSelectedView;
        if (r7 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("mSelectedView");
    L28:
        r2.setVisibility(0);
        post(new RunnableC03511(this));
        return;
    L27:
        r2 = r7;
        goto L28
    L29:
        ConstraintLayout r8 = this.mSelectedAdapter;
        if (r8 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("mSelectedAdapter");
    L33:
        r2.diff(this.mSelectedList);
        return;
    L32:
        r2 = r8;
    L34:
        ViewGroup r9 = this.mSelectedView;
        if (r9 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("mSelectedView");
        r9 = null;
    L38:
        if (r9.getVisibility() != 0) goto L47;
        ConstraintLayout r10 = this.mSelectedAdapter;
        if (r10 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("mSelectedAdapter");
    L43:
        r2.diff(this.mSelectedList);
        post(new RunnableC03522(this));
        return;
    L42:
        r2 = r10;
        goto L43
    L47:
        return;
    L15:
        r5 = true;
        goto L17
    }

    private final void updateSelectedCount() {
        String r0 = UIHelper.mustacheFormat(2131891812, "number", String.valueOf(this.mSelectedList.size()));
        TextView r1 = this.mSelectedCountTV;
        if (r1 == null) goto L6;
        r1.setText(r0);
        return;
    }

    public PK clearCustomSearchResultItems() {
        this.mCustomSearchResultItemManager.clear();
        return (PK) self();
    }

    public final TextView getCancelView() {
        TextView r0 = this.cancelView;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("cancelView");
        return null;
    }

    public final FrameLayout getMDefaultViewContainer() {
        FrameLayout r0 = this.mDefaultViewContainer;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mDefaultViewContainer");
        return null;
    }

    public final SearchInputView getMSearchInputView() {
        SearchInputView r0 = this.mSearchInputView;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mSearchInputView");
        return null;
    }

    public final SearchResultView getMSearchResultView() {
        SearchResultView r0 = this.mSearchResultView;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mSearchResultView");
        return null;
    }

    public final List<String> getSelectedIds() {
        List<SearchBaseInfo> r0 = this.mSelectedList;
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        r1.add(((SearchBaseInfo) r2.next()).getId());
        goto L4
    L6:
        return r1;
    }

    public final List<SearchBaseInfo> getSelectedList() {
        return CollectionsKt.toMutableList(this.mSelectedList);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreate() {
        if (this.isPickerV2 == false) goto L16;
        IViewDependency r0 = this.mDependency;
        ForResultFragment r1 = null;
        if (r0 == null) goto L9;
        FragmentManager r2 = r0.getFragmentManager();
        if (r2 == null) goto L9;
        Fragment r3 = r2.findFragmentByTag(TAG_FOR_RESULT_FRAGMENT);
    L11:
        if ((r3 instanceof ForResultFragment) == false) goto L13;
        r1 = (ForResultFragment) r3;
    L13:
        if (r1 == null) goto L17;
        r1.setOnResult(new C03501(this));
        return;
    L17:
        return;
    L9:
        r3 = null;
        goto L11
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResume() {
        if (this.isPickerV2 == true) goto L6;
        List<SearchBaseInfo> r0 = REMOVED_DATA;
        removeData(r0);
        r0.clear();
        return;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public final void onStop() {
        if (this.mSearchInputView == null) goto L6;
        getMSearchInputView().clearFocus();
        return;
    }

    public final ForResultFragment prepareForResultFragment() {
        IViewDependency r0 = this.mDependency;
        ForResultFragment r1 = null;
        if (r0 == null) goto L12;
        FragmentManager r2 = r0.getFragmentManager();
        if (r2 == null) goto L12;
        Fragment r3 = r2.findFragmentByTag(TAG_FOR_RESULT_FRAGMENT);
        if ((r3 instanceof ForResultFragment) == false) goto L9;
        r1 = (ForResultFragment) r3;
    L9:
        if (r1 != null) goto L11;
        r1 = new ForResultFragment();
        FragmentTransaction r4 = r2.beginTransaction();
        INVOKEVIRTUAL_com_ss_android_lark_picker_base_widget_BasePicker_com_obric_assistant_interaction_impl_window_helpers_FragmentTransactionLancet_add(r4, r1, TAG_FOR_RESULT_FRAGMENT);
        r4.commitNowAllowingStateLoss();
    L11:
        r1.setOnResult(new BasePicker$prepareForResultFragment$1$1(this));
    L12:
        return r1;
    }

    public final void searchMode() {
        if (this.mIsSearch == true) goto L5;
        getMSearchResultView().enableKeyboardNavigation(this.keyboardSelectionUIDependency);
    L5:
        this.mIsSearch = true;
        View r2 = null;
        if (this.mCenterCustomViewAttached == false) goto L12;
        FrameLayout r1 = this.mSearchCenterContainer;
        if (r1 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchCenterContainer");
        r1 = null;
    L10:
        r1.setVisibility(8);
    L12:
        if (this.mTopCustomViewAttached == false) goto L18;
        View r3 = this.mSearchTopContainer;
        if (r3 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchTopContainer");
    L17:
        r2.setVisibility(8);
        goto L18
    L16:
        r2 = r3;
    L18:
        getMDefaultViewContainer().setVisibility(8);
        if (this.isPickerV2 == false) goto L21;
        post(new RunnableC03541(this));
    L22:
        getMSearchResultView().showLoading();
        IOnPickModeChangeListener r4 = this.onPickModeChangeListener;
        if (r4 == null) goto L26;
        r4.onPickModeChanged(true);
        return;
    L26:
        return;
    L21:
        getMSearchResultView().setVisibility(0);
        goto L22
    }

    public final void selectedRvBg2Doubao() {
        ViewGroup r0 = this.mSelectedView;
        DefaultRecommendView r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mSelectedView");
        r0 = null;
    L5:
        r0.setBackgroundColor(d.c(getContext(), 2131101377));
        View r2 = getMDefaultViewContainer().getChildAt(0);
        if ((r2 instanceof DefaultRecommendView) == false) goto L8;
        r1 = (DefaultRecommendView) r2;
    L8:
        if (r1 == null) goto L10;
        r1.setBackgroundColor(d.c(getContext(), 2131101377));
    L10:
        this.useDoubaoSelectedMoreStyle = true;
    }

    public final PK self() {
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type PK of com.ss.android.lark.picker.base.widget.BasePicker");
        return this;
    }

    public final void startSelectedListActivity() {
        Lazy r0 = ForsetiConfig.a;
        if (ForsetiConfig.a(getContext()) == false) goto L7;
        SelectedMoreActivity.Companion.startForResultInForseti(getContext(), prepareForResultFragment(), this.mSelectedList, this.mIsEnableChatPreview, this.scene, this.useDoubaoSelectedMoreStyle);
        return;
    L7:
        if (this.isPickerV2 == false) goto L9;
        SelectedMoreActivity.Companion.startForResult(getContext(), prepareForResultFragment(), this.mSelectedList, this.mIsEnableChatPreview, this.isPickerV2, this.scene, 1, this.useDoubaoSelectedMoreStyle);
        return;
    L9:
        Context r1 = getContext();
        Activity r2 = null;
        if ((r1 instanceof Activity) == false) goto L12;
        Activity r3 = (Activity) r1;
    L13:
        if (r3 != null) goto L18;
        IViewDependency r4 = this.mDependency;
        if (r4 == null) goto L17;
        r2 = r4.getActivity();
    L17:
        Activity r5 = r2;
    L19:
        if (r5 != null) goto L21;
        Log.w(TAG, "context is not compatible or null");
        return;
    L21:
        if (ForsetiFGHelpers.d() == false) goto L23;
        SelectedMoreResponsiveActivity.Companion.startForResult(r5, this.mSelectedList, this.mIsEnableChatPreview, this.isPickerV2, this.scene, 1);
        return;
    L23:
        SelectedMoreActivity.Companion.startForResult(r5, this.mSelectedList, this.mIsEnableChatPreview, this.isPickerV2, this.scene, 1, this.useDoubaoSelectedMoreStyle);
        return;
    L18:
        r5 = r3;
        goto L19
    L12:
        r3 = null;
        goto L13
    }

    private final void checkVisibilityChange() {
        if (getVisibility() == 0) goto L5;
    L7:
        boolean r0 = false;
    L9:
        if (this.wasVisible == true) goto L16;
        if (r0 == false) goto L16;
        if (this.isFirstTime == true) goto L16;
        boolean r2 = this.mIsSearch;
        if (r2 == true) goto L16;
        switchKeyboardNavigation(r2);
    L16:
        this.wasVisible = r0;
        this.isFirstTime = false;
        return;
    L5:
        if (isShown() == false) goto L7;
        r0 = true;
        goto L9
    }

    private final void initPicker() {
        setMSearchInputView(findViewById(2131382282));
        setCancelView((TextView) findViewById(2131382267));
        this.searchHeaderContainer = (FrameLayout) findViewById(2131382271);
        this.mSearchCenterContainer = (FrameLayout) findViewById(2131382268);
        this.mSearchTopContainer = findViewById(2131382291);
        this.mSearchTopContainerFl = (FrameLayout) findViewById(2131382293);
        setMSearchResultView((SearchResultView) findViewById(2131382283));
        setMDefaultViewContainer((FrameLayout) findViewById(2131382270));
        this.mSelectedView = findViewById(2131382288);
        this.mSelectedRV = findViewById(2131382286);
        this.mSelectedMore = findViewById(2131382285);
        this.mSelectedCountTV = (TextView) findViewById(2131385833);
        this.mSelectedDivider = findViewById(2131382284);
        SearchInputView r0 = getMSearchInputView();
        r0.setOnSearch(new BasePicker$initPicker$1$1(this));
        r0.setOnQueryClear(new BasePicker$initPicker$1$2(this));
        SearchResultView r1 = getMSearchResultView();
        r1.erasePadding();
        SearchResultView.IOnLoadMore r2 = new BasePicker$initPicker$2$1(this);
        this.mOnLoadMore = r2;
        r1.setOnLoadMore(r2);
        r1.setOnResultScroll(new BasePicker$initPicker$2$2(this));
        r1.setOnClickEmptyView(new BasePicker$initPicker$2$3(this));
        r1.setClickHandler(new BasePicker$initPicker$2$4(this));
        this.mCallback = new C03493(this);
        this.mSelectedAdapter = new SelectedAdapter(this.mContext);
        RecyclerView r3 = this.mSelectedRV;
        View r4 = null;
        if (r3 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mSelectedRV");
        r3 = null;
    L5:
        RecyclerView.Adapter r5 = this.mSelectedAdapter;
        if (r5 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mSelectedAdapter");
        r5 = null;
    L8:
        r3.setAdapter(r5);
        RecyclerView r6 = this.mSelectedRV;
        if (r6 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mSelectedRV");
        r6 = null;
    L11:
        r6.setItemAnimator(null);
        RecyclerView r7 = this.mSelectedRV;
        if (r7 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mSelectedRV");
        r7 = null;
    L14:
        Context r8 = this.mContext;
        int r9 = DesktopUtil.a;
        r7.setLayoutManager(new LinearLayoutManager(r8, 0, false));
        RecyclerView r10 = this.mSelectedRV;
        if (r10 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mSelectedRV");
        r10 = null;
    L17:
        SimpleItemAnimator r11 = r10.getItemAnimator();
        if ((r11 instanceof SimpleItemAnimator) == false) goto L20;
        r11.setSupportsChangeAnimations(false);
    L20:
        SelectedAdapter r12 = this.mSelectedAdapter;
        if (r12 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("mSelectedAdapter");
        r12 = null;
    L23:
        r12.setOnItemRemoveListener(new AnonymousClass4(this));
        View r13 = this.mSelectedMore;
        if (r13 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("mSelectedMore");
    L27:
        r4.setOnClickListener(new AnonymousClass5(this));
        getMSearchResultView().setProfileClickListener(new AnonymousClass6(this));
        initItemConsumer();
        return;
    L26:
        r4 = r13;
        goto L27
    }

    private final void refreshAll() {
        refreshSelectedView();
        refreshResult();
        refreshDefault();
    }

    public void attachComplete() {
        SearchResultView r0 = getMSearchResultView();
        r0.switchMultiple(this.mIsMultiple);
        r0.setMIsEnableChatPreview(this.mIsEnableChatPreview);
        r0.setMScene(this.scene);
        r0.setForceRefreshNotifyItemChangedOnUnconsumedClick(this.forceNotifyDataSetChangedOnRefreshResult);
        P r1 = this.mPickerParams;
        if (r1 == null) goto L5;
        boolean r2 = r1.shouldShowSelectedView();
    L6:
        ViewGroup r3 = this.mSelectedView;
        if (r3 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("mSelectedView");
        r3 = null;
    L10:
        if (this.mIsMultiple == true) goto L12;
    L15:
        int r4 = 8;
    L16:
        r3.setVisibility(r4);
        Bundle r5 = new Bundle();
        r5.putString(KEY_SCENE, this.scene);
        this.extras = r5;
        post(new AnonymousClass3(this));
        return;
    L12:
        if ((true ^ this.mSelectedList.isEmpty()) == false) goto L15;
        if (r2 == false) goto L15;
        r4 = 0;
        goto L16
    L5:
        r2 = true;
        goto L6
    }

    public final String getQuery() {
        return getMSearchInputView().getQuery();
    }

    public final SearchInputView getSearchInputView() {
        return getMSearchInputView();
    }

    public void initItemConsumer() {
        getMSearchResultView().setOnBusinessConsumeItem(this.itemConsumeDelegate);
        this.itemConsumes.add(new C03481(this));
    }

    public final void refreshResult() {
        getMSearchResultView().refreshResult(this.mSelectedList, this.forceNotifyDataSetChangedOnRefreshResult);
    }

    public final void requestInputFocus() {
        getMSearchInputView().a();
    }

    public static final /* synthetic */ List access$getREMOVED_DATA$cp() {
        return REMOVED_DATA;
    }

    public final SearchResultView.IOnBusinessConsumeItem getBusinessConsumeDelegate() {
        return this.itemConsumeDelegate;
    }

    public final boolean getDisableRightViewHolder() {
        return this.disableRightViewHolder;
    }

    public final Bundle getExtras() {
        return this.extras;
    }

    public final boolean getForceNotifyDataSetChangedOnRefreshResult() {
        return this.forceNotifyDataSetChangedOnRefreshResult;
    }

    public final SearchResultView.IOnBusinessConsumeItem getItemConsumeDelegate() {
        return this.itemConsumeDelegate;
    }

    public final List<SearchResultView.IOnBusinessConsumeItem> getItemConsumes() {
        return this.itemConsumes;
    }

    public final IViewDependency getMDependency() {
        return this.mDependency;
    }

    public final boolean getMIsEnableChatPreview() {
        return this.mIsEnableChatPreview;
    }

    public final boolean getMIsMultiple() {
        return this.mIsMultiple;
    }

    public final boolean getMIsSearch() {
        return this.mIsSearch;
    }

    public final List<IOnPickNotify> getMOnPickNotifyList() {
        return this.mOnPickNotifyList;
    }

    public final OnPickerParamsLoader<P> getMOnPickerParamsLoader() {
        return this.mOnPickerParamsLoader;
    }

    public final PickerUseCategory getMPickerUseCategory() {
        return this.mPickerUseCategory;
    }

    public final PickerUsePage getMPickerUsePage() {
        return this.mPickerUsePage;
    }

    public final PickerReporterDelegate getMReporterDelegate() {
        return this.mReporterDelegate;
    }

    public final a getMSearchLifecycleObserver() {
        return this.mSearchLifecycleObserver;
    }

    public final a getMSearchLifecycleObserver4Spotlight() {
        return this.mSearchLifecycleObserver4Spotlight;
    }

    public final String getMSearchQuery() {
        return this.mSearchQuery;
    }

    public final List<SearchBaseInfo> getMSelectedList() {
        return this.mSelectedList;
    }

    public final boolean getMSoftInputInitPopup() {
        return this.mSoftInputInitPopup;
    }

    public final IOnCancelListener getOnCancelListener() {
        return this.onCancelListener;
    }

    public final List<ActionType> getPermissions() {
        return this.permissions;
    }

    public final Set<IOnPickNotifyV2> getPickNotifies() {
        return this.pickNotifies;
    }

    public final String getScene() {
        return this.scene;
    }

    public final boolean isClearWhenSingleSelect() {
        return this.isClearWhenSingleSelect;
    }

    public final boolean isMultipleSelect() {
        return this.mIsMultiple;
    }

    public final boolean isPickerV2() {
        return this.isPickerV2;
    }

    public BasePicker(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    public static final /* synthetic */ CustomSearchResultItemManager access$getMCustomSearchResultItemManager$p(BasePicker r0) {
        return r0.mCustomSearchResultItemManager;
    }

    public static final /* synthetic */ boolean access$getMHasMore$p(BasePicker r0) {
        return r0.mHasMore;
    }

    public static final /* synthetic */ boolean access$getMInitSearch$p(BasePicker r0) {
        return r0.mInitSearch;
    }

    public static final /* synthetic */ BasePickerParams access$getMPickerParams$p(BasePicker r0) {
        return r0.mPickerParams;
    }

    public static final /* synthetic */ String access$getMRequestId$p(BasePicker r0) {
        return r0.mRequestId;
    }

    public static final /* synthetic */ SelectedAdapter access$getMSelectedAdapter$p(BasePicker r0) {
        return r0.mSelectedAdapter;
    }

    public static final /* synthetic */ ConstraintLayout access$getMSelectedView$p(BasePicker r0) {
        return r0.mSelectedView;
    }

    public static final /* synthetic */ SearchResponse access$getOldSearchResponseFromSpotlight$p(BasePicker r0) {
        return r0.oldSearchResponseFromSpotlight;
    }

    public static final /* synthetic */ OnSearchErrorRetryClickListener access$getOnSearchErrorRetryClickListener$p(BasePicker r0) {
        return r0.onSearchErrorRetryClickListener;
    }

    public static final /* synthetic */ SearchResultAdapter access$getSearchResultAdapter$p(BasePicker r0) {
        return r0.searchResultAdapter;
    }

    public static final /* synthetic */ String access$getSpotlightRequestId$p(BasePicker r0) {
        return r0.spotlightRequestId;
    }

    public static final /* synthetic */ void access$loadMore(BasePicker r0) {
        r0.loadMore();
    }

    public static final /* synthetic */ void access$refreshAll(BasePicker r0) {
        r0.refreshAll();
    }

    private final void handleSearchError(final ErrorResult r3) {
        Log.i(TAG_SPOT, "picker search err Msg: " + r3.getDebugMsg());
        UICallbackExecutor.execute(new RunnableC03461(this, r3));
    }

    private final void notifySelected(List<? extends SearchBaseInfo> r6) {
        Set<IOnPickNotifyV2> r0 = this.pickNotifies;
        if (r0 == null) goto L12;
        Iterator<T> r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L15;
        IOnPickNotifyV2 r2 = (IOnPickNotifyV2) r1.next();
        List<? extends SearchBaseInfo> r3 = r6;
        ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));
        Iterator<T> r5 = r3.iterator();
    L9:
        if (r5.hasNext() == false) goto L11;
        r4.add(((SearchBaseInfo) r5.next()).getId());
        goto L9
    L11:
        r2.onChanged(r4, r6);
        goto L6
    L15:
        return;
    }

    private final void removeData(List<? extends SearchBaseInfo> r8) {
        List<? extends SearchBaseInfo> r0 = r8;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L24;
        Log.i(TAG, "removed data, deal with!!! size: " + r8.size());
        this.mSelectedList.removeAll(r8);
        List<IOnPickNotify> r2 = this.mOnPickNotifyList;
        if (r2 == null) goto L20;
        Iterator<T> r3 = r2.iterator();
    L14:
        if (r3.hasNext() == false) goto L20;
        IOnPickNotify r4 = (IOnPickNotify) r3.next();
        Iterator<T> r5 = r8.iterator();
    L17:
        if (r5.hasNext() == false) goto L19;
        SearchBaseInfo r6 = (SearchBaseInfo) r5.next();
        r4.onDeSelected(r6.getId(), r6);
        PickerReporter.INSTANCE.removeReporter(this.scene);
        notifySelect(false, r6, PickSourceType.CLICK);
        goto L17
    L19:
        r4.onChanged(getSelectedIds(), this.mSelectedList);
        notifySelected(this.mSelectedList);
    L20:
        refreshAll();
        return;
    L24:
        return;
    L5:
        if (r0.isEmpty() == true) goto L8;
        r1 = false;
        goto L9
    }

    private final void switchKeyboardNavigation(boolean r2) {
        if (r2 == false) goto L4;
        getMSearchResultView().enableKeyboardNavigation(this.keyboardSelectionUIDependency);
        return;
    L4:
        View r3 = getMDefaultViewContainer().getChildAt(0);
        if ((r3 instanceof DefaultRecommendView) == false) goto L7;
        DefaultRecommendView r4 = (DefaultRecommendView) r3;
    L8:
        if (r4 == null) goto L12;
        r4.enableKeyboardNavigation(this.keyboardSelectionUIDependency);
        return;
    L12:
        return;
    L7:
        r4 = null;
        goto L8
    }

    private final SearchContext transform2SearchContext(String r3) {
        SearchContext r0 = new SearchContext();
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        r0.b = r3;
        r0.w = this.permissions;
        P r4 = this.mPickerParams;
        if ((r4 instanceof BasePickerParams) == true) goto L6;
        r4 = null;
    L6:
        if (r4 == null) goto L8;
        r4.setSpotLight(false);
    L8:
        transformByPickerParams(r0, this.mPickerParams);
        return r0;
    }

    public final void addOnPickNotifyV2(IOnPickNotifyV2 r2) {
        Intrinsics.checkNotNullParameter(r2, "onPickNotifyV2");
        if (this.pickNotifies != null) goto L5;
        this.pickNotifies = new LinkedHashSet();
    L5:
        Set<IOnPickNotifyV2> r0 = this.pickNotifies;
        if (r0 == null) goto L9;
        r0.add(r2);
        return;
    }

    public final void addSelectModeChangeListener(IOnSelectModeChangeListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.onSelectModeChangeListeners.add(r2);
    }

    public final void addSelectedData(SearchBaseInfo r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        this.mSelectedList.add(r2);
        refreshSelectedView();
    }

    public final PK attachCenterCustomView(View r5) {
        Intrinsics.checkNotNullParameter(r5, "centerView");
        this.mCenterCustomViewAttached = true;
        FrameLayout r0 = this.mSearchCenterContainer;
        FrameLayout r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchCenterContainer");
        r0 = null;
    L5:
        r0.setVisibility(0);
        FrameLayout r2 = this.mSearchCenterContainer;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchCenterContainer");
    L9:
        r1.addView(r5);
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type PK of com.ss.android.lark.picker.base.widget.BasePicker");
        return this;
    L8:
        r1 = r2;
        goto L9
    }

    public final PK attachChatCountStyle(boolean r1) {
        this.isLightStyle = r1;
        return (PK) self();
    }

    public final PK attachConsumeResultLayoutClickWhenEmpty(boolean r3) {
        getMSearchResultView().setConsumeResultLayoutClickWhenEmpty(r3);
        View r0 = getMDefaultViewContainer().getChildAt(0);
        if ((r0 instanceof DefaultRecommendView) == false) goto L5;
        DefaultRecommendView r1 = (DefaultRecommendView) r0;
    L6:
        if (r1 == null) goto L9;
        r1.setConsumeResultLayoutClickWhenEmpty(r3);
    L9:
        return (PK) self();
    L5:
        r1 = null;
        goto L6
    }

    public PK attachCustomSearchResultItem(CustomSearchResultItem r2) {
        Intrinsics.checkNotNullParameter(r2, "customItem");
        this.mCustomSearchResultItemManager.attach(r2);
        return (PK) self();
    }

    public final PK attachDependency(IViewDependency r2) {
        Intrinsics.checkNotNullParameter(r2, "dependency");
        this.mDependency = r2;
        return (PK) self();
    }

    public final PK attachDisableRightViewHolder(boolean r1) {
        this.disableRightViewHolder = r1;
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type PK of com.ss.android.lark.picker.base.widget.BasePicker");
        return this;
    }

    public final void attachEnableAutoFocus(boolean r2) {
        this.enableAutoFocus = r2;
        getMSearchInputView().setAutoFocusEnabled(r2);
    }

    public final PK attachForceRefreshResultNotifyDataSetChanged(boolean r1) {
        this.forceNotifyDataSetChangedOnRefreshResult = r1;
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type PK of com.ss.android.lark.picker.base.widget.BasePicker");
        return this;
    }

    public final PK attachHeaderCustomView(View r4) {
        Intrinsics.checkNotNullParameter(r4, "headerView");
        FrameLayout r0 = this.searchHeaderContainer;
        FrameLayout r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("searchHeaderContainer");
        r0 = null;
    L5:
        r0.removeAllViews();
        FrameLayout r2 = this.searchHeaderContainer;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("searchHeaderContainer");
    L9:
        r1.addView(r4);
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type PK of com.ss.android.lark.picker.base.widget.BasePicker");
        return this;
    L8:
        r1 = r2;
        goto L9
    }

    public final PK attachIsEnableChatPreview(boolean r2) {
        boolean r0 = false;
        if (r2 == true) goto L5;
    L7:
        this.mIsEnableChatPreview = r0;
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type PK of com.ss.android.lark.picker.base.widget.BasePicker");
        return this;
    L5:
        if (FG.enable(FG.CHAT_PREVIEW, false) == false) goto L7;
        r0 = true;
        goto L7
    }

    public final PK attachMultiple(boolean r1) {
        setMIsMultiple(r1);
        return (PK) self();
    }

    public PK attachOnBusinessConsumeItem(SearchResultView.IOnBusinessConsumeItem r2) {
        if (r2 == null) goto L5;
        this.itemConsumes.add(r2);
    L5:
        return (PK) self();
    }

    public final void attachOnCancelListener(final IOnCancelListener r3) {
        getCancelView().setOnClickListener(new AnonymousClass1(r3));
    }

    public final PK attachOnPickerNotify(IOnPickNotify r2) {
        Intrinsics.checkNotNullParameter(r2, "onPickNotify");
        if (this.mOnPickNotifyList != null) goto L5;
        this.mOnPickNotifyList = new ArrayList();
    L5:
        List<IOnPickNotify> r0 = this.mOnPickNotifyList;
        Intrinsics.checkNotNull(r0);
        if (r0.contains(r2) == true) goto L9;
        List<IOnPickNotify> r1 = this.mOnPickNotifyList;
        Intrinsics.checkNotNull(r1);
        r1.add(r2);
    L9:
        return (PK) self();
    }

    public final PK attachOnPickerParamsLoader(OnPickerParamsLoader<P> r1) {
        this.mOnPickerParamsLoader = r1;
        return (PK) self();
    }

    public final PK attachOnSearchErrorRetryClickListener(OnSearchErrorRetryClickListener r1) {
        this.onSearchErrorRetryClickListener = r1;
        return (PK) self();
    }

    public final PK attachPermissions(List<? extends ActionType> r2) {
        Intrinsics.checkNotNullParameter(r2, "permissions");
        this.permissions = r2;
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type PK of com.ss.android.lark.picker.base.widget.BasePicker");
        return this;
    }

    public final PK attachRecommendView(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        getMDefaultViewContainer().removeAllViews();
        getMDefaultViewContainer().addView(r2);
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type PK of com.ss.android.lark.picker.base.widget.BasePicker");
        return this;
    }

    public final PK attachReporterDelegate(PickerReporterDelegate r2) {
        Intrinsics.checkNotNullParameter(r2, "reporterDelegate");
        this.mReporterDelegate = r2;
        return (PK) self();
    }

    public final PK attachScene(String r2) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        this.scene = r2;
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type PK of com.ss.android.lark.picker.base.widget.BasePicker");
        return this;
    }

    public final PK attachSearchHintText(String r2) {
        Intrinsics.checkNotNullParameter(r2, "hint");
        getMSearchInputView().setHint(r2);
        return (PK) self();
    }

    public final void attachSearchResultAdapter(SearchResultAdapter r1) {
        this.searchResultAdapter = r1;
    }

    public final PK attachSelectedCustomView(View r5) {
        Intrinsics.checkNotNullParameter(r5, "selectedView");
        this.mSelectedCustomViewAttached = true;
        ViewGroup r0 = this.mSelectedRV;
        ViewGroup r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mSelectedRV");
        r0 = null;
    L5:
        r0.setVisibility(8);
        View r2 = this.mSelectedMore;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mSelectedMore");
        r2 = null;
    L8:
        r2.setVisibility(8);
        View r3 = this.mSelectedDivider;
        if (r3 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mSelectedDivider");
        r3 = null;
    L11:
        r3.setVisibility(8);
        ViewGroup.LayoutParams r4 = new ConstraintLayout.LayoutParams(0, -2);
        ((ConstraintLayout.LayoutParams) r4).topToTop = 0;
        ((ConstraintLayout.LayoutParams) r4).leftToLeft = 0;
        ((ConstraintLayout.LayoutParams) r4).rightToRight = 0;
        ((ConstraintLayout.LayoutParams) r4).bottomToBottom = 0;
        ViewGroup r6 = this.mSelectedView;
        if (r6 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mSelectedView");
    L15:
        r1.addView(r5, r4);
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type PK of com.ss.android.lark.picker.base.widget.BasePicker");
        return this;
    L14:
        r1 = r6;
        goto L15
    }

    public final PK attachSoftInputInitPopup(boolean r1) {
        this.mSoftInputInitPopup = r1;
        return (PK) self();
    }

    public final PK attachUseCategory(PickerUseCategory r2) {
        Intrinsics.checkNotNullParameter(r2, "useCategory");
        this.mPickerUseCategory = r2;
        return (PK) self();
    }

    public final PK attachUsePage(PickerUsePage r2) {
        Intrinsics.checkNotNullParameter(r2, "usePage");
        this.mPickerUsePage = r2;
        return (PK) self();
    }

    public final void defaultMode(boolean r12) {
        this.mIsSearch = false;
        View r2 = null;
        if (this.mCenterCustomViewAttached == false) goto L9;
        FrameLayout r1 = this.mSearchCenterContainer;
        if (r1 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchCenterContainer");
        r1 = null;
    L7:
        r1.setVisibility(0);
    L9:
        if (this.mTopCustomViewAttached == false) goto L14;
        View r3 = this.mSearchTopContainer;
        if (r3 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchTopContainer");
        r3 = null;
    L13:
        r3.setVisibility(0);
    L14:
        getMDefaultViewContainer().setVisibility(0);
        getMSearchResultView().m3355default();
        post(new RunnableC03441(this));
        refreshDefault();
        P r4 = this.mPickerParams;
        if (r4 == null) goto L19;
        boolean r5 = true;
        if (r4.enableSearchHistory() != true) goto L19;
    L20:
        if (r5 == false) goto L27;
        View r6 = getMDefaultViewContainer().getChildAt(0);
        if ((r6 instanceof DefaultRecommendView) == false) goto L24;
        DefaultRecommendView r7 = (DefaultRecommendView) r6;
    L25:
        if (r7 == null) goto L27;
        DefaultRecommendView.refresh$default(r7, false, false, true, true, false, 17, null);
        goto L27
    L24:
        r7 = null;
    L27:
        SearchInputView r8 = getMSearchInputView();
        EditText r9 = r8.b;
        if (r9 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchEdtTxt");
        r9 = null;
    L30:
        r9.removeTextChangedListener(r8.m);
        r9.setText("");
        r9.addTextChangedListener(r8.m);
        if (r12 == false) goto L33;
        r8.a();
    L33:
        View r13 = r8.c;
        if (r13 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchClearBtn");
    L37:
        r2.setVisibility(8);
        IOnPickModeChangeListener r14 = this.onPickModeChangeListener;
        if (r14 == null) goto L40;
        r14.onPickModeChanged(false);
    L40:
        switchKeyboardNavigation(this.mIsSearch);
        return;
    L36:
        r2 = r13;
    L19:
        r5 = false;
        goto L20
    }

    public final void disableExternalChatter(boolean r2) {
        getMSearchResultView().disableExternalChatter(r2);
    }

    public final void enableCancelView(boolean r2) {
        TextView r0 = getCancelView();
        if (r2 == false) goto L5;
        int r3 = 0;
    L6:
        r0.setVisibility(r3);
        return;
    L5:
        r3 = 8;
        goto L6
    }

    public final List<String> getSelectedIdsByType(int r5) {
        List<SearchBaseInfo> r0 = this.mSelectedList;
        ArrayList r1 = new ArrayList();
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L11;
        Object r3 = r2.next();
        if (((SearchBaseInfo) r3).getType() != r5) goto L8;
        boolean r4 = true;
    L9:
        if (r4 == false) goto L4;
        r1.add(r3);
        goto L4
    L8:
        r4 = false;
        goto L9
    L11:
        ArrayList r6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator r7 = r1.iterator();
    L13:
        if (r7.hasNext() == false) goto L15;
        r6.add(((SearchBaseInfo) r7.next()).getId());
        goto L13
    L15:
        return r6;
    }

    public void initialSearch(String r6) {
        Intrinsics.checkNotNullParameter(r6, "queryKey");
        Log.i(TAG_SPOT, "initialSearch");
        this.mInitSearch = true;
        this.mSearchQuery = r6;
        searchMode();
        this.mRequestId = com.ss.android.lark.sdk.a.a();
        OnPickerParamsLoader<P> r0 = this.mOnPickerParamsLoader;
        String r1 = null;
        if (r0 == null) goto L5;
        P r2 = r0.onLoadPickerParams();
    L6:
        this.mPickerParams = r2;
        if (spotLightSupportable(r2) == false) goto L13;
        String r3 = this.mRequestId;
        if (r3 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mRequestId");
    L12:
        searchWithSpotlightAndNet(r1, r6);
    L21:
        onStartSearch(r6);
        return;
    L11:
        r1 = r3;
        goto L12
    L13:
        a r4 = this.mSearchLifecycleObserver;
        String r5 = this.mRequestId;
        if (r5 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("mRequestId");
        r5 = null;
    L16:
        SearchContext r7 = transform2SearchContext(r6);
        String r8 = this.mCallback;
        if (r8 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("mCallback");
    L20:
        r4.onSearch(r5, r7, r1);
        goto L21
    L19:
        r1 = r8;
        goto L20
    L5:
        r2 = null;
        goto L6
    }

    public void onSearchSuccess(List<SearchBaseInfo> r5) {
        Intrinsics.checkNotNullParameter(r5, "infoList");
        Iterator<T> r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L11;
        SearchChatInfo r0 = (SearchBaseInfo) r6.next();
        if ((r0 instanceof SearchChatterInfo) == true) goto L7;
        if ((r0 instanceof SearchChatInfo) == false) goto L4;
        r0.setCountLightStyle(this.isLightStyle);
        goto L4
    L7:
        SearchChatterInfo r1 = (SearchChatterInfo) r0;
        r1.customer(Intrinsics.areEqual(UserInfo.NONE_NAME_CARD_ID, r1.getTenantId()));
        r1.zenMode(PickerWidgetModuleDependency.getDependency().isInZenMode(r1.getZenModeEndTime()));
        goto L4
    }

    public void registerSearchCustomBinders(Map<Integer, ? extends CommonBinder<?>> r2) {
        Intrinsics.checkNotNullParameter(r2, "customBinders");
        getMSearchResultView().registerCustomBinders(r2);
    }

    public final void removeOnPickNotifyV2(IOnPickNotifyV2 r2) {
        Intrinsics.checkNotNullParameter(r2, "onPickNotifyV2");
        Set<IOnPickNotifyV2> r0 = this.pickNotifies;
        if (r0 == null) goto L6;
        r0.remove(r2);
        return;
    }

    public final void removeSelectModeChangeListener(IOnSelectModeChangeListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.onSelectModeChangeListeners.remove(r2);
    }

    public final void removeSelectedData(List<? extends SearchBaseInfo> r3) {
        Intrinsics.checkNotNullParameter(r3, "removeData");
        Iterator<T> r4 = r3.iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        SearchBaseInfo r0 = (SearchBaseInfo) r4.next();
        this.mSelectedList.remove(r0);
        goto L4
    L6:
        refreshAll();
    }

    public final void resetFocus(final boolean r2) {
        if (b.a() == false) goto L10;
        Boolean r0 = ExternalKeyboardUtils.a;
        if (ExternalKeyboardUtils.b(false) == true) goto L7;
        return;
    L7:
        if (this.enableAutoFocus == false) goto L12;
        post(new RunnableC03531(this, r2));
        return;
    L12:
        return;
    }

    public final void resetSelectedData(List<? extends SearchBaseInfo> r2) {
        this.mSelectedList.clear();
        if (r2 == null) goto L7;
        List<? extends SearchBaseInfo> r3 = r2;
        if ((!r3.isEmpty()) == false) goto L7;
        this.mSelectedList.addAll(r3);
    L7:
        refreshAll();
    }

    public final void setCancelView(TextView r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.cancelView = r2;
    }

    public final void setClearWhenSingleSelect(boolean r1) {
        this.isClearWhenSingleSelect = r1;
    }

    public void setCustomBinder(ICustomBinder r2) {
        Intrinsics.checkNotNullParameter(r2, "customBinder");
        getMSearchResultView().setCustomBinder(r2);
    }

    public void setCustomViewTypeResolvers(List<? extends ICustomViewTypeResolver> r2) {
        getMSearchResultView().setCustomViewTypeResolvers(r2);
    }

    public final void setDefaultContainerHideKeyboardOnTouch(boolean r3) {
        SearchFrameLayout r0 = getMDefaultViewContainer();
        if ((r0 instanceof SearchFrameLayout) == false) goto L5;
        SearchFrameLayout r1 = r0;
    L6:
        if (r1 == null) goto L9;
        r1.setHideKeyboardOnInterceptTouch(r3);
        return;
    L9:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void setDisableRightViewHolder(boolean r1) {
        this.disableRightViewHolder = r1;
    }

    public final void setExtras(Bundle r1) {
        this.extras = r1;
    }

    public final void setForceNotifyDataSetChangedOnRefreshResult(boolean r1) {
        this.forceNotifyDataSetChangedOnRefreshResult = r1;
    }

    public final void setHeadCustomView(View r2) {
        Intrinsics.checkNotNullParameter(r2, "customView");
        getMSearchResultView().setHeadCustomView(r2);
    }

    public final void setMDefaultViewContainer(FrameLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.mDefaultViewContainer = r2;
    }

    public final void setMDependency(IViewDependency r1) {
        this.mDependency = r1;
    }

    public final void setMIsEnableChatPreview(boolean r1) {
        this.mIsEnableChatPreview = r1;
    }

    public final void setMIsMultiple(boolean r3) {
        this.mIsMultiple = r3;
        Iterator<T> r0 = this.onSelectModeChangeListeners.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((IOnSelectModeChangeListener) r0.next()).onSelectModeChanged(r3);
        goto L4
    }

    public final void setMIsSearch(boolean r1) {
        this.mIsSearch = r1;
    }

    public final void setMOnPickNotifyList(List<IOnPickNotify> r1) {
        this.mOnPickNotifyList = r1;
    }

    public final void setMOnPickerParamsLoader(OnPickerParamsLoader<P> r1) {
        this.mOnPickerParamsLoader = r1;
    }

    public final void setMPickerUseCategory(PickerUseCategory r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.mPickerUseCategory = r2;
    }

    public final void setMPickerUsePage(PickerUsePage r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.mPickerUsePage = r2;
    }

    public final void setMReporterDelegate(PickerReporterDelegate r1) {
        this.mReporterDelegate = r1;
    }

    public final void setMSearchInputView(SearchInputView r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.mSearchInputView = r2;
    }

    public final void setMSearchLifecycleObserver(a r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.mSearchLifecycleObserver = r2;
    }

    public final void setMSearchLifecycleObserver4Spotlight(a r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.mSearchLifecycleObserver4Spotlight = r2;
    }

    public final void setMSearchQuery(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.mSearchQuery = r2;
    }

    public final void setMSearchResultView(SearchResultView r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.mSearchResultView = r2;
    }

    public final void setMSelectedList(List<SearchBaseInfo> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.mSelectedList = r2;
    }

    public final void setMSoftInputInitPopup(boolean r1) {
        this.mSoftInputInitPopup = r1;
    }

    public final void setOnCancelListener(IOnCancelListener r1) {
        this.onCancelListener = r1;
    }

    public final void setOnSelectedStatusChangeListener(IOnSelectedStatusChangeListener r1) {
        this.mOnSelectedStatusChangeListener = r1;
    }

    public final void setPermissions(List<? extends ActionType> r1) {
        this.permissions = r1;
    }

    public final void setPickModeChangeListener(IOnPickModeChangeListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.onPickModeChangeListener = r2;
    }

    public final void setPickNotifies(Set<IOnPickNotifyV2> r1) {
        this.pickNotifies = r1;
    }

    public final void setPickerV2(boolean r1) {
        this.isPickerV2 = r1;
    }

    public final void setScene(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.scene = r2;
    }

    public void showFragment(BaseFragment r4) {
        Intrinsics.checkNotNullParameter(r4, "fragment");
        IViewDependency r0 = this.mDependency;
        if (r0 == null) goto L7;
        FragmentManager r1 = r0.getFragmentManager();
        if (r1 == null) goto L7;
        FragmentTransaction r2 = r1.beginTransaction();
    L8:
        if (r2 == null) goto L10;
        INVOKEVIRTUAL_com_ss_android_lark_picker_base_widget_BasePicker_com_obric_assistant_interaction_impl_window_helpers_FragmentTransactionLancet_replace(r2, 2131382270, r4, RECOMMEND_FRAGMENT_TAG);
    L10:
        if (r2 == null) goto L13;
        r2.commitAllowingStateLoss();
        return;
    L13:
        return;
    L7:
        r2 = null;
        goto L8
    }

    public final void updatePreSelectedList(List<? extends SearchBaseInfo> r4) {
        if (r4 == null) goto L16;
        Iterator<T> r5 = r4.iterator();
    L5:
        if (r5.hasNext() == false) goto L9;
        SearchBaseInfo r0 = (SearchBaseInfo) r5.next();
        if (this.mSelectedList.contains(r0) == true) goto L5;
        this.mSelectedList.add(r0);
        notifySelect(true, r0, PickSourceType.PRESELECT);
        goto L5
    L9:
        notifySelected(this.mSelectedList);
        refreshAll();
        return;
    }

    public final void updatePreSelectedListByIds(List<? extends Pair<String, ? extends EntityType>> r12) {
        Intrinsics.checkNotNullParameter(r12, "preSelectedIdList");
        List<? extends Pair<String, ? extends EntityType>> r0 = r12;
        ArrayList r1 = new ArrayList();
        Iterator<T> r2 = r0.iterator();
    L3:
        boolean r4 = true;
        if (r2.hasNext() == false) goto L11;
        Object r3 = r2.next();
        if (((Pair) r3).getSecond() == EntityType.CHAT) goto L9;
        r4 = false;
    L9:
        if (r4 == false) goto L3;
        r1.add(r3);
        goto L3
    L11:
        ArrayList r8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator r5 = r1.iterator();
    L13:
        if (r5.hasNext() == false) goto L15;
        r8.add((String) ((Pair) r5.next()).getFirst());
        goto L13
    L15:
        ArrayList r6 = new ArrayList();
        Iterator<T> r7 = r0.iterator();
    L17:
        if (r7.hasNext() == false) goto L24;
        Object r9 = r7.next();
        if (((Pair) r9).getSecond() != EntityType.CHATTER) goto L21;
        boolean r10 = true;
    L22:
        if (r10 == false) goto L17;
        r6.add(r9);
        goto L17
    L21:
        r10 = false;
        goto L22
    L24:
        ArrayList r11 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10));
        Iterator r13 = r6.iterator();
    L26:
        if (r13.hasNext() == false) goto L28;
        r11.add((String) ((Pair) r13.next()).getFirst());
        goto L26
    L28:
        BuildersKt.launch$default(this.scope, null, null, new C03561(r12, this, r8, r11, null), 3, null);
    }

    public final PK attachSearchHintText(int r2) {
        getMSearchInputView().setHint(r2);
        return (PK) self();
    }

    public final void removeSelectedData(SearchBaseInfo r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        this.mSelectedList.remove(r2);
        refreshSelectedView();
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [com.ss.android.lark.picker.base.widget.BasePicker$keyboardSelectionUIDependency$1] */
    public BasePicker(Context r5, AttributeSet r6) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r6);
        ComponentActivity r7 = null;
        this.scope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getMain().getImmediate()));
        this.spotlightRequestId = "";
        this.enableAutoFocus = true;
        this.onSelectModeChangeListeners = new LinkedHashSet();
        this.keyboardSelectionUIDependency = new BasePicker$keyboardSelectionUIDependency$1(this);
        this.isClearWhenSingleSelect = true;
        this.disableRightViewHolder = true;
        this.mSelectedList = new ArrayList();
        this.itemConsumes = new ArrayList();
        this.mCustomSearchResultItemManager = new CustomSearchResultItemManager();
        this.itemConsumeDelegate = new BasePicker$itemConsumeDelegate$1(this);
        this.mInitSearch = true;
        this.mSearchQuery = "";
        this.isFirstTime = true;
        this.mPickerUsePage = PickerUsePage.UNKNOWN;
        this.mPickerUseCategory = PickerUseCategory.UNKNOWN;
        this.scene = PickerReporterConstants.VALUE.SCENE.OTHERS;
        REMOVED_DATA.clear();
        if (b.a() == false) goto L5;
        ExternalKeyboardUtils.d();
    L5:
        Log.d(TAG, "constructor, BasePicker.");
        this.mContext = r5;
        LayoutInflater r2 = LayoutInflater.from(r5);
        int r3 = DesktopUtil.a;
        r2.inflate(2131568188, this, true);
        initPicker();
        this.mSearchLifecycleObserver = PickerWidgetModuleDependency.getDependency().getSearchLifecycleObserver();
        this.mSearchLifecycleObserver4Spotlight = PickerWidgetModuleDependency.getDependency().getSearchLifecycleObserver();
        Activity r8 = ContextsKt.findActivity(r5);
        if ((r8 instanceof ComponentActivity) == false) goto L8;
        r7 = (ComponentActivity) r8;
    L8:
        if (r7 == null) goto L10;
        r7.getLifecycle().addObserver(this);
        return;
    L10:
        Log.w(TAG, "context is not compatible");
    }

    public static final /* synthetic */ void access$handleSearchError(BasePicker r0, ErrorResult r1) {
        r0.handleSearchError(r1);
    }

    public static final /* synthetic */ void access$notifySelected(BasePicker r0, List r1) {
        r0.notifySelected(r1);
    }

    public static final /* synthetic */ void access$removeData(BasePicker r0, List r1) {
        r0.removeData(r1);
    }

    public static final /* synthetic */ void access$setMHasMore$p(BasePicker r0, boolean r1) {
        r0.mHasMore = r1;
    }

    public static final /* synthetic */ void access$setMRequestId$p(BasePicker r0, String r1) {
        r0.mRequestId = r1;
    }

    public static final /* synthetic */ void access$setOldSearchResponseFromSpotlight$p(BasePicker r0, SearchResponse r1) {
        r0.oldSearchResponseFromSpotlight = r1;
    }

    public static final /* synthetic */ void access$setSpotlightRequestId$p(BasePicker r0, String r1) {
        r0.spotlightRequestId = r1;
    }

    public static final /* synthetic */ void access$switchKeyboardNavigation(BasePicker r0, boolean r1) {
        r0.switchKeyboardNavigation(r1);
    }

    public static final /* synthetic */ SearchContext access$transform2SearchContext(BasePicker r0, String r1) {
        return r0.transform2SearchContext(r1);
    }

    private final Object getSearchEntityByChatIds(List<String> r4, Continuation<? super HashMap<String, SearchBaseInfo>> r5) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass2(r4, null), r5);
    }

    private final Object getSearchEntityByChatterIds(List<String> r4, Continuation<? super HashMap<String, SearchBaseInfo>> r5) {
        return BuildersKt.withContext(Dispatchers.getIO(), new C03452(r4, null), r5);
    }

    private final void handleSearchResponse(final SearchResponse r5, final boolean r6) {
        String r0 = null;
        if (r6 == false) goto L5;
        final String r1 = this.spotlightRequestId;
    L8:
        StringBuilder r2 = new StringBuilder("handleSearchResponse isFromSpotlight: ");
        r2.append(r6);
        r2.append(" , requestId: ");
        if (r5 == null) goto L11;
        r0 = r5.getRequestId();
    L11:
        r2.append(r0);
        r2.append(" , currentRequestId: ");
        r2.append(r1);
        Log.i(TAG_SPOT, r2.toString());
        UICallbackExecutor.execute(new RunnableC03471(r6, this, r5, r1));
        return;
    L5:
        r1 = this.mRequestId;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mRequestId");
        r1 = null;
        goto L8
    }

    private final void searchWithSpotlightAndNet(String r13, String r14) {
        OnPickerParamsLoader<P> r0 = this.mOnPickerParamsLoader;
        String r1 = null;
        if (r0 == null) goto L5;
        P r5 = r0.onLoadPickerParams();
    L6:
        this.spotlightRequestId = com.ss.android.lark.sdk.a.a();
        StringBuilder r2 = new StringBuilder("start searchWithSpotlightAndNet spotlightRequestId: ");
        r2.append(this.spotlightRequestId);
        r2.append(", net requestId : ");
        String r3 = this.mRequestId;
        if (r3 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("mRequestId");
    L10:
        r2.append(r1);
        Log.i(TAG_SPOT, r2.toString());
        BuildersKt.launch$default(this.scope, null, null, new C03551(this, r14, r5, r13, null), 3, null);
        return;
    L9:
        r1 = r3;
        goto L10
    L5:
        r5 = null;
        goto L6
    }

    private final SearchContext transform2SearchContext4Spotlight(String r5, P r6) {
        StringBuilder r0 = new StringBuilder("transform2SearchContext4Spotlight tagName: ");
        P r1 = this.mPickerParams;
        String r3 = null;
        if ((r1 instanceof BasePickerParams) == true) goto L6;
        r1 = null;
    L6:
        if (r1 == null) goto L8;
        r3 = r1.tagName4Spotlight();
    L8:
        r0.append(r3);
        Log.i(TAG_SPOT, r0.toString());
        SearchContext r2 = new SearchContext();
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        r2.b = r5;
        r2.w = this.permissions;
        transformByPickerParams(r2, r6);
        return r2;
    }

    public final PK attachSearchEmptyViewConfig(Integer r2, CharSequence r3) {
        getMSearchResultView().setSearchEmptyViewConfig(r2, r3);
        return (PK) self();
    }

    public final PK attachTopCustomView(View r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r5, "topView");
        this.mTopCustomViewAttached = true;
        View r0 = this.mSearchTopContainer;
        View r2 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchTopContainer");
        r0 = null;
    L5:
        int r3 = 0;
        r0.setVisibility(0);
        FrameLayout r1 = this.mSearchTopContainerFl;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchTopContainerFl");
        r1 = null;
    L8:
        r1.addView(r5);
        View r7 = this.mSearchTopContainer;
        if (r7 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchTopContainer");
    L12:
        View r8 = r2.findViewById(2131382292);
        if (r8 == null) goto L18;
        if (r6 == true) goto L17;
        r3 = 8;
    L17:
        r8.setVisibility(r3);
    L18:
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type PK of com.ss.android.lark.picker.base.widget.BasePicker");
        return this;
    L11:
        r2 = r7;
        goto L12
    }

    @Override // android.view.View
    public void onVisibilityChanged(View r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "changedView");
        super.onVisibilityChanged(r2, r3);
        checkVisibilityChange();
    }

    public void switchMultipleStatus(boolean r3, boolean r4) {
        if (r4 == false) goto L5;
    L10:
        ViewGroup r5 = null;
        resetSelectedData(null);
        setMIsMultiple(r3);
        getMSearchResultView().switchMultiple(this.mIsMultiple);
        P r6 = this.mPickerParams;
        if (r6 == null) goto L13;
        boolean r7 = r6.shouldShowSelectedView();
    L14:
        ViewGroup r1 = this.mSelectedView;
        if (r1 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mSelectedView");
    L19:
        if (this.mIsMultiple == true) goto L21;
    L24:
        int r8 = 8;
    L25:
        r5.setVisibility(r8);
        return;
    L21:
        if ((true ^ this.mSelectedList.isEmpty()) == false) goto L24;
        if (r7 == false) goto L24;
        r8 = 0;
        goto L25
    L17:
        r5 = r1;
        goto L19
    L13:
        r7 = true;
        goto L14
    L5:
        if (this.mIsMultiple == false) goto L10;
        if ((!this.mSelectedList.isEmpty()) == false) goto L10;
        Log.e(TAG, "not support this action!!!");
    }

    public static FragmentTransaction INVOKEVIRTUAL_com_ss_android_lark_picker_base_widget_BasePicker_com_obric_assistant_interaction_impl_window_helpers_FragmentTransactionLancet_add(FragmentTransaction r2, int r3, Fragment r4) {
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r2, r4, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, null, r3) == false) goto L6;
        return r2;
    L6:
        return r2.add(r3, r4);
    }

    public static final /* synthetic */ Object access$getSearchEntityByChatIds(BasePicker r0, List r1, Continuation r2) {
        return r0.getSearchEntityByChatIds(r1, r2);
    }

    public static final /* synthetic */ Object access$getSearchEntityByChatterIds(BasePicker r0, List r1, Continuation r2) {
        return r0.getSearchEntityByChatterIds(r1, r2);
    }

    public static final /* synthetic */ void access$handleSearchResponse(BasePicker r0, SearchResponse r1, boolean r2) {
        r0.handleSearchResponse(r1, r2);
    }

    public static final /* synthetic */ SearchContext access$transform2SearchContext4Spotlight(BasePicker r0, String r1, BasePickerParams r2) {
        return r0.transform2SearchContext4Spotlight(r1, r2);
    }

    private final Object getNetSearchResult(String r4, SearchContext r5, Continuation<? super SearchResponse> r6) throws Exception {
        final SafeContinuation r0 = new SafeContinuation(IntrinsicsKt.intercepted(r6));
        Log.i(TAG_SPOT, "NetSearch start");
        this.mSearchLifecycleObserver.onSearch(r4, r5, new BasePicker$getNetSearchResult$2$1(this, r0));
        Object r7 = r0.getOrThrow();
        if (r7 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r6);
    L5:
        return r7;
    }

    private final Object getSpotlightSearchResult(String r4, SearchContext r5, Continuation<? super SearchResponse> r6) throws Exception {
        final SafeContinuation r0 = new SafeContinuation(IntrinsicsKt.intercepted(r6));
        Log.i(TAG_SPOT, "SpotlightSearch start");
        this.mSearchLifecycleObserver4Spotlight.onSearch(r4, r5, new BasePicker$getSpotlightSearchResult$2$1(this, r0));
        Object r7 = r0.getOrThrow();
        if (r7 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r6);
    L5:
        return r7;
    }

    private final void notifySelect(boolean r4, SearchBaseInfo r5, PickSourceType r6) {
        Set<IOnPickNotifyV2> r0 = this.pickNotifies;
        if (r0 == null) goto L11;
        Iterator<T> r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L18;
        IOnPickNotifyV2 r2 = (IOnPickNotifyV2) r1.next();
        if (r4 == true) goto L9;
        r2.onDeSelected(r5.getId(), r5, r6);
        goto L6
    L9:
        r2.onSelected(r5.getId(), r5, r6);
        goto L6
    L18:
        return;
    }

    public final void customSearch(String r2, String r3, IGetDataCallback<SearchResponse> r4) {
        Intrinsics.checkNotNullParameter(r2, "queryKey");
        Intrinsics.checkNotNullParameter(r3, "requestId");
        Intrinsics.checkNotNullParameter(r4, "callback");
        searchMode();
        OnPickerParamsLoader<P> r0 = this.mOnPickerParamsLoader;
        if (r0 == null) goto L5;
        P r1 = r0.onLoadPickerParams();
    L6:
        this.mPickerParams = r1;
        this.mSearchLifecycleObserver.onSearch(r3, transform2SearchContext(r2), r4);
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void dealSelectAndDeselected(SearchBaseInfo r7, boolean r8, PickSourceType r9) {
        Intrinsics.checkNotNullParameter(r7, "data");
        Intrinsics.checkNotNullParameter(r9, "pickSourceType");
        if (this.mIsMultiple == false) goto L35;
        if (r8 == false) goto L19;
        if (this.mSelectedList.contains(r7) == false) goto L8;
        return;
    L8:
        this.mSelectedList.add(r7);
        RecyclerView r0 = this.mSelectedRV;
        if (r0 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mSelectedRV");
        r0 = null;
    L11:
        r0.smoothScrollToPosition(this.mSelectedList.size());
        List<IOnPickNotify> r1 = this.mOnPickNotifyList;
        if (r1 == null) goto L17;
        Iterator<T> r2 = r1.iterator();
    L15:
        if (r2.hasNext() == false) goto L17;
        ((IOnPickNotify) r2.next()).onSelected(r7.getId(), r7);
    L17:
        notifySelect(r8, r7, r9);
    L28:
        List<IOnPickNotify> r10 = this.mOnPickNotifyList;
        if (r10 == null) goto L34;
        Iterator<T> r11 = r10.iterator();
    L32:
        if (r11.hasNext() == false) goto L34;
        ((IOnPickNotify) r11.next()).onChanged(getSelectedIds(), this.mSelectedList);
    L34:
        notifySelected(this.mSelectedList);
    L44:
        refreshSelectedView();
        return;
    L19:
        if (this.mSelectedList.contains(r7) == true) goto L21;
        return;
    L21:
        this.mSelectedList.remove(r7);
        List<IOnPickNotify> r3 = this.mOnPickNotifyList;
        if (r3 == null) goto L27;
        Iterator<T> r4 = r3.iterator();
    L25:
        if (r4.hasNext() == false) goto L27;
        ((IOnPickNotify) r4.next()).onDeSelected(r7.getId(), r7);
    L27:
        notifySelect(r8, r7, r9);
        goto L28
    L35:
        if (r8 == false) goto L43;
        List<IOnPickNotify> r5 = this.mOnPickNotifyList;
        if (r5 == null) goto L42;
        Iterator<T> r6 = r5.iterator();
    L40:
        if (r6.hasNext() == false) goto L42;
        IOnPickNotify r12 = (IOnPickNotify) r6.next();
        r12.onSelected(r7.getId(), r7);
        r12.onChanged(CollectionsKt.mutableListOf(new String[]{r7.getId()}), CollectionsKt.mutableListOf(new SearchBaseInfo[]{r7}));
    L42:
        notifySelect(r8, r7, r9);
        notifySelected(CollectionsKt.listOf(r7));
        goto L44
    L43:
        Log.e(TAG, "single select, deselect is unreasonable!");
        goto L44
    }

    public void doItemClick(SearchBaseInfo r1, boolean r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "data");
        dealSelectAndDeselected(r1, r2, PickSourceType.CLICK);
    }

    public static FragmentTransaction INVOKEVIRTUAL_com_ss_android_lark_picker_base_widget_BasePicker_com_obric_assistant_interaction_impl_window_helpers_FragmentTransactionLancet_add(FragmentTransaction r2, Fragment r3, String r4) {
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r2, r3, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, r4, 0) == false) goto L6;
        return r2;
    L6:
        return r2.add(r3, r4);
    }

    public static FragmentTransaction INVOKEVIRTUAL_com_ss_android_lark_picker_base_widget_BasePicker_com_obric_assistant_interaction_impl_window_helpers_FragmentTransactionLancet_replace(FragmentTransaction r1, int r2, Fragment r3, String r4) {
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r1, r3, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, r4, r2) == false) goto L6;
        return r1;
    L6:
        return r1.replace(r2, r3, r4);
    }

    public static final /* synthetic */ Object access$getNetSearchResult(BasePicker r0, String r1, SearchContext r2, Continuation r3) {
        return r0.getNetSearchResult(r1, r2, r3);
    }

    public static final /* synthetic */ Object access$getSpotlightSearchResult(BasePicker r0, String r1, SearchContext r2, Continuation r3) {
        return r0.getSpotlightSearchResult(r1, r2, r3);
    }

    public static final /* synthetic */ void access$notifySelect(BasePicker r0, boolean r1, SearchBaseInfo r2, PickSourceType r3) {
        r0.notifySelect(r1, r2, r3);
    }

    public static /* synthetic */ void defaultMode$default(BasePicker r0, boolean r1, int r2, Object r3) {
        if (r3 != null) goto L9;
        if ((r2 & 1) == 0) goto L6;
        r1 = true;
    L6:
        r0.defaultMode(r1);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: defaultMode");
    }

    public final void switchFragmentWithAnimations(BaseFragment r2, BaseFragment r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r2, "currentFragment");
        Intrinsics.checkNotNullParameter(r3, "targetFragment");
        IViewDependency r0 = this.mDependency;
        if (r0 == null) goto L7;
        FragmentManager r1 = r0.getFragmentManager();
        if (r1 == null) goto L7;
        FragmentTransaction r6 = r1.beginTransaction();
    L8:
        if (r6 == null) goto L11;
        r6.setCustomAnimations(r4, r5);
    L11:
        if (r3.isAdded() == false) goto L14;
        if (r6 == null) goto L17;
        r6.show(r3);
    L17:
        if (r2.isAdded() == false) goto L20;
        if (r6 == null) goto L20;
        r6.hide(r2);
    L20:
        if (r6 == null) goto L23;
        r6.commitAllowingStateLoss();
        return;
    L23:
        return;
    L14:
        if (r6 == null) goto L17;
        INVOKEVIRTUAL_com_ss_android_lark_picker_base_widget_BasePicker_com_obric_assistant_interaction_impl_window_helpers_FragmentTransactionLancet_add(r6, 2131382270, r3);
    L7:
        r6 = null;
        goto L8
    }

    public static /* synthetic */ BasePicker attachSearchEmptyViewConfig$default(BasePicker r1, Integer r2, CharSequence r3, int r4, Object r5) {
        if (r5 != null) goto L12;
        if ((r4 & 1) == 0) goto L7;
        r2 = null;
    L7:
        if ((r4 & 2) == 0) goto L10;
        r3 = null;
    L10:
        return r1.attachSearchEmptyViewConfig(r2, r3);
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: attachSearchEmptyViewConfig");
    }

    public static /* synthetic */ BasePicker attachTopCustomView$default(BasePicker r0, View r1, boolean r2, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 2) == 0) goto L7;
        r2 = true;
    L7:
        return r0.attachTopCustomView(r1, r2);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: attachTopCustomView");
    }

    public static /* synthetic */ void handleSearchResponse$default(BasePicker r0, SearchResponse r1, boolean r2, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 2) == 0) goto L6;
        r2 = false;
    L6:
        r0.handleSearchResponse(r1, r2);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: handleSearchResponse");
    }

    public static /* synthetic */ void switchMultipleStatus$default(BasePicker r0, boolean r1, boolean r2, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 2) == 0) goto L6;
        r2 = false;
    L6:
        r0.switchMultipleStatus(r1, r2);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: switchMultipleStatus");
    }
}
