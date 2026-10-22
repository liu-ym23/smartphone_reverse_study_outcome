package com.larus.dora.obric.device_management.device_home;

import android.R;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.os.BundleKt;
import androidx.core.view.OneShotPreDrawListener;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.viewbinding.ViewBindings;
import com.bytedance.dora.device.DoraDevice;
import com.bytedance.router.SmartRouter;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.databinding.LarusDoraPageObricDeviceHomeBinding;
import com.larus.dora.impl.device.DoraBaseFragment;
import com.larus.dora.impl.resource.DoraDrawableDensity;
import com.larus.dora.impl.resource.DoraResourceDeviceType;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.larus.dora.impl.settings.DoraSetting;
import com.larus.dora.o.api.DefaultDoraODiaryService;
import com.larus.dora.o.api.DefaultDoraOHealthService;
import com.larus.dora.o.api.DefaultDoraOUIService;
import com.larus.dora.o.api.IDoraODiaryService;
import com.larus.dora.o.api.IDoraOHealthService;
import com.larus.dora.o.api.IDoraOUIService;
import com.larus.dora.obric.device_management.explore.DoraObricExploreFragment;
import com.larus.dora.obric.device_management.explore.DoraObricGlassesExploreFragment;
import com.larus.dora.obric.device_v2.ObricDoraGConnectFailedDialogFragment;
import com.larus.dora.obric.onboarding.ObricDoraGEnvAuthResult;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.obric.oui.actionbar.v2.OBottomActionBarNormalHorizontal;
import com.obric.oui.bouncelayout.ONestedScrollView;
import com.obric.oui.button.OButton;
import com.obric.oui.dialog.base.AbstractDialog;
import com.obric.oui.divider.ODivider;
import com.obric.oui.image.OImage;
import com.obric.oui.layout.OUIFrameLayout;
import com.obric.oui.layout.OUILinearLayout;
import com.obric.oui.lisitem.OUICardConstraintLayout;
import com.obric.oui.material.OMaterialHelper;
import com.obric.oui.orecyclerview.widget.GridLayoutManager;
import com.obric.oui.orecyclerview.widget.LinearLayoutManager;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.sectiontitlebar.OSectionTitleBar;
import com.obric.oui.segmentedtab.OBottomNavActionBar;
import com.obric.oui.segmentedtab.OBottomNavigationBar;
import com.obric.oui.tag.OTextTag;
import com.obric.oui.text.OTextView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.flow.StateFlowImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000»\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u000e*\u0001N\u0018\u0000 \u008f\u00022\u00020\u0001:\f\u008a\u0002\u008b\u0002\u008c\u0002\u008d\u0002\u008e\u0002\u008f\u0002B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010P\u001a\u00020Q2\u0006\u0010R\u001a\u00020S2\b\u0010T\u001a\u0004\u0018\u00010U2\b\u0010V\u001a\u0004\u0018\u00010BH\u0016J\u0010\u0010W\u001a\u00020X2\u0006\u0010Y\u001a\u00020ZH\u0016J\u001a\u0010[\u001a\u00020X2\u0006\u0010\\\u001a\u00020Q2\b\u0010V\u001a\u0004\u0018\u00010BH\u0016J\u0010\u0010]\u001a\u00020X2\b\u0010^\u001a\u0004\u0018\u00010BJ\b\u0010_\u001a\u00020XH\u0016J\b\u0010`\u001a\u00020XH\u0016J\b\u0010a\u001a\u00020XH\u0016J\b\u0010b\u001a\u00020\u000eH\u0016J\u001c\u0010c\u001a\u00020\u00102\b\b\u0001\u0010d\u001a\u00020\u00102\b\b\u0001\u0010e\u001a\u00020\u0010H\u0002J\b\u0010f\u001a\u00020\u0017H\u0016J\b\u0010g\u001a\u00020XH\u0002J\b\u0010h\u001a\u00020XH\u0002J\b\u0010i\u001a\u00020XH\u0002J\b\u0010j\u001a\u00020XH\u0002J\b\u0010k\u001a\u00020XH\u0002J\b\u0010l\u001a\u00020XH\u0002J\b\u0010m\u001a\u00020XH\u0002J\u0010\u0010n\u001a\u00020X2\u0006\u0010o\u001a\u00020\u0010H\u0002J\u0010\u0010p\u001a\u00020X2\u0006\u0010o\u001a\u00020\u0010H\u0002J\u0018\u0010q\u001a\u00020X2\u0006\u0010r\u001a\u00020s2\u0006\u0010t\u001a\u00020QH\u0002J\b\u0010u\u001a\u00020XH\u0002J\b\u0010v\u001a\u00020XH\u0002J\b\u0010w\u001a\u00020XH\u0002J\b\u0010x\u001a\u00020XH\u0002J\u0010\u0010y\u001a\u00020X2\u0006\u0010z\u001a\u00020\u000eH\u0002J\b\u0010{\u001a\u00020XH\u0002J\u0010\u0010|\u001a\u00020X2\u0006\u0010z\u001a\u00020\u000eH\u0002J\b\u0010}\u001a\u00020XH\u0002J\u0011\u0010~\u001a\u00020X2\u0007\u0010\u007f\u001a\u00030\u0080\u0001H\u0002J\u0011\u0010\u0081\u0001\u001a\u00020X2\u0006\u0010z\u001a\u00020\u000eH\u0002J\t\u0010\u0082\u0001\u001a\u00020XH\u0002J\u0011\u0010\u0083\u0001\u001a\u00020X2\u0006\u0010z\u001a\u00020\u000eH\u0002J\t\u0010\u0084\u0001\u001a\u00020XH\u0002J\t\u0010\u0085\u0001\u001a\u00020XH\u0002J\t\u0010\u0086\u0001\u001a\u00020XH\u0002J\t\u0010\u0087\u0001\u001a\u00020XH\u0002J\u0015\u0010\u0088\u0001\u001a\u00020X2\n\u0010\u0089\u0001\u001a\u0005\u0018\u00010\u008a\u0001H\u0002J\t\u0010\u008b\u0001\u001a\u00020XH\u0002J\t\u0010\u008c\u0001\u001a\u00020XH\u0002J\u001d\u0010\u008d\u0001\u001a\u00020X2\b\u0010\u008e\u0001\u001a\u00030\u008f\u00012\b\u0010\u0090\u0001\u001a\u00030\u0091\u0001H\u0002J\t\u0010\u0092\u0001\u001a\u00020XH\u0002J\t\u0010\u0093\u0001\u001a\u00020XH\u0002J\u0013\u0010\u0094\u0001\u001a\u00020X2\b\u0010\u0095\u0001\u001a\u00030\u0096\u0001H\u0002J\t\u0010\u0097\u0001\u001a\u00020XH\u0003J\t\u0010\u0098\u0001\u001a\u00020XH\u0002J\u0018\u0010\u0099\u0001\u001a\u00020X2\r\u0010\u0089\u0001\u001a\b0\u009a\u0001j\u0003`\u009b\u0001H\u0002J\u0011\u0010\u009c\u0001\u001a\u0005\u0018\u00010\u009d\u0001*\u00030\u009e\u0001H\u0002J\t\u0010\u009f\u0001\u001a\u00020XH\u0002J\u001a\u0010 \u0001\u001a\u00020X2\u0006\u0010z\u001a\u00020\u000e2\u0007\u0010¡\u0001\u001a\u00020\u0015H\u0002J\t\u0010¢\u0001\u001a\u00020XH\u0002J\u0013\u0010£\u0001\u001a\u00020X2\b\u0010\u008e\u0001\u001a\u00030\u008f\u0001H\u0002J\u001c\u0010¤\u0001\u001a\u00020X2\b\u0010\u008e\u0001\u001a\u00030\u008f\u00012\u0007\u0010¥\u0001\u001a\u00020\u0017H\u0002J\u0013\u0010¦\u0001\u001a\u00020X2\b\u0010\u008e\u0001\u001a\u00030\u008f\u0001H\u0003J\t\u0010§\u0001\u001a\u00020XH\u0002J\u0013\u0010¨\u0001\u001a\u00020X2\b\u0010\u008e\u0001\u001a\u00030\u008f\u0001H\u0002J\u0013\u0010©\u0001\u001a\u00020X2\b\b\u0002\u0010z\u001a\u00020\u000eH\u0002J\t\u0010ª\u0001\u001a\u00020XH\u0002J\t\u0010«\u0001\u001a\u00020XH\u0002J\u0013\u0010¬\u0001\u001a\u00020X2\b\u0010z\u001a\u0004\u0018\u00010\u000eH\u0002J\u0018\u0010\u00ad\u0001\u001a\u00020X2\r\u0010\u0089\u0001\u001a\b0\u009a\u0001j\u0003`\u009b\u0001H\u0002J\u0012\u0010®\u0001\u001a\u00020X2\u0007\u0010¯\u0001\u001a\u00020\u000eH\u0002J\t\u0010°\u0001\u001a\u00020XH\u0002J\t\u0010±\u0001\u001a\u00020XH\u0002J\u0012\u0010²\u0001\u001a\u00020X2\u0007\u0010¯\u0001\u001a\u00020\u000eH\u0002J\t\u0010³\u0001\u001a\u00020\u000eH\u0002J\t\u0010´\u0001\u001a\u00020XH\u0002J\t\u0010µ\u0001\u001a\u00020XH\u0002J\u0018\u0010¶\u0001\u001a\u00020X2\r\u0010\u0089\u0001\u001a\b0\u009a\u0001j\u0003`\u009b\u0001H\u0002J\u0015\u0010·\u0001\u001a\u0004\u0018\u0001032\b\u0010^\u001a\u0004\u0018\u00010BH\u0002J\u0015\u0010¸\u0001\u001a\u0004\u0018\u00010\u000e2\b\u0010^\u001a\u0004\u0018\u00010BH\u0002J\u0019\u0010¹\u0001\u001a\u00020\u00172\u000e\u0010º\u0001\u001a\t\u0012\u0005\u0012\u00030»\u00010\rH\u0002J\t\u0010¼\u0001\u001a\u00020XH\u0002J#\u0010½\u0001\u001a\u00020X2\u0007\u0010¾\u0001\u001a\u00020\u00102\u000f\b\u0002\u0010\u0089\u0001\u001a\b0\u009a\u0001j\u0003`\u009b\u0001H\u0002J\t\u0010¿\u0001\u001a\u00020XH\u0002J\u0012\u0010À\u0001\u001a\u00020X2\u0007\u0010Á\u0001\u001a\u00020QH\u0002J\u0012\u0010Â\u0001\u001a\u00020X2\u0007\u0010Á\u0001\u001a\u00020QH\u0002J\u0012\u0010Ã\u0001\u001a\u00020X2\u0007\u0010Ä\u0001\u001a\u00020BH\u0016J\u0012\u0010Å\u0001\u001a\u00020X2\u0007\u0010Æ\u0001\u001a\u00020\u0017H\u0002J\t\u0010Ç\u0001\u001a\u00020XH\u0002J\u001c\u0010È\u0001\u001a\u00020X2\b\u0010É\u0001\u001a\u00030Ê\u00012\u0007\u0010Ë\u0001\u001a\u00020\u000eH\u0002J+\u0010Ì\u0001\u001a\u0005\u0018\u00010Ê\u00012\u0007\u0010Æ\u0001\u001a\u00020\u00172\t\u0010Í\u0001\u001a\u0004\u0018\u00010\u000e2\t\u0010Î\u0001\u001a\u0004\u0018\u00010\u000eH\u0002J\t\u0010Ï\u0001\u001a\u00020XH\u0002J\u0015\u0010Ð\u0001\u001a\u0005\u0018\u00010Ê\u00012\u0007\u0010Ñ\u0001\u001a\u00020\u000eH\u0002J\t\u0010Ò\u0001\u001a\u00020XH\u0002J\t\u0010Ó\u0001\u001a\u00020XH\u0002J\t\u0010Ô\u0001\u001a\u00020\u0017H\u0002J\u0012\u0010Õ\u0001\u001a\u00020\u000e2\u0007\u0010Ö\u0001\u001a\u00020\u000eH\u0002J\t\u0010×\u0001\u001a\u00020BH\u0002J\u0018\u0010Ø\u0001\u001a\u00020X2\r\u0010\u0089\u0001\u001a\b0\u009a\u0001j\u0003`\u009b\u0001H\u0002J\u0012\u0010Ù\u0001\u001a\u00020X2\u0007\u0010¾\u0001\u001a\u00020\u0010H\u0002J\u0013\u0010Ú\u0001\u001a\u00020X2\b\u0010Û\u0001\u001a\u00030Ü\u0001H\u0002J\t\u0010Ý\u0001\u001a\u00020XH\u0002J\u001c\u0010Þ\u0001\u001a\u00020X2\b\u0010ß\u0001\u001a\u00030à\u00012\u0007\u0010á\u0001\u001a\u00020QH\u0002J\t\u0010â\u0001\u001a\u00020XH\u0002J\u001a\u0010ã\u0001\u001a\u00020X2\u0006\u0010\\\u001a\u00020Q2\u0007\u0010ä\u0001\u001a\u00020\u0017H\u0002J\u001c\u0010å\u0001\u001a\u00020X2\b\u0010ß\u0001\u001a\u00030à\u00012\u0007\u0010æ\u0001\u001a\u00020\u0017H\u0002J\u0013\u0010ç\u0001\u001a\u00020X2\b\u0010ß\u0001\u001a\u00030à\u0001H\u0002J\t\u0010è\u0001\u001a\u00020XH\u0002J\u0012\u0010é\u0001\u001a\u00020X2\u0007\u0010ê\u0001\u001a\u00020\u0017H\u0002J\t\u0010ë\u0001\u001a\u00020XH\u0002J\u0019\u0010ì\u0001\u001a\u00020X2\u000e\u0010í\u0001\u001a\t\u0012\u0005\u0012\u00030î\u00010\rH\u0002J!\u0010ï\u0001\u001a\u0004\u0018\u00010X2\u000e\u0010º\u0001\u001a\t\u0012\u0005\u0012\u00030»\u00010\rH\u0002¢\u0006\u0003\u0010ð\u0001J\u000e\u0010ñ\u0001\u001a\u00020X*\u00030ò\u0001H\u0002J\u001d\u0010ó\u0001\u001a\u00030ô\u00012\b\u0010õ\u0001\u001a\u00030»\u00012\u0007\u0010ö\u0001\u001a\u00020\u0017H\u0002J\u001c\u0010÷\u0001\u001a\u00020\u00102\b\u0010õ\u0001\u001a\u00030»\u00012\u0007\u0010ö\u0001\u001a\u00020\u0017H\u0002J\u001c\u0010ø\u0001\u001a\u00020X2\u0007\u0010ù\u0001\u001a\u00020\u000e2\b\u0010^\u001a\u0004\u0018\u00010BH\u0002J\u0015\u0010ú\u0001\u001a\u00020X2\n\u0010\u008e\u0001\u001a\u0005\u0018\u00010\u008f\u0001H\u0002J\u001e\u0010û\u0001\u001a\u00020X2\n\u0010\u008e\u0001\u001a\u0005\u0018\u00010\u008f\u00012\u0007\u0010ü\u0001\u001a\u00020\u000eH\u0003J\t\u0010ý\u0001\u001a\u00020XH\u0002J\t\u0010þ\u0001\u001a\u00020XH\u0002J\t\u0010ÿ\u0001\u001a\u00020XH\u0002J\t\u0010\u0080\u0002\u001a\u00020XH\u0002J\u000b\u0010\u0085\u0002\u001a\u0004\u0018\u00010\u000eH\u0002J\u000b\u0010\u0086\u0002\u001a\u0004\u0018\u00010BH\u0002J\u0010\u0010\u0087\u0002\u001a\u0004\u0018\u00010\u000e*\u00030\u0080\u0001H\u0002J\r\u0010\u0088\u0002\u001a\u00020\u000e*\u000203H\u0002J\r\u0010\u0089\u0002\u001a\u00020\u000e*\u000203H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0016\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0011R\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0011R\u001c\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010)\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010*\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0004\n\u0002\u0010+R\u0010\u0010,\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u000100X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00101\u001a\b\u0012\u0004\u0012\u00020302X\u0082\u0004¢\u0006\u0002\n\u0000R$\u00105\u001a\u0002032\u0006\u00104\u001a\u0002038B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u0010\u0010:\u001a\u0004\u0018\u000103X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010;\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010<\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0011R\u000e\u0010=\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010>\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010A\u001a\u0004\u0018\u00010BX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010H\u001a\u00020I8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bL\u0010\u000b\u001a\u0004\bJ\u0010KR\u0010\u0010M\u001a\u00020NX\u0082\u0004¢\u0006\u0004\n\u0002\u0010OR\u0018\u0010\u0081\u0002\u001a\u00030\u0082\u00028BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u0083\u0002\u0010\u0084\u0002¨\u0006\u0090\u0002"}, d2 = {"Lcom/larus/dora/obric/device_management/device_home/DoraObricDeviceHomeFragment;", "Lcom/larus/dora/impl/device/DoraBaseFragment;", "<init>", "()V", "binding", "Lcom/larus/dora/impl/databinding/LarusDoraPageObricDeviceHomeBinding;", "viewModel", "Lcom/larus/dora/obric/device_management/device_home/DoraObricDeviceHomeViewModel;", "getViewModel", "()Lcom/larus/dora/obric/device_management/device_home/DoraObricDeviceHomeViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "bottomTabTitles", "", "", "bottomTabIconSelectedIndex", "", "Ljava/lang/Integer;", "selectedBottomTabIndex", "pendingEnvironmentMemoryAuthorization", "Lkotlin/Pair;", "", "suppressBottomTabEvent", "", "connectFailedDialog", "Lcom/larus/dora/obric/device_v2/ObricDoraGConnectFailedDialogFragment;", "quickActionReconnectDialog", "Landroid/content/DialogInterface;", "unbindDialog", "btSwitch", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "deviceCardAdapter", "Lcom/larus/dora/obric/device_management/device_home/DoraObricDeviceHomeDeviceCardAdapter;", "quickActionAdapter", "Lcom/larus/dora/obric/device_management/device_home/DoraObricDeviceHomeQuickActionAdapter;", "deviceCardLayoutManager", "Lcom/obric/oui/orecyclerview/widget/LinearLayoutManager;", "deviceCardSnapHelper", "Lcom/obric/oui/orecyclerview/widget/LinearSnapHelper;", "renderedSelectedDeviceMac", "renderedDeviceCardMacs", "renderedDiaryHasData", "Ljava/lang/Boolean;", "renderedDiaryGlassesMac", "renderedHealthUrl", "renderedDeviceCardImageKey", "renderedHomeStructure", "Lcom/larus/dora/obric/device_management/device_home/DoraObricDeviceHomeFragment$RenderedHomeStructure;", "selectedBottomTabPageState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/larus/dora/obric/device_management/device_home/DoraObricDeviceHomeTabPage;", "value", "selectedBottomTabPage", "getSelectedBottomTabPage", "()Lcom/larus/dora/obric/device_management/device_home/DoraObricDeviceHomeTabPage;", "setSelectedBottomTabPage", "(Lcom/larus/dora/obric/device_management/device_home/DoraObricDeviceHomeTabPage;)V", "pendingTargetTabPage", "pendingDiaryDate", "bottomNavigationBackdropTargetId", "isEmptyDeviceTitleBar", "pendingReconnectDeviceMac", "reconnectStartElapsedRealtime", "initialPageEnterReported", "latestEntryArguments", "Landroid/os/Bundle;", "hasLatestEntryArguments", "pendingEntryArgumentUpdate", "pendingNewEntryExposure", "isViewInitialized", "hasResumedHome", "bottomNavigationAreaBlurMaterial", "Lcom/obric/oui/material/MaterialConfig;", "getBottomNavigationAreaBlurMaterial", "()Lcom/obric/oui/material/MaterialConfig;", "bottomNavigationAreaBlurMaterial$delegate", "deviceUpdateReceiver", "com/larus/dora/obric/device_management/device_home/DoraObricDeviceHomeFragment$deviceUpdateReceiver$1", "Lcom/larus/dora/obric/device_management/device_home/DoraObricDeviceHomeFragment$deviceUpdateReceiver$1;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "onAttach", "", "context", "Landroid/content/Context;", "onViewCreated", "view", "onEntryArgumentsChanged", "arguments", "onResume", "onPause", "onDestroyView", "getCurrentPageName", "dimensionPixelSize", "attrResId", "defaultResId", "autoLogEnterPage", "setupClickListeners", "setupEmptyActionBar", "setupEmptyImage", "setupTitleBar", "configureEmptyTitleBar", "setupDeviceContentInsets", "setupEmptyContentInsets", "updateDeviceContentTopPadding", "statusBarInset", "updateEmptyContentPadding", "setupScrollBounceCompensation", "scrollView", "Lcom/obric/oui/bouncelayout/ONestedScrollView;", "content", "resetScrollBounceCompensation", "setupSectionTitle", "setupQuickActionGrid", "setupDeviceCardCarousel", "onDeviceCardClicked", "deviceMac", "openSelectedDeviceSettings", "openGlassesModeSheet", "reportDeviceCardClick", "onQuickActionClicked", "type", "Lcom/larus/dora/obric/device_management/device_home/DoraObricDeviceHomeQuickActionType;", "onDeviceCardReconnectClicked", "selectSnappedDeviceCard", "scrollToDeviceCard", "setupBottomNavigation", "configureBottomNavigationMargins", "observeUiState", "observeOtaHomeCardState", "renderOtaHomeCard", "state", "Lcom/larus/dora/impl/ota/g2/G2OtaHomeCardState;", "openSelectedDeviceOta", "observeSilentOtaCompletion", "showSilentOtaCompletion", "device", "Lcom/bytedance/dora/device/DoraDevice;", "notice", "Lcom/larus/dora/impl/ota/g2/SilentOtaCompletionNotice;", "setupDiaryDataChangeListener", "setupGlassesModeSheetResultListener", "executeGlassesModeSheetCommand", "command", "Lcom/larus/dora/obric/device_management/device_home/DoraObricGlassesModeSheetCommand;", "showGlassesShutdownConfirmDialog", "dismissGlassesModeSheet", "renderGlassesModeSheetSelection", "Lcom/larus/dora/obric/device_management/device_home/DoraObricDeviceHomeViewModel$UiState;", "Lcom/larus/dora/obric/device_management/device_home/DoraObricDeviceHomeUiState;", "toApiGlassesMode", "Lcom/larus/dora/api/GlassesMode;", "Lcom/larus/dora/obric/device_management/device_home/DoraObricGlassesMode;", "observeActions", "showEnvironmentMemoryAuthorization", "requestId", "observeDeviceActions", "handleUnbind", "showGUnbindDialog", "isG2Series", "showNotGUnbindDialog", "dismissUnbindDialog", "unbindAndDisconnect", "checkReadyForReconnect", "requestBluetoothPermissionForReconnect", "requestEnableBluetoothForReconnect", "startReconnect", "render", "reportInitialPageEnterIfNeeded", "currentPage", "reportNewEntryExposureWhenReady", "reportNewEntryExposure", "reportPageEnter", "currentPageForExposure", "renderLoading", "renderEmptyDevice", "renderBoundDeviceContent", "resolveEntryTargetTabPage", "resolveEntryDiaryDate", "consumePendingTargetTab", "tabs", "Lcom/larus/dora/obric/device_management/device_home/DoraObricDeviceHomeTab;", "applyPendingTargetTabOnNewEntry", "renderSelectedTab", "position", "updateBottomNavigationBackdropTarget", "applyBottomNavigationAreaBlur", "target", "applyBottomNavigationFrostedBackground", "onSaveInstanceState", "outState", "ensureDiaryFragment", "hasDiaryData", "applyPendingDiaryDateOnCurrentTab", "selectDiaryFragmentDate", "fragment", "Landroidx/fragment/app/Fragment;", "date", "createDiaryFragment", "glassesMac", "initialDate", "ensureHealthFragment", "createHealthFragment", "url", "fallbackToDeviceTab", "ensureDiscoverFragment", "shouldUseGlassesExploreFragment", "buildChildFragmentTag", "prefix", "createChildPageArguments", "renderDeviceCards", "scrollToSelectedDeviceCard", "renderDeviceCard", "item", "Lcom/larus/dora/obric/device_management/device_home/DoraObricDeviceHomeDeviceCardItem;", "startReconnectUiTiming", "reportReconnectUiRendered", "card", "Lcom/larus/dora/obric/device_management/device_home/DoraObricDeviceHomeDeviceCardUiState;", "cardContainer", "cancelReconnectUiTiming", "renderChargingIcon", "isCharging", "renderDeviceModeTag", "showLegacyModeTag", "renderDeviceConnectionState", "setupAlbumCard", "updateAlbumVisibility", "visible", "reportAlbumEntryClick", "renderQuickActions", "actions", "Lcom/larus/dora/obric/device_management/device_home/DoraObricDeviceHomeQuickAction;", "renderBottomTabs", "(Ljava/util/List;)Lkotlin/Unit;", "requestBottomNavigationLayout", "Lcom/obric/oui/segmentedtab/OBottomNavActionBar;", "getBottomNavigationIconDrawable", "Landroid/graphics/drawable/Drawable;", "tab", "selected", "getBottomNavigationIconRes", "openRoute", "route", "showConnectFailedDialog", "showQuickActionReconnectDialog", "featureName", "dismissQuickActionReconnectDialog", "dismissConnectFailedDialog", "registerDeviceUpdateReceiver", "unregisterDeviceUpdateReceiver", "applicationContext", "Landroid/app/Application;", "getApplicationContext", "()Landroid/app/Application;", "resolveEntryMethod", "entryArguments", "cardContentType", "currentPageName", "tabName", "DeviceCardTouchInterceptor", "DeviceCardSnapHelper", "DeviceCardSpacingDecoration", "QuickActionSpacingDecoration", "RenderedHomeStructure", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraObricDeviceHomeFragment extends DoraBaseFragment {
    public static final /* synthetic */ int R = 0;
    public f A;
    public final StateFlowImpl B;
    public DoraObricDeviceHomeTabPage C;
    public String D;
    public Integer E;
    public boolean F;
    public String G;
    public long H;
    public boolean I;
    public Bundle J;
    public boolean K;
    public boolean L;
    public boolean M;
    public boolean N;
    public boolean O;
    public final Lazy P;
    public final DoraObricDeviceHomeFragment$deviceUpdateReceiver$1 Q;
    public LarusDoraPageObricDeviceHomeBinding f;
    public final Lazy g;
    public List<String> h;
    public Integer i;
    public Integer j;
    public Pair<String, Long> k;
    public boolean l;
    public ObricDoraGConnectFailedDialogFragment m;
    public com.obric.oui.dialog.v2.alert.c n;
    public AbstractDialog o;
    public ActivityResultLauncher<Intent> p;
    public j q;
    public n1 r;
    public LinearLayoutManager s;
    public b t;
    public String u;
    public List<String> v;
    public Boolean w;
    public String x;
    public String y;
    public String z;

    public static final class a {
    }

    public final class b extends com.obric.oui.orecyclerview.widget.v {
        public final /* synthetic */ DoraObricDeviceHomeFragment f;

        public b(DoraObricDeviceHomeFragment r1) {
            this.f = r1;
        }

        public final int[] b(RecyclerView.k r5, View r6) {
            Intrinsics.checkNotNullParameter(r5, "layoutManager");
            Intrinsics.checkNotNullParameter(r6, "targetView");
            int[] r0 = super.b(r5, r6);
            if (r5.c() == true) goto L5;
            return r0;
        L5:
            int r1 = RecyclerView.k.F(r6);
            int r2 = h.a;
            int r3 = h.a(this.f.requireContext());
            if (r1 != 0) goto L9;
            int r7 = r6.getLeft() - r3;
        L12:
            r0[0] = r7;
            return r0;
        L9:
            if (r1 != (r5.A() - 1)) goto L11;
            r7 = r6.getRight() - (r5.l - r3);
            goto L12
        L11:
            r7 = (r6.getLeft() + (r6.getWidth() / 2)) - (r5.l / 2);
            goto L12
        }
    }

    public final class c extends RecyclerView.j {
        public final int a;
        public final int b;

        public c(DoraObricDeviceHomeFragment r5) {
            int r0 = h.a;
            Context r1 = r5.requireContext();
            Intrinsics.checkNotNullParameter(r1, "context");
            this.a = r1.getResources().getDimensionPixelSize(v19.c.b(2130971546, r1, 2131167462));
            this.b = h.a(r5.requireContext());
        }

        public final void c(Rect r2, View r3, RecyclerView r4, RecyclerView.v r5) {
            Intrinsics.checkNotNullParameter(r2, "outRect");
            Intrinsics.checkNotNullParameter(r3, "view");
            Intrinsics.checkNotNullParameter(r4, "parent");
            Intrinsics.checkNotNullParameter(r5, "state");
            int r0 = 0;
            r2.set(0, 0, 0, 0);
            int r6 = r4.C(r3);
            if (r6 != (-1)) goto L5;
            return;
        L5:
            if (r6 != 0) goto L7;
            r0 = this.b;
        L7:
            r2.left = r0;
            if (r6 != (r5.b() - 1)) goto L10;
            int r7 = this.b;
        L11:
            r2.right = r7;
            return;
        L10:
            r7 = this.a;
            goto L11
        }
    }

    public final class d extends RecyclerView.t {
        public final int a;
        public float b;
        public float c;

        public d(DoraObricDeviceHomeFragment r1) {
            this.a = ViewConfiguration.get(r1.requireContext()).getScaledTouchSlop();
        }

        public final boolean a(RecyclerView r5, MotionEvent r6) {
            Intrinsics.checkNotNullParameter(r5, "recyclerView");
            Intrinsics.checkNotNullParameter(r6, "event");
            int r0 = r6.getActionMasked();
            if (r0 != 0) goto L5;
            this.b = r6.getX();
            this.c = r6.getY();
        L22:
            return false;
        L5:
            if (r0 != 1) goto L7;
        L18:
            ViewParent r7 = r5.getParent();
            if (r7 == null) goto L22;
            r7.requestDisallowInterceptTouchEvent(false);
            goto L22
        L7:
            if (r0 != 2) goto L9;
            float r1 = Math.abs(r6.getX() - this.b);
            float r8 = Math.abs(r6.getY() - this.c);
            if (r1 <= this.a) goto L22;
            if (r1 <= r8) goto L22;
            ViewParent r9 = r5.getParent();
            if (r9 == null) goto L22;
            r9.requestDisallowInterceptTouchEvent(true);
            goto L22
        L9:
            if (r0 == 3) goto L18;
            goto L18
        }
    }

    public final class e extends RecyclerView.j {
        public final int a;

        public e(DoraObricDeviceHomeFragment r3) {
            int r0 = DoraObricDeviceHomeFragment.R;
            this.a = r3.ca0(2130971546, 2131167462);
        }

        public final void c(Rect r2, View r3, RecyclerView r4, RecyclerView.v r5) {
            Intrinsics.checkNotNullParameter(r2, "outRect");
            Intrinsics.checkNotNullParameter(r3, "view");
            Intrinsics.checkNotNullParameter(r4, "parent");
            Intrinsics.checkNotNullParameter(r5, "state");
            r2.set(0, 0, 0, 0);
            int r6 = r4.C(r3);
            if (r6 != (-1)) goto L6;
            return;
        L6:
            if ((r6 % 2) != 0) goto L8;
            r2.right = this.a / 2;
        L9:
            if (r6 < 2) goto L12;
            r2.top = this.a;
            return;
        L12:
            return;
        L8:
            r2.left = this.a / 2;
            goto L9
        }
    }

    public static final class f {
        public final String a;
        public final boolean b;
        public final boolean c;
        public final List<m1> d;
        public final List<r1> e;
        public final String f;
        public final String g;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof f) == true) goto L8;
            return false;
        L8:
            f r6 = (f) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.g, r6.g) == true) goto L29;
            return false;
        L29:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            int r2 = 1231;
            if (this.b == false) goto L5;
            int r1 = 1231;
        L6:
            int r3 = (r0 + r1) * 31;
            if (this.c == true) goto L11;
            r2 = 1237;
        L11:
            return ((((((((r3 + r2) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode();
        L5:
            r1 = 1237;
            goto L6
        }

        public final String toString() {
            return "RenderedHomeStructure(selectedDeviceMac=" + this.a + ", hasDiaryData=" + this.b + ", showAlbumSection=" + this.c + ", quickActions=" + this.d + ", bottomTabs=" + this.e + ", pageTitle=" + this.f + ", commonSectionTitle=" + this.g + ')';
        }

        public f(String r2, boolean r3, boolean r4, List<m1> r5, List<r1> r6, String r7, String r8) {
            Intrinsics.checkNotNullParameter(r2, "selectedDeviceMac");
            Intrinsics.checkNotNullParameter(r5, "quickActions");
            Intrinsics.checkNotNullParameter(r6, "bottomTabs");
            Intrinsics.checkNotNullParameter(r7, "pageTitle");
            Intrinsics.checkNotNullParameter(r8, "commonSectionTitle");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
            this.g = r8;
        }
    }

    public /* synthetic */ class g {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;
        public static final /* synthetic */ int[] c = null;
        public static final /* synthetic */ int[] d = null;
        public static final /* synthetic */ int[] e = null;

        static {
            int[] r0 = new int[DoraObricGlassesMode.values().length];
            r0[DoraObricGlassesMode.ASSISTANT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L29
        L66:
            r0[DoraObricGlassesMode.HEADPHONE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L30
        L76:
            r0[DoraObricGlassesMode.UNKNOWN.ordinal()] = 3;     // Catch: NoSuchFieldError -> L31
        L8:
            a = r0;
            int[] r1 = new int[ObricDoraGEnvAuthResult.values().length];
            r1[ObricDoraGEnvAuthResult.AUTHORIZED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L32
        L68:
            r1[ObricDoraGEnvAuthResult.CANCELED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L33
        L78:
            r1[ObricDoraGEnvAuthResult.FAILED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L34
        L12:
            b = r1;
            int[] r2 = new int[DoraObricDeviceHomeTabPage.values().length];
            r2[DoraObricDeviceHomeTabPage.DEVICE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L35
        L58:
            r2[DoraObricDeviceHomeTabPage.DIARY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L36
        L70:
            r2[DoraObricDeviceHomeTabPage.HEALTH.ordinal()] = 3;     // Catch: NoSuchFieldError -> L37
        L46:
            r2[DoraObricDeviceHomeTabPage.DISCOVER.ordinal()] = 4;     // Catch: NoSuchFieldError -> L38
        L18:
            c = r2;
            int[] r3 = new int[DoraObricDeviceHomeDeviceCardType.values().length];
            r3[DoraObricDeviceHomeDeviceCardType.GLASSES.ordinal()] = 1;     // Catch: NoSuchFieldError -> L39
        L72:
            r3[DoraObricDeviceHomeDeviceCardType.EARBUDS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L40
        L21:
            d = r3;
            int[] r4 = new int[DoraObricDeviceHomeQuickActionType.values().length];
            r4[DoraObricDeviceHomeQuickActionType.QUICK_NOTE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L41
        L62:
            r4[DoraObricDeviceHomeQuickActionType.RECORD_MINUTES.ordinal()] = 2;     // Catch: NoSuchFieldError -> L42
        L74:
            r4[DoraObricDeviceHomeQuickActionType.SIMULTANEOUS_INTERPRET.ordinal()] = 3;     // Catch: NoSuchFieldError -> L43
        L48:
            r4[DoraObricDeviceHomeQuickActionType.DOUBAO_ASSISTANT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L44
        L64:
            r4[DoraObricDeviceHomeQuickActionType.NOTIFICATION_BROADCAST.ordinal()] = 5;     // Catch: NoSuchFieldError -> L45
        L27:
            e = r4;
        }
    }

    static {
    }

    public final void ea0() {
        this.j = 0;
        DoraObricDeviceHomeTabPage r1 = DoraObricDeviceHomeTabPage.DEVICE;
        this.B.setValue(r1);
        ma0(((DoraObricDeviceHomeViewModel.c) ia0().getUiState().getValue()).m);
        pa0(this, 0);
    }

    public final String k() {
        return DoraObricDeviceHomeViewModel.PREVIOUS_PAGE_DEVICE_HOME;
    }

    public final void Y90() {
        this.H = 0;
        this.G = null;
    }

    public final Application fa0() {
        gd9.i r0 = com.larus.im.b.a;
        Intrinsics.checkNotNull(r0);
        return r0.getApplication();
    }

    public final DoraObricDeviceHomeTabPage ha0() {
        return (DoraObricDeviceHomeTabPage) this.B.getValue();
    }

    public final DoraObricDeviceHomeViewModel ia0() {
        return (DoraObricDeviceHomeViewModel) this.g.getValue();
    }

    public final void onDestroyView() {
        ObricDoraGConnectFailedDialogFragment r0 = this.m;
        if (r0 != null) goto L44;
    L10:
        this.m = null;
        com.obric.oui.dialog.v2.alert.c r1 = this.n;
        if (r1 == null) goto L13;
        r1.dismiss();
    L13:
        this.n = null;
        AbstractDialog r2 = this.o;
        if (r2 == null) goto L16;
        r2.dismiss();
    L16:
        this.o = null;
        g49.d.d("DoraObricDeviceHomeFragment", "unregisterDeviceUpdateReceiver");
        LocalBroadcastManager.getInstance(fa0()).unregisterReceiver(this.Q);
        LarusDoraPageObricDeviceHomeBinding r3 = this.f;
        if (r3 == null) goto L19;
        r3.R.setTranslationY(0.0f);
        r3.l.setTranslationY(0.0f);
        r3.y.setTranslationY(0.0f);
        r3.z.setTranslationY(0.0f);
    L19:
        LarusDoraPageObricDeviceHomeBinding r4 = this.f;
        if (r4 == null) goto L24;
        ONestedScrollView r5 = r4.y;
        if (r5 == null) goto L24;
        r5.setOnBounceTranslationListener(null);
    L24:
        LarusDoraPageObricDeviceHomeBinding r6 = this.f;
        if (r6 == null) goto L29;
        ONestedScrollView r7 = r6.R;
        if (r7 == null) goto L29;
        r7.setOnBounceTranslationListener(null);
    L29:
        b r8 = this.t;
        if (r8 == null) goto L32;
        r8.a(null);
    L32:
        LarusDoraPageObricDeviceHomeBinding r9 = this.f;
        if (r9 == null) goto L37;
        RecyclerView r10 = r9.n;
        if (r10 == null) goto L37;
        r10.setAdapter(null);
    L37:
        LarusDoraPageObricDeviceHomeBinding r11 = this.f;
        if (r11 == null) goto L42;
        RecyclerView r12 = r11.M;
        if (r12 == null) goto L42;
        r12.setAdapter(null);
    L42:
        this.h = null;
        this.i = null;
        this.j = null;
        this.l = false;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = CollectionsKt.emptyList();
        this.w = null;
        this.x = null;
        this.y = null;
        this.z = null;
        this.A = null;
        this.E = null;
        this.F = false;
        this.G = null;
        this.H = 0;
        this.N = false;
        this.f = null;
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
        return;
    L44:
        r0.dismiss();     // Catch: Exception -> L6
    L6:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r13 = DialogFragmentLancet.sLastShowStack;
        if (r13 == null) goto L10;
        com.bytedance.crash.d.d(r13, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L10
    }

    public final void onPause() {
        LarusDoraPageObricDeviceHomeBinding r0 = this.f;
        if (r0 == null) goto L5;
        r0.R.setTranslationY(0.0f);
        r0.l.setTranslationY(0.0f);
        r0.y.setTranslationY(0.0f);
        r0.z.setTranslationY(0.0f);
    L5:
        super/*androidx.fragment.app.Fragment*/.onPause();
    }

    public final void qa0() {
        if (this.N == true) goto L6;
        this.M = true;
        return;
    L6:
        this.M = false;
        this.I = true;
        if (((DoraObricDeviceHomeViewModel.c) ia0().getUiState().getValue()).a != DoraObricDeviceHomeViewModel.PageState.Empty) goto L9;
        String r0 = DoraObricDeviceHomeViewModel.PREVIOUS_PAGE_DEVICE_HOME;
    L10:
        ra0(r0);
        return;
    L9:
        r0 = ba0(ha0());
        goto L10
    }

    public final void va0() {
        LarusDoraPageObricDeviceHomeBinding r0 = this.f;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.n == null) goto L31;
        b r1 = this.t;
        if (r1 != null) goto L10;
        return;
    L10:
        LinearLayoutManager r2 = this.s;
        if (r2 != null) goto L13;
        return;
    L13:
        View r3 = r1.c(r2);
        if (r3 != null) goto L16;
        return;
    L16:
        int r4 = RecyclerView.k.F(r3);
        j r5 = this.q;
        if (r5 == null) goto L29;
        List r6 = ((com.obric.oui.orecyclerview.widget.w) r5).c.f;
        if (r6 == null) goto L30;
        q r7 = (q) CollectionsKt.getOrNull(r6, r4);
        if (r7 != null) goto L24;
        return;
    L24:
        if (Intrinsics.areEqual(r7.a, ((DoraObricDeviceHomeViewModel.c) ia0().getUiState().getValue()).c) == false) goto L26;
        return;
    L26:
        g49.d.d("DoraObricDeviceHomeFragment", "selectSnappedDeviceCard mac=" + r7.a + " position=" + r4);
        ia0().onDeviceCardPageSelected(r7.a);
        return;
    L30:
        return;
    L29:
        return;
    }

    public final void wa0() {
        LarusDoraPageObricDeviceHomeBinding r0 = this.f;
        if (r0 == null) goto L8;
        final OFloatingTitleBar r1 = r0.T;
        if (r1 == null) goto L9;
        r1.setMaskBlurRadius(8.0f);
        r1.setStartTitle(null);
        r1.setCenterTitle(null);
        OFloatingTitleBar.V(r1, null, CollectionsKt.emptyList(), false, 7);
        r1.h(2131244206, -1, new k0(this));
        ViewCompat.setOnApplyWindowInsetsListener(r1, new l0(r1));
        ViewCompat.requestApplyInsets(r1);
        return;
    L9:
        return;
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeFragment$deviceUpdateReceiver$1] */
    public DoraObricDeviceHomeFragment() {
        final Function0<Fragment> r0 = new DoraObricDeviceHomeFragment$special$$inlined$viewModels$default$1(this);
        this.g = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(DoraObricDeviceHomeViewModel.class), new DoraObricDeviceHomeFragment$special$$inlined$viewModels$default$2(r0), new DoraObricDeviceHomeFragment$special$$inlined$viewModels$default$3(r0, this));
        this.v = CollectionsKt.emptyList();
        this.B = kotlinx.coroutines.flow.j1.a(DoraObricDeviceHomeTabPage.DEVICE);
        this.P = LazyKt.lazy(new f0(this));
        this.Q = new DoraObricDeviceHomeFragment$deviceUpdateReceiver$1(this);
    }

    public final void la0() {
        if (((DoraObricDeviceHomeViewModel.c) ia0().getUiState().getValue()).b != null) goto L5;
        return;
    L5:
        y69.a.c("device_card");
        ia0().onDeviceCardClicked();
    }

    public final void onResume() {
        super.onResume();
        Pair<String, Long> r0 = this.k;
        if (r0 == null) goto L6;
        String r1 = (String) r0.component1();
        long r2 = ((Number) r0.component2()).longValue();
        this.k = null;
        ia0().resumeEnvironmentMemoryAuthorization(r1, r2);
    L6:
        if (this.O == false) goto L8;
        g49.d.d("DoraObricDeviceHomeFragment", "home resumed, check current device bind state");
        ia0().checkCurrentDeviceBindState("home_resume", true);
    L8:
        this.O = true;
        if (this.M == false) goto L12;
        qa0();
        return;
    }

    public static void W90(com.obric.oui.dialog.v2.alert.c r1) {
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

    public static String ba0(DoraObricDeviceHomeTabPage r1) {
        int r2 = g.c[r1.ordinal()];
        if (r2 != 1) goto L5;
        return DoraObricDeviceHomeViewModel.PREVIOUS_PAGE_DEVICE_HOME;
    L5:
        if (r2 != 2) goto L7;
        return "diary_detail";
    L7:
        if (r2 != 3) goto L9;
        return "health_home";
    L9:
        if (r2 != 4) goto L12;
        return "explore_home";
    L12:
        throw new NoWhenBranchMatchedException();
    }

    public static DoraObricDeviceHomeTabPage sa0(Bundle r3) {
        if (r3 == null) goto L5;
        String r4 = r3.getString("obric_device_home_tab");
    L6:
        if (r4 == null) goto L20;
        int r1 = r4.hashCode();
        if (r1 == (-1335157162)) goto L17;
        if (r1 == 95577027) goto L13;
        return null;
    L13:
        if (r4.equals("diary") == true) goto L21;
        return null;
    L21:
        return DoraObricDeviceHomeTabPage.DIARY;
    L17:
        if (r4.equals("device") == true) goto L19;
        return null;
    L19:
        return DoraObricDeviceHomeTabPage.DEVICE;
    L20:
        return null;
    L5:
        r4 = null;
        goto L6
    }

    public final void Z90(String r8) {
        if (r8.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        return;
    L9:
        if (Intrinsics.areEqual(this.G, r8) == true) goto L11;
        this.H = SystemClock.elapsedRealtime();
        g49.d.a("DoraObricDeviceHomeFragment", "reconnect UI timing started");
    L11:
        this.G = r8;
        g49.d.d("DoraObricDeviceHomeFragment", "checkReadyForReconnect mac=".concat(r8));
        ia0().onReconnectStarted(r8);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new DoraObricDeviceHomeFragment$checkReadyForReconnect$1(this, r8, null), 3, null);
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final boolean aa0(List<r1> r5) {
        DoraObricDeviceHomeTabPage r0 = this.C;
        if (r0 != null) goto L6;
        return false;
    L6:
        if (r5.isEmpty() == false) goto L8;
        return false;
    L8:
        this.C = null;
        List<r1> r6 = r5;
        if ((r6 instanceof Collection) == true) goto L11;
    L13:
        Iterator<T> r7 = r6.iterator();
    L15:
        if (r7.hasNext() == false) goto L22;
        if (((r1) r7.next()).b != r0) goto L19;
        boolean r2 = true;
    L20:
        if (r2 == false) goto L15;
        boolean r8 = false;
    L24:
        if (r8 == false) goto L28;
        g49.d.d("DoraObricDeviceHomeFragment", "drop entry target tab, unsupported by current device, target=" + r0);
        return false;
    L28:
        if (ha0() != r0) goto L30;
        return false;
    L30:
        g49.d.d("DoraObricDeviceHomeFragment", "apply entry target tab=" + r0);
        this.B.setValue(r0);
        return true;
    L19:
        r2 = false;
    L22:
        r8 = true;
        goto L24
    L11:
        if (r6.isEmpty() == false) goto L13;
        goto L13
    }

    public final void da0(x2 r13) {
        IDoraService r0 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r0 == null) goto L5;
        DeviceService r1 = r0.device();
    L6:
        DeviceService r5 = r1;
        if (r5 != null) goto L10;
        g49.d.b("DoraObricDeviceHomeFragment", "execute glasses mode command failed: device service unavailable");
        t19.s r14 = t19.s.a;
        Application r2 = fa0();
        r14.getClass();
        t19.s.b(r2, 2131903992, false);
        return;
    L10:
        String r4 = ((DoraObricDeviceHomeViewModel.c) ia0().getUiState().getValue()).c;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new DoraObricDeviceHomeFragment$executeGlassesModeSheetCommand$1(r13, this, r4, r5, null), 3, null);
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void ja0(String r9) {
        Iterator<T> r0 = ((DoraObricDeviceHomeViewModel.c) ia0().getUiState().getValue()).f.iterator();
    L3:
        DoraObricGlassesModeSheet r2 = null;
        if (r0.hasNext() == false) goto L8;
        Object r1 = r0.next();
        if (Intrinsics.areEqual(((q) r1).a, r9) == false) goto L3;
    L9:
        q r3 = (q) r1;
        if (r3 != null) goto L13;
        return;
    L13:
        if (r3.b.d == true) goto L16;
        return;
    L16:
        if (getChildFragmentManager().findFragmentByTag("ObricGlassesModeSheet") == null) goto L18;
        return;
    L18:
        DoraObricGlassesMode r10 = r3.d.d;
        if (r10 != DoraObricGlassesMode.UNKNOWN) goto L21;
        boolean r4 = true;
    L22:
        if (r4 == false) goto L25;
        r10 = null;
    L25:
        if (r10 != null) goto L27;
        r10 = DoraObricGlassesMode.ASSISTANT;
    L27:
        int r5 = DoraObricGlassesModeSheet.g;
        DoraObricDeviceModeEntryProduct r6 = r3.c;
        String r7 = r3.b.b;
        Intrinsics.checkNotNullParameter(r6, "product");
        Intrinsics.checkNotNullParameter(r7, "deviceName");
        Intrinsics.checkNotNullParameter(r10, "selectedMode");
        int r8 = b3.a;
        Intrinsics.checkNotNullParameter(r6, "product");
        if (a2.a(r6) == false) goto L31;
        r2 = new DoraObricGlassesModeSheet();
        r2.setArguments(BundleKt.bundleOf(new Pair[]{TuplesKt.to("arg_device_name", r7), TuplesKt.to("arg_selected_mode", r10.name())}));
    L31:
        if (r2 == null) goto L44;
        FragmentManager r11 = getChildFragmentManager();
        LandscapeRestrictionOperation r12 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r2, "ObricGlassesModeSheet", r12);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r11, r2, r12) == true) goto L45;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L38
    L36:
        r2.show(r11, "ObricGlassesModeSheet");
        return;
    L45:
        return;
    L44:
        return;
    L21:
        r4 = false;
        goto L22
    L8:
        r1 = null;
        goto L9
    }

    public final Unit ma0(List<r1> r12) {
        LarusDoraPageObricDeviceHomeBinding r0 = this.f;
        Integer r1 = null;
        if (r0 == null) goto L138;
        OBottomNavigationBar r2 = r0.e;
        if (r2 != null) goto L7;
        return null;
    L7:
        if (r12.isEmpty() == false) goto L9;
        this.h = null;
        this.i = null;
        com.larus.utils.e1.o(r2);
    L120:
        return Unit.INSTANCE;
    L9:
        com.larus.utils.e1.x(r2);
        List<r1> r3 = r12;
        ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));
        Iterator<T> r5 = r3.iterator();
    L11:
        if (r5.hasNext() == false) goto L13;
        r4.add(((r1) r5.next()).a);
        goto L11
    L13:
        Iterator<r1> r6 = r12.iterator();
        int r7 = 0;
    L15:
        if (r6.hasNext() == false) goto L20;
        if (r6.next().c == true) goto L21;
        r7 = r7 + 1;
    L21:
        Integer r8 = Integer.valueOf(r7);
        if (r8.intValue() < 0) goto L24;
        boolean r9 = true;
    L25:
        if (r9 == true) goto L28;
        r8 = null;
    L28:
        if (r8 == null) goto L30;
        int r10 = r8.intValue();
    L31:
        Integer r11 = this.j;
        if (r11 == null) goto L43;
        int r13 = r11.intValue();
        if (r13 >= 0) goto L36;
    L38:
        boolean r14 = false;
    L39:
        if (r14 == false) goto L41;
        r1 = r11;
    L41:
        if (r1 == null) goto L43;
        r10 = r1.intValue();
        goto L43
    L36:
        if (r13 >= r12.size()) goto L38;
        r14 = true;
    L43:
        final OBottomNavActionBar r15 = r2.getNavigationBar();
        boolean r16 = !Intrinsics.areEqual(r4, this.h);
        r15.setIndicatorAnimEnable(!r16);
        if (r16 == false) goto L65;
        ArrayList r17 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));
        Iterator<T> r18 = r3.iterator();
        int r20 = 0;
    L47:
        if (r18.hasNext() == false) goto L56;
        Object r21 = r18.next();
        int r110 = r20 + 1;
        if (r20 >= 0) goto L51;
        CollectionsKt.throwIndexOverflow();
    L51:
        r1 r22 = (r1) r21;
        if (r20 != r10) goto L54;
        boolean r23 = true;
    L55:
        r17.add(ga0(r22, r23));
        r20 = r110;
        goto L47
    L54:
        r23 = false;
        goto L55
    L56:
        r15.h((String[]) r4.toArray(new String[0]), (Drawable[]) r17.toArray(new Drawable[0]));
        int r24 = ca0(2130971299, 2131166968);
        int r25 = r15.o;
        int r26 = 0;
    L57:
        if (r26 >= r25) goto L63;
        int r27 = r26 + 1;
        ImageView r28 = (ImageView) r15.k.getChildAt(r26).findViewById(2131391546);
        ViewGroup.LayoutParams r111 = r28.getLayoutParams();
        if (r111 == null) goto L62;
        LinearLayout.LayoutParams r112 = (LinearLayout.LayoutParams) r111;
        r112.width = r24;
        r112.height = r24;
        r28.setLayoutParams(r112);
        r26 = r27;
        goto L57
    L62:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    L63:
        this.h = r4;
        this.i = Integer.valueOf(r10);
    L64:
        boolean r30 = true;
    L105:
        if (r15.getCurrentTab() == r10) goto L112;
        this.l = true;
        r15.setCurrentTab(r10);     // Catch: Throwable -> L109
        this.l = false;
        r30 = true;
    L109:
        th = move-exception;
        this.l = false;
        throw th;
    L112:
        if (r30 == true) goto L114;
    L117:
        if (r16 == false) goto L120;
        r15.setIndicatorAnimEnable(true);
        goto L120
    L114:
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.RESUMED) == false) goto L117;
        r15.post(new v0(this, r15));
        goto L117
    L65:
        Integer r31 = this.i;
        if (r31 != null) goto L69;
    L70:
        Iterator<T> r32 = r3.iterator();
        int r33 = 0;
    L72:
        if (r32.hasNext() == false) goto L102;
        Object r34 = r32.next();
        int r35 = r33 + 1;
        if (r33 >= 0) goto L76;
        CollectionsKt.throwIndexOverflow();
    L76:
        r1 r36 = (r1) r34;
        if (r33 != r10) goto L79;
        boolean r37 = true;
    L80:
        Drawable r38 = ga0(r36, r37);
        Intrinsics.checkNotNullParameter(r38, "drawable");
        Drawable[] r40 = r15.j;
        if (r40 == null) goto L101;
        if (r33 < 0) goto L101;
        if (r33 >= r40.length) goto L101;
        r40[r33] = r38;
        View r41 = r15.k.getChildAt(r33);
        View r42 = r41.findViewById(2131391548);
        if (r42 == null) goto L100;
        TextView r43 = (TextView) r42;
        ImageView r44 = (ImageView) r41.findViewById(2131391546);
        String[] r113 = r15.i;
        if (r113 == null) goto L95;
        String r114 = r113[r33];
        if (r114 != null) goto L94;
        r114 = "";
    L94:
        r43.setText(r114);
    L95:
        Drawable[] r45 = r15.j;
        if (r45 == null) goto L101;
        r44.setImageDrawable(r45[r33]);
        goto L101
    L100:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    L101:
        r33 = r35;
        goto L72
    L79:
        r37 = false;
        goto L80
    L102:
        this.i = Integer.valueOf(r10);
        goto L64
    L69:
        if (r10 != r31.intValue()) goto L70;
        r30 = false;
        goto L105
    L30:
        r10 = 0;
        goto L31
    L24:
        r9 = false;
        goto L25
    L20:
        r7 = -1;
        goto L21
    L138:
        return null;
    }

    /* JADX WARN: Type inference failed for: r5v7, types: [com.larus.dora.obric.device_management.device_home.e0] */
    public final void na0(final DoraObricDeviceHomeViewModel.c r27) {
        LarusDoraPageObricDeviceHomeBinding r2 = this.f;
        if (r2 == null) goto L166;
        final RecyclerView r3 = r2.n;
        if (r3 == null) goto L168;
        List<q> r4 = r27.f;
        Drawable r5 = null;
        if (r4.isEmpty() == false) goto L20;
        com.larus.utils.e1.o(r3);
        LarusDoraPageObricDeviceHomeBinding r1 = this.f;
        if (r1 == null) goto L14;
        OUICardConstraintLayout r6 = r1.m;
        if (r6 == null) goto L14;
        com.larus.utils.e1.o(r6);
    L14:
        j r7 = this.q;
        if (r7 == null) goto L17;
        ((com.obric.oui.orecyclerview.widget.w) r7).c.b(CollectionsKt.emptyList(), null);
    L17:
        this.u = null;
        this.v = CollectionsKt.emptyList();
        return;
    L20:
        if (r4.size() <= 1) goto L22;
        boolean r8 = true;
    L23:
        if (r8 == true) goto L133;
        com.larus.utils.e1.o(r3);
        j r9 = this.q;
        if (r9 != null) goto L27;
    L32:
        final q r10 = (q) CollectionsKt.first(r4);
        r r11 = r10.b;
        int r12 = com.larus.dora.obric.device_management.device_home.c.a;
        com.larus.dora.obric.device_management.device_home.b r13 = com.larus.dora.obric.device_management.device_home.c.a(r10.c, r10.d);
        LarusDoraPageObricDeviceHomeBinding r14 = this.f;
        if (r14 == null) goto L110;
        r14.r.setText(r11.b);
        r14.k.setText(r11.c);
        String r15 = CollectionsKt.joinToString$default(CollectionsKt.listOf(new Object[]{r11.i, r11.g, r11.h, Integer.valueOf(r11.f)}), null, null, null, 0, null, null, 63, null);
        if (Intrinsics.areEqual(this.z, r15) == true) goto L56;
        DoraResourceDeviceType r16 = r11.i;
        if (r16 == null) goto L45;
        String r17 = r11.g;
        if (r17 == null) goto L42;
        Drawable r18 = com.larus.dora.impl.resource.j0.f(com.larus.dora.impl.resource.j0.a, requireContext(), r16, r17, DoraDrawableDensity.XXHDPI, 8);
        if (r18 == null) goto L42;
    L46:
        if (r18 == null) goto L48;
        r14.p.setImageDrawable(r18);
    L52:
        OImage r110 = r14.D;
        DoraResourceDeviceType r111 = r11.i;
        if (r111 == null) goto L55;
        r5 = com.larus.dora.impl.resource.j0.f(com.larus.dora.impl.resource.j0.a, requireContext(), r111, "larus_dora_obric_device_home_ic_glasses", DoraDrawableDensity.XXHDPI, 8);
    L55:
        r110.setImageDrawable(r5);
        this.z = r15;
        goto L56
    L48:
        int r112 = r11.f;
        if (r112 == 0) goto L51;
        r14.p.setImageResource(r112);
        goto L52
    L51:
        r14.p.setImageDrawable(null);
    L42:
        String r113 = r11.h;
        if (r113 == null) goto L45;
        r18 = com.larus.dora.impl.resource.j0.f(com.larus.dora.impl.resource.j0.a, requireContext(), r16, r113, DoraDrawableDensity.XXHDPI, 8);
    L45:
        r18 = null;
    L56:
        r14.I.a(r10.c, r10.d);
        if (r13.d == false) goto L59;
        com.larus.utils.e1.x(r14.U);
    L61:
        if (r13.e == false) goto L63;
        com.larus.utils.e1.x(r14.t);
    L64:
        int r20 = com.larus.dora.obric.device_management.device_home.e.a;
        List<q> r25 = r4;
        com.larus.dora.obric.device_management.device_home.e.a(r14.m, r14.p, r14.s, r14.c, r14.w, r14.j, r14.q, r14.t, r14.U, r14.I, r13.a);
        com.larus.dora.obric.device_management.device_home.e.b(r14.S, r14.B, r14.F, r13, new t0(this, r10));
        boolean r21 = r13.c;
        LarusDoraPageObricDeviceHomeBinding r22 = this.f;
        if (r22 == null) goto L76;
        if (r21 == true) goto L68;
    L75:
        com.larus.utils.e1.o(r22.q);
        goto L76
    L68:
        if (r11.d == false) goto L75;
        if (r11.j.length() <= 0) goto L72;
        boolean r23 = true;
    L73:
        if (r23 == false) goto L75;
        r22.q.setText(r11.j);
        com.larus.utils.e1.x(r22.q);
        goto L76
    L72:
        r23 = false;
    L76:
        LarusDoraPageObricDeviceHomeBinding r24 = this.f;
        if (r24 == null) goto L86;
        if (r11.d == false) goto L81;
        com.larus.utils.e1.o(r24.j);
        com.larus.utils.e1.o(r24.N);
        com.larus.utils.e1.o(r24.O);
        com.larus.utils.e1.o(r24.i);
        goto L86
    L81:
        com.larus.utils.e1.o(r24.c);
        com.larus.utils.e1.o(r24.w);
        com.larus.utils.e1.x(r24.j);
        com.larus.utils.e1.o(r24.k);
        if (r11.e == false) goto L84;
        com.larus.utils.e1.o(r24.N);
        com.larus.utils.e1.o(r24.O);
        com.larus.utils.e1.x(r24.i);
        goto L86
    L84:
        com.larus.utils.e1.x(r24.N);
        com.larus.utils.e1.x(r24.O);
        com.larus.utils.e1.o(r24.i);
    L86:
        if (r11.d == false) goto L111;
        int r26 = g.d[r11.getType().ordinal()];
        if (r26 != 1) goto L91;
        com.larus.utils.e1.x(r14.c);
        com.larus.utils.e1.o(r14.w);
        r14.d.setText(r11.k);
        OImage r28 = r14.C;
        if (r11.l == false) goto L109;
        com.larus.utils.e1.x(r28);
        goto L111
    L109:
        com.larus.utils.e1.o(r28);
        goto L111
    L91:
        if (r26 != 2) goto L105;
        com.larus.utils.e1.o(r14.c);
        com.larus.utils.e1.x(r14.w);
        r14.G.setText(r11.m);
        r14.P.setText(r11.o);
        r14.f.setText(r11.q);
        OImage r30 = r14.H;
        if (r11.n == false) goto L95;
        com.larus.utils.e1.x(r30);
    L96:
        OImage r31 = r14.Q;
        if (r11.p == false) goto L99;
        com.larus.utils.e1.x(r31);
    L100:
        OImage r32 = r14.g;
        if (r11.r == false) goto L103;
        com.larus.utils.e1.x(r32);
        goto L111
    L103:
        com.larus.utils.e1.o(r32);
        goto L111
    L99:
        com.larus.utils.e1.o(r31);
        goto L100
    L95:
        com.larus.utils.e1.o(r30);
        goto L96
    L105:
        throw new NoWhenBranchMatchedException();
    L111:
        LarusDoraPageObricDeviceHomeBinding r33 = this.f;
        if (r33 == null) goto L116;
        OUICardConstraintLayout r34 = r33.m;
        if (r34 == null) goto L116;
        com.larus.utils.e1.x(r34);
    L116:
        r r35 = r27.h;
        LarusDoraPageObricDeviceHomeBinding r36 = this.f;
        if (r36 == null) goto L164;
        OUICardConstraintLayout r37 = r36.m;
        if (r37 == null) goto L165;
        long r38 = this.H;
        if (r35.d == true) goto L124;
    L127:
        this.u = r27.c;
        List<q> r40 = r25;
        ArrayList r41 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r40, 10));
        Iterator<T> r42 = r40.iterator();
    L129:
        if (r42.hasNext() == false) goto L131;
        r41.add(((q) r42.next()).a);
        goto L129
    L131:
        this.v = r41;
        return;
    L124:
        if (r38 == 0) goto L127;
        OneShotPreDrawListener.add(r37, new h1(r37, this, r38));
        goto L127
    L165:
        return;
    L164:
        return;
    L63:
        com.larus.utils.e1.o(r14.t);
        goto L64
    L59:
        com.larus.utils.e1.o(r14.U);
        goto L61
    L110:
        r25 = r4;
        goto L111
    L27:
        if (r9.h == false) goto L32;
        r9.h = false;
        if (r9.a() <= 0) goto L32;
        ((RecyclerView.Adapter) r9).a.c(0, r9.a(), null);
        goto L32
    L133:
        LarusDoraPageObricDeviceHomeBinding r43 = this.f;
        if (r43 == null) goto L138;
        OUICardConstraintLayout r44 = r43.m;
        if (r44 == null) goto L138;
        com.larus.utils.e1.o(r44);
    L138:
        com.larus.utils.e1.x(r3);
        j r45 = this.q;
        if (r45 == null) goto L146;
        final boolean r46 = true;
        if (r45.h == true) goto L148;
        r45.h = true;
        if (r45.a() <= 0) goto L148;
        ((RecyclerView.Adapter) r45).a.c(0, r45.a(), null);
    L148:
        List<q> r47 = r4;
        ArrayList r48 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r47, 10));
        Iterator<T> r50 = r47.iterator();
    L150:
        if (r50.hasNext() == false) goto L153;
        r48.add(((q) r50.next()).a);
        goto L150
    L153:
        if (Intrinsics.areEqual(this.u, r27.c) == true) goto L155;
    L158:
        this.u = r27.c;
        this.v = r48;
        j r51 = this.q;
        if (r51 == null) goto L167;
        ((com.obric.oui.orecyclerview.widget.w) r51).c.b(CollectionsKt.toList(r47), new e0(this, r27, r3, r46));
        return;
    L167:
        return;
    L155:
        if (Intrinsics.areEqual(this.v, r48) == false) goto L158;
        r46 = false;
        goto L158
    L146:
        r46 = true;
        goto L148
    L22:
        r8 = false;
        goto L23
    L168:
        return;
    }

    public final void onAttach(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super/*androidx.fragment.app.Fragment*/.onAttach(r2);
        this.p = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new v(this));
    }

    public final void onSaveInstanceState(Bundle r3) {
        Intrinsics.checkNotNullParameter(r3, "outState");
        super/*androidx.fragment.app.Fragment*/.onSaveInstanceState(r3);
        r3.putString("obric_device_home_selected_tab", ha0().name());
    }

    public final void ra0(String r6) {
        int r0 = y69.a.a;
        if (this.K == false) goto L5;
        Bundle r1 = this.J;
    L6:
        String r2 = y69.b.a(this, r1);
        if (this.K == false) goto L9;
        Bundle r3 = this.J;
    L10:
        String r4 = null;
        if (r3 == null) goto L13;
        String r5 = r3.getString(DoraObricDeviceHomeViewModel.PARAM_ENTER_METHOD);
    L15:
        if (Intrinsics.areEqual(r5, "desktop_shortcut") == false) goto L18;
        String r7 = "click_icon";
    L24:
        y69.a.a(r6, r2, r7);
        return;
    L18:
        if (this.K == false) goto L20;
        Bundle r8 = this.J;
    L21:
        if (r8 == null) goto L23;
        r4 = r8.getString(DoraObricDeviceHomeViewModel.PARAM_ENTER_METHOD);
    L23:
        r7 = r4;
        goto L24
    L20:
        r8 = getArguments();
        goto L21
    L13:
        r5 = null;
        goto L15
    L9:
        r3 = getArguments();
        goto L10
    L5:
        r1 = getArguments();
        goto L6
    }

    public final void ta0(String r5) {
        j r0 = this.q;
        if (r0 == null) goto L35;
        List r1 = ((com.obric.oui.orecyclerview.widget.w) r0).c.f;
        if (r1 == null) goto L36;
        Iterator r2 = r1.iterator();
        boolean r3 = false;
        int r4 = 0;
    L8:
        if (r2.hasNext() == false) goto L13;
        if (Intrinsics.areEqual(((q) r2.next()).a, r5) == true) goto L14;
        r4 = r4 + 1;
    L14:
        Integer r6 = Integer.valueOf(r4);
        if (r6.intValue() < 0) goto L17;
        r3 = true;
    L17:
        if (r3 == true) goto L20;
        r6 = null;
    L20:
        if (r6 == null) goto L37;
        int r7 = r6.intValue();
        LarusDoraPageObricDeviceHomeBinding r8 = this.f;
        if (r8 == null) goto L38;
        RecyclerView r9 = r8.n;
        if (r9 != null) goto L26;
        return;
    L26:
        if (r9.x == true) goto L40;
        RecyclerView.k r10 = r9.m;
        if (r10 == null) goto L41;
        r10.r0(r9, r7);
        return;
    L41:
        return;
    L40:
        return;
    L38:
        return;
    L37:
        return;
    L13:
        r4 = -1;
        goto L14
    L36:
        return;
    }

    public final void xa0(String r3) {
        g49.d.d("DoraObricDeviceHomeFragment", "startReconnect mac=" + r3);
        if (r3 != null) goto L5;
    L8:
        boolean r0 = true;
    L9:
        if (r0 == false) goto L12;
        Y90();
        ia0().onReconnectFailed();
        return;
    L12:
        this.G = null;
        ia0().handleConnectRequest(r3);
        return;
    L5:
        if (r3.length() == 0) goto L8;
        r0 = false;
        goto L9
    }

    public final void ya0(DoraDevice r7) {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new DoraObricDeviceHomeFragment$unbindAndDisconnect$1(this, r7, null), 3, null);
    }

    public final void za0(boolean r2) {
        LarusDoraPageObricDeviceHomeBinding r0 = this.f;
        if (r0 == null) goto L10;
        OUIFrameLayout r1 = r0.b;
        if (r1 == null) goto L11;
        if (r2 == false) goto L8;
        com.larus.utils.e1.x(r1);
        return;
    L8:
        com.larus.utils.e1.o(r1);
        return;
    L11:
        return;
    }

    public static final String X90(DoraObricDeviceHomeFragment r0, DoraObricDeviceHomeTabPage r1) {
        r0.getClass();
        int r2 = g.c[r1.ordinal()];
        if (r2 != 1) goto L5;
        return "home";
    L5:
        if (r2 != 2) goto L7;
        return "diary";
    L7:
        if (r2 != 3) goto L9;
        return "health";
    L9:
        if (r2 != 4) goto L12;
        return "explore";
    L12:
        throw new NoWhenBranchMatchedException();
    }

    public static /* synthetic */ void pa0(DoraObricDeviceHomeFragment r1, int r2) {
        r1.oa0(r2, (DoraObricDeviceHomeViewModel.c) r1.ia0().getUiState().getValue());
    }

    public static void ua0(Fragment r2, String r3) {
        IDoraODiaryService r0 = (IDoraODiaryService) ServiceManager.get().getService(IDoraODiaryService.class);
        if (r0 != null) goto L13;
        return;
    L13:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L7
        r0.d(r2, r3);     // Catch: Throwable -> L7
        Object r4 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L7
    L9:
        Throwable r5 = Result.exceptionOrNull-impl(r4);
        if (r5 == null) goto L15;
        g49.d.c("DoraObricDeviceHomeFragment", "selectDeviceHomeDiaryDate failed", r5);
        return;
    L15:
        return;
    L7:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L9
    }

    public final int ca0(int r3, int r4) {
        Context r0 = requireContext();
        return r0.getResources().getDimensionPixelSize(v19.c.b(r3, r0, r4));
    }

    public final Drawable ga0(r1 r2, boolean r3) {
        int r4 = g.c[r2.b.ordinal()];
        if (r4 != 1) goto L5;
        if (r3 == false) goto L23;
        int r5 = 2131240547;
    L24:
        Drawable r6 = ContextCompat.getDrawable(requireContext(), r5);
        if (r6 == null) goto L28;
        return r6;
    L28:
        throw new IllegalArgumentException(("Bottom navigation icon resource is missing: " + r5).toString());
    L23:
        r5 = 2131240549;
        goto L24
    L5:
        if (r4 != 2) goto L7;
        if (r3 == false) goto L20;
        r5 = 2131240550;
        goto L24
    L20:
        r5 = 2131240551;
        goto L24
    L7:
        if (r4 != 3) goto L9;
        if (r3 == false) goto L17;
        r5 = 2131240559;
        goto L24
    L17:
        r5 = 2131240560;
        goto L24
    L9:
        if (r4 != 4) goto L14;
        if (r3 == false) goto L12;
        r5 = 2131240552;
        goto L24
    L12:
        r5 = 2131240553;
        goto L24
    L14:
        throw new NoWhenBranchMatchedException();
    }

    public final void ka0(String r4, Bundle r5) {
        FragmentActivity r0 = getActivity();
        if (r0 != null) goto L5;
        return;
    L5:
        g49.d.d("DoraObricDeviceHomeFragment", "openRoute route=" + r4 + " taskId=" + r0.getTaskId());
        com.bytedance.router.i r6 = SmartRouter.buildRoute(r0, r4);
        if (r5 != null) goto L8;
        r5 = new Bundle();
    L8:
        r6.c.putExtras(r5);
        r6.d();
    }

    public final void oa0(int r10, DoraObricDeviceHomeViewModel.c r11) {
        r1 r12 = (r1) CollectionsKt.getOrNull(r11.m, r10);
        if (r12 == null) goto L6;
        DoraObricDeviceHomeTabPage r13 = r12.b;
        if (r13 == null) goto L6;
    L7:
        LarusDoraPageObricDeviceHomeBinding r0 = this.f;
        if (r0 == null) goto L154;
        int r14 = g.c[r13.ordinal()];
        if (r14 == 1) goto L102;
        Fragment r5 = null;
        Object r6 = null;
        Fragment r7 = null;
        r7 = null;
        r7 = null;
        Object r8 = null;
        r5 = null;
        if (r14 != 2) goto L14;
        com.larus.utils.e1.o(r0.R);
        com.larus.utils.e1.x(r0.u);
        com.larus.utils.e1.o(r0.E);
        com.larus.utils.e1.o(r0.v);
        com.larus.utils.e1.o(r0.T);
        za0(false);
        boolean r15 = r11.j;
        Fragment r16 = getChildFragmentManager().findFragmentByTag("ObricDeviceHomeDiaryFragment");
        String r4 = ia0().resolveDiaryGlassesMac();
        String r9 = this.D;
        this.D = null;
        if (r16 != null) goto L72;
    L77:
        IDoraODiaryService r17 = (IDoraODiaryService) ServiceManager.get().getService(IDoraODiaryService.class);
        if (r17 != null) goto L81;
    L95:
        if (r5 != null) goto L97;
        g49.d.e("DoraObricDeviceHomeFragment", "createDiaryFragment returned null");
        ea0();
    L103:
        LarusDoraPageObricDeviceHomeBinding r18 = this.f;
        if (r18 != null) goto L106;
        return;
    L106:
        if (r18.R.getVisibility() != 0) goto L109;
        OUIFrameLayout r110 = r18.R;
    L117:
        Integer r1 = this.E;
        int r20 = r110.getId();
        if (r1 != null) goto L121;
    L123:
        r18.e.setBackdropTarget(r110);
        LarusDoraPageObricDeviceHomeBinding r111 = this.f;
        if (r111 == null) goto L132;
        OBottomNavigationBar r112 = r111.e;
        if (r112 == null) goto L132;
        View r113 = r112.findViewById(2131364490);
        if (r113 == null) goto L132;
        OMaterialHelper.p(r113, (com.obric.oui.material.c) this.P.getValue(), 5);
        OMaterialHelper.t(r113, r110);
    L132:
        LarusDoraPageObricDeviceHomeBinding r114 = this.f;
        if (r114 == null) goto L148;
        OBottomNavigationBar r115 = r114.e;
        if (r115 == null) goto L148;
        OBottomNavActionBar r116 = r115.getNavigationBar();
        if (r116 == null) goto L148;
        Intrinsics.checkNotNullParameter(r116, "<this>");
        OMaterialHelper.t(r116, r110);
        r116.setBackgroundResource(2131240544);
        int[] r2 = r116.getDrawableState();
        Drawable r21 = r116.getBackground();
        Intrinsics.checkNotNull(r2);
        if (r2.length != 0) goto L142;
        boolean r22 = true;
    L144:
        if ((!r22) == false) goto L146;
        int[] r3 = new int[0];
    L147:
        r21.setState(r3);
        r116.getBackground().setState(r2);
        r116.getBackground().invalidateSelf();
        g49.d.d("DoraObricDeviceHomeFragment", "bottom navigation frosted background applied, target=" + getResources().getResourceEntryName(r110.getId()));
        goto L148
    L146:
        r3 = new int[]{R.attr.state_enabled};
        goto L147
    L142:
        r22 = false;
    L148:
        this.E = Integer.valueOf(r110.getId());
        g49.d.d("DoraObricDeviceHomeFragment", "bottom navigation backdrop target updated, target=" + getResources().getResourceEntryName(r110.getId()));
        return;
    L121:
        if (r1.intValue() != r20) goto L123;
        return;
    L109:
        if (r18.u.getVisibility() != 0) goto L112;
        r110 = r18.u;
        goto L117
    L112:
        if (r18.E.getVisibility() != 0) goto L115;
        r110 = r18.E;
        goto L117
    L115:
        if (r18.v.getVisibility() != 0) goto L156;
        r110 = r18.v;
        goto L117
    L156:
        return;
    L97:
        this.w = Boolean.valueOf(r15);
        this.x = r4;
        FragmentTransaction r117 = getChildFragmentManager().beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r117, r5, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, "ObricDeviceHomeDiaryFragment", 2131369793) == true) goto L101;
        r117 = r117.replace(2131369793, r5, "ObricDeviceHomeDiaryFragment");
    L101:
        r117.commitAllowingStateLoss();
        goto L103
    L81:
        if ((r17 instanceof DefaultDoraODiaryService) == true) goto L95;
        Result.Companion r23 = Result.Companion;     // Catch: Throwable -> L85
        Object r118 = Result.constructor-impl(r17.b(r4, r9));     // Catch: Throwable -> L85
    L87:
        Throwable r24 = Result.exceptionOrNull-impl(r118);
        if (r24 == null) goto L91;
        g49.d.c("DoraObricDeviceHomeFragment", "createDiaryFragment failed", r24);
    L91:
        if (Result.isFailure-impl(r118) == true) goto L94;
        r8 = r118;
    L94:
        r5 = (Fragment) r8;
    L85:
        th = move-exception;
        Result.Companion r25 = Result.Companion;
        r118 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L87
    L72:
        if (Intrinsics.areEqual(this.w, Boolean.valueOf(r15)) == false) goto L77;
        if (Intrinsics.areEqual(this.x, r4) == false) goto L77;
        if (r9 == null) goto L103;
        ua0(r16, r9);
        goto L103
    L14:
        if (r14 != 3) goto L16;
        com.larus.utils.e1.o(r0.R);
        com.larus.utils.e1.o(r0.u);
        com.larus.utils.e1.x(r0.E);
        com.larus.utils.e1.o(r0.v);
        com.larus.utils.e1.o(r0.T);
        za0(false);
        String r119 = ia0().healthEntryUrl();
        if (getChildFragmentManager().findFragmentByTag("ObricDeviceHomeHealthFragment") == null) goto L42;
        if (Intrinsics.areEqual(this.y, r119) == true) goto L103;
    L42:
        if (StringsKt.isBlank(r119) == true) goto L62;
        IDoraOHealthService r120 = (IDoraOHealthService) ServiceManager.get().getService(IDoraOHealthService.class);
        if (r120 == null) goto L62;
        if ((r120 instanceof DefaultDoraOHealthService) == true) goto L62;
        Result.Companion r26 = Result.Companion;     // Catch: Throwable -> L52
        Object r121 = Result.constructor-impl(r120.a(r119));     // Catch: Throwable -> L52
    L54:
        Throwable r27 = Result.exceptionOrNull-impl(r121);
        if (r27 == null) goto L58;
        g49.d.c("DoraObricDeviceHomeFragment", "createHealthFragment failed", r27);
    L58:
        if (Result.isFailure-impl(r121) == true) goto L61;
        r6 = r121;
    L61:
        r7 = (Fragment) r6;
    L52:
        th = move-exception;
        Result.Companion r28 = Result.Companion;
        r121 = Result.constructor-impl(ResultKt.createFailure(th));
    L62:
        if (r7 != null) goto L64;
        g49.d.e("DoraObricDeviceHomeFragment", "createHealthFragment returned null");
        ea0();
        goto L103
    L64:
        this.y = r119;
        FragmentTransaction r122 = getChildFragmentManager().beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r122, r7, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, "ObricDeviceHomeHealthFragment", 2131369806) == true) goto L68;
        r122 = r122.replace(2131369806, r7, "ObricDeviceHomeHealthFragment");
    L68:
        r122.commitAllowingStateLoss();
        goto L103
    L16:
        if (r14 != 4) goto L35;
        com.larus.utils.e1.o(r0.R);
        com.larus.utils.e1.o(r0.u);
        com.larus.utils.e1.o(r0.E);
        com.larus.utils.e1.x(r0.v);
        com.larus.utils.e1.o(r0.T);
        za0(false);
        String r123 = "ObricDeviceHomeDiscoverFragment:" + ((DoraObricDeviceHomeViewModel.c) ia0().getUiState().getValue()).c;
        if (getChildFragmentManager().findFragmentByTag(r123) != null) goto L103;
        if (ia0().hasBoundGlasses() == false) goto L25;
        DoraSetting.a.getClass();
        int r124 = com.larus.utils.l0.a;
        if (((Boolean) com.larus.utils.l0.a(Boolean.TRUE, new com.larus.dora.impl.settings.s())).booleanValue() == false) goto L25;
        boolean r125 = true;
    L26:
        if (r125 == false) goto L28;
        Fragment r126 = new DoraObricGlassesExploreFragment();
    L29:
        Bundle r30 = DoraObricDeviceHomeViewModel.createDeviceRouteArguments$default(ia0(), null, 1, null);
        r30.putBoolean("embedded_device_home", true);
        r126.setArguments(r30);
        FragmentTransaction r31 = getChildFragmentManager().beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r31, r126, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, r123, 2131369794) == true) goto L33;
        r31 = r31.replace(2131369794, r126, r123);
    L33:
        r31.commitAllowingStateLoss();
        goto L103
    L28:
        r126 = new DoraObricExploreFragment();
    L25:
        r125 = false;
        goto L26
    L35:
        throw new NoWhenBranchMatchedException();
    L102:
        com.larus.utils.e1.x(r0.R);
        com.larus.utils.e1.o(r0.u);
        com.larus.utils.e1.o(r0.E);
        com.larus.utils.e1.o(r0.v);
        com.larus.utils.e1.x(r0.T);
        za0(r11.k);
        goto L103
    L154:
        return;
    L6:
        r13 = DoraObricDeviceHomeTabPage.DEVICE;
        goto L7
    }

    /* JADX WARN: Type inference failed for: r2v23, types: [android.view.View, android.widget.FrameLayout, com.obric.oui.bouncelayout.ONestedScrollView] */
    /* JADX WARN: Type inference failed for: r2v24, types: [android.view.View, android.widget.FrameLayout, com.obric.oui.bouncelayout.ONestedScrollView] */
    public final void onViewCreated(View r11, Bundle r12) {
        Intrinsics.checkNotNullParameter(r11, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r11, r12);
        if (r12 == null) goto L17;
        String r13 = r12.getString("obric_device_home_selected_tab");
        if (r13 == null) goto L17;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L8
        Object r14 = Result.constructor-impl(DoraObricDeviceHomeTabPage.valueOf(r13));     // Catch: Throwable -> L8
    L11:
        if (Result.isFailure-impl(r14) == false) goto L13;
        r14 = null;
    L13:
        DoraObricDeviceHomeTabPage r15 = (DoraObricDeviceHomeTabPage) r14;
        if (r15 == null) goto L17;
        this.B.setValue(r15);
    L8:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r14 = Result.constructor-impl(ResultKt.createFailure(th));
    L17:
        if (this.K == false) goto L19;
        Bundle r16 = this.J;
    L20:
        this.C = sa0(r16);
        if (r16 == null) goto L30;
        String r2 = r16.getString("obric_device_home_diary_date");
        if (r2 == null) goto L30;
        if (r2.length() <= 0) goto L27;
        boolean r3 = true;
    L28:
        if (r3 == false) goto L30;
    L31:
        this.D = r2;
        ia0().initialize(r16);
        if (this.L == false) goto L34;
        ia0().onEntryArgumentsChanged(r16);
        this.L = false;
    L34:
        this.N = true;
        LarusDoraPageObricDeviceHomeBinding r17 = this.f;
        if (r17 == null) goto L39;
        OUIFrameLayout r18 = r17.o;
        if (r18 == null) goto L39;
        r18.setOnClickListener(null);
        r18.setClickable(false);
        r18.setFocusable(false);
    L39:
        LarusDoraPageObricDeviceHomeBinding r110 = this.f;
        if (r110 == null) goto L44;
        OImage r111 = r110.t;
        if (r111 == null) goto L44;
        r111.setOnClickListener(new a1(this));
    L44:
        LarusDoraPageObricDeviceHomeBinding r112 = this.f;
        if (r112 == null) goto L49;
        OImage r113 = r112.U;
        if (r113 == null) goto L49;
        r113.setOnClickListener(new b1(this));
    L49:
        LarusDoraPageObricDeviceHomeBinding r114 = this.f;
        if (r114 == null) goto L54;
        DoraObricDeviceModeEntryView r115 = r114.I;
        if (r115 == null) goto L54;
        r115.setOnModeClickListener(new w(this));
    L54:
        LarusDoraPageObricDeviceHomeBinding r116 = this.f;
        if (r116 == null) goto L59;
        OTextView r117 = r116.N;
        if (r117 == null) goto L59;
        r117.setOnClickListener(new x(this));
    L59:
        LarusDoraPageObricDeviceHomeBinding r118 = this.f;
        if (r118 == null) goto L64;
        View r119 = r118.O;
        if (r119 == null) goto L64;
        r119.setOnClickListener(new y(this));
    L64:
        LarusDoraPageObricDeviceHomeBinding r120 = this.f;
        if (r120 == null) goto L69;
        OTextView r121 = r120.J;
        if (r121 == null) goto L69;
        r121.setOnClickListener(new z(this));
    L69:
        LarusDoraPageObricDeviceHomeBinding r122 = this.f;
        if (r122 == null) goto L85;
        OBottomActionBarNormalHorizontal r123 = r122.x;
        if (r123 == null) goto L85;
        ODivider r4 = r123.c;
        if (r4 == null) goto L78;
        r4.setVisibility(8);
    L78:
        r123.setPadding(0, 0, 0, 0);
        View r5 = r123.findViewById(2131364400);
        if (r5 == null) goto L81;
        r5.setPadding(0, 0, 0, 0);
    L81:
        LinearLayout r6 = (LinearLayout) r123.findViewById(2131362046);
        if (r6 == null) goto L84;
        r6.setPadding(ca0(2130971390, 2131167150), 0, ca0(2130971390, 2131167150), ca0(2130971546, 2131167462));
    L84:
        OButton r7 = vma.e.a(requireContext(), 2131952832, new a0());
        r7.setGravity(17);
        r7.setText(getString(2131902189));
        r7.setOnClickListener(new b0(this));
        r123.setButtons(CollectionsKt.listOf(r7));
    L85:
        LarusDoraPageObricDeviceHomeBinding r124 = this.f;
        if (r124 == null) goto L90;
        OImage r125 = r124.A;
        if (r125 == null) goto L90;
        r125.setImageDrawable(com.larus.dora.impl.resource.j0.f(com.larus.dora.impl.resource.j0.a, requireContext(), DoraResourceDeviceType.G2, "larus_dora_obric_device_home_img_empty", DoraDrawableDensity.XXHDPI, 8));
    L90:
        wa0();
        LarusDoraPageObricDeviceHomeBinding r126 = this.f;
        if (r126 == null) goto L99;
        ?? r8 = r126.R;
        if (r8 == 0) goto L99;
        OUILinearLayout r127 = r126.l;
        if (r127 == null) goto L99;
        r8.setOverScrollMode(2);
        r8.setOnBounceTranslationListener(new p0(r127));
        ViewCompat.setOnApplyWindowInsetsListener(r8, new j0(this));
        ViewCompat.requestApplyInsets(r8);
    L99:
        LarusDoraPageObricDeviceHomeBinding r128 = this.f;
        if (r128 == null) goto L108;
        ?? r9 = r128.y;
        if (r9 == 0) goto L108;
        OUILinearLayout r129 = r128.z;
        if (r129 == null) goto L108;
        r9.setOverScrollMode(2);
        r9.setOnBounceTranslationListener(new p0(r129));
        ViewCompat.setOnApplyWindowInsetsListener(r9, new y0(this));
        ViewCompat.requestApplyInsets(r9);
    L108:
        LarusDoraPageObricDeviceHomeBinding r130 = this.f;
        if (r130 == null) goto L118;
        OSectionTitleBar r131 = r130.h;
        if (r131 == null) goto L118;
        LinearLayout r10 = (LinearLayout) r131.findViewById(2131367728);
        if (r10 == null) goto L115;
        r10.setPadding(ca0(2130971208, 2131166786), 0, ca0(2130971163, 2131166696), 0);
    L115:
        TextView r132 = (TextView) r131.findViewById(2131388792);
        if (r132 == null) goto L118;
        r132.setTextSize(12.0f);
        r132.setTextColor(ContextCompat.getColor(r132.getContext(), 2131104359));
    L118:
        LarusDoraPageObricDeviceHomeBinding r133 = this.f;
        if (r133 == null) goto L135;
        OUIFrameLayout r134 = r133.b;
        if (r134 == null) goto L135;
        IDoraOUIService r20 = (IDoraOUIService) ServiceManager.get().getService(IDoraOUIService.class);
        if (r20 == null) goto L135;
        if ((r20 instanceof DefaultDoraOUIService) == true) goto L135;
        View r21 = r20.a(r134.getContext(), getViewLifecycleOwner(), new DoraObricDeviceHomeFragment$setupAlbumCard$albumView$1(this), new DoraObricDeviceHomeFragment$setupAlbumCard$albumView$2(ia0()));
        if (r21 == null) goto L135;
        r134.removeAllViews();
        if (r21.getParent() == null) goto L134;
        g49.d.e("DoraObricDeviceHomeFragment", "setupAlbumCard skipped: album view already has parent");
        com.larus.utils.e1.o(r134);
        goto L135
    L134:
        r134.addView(r21);
        g49.d.d("DoraObricDeviceHomeFragment", "setupAlbumCard attached");
    L135:
        LarusDoraPageObricDeviceHomeBinding r135 = this.f;
        if (r135 == null) goto L141;
        RecyclerView r136 = r135.n;
        if (r136 == null) goto L141;
        getContext();
        LinearLayoutManager r22 = new LinearLayoutManager(0);
        final j r23 = new j(new DoraObricDeviceHomeFragment$setupDeviceCardCarousel$adapter$1(this), new DoraObricDeviceHomeFragment$setupDeviceCardCarousel$adapter$2(this), new DoraObricDeviceHomeFragment$setupDeviceCardCarousel$adapter$3(this), new DoraObricDeviceHomeFragment$setupDeviceCardCarousel$adapter$4(ia0()));
        b r24 = new b(this);
        r136.setLayoutManager(r22);
        r136.setAdapter(r23);
        r136.setItemAnimator(null);
        r136.setNestedScrollingEnabled(false);
        r136.addOnLayoutChangeListener(new d0(r23));
        r136.i(new c(this));
        r136.q.add(new d(this));
        r136.j(new k1(this));
        r24.a(r136);
        this.q = r23;
        this.s = r22;
        this.t = r24;
    L141:
        LarusDoraPageObricDeviceHomeBinding r137 = this.f;
        if (r137 == null) goto L147;
        RecyclerView r138 = r137.M;
        if (r138 == null) goto L147;
        n1 r25 = new n1(new DoraObricDeviceHomeFragment$setupQuickActionGrid$adapter$1(this));
        r138.getContext();
        r138.setLayoutManager(new GridLayoutManager());
        r138.setAdapter(r25);
        r138.setHasFixedSize(false);
        r138.setNestedScrollingEnabled(false);
        r138.setItemAnimator(null);
        r138.i(new e(this));
        this.r = r25;
    L147:
        LarusDoraPageObricDeviceHomeBinding r139 = this.f;
        if (r139 == null) goto L199;
        OBottomNavigationBar r140 = r139.e;
        if (r140 == null) goto L199;
        int r26 = ca0(2130971343, 2131167056);
        int r27 = ca0(2130971255, 2131166880);
        int r28 = getResources().getDimensionPixelSize(2131167420);
        int r30 = (r28 + 0) + r27;
        ViewGroup.LayoutParams r31 = r140.getLayoutParams();
        if ((r31 instanceof ViewGroup.MarginLayoutParams) == false) goto L155;
        ViewGroup.MarginLayoutParams r32 = (ViewGroup.MarginLayoutParams) r31;
    L157:
        if (r32 != null) goto L159;
    L171:
        View r33 = r140.findViewById(2131364490);
        if (r33 != null) goto L174;
    L178:
        OBottomNavActionBar r34 = r140.getNavigationBar();
        ViewGroup.LayoutParams r35 = r34.getLayoutParams();
        if ((r35 instanceof ViewGroup.MarginLayoutParams) == false) goto L181;
        ViewGroup.MarginLayoutParams r36 = (ViewGroup.MarginLayoutParams) r35;
    L182:
        if (r36 != null) goto L185;
    L198:
        r140.getNavigationBar().setOnTabSelectListener(new j1(this));
        goto L199
    L185:
        if (r36.width == (-1)) goto L187;
    L197:
        r36.width = -1;
        r36.height = r28;
        r36.setMargins(r26, 0, r26, r27);
        r34.setLayoutParams(r36);
        goto L198
    L187:
        if (r36.height != r28) goto L197;
        if (r36.leftMargin != r26) goto L197;
        if (r36.topMargin != 0) goto L197;
        if (r36.rightMargin != r26) goto L197;
        if (r36.bottomMargin != r27) goto L197;
    L181:
        r36 = null;
        goto L182
    L174:
        if (r33.getLayoutParams().width == (-1)) goto L176;
    L177:
        ViewGroup.LayoutParams r37 = r33.getLayoutParams();
        r37.width = -1;
        r37.height = r30;
        r33.setLayoutParams(r37);
        goto L178
    L176:
        if (r33.getLayoutParams().height == r30) goto L178;
    L159:
        if (r32.width == (-1)) goto L161;
    L170:
        r32.width = -1;
        r32.height = -2;
        r32.setMargins(0, 0, 0, 0);
        r140.setLayoutParams(r32);
        goto L171
    L161:
        if (r32.height != (-2)) goto L170;
        if (r32.leftMargin != 0) goto L170;
        if (r32.topMargin != 0) goto L170;
        if (r32.rightMargin != 0) goto L170;
        if (r32.bottomMargin == 0) goto L171;
    L155:
        r32 = null;
    L199:
        getChildFragmentManager().setFragmentResultListener("dora_o_device_home_diary_data_changed", getViewLifecycleOwner(), new c0(this));
        getChildFragmentManager().setFragmentResultListener("request_key_obric_glasses_mode_sheet", getViewLifecycleOwner(), new g0(this));
        g49.d.d("DoraObricDeviceHomeFragment", "registerDeviceUpdateReceiver");
        LocalBroadcastManager r141 = LocalBroadcastManager.getInstance(fa0());
        DoraObricDeviceHomeFragment$deviceUpdateReceiver$1 r38 = this.Q;
        IntentFilter r40 = new IntentFilter("action.DEVICE_UPDATE_DYNAMIC");
        r40.addAction("action.DEVICE_UNBIND");
        r40.addAction("action.DEVICE_UPDATE_NAME");
        Unit r41 = Unit.INSTANCE;
        r141.registerReceiver(r38, r40);
        Lifecycle.State r142 = Lifecycle.State.RESUMED;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraObricDeviceHomeFragment$observeUiState$$inlined$launchAndRepeatWithViewLifecycle$1(this, r142, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraObricDeviceHomeFragment$observeOtaHomeCardState$$inlined$launchAndRepeatWithViewLifecycle$1(this, r142, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraObricDeviceHomeFragment$observeSilentOtaCompletion$$inlined$launchAndRepeatWithViewLifecycle$1(this, r142, null, this), 3, null);
        Lifecycle.State r143 = Lifecycle.State.STARTED;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraObricDeviceHomeFragment$observeActions$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, r143, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraObricDeviceHomeFragment$observeDeviceActions$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, r143, null, this), 3, null);
        return;
    L27:
        r3 = false;
    L30:
        r2 = null;
        goto L31
    L19:
        r16 = getArguments();
        goto L20
    }

    public final View onCreateView(LayoutInflater r52, ViewGroup r53, Bundle r54) {
        Intrinsics.checkNotNullParameter(r52, "inflater");
        ConstraintLayout r0 = r52.inflate(2131562280, r53, false);
        int r1 = 2131369773;
        OUIFrameLayout r5 = ViewBindings.findChildViewById(r0, 2131369773);
        if (r5 == null) goto L107;
        r1 = 2131369774;
        OUILinearLayout r6 = ViewBindings.findChildViewById(r0, 2131369774);
        if (r6 == null) goto L107;
        r1 = 2131369775;
        OTextView r7 = ViewBindings.findChildViewById(r0, 2131369775);
        if (r7 == null) goto L107;
        r1 = 2131369776;
        OBottomNavigationBar r8 = ViewBindings.findChildViewById(r0, 2131369776);
        if (r8 == null) goto L107;
        r1 = 2131369777;
        OTextView r9 = ViewBindings.findChildViewById(r0, 2131369777);
        if (r9 == null) goto L107;
        r1 = 2131369778;
        OImage r10 = ViewBindings.findChildViewById(r0, 2131369778);
        if (r10 == null) goto L107;
        r1 = 2131369779;
        OSectionTitleBar r11 = ViewBindings.findChildViewById(r0, 2131369779);
        if (r11 == null) goto L107;
        r1 = 2131369780;
        OTextView r12 = ViewBindings.findChildViewById(r0, 2131369780);
        if (r12 == null) goto L107;
        r1 = 2131369781;
        if (ViewBindings.findChildViewById(r0, 2131369781) == null) goto L107;
        r1 = 2131369782;
        OUIFrameLayout r13 = ViewBindings.findChildViewById(r0, 2131369782);
        if (r13 == null) goto L107;
        r1 = 2131369783;
        OTextView r14 = ViewBindings.findChildViewById(r0, 2131369783);
        if (r14 == null) goto L107;
        r1 = 2131369784;
        OUILinearLayout r15 = ViewBindings.findChildViewById(r0, 2131369784);
        if (r15 == null) goto L107;
        r1 = 2131369785;
        OUICardConstraintLayout r16 = ViewBindings.findChildViewById(r0, 2131369785);
        if (r16 == null) goto L107;
        r1 = 2131369786;
        RecyclerView r17 = ViewBindings.findChildViewById(r0, 2131369786);
        if (r17 == null) goto L107;
        r1 = 2131369787;
        OUIFrameLayout r18 = ViewBindings.findChildViewById(r0, 2131369787);
        if (r18 == null) goto L107;
        r1 = 2131369788;
        OImage r110 = ViewBindings.findChildViewById(r0, 2131369788);
        if (r110 == null) goto L107;
        r1 = 2131369789;
        OTextTag r20 = ViewBindings.findChildViewById(r0, 2131369789);
        if (r20 == null) goto L107;
        r1 = 2131369790;
        OTextView r21 = ViewBindings.findChildViewById(r0, 2131369790);
        if (r21 == null) goto L107;
        r1 = 2131369791;
        OUILinearLayout r22 = ViewBindings.findChildViewById(r0, 2131369791);
        if (r22 == null) goto L107;
        r1 = 2131369792;
        OImage r23 = ViewBindings.findChildViewById(r0, 2131369792);
        if (r23 == null) goto L107;
        r1 = 2131369793;
        OUIFrameLayout r24 = ViewBindings.findChildViewById(r0, 2131369793);
        if (r24 == null) goto L107;
        r1 = 2131369794;
        OUIFrameLayout r25 = ViewBindings.findChildViewById(r0, 2131369794);
        if (r25 == null) goto L107;
        r1 = 2131369795;
        OUILinearLayout r26 = ViewBindings.findChildViewById(r0, 2131369795);
        if (r26 == null) goto L107;
        r1 = 2131369796;
        OBottomActionBarNormalHorizontal r27 = ViewBindings.findChildViewById(r0, 2131369796);
        if (r27 == null) goto L107;
        r1 = 2131369797;
        if (ViewBindings.findChildViewById(r0, 2131369797) == null) goto L107;
        r1 = 2131369798;
        ONestedScrollView r28 = (ONestedScrollView) ViewBindings.findChildViewById(r0, 2131369798);
        if (r28 == null) goto L107;
        r1 = 2131369799;
        OUILinearLayout r210 = ViewBindings.findChildViewById(r0, 2131369799);
        if (r210 == null) goto L107;
        r1 = 2131369800;
        if (ViewBindings.findChildViewById(r0, 2131369800) == null) goto L107;
        r1 = 2131369801;
        OImage r30 = ViewBindings.findChildViewById(r0, 2131369801);
        if (r30 == null) goto L107;
        r1 = 2131369802;
        if (ViewBindings.findChildViewById(r0, 2131369802) == null) goto L107;
        r1 = 2131369803;
        OButton r31 = ViewBindings.findChildViewById(r0, 2131369803);
        if (r31 == null) goto L107;
        r1 = 2131369804;
        OImage r32 = ViewBindings.findChildViewById(r0, 2131369804);
        if (r32 == null) goto L107;
        r1 = 2131369805;
        OImage r33 = ViewBindings.findChildViewById(r0, 2131369805);
        if (r33 == null) goto L107;
        r1 = 2131369806;
        OUIFrameLayout r34 = ViewBindings.findChildViewById(r0, 2131369806);
        if (r34 == null) goto L107;
        r1 = 2131369807;
        OTextView r35 = ViewBindings.findChildViewById(r0, 2131369807);
        if (r35 == null) goto L107;
        r1 = 2131369808;
        OTextView r36 = ViewBindings.findChildViewById(r0, 2131369808);
        if (r36 == null) goto L107;
        r1 = 2131369809;
        OImage r37 = ViewBindings.findChildViewById(r0, 2131369809);
        if (r37 == null) goto L107;
        r1 = 2131369810;
        DoraObricDeviceModeEntryView r38 = (DoraObricDeviceModeEntryView) ViewBindings.findChildViewById(r0, 2131369810);
        if (r38 == null) goto L107;
        r1 = 2131369811;
        OTextView r310 = ViewBindings.findChildViewById(r0, 2131369811);
        if (r310 == null) goto L107;
        r1 = 2131369812;
        OUICardConstraintLayout r40 = ViewBindings.findChildViewById(r0, 2131369812);
        if (r40 == null) goto L107;
        r1 = 2131369813;
        if (ViewBindings.findChildViewById(r0, 2131369813) == null) goto L107;
        r1 = 2131369814;
        OTextView r41 = ViewBindings.findChildViewById(r0, 2131369814);
        if (r41 == null) goto L107;
        r1 = 2131369815;
        RecyclerView r42 = ViewBindings.findChildViewById(r0, 2131369815);
        if (r42 == null) goto L107;
        r1 = 2131369818;
        OTextView r43 = ViewBindings.findChildViewById(r0, 2131369818);
        if (r43 == null) goto L107;
        r1 = 2131369819;
        View r44 = ViewBindings.findChildViewById(r0, 2131369819);
        if (r44 == null) goto L107;
        r1 = 2131369820;
        OTextView r45 = ViewBindings.findChildViewById(r0, 2131369820);
        if (r45 == null) goto L107;
        r1 = 2131369821;
        OImage r46 = ViewBindings.findChildViewById(r0, 2131369821);
        if (r46 == null) goto L107;
        r1 = 2131369822;
        ONestedScrollView r47 = (ONestedScrollView) ViewBindings.findChildViewById(r0, 2131369822);
        if (r47 == null) goto L107;
        r1 = 2131369823;
        OUILinearLayout r48 = ViewBindings.findChildViewById(r0, 2131369823);
        if (r48 == null) goto L107;
        r1 = 2131369824;
        OFloatingTitleBar r410 = ViewBindings.findChildViewById(r0, 2131369824);
        if (r410 == null) goto L107;
        r1 = 2131369825;
        OImage r50 = ViewBindings.findChildViewById(r0, 2131369825);
        if (r50 == null) goto L107;
        ConstraintLayout r2 = r0;
        this.f = new LarusDoraPageObricDeviceHomeBinding(r2, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r110, r20, r21, r22, r23, r24, r25, r26, r27, r28, r210, r30, r31, r32, r33, r34, r35, r36, r37, r38, r310, r40, r41, r42, r43, r44, r45, r46, r47, r48, r410, r50);
        return r2;
    L107:
        throw new NullPointerException("Missing required view with ID: ".concat(r0.getResources().getResourceName(r1)));
    }
}
