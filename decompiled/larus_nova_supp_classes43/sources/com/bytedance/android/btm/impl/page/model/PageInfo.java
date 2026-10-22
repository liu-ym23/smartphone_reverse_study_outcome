package com.bytedance.android.btm.impl.page.model;

import android.os.SystemClock;
import com.bytedance.android.btm.api.BtmHostDependManager;
import com.bytedance.android.btm.api.PageProp;
import com.bytedance.android.btm.api.inner.ALogger;
import com.bytedance.android.btm.api.inner.g$a;
import com.bytedance.android.btm.api.model.BufferBtm;
import com.bytedance.android.btm.impl.ShowIdUpdateReason;
import com.bytedance.android.btm.impl.chain.BtmChainRecorder;
import com.bytedance.android.btm.impl.monitor.BtmMonitor;
import com.bytedance.android.btm.impl.page.BufferQueue;
import com.bytedance.android.btm.impl.page.lifecycle.ResumeFuncOrigin;
import com.bytedance.android.btm.impl.page.lifecycle.layer3.BtmPageLifecycleCallbackV2;
import com.bytedance.android.btm.impl.page.unknown.UnionBufferBtm;
import com.bytedance.android.btm.impl.page.unknown.UnionData;
import com.bytedance.android.btm.impl.pageshow.PageShowLog;
import com.bytedance.android.btm.impl.pageshow.checker.DuplicatedEnterPageChecker;
import com.bytedance.android.btm.impl.pageshow.checker.DuplicatedEnterPageChecker$a;
import com.bytedance.android.btm.impl.pageshow.checker.DuplicatedEnterPageChecker$monitor$$inlined$monitor$btm_impl_cnRelease$2;
import com.bytedance.android.btm.impl.setting.BtmSetting;
import com.bytedance.android.btm.impl.util.BtmFormatUtils;
import com.bytedance.android.ec.base.api.ai.AIStateLogRequest;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b1\b\u0016\u0018\u0000 £\u00012\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00000\u0003:\u0001FB\t¢\u0006\u0006\b¢\u0001\u0010\u0097\u0001J\u0010\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u001e\u0010\u000e\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fJ4\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u0013J\u000e\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0017J\u000e\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0017J\u000e\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u001bJ\u0006\u0010\u001e\u001a\u00020\u0013J\u001c\u0010!\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001fH\u0016J\u0006\u0010\"\u001a\u00020\u0006J\u0006\u0010#\u001a\u00020\u0013J\b\u0010$\u001a\u00020\u0000H\u0016J\u000e\u0010$\u001a\u00020\u00002\u0006\u0010%\u001a\u00020\u0000J\u0006\u0010&\u001a\u00020\u0006J\u0006\u0010'\u001a\u00020\u0006J\b\u0010(\u001a\u00020\u0004H\u0016J\b\u0010)\u001a\u00020\u0004H\u0016J\u0010\u0010+\u001a\u00020\u00002\u0006\u0010*\u001a\u00020\u0004H\u0016R\u0014\u0010,\u001a\u00020\u00048\u0002X\u0082D¢\u0006\u0006\n\u0004\b,\u0010-R\u0014\u0010.\u001a\u00020\u00048\u0002X\u0082D¢\u0006\u0006\n\u0004\b.\u0010-R\u0014\u0010/\u001a\u00020\u00048\u0002X\u0082D¢\u0006\u0006\n\u0004\b/\u0010-R\u0014\u00100\u001a\u00020\u00048\u0002X\u0082D¢\u0006\u0006\n\u0004\b0\u0010-R\u0014\u00101\u001a\u00020\u00048\u0002X\u0082D¢\u0006\u0006\n\u0004\b1\u0010-R\u0014\u00102\u001a\u00020\u00048\u0002X\u0082D¢\u0006\u0006\n\u0004\b2\u0010-R\u0014\u00103\u001a\u00020\u00048\u0002X\u0082D¢\u0006\u0006\n\u0004\b3\u0010-R\"\u00104\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b4\u0010-\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\"\u00109\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\"\u0010?\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b?\u0010-\u001a\u0004\b@\u00106\"\u0004\bA\u00108R\"\u0010B\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bB\u0010-\u001a\u0004\bC\u00106\"\u0004\bD\u00108R$\u0010L\u001a\u0004\u0018\u00010E8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bF\u0010G\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR$\u0010P\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bM\u0010-\u001a\u0004\bN\u00106\"\u0004\bO\u00108R$\u0010T\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bQ\u0010-\u001a\u0004\bR\u00106\"\u0004\bS\u00108R$\u0010X\u001a\u0004\u0018\u00010E8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bU\u0010G\u001a\u0004\bV\u0010I\"\u0004\bW\u0010KR$\u0010\\\u001a\u0004\u0018\u00010E8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bY\u0010G\u001a\u0004\bZ\u0010I\"\u0004\b[\u0010KR$\u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010-\u001a\u0004\b]\u00106\"\u0004\b^\u00108R\"\u0010_\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b_\u0010:\u001a\u0004\b`\u0010<\"\u0004\ba\u0010>R\"\u0010\u0015\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010:\u001a\u0004\bb\u0010<\"\u0004\bc\u0010>R\"\u0010d\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bd\u0010:\u001a\u0004\be\u0010<\"\u0004\bf\u0010>R$\u0010h\u001a\u0004\u0018\u00010g8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bh\u0010i\u001a\u0004\bj\u0010k\"\u0004\bl\u0010mR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010n\u001a\u0004\bo\u0010p\"\u0004\bq\u0010rR\"\u0010t\u001a\u00020s8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bt\u0010u\u001a\u0004\bv\u0010w\"\u0004\bx\u0010yR\"\u0010z\u001a\u00020s8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bz\u0010u\u001a\u0004\b{\u0010w\"\u0004\b|\u0010yR\"\u0010}\u001a\u00020s8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b}\u0010u\u001a\u0004\b~\u0010w\"\u0004\b\u007f\u0010yR&\u0010\u0080\u0001\u001a\u00020s8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0080\u0001\u0010u\u001a\u0005\b\u0081\u0001\u0010w\"\u0005\b\u0082\u0001\u0010yR+\u0010\u0083\u0001\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0083\u0001\u0010\u0084\u0001\u001a\u0006\b\u0085\u0001\u0010\u0086\u0001\"\u0006\b\u0087\u0001\u0010\u0088\u0001R(\u0010\u0089\u0001\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0089\u0001\u0010-\u001a\u0005\b\u008a\u0001\u00106\"\u0005\b\u008b\u0001\u00108R&\u0010\u008c\u0001\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u008c\u0001\u0010-\u001a\u0005\b\u008d\u0001\u00106\"\u0005\b\u008e\u0001\u00108R&\u0010\u008f\u0001\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u008f\u0001\u0010:\u001a\u0005\b\u008f\u0001\u0010<\"\u0005\b\u0090\u0001\u0010>R&\u0010\u0091\u0001\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0091\u0001\u0010:\u001a\u0005\b\u0091\u0001\u0010<\"\u0005\b\u0092\u0001\u0010>R.\u0010\u0093\u0001\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u001d\n\u0005\b\u0093\u0001\u0010:\u0012\u0006\b\u0096\u0001\u0010\u0097\u0001\u001a\u0005\b\u0094\u0001\u0010<\"\u0005\b\u0095\u0001\u0010>R&\u0010\u0098\u0001\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0098\u0001\u0010:\u001a\u0005\b\u0099\u0001\u0010<\"\u0005\b\u009a\u0001\u0010>R&\u0010\u009b\u0001\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u009b\u0001\u0010:\u001a\u0005\b\u009c\u0001\u0010<\"\u0005\b\u009d\u0001\u0010>R\u0018\u0010\u009e\u0001\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u009e\u0001\u0010:R&\u0010\u009f\u0001\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u009f\u0001\u0010:\u001a\u0005\b \u0001\u0010<\"\u0005\b¡\u0001\u0010>¨\u0006¤\u0001"}, d2 = {"Lcom/bytedance/android/btm/impl/page/model/PageInfo;", "Lcom/bytedance/android/btm/impl/page/unknown/UnionData;", "Ljava/io/Serializable;", "Lxc/a;", "", "btm", "", "parsePageBtm", "Lcom/bytedance/android/btm/api/PageProp;", "prop", "", AIStateLogRequest.SOURCE_PAGE, "Lcom/bytedance/android/btm/impl/page/model/PageInfoStack;", "infoStack", "setProp", "btmPre", "", "step", "sourcePageId", "", "resetBeforeUpdate", "btmPreIsToken", "putSourceBtm", "Lcom/bytedance/android/btm/impl/page/lifecycle/ResumeFuncOrigin;", "resumeFuncOrigin", "onlyResume", "onResume", "Lcom/bytedance/android/btm/impl/ShowIdUpdateReason;", "reason", "updateShowIdIfNeed", "isFirstResumeV2", "Lcom/bytedance/android/btm/impl/page/model/i;", "pausedInfo", "onPause", "onDestroy", "isFromBackground", "copy", "info", "reset", "resetDataAfterPageShow", "toString", "save", "data", "parse", "TAG_CLASS_PREFIX", "Ljava/lang/String;", "TAG_SETPROP", "TAG_PUTSOURCEBTM", "TAG_ONRESUME", "TAG_ONPAUSE", "TAG_PARSEPAGEBTM", "TAG_UPDATE_SHOW_ID", "instanceId", "getInstanceId", "()Ljava/lang/String;", "setInstanceId", "(Ljava/lang/String;)V", "reuse", "Z", "getReuse", "()Z", "setReuse", "(Z)V", "pageShowId", "getPageShowId", "setPageShowId", "lastPageShowId", "getLastPageShowId", "setLastPageShowId", "Lcom/bytedance/android/btm/api/model/b;", "a", "Lcom/bytedance/android/btm/api/model/b;", "getPreBtmIdNode", "()Lcom/bytedance/android/btm/api/model/b;", "setPreBtmIdNode", "(Lcom/bytedance/android/btm/api/model/b;)V", "preBtmIdNode", "b", "getLatestBtmId", "setLatestBtmId", "latestBtmId", "c", "getLatestPageBtmId", "setLatestPageBtmId", "latestPageBtmId", "d", "getLatestBtmIdNode", "setLatestBtmIdNode", "latestBtmIdNode", "e", "getLatestPageBtmIdNode", "setLatestPageBtmIdNode", "latestPageBtmIdNode", "getBtmPre", "setBtmPre", "btmPreSetFromSourceBtmToken", "getBtmPreSetFromSourceBtmToken", "setBtmPreSetFromSourceBtmToken", "getBtmPreIsToken", "setBtmPreIsToken", "btmPreHasCreatedToken", "getBtmPreHasCreatedToken", "setBtmPreHasCreatedToken", "Lcom/bytedance/android/btm/impl/page/unknown/UnionBufferBtm;", "earlierUnionBuffer", "Lcom/bytedance/android/btm/impl/page/unknown/UnionBufferBtm;", "getEarlierUnionBuffer", "()Lcom/bytedance/android/btm/impl/page/unknown/UnionBufferBtm;", "setEarlierUnionBuffer", "(Lcom/bytedance/android/btm/impl/page/unknown/UnionBufferBtm;)V", "I", "getStep", "()I", "setStep", "(I)V", "", "enterTime", "J", "getEnterTime", "()J", "setEnterTime", "(J)V", com.bytedance.android.ec.core.event.a.KEY_DURATION, "getDuration", "setDuration", "lastResumeTime", "getLastResumeTime", "setLastResumeTime", "lastPauseTime", "getLastPauseTime", "setLastPauseTime", "firstShow", "Ljava/lang/Boolean;", "getFirstShow", "()Ljava/lang/Boolean;", "setFirstShow", "(Ljava/lang/Boolean;)V", "classSimpleName", "getClassSimpleName", "setClassSimpleName", "scene", "getScene", "setScene", "isFirstPage", "setFirstPage", "isBeforeFirstResume", "setBeforeFirstResume", "enterPage", "getEnterPage", "setEnterPage", "enterPage$annotations", "()V", "hasSendEnterPage", "getHasSendEnterPage", "setHasSendEnterPage", "needUpdateShowIdWhenResume", "getNeedUpdateShowIdWhenResume", "setNeedUpdateShowIdWhenResume", "couldUpdateInstanceId", "updateBySourceBtmTokenInThisDisplay", "getUpdateBySourceBtmTokenInThisDisplay", "setUpdateBySourceBtmTokenInThisDisplay", "<init>", "Companion", "btm-impl_cnRelease"}, k = 1, mv = {1, 4, 0})
public class PageInfo extends UnionData implements xc.a<PageInfo> {
    public static final a Companion = null;
    public static final String SCENE_CRASH = "crash";
    public static final String SCENE_KILL = "kill";
    public static final String SCENE_NORMAL = "normal";
    private static final long serialVersionUID = 20211213;
    private final String TAG_CLASS_PREFIX;
    private final String TAG_ONPAUSE;
    private final String TAG_ONRESUME;
    private final String TAG_PARSEPAGEBTM;
    private final String TAG_PUTSOURCEBTM;
    private final String TAG_SETPROP;
    private final String TAG_UPDATE_SHOW_ID;
    public transient com.bytedance.android.btm.api.model.b a;
    public transient String b;
    private String btmPre;
    private boolean btmPreHasCreatedToken;
    private boolean btmPreIsToken;
    private boolean btmPreSetFromSourceBtmToken;
    public transient String c;
    private String classSimpleName;
    private boolean couldUpdateInstanceId;
    public transient com.bytedance.android.btm.api.model.b d;
    private long duration;
    public transient com.bytedance.android.btm.api.model.b e;
    private UnionBufferBtm earlierUnionBuffer;
    private boolean enterPage;
    private long enterTime;
    private Boolean firstShow;
    private boolean hasSendEnterPage;
    private String instanceId;
    private boolean isBeforeFirstResume;
    private boolean isFirstPage;
    private String lastPageShowId;
    private long lastPauseTime;
    private long lastResumeTime;
    private boolean needUpdateShowIdWhenResume;
    private String pageShowId;
    private boolean reuse;
    private String scene;
    private int step;
    private boolean updateBySourceBtmTokenInThisDisplay;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    @Deprecated(message = "use getForwardPageId instead")
    public static /* synthetic */ void enterPage$annotations() {
    }

    public final void onDestroy() {
    }

    public final void reset() {
        this.step = 1;
        this.btmPre = null;
        this.enterTime = 0;
        this.duration = 0;
        this.lastResumeTime = 0;
        this.lastPauseTime = 0;
        this.scene = "normal";
        if (BtmSetting.d.c().b().M() == 1) goto L6;
        String r0 = this.pageShowId;
        this.lastPageShowId = r0;
        AtomicLong r1 = com.bytedance.android.btm.impl.util.e.a;
        this.pageShowId = com.bytedance.android.btm.impl.util.e.a(this.instanceId, r0);
        return;
    }

    public PageInfo copy() {
        PageInfoStack.Companion.getClass();
        return copy(PageInfoStack.a.a().create());
    }

    public final boolean isFirstResumeV2() {
        if (BtmSetting.d.c().b().I() != 1) goto L13;
        if (this.isBeforeFirstResume == false) goto L7;
        return true;
    L7:
        if (this.firstShow != null) goto L9;
        return true;
    L9:
        if (this.reuse == true) goto L17;
        return false;
    L17:
        return true;
    L13:
        return this.isBeforeFirstResume;
    }

    public final boolean isFromBackground() {
        boolean r0 = com.bytedance.android.btm.impl.b.a;
        return !com.bytedance.android.btm.impl.b.b().l(this.enterTime, Long.MAX_VALUE).isEmpty();
    }

    public final void resetDataAfterPageShow() {
        if (((Boolean) DuplicatedEnterPageChecker.b.getValue()).booleanValue() == false) goto L25;
        Iterator r0 = DuplicatedEnterPageChecker.a.entrySet().iterator();
        final ArrayList r10 = new ArrayList();
    L7:
        if (r0.hasNext() == false) goto L22;
        Object r11 = r0.next();
        Map.Entry r12 = (Map.Entry) r11;
        if (Intrinsics.areEqual(((DuplicatedEnterPageChecker$a) r12.getValue()).d, getPageShowId()) == false) goto L11;
    L14:
        boolean r13 = true;
    L15:
        if (r13 == true) goto L18;
        r11 = null;
    L18:
        Map.Entry r14 = (Map.Entry) r11;
        if (r14 == null) goto L7;
        r10.add(r14.getValue());
        r0.remove();
        goto L7
    L11:
        if (((DuplicatedEnterPageChecker$a) r12.getValue()).d == null) goto L14;
        r13 = false;
        goto L15
    L22:
        if (r10.size() <= 1) goto L25;
        Lazy r1 = BtmMonitor.a;
        new DuplicatedEnterPageChecker$monitor$$inlined$monitor$btm_impl_cnRelease$2(r10).run();
    L25:
        final String r15 = this.pageShowId;
        this.enterTime = 0;
        this.duration = 0;
        if (com.bytedance.android.btm.impl.c.a == false) goto L28;
        this.needUpdateShowIdWhenResume = true;
    L29:
        this.couldUpdateInstanceId = true;
        this.hasSendEnterPage = false;
        ALogger.j(ALogger.d, this.TAG_CLASS_PREFIX + "resetDataAfterPageShow", new C02371(this, r15));
        return;
    L28:
        this.lastPageShowId = r15;
        AtomicLong r16 = com.bytedance.android.btm.impl.util.e.a;
        this.pageShowId = com.bytedance.android.btm.impl.util.e.a(this.instanceId, r15);
        goto L29
    }

    public String toString() {
        JSONObject r0 = new JSONObject();
        r0.put("class_name", getClassName());     // Catch: Throwable -> L6
        r0.put("page_btm", getPageBtm());     // Catch: Throwable -> L6
        r0.put("btm_pre", this.btmPre);     // Catch: Throwable -> L6
        r0.put("btm_pre_from_source_btm_token", this.btmPreSetFromSourceBtmToken);     // Catch: Throwable -> L6
        r0.put("update_token_this_display", this.updateBySourceBtmTokenInThisDisplay);     // Catch: Throwable -> L6
        r0.put("btm_pre_is_token", this.btmPreIsToken);     // Catch: Throwable -> L6
        r0.put("btm_pre_has_created_token", this.btmPreHasCreatedToken);     // Catch: Throwable -> L6
        r0.put("step", this.step);     // Catch: Throwable -> L6
        r0.put("union_pre", getUnionPre());     // Catch: Throwable -> L6
        r0.put("union_step", getUnionStep());     // Catch: Throwable -> L6
        r0.put(com.bytedance.android.ec.core.event.a.KEY_PAGE_ID, getPageId());     // Catch: Throwable -> L6
        r0.put("enter_time", this.enterTime);     // Catch: Throwable -> L6
        r0.put(com.bytedance.android.ec.core.event.a.KEY_DURATION, this.duration);     // Catch: Throwable -> L6
        r0.put("first_show", this.firstShow);     // Catch: Throwable -> L6
        r0.put("scene", this.scene);     // Catch: Throwable -> L6
        r0.put("page_show_id", this.pageShowId);     // Catch: Throwable -> L6
        r0.put("last_page_show_id", this.lastPageShowId);     // Catch: Throwable -> L6
        r0.put("last_resume_time", this.lastResumeTime);     // Catch: Throwable -> L6
        r0.put("last_pause_time", this.lastPauseTime);     // Catch: Throwable -> L6
        r0.put("is_first_page", this.isFirstPage);     // Catch: Throwable -> L6
        r0.put("has_send_enter_page", this.hasSendEnterPage);     // Catch: Throwable -> L6
        r0.put("btm_instance_id", this.instanceId);     // Catch: Throwable -> L6
        r0.put("is_before_first_resume", this.isBeforeFirstResume);     // Catch: Throwable -> L6
        r0.put("reuse", this.reuse);     // Catch: Throwable -> L6
    L5:
        return r0.toString();
    }

    public PageInfo() {
        this.TAG_CLASS_PREFIX = "PageInfo_";
        this.TAG_SETPROP = "PageInfo_setProp";
        this.TAG_PUTSOURCEBTM = "PageInfo_putSourceBtm";
        this.TAG_ONRESUME = "PageInfo_onResume";
        this.TAG_ONPAUSE = "PageInfo_onPause";
        this.TAG_PARSEPAGEBTM = "PageInfo_parsePageBtm";
        this.TAG_UPDATE_SHOW_ID = "PageInfo_updateShowId";
        AtomicLong r0 = com.bytedance.android.btm.impl.util.e.a;
        String r1 = UUID.randomUUID().toString();
        this.instanceId = r1;
        this.pageShowId = com.bytedance.android.btm.impl.util.e.a(r1, null);
        this.lastPageShowId = "";
        this.step = 1;
        this.scene = "normal";
        this.isBeforeFirstResume = true;
    }

    public String save() {
        return toString();
    }

    public final String getBtmPre() {
        return this.btmPre;
    }

    public final boolean getBtmPreHasCreatedToken() {
        return this.btmPreHasCreatedToken;
    }

    public final boolean getBtmPreIsToken() {
        return this.btmPreIsToken;
    }

    public final boolean getBtmPreSetFromSourceBtmToken() {
        return this.btmPreSetFromSourceBtmToken;
    }

    public final String getClassSimpleName() {
        return this.classSimpleName;
    }

    public final long getDuration() {
        return this.duration;
    }

    public final UnionBufferBtm getEarlierUnionBuffer() {
        return this.earlierUnionBuffer;
    }

    public final boolean getEnterPage() {
        return this.enterPage;
    }

    public final long getEnterTime() {
        return this.enterTime;
    }

    public final Boolean getFirstShow() {
        return this.firstShow;
    }

    public final boolean getHasSendEnterPage() {
        return this.hasSendEnterPage;
    }

    public final String getInstanceId() {
        return this.instanceId;
    }

    public final String getLastPageShowId() {
        return this.lastPageShowId;
    }

    public final long getLastPauseTime() {
        return this.lastPauseTime;
    }

    public final long getLastResumeTime() {
        return this.lastResumeTime;
    }

    public final String getLatestBtmId() {
        return this.b;
    }

    public final com.bytedance.android.btm.api.model.b getLatestBtmIdNode() {
        return this.d;
    }

    public final String getLatestPageBtmId() {
        return this.c;
    }

    public final com.bytedance.android.btm.api.model.b getLatestPageBtmIdNode() {
        return this.e;
    }

    public final boolean getNeedUpdateShowIdWhenResume() {
        return this.needUpdateShowIdWhenResume;
    }

    public final String getPageShowId() {
        return this.pageShowId;
    }

    public final com.bytedance.android.btm.api.model.b getPreBtmIdNode() {
        return this.a;
    }

    public final boolean getReuse() {
        return this.reuse;
    }

    public final String getScene() {
        return this.scene;
    }

    public final int getStep() {
        return this.step;
    }

    public final boolean getUpdateBySourceBtmTokenInThisDisplay() {
        return this.updateBySourceBtmTokenInThisDisplay;
    }

    public final boolean isBeforeFirstResume() {
        return this.isBeforeFirstResume;
    }

    public final boolean isFirstPage() {
        return this.isFirstPage;
    }

    public final PageInfo copy(PageInfo r10) {
        r10.setPageId(getPageId());
        r10.btmPre = this.btmPre;
        r10.setPageBtm(getPageBtm());
        r10.step = this.step;
        r10.enterTime = this.enterTime;
        r10.duration = this.duration;
        r10.lastResumeTime = this.lastResumeTime;
        r10.lastPauseTime = this.lastPauseTime;
        r10.firstShow = this.firstShow;
        r10.setClassName(getClassName());
        r10.scene = this.scene;
        r10.isFirstPage = this.isFirstPage;
        r10.isBeforeFirstResume = this.isBeforeFirstResume;
        r10.pageShowId = this.pageShowId;
        r10.lastPageShowId = this.lastPageShowId;
        r10.instanceId = this.instanceId;
        r10.setUnionPre(getUnionPre());
        r10.setUnionStep(getUnionStep());
        r10.earlierUnionBuffer = this.earlierUnionBuffer;
        r10.b = this.b;
        r10.c = this.c;
        r10.btmPreSetFromSourceBtmToken = this.btmPreSetFromSourceBtmToken;
        r10.updateBySourceBtmTokenInThisDisplay = this.updateBySourceBtmTokenInThisDisplay;
        r10.btmPreIsToken = this.btmPreIsToken;
        r10.btmPreHasCreatedToken = this.btmPreHasCreatedToken;
        r10.reuse = this.reuse;
        return r10;
    }

    public final void onResume(ResumeFuncOrigin r10) {
        updateShowIdIfNeed(ShowIdUpdateReason.PageInfoResume);
        onlyResume(r10);
        PageShowLog.e.getClass();
        PageShowLog.g(this, r10);
    }

    public final void onlyResume(final ResumeFuncOrigin r10) {
        if (BtmPageLifecycleCallbackV2.a == false) goto L5;
        this.isFirstPage = true;
        BtmPageLifecycleCallbackV2.a = false;
    L5:
        this.isBeforeFirstResume = false;
        final PageInfo r0 = copy();
        ALogger r11 = ALogger.d;
        ALogger.j(r11, this.TAG_ONRESUME, new C02331(r0, r10));
        this.lastResumeTime = SystemClock.elapsedRealtime();
        if (this.enterTime > 0) goto L9;
        this.enterTime = System.currentTimeMillis();
        ALogger.j(r11, this.TAG_ONRESUME, new AnonymousClass2(this));
        this.duration = 0;
    L9:
        if (this.reuse == false) goto L22;
        BtmSetting r12 = BtmSetting.d;
        if (r12.c().c().t() == 0) goto L22;
        if ((r12.c().c().t() & 1) == 0) goto L16;
        this.firstShow = null;
        this.duration = 0;
    L16:
        if ((r12.c().c().t() & 2) == 0) goto L22;
        if (this.couldUpdateInstanceId == false) goto L22;
        this.couldUpdateInstanceId = false;
        AtomicLong r1 = com.bytedance.android.btm.impl.util.e.a;
        this.instanceId = UUID.randomUUID().toString();
        if (r12.c().c().x() != 1) goto L22;
        this.pageShowId = com.bytedance.android.btm.impl.util.e.a(this.instanceId, null);
    L22:
        Boolean r13 = this.firstShow;
        if (r13 != null) goto L26;
        final boolean r14 = this.reuse;
        ALogger.j(r11, this.TAG_ONRESUME, new AnonymousClass3(r14));
        this.firstShow = Boolean.TRUE;
    L30:
        this.reuse = false;
        return;
    L26:
        if (Intrinsics.areEqual(r13, Boolean.TRUE) == false) goto L30;
        if (this.duration != 0) goto L30;
        ALogger.j(r11, this.TAG_ONRESUME, AnonymousClass4.INSTANCE);
        this.firstShow = Boolean.FALSE;
        goto L30
    }

    public PageInfo parse(String r10) {
        JSONObject r0 = new JSONObject(r10);     // Catch: Exception -> L13
        setClassName(r0.optString("class_name"));     // Catch: Exception -> L13
        String r11 = r0.optString("page_btm");     // Catch: Exception -> L13
        if (r11 != null) goto L5;
    L8:
        boolean r12 = true;
    L9:
        if (r12 == false) goto L11;
        r11 = null;
    L11:
        setPageBtm(r11);     // Catch: Exception -> L13
        this.btmPre = r0.optString("btm_pre");     // Catch: Exception -> L13
        this.btmPreSetFromSourceBtmToken = r0.optBoolean("btm_pre_from_source_btm_token");     // Catch: Exception -> L13
        this.updateBySourceBtmTokenInThisDisplay = r0.optBoolean("update_token_this_display");     // Catch: Exception -> L13
        this.btmPreIsToken = r0.optBoolean("btm_pre_is_token");     // Catch: Exception -> L13
        this.btmPreHasCreatedToken = r0.optBoolean("btm_pre_has_created_token");     // Catch: Exception -> L13
        this.step = r0.optInt("step");     // Catch: Exception -> L13
        setUnionPre(r0.optString("union_pre"));     // Catch: Exception -> L13
        setUnionStep(r0.optInt("union_step"));     // Catch: Exception -> L13
        setPageId(r0.optString(com.bytedance.android.ec.core.event.a.KEY_PAGE_ID));     // Catch: Exception -> L13
        this.enterTime = r0.optLong("enter_time");     // Catch: Exception -> L13
        this.duration = r0.optLong(com.bytedance.android.ec.core.event.a.KEY_DURATION);     // Catch: Exception -> L13
        this.firstShow = Boolean.valueOf(r0.optBoolean("first_show"));     // Catch: Exception -> L13
        this.scene = r0.optString("scene");     // Catch: Exception -> L13
        this.pageShowId = r0.optString("page_show_id");     // Catch: Exception -> L13
        this.lastPageShowId = r0.optString("last_page_show_id");     // Catch: Exception -> L13
        this.lastResumeTime = r0.optLong("last_resume_time");     // Catch: Exception -> L13
        this.lastPauseTime = r0.optLong("last_pause_time");     // Catch: Exception -> L13
        this.isFirstPage = r0.optBoolean("is_first_page");     // Catch: Exception -> L13
        this.isBeforeFirstResume = r0.optBoolean("is_before_first_resume", true);     // Catch: Exception -> L13
        this.hasSendEnterPage = r0.optBoolean("has_send_enter_page", true);     // Catch: Exception -> L13
        this.instanceId = r0.optString("btm_instance_id");     // Catch: Exception -> L13
        goto L12
    L5:
        if (r11.length() == 0) goto L8;
        r12 = false;
    L12:
        return this;
    }

    public final void parsePageBtm(final String r10) {
        if (r10 != null) goto L5;
    L8:
        boolean r11 = true;
    L9:
        if (r11 == false) goto L12;
        ALogger.j(ALogger.d, this.TAG_PARSEPAGEBTM, C02341.INSTANCE);
        return;
    L12:
        List r12 = StringsKt.split$default(r10, new String[]{"."}, false, 0, 6, null);
        if (r12.size() != 1) goto L18;
        if (StringsKt.startsWith$default((String) ListProtector.get(r12, 0), "b", false, 2, null) == false) goto L18;
        setPageBtm(BtmHostDependManager.F.d() + "." + ((String) ListProtector.get(r12, 0)) + ".c0.d0");
    L25:
        ALogger.j(ALogger.d, this.TAG_PARSEPAGEBTM, new C02352(r10));
        return;
    L18:
        if (StringsKt.contains$default(r10, "bUnknown", false, 2, null) == false) goto L21;
        setPageBtm(r10);
        goto L25
    L21:
        if (StringsKt.startsWith$default((String) ListProtector.get(r12, 0), "a", false, 2, null) == true) goto L23;
    L27:
        g$a.b(BtmMonitor.c, 1102, r10 + ", format error", null, false, 28);
        return;
    L23:
        if (r12.size() < 2) goto L27;
        setPageBtm(((String) ListProtector.get(r12, 0)) + "." + ((String) ListProtector.get(r12, 1)) + ".c0.d0");
        goto L25
    L5:
        if (r10.length() == 0) goto L8;
        r11 = false;
        goto L9
    }

    public final void setBeforeFirstResume(boolean r1) {
        this.isBeforeFirstResume = r1;
    }

    public final void setBtmPre(String r1) {
        this.btmPre = r1;
    }

    public final void setBtmPreHasCreatedToken(boolean r1) {
        this.btmPreHasCreatedToken = r1;
    }

    public final void setBtmPreIsToken(boolean r1) {
        this.btmPreIsToken = r1;
    }

    public final void setBtmPreSetFromSourceBtmToken(boolean r1) {
        this.btmPreSetFromSourceBtmToken = r1;
    }

    public final void setClassSimpleName(String r1) {
        this.classSimpleName = r1;
    }

    public final void setDuration(long r1) {
        this.duration = r1;
    }

    public final void setEarlierUnionBuffer(UnionBufferBtm r1) {
        this.earlierUnionBuffer = r1;
    }

    public final void setEnterPage(boolean r1) {
        this.enterPage = r1;
    }

    public final void setEnterTime(long r1) {
        this.enterTime = r1;
    }

    public final void setFirstPage(boolean r1) {
        this.isFirstPage = r1;
    }

    public final void setFirstShow(Boolean r1) {
        this.firstShow = r1;
    }

    public final void setHasSendEnterPage(boolean r1) {
        this.hasSendEnterPage = r1;
    }

    public final void setInstanceId(String r1) {
        this.instanceId = r1;
    }

    public final void setLastPageShowId(String r1) {
        this.lastPageShowId = r1;
    }

    public final void setLastPauseTime(long r1) {
        this.lastPauseTime = r1;
    }

    public final void setLastResumeTime(long r1) {
        this.lastResumeTime = r1;
    }

    public final void setLatestBtmId(String r1) {
        this.b = r1;
    }

    public final void setLatestBtmIdNode(com.bytedance.android.btm.api.model.b r1) {
        this.d = r1;
    }

    public final void setLatestPageBtmId(String r1) {
        this.c = r1;
    }

    public final void setLatestPageBtmIdNode(com.bytedance.android.btm.api.model.b r1) {
        this.e = r1;
    }

    public final void setNeedUpdateShowIdWhenResume(boolean r1) {
        this.needUpdateShowIdWhenResume = r1;
    }

    public final void setPageShowId(String r1) {
        this.pageShowId = r1;
    }

    public final void setPreBtmIdNode(com.bytedance.android.btm.api.model.b r1) {
        this.a = r1;
    }

    public final void setReuse(boolean r1) {
        this.reuse = r1;
    }

    public final void setScene(String r1) {
        this.scene = r1;
    }

    public final void setStep(int r1) {
        this.step = r1;
    }

    public final void setUpdateBySourceBtmTokenInThisDisplay(boolean r1) {
        this.updateBySourceBtmTokenInThisDisplay = r1;
    }

    public final void updateShowIdIfNeed(final ShowIdUpdateReason r10) {
        if (this.needUpdateShowIdWhenResume == true) goto L5;
        return;
    L5:
        if (com.bytedance.android.btm.impl.c.a == false) goto L9;
        final PageInfo r0 = copy();
        ALogger.j(ALogger.d, this.TAG_UPDATE_SHOW_ID, new C02391(r0, r10));
        this.needUpdateShowIdWhenResume = false;
        String r11 = this.pageShowId;
        this.lastPageShowId = r11;
        AtomicLong r1 = com.bytedance.android.btm.impl.util.e.a;
        this.pageShowId = com.bytedance.android.btm.impl.util.e.a(this.instanceId, r11);
        return;
    }

    /* JADX INFO: renamed from: parse */
    public /* bridge */ /* synthetic */ Object mo505parse(String r1) {
        return parse(r1);
    }

    public void onPause(Object r14, i r15) {
        final PageInfo r16 = copy();
        Flag r0 = null;
        if (r15 == null) goto L5;
        final String r1 = r15.toString();
    L6:
        ALogger.j(ALogger.d, this.TAG_ONPAUSE, new AnonymousClass1(r16, r1));
        long r10 = SystemClock.elapsedRealtime();
        this.lastPauseTime = r10;
        long r11 = this.lastResumeTime;
        if (r11 <= 0) goto L9;
        this.duration += r10 - r11;
    L10:
        BtmChainRecorder r17 = com.bytedance.android.btm.impl.b.e.c();
        r17.h.put(this.pageShowId, Long.valueOf(this.duration));
        if (r15 == null) goto L13;
        Flag r18 = r15.c;
    L15:
        if (r18 != Flag.BACKGROUND) goto L17;
        com.bytedance.android.btm.impl.util.d r19 = com.bytedance.android.btm.impl.util.d.a;
    L29:
        this.updateBySourceBtmTokenInThisDisplay = false;
        return;
    L17:
        if (r15 == null) goto L19;
        Flag r110 = r15.c;
    L21:
        if (r110 != Flag.FORWARD) goto L23;
        PageShowLog.e.k(this, r15, false);
        goto L29
    L23:
        if (r15 == null) goto L26;
        r0 = r15.c;
    L26:
        if (r0 != Flag.BACK) goto L28;
        PageShowLog.e.k(this, r15, true);
        goto L29
    L28:
        com.bytedance.android.btm.impl.util.d r111 = com.bytedance.android.btm.impl.util.d.a;
        goto L29
    L19:
        r110 = null;
        goto L21
    L13:
        r18 = null;
        goto L15
    L9:
        g$a.b(BtmMonitor.c, 1104, "lastResumeTime is " + this.lastResumeTime, null, false, 28);
        goto L10
    L5:
        r1 = null;
        goto L6
    }

    public final void setProp(final PageProp r10, Object r11, PageInfoStack r12) {
        if (BtmSetting.d.c().b().i() != 1) goto L5;
        r10.setAuto(true);
    L5:
        final String r0 = r11.getClass().getName();
        ALogger.j(ALogger.d, this.TAG_SETPROP, new C02381(r10, r0));
        parsePageBtm(r10.getBtm());
        setClassName(r11.getClass().getName());
        this.classSimpleName = r11.getClass().getSimpleName();
        r12.setPageProp(r10);
    }

    public static /* synthetic */ void onPause$default(PageInfo r0, Object r1, i r10, int r11, Object r12) {
        if (r12 != null) goto L9;
        if ((r11 & 2) == 0) goto L6;
        r10 = null;
    L6:
        r0.onPause(r1, r10);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onPause");
    }

    public final void putSourceBtm(final String r10, final int r11, final String r12, boolean r13, boolean r14) {
        ALogger.j(ALogger.d, this.TAG_PUTSOURCEBTM, new C02361(this, r10, r11, r12));
        if (Intrinsics.areEqual(getPageId(), r12) == false) goto L6;
        g$a.b(BtmMonitor.c, 1123, "pre=" + r10 + ", step=" + r11, null, false, 28);
        return;
    L6:
        if (r13 == false) goto L8;
        reset();
    L8:
        this.btmPre = r10;
        this.step = r11;
        this.btmPreIsToken = r14;
        boolean r15 = true;
        if (r14 == false) goto L11;
        this.btmPreHasCreatedToken = true;
        return;
    L11:
        Map<String, BufferBtm> r16 = BufferQueue.k;
        monitor-enter(r16);
        Iterator<Map.Entry<String, BufferBtm>> r17 = r16.entrySet().iterator();     // Catch: Throwable -> L25
    L15:
        if (r17.hasNext() == false) goto L20;
        Map.Entry<String, BufferBtm> r18 = r17.next();     // Catch: Throwable -> L25
        Lazy r0 = BtmFormatUtils.a;     // Catch: Throwable -> L25
        if (Intrinsics.areEqual(r10, BtmFormatUtils.g(r18.getKey())) == false) goto L15;
        monitor-exit(r16);
    L23:
        this.btmPreHasCreatedToken = r15;
        return;
    L20:
        Unit r19 = Unit.INSTANCE;     // Catch: Throwable -> L25
        monitor-exit(r16);
        r15 = false;
    L25:
        th = move-exception;
        throw th;
    }

    public static /* synthetic */ void putSourceBtm$default(PageInfo r10, String r11, int r12, String r13, boolean r14, boolean r15, int r16, Object r17) {
        if (r17 != null) goto L14;
        if ((r16 & 8) == 0) goto L6;
        boolean r18 = true;
    L8:
        if ((r16 & 16) == 0) goto L10;
        boolean r19 = false;
    L11:
        r10.putSourceBtm(r11, r12, r13, r18, r19);
        return;
    L10:
        r19 = r15;
        goto L11
    L6:
        r18 = r14;
        goto L8
    L14:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: putSourceBtm");
    }
}
