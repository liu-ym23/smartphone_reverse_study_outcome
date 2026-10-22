package com.obric.memorydata.memory.ui.settings;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.ContentObserver;
import android.provider.Settings;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.aiproactive.api.ProactiveShortcutCompletion;
import com.obric.aiproactive.api.ProactiveShortcutRequestResult;
import com.obric.aiproactive.api.ProactiveShortcutState;
import com.obric.memorydata.memory.AutoMemoryCollectionScheme;
import com.obric.memorydata.memory.AutoMemoryConfig;
import com.obric.memorydata.memory.lab.AILabPermissionRepository;
import com.obric.memorydata.memory.ui.list.MemoryListActivity;
import com.obric.memorydata.memory.ui.list.PendingPersonalInfoNotificationTask;
import com.obric.memorydata.memory.utils.PinShortcutRequestSupport;
import com.obric.memorydata.memory.utils.PinShortcutStartResult;
import com.obric.memorydata.memory.utils.PinShortcutSupersedeProvenance;
import com.obric.memorydata.memory.utils.PinnedShortcutState;
import com.obric.memorydata.memory.y;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.store.IStore;
import com.obric.memorydata.middleware.api.store.IStoreManager;
import com.obric.memorydata.middleware.api.store.StoreManager;
import com.obric.memorydata.plugin.R;
import com.obric.memorydata.recommend.RecommendApi;
import com.obric.memorydata.task.impl.TaskInfo;
import com.obric.memorydata.task.impl.TaskRequest;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.flow.ae;
import kotlinx.coroutines.flow.ar;
import kotlinx.coroutines.flow.at;
import net.zetetic.database.sqlcipher.SQLiteDatabase;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0011\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b%\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 ¹\u00012\u00020\u0001:\u0006¹\u0001º\u0001»\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0016\u001a\u00020\u0017J\u0016\u00102\u001a\u00020\u00172\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u00020\u0011J\u0006\u0010<\u001a\u00020\u0017J\u000e\u0010=\u001a\b\u0012\u0004\u0012\u00020)07H\u0002J\u000e\u0010U\u001a\u00020\u00172\u0006\u0010V\u001a\u00020\u0011J\u0006\u0010W\u001a\u00020\u0017J\b\u0010X\u001a\u00020\u0011H\u0002J\b\u0010Y\u001a\u00020\u0011H\u0002J\b\u0010Z\u001a\u00020\u0011H\u0002J\u0016\u0010[\u001a\u00020\u00112\u0006\u0010\\\u001a\u00020]2\u0006\u0010^\u001a\u00020\u0011J\u0006\u0010_\u001a\u00020\u0011J\u0006\u0010`\u001a\u00020\u0017J\u000e\u0010a\u001a\u00020b2\u0006\u0010\\\u001a\u00020]J\u000e\u0010c\u001a\u00020d2\u0006\u0010\\\u001a\u00020]J\u000e\u0010e\u001a\u00020f2\u0006\u0010g\u001a\u00020hJ\u0018\u0010i\u001a\u00020\u00172\u0006\u0010g\u001a\u00020hH\u0080@¢\u0006\u0004\bj\u0010kJ\u0018\u0010l\u001a\u00020\u00112\u0006\u0010g\u001a\u00020h2\u0006\u0010m\u001a\u00020)H\u0002J\u0010\u0010n\u001a\u00020\u00172\u0006\u0010g\u001a\u00020hH\u0002J\u0016\u0010o\u001a\u00020p2\u0006\u0010\\\u001a\u00020]2\u0006\u0010q\u001a\u00020rJ\u000e\u0010s\u001a\u00020d2\u0006\u0010\\\u001a\u00020]J\u000e\u0010t\u001a\u00020\u00112\u0006\u0010\\\u001a\u00020]J\u0016\u0010u\u001a\u00020d2\u0006\u0010\\\u001a\u00020]2\u0006\u0010v\u001a\u00020\u0011J\u000e\u0010w\u001a\u00020d2\u0006\u0010\\\u001a\u00020]J\u0018\u0010x\u001a\u00020d2\u0006\u0010\\\u001a\u00020]2\b\b\u0002\u0010y\u001a\u00020\u0011J\u0010\u0010z\u001a\u00020{2\u0006\u0010\\\u001a\u00020]H\u0002J\u0010\u0010|\u001a\u00020}2\u0006\u0010\\\u001a\u00020]H\u0002J\b\u0010~\u001a\u00020\u0011H\u0002J\u0016\u0010\u007f\u001a\u00020\u00172\u0006\u0010\\\u001a\u00020]2\u0006\u0010^\u001a\u00020\u0011J\u000f\u0010\u0080\u0001\u001a\u00020\u00172\u0006\u0010\\\u001a\u00020]J\u0011\u0010\u0081\u0001\u001a\u00020b2\u0006\u0010\\\u001a\u00020]H\u0002J\u000f\u0010\u0082\u0001\u001a\u00020\u00172\u0006\u0010\\\u001a\u00020]J\u000f\u0010\u0083\u0001\u001a\u00020\u00172\u0006\u0010V\u001a\u00020\u0011J\u0011\u0010\u0084\u0001\u001a\u00020\u00172\b\b\u0002\u0010\u0019\u001a\u00020\u0011J\u000e\u0010\u0085\u0001\u001a\t\u0012\u0004\u0012\u00020)0\u0086\u0001J\u000e\u0010\u0087\u0001\u001a\t\u0012\u0004\u0012\u00020)0\u0086\u0001J\u0007\u0010\u0088\u0001\u001a\u00020\u0011J\u0007\u0010\u0089\u0001\u001a\u00020\u0017J\u0019\u0010\u008a\u0001\u001a\u00020\u00172\u0007\u0010\u008b\u0001\u001a\u00020\u00112\u0007\u0010\u008c\u0001\u001a\u00020\u0011J\u0016\u0010\u008d\u0001\u001a\u00020\u00172\r\u0010\u008e\u0001\u001a\b\u0012\u0004\u0012\u00020)07J\r\u0010\u008f\u0001\u001a\b\u0012\u0004\u0012\u00020)07J\u0007\u0010\u0090\u0001\u001a\u00020\u0017J\u0010\u0010\u0091\u0001\u001a\u00020\u00172\u0007\u0010\u0092\u0001\u001a\u00020\u0011J\u0010\u0010\u0093\u0001\u001a\u00020\u00172\u0007\u0010\u0094\u0001\u001a\u00020\u0011J\u0010\u0010\u0095\u0001\u001a\u00020\u00172\u0007\u0010\u0094\u0001\u001a\u00020\u0011J\u0010\u0010\u0096\u0001\u001a\u00020\u00172\u0007\u0010\u0094\u0001\u001a\u00020\u0011J\u0010\u0010\u0097\u0001\u001a\u00020\u00172\u0007\u0010\u0094\u0001\u001a\u00020\u0011J\u0006\u0010O\u001a\u00020\u0011J\u0006\u0010R\u001a\u00020\u0011J\u0010\u0010\u0098\u0001\u001a\u00020\u00172\u0007\u0010\u0094\u0001\u001a\u00020\u0011J\u0010\u0010\u0099\u0001\u001a\u00020\u00172\u0007\u0010\u0094\u0001\u001a\u00020\u0011J\u0007\u0010\u009a\u0001\u001a\u00020\u0017J\u0007\u0010\u009b\u0001\u001a\u00020\u0017J\u0007\u0010\u009c\u0001\u001a\u00020\u0017J\u0018\u0010\u009d\u0001\u001a\u00020\u00172\u0006\u0010\\\u001a\u00020]2\u0007\u0010\u009e\u0001\u001a\u00020\u0011J\t\u0010\u009f\u0001\u001a\u00020\u0011H\u0002J\t\u0010 \u0001\u001a\u00020\u0011H\u0002J\t\u0010¡\u0001\u001a\u00020\u0011H\u0002J\u0007\u0010¢\u0001\u001a\u00020\u0017J\u0012\u0010£\u0001\u001a\u00020\u00172\u0007\u0010¤\u0001\u001a\u00020\u0011H\u0002J\t\u0010¥\u0001\u001a\u00020\u0011H\u0002J\n\u0010¦\u0001\u001a\u00030§\u0001H\u0002J\u0013\u0010¨\u0001\u001a\u00020\u00172\b\u0010©\u0001\u001a\u00030§\u0001H\u0002J\u000e\u0010ª\u0001\u001a\u00020\u0011*\u00030§\u0001H\u0002J\f\u0010«\u0001\u001a\u0005\u0018\u00010¬\u0001H\u0002J\u0012\u0010\u00ad\u0001\u001a\u00020\u00112\u0007\u0010®\u0001\u001a\u00020)H\u0002J\u000b\u0010¯\u0001\u001a\u0004\u0018\u00010\u0005H\u0002J\u0010\u0010°\u0001\u001a\u00020\u00172\u0007\u0010\u0094\u0001\u001a\u00020\u0011J\u0007\u0010±\u0001\u001a\u00020\u0011J\u000f\u0010²\u0001\u001a\u00020\u00172\u0006\u0010V\u001a\u00020\u0011J\u0010\u0010³\u0001\u001a\u00020\u00172\u0007\u0010´\u0001\u001a\u00020)J\u0007\u0010µ\u0001\u001a\u00020\u0011J\u0010\u0010¶\u0001\u001a\u00020\u00172\u0007\u0010\u0094\u0001\u001a\u00020\u0011J\u0007\u0010·\u0001\u001a\u00020\u0017J\u000f\u0010¸\u0001\u001a\u00020\u00112\u0006\u0010\\\u001a\u00020]R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0015R\u0011\u0010\u001b\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0015R\u0014\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0015R\u0014\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0015R\u0014\u0010(\u001a\b\u0012\u0004\u0012\u00020)0\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010*\u001a\b\u0012\u0004\u0012\u00020)0\u0013¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u0015R\u0014\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u0015R\u0014\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u00100\u001a\b\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u0015R'\u00106\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020)070\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b8\u00109R'\u0010>\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020)070\u00138FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b?\u0010;\u001a\u0004\b=\u0010\u0015R\u000e\u0010@\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\b\n\u0000\u001a\u0004\bC\u0010\u0015R\u0014\u0010D\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010E\u001a\b\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\b\n\u0000\u001a\u0004\bF\u0010\u0015R\u0014\u0010G\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\b\n\u0000\u001a\u0004\bI\u0010\u0015R\u0014\u0010J\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010K\u001a\b\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\b\n\u0000\u001a\u0004\bL\u0010\u0015R\u0014\u0010M\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010N\u001a\b\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\b\n\u0000\u001a\u0004\bO\u0010\u0015R\u0014\u0010P\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\b\n\u0000\u001a\u0004\bR\u0010\u0015R\u0017\u0010S\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\b\n\u0000\u001a\u0004\bT\u00109¨\u0006¼\u0001"}, d2 = {"Lcom/obric/memorydata/memory/ui/settings/MemorySettingsStore;", "", "<init>", "()V", "memoryStore", "Lcom/obric/memorydata/middleware/api/store/IStore;", "recommendStore", "proactiveShortcutOptOutStore", "Lcom/obric/memorydata/memory/ui/settings/ProactiveShortcutOptOutStore;", "proactiveShortcutOptInRequests", "Lcom/obric/memorydata/memory/ui/settings/ProactiveShortcutOptInRequests;", "proactiveShortcutCheckMutex", "Lkotlinx/coroutines/sync/Mutex;", "proactiveShortcutDefaultTrigger", "Lcom/obric/memorydata/memory/ui/settings/ProactiveShortcutDefaultTrigger;", "_smartMemoryState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "smartMemoryState", "Lkotlinx/coroutines/flow/StateFlow;", "getSmartMemoryState", "()Lkotlinx/coroutines/flow/StateFlow;", "clearMemorySwitchDailyReportStateForDebug", "", "_hasConfirmed", "hasConfirmed", "getHasConfirmed", "needWriteA11y", "getNeedWriteA11y", "()Z", "enterpriseAccount", "_audioMemoryConfigured", "audioMemoryConfigured", "getAudioMemoryConfigured", "_audioMemoryVisible", "audioMemoryVisible", "getAudioMemoryVisible", "_audioMemoryEnable", "audioMemoryEnable", "getAudioMemoryEnable", "_defaultMapPackageName", "", "defaultMapPackageName", "getDefaultMapPackageName", "_aiVolumeShortcutConsentAccepted", "aiVolumeShortcutConsentAccepted", "getAiVolumeShortcutConsentAccepted", "_gestureShortcutConsentAccepted", "gestureShortcutConsentAccepted", "getGestureShortcutConsentAccepted", "setShortcutConsentAccepted", "type", "Lcom/obric/memorydata/memory/ui/settings/ShortcutMemoryConsentType;", "accepted", "_enableApps", "", "get_enableApps", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "_enableApps$delegate", "Lkotlin/Lazy;", "saveInitialDisableAppsIfNeeded", "getEnableApps", "enableApps", "enableApps$delegate", "experienceEnabled", "_joinInUXP", "joinInUXP", "getJoinInUXP", "_screenMemoryShown", "screenMemoryShown", "getScreenMemoryShown", "_voiceMemoryShown", "voiceMemoryShown", "getVoiceMemoryShown", "_autoMemoryShown", "autoMemoryShown", "getAutoMemoryShown", "_screenObservationConfigured", "screenObservationConfigured", "getScreenObservationConfigured", "_contextAwarenessConfigured", "contextAwarenessConfigured", "getContextAwarenessConfigured", "launcherIconEnabled", "getLauncherIconEnabled", "saveLauncherIconEnabled", "enabled", "updateAutoMemoryState", "isScreenMemoryShown", "isVoiceMemoryShown", "isAutoMemoryEffectiveEnabled", "enableStartupActivity", "context", "Landroid/content/Context;", "enable", "isMemoryShortcutAutoGuideShown", "markMemoryShortcutAutoGuideShown", "createProactiveStartupIntent", "Landroid/content/Intent;", "queryProactiveShortcutState", "Lcom/obric/aiproactive/api/ProactiveShortcutState;", "requestProactiveShortcutByUser", "Lcom/obric/aiproactive/api/ProactiveShortcutRequestResult;", "activity", "Landroid/app/Activity;", "initializeProactiveShortcutOnHome", "initializeProactiveShortcutOnHome$memory_obricRelease", "(Landroid/app/Activity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "canInitializeProactiveShortcut", "uid", "initializeProactiveShortcutOnce", "resolveProactiveShortcutPinResult", "Lcom/obric/aiproactive/api/ProactiveShortcutCompletion;", PendingPersonalInfoNotificationTask.KEY_GENERATION, "", "disableProactiveShortcutByUser", "isProactiveShortcutResidualOnLauncher", "reconcileSupersededProactiveShortcut", "persistUserOptOutIfInactive", "disableProactiveShortcutByPolicy", "recoverProactiveShortcutByPolicy", "featureEnabled", "proactiveShortcutCoordinator", "Lcom/obric/memorydata/memory/ui/settings/ProactiveShortcutCoordinator;", "enableExistingProactiveShortcut", "Lcom/obric/memorydata/memory/utils/PinnedShortcutState;", "isAiProactiveShortcutPolicyEnabled", "enableAutoMemoryShortcut", "enableShortcuts", "buildAutoMemoryShortcutIntent", "refreshPinnedShortcuts", "saveSmartMemoryEnabled", "saveHasConfirmed", "getAutoMemoryProSlmEnableDid", "", "getAutoMemoryProSlmEnableUid", "isAutoMemoryProSlmEnabled", "initA11ySwitch", "reconcileAutoMemoryApps", "useInApp", "accessibilityEnabled", "saveEnabledApps", "apps", "disableAppsRequiringAccessibility", "updateEnableApps", "saveJoinInUXP", "join", "saveScreenMemoryShown", "state", "saveVoiceMemoryShown", "saveAutoMemoryShown", "saveRecommendMemoryEnabled", "saveScreenObservationConfigured", "saveAudioMemoryConfigured", "refreshPersonalMemoryConfiguredState", "markContextAwarenessConfigured", "clearContextAwarenessConfiguredSnapshotForLogout", "syncEnterpriseAccountState", "isEnterprise", "isEnterpriseAccount", "isAudioMemoryEnabled", "readPersistedAudioMemoryEnabled", "refreshMemorySwitchEnabledStates", "refreshAudioMemoryEnabled", "reportSwitchChanged", "readAudioMemoryConfigured", "readPersonalMemoryConfiguredSnapshot", "Lcom/obric/memorydata/memory/ui/settings/MemorySettingsStore$PersonalMemoryConfiguredSnapshot;", "publishPersonalMemoryConfiguredSnapshot", "snapshot", "contextConfiguredForCurrentAccount", "getPersonalStoreSnapshotOrNull", "Lcom/obric/memorydata/memory/ui/settings/MemorySettingsStore$PersonalStoreSnapshot;", "isCurrentAccount", "userId", "getPersonalStoreOrNull", "saveAudioMemoryEnabled", "isInAppEvidenceArchiveEnabled", "saveInAppEvidenceArchiveEnabled", "saveDefaultMapPackageName", ObricMemoryConstants.KEY_PACKAGE_NAME, "getLauncherOldIconEnabled", "saveLauncherOldIconEnabled", "clearLauncherOldIconEnabled", "oldStartupActivityEnabled", "Companion", "PersonalStoreSnapshot", "PersonalMemoryConfiguredSnapshot", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class l {
    private static final Lazy<l> P = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f11479a = null;
    private final Lazy A;
    private final boolean B;
    private final ae<Boolean> C;
    private final ar<Boolean> D;
    private final ae<Boolean> E;
    private final ar<Boolean> F;
    private final ae<Boolean> G;
    private final ar<Boolean> H;
    private final ae<Boolean> I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private final ar<Boolean> f11480J;
    private final ae<Boolean> K;
    private final ar<Boolean> L;
    private final ae<Boolean> M;
    private final ar<Boolean> N;
    private final ae<Boolean> O;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final IStore f11481b;
    private final IStore c;
    private final s d;
    private final r e;
    private final kotlinx.coroutines.sync.a f;
    private final p g;
    private final ae<Boolean> h;
    private final ar<Boolean> i;
    private final ae<Boolean> j;
    private final ar<Boolean> k;
    private final boolean l;
    private volatile boolean m;
    private final ae<Boolean> n;
    private final ar<Boolean> o;
    private final ae<Boolean> p;
    private final ar<Boolean> q;
    private final ae<Boolean> r;
    private final ar<Boolean> s;
    private final ae<String> t;
    private final ar<String> u;
    private final ae<Boolean> v;
    private final ar<Boolean> w;
    private final ae<Boolean> x;
    private final ar<Boolean> y;
    private final Lazy z;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/obric/memorydata/memory/ui/settings/MemorySettingsStore$Companion;", "", "<init>", "()V", "TAG", "", "instance", "Lcom/obric/memorydata/memory/ui/settings/MemorySettingsStore;", "getInstance", "()Lcom/obric/memorydata/memory/ui/settings/MemorySettingsStore;", "instance$delegate", "Lkotlin/Lazy;", "AUTO_MEMORY_STARTUP_ALIAS", "STARTUP_ALIAS", "STARTUP", "MEMORY_SHORTCUT_ID", "MEMORY_SHORTCUT_AUTO_GUIDE_SHOWN", "PROACTIVE_STARTUP", "PROACTIVE_SHORTCUT_ID", "AUTO_MEMORY_STARTUP", "AUTO_MEMORY_SHORTCUT_ID", "MEMORY_ENABLE", "SMART_MEMORY_HAS_CONFIRMED", "SMART_MEMORY_NEED_WRITE_A11Y", "RECOMMEND_MEMORY_ENABLED", "AUDIO_MEMORY_CONFIGURED", "ENTERPRISE_DISABLED_SHORTCUTS", "PROACTIVE_SHORTCUT_USER_DISABLED", "PROACTIVE_SHORTCUT_DEFAULT_TRIGGERED", "DEFAULT_MAP_PKG", "IN_APP_EVIDENCE_ARCHIVE_ENABLED", "AUTO_MEMORY_COLLECTION_SCHEME", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final l a() {
            return (l) ZeusTransformUtils.preCheckCast(l.E().getValue(), l.class, "com.obric.memorydata.plugin");
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0003\b\u0082\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB)\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J3\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006\u001b"}, d2 = {"Lcom/obric/memorydata/memory/ui/settings/MemorySettingsStore$PersonalMemoryConfiguredSnapshot;", "", "userId", "", "screenConfigured", "", "audioConfigured", "contextConfigured", "<init>", "(Ljava/lang/String;ZZZ)V", "getUserId", "()Ljava/lang/String;", "getScreenConfigured", "()Z", "getAudioConfigured", "getContextConfigured", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f11485a = null;
        private static final b f = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f11486b;
        private final boolean c;
        private final boolean d;
        private final boolean e;

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/memory/ui/settings/MemorySettingsStore$PersonalMemoryConfiguredSnapshot$Companion;", "", "<init>", "()V", "EMPTY", "Lcom/obric/memorydata/memory/ui/settings/MemorySettingsStore$PersonalMemoryConfiguredSnapshot;", "getEMPTY", "()Lcom/obric/memorydata/memory/ui/settings/MemorySettingsStore$PersonalMemoryConfiguredSnapshot;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker r1) {
                this();
            }

            public final b a() {
                return b.e();
            }
        }

        static {
            f11485a = new a(null);
            f = new b(null, false, false, false);
        }

        public b(String r1, boolean r2, boolean r3, boolean r4) {
            this.f11486b = r1;
            this.c = r2;
            this.d = r3;
            this.e = r4;
        }

        public static final /* synthetic */ b e() {
            return f;
        }

        public final String a() {
            return this.f11486b;
        }

        public final boolean b() {
            return this.c;
        }

        public final boolean c() {
            return this.d;
        }

        public final boolean d() {
            return this.e;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f11486b, r6.f11486b) == true) goto L12;
            return false;
        L12:
            if (this.c == r6.c) goto L15;
            return false;
        L15:
            if (this.d == r6.d) goto L18;
            return false;
        L18:
            if (this.e == r6.e) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            String r0 = this.f11486b;
            if (r0 != null) goto L5;
            int r1 = 0;
        L7:
            return (((((r1 * 31) + Boolean.hashCode(this.c)) * 31) + Boolean.hashCode(this.d)) * 31) + Boolean.hashCode(this.e);
        L5:
            r1 = r0.hashCode();
            goto L7
        }

        public String toString() {
            return "PersonalMemoryConfiguredSnapshot(userId=" + this.f11486b + ", screenConfigured=" + this.c + ", audioConfigured=" + this.d + ", contextConfigured=" + this.e + ')';
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/obric/memorydata/memory/ui/settings/MemorySettingsStore$PersonalStoreSnapshot;", "", "userId", "", "store", "Lcom/obric/memorydata/middleware/api/store/IStore;", "<init>", "(Ljava/lang/String;Lcom/obric/memorydata/middleware/api/store/IStore;)V", "getUserId", "()Ljava/lang/String;", "getStore", "()Lcom/obric/memorydata/middleware/api/store/IStore;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f11487a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final IStore f11488b;

        public c(String r3, IStore r4) {
            IStore r5 = (IStore) ZeusTransformUtils.wrapperContextForParams(r4, IStore.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "userId");
            Intrinsics.checkNotNullParameter(r5, "store");
            this.f11487a = r3;
            this.f11488b = r5;
        }

        public final String a() {
            return this.f11487a;
        }

        public final IStore b() {
            return this.f11488b;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
            return false;
        L8:
            c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f11487a, r6.f11487a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f11488b, r6.f11488b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f11487a.hashCode() * 31) + this.f11488b.hashCode();
        }

        public String toString() {
            return "PersonalStoreSnapshot(userId=" + this.f11487a + ", store=" + this.f11488b + ')';
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f11489a = null;

        static {
            int[] r0 = new int[ShortcutMemoryConsentType.values().length];
            r0[ShortcutMemoryConsentType.AI_VOLUME.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[ShortcutMemoryConsentType.GESTURE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f11489a = r0;
        }
    }

    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001¨\u0006\u0003¸\u0006\u0000"}, d2 = {"com/obric/memorydata/utils/GsonExtKt$toListObj$1", "Lcom/google/gson/reflect/TypeToken;", "", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class e extends TypeToken<List<? extends String>> {
        public e() {
        }
    }

    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001¨\u0006\u0003¸\u0006\u0000"}, d2 = {"com/obric/memorydata/utils/GsonExtKt$toListObj$1", "Lcom/google/gson/reflect/TypeToken;", "", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class f extends TypeToken<List<? extends String>> {
        public f() {
        }
    }

    @Metadata(d1 = {"\u0000=\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J0\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nH\u0016J*\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0018\u0010\u0011\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u0012\u0012\u0004\u0012\u00020\f0\nH\u0016J\b\u0010\u0013\u001a\u00020\fH\u0016¨\u0006\u0014"}, d2 = {"com/obric/memorydata/memory/ui/settings/MemorySettingsStore$proactiveShortcutCoordinator$2", "Lcom/obric/memorydata/memory/ui/settings/ProactiveShortcutGateway;", "queryPinnedState", "Lcom/obric/memorydata/memory/utils/PinnedShortcutState;", "enableExistingAndQuery", "queryPinRequestSupport", "Lcom/obric/memorydata/memory/utils/PinShortcutRequestSupport;", "requestNewPin", "Lcom/obric/memorydata/memory/utils/PinShortcutStartResult;", "onGenerationStarted", "Lkotlin/Function1;", "", "", "onGenerationAbandoned", "supersedePinRequests", "provenance", "Lcom/obric/memorydata/memory/utils/PinShortcutSupersedeProvenance;", "onGenerationsSuperseded", "", "disable", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class g implements q {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f11490a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ l f11491b;

        g(Context r3, l r4) {
            this.f11490a = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
            this.f11491b = r4;
        }

        @Override // com.obric.memorydata.memory.ui.settings.q
        public PinShortcutStartResult a(Function1<? super Long, Unit> r11, Function1<? super Long, Unit> r12) {
            Function1<? super Long, Unit> r8 = (Function1) ZeusTransformUtils.wrapperContextForParams(r11, Function1.class, "com.obric.memorydata.plugin");
            Function1<? super Long, Unit> r9 = (Function1) ZeusTransformUtils.wrapperContextForParams(r12, Function1.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r8, "onGenerationStarted");
            Intrinsics.checkNotNullParameter(r9, "onGenerationAbandoned");
            com.obric.memorydata.memory.utils.m r2 = com.obric.memorydata.memory.utils.m.f11550a;
            Context r3 = this.f11490a;
            String r5 = r3.getString(ZeusTransformUtils.mapRes(R.string.memory_settings_ai_proactive_agent_title, TypedValues.Custom.S_STRING, "memory_settings_ai_proactive_agent_title"));
            Intrinsics.checkNotNullExpressionValue(r5, "getString(...)");
            return r2.a(r3, "proactive_home_shortcut", r5, ZeusTransformUtils.mapRes(R.drawable.host_ic_rectangle_ai_proactive, "drawable", "host_ic_rectangle_ai_proactive"), this.f11491b.a(this.f11490a), r8, r9);
        }

        @Override // com.obric.memorydata.memory.ui.settings.q
        public PinnedShortcutState a() {
            return com.obric.memorydata.memory.utils.m.f11550a.a(this.f11490a, "proactive_home_shortcut");
        }

        @Override // com.obric.memorydata.memory.ui.settings.q
        public void a(PinShortcutSupersedeProvenance r2, Function1<? super Set<Long>, Unit> r3) {
            Function1<? super Set<Long>, Unit> r1 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r2, "provenance");
            Intrinsics.checkNotNullParameter(r1, "onGenerationsSuperseded");
            com.obric.memorydata.memory.utils.m.f11550a.a("proactive_home_shortcut", r2, r1);
        }

        @Override // com.obric.memorydata.memory.ui.settings.q
        public PinnedShortcutState b() {
            return l.a(this.f11491b, this.f11490a);
        }

        @Override // com.obric.memorydata.memory.ui.settings.q
        public PinShortcutRequestSupport c() {
            return com.obric.memorydata.memory.utils.m.f11550a.a(this.f11490a);
        }

        @Override // com.obric.memorydata.memory.ui.settings.q
        public void d() {
            com.obric.memorydata.memory.utils.m.f11550a.b(this.f11490a, "proactive_home_shortcut");
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/obric/memorydata/memory/ui/settings/MemorySettingsStore$updateAutoMemoryState$1", "Lcom/obric/memorydata/task/scheduler/OnTaskInfoCallBack;", "onChanged", "", "taskInfo", "Lcom/obric/memorydata/task/impl/TaskInfo;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class h implements com.obric.memorydata.task.scheduler.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ l f11492a;

        h(l r1) {
            this.f11492a = r1;
        }

        @Override // com.obric.memorydata.task.scheduler.c
        public void a(TaskInfo r3) {
            Intrinsics.checkNotNullParameter(r3, "taskInfo");
            if (r3.c() != TaskInfo.State.SUCCEEDED) goto L6;
        L4:
            l r2 = this.f11492a;
            r2.f(l.a(r2));
            return;
        L6:
            if (r3.c() == TaskInfo.State.FAILED) goto L4;
            if (r3.c() == TaskInfo.State.TIMEOUT) goto L4;
        }
    }

    static {
        f11479a = new a(null);
        P = LazyKt.lazy($$Lambda$l$eUdD36PJL8lFfz72SednnuThNYY.INSTANCE);
    }

    private l() {
        IStore r0 = IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null);
        this.f11481b = r0;
        IStore r1 = IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), "recommend_store", 0, 2, null);
        this.c = r1;
        this.d = new s(new $$Lambda$l$GE2xaOPWFGrMCI5NP1ZidYm6gs(this), new $$Lambda$l$Hz4u_gw484fnop4fW0ERTNQ4wdk(this));
        boolean r6 = true;
        this.e = new r(0, 1 == true ? 1 : 0, null);
        this.f = kotlinx.coroutines.sync.c.a(false, 1, null);
        this.g = new p(new $$Lambda$l$3ujtfQ0hopMOdhtexTMKFPGETW0(this), new $$Lambda$l$nexx7Tli2l_xXsWUTIGO7EapTv4(this));
        if (Settings.System.getInt(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getContentResolver(), "smart_memory_enabled", 0) != 1) goto L5;
        boolean r4 = true;
    L6:
        ae<Boolean> r5 = at.a(Boolean.valueOf(r4));
        this.h = r5;
        this.i = kotlinx.coroutines.flow.k.a(r5);
        ae<Boolean> r7 = at.a(Boolean.valueOf(r0.getBoolean("smart_memory_has_confirmed", false)));
        this.j = r7;
        this.k = kotlinx.coroutines.flow.k.a(r7);
        this.l = r0.getBoolean("smart_memory_need_write_a11y", true);
        this.m = UserSettings.INSTANCE.isEnterpriseAccount();
        ae<Boolean> r8 = at.a(Boolean.valueOf(O()));
        this.n = r8;
        this.o = kotlinx.coroutines.flow.k.a(r8);
        if (((Boolean) ZeusTransformUtils.preCheckCast(r8.c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L9;
    L11:
        boolean r9 = false;
    L12:
        ae<Boolean> r10 = at.a(Boolean.valueOf(r9));
        this.p = r10;
        this.q = kotlinx.coroutines.flow.k.a(r10);
        ae<Boolean> r11 = at.a(Boolean.valueOf(M()));
        this.r = r11;
        this.s = kotlinx.coroutines.flow.k.a(r11);
        ae<String> r12 = at.a(r0.getString("defaultMapPackageName", ""));
        this.t = r12;
        this.u = kotlinx.coroutines.flow.k.a(r12);
        ae<Boolean> r13 = at.a(Boolean.valueOf(r0.getBoolean("ai_volume_shortcut_consent_accepted", false)));
        this.v = r13;
        this.w = kotlinx.coroutines.flow.k.a(r13);
        ae<Boolean> r14 = at.a(Boolean.valueOf(r0.getBoolean("gesture_shortcut_consent_accepted", false)));
        this.x = r14;
        this.y = kotlinx.coroutines.flow.k.a(r14);
        final ContentResolver r15 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getContentResolver();
        ZeusProviderTransform.registerContentObserver(r15, Settings.System.getUriFor("smart_memory_enabled"), false, (ContentObserver) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this, r15), ContentObserver.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        ZeusProviderTransform.registerContentObserver(r15, Settings.Global.getUriFor("recorder_always_on_enable"), false, (ContentObserver) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this), ContentObserver.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        this.z = LazyKt.lazy(new $$Lambda$l$X73lkEsGrFVWNarCYOlb6gpKyRc(this));
        this.A = LazyKt.lazy(new $$Lambda$l$qjakg3mmEjPZRj4veMjgFEProa4(this));
        boolean r2 = r1.getBoolean("experience_enabled", false);
        this.B = r2;
        ae<Boolean> r3 = at.a(Boolean.valueOf(r0.getBoolean("memory_user_experience", r2)));
        this.C = r3;
        this.D = kotlinx.coroutines.flow.k.a(r3);
        ae<Boolean> r16 = at.a(Boolean.valueOf(H()));
        this.E = r16;
        this.F = kotlinx.coroutines.flow.k.a(r16);
        if (I() == true) goto L15;
    L17:
        r6 = false;
    L18:
        ae<Boolean> r17 = at.a(Boolean.valueOf(r6));
        this.G = r17;
        this.H = kotlinx.coroutines.flow.k.a(r17);
        ae<Boolean> r18 = at.a(Boolean.valueOf(J()));
        this.I = r18;
        this.f11480J = kotlinx.coroutines.flow.k.a(r18);
        ae<Boolean> r19 = at.a(Boolean.valueOf(RecommendApi.INSTANCE.getScreenObservationConfigured()));
        this.K = r19;
        this.L = kotlinx.coroutines.flow.k.a(r19);
        ae<Boolean> r20 = at.a(Boolean.valueOf(b(P())));
        this.M = r20;
        this.N = kotlinx.coroutines.flow.k.a(r20);
        this.O = at.a(Boolean.valueOf(r0.getBoolean("launcher_icon_enabled", false)));
        return;
    L15:
        if (this.m == true) goto L17;
    L9:
        if (this.m == true) goto L11;
        r9 = true;
        goto L12
    L5:
        r4 = false;
        goto L6
    }

    public static final /* synthetic */ Lazy E() {
        return P;
    }

    private final ae<Set<String>> F() {
        return (ae) ZeusTransformUtils.preCheckCast(this.z.getValue(), ae.class, "com.obric.memorydata.plugin");
    }

    private final Set<String> G() {
        String r2 = null;
        if (this.f11481b.contains("smart_memory_disable_packages") == true) goto L5;
        Set<String> r14 = null;
    L6:
        IRunLog r4 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r0 = new StringBuilder().append("getStoreDisableApps: ");
        if (r14 == null) goto L9;
        r2 = CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.memorydata.plugin"), null, null, null, 0, null, null, 63, null);
    L9:
        IRunLog.a.a(r4, "MemorySettingsStore", r0.append(r2).toString(), false, 4, null);
        if (r14 != null) goto L22;
        Iterable r15 = (Iterable) ZeusTransformUtils.preCheckCast(y.f11594a.a().getSmartMemoryPackages(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r16 = r15.iterator();
    L13:
        if (r16.hasNext() == false) goto L17;
        Object r3 = r16.next();
        if (((AutoMemoryConfig.SmartMemoryPackage) ZeusTransformUtils.preCheckCast(r3, AutoMemoryConfig.SmartMemoryPackage.class, "com.obric.memorydata.plugin")).getEnable() == false) goto L13;
        r1.add(r3);
        goto L13
    L17:
        Iterable r17 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r5 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r17, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r18 = r17.iterator();
    L19:
        if (r18.hasNext() == false) goto L35;
        r5.add(((AutoMemoryConfig.SmartMemoryPackage) ZeusTransformUtils.preCheckCast(r18.next(), AutoMemoryConfig.SmartMemoryPackage.class, "com.obric.memorydata.plugin")).getPackageName());
        goto L19
    L35:
        return CollectionsKt.toSet((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"));
    L22:
        Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast(y.f11594a.a().getSmartMemoryPackages(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r7 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r8 = r6.iterator();
    L24:
        if (r8.hasNext() == false) goto L27;
        r7.add(((AutoMemoryConfig.SmartMemoryPackage) ZeusTransformUtils.preCheckCast(r8.next(), AutoMemoryConfig.SmartMemoryPackage.class, "com.obric.memorydata.plugin")).getPackageName());
        goto L24
    L27:
        return SetsKt.minus(CollectionsKt.toSet((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r7, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")), (Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.memorydata.plugin"));
    L5:
        r14 = this.f11481b.getStringSet("smart_memory_disable_packages", SetsKt.emptySet());
        goto L6
    }

    private final boolean H() {
        return AILabPermissionRepository.a(AILabPermissionRepository.f10236a, null, 1, null);
    }

    private final boolean I() {
        return AILabPermissionRepository.b(AILabPermissionRepository.f10236a, null, 1, null);
    }

    private final boolean J() {
        return AILabPermissionRepository.a(AILabPermissionRepository.f10236a, null, null, null, null, null, null, 63, null);
    }

    private final boolean K() {
        return AILabPermissionRepository.f10236a.a(AILabPermissionRepository.a(AILabPermissionRepository.f10236a, "ai_proactive_agent", null, 2, null));
    }

    private final boolean L() {
        if (this.m == false) goto L5;
    L8:
        return true;
    L5:
        if (UserSettings.INSTANCE.isEnterpriseAccount() == true) goto L8;
        return false;
    }

    private final boolean M() {
        return com.obric.memorydata.middleware.api.app.e.f11601a.a(N(), AILabPermissionRepository.b(AILabPermissionRepository.f10236a, null, 1, null));
    }

    private final boolean N() {
        if (Settings.Global.getInt(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getContentResolver(), "recorder_always_on_enable", 0) == 0) goto L6;
        return true;
    L6:
        return false;
    }

    private final boolean O() {
        return com.obric.memorydata.middleware.api.store.a.f11639a.a(R(), this.f11481b, "audio_memory_configured", false);
    }

    private final b P() {
        int r1 = 0;
    L4:
        if (r1 >= 2) goto L19;
        c r2 = Q();
        if (r2 == null) goto L8;
        boolean r3 = r2.b().getBoolean("screen_observation_configured", false);
        boolean r4 = com.obric.memorydata.middleware.api.store.a.f11639a.a(r2.b(), this.f11481b, "audio_memory_configured", false);
        boolean r5 = com.obric.memorydata.middleware.api.store.a.f11639a.a(r2.b(), this.f11481b, "context_awareness_configured", false);
        boolean r6 = com.obric.memorydata.memory.ui.settings.d.f11466a.a(r5, r3, r4, false);
        if (r5 == true) goto L14;
        if (r6 == false) goto L14;
        r6 = com.obric.memorydata.middleware.api.store.a.f11639a.a(r2.b(), "context_awareness_configured", true);
    L14:
        if (b(r2.a()) == true) goto L16;
        r1 = r1 + 1;
        goto L4
    L16:
        return new b(r2.a(), r3, r4, r6);
    L8:
        return b.f11485a.a();
    L19:
        return b.f11485a.a();
    }

    private final c Q() {
        int r1 = 0;
    L4:
        if (r1 >= 2) goto L26;
        String r3 = AppContext.INSTANCE.getUserId();
        if (AppContext.INSTANCE.isLogin() == false) goto L26;
        Long r4 = StringsKt.toLongOrNull(r3);
        boolean r5 = true;
        if (r4 != null) goto L10;
    L15:
        r5 = false;
    L16:
        if (r5 == false) goto L26;
        IStore r2 = StoreManager.INSTANCE.getPersonalStore();
        if (r2 == null) goto L25;
        if (b(r3) == false) goto L25;
        return new c(r3, r2);
    L25:
        r1 = r1 + 1;
        goto L4
    L10:
        if (((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.memorydata.plugin")).longValue() <= 0) goto L12;
        boolean r6 = true;
    L13:
        if (r6 != true) goto L15;
    L12:
        r6 = false;
    L26:
        return null;
    }

    private final IStore R() {
        c r0 = Q();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.b();
    }

    private static final l S() {
        return new l();
    }

    public static /* synthetic */ ProactiveShortcutState a(l r1, Context r2, boolean r3, int r4, Object r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if ((r4 & 2) == 0) goto L6;
        r3 = r1.K();
    L6:
        return r1.c(r6, r3);
    }

    public static final /* synthetic */ PinnedShortcutState a(l r2, Context r3) {
        return r2.i((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"));
    }

    private final void a(b r3) {
        if (r3.a() != null) goto L5;
    L7:
        r3 = b.f11485a.a();
    L8:
        this.K.b(Boolean.valueOf(r3.b()));
        this.n.b(Boolean.valueOf(r3.c()));
        ae<Boolean> r0 = this.p;
        if (r3.c() == true) goto L11;
    L13:
        boolean r1 = false;
    L14:
        r0.b(Boolean.valueOf(r1));
        this.M.b(Boolean.valueOf(r3.d()));
        return;
    L11:
        if (L() == true) goto L13;
        r1 = true;
        goto L14
    L5:
        if (b(r3.a()) == false) goto L7;
        goto L7
    }

    public static final /* synthetic */ void a(l r2, Activity r3) {
        r2.b((Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ void a(l r0, boolean r1) {
        r0.i(r1);
    }

    public static /* synthetic */ void a(l r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = true;
    L5:
        r0.b(r1);
    }

    private final boolean a(Activity r7, String r8) {
        Activity r9 = (Activity) ZeusTransformUtils.wrapperContextForParams(r7, Activity.class, "com.obric.memorydata.plugin");
        if (this.g.a() == true) goto L30;
        if (r9.isFinishing() == true) goto L30;
        if (r9.isDestroyed() == true) goto L30;
        if (r9.hasWindowFocus() == false) goto L30;
        Long r10 = StringsKt.toLongOrNull(r8);
        if (r10 != null) goto L13;
    L18:
        boolean r11 = false;
    L19:
        if (r11 == false) goto L30;
        if (Intrinsics.areEqual(r8, AppContext.INSTANCE.getUserId()) == false) goto L30;
        if (UserSettings.INSTANCE.hasAgreePrivacyAndLogin() == false) goto L30;
        if (L() == true) goto L30;
        if (K() == false) goto L30;
        return true;
    L13:
        if (((Number) ZeusTransformUtils.preCheckCast(r10, Number.class, "com.obric.memorydata.plugin")).longValue() <= 0) goto L15;
        boolean r12 = true;
    L16:
        if (r12 != true) goto L18;
        r11 = true;
        goto L19
    L15:
        r12 = false;
    L30:
        return false;
    }

    public static final /* synthetic */ boolean a(l r0) {
        return r0.J();
    }

    public static final /* synthetic */ boolean a(l r2, Activity r3, String r4) {
        return r2.a((Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.memorydata.plugin"), r4);
    }

    private static final Unit b(l r1, boolean r2) {
        r1.f11481b.save("proactive_shortcut_user_disabled", r2);
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ kotlinx.coroutines.sync.a b(l r0) {
        return r0.f;
    }

    private final void b(Activity r4) {
        Activity r5 = (Activity) ZeusTransformUtils.wrapperContextForParams(r4, Activity.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.h.f9872a.a();
        ProactiveShortcutRequestResult r3 = this.g.a(h((Context) ZeusTransformUtils.preCheckCast(r5, Context.class, "com.obric.memorydata.plugin")));
        if (r3 != ProactiveShortcutRequestResult.ALREADY_ACTIVE) goto L5;
    L6:
        com.obric.memorydata.h.f9872a.b();
        return;
    L5:
        if (r3 == ProactiveShortcutRequestResult.ENABLED_EXISTING) goto L6;
    }

    private final boolean b(b r3) {
        String r0 = r3.a();
        if (r0 != null) goto L6;
        return false;
    L6:
        if (r3.d() == true) goto L8;
        return false;
    L8:
        if (b(r0) == false) goto L12;
        return true;
    L12:
        return false;
    }

    private final boolean b(String r1) {
        if (AppContext.INSTANCE.isLogin() == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(AppContext.INSTANCE.getUserId(), r1) == false) goto L7;
        return true;
    }

    private static final Unit c(l r1, boolean r2) {
        r1.f11481b.save("proactive_shortcut_default_triggered_v1", r2);
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ boolean c(l r0) {
        return r0.L();
    }

    public static final /* synthetic */ ae d(l r0) {
        return r0.h;
    }

    private static final boolean e(l r2) {
        return r2.f11481b.getBoolean("proactive_shortcut_user_disabled", false);
    }

    private static final boolean f(l r2) {
        return r2.f11481b.getBoolean("proactive_shortcut_default_triggered_v1", false);
    }

    private static final ae g(l r0) {
        return at.a(r0.G());
    }

    private final o h(Context r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        return new o((Function0) ZeusTransformUtils.preCheckCast(new MemorySettingsStore$proactiveShortcutCoordinator$1(this), Function0.class, "com.obric.memorydata.plugin"), (q) ZeusTransformUtils.preCheckCast(new g(r6, this), q.class, "com.obric.memorydata.plugin"), this.d, this.e);
    }

    private static final ar h(l r0) {
        return kotlinx.coroutines.flow.k.a(r0.F());
    }

    private final PinnedShortcutState i(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.memory.utils.m r0 = com.obric.memorydata.memory.utils.m.f11550a;
        String r3 = r1.getString(ZeusTransformUtils.mapRes(R.string.memory_settings_ai_proactive_agent_title, TypedValues.Custom.S_STRING, "memory_settings_ai_proactive_agent_title"));
        Intrinsics.checkNotNullExpressionValue(r3, "getString(...)");
        return r0.c(r1, "proactive_home_shortcut", r3, ZeusTransformUtils.mapRes(R.drawable.host_ic_rectangle_ai_proactive, "drawable", "host_ic_rectangle_ai_proactive"), a(r1));
    }

    private final void i(boolean r12) {
        boolean r0 = N();
        boolean r1 = com.obric.memorydata.middleware.api.app.e.f11601a.a(r0, AILabPermissionRepository.b(AILabPermissionRepository.f10236a, null, 1, null));
        if (((Boolean) ZeusTransformUtils.preCheckCast(this.r.c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == r1) goto L5;
        boolean r2 = true;
    L6:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemorySettingsStore", "refreshAudioMemoryEnabled: persisted=" + r0 + ", effective=" + r1 + ", changed=" + r2, false, 4, null);
        if (r1 == false) goto L9;
        g(true);
    L9:
        this.r.b(Boolean.valueOf(r1));
        if (r2 == false) goto L14;
        if (r12 == false) goto L15;
        com.obric.memorydata.memory.tracker.f.f10542a.a();
        return;
    L15:
        return;
    L14:
        return;
    L5:
        r2 = false;
        goto L6
    }

    private final Intent j(Context r2) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        Intent r3 = new Intent();
        r3.setClassName(r1.getPackageName(), "com.obric.memorydata.plugin_api.stub.activity.MemoryListActivity");
        r3.setAction("android.intent.action.MAIN");
        r3.addCategory("android.intent.category.LAUNCHER");
        r3.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        r3.putExtra(MemoryListActivity.ARG_TARGET_CONTAINER_TAB, "AUTO_MEMORY_TASK");
        return r3;
    }

    public static /* synthetic */ boolean lambda$3ujtfQ0hopMOdhtexTMKFPGETW0(l r0) {
        return f(r0);
    }

    /* JADX INFO: renamed from: lambda$GE2xaOPWFGrMCI5NP1ZidYm-6gs, reason: not valid java name */
    public static /* synthetic */ boolean m989lambda$GE2xaOPWFGrMCI5NP1ZidYm6gs(l r0) {
        return e(r0);
    }

    public static /* synthetic */ Unit lambda$Hz4u_gw484fnop4fW0ERTNQ4wdk(l r0, boolean r1) {
        return b(r0, r1);
    }

    public static /* synthetic */ ae lambda$X73lkEsGrFVWNarCYOlb6gpKyRc(l r0) {
        return g(r0);
    }

    public static /* synthetic */ l lambda$eUdD36PJL8lFfz72SednnuThNYY() {
        return S();
    }

    public static /* synthetic */ Unit lambda$nexx7Tli2l_xXsWUTIGO7EapTv4(l r0, boolean r1) {
        return c(r0, r1);
    }

    public static /* synthetic */ ar lambda$qjakg3mmEjPZRj4veMjgFEProa4(l r0) {
        return h(r0);
    }

    public final void A() {
        c r0 = Q();
        com.obric.memorydata.middleware.api.store.a r1 = com.obric.memorydata.middleware.api.store.a.f11639a;
        if (r0 == null) goto L5;
        IStore r2 = r0.b();
    L6:
        boolean r3 = r1.a(r2, "context_awareness_configured", true);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemorySettingsStore", "markContextAwarenessConfigured: personalSaved=" + r3, false, 4, null);
        if (r3 == false) goto L13;
        if (r0 != null) goto L10;
        return;
    L10:
        if (b(r0.a()) == false) goto L15;
        this.M.b(true);
        return;
    L15:
        return;
    L13:
        return;
    L5:
        r2 = null;
        goto L6
    }

    public final void B() {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemorySettingsStore", "clearContextAwarenessConfiguredSnapshotForLogout", false, 4, null);
        this.M.b(false);
    }

    public final void C() {
        RecommendApi.INSTANCE.refreshScreenObservationEnabled();
        i(false);
    }

    public final boolean D() {
        return this.f11481b.getBoolean("in_app_evidence_archive_enabled", false);
    }

    public final Intent a(Context r2) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        Intent r3 = new Intent();
        r3.setClassName(r1.getPackageName(), "com.obric.memorydata.plugin_api.stub.activity.ProactiveNowShortcutActivity");
        r3.setAction("android.intent.action.MAIN");
        r3.addCategory("android.intent.category.LAUNCHER");
        r3.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        return r3;
    }

    public final ProactiveShortcutCompletion a(Context r3, long r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "context");
        return h(r5).a(r4);
    }

    public final ProactiveShortcutRequestResult a(Activity r3) {
        Activity r4 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "activity");
        this.g.b();
        com.obric.memorydata.h.f9872a.a();
        return h((Context) ZeusTransformUtils.preCheckCast(r4, Context.class, "com.obric.memorydata.plugin")).b();
    }

    public final Object a(Activity r6, Continuation<? super Unit> r7) {
        Activity r8 = (Activity) ZeusTransformUtils.wrapperContextForParams(r6, Activity.class, "com.obric.memorydata.plugin");
        Continuation r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
        String r0 = AppContext.INSTANCE.getUserId();
        Object r5 = kotlinx.coroutines.i.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.b().a(), CoroutineContext.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(new MemorySettingsStore$initializeProactiveShortcutOnHome$2(this, r8, r0, null), Function2.class, "com.obric.memorydata.plugin"), r9);
        if (r5 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r5;
    L6:
        return Unit.INSTANCE;
    }

    public final ar<Boolean> a() {
        return this.i;
    }

    public final void a(ShortcutMemoryConsentType r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r8, "type");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemorySettingsStore", "setShortcutConsentAccepted: type=" + r8 + ", accepted=" + r9, false, 4, null);
        int r10 = d.f11489a[r8.ordinal()];
        if (r10 != 1) goto L5;
        this.v.b(Boolean.valueOf(r9));
        IStore r7 = this.f11481b;
        String r11 = "ai_volume_shortcut_consent_accepted";
    L10:
        r7.save(r11, r9);
        return;
    L5:
        if (r10 != 2) goto L8;
        this.x.b(Boolean.valueOf(r9));
        r7 = this.f11481b;
        r11 = "gesture_shortcut_consent_accepted";
        goto L10
    L8:
        throw new NoWhenBranchMatchedException();
    }

    public final void a(String r8) {
        Intrinsics.checkNotNullParameter(r8, ObricMemoryConstants.KEY_PACKAGE_NAME);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemorySettingsStore", "saveDefaultMapPackageName: " + r8, false, 4, null);
        this.t.b(r8);
        this.f11481b.save("defaultMapPackageName", r8);
    }

    public final void a(Set<String> r9) {
        Set<String> r10 = (Set) ZeusTransformUtils.wrapperContextForParams(r9, Set.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r10, "apps");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemorySettingsStore", "saveEnabledApps: " + r10, false, 4, null);
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(y.f11594a.a().getSmartMemoryPackages(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r1 = r0.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r2.add(((AutoMemoryConfig.SmartMemoryPackage) ZeusTransformUtils.preCheckCast(r1.next(), AutoMemoryConfig.SmartMemoryPackage.class, "com.obric.memorydata.plugin")).getPackageName());
        goto L4
    L6:
        Set r3 = SetsKt.minus(CollectionsKt.toSet((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")), (Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.memorydata.plugin"));
        Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast(y.f11594a.a().getSmartMemoryPackages(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r5 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r6 = r4.iterator();
    L8:
        if (r6.hasNext() == false) goto L10;
        r5.add(((AutoMemoryConfig.SmartMemoryPackage) ZeusTransformUtils.preCheckCast(r6.next(), AutoMemoryConfig.SmartMemoryPackage.class, "com.obric.memorydata.plugin")).getPackageName());
        goto L8
    L10:
        this.f11481b.save("smart_memory_disable_packages", SetsKt.plus(SetsKt.minus(this.f11481b.getStringSet("smart_memory_disable_packages", SetsKt.emptySet()), (Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.toSet((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin")), (Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.memorydata.plugin")));
        F().b(r10);
    }

    public final void a(boolean r10) {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemorySettingsStore", "saveAutoMemoryEnabled: " + r10, false, 4, null);
        if (((Boolean) ZeusTransformUtils.preCheckCast(this.h.c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == r10) goto L5;
        boolean r0 = true;
    L7:
        if (Settings.System.putInt(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getContentResolver(), "smart_memory_enabled", r10 ? 1 : 0) == true) goto L10;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemorySettingsStore", "saveAutoMemoryEnabled failed: " + r10, null, 4, null);
        return;
    L10:
        this.h.b(Boolean.valueOf(r10));
        if (r0 == false) goto L14;
        com.obric.memorydata.memory.tracker.f.f10542a.a();
        return;
    L14:
        return;
    L5:
        r0 = false;
        goto L7
    }

    public final void a(boolean r12, boolean r13) {
        List<AutoMemoryConfig.SmartMemoryPackage> r0 = y.f11594a.a().getSmartMemoryPackages();
        if (r0.isEmpty() == false) goto L5;
        return;
    L5:
        if (r12 == false) goto L7;
        AutoMemoryCollectionScheme r14 = AutoMemoryCollectionScheme.IN_APP;
    L8:
        String r1 = this.f11481b.getString("auto_memory_collection_scheme_v2", "");
        Iterator r2 = ((Iterable) ZeusTransformUtils.preCheckCast(AutoMemoryCollectionScheme.getEntries(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L10:
        if (r2.hasNext() == false) goto L14;
        Object r3 = r2.next();
        if (Intrinsics.areEqual(((AutoMemoryCollectionScheme) ZeusTransformUtils.preCheckCast(r3, AutoMemoryCollectionScheme.class, "com.obric.memorydata.plugin")).name(), r1) == false) goto L10;
    L15:
        AutoMemoryCollectionScheme r9 = (AutoMemoryCollectionScheme) ZeusTransformUtils.preCheckCast(r3, AutoMemoryCollectionScheme.class, "com.obric.memorydata.plugin");
        Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin");
        Collection r5 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r6 = r4.iterator();
    L17:
        if (r6.hasNext() == false) goto L21;
        Object r7 = r6.next();
        if (((AutoMemoryConfig.SmartMemoryPackage) ZeusTransformUtils.preCheckCast(r7, AutoMemoryConfig.SmartMemoryPackage.class, "com.obric.memorydata.plugin")).getEnable() == false) goto L17;
        r5.add(r7);
        goto L17
    L21:
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r10 = (Collection) ZeusTransformUtils.preCheckCast((Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin");
        Iterator r11 = r8.iterator();
    L23:
        if (r11.hasNext() == false) goto L25;
        r10.add(((AutoMemoryConfig.SmartMemoryPackage) ZeusTransformUtils.preCheckCast(r11.next(), AutoMemoryConfig.SmartMemoryPackage.class, "com.obric.memorydata.plugin")).getPackageName());
        goto L23
    L25:
        Set<String> r15 = (Set) ZeusTransformUtils.preCheckCast(r10, Set.class, "com.obric.memorydata.plugin");
        Iterable r16 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin");
        Collection r17 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r18 = r16.iterator();
    L27:
        if (r18.hasNext() == false) goto L31;
        Object r19 = r18.next();
        if (((AutoMemoryConfig.SmartMemoryPackage) ZeusTransformUtils.preCheckCast(r19, AutoMemoryConfig.SmartMemoryPackage.class, "com.obric.memorydata.plugin")).getNoNeedA11y() == true) goto L27;
        r17.add(r19);
        goto L27
    L31:
        Iterable r20 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r17, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r21 = (Collection) ZeusTransformUtils.preCheckCast((Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin");
        Iterator r22 = r20.iterator();
    L33:
        if (r22.hasNext() == false) goto L35;
        r21.add(((AutoMemoryConfig.SmartMemoryPackage) ZeusTransformUtils.preCheckCast(r22.next(), AutoMemoryConfig.SmartMemoryPackage.class, "com.obric.memorydata.plugin")).getPackageName());
        goto L33
    L35:
        Set<String> r23 = (Set) ZeusTransformUtils.preCheckCast(r21, Set.class, "com.obric.memorydata.plugin");
        Set<String> r110 = (Set) ZeusTransformUtils.preCheckCast(i().c(), Set.class, "com.obric.memorydata.plugin");
        Set<String> r111 = com.obric.memorydata.memory.c.f10080a.a(r110, r15, r23, r13, r14, r9);
        if (r9 != null) goto L38;
    L39:
        a(r111);
    L40:
        this.f11481b.save("auto_memory_collection_scheme_v2", r14.name());
        if (r9 != null) goto L59;
        this.f11481b.save("smart_memory_need_write_a11y", false);
        return;
    L59:
        return;
    L38:
        if (Intrinsics.areEqual(r110, r111) == true) goto L40;
    L14:
        r3 = null;
        goto L15
    L7:
        r14 = AutoMemoryCollectionScheme.ACCESSIBILITY;
        goto L8
    }

    public final boolean a(Context r7, boolean r8) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        if (r8 == false) goto L8;
        if (L() == true) goto L8;
        com.obric.memorydata.memory.utils.m r0 = com.obric.memorydata.memory.utils.m.f11550a;
        String r3 = r1.getString(ZeusTransformUtils.mapRes(R.string.memory_settings_title, TypedValues.Custom.S_STRING, "memory_settings_title"));
        Intrinsics.checkNotNullExpressionValue(r3, "getString(...)");
        int r4 = ZeusTransformUtils.mapRes(R.drawable.host_ic_rectangle_memorydata, "drawable", "host_ic_rectangle_memorydata");
        Intent r5 = new Intent();
        r5.setClassName(r1.getPackageName(), "com.obric.memorydata.plugin_api.stub.activity.MemoryListActivity");
        r5.setAction("android.intent.action.MAIN");
        r5.addCategory("android.intent.category.LAUNCHER");
        r5.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        Unit r6 = Unit.INSTANCE;
        return r0.a(r1, "memory_home_shortcut", r3, r4, r5);
    L8:
        return com.obric.memorydata.memory.utils.m.f11550a.b(r1, "memory_home_shortcut");
    }

    public final ProactiveShortcutState b(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "context");
        return h(r4).a();
    }

    public final ProactiveShortcutState b(Context r3, boolean r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "context");
        return h(r5).a(r4);
    }

    public final ar<Boolean> b() {
        return this.k;
    }

    public final void b(boolean r8) {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemorySettingsStore", "saveHasConfirmed: " + r8, false, 4, null);
        this.j.b(Boolean.valueOf(r8));
        this.f11481b.save("smart_memory_has_confirmed", r8);
    }

    public final ProactiveShortcutState c(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "context");
        this.g.b();
        return h(r4).c();
    }

    public final ProactiveShortcutState c(Context r3, boolean r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "context");
        return h(r5).b(r4);
    }

    public final ar<Boolean> c() {
        return this.o;
    }

    public final void c(boolean r8) {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemorySettingsStore", "saveJoinInUXP: " + r8, false, 4, null);
        this.C.b(Boolean.valueOf(r8));
        this.f11481b.save("memory_user_experience", r8);
    }

    public final ar<Boolean> d() {
        return this.s;
    }

    public final void d(Context r7, boolean r8) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        if (r8 == true) goto L5;
    L7:
        com.obric.memorydata.memory.utils.m.f11550a.b(r1, "auto_memory_shortcut");
        return;
    L5:
        if (L() == true) goto L7;
        com.obric.memorydata.memory.utils.m r0 = com.obric.memorydata.memory.utils.m.f11550a;
        String r3 = r1.getString(ZeusTransformUtils.mapRes(R.string.memory_task, TypedValues.Custom.S_STRING, "memory_task"));
        Intrinsics.checkNotNullExpressionValue(r3, "getString(...)");
        r0.a(r1, "auto_memory_shortcut", r3, ZeusTransformUtils.mapRes(R.drawable.host_ic_rectangle_memorydata, "drawable", "host_ic_rectangle_memorydata"), j(r1));
    }

    public final void d(boolean r8) {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemorySettingsStore", "saveScreenMemory: " + r8, false, 4, null);
        this.E.b(Boolean.valueOf(r8));
    }

    public final boolean d(Context r2) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        if (com.obric.memorydata.memory.utils.m.f11550a.c(r1, "proactive_home_shortcut") != PinnedShortcutState.DISABLED) goto L5;
        return true;
    L5:
        return false;
    }

    public final ProactiveShortcutState e(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "context");
        return h(r4).d();
    }

    public final ar<String> e() {
        return this.u;
    }

    public final void e(Context r18, boolean r19) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r18, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "context");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemorySettingsStore", "syncEnterpriseAccountState: isEnterprise=" + r19, false, 4, null);
        this.m = r19;
        ae<Boolean> r4 = this.G;
        boolean r10 = false;
        if (I() == false) goto L6;
        if (r19 == true) goto L6;
        boolean r5 = true;
    L7:
        r4.b(Boolean.valueOf(r5));
        ae<Boolean> r6 = this.p;
        if (((Boolean) ZeusTransformUtils.preCheckCast(this.n.c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L11;
        if (r19 == true) goto L11;
        boolean r7 = true;
    L12:
        r6.b(Boolean.valueOf(r7));
        C();
        Set<String> r13 = CollectionsKt.toMutableSet((Iterable) ZeusTransformUtils.preCheckCast(this.f11481b.getStringSet("enterprise_disabled_shortcuts", SetsKt.emptySet()), Iterable.class, "com.obric.memorydata.plugin"));
        String r9 = "proactive_home_shortcut";
        List r8 = CollectionsKt.listOf(new String[]{"memory_home_shortcut", "auto_memory_shortcut", "proactive_home_shortcut"});
        if (r19 == false) goto L37;
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L16:
        if (r1.hasNext() == false) goto L27;
        String r11 = (String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(r11, "proactive_home_shortcut") == true) goto L20;
        boolean r12 = com.obric.memorydata.memory.utils.m.f11550a.d(r2, r11);
    L24:
        if (r12 == false) goto L16;
        r13.add(r11);
        goto L16
    L20:
        if (com.obric.memorydata.memory.utils.m.f11550a.a(r2, r11) != PinnedShortcutState.ACTIVE) goto L22;
        r12 = true;
        goto L24
    L22:
        r12 = false;
        goto L24
    L27:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r13, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L29;
        this.f11481b.save("enterprise_disabled_shortcuts", r13);
    L29:
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L31:
        if (r3.hasNext() == false) goto L35;
        String r14 = (String) ZeusTransformUtils.preCheckCast(r3.next(), String.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(r14, "proactive_home_shortcut") == true) goto L31;
        com.obric.memorydata.memory.utils.m.f11550a.b(r2, r14);
        goto L31
    L35:
        e(r2);
        return;
    L37:
        Iterator r15 = ((Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L39:
        if (r15.hasNext() == false) goto L61;
        String r16 = (String) ZeusTransformUtils.preCheckCast(r15.next(), String.class, "com.obric.memorydata.plugin");
        int r17 = r16.hashCode();
        if (r17 == 527654120) goto L56;
        if (r17 == 2034256986) goto L52;
        if (r17 == 2086295348) goto L48;
    L59:
        r9 = r9;
        r10 = false;
        goto L39
    L48:
        if (r16.equals("auto_memory_shortcut") == false) goto L59;
        f(r2);
        goto L59
    L52:
        if (r16.equals(r9) == false) goto L59;
        a(this, r2, r10, 2, null);
        goto L59
    L56:
        if (r16.equals("memory_home_shortcut") == false) goto L59;
        com.obric.memorydata.memory.utils.m r20 = com.obric.memorydata.memory.utils.m.f11550a;
        String r21 = r2.getString(ZeusTransformUtils.mapRes(R.string.memory_settings_title, TypedValues.Custom.S_STRING, "memory_settings_title"));
        Intrinsics.checkNotNullExpressionValue(r21, "getString(...)");
        int r22 = ZeusTransformUtils.mapRes(R.drawable.host_ic_rectangle_memorydata, "drawable", "host_ic_rectangle_memorydata");
        Intent r23 = new Intent();
        r23.setClassName(r2.getPackageName(), "com.obric.memorydata.plugin_api.stub.activity.MemoryListActivity");
        r23.setAction("android.intent.action.MAIN");
        r23.addCategory("android.intent.category.LAUNCHER");
        r23.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        Unit r24 = Unit.INSTANCE;
        r20.d(r2, "memory_home_shortcut", r21, r22, r23);
        goto L59
    L61:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r13, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L77;
        this.f11481b.remove(new String[]{"enterprise_disabled_shortcuts"});
        return;
    L77:
        return;
    L11:
        r7 = false;
    L6:
        r5 = false;
        goto L7
    }

    public final void e(boolean r8) {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemorySettingsStore", "saveVoiceMemoryShown: " + r8, false, 4, null);
        ae<Boolean> r0 = this.G;
        if (r8 == true) goto L5;
    L7:
        boolean r7 = false;
    L8:
        r0.b(Boolean.valueOf(r7));
        return;
    L5:
        if (L() == true) goto L7;
        r7 = true;
        goto L8
    }

    public final ar<Boolean> f() {
        return this.w;
    }

    public final void f(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        if (L() == false) goto L6;
        com.obric.memorydata.memory.utils.m.f11550a.b(r1, "auto_memory_shortcut");
        return;
    L6:
        com.obric.memorydata.memory.utils.m r0 = com.obric.memorydata.memory.utils.m.f11550a;
        String r3 = r1.getString(ZeusTransformUtils.mapRes(R.string.memory_task, TypedValues.Custom.S_STRING, "memory_task"));
        Intrinsics.checkNotNullExpressionValue(r3, "getString(...)");
        r0.d(r1, "auto_memory_shortcut", r3, ZeusTransformUtils.mapRes(R.drawable.host_ic_rectangle_memorydata, "drawable", "host_ic_rectangle_memorydata"), j(r1));
    }

    public final void f(boolean r8) {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemorySettingsStore", "saveAutoMemoryShown: " + r8, false, 4, null);
        this.I.b(Boolean.valueOf(r8));
    }

    public final ar<Boolean> g() {
        return this.y;
    }

    public final void g(Context r15) {
        Context r14 = (Context) ZeusTransformUtils.wrapperContextForParams(r15, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r14, "context");
        String r4 = r14.getString(ZeusTransformUtils.mapRes(R.string.memory_settings_title, TypedValues.Custom.S_STRING, "memory_settings_title"));
        Intrinsics.checkNotNullExpressionValue(r4, "getString(...)");
        String r7 = r14.getString(ZeusTransformUtils.mapRes(R.string.memory_settings_smart_memory_pro_title, TypedValues.Custom.S_STRING, "memory_settings_smart_memory_pro_title"));
        Intrinsics.checkNotNullExpressionValue(r7, "getString(...)");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemorySettingsStore", "refreshPinnedShortcuts memoryLabel=" + r4 + ", autoMemoryLabel=" + r7, false, 4, null);
        com.obric.memorydata.memory.utils.m r1 = com.obric.memorydata.memory.utils.m.f11550a;
        int r5 = ZeusTransformUtils.mapRes(R.drawable.host_ic_rectangle_memorydata, "drawable", "host_ic_rectangle_memorydata");
        Intent r6 = new Intent();
        r6.setClassName(r14.getPackageName(), "com.obric.memorydata.plugin_api.stub.activity.MemoryListActivity");
        r6.setAction("android.intent.action.MAIN");
        r6.addCategory("android.intent.category.LAUNCHER");
        r6.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        Unit r2 = Unit.INSTANCE;
        r1.e(r14, "memory_home_shortcut", r4, r5, r6);
        com.obric.memorydata.memory.utils.m r3 = com.obric.memorydata.memory.utils.m.f11550a;
        int r8 = ZeusTransformUtils.mapRes(R.drawable.host_ic_rectangle_memorydata, "drawable", "host_ic_rectangle_memorydata");
        Intent r9 = new Intent();
        r9.setClassName(r14.getPackageName(), "com.obric.memorydata.plugin_api.stub.activity.MemoryListActivity");
        r9.setAction("android.intent.action.MAIN");
        r9.addCategory("android.intent.category.LAUNCHER");
        r9.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        Unit r16 = Unit.INSTANCE;
        r3.e(r14, "auto_memory_shortcut", r7, r8, r9);
    }

    public final void g(boolean r13) {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemorySettingsStore", "saveAudioMemoryConfigured: " + r13, false, 4, null);
        c r0 = Q();
        com.obric.memorydata.middleware.api.store.a r1 = com.obric.memorydata.middleware.api.store.a.f11639a;
        IStore r3 = null;
        if (r0 == null) goto L5;
        IStore r4 = r0.b();
    L6:
        boolean r2 = r1.a(r4, "audio_memory_configured", r13);
        boolean r5 = false;
        if (r13 == false) goto L13;
        if (r2 == false) goto L13;
        com.obric.memorydata.middleware.api.store.a r6 = com.obric.memorydata.middleware.api.store.a.f11639a;
        if (r0 == null) goto L12;
        r3 = r0.b();
    L12:
        boolean r7 = r6.a(r3, "context_awareness_configured", true);
    L14:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemorySettingsStore", "saveAudioMemoryConfigured: personalSaved=" + r2 + ", contextSaved=" + r7, false, 4, null);
        if (r0 != null) goto L17;
    L20:
        this.n.b(Boolean.valueOf(r13));
        ae<Boolean> r8 = this.p;
        if (r13 == true) goto L23;
    L25:
        r8.b(Boolean.valueOf(r5));
        if (r7 == false) goto L30;
        this.M.b(true);
        return;
    L30:
        return;
    L23:
        if (L() == true) goto L25;
        r5 = true;
        goto L25
    L17:
        if (b(r0.a()) == true) goto L20;
        z();
        return;
    L13:
        r7 = false;
        goto L14
    L5:
        r4 = null;
        goto L6
    }

    public final void h() {
        boolean r0 = this.f11481b.contains("smart_memory_disable_packages");
        boolean r1 = !((Collection) ZeusTransformUtils.preCheckCast(y.f11594a.a().getSmartMemoryPackages(), Collection.class, "com.obric.memorydata.plugin")).isEmpty();
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemorySettingsStore", "saveInitialDisableAppsIfNeeded: localDisableConfigured: " + r0 + ", cloudSettingsReady: " + r1, false, 4, null);
        if (r0 == true) goto L23;
        if (r1 == false) goto L24;
        Iterable r2 = (Iterable) ZeusTransformUtils.preCheckCast(y.f11594a.a().getSmartMemoryPackages(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r4 = r2.iterator();
    L7:
        if (r4.hasNext() == false) goto L11;
        Object r5 = r4.next();
        if (((AutoMemoryConfig.SmartMemoryPackage) ZeusTransformUtils.preCheckCast(r5, AutoMemoryConfig.SmartMemoryPackage.class, "com.obric.memorydata.plugin")).getEnable() == false) goto L7;
        r3.add(r5);
        goto L7
    L11:
        Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r7 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r8 = r6.iterator();
    L13:
        if (r8.hasNext() == false) goto L15;
        r7.add(((AutoMemoryConfig.SmartMemoryPackage) ZeusTransformUtils.preCheckCast(r8.next(), AutoMemoryConfig.SmartMemoryPackage.class, "com.obric.memorydata.plugin")).getPackageName());
        goto L13
    L15:
        a(CollectionsKt.toSet((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r7, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")));
        return;
    L24:
        return;
    }

    public final void h(boolean r10) {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemorySettingsStore", "saveAudioMemoryEnabled", false, 4, null);
        Settings.Global.putInt(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getContentResolver(), "recorder_always_on_enable", r10 ? 1 : 0);
        i(true);
    }

    public final ar<Set<String>> i() {
        return (ar) ZeusTransformUtils.preCheckCast(this.A.getValue(), ar.class, "com.obric.memorydata.plugin");
    }

    public final ar<Boolean> j() {
        return this.D;
    }

    public final ar<Boolean> k() {
        return this.F;
    }

    public final ar<Boolean> l() {
        return this.H;
    }

    public final ar<Boolean> m() {
        return this.f11480J;
    }

    public final ar<Boolean> n() {
        return this.L;
    }

    public final ar<Boolean> o() {
        return this.N;
    }

    public final void p() {
        ((TaskRequest) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(new TaskRequest.Builder("recommend_settings").setTaskInfoCallback((com.obric.memorydata.task.scheduler.c) ZeusTransformUtils.preCheckCast(new h(this), com.obric.memorydata.task.scheduler.c.class, "com.obric.memorydata.plugin")), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).build(), TaskRequest.class, "com.obric.memorydata.plugin")).enqueue();
    }

    public final boolean q() {
        return this.f11481b.getBoolean("memory_shortcut_auto_guide_shown", false);
    }

    public final void r() {
        this.f11481b.save("memory_shortcut_auto_guide_shown", true);
    }

    public final List<String> s() {
        String r9 = this.f11481b.getString("recommend_settings_auto_memory_pro_slm_did", HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
        List<String> r2 = null;
        r2 = (List) ZeusTransformUtils.preCheckCast(com.obric.memorydata.utils.u.a().fromJson(r9, new e().getType()), List.class, "com.obric.memorydata.plugin");     // Catch: JsonParseException -> L5 JsonSyntaxException -> L7
    L10:
        if (r2 == null) goto L12;
        return r2;
    L12:
        return CollectionsKt.emptyList();
    L7:
        e = e;
        IRunLog r3 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r1 = new StringBuilder();
    L9:
        IRunLog.a.b(r3, "GsonExt", r1.append("toListObj error : ").append(e).toString(), null, 4, null);
    L5:
        e = e;
        r3 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r1 = new StringBuilder();
        goto L9
    }

    public final List<String> t() {
        String r9 = this.f11481b.getString("recommend_settings_auto_memory_pro_slm_uid", HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
        List<String> r2 = null;
        r2 = (List) ZeusTransformUtils.preCheckCast(com.obric.memorydata.utils.u.a().fromJson(r9, new f().getType()), List.class, "com.obric.memorydata.plugin");     // Catch: JsonParseException -> L5 JsonSyntaxException -> L7
    L10:
        if (r2 == null) goto L12;
        return r2;
    L12:
        return CollectionsKt.emptyList();
    L7:
        e = e;
        IRunLog r3 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r1 = new StringBuilder();
    L9:
        IRunLog.a.b(r3, "GsonExt", r1.append("toListObj error : ").append(e).toString(), null, 4, null);
    L5:
        e = e;
        r3 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r1 = new StringBuilder();
        goto L9
    }

    public final boolean u() {
        String r0 = AppContext.INSTANCE.getServerDeviceId();
        String r1 = AppContext.INSTANCE.getUserId();
        if (s().contains(r0) == false) goto L5;
    L8:
        return true;
    L5:
        if (t().contains(r1) == true) goto L8;
        return false;
    }

    public final Set<String> v() {
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(y.f11594a.a().getSmartMemoryPackages(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        Object r3 = r2.next();
        if (((AutoMemoryConfig.SmartMemoryPackage) ZeusTransformUtils.preCheckCast(r3, AutoMemoryConfig.SmartMemoryPackage.class, "com.obric.memorydata.plugin")).getNoNeedA11y() == true) goto L4;
        r1.add(r3);
        goto L4
    L8:
        Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r5 = (Collection) ZeusTransformUtils.preCheckCast((Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin");
        Iterator r6 = r4.iterator();
    L10:
        if (r6.hasNext() == false) goto L12;
        r5.add(((AutoMemoryConfig.SmartMemoryPackage) ZeusTransformUtils.preCheckCast(r6.next(), AutoMemoryConfig.SmartMemoryPackage.class, "com.obric.memorydata.plugin")).getPackageName());
        goto L10
    L12:
        Set r7 = (Set) ZeusTransformUtils.preCheckCast(r5, Set.class, "com.obric.memorydata.plugin");
        Set r8 = (Set) ZeusTransformUtils.preCheckCast(i().c(), Set.class, "com.obric.memorydata.plugin");
        Set<String> r9 = CollectionsKt.intersect((Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin"));
        if (r9.isEmpty() == true) goto L15;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemorySettingsStore", "disableAppsRequiringAccessibility: " + r9, false, 4, null);
        a(SetsKt.minus(r8, (Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.memorydata.plugin")));
        return r9;
    L15:
        return SetsKt.emptySet();
    }

    public final void w() {
        F().b(G());
    }

    public final boolean x() {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemorySettingsStore", "getScreenObservationConfigured", false, 4, null);
        this.K.b(Boolean.valueOf(RecommendApi.INSTANCE.getScreenObservationConfigured()));
        return ((Boolean) ZeusTransformUtils.preCheckCast(this.K.c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    }

    public final boolean y() {
        a(P());
        return ((Boolean) ZeusTransformUtils.preCheckCast(this.M.c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    }

    public final void z() {
        b r0 = P();
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemorySettingsStore", "refreshPersonalMemoryConfiguredState: screen=" + r0.b() + ", audio=" + r0.c() + ", context=" + r0.d(), false, 4, null);
        a(r0);
    }
}
