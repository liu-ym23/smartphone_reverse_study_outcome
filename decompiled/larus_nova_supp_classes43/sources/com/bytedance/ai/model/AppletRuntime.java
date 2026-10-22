package com.bytedance.ai.model;

import android.content.Context;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import com.byted.cast.sink.api.IServerListener;
import com.bytedance.ai.applet.app.AppletApplication;
import com.bytedance.ai.applet.services.AppletAppManagerService;
import com.bytedance.ai.core.base.SessionType;
import com.bytedance.ai.event.MessageIndication;
import com.bytedance.ai.ext.ext_sharedviewmodel.SharedViewModelExtKt;
import com.bytedance.ai.model.objects.Applet;
import com.bytedance.ai.model.objects.LLMData;
import com.bytedance.ai.model.objects.Page;
import com.bytedance.ai.model.objects.PageInfo;
import com.bytedance.ai.model.objects.RealData;
import com.bytedance.ai.model.widgets.f1;
import com.bytedance.ai.monitor.AppletErrorCode;
import com.bytedance.ai.monitor.AppletMonitorableEvent;
import com.bytedance.ai.resource.AppletResourceTool;
import com.bytedance.ai.utils.LifecycleRegistryExtKt;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.vmsdk.jsbridge.utils.JavaOnlyMap;
import com.google.gson.JsonObject;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadTimer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScopeKt;
import m5.i1;
import m5.y0;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000¦\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010$\n\u0002\b'\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b&\u0018\u0000 ¶\u00012\u00020\u00012\u00020\u0002:\u0006¶\u0001·\u0001¸\u0001B/\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\b¢\u0006\u0004\b\u000b\u0010\fJ\u001c\u0010C\u001a\u0004\u0018\u00010B2\u0006\u0010D\u001a\u00020\t2\b\b\u0002\u0010E\u001a\u00020\u001fH\u0002J\u001c\u0010F\u001a\u00020G2\u0012\u0010H\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020G0IH$J\b\u0010J\u001a\u00020GH$J\u0006\u0010F\u001a\u00020GJ\u000e\u0010K\u001a\u00020G2\u0006\u00107\u001a\u000208J\u001e\u0010L\u001a\u00020G2\n\b\u0002\u0010M\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010N\u001a\u0004\u0018\u00010\tJu\u0010O\u001a\u00020G2\u0006\u0010P\u001a\u00020Q2\b\u0010R\u001a\u0004\u0018\u00010\u00042\u0006\u0010S\u001a\u00020T2S\u0010U\u001aO\u0012\u0013\u0012\u00110W¢\u0006\f\bX\u0012\b\bY\u0012\u0004\b\b(Z\u0012\u0015\u0012\u0013\u0018\u00010\t¢\u0006\f\bX\u0012\b\bY\u0012\u0004\b\b([\u0012\u0015\u0012\u0013\u0018\u00010\t¢\u0006\f\bX\u0012\b\bY\u0012\u0004\b\b(\\\u0012\u0004\u0012\u00020\u001f0Vj\u0002`]J\u0016\u0010^\u001a\u00020\u001f2\u0006\u0010Y\u001a\u00020\t2\u0006\u0010_\u001a\u00020`J \u0010^\u001a\u00020\u001f2\u0006\u0010Y\u001a\u00020\t2\u0006\u0010_\u001a\u00020`2\b\u0010a\u001a\u0004\u0018\u00010`J\u000e\u0010b\u001a\u00020\u001fH\u0086@¢\u0006\u0002\u0010cJ\u001a\u0010d\u001a\u00020G2\u0006\u0010e\u001a\u00020\t2\n\b\u0002\u0010f\u001a\u0004\u0018\u00010gJ\u0006\u0010h\u001a\u00020.J\u000e\u0010i\u001a\u0004\u0018\u00010\t*\u00020jH\u0002Ju\u0010k\u001a\u00020G2\u0006\u0010l\u001a\u00020j2\n\b\u0002\u0010m\u001a\u0004\u0018\u00010\t2W\b\u0002\u0010n\u001aQ\u0012\u0015\u0012\u0013\u0018\u00010o¢\u0006\f\bX\u0012\b\bY\u0012\u0004\b\b(p\u0012\u0013\u0012\u00110\u001f¢\u0006\f\bX\u0012\b\bY\u0012\u0004\b\b(q\u0012\u0013\u0012\u00110\t¢\u0006\f\bX\u0012\b\bY\u0012\u0004\b\b([\u0012\u0004\u0012\u00020G\u0018\u00010Vj\u0004\u0018\u0001`rH\u0007Js\u0010s\u001a\u00020G2\u0006\u0010l\u001a\u00020j2\n\b\u0002\u0010m\u001a\u0004\u0018\u00010\t2W\b\u0002\u0010n\u001aQ\u0012\u0015\u0012\u0013\u0018\u00010o¢\u0006\f\bX\u0012\b\bY\u0012\u0004\b\b(p\u0012\u0013\u0012\u00110\u001f¢\u0006\f\bX\u0012\b\bY\u0012\u0004\b\b(q\u0012\u0013\u0012\u00110\t¢\u0006\f\bX\u0012\b\bY\u0012\u0004\b\b([\u0012\u0004\u0012\u00020G\u0018\u00010Vj\u0004\u0018\u0001`rJ¥\u0001\u0010t\u001a\u00020G2\u0006\u0010l\u001a\u00020j2\u000e\u0010u\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010v2\u0006\u0010m\u001a\u00020\t2\u0014\u0010w\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010x2\u000e\u0010y\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010v2W\b\u0002\u0010n\u001aQ\u0012\u0015\u0012\u0013\u0018\u00010o¢\u0006\f\bX\u0012\b\bY\u0012\u0004\b\b(p\u0012\u0013\u0012\u00110\u001f¢\u0006\f\bX\u0012\b\bY\u0012\u0004\b\b(q\u0012\u0013\u0012\u00110\t¢\u0006\f\bX\u0012\b\bY\u0012\u0004\b\b([\u0012\u0004\u0012\u00020G\u0018\u00010Vj\u0004\u0018\u0001`rJ±\u0001\u0010z\u001a\u00020G2\u0006\u0010{\u001a\u00020\t2\u0006\u0010|\u001a\u00020\t2\u000e\u0010u\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010v2\u0006\u0010m\u001a\u00020\t2\u0016\b\u0002\u0010w\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010x2\u0010\b\u0002\u0010y\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010v2W\b\u0002\u0010n\u001aQ\u0012\u0015\u0012\u0013\u0018\u00010o¢\u0006\f\bX\u0012\b\bY\u0012\u0004\b\b(p\u0012\u0013\u0012\u00110\u001f¢\u0006\f\bX\u0012\b\bY\u0012\u0004\b\b(q\u0012\u0013\u0012\u00110\t¢\u0006\f\bX\u0012\b\bY\u0012\u0004\b\b([\u0012\u0004\u0012\u00020G\u0018\u00010Vj\u0004\u0018\u0001`rJh\u0010}\u001a\u0004\u0018\u00010\u001f2\u0006\u0010~\u001a\u00020\t2\u0006\u0010l\u001a\u00020j2\u0006\u0010\u007f\u001a\u00020\t2\u000e\u0010u\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010v2\u0007\u0010\u0080\u0001\u001a\u00020\u001f2\u0014\u0010w\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010x2\u000e\u0010y\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010vH\u0086@¢\u0006\u0003\u0010\u0081\u0001Jt\u0010z\u001a\u0004\u0018\u00010\u001f2\u0006\u0010~\u001a\u00020\t2\u0006\u0010|\u001a\u00020\t2\u000e\u0010u\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010v2\u0006\u0010{\u001a\u00020\t2\u0006\u0010\u007f\u001a\u00020\t2\u0007\u0010\u0080\u0001\u001a\u00020\u001f2\u0016\b\u0002\u0010w\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010x2\u0010\b\u0002\u0010y\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010vH\u0086@¢\u0006\u0003\u0010\u0082\u0001J\u008d\u0001\u0010\u0083\u0001\u001a\u00020G2\u0006\u0010{\u001a\u00020\t2\u0006\u0010Z\u001a\u00020W2\t\u0010\u0084\u0001\u001a\u0004\u0018\u00010\t2\b\u0010\\\u001a\u0004\u0018\u00010\t2\u0006\u0010m\u001a\u00020\t2W\b\u0002\u0010n\u001aQ\u0012\u0015\u0012\u0013\u0018\u00010o¢\u0006\f\bX\u0012\b\bY\u0012\u0004\b\b(p\u0012\u0013\u0012\u00110\u001f¢\u0006\f\bX\u0012\b\bY\u0012\u0004\b\b(q\u0012\u0013\u0012\u00110\t¢\u0006\f\bX\u0012\b\bY\u0012\u0004\b\b([\u0012\u0004\u0012\u00020G\u0018\u00010Vj\u0004\u0018\u0001`rJ$\u0010\u0085\u0001\u001a\u00020G2\u0006\u0010f\u001a\u00020g2\u000b\b\u0002\u0010\u0086\u0001\u001a\u0004\u0018\u00010TH\u0002¢\u0006\u0003\u0010\u0087\u0001J\u000f\u0010\u0088\u0001\u001a\u00020G2\u0006\u0010f\u001a\u00020\tJ\u0018\u0010\u0089\u0001\u001a\u00020G2\u0007\u0010\u008a\u0001\u001a\u00020\t2\u0006\u0010[\u001a\u00020\tJ\u0007\u0010\u008b\u0001\u001a\u00020\u001fJ\u000f\u0010\u008c\u0001\u001a\u00020GH\u0000¢\u0006\u0003\b\u008d\u0001J\u001d\u0010\u008e\u0001\u001a\u00020G2\b\u0010R\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010{\u001a\u0004\u0018\u00010\tJ\u0011\u0010\u008f\u0001\u001a\u0004\u0018\u00010\t2\u0006\u0010{\u001a\u00020\tJ\u0011\u0010\u0090\u0001\u001a\u0004\u0018\u00010\t2\u0006\u0010{\u001a\u00020\tJ\u0012\u0010\u0091\u0001\u001a\u00020G2\t\u0010\u0092\u0001\u001a\u0004\u0018\u00010\tJ\u001d\u0010\u0093\u0001\u001a\u0004\u0018\u00010,2\u0007\u0010\u0094\u0001\u001a\u00020\u001f2\u0007\u0010\u0095\u0001\u001a\u00020\tH\u0016J\u0011\u0010\u0096\u0001\u001a\u00020G2\u0006\u0010[\u001a\u00020\tH\u0016J\u001c\u0010\u0097\u0001\u001a\u00020G2\u0006\u0010e\u001a\u00020\t2\t\u0010\u0098\u0001\u001a\u0004\u0018\u00010`H\u0016J\t\u0010\u0099\u0001\u001a\u00020GH\u0002J\t\u0010\u009a\u0001\u001a\u00020GH\u0014J\t\u0010\u009b\u0001\u001a\u00020TH\u0014J\u0010\u0010\u009c\u0001\u001a\u00020G2\u0007\u0010\u0092\u0001\u001a\u00020\tJ\u0012\u0010\u009d\u0001\u001a\u00020G2\u0007\u0010\u0092\u0001\u001a\u00020\tH\u0002J*\u0010\u009e\u0001\u001a\u00020*2\u0007\u0010\u0092\u0001\u001a\u00020\t2\n\b\u0002\u0010{\u001a\u0004\u0018\u00010\t2\f\b\u0002\u0010\u009f\u0001\u001a\u0005\u0018\u00010 \u0001J\u0012\u0010¡\u0001\u001a\u0004\u0018\u00010*2\u0007\u0010\u0092\u0001\u001a\u00020\tJ\u001c\u0010¢\u0001\u001a\u0005\u0018\u00010£\u00012\u0007\u0010\u0092\u0001\u001a\u00020\t2\u0007\u0010¤\u0001\u001a\u00020\tJ\u0019\u0010¥\u0001\u001a\u00020G2\u0007\u0010\u0092\u0001\u001a\u00020\t2\u0007\u0010¤\u0001\u001a\u00020\tJ\u0012\u0010¦\u0001\u001a\u00020G2\u0007\u0010§\u0001\u001a\u00020WH\u0014J\u0012\u0010¨\u0001\u001a\u00020G2\u0007\u0010§\u0001\u001a\u00020WH\u0014J\t\u0010±\u0001\u001a\u00020GH\u0007J\t\u0010²\u0001\u001a\u00020GH\u0007J\u0019\u0010³\u0001\u001a\u00020G2\u0007\u0010´\u0001\u001a\u00020\u001f2\u0007\u0010µ\u0001\u001a\u00020TR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001f\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R:\u0010\u0013\u001a\"\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0014j\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u0001`\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010!\u001a\u0012\u0012\u0004\u0012\u00020#0\"j\b\u0012\u0004\u0012\u00020#`$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020*0)X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020,0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010/\u001a\u000200X¦\u0004¢\u0006\u0006\u001a\u0004\b1\u00102R\u0016\u00103\u001a\u0006\u0012\u0002\b\u000304X¦\u0004¢\u0006\u0006\u001a\u0004\b5\u00106R\u001a\u00107\u001a\u0004\u0018\u000108X¦\u000e¢\u0006\f\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\"\u0010>\u001a\u0004\u0018\u00010\t2\b\u0010=\u001a\u0004\u0018\u00010\t@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b?\u0010@R\u001a\u0010A\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020B0)X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010©\u0001\u001a\u00030ª\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\b«\u0001\u0010¬\u0001R\u0012\u0010\u00ad\u0001\u001a\u0005\u0018\u00010®\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010¯\u0001\u001a\u0005\u0018\u00010°\u0001X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006¹\u0001"}, d2 = {"Lcom/bytedance/ai/model/AppletRuntime;", "Lcom/bytedance/ai/core/base/RuntimeBase;", "Landroidx/lifecycle/LifecycleOwner;", "app", "Landroid/content/Context;", "applet", "Lcom/bytedance/ai/model/objects/Applet;", "traceInfo", "", "", "", "<init>", "(Landroid/content/Context;Lcom/bytedance/ai/model/objects/Applet;Ljava/util/Map;)V", "getApp", "()Landroid/content/Context;", "getApplet", "()Lcom/bytedance/ai/model/objects/Applet;", "getTraceInfo", "()Ljava/util/Map;", "eventCommonParams", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getEventCommonParams", "()Ljava/util/HashMap;", "setEventCommonParams", "(Ljava/util/HashMap;)V", "isActive", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isDestroyed", "readyDeferred", "Lkotlinx/coroutines/CompletableDeferred;", "", "initMainJSErrorMsg", "taskCache", "Ljava/util/ArrayList;", "Ljava/lang/Runnable;", "Lkotlin/collections/ArrayList;", "_lifecycleRegistry", "Landroidx/lifecycle/LifecycleRegistry;", "hasBeenKeptAlive", "sessions", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/bytedance/ai/core/base/Session;", "aiViewModelMap", "Lcom/bytedance/ai/viewmodel/IAIViewModel;", "renderType", "Lcom/bytedance/ai/model/RenderType;", "workerType", "Lcom/bytedance/ai/model/worker/WorkerType;", "getWorkerType", "()Lcom/bytedance/ai/model/worker/WorkerType;", "workerWrapper", "Lcom/bytedance/ai/model/worker/WorkerWrapper;", "getWorkerWrapper", "()Lcom/bytedance/ai/model/worker/WorkerWrapper;", "aiBridge", "Lcom/bytedance/ai/bridge/AIBridge;", "getAiBridge", "()Lcom/bytedance/ai/bridge/AIBridge;", "setAiBridge", "(Lcom/bytedance/ai/bridge/AIBridge;)V", com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE, "mainJsResFrom", "getMainJsResFrom", "()Ljava/lang/String;", "localPluginCallbacks", "Lcom/bytedance/ai/model/AppletRuntime$LocalPluginCallbackData;", "getLocalPluginCallback", "id", "withRemove", "initializeWorker", "", "succeed", "Lkotlin/Function1;", "initializeAIBridge", "registerAIBridgeMethods", "runMainJS", "traceId", "eventType", "llmMsgReceived", "llmData", "Lcom/bytedance/ai/model/objects/LLMData;", "context", "msgReceivedTime", "", "appActionCallback", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME, "code", com.bytedance.android.ec.core.event.a.KEY_MSG, "data", "Lcom/bytedance/ai/model/AppActionCallback;", "sendAgentEvent", "payload", "Lcom/google/gson/JsonObject;", "meta", "awaitReady", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendLifecycle", "eventName", "param", "Lcom/bytedance/vmsdk/jsbridge/utils/JavaOnlyMap;", "getRenderTye", "realUrl", "Lcom/bytedance/ai/model/objects/PageInfo;", "createWebViewPage", "pageInfo", "callbackID", "jsCallback", "Lcom/bytedance/ai/api/model/view/IAIContainerView;", "appletPage", "isSuccess", "Lcom/bytedance/ai/model/JSModuleCallback;", "createPage", "generateWidgetMessageWithCallback", "suggests", "", "extra", "", "suggestsV2", "generateTextMessage", "botId", "content", "generateWidgetMessage", "questionId", "conversationId", "forHistoricalQuestion", "(Ljava/lang/String;Lcom/bytedance/ai/model/objects/PageInfo;Ljava/lang/String;Ljava/util/List;ZLjava/util/Map;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;ZLjava/util/Map;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "replyLocalPlugin", MessageIndication.MESSAGE_TYPE_MSG, "receiveMessageToWorkerJS", "msgId", "(Lcom/bytedance/vmsdk/jsbridge/utils/JavaOnlyMap;Ljava/lang/Long;)V", "onMessageToWorkerJS", "onMessageToWebViewJS", "viewId", "terminated", "terminate", "terminate$ai_sdk_release", "setAdditionalContext", "getAdditionalContext", "getGlobalAdditionalContext", "clearContext", "sessionId", "getViewModel", "isShared", "groupId", "onMessageToJS", "onMessageToAIBridge", "params", "clearAiViewModel", "cleanup", "delayTime", "unBindSession", "removeSession", "bindSession", "sessionType", "Lcom/bytedance/ai/core/base/SessionType;", "findSession", "startRuntimeTask", "Lcom/bytedance/ai/core/base/RuntimeTask;", "taskName", "finishRuntimeTask", "onIncrement", "newCount", "onDecrement", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "getLifecycle", "()Landroidx/lifecycle/Lifecycle;", "setAliveTimer", "Ljava/util/Timer;", "setAliveTimerTask", "Ljava/util/TimerTask;", "cancelAlive", "keepAlive", "setKeepAlive", "isAlive", "aliveTime", "Companion", "GlobalEventEmitter", "LocalPluginCallbackData", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AppletRuntime extends com.bytedance.ai.core.base.g implements LifecycleOwner {
    public static final AtomicInteger x = null;
    public static final long y = 0;
    public final Context g;
    public final Applet h;
    public final Map<String, Object> i;
    public HashMap<String, Object> j;
    public final AtomicBoolean k;
    public final AtomicBoolean l;
    public final CompletableDeferred<Boolean> m;
    public String n;
    public final ArrayList<Runnable> o;
    public final LifecycleRegistry p;
    public final AtomicBoolean q;
    public final ConcurrentHashMap<String, com.bytedance.ai.core.base.i> r;
    public final Map<String, a6.a> s;
    public String t;
    public final ConcurrentHashMap<String, d> u;
    public PthreadTimer v;
    public h w;

    public static final class a implements k5.j {
        public final /* synthetic */ AppletRuntime a;

        public a(AppletRuntime r1) {
            this.a = r1;
        }

        @Override // k5.j
        public final void a(AppletMonitorableEvent r10) {
            Intrinsics.checkNotNullParameter(r10, "event");
            r10.f = this.a.h.o();
            r10.g = this.a.h.o();
            r10.f("botId", this.a.h.N);
        }
    }

    public static final class b {
    }

    public static final class c {
        public static final HashSet<AppletRuntime> a = null;

        static {
            a = new HashSet();
        }

        public static void a(String r10, JavaOnlyMap r11) {
            Intrinsics.checkNotNullParameter(r10, "eventName");
            Intrinsics.checkNotNullParameter(r11, "data");
            final JavaOnlyMap r12 = new JavaOnlyMap();
            r12.put("eventName", r10);
            r12.put("data", r11);
            Iterator<AppletRuntime> r13 = a.iterator();
        L4:
            if (r13.hasNext() == false) goto L6;
            final AppletRuntime r14 = r13.next();
            AtomicInteger r0 = AppletRuntime.x;
            final Long r15 = null;
            r14.v().f(new i(r15, r14, r12));
            goto L4
        }
    }

    public static final class d {
        public final LLMData a;
        public final Function3<Integer, String, String, Boolean> b;
        public final WeakReference<Context> c;
        public final List<j2.a> d;
        public List<String> e;
        public List<String> f;

        public d() {
            throw null;
        }

        public final boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof d) == true) goto L8;
            return false;
        L8:
            d r11 = (d) r10;
            if (Intrinsics.areEqual(this.a, r11.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r11.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r11.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r11.d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r11.e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f, r11.f) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            int r0 = ((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31;
            List<String> r1 = this.e;
            int r10 = 0;
            if (r1 != null) goto L5;
            int r11 = 0;
        L6:
            int r12 = (r0 + r11) * 31;
            List<String> r13 = this.f;
            if (r13 == null) goto L11;
            r10 = r13.hashCode();
        L11:
            return r12 + r10;
        L5:
            r11 = r1.hashCode();
            goto L6
        }

        public final String toString() {
            return "LocalPluginCallbackData(llmData=" + this.a + ", callback=" + this.b + ", context=" + this.c + ", messageContents=" + this.d + ", suggests=" + this.e + ", suggestsV2=" + this.f + ')';
        }

        public final WeakReference<Context> getContext() {
            return this.c;
        }

        public d(LLMData r10, Function3 r11, WeakReference r12) {
            ArrayList r0 = new ArrayList();
            Intrinsics.checkNotNullParameter(r10, "llmData");
            Intrinsics.checkNotNullParameter(r11, "callback");
            Intrinsics.checkNotNullParameter(r12, "context");
            Intrinsics.checkNotNullParameter(r0, "messageContents");
            this.a = r10;
            this.b = r11;
            this.c = r12;
            this.d = r0;
            this.e = null;
            this.f = null;
        }
    }

    public /* synthetic */ class e {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[SessionType.values().length];
            r0[SessionType.DEBUG.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[SessionType.PLAYGROUND.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public static final class f implements k5.j {
        public final /* synthetic */ AppletRuntime a;

        public f(AppletRuntime r1) {
            this.a = r1;
        }

        @Override // k5.j
        public final void a(AppletMonitorableEvent r10) {
            Intrinsics.checkNotNullParameter(r10, "event");
            r10.f = this.a.h.o();
            r10.g = this.a.h.o();
            r10.f("botId", this.a.h.N);
            r10.f("js_worker_id", this.a.v().d());
        }
    }

    public static final class g implements k5.j {
        public g() {
        }

        @Override // k5.j
        public final void a(AppletMonitorableEvent r10) {
            Intrinsics.checkNotNullParameter(r10, "event");
            r10.g(com.bytedance.android.ec.core.event.a.KEY_RESULT, true);
            r10.f(com.bytedance.android.ec.core.event.a.KEY_MSG, "evaluate main.js success");
        }
    }

    public static final class h extends TimerTask {
        public final /* synthetic */ AppletRuntime a;

        @Override // java.util.TimerTask, java.lang.Runnable
        public final void run() {
            this.a.p();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public h(AppletRuntime r1) {
            this.a = r1;
        }
    }

    public abstract d3.w u();

    public abstract j5.g<?> v();

    public abstract void w();

    public abstract void y(l r1);

    static {
        x = new AtomicInteger(0);
        y = ((long) 5) * 1000;
    }

    public final void G() {
        this.k.set(false);
        this.l.set(true);
        HashSet<AppletRuntime> r0 = c.a;
        Intrinsics.checkNotNullParameter(this, "runtime");
        c.a.remove(this);
        this.u.clear();
        Iterator r1 = ((LinkedHashMap) this.s).values().iterator();
    L4:
        if (r1.hasNext() == false) goto L35;
        ((a6.a) r1.next()).getIStorage().cleanup();
        goto L4
    L35:
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L8
        v().a();     // Catch: Throwable -> L8
        Object r11 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r12 = Result.exceptionOrNull-impl(r11);
        if (r12 == null) goto L13;
        com.bytedance.ai.utils.g.a.e("WorkerRuntime", "exception when jsWorker is terminated. " + r12);
    L13:
        this.h.g();
        D(this, "onDestroy");
        LifecycleRegistryExtKt.a(this.p, Lifecycle.Event.ON_DESTROY);
        d3.w r13 = u();
        if (r13 == null) goto L26;
        e3.a r14 = r13.i;
        if (r14 == null) goto L26;
        c4.a r15 = c4.b.a(r14);
        if (r15 == null) goto L20;
        r15.f(r14);
    L20:
        d4.b r16 = d4.c.c(r14);
        if (r16 == null) goto L23;
        r16.b(r14);
    L23:
        com.bytedance.ai.bridge.method.net.download.a r17 = com.bytedance.ai.bridge.method.net.download.n.a(r14);
        if (r17 == null) goto L26;
        r17.i(r14);
    L26:
        AppletRuntimeManager r18 = AppletRuntimeManager.INSTANCE;
        String r19 = this.h.o();
        r18.getClass();
        Intrinsics.checkNotNullParameter(r19, "appletId");
        Iterator<AppletRuntimeManager.RuntimeLifecycleListener> r20 = AppletRuntimeManager.c.iterator();
    L28:
        if (r20.hasNext() == false) goto L30;
        r20.next().onRuntimeTerminated(r19);
        goto L28
    L30:
        d3.w r21 = u();
        if (r21 == null) goto L33;
        r21.g();
    L33:
        com.bytedance.ai.utils.g.a.i("WorkerRuntime", "AppletRuntime is terminated. appletId; " + this.h.o());
        return;
    L8:
        th = move-exception;
        Result.Companion r22 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }

    public final boolean H() {
        return this.l.get();
    }

    public final void p() {
        if (this.q.get() == true) goto L5;
        return;
    L5:
        this.q.set(false);
        com.bytedance.ai.utils.g.a.d("WorkerRuntime", this.h.K + " cancel alive");
        f();
    }

    public final void x() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        y(new l(this));     // Catch: Throwable -> L4
        Object r1 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L4
    L6:
        Throwable r10 = Result.exceptionOrNull-impl(r1);
        if (r10 == null) goto L9;
        com.bytedance.ai.utils.g.a.e("WorkerRuntime", "init worker failed: " + r10.getMessage(), r10);
    L9:
        HashSet<AppletRuntime> r11 = c.a;
        Intrinsics.checkNotNullParameter(this, "runtime");
        c.a.add(this);
        LifecycleRegistryExtKt.a(this.p, Lifecycle.Event.ON_CREATE);
        return;
    L4:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L6
    }

    public final void z() {
        if (this.q.get() == false) goto L5;
        return;
    L5:
        this.q.set(true);
        g();
        com.bytedance.ai.utils.g.a.d("WorkerRuntime", this.h.K + " set alive");
    }

    public final Lifecycle getLifecycle() {
        return this.p;
    }

    @Override // com.bytedance.ai.core.base.d
    public void k() {
        G();
    }

    @Override // com.bytedance.ai.core.base.d
    public final long l() {
        return y;
    }

    public final void A(String r10) {
        Intrinsics.checkNotNullParameter(r10, "param");
        Object r11 = null;
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L9
        JSONObject r13 = sx7.a.a(r10);     // Catch: Throwable -> L9
        if (r13 == null) goto L6;
        String r14 = r13.optString("eventName");     // Catch: Throwable -> L9
    L7:
        Object r15 = Result.constructor-impl(r14);     // Catch: Throwable -> L9
    L12:
        if (Result.isFailure-impl(r15) == false) goto L14;
        r15 = null;
    L14:
        String r16 = (String) r15;
        JSONObject r17 = sx7.a.a(r10);     // Catch: Throwable -> L21
        if (r17 == null) goto L18;
        JSONObject r18 = JSONObjectProtectorUtils.getJSONObject(r17, "data");     // Catch: Throwable -> L21
    L19:
        Object r19 = Result.constructor-impl(r18);     // Catch: Throwable -> L21
    L24:
        if (Result.isFailure-impl(r19) == true) goto L27;
        r11 = r19;
    L27:
        JSONObject r20 = (JSONObject) r11;
        final JavaOnlyMap r21 = new JavaOnlyMap();
        if (r16 == null) goto L30;
        r21.put("eventName", r16);
    L30:
        if (r20 == null) goto L36;
        JavaOnlyMap r1 = new JavaOnlyMap();
        Iterator<String> r22 = r20.keys();
    L33:
        if (r22.hasNext() == false) goto L35;
        String r23 = r22.next();
        r1.put(r23, r20.get(r23));
        goto L33
    L35:
        r21.put("data", r1);
    L36:
        v().f(new n(this, r21));
        return;
    L18:
        r18 = null;
    L21:
        th = move-exception;
        Result.Companion r24 = Result.Companion;
        r19 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L24
    L6:
        r14 = null;
    L9:
        th = move-exception;
        Result.Companion r25 = Result.Companion;
        r15 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L12
    }

    @Override // com.bytedance.ai.core.base.f
    public final void h(int r10) {
        com.bytedance.ai.utils.g.a.i("WorkerRuntime", this.h.K + " refCount -1 ==> " + r10);
    }

    @Override // com.bytedance.ai.core.base.f
    public final void j(int r10) {
        com.bytedance.ai.utils.g.a.i("WorkerRuntime", this.h.K + " refCount +1 ==> " + r10);
    }

    public final com.bytedance.ai.core.base.i s(String r10) {
        Intrinsics.checkNotNullParameter(r10, "sessionId");
        return this.r.get(r10);
    }

    public static void D(AppletRuntime r1, String r10) {
        r1.getClass();
        Intrinsics.checkNotNullParameter(r10, "eventName");
        d3.w r11 = r1.u();
        if (r11 == null) goto L6;
        r11.a(r10, null);
        return;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [com.bytedance.ai.model.j, java.lang.Object] */
    public final void B(final String r10, final String r11) {
        AppletAppManagerService r0 = AppletAppManagerService.INSTANCE;
        String r1 = this.h.o();
        r0.getClass();
        AppletApplication r12 = AppletAppManagerService.a(r1);
        final com.bytedance.ai.applet.app.foundation.performance.n r13 = null;
        if (r12 == null) goto L24;
        com.bytedance.ai.applet.app.foundation.v r14 = r12.h();
        if (r14 == null) goto L24;
        com.bytedance.ai.applet.app.foundation.performance.c r15 = r14.c();
        if (r15 == null) goto L24;
        Intrinsics.checkNotNullParameter("__APP__", "moduleName");
        if (StringsKt.isBlank("__APP__") == false) goto L11;
        com.bytedance.ai.applet.app.foundation.performance.c.k("createEvaluateScriptTracker", "moduleName is blank");
        goto L24
    L11:
        Object r16 = r15.c;
        monitor-enter(r16);
    L21:
        th = move-exception;
        throw th;
    L14:
        if (r15.i == false) goto L16;
        com.bytedance.ai.applet.app.foundation.performance.n r17 = null;
    L17:
        monitor-exit(r16);
        if (r17 != null) goto L20;
        com.bytedance.ai.applet.app.foundation.performance.c.k("createEvaluateScriptTracker", "component destroyed");
        goto L24
    L20:
        r13 = r17;
        goto L24
    L16:
        r17 = new com.bytedance.ai.applet.app.foundation.performance.n(r15, System.currentTimeMillis());     // Catch: Throwable -> L21
        r15.e.put(Long.valueOf(r17.c), r17);     // Catch: Throwable -> L21
    L24:
        if (r10 == null) goto L32;
        if (r11 == null) goto L32;
        i1 r18 = y0.a;
        Intrinsics.checkNotNullParameter(r10, "traceId");
        Intrinsics.checkNotNullParameter(r11, "eventType");
        final long r19 = System.currentTimeMillis();
        com.bytedance.ai.utils.g.a.d("AppletEventMonitorManager", "onLoadMainJSStart: " + r10 + ", " + r11);
        if (Intrinsics.areEqual(r11, "applet_widget_timeline_full") == false) goto L30;
        y0.r(new m5.s(r10, r19));
        goto L32
    L30:
        if (Intrinsics.areEqual(r11, "applet_page_timeline_full") == false) goto L32;
        y0.r(new m5.t(r10, r19));
    L32:
        Applet r20 = this.h;
        final ?? r21 = new j(this, r10, r11, r13);
        r20.getClass();
        Intrinsics.checkNotNullParameter(r21, "callback");
        com.bytedance.ai.utils.f.j("begin to load main.js from gecko");
        com.bytedance.ai.monitor.b.d("applet_load_main_js", new h5.d(r20.o()));
        AppletResourceTool r22 = AppletResourceTool.a;
        r22.getClass();
        Intrinsics.checkNotNullParameter(r20, "<this>");
        String r23 = r20.P;
        final boolean r24 = false;
        if (r23 != null) goto L35;
    L38:
        boolean r25 = true;
    L39:
        if (r25 == false) goto L41;
        String r26 = r20.K + "/main.js";
    L43:
        if (h5.e.a(r20.h, "3.0") < 0) goto L45;
        boolean r27 = true;
    L46:
        if (r27 == false) goto L48;
        final String r28 = r22.j(r20, r26);
    L49:
        com.bytedance.ai.resource.security.e r29 = com.bytedance.ai.resource.security.e.a;
        String r30 = r20.P;
        r29.getClass();
        if (com.bytedance.ai.resource.security.e.c(r30) == true) goto L52;
        r24 = true;
    L52:
        AppletResourceTool.q(r20.x, r28, new h5.b(r24, r21, r28), new h5.c(r21, r28), r24);
        return;
    L48:
        r28 = r22.f(r20, r26, true);
        goto L49
    L45:
        r27 = false;
        goto L46
    L41:
        r26 = r20.P;
        goto L43
    L35:
        if (r23.length() == 0) goto L38;
        r25 = false;
        goto L39
    }

    public final void E(String r10, String r11) {
        if (r11 != null) goto L4;
        String r0 = this.h.N;
    L5:
        String r1 = x4.a.a(r0);
        if (r1 != null) goto L8;
        return;
    L8:
        o(this, r1, r11).c = r10;
        AppletRuntimeManager.INSTANCE.getClass();
        g2.b r12 = AppletRuntimeManager.d;
        if (r12 == null) goto L12;
        r12.k(r1, r0);
        return;
    L12:
        return;
    L4:
        r0 = r11;
        goto L5
    }

    public final void F(boolean r10, long r11) {
        if (r11 >= 0) goto L5;
        return;
    L5:
        h r0 = this.w;
        if (r0 == null) goto L8;
        r0.cancel();
    L8:
        this.w = null;
        PthreadTimer r1 = this.v;
        if (r1 == null) goto L11;
        r1.cancel();
    L11:
        this.v = null;
        if (r10 == true) goto L15;
        p();
        return;
    L15:
        this.v = new PthreadTimer("AppletRuntime");
        this.w = new h(this);
        z();
        PthreadTimer r12 = this.v;
        if (r12 == null) goto L19;
        r12.schedule(this.w, r11 * ((long) IServerListener.WHAT_BYTELINK_SINK_ERROR));
        return;
    }

    @Override // u4.a
    public final a6.a getViewModel(boolean r10, String r11) {
        Intrinsics.checkNotNullParameter(r11, "groupId");
        if (r10 == true) goto L5;
        a6.a r12 = (a6.a) ((LinkedHashMap) this.s).get(r11);
        if (r12 != null) goto L14;
        f1.b r13 = new f1.b(r11);
        this.s.put(r11, r13);
        return r13;
    L14:
        return r12;
    L5:
        if (getLifecycle().getCurrentState() != Lifecycle.State.DESTROYED) goto L12;
        return null;
    L12:
        return SharedViewModelExtKt.b(this, r11);
    }

    @Override // k2.r
    public final void onMessageToAIBridge(final String r10, final JsonObject r11) {
        Intrinsics.checkNotNullParameter(r10, "eventName");
        final d3.w r0 = u();
        if (r0 == null) goto L6;
        v().f(new com.bytedance.ai.model.c(r0, r10, r11));
        return;
    }

    public final void t(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "sessionId");
        Intrinsics.checkNotNullParameter(r11, "taskName");
        com.bytedance.ai.core.base.i r1 = s(r10);
        if (r1 == null) goto L19;
        Intrinsics.checkNotNullParameter(r11, "taskName");
        com.bytedance.ai.core.base.h r12 = r1.d.remove(r11);
        if (r12 == null) goto L9;
        AtomicBoolean r0 = r12.c;
        if (r0 == null) goto L9;
        r0.set(false);
    L9:
        if (r12 == null) goto L12;
        f();
    L12:
        if (r1.a() == true) goto L20;
        com.bytedance.ai.core.base.i r13 = this.r.remove(r10);
        if (r13 != null) goto L16;
        return;
    L16:
        if ((r13 instanceof com.bytedance.ai.core.base.a) == false) goto L22;
        f();
        return;
    L22:
        return;
    L20:
        return;
    }

    public AppletRuntime(Context r10, Applet r11, Map<String, Object> r12) {
        Intrinsics.checkNotNullParameter(r10, "app");
        Intrinsics.checkNotNullParameter(r11, "applet");
        this.g = r10;
        this.h = r11;
        this.i = r12;
        this.k = new AtomicBoolean(false);
        this.l = new AtomicBoolean(false);
        this.m = CompletableDeferredKt.CompletableDeferred(Boolean.FALSE);
        this.n = "";
        this.o = new ArrayList();
        this.p = new LifecycleRegistry(this);
        this.q = new AtomicBoolean(false);
        this.r = new ConcurrentHashMap();
        this.s = new LinkedHashMap();
        String r13 = r11.o;
        if (Intrinsics.areEqual(r13, "webview") == false) goto L6;
        RenderType r14 = RenderType.WEBVIEW;
    L9:
        this.u = new ConcurrentHashMap();
        r11.e();
        com.bytedance.ai.monitor.b.d("applet_init_js_worker_start", new a(this));
        return;
    L6:
        if (Intrinsics.areEqual(r13, "lynx") == false) goto L8;
        RenderType r15 = RenderType.WEBVIEW;
        goto L9
    L8:
        RenderType r16 = RenderType.WEBVIEW;
        goto L9
    }

    public static /* synthetic */ com.bytedance.ai.core.base.i o(AppletRuntime r1, String r10, String r11) {
        return r1.m(r10, r11, SessionType.CHATUI);
    }

    public final boolean C(final String r10, final JsonObject r11, final JsonObject r12) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME);
        Intrinsics.checkNotNullParameter(r11, "payload");
        if (H() == false) goto L6;
        com.bytedance.ai.utils.g.a.i("WorkerRuntime", "sendAgentEvent rejected, reason=runtime_terminated, eventName=" + r10);
        return false;
    L6:
        final d3.w r13 = u();
        if (r13 != null) goto L10;
        com.bytedance.ai.utils.g.a.i("WorkerRuntime", "sendAgentEvent rejected, reason=bridge_unavailable, eventName=" + r10);
        return false;
    L10:
        Runnable r0 = new com.bytedance.ai.model.a(this, r10, r13, r11, r12);
        if (this.k.get() == false) goto L13;
        r0.run();
        return true;
    L13:
        this.o.add(r0);
        return true;
    }

    public final com.bytedance.ai.core.base.i m(String r10, String r11, SessionType r12) {
        Intrinsics.checkNotNullParameter(r10, "sessionId");
        com.bytedance.ai.core.base.i r0 = s(r10);
        boolean r1 = true;
        if (r0 == null) goto L6;
        com.bytedance.ai.utils.g.a.i("WorkerRuntime", "bindSession(" + r0.a + ") has one --> " + r0.b);
    L21:
        this.r.putIfAbsent(r10, r0);
        if ((r0 instanceof com.bytedance.ai.core.base.a) == false) goto L30;
        if (r11 != null) goto L25;
    L28:
        if (r1 == false) goto L30;
        ((com.bytedance.ai.core.base.a) r0).getClass();
        goto L30
    L25:
        if (r11.length() == 0) goto L28;
        r1 = false;
    L30:
        return r0;
    L6:
        if (Intrinsics.areEqual(r10, "SYSTEM_CVS_ID") == true) goto L8;
    L10:
        com.bytedance.ai.utils.g.a.i("WorkerRuntime", "bindSession(" + r10 + ") create one --> " + r12);
        if (r12 != null) goto L13;
        int r13 = -1;
    L14:
        if (r13 != 1) goto L16;
        com.bytedance.ai.core.base.i r14 = com.bytedance.ai.core.base.b.e;
    L20:
        r0 = r14;
        goto L21
    L16:
        if (r13 == 2) goto L18;
        r14 = new com.bytedance.ai.core.base.a(r10);
        g();
        goto L20
    L18:
        r14 = com.bytedance.ai.core.base.e.e;
        goto L20
    L13:
        r13 = e.a[r12.ordinal()];
        goto L14
    L8:
        if (r12 != SessionType.CHATUI) goto L10;
        r12 = SessionType.DEBUG;
        goto L10
    }

    public final void r(PageInfo r19, String r20, Function3<? super k2.j, ? super Boolean, ? super String, Unit> r21) {
        Intrinsics.checkNotNullParameter(r19, "pageInfo");
        Map<String, Object> r1 = r19.getTraceInfo();
        if (r1 == null) goto L10;
        Object r10 = r1.get("trace_id");
        if (r10 == null) goto L10;
        String r11 = r10.toString();
        if (r11 == null) goto L10;
        final String r12 = r11;
    L11:
        Map<String, Object> r13 = r19.getTraceInfo();
        if (r13 == null) goto L19;
        Object r14 = r13.get("eventName");
        if (r14 == null) goto L19;
        String r15 = r14.toString();
        if (r15 == null) goto L19;
        String r16 = r15;
    L20:
        if (r12 == null) goto L23;
        if (r16 == null) goto L23;
        i1 r17 = y0.a;
        Intrinsics.checkNotNullParameter(r12, "traceId");
        final long r18 = System.currentTimeMillis();
        y0.r(new m5.v(r12, r18));
    L23:
        String r22 = r19.getPageUrl();
        boolean r23 = true;
        if (r22 != null) goto L26;
    L28:
        boolean r24 = false;
    L29:
        if (r24 == false) goto L31;
        String r25 = r19.getPageUrl();
    L50:
        String r26 = r25;
    L51:
        if (r26 != null) goto L59;
        com.bytedance.ai.utils.g.a.e("WorkerRuntime", "createWebViewPopupPage find App null");
        if (r12 == null) goto L56;
        if (r16 == null) goto L56;
        i1 r0 = y0.a;
        y0.b(r12, "createWebViewPopupPage find App null", AppletErrorCode.PAGE_NOT_FOUND.getType(), r16);
    L56:
        if (r21 == null) goto L100;
        r21.invoke(null, Boolean.FALSE, "createWebViewPopupPage find App null");
        return;
    L100:
        return;
    L59:
        if (r20 != null) goto L61;
    L64:
        if (r23 == false) goto L66;
        String r27 = r19.getPageData();
    L72:
        String r28 = r27;
    L74:
        i2.j r29 = i2.i.a;
        if (i2.i.a.a().k(this.h, r19, new k(r21)) == true) goto L95;
        return;
    L95:
        Result.Companion r30 = Result.Companion;     // Catch: Throwable -> L83
        com.bytedance.ai.model.widgets.c r31 = k2.n.a(this, r19);     // Catch: Throwable -> L83
        if (r31 == null) goto L80;
        k2.n.c(r31);     // Catch: Throwable -> L83
    L81:
        Object r32 = Result.constructor-impl(r31);     // Catch: Throwable -> L83
    L86:
        if (Result.isFailure-impl(r32) == false) goto L88;
        r32 = null;
    L88:
        k2.j r33 = (k2.j) r32;
        if (r33 != null) goto L93;
        if (r21 == null) goto L101;
        r21.invoke(null, Boolean.FALSE, "create page failed, check renderType first");
        return;
    L101:
        return;
    L93:
        AppletRuntimeManager.INSTANCE.getClass();
        r33.setEventCommonParams(AppletRuntimeManager.e);
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(com.bytedance.ai.infra.thread_pool.b.e), null, null, new AppletRuntime$createPage$1(this, r12, r16, r33, r21, r19, r28, r26, null), 3, null);
        return;
    L80:
        r31 = null;
    L83:
        th = move-exception;
        Result.Companion r34 = Result.Companion;
        r32 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L86
    L66:
        d r35 = this.u.get(r20);
        if (r35 != null) goto L69;
        return;
    L69:
        RealData r36 = r35.a.getData();
        if (r36 == null) goto L73;
        r27 = r36.getPluginParams();
        goto L72
    L73:
        r28 = null;
        goto L74
    L61:
        if (r20.length() == 0) goto L64;
        r23 = false;
        goto L64
    L31:
        String r37 = r19.getPageName();
        if (r37 != null) goto L34;
        r26 = null;
        goto L51
    L34:
        String r38 = r19.getPackageName();
        List<Page> r110 = this.h.L;
        if (r110 == null) goto L46;
        Iterator<T> r111 = r110.iterator();
    L38:
        if (r111.hasNext() == false) goto L42;
        Object r112 = r111.next();
        if (Intrinsics.areEqual(((Page) r112).pageId(), r37) == false) goto L38;
    L43:
        Page r113 = (Page) r112;
        if (r113 == null) goto L46;
        String r114 = r113.getEntry();
    L47:
        if (r114 == null) goto L49;
        r25 = AppletResourceTool.l(AppletResourceTool.a, this.h, r114);
        goto L50
    L49:
        r25 = (String) BuildersKt.runBlocking$default(null, new AppletRuntime$realUrl$1(r38, r37, r19, null), 1, null);
        goto L50
    L42:
        r112 = null;
    L46:
        r114 = null;
        goto L47
    L26:
        if (StringsKt.startsWith$default(r22, "http", false, 2, null) != true) goto L28;
        r24 = true;
    L19:
        r16 = null;
    L10:
        r12 = null;
        goto L11
    }
}
