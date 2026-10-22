package com.obric.matrix.platform.sdk.ones.account;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.dtrait.constant.DTraitConstant;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.obric.memorydata.memory.ui.automemory.settings.MemoryInfoSectionEditActivity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000Ò\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u0085\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0018\u001a\u00020\rJ\u0010\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001cJ\u0016\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"J\u000e\u0010#\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020%J\u000e\u0010&\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020%J\u001e\u0010'\u001a\u00020\u001e2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\rJ\u009c\u0001\u0010-\u001a\u00020\u001e2\u0006\u0010.\u001a\u00020\u00042\u0006\u0010/\u001a\u00020\u001c2\b\u00100\u001a\u0004\u0018\u0001012\u0010\b\u0002\u00102\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u0001032\u0018\b\u0002\u00104\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u000101\u0012\u0004\u0012\u00020\u001e\u0018\u0001052:\b\u0002\u00106\u001a4\u0012\u0013\u0012\u001108¢\u0006\f\b9\u0012\b\b:\u0012\u0004\b\b(;\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b9\u0012\b\b:\u0012\u0004\b\b(<\u0012\u0004\u0012\u00020\u001e\u0018\u0001072\u0010\b\u0002\u0010=\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u000103H\u0002JX\u0010>\u001a\u00020\u001e2\u0012\u0010?\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u001e052:\u00106\u001a6\u0012\u0013\u0012\u001108¢\u0006\f\b9\u0012\b\b:\u0012\u0004\b\b(;\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b9\u0012\b\b:\u0012\u0004\b\b(<\u0012\u0004\u0012\u00020\u001e\u0018\u000107H\u0002J\u0012\u0010@\u001a\u00020\u001e2\b\b\u0002\u0010\u001b\u001a\u00020\u001cH\u0002J^\u0010A\u001a\u00020\u001e2\u0006\u0010B\u001a\u00020\u00042\u0010\b\u0002\u00102\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u0001032<\b\u0002\u00106\u001a6\u0012\u0013\u0012\u001108¢\u0006\f\b9\u0012\b\b:\u0012\u0004\b\b(;\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b9\u0012\b\b:\u0012\u0004\b\b(<\u0012\u0004\u0012\u00020\u001e\u0018\u000107J(\u0010C\u001a\u00020\u001e2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\r2\u0006\u0010'\u001a\u00020\u001cH\u0002J\u0006\u0010D\u001a\u00020\u001eJ\u0006\u0010E\u001a\u000201JK\u0010F\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010G\u001a\u00020\u001c2\b\u0010H\u001a\u0004\u0018\u00010I2'\u0010J\u001a#\u0012\u0017\u0012\u00150Kj\u0002`L¢\u0006\f\b9\u0012\b\b:\u0012\u0004\b\b(M\u0012\u0004\u0012\u00020\u001e\u0018\u000105H\u0002J\u001e\u0010N\u001a\u00020\u001e2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\rJ\u0010\u0010N\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020\u001cH\u0002J\u0006\u0010O\u001a\u00020\u0004J\u0010\u0010P\u001a\u00020\u001c2\b\b\u0002\u0010\u001b\u001a\u00020\u001cJ\u001a\u0010Q\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\n\b\u0002\u0010H\u001a\u0004\u0018\u00010IJ0\u0010R\u001a\u0002082\u0006\u0010\u001f\u001a\u00020 2\n\b\u0002\u0010H\u001a\u0004\u0018\u00010I2\n\b\u0002\u0010S\u001a\u0004\u0018\u00010T2\b\b\u0002\u0010\u001b\u001a\u00020\u001cJf\u0010U\u001a\u00020\u001e2\u0006\u0010V\u001a\u00020\u00042\u0006\u0010B\u001a\u00020\u00042\u0010\b\u0002\u00102\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u0001032<\b\u0002\u00106\u001a6\u0012\u0013\u0012\u001108¢\u0006\f\b9\u0012\b\b:\u0012\u0004\b\b(;\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b9\u0012\b\b:\u0012\u0004\b\b(<\u0012\u0004\u0012\u00020\u001e\u0018\u000107JT\u0010W\u001a\u00020\u001e2\u0010\b\u0002\u0010X\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u0001032:\b\u0002\u0010J\u001a4\u0012\u0013\u0012\u001108¢\u0006\f\b9\u0012\b\b:\u0012\u0004\b\b(;\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b9\u0012\b\b:\u0012\u0004\b\b(<\u0012\u0004\u0012\u00020\u001e\u0018\u000107J\u0006\u0010Y\u001a\u000208J{\u0010Z\u001a\u00020\u001e2\u0006\u0010V\u001a\u00020\u00042\u0006\u0010[\u001a\u00020\u00042'\b\u0002\u0010X\u001a!\u0012\u0015\u0012\u0013\u0018\u000101¢\u0006\f\b9\u0012\b\b:\u0012\u0004\b\b(0\u0012\u0004\u0012\u00020\u001e\u0018\u0001052:\b\u0002\u0010J\u001a4\u0012\u0013\u0012\u001108¢\u0006\f\b9\u0012\b\b:\u0012\u0004\b\b(;\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b9\u0012\b\b:\u0012\u0004\b\b(<\u0012\u0004\u0012\u00020\u001e\u0018\u000107J\u000e\u0010\\\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020%Jd\u0010]\u001a\u00020\u001e2\u0006\u0010^\u001a\u00020\u00042\u0006\u0010_\u001a\u0002082\u0010\b\u0002\u0010X\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u0001032:\b\u0002\u0010J\u001a4\u0012\u0013\u0012\u001108¢\u0006\f\b9\u0012\b\b:\u0012\u0004\b\b(;\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b9\u0012\b\b:\u0012\u0004\b\b(<\u0012\u0004\u0012\u00020\u001e\u0018\u000107J^\u0010`\u001a\u00020\u001e2\u0006\u0010B\u001a\u00020\u00042\u0010\b\u0002\u00102\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u0001032<\b\u0002\u00106\u001a6\u0012\u0013\u0012\u001108¢\u0006\f\b9\u0012\b\b:\u0012\u0004\b\b(;\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b9\u0012\b\b:\u0012\u0004\b\b(<\u0012\u0004\u0012\u00020\u001e\u0018\u000107J\u000e\u0010a\u001a\u00020\u001e2\u0006\u0010b\u001a\u00020\u0004J\b\u0010c\u001a\u00020\u001eH\u0002J\u001f\u0010d\u001a\u00020\u001e2\u0006\u0010e\u001a\u00020f2\n\b\u0002\u0010g\u001a\u0004\u0018\u000108¢\u0006\u0002\u0010hJ\u001f\u0010i\u001a\u00020\u001e2\u0006\u0010e\u001a\u00020f2\n\b\u0002\u0010g\u001a\u0004\u0018\u000108¢\u0006\u0002\u0010hJ\u001e\u0010j\u001a\u00020\u001e2\u0006\u0010e\u001a\u00020f2\u0006\u0010k\u001a\u00020\u00042\u0006\u0010g\u001a\u000208Jf\u0010l\u001a\u00020\u001e2\u0006\u0010m\u001a\u00020\u00042\u0006\u0010B\u001a\u00020\u00042\u0010\b\u0002\u00102\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u0001032<\b\u0002\u00106\u001a6\u0012\u0013\u0012\u001108¢\u0006\f\b9\u0012\b\b:\u0012\u0004\b\b(;\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b9\u0012\b\b:\u0012\u0004\b\b(<\u0012\u0004\u0012\u00020\u001e\u0018\u000107J\u0006\u0010n\u001a\u00020\u001eJ\u0010\u0010o\u001a\u00020\u001e2\b\u0010p\u001a\u0004\u0018\u00010qJf\u0010r\u001a\u00020\u001e2\u0006\u0010s\u001a\u00020\u00042\u0006\u0010t\u001a\u00020\u00042\u0010\b\u0002\u00102\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u0001032<\b\u0002\u00106\u001a6\u0012\u0013\u0012\u001108¢\u0006\f\b9\u0012\b\b:\u0012\u0004\b\b(;\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b9\u0012\b\b:\u0012\u0004\b\b(<\u0012\u0004\u0012\u00020\u001e\u0018\u000107Jf\u0010u\u001a\u00020\u001e2\u0006\u0010v\u001a\u0002012\b\u0010w\u001a\u0004\u0018\u00010\u00042\u0010\b\u0002\u0010X\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u0001032:\b\u0002\u0010J\u001a4\u0012\u0013\u0012\u001108¢\u0006\f\b9\u0012\b\b:\u0012\u0004\b\b(;\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b9\u0012\b\b:\u0012\u0004\b\b(<\u0012\u0004\u0012\u00020\u001e\u0018\u000107J\u0006\u0010x\u001a\u00020\u001eJ\u0010\u0010y\u001a\u00020\u001e2\b\u0010p\u001a\u0004\u0018\u00010zJs\u0010{\u001a\u00020\u001e2\u0006\u0010|\u001a\u00020\u00042'\b\u0002\u0010X\u001a!\u0012\u0015\u0012\u0013\u0018\u000101¢\u0006\f\b9\u0012\b\b:\u0012\u0004\b\b(0\u0012\u0004\u0012\u00020\u001e\u0018\u0001052:\b\u0002\u0010J\u001a4\u0012\u0013\u0012\u001108¢\u0006\f\b9\u0012\b\b:\u0012\u0004\b\b(;\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b9\u0012\b\b:\u0012\u0004\b\b(<\u0012\u0004\u0012\u00020\u001e\u0018\u000107J}\u0010}\u001a\u00020\u001e2\u0006\u0010V\u001a\u00020\u00042\u0006\u0010B\u001a\u00020\u00042'\b\u0002\u00102\u001a!\u0012\u0015\u0012\u0013\u0018\u000101¢\u0006\f\b9\u0012\b\b:\u0012\u0004\b\b(0\u0012\u0004\u0012\u00020\u001e\u0018\u0001052<\b\u0002\u00106\u001a6\u0012\u0013\u0012\u001108¢\u0006\f\b9\u0012\b\b:\u0012\u0004\b\b(;\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b9\u0012\b\b:\u0012\u0004\b\b(<\u0012\u0004\u0012\u00020\u001e\u0018\u000107J}\u0010~\u001a\u00020\u001e2\u0006\u0010V\u001a\u00020\u00042\u0006\u0010B\u001a\u00020\u00042'\b\u0002\u00102\u001a!\u0012\u0015\u0012\u0013\u0018\u000101¢\u0006\f\b9\u0012\b\b:\u0012\u0004\b\b(0\u0012\u0004\u0012\u00020\u001e\u0018\u0001052<\b\u0002\u00106\u001a6\u0012\u0013\u0012\u001108¢\u0006\f\b9\u0012\b\b:\u0012\u0004\b\b(;\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b9\u0012\b\b:\u0012\u0004\b\b(<\u0012\u0004\u0012\u00020\u001e\u0018\u000107J\u0085\u0001\u0010\u007f\u001a\u00020\u001e2\u0006\u0010V\u001a\u00020\u00042\u0006\u0010[\u001a\u00020\u00042\u0006\u0010_\u001a\u0002082'\b\u0002\u00102\u001a!\u0012\u0015\u0012\u0013\u0018\u000101¢\u0006\f\b9\u0012\b\b:\u0012\u0004\b\b(0\u0012\u0004\u0012\u00020\u001e\u0018\u0001052<\b\u0002\u00106\u001a6\u0012\u0013\u0012\u001108¢\u0006\f\b9\u0012\b\b:\u0012\u0004\b\b(;\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b9\u0012\b\b:\u0012\u0004\b\b(<\u0012\u0004\u0012\u00020\u001e\u0018\u000107J\u0014\u0010\u0080\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0081\u0001J\u0018\u0010\u0082\u0001\u001a\u000208*\u0004\u0018\u0001012\u0007\u0010\u0083\u0001\u001a\u000208H\u0002J\u0017\u0010\u0084\u0001\u001a\u00020\u0004*\u0004\u0018\u0001012\u0006\u0010\u0005\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0086\u0001"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/account/OAccount;", "", "()V", "TAG", "", "defaultErrorMsg", "getDefaultErrorMsg", "()Ljava/lang/String;", "defaultErrorMsg$delegate", "Lkotlin/Lazy;", "initCountDownLatch", "Ljava/util/concurrent/CountDownLatch;", "mAccountBridge", "Lcom/obric/matrix/platform/sdk/ones/account/api/IAccountBridge;", "mAccountManager", "Lcom/obric/matrix/platform/sdk/ones/account/api/IAccountManager;", "mAccountService", "Lcom/obric/matrix/platform/sdk/ones/account/IAccountService;", "mAccountServiceCon", "Landroid/content/ServiceConnection;", "mCallbackHandler", "Landroid/os/Handler;", "mInit", "Ljava/util/concurrent/atomic/AtomicBoolean;", "accountBridge", "accountInfo", "Lcom/obric/matrix/platform/sdk/ones/account/AccountInfo;", "waitAccountInit", "", "accountLaunchIntent", "", "context", "Landroid/content/Context;", MemorySourceLinkType.INTENT, "Landroid/content/Intent;", "addAccountStatusListener", "accountStatusListener", "Lcom/obric/matrix/platform/sdk/ones/account/api/IAccountStatusListener;", "addSecureAccountStatusListener", "asyncInit", "application", "Landroid/app/Application;", "logger", "Lcom/obric/matrix/platform/sdk/ones/account/api/ILogger;", "bridge", "asyncResultCallback", "method", "success", WsConstants.KEY_EXTRA, "Landroid/os/Bundle;", "onSuccess", "Lkotlin/Function0;", "onSuccessEx", "Lkotlin/Function1;", "onFailed", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "errorCode", DTraitConstant.ERROR, "onComplete", "callAccountService", "block", "checkInit", "checkPassword", "password", "doInit", "forceUpdateAccount", "getMatrixVersionInfo", "goToHome", "newTask", "options", "Landroid/app/ActivityOptions;", "onFailedAction", "Ljava/lang/Exception;", "Lkotlin/Exception;", "e", CommonConsts.APM_INNER_EVENT_COST_INIT, "innerToken", "isLogin", "login", "loginWithCallback", "callbackIntent", "Landroid/app/PendingIntent;", "loginWithPassword", "mobile", "logout", "onSuccessAction", "logoutScene", "quickLogin", "code", "removeAccountStatusListener", "sendCode", "account", MemoryInfoSectionEditActivity.KIND_SCENE, "setInitPassword", "setLoginPhoneNumber", "phoneNumber", "startBindService", "startLogoutActivity", "activity", "Landroid/app/Activity;", "requestCode", "(Landroid/app/Activity;Ljava/lang/Integer;)V", "startSetInitPassword", "startVerifyActivity", "verifyReason", "ticketResetPassword", Api.KEY_TICKET, "updateAccountInfo", "updateAccountInfoAsync", "callback", "Lcom/obric/matrix/platform/sdk/ones/account/api/IUpdateAccountInfoCallback;", "updatePassword", "oldPassword", "newPassword", "updateUserInfo", "updateInfo", "customizedParams", "updateXttTokenMap", "updateXttTokenMapAsync", "Lcom/obric/matrix/platform/sdk/ones/account/api/IUpdateTokenMapCallback;", "uploadAvatar", "path", "verifyPassword", "verifyPasswordWithoutLogin", "verifySmsCode", "xttTokenMap", "", "getErrorCode", "defaultErrorCode", "getErrorMsg", "AsyncResultCallback", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f8078a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile AtomicBoolean f8079b;
    private static final CountDownLatch c = null;
    private static Handler d;
    private static c e;
    private static final ServiceConnection f = null;
    private static final Lazy g = null;

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001Bq\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u00128\u0010\u0007\u001a4\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b\u0012\u0018\b\u0002\u0010\u000e\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000f¢\u0006\u0002\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0010H\u0016R@\u0010\u0012\u001a4\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u0006\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0014\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/account/OAccount$AsyncResultCallback;", "Lcom/obric/matrix/platform/sdk/ones/account/IAccountActionCallback$Stub;", "methodName", "", "onSuccess", "Lkotlin/Function0;", "", "onFailed", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "errorCode", DTraitConstant.ERROR, "onSuccessEx", "Lkotlin/Function1;", "Landroid/os/Bundle;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;)V", "_onFailed", "_onSuccess", "_onSuccessEx", "onResult", "success", "", WsConstants.KEY_EXTRA, "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a extends com.obric.matrix.platform.sdk.ones.account.b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f8080a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Function0<Unit> f8081b;
        private Function2<? super Integer, ? super String, Unit> c;
        private Function1<? super Bundle, Unit> d;

        public a(String r3, Function0<Unit> r4, Function2<? super Integer, ? super String, Unit> r5, Function1<? super Bundle, Unit> r6) {
            Function0<Unit> r7 = (Function0) ZeusTransformUtils.wrapperContextForParams(r4, Function0.class, "com.obric.memorydata.plugin");
            Function2<? super Integer, ? super String, Unit> r8 = (Function2) ZeusTransformUtils.wrapperContextForParams(r5, Function2.class, "com.obric.memorydata.plugin");
            Function1<? super Bundle, Unit> r9 = (Function1) ZeusTransformUtils.wrapperContextForParams(r6, Function1.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "methodName");
            this.f8080a = r3;
            this.f8081b = r7;
            this.c = r8;
            this.d = r9;
        }

        public /* synthetic */ a(String r2, Function0 r3, Function2 r4, Function1 r5, int r6, DefaultConstructorMarker r7) {
            Function0 r8 = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
            Function2 r9 = (Function2) ZeusTransformUtils.wrapperContextForParams(r4, Function2.class, "com.obric.memorydata.plugin");
            Function1 r10 = (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin");
            if ((r6 & 8) == 0) goto L5;
            r10 = null;
        L5:
            this(r2, r8, r9, r10);
        }

        public static final /* synthetic */ void a(a r2, Function0 r3) {
            r2.f8081b = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
        }

        public static final /* synthetic */ void a(a r2, Function1 r3) {
            r2.d = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        }

        public static final /* synthetic */ void a(a r2, Function2 r3) {
            r2.c = (Function2) ZeusTransformUtils.wrapperContextForParams(r3, Function2.class, "com.obric.memorydata.plugin");
        }

        @Override // com.obric.matrix.platform.sdk.ones.account.b
        public void a(boolean r9, Bundle r10) {
            d.a(d.f8078a, this.f8080a, r9, r10, this.f8081b, this.d, this.c, (Function0) ZeusTransformUtils.preCheckCast(new OAccount$AsyncResultCallback$onResult$1(this), Function0.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\t"}, d2 = {"com/obric/matrix/platform/sdk/ones/account/OAccount$mAccountServiceCon$1", "Landroid/content/ServiceConnection;", "onServiceConnected", "", ActivityLifecycle.NAME, "Landroid/content/ComponentName;", "service", "Landroid/os/IBinder;", "onServiceDisconnected", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class b implements ServiceConnection {
        b() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName r2, IBinder r3) {
            IBinder r1 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r2, ActivityLifecycle.NAME);
            Intrinsics.checkNotNullParameter(r1, "service");
            com.obric.matrix.platform.sdk.ones.account.b.a.b("AccountSDK_OAccount", "onServiceConnected: ");
            d r4 = d.f8078a;
            d.a(c.a.a(r1));
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName r2) {
            Intrinsics.checkNotNullParameter(r2, ActivityLifecycle.NAME);
            com.obric.matrix.platform.sdk.ones.account.b.a.c("AccountSDK_OAccount", "onServiceDisconnected: name=" + r2);
            d r1 = d.f8078a;
            d.a(null);
            d.a(d.f8078a);
        }
    }

    static {
        f8078a = new d();
        f8079b = new AtomicBoolean(false);
        c = new CountDownLatch(1);
        d = new Handler(Looper.getMainLooper());
        f = (ServiceConnection) ZeusTransformUtils.preCheckCast(new b(), ServiceConnection.class, "com.obric.memorydata.plugin");
        g = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(OAccount$defaultErrorMsg$2.INSTANCE, Function0.class, "com.obric.memorydata.plugin"));
    }

    private d() {
    }

    private final int a(Bundle r1, int r2) {
        if (r1 != null) goto L4;
        return r2;
    L4:
        return r1.getInt("errorCode", r2);
    }

    private final String a() {
        return (String) ZeusTransformUtils.preCheckCast(g.getValue(), String.class, "com.obric.memorydata.plugin");
    }

    private final String a(Bundle r1, String r2) {
        if (r1 == null) goto L4;
        String r0 = r1.getString(DTraitConstant.ERROR, r2);
    L5:
        if (r0 != null) goto L8;
        return r2;
    L8:
        return r0;
    L4:
        r0 = null;
        goto L5
    }

    public static final /* synthetic */ void a(c r2) {
        e = (c) ZeusTransformUtils.wrapperContextForParams(r2, c.class, "com.obric.memorydata.plugin");
    }

    public static final /* synthetic */ void a(d r0) {
        r0.b();
    }

    public static final /* synthetic */ void a(d r10, String r11, boolean r12, Bundle r13, Function0 r14, Function1 r15, Function2 r16, Function0 r17) {
        r10.a(r11, r12, r13, (Function0) ZeusTransformUtils.wrapperContextForParams(r14, Function0.class, "com.obric.memorydata.plugin"), (Function1) ZeusTransformUtils.wrapperContextForParams(r15, Function1.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.wrapperContextForParams(r16, Function2.class, "com.obric.memorydata.plugin"), (Function0) ZeusTransformUtils.wrapperContextForParams(r17, Function0.class, "com.obric.memorydata.plugin"));
    }

    static /* synthetic */ void a(d r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = true;
    L5:
        r0.a(r1);
    }

    private final void a(final String r11, final boolean r12, final Bundle r13, Function0<Unit> r14, Function1<? super Bundle, Unit> r15, Function2<? super Integer, ? super String, Unit> r16, Function0<Unit> r17) {
        final Function0 r7 = (Function0) ZeusTransformUtils.wrapperContextForParams(r14, Function0.class, "com.obric.memorydata.plugin");
        final Function1 r5 = (Function1) ZeusTransformUtils.wrapperContextForParams(r15, Function1.class, "com.obric.memorydata.plugin");
        final Function2 r9 = (Function2) ZeusTransformUtils.wrapperContextForParams(r16, Function2.class, "com.obric.memorydata.plugin");
        final Function0 r8 = (Function0) ZeusTransformUtils.wrapperContextForParams(r17, Function0.class, "com.obric.memorydata.plugin");
        d.post(new $$Lambda$d$YkYDrJywHhVxyQ6MjjjQ6aYD8xs(r12, r11, r5, r13, r7, r8, r9));
    }

    private final void a(boolean r9) {
        boolean r8 = f8079b.get();
        if (r9 == false) goto L10;
        if (r8 == false) goto L14;
        return;
    L14:
        c.await(3000, TimeUnit.MILLISECONDS);     // Catch: Exception -> L8
        return;
    L9:
        throw new AccountException(1002, "account init timeout", null, 4, null);
    L10:
        if (r8 == false) goto L13;
        return;
    L13:
        throw new AccountException(1001, "please call init first ", null, 4, null);
    }

    private static final void a(boolean r3, String r4, Function1 r5, Bundle r6, Function0 r7, Function0 r8, Function2 r9) {
        Function1 r10 = (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin");
        Function0 r11 = (Function0) ZeusTransformUtils.wrapperContextForParams(r7, Function0.class, "com.obric.memorydata.plugin");
        Function0 r12 = (Function0) ZeusTransformUtils.wrapperContextForParams(r8, Function0.class, "com.obric.memorydata.plugin");
        Function2 r13 = (Function2) ZeusTransformUtils.wrapperContextForParams(r9, Function2.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "$method");
        if (r3 == false) goto L11;
        com.obric.matrix.platform.sdk.ones.account.b.a.a("AccountSDK_OAccount", "asyncResult, " + r4 + ", success");
        if (r10 == null) goto L7;
        r10.invoke(r6);
    L9:
        if (r12 == null) goto L17;
    L15:
        r12.invoke();
        return;
    L17:
        return;
    L7:
        if (r11 == null) goto L9;
        r11.invoke();
        goto L9
    L11:
        d r14 = f8078a;
        int r15 = r14.a(r6, -1);
        String r16 = r14.a();
        Intrinsics.checkNotNullExpressionValue(r16, "defaultErrorMsg");
        String r17 = r14.a(r6, r16);
        com.obric.matrix.platform.sdk.ones.account.b.a.d("AccountSDK_OAccount", "asyncResult, " + r4 + " failed. errorCode: " + r15 + " errorMsg: " + r17 + '.');
        if (r13 == null) goto L14;
        r13.invoke(Integer.valueOf(r15), r17);
    L14:
        if (r12 != null) goto L15;
    }

    private final void b() {
        a(this, false, 1, null);
        com.obric.matrix.platform.sdk.ones.account.b.a.b("AccountSDK_OAccount", "startBindService: ");
        Intent r3 = new Intent();
        r3.setClassName("com.obric.matrix", "com.obric.matrix.account.service.OAccountService");
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L8
        d r6 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L8
        if (ZeusTransformUtils.bindService((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.obric.matrix.platform.sdk.ones.account.a.f8070a.b(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r3, f, 1, "com.obric.memorydata.plugin") == true) goto L6;
        com.obric.matrix.platform.sdk.ones.account.b.a.d("AccountSDK_OAccount", "startBindService: failed");     // Catch: Throwable -> L8
    L6:
        Object r7 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r8 = Result.m1424exceptionOrNullimpl(r7);
        if (r8 == null) goto L16;
        com.obric.matrix.platform.sdk.ones.account.b.a.f8074a.d("AccountSDK_OAccount", "onFailure startBindService: failed", r8);
        return;
    L16:
        return;
    L8:
        th = move-exception;
        Result.Companion r0 = Result.Companion;
        r7 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

    public static /* synthetic */ void lambda$YkYDrJywHhVxyQ6MjjjQ6aYD8xs(boolean r0, String r1, Function1 r2, Bundle r3, Function0 r4, Function0 r5, Function2 r6) {
        a(r0, r1, r2, r3, r4, r5, r6);
    }
}
