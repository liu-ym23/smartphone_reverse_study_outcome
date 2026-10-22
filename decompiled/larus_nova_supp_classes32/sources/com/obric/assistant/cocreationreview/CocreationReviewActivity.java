package com.obric.assistant.cocreationreview;

import android.R;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Insets;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsets;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.applog.api.IApplog;
import com.larus.bmhome.rc.FlowResourceScene;
import com.larus.bmhome.rc.ResourceCenter;
import com.larus.im.bean.message.FileType;
import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.UplinkEntityContent;
import com.larus.im.bean.message.UplinkEntityType;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.im.bean.message.UplinkFileInfo;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import com.larus.voice_setting.voice.base.VoiceDisplayScene;
import com.lynx.jsbridge.LynxAccessibilityModule;
import com.lynx.jsbridge.LynxResourceModule;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000Í\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e*\u0001]\b\u0007\u0018\u0000 ¼\u00032\u00020\u00012\u00020\u0002:\f·\u0003¸\u0003¹\u0003º\u0003»\u0003¼\u0003B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010e\u001a\u00020f2\u0006\u0010g\u001a\u00020*H\u0002J\u0012\u0010¥\u0001\u001a\u0002052\u0007\u0010¦\u0001\u001a\u00020\u000eH\u0002J\u0015\u0010§\u0001\u001a\u00020f2\n\u0010¨\u0001\u001a\u0005\u0018\u00010©\u0001H\u0014J\t\u0010ª\u0001\u001a\u00020fH\u0014J\t\u0010«\u0001\u001a\u00020fH\u0014J\t\u0010¬\u0001\u001a\u00020fH\u0014J\u0013\u0010\u00ad\u0001\u001a\u00020f2\b\u0010®\u0001\u001a\u00030©\u0001H\u0014J\t\u0010¯\u0001\u001a\u00020fH\u0014J\t\u0010°\u0001\u001a\u00020fH\u0002J\u0012\u0010±\u0001\u001a\u00020f2\u0007\u0010²\u0001\u001a\u00020-H\u0002J\t\u0010³\u0001\u001a\u00020fH\u0002J\t\u0010´\u0001\u001a\u00020oH\u0002J\u0013\u0010µ\u0001\u001a\u00030¶\u00012\u0007\u0010²\u0001\u001a\u00020-H\u0002J\u001b\u0010·\u0001\u001a\u00020o2\u0007\u0010²\u0001\u001a\u00020-2\u0007\u0010¸\u0001\u001a\u00020oH\u0002J\u0012\u0010¹\u0001\u001a\u00020f2\u0007\u0010²\u0001\u001a\u00020-H\u0002J\t\u0010º\u0001\u001a\u00020fH\u0002J\t\u0010»\u0001\u001a\u00020fH\u0002J\u0013\u0010¼\u0001\u001a\u00020f2\b\u0010½\u0001\u001a\u00030¾\u0001H\u0002J\t\u0010¿\u0001\u001a\u00020fH\u0002J\n\u0010À\u0001\u001a\u00030Á\u0001H\u0002J\u0013\u0010Â\u0001\u001a\u00020f2\b\u0010Ã\u0001\u001a\u00030Ä\u0001H\u0002J\t\u0010Å\u0001\u001a\u00020fH\u0002J\u0013\u0010Æ\u0001\u001a\u00020o2\b\u0010Ã\u0001\u001a\u00030Ä\u0001H\u0002J\u0013\u0010Ç\u0001\u001a\u00020o2\b\u0010Ã\u0001\u001a\u00030Ä\u0001H\u0002J\t\u0010È\u0001\u001a\u00020fH\u0002J\u0013\u0010É\u0001\u001a\u00020f2\b\u0010Ê\u0001\u001a\u00030Ë\u0001H\u0002J\u0013\u0010Ì\u0001\u001a\u00020f2\b\u0010Ê\u0001\u001a\u00030Ë\u0001H\u0002J\u001b\u0010Í\u0001\u001a\u0004\u0018\u00010y2\b\u0010Ê\u0001\u001a\u00030Ë\u0001H\u0002¢\u0006\u0003\u0010Î\u0001J\t\u0010Ï\u0001\u001a\u00020fH\u0002J\f\u0010Ð\u0001\u001a\u0005\u0018\u00010Ë\u0001H\u0002J\u0012\u0010Ñ\u0001\u001a\u00020f2\u0007\u0010Ò\u0001\u001a\u00020oH\u0002J\u001d\u0010Ó\u0001\u001a\u00020o2\b\u0010Ê\u0001\u001a\u00030Ë\u00012\b\u0010Ô\u0001\u001a\u00030Õ\u0001H\u0002J\u0015\u0010Ö\u0001\u001a\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020.0\rH\u0002J\u0012\u0010×\u0001\u001a\u00020o2\u0007\u0010Ø\u0001\u001a\u00020-H\u0002J\u0014\u0010Ù\u0001\u001a\u00020f2\t\b\u0002\u0010¸\u0001\u001a\u00020oH\u0002J\t\u0010Ú\u0001\u001a\u00020fH\u0002J\t\u0010Û\u0001\u001a\u00020fH\u0002J\t\u0010Ü\u0001\u001a\u00020oH\u0002J\t\u0010Ý\u0001\u001a\u00020fH\u0002J\u0010\u0010Þ\u0001\u001a\t\u0012\u0005\u0012\u00030ß\u00010\u0006H\u0002J\t\u0010à\u0001\u001a\u00020fH\u0002J\u0013\u0010á\u0001\u001a\u00020f2\b\u0010â\u0001\u001a\u00030ã\u0001H\u0002J\u001a\u0010ä\u0001\u001a\u00020f2\u000f\u0010å\u0001\u001a\n\u0012\u0005\u0012\u00030ß\u00010æ\u0001H\u0002J\u001a\u0010ç\u0001\u001a\u00020f2\u000f\u0010å\u0001\u001a\n\u0012\u0005\u0012\u00030ß\u00010æ\u0001H\u0002J\u0014\u0010è\u0001\u001a\u00030Ë\u00012\b\u0010é\u0001\u001a\u00030ß\u0001H\u0002J)\u0010ê\u0001\u001a\u00020|2\b\u0010Ê\u0001\u001a\u00030Ë\u00012\t\b\u0002\u0010ë\u0001\u001a\u00020y2\t\b\u0002\u0010ì\u0001\u001a\u00020yH\u0002J\u0014\u0010í\u0001\u001a\u00030Ë\u00012\b\u0010é\u0001\u001a\u00030î\u0001H\u0002J\t\u0010ï\u0001\u001a\u00020fH\u0002J\u0014\u0010ð\u0001\u001a\u00030ñ\u00012\b\u0010é\u0001\u001a\u00030î\u0001H\u0002J\u0011\u0010ò\u0001\u001a\u00020f2\u0006\u0010h\u001a\u00020@H\u0002J\n\u0010ó\u0001\u001a\u00030\u0085\u0001H\u0002J\n\u0010ô\u0001\u001a\u00030\u0085\u0001H\u0002J\t\u0010õ\u0001\u001a\u00020fH\u0002J\u0012\u0010ö\u0001\u001a\u00020f2\u0007\u0010÷\u0001\u001a\u00020-H\u0002J\t\u0010ø\u0001\u001a\u00020fH\u0002J\u0013\u0010ù\u0001\u001a\u00020f2\b\u0010ú\u0001\u001a\u00030û\u0001H\u0002J\u0014\u0010ü\u0001\u001a\u00020f2\t\b\u0002\u0010ý\u0001\u001a\u00020-H\u0002J\u0014\u0010þ\u0001\u001a\u00030Ë\u00012\b\u0010é\u0001\u001a\u00030ÿ\u0001H\u0002J\u0014\u0010\u0080\u0002\u001a\u00030Ë\u00012\b\u0010é\u0001\u001a\u00030\u0081\u0002H\u0002J7\u0010\u0082\u0002\u001a\u00030Ë\u00012\u0007\u0010\u0083\u0002\u001a\u0002052\u0007\u0010\u0084\u0002\u001a\u00020y2\u0007\u0010\u0085\u0002\u001a\u00020y2\u0007\u0010\u0086\u0002\u001a\u00020y2\u0007\u0010\u0087\u0002\u001a\u00020yH\u0002J\u0013\u0010\u0088\u0002\u001a\u00030Ë\u00012\u0007\u0010\u0089\u0002\u001a\u00020yH\u0002J\u0015\u0010\u008a\u0002\u001a\u00030Ë\u00012\t\b\u0002\u0010\u008b\u0002\u001a\u00020jH\u0002J,\u0010\u008c\u0002\u001a\u00030\u0093\u00012\u0007\u0010\u008d\u0002\u001a\u00020-2\u0007\u0010\u008e\u0002\u001a\u00020o2\u000e\u0010\u008f\u0002\u001a\t\u0012\u0004\u0012\u00020f0\u0090\u0002H\u0002J\u0014\u0010\u0091\u0002\u001a\u00020y2\t\u0010¦\u0001\u001a\u0004\u0018\u00010\u000eH\u0002J\u000f\u0010\u0092\u0002\u001a\b\u0012\u0004\u0012\u0002080\u0006H\u0002J(\u0010\u0093\u0002\u001a\b\u0012\u0004\u0012\u0002080\u0006*\b\u0012\u0004\u0012\u0002080\u00062\r\u0010\u0094\u0002\u001a\b\u0012\u0004\u0012\u0002080\u0006H\u0002J\u000f\u0010\u0095\u0002\u001a\u0004\u0018\u00010-*\u000208H\u0002J4\u0010\u0096\u0002\u001a\u00030Ë\u00012\u0007\u0010\u0097\u0002\u001a\u0002082\u0007\u0010\u0098\u0002\u001a\u00020.2\u0007\u0010\u0099\u0002\u001a\u00020o2\r\u0010\u009a\u0002\u001a\b\u0012\u0004\u0012\u0002000\u0006H\u0002J\u0013\u0010\u009b\u0002\u001a\u00030\u009c\u00022\u0007\u0010\u0098\u0002\u001a\u00020.H\u0002J\u001d\u0010\u009d\u0002\u001a\u00020f2\u0007\u0010\u009e\u0002\u001a\u00020w2\t\b\u0002\u0010\u009f\u0002\u001a\u00020yH\u0002J\t\u0010 \u0002\u001a\u00020fH\u0002J\u0013\u0010¡\u0002\u001a\u00030Ë\u00012\u0007\u0010\u009e\u0002\u001a\u00020wH\u0002J\u001d\u0010¢\u0002\u001a\u00030Ë\u00012\u0007\u0010\u009e\u0002\u001a\u00020w2\b\u0010£\u0002\u001a\u00030¤\u0002H\u0002J#\u0010¥\u0002\u001a\t\u0012\u0005\u0012\u00030¦\u00020\u00062\u0007\u0010\u009e\u0002\u001a\u00020w2\b\u0010£\u0002\u001a\u00030¤\u0002H\u0002J\u001d\u0010§\u0002\u001a\u00020o2\b\u0010¨\u0002\u001a\u00030¦\u00022\b\u0010©\u0002\u001a\u00030¦\u0002H\u0002J\u0014\u0010ª\u0002\u001a\t\u0012\u0005\u0012\u00030¤\u00020\u0006*\u00020wH\u0002J\u001c\u0010«\u0002\u001a\u00030\u0095\u00012\u0007\u0010¬\u0002\u001a\u00020y2\u0007\u0010\u00ad\u0002\u001a\u00020yH\u0002J%\u0010®\u0002\u001a\u00020f2\b\u0010¯\u0002\u001a\u00030\u0095\u00012\u0007\u0010¬\u0002\u001a\u00020y2\u0007\u0010\u00ad\u0002\u001a\u00020yH\u0002J&\u0010°\u0002\u001a\u00030Ë\u00012\u0007\u0010\u009e\u0002\u001a\u00020w2\b\u0010£\u0002\u001a\u00030¤\u00022\u0007\u0010\u0098\u0002\u001a\u00020.H\u0002J\u0016\u0010±\u0002\u001a\u00020-*\u00020w2\u0007\u0010²\u0002\u001a\u00020yH\u0002J\u0016\u0010³\u0002\u001a\u00020y*\u00020w2\u0007\u0010Ø\u0001\u001a\u00020-H\u0002J\u0017\u0010´\u0002\u001a\u00020-*\u00030¤\u00022\u0007\u0010\u009e\u0002\u001a\u00020wH\u0002J&\u0010µ\u0002\u001a\u00030ñ\u00012\u0007\u0010Ø\u0001\u001a\u00020-2\u0007\u0010\u0098\u0002\u001a\u00020.2\b\u0010¶\u0002\u001a\u00030·\u0002H\u0002J\u001c\u0010¸\u0002\u001a\u00020f2\u0007\u0010Ø\u0001\u001a\u00020-2\b\u0010¶\u0002\u001a\u00030·\u0002H\u0002J\n\u0010¹\u0002\u001a\u00030\u0093\u0001H\u0002J\u0014\u0010º\u0002\u001a\u00030Ë\u00012\b\u0010»\u0002\u001a\u00030¦\u0002H\u0002J\u0010\u0010¼\u0002\u001a\u0004\u0018\u00010-*\u00030¦\u0002H\u0002J\u001d\u0010½\u0002\u001a\u00030Ë\u00012\u0007\u0010¾\u0002\u001a\u00020-2\b\u0010¿\u0002\u001a\u00030Ë\u0001H\u0002J\u0013\u0010À\u0002\u001a\u00030\u0093\u00012\u0007\u0010¾\u0002\u001a\u00020-H\u0002J\u0019\u0010Á\u0002\u001a\u00030Ë\u00012\r\u0010Â\u0002\u001a\b\u0012\u0004\u0012\u00020-0\u0006H\u0002J\n\u0010Ã\u0002\u001a\u00030Ë\u0001H\u0002J\n\u0010Ä\u0002\u001a\u00030Ë\u0001H\u0002J\u0013\u0010Å\u0002\u001a\u00030Ë\u00012\u0007\u0010Ê\u0001\u001a\u00020@H\u0002J\n\u0010Æ\u0002\u001a\u00030Ë\u0001H\u0002J\u0016\u0010Í\u0002\u001a\u00020y*\u00020@2\u0007\u0010\u008e\u0002\u001a\u00020oH\u0002J\u001c\u0010Î\u0002\u001a\u00020f2\u0007\u0010Ø\u0001\u001a\u00020-2\b\u0010¶\u0002\u001a\u00030·\u0002H\u0002J\u001b\u0010Ï\u0002\u001a\u00020o2\u0007\u0010Ø\u0001\u001a\u00020-2\u0007\u0010÷\u0001\u001a\u00020-H\u0002J\u0014\u0010Ð\u0002\u001a\u0004\u0018\u0001082\u0007\u0010Ø\u0001\u001a\u00020-H\u0002J\u001c\u0010Ñ\u0002\u001a\u00020f2\u0007\u0010\u0097\u0002\u001a\u0002082\b\u0010¶\u0002\u001a\u00030·\u0002H\u0002J\u001c\u0010Ò\u0002\u001a\u00020f2\u0007\u0010\u0097\u0002\u001a\u0002082\b\u0010¶\u0002\u001a\u00030·\u0002H\u0002J\u001c\u0010Ó\u0002\u001a\u00020.2\u0007\u0010\u0097\u0002\u001a\u0002082\b\u0010¶\u0002\u001a\u00030·\u0002H\u0002J(\u0010Ô\u0002\u001a\u00020f2\u0007\u0010÷\u0001\u001a\u00020-2\t\b\u0002\u0010Õ\u0002\u001a\u00020o2\t\b\u0002\u0010Ö\u0002\u001a\u00020oH\u0002J\u001e\u0010×\u0002\u001a\u00030Ø\u00022\u0007\u0010Ø\u0001\u001a\u00020-2\t\u0010¦\u0001\u001a\u0004\u0018\u00010\u000eH\u0002J\u0013\u0010Ù\u0002\u001a\u00020f2\b\u0010Ú\u0002\u001a\u00030Ø\u0002H\u0002J\f\u0010Û\u0002\u001a\u0005\u0018\u00010Ü\u0002H\u0002J\u001b\u0010Ý\u0002\u001a\u00020f2\u0007\u0010Ø\u0001\u001a\u00020-2\u0007\u0010²\u0001\u001a\u00020-H\u0016J\u001b\u0010Þ\u0002\u001a\u00020f2\u0007\u0010Ø\u0001\u001a\u00020-2\u0007\u0010ß\u0002\u001a\u00020-H\u0016J!\u0010à\u0002\u001a\u00020f2\u0007\u0010Ø\u0001\u001a\u00020-2\r\u0010á\u0002\u001a\b\u0012\u0004\u0012\u0002000\u0006H\u0016J\u0012\u0010â\u0002\u001a\u00020f2\u0007\u0010Ø\u0001\u001a\u00020-H\u0016J\u001b\u0010ã\u0002\u001a\u00020f2\u0007\u0010Ø\u0001\u001a\u00020-2\u0007\u0010÷\u0001\u001a\u00020-H\u0016J1\u0010ä\u0002\u001a\u00020f2\u0007\u0010Ø\u0001\u001a\u00020-2\u0007\u0010²\u0001\u001a\u00020-2\t\b\u0002\u0010å\u0002\u001a\u00020o2\t\b\u0002\u0010÷\u0001\u001a\u00020-H\u0002J#\u0010æ\u0002\u001a\u00020f2\u0007\u0010Ø\u0001\u001a\u00020-2\t\u0010ç\u0002\u001a\u0004\u0018\u00010yH\u0002¢\u0006\u0003\u0010è\u0002J\u0012\u0010é\u0002\u001a\u00020f2\u0007\u0010Ø\u0001\u001a\u00020-H\u0002J%\u0010ê\u0002\u001a\u00020f2\u0007\u0010\u0097\u0002\u001a\u0002082\u0007\u0010ë\u0002\u001a\u00020\u00132\b\u0010ì\u0002\u001a\u00030í\u0002H\u0002J1\u0010î\u0002\u001a\u00020o2\u0007\u0010Ø\u0001\u001a\u00020-2\u0007\u0010ï\u0002\u001a\u00020-2\u0014\u0010ð\u0002\u001a\u000f\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u0002000ñ\u0002H\u0002J\u001b\u0010ò\u0002\u001a\u00020f2\u0007\u0010Ø\u0001\u001a\u00020-2\u0007\u0010ó\u0002\u001a\u00020-H\u0002J%\u0010ô\u0002\u001a\u00020f2\u0007\u0010\u0097\u0002\u001a\u0002082\u0007\u0010ë\u0002\u001a\u00020\u00132\b\u0010ì\u0002\u001a\u00030í\u0002H\u0002J\u0012\u0010õ\u0002\u001a\u00020f2\u0007\u0010Ø\u0001\u001a\u00020-H\u0002J\u0012\u0010ö\u0002\u001a\u00020f2\u0007\u0010Ø\u0001\u001a\u00020-H\u0002J\u0014\u0010÷\u0002\u001a\t\u0012\u0004\u0012\u00020-0ø\u0002*\u00020.H\u0002J>\u0010ù\u0002\u001a\u00020f2\u0007\u0010Ø\u0001\u001a\u00020-2\t\b\u0002\u0010å\u0002\u001a\u00020o2\t\b\u0002\u0010÷\u0001\u001a\u00020-2\u0014\u0010ð\u0002\u001a\u000f\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020.0ñ\u0002H\u0002J\u0014\u0010ú\u0002\u001a\u00030Ë\u00012\b\u0010û\u0002\u001a\u00030\u0085\u0001H\u0002J\u0014\u0010ü\u0002\u001a\u00030Ë\u00012\b\u0010û\u0002\u001a\u00030\u0085\u0001H\u0002J\u001c\u0010ý\u0002\u001a\u00030Ë\u00012\u0007\u0010¾\u0002\u001a\u00020-2\u0007\u0010ç\u0002\u001a\u00020yH\u0002J\n\u0010þ\u0002\u001a\u00030Ë\u0001H\u0002J\t\u0010ÿ\u0002\u001a\u00020fH\u0002J\u0012\u0010\u0080\u0003\u001a\u00020f2\u0007\u0010÷\u0001\u001a\u00020-H\u0002J\t\u0010\u0081\u0003\u001a\u00020fH\u0002J\n\u0010\u0082\u0003\u001a\u00030Ë\u0001H\u0002J\t\u0010\u0083\u0003\u001a\u00020yH\u0002J\u0013\u0010\u0084\u0003\u001a\u00030\u0085\u00032\u0007\u0010\u0083\u0002\u001a\u000205H\u0002J!\u0010\u0086\u0003\u001a\u00030Ë\u00012\t\u0010\u0083\u0002\u001a\u0004\u0018\u0001052\n\u0010Ú\u0002\u001a\u0005\u0018\u00010\u0085\u0003H\u0002J!\u0010\u0087\u0003\u001a\u00030Ë\u00012\t\u0010\u0083\u0002\u001a\u0004\u0018\u0001052\n\u0010Ú\u0002\u001a\u0005\u0018\u00010\u0085\u0003H\u0002J*\u0010\u0088\u0003\u001a\u00020f2\b\u0010\u0089\u0003\u001a\u00030\u0095\u00012\t\u0010\u0083\u0002\u001a\u0004\u0018\u0001052\n\u0010Ú\u0002\u001a\u0005\u0018\u00010\u0085\u0003H\u0002J#\u0010\u008a\u0003\u001a\u00030\u0093\u00012\u0007\u0010\u008b\u0003\u001a\u00020o2\u000e\u0010\u008f\u0002\u001a\t\u0012\u0004\u0012\u00020f0\u0090\u0002H\u0002J\u0012\u0010\u008c\u0003\u001a\u00020f2\u0007\u0010\u0083\u0002\u001a\u000205H\u0002J\t\u0010\u008d\u0003\u001a\u00020fH\u0002J\u001c\u0010\u008e\u0003\u001a\u00020f2\b\u0010\u008f\u0003\u001a\u00030\u0093\u00012\u0007\u0010\u008b\u0003\u001a\u00020oH\u0002J\u0013\u0010\u0090\u0003\u001a\u00020f2\b\u0010\u0091\u0003\u001a\u00030\u0092\u0003H\u0002J\u0014\u0010\u0093\u0003\u001a\u00030û\u00012\b\u0010\u0091\u0003\u001a\u00030\u0092\u0003H\u0002J\u000b\u0010\u0094\u0003\u001a\u0004\u0018\u00010-H\u0002J\u0018\u0010\u0095\u0003\u001a\u00030\u0096\u0003*\u00030\u0092\u00032\u0007\u0010\u0097\u0003\u001a\u000205H\u0002J\u0013\u0010\u0098\u0003\u001a\u00020-2\b\u0010\u0099\u0003\u001a\u00030\u009f\u0001H\u0002J\u0013\u0010\u009a\u0003\u001a\u00020-2\b\u0010\u0099\u0003\u001a\u00030\u009f\u0001H\u0002J\u001c\u0010\u009b\u0003\u001a\u00020-2\b\u0010\u0099\u0003\u001a\u00030\u009f\u00012\u0007\u0010\u009c\u0003\u001a\u00020-H\u0002J\u0016\u0010\u009d\u0003\u001a\u00030û\u0001*\n\u0012\u0005\u0012\u00030\u009f\u00030\u009e\u0003H\u0002J\u000f\u0010 \u0003\u001a\u00030¡\u0003*\u00030\u0085\u0001H\u0002J#\u0010¢\u0003\u001a\u00030£\u0003*\u0002052\u0013\u0010¤\u0003\u001a\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020.0\rH\u0002J\u0016\u0010¥\u0003\u001a\u00030û\u0001*\n\u0012\u0005\u0012\u00030\u009f\u00030\u009e\u0003H\u0002J\u0018\u0010¦\u0003\u001a\u00020-*\r\u0012\u0007\u0012\u0005\u0018\u00010£\u0003\u0018\u00010\u0006H\u0002J\n\u0010§\u0003\u001a\u00030Ë\u0001H\u0002J\u001c\u0010¨\u0003\u001a\u00030Ë\u00012\u0007\u0010\u0083\u0002\u001a\u0002052\u0007\u0010\u008e\u0002\u001a\u00020oH\u0002J\u0012\u0010©\u0003\u001a\u00020f2\u0007\u0010¦\u0001\u001a\u00020\u000eH\u0002J\u001b\u0010ª\u0003\u001a\u00020f2\u0007\u0010\u0083\u0002\u001a\u0002052\u0007\u0010\u008e\u0002\u001a\u00020oH\u0002J\n\u0010«\u0003\u001a\u00030¬\u0003H\u0002J\u0013\u0010\u00ad\u0003\u001a\u00020f2\b\u0010®\u0003\u001a\u00030¯\u0003H\u0002J\u0013\u0010°\u0003\u001a\u00020-2\b\u0010±\u0003\u001a\u00030\u009f\u0001H\u0002J\u0013\u0010²\u0003\u001a\u00020-2\b\u0010±\u0003\u001a\u00030\u009f\u0001H\u0002J\u0016\u0010³\u0003\u001a\u00030\u009f\u00012\n\b\u0002\u0010´\u0003\u001a\u00030\u009f\u0001H\u0002J\u0016\u0010µ\u0003\u001a\u00030\u009f\u00012\n\b\u0002\u0010¶\u0003\u001a\u00030\u009f\u0001H\u0002R!\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR'\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00070\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u000b\u001a\u0004\b\u000f\u0010\u0010R!\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0014\u0010\tR'\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00130\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u000b\u001a\u0004\b\u0017\u0010\u0010R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u000b\u001a\u0004\b\u001b\u0010\u001cR\u001b\u0010\u001e\u001a\u00020\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u000b\u001a\u0004\b \u0010!R\u001b\u0010#\u001a\u00020$8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\u000b\u001a\u0004\b%\u0010&R*\u0010(\u001a\u001e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020*0)j\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020*`+X\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010,\u001a\u001e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020.0)j\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020.`+X\u0082\u0004¢\u0006\u0002\n\u0000R6\u0010/\u001a*\u0012\u0004\u0012\u00020-\u0012\n\u0012\b\u0012\u0004\u0012\u0002000\u00060)j\u0014\u0012\u0004\u0012\u00020-\u0012\n\u0012\b\u0012\u0004\u0012\u0002000\u0006`+X\u0082\u0004¢\u0006\u0002\n\u0000R6\u00101\u001a*\u0012\u0004\u0012\u00020-\u0012\n\u0012\b\u0012\u0004\u0012\u0002000\u00060)j\u0014\u0012\u0004\u0012\u00020-\u0012\n\u0012\b\u0012\u0004\u0012\u0002000\u0006`+X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u000203X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u00104\u001a\b\u0012\u0004\u0012\u0002050\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b6\u0010\tR\u001a\u00107\u001a\b\u0012\u0004\u0012\u0002080\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b9\u0010\tR \u0010:\u001a\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020.0\r8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b;\u0010\u0010R\u001e\u0010<\u001a\u0012\u0012\u0004\u0012\u00020-0=j\b\u0012\u0004\u0012\u00020-`>X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010?\u001a\b\u0012\u0004\u0012\u00020@0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020BX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020DX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020FX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010G\u001a\u0004\u0018\u00010-X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010H\u001a\u00020I8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bL\u0010\u000b\u001a\u0004\bJ\u0010KR\u001b\u0010M\u001a\u00020N8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bQ\u0010\u000b\u001a\u0004\bO\u0010PR\u001b\u0010R\u001a\u00020S8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bV\u0010\u000b\u001a\u0004\bT\u0010UR\u001b\u0010W\u001a\u00020X8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b[\u0010\u000b\u001a\u0004\bY\u0010ZR\u0010\u0010\\\u001a\u00020]X\u0082\u0004¢\u0006\u0004\n\u0002\u0010^R\u000e\u0010_\u001a\u00020`X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010a\u001a\u00020bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010c\u001a\u00020dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010h\u001a\u00020@X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010i\u001a\u00020jX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010k\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010l\u001a\u0004\u0018\u00010-X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010m\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010n\u001a\u00020oX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010p\u001a\u00020oX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010q\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010r\u001a\u0004\u0018\u00010-X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010s\u001a\u00020-X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010t\u001a\u00020oX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010u\u001a\u00020oX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010v\u001a\u0004\u0018\u00010wX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010x\u001a\u00020yX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010z\u001a\u00020yX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010{\u001a\u00020|X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010}\u001a\u00020~X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u007f\u001a\u00020|X\u0082.¢\u0006\u0002\n\u0000R\u000f\u0010\u0080\u0001\u001a\u00020|X\u0082.¢\u0006\u0002\n\u0000R\u0011\u0010\u0081\u0001\u001a\u0004\u0018\u00010@X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0082\u0001\u001a\u0004\u0018\u00010oX\u0082\u000e¢\u0006\u0005\n\u0003\u0010\u0083\u0001R\u0012\u0010\u0084\u0001\u001a\u0005\u0018\u00010\u0085\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0086\u0001\u001a\u0004\u0018\u00010oX\u0082\u000e¢\u0006\u0005\n\u0003\u0010\u0083\u0001R\u0014\u0010\u0087\u0001\u001a\u0004\u0018\u00010oX\u0082\u000e¢\u0006\u0005\n\u0003\u0010\u0083\u0001R\u0011\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0089\u0001\u001a\u0004\u0018\u00010-X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u008a\u0001\u001a\u0004\u0018\u00010oX\u0082\u000e¢\u0006\u0005\n\u0003\u0010\u0083\u0001R\u0011\u0010\u008b\u0001\u001a\u0004\u0018\u00010wX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u008c\u0001\u001a\u0004\u0018\u00010yX\u0082\u000e¢\u0006\u0005\n\u0003\u0010\u008d\u0001R\u0011\u0010\u008e\u0001\u001a\u0004\u0018\u00010.X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u008f\u0001\u001a\u00020yX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0090\u0001\u001a\u0005\u0018\u00010\u0091\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0092\u0001\u001a\u0005\u0018\u00010\u0093\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0094\u0001\u001a\u0005\u0018\u00010\u0095\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0096\u0001\u001a\u0005\u0018\u00010\u0097\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0098\u0001\u001a\u0005\u0018\u00010\u0093\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R-\u0010\u0099\u0001\u001a \u0012\u0004\u0012\u00020\u000e\u0012\u0005\u0012\u00030\u009a\u00010)j\u000f\u0012\u0004\u0012\u00020\u000e\u0012\u0005\u0012\u00030\u009a\u0001`+X\u0082\u0004¢\u0006\u0002\n\u0000R-\u0010\u009b\u0001\u001a \u0012\u0004\u0012\u00020-\u0012\u0005\u0012\u00030\u0093\u00010)j\u000f\u0012\u0004\u0012\u00020-\u0012\u0005\u0012\u00030\u0093\u0001`+X\u0082\u0004¢\u0006\u0002\n\u0000R\u000f\u0010\u009c\u0001\u001a\u00020oX\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u009d\u0001\u001a\u00020yX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u009e\u0001\u001a\u00030\u009f\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u0001\u001a\u00030\u009f\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010¡\u0001\u001a\u00030¢\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000f\u0010£\u0001\u001a\u00020oX\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010¤\u0001\u001a\u00020oX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010Ç\u0002\u001a\u00020y*\u00020@8BX\u0082\u0004¢\u0006\b\u001a\u0006\bÈ\u0002\u0010É\u0002R\u001b\u0010Ê\u0002\u001a\u00020-*\u00020@8BX\u0082\u0004¢\u0006\b\u001a\u0006\bË\u0002\u0010Ì\u0002¨\u0006½\u0003"}, d2 = {"Lcom/obric/assistant/cocreationreview/CocreationReviewActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/obric/assistant/cocreationreview/CocreationFeedbackPanelFragment$Callback;", "<init>", "()V", "moduleFeatures", NameKeys.UnloadStrategy_No_Strategy, "Lcom/obric/assistant/cocreationreview/CocreationModuleFeature;", "getModuleFeatures", "()Ljava/util/List;", "moduleFeatures$delegate", "Lkotlin/Lazy;", "moduleFeatureByKey", NameKeys.UnloadStrategy_No_Strategy, "Lcom/obric/assistant/cocreationreview/ModuleKey;", "getModuleFeatureByKey", "()Ljava/util/Map;", "moduleFeatureByKey$delegate", "providers", "Lcom/obric/assistant/cocreationreview/LabelingBusinessProvider;", "getProviders", "providers$delegate", "providerByModule", "getProviderByModule", "providerByModule$delegate", "labelingServerClient", "Lcom/obric/assistant/cocreationreview/CocreationLabelingServerClient;", "getLabelingServerClient", "()Lcom/obric/assistant/cocreationreview/CocreationLabelingServerClient;", "labelingServerClient$delegate", "memoryReviewBridge", "Lcom/obric/assistant/cocreationreview/modules/memory/ContentResolverMemoryReviewBridge;", "getMemoryReviewBridge", "()Lcom/obric/assistant/cocreationreview/modules/memory/ContentResolverMemoryReviewBridge;", "memoryReviewBridge$delegate", "usageCardTemplateRenderer", "Lcom/obric/assistant/cocreationreview/UsageCardTemplateRenderer;", "getUsageCardTemplateRenderer", "()Lcom/obric/assistant/cocreationreview/UsageCardTemplateRenderer;", "usageCardTemplateRenderer$delegate", "snapshots", "Ljava/util/LinkedHashMap;", "Lcom/obric/assistant/cocreationreview/LabelingSnapshot;", "Lkotlin/collections/LinkedHashMap;", "draftFeedbackMap", NameKeys.UnloadStrategy_No_Strategy, "Lcom/obric/assistant/cocreationreview/Feedback;", "draftFeedbackMediaMap", "Lcom/obric/assistant/cocreationreview/FeedbackMediaDraft;", "submittedFeedbackMediaMap", "feedbackMediaUploader", "Lcom/obric/assistant/cocreationreview/CocreationFeedbackMediaUploader;", "moduleMetas", "Lcom/obric/assistant/cocreationreview/ModuleMeta;", "getModuleMetas", "records", "Lcom/obric/assistant/cocreationreview/BaseUsageRecord;", "getRecords", "feedbackMap", "getFeedbackMap", "submittingRecordIds", "Ljava/util/LinkedHashSet;", "Lkotlin/collections/LinkedHashSet;", "visibleMainViews", "Lcom/obric/assistant/cocreationreview/MainView;", "taskCenterState", "Lcom/obric/assistant/cocreationreview/CocreationTaskCenterState;", "taskCenterScope", "Lkotlinx/coroutines/CoroutineScope;", "taskRunStore", "Lcom/obric/assistant/cocreationreview/CocreationTaskRunStore;", "taskCenterUserId", "taskRepository", "Lcom/obric/assistant/cocreationreview/CocreationTaskRepository;", "getTaskRepository", "()Lcom/obric/assistant/cocreationreview/CocreationTaskRepository;", "taskRepository$delegate", "overviewActions", "Lcom/obric/assistant/cocreationreview/CocreationOverviewActions;", "getOverviewActions", "()Lcom/obric/assistant/cocreationreview/CocreationOverviewActions;", "overviewActions$delegate", "taskCenterRenderer", "Lcom/obric/assistant/cocreationreview/CocreationTaskCenterRenderer;", "getTaskCenterRenderer", "()Lcom/obric/assistant/cocreationreview/CocreationTaskCenterRenderer;", "taskCenterRenderer$delegate", "pageAdapter", "Lcom/obric/assistant/cocreationreview/CocreationReviewPageAdapter;", "getPageAdapter", "()Lcom/obric/assistant/cocreationreview/CocreationReviewPageAdapter;", "pageAdapter$delegate", "overlayBackCallback", "com/obric/assistant/cocreationreview/CocreationReviewActivity$overlayBackCallback$1", "Lcom/obric/assistant/cocreationreview/CocreationReviewActivity$overlayBackCallback$1;", "keyboardLayoutListener", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "submitExecutor", "Ljava/util/concurrent/ExecutorService;", "providerListener", "Lcom/obric/assistant/cocreationreview/LabelingDataListener;", "handleProviderSnapshot", NameKeys.UnloadStrategy_No_Strategy, "snapshot", "mainView", "reviewMode", "Lcom/obric/assistant/cocreationreview/ReviewMode;", "selectedModule", "feedbackPanelRecordId", "feedbackPanelModule", "settlementDialogVisible", NameKeys.UnloadStrategy_No_Strategy, "reportSheetVisible", "reportSelectedModule", "reportSelectedIssue", "reportDraftContent", "reportSubmitting", "settlementSubmitting", "activeDetailView", "Lcom/obric/assistant/cocreationreview/DetailView$Content;", "activeDetailPageIndex", NameKeys.UnloadStrategy_No_Strategy, "renderCount", "rootHost", "Landroid/widget/FrameLayout;", "contentList", "Landroidx/recyclerview/widget/RecyclerView;", "bottomDockHost", "overlayHost", "renderedDockMainView", "renderedSettlementDialogVisible", "Ljava/lang/Boolean;", "renderedSettlementStats", "Lcom/obric/assistant/cocreationreview/SummaryStats;", "renderedSettlementSubmitting", "renderedReportSheetVisible", "renderedReportSelectedModule", "renderedReportSelectedIssue", "renderedReportSubmitting", "renderedDetailView", "renderedDetailPageIndex", "Ljava/lang/Integer;", "renderedDetailFeedback", "reportScrollY", "reportScrollView", "Landroid/widget/ScrollView;", "reportDescriptionView", "Landroid/widget/TextView;", "reportIssueContainer", "Landroid/widget/LinearLayout;", "reportInputView", "Landroid/widget/EditText;", "reportSubmitButtonView", "reportModuleOptionViews", "Lcom/obric/assistant/cocreationreview/CocreationReviewActivity$ReportModuleOptionView;", "reportIssueOptionViews", "keyboardVisible", "keyboardTop", "observeEarliestTimeMillis", NameKeys.UnloadStrategy_No_Strategy, "todaySettlementTimeMillis", "settlementDayBoundaryRunnable", "Ljava/lang/Runnable;", "refreshProvidersOnNextResume", "entryAccessGranted", "moduleMetaOf", "module", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "onPause", "onStop", "onSaveInstanceState", "outState", "onDestroy", "registerProviderObservers", "updateProviderObserveRequest", "reason", "notifyProvidersHostResumeFromBackground", "hasSettledToday", "restoreSettlementState", "Lcom/obric/assistant/cocreationreview/CocreationReviewActivity$SettlementStateRestoreResult;", "applySettlementStateIfNeeded", "resetScroll", "clearObserveWindowUiState", "handleSettlementDayBoundary", "scheduleSettlementDayBoundaryRefresh", "setupWindow", "window", "Landroid/view/Window;", "setupContentView", "createFloatingTitleBar", "Lcom/obric/oui/titlebar/OFloatingTitleBar;", "handleWindowInsets", "insets", "Landroid/view/WindowInsets;", "handleKeyboardGlobalLayout", "refreshKeyboardState", "isImeVisible", "ensureCurrentFocusedInputVisible", "scheduleFocusedInputVisibilityCheck", "view", "Landroid/view/View;", "ensureFocusedInputVisible", "focusedKeyboardTop", "(Landroid/view/View;)Ljava/lang/Integer;", "hideKeyboardAndRestoreReportSheet", "reportSheetView", "restoreReportSheetPosition", "animated", "isDescendantOf", "parent", "Landroid/view/ViewGroup;", "currentFeedbackMap", "isFeedbackCompleted", "recordId", "render", "renderBottomDockHost", "renderOverlayHost", "shouldHandleOverlayBack", "updateOverlayBackCallback", "buildPageItems", "Lcom/obric/assistant/cocreationreview/PageItem;", "loadCenterTasks", "runCenterTask", "task", "Lcom/obric/assistant/cocreationreview/CocreationTask;", "appendOverviewItems", "result", NameKeys.UnloadStrategy_No_Strategy, "appendReviewItems", "renderPageItem", "item", "listItem", "top", "bottom", "renderHeaderItem", "Lcom/obric/assistant/cocreationreview/PageItem$Header;", "requestReviewShortcut", "headerActionButton", "Landroid/widget/ImageView;", "handleHeaderAction", "buildReviewSummaryStats", "buildSettlementSummaryStats", "showSettlementDialog", "dismissSettlementDialog", "source", "confirmSettlementDialog", "triggerSettlementFeedbackReport", "submitResult", "Lcom/obric/assistant/cocreationreview/SubmitAnnotationResult;", "settleCurrentObserveWindow", "toastMessage", "renderOverviewRow", "Lcom/obric/assistant/cocreationreview/PageItem$OverviewRow;", "renderSummaryHero", "Lcom/obric/assistant/cocreationreview/PageItem$SummaryHero;", "moduleSummaryCard", "meta", "total", "completed", "up", "down", "progressBubble", "progress", "queueModeSwitch", "currentMode", "segButton", "text", "selected", "onClick", "Lkotlin/Function0;", "reviewModeTabCount", "filteredRecords", "foldVisualVersions", "allRecords", "visualGroupId", "renderUsageCard", "record", "feedback", "readOnly", "feedbackMedia", "templateFeedbackState", "Lcom/obric/assistant/cocreationreview/CardTemplateFeedbackState;", "showDetailView", "detailView", "initialPageIndex", "dismissDetailView", "renderDetailOverlay", "renderDetailPageContent", "currentPage", "Lcom/obric/assistant/cocreationreview/DetailPage;", "buildDetailSections", "Lcom/obric/assistant/cocreationreview/DetailSection;", "shouldSeparateDetailSections", "previous", "current", "detailPages", "renderDetailPageIndicator", "pageCount", "currentIndex", "updateDetailPageIndicator", "indicator", "renderDetailHeader", "activeDetailRecordId", "pageIndex", "pageIndexForRecordId", "detailRecordId", "detailVoteButton", "vote", "Lcom/obric/assistant/cocreationreview/Vote;", "handleDetailVoteClick", "closeDetailButton", "renderDetailSection", "section", "anchor", "detailSectionRow", "label", LynxAccessibilityModule.MSG_CONTENT, "detailSectionLabel", "detailStepsBox", "steps", "emptyState", "renderBottomDock", "dockItem", "divider", "headerActionIconRes", "getHeaderActionIconRes", "(Lcom/obric/assistant/cocreationreview/MainView;)I", "headerActionDescription", "getHeaderActionDescription", "(Lcom/obric/assistant/cocreationreview/MainView;)Ljava/lang/String;", "dockIconRes", "handleVoteClick", "shouldBlockVoteForActiveFeedbackPanel", "resolveVisibleRecordForCardAction", "showDefaultFeedbackPanel", "showDetailAfterVote", "applyFeedbackVoteDraft", "dismissFeedbackPanel", "dismissFragment", "discardDraft", "buildFeedbackPanelTemplate", "Lcom/obric/assistant/cocreationreview/FeedbackPanelTemplate;", "showFeedbackPanelFragment", "template", "currentFeedbackPanelFragment", "Lcom/obric/assistant/cocreationreview/CocreationFeedbackPanelFragment;", "onFeedbackPanelReasonToggle", "onFeedbackPanelCommentChange", "comment", "onFeedbackPanelMediaChange", "media", "onFeedbackPanelSubmit", "onFeedbackPanelDismissWithoutSubmit", "toggleReason", "renderAfter", "handleFeedbackValueSelect", "value", "(Ljava/lang/String;Ljava/lang/Integer;)V", "completeFeedback", "uploadNextFeedbackMedia", "provider", "submitRequest", "Lcom/obric/assistant/cocreationreview/SubmitAnnotationRequest;", "updateFeedbackMedia", "mediaId", "transform", "Lkotlin/Function1;", "failFeedbackMediaUpload", "message", "submitFeedbackToProvider", "promoteSubmittedFeedbackMedia", "resetFeedbackPanelSubmitting", "submitAnnotationReasons", NameKeys.UnloadStrategy_No_Strategy, "updateFeedback", "renderSettlementOverlay", "stats", "settlementStatsGrid", "settlementStatCard", "settlementActions", "showReportDialog", "dismissReportDialog", "clearReportOverlayViews", "renderReportOverlay", "reportSheetHeight", "reportTemplateFor", "Lcom/obric/assistant/cocreationreview/CocreationReviewActivity$ReportTemplate;", "reportTemplateDescription", "reportIssueGrid", "populateReportIssueGrid", "container", "reportSubmitButton", "enabled", "updateReportIssueViews", "updateReportSubmitButton", "applyReportSubmitButtonStyle", "button", "submitReport", "report", "Lcom/obric/assistant/cocreationreview/CocreationReport;", "submitProactiveDirectFeedback", "overallProactiveFeedbackRelatedInfo", "toUserFeedbackRequest", "Lcom/obric/assistant/cocreationreview/CocreationUserFeedbackRequest;", "moduleMeta", "resolveReportUniqId", "createdAt", "resolveSettlementUniqId", "resolveLabelingUniqId", "logTag", "toSubmitReportResult", "Lcom/larus/network/bean/HttpDataResult;", NameKeys.UnloadStrategy_No_Strategy, "toUserFeedbackStatRequest", "Lcom/obric/assistant/cocreationreview/CocreationUserFeedbackStatRequest;", "toUserFeedbackStatDetail", "Lcom/obric/assistant/cocreationreview/CocreationUserFeedbackStatDetail;", "settledFeedback", "toSubmitSettlementResult", "toLogText", "moduleTemplateGrid", "moduleTemplate", "selectReportModuleInSheet", "applyReportModuleOptionStyle", "bottomSheetBackground", "Landroid/graphics/drawable/GradientDrawable;", "selectModuleTab", "tab", "Lcom/obric/assistant/cocreationreview/ModuleTabState;", "formatObserveTime", "timeMillis", "formatObserveTimeSafely", "startOfTomorrowMillis", "nowMillis", "startOfYesterdayMillis", "todayStartMillis", "DetailPageAdapter", "DetailPageViewHolder", "ReportTemplate", "SettlementStateRestoreResult", "ReportModuleOptionView", "Companion", "cocreationreview_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CocreationReviewActivity extends AppCompatActivity implements CocreationFeedbackPanelFragment.a {
    public static final Set<String> P1 = null;
    public MainView A;
    public ReviewMode B;
    public ModuleKey C;
    public String D;
    public boolean E;
    public boolean F;
    public ModuleKey G;
    public long G1;
    public String H;
    public a5 H0;
    public final w0 H1;
    public String I;
    public boolean J;
    public boolean K;
    public z4.a L;
    public int L0;
    public boolean L1;
    public int M;
    public boolean M1;
    public int N;
    public FrameLayout O;
    public RecyclerView P;
    public ScrollView P0;
    public FrameLayout Q;
    public FrameLayout R;
    public MainView S;
    public Boolean T;
    public u5 U;
    public Boolean V;
    public TextView V0;
    public Boolean W;
    public ModuleKey X;
    public String Y;
    public Boolean Z;
    public final Lazy a;
    public final Lazy b;
    public LinearLayout b1;
    public final Lazy c;
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;
    public final Lazy g;
    public EditText g1;
    public final LinkedHashMap<ModuleKey, i5> h;
    public TextView h1;
    public final LinkedHashMap<String, a5> i;
    public final LinkedHashMap<String, List<b5>> j;
    public final LinkedHashMap<String, List<b5>> k;
    public z4.a k0;
    public final LinkedHashMap<ModuleKey, d> k1;
    public final q l;
    public final LinkedHashSet<String> m;
    public final List<MainView> n;
    public final q4 o;
    public final CoroutineScope p;
    public Integer p0;
    public final LinkedHashMap<String, TextView> p1;
    public final CocreationTaskRunStore q;
    public String r;
    public final Lazy s;
    public final Lazy t;
    public final Lazy u;
    public final Lazy v;
    public boolean v1;
    public final CocreationReviewActivity$overlayBackCallback$1 w;
    public final t0 x;
    public int x1;
    public final ExecutorService y;
    public long y1;
    public final v0 z;

    public static final class a {
    }

    public final class b extends RecyclerView.Adapter<c> {
        public final z4.a a;
        public final List<x4> b;
        public final /* synthetic */ CocreationReviewActivity c;

        public final int getItemCount() {
            return this.b.size();
        }

        public final void onBindViewHolder(RecyclerView.ViewHolder r4, int r5) {
            c r6 = (c) r4;
            Intrinsics.checkNotNullParameter(r6, "holder");
            CocreationReviewActivity r0 = this.c;
            z4.a r1 = this.a;
            x4 r7 = (x4) ListProtector.get(this.b, r5);
            Set<String> r2 = CocreationReviewActivity.P1;
            View r8 = r0.p2(r1, r7);
            r6.getClass();
            Intrinsics.checkNotNullParameter(r8, "page");
            r6.a.removeAllViews();
            r6.a.addView(r8, new FrameLayout.LayoutParams(-1, -1));
        }

        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "parent");
            FrameLayout r4 = new FrameLayout(r2.getContext());
            r4.setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
            return new c(r4);
        }

        public b(CocreationReviewActivity r2, z4.a r3, List<x4> r4) {
            Intrinsics.checkNotNullParameter(r3, "detailView");
            Intrinsics.checkNotNullParameter(r4, "pages");
            this.c = r2;
            this.a = r3;
            this.b = r4;
        }
    }

    public static final class c extends RecyclerView.ViewHolder {
        public final FrameLayout a;

        public c(FrameLayout r2) {
            Intrinsics.checkNotNullParameter(r2, "container");
            super(r2);
            this.a = r2;
        }
    }

    public static final class d {
        public final View a;
        public final TextView b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof d) == true) goto L8;
            return false;
        L8:
            d r6 = (d) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "ReportModuleOptionView(container=" + this.a + ", label=" + this.b + ')';
        }

        public d(View r2, TextView r3) {
            Intrinsics.checkNotNullParameter(r2, "container");
            Intrinsics.checkNotNullParameter(r3, "label");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class e {
        public final String a;
        public final List<String> b;
        public final String c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof e) == true) goto L8;
            return false;
        L8:
            e r6 = (e) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
        }

        public final String toString() {
            return "ReportTemplate(description=" + this.a + ", issues=" + this.b + ", placeholder=" + this.c + ')';
        }

        public e(String r2, List<String> r3, String r4) {
            Intrinsics.checkNotNullParameter(r2, "description");
            Intrinsics.checkNotNullParameter(r3, "issues");
            Intrinsics.checkNotNullParameter(r4, "placeholder");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public static final class f {
        public final boolean a;
        public final boolean b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof f) == true) goto L8;
            return false;
        L8:
            f r6 = (f) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r1 = 1231;
            if (this.a == false) goto L5;
            int r0 = 1231;
        L6:
            int r2 = r0 * 31;
            if (this.b == true) goto L11;
            r1 = 1237;
        L11:
            return r2 + r1;
        L5:
            r0 = 1237;
            goto L6
        }

        public final String toString() {
            return "SettlementStateRestoreResult(settlementChanged=" + this.a + ", observeWindowChanged=" + this.b + ')';
        }

        public f(boolean r1, boolean r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public /* synthetic */ class g {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;
        public static final /* synthetic */ int[] c = null;
        public static final /* synthetic */ int[] d = null;
        public static final /* synthetic */ int[] e = null;
        public static final /* synthetic */ int[] f = null;

        static {
            int[] r0 = new int[MainView.values().length];
            r0[MainView.OVERVIEW.ordinal()] = 1;     // Catch: NoSuchFieldError -> L35
        L85:
            r0[MainView.REVIEW.ordinal()] = 2;     // Catch: NoSuchFieldError -> L36
        L95:
            r0[MainView.TASK_CENTER.ordinal()] = 3;     // Catch: NoSuchFieldError -> L37
        L8:
            a = r0;
            int[] r1 = new int[CocreationReviewShortcut.Result.values().length];
            r1[CocreationReviewShortcut.Result.REQUESTED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L38
        L89:
            r1[CocreationReviewShortcut.Result.ALREADY_PINNED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L39
        L99:
            r1[CocreationReviewShortcut.Result.UNSUPPORTED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L40
        L57:
            r1[CocreationReviewShortcut.Result.FAILED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L41
        L14:
            b = r1;
            int[] r2 = new int[ReviewMode.values().length];
            r2[ReviewMode.QUEUE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L42
        L91:
            r2[ReviewMode.HISTORY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L43
        L17:
            c = r2;
            int[] r3 = new int[Vote.values().length];
            r3[Vote.UP.ordinal()] = 1;     // Catch: NoSuchFieldError -> L44
        L79:
            r3[Vote.DOWN.ordinal()] = 2;     // Catch: NoSuchFieldError -> L45
        L20:
            d = r3;
            int[] r4 = new int[FeedbackMediaSubmissionDecision.values().length];
            r4[FeedbackMediaSubmissionDecision.UPLOAD.ordinal()] = 1;     // Catch: NoSuchFieldError -> L46
        L67:
            r4[FeedbackMediaSubmissionDecision.SUBMIT_FEEDBACK.ordinal()] = 2;     // Catch: NoSuchFieldError -> L47
        L81:
            r4[FeedbackMediaSubmissionDecision.WAIT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L48
        L24:
            e = r4;
            int[] r5 = new int[ModuleKey.values().length];
            r5[ModuleKey.PROACTIVE_AGENT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L49
        L83:
            r5[ModuleKey.SCREEN_MEMORY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L50
        L93:
            r5[ModuleKey.AUDIO_MEMORY.ordinal()] = 3;     // Catch: NoSuchFieldError -> L51
        L63:
            r5[ModuleKey.AUTO_MEMORY_PRO.ordinal()] = 4;     // Catch: NoSuchFieldError -> L52
        L73:
            r5[ModuleKey.COLLECTION_MEMORY.ordinal()] = 5;     // Catch: NoSuchFieldError -> L53
        L87:
            r5[ModuleKey.PERSONAL_MEMORY.ordinal()] = 6;     // Catch: NoSuchFieldError -> L54
        L97:
            r5[ModuleKey.SEARCH_QA.ordinal()] = 7;     // Catch: NoSuchFieldError -> L55
        L59:
            r5[ModuleKey.OMNI.ordinal()] = 8;     // Catch: NoSuchFieldError -> L56
        L33:
            f = r5;
        }
    }

    public static final class h implements c5 {
        public final /* synthetic */ CocreationReviewActivity a;
        public final /* synthetic */ String b;
        public final /* synthetic */ b5 c;
        public final /* synthetic */ com.obric.assistant.cocreationreview.a d;
        public final /* synthetic */ e5 e;
        public final /* synthetic */ s5 f;

        /* JADX WARN: Type inference failed for: r0v1, types: [android.app.Activity, com.obric.assistant.cocreationreview.CocreationReviewActivity] */
        @Override // com.obric.assistant.cocreationreview.c5
        public final void a(final String r10, final long r11) {
            Intrinsics.checkNotNullParameter(r10, "identifier");
            final ?? r0 = this.a;
            final String r3 = this.b;
            final b5 r4 = this.c;
            r0.runOnUiThread(new l3(r0, r3, r4, r10, r11));
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [android.app.Activity, com.obric.assistant.cocreationreview.CocreationReviewActivity] */
        @Override // com.obric.assistant.cocreationreview.c5
        public final void onFailure(final String r9, final String r10) {
            Intrinsics.checkNotNullParameter(r9, "identifier");
            Intrinsics.checkNotNullParameter(r10, "message");
            final ?? r0 = this.a;
            final String r3 = this.b;
            final b5 r4 = this.c;
            r0.runOnUiThread(new n3(r0, r3, r4, r10, r9));
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [android.app.Activity, com.obric.assistant.cocreationreview.CocreationReviewActivity] */
        @Override // com.obric.assistant.cocreationreview.c5
        public final void onSuccess(final String r12, final String r13) {
            Intrinsics.checkNotNullParameter(r12, "identifier");
            Intrinsics.checkNotNullParameter(r13, "remoteUri");
            final ?? r0 = this.a;
            final String r3 = this.b;
            final b5 r4 = this.c;
            final com.obric.assistant.cocreationreview.a r5 = this.d;
            final e5 r6 = this.e;
            final s5 r7 = this.f;
            r0.runOnUiThread(new m3(r0, r3, r4, r5, r6, r7, r12, r13));
        }

        public h(CocreationReviewActivity r1, String r2, b5 r3, com.obric.assistant.cocreationreview.a r4, e5 r5, s5 r6) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
        }
    }

    static {
        P1 = SetsKt.setOf(new String[]{"点赞", "点踩"});
    }

    public final void A2() {
        FrameLayout r0 = this.O;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.removeCallbacks(this.H1);
        long r1 = System.currentTimeMillis();
        Calendar r2 = Calendar.getInstance();
        r2.setTimeInMillis(i0.b(r1));
        r2.add(6, 1);
        long r3 = RangesKt.coerceAtLeast((r2.getTimeInMillis() - r1) + 1000, 1000);
        FrameLayout r4 = this.O;
        if (r4 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("rootHost");
        r4 = null;
    L8:
        r4.postDelayed(this.H1, r3);
        int r5 = s3.a;
        s3.a("settlement.state", "scheduleDayBoundaryRefresh delayMillis=" + r3);
    }

    public final void I1() {
        ScrollView r0 = this.P0;
        if (r0 == null) goto L5;
        this.L0 = r0.getScrollY();
    L5:
        this.P0 = null;
        this.V0 = null;
        this.b1 = null;
        this.g1 = null;
        this.h1 = null;
        this.k1.clear();
        this.p1.clear();
    }

    public final Map<String, a5> L1() {
        LinkedHashMap r0 = new LinkedHashMap();
        Iterator<T> r1 = this.h.values().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r0.putAll(((i5) r1.next()).d);
        goto L4
    L6:
        r0.putAll(this.i);
        return r0;
    }

    public final void R1() {
        int r0 = s3.a;
        z4.a r1 = this.L;
        if (r1 == null) goto L6;
        String r2 = r1.a;
        if (r2 == null) goto L6;
    L7:
        s3.b("detail.action", "dismiss recordId=".concat(r2));
        this.L = null;
        this.M = 0;
        o2(false);
        return;
    L6:
        r2 = VoiceDisplayScene.NONE;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final View U1() {
        View r0 = new View(this);
        r0.setBackgroundColor(-1512723);
        r0.setMinimumHeight(c4.c(this, 1));
        r0.setLayoutParams(new LinearLayout.LayoutParams(-1, c4.c(this, 1)));
        return r0;
    }

    public final List<e5> b2() {
        return (List) this.c.getValue();
    }

    public final List<com.obric.assistant.cocreationreview.a> c2() {
        Collection<i5> r0 = this.h.values();
        ArrayList r1 = new ArrayList();
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        i5 r3 = (i5) r2.next();
        CollectionsKt.addAll(r1, CollectionsKt.plus(r3.b, r3.c));
        goto L4
    L6:
        return r1;
    }

    public final void k2() {
        q4 r0 = this.o;
        if (r0.b == false) goto L5;
        return;
    L5:
        if (r0.g != null) goto L13;
        String r1 = AccountService.a.getUserId();
        if (Intrinsics.areEqual(this.r, r1) == true) goto L10;
        q4 r2 = this.o;
        r2.getClass();
        r2.a = CollectionsKt.emptyList();
        r2.d.clear();
        r2.e.clear();
        r2.f = null;
        r2.g = null;
        r2.h = CocreationTaskFilter.ALL;
    L10:
        this.r = r1;
        q4 r3 = this.o;
        r3.b = true;
        r3.c = false;
        o2(false);
        BuildersKt.launch$default(this.p, null, null, new CocreationReviewActivity$loadCenterTasks$1(this, r1, null), 3, null);
        return;
    }

    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(CocreationReviewActivity.class.getName()));
    L5:
        FrameLayout r1 = null;
        CoroutineScopeKt.cancel$default(this.p, null, 1, null);
        if (this.M1 == false) goto L8;
        ((q0) this.t.getValue()).b();
    L8:
        q r0 = this.l;
        r0.b.set(true);
        Iterator<T> r3 = r0.c.values().iterator();
    L10:
        if (r3.hasNext() == false) goto L12;
        ((AtomicBoolean) r3.next()).set(true);
        goto L10
    L12:
        r0.c.clear();
        CoroutineScopeKt.cancel$default(r0.a, null, 1, null);
        if (this.M1 == true) goto L15;
        super.onDestroy();
        return;
    L15:
        int r2 = s3.a;
        s3.b("activity.lifecycle", "onDestroy providers=" + b2().size() + ", renderCount=" + this.N + ", drafts=" + this.i.size());
        FrameLayout r4 = this.O;
        if (r4 == null) goto L27;
        r4.removeCallbacks(this.H1);
        FrameLayout r5 = this.O;
        if (r5 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("rootHost");
        r5 = null;
    L21:
        if (r5.getViewTreeObserver().isAlive() == false) goto L27;
        FrameLayout r6 = this.O;
        if (r6 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("rootHost");
    L26:
        r1.getViewTreeObserver().removeOnGlobalLayoutListener(this.x);
        goto L27
    L25:
        r1 = r6;
    L27:
        Iterator<T> r7 = b2().iterator();
    L29:
        if (r7.hasNext() == false) goto L31;
        ((e5) r7.next()).f(this.z);
        goto L29
    L31:
        this.y.shutdownNow();
        super.onDestroy();
    }

    public final void onPause() {
        if (this.M1 == false) goto L5;
        ((q0) this.t.getValue()).b();
    L5:
        super/*androidx.fragment.app.FragmentActivity*/.onPause();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onStop() {
        if (this.M1 == true) goto L5;
        super.onStop();
    L10:
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L16;
        y1(getWindow()).getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L13
        return;
    L17:
        return;
    L16:
        return;
    L5:
        this.L1 = true;
        FrameLayout r0 = this.O;
        if (r0 == null) goto L8;
        r0.removeCallbacks(this.H1);
    L8:
        super.onStop();
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v12, types: [com.obric.assistant.cocreationreview.x1] */
    public final void q2() {
        boolean r1 = Intrinsics.areEqual(this.W, Boolean.valueOf(this.F));
        if (this.X != this.G) goto L5;
        boolean r2 = true;
    L6:
        boolean r3 = Intrinsics.areEqual(this.Y, this.H);
        boolean r6 = Intrinsics.areEqual(this.Z, Boolean.valueOf(this.J));
        if (this.E == false) goto L9;
        u5 r7 = G1();
    L10:
        boolean r9 = Intrinsics.areEqual(this.V, Boolean.valueOf(this.K));
        if (Intrinsics.areEqual(this.T, Boolean.valueOf(this.E)) == true) goto L13;
    L18:
        boolean r10 = false;
    L19:
        z4.a r11 = this.L;
        if (r11 == null) goto L29;
        String r13 = z1(r11, this.M);
        a5 r12 = (a5) ((LinkedHashMap) L1()).get(r13);
        if (r12 != null) goto L31;
        r12 = r11.d;
        if (Intrinsics.areEqual(r12.a, r13) == true) goto L27;
        r12 = null;
    L27:
        if (r12 != null) goto L31;
        r12 = new a5(r13, null, null, null, false, 0, null, 254);
    L31:
        if (Intrinsics.areEqual(this.k0, r11) == false) goto L40;
        Integer r14 = this.p0;
        int r15 = this.M;
        if (r14 == null) goto L40;
        if (r14.intValue() != r15) goto L40;
        if (Intrinsics.areEqual(this.H0, r12) == false) goto L40;
        boolean r16 = true;
    L41:
        if (r1 == true) goto L43;
    L50:
        FrameLayout r4 = this.R;
        if (r4 != null) goto L53;
        Intrinsics.throwUninitializedPropertyAccessException("overlayHost");
        r4 = null;
    L53:
        r4.removeAllViews();
        if (r11 == null) goto L71;
        FrameLayout r17 = this.R;
        if (r17 != null) goto L58;
        Intrinsics.throwUninitializedPropertyAccessException("overlayHost");
        r17 = null;
    L58:
        r17.setVisibility(0);
        FrameLayout r18 = this.R;
        if (r18 != null) goto L61;
        Intrinsics.throwUninitializedPropertyAccessException("overlayHost");
        r18 = null;
    L61:
        final List r5 = N1(r11);
        int r19 = RangesKt.coerceIn(this.M, 0, CollectionsKt.getLastIndex(r5));
        if (r19 == this.M) goto L64;
        this.M = r19;
    L64:
        LinearLayout r110 = c4.k(this);
        r110.setBackgroundColor(-1);
        r110.setClickable(true);
        if (r5.size() <= 1) goto L67;
        int r8 = r5.size();
        final LinearLayout r20 = c4.e(this);
        r20.setGravity(17);
        r20.setMinimumHeight(c4.c(this, 22));
        I2(r20, r8, r19);
        final ViewPager2 r21 = new ViewPager2(this);
        r21.setOrientation(0);
        r21.setAdapter(new b(this, r11, r5));
        r21.setOffscreenPageLimit(1);
        r21.addOnAttachStateChangeListener(new i3(this, r20, r5, r21));
        r21.registerOnPageChangeCallback(new CocreationReviewActivity$renderDetailOverlay$pager$1$2(this, r5, r20));
        r21.setCurrentItem(r19, false);
        r110.addView(r21, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        c4.b(r110, r20, c4.c(this, 22), 0, c4.c(this, 10), 4);
        r21.post(new a2(this, r20, r5, r21));
    L68:
        r18.addView(r110, new FrameLayout.LayoutParams(-1, -1));
    L228:
        this.T = Boolean.valueOf(this.E);
        this.U = r7;
        if (this.E == false) goto L231;
        Boolean r22 = Boolean.valueOf(this.K);
    L232:
        this.V = r22;
        this.W = Boolean.valueOf(this.F);
        boolean r23 = this.F;
        if (r23 == false) goto L235;
        ModuleKey r24 = this.G;
    L236:
        this.X = r24;
        if (r23 == false) goto L239;
        String r25 = this.H;
    L240:
        this.Y = r25;
        if (r23 == false) goto L243;
        Boolean r26 = Boolean.valueOf(this.J);
    L244:
        this.Z = r26;
        z4.a r27 = r11;
        this.k0 = r27;
        if (r27 == null) goto L247;
        Integer r28 = Integer.valueOf(this.M);
    L248:
        this.p0 = r28;
        if (r27 == null) goto L251;
        a5 r29 = r12;
    L252:
        this.H0 = r29;
        CocreationReviewActivity$overlayBackCallback$1 r30 = this.w;
        if (this.L == null) goto L255;
    L260:
        boolean r31 = true;
    L261:
        r30.setEnabled(r31);
        return;
    L255:
        if (this.E == true) goto L260;
        if (this.F == true) goto L260;
        r31 = false;
        goto L261
    L251:
        r29 = null;
        goto L252
    L247:
        r28 = null;
        goto L248
    L243:
        r26 = null;
        goto L244
    L239:
        r25 = null;
        goto L240
    L235:
        r24 = null;
        goto L236
    L231:
        r22 = null;
        goto L232
    L67:
        r110.addView(p2(r11, (x4) ListProtector.get(r5, r19)), new LinearLayout.LayoutParams(-1, 0, 1.0f));
        goto L68
    L71:
        if (this.E == false) goto L133;
        FrameLayout r32 = this.R;
        if (r32 != null) goto L75;
        Intrinsics.throwUninitializedPropertyAccessException("overlayHost");
        r32 = null;
    L75:
        r32.setVisibility(0);
        FrameLayout r33 = this.R;
        if (r33 != null) goto L78;
        Intrinsics.throwUninitializedPropertyAccessException("overlayHost");
        r33 = null;
    L78:
        if (r7 != null) goto L80;
        u5 r34 = G1();
    L81:
        FrameLayout r35 = new FrameLayout(this);
        r35.setBackgroundColor(1711276032);
        r35.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        r35.setOnClickListener(new d2(this));
        LinearLayout r111 = c4.k(this);
        r111.setPadding(c4.c(this, 18), c4.c(this, 18), c4.c(this, 18), c4.c(this, 18));
        r111.setBackground(c4.h(this, -1, 22, -1973274, 1));
        r111.setElevation(c4.c(this, 8));
        r111.setOnClickListener(new y1());
        c4.b(r111, c4.f(this, "今日结算", 12.5f, -14979842, 1), 0, 0, c4.c(this, 12), 6);
        c4.b(r111, c4.f(this, "查看今日反馈汇总，选择是否完成今日反馈任务", 18.0f, -15656921, 1), 0, 0, c4.c(this, 8), 6);
        c4.b(r111, c4.f(this, "完成后今日反馈将锁定，不能继续新增或修改反馈。", 14.0f, -9735552, 0), 0, 0, c4.c(this, 18), 6);
        LinearLayout r210 = c4.k(this);
        List r36 = CollectionsKt.listOf(new Pair[]{TuplesKt.to("总反馈条数", Integer.valueOf(r34.a)), TuplesKt.to("已反馈", Integer.valueOf(r34.b)), TuplesKt.to("未处理", Integer.valueOf(r34.c)), TuplesKt.to("点赞", Integer.valueOf(r34.d)), TuplesKt.to("点踩", Integer.valueOf(r34.e))});
        Iterator r37 = CollectionsKt.chunked(r36, 2).iterator();
        int r38 = 0;
    L83:
        if (r37.hasNext() == false) goto L105;
        Object r39 = r37.next();
        int r112 = r38 + 1;
        if (r38 >= 0) goto L87;
        CollectionsKt.throwIndexOverflow();
    L87:
        List r40 = (List) r39;
        LinearLayout r113 = c4.e(this);
        r113.setGravity(48);
        Iterator r114 = r40.iterator();
        int r115 = 0;
    L89:
        if (r114.hasNext() == false) goto L97;
        Object r211 = r114.next();
        int r212 = r115 + 1;
        if (r115 >= 0) goto L93;
        CollectionsKt.throwIndexOverflow();
    L93:
        Pair r213 = (Pair) r211;
        String r41 = (String) r213.getFirst();
        int r214 = ((Number) r213.getSecond()).intValue();
        LinearLayout r116 = c4.k(this);
        r116.setGravity(16);
        Iterator r215 = r37;
        int r216 = r112;
        r116.setPadding(c4.c(this, 12), 0, c4.c(this, 12), 0);
        Iterator r217 = r114;
        r116.setBackground(c4.h(this, -460035, 12, -1512723, 1));
        c4.b(r116, c4.f(this, r41, 12.5f, -9735552, 1), 0, 0, 0, 14);
        c4.b(r116, c4.f(this, String.valueOf(r214), 22.0f, -15656921, 1), 0, c4.c(this, 6), 0, 10);
        LinearLayout.LayoutParams r42 = new LinearLayout.LayoutParams(0, c4.c(this, 72), 1.0f);
        if (r115 != 0) goto L96;
        r42.setMargins(0, 0, c4.c(this, 8), 0);
    L96:
        Unit r43 = Unit.INSTANCE;
        r113.addView(r116, r42);
        r115 = r212;
        r37 = r215;
        r112 = r216;
        r114 = r217;
        goto L89
    L97:
        Iterator r218 = r37;
        int r219 = r112;
        if (r40.size() != 1) goto L101;
        r113.addView(new View(this), new LinearLayout.LayoutParams(0, c4.c(this, 72), 1.0f));
    L101:
        if (r38 != (CollectionsKt.getLastIndex(r36) / 2)) goto L103;
        int r310 = 0;
    L104:
        c4.b(r210, r113, 0, 0, r310, 6);
        r37 = r218;
        r38 = r219;
        goto L83
    L103:
        r310 = c4.c(this, 8);
        goto L104
    L105:
        c4.b(r111, r210, 0, 0, c4.c(this, 22), 6);
        if (this.G1 <= 0) goto L108;
        boolean r44 = true;
    L109:
        boolean r45 = this.K;
        boolean r46 = !r45;
        if (r45 == true) goto L113;
        if (r44 == true) goto L113;
        boolean r47 = true;
    L114:
        LinearLayout r48 = c4.e(this);
        r48.setGravity(21);
        r48.addView(new View(this), new LinearLayout.LayoutParams(0, 1, 1.0f));
        TextView r49 = c4.j(this, "暂不", false, -1973274, new t2(this));
        r49.setTextColor(-15656921);
        r49.setBackground(c4.h(this, -1, 20, -1973274, 1));
        r49.setEnabled(r46);
        if (r46 == false) goto L117;
        float r50 = 1.0f;
    L118:
        r49.setAlpha(r50);
        LinearLayout.LayoutParams r51 = new LinearLayout.LayoutParams(c4.c(this, 72), c4.c(this, 42));
        r51.setMargins(0, 0, c4.c(this, 12), 0);
        Unit r52 = Unit.INSTANCE;
        r48.addView(r49, r51);
        if (r44 == false) goto L122;
        String r53 = "今日已完成";
    L125:
        if (r47 == false) goto L127;
        int r54 = -14979842;
    L128:
        TextView r55 = c4.j(this, r53, true, r54, new u2(this));
        r55.setEnabled(r47);
        if (r47 == false) goto L131;
        float r117 = 1.0f;
    L132:
        r55.setAlpha(r117);
        r48.addView(r55, new LinearLayout.LayoutParams(c4.c(this, 150), c4.c(this, 42)));
        c4.b(r111, r48, 0, 0, 0, 14);
        FrameLayout.LayoutParams r56 = new FrameLayout.LayoutParams(-1, -2, 17);
        r56.setMargins(c4.c(this, 24), 0, c4.c(this, 24), 0);
        r35.addView(r111, r56);
        r33.addView(r35, new FrameLayout.LayoutParams(-1, -1));
        goto L228
    L131:
        r117 = 0.65f;
        goto L132
    L127:
        r54 = -4667418;
        goto L128
    L122:
        if (this.K == false) goto L124;
        r53 = "提交中...";
        goto L125
    L124:
        r53 = "完成今日反馈";
        goto L125
    L117:
        r50 = 0.45f;
    L113:
        r47 = false;
        goto L114
    L108:
        r44 = false;
        goto L109
    L80:
        r34 = r7;
        goto L81
    L133:
        r12 = r12;
        if (this.F == false) goto L224;
        FrameLayout r57 = this.R;
        if (r57 != null) goto L138;
        Intrinsics.throwUninitializedPropertyAccessException("overlayHost");
        r57 = null;
    L138:
        r57.setVisibility(0);
        FrameLayout r58 = this.R;
        if (r58 != null) goto L141;
        Intrinsics.throwUninitializedPropertyAccessException("overlayHost");
        r58 = null;
    L141:
        I1();
        FrameLayout r59 = new FrameLayout(this);
        r59.setBackgroundColor(1711276032);
        r59.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        r59.setOnClickListener(new r1(this));
        ModuleKey r60 = this.G;
        if (r60 == null) goto L154;
        Iterator r61 = ((ArrayList) a2()).iterator();
    L145:
        if (r61.hasNext() == false) goto L152;
        Object r62 = r61.next();
        if (((l5) r62).a != r60) goto L149;
        boolean r63 = true;
    L150:
        if (r63 == false) goto L145;
    L153:
        l5 r64 = (l5) r62;
    L155:
        if (r64 == null) goto L157;
        e r65 = u2(r64);
    L158:
        LinearLayout r66 = c4.k(this);
        GradientDrawable r67 = new GradientDrawable();
        r67.setColor(-1);
        r67.setCornerRadii(new float[]{c4.c(this, 18), c4.c(this, 18), c4.c(this, 18), c4.c(this, 18), 0.0f, 0.0f, 0.0f, 0.0f});
        r66.setBackground(r67);
        r66.setLayoutParams(new ViewGroup.LayoutParams(-1, r2()));
        LinearLayout r68 = c4.e(this);
        r68.setGravity(16);
        r68.setPadding(c4.c(this, 18), c4.c(this, 16), c4.c(this, 18), c4.c(this, 14));
        r68.addView(new View(this), new LinearLayout.LayoutParams(c4.c(this, 36), c4.c(this, 36)));
        TextView r69 = c4.f(this, "我要反馈", 18.0f, -15656921, 1);
        r69.setGravity(17);
        r68.addView(r69, new LinearLayout.LayoutParams(0, -2, 1.0f));
        TextView r70 = c4.f(this, "×", 24.0f, -9735552, 1);
        r70.setGravity(17);
        GradientDrawable r71 = new GradientDrawable();
        r71.setShape(1);
        r71.setColor(-658192);
        r70.setBackground(r71);
        r70.setOnClickListener(new s1(this));
        r68.addView(r70, new LinearLayout.LayoutParams(c4.c(this, 36), c4.c(this, 36)));
        c4.b(r66, r68, 0, 0, 0, 14);
        c4.b(r66, U1(), c4.c(this, 1), 0, 0, 12);
        LinearLayout r72 = c4.k(this);
        r72.setPadding(c4.c(this, 18), c4.c(this, 14), c4.c(this, 18), 0);
        r72.setBackgroundColor(-1);
        c4.b(r72, c4.f(this, "选择功能模板", 13.5f, -15656921, 1), 0, 0, c4.c(this, 8), 6);
        LinearLayout r311 = c4.k(this);
        Iterator r73 = CollectionsKt.chunked(a2(), 2).iterator();
        int r118 = 0;
    L160:
        if (r73.hasNext() == false) goto L190;
        Object r119 = r73.next();
        int r120 = r118 + 1;
        if (r118 >= 0) goto L164;
        CollectionsKt.throwIndexOverflow();
    L164:
        List r121 = (List) r119;
        LinearLayout r122 = c4.e(this);
        Iterator r123 = r121.iterator();
        int r220 = 0;
    L166:
        if (r123.hasNext() == false) goto L182;
        Object r221 = r123.next();
        int r222 = r220 + 1;
        if (r220 >= 0) goto L170;
        CollectionsKt.throwIndexOverflow();
    L170:
        final l5 r74 = (l5) r221;
        Iterator r312 = r73;
        int r313 = r120;
        if (this.G != r74.a) goto L173;
        boolean r75 = true;
    L174:
        LinearLayout r124 = c4.e(this);
        Iterator r223 = r123;
        r124.setGravity(16);
        z4.a r314 = r11;
        u5 r315 = r7;
        r124.setPadding(c4.c(this, 10), 0, c4.c(this, 10), 0);
        r124.setClickable(true);
        r124.setFocusable(true);
        r124.setOnClickListener(new q2(this, r74));
        ImageView r76 = new ImageView(this);
        r76.setImageResource(r74.d);
        r76.setContentDescription(r74.b);
        r76.setScaleType(ImageView.ScaleType.FIT_CENTER);
        FrameLayout r410 = r58;
        FrameLayout r411 = r59;
        LinearLayout.LayoutParams r125 = new LinearLayout.LayoutParams(c4.c(this, 18), c4.c(this, 18));
        r125.setMargins(0, 0, c4.c(this, 8), 0);
        Unit r77 = Unit.INSTANCE;
        r124.addView(r76, r125);
        String r78 = r74.b;
        if (r75 == false) goto L177;
        int r79 = r74.e;
    L178:
        TextView r80 = c4.f(this, r78, 13.5f, r79, 1);
        r124.addView(r80);
        this.k1.put(r74.a, new d(r124, r80));
        B1(r74, r75);
        LinearLayout.LayoutParams r81 = new LinearLayout.LayoutParams(0, c4.c(this, 34), 1.0f);
        if (r220 != 0) goto L181;
        r81.setMargins(0, 0, c4.c(this, 8), 0);
    L181:
        r122.addView(r124, r81);
        r123 = r223;
        r220 = r222;
        r73 = r312;
        r120 = r313;
        r11 = r314;
        r7 = r315;
        r58 = r410;
        r59 = r411;
        goto L166
    L177:
        r79 = -9735552;
        goto L178
    L173:
        r75 = false;
        goto L174
    L182:
        FrameLayout r412 = r58;
        FrameLayout r413 = r59;
        u5 r316 = r7;
        Iterator r317 = r73;
        z4.a r318 = r11;
        int r319 = r120;
        if (r121.size() != 1) goto L186;
        r122.addView(new View(this), new LinearLayout.LayoutParams(0, c4.c(this, 34), 1.0f));
    L186:
        if (r118 != (CollectionsKt.getLastIndex(a2()) / 2)) goto L188;
        int r224 = 0;
    L189:
        c4.b(r311, r122, 0, 0, r224, 6);
        r73 = r317;
        r118 = r319;
        r11 = r318;
        r7 = r316;
        r58 = r412;
        r59 = r413;
        goto L160
    L188:
        r224 = c4.c(this, 8);
        goto L189
    L190:
        FrameLayout r414 = r58;
        FrameLayout r415 = r59;
        r7 = r7;
        r11 = r11;
        c4.b(r72, r311, 0, 0, c4.c(this, 16), 6);
        if (r65 == null) goto L194;
        String r82 = r65.a;
        if (r82 == null) goto L194;
    L195:
        TextView r83 = c4.f(this, r82, 14.0f, -9735552, 0);
        r83.setGravity(16);
        r83.setPadding(c4.c(this, 12), 0, c4.c(this, 12), 0);
        r83.setBackground(c4.h(this, -328708, 10, 0, 0));
        if (r64 == null) goto L198;
        r83.setTextColor(-9735552);
    L198:
        this.V0 = r83;
        r83.setMinimumHeight(c4.c(this, 44));
        c4.b(r72, r83, 0, 0, c4.c(this, 18), 6);
        c4.b(r72, c4.f(this, "选择反馈内容", 13.5f, -15656921, 1), 0, 0, c4.c(this, 8), 6);
        LinearLayout r84 = c4.k(this);
        this.b1 = r84;
        l2(r84, r64, r65);
        c4.b(r72, r84, 0, 0, c4.c(this, 18), 6);
        c4.b(r72, c4.f(this, "补充说明", 13.5f, -15656921, 1), 0, 0, c4.c(this, 8), 6);
        final EditText r85 = new EditText(this);
        this.g1 = r85;
        if (r65 == null) goto L203;
        String r86 = r65.c;
        if (r86 == null) goto L203;
    L204:
        r85.setHint(r86);
        r85.setTextSize(13.5f);
        r85.setTextColor(-15656921);
        r85.setHintTextColor(-5721662);
        r85.setText(this.I);
        if (this.I.length() <= 0) goto L207;
        boolean r126 = true;
    L208:
        if (r126 == false) goto L210;
        r85.setSelection(this.I.length());
    L210:
        r85.setMinLines(4);
        r85.setInputType(131073);
        r85.setGravity(8388659);
        r85.setPadding(c4.c(this, 12), c4.c(this, 11), c4.c(this, 12), c4.c(this, 11));
        r85.setBackground(c4.h(this, -394501, 10, -1973274, 1));
        c4.d(r85);
        r85.addTextChangedListener(new r5(new t1(this)));
        r85.setOnFocusChangeListener(new u1(this));
        c4.b(r72, r85, c4.c(this, 90), 0, c4.c(this, 14), 4);
        final ScrollView r87 = new ScrollView(this);
        this.P0 = r87;
        r87.setOnScrollChangeListener(new v1(this));
        r87.post(new w1(r87, this));
        r87.setFillViewport(false);
        r87.setOverScrollMode(2);
        r87.setBackgroundColor(-1);
        r87.addView(r72, new ViewGroup.LayoutParams(-1, -2));
        r66.addView(r87, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        LinearLayout r88 = c4.k(this);
        r88.setPadding(c4.c(this, 18), c4.c(this, 10), c4.c(this, 18), c4.c(this, 18));
        r88.setBackgroundColor(-1);
        if (this.H != null) goto L213;
    L215:
        boolean r89 = false;
    L216:
        final ?? r90 = new x1(this, r85);
        if (this.J == false) goto L219;
        String r91 = "提交中...";
    L220:
        if (r89 == false) goto L222;
        float r92 = 12.5f;
        int r127 = -1;
    L223:
        final TextView r93 = c4.f(this, r91, r92, r127, 1);
        this.h1 = r93;
        r93.setGravity(17);
        C1(r93, r89);
        r93.setOnClickListener(new s2(r93, r90));
        c4.b(r88, r93, c4.c(this, 46), 0, 0, 12);
        c4.b(r66, r88, 0, 0, 0, 14);
        r66.setOnClickListener(new y1());
        r415.addView(r66, new FrameLayout.LayoutParams(-1, r2(), 80));
        r414.addView(r415, new FrameLayout.LayoutParams(-1, -1));
        goto L228
    L222:
        r127 = -3616547;
        r92 = 12.5f;
        goto L223
    L219:
        r91 = "提交反馈";
        goto L220
    L213:
        if (this.J == true) goto L215;
        r89 = true;
        goto L216
    L207:
        r126 = false;
    L203:
        r86 = "请描述你遇到的具体问题或改进建议...";
    L194:
        r82 = "先选择一个功能模板";
        goto L195
    L157:
        r65 = null;
        goto L158
    L149:
        r63 = false;
        goto L150
    L152:
        r62 = null;
        goto L153
    L154:
        r64 = null;
        goto L155
    L224:
        r7 = r7;
        r11 = r11;
        FrameLayout r94 = this.R;
        if (r94 != null) goto L227;
        Intrinsics.throwUninitializedPropertyAccessException("overlayHost");
        r94 = null;
    L227:
        r94.setVisibility(8);
        goto L228
    L43:
        if (this.F == false) goto L47;
        if (r2 == false) goto L50;
        if (r3 == false) goto L50;
        if (r6 == false) goto L50;
    L47:
        if (r10 == false) goto L50;
        if (r16 == false) goto L50;
        return;
    L40:
        r16 = false;
        goto L41
    L29:
        r12 = null;
        goto L31
    L13:
        if (Intrinsics.areEqual(this.U, r7) == false) goto L18;
        if (this.E == false) goto L17;
        if (r9 == false) goto L18;
    L17:
        r10 = true;
        goto L19
    L9:
        r7 = null;
        goto L10
    L5:
        r2 = false;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int r2() {
        FrameLayout r0 = this.O;
        Integer r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("rootHost");
        r0 = null;
    L5:
        Integer r2 = Integer.valueOf(r0.getHeight());
        if (r2.intValue() <= 0) goto L8;
        boolean r3 = true;
    L9:
        if (r3 == false) goto L11;
        r1 = r2;
    L11:
        if (r1 == null) goto L13;
        int r4 = r1.intValue();
    L15:
        return RangesKt.coerceAtMost(RangesKt.coerceAtLeast(r4 - c4.c(this, 104), c4.c(this, 560)), r4);
    L13:
        Resources r5 = getResources();
        r4 = WindowDisplayMetricsOverride.apply(r5, r5.getDisplayMetrics()).heightPixels;
        goto L15
    L8:
        r3 = false;
        goto L9
    }

    public final View t2() {
        FrameLayout r0 = this.R;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("overlayHost");
        r0 = null;
    L5:
        View r1 = r0.getChildAt(0);
        if ((r1 instanceof ViewGroup) == false) goto L8;
        ViewGroup r2 = (ViewGroup) r1;
    L9:
        if (r2 != null) goto L12;
        return null;
    L12:
        if (r2.getChildCount() > 0) goto L14;
        return null;
    L14:
        return r2.getChildAt(r2.getChildCount() - 1);
    L8:
        r2 = null;
        goto L9
    }

    /* JADX WARN: Type inference failed for: r0v34, types: [com.obric.assistant.cocreationreview.CocreationReviewActivity$overlayBackCallback$1] */
    /* JADX WARN: Type inference failed for: r0v35, types: [com.obric.assistant.cocreationreview.t0] */
    /* JADX WARN: Type inference failed for: r0v44, types: [com.obric.assistant.cocreationreview.w0] */
    public CocreationReviewActivity() {
        this.a = LazyKt.lazy(new g3());
        this.b = LazyKt.lazy(new x0(this));
        this.c = LazyKt.lazy(new y0(this));
        this.d = LazyKt.lazy(new z0(this));
        this.e = LazyKt.lazy(new a1());
        this.f = LazyKt.lazy(new b1(this));
        this.g = LazyKt.lazy(new c1(this));
        this.h = new LinkedHashMap();
        this.i = new LinkedHashMap();
        this.j = new LinkedHashMap();
        this.k = new LinkedHashMap();
        this.l = new q();
        this.m = new LinkedHashSet();
        MainView r1 = MainView.REVIEW;
        this.n = CollectionsKt.listOf(new MainView[]{MainView.OVERVIEW, r1, MainView.TASK_CENTER});
        this.o = new q4();
        this.p = CoroutineScopeKt.MainScope();
        this.q = new CocreationTaskRunStore(0);
        this.s = LazyKt.lazy(new e1(this));
        this.t = LazyKt.lazy(new f1(this));
        this.u = LazyKt.lazy(new g1(this));
        this.v = LazyKt.lazy(new h3(this));
        this.w = new CocreationReviewActivity$overlayBackCallback$1(this);
        this.x = new t0(this);
        this.y = PThreadExecutorsUtils.newSingleThreadExecutor(new u0());
        this.z = new v0(this);
        this.A = r1;
        this.B = ReviewMode.QUEUE;
        this.I = NameKeys.UnloadStrategy_No_Strategy;
        this.k1 = new LinkedHashMap();
        this.p1 = new LinkedHashMap();
        this.x1 = Integer.MAX_VALUE;
        this.H1 = new w0(this);
    }

    public final u5 G1() {
        int r2 = ((ArrayList) c2()).size();
        List<com.obric.assistant.cocreationreview.a> r0 = c2();
        if (r0.isEmpty() == false) goto L5;
        int r1 = 0;
    L19:
        int r5 = RangesKt.coerceAtLeast(r2 - r1, 0);
        List<com.obric.assistant.cocreationreview.a> r3 = c2();
        if (r3.isEmpty() == false) goto L22;
        int r6 = 0;
    L40:
        List<com.obric.assistant.cocreationreview.a> r4 = c2();
        if (r4.isEmpty() == false) goto L43;
        int r7 = 0;
    L62:
        return new u5(r2, r1, r5, r6, r7);
    L43:
        Iterator<T> r8 = r4.iterator();
        r7 = 0;
    L45:
        if (r8.hasNext() == false) goto L62;
        com.obric.assistant.cocreationreview.a r9 = (com.obric.assistant.cocreationreview.a) r8.next();
        Map<String, a5> r10 = L1();
        LinkedHashMap r11 = (LinkedHashMap) r10;
        a5 r12 = (a5) r11.get(r9.a());
        if (r12 != null) goto L49;
    L51:
        boolean r13 = false;
    L52:
        if (r13 == true) goto L54;
    L56:
        boolean r14 = false;
    L57:
        if (r14 == false) goto L45;
        r7 = r7 + 1;
        if (r7 >= 0) goto L45;
        CollectionsKt.throwCountOverflow();
        goto L45
    L54:
        if (r12.b != Vote.DOWN) goto L56;
        r14 = true;
        goto L57
    L49:
        if (r12.e != true) goto L51;
        r13 = true;
        goto L52
    L22:
        Iterator<T> r15 = r3.iterator();
        r6 = 0;
    L24:
        if (r15.hasNext() == false) goto L40;
        com.obric.assistant.cocreationreview.a r16 = (com.obric.assistant.cocreationreview.a) r15.next();
        Map<String, a5> r17 = L1();
        LinkedHashMap r18 = (LinkedHashMap) r17;
        a5 r19 = (a5) r18.get(r16.a());
        if (r19 != null) goto L28;
    L30:
        boolean r20 = false;
    L31:
        if (r20 == true) goto L33;
    L35:
        boolean r21 = false;
    L36:
        if (r21 == false) goto L24;
        r6 = r6 + 1;
        if (r6 >= 0) goto L24;
        CollectionsKt.throwCountOverflow();
        goto L24
    L33:
        if (r19.b != Vote.UP) goto L35;
        r21 = true;
        goto L36
    L28:
        if (r19.e != true) goto L30;
        r20 = true;
        goto L31
    L5:
        Iterator<T> r22 = r0.iterator();
        int r23 = 0;
    L7:
        if (r22.hasNext() == false) goto L18;
        com.obric.assistant.cocreationreview.a r24 = (com.obric.assistant.cocreationreview.a) r22.next();
        Map<String, a5> r25 = L1();
        LinkedHashMap r26 = (LinkedHashMap) r25;
        a5 r27 = (a5) r26.get(r24.a());
        if (r27 != null) goto L11;
    L13:
        boolean r28 = false;
    L14:
        if (r28 == false) goto L7;
        r23 = r23 + 1;
        if (r23 >= 0) goto L7;
        CollectionsKt.throwCountOverflow();
        goto L7
    L11:
        if (r27.e != true) goto L13;
        r28 = true;
        goto L14
    L18:
        r1 = r23;
        goto L19
    }

    public final CocreationFeedbackPanelFragment M1() {
        CocreationFeedbackPanelFragment r0 = getSupportFragmentManager().findFragmentByTag("CocreationFeedbackPanelFragment");
        if ((r0 instanceof CocreationFeedbackPanelFragment) == true) goto L7;
        return null;
    L7:
        return r0;
    }

    public final List<com.obric.assistant.cocreationreview.a> Y1() {
        List<com.obric.assistant.cocreationreview.a> r0 = c2();
        ArrayList r1 = new ArrayList();
        Iterator r2 = ((ArrayList) r0).iterator();
    L3:
        boolean r3 = false;
        if (r2.hasNext() == false) goto L12;
        Object r4 = r2.next();
        com.obric.assistant.cocreationreview.a r5 = (com.obric.assistant.cocreationreview.a) r4;
        if (this.C != null) goto L8;
    L9:
        r3 = true;
    L10:
        if (r3 == false) goto L3;
        r1.add(r4);
        goto L3
    L8:
        if (r5.b() != this.C) goto L10;
    L12:
        ArrayList r6 = new ArrayList();
        Iterator r7 = r1.iterator();
    L14:
        if (r7.hasNext() == false) goto L33;
        Object r8 = r7.next();
        Map<String, a5> r9 = L1();
        LinkedHashMap r10 = (LinkedHashMap) r9;
        a5 r11 = (a5) r10.get(((com.obric.assistant.cocreationreview.a) r8).a());
        if (r11 != null) goto L18;
    L20:
        boolean r12 = false;
    L21:
        ReviewMode r13 = this.B;
        int r14 = g.c[r13.ordinal()];
        if (r14 != 1) goto L24;
        if (r12 == true) goto L30;
        r12 = true;
    L31:
        if (r12 == false) goto L14;
        r6.add(r8);
        goto L14
    L30:
        r12 = false;
        goto L31
    L24:
        if (r14 == 2) goto L31;
        throw new NoWhenBranchMatchedException();
    L18:
        if (r11.e != true) goto L20;
        r12 = true;
        goto L21
    L33:
        List<com.obric.assistant.cocreationreview.a> r15 = c2();
        ArrayList r16 = new ArrayList();
        Iterator r17 = ((ArrayList) r15).iterator();
    L35:
        if (r17.hasNext() == false) goto L42;
        com.obric.assistant.cocreationreview.a r18 = (com.obric.assistant.cocreationreview.a) r17.next();
        String r19 = O2(r18);
        if (r19 == null) goto L39;
        Pair r20 = TuplesKt.to(r19, r18);
    L40:
        if (r20 == null) goto L35;
        r16.add(r20);
        goto L35
    L39:
        r20 = null;
        goto L40
    L42:
        LinkedHashMap r21 = new LinkedHashMap();
        Iterator r22 = r16.iterator();
    L44:
        if (r22.hasNext() == false) goto L49;
        Pair r23 = (Pair) r22.next();
        String r24 = (String) r23.getFirst();
        Object r25 = r21.get(r24);
        if (r25 != null) goto L48;
        r25 = new ArrayList();
        r21.put(r24, r25);
    L48:
        ((List) r25).add((com.obric.assistant.cocreationreview.a) r23.getSecond());
        goto L44
    L49:
        HashSet r26 = new HashSet();
        ArrayList r27 = new ArrayList();
        Iterator r28 = r6.iterator();
    L51:
        if (r28.hasNext() == false) goto L58;
        Object r29 = r28.next();
        String r30 = O2((com.obric.assistant.cocreationreview.a) r29);
        if (r30 != null) goto L55;
        boolean r31 = true;
    L56:
        if (r31 == false) goto L51;
        r27.add(r29);
        goto L51
    L55:
        r31 = r26.add(r30);
        goto L56
    L58:
        ArrayList r32 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r27, 10));
        Iterator r33 = r27.iterator();
    L60:
        if (r33.hasNext() == false) goto L70;
        com.obric.assistant.cocreationreview.a r34 = (com.obric.assistant.cocreationreview.a) r33.next();
        String r35 = O2(r34);
        if (r35 == null) goto L69;
        List<? extends com.obric.assistant.cocreationreview.a> r36 = (List) r21.get(r35);
        if (r36 != null) goto L66;
        r36 = CollectionsKt.emptyList();
    L66:
        com.obric.assistant.cocreationreview.a r37 = r34.d(r36);
        if (r37 == null) goto L69;
        r34 = r37;
    L69:
        r32.add(r34);
        goto L60
    L70:
        int r38 = s3.a;
        StringBuilder r39 = new StringBuilder("recordsIn=");
        r39.append(((ArrayList) c2()).size());
        r39.append(", recordsOut=");
        r39.append(r6.size());
        r39.append(", visibleOut=");
        r39.append(r32.size());
        r39.append(", mode=");
        r39.append(this.B);
        r39.append(", selectedModule=");
        ModuleKey r40 = this.C;
        if (r40 == null) goto L74;
        String r41 = r40.getRaw();
        if (r41 == null) goto L74;
    L75:
        r39.append(r41);
        s3.a("ui.filter", r39.toString());
        return r32;
    L74:
        r41 = "all";
        goto L75
    }

    public final List<l5> a2() {
        List<e5> r0 = b2();
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        r1.add(((e5) r2.next()).b());
        goto L4
    L6:
        return r1;
    }

    /* JADX INFO: Removed unreachable split cross block B:53:0x0106 */
    /* JADX WARN: Multi-variable type inference failed */
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(CocreationReviewActivity.class.getName()));
        long r3 = SystemClock.uptimeMillis();
        Map r5 = ActivityLancet.LAST_FINISH_HANDLED_MS;
        monitor-enter(r5);
        Long r6 = (Long) r5.get(this);     // Catch: Throwable -> L45
        if (r6 != null) goto L10;
    L13:
        r5.put(this, Long.valueOf(r3));     // Catch: Throwable -> L45
        monitor-exit(r5);     // Catch: Throwable -> L45
    L42:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "handle onBackPressed strategy failed", th);
    L50:
        return;
    L16:
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L19;
        r2.i("ActivityLancet", "quit !resume, current state = " + getLifecycle().getCurrentState());     // Catch: Throwable -> L42
        goto L50
    L19:
        if (isFinishing() == true) goto L22;
        r2.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L42
        goto L50
    L22:
        if (ActivityStartBehavior.isInternalActivityConsumed(this) == true) goto L25;
        r2.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L42
        goto L50
    L25:
        if (ActivityLancet.isOnlyActivityInTask(this) == true) goto L28;
        r2.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L42
        goto L50
    L28:
        if (ActivityLancet.isExcludedActivity(this) == false) goto L31;
        r2.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L42
        goto L50
    L31:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L33;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L42
        goto L50
    L33:
        Intent r1 = getPackageManager().getLaunchIntentForPackage(getPackageName());     // Catch: Throwable -> L42
        if (r1 == null) goto L50;
        r1.addFlags(268435456);     // Catch: Throwable -> L42
        r1.addFlags(2097152);     // Catch: Throwable -> L42
        r2.i("ActivityLancet", "start launcher intent after backPressed, activity=" + this);     // Catch: Throwable -> L42
        startActivity(r1);     // Catch: Throwable -> L39
        overridePendingTransition(R.anim.fade_in, R.anim.slide_out_right);     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L42
        goto L50
    L10:
        if ((r3 - r6.longValue()) >= 800) goto L13;
        monitor-exit(r5);     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void h2() {
        View r0 = getCurrentFocus();
        FrameLayout r2 = null;
        if (r0 != null) goto L8;
        FrameLayout r1 = this.O;
        if (r1 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("rootHost");
        r1 = null;
    L7:
        r0 = r1.findFocus();
    L8:
        if (r0 == null) goto L11;
        IBinder r3 = r0.getWindowToken();
        if (r3 == null) goto L11;
    L15:
        if (r3 == null) goto L22;
        Object r4 = getSystemService("input_method");
        if ((r4 instanceof InputMethodManager) == false) goto L19;
        InputMethodManager r5 = (InputMethodManager) r4;
    L20:
        if (r5 == null) goto L22;
        r5.hideSoftInputFromWindow(r3, 0);
        goto L22
    L19:
        r5 = null;
    L22:
        if (r0 == null) goto L24;
        r0.clearFocus();
    L24:
        FrameLayout r6 = this.O;
        if (r6 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("rootHost");
        r6 = null;
    L27:
        r6.clearFocus();
        w2(true);
        FrameLayout r7 = this.O;
        if (r7 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("rootHost");
        r7 = null;
    L30:
        r7.postDelayed(new e3(this), 120);
        FrameLayout r8 = this.O;
        if (r8 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("rootHost");
    L34:
        r2.postDelayed(new f3(this), 320);
        return;
    L33:
        r2 = r8;
    L11:
        FrameLayout r9 = this.O;
        if (r9 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("rootHost");
        r9 = null;
    L14:
        r3 = r9.getWindowToken();
        goto L15
    }

    public final void onResume() {
        super/*androidx.fragment.app.FragmentActivity*/.onResume();
        if (this.M1 == true) goto L6;
        return;
    L6:
        if (D1("activity_resume", true) == false) goto L8;
        s3.b("activity.lifecycle", "resume applied settlement window refresh");
    L8:
        A2();
        if (this.L1 == false) goto L15;
        this.L1 = false;
        int r0 = s3.a;
        s3.b("activity.lifecycle", "resumeFromBackground providers=" + b2().size());
        Iterator<T> r1 = b2().iterator();
    L12:
        if (r1.hasNext() == false) goto L15;
        ((e5) r1.next()).a();
    L15:
        if (this.A != MainView.TASK_CENTER) goto L19;
        k2();
        return;
    }

    public static List N1(z4.a r3) {
        List<x4> r0 = r3.f;
        if ((!r0.isEmpty()) == true) goto L6;
        r0 = null;
    L6:
        if (r0 == null) goto L8;
        return r0;
    L8:
        return CollectionsKt.listOf(new x4(r3.a, r3.c, r3.e));
    }

    public static String O2(com.obric.assistant.cocreationreview.a r3) {
        String r0 = r3.c();
        if (r0 != null) goto L5;
        return null;
    L5:
        if ((!StringsKt.isBlank(r0)) == true) goto L8;
        r0 = null;
    L8:
        if (r0 != null) goto L10;
        return null;
    L10:
        return r3.b().getRaw() + ':' + r0;
    }

    public static String Z1(long r3) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA).format(new Date(r3));
    }

    public static e u2(l5 r8) {
        ModuleKey r9 = r8.a;
        switch(g.f[r9.ordinal()]) {
            case 1: goto L14;
            case 2: goto L21;
            case 3: goto L20;
            case 4: goto L19;
            case 5: goto L18;
            case 6: goto L17;
            case 7: goto L16;
            case 8: goto L15;
            default: goto L5;
        };
    L5:
        throw new NoWhenBranchMatchedException();
    L15:
        return new e("操作手机：GUI 操作与工具调用落地任务", CollectionsKt.listOf(new String[]{"当天整体反馈", "耗时太长", "没做完", "错误拦截", "频繁询问", "交互相关", "其他"}), "请描述今天操作手机整体哪里不对，例如耗时太长、没做完、错误拦截、频繁询问或交互相关问题...");
    L16:
        return new e("全搜问答：基于本地资料检索并回答用户问题", CollectionsKt.listOf(new String[]{"当天整体反馈", "完全没搜到目标内容", "没搜全多个目标内容", "搜到内容但回复错误", "没搜索本地数据", "其他"}), "请描述今天全搜问答整体哪里不对，例如目标内容没搜到、多个目标没搜全、回复错误或没有搜索本地数据...");
    L17:
        return new e("个人信息记忆：记录用户偏好、兴趣、社交关系和个人资料变化", CollectionsKt.listOf(new String[]{"当天整体反馈", "内容漏记", "内容冗余", "内容记错", "分类错误", "格式乱", "内容安全问题", "其他"}), "请描述今天个人信息记忆整体哪里不对，例如偏好画像不准、人物关系记错、分类错误、格式乱或隐私边界问题...");
    L18:
        return new e("收藏记忆：记录用户主动收藏、保存、转发到收藏夹的内容", CollectionsKt.listOf(new String[]{"当天整体反馈", "内容漏记", "内容冗余", "内容记错", "记忆来源错误", "内容安全问题", "其他"}), "请描述今天收藏记忆整体哪里不对，例如收藏内容漏记、内容冗余、内容记错、记忆来源错误或内容安全问题...");
    L19:
        return new e("记忆任务：按用户规则提取屏幕，形成记忆合集", CollectionsKt.listOf(new String[]{"当天整体反馈", "漏记/漏信息", "误记/信息不准", "记了不该记的", "分类/合集不对", "隐私边界问题", "其他"}), "请描述今天记忆任务整体哪里不对，例如漏掉了什么、哪些内容记错、哪些不该记、分类/合集哪里不合理...");
    L20:
        return new e("环境人声：基于环境声音、语音和录音转写形成记忆", CollectionsKt.listOf(new String[]{"当天整体反馈", "内容记错", "内容漏记", "内容冗余", "记了无意义内容", "其他"}), "请描述今天环境人声整体哪里不对，例如内容记错、内容漏记、内容冗余、记了无意义内容或转写相关问题...");
    L21:
        return new e("屏幕内容：基于手机屏幕内容自动形成单条记忆", CollectionsKt.listOf(new String[]{"当天整体反馈", "内容记错", "内容冗余", "记了无意义内容", "屏蔽内容仍记录", "其他"}), "请描述今天屏幕内容整体哪里不对，例如记错内容、内容冗余、记了无意义内容或屏蔽内容仍记录...");
    L14:
        return new e("主动智能：在关键时刻提醒并给下一步建议", CollectionsKt.listOf(new String[]{"没有出现预期中的建议", "建议出现的概率不合预期", "经常出现价值不大的建议", "其他"}), "请描述没有出现、出现概率异常或价值不大的具体建议场景...");
    }

    public static View y1(Window r3) {
        View r4 = r3.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    public final void F2(d5 r9) {
        if (getSupportFragmentManager().isStateSaved() == false) goto L6;
        int r0 = s3.a;
        s3.c("feedback.panel", "show blocked recordId=" + r9.a + ", reason=fragment_state_saved");
        return;
    L6:
        CocreationFeedbackPanelFragment r1 = M1();
        if (r1 != null) goto L31;
    L14:
        getSupportFragmentManager().executePendingTransactions();
        Set<String> r2 = CocreationFeedbackPanelFragment.v;
        Intrinsics.checkNotNullParameter(r9, "template");
        CocreationFeedbackPanelFragment r3 = new CocreationFeedbackPanelFragment();
        Bundle r4 = new Bundle();
        r4.putString("record_id", r9.a);
        r4.putString("title", r9.b);
        r4.putString("reasons_title", r9.c);
        r4.putStringArrayList("reasons", new ArrayList(r9.d));
        Vote r5 = r9.e.b;
        if (r5 == null) goto L17;
        String r6 = r5.getRaw();
    L18:
        r4.putString("feedback_vote", r6);
        r4.putStringArrayList("feedback_reasons", new ArrayList(r9.e.c));
        r4.putString("feedback_comment", r9.e.d);
        r4.putBoolean("feedback_completed", r9.e.e);
        r4.putLong("feedback_created_at", r9.e.f);
        r4.putString("placeholder", r9.f);
        r4.putString("empty_reasons_text", r9.g);
        r4.putString("submit_text", r9.h);
        r4.putString("submitting_text", r9.i);
        r4.putString("incomplete_text", r9.j);
        r4.putInt("max_comment_length", r9.k);
        r4.putBoolean("submitting", r9.l);
        r4.putBoolean("media_enabled", r9.m);
        List<b5> r10 = r9.n;
        ArrayList r7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10));
        Iterator<T> r11 = r10.iterator();
    L20:
        if (r11.hasNext() == false) goto L22;
        b5 r8 = (b5) r11.next();
        Bundle r12 = new Bundle();
        r12.putString("media_id", r8.a);
        r12.putString("media_uri", r8.b);
        r12.putString("media_type", r8.getType().name());
        r12.putString("media_display_name", r8.d);
        r12.putLong("media_duration", r8.e);
        r12.putBoolean("media_is_marked", r8.f);
        r12.putBoolean("media_is_cropped", r8.g);
        r12.putString("media_upload_state", r8.h.name());
        r12.putInt("media_upload_progress", r8.i);
        r12.putString("media_upload_identifier", r8.j);
        r12.putString("media_remote_uri", r8.k);
        r12.putString("media_upload_error", r8.l);
        r7.add(r12);
        goto L20
    L22:
        r4.putParcelableArrayList("media_items", new ArrayList(r7));
        r3.setArguments(r4);
        FragmentManager r13 = getSupportFragmentManager();
        LandscapeRestrictionOperation r14 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r3, "CocreationFeedbackPanelFragment", r14);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r13, r3, r14) == true) goto L34;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L28
    L26:
        r3.show(r13, "CocreationFeedbackPanelFragment");
        return;
    L34:
        return;
    L17:
        r6 = null;
        goto L18
    L31:
        r1.dismissAllowingStateLoss();     // Catch: Exception -> L10
    L10:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r15 = DialogFragmentLancet.sLastShowStack;
        if (r15 == null) goto L14;
        com.bytedance.crash.d.d(r15, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L14
    }

    public final void H1(String r5) {
        int r0 = this.h.size();
        int r1 = this.i.size();
        this.h.clear();
        this.i.clear();
        CocreationFeedbackPanelFragment r2 = M1();
        if (r2 == null) goto L5;
        r2.h = true;
        CocreationFeedbackPanelFragment.T90(r2);
    L5:
        this.D = null;
        this.B = ReviewMode.QUEUE;
        int r3 = s3.a;
        s3.b("settlement.state", "clearWindowState reason=" + r5 + ", clearedSnapshots=" + r0 + ", clearedDrafts=" + r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void K1(String r24) {
        a5 r1 = this.i.get(r24);
        if (r1 != null) goto L7;
        r1 = (a5) ((LinkedHashMap) L1()).get(r24);
        if (r1 != null) goto L7;
        r1 = new a5(r24, null, null, null, false, 0, null, 254);
    L7:
        Set<String> r2 = r1.c;
        ArrayList r3 = new ArrayList();
        Iterator<T> r4 = r2.iterator();
    L9:
        if (r4.hasNext() == false) goto L13;
        Object r5 = r4.next();
        if (P1.contains((String) r5) == true) goto L9;
        r3.add(r5);
        goto L9
    L13:
        Set r6 = (Set) CollectionsKt.toCollection(r3, new LinkedHashSet());
        if (r1.b != null) goto L16;
    L107:
        int r7 = s3.a;
        s3.c("submit.annotation", "blocked recordId=" + r24 + ", reason=incomplete, vote=" + r1.b + ", reasonCount=" + r6.size() + ", rawReasonCount=" + r1.c.size());
        Toast.makeText(this, "请选择评价和原因后再完成反馈", 0).show();
        v2(r24);
        return;
    L16:
        if (r6.isEmpty() == true) goto L107;
        if (r6.size() == r1.c.size()) goto L21;
        int r8 = s3.a;
        s3.c("submit.annotation", "sanitize vote labels from reasons recordId=" + r24 + ", rawReasons=" + r1.c + ", submitReasons=" + r6);
    L21:
        Iterator r9 = ((ArrayList) c2()).iterator();
    L23:
        if (r9.hasNext() == false) goto L27;
        Object r10 = r9.next();
        if (Intrinsics.areEqual(((com.obric.assistant.cocreationreview.a) r10).a(), r24) == false) goto L23;
    L28:
        com.obric.assistant.cocreationreview.a r11 = (com.obric.assistant.cocreationreview.a) r10;
        if (r11 != null) goto L33;
        int r12 = s3.a;
        s3.c("submit.annotation", "blocked recordId=" + r24 + ", reason=record_not_found");
        Toast.makeText(this, "反馈数据不存在", 0).show();
        v2(r24);
        return;
    L33:
        if (this.m.contains(r24) == false) goto L36;
        Toast.makeText(this, "正在提交，请稍候", 0).show();
        v2(r24);
        return;
    L36:
        e5 r13 = (e5) ((Map) this.d.getValue()).get(r11.b());
        l0 r14 = (l0) ((Map) this.b.getValue()).get(r11.b());
        Vote r15 = r1.b;
        if (r13 == null) goto L105;
        if (r14 == null) goto L105;
        String r19 = r14.d(r11);
        int r16 = s3.a;
        s3.b("submit.annotation", "prepare recordId=" + r11.a() + ", module=" + r11.b().getRaw() + ", vote=" + r1.b.getRaw() + ", reasonCount=" + r6.size() + ", commentLength=" + r1.d.length() + ", payloadHash=" + r19.hashCode());
        StringBuilder r17 = new StringBuilder();
        r17.append(r11.a());
        r17.append('-');
        r17.append(System.currentTimeMillis());
        s5 r18 = new s5(r17.toString(), r11.a(), r11.b(), r15, r6, r1.d, r19, CollectionsKt.emptyList(), CollectionsKt.emptyList(), r1.h);
        this.m.add(r24);
        CocreationFeedbackPanelFragment r20 = M1();
        if (r20 == null) goto L43;
        r20.ca0(true);
    L43:
        List<b5> r21 = this.j.get(r24);
        if (r21 != null) goto L47;
        r21 = CollectionsKt.emptyList();
    L47:
        if (r21.isEmpty() == false) goto L49;
        String r22 = "正在提交反馈";
    L50:
        Toast.makeText(this, r22, 0).show();
        o2(false);
        Intrinsics.checkNotNullParameter(r21, "<this>");
        List<b5> r23 = r21;
        boolean r25 = r23 instanceof Collection;
        if (r25 == true) goto L53;
    L55:
        Iterator<T> r26 = r23.iterator();
    L57:
        if (r26.hasNext() == false) goto L64;
        if (((b5) r26.next()).h != FeedbackMediaUploadState.UPLOADING) goto L61;
        boolean r27 = true;
    L62:
        if (r27 == false) goto L57;
        boolean r28 = true;
    L65:
        if (r28 == false) goto L67;
        FeedbackMediaSubmissionDecision r29 = FeedbackMediaSubmissionDecision.WAIT;
    L93:
        int r30 = g.e[r29.ordinal()];
        if (r30 != 1) goto L96;
        N2(r11, r13, r18);
        return;
    L96:
        if (r30 != 2) goto L98;
        G2(r11, r13, r18);
        return;
    L98:
        if (r30 != 3) goto L101;
        this.m.remove(r24);
        v2(r24);
        Toast.makeText(this, "媒体正在上传，请稍候", 0).show();
        o2(false);
        return;
    L101:
        throw new NoWhenBranchMatchedException();
    L67:
        if (r25 == true) goto L69;
    L71:
        Iterator<T> r31 = r23.iterator();
    L73:
        if (r31.hasNext() == false) goto L89;
        b5 r32 = (b5) r31.next();
        if (r32.h != FeedbackMediaUploadState.UPLOADED) goto L86;
        String r33 = r32.k;
        if (r33 != null) goto L79;
    L82:
        boolean r34 = true;
    L83:
        if (r34 == true) goto L86;
        boolean r35 = false;
    L87:
        if (r35 == false) goto L73;
        boolean r36 = true;
    L90:
        if (r36 == false) goto L92;
        r29 = FeedbackMediaSubmissionDecision.UPLOAD;
        goto L93
    L92:
        r29 = FeedbackMediaSubmissionDecision.SUBMIT_FEEDBACK;
        goto L93
    L79:
        if (StringsKt.isBlank(r33) == true) goto L82;
        r34 = false;
    L86:
        r35 = true;
    L89:
        r36 = false;
        goto L90
    L69:
        if (r23.isEmpty() == false) goto L71;
    L61:
        r27 = false;
    L64:
        r28 = false;
        goto L65
    L53:
        if (r23.isEmpty() == false) goto L55;
    L49:
        r22 = "正在上传图片和反馈";
    L105:
        int r37 = s3.a;
        s3.c("submit.annotation", "blocked recordId=" + r24 + ", module=" + r11.b().getRaw() + ", reason=provider_unavailable");
        Toast.makeText(this, "业务方不可用", 0).show();
        v2(r24);
        return;
    L27:
        r10 = null;
        goto L28
    }

    public final void M2(String r7) {
        g5 r0 = new g5(this.y1, r7);
        h5 r1 = g5.a(r0);
        int r2 = s3.a;
        s3.b("activity.observe", "updateProviderObserveRequest reason=" + r7 + ", earliest=" + Z1(r1.a) + ", latest=" + Z1(r1.b) + ", providers=" + b2().size());
        Iterator<T> r3 = b2().iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        e5 r4 = (e5) r3.next();
        int r5 = s3.a;
        s3.a("activity.observe", "updateRequest module=" + r4.getBusinessId().getRaw() + ", reason=" + r7);
        r4.d(r0);
        goto L4
    }

    @Override // com.obric.assistant.cocreationreview.CocreationFeedbackPanelFragment.a
    public final void S0(String r2) {
        Intrinsics.checkNotNullParameter(r2, "recordId");
        K1(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void S1(String r5) {
        if (this.J == false) goto L6;
        int r0 = s3.a;
        s3.b("report.action", "dismissBlocked source=" + r5 + ", reason=submitting");
        Toast.makeText(this, "正在提交，请稍候", 0).show();
        return;
    L6:
        int r1 = s3.a;
        s3.b("report.action", "dismissReportDialog source=".concat(r5));
        h2();
        this.F = false;
        this.G = null;
        this.H = null;
        this.I = NameKeys.UnloadStrategy_No_Strategy;
        I1();
        this.L0 = 0;
        o2(false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void T1(String r5) {
        if (this.K == false) goto L6;
        int r0 = s3.a;
        s3.b("settlement.action", "dismissBlocked source=" + r5 + ", reason=submitting");
        Toast.makeText(this, "正在完成今日反馈，请稍候", 0).show();
        return;
    L6:
        int r1 = s3.a;
        s3.b("settlement.action", "dismissConfirm source=".concat(r5));
        this.E = false;
        o2(false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void W1(View r7) {
        FrameLayout r0 = this.O;
        RecyclerView r2 = null;
        if (r0 == null) goto L10;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("rootHost");
        r0 = null;
    L6:
        WindowInsets r1 = r0.getRootWindowInsets();
        if (r1 == null) goto L10;
        n2(r1);
    L10:
        if (this.O != null) goto L12;
        return;
    L12:
        if (r7.isShown() == false) goto L68;
        Rect r3 = new Rect();
        if (r7.getGlobalVisibleRect(r3) == true) goto L18;
        return;
    L18:
        if (this.v1 == false) goto L21;
        Integer r4 = Integer.valueOf(this.x1);
    L29:
        if (r4 == null) goto L65;
        int r5 = r3.bottom - (r4.intValue() - c4.c(this, 16));
        if (r5 > 0) goto L34;
        return;
    L34:
        if (this.F == false) goto L50;
        FrameLayout r6 = this.R;
        if (r6 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("overlayHost");
        r6 = null;
    L38:
        if (r7 == null) goto L45;
        if (r7 == r6) goto L40;
        Object r8 = r7.getParent();
        if ((r8 instanceof View) == true) goto L43;
        r7 = null;
        goto L38
    L43:
        r7 = (View) r8;
        goto L38
    L40:
        boolean r9 = true;
    L46:
        if (r9 == false) goto L50;
        View r10 = t2();
        if (r10 == null) goto L66;
        r10.animate().cancel();
        r10.animate().translationY(r10.getTranslationY() - r5).setDuration(120).start();
        return;
    L66:
        return;
    L45:
        r9 = false;
    L50:
        RecyclerView r11 = this.P;
        if (r11 != null) goto L53;
        Intrinsics.throwUninitializedPropertyAccessException("contentList");
    L54:
        r2.smoothScrollBy(0, r5 + c4.c(this, 16));
        return;
    L53:
        r2 = r11;
        goto L54
    L65:
        return;
    L21:
        if ((r7 instanceof EditText) == true) goto L23;
    L28:
        r4 = null;
        goto L29
    L23:
        if (r7.hasFocus() == false) goto L28;
        FrameLayout r12 = this.O;
        if (r12 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("rootHost");
        r12 = null;
    L27:
        r4 = Integer.valueOf((int) (r12.getHeight() * 0.58f));
        goto L29
    }

    public final void d2(i5 r4) {
        int r0 = this.i.size();
        this.h.put(r4.a.a, r4);
        this.i.keySet().removeAll(r4.d.keySet());
        Iterator<T> r1 = r4.d.keySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        m2((String) r1.next());
        goto L4
    L6:
        this.j.keySet().removeAll(r4.d.keySet());
        this.m.removeAll(r4.d.keySet());
        String r2 = this.D;
        if (r2 != null) goto L9;
    L14:
        int r3 = r0 - this.i.size();
        int r5 = s3.a;
        s3.b("activity.snapshot", "received module=" + r4.a.a.getRaw() + ", pending=" + r4.b.size() + ", completed=" + r4.c.size() + ", feedback=" + r4.d.size() + ", storedSnapshots=" + this.h.size() + ", cleanedDrafts=" + r3);
        o2(false);
        return;
    L9:
        if (r4.d.containsKey(r2) == false) goto L14;
        int r6 = s3.a;
        s3.b("feedback.panel", "dismiss reason=provider_feedback_arrived, recordId=".concat(r2));
        CocreationFeedbackPanelFragment r7 = M1();
        if (r7 == null) goto L13;
        r7.h = true;
        CocreationFeedbackPanelFragment.T90(r7);
    L13:
        this.D = null;
        goto L14
    }

    public final void e2(WindowInsets r6) {
        int r0 = r6.getInsets(WindowInsets.Type.statusBars()).top;
        FrameLayout r1 = this.R;
        FrameLayout r3 = null;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("overlayHost");
        r1 = null;
    L5:
        ViewGroup.LayoutParams r2 = r1.getLayoutParams();
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams r4 = (FrameLayout.LayoutParams) r2;
        if (r4.topMargin == r0) goto L12;
        r4.topMargin = r0;
        FrameLayout r5 = this.R;
        if (r5 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("overlayHost");
        r5 = null;
    L10:
        r5.setLayoutParams(r4);
    L12:
        if (n2(r6) == true) goto L15;
        return;
    L15:
        if (this.v1 == false) goto L23;
        FrameLayout r7 = this.O;
        if (r7 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("rootHost");
    L20:
        View r8 = r3.findFocus();
        if (r8 == null) goto L25;
        W1(r8);
        return;
    L25:
        return;
    L19:
        r3 = r7;
        goto L20
    L23:
        w2(true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final ImageView g2(final q5.b r9) {
        int r2 = 0;
        if (r9.b == MainView.OVERVIEW) goto L5;
    L7:
        final boolean r0 = false;
    L8:
        ImageView r1 = new ImageView(this);
        MainView r4 = r9.b;
        int[] r5 = g.a;
        int r6 = r5[r4.ordinal()];
        if (r6 == 1) goto L16;
        if (r6 == 2) goto L15;
        if (r6 != 3) goto L14;
    L17:
        r1.setImageResource(r2);
        if (r0 == false) goto L20;
        String r3 = "今日已结算";
    L29:
        r1.setContentDescription(r3);
        r1.setScaleType(ImageView.ScaleType.FIT_CENTER);
        r1.setClickable(true);
        r1.setFocusable(true);
        if (r0 == false) goto L32;
        int r7 = 90;
    L33:
        r1.setImageAlpha(r7);
        r1.clearColorFilter();
        r1.setOnClickListener(new i1(r0, this, r9));
        return r1;
    L32:
        r7 = 255;
        goto L33
    L20:
        int r8 = r5[r9.b.ordinal()];
        if (r8 == 1) goto L28;
        if (r8 == 2) goto L27;
        if (r8 != 3) goto L26;
        r3 = NameKeys.UnloadStrategy_No_Strategy;
        goto L29
    L26:
        throw new NoWhenBranchMatchedException();
    L27:
        r3 = "我要反馈";
        goto L29
    L28:
        r3 = "我要结算";
        goto L29
    L14:
        throw new NoWhenBranchMatchedException();
    L15:
        r2 = 2131235863;
        goto L17
    L16:
        r2 = 2131235878;
        goto L17
    L5:
        if (r9.d == false) goto L7;
        r0 = true;
        goto L8
    }

    public final boolean i2(String r3) {
        a5 r4 = (a5) ((LinkedHashMap) L1()).get(r3);
        if (r4 != null) goto L5;
        return false;
    L5:
        if (r4.e != true) goto L9;
        return true;
    L9:
        return false;
    }

    public final void m2(String r7) {
        List<b5> r0 = this.j.get(r7);
        if (r0 != null) goto L5;
        r0 = CollectionsKt.emptyList();
    L5:
        boolean r2 = true;
        if ((!r0.isEmpty()) == false) goto L23;
        List<b5> r1 = r0;
        if ((r1 instanceof Collection) == true) goto L10;
    L12:
        Iterator<T> r3 = r1.iterator();
    L14:
        if (r3.hasNext() == false) goto L21;
        if (((b5) r3.next()).h != FeedbackMediaUploadState.UPLOADED) goto L18;
        boolean r4 = true;
    L19:
        if (r4 == true) goto L14;
        r2 = false;
        goto L21
    L18:
        r4 = false;
    L21:
        if (r2 == false) goto L23;
        this.k.put(r7, CollectionsKt.toList(r1));
        goto L23
    L10:
        if (r1.isEmpty() == false) goto L12;
    L23:
        this.j.remove(r7);
    }

    public final boolean n2(WindowInsets r5) {
        FrameLayout r0 = this.O;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L29:
        return false;
    L5:
        if (r0.getHeight() == 0) goto L29;
        Insets r2 = r5.getInsets(WindowInsets.Type.ime());
        if (r5.isVisible(WindowInsets.Type.ime()) == false) goto L10;
    L11:
        r1 = true;
    L12:
        this.v1 = r1;
        if (r1 == false) goto L26;
        FrameLayout r3 = null;
        if (r2.bottom <= 0) goto L21;
        FrameLayout r6 = this.O;
        if (r6 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("rootHost");
    L20:
        int r7 = r3.getHeight() - r2.bottom;
    L27:
        this.x1 = r7;
        return true;
    L19:
        r3 = r6;
        goto L20
    L21:
        FrameLayout r8 = this.O;
        if (r8 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("rootHost");
    L25:
        r7 = (int) (r3.getHeight() * 0.58f);
        goto L27
    L24:
        r3 = r8;
        goto L25
    L26:
        r7 = Integer.MAX_VALUE;
        goto L27
    L10:
        if (r5.getInsets(WindowInsets.Type.ime()).bottom <= 0) goto L12;
        goto L11
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void o2(final boolean r37) {
        this.N++;
        if (this.n.contains(this.A) == true) goto L5;
        int r1 = s3.a;
        StringBuilder r2 = new StringBuilder("unsupported mainView=");
        r2.append(this.A);
        r2.append(", fallback=");
        MainView r4 = MainView.REVIEW;
        r2.append(r4);
        s3.c("ui.render", r2.toString());
        this.A = r4;
    L5:
        Map<String, a5> r3 = L1();
        int r5 = s3.a;
        StringBuilder r6 = new StringBuilder("start seq=");
        r6.append(this.N);
        r6.append(", mainView=");
        r6.append(this.A);
        r6.append(", reviewMode=");
        r6.append(this.B);
        r6.append(", selectedModule=");
        ModuleKey r7 = this.C;
        String r8 = "all";
        if (r7 == null) goto L9;
        String r9 = r7.getRaw();
        if (r9 == null) goto L9;
    L10:
        r6.append(r9);
        r6.append(", snapshots=");
        r6.append(this.h.size());
        r6.append(", records=");
        r6.append(((ArrayList) c2()).size());
        r6.append(", completedFeedback=");
        Collection r10 = ((LinkedHashMap) r3).values();
        if ((r10 instanceof Collection) == true) goto L13;
    L15:
        Iterator r11 = r10.iterator();
        int r12 = 0;
    L17:
        if (r11.hasNext() == false) goto L23;
        if (((a5) r11.next()).e == false) goto L17;
        r12 = r12 + 1;
        if (r12 >= 0) goto L17;
        CollectionsKt.throwCountOverflow();
    L23:
        r6.append(r12);
        r6.append(", drafts=");
        r6.append(this.i.size());
        r6.append(", feedbackPanel=");
        String r13 = this.D;
        String r14 = VoiceDisplayScene.NONE;
        if (r13 != null) goto L26;
        r13 = VoiceDisplayScene.NONE;
    L26:
        r6.append(r13);
        r6.append(", reportSheet=");
        r6.append(this.F);
        r6.append(", reportModule=");
        ModuleKey r15 = this.G;
        if (r15 == null) goto L30;
        String r16 = r15.getRaw();
        if (r16 == null) goto L30;
    L31:
        r6.append(r16);
        r6.append(", detail=");
        z4.a r17 = this.L;
        if (r17 == null) goto L37;
        String r18 = r17.a;
        if (r18 == null) goto L37;
        r14 = r18;
    L37:
        r6.append(r14);
        s3.a("ui.render", r6.toString());
        CocreationReviewPageAdapter r19 = (CocreationReviewPageAdapter) this.v.getValue();
        ArrayList r20 = new ArrayList();
        MainView r21 = this.A;
        String r22 = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA).format(new Date());
        long r23 = this.G1;
        if (r23 <= 0) goto L40;
        boolean r110 = true;
    L41:
        Long r24 = Long.valueOf(r23);
        if (r24.longValue() <= 0) goto L44;
        boolean r111 = true;
    L46:
        if (r111 == true) goto L49;
        r24 = null;
    L49:
        if (r24 == null) goto L51;
        String r25 = new SimpleDateFormat("HH:mm", Locale.CHINA).format(new Date(r24.longValue()));
    L52:
        r20.add(new q5.b(r21, r22, r110, r25));
        int r26 = g.a[this.A.ordinal()];
        if (r26 == 1) goto L210;
        if (r26 == 2) goto L119;
        if (r26 != 3) goto L118;
        int r27 = this.o.a.size();
        q4 r28 = this.o;
        CocreationTaskFilter r112 = CocreationTaskFilter.RUN;
        r28.getClass();
        Intrinsics.checkNotNullParameter(r112, "filter");
        int r113 = q4.a.a[r112.ordinal()];
        if (r113 == 1) goto L88;
        if (r113 == 2) goto L75;
        if (r113 != 3) goto L74;
        List<e4> r114 = r28.a;
        if ((r114 instanceof Collection) == true) goto L63;
    L65:
        Iterator<T> r115 = r114.iterator();
        int r116 = 0;
    L67:
        if (r115.hasNext() == false) goto L89;
        if (r28.e.contains(((e4) r115.next()).a) == false) goto L67;
        r116 = r116 + 1;
        if (r116 >= 0) goto L67;
        CollectionsKt.throwCountOverflow();
    L89:
        r20.add(new q5.h(r27, r116, this.o.h));
        q4 r29 = this.o;
        List<e4> r30 = r29.a;
        ArrayList r31 = new ArrayList();
        Iterator<T> r32 = r30.iterator();
    L91:
        if (r32.hasNext() == false) goto L106;
        Object r117 = r32.next();
        e4 r118 = (e4) r117;
        int r119 = q4.a.a[r29.h.ordinal()];
        if (r119 == 1) goto L103;
        if (r119 == 2) goto L100;
        if (r119 != 3) goto L98;
        boolean r120 = r29.e.contains(r118.a);
    L104:
        if (r120 == false) goto L91;
        r31.add(r117);
        goto L91
    L98:
        throw new NoWhenBranchMatchedException();
    L100:
        if (r29.e.contains(r118.a) == false) goto L103;
        r120 = false;
    L103:
        r120 = true;
        goto L104
    L106:
        q4 r33 = this.o;
        if (r33.b == false) goto L109;
    L112:
        q4 r34 = this.o;
        r20.add(new q5.g(r34.h, r34.b, r34.c));
    L113:
        Iterator r35 = r31.iterator();
    L115:
        if (r35.hasNext() == false) goto L284;
        e4 r36 = (e4) r35.next();
        r20.add(new q5.f(r36, Intrinsics.areEqual(this.o.f, r36.a), this.o.e.contains(r36.a), this.o.g));
    L284:
        r19.submitList(r20, new k2(r37, this));
        if (this.S != this.A) goto L292;
        FrameLayout r38 = this.Q;
        if (r38 != null) goto L290;
        Intrinsics.throwUninitializedPropertyAccessException("bottomDockHost");
        r38 = null;
    L290:
        if (r38.getChildCount() <= 0) goto L292;
    L330:
        q2();
        return;
    L292:
        FrameLayout r39 = this.Q;
        if (r39 != null) goto L295;
        Intrinsics.throwUninitializedPropertyAccessException("bottomDockHost");
        r39 = null;
    L295:
        r39.removeAllViews();
        FrameLayout r40 = this.Q;
        if (r40 != null) goto L298;
        Intrinsics.throwUninitializedPropertyAccessException("bottomDockHost");
        FrameLayout r121 = null;
    L299:
        int r41 = x3.a;
        FrameLayout r42 = new FrameLayout(this);
        r42.setPadding(0, c4.c(this, 8), 0, c4.c(this, 10));
        LinearLayout r43 = c4.e(this);
        r43.setGravity(17);
        r43.setPadding(c4.c(this, 14), c4.c(this, 5), c4.c(this, 14), c4.c(this, 5));
        r43.setBackground(c4.h(this, -1, 29, -1711396, 1));
        Iterator<T> r44 = this.n.iterator();
    L301:
        if (r44.hasNext() == false) goto L329;
        final MainView r45 = (MainView) r44.next();
        if (this.A != r45) goto L305;
        boolean r122 = true;
    L306:
        int r46 = x3.a;
        LinearLayout r47 = c4.k(this);
        r47.setGravity(17);
        FrameLayout r48 = new FrameLayout(this);
        ImageView r123 = new ImageView(this);
        int r124 = g.a[r45.ordinal()];
        if (r124 == 1) goto L321;
        if (r124 != 2) goto L311;
        if (r122 == false) goto L319;
        int r125 = 2131235860;
    L324:
        r123.setImageResource(r125);
        r123.setContentDescription(r45.getTitle());
        r123.setScaleType(ImageView.ScaleType.FIT_CENTER);
        r48.addView(r123, new FrameLayout.LayoutParams(c4.c(this, 20), c4.c(this, 20), 17));
        r47.addView(r48, new LinearLayout.LayoutParams(c4.c(this, 30), c4.c(this, 30)));
        String r49 = r45.getTitle();
        if (r122 == false) goto L327;
        int r126 = -14979842;
    L328:
        TextView r50 = c4.f(this, r49, 10.5f, r126, 1);
        r50.setGravity(17);
        r50.setIncludeFontPadding(false);
        LinearLayout.LayoutParams r127 = new LinearLayout.LayoutParams(-2, -2);
        r127.setMargins(0, c4.c(this, 3), 0, 0);
        Unit r51 = Unit.INSTANCE;
        r47.addView(r50, r127);
        r47.setClickable(true);
        r47.setFocusable(true);
        r47.setOnClickListener(new h2(this, r45));
        r43.addView(r47, new LinearLayout.LayoutParams(0, -1, 1.0f));
        goto L301
    L327:
        r126 = -15656921;
        goto L328
    L319:
        r125 = 2131235859;
        goto L324
    L311:
        if (r124 != 3) goto L316;
        if (r122 == false) goto L314;
        r125 = 2131235862;
        goto L324
    L314:
        r125 = 2131235861;
        goto L324
    L316:
        throw new NoWhenBranchMatchedException();
    L321:
        if (r122 == false) goto L323;
        r125 = 2131235858;
        goto L324
    L323:
        r125 = 2131235857;
        goto L324
    L305:
        r122 = false;
        goto L306
    L329:
        int r52 = c4.c(this, 300);
        Resources r53 = getResources();
        r42.addView(r43, new FrameLayout.LayoutParams(Math.min(r52, WindowDisplayMetricsOverride.apply(r53, r53.getDisplayMetrics()).widthPixels - c4.c(this, 24)), c4.c(this, 58), 17));
        r121.addView(r42, new FrameLayout.LayoutParams(-1, -2));
        this.S = this.A;
        goto L330
    L298:
        r121 = r40;
        goto L299
    L109:
        if (r33.c == true) goto L112;
        if (r31.isEmpty() == false) goto L113;
    L63:
        if (r114.isEmpty() == false) goto L65;
    L79:
        r116 = 0;
        goto L89
    L74:
        throw new NoWhenBranchMatchedException();
    L75:
        List<e4> r128 = r28.a;
        if ((r128 instanceof Collection) == true) goto L78;
    L80:
        Iterator<T> r129 = r128.iterator();
        r116 = 0;
    L82:
        if (r129.hasNext() == false) goto L89;
        if ((!r28.e.contains(((e4) r129.next()).a)) == false) goto L82;
        r116 = r116 + 1;
        if (r116 >= 0) goto L82;
        CollectionsKt.throwCountOverflow();
        goto L82
    L78:
        if (r128.isEmpty() == false) goto L80;
    L88:
        r116 = r28.a.size();
        goto L89
    L118:
        throw new NoWhenBranchMatchedException();
    L119:
        int r130 = ((ArrayList) c2()).size();
        ArrayList r54 = (ArrayList) c2();
        if (r54.isEmpty() == false) goto L122;
        int r131 = 0;
    L136:
        int r132 = RangesKt.coerceAtLeast(r130 - r131, 0);
        Collection r55 = ((LinkedHashMap) L1()).values();
        if ((r55 instanceof Collection) == true) goto L139;
    L141:
        Iterator r56 = r55.iterator();
        int r133 = 0;
    L143:
        if (r56.hasNext() == false) goto L153;
        if (((a5) r56.next()).b != Vote.UP) goto L147;
        boolean r57 = true;
    L148:
        if (r57 == false) goto L143;
        r133 = r133 + 1;
        if (r133 >= 0) goto L143;
        CollectionsKt.throwCountOverflow();
        goto L143
    L147:
        r57 = false;
        goto L148
    L153:
        int r134 = r133;
    L154:
        Collection r58 = ((LinkedHashMap) L1()).values();
        if ((r58 instanceof Collection) == true) goto L157;
    L159:
        Iterator r59 = r58.iterator();
        int r60 = 0;
    L161:
        if (r59.hasNext() == false) goto L170;
        if (((a5) r59.next()).b != Vote.DOWN) goto L165;
        boolean r135 = true;
    L166:
        if (r135 == false) goto L161;
        r60 = r60 + 1;
        if (r60 >= 0) goto L161;
        CollectionsKt.throwCountOverflow();
        goto L161
    L165:
        r135 = false;
        goto L166
    L170:
        int r136 = r60;
    L171:
        r20.add(new q5.e(this.B, new u5(r130, r131, r132, r134, r136)));
        int r210 = y2(null);
        if (this.C != null) goto L174;
        boolean r211 = true;
    L175:
        List r61 = CollectionsKt.listOf(new p5("all", "全部", 2131235866, null, r210, r211, -14979842));
        List<l5> r62 = a2();
        ArrayList r137 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r62, 10));
        Iterator r63 = ((ArrayList) r62).iterator();
    L177:
        if (r63.hasNext() == false) goto L183;
        l5 r138 = (l5) r63.next();
        String r139 = r138.a.getRaw();
        String r140 = r138.c;
        int r141 = r138.d;
        ModuleKey r142 = r138.a;
        int r212 = y2(r142);
        if (this.C != r138.a) goto L181;
        boolean r213 = true;
    L182:
        r137.add(new p5(r139, r140, r141, r142, r212, r213, r138.e));
        goto L177
    L181:
        r213 = false;
        goto L182
    L183:
        r20.add(new q5.c(CollectionsKt.plus(r61, r137)));
        List<com.obric.assistant.cocreationreview.a> r64 = Y1();
        int r65 = s3.a;
        StringBuilder r66 = new StringBuilder("listCount=");
        ArrayList r67 = (ArrayList) r64;
        r66.append(r67.size());
        r66.append(", mode=");
        r66.append(this.B);
        r66.append(", selectedModule=");
        ModuleKey r68 = this.C;
        if (r68 == null) goto L189;
        String r69 = r68.getRaw();
        if (r69 == null) goto L189;
        r8 = r69;
    L189:
        r66.append(r8);
        s3.a("ui.renderReview", r66.toString());
        if (r67.isEmpty() == false) goto L192;
        r20.add(new q5.a(this.B));
        goto L284
    L192:
        Iterator r70 = r67.iterator();
    L194:
        if (r70.hasNext() == false) goto L284;
        com.obric.assistant.cocreationreview.a r71 = (com.obric.assistant.cocreationreview.a) r70.next();
        a5 r72 = (a5) ((LinkedHashMap) L1()).get(r71.a());
        if (r72 != null) goto L198;
        r72 = new a5(r71.a(), null, null, null, false, 0, null, 254);
    L198:
        List<b5> r73 = this.k.get(r71.a());
        if (r73 != null) goto L201;
        r73 = CollectionsKt.emptyList();
    L201:
        List<b5> r74 = r72.g;
        Intrinsics.checkNotNullParameter(r73, "sessionMedia");
        Intrinsics.checkNotNullParameter(r74, "persistedMedia");
        List<b5> r75 = r73;
        if (r75.isEmpty() == true) goto L205;
        r74 = r75;
    L205:
        List<b5> r76 = r74;
        if (this.B != ReviewMode.HISTORY) goto L208;
        boolean r77 = true;
    L209:
        r20.add(new q5.i(r71, r72, r77, r76));
        goto L194
    L208:
        r77 = false;
        goto L209
    L174:
        r211 = false;
        goto L175
    L157:
        if (r58.isEmpty() == false) goto L159;
        r136 = 0;
        goto L171
    L139:
        if (r55.isEmpty() == false) goto L141;
        r134 = 0;
        goto L154
    L122:
        Iterator r78 = r54.iterator();
        int r143 = 0;
    L124:
        if (r78.hasNext() == false) goto L135;
        com.obric.assistant.cocreationreview.a r144 = (com.obric.assistant.cocreationreview.a) r78.next();
        a5 r145 = (a5) ((LinkedHashMap) L1()).get(r144.a());
        if (r145 != null) goto L128;
    L130:
        boolean r146 = false;
    L131:
        if (r146 == false) goto L124;
        r143 = r143 + 1;
        if (r143 >= 0) goto L124;
        CollectionsKt.throwCountOverflow();
        goto L124
    L128:
        if (r145.e != true) goto L130;
        r146 = true;
        goto L131
    L135:
        r131 = r143;
        goto L136
    L210:
        Iterator r79 = CollectionsKt.chunked(a2(), 2).iterator();
        int r80 = 0;
    L212:
        if (r79.hasNext() == false) goto L284;
        Object r81 = r79.next();
        int r82 = r80 + 1;
        if (r80 >= 0) goto L216;
        CollectionsKt.throwIndexOverflow();
    L216:
        List r83 = (List) r81;
        ArrayList r84 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r83, 10));
        Iterator r85 = r83.iterator();
    L218:
        if (r85.hasNext() == false) goto L283;
        l5 r147 = (l5) r85.next();
        List<com.obric.assistant.cocreationreview.a> r86 = c2();
        ArrayList r148 = new ArrayList();
        Iterator r87 = ((ArrayList) r86).iterator();
    L221:
        if (r87.hasNext() == false) goto L228;
        Object r149 = r87.next();
        if (((com.obric.assistant.cocreationreview.a) r149).b() != r147.a) goto L225;
        boolean r150 = true;
    L226:
        if (r150 == false) goto L221;
        r148.add(r149);
        goto L221
    L225:
        r150 = false;
        goto L226
    L228:
        int r151 = r148.size();
        if (r148.isEmpty() == false) goto L231;
        int r152 = 0;
    L245:
        if (r148.isEmpty() == false) goto L247;
        int r153 = 0;
    L264:
        if (r148.isEmpty() == false) goto L266;
        int r154 = 0;
    L282:
        r84.add(new o5(r147, r151, r152, r153, r154));
        goto L218
    L266:
        Iterator r88 = r148.iterator();
        int r89 = 0;
    L268:
        if (r88.hasNext() == false) goto L281;
        com.obric.assistant.cocreationreview.a r155 = (com.obric.assistant.cocreationreview.a) r88.next();
        a5 r156 = (a5) ((LinkedHashMap) L1()).get(r155.a());
        if (r156 == null) goto L272;
        Vote r157 = r156.b;
    L274:
        if (r157 != Vote.DOWN) goto L276;
        boolean r158 = true;
    L277:
        if (r158 == false) goto L268;
        r89 = r89 + 1;
        if (r89 >= 0) goto L268;
        CollectionsKt.throwCountOverflow();
        goto L268
    L276:
        r158 = false;
        goto L277
    L272:
        r157 = null;
        goto L274
    L281:
        r154 = r89;
        goto L282
    L247:
        Iterator r90 = r148.iterator();
        r153 = 0;
    L249:
        if (r90.hasNext() == false) goto L264;
        com.obric.assistant.cocreationreview.a r159 = (com.obric.assistant.cocreationreview.a) r90.next();
        a5 r91 = (a5) ((LinkedHashMap) L1()).get(r159.a());
        if (r91 == null) goto L253;
        Vote r92 = r91.b;
    L255:
        if (r92 != Vote.UP) goto L257;
        boolean r93 = true;
    L258:
        if (r93 == false) goto L249;
        r153 = r153 + 1;
        if (r153 >= 0) goto L249;
        CollectionsKt.throwCountOverflow();
        goto L249
    L257:
        r93 = false;
        goto L258
    L253:
        r92 = null;
        goto L255
    L231:
        Iterator r94 = r148.iterator();
        r152 = 0;
    L233:
        if (r94.hasNext() == false) goto L245;
        com.obric.assistant.cocreationreview.a r160 = (com.obric.assistant.cocreationreview.a) r94.next();
        a5 r161 = (a5) ((LinkedHashMap) L1()).get(r160.a());
        if (r161 != null) goto L237;
    L239:
        boolean r162 = false;
    L240:
        if (r162 == false) goto L233;
        r152 = r152 + 1;
        if (r152 >= 0) goto L233;
        CollectionsKt.throwCountOverflow();
        goto L233
    L237:
        if (r161.e != true) goto L239;
        r162 = true;
        goto L240
    L283:
        r20.add(new q5.d(r80, r84));
        r80 = r82;
        goto L212
    L51:
        r25 = null;
        goto L52
    L44:
        r111 = false;
        goto L46
    L40:
        r110 = false;
    L30:
        r16 = VoiceDisplayScene.NONE;
        goto L31
    L13:
        if (r10.isEmpty() == false) goto L15;
        r12 = 0;
    L9:
        r9 = "all";
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r18) {
        if (com.larus.platform.service.z2.a.enableGlobalActivityTheme() == false) goto L7;
        v19.f.a(getTheme());     // Catch: Throwable -> L10
    L7:
        if (v19.f.f(this) == false) goto L11;
        v19.f.c(getTheme());     // Catch: Throwable -> L10
    L11:
        super/*androidx.fragment.app.FragmentActivity*/.onCreate(r18);
        CocreationReviewEntrySource.a r2 = CocreationReviewEntrySource.Companion;
        Intent r3 = getIntent();
        r2.getClass();
        Intrinsics.checkNotNullParameter(r3, "intent");
        Uri r4 = r3.getData();
        FrameLayout r5 = null;
        if (r4 == null) goto L14;
        String r6 = UriProtector.getQueryParameter(r4, "is_from_push");
    L15:
        Bundle r7 = r3.getExtras();
        if (r7 == null) goto L18;
        Object r8 = r7.get("is_from_push");
    L20:
        if (StringsKt.equals(r6, "true", true) == false) goto L22;
    L31:
        boolean r9 = true;
    L32:
        if (r9 == false) goto L34;
        CocreationReviewEntrySource r10 = CocreationReviewEntrySource.PUSH;
    L35:
        com.obric.assistant.settings.h.a.getClass();
        com.obric.assistant.settings.h.a r11 = com.obric.assistant.settings.h.a();
        if (r11.a == true) goto L38;
        int r1 = s3.a;
        s3.b("activity.entry", "blocked enterFrom=" + r10.getTrackValue() + ", resolved=" + r11.b + ", gateSource=" + r11.c);
        finish();
        return;
    L38:
        this.M1 = true;
        int r12 = s3.a;
        s3.b("activity.entry", "allowed enterFrom=" + r10.getTrackValue() + ", gateSource=" + r11.c);
        int r13 = r3.a;
        Intrinsics.checkNotNullParameter(r10, "source");
        JSONObject r14 = new JSONObject();
        r14.put("enter_from", r10.getTrackValue());
        s3.b("activity.entry", "report event=enter_cocreation_review_page, enterFrom=" + r10.getTrackValue());
        IApplog.a.reportEvent("enter_cocreation_review_page", r14);
        s3.b("activity.lifecycle", "onCreate providers=" + b2().size() + ", modules=" + CollectionsKt.joinToString$default(b2(), null, null, null, 0, null, new n1(), 31, null));
        if (r18 == null) goto L74;
        Bundle r15 = r18.getBundle("task_center");
        if (r15 == null) goto L74;
        if (Intrinsics.areEqual(r15.getString("user_id"), AccountService.a.getUserId()) == true) goto L46;
        r15 = null;
    L46:
        if (r15 == null) goto L74;
        this.r = r15.getString("user_id");
        Bundle r16 = r15.getBundle("drafts");
        if (r16 == null) goto L55;
        Iterator<T> r17 = r16.keySet().iterator();
    L51:
        if (r17.hasNext() == false) goto L55;
        String r19 = (String) r17.next();
        String r20 = r16.getString(r19);
        if (r20 == null) goto L51;
        this.o.d.put(r19, r20);
    L55:
        this.o.f = r15.getString("expanded_id");
        q4 r21 = this.o;
        CocreationTaskFilter[] r22 = CocreationTaskFilter.values();
        int r23 = r22.length;
        int r24 = 0;
    L56:
        if (r24 >= r23) goto L61;
        CocreationTaskFilter r25 = r22[r24];
        if (Intrinsics.areEqual(r25.name(), r15.getString("filter")) == true) goto L62;
        r24 = r24 + 1;
    L62:
        if (r25 != null) goto L64;
        r25 = CocreationTaskFilter.ALL;
    L64:
        r21.getClass();
        Intrinsics.checkNotNullParameter(r25, "<set-?>");
        r21.h = r25;
        MainView[] r26 = MainView.values();
        int r27 = r26.length;
        int r28 = 0;
    L65:
        if (r28 >= r27) goto L70;
        MainView r29 = r26[r28];
        if (Intrinsics.areEqual(r29.name(), r15.getString("main_view")) == true) goto L71;
        r28 = r28 + 1;
    L71:
        if (r29 != null) goto L73;
        r29 = this.A;
    L73:
        this.A = r29;
        goto L74
    L70:
        r29 = null;
        goto L71
    L61:
        r25 = null;
    L74:
        Window r30 = getWindow();
        r30.setStatusBarColor(0);
        r30.setNavigationBarColor(-1);
        r30.setSoftInputMode(50);
        y1(r30).setSystemUiVisibility(9488);
        LinearLayout r31 = c4.k(this);
        r31.setBackgroundColor(-1);
        RecyclerView r32 = new RecyclerView(this);
        r32.setLayoutManager(new LinearLayoutManager(this));
        r32.setAdapter((CocreationReviewPageAdapter) this.v.getValue());
        r32.setOverScrollMode(1);
        r32.setClipToPadding(false);
        r32.setItemAnimator(null);
        r32.setMotionEventSplittingEnabled(false);
        this.P = r32;
        this.Q = new FrameLayout(this);
        View r33 = this.P;
        if (r33 != null) goto L77;
        Intrinsics.throwUninitializedPropertyAccessException("contentList");
        r33 = null;
    L77:
        r31.addView(r33, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        FrameLayout r34 = this.Q;
        if (r34 != null) goto L80;
        Intrinsics.throwUninitializedPropertyAccessException("bottomDockHost");
        r34 = null;
    L80:
        r31.addView(r34, new LinearLayout.LayoutParams(-1, -2));
        FrameLayout r35 = new FrameLayout(this);
        r35.setVisibility(8);
        this.R = r35;
        FrameLayout r36 = new FrameLayout(this);
        r36.setBackgroundColor(-1);
        this.O = r36;
        r36.addView(r31, new FrameLayout.LayoutParams(-1, -1));
        FrameLayout r37 = this.O;
        if (r37 != null) goto L83;
        Intrinsics.throwUninitializedPropertyAccessException("rootHost");
        r37 = null;
    L83:
        LayoutInflater r38 = getLayoutInflater();
        FrameLayout r39 = this.O;
        if (r39 != null) goto L86;
        Intrinsics.throwUninitializedPropertyAccessException("rootHost");
        r39 = null;
    L86:
        OFloatingTitleBar r40 = r38.inflate(2131559841, r39, false);
        Intrinsics.checkNotNull(r40, "null cannot be cast to non-null type com.obric.oui.titlebar.OFloatingTitleBar");
        OFloatingTitleBar r41 = r40;
        r41.setCenterTitle(2131895700);
        r41.setCenterTitleColor(-15656921);
        OFloatingTitleBar.k(r41, new o2(this), 2).setContentDescription(getString(2131895699));
        r41.setFloatingTransitionEnabled(t9a.b.a().b());
        r41.findViewById(2131388812).addOnLayoutChangeListener(new p2(this));
        r37.addView(r41, new FrameLayout.LayoutParams(-1, -2, 48));
        FrameLayout r42 = this.O;
        if (r42 != null) goto L89;
        Intrinsics.throwUninitializedPropertyAccessException("rootHost");
        r42 = null;
    L89:
        FrameLayout r43 = this.R;
        if (r43 != null) goto L92;
        Intrinsics.throwUninitializedPropertyAccessException("overlayHost");
        r43 = null;
    L92:
        r42.addView(r43, new FrameLayout.LayoutParams(-1, -1));
        FrameLayout r44 = this.O;
        if (r44 != null) goto L95;
        Intrinsics.throwUninitializedPropertyAccessException("rootHost");
        r44 = null;
    L95:
        r44.getViewTreeObserver().addOnGlobalLayoutListener(this.x);
        FrameLayout r45 = this.O;
        if (r45 != null) goto L98;
        Intrinsics.throwUninitializedPropertyAccessException("rootHost");
        r45 = null;
    L98:
        r45.setOnApplyWindowInsetsListener(new p1(this));
        FrameLayout r46 = this.O;
        if (r46 != null) goto L101;
        Intrinsics.throwUninitializedPropertyAccessException("rootHost");
        r46 = null;
    L101:
        r46.setWindowInsetsAnimationCallback(new k3(this));
        FrameLayout r47 = this.O;
        if (r47 != null) goto L104;
        Intrinsics.throwUninitializedPropertyAccessException("rootHost");
        r47 = null;
    L104:
        setContentView(r47);
        FrameLayout r48 = this.O;
        if (r48 != null) goto L107;
        Intrinsics.throwUninitializedPropertyAccessException("rootHost");
    L108:
        r5.requestApplyInsets();
        x2("activity_create");
        A2();
        getOnBackPressedDispatcher().addCallback(this, this.w);
        int r49 = s3.a;
        s3.b("activity.observe", "registerProviderObservers providers=" + b2().size());
        Iterator<T> r50 = b2().iterator();
    L110:
        if (r50.hasNext() == false) goto L112;
        e5 r51 = (e5) r50.next();
        int r52 = s3.a;
        s3.a("activity.observe", "register module=" + r51.getBusinessId().getRaw());
        r51.c(this.z);
        goto L110
    L112:
        M2("activity_create");
        return;
    L107:
        r5 = r48;
        goto L108
    L34:
        r10 = CocreationReviewEntrySource.NORMAL;
        goto L35
    L22:
        if ((r8 instanceof Boolean) == false) goto L25;
        boolean r53 = ((Boolean) r8).booleanValue();
    L28:
        if (r53 == true) goto L31;
        r9 = false;
        goto L32
    L25:
        if ((r8 instanceof String) == false) goto L27;
        r53 = StringsKt.equals((String) r8, "true", true);
        goto L28
    L27:
        r53 = false;
        goto L28
    L18:
        r8 = null;
        goto L20
    L14:
        r6 = null;
        goto L15
    }

    public final void onSaveInstanceState(Bundle r6) {
        Intrinsics.checkNotNullParameter(r6, "outState");
        Bundle r0 = new Bundle();
        Bundle r1 = new Bundle();
        Iterator<Map.Entry<String, String>> r2 = this.o.d.entrySet().iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        Map.Entry<String, String> r3 = r2.next();
        r1.putString(r3.getKey(), r3.getValue());
        goto L4
    L6:
        Unit r4 = Unit.INSTANCE;
        r0.putBundle("drafts", r1);
        r0.putString("user_id", this.r);
        r0.putString("expanded_id", this.o.f);
        r0.putString("filter", this.o.h.name());
        r0.putString("main_view", this.A.name());
        r6.putBundle("task_center", r0);
        super/*androidx.activity.ComponentActivity*/.onSaveInstanceState(r6);
    }

    public final void v2(String r2) {
        if (Intrinsics.areEqual(this.D, r2) == false) goto L8;
        CocreationFeedbackPanelFragment r3 = M1();
        if (r3 == null) goto L9;
        r3.ca0(false);
        return;
    L9:
        return;
    }

    public final void w2(boolean r3) {
        if (this.F == true) goto L5;
        return;
    L5:
        View r0 = t2();
        if (r0 == null) goto L12;
        r0.animate().cancel();
        if (r3 == false) goto L10;
        r0.animate().translationY(0.0f).setDuration(120).start();
        return;
    L10:
        r0.setTranslationY(0.0f);
        return;
    }

    public final f x2(String r19) {
        long r2 = this.G1;
        long r4 = this.y1;
        long r6 = ((Keva) w3.a.getValue()).getLong("last_settlement_time_millis", 0);
        long r10 = i0.b(System.currentTimeMillis());
        long r12 = System.currentTimeMillis();
        Calendar r14 = Calendar.getInstance();
        r14.setTimeInMillis(i0.b(r12));
        r14.add(6, 1);
        long r15 = r14.getTimeInMillis();
        Calendar r13 = Calendar.getInstance();
        r13.setTimeInMillis(r10);
        r13.add(6, -1);
        long r8 = r13.getTimeInMillis();
        if (r10 <= r6) goto L5;
    L7:
        boolean r16 = false;
    L8:
        if (r16 == false) goto L10;
        long r17 = r6;
    L12:
        if (r17 <= 0) goto L15;
        r10 = r17;
    L22:
        this.G1 = r17;
        this.y1 = r10;
        if (r2 == r17) goto L25;
        boolean r3 = true;
    L27:
        if (r4 == r10) goto L29;
        boolean r18 = true;
    L30:
        if (r3 == true) goto L34;
        if (r18 == true) goto L34;
        if (Intrinsics.areEqual(r19, "activity_create") == true) goto L34;
    L43:
        return new f(r3, r18);
    L34:
        int r5 = s3.a;
        StringBuilder r7 = new StringBuilder("restore reason=");
        r7.append(r19);
        r7.append(", stored=");
        String r1 = VoiceDisplayScene.NONE;
        if (r6 <= 0) goto L37;
        String r9 = Z1(r6);
    L38:
        r7.append(r9);
        r7.append(", todaySettlement=");
        long r11 = this.G1;
        if (r11 <= 0) goto L41;
        r1 = Z1(r11);
    L41:
        r7.append(r1);
        r7.append(", observeEarliest=");
        r7.append(Z1(this.y1));
        r7.append(", settlementChanged=");
        r7.append(r3);
        r7.append(", observeWindowChanged=");
        r7.append(r18);
        s3.b("settlement.state", r7.toString());
        goto L43
    L37:
        r9 = VoiceDisplayScene.NONE;
        goto L38
    L29:
        r18 = false;
        goto L30
    L25:
        r3 = false;
        goto L27
    L15:
        if (r8 <= r6) goto L17;
    L19:
        boolean r20 = false;
    L20:
        if (r20 == false) goto L22;
        r10 = r6;
        goto L22
    L17:
        if (r6 >= r10) goto L19;
        r20 = true;
        goto L20
    L10:
        r17 = 0;
        goto L12
    L5:
        if (r6 >= r15) goto L7;
        r16 = true;
        goto L8
    }

    public final int y2(ModuleKey r7) {
        List<com.obric.assistant.cocreationreview.a> r0 = c2();
        ArrayList r1 = new ArrayList();
        Iterator<T> r2 = r0.iterator();
    L3:
        boolean r3 = true;
        if (r2.hasNext() == false) goto L14;
        Object r4 = r2.next();
        com.obric.assistant.cocreationreview.a r5 = (com.obric.assistant.cocreationreview.a) r4;
        if (r7 != null) goto L8;
    L11:
        if (r3 == false) goto L3;
        r1.add(r4);
        goto L3
    L8:
        if (r5.b() == r7) goto L11;
        r3 = false;
        goto L11
    L14:
        if (r1.isEmpty() == true) goto L54;
        Iterator r8 = r1.iterator();
        int r6 = 0;
    L18:
        if (r8.hasNext() == false) goto L40;
        com.obric.assistant.cocreationreview.a r9 = (com.obric.assistant.cocreationreview.a) r8.next();
        Map<String, a5> r10 = L1();
        LinkedHashMap r11 = (LinkedHashMap) r10;
        a5 r12 = (a5) r11.get(r9.a());
        if (r12 != null) goto L22;
    L24:
        boolean r13 = false;
    L25:
        ReviewMode r14 = this.B;
        int r15 = g.c[r14.ordinal()];
        if (r15 != 1) goto L28;
        if (r13 == true) goto L34;
        r13 = true;
    L35:
        if (r13 == false) goto L18;
        r6 = r6 + 1;
        if (r6 >= 0) goto L18;
        CollectionsKt.throwCountOverflow();
        goto L18
    L34:
        r13 = false;
        goto L35
    L28:
        if (r15 == 2) goto L35;
        throw new NoWhenBranchMatchedException();
    L22:
        if (r12.e != true) goto L24;
        r13 = true;
        goto L25
    L40:
        return r6;
    L54:
        return 0;
    }

    public final void z2(final View r4) {
        FrameLayout r0 = this.O;
        if (r0 == null) goto L10;
        r0.requestApplyInsets();
        FrameLayout r1 = this.O;
        if (r1 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("rootHost");
        r1 = null;
    L7:
        WindowInsets r2 = r1.getRootWindowInsets();
        if (r2 == null) goto L10;
        n2(r2);
    L10:
        r4.postDelayed(new o1(this, r4), 120);
        r4.postDelayed(new z1(this, r4), 320);
    }

    public static String O1(x4 r1, z4.a r2) {
        String r3 = r1.a;
        if (r3 == null) goto L10;
        if ((!StringsKt.isBlank(r3)) == true) goto L8;
        r3 = null;
    L8:
        if (r3 == null) goto L10;
        return r3;
    L10:
        return r2.a;
    }

    public static String z1(z4.a r3, int r4) {
        List r0 = N1(r3);
        x4 r5 = (x4) CollectionsKt.getOrNull(r0, RangesKt.coerceIn(r4, 0, CollectionsKt.getLastIndex(r0)));
        if (r5 == null) goto L8;
        String r6 = O1(r5, r3);
        if (r6 == null) goto L8;
        return r6;
    L8:
        return r3.a;
    }

    public final a5 A1(com.obric.assistant.cocreationreview.a r22, Vote r23) {
        a5 r1 = this.i.get(r22.a());
        if (r1 != null) goto L7;
        r1 = (a5) ((LinkedHashMap) L1()).get(r22.a());
        if (r1 != null) goto L7;
        r1 = new a5(r22.a(), null, null, null, false, 0, null, 254);
    L7:
        a5 r12 = r1;
        if (r12.b == r23) goto L10;
        boolean r2 = true;
    L11:
        if (r2 == false) goto L13;
        Set<String> r4 = SetsKt.emptySet();
    L14:
        a5 r5 = a5.a(r12, r23, r4, null, false, 0, null, 201);
        this.i.put(r22.a(), r5);
        this.F = false;
        this.E = false;
        int r3 = s3.a;
        s3.b("draft.vote", "apply recordId=" + r22.a() + ", module=" + r22.b().getRaw() + ", vote=" + r23.getRaw() + ", resetReasons=" + r2 + ", reasonCount=" + r5.c.size() + ", commentLength=" + r5.d.length());
        return r5;
    L13:
        r4 = r12.c;
        goto L14
    L10:
        r2 = false;
        goto L11
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void B1(l5 r7, boolean r8) {
        d r0 = this.k1.get(r7.a);
        if (r0 != null) goto L5;
        return;
    L5:
        View r1 = r0.a;
        if (r8 == false) goto L8;
        int r2 = -656897;
    L9:
        if (r8 == false) goto L11;
        int r3 = r7.e;
    L12:
        r1.setBackground(c4.h(this, r2, 11, r3, 1));
        TextView r4 = r0.b;
        if (r8 == false) goto L15;
        int r9 = r7.e;
    L16:
        r4.setTextColor(r9);
        return;
    L15:
        r9 = -9735552;
        goto L16
    L11:
        r3 = -1973274;
        goto L12
    L8:
        r2 = -1;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void C1(TextView r5, boolean r6) {
        if (this.J == false) goto L5;
        String r0 = "提交中...";
    L6:
        r5.setText(r0);
        if (r6 == false) goto L9;
        int r1 = -1;
    L10:
        r5.setTextColor(r1);
        int r2 = -14979842;
        if (r6 == false) goto L13;
        int r3 = -14979842;
    L14:
        if (r6 == true) goto L17;
        r2 = -1512723;
    L17:
        r5.setBackground(c4.h(this, r3, 20, r2, 1));
        r5.setEnabled(r6);
        return;
    L13:
        r3 = -394242;
        goto L14
    L9:
        r1 = -3616547;
        goto L10
    L5:
        r0 = "提交反馈";
        goto L6
    }

    public final boolean C2(String r4, String r5) {
        String r0 = this.D;
        if (r0 != null) goto L6;
        return false;
    L6:
        int r1 = s3.a;
        s3.b("feedback.panel", "vote blocked source=" + r5 + ", recordId=" + r4 + ", activeRecordId=" + r0 + ", reason=panel_active");
        return true;
    }

    public final boolean D1(String r7, boolean r8) {
        f r0 = x2(r7);
        boolean r2 = false;
        if (r0.a == false) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L12;
        return false;
    L12:
        if (r0.b == false) goto L14;
        H1(r7);
        M2(r7);
    L15:
        if (r8 == true) goto L17;
    L19:
        o2(r2);
        return true;
    L17:
        if (r0.b == false) goto L19;
        r2 = true;
        goto L19
    L14:
        int r3 = s3.a;
        s3.b("settlement.state", "skipObserveWindowRefresh reason=" + r7 + ", observeEarliest=" + Z1(this.y1));
        goto L15
    L5:
        if (r0.b == true) goto L8;
        r1 = false;
        goto L9
    }

    public final void D2(com.obric.assistant.cocreationreview.a r7, Vote r8) {
        if (i2(r7.a()) == false) goto L6;
        int r0 = s3.a;
        s3.b("feedback.panel", "show blocked recordId=" + r7.a() + ", module=" + r7.b().getRaw() + ", vote=" + r8.getRaw() + ", reason=feedback_completed");
        return;
    L6:
        a5 r1 = A1(r7, r8);
        this.D = r7.a();
        r7.b();
        int r4 = s3.a;
        s3.b("feedback.panel", "show recordId=" + r7.a() + ", module=" + r7.b().getRaw() + ", vote=" + r8.getRaw() + ", reasonCount=" + r1.c.size() + ", commentLength=" + r1.d.length());
        o2(false);
        F2(F1(r7.a(), r7.b()));
    }

    public final void E2(z4.a r4, int r5) {
        int r6 = RangesKt.coerceIn(r5, 0, CollectionsKt.getLastIndex(N1(r4)));
        int r0 = s3.a;
        StringBuilder r1 = new StringBuilder("show recordId=");
        r1.append(r4.a);
        r1.append(", title=");
        r1.append(r4.c.a);
        r1.append(", pages=");
        r1.append(r4.f.size());
        r1.append(", initialPage=");
        r1.append(r6);
        r1.append(", anchor=");
        String r2 = r4.g;
        if (r2 != null) goto L5;
        r2 = VoiceDisplayScene.NONE;
    L5:
        r1.append(r2);
        s3.b("detail.action", r1.toString());
        this.L = r4;
        this.M = r6;
        this.F = false;
        o2(false);
    }

    public final d5 F1(String r19, ModuleKey r20) {
        Iterator r1 = ((ArrayList) c2()).iterator();
    L3:
        l5 r3 = null;
        if (r1.hasNext() == false) goto L8;
        Object r2 = r1.next();
        if (Intrinsics.areEqual(((com.obric.assistant.cocreationreview.a) r2).a(), r19) == false) goto L3;
    L9:
        com.obric.assistant.cocreationreview.a r4 = (com.obric.assistant.cocreationreview.a) r2;
        if (r4 == null) goto L13;
        ModuleKey r5 = r4.b();
        if (r5 == null) goto L13;
    L15:
        if (r5 != null) goto L18;
        int r6 = s3.a;
        s3.c("feedback.panel", "render blocked recordId=" + r19 + ", reason=module_missing");
        this.D = null;
        return new d5(r19, "反馈原因", CollectionsKt.emptyList(), new a5(r19, null, null, null, false, 0, null, 254), NameKeys.UnloadStrategy_No_Strategy, "反馈数据不存在", "反馈数据不存在", false, false, null, 15360);
    L18:
        if (r4 != null) goto L20;
        int r7 = s3.a;
        s3.c("feedback.panel", "render with cached module, recordId=" + r19 + ", module=" + r5.getRaw() + ", reason=record_missing");
    L20:
        l0 r8 = (l0) ((Map) this.b.getValue()).get(r5);
        if (r8 == null) goto L23;
        r3 = r8.b();
    L23:
        l5 r12 = r3;
        if (r12 == null) goto L60;
        a5 r9 = (a5) ((LinkedHashMap) L1()).get(r19);
        if (r9 != null) goto L28;
        a5 r10 = new a5(r19, null, null, null, false, 0, null, 254);
    L29:
        Vote r11 = r10.b;
        if (r11 != null) goto L32;
        int r13 = -1;
    L34:
        if (r13 == (-1)) goto L41;
        if (r13 == 1) goto L40;
        if (r13 != 2) goto L39;
        List<String> r14 = r12.h;
    L42:
        List<String> r15 = r14;
        if (r11 != null) goto L45;
        int r16 = -1;
    L46:
        if (r16 == (-1)) goto L53;
        if (r16 == 1) goto L52;
        if (r16 != 2) goto L51;
        String r17 = "点踩原因（多选）";
    L54:
        String r18 = r17;
        String r21 = t3.a(r12, r11);
        String r22 = "需先选择点赞或点踩";
        String r23 = "需先选择一个标签";
        boolean r110 = this.m.contains(r19);
        boolean r111 = r12.l;
        List<b5> r24 = this.j.get(r19);
        if (r24 != null) goto L58;
        r24 = CollectionsKt.emptyList();
    L58:
        return new d5(r19, r18, r15, r10, r21, r22, r23, r110, r111, r24, 1024);
    L51:
        throw new NoWhenBranchMatchedException();
    L52:
        r17 = "点赞原因（多选）";
        goto L54
    L53:
        r17 = "反馈原因";
        goto L54
    L45:
        r16 = g.d[r11.ordinal()];
        goto L46
    L39:
        throw new NoWhenBranchMatchedException();
    L40:
        r14 = r12.g;
        goto L42
    L41:
        r14 = CollectionsKt.emptyList();
        goto L42
    L32:
        r13 = g.d[r11.ordinal()];
        goto L34
    L28:
        r10 = r9;
        goto L29
    L60:
        throw new IllegalArgumentException(("No CocreationModuleFeature registered for " + r5.getRaw()).toString());
    L13:
        r5 = r20;
        goto L15
    L8:
        r2 = null;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final View P1(String r8, View r9) {
        LinearLayout r6 = c4.k(this);
        TextView r10 = c4.f(this, r8, 12.5f, -9735552, 1);
        r10.setGravity(17);
        r10.setPadding(c4.c(this, 12), 0, c4.c(this, 12), 0);
        r10.setBackground(c4.h(this, -1, 15, -1973274, 1));
        r6.addView(r10, new LinearLayout.LayoutParams(-2, c4.c(this, 30)));
        c4.b(r6, r9, 0, c4.c(this, 10), 0, 10);
        return r6;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.obric.assistant.cocreationreview.CocreationFeedbackPanelFragment.a
    public final void Q(String r8, String r9) {
        Intrinsics.checkNotNullParameter(r8, "recordId");
        Intrinsics.checkNotNullParameter(r9, "source");
        if (Intrinsics.areEqual(this.D, r8) == true) goto L5;
        return;
    L5:
        String r10 = this.D;
        if (r10 != null) goto L9;
        return;
    L9:
        if (this.m.contains(r10) == false) goto L11;
        int r0 = s3.a;
        s3.b("feedback.panel", "dismissBlocked source=" + r9 + ", recordId=" + r10 + ", reason=submitting");
        Toast.makeText(this, "正在提交，请稍候", 0).show();
        return;
    L11:
        boolean r1 = this.i.containsKey(r10);
        if (this.i.remove(r10) == null) goto L14;
        boolean r4 = true;
    L15:
        this.j.remove(r10);
        int r5 = s3.a;
        s3.b("feedback.panel", "dismiss source=" + r9 + ", recordId=" + r10 + ", draftExists=" + r1 + ", discardedDraft=" + r4);
        this.D = null;
        o2(false);
        return;
    L14:
        r4 = false;
        goto L15
    }

    @Override // com.obric.assistant.cocreationreview.CocreationFeedbackPanelFragment.a
    public final void R0(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "recordId");
        Intrinsics.checkNotNullParameter(r4, "reason");
        K2(r3, false, "panel_reason", new h1(r4, r3));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void X1(String r3, String r4) {
        this.m.remove(r3);
        v2(r3);
        int r0 = s3.a;
        s3.c("submit.media", "failed recordId=" + r3 + ", message=" + r4);
        Toast.makeText(this, r4, 0).show();
        o2(false);
    }

    @Override // com.obric.assistant.cocreationreview.CocreationFeedbackPanelFragment.a
    public final void h1(String r2, List<b5> r3) {
        Intrinsics.checkNotNullParameter(r2, "recordId");
        Intrinsics.checkNotNullParameter(r3, "media");
        if (r3.isEmpty() == false) goto L5;
        this.j.remove(r2);
        return;
    L5:
        this.j.put(r2, CollectionsKt.toList(r3));
    }

    @Override // com.obric.assistant.cocreationreview.CocreationFeedbackPanelFragment.a
    public final void o(String r3, final String r4) {
        Intrinsics.checkNotNullParameter(r3, "recordId");
        Intrinsics.checkNotNullParameter(r4, "comment");
        K2(r3, false, "panel_comment", new n2(r4));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final View p2(z4.a r39, x4 r40) {
        String r4 = O1(r40, r39);
        a5 r3 = (a5) ((LinkedHashMap) L1()).get(r4);
        if (r3 != null) goto L10;
        r3 = r39.d;
        if (Intrinsics.areEqual(r3.a, r4) == true) goto L8;
        r3 = null;
    L8:
        if (r3 != null) goto L10;
        r3 = new a5(r4, null, null, null, false, 0, null, 254);
    L10:
        LinearLayout r10 = c4.k(this);
        r10.setBackgroundColor(-1);
        LinearLayout r5 = c4.e(this);
        r5.setGravity(16);
        r5.setPadding(c4.c(this, 18), c4.c(this, 24), c4.c(this, 10), c4.c(this, 20));
        if (r39.h == null) goto L13;
        boolean r6 = true;
    L14:
        LinearLayout r7 = c4.k(this);
        String r8 = r39.b;
        if (r6 == false) goto L17;
        float r13 = 16.0f;
    L18:
        c4.b(r7, c4.f(this, r8, r13, -14979842, 1), 0, 0, 0, 14);
        if (r6 == true) goto L28;
        TextView r9 = c4.f(this, r40.b.a, 18.0f, -15656921, 1);
        r9.setMaxLines(2);
        r9.setEllipsize(TextUtils.TruncateAt.END);
        c4.b(r7, r9, 0, c4.c(this, 8), 0, 10);
        String r11 = r40.b.b;
        if (r11 == null) goto L28;
        if ((!StringsKt.isBlank(r11)) == true) goto L26;
        r11 = null;
    L26:
        if (r11 == null) goto L28;
        c4.b(r7, c4.f(this, r11, 13.0f, -9735552, 1), 0, c4.c(this, 4), 0, 10);
    L28:
        r5.addView(r7, new LinearLayout.LayoutParams(0, -2, 1.0f));
        String r12 = O1(r40, r39);
        View r14 = Q1(r12, r3, Vote.UP);
        LinearLayout.LayoutParams r15 = new LinearLayout.LayoutParams(c4.c(this, 32), c4.c(this, 32));
        r15.setMargins(c4.c(this, 8), 0, 0, 0);
        Unit r16 = Unit.INSTANCE;
        r5.addView(r14, r15);
        View r17 = Q1(r12, r3, Vote.DOWN);
        LinearLayout.LayoutParams r18 = new LinearLayout.LayoutParams(c4.c(this, 32), c4.c(this, 32));
        r18.setMargins(c4.c(this, 5), 0, 0, 0);
        r5.addView(r17, r18);
        TextView r19 = c4.f(this, "×", 20.0f, -9735552, 0);
        r19.setGravity(17);
        GradientDrawable r20 = new GradientDrawable();
        r20.setShape(1);
        r20.setColor(-459777);
        r20.setStroke(c4.c(this, 1), -1512723);
        r19.setBackground(r20);
        r19.setOnClickListener(new y2(this));
        LinearLayout.LayoutParams r21 = new LinearLayout.LayoutParams(c4.c(this, 32), c4.c(this, 32));
        r21.setMargins(c4.c(this, 5), 0, 0, 0);
        r5.addView(r19, r21);
        int r22 = 1;
        c4.b(r10, r5, 0, 0, 0, 14);
        c4.b(r10, U1(), c4.c(this, 1), 0, 0, 12);
        final ScrollView r23 = new ScrollView(this);
        r23.setOverScrollMode(1);
        LinearLayout r24 = c4.k(this);
        r24.setPadding(c4.c(this, 18), c4.c(this, 28), c4.c(this, 18), c4.c(this, 32));
        final LinkedHashMap r25 = new LinkedHashMap();
        String r26 = r39.h;
        if (r26 != null) goto L31;
    L36:
        y4.c r27 = null;
    L37:
        List r2 = CollectionsKt.plus(CollectionsKt.listOfNotNull(r27), r40.c);
        if (r2.isEmpty() == false) goto L41;
        c4.b(r24, c4.f(this, "暂无详情", 14.0f, -9735552, 0), 0, c4.c(this, 24), 0, 10);
    L40:
        LinearLayout r37 = r10;
        r23.addView(r24, new ViewGroup.LayoutParams(-1, -2));
        final String r1 = r39.g;
        if (r1 == null) goto L105;
        r23.post(new m2(r25, r1, r23));
    L105:
        r37.addView(r23, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        return r37;
    L41:
        Iterator r28 = r2.iterator();
        int r29 = 0;
    L43:
        if (r28.hasNext() == false) goto L40;
        Object r110 = r28.next();
        int r111 = r29 + 1;
        if (r29 >= 0) goto L47;
        CollectionsKt.throwIndexOverflow();
    L47:
        y4 r112 = (y4) r110;
        if (r29 > 0) goto L50;
    L58:
        boolean r113 = false;
    L59:
        if (r113 == false) goto L62;
        c4.a(r24, U1(), c4.c(this, r22), c4.c(this, 20), c4.c(this, 22));
    L62:
        if ((r112 instanceof y4.c) == false) goto L64;
        y4.c r30 = (y4.c) r112;
        String r31 = r30.a;
        List r210 = r2;
        TextView r32 = c4.f(this, r30.b, 14.0f, -13418155, 0);
        Iterator r211 = r28;
        int r33 = r111;
        r32.setPadding(c4.c(this, 16), c4.c(this, 13), c4.c(this, 16), c4.c(this, 13));
        r32.setBackground(c4.h(this, -262657, 14, -1512723, 1));
        Unit r34 = Unit.INSTANCE;
        View r35 = P1(r31, r32);
        r10 = r10;
    L89:
        if ((r112 instanceof y4.a) == false) goto L91;
        String r36 = ((y4.a) r112).b;
    L92:
        if (r36 == null) goto L95;
        r25.put(r36, r35);
    L95:
        if (r29 <= 0) goto L98;
        if (r113 == true) goto L98;
        int r212 = c4.c(this, 24);
    L99:
        c4.b(r24, r35, 0, r212, 0, 10);
        r2 = r210;
        r28 = r211;
        r29 = r33;
        r10 = r10;
        r22 = 1;
    L98:
        r212 = 0;
        goto L99
    L91:
        r36 = null;
        goto L92
    L64:
        r210 = r2;
        r211 = r28;
        r33 = r111;
        if ((r112 instanceof y4.b) == false) goto L85;
        LinearLayout r38 = c4.k(this);
        y4.b r41 = (y4.b) r112;
        if ((!r41.b.isEmpty()) == false) goto L70;
        c4.b(r38, ((UsageCardTemplateRenderer) this.g.getValue()).d(r41.b), 0, 0, c4.c(this, 12), 6);
    L70:
        if ((!r41.c.isEmpty()) == false) goto L84;
        List<String> r42 = r41.c;
        LinearLayout r114 = c4.k(this);
        r114.setPadding(c4.c(this, 16), c4.c(this, 14), c4.c(this, 16), c4.c(this, 14));
        r114.setBackground(c4.h(this, -262657, 14, -1512723, 1));
        Iterator r43 = r42.iterator();
        int r44 = 0;
    L73:
        if (r43.hasNext() == false) goto L82;
        Object r115 = r43.next();
        int r116 = r44 + 1;
        if (r44 >= 0) goto L77;
        CollectionsKt.throwIndexOverflow();
    L77:
        StringBuilder r117 = new StringBuilder();
        r117.append(r116);
        Iterator r213 = r43;
        r117.append(". ");
        r117.append((String) r115);
        TextView r310 = c4.f(this, r117.toString(), 14.0f, -13418155, 0);
        if (r44 != CollectionsKt.getLastIndex(r42)) goto L80;
        int r311 = 0;
    L81:
        c4.b(r114, r310, 0, 0, r311, 6);
        r44 = r116;
        r43 = r213;
        goto L73
    L80:
        r311 = c4.c(this, 10);
        goto L81
    L82:
        c4.b(r38, r114, 0, 0, 0, 14);
    L84:
        r35 = P1(r41.a, r38);
        goto L89
    L85:
        r10 = r10;
        if ((r112 instanceof y4.a) == false) goto L101;
        y4.a r45 = (y4.a) r112;
        r35 = P1(r45.a, (View) r45.c.invoke(this));
        goto L89
    L101:
        throw new NoWhenBranchMatchedException();
    L50:
        if ((((y4) ListProtector.get(r2, r29 - 1)) instanceof y4.c) == true) goto L52;
    L55:
        boolean r118 = true;
    L56:
        if (r118 == false) goto L58;
        r113 = true;
        goto L59
    L52:
        if ((r112 instanceof y4.c) == false) goto L55;
        r118 = false;
        goto L56
    L31:
        if ((!StringsKt.isBlank(r40.b.a)) == true) goto L34;
        r26 = null;
    L34:
        if (r26 == null) goto L36;
        r27 = new y4.c(r26, r40.b.a);
        goto L37
    L17:
        r13 = 12.5f;
        goto L18
    L13:
        r6 = false;
        goto L14
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final TextView B2(String r4, boolean r5, final Function0<Unit> r6) {
        if (r5 == false) goto L4;
        int r0 = -1;
    L5:
        TextView r7 = c4.f(this, r4, 12.0f, r0, 1);
        r7.setGravity(17);
        r7.setIncludeFontPadding(false);
        r7.setPadding(c4.c(this, 12), 0, c4.c(this, 12), 0);
        if (r5 == false) goto L8;
        int r8 = -14979842;
    L9:
        r7.setBackground(c4.h(this, r8, 9, 0, 0));
        r7.setOnClickListener(new c2(r6));
        return r7;
    L8:
        r8 = 0;
        goto L9
    L4:
        r0 = -9735552;
        goto L5
    }

    public final void G2(final com.obric.assistant.cocreationreview.a r19, final e5 r20, s5 r21) {
        final String r4 = r19.a();
        if (this.m.contains(r4) == true) goto L5;
        return;
    L5:
        List<b5> r1 = this.j.get(r4);
        if (r1 != null) goto L8;
        r1 = CollectionsKt.emptyList();
    L8:
        ArrayList r15 = new ArrayList();
        Iterator<T> r2 = r1.iterator();
    L10:
        if (r2.hasNext() == false) goto L31;
        b5 r3 = (b5) r2.next();
        Intrinsics.checkNotNullParameter(r3, "<this>");
        String r5 = r3.k;
        CocreationUserFeedbackAttachment r7 = null;
        if (r5 != null) goto L14;
    L28:
        if (r7 == null) goto L10;
        r15.add(r7);
        goto L10
    L14:
        if ((!StringsKt.isBlank(r5)) == true) goto L17;
        r5 = null;
    L17:
        if (r5 == null) goto L28;
        int r6 = l.a[r3.getType().ordinal()];
        if (r6 != 1) goto L22;
        String r8 = "image";
    L27:
        r7 = new CocreationUserFeedbackAttachment(r8, r5);
        goto L28
    L22:
        if (r6 != 2) goto L25;
        r8 = LynxResourceModule.VIDEO_TYPE;
        goto L27
    L25:
        throw new NoWhenBranchMatchedException();
    L31:
        if (r15.size() == r1.size()) goto L34;
        X1(r4, "媒体上传结果无效，请重试");
        return;
    L34:
        String r9 = r21.a;
        String r10 = r21.b;
        ModuleKey r11 = r21.c;
        Vote r12 = r21.d;
        Set<String> r13 = r21.e;
        String r14 = r21.f;
        String r16 = r21.g;
        Integer r17 = r21.j;
        r21.getClass();
        Intrinsics.checkNotNullParameter(r9, "requestId");
        Intrinsics.checkNotNullParameter(r10, "recordId");
        Intrinsics.checkNotNullParameter(r11, "businessId");
        Intrinsics.checkNotNullParameter(r12, "vote");
        Intrinsics.checkNotNullParameter(r13, "reasons");
        Intrinsics.checkNotNullParameter(r14, "comment");
        Intrinsics.checkNotNullParameter(r16, "businessPayload");
        Intrinsics.checkNotNullParameter(r15, "attachments");
        Intrinsics.checkNotNullParameter(r1, "feedbackMedia");
        final s5 r18 = new s5(r9, r10, r11, r12, r13, r14, r16, r15, r1, r17);
        this.y.execute(new d1(r20, r18, this, r4, r19));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void I2(LinearLayout r9, int r10, int r11) {
        r9.removeAllViews();
        int r1 = 0;
        if (r10 <= 15) goto L6;
        TextView r12 = c4.f(this, RangesKt.coerceIn(r11 + 1, 1, r10) + " / " + r10, 12.0f, -9735552, 1);
        r12.setGravity(17);
        r12.setIncludeFontPadding(false);
        r9.addView(r12, new LinearLayout.LayoutParams(-2, c4.c(this, 22)));
        return;
    L6:
        if (r1 >= r10) goto L12;
        View r0 = new View(this);
        GradientDrawable r3 = new GradientDrawable();
        r3.setShape(1);
        if (r1 != r11) goto L10;
        int r4 = -15656921;
    L11:
        r3.setColor(r4);
        r0.setBackground(r3);
        LinearLayout.LayoutParams r5 = new LinearLayout.LayoutParams(c4.c(this, 7), c4.c(this, 7));
        r5.setMargins(c4.c(this, 4), c4.c(this, 5), c4.c(this, 4), c4.c(this, 5));
        Unit r6 = Unit.INSTANCE;
        r9.addView(r0, r5);
        r1 = r1 + 1;
        goto L6
    L10:
        r4 = -2628363;
        goto L11
    }

    public final boolean L2(String r6, String r7, Function1<? super b5, b5> r8) {
        List<b5> r0 = this.j.get(r6);
        if (r0 != null) goto L5;
        return false;
    L5:
        Iterator<b5> r2 = r0.iterator();
        int r3 = 0;
    L7:
        if (r2.hasNext() == false) goto L12;
        if (Intrinsics.areEqual(r2.next().a, r7) == true) goto L13;
        r3 = r3 + 1;
    L13:
        if (r3 >= 0) goto L15;
        return false;
    L15:
        b5 r9 = (b5) ListProtector.get(r0, r3);
        b5 r10 = (b5) r8.invoke(r9);
        if (Intrinsics.areEqual(r10, r9) == false) goto L18;
        return false;
    L18:
        List r11 = CollectionsKt.toMutableList(r0);
        ListProtector.set(r11, r3, r10);
        List<b5> r12 = CollectionsKt.toList(r11);
        this.j.put(r6, r12);
        if (Intrinsics.areEqual(this.D, r6) == false) goto L27;
        CocreationFeedbackPanelFragment r13 = M1();
        if (r13 == null) goto L28;
        Intrinsics.checkNotNullParameter(r12, "next");
        r13.f = CollectionsKt.toList(r12);
        r13.aa0();
        r13.Z90();
        return true;
    L28:
        return true;
    L27:
        return true;
    L12:
        r3 = -1;
        goto L13
    }

    public final void N2(com.obric.assistant.cocreationreview.a r41, e5 r42, s5 r43) {
        String r2 = r41.a();
        if (this.m.contains(r2) == true) goto L5;
        return;
    L5:
        List<b5> r0 = this.j.get(r2);
        if (r0 != null) goto L8;
        r0 = CollectionsKt.emptyList();
    L8:
        List<b5> r1 = r0;
        if ((r1 instanceof Collection) == true) goto L11;
    L13:
        Iterator<T> r3 = r1.iterator();
    L15:
        if (r3.hasNext() == false) goto L22;
        if (((b5) r3.next()).h != FeedbackMediaUploadState.UPLOADING) goto L19;
        boolean r4 = true;
    L20:
        if (r4 == false) goto L15;
        boolean r5 = true;
    L23:
        if (r5 == false) goto L25;
        return;
    L25:
        Iterator<T> r6 = r1.iterator();
    L27:
        if (r6.hasNext() == false) goto L43;
        Object r7 = r6.next();
        b5 r8 = (b5) r7;
        if (r8.h != FeedbackMediaUploadState.UPLOADED) goto L40;
        String r9 = r8.k;
        if (r9 != null) goto L33;
    L36:
        boolean r10 = true;
    L37:
        if (r10 == true) goto L40;
        boolean r11 = false;
    L41:
        if (r11 == false) goto L27;
    L44:
        b5 r12 = (b5) r7;
        if (r12 != null) goto L48;
        G2(r41, r42, r43);
        return;
    L48:
        String r13 = r2 + '-' + r12.a + '-' + UUID.randomUUID();
        Intrinsics.checkNotNullParameter(r13, "identifier");
        final b5 r14 = b5.a(r12, null, null, false, false, FeedbackMediaUploadState.UPLOADING, 0, r13, null, null, 127);
        if (L2(r2, r12.a, new s0(r14)) == true) goto L52;
        X1(r2, "媒体草稿已失效");
        return;
    L52:
        q r15 = this.l;
        h r16 = new h(this, r2, r12, r41, r42, r43);
        r15.getClass();
        Intrinsics.checkNotNullParameter(r14, "media");
        Intrinsics.checkNotNullParameter(r13, "identifier");
        Intrinsics.checkNotNullParameter(r16, "callback");
        if (r15.b.get() == true) goto L79;
        AtomicBoolean r17 = new AtomicBoolean(false);
        r15.c.put(r13, r17);
        Uri r22 = UriProtector.parse(r14.b);
        int r18 = s.a[r14.getType().ordinal()];
        if (r18 != 1) goto L58;
        String r19 = r13;
        int r20 = UplinkEntityType.EntityTypeImage.getValue();
        Image r21 = new Image(null, null, null, null, null, null, null, null, null, null, null, null, null, null, 16383, null);
        r21.identifier = r19;
        r21.localResPath = r14.b;
        r21.setCropped(Boolean.valueOf(r14.g));
        Pair[] r23 = new Pair[1];
        if (r14.f == false) goto L65;
        String r110 = "1";
    L66:
        r23[0] = TuplesKt.to("is_marked", r110);
        r21.ext = MapsKt.mutableMapOf(r23);
        UplinkFileEntity r111 = new UplinkFileEntity(Integer.valueOf(r20), new UplinkEntityContent(null, r21, 1, null), r19, null, null, null, null, null, null, false, r22, null, null, null, 15352, null);
    L67:
        ResourceCenter r24 = ResourceCenter.a;
        FlowResourceScene r25 = FlowResourceScene.O_ASSISTANT_FEEDBACK;
        r24.getClass();
        ResourceCenter.k(r19, r25);
        BuildersKt.launch$default(r15.a, null, null, new CocreationFeedbackMediaUploader$upload$1(r111, r15, r19, r17, r16, null), 3, null);
        return;
    L65:
        r110 = "0";
        goto L66
    L58:
        if (r18 != 2) goto L61;
        int r26 = UplinkEntityType.EntityTypeFile.getValue();
        r19 = r13;
        r111 = new UplinkFileEntity(Integer.valueOf(r26), new UplinkEntityContent(new UplinkFileInfo(r14.d, null, null, Integer.valueOf(FileType.FileTypeVideo.getValue()), null, null, null, null, r14.b, null, 758, null), null, 2, null), r19, null, null, null, null, null, null, false, r22, null, null, null, 15352, null);
        goto L67
    L61:
        throw new NoWhenBranchMatchedException();
    L79:
        return;
    L33:
        if (StringsKt.isBlank(r9) == true) goto L36;
        r10 = false;
    L40:
        r11 = true;
        goto L41
    L43:
        r7 = null;
        goto L44
    L19:
        r4 = false;
    L22:
        r5 = false;
        goto L23
    L11:
        if (r1.isEmpty() == false) goto L13;
        goto L13
    }

    public final ImageView Q1(final String r9, a5 r10, final Vote r11) {
        Vote r0 = Vote.DOWN;
        if (r11 != r0) goto L5;
        String r1 = "踩";
    L6:
        String r3 = r1;
        if (r11 != r0) goto L9;
        int r5 = -2076093;
    L10:
        UsageCardTemplateRenderer r2 = (UsageCardTemplateRenderer) this.g.getValue();
        if (r10.b != r11) goto L13;
        boolean r4 = true;
    L15:
        if (this.B != ReviewMode.HISTORY) goto L17;
    L19:
        boolean r6 = false;
    L20:
        boolean r7 = r4;
        return r2.g(r3, r7, r5, r6, new x2(this, r9, r11));
    L17:
        if (r10.e == true) goto L19;
        r6 = true;
        goto L20
    L13:
        r4 = false;
        goto L15
    L9:
        r5 = -14979842;
        goto L10
    L5:
        r1 = "赞";
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v2, types: [com.obric.assistant.cocreationreview.j2] */
    public final void l2(LinearLayout r17, final l5 r18, e r19) {
        r17.removeAllViews();
        this.p1.clear();
        if (r19 == null) goto L5;
        List<String> r2 = r19.b;
    L6:
        if (r2 != null) goto L9;
        r2 = CollectionsKt.emptyList();
    L9:
        if (r18 != null) goto L11;
    L39:
        c4.b(r17, c4.f(this, "先选择一个功能模板", 14.0f, -5721662, 0), 0, 0, 0, 6);
        return;
    L11:
        if (r2.isEmpty() == true) goto L39;
        LinearLayout r4 = c4.e(this);
        Iterator<T> r3 = r2.iterator();
        LinearLayout r6 = r4;
        int r5 = 0;
        int r7 = 0;
    L15:
        if (r3.hasNext() == false) goto L36;
        Object r8 = r3.next();
        int r11 = r5 + 1;
        if (r5 >= 0) goto L19;
        CollectionsKt.throwIndexOverflow();
    L19:
        final String r12 = (String) r8;
        int r13 = r12.length() + 4;
        if (r5 > 0) goto L22;
    L24:
        boolean r9 = Intrinsics.areEqual(this.H, r12);
        int r10 = r18.e;
        final ?? r14 = new j2(this, r12, r18);
        Intrinsics.checkNotNullParameter(this, "<this>");
        Intrinsics.checkNotNullParameter(r12, "text");
        int r15 = -1;
        if (r9 == false) goto L27;
        int r16 = -1;
    L28:
        if (r9 == false) goto L30;
        r15 = r10;
    L30:
        TextView r110 = c4.f(this, r12, 12.0f, r16, 1);
        r110.setGravity(17);
        r110.setMinHeight(c4.c(this, 30));
        r110.setPadding(c4.c(this, 13), 0, c4.c(this, 13), 0);
        if (r9 == true) goto L34;
        r10 = -1973274;
    L34:
        r110.setBackground(c4.h(this, r15, 18, r10, 1));
        r110.setClickable(true);
        r110.setOnClickListener(new b4(r14));
        this.p1.put(r12, r110);
        LinearLayout.LayoutParams r20 = new LinearLayout.LayoutParams(-2, c4.c(this, 32));
        r20.setMargins(0, 0, c4.c(this, 8), 0);
        Unit r21 = Unit.INSTANCE;
        r6.addView(r110, r20);
        r7 = r7 + r13;
        r5 = r11;
        goto L15
    L27:
        r16 = -9735552;
        goto L28
    L22:
        if ((r7 + r13) <= 26) goto L24;
        c4.b(r17, r6, 0, 0, c4.c(this, 8), 6);
        r6 = c4.e(this);
        r7 = 0;
        goto L24
    L36:
        if (r6.getChildCount() <= 0) goto L44;
        c4.b(r17, r6, 0, 0, 0, 14);
        return;
    L44:
        return;
    L5:
        r2 = null;
        goto L6
    }

    public final void K2(String r12, boolean r13, String r14, Function1<? super a5, a5> r15) {
        a5 r0 = this.i.get(r12);
        if (r0 != null) goto L7;
        r0 = (a5) ((LinkedHashMap) L1()).get(r12);
        if (r0 != null) goto L7;
        r0 = new a5(r12, null, null, null, false, 0, null, 254);
    L7:
        a5 r16 = (a5) r15.invoke(r0);
        this.i.put(r12, r16);
        int r1 = s3.a;
        s3.a("draft.update", "source=" + r14 + ", recordId=" + r12 + ", vote=" + r16.b + ", reasonCount=" + r16.c.size() + ", commentLength=" + r16.d.length() + ", completed=" + r16.e + ", renderAfter=" + r13 + ", drafts=" + this.i.size());
        if (r13 == false) goto L11;
        o2(false);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static FrameLayout j2(CocreationReviewActivity r2, View r3, int r4, int r5, int r6) {
        if ((r6 & 2) == 0) goto L6;
        r4 = 0;
    L6:
        if ((r6 & 4) == 0) goto L8;
        r5 = 0;
    L8:
        FrameLayout r7 = new FrameLayout(r2);
        r7.setPadding(c4.c(r2, 14), r4, c4.c(r2, 14), r5);
        r7.addView(r3, new FrameLayout.LayoutParams(-1, -2));
        return r7;
    }
}
