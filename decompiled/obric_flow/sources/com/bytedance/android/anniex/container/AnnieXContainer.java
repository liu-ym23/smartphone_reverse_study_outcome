package com.bytedance.android.anniex.container;

import ai.j0;
import android.R;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.FrameLayout;
import androidx.annotation.Keep;
import androidx.annotation.UiThread;
import androidx.core.graphics.Insets;
import androidx.core.view.WindowInsetsCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ai.bridge.method.router.OpenPageMethod;
import com.bytedance.ies.bullet.core.o;
import com.bytedance.ies.bullet.deprecate.fake.ContainerBidParam;
import com.bytedance.ies.bullet.kit.web.SSWebView;
import com.bytedance.ies.bullet.service.base.CacheType;
import com.bytedance.ies.bullet.service.base.utils.KitType;
import com.bytedance.ies.bullet.service.sdk.param.LaunchMode;
import com.bytedance.ies.bullet.ui.common.DebugTagTextView;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.TemplateData;
import com.lynx.tasm.behavior.v0;
import com.obric.launcher.widget.R$layout;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(d1 = {"\u0000ä\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010%\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t*\u0006\u0085\u0002\u0088\u0002\u008c\u0002\b!\u0018\u0000 Ø\u00022\u00020\u0001:\u0002Ù\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0011\u0010\t\u001a\u0004\u0018\u00010\u0006H\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\fJ\u0017\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0012\u0010\fJ-\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\n2\u0014\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0019\u0010\u0011J\u000f\u0010\u001a\u001a\u00020\u000fH\u0014¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u000fH\u0016¢\u0006\u0004\b \u0010\u001bJ\u000f\u0010!\u001a\u00020\u000fH\u0016¢\u0006\u0004\b!\u0010\u001bJ\u000f\u0010\"\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\"\u0010#J%\u0010$\u001a\u00020\u000f2\u0014\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014H\u0016¢\u0006\u0004\b$\u0010%J'\u0010'\u001a\u00020\u000f2\u0016\u0010&\u001a\u0012\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0018\u00010\u0014H\u0016¢\u0006\u0004\b'\u0010%J\u000f\u0010(\u001a\u00020\u000fH\u0016¢\u0006\u0004\b(\u0010\u001bJ\u000f\u0010)\u001a\u00020\u000fH\u0016¢\u0006\u0004\b)\u0010\u001bJ\u000f\u0010*\u001a\u00020\u000fH\u0016¢\u0006\u0004\b*\u0010\u001bJ\u000f\u0010+\u001a\u00020\u000fH\u0017¢\u0006\u0004\b+\u0010\u001bJ\u000f\u0010,\u001a\u00020\u000fH\u0017¢\u0006\u0004\b,\u0010\u001bJ\u000f\u0010-\u001a\u00020\u000fH\u0016¢\u0006\u0004\b-\u0010\u001bJ\u0017\u0010/\u001a\u00020.2\u0006\u0010\u0013\u001a\u00020\nH\u0016¢\u0006\u0004\b/\u00100J\u0011\u00101\u001a\u0004\u0018\u00010.H\u0016¢\u0006\u0004\b1\u00102J\u0011\u00103\u001a\u0004\u0018\u00010.H\u0016¢\u0006\u0004\b3\u00102J\u0011\u00104\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b4\u0010\fJ\u000f\u00106\u001a\u000205H\u0016¢\u0006\u0004\b6\u00107J\u0011\u00109\u001a\u0004\u0018\u000108H\u0016¢\u0006\u0004\b9\u0010:J\u000f\u0010<\u001a\u00020;H\u0016¢\u0006\u0004\b<\u0010=J\u0017\u0010@\u001a\u00020\u000f2\u0006\u0010?\u001a\u00020>H\u0016¢\u0006\u0004\b@\u0010AJ\u000f\u0010B\u001a\u00020\u001cH\u0016¢\u0006\u0004\bB\u0010#J\u000f\u0010C\u001a\u00020\u001cH\u0016¢\u0006\u0004\bC\u0010#J+\u0010H\u001a\u00020\u000f\"\u0004\b\u0000\u0010D2\f\u0010F\u001a\b\u0012\u0004\u0012\u00028\u00000E2\u0006\u0010G\u001a\u00028\u0000H\u0016¢\u0006\u0004\bH\u0010IJ#\u0010K\u001a\u00020\u000f2\u0012\u0010J\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00150\u0014H\u0016¢\u0006\u0004\bK\u0010%J\u0011\u0010M\u001a\u0004\u0018\u00010LH\u0016¢\u0006\u0004\bM\u0010NJ#\u0010P\u001a\u00020\u000f2\u0012\u0010O\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00150\u0014H\u0016¢\u0006\u0004\bP\u0010%J\u0017\u0010P\u001a\u00020\u000f2\u0006\u0010O\u001a\u00020\nH\u0016¢\u0006\u0004\bP\u0010\u0011J\u001f\u0010T\u001a\u00020\u000f2\u0006\u0010R\u001a\u00020Q2\u0006\u0010S\u001a\u00020QH\u0016¢\u0006\u0004\bT\u0010UJ\u001b\u0010W\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020V0\u0014H\u0017¢\u0006\u0004\bW\u0010XJ\u0017\u0010[\u001a\u00020\u000f2\u0006\u0010Z\u001a\u00020YH\u0004¢\u0006\u0004\b[\u0010\\J\u000f\u0010]\u001a\u00020\u000fH\u0004¢\u0006\u0004\b]\u0010\u001bJ\u000f\u0010^\u001a\u00020\u000fH\u0016¢\u0006\u0004\b^\u0010\u001bJ\u0017\u0010a\u001a\u00020\u000f2\u0006\u0010`\u001a\u00020_H\u0016¢\u0006\u0004\ba\u0010bJ\r\u0010c\u001a\u00020\u001c¢\u0006\u0004\bc\u0010#J\u000f\u0010d\u001a\u00020\u000fH\u0016¢\u0006\u0004\bd\u0010\u001bJ\u000f\u0010e\u001a\u00020\u000fH\u0016¢\u0006\u0004\be\u0010\u001bJ\u000f\u0010g\u001a\u00020fH\u0016¢\u0006\u0004\bg\u0010hJ\u000f\u0010i\u001a\u00020\nH\u0016¢\u0006\u0004\bi\u0010\fJ\u000f\u0010j\u001a\u00020\u000fH\u0016¢\u0006\u0004\bj\u0010\u001bJ\r\u0010k\u001a\u00020\n¢\u0006\u0004\bk\u0010\fJ!\u0010n\u001a\u00020\u000f2\u0006\u0010l\u001a\u00020\u001c2\b\u0010m\u001a\u0004\u0018\u00010\u001cH\u0016¢\u0006\u0004\bn\u0010oJ\u0017\u0010q\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010f0pH\u0016¢\u0006\u0004\bq\u0010rJ\r\u0010s\u001a\u00020\u001c¢\u0006\u0004\bs\u0010#J/\u0010x\u001a\u00020\u000f2\u0006\u0010t\u001a\u00020Q2\u0006\u0010u\u001a\u00020Q2\u0006\u0010v\u001a\u00020Q2\u0006\u0010w\u001a\u00020QH\u0016¢\u0006\u0004\bx\u0010yJ#\u0010}\u001a\u00020\u000f2\b\u0010{\u001a\u0004\u0018\u00010z2\b\u0010|\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b}\u0010~J\r\u0010\u007f\u001a\u00020\u001c¢\u0006\u0004\b\u007f\u0010#J\u0010\u0010\u0080\u0001\u001a\u00020Q¢\u0006\u0006\b\u0080\u0001\u0010\u0081\u0001J\u000f\u0010\u0082\u0001\u001a\u00020\u001c¢\u0006\u0005\b\u0082\u0001\u0010#J\u0010\u0010\u0083\u0001\u001a\u00020Q¢\u0006\u0006\b\u0083\u0001\u0010\u0081\u0001J\u0012\u0010\u0084\u0001\u001a\u00020QH\u0007¢\u0006\u0006\b\u0084\u0001\u0010\u0081\u0001J\u001b\u0010\u0086\u0001\u001a\u00020\u001c2\u0007\u0010\u0085\u0001\u001a\u00020\nH\u0002¢\u0006\u0006\b\u0086\u0001\u0010\u0087\u0001J%\u0010\u008a\u0001\u001a\u00030\u0089\u00012\u0007\u0010\u0085\u0001\u001a\u00020\n2\u0007\u0010\u0088\u0001\u001a\u00020\nH\u0002¢\u0006\u0006\b\u008a\u0001\u0010\u008b\u0001J*\u0010\u0090\u0001\u001a\u00020\u000f2\b\u0010\u008d\u0001\u001a\u00030\u008c\u00012\f\b\u0002\u0010\u008f\u0001\u001a\u0005\u0018\u00010\u008e\u0001H\u0002¢\u0006\u0006\b\u0090\u0001\u0010\u0091\u0001J\u0011\u0010\u0092\u0001\u001a\u00020\u001cH\u0002¢\u0006\u0005\b\u0092\u0001\u0010#J\u0011\u0010\u0093\u0001\u001a\u00020;H\u0002¢\u0006\u0005\b\u0093\u0001\u0010=J\u0011\u0010\u0094\u0001\u001a\u00020\nH\u0002¢\u0006\u0005\b\u0094\u0001\u0010\fJ\u0011\u0010\u0095\u0001\u001a\u00020\nH\u0002¢\u0006\u0005\b\u0095\u0001\u0010\fJ\u001c\u0010\u0096\u0001\u001a\u00020\u000f2\b\u0010\u008d\u0001\u001a\u00030\u008c\u0001H\u0002¢\u0006\u0006\b\u0096\u0001\u0010\u0097\u0001J\u0011\u0010\u0098\u0001\u001a\u00020\u000fH\u0002¢\u0006\u0005\b\u0098\u0001\u0010\u001bJ\u0011\u0010\u0099\u0001\u001a\u00020\u000fH\u0002¢\u0006\u0005\b\u0099\u0001\u0010\u001bJ\u0011\u0010\u009a\u0001\u001a\u00020\u000fH\u0002¢\u0006\u0005\b\u009a\u0001\u0010\u001bJ\u0011\u0010\u009b\u0001\u001a\u00020\u000fH\u0002¢\u0006\u0005\b\u009b\u0001\u0010\u001bJ\u0011\u0010\u009c\u0001\u001a\u00020\u000fH\u0002¢\u0006\u0005\b\u009c\u0001\u0010\u001bJ\u0011\u0010\u009d\u0001\u001a\u00020\u001cH\u0002¢\u0006\u0005\b\u009d\u0001\u0010#J\u0011\u0010\u009e\u0001\u001a\u00020\u000fH\u0002¢\u0006\u0005\b\u009e\u0001\u0010\u001bJ\u0011\u0010\u009f\u0001\u001a\u00020\u000fH\u0002¢\u0006\u0005\b\u009f\u0001\u0010\u001bJZ\u0010¨\u0001\u001a\u00020\u000f2\u0007\u0010 \u0001\u001a\u00020Q2\u0007\u0010¡\u0001\u001a\u00020Q2\u0007\u0010¢\u0001\u001a\u00020Q2\u0007\u0010£\u0001\u001a\u00020Q2\u0007\u0010¤\u0001\u001a\u00020Q2\u0007\u0010¥\u0001\u001a\u00020Q2\u0007\u0010¦\u0001\u001a\u00020Q2\u0007\u0010§\u0001\u001a\u00020QH\u0002¢\u0006\u0006\b¨\u0001\u0010©\u0001J2\u0010\u00ad\u0001\u001a\u00020\u000f2\u0007\u0010ª\u0001\u001a\u00020\n2\u0016\u0010¬\u0001\u001a\u0011\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010«\u0001H\u0002¢\u0006\u0005\b\u00ad\u0001\u0010\u0018J*\u0010®\u0001\u001a\u00020\u001c2\u0016\u0010¬\u0001\u001a\u0011\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010«\u0001H\u0002¢\u0006\u0006\b®\u0001\u0010¯\u0001J\u001b\u0010±\u0001\u001a\u00020\u000f2\u0007\u0010°\u0001\u001a\u00020QH\u0002¢\u0006\u0006\b±\u0001\u0010²\u0001J\u0011\u0010³\u0001\u001a\u00020\u001cH\u0002¢\u0006\u0005\b³\u0001\u0010#J\u001d\u0010µ\u0001\u001a\u0004\u0018\u0001082\u0007\u0010´\u0001\u001a\u000208H\u0002¢\u0006\u0006\bµ\u0001\u0010¶\u0001J#\u0010¸\u0001\u001a\u00020\u000f2\u0007\u0010·\u0001\u001a\u00020\u001c2\u0006\u0010S\u001a\u00020QH\u0002¢\u0006\u0006\b¸\u0001\u0010¹\u0001J\u001b\u0010»\u0001\u001a\u00020\u000f2\u0007\u0010º\u0001\u001a\u00020QH\u0002¢\u0006\u0006\b»\u0001\u0010²\u0001J\u001b\u0010¼\u0001\u001a\u00020\u000f2\u0007\u0010º\u0001\u001a\u00020QH\u0002¢\u0006\u0006\b¼\u0001\u0010²\u0001J\u0011\u0010½\u0001\u001a\u00020\u000fH\u0002¢\u0006\u0005\b½\u0001\u0010\u001bJ\u0011\u0010¾\u0001\u001a\u00020\u000fH\u0002¢\u0006\u0005\b¾\u0001\u0010\u001bJ\u0011\u0010¿\u0001\u001a\u00020\u000fH\u0002¢\u0006\u0005\b¿\u0001\u0010\u001bJ\u0011\u0010À\u0001\u001a\u00020\u000fH\u0002¢\u0006\u0005\bÀ\u0001\u0010\u001bJ3\u0010Â\u0001\u001a\u00020\u000f2\u0007\u0010Á\u0001\u001a\u00020Q2\u0016\u0010¬\u0001\u001a\u0011\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010«\u0001H\u0002¢\u0006\u0006\bÂ\u0001\u0010Ã\u0001J2\u0010Æ\u0001\u001a\u00020\u000f2\n\u0010\u008f\u0001\u001a\u0005\u0018\u00010\u008e\u00012\u0007\u0010Ä\u0001\u001a\u00020_2\t\b\u0002\u0010Å\u0001\u001a\u00020\u001cH\u0002¢\u0006\u0006\bÆ\u0001\u0010Ç\u0001J\u0011\u0010È\u0001\u001a\u00020\u000fH\u0002¢\u0006\u0005\bÈ\u0001\u0010\u001bJ\u0011\u0010É\u0001\u001a\u00020\u000fH\u0002¢\u0006\u0005\bÉ\u0001\u0010\u001bJ\u0011\u0010Ê\u0001\u001a\u00020\u000fH\u0002¢\u0006\u0005\bÊ\u0001\u0010\u001bJ\u001c\u0010Í\u0001\u001a\u00020\u001c2\b\u0010Ì\u0001\u001a\u00030Ë\u0001H\u0002¢\u0006\u0006\bÍ\u0001\u0010Î\u0001J\u0011\u0010Ï\u0001\u001a\u00020\u000fH\u0002¢\u0006\u0005\bÏ\u0001\u0010\u001bJ\u0011\u0010Ð\u0001\u001a\u00020\u000fH\u0002¢\u0006\u0005\bÐ\u0001\u0010\u001bJ\u0012\u0010Ñ\u0001\u001a\u00020VH\u0002¢\u0006\u0006\bÑ\u0001\u0010Ò\u0001J\u0011\u0010Ó\u0001\u001a\u00020\u000fH\u0002¢\u0006\u0005\bÓ\u0001\u0010\u001bJ\u0015\u0010Õ\u0001\u001a\u0005\u0018\u00010Ô\u0001H\u0002¢\u0006\u0006\bÕ\u0001\u0010Ö\u0001J\u0011\u0010×\u0001\u001a\u00020\u000fH\u0002¢\u0006\u0005\b×\u0001\u0010\u001bR\u001a\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\u000f\n\u0005\b\u0003\u0010Ø\u0001\u001a\u0006\bÙ\u0001\u0010Ú\u0001R\u0018\u0010Ü\u0001\u001a\u00030Û\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÜ\u0001\u0010Ý\u0001R\u0017\u0010Þ\u0001\u001a\u00020L8\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÞ\u0001\u0010ß\u0001R\"\u0010J\u001a\u000f\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00150«\u00018\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\bJ\u0010à\u0001R\u0018\u0010â\u0001\u001a\u00030á\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bâ\u0001\u0010ã\u0001R\u001e\u0010ä\u0001\u001a\u00020f8\u0004X\u0084\u0004¢\u0006\u000f\n\u0006\bä\u0001\u0010å\u0001\u001a\u0005\bæ\u0001\u0010hR\u0019\u0010ç\u0001\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bç\u0001\u0010è\u0001R\u0019\u0010é\u0001\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bé\u0001\u0010è\u0001R\u001a\u0010ê\u0001\u001a\u00030\u008c\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bê\u0001\u0010ë\u0001R\u001b\u0010ì\u0001\u001a\u0004\u0018\u00010Q8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bì\u0001\u0010í\u0001R\u001b\u0010î\u0001\u001a\u0004\u0018\u00010Q8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bî\u0001\u0010í\u0001R\u0018\u0010ð\u0001\u001a\u00030ï\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bð\u0001\u0010ñ\u0001R\u0019\u0010ò\u0001\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bò\u0001\u0010ó\u0001R*\u0010ô\u0001\u001a\u0004\u0018\u0001088\u0000@\u0000X\u0080\u000e¢\u0006\u0017\n\u0006\bô\u0001\u0010õ\u0001\u001a\u0005\bö\u0001\u0010:\"\u0006\b÷\u0001\u0010ø\u0001R*\u0010ù\u0001\u001a\u00030\u0089\u00018\u0004@\u0004X\u0084\u000e¢\u0006\u0018\n\u0006\bù\u0001\u0010ú\u0001\u001a\u0006\bû\u0001\u0010ü\u0001\"\u0006\bý\u0001\u0010þ\u0001R\u0018\u0010\u0080\u0002\u001a\u00030ÿ\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0080\u0002\u0010\u0081\u0002R\u0018\u0010\u0083\u0002\u001a\u00030\u0082\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0083\u0002\u0010\u0084\u0002R\u0018\u0010\u0086\u0002\u001a\u00030\u0085\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0086\u0002\u0010\u0087\u0002R\u0018\u0010\u0089\u0002\u001a\u00030\u0088\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0089\u0002\u0010\u008a\u0002R\u0019\u0010\u008b\u0002\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008b\u0002\u0010ó\u0001R\u001a\u0010\u008d\u0002\u001a\u00030\u008c\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008d\u0002\u0010\u008e\u0002R\u0017\u0010Z\u001a\u00020Y8\u0002@\u0002X\u0082.¢\u0006\u0007\n\u0005\bZ\u0010\u008f\u0002R*\u0010\u0091\u0002\u001a\u00030\u0090\u00028\u0004@\u0004X\u0084.¢\u0006\u0018\n\u0006\b\u0091\u0002\u0010\u0092\u0002\u001a\u0006\b\u0093\u0002\u0010\u0094\u0002\"\u0006\b\u0095\u0002\u0010\u0096\u0002R*\u0010\u0097\u0002\u001a\u0004\u0018\u0001088\u0004@\u0004X\u0084\u000e¢\u0006\u0017\n\u0006\b\u0097\u0002\u0010õ\u0001\u001a\u0005\b\u0098\u0002\u0010:\"\u0006\b\u0099\u0002\u0010ø\u0001R\u001c\u0010\u009b\u0002\u001a\u0005\u0018\u00010\u009a\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009b\u0002\u0010\u009c\u0002R\u0019\u0010\u009d\u0002\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009d\u0002\u0010ó\u0001R\u0019\u0010Á\u0001\u001a\u00020Q8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÁ\u0001\u0010\u009e\u0002R\u0019\u0010ª\u0001\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bª\u0001\u0010è\u0001R\u001b\u0010\u009f\u0002\u001a\u0004\u0018\u00010Q8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009f\u0002\u0010í\u0001R\u001b\u0010 \u0002\u001a\u0004\u0018\u00010Q8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b \u0002\u0010í\u0001R'\u0010¬\u0001\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¬\u0001\u0010à\u0001R!\u0010´\u0001\u001a\u0004\u0018\u0001088BX\u0082\u0084\u0002¢\u0006\u000f\n\u0006\b¡\u0002\u0010¢\u0002\u001a\u0005\b£\u0002\u0010:R#\u0010¨\u0002\u001a\u0005\u0018\u00010¤\u00028FX\u0086\u0084\u0002¢\u0006\u0010\n\u0006\b¥\u0002\u0010¢\u0002\u001a\u0006\b¦\u0002\u0010§\u0002R\u0019\u0010©\u0002\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b©\u0002\u0010ó\u0001R\u0019\u0010ª\u0002\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bª\u0002\u0010ó\u0001R\u0019\u0010«\u0002\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b«\u0002\u0010ó\u0001R\u001c\u0010\u00ad\u0002\u001a\u0005\u0018\u00010¬\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u00ad\u0002\u0010®\u0002R\u0019\u0010¯\u0002\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¯\u0002\u0010ó\u0001R\u001b\u0010°\u0002\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b°\u0002\u0010õ\u0001R\u0019\u0010±\u0002\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b±\u0002\u0010ó\u0001R\u001b\u0010²\u0002\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b²\u0002\u0010õ\u0001R\u001b\u0010³\u0002\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b³\u0002\u0010õ\u0001R\u001b\u0010´\u0002\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b´\u0002\u0010õ\u0001R \u0010¶\u0002\u001a\t\u0012\u0004\u0012\u00020Q0µ\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¶\u0002\u0010·\u0002R'\u0010¸\u0002\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0006\b¸\u0002\u0010ó\u0001\u001a\u0005\b¹\u0002\u0010#\"\u0005\bº\u0002\u0010\u001fR\u0017\u0010\"\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\"\u0010ó\u0001R\u001b\u0010»\u0002\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b»\u0002\u0010è\u0001R\u0018\u0010½\u0002\u001a\u00030¼\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\b½\u0002\u0010¾\u0002R\u001c\u0010¿\u0002\u001a\u0005\u0018\u00010\u008e\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¿\u0002\u0010À\u0002R\u0019\u0010Á\u0002\u001a\u00020V8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÁ\u0002\u0010Â\u0002R@\u0010Æ\u0002\u001a+\u0012\r\u0012\u000b Ä\u0002*\u0004\u0018\u00010>0> Ä\u0002*\u0014\u0012\r\u0012\u000b Ä\u0002*\u0004\u0018\u00010>0>\u0018\u00010Å\u00020Ã\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÆ\u0002\u0010Ç\u0002R\u0017\u0010È\u0002\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÈ\u0002\u0010É\u0002R,\u0010Ë\u0002\u001a\u000f\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u000f0Ê\u00028\u0000X\u0080\u0004¢\u0006\u0010\n\u0006\bË\u0002\u0010Ì\u0002\u001a\u0006\bÍ\u0002\u0010Î\u0002R\u0019\u0010Ï\u0002\u001a\u00020Q8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÏ\u0002\u0010\u009e\u0002R\u0019\u0010Ð\u0002\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÐ\u0002\u0010ó\u0001R!\u0010Õ\u0002\u001a\u00030Ñ\u00028BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\bÒ\u0002\u0010¢\u0002\u001a\u0006\bÓ\u0002\u0010Ô\u0002R\u0018\u0010×\u0002\u001a\u0004\u0018\u00010\u00068BX\u0082\u0004¢\u0006\u0007\u001a\u0005\bÖ\u0002\u0010\b¨\u0006Ú\u0002"}, d2 = {"Lcom/bytedance/android/anniex/container/AnnieXContainer;", "Ls3/b;", "Lr3/d;", "builder", "<init>", "(Lr3/d;)V", "Ltd/a;", "getAnnieXContainerModel$anniex_release", "()Ltd/a;", "getAnnieXContainerModel", "", "getBid", "()Ljava/lang/String;", "getContainerId", "containerId", "", "bindContainerId", "(Ljava/lang/String;)V", "getCurrentUrl", "schema", "", "", "renderData", "loadSchema", "(Ljava/lang/String;Ljava/util/Map;)V", "preloadSchema", "parseSchema", "()V", "", "enable", "interceptBackPress", "(Z)V", "enterForeground", "enterBackground", "isVisibility", "()Z", "reload", "(Ljava/util/Map;)V", "templateData", "reloadTemplate", "goBack", "showError", "hideError", "showLoading", "hideLoading", "close", "Lrd/b;", "generateSchemaData", "(Ljava/lang/String;)Lrd/b;", "getSchemaData", "()Lrd/b;", "getCurrentSchema", "getBDXTag", "Lcom/bytedance/ies/bullet/service/sdk/param/LaunchMode;", "getBDXLaunchMode", "()Lcom/bytedance/ies/bullet/service/sdk/param/LaunchMode;", "Landroid/view/View;", "getKitView", "()Landroid/view/View;", "Lcom/bytedance/ies/bullet/service/base/utils/KitType;", "getKitType", "()Lcom/bytedance/ies/bullet/service/base/utils/KitType;", "Lcom/bytedance/ies/bullet/core/kit/bridge/f;", "event", "sendEvent", "(Lcom/bytedance/ies/bullet/core/kit/bridge/f;)V", "canBackPress", "canGoBack", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/lang/Class;", "clazz", "item", "registerWeakHolder", "(Ljava/lang/Class;Ljava/lang/Object;)V", "globalProps", "updateGlobalProps", "Lrb/b;", "getContextProviderFactory", "()Lrb/b;", "data", "updateData", "", "width", "height", "updateScreenMetrics", "(II)V", "", "getPerfMap", "()Ljava/util/Map;", "Ls3/f;", "uiComponent", "setUiComponent", "(Ls3/f;)V", "initUi", "observerKeyboardStatusChange", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "isPadOrFold", "onAttachToWindow", "postFirstVisibleEvent", "Landroid/content/Context;", "getSystemContext", "()Landroid/content/Context;", "getViewType", "release", "getUrl", "visible", "hasReadySendVisibleEvent", "onVisibleChange", "(ZLjava/lang/Boolean;)V", "Ljava/lang/ref/WeakReference;", "getWeakContext", "()Ljava/lang/ref/WeakReference;", "isKitViewScrollReachTop", "scrollX", "scrollY", "oldScrollX", "oldScrollY", "onWebScrollChanged", "(IIII)V", "Landroid/webkit/WebView;", "view", "url", "onWebPageFinish", "(Landroid/webkit/WebView;Ljava/lang/String;)V", "hasStatusBar", "getStatusBarHeight", "()I", "hasSystemNavBar", "getNavigationBarHeight", "getRealNavigationBarHeight", "schemaUri", "canCreateNormalBulletContext", "(Ljava/lang/String;)Z", "sessionId", "Lcom/bytedance/ies/bullet/core/e;", "initOrGetBulletContext", "(Ljava/lang/String;Ljava/lang/String;)Lcom/bytedance/ies/bullet/core/e;", "Landroid/net/Uri;", LynxResourceModule.URI_KEY, "Lcom/bytedance/ies/bullet/service/base/h;", "kitView", "bindKitView", "(Landroid/net/Uri;Lcom/bytedance/ies/bullet/service/base/h;)V", "kitViewCreateOpt", "getKitTypeWithSchema", "getSessionIdWithBundle", "getSchemaWithBundle", "createModel", "(Landroid/net/Uri;)V", "sendPendingEvent", "showNotice", "hideNotice", "showDeny", "hideDeny", "supportScreenProps", "observerKitViewLayoutChanged", "observerRootViewLayoutChanged", OpenPageMethod.ALIGN_LEFT, "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "onRootViewLayoutChanged", "(IIIIIIII)V", "foldStatus", "", "screenProps", "onFoldStatusChanged", "isBreakPointChange", "(Ljava/util/Map;)Z", "softHeight", "possiblyResizeChildOfContent4Web", "(I)V", "needAdapterKeyboard4Web", "decorView", "getContentView", "(Landroid/view/View;)Landroid/view/View;", "isShowing", "sendKeyboardStatusChangeEvent", "(ZI)V", "state", "putState", "changeState", "transferToTargetState", "initContainerColor", "setContainerColor", "setBackgroundColor", "orientation", "onOrientationChanged", "(ILjava/util/Map;)V", "configuration", "isKitViewCreate", "padAdaptation", "(Lcom/bytedance/ies/bullet/service/base/h;Landroid/content/res/Configuration;Z)V", "sendWindowSizeEvent", "updateLynxScreenMetrics", "addKitView", "Lmb/b;", "debugInfo", "showContainerTag", "(Lmb/b;)Z", "addTagView", "closeCurrentPageWhenAfterPageOpen", "getOpenTime", "()J", "bindWebOnScrollChangeListener", "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", "setSecureInfo", "Lr3/d;", "getBuilder", "()Lr3/d;", "Landroid/os/Bundle;", "bundle", "Landroid/os/Bundle;", "contextProviderFactory", "Lrb/b;", "Ljava/util/Map;", "Lcom/bytedance/android/anniex/container/j;", "lifecycleDispatcher", "Lcom/bytedance/android/anniex/container/j;", "context", "Landroid/content/Context;", "getContext", "currentBid", "Ljava/lang/String;", "currentSchema", "currentUri", "Landroid/net/Uri;", "padAdapterWidth", "Ljava/lang/Integer;", "padAdapterHeight", "Lrc/a;", "serviceContext", "Lrc/a;", "isWebViewScrollReachTop", "Z", "lynxWithScrollView", "Landroid/view/View;", "getLynxWithScrollView$anniex_release", "setLynxWithScrollView$anniex_release", "(Landroid/view/View;)V", "bulletContext", "Lcom/bytedance/ies/bullet/core/e;", "getBulletContext", "()Lcom/bytedance/ies/bullet/core/e;", "setBulletContext", "(Lcom/bytedance/ies/bullet/core/e;)V", "Lv3/b;", "annieXLynxViewClientProxy", "Lv3/b;", "Lv3/c;", "annieXWebViewClientProxy", "Lv3/c;", "com/bytedance/android/anniex/container/d", "containerInstance", "Lcom/bytedance/android/anniex/container/d;", "com/bytedance/android/anniex/container/e", "deprecatedBulletContainer", "Lcom/bytedance/android/anniex/container/e;", "kitViewHasBinded", "com/bytedance/android/anniex/container/b", "bulletLifecycle", "Lcom/bytedance/android/anniex/container/b;", "Ls3/f;", "Landroid/view/ViewGroup;", "parentViewGroup", "Landroid/view/ViewGroup;", "getParentViewGroup", "()Landroid/view/ViewGroup;", "setParentViewGroup", "(Landroid/view/ViewGroup;)V", "rootView", "getRootView", "setRootView", "Landroid/view/View$OnLayoutChangeListener;", "rootViewLayoutListener", "Landroid/view/View$OnLayoutChangeListener;", "isRootViewFirstLayout", "I", "curHorizontalBreakPoint", "curVerticalBreakPoint", "decorView$delegate", "Lkotlin/Lazy;", "getDecorView", "Landroidx/core/view/WindowInsetsCompat;", "windowInsetsCompat$delegate", "getWindowInsetsCompat", "()Landroidx/core/view/WindowInsetsCompat;", "windowInsetsCompat", "isResuming", "isRuntimeReady", "loadSuccess", "Landroid/graphics/drawable/Drawable;", "originBackground", "Landroid/graphics/drawable/Drawable;", "useCustomBackground", "errorView", "errorViewAdded", "loadingView", "noticeView", "denyView", "Ljava/util/concurrent/ArrayBlockingQueue;", "stateBlockingQueue", "Ljava/util/concurrent/ArrayBlockingQueue;", "containerVisible", "getContainerVisible", "setContainerVisible", "__containerId", "Lcom/bytedance/ies/bullet/ui/common/loader/c;", "containerLoader", "Lcom/bytedance/ies/bullet/ui/common/loader/c;", "bulletKitView", "Lcom/bytedance/ies/bullet/service/base/h;", "createViewTime", "J", "", "kotlin.jvm.PlatformType", "", "pendingEvent", "Ljava/util/List;", "synchronizedObj", "Ljava/lang/Object;", "Lkotlin/Function1;", "onSoftInputChangeListener", "Lkotlin/jvm/functions/Function1;", "getOnSoftInputChangeListener$anniex_release", "()Lkotlin/jvm/functions/Function1;", "usableHeightPrevious", "isNotRelease", "Landroid/os/Handler;", "mainHandler$delegate", "getMainHandler", "()Landroid/os/Handler;", "mainHandler", "getContainerModel", "containerModel", "Companion", "com/bytedance/android/anniex/container/a", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
@SourceDebugExtension({"SMAP\nAnnieXContainer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AnnieXContainer.kt\ncom/bytedance/android/anniex/container/AnnieXContainer\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Uri.kt\nandroidx/core/net/UriKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,1611:1\n1#2:1612\n29#3:1613\n29#3:1614\n29#3:1615\n29#3:1616\n1819#4,2:1617\n1819#4,2:1619\n*E\n*S KotlinDebug\n*F\n+ 1 AnnieXContainer.kt\ncom/bytedance/android/anniex/container/AnnieXContainer\n*L\n408#1:1613\n136#1:1614\n148#1:1615\n382#1:1616\n632#1,2:1617\n1065#1,2:1619\n*E\n"})
public abstract class AnnieXContainer implements s3.b {
    public static final a Companion = null;
    private static final String DEFAULT_UNKNOWN = "unknown";
    private static final int LOAD_RUNTIME_READY = 4;
    private static final int LOAD_STATUS_CREATE_KIT_VIEW = 2;
    private static final int LOAD_STATUS_FINISH = 3;
    private static final int LOAD_STATUS_INIT_UI = 0;
    private static final int LOAD_STATUS_PARSE_SCHEMA = 1;
    private static final int LOAD_STATUS_UNKNOWN = -1;
    private static final String TAG = "AnnieXContainer";
    private static final String VISIBLE_CHANGE_TYPE_APP = "app";
    private static final String VISIBLE_CHANGE_TYPE_PAGE = "page";
    private String __containerId;
    private final v3.b annieXLynxViewClientProxy;
    private final v3.c annieXWebViewClientProxy;
    private final r3.d builder;
    private com.bytedance.ies.bullet.core.e bulletContext;
    private com.bytedance.ies.bullet.service.base.h bulletKitView;
    private b bulletLifecycle;
    private final Bundle bundle;
    private final d containerInstance;
    private final com.bytedance.ies.bullet.ui.common.loader.c containerLoader;
    private volatile boolean containerVisible;
    private final Context context;
    private final rb.b contextProviderFactory;
    private long createViewTime;
    private Integer curHorizontalBreakPoint;
    private Integer curVerticalBreakPoint;
    private String currentBid;
    private String currentSchema;
    private Uri currentUri;
    private final Lazy decorView$delegate;
    private View denyView;
    private final e deprecatedBulletContainer;
    private View errorView;
    private boolean errorViewAdded;
    private String foldStatus;
    private final Map<String, Object> globalProps;
    private boolean isNotRelease;
    private boolean isResuming;
    private boolean isRootViewFirstLayout;
    private boolean isRuntimeReady;
    private volatile boolean isVisibility;
    private boolean isWebViewScrollReachTop;
    private boolean kitViewHasBinded;
    private final j lifecycleDispatcher;
    private boolean loadSuccess;
    private View loadingView;
    private View lynxWithScrollView;
    private final Lazy mainHandler$delegate;
    private View noticeView;
    private final Function1<Boolean, Unit> onSoftInputChangeListener;
    private int orientation;
    private Drawable originBackground;
    private Integer padAdapterHeight;
    private Integer padAdapterWidth;
    protected ViewGroup parentViewGroup;
    private final List<com.bytedance.ies.bullet.core.kit.bridge.f> pendingEvent;
    private View rootView;
    private View.OnLayoutChangeListener rootViewLayoutListener;
    private Map<String, ? extends Object> screenProps;
    private final rc.a serviceContext;
    private ArrayBlockingQueue<Integer> stateBlockingQueue;
    private final Object synchronizedObj;
    private s3.f uiComponent;
    private int usableHeightPrevious;
    private boolean useCustomBackground;
    private final Lazy windowInsetsCompat$delegate;

    static {
        Companion = new a();
    }

    public AnnieXContainer(r3.d r10) {
        Intrinsics.checkNotNullParameter(r10, "builder");
        this.builder = r10;
        this.bundle = r10.f21654c;
        this.contextProviderFactory = r10.d;
        this.globalProps = r10.e;
        j r5 = new j();
        com.bytedance.android.anniex.container.ui.b r11 = r10.f;
        if (r11 == null) goto L5;
        Intrinsics.checkNotNullParameter(r11, "lifecycle");
        r5.f3151a.add(r11);
    L5:
        this.lifecycleDispatcher = r5;
        FragmentActivity r12 = r10.f21652a;
        if (r12 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("systemContext");
        r12 = null;
    L9:
        this.context = r12;
        this.currentBid = r10.f21653b;
        this.currentSchema = "";
        this.currentUri = Uri.EMPTY;
        rc.a r13 = new rc.a(r12, com.bytedance.ies.bullet.core.h.g.f5315a);
        this.serviceContext = r13;
        this.isWebViewScrollReachTop = true;
        this.bulletContext = initOrGetBulletContext(getSchemaWithBundle(), getSessionIdWithBundle());
        this.annieXLynxViewClientProxy = new v3.b(this, r10.f21655h);
        this.annieXWebViewClientProxy = new v3.c(this, r10.g);
        this.containerInstance = new d();
        this.deprecatedBulletContainer = new e(this);
        this.bulletLifecycle = new b(this);
        this.isRootViewFirstLayout = true;
        this.foldStatus = "";
        this.decorView$delegate = LazyKt.lazy(new AnnieXContainer$decorView$2(this));
        this.windowInsetsCompat$delegate = LazyKt.lazy(new AnnieXContainer$windowInsetsCompat$2(this));
        this.loadSuccess = true;
        this.stateBlockingQueue = new ArrayBlockingQueue(10);
        com.bytedance.ies.bullet.ui.common.loader.c r14 = new com.bytedance.ies.bullet.ui.common.loader.c(r13, this.currentBid);
        this.containerLoader = r14;
        if (kitViewCreateOpt() == false) goto L12;
        hb.a r15 = r14.d(getKitTypeWithSchema(), getSessionIdWithBundle());
    L13:
        this.bulletKitView = r15;
        if (kitViewCreateOpt() == true) goto L16;
    L21:
        this.createViewTime = System.currentTimeMillis();
        this.pendingEvent = Collections.synchronizedList(new ArrayList());
        this.synchronizedObj = new Object();
        this.onSoftInputChangeListener = new AnnieXContainer$onSoftInputChangeListener$1(this);
        this.isNotRelease = true;
        this.mainHandler$delegate = LazyKt.lazy(AnnieXContainer$mainHandler$2.f3134a);
        return;
    L16:
        if (this.bulletKitView == null) goto L21;
        String r16 = getSchemaWithBundle();
        com.bytedance.ies.bullet.service.base.h r17 = this.bulletKitView;
        if (r17 == null) goto L20;
        r17.a(r16);
    L20:
        bindKitView$default(this, Uri.parse(r16), null, 2, null);
        goto L21
    L12:
        r15 = null;
        goto L13
    }

    public static final /* synthetic */ void access$bindKitView(AnnieXContainer r5, Uri r10, com.bytedance.ies.bullet.service.base.h r11) {
        r5.bindKitView(r10, r11);
    }

    public static final /* synthetic */ void access$changeState(AnnieXContainer r5, int r10) {
        r5.changeState(r10);
    }

    public static final /* synthetic */ Activity access$getActivity(AnnieXContainer r5) {
        return r5.getActivity();
    }

    public static final /* synthetic */ com.bytedance.ies.bullet.service.base.h access$getBulletKitView$p(AnnieXContainer r5) {
        return r5.bulletKitView;
    }

    public static final /* synthetic */ rb.b access$getContextProviderFactory$p(AnnieXContainer r5) {
        return r5.contextProviderFactory;
    }

    public static final /* synthetic */ String access$getCurrentBid$p(AnnieXContainer r5) {
        return r5.currentBid;
    }

    public static final /* synthetic */ String access$getCurrentSchema$p(AnnieXContainer r5) {
        return r5.currentSchema;
    }

    public static final /* synthetic */ Uri access$getCurrentUri$p(AnnieXContainer r5) {
        return r5.currentUri;
    }

    public static final /* synthetic */ View access$getDecorView(AnnieXContainer r5) {
        return r5.getDecorView();
    }

    public static final /* synthetic */ j access$getLifecycleDispatcher$p(AnnieXContainer r5) {
        return r5.lifecycleDispatcher;
    }

    public static final /* synthetic */ Integer access$getPadAdapterHeight$p(AnnieXContainer r5) {
        return r5.padAdapterHeight;
    }

    public static final /* synthetic */ Integer access$getPadAdapterWidth$p(AnnieXContainer r5) {
        return r5.padAdapterWidth;
    }

    public static final /* synthetic */ Map access$getScreenProps$p(AnnieXContainer r5) {
        return r5.screenProps;
    }

    public static final /* synthetic */ s3.f access$getUiComponent$p(AnnieXContainer r5) {
        return r5.uiComponent;
    }

    public static final /* synthetic */ void access$observerKitViewLayoutChanged(AnnieXContainer r5) {
        r5.observerKitViewLayoutChanged();
    }

    public static final /* synthetic */ void access$onRootViewLayoutChanged(AnnieXContainer r5, int r10, int r11, int r12, int r13, int r14, int r15, int r16, int r17) {
        r5.onRootViewLayoutChanged(r10, r11, r12, r13, r14, r15, r16, r17);
    }

    public static final /* synthetic */ void access$possiblyResizeChildOfContent4Web(AnnieXContainer r5, int r10) {
        r5.possiblyResizeChildOfContent4Web(r10);
    }

    public static final /* synthetic */ void access$putState(AnnieXContainer r5, int r10) {
        r5.putState(r10);
    }

    public static final /* synthetic */ void access$sendKeyboardStatusChangeEvent(AnnieXContainer r5, boolean r10, int r11) {
        r5.sendKeyboardStatusChangeEvent(r10, r11);
    }

    public static final /* synthetic */ void access$sendWindowSizeEvent(AnnieXContainer r5) {
        r5.sendWindowSizeEvent();
    }

    public static final /* synthetic */ void access$setLoadSuccess$p(AnnieXContainer r5, boolean r10) {
        r5.loadSuccess = r10;
    }

    public static final /* synthetic */ void access$setWebViewScrollReachTop$p(AnnieXContainer r5, boolean r10) {
        r5.isWebViewScrollReachTop = r10;
    }

    private final void addKitView() {
        int r5 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        oo.j.g(this, new StringBuilder("===addKitView: "));
        com.bytedance.ies.bullet.service.base.h r10 = this.bulletKitView;
        if (r10 == null) goto L7;
        View r11 = r10.a();
        if (r11 == null) goto L7;
        getParentViewGroup().addView(r11);
        this.lifecycleDispatcher.d(this.currentSchema, this);
    L7:
        sendPendingEvent();
    }

    private final void addTagView() {
        int r5 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        oo.j.g(this, new StringBuilder("===addTagView: "));
        ConcurrentHashMap r10 = mb.a.f20054a;
        mb.b r11 = mb.a.a(this.currentBid);
        String r12 = null;
        if (showContainerTag(r11) == true) goto L6;
        r11 = null;
    L6:
        if (r11 == null) goto L41;
        View r13 = LayoutInflater.from(this.context).inflate(R$layout.bullet_debug_tag_view, getParentViewGroup(), false);
        if ((r13 instanceof DebugTagTextView) == false) goto L10;
        DebugTagTextView r14 = (DebugTagTextView) r13;
    L11:
        FrameLayout.LayoutParams r15 = new FrameLayout.LayoutParams(-2, -2);
        r15.gravity = 8388661;
        getParentViewGroup().addView(r14, r15);
        if (r14 == null) goto L42;
        String r16 = getViewType();
        String r17 = r11.f20056b;
        String r18 = "";
        if (r17 != null) goto L16;
    L19:
        String r19 = "";
    L20:
        CacheType r20 = this.bulletContext.f5308w.e;
        if (r20 == null) goto L30;
        int r21 = r20.ordinal();
        if (r21 != 0) goto L26;
        r18 = "(PreRender)";
        goto L30
    L26:
        if (r21 != 1) goto L30;
        r18 = "(ReUse)";
    L30:
        StringBuilder r22 = new StringBuilder("debug tag: ");
        r22.append(r16);
        r22.append('_');
        r22.append(r19);
        com.bytedance.ies.bullet.service.base.h r23 = this.bulletKitView;
        if (r23 == null) goto L33;
        String r24 = r23.f();
    L34:
        com.bytedance.ies.bullet.base.utils.logger.a.g(TAG, j0.q(r22, r24, r18), null, 12);
        StringBuilder r25 = new StringBuilder("x-");
        com.bytedance.ies.bullet.service.base.h r26 = this.bulletKitView;
        if (r26 == null) goto L39;
        KitType r27 = r26.h();
        if (r27 == null) goto L39;
        r12 = r27.f6013a;
    L39:
        r25.append(r12);
        r25.append('-');
        r25.append(r16);
        r25.append('(');
        r25.append(this.currentBid);
        r25.append(')');
        r14.setText(r25.toString());
        com.bytedance.ies.bullet.core.h.g.getClass();
        return;
    L33:
        r24 = null;
        goto L34
    L16:
        if (r17.length() == 0) goto L19;
        r19 = j0.q(new StringBuilder(), r11.f20056b, " - ");
        goto L20
    L42:
        return;
    L10:
        r14 = null;
        goto L11
    }

    private final void bindKitView(Uri r5, com.bytedance.ies.bullet.service.base.h r10) {
        if (this.kitViewHasBinded != true) goto L5;
        return;
    L5:
        if (r10 != null) goto L7;
    L9:
        postFirstVisibleEvent();
        putState(2);
        com.bytedance.ies.bullet.service.base.h r11 = this.bulletKitView;
        if (r11 != null) goto L12;
    L14:
        this.lifecycleDispatcher.f(this.currentSchema, this);
        this.bulletContext.f5293c.l().o(r5, this.bulletKitView);
        bindWebOnScrollChangeListener();
        this.kitViewHasBinded = true;
        return;
    L12:
        if (r11.a() == null) goto L14;
        getContainerModel();
        getContainerModel();
        goto L14
    L7:
        if (kitViewCreateOpt() == true) goto L9;
        this.bulletKitView = r10;
        goto L9
    }

    public static /* synthetic */ void bindKitView$default(AnnieXContainer r5, Uri r10, com.bytedance.ies.bullet.service.base.h r11, int r12, Object r13) {
        if (r13 != null) goto L9;
        if ((r12 & 2) == 0) goto L6;
        r11 = null;
    L6:
        r5.bindKitView(r10, r11);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: bindKitView");
    }

    private final void bindWebOnScrollChangeListener() {
        if (getKitView() != null) goto L5;
        return;
    L5:
        if ((getKitView() instanceof SSWebView) == false) goto L9;
        View r5 = getKitView();
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type com.bytedance.ies.bullet.kit.web.SSWebView");
        ((SSWebView) r5).setWebScrollListener(new zm.c(this, 2));
        return;
    }

    private final boolean canCreateNormalBulletContext(String r5) {
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L8
        if (Uri.parse(r5).getHost() != null) goto L6;
        return false;
    L6:
        Object r11 = Result.m124constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L11:
        if (Result.m127exceptionOrNullimpl(r11) == null) goto L13;
        return false;
    L13:
        return true;
    L8:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r11 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L11
    }

    private final void changeState(int r10) {
        if (r10 != 0) goto L4;
        transferToTargetState();
        initContainerColor();
        return;
    L4:
        if (r10 == 1) goto L27;
        if (r10 != 2) goto L8;
        getParentViewGroup().removeAllViews();
        this.errorViewAdded = false;
        addKitView();
        padAdaptation(this.bulletKitView, this.context.getResources().getConfiguration(), true);
        getContainerModel();
        return;
    L8:
        if (r10 == 3) goto L19;
        if (r10 != 4) goto L63;
        this.isRuntimeReady = true;
        if (this.isResuming == false) goto L61;
        com.bytedance.ies.bullet.service.base.h r5 = this.bulletKitView;
        if (r5 == null) goto L62;
        r5.d();
        return;
    L62:
        return;
    L61:
        return;
    L63:
        return;
    L19:
        if (this.loadSuccess == false) goto L21;
        com.bytedance.ies.bullet.base.utils.logger.a.c(TAG, "load success");
        setContainerColor();
    L22:
        hideLoading();
        addTagView();
        return;
    L21:
        com.bytedance.ies.bullet.base.utils.logger.a.c(TAG, "load fail");
        showError();
        goto L22
    L27:
        if (Intrinsics.areEqual(getViewType(), OpenPageMethod.APP_POPUP) == false) goto L42;
        LinkedHashMap r11 = new LinkedHashMap();
        Iterator r12 = ((LinkedHashMap) com.bytedance.android.anniex.container.util.b.f3200a.getValue()).entrySet().iterator();
    L30:
        if (r12.hasNext() == false) goto L34;
        Map.Entry r13 = (Map.Entry) r12.next();
        s3.b r14 = (s3.b) ((WeakReference) r13.getValue()).get();
        if (r14 == null) goto L30;
        r11.put(r13.getKey(), new WeakReference(r14));
        goto L30
    L34:
        Iterator r15 = r11.entrySet().iterator();
    L36:
        if (r15.hasNext() == false) goto L42;
        s3.b r16 = (s3.b) ((WeakReference) ((Map.Entry) r15.next()).getValue()).get();
        if (r16 == null) goto L36;
        if (Intrinsics.areEqual(r16.getWeakContext().get(), this.context) == false) goto L36;
        r16.onVisibleChange(false, Boolean.FALSE);
    L42:
        Lazy r17 = com.bytedance.android.anniex.container.util.b.f3200a;
        Intrinsics.checkNotNullParameter(this, "container");
        String r18 = getBDXTag();
        if (r18 == null) goto L45;
        com.bytedance.android.anniex.container.util.b.a(r18, getBDXLaunchMode(), this);
    L45:
        ((LinkedHashMap) com.bytedance.android.anniex.container.util.b.f3200a.getValue()).put(getContainerId(), new WeakReference(this));
    }

    private final void closeCurrentPageWhenAfterPageOpen() {
        if ((this instanceof k) == false) goto L5;
    L8:
        getContainerModel();
        return;
    L5:
        if ((this instanceof m) == true) goto L8;
    }

    private final void createModel(Uri r5) {
        this.bulletContext = initOrGetBulletContext(r5.toString(), getSessionIdWithBundle());
        parseSchema();
    }

    private final Activity getActivity() {
        Context r5 = this.context;
        if ((r5 instanceof Activity) == false) goto L7;
        return (Activity) r5;
    L7:
        if ((r5 instanceof ContextThemeWrapper) == true) goto L9;
        return null;
    L9:
        if ((((ContextThemeWrapper) r5).getBaseContext() instanceof Activity) == false) goto L14;
        Context r10 = ((ContextThemeWrapper) this.context).getBaseContext();
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type android.app.Activity");
        return (Activity) r10;
    L14:
        return null;
    }

    private final td.a getContainerModel() {
        this.bulletContext.g.getClass();
        return null;
    }

    private final View getContentView(View r5) {
        View r10 = r5.findViewById(R.id.content);
        if ((r10 instanceof ViewGroup) == true) goto L5;
        return null;
    L5:
        return (ViewGroup) r10;
    }

    private final View getDecorView() {
        return (View) this.decorView$delegate.getValue();
    }

    private final KitType getKitTypeWithSchema() {
        String r5 = getSchemaWithBundle();
        if (StringsKt.g(r5, "://lynxview") == true) goto L17;
        if (StringsKt.g(r5, "://webcast_lynxview") == true) goto L17;
        if (StringsKt.g(r5, "://webview") == true) goto L15;
        if (StringsKt.g(r5, "://webcast_webview") == true) goto L15;
        return KitType.f6011b;
    L15:
        return KitType.f6012c;
    L17:
        return KitType.d;
    }

    private final Handler getMainHandler() {
        return (Handler) this.mainHandler$delegate.getValue();
    }

    private final long getOpenTime() {
        long r5 = System.currentTimeMillis();
        long r10 = this.bundle.getLong("open_time");
        if (r10 <= 0) goto L6;
        int r11 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        StringBuilder r12 = dn.a.K(r10, "openTime:", ", currentTime: ");
        r12.append(r5);
        com.bytedance.ies.bullet.base.utils.logger.a.g(TAG, r12.toString(), null, 12);
        return Math.min(r10, r5);
    L6:
        return r5;
    }

    private final String getSchemaWithBundle() {
        String r5 = this.bundle.getString("annie_x_inner_bundle_schema");
        if (r5 != null) goto L6;
        return "unknown";
    L6:
        return r5;
    }

    private final String getSessionIdWithBundle() {
        String r5 = this.bundle.getString("__x_session_id");
        if (r5 != null) goto L6;
        return "unknown";
    L6:
        return r5;
    }

    private final void hideDeny() {
        View r5 = this.denyView;
        if (r5 == null) goto L6;
        r5.setVisibility(8);
        getParentViewGroup().removeView(r5);
        return;
    }

    private final void hideNotice() {
        View r5 = this.noticeView;
        if (r5 == null) goto L6;
        r5.setVisibility(8);
        getParentViewGroup().removeView(r5);
        return;
    }

    private final void initContainerColor() {
        getContainerModel();
    }

    private final com.bytedance.ies.bullet.core.e initOrGetBulletContext(String r10, String r11) {
        if (canCreateNormalBulletContext(r10) == false) goto L11;
        com.bytedance.ies.bullet.base.utils.logger.a.d(TAG, "====init BulletContext with normal===", null, 12);
        Uri r12 = Uri.parse(r10);
        this.currentUri = r12;
        String r13 = r12.getQueryParameter("bid");
        if (r13 == null) goto L7;
        this.currentBid = r13;
    L7:
        Lazy r14 = com.bytedance.ies.bullet.core.f.f5312b;
        com.bytedance.ies.bullet.core.e r15 = td.b.b().b(this.currentBid, this.currentUri, this.bundle, false, null);
        r15.f5294h = this.context;
        if (Intrinsics.areEqual(r11, "unknown") == true) goto L10;
        Intrinsics.checkNotNullParameter(r11, "<set-?>");
        r15.f5291a = r11;
    L10:
        r15.f = this.currentBid;
        com.bytedance.ies.bullet.core.j r16 = r15.f5306u;
        r16.d = this.annieXLynxViewClientProxy;
        c5.a r17 = r15.f5307v;
        r17.d = this.annieXWebViewClientProxy;
        LinkedHashMap r18 = this.builder.e;
        r15.f5308w.getClass();
        this.builder.getClass();
        r15.f5304r = this.serviceContext;
        r15.f5293c.d(r15);
    L12:
        com.bytedance.ies.bullet.core.c r19 = r15.f5308w;
        r19.f5277h = this.globalProps;
        return r15;
    L11:
        com.bytedance.ies.bullet.base.utils.logger.a.d(TAG, "====init BulletContext with default===", null, 12);
        r15 = new com.bytedance.ies.bullet.core.e();
        r15.f5294h = this.context;
        Intrinsics.checkNotNullParameter("unknown", "<set-?>");
        r15.f5291a = "unknown";
        r15.f = this.builder.f21653b;
        com.bytedance.ies.bullet.core.j r110 = r15.f5306u;
        r110.d = this.annieXLynxViewClientProxy;
        c5.a r111 = r15.f5307v;
        r111.d = this.annieXWebViewClientProxy;
        r15.f5308w.getClass();
        this.builder.getClass();
        r15.f5304r = this.serviceContext;
        r15.f5293c.d(r15);
        goto L12
    }

    private final boolean isBreakPointChange(Map<String, Object> r5) {
        Integer r10 = null;
        if (r5 == null) goto L5;
        Object r11 = r5.get("aweBreakPoint");
    L7:
        if ((r11 instanceof Map) == false) goto L9;
        Map r12 = (Map) r11;
    L10:
        if (r12 == null) goto L26;
        Object r13 = r12.get("horizontal");
        if ((r13 instanceof Integer) == false) goto L14;
        Integer r14 = (Integer) r13;
    L15:
        Object r15 = r12.get("vertical");
        if ((r15 instanceof Integer) == false) goto L18;
        r10 = (Integer) r15;
    L18:
        if (r14 == null) goto L28;
        if (r10 != null) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(r14, this.curHorizontalBreakPoint) == true) goto L23;
    L24:
        this.curHorizontalBreakPoint = r14;
        this.curVerticalBreakPoint = r10;
        return true;
    L23:
        if (Intrinsics.areEqual(r10, this.curVerticalBreakPoint) == false) goto L24;
        return false;
    L28:
        return false;
    L14:
        r14 = null;
        goto L15
    L26:
        return false;
    L9:
        r12 = null;
        goto L10
    L5:
        r11 = null;
        goto L7
    }

    private final boolean kitViewCreateOpt() {
        return Intrinsics.areEqual(Uri.parse(getSchemaWithBundle()).getQueryParameter("anniex_kitview_create_opt"), IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST);
    }

    private final boolean needAdapterKeyboard4Web() {
        com.bytedance.ies.bullet.service.base.h r5 = this.bulletKitView;
        if (r5 == null) goto L5;
        View r10 = r5.a();
    L7:
        if ((r10 instanceof LynxView) == false) goto L9;
        return false;
    L9:
        getContainerModel();
        if ((this instanceof k) == false) goto L14;
        getContainerModel();
        getContainerModel();
        return false;
    L14:
        if ((this instanceof m) == false) goto L17;
        return true;
    L17:
        return false;
    L5:
        r10 = null;
        goto L7
    }

    private final void observerKitViewLayoutChanged() {
        xq.b.f();
    }

    private final void observerRootViewLayoutChanged() {
        int r5 = 0;
        if (getDecorView() != null) goto L5;
        return;
    L5:
        if (supportScreenProps() == false) goto L27;
        Ref.IntRef r10 = new Ref.IntRef();
        View r11 = getDecorView();
        if (r11 == null) goto L10;
        int r12 = r11.getWidth();
    L11:
        r10.element = r12;
        Ref.IntRef r13 = new Ref.IntRef();
        View r14 = getDecorView();
        if (r14 == null) goto L14;
        int r15 = r14.getHeight();
    L15:
        r13.element = r15;
        ((com.bytedance.android.anniex.base.depend.c) com.bytedance.android.anniex.base.depend.a.f3114c.getValue()).getClass();
        Resources r16 = this.context.getResources();
        if (r16 == null) goto L20;
        Configuration r17 = r16.getConfiguration();
        if (r17 == null) goto L20;
        int r18 = r17.orientation;
    L21:
        this.orientation = r18;
        List r19 = nb.a.f20224a;
        this.screenProps = nb.a.d(r18, this.bulletContext.f5294h);
        f r20 = new f(r10, r13, this, r5);
        this.rootViewLayoutListener = r20;
        View r21 = getDecorView();
        if (r21 == null) goto L26;
        r21.addOnLayoutChangeListener(r20);
        return;
    L26:
        return;
    L20:
        r18 = 0;
        goto L21
    L14:
        r15 = 0;
        goto L15
    L10:
        r12 = 0;
        goto L11
    }

    private final void onFoldStatusChanged(String r5, Map<String, Object> r10) {
        this.foldStatus = r5;
        if (r10 == null) goto L6;
        sendEvent(new g(0, r10));
        return;
    }

    private final void onOrientationChanged(int r5, Map<String, Object> r10) {
        this.orientation = r5;
        if (r10 == null) goto L6;
        sendEvent(new g(1, r10));
        return;
    }

    private final void onRootViewLayoutChanged(int r10, int r11, int r12, int r13, int r14, int r15, int r16, int r17) {
        Resources r18 = this.context.getResources();
        if (r18 == null) goto L7;
        Configuration r19 = r18.getConfiguration();
        if (r19 == null) goto L7;
        Integer r110 = Integer.valueOf(r19.orientation);
    L8:
        int r5 = 0;
        boolean r20 = true;
        if (isPadOrFold() == false) goto L18;
        ConcurrentHashMap r111 = yc.a.f23246a;
        Intrinsics.checkNotNullParameter(xc.e.class, "cls");
        xc.e r112 = (xc.e) yc.a.a(xc.e.class, "default_bid");
        if (r112 == null) goto L15;
        xc.d r113 = (xc.d) r112.a(xc.d.class);
        if (r113 == null) goto L15;
        boolean r114 = Intrinsics.areEqual(r113.u0(), Boolean.TRUE);
    L16:
        if (r114 == false) goto L18;
        boolean r115 = true;
    L20:
        if (r115 == false) goto L35;
        if (r110 != null) goto L24;
    L28:
        if (r110 == null) goto L35;
        if (r110.intValue() != 2) goto L35;
        if ((r12 - r10) >= (r13 - r11)) goto L35;
        r110 = 1;
        goto L35
    L24:
        if (r110.intValue() != 1) goto L28;
        if ((r12 - r10) <= (r13 - r11)) goto L28;
        r110 = 2;
    L35:
        List r21 = nb.a.f20224a;
        Context r22 = this.bulletContext.f5294h;
        if (r110 == null) goto L38;
        int r23 = r110.intValue();
    L39:
        LinkedHashMap r24 = nb.a.d(r23, r22);
        xq.b.f();
        if (r115 == false) goto L49;
        if (r24 == null) goto L49;
        if (r110 != null) goto L45;
    L47:
        r24.put("isLandscape", Integer.valueOf(r5));
        goto L49
    L45:
        if (r110.intValue() != 2) goto L47;
        r5 = 1;
    L49:
        if (Intrinsics.areEqual(this.screenProps, r24) == true) goto L53;
        this.screenProps = r24;
        if (r24 == null) goto L53;
        updateGlobalProps(r24);
    L53:
        ConcurrentHashMap r25 = yc.a.f23246a;
        Intrinsics.checkNotNullParameter(xc.e.class, "cls");
        xc.e r26 = (xc.e) yc.a.a(xc.e.class, "default_bid");
        if (r26 == null) goto L60;
        xc.d r27 = (xc.d) r26.a(xc.d.class);
        if (r27 == null) goto L60;
        Boolean r28 = r27.e();
        if (r28 == null) goto L60;
        r20 = r28.booleanValue();
    L60:
        if (r20 == false) goto L65;
        if (r110 == null) goto L65;
        if (r110.intValue() == this.orientation) goto L65;
        onOrientationChanged(r110.intValue(), r24);
    L65:
        Lazy r29 = com.bytedance.android.anniex.base.depend.a.f3114c;
        ((com.bytedance.android.anniex.base.depend.c) r29.getValue()).getClass();
        ((com.bytedance.android.anniex.base.depend.c) r29.getValue()).getClass();
        return;
    L38:
        r23 = 0;
    L15:
        r114 = false;
    L18:
        r115 = false;
    L7:
        r110 = null;
        goto L8
    }

    private final void padAdaptation(com.bytedance.ies.bullet.service.base.h r5, Configuration r10, boolean r11) {
        if (r5 != null) goto L4;
        return;
    L4:
        boolean r12 = this instanceof k;
        com.lynx.tasm.base.a.i(this.bulletContext.g);
        int r13 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        com.bytedance.ies.bullet.base.utils.logger.a.g(TAG, "padAdaptation : current scenes=" + this.bulletContext.f5295i + ",padAdapterWidth=" + this.padAdapterWidth + ",padAdapterHeight=" + this.padAdapterHeight, null, 12);
    }

    public static /* synthetic */ void padAdaptation$default(AnnieXContainer r5, com.bytedance.ies.bullet.service.base.h r10, Configuration r11, boolean r12, int r13, Object r14) {
        if (r14 != null) goto L9;
        if ((r13 & 4) == 0) goto L6;
        r12 = false;
    L6:
        r5.padAdaptation(r10, r11, r12);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: padAdaptation");
    }

    private final void possiblyResizeChildOfContent4Web(int r10) {
        if (needAdapterKeyboard4Web() == false) goto L40;
        getContainerModel();
        View r5 = getParentViewGroup().getRootView();
        int r11 = r5.getHeight();
        int r12 = r11 - r10;
        if (r12 == this.usableHeightPrevious) goto L38;
        View r13 = getContentView(r5);
        ConcurrentHashMap r14 = yc.a.f23246a;
        Intrinsics.checkNotNullParameter(xc.e.class, "cls");
        xc.e r15 = (xc.e) yc.a.a(xc.e.class, "default_bid");
        if (r15 == null) goto L14;
        xc.d r16 = (xc.d) r15.a(xc.d.class);
        if (r16 == null) goto L14;
        Boolean r17 = r16.m();
        if (r17 == null) goto L14;
        boolean r18 = r17.booleanValue();
    L15:
        if (r18 == true) goto L17;
    L28:
        if (r13 == null) goto L30;
        ViewGroup.LayoutParams r19 = r13.getLayoutParams();
    L31:
        if (r19 != null) goto L33;
        return;
    L33:
        if (r10 <= (r11 / 4)) goto L35;
        r19.height = r12;
    L36:
        r13.requestLayout();
        this.usableHeightPrevious = r12;
        return;
    L35:
        r19.height = r11;
        goto L36
    L30:
        r19 = null;
        goto L31
    L17:
        if ((this instanceof m) == false) goto L28;
        if (com.bytedance.android.anniex.container.util.b.b(this) == false) goto L28;
        if (r10 != 0) goto L24;
        if (r13 == null) goto L26;
        r13.scrollTo(0, 0);
    L26:
        this.usableHeightPrevious = r12;
        return;
    L24:
        if (r13 == null) goto L26;
        r13.scrollBy(0, r10 - getNavigationBarHeight());
    L14:
        r18 = true;
        goto L15
    L38:
        return;
    }

    private final void putState(int r5) {
        if (this.parentViewGroup == null) goto L6;
        getMainHandler().post(new i(r5, 0, this));
        return;
    L6:
        this.stateBlockingQueue.put(Integer.valueOf(r5));
    }

    private final void sendKeyboardStatusChangeEvent(boolean r5, int r10) {
        JSONObject r11 = new JSONObject();
        r11.put("visible", r5);
        r11.put("height", r10);
        sendEvent(new g(r11, 2));
        sendEvent(new g(r11, 3));
    }

    private final void sendPendingEvent() {
        Object r5 = this.synchronizedObj;
        monitor-enter(r5);
        Iterator<T> r10 = this.pendingEvent.iterator();     // Catch: Throwable -> L10
    L6:
        if (r10.hasNext() == false) goto L12;
        com.bytedance.ies.bullet.core.kit.bridge.f r11 = (com.bytedance.ies.bullet.core.kit.bridge.f) r10.next();     // Catch: Throwable -> L10
        com.bytedance.ies.bullet.service.base.h r12 = this.bulletKitView;     // Catch: Throwable -> L10
        if (r12 == null) goto L6;
        r12.a(r11.getName(), r11.getParams());     // Catch: Throwable -> L10
        goto L6
    L12:
        this.pendingEvent.clear();     // Catch: Throwable -> L10
        Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(r5);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private final void sendWindowSizeEvent() {
        Lazy r5 = com.bytedance.android.anniex.base.depend.a.f3114c;
        ((com.bytedance.android.anniex.base.depend.c) r5.getValue()).getClass();
        ((com.bytedance.android.anniex.base.depend.c) r5.getValue()).getClass();
    }

    private final void setBackgroundColor() {
        getContainerModel();
        Intrinsics.checkNotNull(null);
        throw null;
    }

    private final void setContainerColor() {
        getContainerModel();
    }

    private final void setSecureInfo() {
        this.bulletContext.f5293c.p("on_container_created_start");
        this.bulletContext.getClass();
        this.bulletContext.f5293c.p("on_container_created_end");
    }

    private final boolean showContainerTag(mb.b r5) {
        if (com.bytedance.ies.bullet.core.h.g.f5315a == true) goto L5;
        return false;
    L5:
        if (r5.f20055a == false) goto L10;
        return true;
    L10:
        return false;
    }

    private final void showDeny() {
        if (this.denyView == null) goto L5;
    L10:
        View r5 = this.denyView;
        if (r5 == null) goto L14;
        getParentViewGroup().addView(r5);
        r5.setVisibility(0);
        return;
    L14:
        return;
    L5:
        if (this.isNotRelease == false) goto L10;
        com.bytedance.ies.bullet.base.utils.logger.a.g(TAG, "create deny view", null, 12);
        s3.f r10 = this.uiComponent;
        if (r10 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("uiComponent");
        r10 = null;
    L9:
        r10.getClass();
        Intrinsics.checkNotNullParameter(this, "container");
        this.denyView = null;
        goto L10
    }

    private final void showNotice() {
        if (this.noticeView == null) goto L5;
    L10:
        View r5 = this.noticeView;
        if (r5 == null) goto L14;
        getParentViewGroup().addView(r5);
        r5.setVisibility(0);
        return;
    L14:
        return;
    L5:
        if (this.isNotRelease == false) goto L10;
        com.bytedance.ies.bullet.base.utils.logger.a.g(TAG, "create notice view", null, 12);
        s3.f r10 = this.uiComponent;
        if (r10 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("uiComponent");
        r10 = null;
    L9:
        r10.getClass();
        Intrinsics.checkNotNullParameter(this, "container");
        this.noticeView = null;
        goto L10
    }

    private final boolean supportScreenProps() {
        if ((this instanceof k) == false) goto L5;
        return true;
    L5:
        if ((this instanceof m) == true) goto L11;
        return false;
    L11:
        return true;
    }

    private final void transferToTargetState() {
    L3:
        if (this.stateBlockingQueue.isEmpty() == true) goto L5;
        changeState(this.stateBlockingQueue.take().intValue());
        goto L3
    }

    private final void updateLynxScreenMetrics() {
        if (this.bulletKitView == null) goto L10;
        boolean r5 = this instanceof k;
        com.lynx.tasm.base.a.i(this.bulletContext.g);
        Context r10 = this.bulletContext.f5294h;
        if (r10 == null) goto L11;
        xd.d r11 = v0.p(r10);
        if (r11 == null) goto L12;
        int r12 = r11.f23105a;
        int r13 = r11.f23106b;
        updateScreenMetrics(r12, r13);
        int r14 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        com.bytedance.ies.bullet.base.utils.logger.a.g(TAG, "updateLynxScreenMetrics : enableIpadAdapter false , width " + r12 + " , height " + r13, null, 12);
        return;
    L12:
        return;
    L11:
        return;
    }

    public void bindContainerId(String r5) {
        Intrinsics.checkNotNullParameter(r5, "containerId");
        this.__containerId = r5;
    }

    @Override // s3.b
    public boolean canBackPress() {
        getContainerModel();
        sendEvent(new c(0));
        return true;
    }

    public boolean canGoBack() {
        com.bytedance.ies.bullet.service.base.h r5 = this.bulletKitView;
        if (r5 != null) goto L5;
        return false;
    L5:
        return r5.g();
    }

    @Override // s3.b
    public void close() {
        int r5 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        oo.j.g(this, new StringBuilder("===close: "));
        if (this.isNotRelease == false) goto L9;
        s3.f r10 = this.uiComponent;
        if (r10 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("uiComponent");
        r10 = null;
    L7:
        r10.a();
        return;
    }

    @Override // s3.b
    public void enterBackground() {
        com.bytedance.ies.bullet.service.base.h r5 = this.bulletKitView;
        if (r5 == null) goto L5;
        r5.c();
    L5:
        o r10 = this.bulletContext.f5293c.l();
        Uri.parse(this.currentSchema);
        r10.c();
        this.isVisibility = false;
        int r11 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        oo.j.g(this, new StringBuilder("===enterBackground: "));
    }

    @Override // s3.b
    public void enterForeground() {
        this.isResuming = true;
        if (this.isRuntimeReady == false) goto L7;
        com.bytedance.ies.bullet.service.base.h r5 = this.bulletKitView;
        if (r5 == null) goto L7;
        r5.d();
    L7:
        o r10 = this.bulletContext.f5293c.l();
        Uri.parse(this.currentSchema);
        r10.a();
        this.isVisibility = true;
        int r11 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        oo.j.g(this, new StringBuilder("===enterForeground: "));
    }

    @Override // s3.b
    public void finish() {
    }

    public rd.b generateSchemaData(String r5) {
        Intrinsics.checkNotNullParameter(r5, "schema");
        if (Intrinsics.areEqual(r5, this.currentSchema) == true) goto L5;
        this.currentSchema = r5;
        createModel(Uri.parse(r5));
    L5:
        rd.b r10 = this.bulletContext.e;
        if (r10 != null) goto L9;
        Lazy r11 = com.bytedance.ies.bullet.service.sdk.d.e;
        return av.i.e().a(this.currentBid, this.currentUri, true);
    L9:
        return r10;
    }

    public final td.a getAnnieXContainerModel$anniex_release() {
        getContainerModel();
        return null;
    }

    @Override // s3.b
    public LaunchMode getBDXLaunchMode() {
        rd.b r5 = this.bulletContext.e;
        if (r5 == null) goto L9;
        LaunchMode r10 = (LaunchMode) new vd.a(r5, null).f22372b;
        if (r10 == null) goto L9;
        return r10;
    L9:
        return LaunchMode.f6147b;
    }

    @Override // s3.b
    public String getBDXTag() {
        rd.b r5 = this.bulletContext.e;
        if (r5 != null) goto L5;
        return null;
    L5:
        return (String) new vd.a(r5, "bdx_tag", null).f22372b;
    }

    @Override // s3.b
    public String getBid() {
        return this.currentBid;
    }

    public final r3.d getBuilder() {
        return this.builder;
    }

    public final com.bytedance.ies.bullet.core.e getBulletContext() {
        return this.bulletContext;
    }

    @Override // s3.b
    public String getContainerId() {
        String r5 = this.__containerId;
        if (r5 == null) goto L5;
        return r5;
    L5:
        return this.bulletContext.getSessionId();
    }

    public final boolean getContainerVisible() {
        return this.containerVisible;
    }

    public final Context getContext() {
        return this.context;
    }

    public rb.b getContextProviderFactory() {
        return this.contextProviderFactory;
    }

    @Override // s3.b
    public rd.b getCurrentSchema() {
        return this.bulletContext.e;
    }

    public String getCurrentUrl() {
        return this.currentSchema;
    }

    public KitType getKitType() {
        com.bytedance.ies.bullet.service.base.h r5 = this.bulletKitView;
        if (r5 == null) goto L9;
        KitType r10 = r5.h();
        if (r10 == null) goto L9;
        return r10;
    L9:
        return KitType.d;
    }

    @Override // s3.b
    public View getKitView() {
        com.bytedance.ies.bullet.service.base.h r5 = this.bulletKitView;
        if (r5 != null) goto L5;
        return null;
    L5:
        return r5.a();
    }

    public final View getLynxWithScrollView$anniex_release() {
        return this.lynxWithScrollView;
    }

    public final int getNavigationBarHeight() {
        if (hasSystemNavBar() == true) goto L5;
        return 0;
    L5:
        WindowInsetsCompat r5 = getWindowInsetsCompat();
        if (r5 == null) goto L11;
        Insets r10 = r5.getInsets(WindowInsetsCompat.Type.navigationBars());
        if (r10 == null) goto L11;
        return r10.bottom;
    L11:
        return 0;
    }

    public final Function1<Boolean, Unit> getOnSoftInputChangeListener$anniex_release() {
        return this.onSoftInputChangeListener;
    }

    public final ViewGroup getParentViewGroup() {
        ViewGroup r5 = this.parentViewGroup;
        if (r5 == null) goto L5;
        return r5;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("parentViewGroup");
        return null;
    }

    @SuppressLint({"LogicalBranchDetector"})
    public Map<String, Long> getPerfMap() {
        com.bytedance.ies.bullet.service.base.h r5 = this.bulletKitView;
        if (r5 == null) goto L24;
        if (Intrinsics.areEqual(this.bulletContext.f5309x.f5347b, "unknown") == false) goto L7;
    L10:
        long r10 = 1;
    L12:
        if (r5.h() != KitType.d) goto L15;
        long r11 = this.bulletContext.f5293c.a("prepare_template_start");
        long r14 = this.bulletContext.f5293c.a("read_template_end");
        long r12 = this.bulletContext.f5293c.a("read_template_end");
        long r13 = this.bulletContext.f5293c.a("render_template_start");
        long r20 = this.bulletContext.f5293c.a("render_template_start");
        long r22 = this.bulletContext.f5293c.a("render_template_end");
        LinkedHashMap r15 = new LinkedHashMap();
        r15.put("prepare_template_start", Long.valueOf(r11));
        r15.put("prepare_template_end", Long.valueOf(r14));
        r15.put("prepare_engine_load_start", Long.valueOf(r20));
        r15.put("prepare_engine_load_end", Long.valueOf(r22));
        r15.put("prepare_render_data_start", Long.valueOf(r12));
        r15.put("prepare_render_data_end", Long.valueOf(r13));
        r15.put("res_from", Long.valueOf(r10));
        return r15;
    L15:
        long r17 = r10;
        long r16 = this.bulletContext.f5293c.a("prepare_template_start");
        long r18 = this.bulletContext.f5293c.a("prepare_template_end");
        long r19 = this.bulletContext.f5293c.a("prepare_component_end");
        long r21 = this.bulletContext.f5293c.a("page_load");
        long r23 = this.bulletContext.f5293c.a("page_load");
        long r24 = this.bulletContext.f5293c.a("page_finish");
        LinkedHashMap r25 = new LinkedHashMap();
        if (r16 <= 0) goto L19;
        r25.put("prepare_template_start", Long.valueOf(r16));
    L19:
        if (r18 <= 0) goto L21;
        r25.put("prepare_template_end", Long.valueOf(r18));
    L21:
        r25.put("prepare_engine_load_start", Long.valueOf(r23));
        r25.put("prepare_engine_load_end", Long.valueOf(r24));
        r25.put("prepare_render_data_start", Long.valueOf(r19));
        r25.put("prepare_render_data_end", Long.valueOf(r21));
        r25.put("res_from", Long.valueOf(r17));
        return r25;
    L7:
        if (StringsKt.g(this.bulletContext.f5309x.f5347b, "cdn") == true) goto L10;
        r10 = 0;
        goto L12
    L24:
        return MapsKt.emptyMap();
    }

    @Deprecated(message = "该方法可能存在底部导航是否显示判断以及高度获取不准的问题，建议使用上面的getNavigationBarHeight()替代")
    public final int getRealNavigationBarHeight() {
        if (hasSystemNavBar() == true) goto L6;
        return 0;
    L6:
        if (getActivity() != null) goto L8;
        return 0;
    L8:
        Activity r5 = getActivity();
        Intrinsics.checkNotNull(r5);
        return com.lynx.tasm.utils.g.i(r5);
    }

    public final View getRootView() {
        return this.rootView;
    }

    @Override // s3.b
    public rd.b getSchemaData() {
        return this.bulletContext.e;
    }

    public final int getStatusBarHeight() {
        if (hasStatusBar() == true) goto L5;
        return 0;
    L5:
        WindowInsetsCompat r5 = getWindowInsetsCompat();
        if (r5 == null) goto L11;
        Insets r10 = r5.getInsets(WindowInsetsCompat.Type.statusBars());
        if (r10 == null) goto L11;
        return r10.bottom;
    L11:
        return 0;
    }

    @Override // s3.b
    public Context getSystemContext() {
        return this.context;
    }

    public final String getUrl() {
        getContainerModel();
        return "unknown";
    }

    @Override // s3.b
    public String getViewType() {
        return "card";
    }

    @Override // s3.b
    public WeakReference<Context> getWeakContext() {
        return new WeakReference(this.context);
    }

    public final WindowInsetsCompat getWindowInsetsCompat() {
        return (WindowInsetsCompat) this.windowInsetsCompat$delegate.getValue();
    }

    public void goBack() {
        int r5 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        oo.j.g(this, new StringBuilder("===goBack: "));
        com.bytedance.ies.bullet.service.base.h r10 = this.bulletKitView;
        if (r10 != null) goto L5;
    L7:
        close();
        return;
    L5:
        if (r10.g() != true) goto L7;
    }

    public final boolean hasStatusBar() {
        if (getWindowInsetsCompat() != null) goto L5;
        return false;
    L5:
        WindowInsetsCompat r5 = getWindowInsetsCompat();
        if (r5 != null) goto L8;
    L10:
        return false;
    L8:
        if (r5.isVisible(WindowInsetsCompat.Type.statusBars()) != true) goto L10;
        return true;
    }

    public final boolean hasSystemNavBar() {
        if (getWindowInsetsCompat() != null) goto L5;
        return false;
    L5:
        WindowInsetsCompat r5 = getWindowInsetsCompat();
        if (r5 != null) goto L8;
    L10:
        return false;
    L8:
        if (r5.isVisible(WindowInsetsCompat.Type.navigationBars()) != true) goto L10;
        return true;
    }

    public void hideError() {
        int r5 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        oo.j.g(this, new StringBuilder("===hideError: "));
        View r10 = this.errorView;
        if (r10 != null) goto L5;
        return;
    L5:
        r10.setVisibility(8);
    }

    @UiThread
    public void hideLoading() {
        int r5 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        oo.j.g(this, new StringBuilder("===hideLoading: "));
        View r10 = this.loadingView;
        if (r10 != null) goto L5;
        return;
    L5:
        r10.setVisibility(8);
    }

    public final void initUi() {
        int r5 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        oo.j.g(this, new StringBuilder("===initUi: "));
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L5
        observerKeyboardStatusChange();     // Catch: Throwable -> L5
        observerRootViewLayoutChanged();     // Catch: Throwable -> L5
        putState(0);     // Catch: Throwable -> L5
        this.bulletContext.f5293c.l().f();     // Catch: Throwable -> L5
        Object r11 = Result.m124constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r12 = Result.m127exceptionOrNullimpl(r11);
        if (r12 == null) goto L13;
        int r13 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        com.bytedance.ies.bullet.base.utils.logger.a.d(TAG, "initUi===>" + getUrl() + " error:" + r12.getMessage(), null, 12);
        return;
    L13:
        return;
    L5:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r11 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public void interceptBackPress(boolean r5) {
        getContainerModel();
        s3.f r10 = this.uiComponent;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("uiComponent");
        r10 = null;
    L5:
        r10.getClass();
    }

    public final boolean isKitViewScrollReachTop() {
        if (getKitType() == KitType.f6012c) goto L5;
        View r5 = this.lynxWithScrollView;
        if (r5 != null) goto L9;
    L12:
        return true;
    L9:
        if (r5.canScrollVertically(-1) != true) goto L12;
        return false;
    L5:
        return this.isWebViewScrollReachTop;
    }

    public final boolean isPadOrFold() {
        Lazy r5 = com.bytedance.android.anniex.base.depend.a.f3114c;
        ((com.bytedance.android.anniex.base.depend.c) r5.getValue()).getClass();
        ((com.bytedance.android.anniex.base.depend.c) r5.getValue()).getClass();
        return false;
    }

    public boolean isVisibility() {
        return this.isVisibility;
    }

    public void loadSchema(String r5, Map<String, ? extends Object> r10, rb.b r11, v3.a r12) {
        Intrinsics.checkNotNullParameter(r5, "schema");
    }

    public void observerKeyboardStatusChange() {
        com.bytedance.ies.bullet.base.utils.logger.a.g(TAG, "===observerKeyboardStatusChange====", null, 12);
    }

    public void onAttachToWindow() {
        this.bulletContext.f5293c.n(this.currentUri.getPath());
    }

    public void onConfigurationChanged(Configuration r10) {
        Intrinsics.checkNotNullParameter(r10, "newConfig");
        padAdaptation$default(this, this.bulletKitView, r10, false, 4, null);
        updateLynxScreenMetrics();
        sendWindowSizeEvent();
    }

    @Override // s3.b
    @UiThread
    public abstract /* synthetic */ void onCreate(Bundle r5);

    @Override // s3.b
    public void onEngineReady(rb.b r5) {
        Intrinsics.checkNotNullParameter(r5, "contextProviderFactory");
    }

    @Override // s3.b
    public void onVisibleChange(boolean r5, Boolean r10) {
        if (r5 == this.containerVisible) goto L16;
        this.containerVisible = r5;
        sendEvent(new h(r5, this, 0));
        if (r10 != null) goto L8;
    L11:
        if (r5 == false) goto L14;
        sendEvent(new c(1));
        return;
    L14:
        sendEvent(new c(2));
        return;
    L8:
        if (Intrinsics.areEqual(r10, Boolean.FALSE) == true) goto L11;
        return;
    }

    public void onWebPageFinish(WebView r5, String r10) {
    }

    public void onWebScrollChanged(int r5, int r10, int r11, int r12) {
    }

    public void parseSchema() {
        rd.b r5 = this.bulletContext.e;
        if (r5 == null) goto L5;
        com.lynx.tasm.utils.a.e(this.bulletContext, r5);
    L5:
        putState(1);
        int r10 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        oo.j.g(this, new StringBuilder("===parseSchema: "));
    }

    public void postFirstVisibleEvent() {
    }

    public void preloadSchema(String r5) {
        Intrinsics.checkNotNullParameter(r5, "schema");
        if (Intrinsics.areEqual(r5, this.currentSchema) == true) goto L5;
        this.currentSchema = r5;
        createModel(Uri.parse(r5));
    L5:
        int r10 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        oo.j.g(this, new StringBuilder("===preloadSchema: "));
    }

    public <T> void registerWeakHolder(Class<T> r5, T r10) {
        Intrinsics.checkNotNullParameter(r5, "clazz");
        rb.b r11 = this.contextProviderFactory;
        r11.getClass();
        Intrinsics.checkNotNullParameter(r5, "clazz");
        r11.b(r5, new rb.a(r10));
    }

    @Override // s3.b
    public void release() {
        if (this.isNotRelease == true) goto L5;
        return;
    L5:
        int r5 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        oo.j.g(this, new StringBuilder("===release: "));
        this.lifecycleDispatcher.b(this.currentSchema);
        this.bulletContext.f5293c.l().n();
        Lazy r10 = com.bytedance.ies.bullet.core.f.f5312b;
        com.bytedance.ies.bullet.core.f r11 = td.b.b();
        com.bytedance.ies.bullet.core.e r12 = this.bulletContext;
        r11.getClass();
        Intrinsics.checkNotNullParameter(r12, "bulletContext");
        ConcurrentHashMap r13 = r11.f5313a;
        r13.remove(r12.getSessionId());
        boolean r14 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.service.base.b.b(12, r12.getSessionId(), "BulletContextManager removeContext: " + r13.size(), null);
        View.OnLayoutChangeListener r15 = this.rootViewLayoutListener;
        if (r15 == null) goto L11;
        View r16 = getDecorView();
        if (r16 == null) goto L10;
        r16.removeOnLayoutChangeListener(r15);
    L10:
        this.rootViewLayoutListener = null;
    L11:
        c4.a.f1115a.b(this.bulletContext.getSessionId());
        getMainHandler().postDelayed(new a6.a(this, 6), 1000);
        com.bytedance.ies.bullet.service.base.h r17 = this.bulletKitView;
        if (r17 == null) goto L14;
        r17.destroy();
    L14:
        this.bulletKitView = null;
        this.containerLoader.d = null;
        this.rootView = null;
        this.errorView = null;
        this.loadingView = null;
        this.noticeView = null;
        this.denyView = null;
        this.isNotRelease = false;
    }

    public void reload(Map<String, ? extends Object> r5) {
        int r10 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        oo.j.g(this, new StringBuilder("===reload: "));
        loadSchema(this.currentSchema, r5);
    }

    public void reloadTemplate(Map<String, ? extends Object> r5) {
        int r10 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        oo.j.g(this, new StringBuilder("===reloadTemplate: "));
        Object r11 = this.bulletKitView;
        LinkedHashMap r12 = null;
        if ((r11 instanceof LynxView) == false) goto L5;
        LynxView r13 = (LynxView) r11;
    L6:
        if (r13 == null) goto L22;
        this.lifecycleDispatcher.i(this.currentSchema, this);
        if (r5 == null) goto L15;
        Intrinsics.checkNotNullParameter(r5, "<this>");
        r12 = new LinkedHashMap();
        Iterator<Map.Entry<String, ? extends Object>> r14 = r5.entrySet().iterator();
    L11:
        if (r14.hasNext() == false) goto L15;
        Map.Entry<String, ? extends Object> r15 = r14.next();
        Object r16 = r15.getValue();
        if (r16 == null) goto L11;
        r12.put(r15.getKey(), r16);
    L15:
        TemplateData r17 = TemplateData.c(r12);
        r17.e = true;
        r13.reloadTemplate(r17);
        this.lifecycleDispatcher.j(this.currentSchema, this);
        return;
    L22:
        return;
    L5:
        r13 = null;
        goto L6
    }

    public void sendEvent(com.bytedance.ies.bullet.core.kit.bridge.f r5) {
        Intrinsics.checkNotNullParameter(r5, "event");
        com.bytedance.ies.bullet.service.base.h r10 = this.bulletKitView;
        if (r10 == null) goto L6;
        r10.a(r5.getName(), r5.getParams());
        return;
    L6:
        Object r11 = this.synchronizedObj;
        monitor-enter(r11);
        this.pendingEvent.add(r5);     // Catch: Throwable -> L11
        monitor-exit(r11);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public final void setBulletContext(com.bytedance.ies.bullet.core.e r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.bulletContext = r5;
    }

    public final void setContainerVisible(boolean r5) {
        this.containerVisible = r5;
    }

    public final void setLynxWithScrollView$anniex_release(View r5) {
        this.lynxWithScrollView = r5;
    }

    public final void setParentViewGroup(ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.parentViewGroup = r5;
    }

    public final void setRootView(View r5) {
        this.rootView = r5;
    }

    public final void setUiComponent(s3.f r5) {
        Intrinsics.checkNotNullParameter(r5, "uiComponent");
        this.uiComponent = r5;
    }

    public void showError() {
        int r5 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        oo.j.g(this, new StringBuilder("===showError: "));
        if (this.errorView == null) goto L5;
    L11:
        View r10 = this.errorView;
        if (r10 != null) goto L14;
        return;
    L14:
        if (this.errorViewAdded == true) goto L16;
        getParentViewGroup().addView(r10);
        this.errorViewAdded = true;
    L16:
        r10.setVisibility(0);
        return;
    L5:
        if (this.isNotRelease == false) goto L11;
        s3.f r11 = null;
        com.bytedance.ies.bullet.base.utils.logger.a.g(TAG, "create error view", null, 12);
        s3.f r12 = this.uiComponent;
        if (r12 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("uiComponent");
    L10:
        r11.b();
        goto L11
    L9:
        r11 = r12;
        goto L10
    }

    @UiThread
    public void showLoading() {
        int r5 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        oo.j.g(this, new StringBuilder("===showLoading: "));
        View r10 = this.loadingView;
        if (r10 != null) goto L5;
        return;
    L5:
        r10.setVisibility(0);
    }

    public void updateData(Map<String, ? extends Object> r5) {
        Intrinsics.checkNotNullParameter(r5, "data");
        int r10 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        oo.j.g(this, new StringBuilder("===updateData: "));
        com.bytedance.ies.bullet.service.base.h r11 = this.bulletKitView;
        if (r11 == null) goto L6;
        r11.a(r5);
        return;
    }

    public void updateGlobalProps(Map<String, ? extends Object> r5) {
        Intrinsics.checkNotNullParameter(r5, "globalProps");
        int r10 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        oo.j.g(this, new StringBuilder("===updateGlobalProps: "));
        this.globalProps.putAll(r5);
        com.bytedance.ies.bullet.service.base.h r11 = this.bulletKitView;
        if (r11 == null) goto L6;
        r11.b(this.globalProps);
        return;
    }

    public void updateScreenMetrics(int r5, int r10) {
        com.bytedance.ies.bullet.service.base.h r11 = this.bulletKitView;
        LynxView r12 = null;
        if (r11 == null) goto L5;
        View r13 = r11.a();
    L7:
        if ((r13 instanceof LynxView) == false) goto L9;
        r12 = (LynxView) r13;
    L9:
        if (r12 == null) goto L12;
        r12.updateScreenMetrics(r5, r10);
        return;
    L12:
        return;
    L5:
        r13 = null;
        goto L7
    }

    @Override // s3.b
    public void loadSchema(String r10, Map<String, ? extends Object> r11) {
        Intrinsics.checkNotNullParameter(r10, "schema");
        long r5 = getOpenTime();
        Uri r12 = Uri.parse(r10);
        if (Intrinsics.areEqual(r10, this.currentSchema) == true) goto L5;
        this.currentSchema = r10;
        createModel(r12);
    L5:
        Intrinsics.checkNotNullParameter(getContainerId(), "sessionId");
        Intrinsics.checkNotNullParameter(r10, "schema");
        if (xq.b.q() == true) goto L8;
        ug.a.d(this.bulletContext, null, null, false);
    L8:
        zj.b.a(r12);
        Application r13 = com.bytedance.ies.bullet.core.h.g.f5316b;
        if (r13 == null) goto L11;
        com.bytedance.android.anniex.worker.b.f3505a.b(r13, this.currentSchema);
    L11:
        closeCurrentPageWhenAfterPageOpen();
        com.bytedance.ies.bullet.core.e r14 = this.bulletContext;
        r14.f5294h = this.context;
        if (r11 == null) goto L16;
        Map r15 = MapsKt.toMutableMap(r11);
        if (r15 == null) goto L16;
        com.bytedance.ies.bullet.core.j r16 = this.bulletContext.f5306u;
        ae.a r17 = new ae.a();
        r17.f160a = r15;
        r16.f5321c = r17;
    L16:
        setSecureInfo();
        rb.b r18 = this.contextProviderFactory;
        ContainerBidParam r19 = new ContainerBidParam(this.currentBid);
        r18.getClass();
        Intrinsics.checkNotNullParameter(ContainerBidParam.class, "clazz");
        r18.b(ContainerBidParam.class, new rb.a(r19, 0));
        rb.b r20 = this.contextProviderFactory;
        Context r110 = this.context;
        r20.getClass();
        Intrinsics.checkNotNullParameter(Context.class, "clazz");
        r20.b(Context.class, new rb.a(r110));
        rb.b r21 = this.contextProviderFactory;
        com.bytedance.ies.bullet.core.e r111 = this.bulletContext;
        r21.getClass();
        Intrinsics.checkNotNullParameter(com.bytedance.ies.bullet.core.e.class, "clazz");
        r21.b(com.bytedance.ies.bullet.core.e.class, new rb.a(r111));
        rb.b r22 = this.contextProviderFactory;
        d r112 = this.containerInstance;
        r22.getClass();
        Intrinsics.checkNotNullParameter(kj.c.class, "clazz");
        r22.b(kj.c.class, new rb.a(r112));
        rb.b r23 = this.contextProviderFactory;
        e r113 = this.deprecatedBulletContainer;
        r23.getClass();
        Intrinsics.checkNotNullParameter(com.bytedance.ies.bullet.core.container.e.class, "clazz");
        r23.b(com.bytedance.ies.bullet.core.container.e.class, new rb.a(r113));
        rb.b r24 = this.contextProviderFactory;
        r24.getClass();
        Intrinsics.checkNotNullParameter(s3.b.class, "clazz");
        r24.b(s3.b.class, new rb.a(this));
        if (xq.b.q() == true) goto L19;
    L23:
        LinkedHashMap r25 = cd.a.f1171a;
        cd.a.b(this.bulletContext.getSessionId(), this.contextProviderFactory);
        this.lifecycleDispatcher.i(this.currentSchema, this);
        this.bulletContext.f5293c.c(r5, false);
        this.bulletContext.f5293c.i(Long.valueOf(this.createViewTime));
        this.bulletContext.f5293c.l().u(this.currentUri, null);
        com.bytedance.ies.bullet.core.e r26 = this.bulletContext;
        r26.f5299m = r26.f5293c.l();
        this.serviceContext.b(com.bytedance.ies.bullet.core.e.class, this.bulletContext);
        this.containerLoader.g(this.bulletContext, this.currentUri, this.bundle, this.bulletLifecycle);
        return;
    L19:
        if (Intrinsics.areEqual(this.currentBid, "webcast") == false) goto L23;
        String r27 = this.__containerId;
        if (r27 == null) goto L23;
        rb.b r114 = this.contextProviderFactory;
        ub.a r28 = new ub.a(r27);
        r114.getClass();
        Intrinsics.checkNotNullParameter(ub.a.class, "clazz");
        r114.b(ub.a.class, new rb.a(r28, 0));
        goto L23
    }

    public void updateData(String r5) {
        Intrinsics.checkNotNullParameter(r5, "data");
        int r10 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        oo.j.g(this, new StringBuilder("===updateData: "));
    }
}
