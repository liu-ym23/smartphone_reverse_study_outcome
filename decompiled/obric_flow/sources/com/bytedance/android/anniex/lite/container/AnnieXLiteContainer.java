package com.bytedance.android.anniex.lite.container;

import ai.j0;
import android.R;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.LruCache;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.activity.ComponentActivity;
import androidx.annotation.Keep;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ai.bridge.method.router.OpenPageMethod;
import com.bytedance.android.anniex.container.j;
import com.bytedance.ies.bullet.core.common.Scenes;
import com.bytedance.ies.bullet.kit.web.SSWebView;
import com.bytedance.ies.bullet.service.base.utils.KitType;
import com.bytedance.ies.bullet.service.sdk.param.LaunchMode;
import com.bytedance.ies.bullet.ui.common.DebugTagTextView;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.behavior.ui.utils.n;
import com.lynx.tasm.behavior.v0;
import com.obric.launcher.widget.R$layout;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(d1 = {"\u0000þ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\b\u0007*\u0002Ø\u0001\b!\u0018\u0000 Ü\u00012\u00020\u0001:\u0002Ý\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0004¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u000eH\u0014¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u000eH\u0004¢\u0006\u0004\b\u0013\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0014\u0010\u0012J\u0017\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J!\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u0019H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001e\u0010\bJ\u000f\u0010\u001f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001f\u0010\bJ\u000f\u0010!\u001a\u00020 H\u0016¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\u0006H\u0016¢\u0006\u0004\b#\u0010\bJ\u0011\u0010%\u001a\u0004\u0018\u00010$H\u0016¢\u0006\u0004\b%\u0010&J-\u0010+\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020\u00062\u0014\u0010*\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020)\u0018\u00010(H\u0016¢\u0006\u0004\b+\u0010,JA\u0010+\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020\u00062\u0014\u0010*\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020)\u0018\u00010(2\b\u0010.\u001a\u0004\u0018\u00010-2\b\u00100\u001a\u0004\u0018\u00010/H\u0016¢\u0006\u0004\b+\u00101J\u000f\u00103\u001a\u000202H\u0016¢\u0006\u0004\b3\u00104J\u0017\u00105\u001a\u00020$2\u0006\u0010'\u001a\u00020\u0006H\u0016¢\u0006\u0004\b5\u00106J\u0011\u00107\u001a\u0004\u0018\u00010$H\u0016¢\u0006\u0004\b7\u0010&J\u0017\u0010:\u001a\u00020\u000e2\u0006\u00109\u001a\u000208H\u0016¢\u0006\u0004\b:\u0010;J\u000f\u0010<\u001a\u00020\u000eH\u0016¢\u0006\u0004\b<\u0010\u0012J\u000f\u0010=\u001a\u00020\u000eH\u0016¢\u0006\u0004\b=\u0010\u0012J%\u0010>\u001a\u00020\u000e2\u0014\u0010*\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020)\u0018\u00010(H\u0016¢\u0006\u0004\b>\u0010?J\u000f\u0010@\u001a\u00020\u000eH\u0016¢\u0006\u0004\b@\u0010\u0012J\u0011\u0010B\u001a\u0004\u0018\u00010AH\u0016¢\u0006\u0004\bB\u0010CJ+\u0010H\u001a\u00020\u000e\"\u0004\b\u0000\u0010D2\f\u0010F\u001a\b\u0012\u0004\u0012\u00028\u00000E2\u0006\u0010G\u001a\u00028\u0000H\u0016¢\u0006\u0004\bH\u0010IJ#\u0010K\u001a\u00020\u000e2\u0012\u0010J\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020)0(H\u0016¢\u0006\u0004\bK\u0010?J#\u0010M\u001a\u00020\u000e2\u0012\u0010L\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020)0(H\u0016¢\u0006\u0004\bM\u0010?J\u0017\u0010M\u001a\u00020\u000e2\u0006\u0010L\u001a\u00020\u0006H\u0016¢\u0006\u0004\bM\u0010NJ\u0011\u0010O\u001a\u0004\u0018\u00010-H\u0016¢\u0006\u0004\bO\u0010PJ\u001f\u0010T\u001a\u00020\u000e2\u0006\u0010R\u001a\u00020Q2\u0006\u0010S\u001a\u00020QH\u0016¢\u0006\u0004\bT\u0010UJ\u001b\u0010W\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020V0(H\u0016¢\u0006\u0004\bW\u0010XJ\u000f\u0010Y\u001a\u00020\u0006H\u0016¢\u0006\u0004\bY\u0010\bJ\u0017\u0010[\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001020ZH\u0016¢\u0006\u0004\b[\u0010\\J\u000f\u0010]\u001a\u00020\u0019H\u0016¢\u0006\u0004\b]\u0010^J\u0017\u0010`\u001a\u00020\u000e2\u0006\u0010_\u001a\u00020\u0019H\u0016¢\u0006\u0004\b`\u0010aJ\u000f\u0010b\u001a\u00020\u000eH\u0016¢\u0006\u0004\bb\u0010\u0012J\u000f\u0010c\u001a\u00020\u000eH\u0016¢\u0006\u0004\bc\u0010\u0012J\u000f\u0010d\u001a\u00020\u000eH\u0016¢\u0006\u0004\bd\u0010\u0012J\u000f\u0010e\u001a\u00020\u000eH\u0016¢\u0006\u0004\be\u0010\u0012J\u0011\u0010f\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\bf\u0010\bJ\u000f\u0010h\u001a\u00020gH\u0016¢\u0006\u0004\bh\u0010iJ/\u0010n\u001a\u00020\u000e2\u0006\u0010j\u001a\u00020Q2\u0006\u0010k\u001a\u00020Q2\u0006\u0010l\u001a\u00020Q2\u0006\u0010m\u001a\u00020QH\u0016¢\u0006\u0004\bn\u0010oJ\u0017\u0010q\u001a\u00020p2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\bq\u0010rJ\u0017\u0010v\u001a\u00020u2\u0006\u0010t\u001a\u00020sH\u0002¢\u0006\u0004\bv\u0010wJ\u0017\u0010z\u001a\u00020y2\u0006\u0010x\u001a\u00020pH\u0002¢\u0006\u0004\bz\u0010{J\u0017\u0010}\u001a\u00020\u000e2\u0006\u0010|\u001a\u00020QH\u0002¢\u0006\u0004\b}\u0010~J\u0017\u0010\u007f\u001a\u00020\u000e2\u0006\u0010|\u001a\u00020QH\u0002¢\u0006\u0004\b\u007f\u0010~J\u0011\u0010\u0080\u0001\u001a\u00020\u000eH\u0002¢\u0006\u0005\b\u0080\u0001\u0010\u0012J\u0011\u0010\u0081\u0001\u001a\u00020\u000eH\u0002¢\u0006\u0005\b\u0081\u0001\u0010\u0012J\u001a\u0010\u0083\u0001\u001a\u00020\u000e2\u0007\u0010\u0082\u0001\u001a\u00020QH\u0002¢\u0006\u0005\b\u0083\u0001\u0010~J\u001d\u0010\u0085\u0001\u001a\u0004\u0018\u00010A2\u0007\u0010\u0084\u0001\u001a\u00020AH\u0002¢\u0006\u0006\b\u0085\u0001\u0010\u0086\u0001J#\u0010\u0088\u0001\u001a\u00020\u000e2\u0007\u0010\u0087\u0001\u001a\u00020\u00192\u0006\u0010S\u001a\u00020QH\u0002¢\u0006\u0006\b\u0088\u0001\u0010\u0089\u0001J\u0011\u0010\u008a\u0001\u001a\u00020\u0019H\u0002¢\u0006\u0005\b\u008a\u0001\u0010^J\u0011\u0010\u008b\u0001\u001a\u00020\u000eH\u0002¢\u0006\u0005\b\u008b\u0001\u0010\u0012J\u001c\u0010\u008e\u0001\u001a\u00020\u00192\b\u0010\u008d\u0001\u001a\u00030\u008c\u0001H\u0002¢\u0006\u0006\b\u008e\u0001\u0010\u008f\u0001J\u0011\u0010\u0090\u0001\u001a\u00020\u000eH\u0002¢\u0006\u0005\b\u0090\u0001\u0010\u0012J\u0011\u0010\u0091\u0001\u001a\u00020\u000eH\u0002¢\u0006\u0005\b\u0091\u0001\u0010\u0012J\u0011\u0010\u0092\u0001\u001a\u00020\u000eH\u0002¢\u0006\u0005\b\u0092\u0001\u0010\u0012J1\u0010\u0096\u0001\u001a\u00020\u000e2\t\u0010\u0093\u0001\u001a\u0004\u0018\u00010A2\u0007\u0010\u0094\u0001\u001a\u00020\u00152\t\b\u0002\u0010\u0095\u0001\u001a\u00020\u0019H\u0002¢\u0006\u0006\b\u0096\u0001\u0010\u0097\u0001J6\u0010\u0098\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020)\u0018\u00010(2\u0014\u0010*\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020)\u0018\u00010(H\u0002¢\u0006\u0006\b\u0098\u0001\u0010\u0099\u0001J\u001c\u0010\u009a\u0001\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010-H\u0002¢\u0006\u0006\b\u009a\u0001\u0010\u009b\u0001J\u0011\u0010\u009c\u0001\u001a\u00020\u000eH\u0002¢\u0006\u0005\b\u009c\u0001\u0010\u0012R\u001a\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\u000f\n\u0005\b\u0003\u0010\u009d\u0001\u001a\u0006\b\u009e\u0001\u0010\u009f\u0001R \u0010¡\u0001\u001a\u00030 \u00018\u0004X\u0084\u0004¢\u0006\u0010\n\u0006\b¡\u0001\u0010¢\u0001\u001a\u0006\b£\u0001\u0010¤\u0001R#\u0010ª\u0001\u001a\u0005\u0018\u00010¥\u00018FX\u0086\u0084\u0002¢\u0006\u0010\n\u0006\b¦\u0001\u0010§\u0001\u001a\u0006\b¨\u0001\u0010©\u0001R\u0017\u0010«\u0001\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\b\n\u0006\b«\u0001\u0010¬\u0001R\u001e\u0010\u00ad\u0001\u001a\u0002028\u0004X\u0084\u0004¢\u0006\u000f\n\u0006\b\u00ad\u0001\u0010®\u0001\u001a\u0005\b¯\u0001\u00104R\u001f\u0010x\u001a\u00020p8FX\u0086\u0084\u0002¢\u0006\u0010\n\u0006\b°\u0001\u0010§\u0001\u001a\u0006\b±\u0001\u0010²\u0001R \u0010¶\u0001\u001a\u00020y8DX\u0084\u0084\u0002¢\u0006\u0010\n\u0006\b³\u0001\u0010§\u0001\u001a\u0006\b´\u0001\u0010µ\u0001R\u0017\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082.¢\u0006\u0007\n\u0005\b\r\u0010·\u0001R*\u0010¹\u0001\u001a\u00030¸\u00018\u0004@\u0004X\u0084.¢\u0006\u0018\n\u0006\b¹\u0001\u0010º\u0001\u001a\u0006\b»\u0001\u0010¼\u0001\"\u0006\b½\u0001\u0010¾\u0001R\u0019\u0010¿\u0001\u001a\u00020Q8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¿\u0001\u0010À\u0001R\u0019\u0010Á\u0001\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÁ\u0001\u0010Â\u0001R\u0019\u0010Ã\u0001\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÃ\u0001\u0010Â\u0001R\u0019\u0010Ä\u0001\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÄ\u0001\u0010Â\u0001R\u001c\u0010Æ\u0001\u001a\u0005\u0018\u00010Å\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÆ\u0001\u0010Ç\u0001R\u0019\u0010È\u0001\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÈ\u0001\u0010Â\u0001R\u001b\u0010É\u0001\u001a\u0004\u0018\u00010A8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÉ\u0001\u0010Ê\u0001R\u001b\u0010Ë\u0001\u001a\u0004\u0018\u00010A8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bË\u0001\u0010Ê\u0001R\u001b\u0010Ì\u0001\u001a\u0004\u0018\u00010A8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÌ\u0001\u0010Ê\u0001R\u001b\u0010Í\u0001\u001a\u0004\u0018\u00010A8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÍ\u0001\u0010Ê\u0001R \u0010Ï\u0001\u001a\t\u0012\u0004\u0012\u00020Q0Î\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÏ\u0001\u0010Ð\u0001R'\u0010Ñ\u0001\u001a\u00020\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0006\bÑ\u0001\u0010Â\u0001\u001a\u0005\bÒ\u0001\u0010^\"\u0005\bÓ\u0001\u0010aR\u0017\u0010]\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b]\u0010Â\u0001R\u0019\u0010Ô\u0001\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÔ\u0001\u0010Â\u0001R\u001b\u0010Õ\u0001\u001a\u0004\u0018\u00010Q8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÕ\u0001\u0010Ö\u0001R\u001b\u0010×\u0001\u001a\u0004\u0018\u00010Q8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b×\u0001\u0010Ö\u0001R\u001a\u0010Ù\u0001\u001a\u00030Ø\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÙ\u0001\u0010Ú\u0001R\u0019\u0010Û\u0001\u001a\u00020Q8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÛ\u0001\u0010À\u0001¨\u0006Þ\u0001"}, d2 = {"Lcom/bytedance/android/anniex/lite/container/AnnieXLiteContainer;", "Ls3/a;", "Lr3/d;", "builder", "<init>", "(Lr3/d;)V", "", "getUrl", "()Ljava/lang/String;", "Lcom/bytedance/ies/bullet/core/common/Scenes;", "getScenes", "()Lcom/bytedance/ies/bullet/core/common/Scenes;", "Ls3/f;", "uiComponent", "", "setUiComponent", "(Ls3/f;)V", "addKitView", "()V", "initUi", "observerKeyboardStatusChange", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "", "visible", "hasReadySendVisibleEvent", "onVisibleChange", "(ZLjava/lang/Boolean;)V", "getBid", "getContainerId", "Lcom/bytedance/ies/bullet/service/base/utils/KitType;", "getKitType", "()Lcom/bytedance/ies/bullet/service/base/utils/KitType;", "getCurrentUrl", "Lrd/b;", "getSchemaData", "()Lrd/b;", "schema", "", "", "renderData", "loadSchema", "(Ljava/lang/String;Ljava/util/Map;)V", "Lrb/b;", "contextProviderFactory", "Lv3/a;", "lifecycle", "(Ljava/lang/String;Ljava/util/Map;Lrb/b;Lv3/a;)V", "Landroid/content/Context;", "getSystemContext", "()Landroid/content/Context;", "generateSchemaData", "(Ljava/lang/String;)Lrd/b;", "getCurrentSchema", "Lcom/bytedance/ies/bullet/core/kit/bridge/f;", "event", "sendEvent", "(Lcom/bytedance/ies/bullet/core/kit/bridge/f;)V", "enterForeground", "enterBackground", "reload", "(Ljava/util/Map;)V", "release", "Landroid/view/View;", "getKitView", "()Landroid/view/View;", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/lang/Class;", "clazz", "item", "registerWeakHolder", "(Ljava/lang/Class;Ljava/lang/Object;)V", "globalProps", "updateGlobalProps", "data", "updateData", "(Ljava/lang/String;)V", "getContextProviderFactory", "()Lrb/b;", "", "width", "height", "updateScreenMetrics", "(II)V", "", "getPerfMap", "()Ljava/util/Map;", "getViewType", "Ljava/lang/ref/WeakReference;", "getWeakContext", "()Ljava/lang/ref/WeakReference;", "isVisibility", "()Z", "enable", "interceptBackPress", "(Z)V", "showError", "showLoading", "hideLoading", "close", "getBDXTag", "Lcom/bytedance/ies/bullet/service/sdk/param/LaunchMode;", "getBDXLaunchMode", "()Lcom/bytedance/ies/bullet/service/sdk/param/LaunchMode;", "scrollX", "scrollY", "oldScrollX", "oldScrollY", "onWebScrollChanged", "(IIII)V", "La4/a;", "createAnnieXContext", "(Lr3/d;)La4/a;", "Landroid/os/Bundle;", "bundle", "Landroid/net/Uri;", "getUriByBundle", "(Landroid/os/Bundle;)Landroid/net/Uri;", "annieXContext", "Lx3/a;", "createEngine", "(La4/a;)Lx3/a;", "state", "putState", "(I)V", "changeState", "transferToTargetState", "initContainerColor", "softHeight", "possiblyResizeChildOfContent", "decorView", "getContentView", "(Landroid/view/View;)Landroid/view/View;", "isShowing", "sendKeyboardStatusChangeEvent", "(ZI)V", "needAdapterKeyboard", "addTagView", "Lmb/b;", "debugInfo", "showContainerTag", "(Lmb/b;)Z", "setContainerColor", "setBackgroundColor", "updateLynxScreenMetrics", "view", "configuration", "isKitViewCreate", "padAdaptation", "(Landroid/view/View;Landroid/content/res/Configuration;Z)V", "completeRenderData", "(Ljava/util/Map;)Ljava/util/Map;", "mergeContext", "(Lrb/b;)Lrb/b;", "bindWebOnScrollChangeListener", "Lr3/d;", "getBuilder", "()Lr3/d;", "Lcom/bytedance/android/anniex/container/j;", "lifecycleDispatcher", "Lcom/bytedance/android/anniex/container/j;", "getLifecycleDispatcher", "()Lcom/bytedance/android/anniex/container/j;", "Ltd/a;", "containerModel$delegate", "Lkotlin/Lazy;", "getContainerModel", "()Ltd/a;", "containerModel", "currentBid", "Ljava/lang/String;", "context", "Landroid/content/Context;", "getContext", "annieXContext$delegate", "getAnnieXContext", "()La4/a;", "engine$delegate", "getEngine", "()Lx3/a;", "engine", "Ls3/f;", "Landroid/view/ViewGroup;", "parentViewGroup", "Landroid/view/ViewGroup;", "getParentViewGroup", "()Landroid/view/ViewGroup;", "setParentViewGroup", "(Landroid/view/ViewGroup;)V", "currentState", "I", "isResuming", "Z", "isRuntimeReady", "loadSuccess", "Landroid/graphics/drawable/Drawable;", "originBackground", "Landroid/graphics/drawable/Drawable;", "useCustomBackground", "errorView", "Landroid/view/View;", "loadingView", "noticeView", "denyView", "Ljava/util/concurrent/ArrayBlockingQueue;", "stateBlockingQueue", "Ljava/util/concurrent/ArrayBlockingQueue;", "containerVisible", "getContainerVisible", "setContainerVisible", "isNotRelease", "padAdapterWidth", "Ljava/lang/Integer;", "padAdapterHeight", "com/bytedance/android/anniex/lite/container/c", "annieLifeCycle", "Lcom/bytedance/android/anniex/lite/container/c;", "usableHeightPrevious", "Companion", "com/bytedance/android/anniex/lite/container/b", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
@SourceDebugExtension({"SMAP\nAnnieXLiteContainer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AnnieXLiteContainer.kt\ncom/bytedance/android/anniex/lite/container/AnnieXLiteContainer\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,896:1\n1#2:897\n1819#3,2:898\n*E\n*S KotlinDebug\n*F\n+ 1 AnnieXLiteContainer.kt\ncom/bytedance/android/anniex/lite/container/AnnieXLiteContainer\n*L\n312#1,2:898\n*E\n"})
public abstract class AnnieXLiteContainer extends s3.a {
    public static final b Companion = null;
    private static final int LOAD_STATUS_CREATE_KIT_VIEW = 2;
    private static final int LOAD_STATUS_DESTROY = 6;
    private static final int LOAD_STATUS_FINISH = 4;
    private static final int LOAD_STATUS_INIT_UI = 0;
    private static final int LOAD_STATUS_LOADING = 3;
    private static final int LOAD_STATUS_PARSE_SCHEMA = 1;
    private static final int LOAD_STATUS_RUNTIME_READY = 5;
    private static final int LOAD_STATUS_UNKNOWN = -1;
    private static final String TAG = "AnnieXContainer";
    private static final String VISIBLE_CHANGE_TYPE_APP = "app";
    private static final String VISIBLE_CHANGE_TYPE_PAGE = "page";
    private c annieLifeCycle;
    private final Lazy annieXContext$delegate;
    private final r3.d builder;
    private final Lazy containerModel$delegate;
    private volatile boolean containerVisible;
    private final Context context;
    private final String currentBid;
    private int currentState;
    private View denyView;
    private final Lazy engine$delegate;
    private View errorView;
    private boolean isNotRelease;
    private boolean isResuming;
    private boolean isRuntimeReady;
    private volatile boolean isVisibility;
    private final j lifecycleDispatcher;
    private boolean loadSuccess;
    private View loadingView;
    private View noticeView;
    private Drawable originBackground;
    private Integer padAdapterHeight;
    private Integer padAdapterWidth;
    protected ViewGroup parentViewGroup;
    private ArrayBlockingQueue<Integer> stateBlockingQueue;
    private s3.f uiComponent;
    private int usableHeightPrevious;
    private boolean useCustomBackground;

    static {
        Companion = new b();
    }

    public AnnieXLiteContainer(r3.d r5) {
        Intrinsics.checkNotNullParameter(r5, "builder");
        this.builder = r5;
        j r10 = new j();
        com.bytedance.android.anniex.container.ui.b r11 = r5.f;
        if (r11 == null) goto L5;
        Intrinsics.checkNotNullParameter(r11, "lifecycle");
        r10.f3151a.add(r11);
    L5:
        this.lifecycleDispatcher = r10;
        this.containerModel$delegate = LazyKt.lazy(new AnnieXLiteContainer$containerModel$2(this));
        this.currentBid = r5.f21653b;
        FragmentActivity r12 = r5.f21652a;
        if (r12 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("systemContext");
        r12 = null;
    L9:
        this.context = r12;
        this.annieXContext$delegate = LazyKt.lazy(new AnnieXLiteContainer$annieXContext$2(this));
        this.engine$delegate = LazyKt.lazy(new AnnieXLiteContainer$engine$2(this));
        this.currentState = -1;
        this.stateBlockingQueue = new ArrayBlockingQueue(10);
        this.isNotRelease = true;
        this.annieLifeCycle = new c(this);
    }

    public static final /* synthetic */ void access$bindWebOnScrollChangeListener(AnnieXLiteContainer r5) {
        r5.bindWebOnScrollChangeListener();
    }

    public static final /* synthetic */ void access$changeState(AnnieXLiteContainer r5, int r10) {
        r5.changeState(r10);
    }

    public static final /* synthetic */ a4.a access$createAnnieXContext(AnnieXLiteContainer r5, r3.d r10) {
        return r5.createAnnieXContext(r10);
    }

    public static final /* synthetic */ x3.a access$createEngine(AnnieXLiteContainer r5, a4.a r10) {
        return r5.createEngine(r10);
    }

    public static final /* synthetic */ s3.f access$getUiComponent$p(AnnieXLiteContainer r5) {
        return r5.uiComponent;
    }

    public static final /* synthetic */ void access$possiblyResizeChildOfContent(AnnieXLiteContainer r5, int r10) {
        r5.possiblyResizeChildOfContent(r10);
    }

    public static final /* synthetic */ void access$putState(AnnieXLiteContainer r5, int r10) {
        r5.putState(r10);
    }

    public static final /* synthetic */ void access$sendKeyboardStatusChangeEvent(AnnieXLiteContainer r5, boolean r10, int r11) {
        r5.sendKeyboardStatusChangeEvent(r10, r11);
    }

    public static final /* synthetic */ void access$setLoadSuccess$p(AnnieXLiteContainer r5, boolean r10) {
        r5.loadSuccess = r10;
    }

    private final void addTagView() {
        int r5 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        DebugTagTextView r10 = null;
        com.bytedance.ies.bullet.base.utils.logger.a.g(TAG, "===addTagView: " + getUrl(), null, 12);
        ConcurrentHashMap r11 = mb.a.f20054a;
        mb.b r12 = mb.a.a(this.currentBid);
        if (showContainerTag(r12) == true) goto L6;
        r12 = null;
    L6:
        if (r12 == null) goto L12;
        View r13 = LayoutInflater.from(this.context).inflate(R$layout.bullet_debug_tag_view, getParentViewGroup(), false);
        if ((r13 instanceof DebugTagTextView) == false) goto L10;
        r10 = (DebugTagTextView) r13;
    L10:
        FrameLayout.LayoutParams r14 = new FrameLayout.LayoutParams(-2, -2);
        r14.gravity = 8388661;
        getParentViewGroup().addView(r10, r14);
        return;
    }

    private final void bindWebOnScrollChangeListener() {
        if ((getKitView() instanceof SSWebView) == false) goto L6;
        View r5 = getKitView();
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type com.bytedance.ies.bullet.kit.web.SSWebView");
        ((SSWebView) r5).setWebScrollListener(new n(this));
        return;
    }

    private final void changeState(int r5) {
        this.currentState = r5;
        if (r5 != 0) goto L5;
        transferToTargetState();
        initContainerColor();
        return;
    L5:
        if (r5 == 1) goto L26;
        if (r5 != 2) goto L9;
        addKitView();
        getContainerModel();
        return;
    L9:
        if (r5 == 4) goto L18;
        if (r5 != 5) goto L61;
        this.isRuntimeReady = true;
        if (this.isResuming == false) goto L60;
        getEngine().enterForeground();
        return;
    L60:
        return;
    L61:
        return;
    L18:
        if (this.loadSuccess == false) goto L20;
        com.bytedance.ies.bullet.base.utils.logger.a.c(TAG, "load success");
        setContainerColor();
    L21:
        hideLoading();
        addTagView();
        return;
    L20:
        com.bytedance.ies.bullet.base.utils.logger.a.c(TAG, "load fail");
        showError();
        goto L21
    L26:
        if (Intrinsics.areEqual(getViewType(), OpenPageMethod.APP_POPUP) == false) goto L41;
        LinkedHashMap r10 = new LinkedHashMap();
        Iterator r11 = ((LinkedHashMap) com.bytedance.android.anniex.container.util.b.f3200a.getValue()).entrySet().iterator();
    L29:
        if (r11.hasNext() == false) goto L33;
        Map.Entry r12 = (Map.Entry) r11.next();
        s3.b r13 = (s3.b) ((WeakReference) r12.getValue()).get();
        if (r13 == null) goto L29;
        r10.put(r12.getKey(), new WeakReference(r13));
        goto L29
    L33:
        Iterator r14 = r10.entrySet().iterator();
    L35:
        if (r14.hasNext() == false) goto L41;
        s3.b r15 = (s3.b) ((WeakReference) ((Map.Entry) r14.next()).getValue()).get();
        if (r15 == null) goto L35;
        if (Intrinsics.areEqual(r15.getWeakContext().get(), this.context) == false) goto L35;
        r15.onVisibleChange(false, Boolean.FALSE);
    L41:
        Lazy r16 = com.bytedance.android.anniex.container.util.b.f3200a;
        Intrinsics.checkNotNullParameter(this, "container");
        String r17 = getBDXTag();
        if (r17 == null) goto L44;
        com.bytedance.android.anniex.container.util.b.a(r17, getBDXLaunchMode(), this);
    L44:
        ((LinkedHashMap) com.bytedance.android.anniex.container.util.b.f3200a.getValue()).put(getContainerId(), new WeakReference(this));
    }

    private final Map<String, Object> completeRenderData(Map<String, ? extends Object> r10) {
        LinkedHashMap r5 = new LinkedHashMap();
        String r11 = getAnnieXContext().f90b;
        if (r11 == null) goto L15;
        LinkedHashMap r12 = com.bytedance.android.anniex.monitor.c.f3335a;
        Intrinsics.checkNotNullParameter(r11, "sessionId");
        id.c r13 = (id.c) com.bytedance.android.anniex.monitor.c.f3335a.get(r11);
        if (r13 == null) goto L7;
        LinkedHashMap r14 = new LinkedHashMap();
        r14.put("open_time", Long.valueOf(r13.d("open_time")));
        r14.put("container_init_start", Long.valueOf(r13.d("container_init_start")));
        r14.put("container_init_end", Long.valueOf(r13.d("container_init_end")));
    L8:
        if (r14 == null) goto L15;
        r5.putAll(r14);
        Object r15 = r14.get("open_time");
        if (r15 == null) goto L15;
        if (Intrinsics.areEqual(this.builder.f21653b, "webcast") == false) goto L14;
        r5.put("initTimestamp", r15.toString());
        goto L15
    L14:
        r5.put("containerInitTime", r15);
        goto L15
    L7:
        r14 = null;
    L15:
        r5.put("page_type_opt", "lite_page");
        if (r10 == null) goto L18;
        r5.putAll(r10);
    L18:
        return r5;
    }

    private final a4.a createAnnieXContext(r3.d r11) {
        Uri r5 = getUriByBundle(r11.f21654c);
        String r10 = com.lynx.tasm.behavior.utils.d.b(r5, r11.f21654c);
        LruCache r12 = com.bytedance.android.anniex.lite.b.f3223a;
        rd.e r13 = com.bytedance.android.anniex.lite.b.a(r5, this.currentBid, r10);
        String r14 = (String) ((com.bytedance.ies.bullet.service.sdk.b) r13.f21723a).f6143o.get("url");
        if (r14 != null) goto L5;
        r14 = r5.toString();
    L5:
        String r15 = r14;
        com.bytedance.android.anniex.worker.b r16 = com.bytedance.android.anniex.worker.b.f3505a;
        Context r17 = this.context.getApplicationContext();
        Intrinsics.checkNotNull(r17, "null cannot be cast to non-null type android.app.Application");
        r16.b((Application) r17, r5.toString());
        Scenes r18 = getScenes();
        String r19 = this.currentBid;
        Uri r110 = Uri.parse(r15);
        Intrinsics.checkNotNullParameter(r110, LynxResourceModule.URI_KEY);
        String r111 = r110.getScheme();
        if (r111 == null) goto L27;
        int r20 = r111.hashCode();
        if (r20 == (-1772600516)) goto L24;
        if (r20 == 3213448) goto L20;
        if (r20 != 99617003) goto L27;
        if (r111.equals(IIvyAIPackageResourceService.SCHEMA) == false) goto L27;
        KitType r112 = KitType.f6012c;
    L18:
        KitType r21 = r112;
        a4.a r22 = new a4.a(r18, r10, r19, r11.f21654c, r15, r21, r13);
        FragmentActivity r113 = r11.f21652a;
        if (r113 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("systemContext");
        r113 = null;
    L32:
        r22.g = r113;
        return r22;
    L20:
        if (r111.equals("http") == false) goto L27;
        r112 = KitType.f6012c;
        goto L18
    L24:
        if (r111.equals("lynxview") == false) goto L27;
        r112 = KitType.d;
    L27:
        r112 = KitType.f6011b;
        goto L18
    }

    private final x3.a createEngine(a4.a r5) {
        if (r5.d == KitType.d) goto L5;
        ConcurrentHashMap r10 = yc.a.f23246a;
        Intrinsics.checkNotNullParameter(xc.e.class, "cls");
        xc.e r11 = (xc.e) yc.a.a(xc.e.class, "default_bid");
        if (r11 == null) goto L11;
        xc.d r12 = (xc.d) r11.a(xc.d.class);
        if (r12 == null) goto L11;
        boolean r13 = r12.c();
    L12:
        if (r13 == false) goto L17;
        if (StringsKt.g(r5.e, "template.js") == false) goto L17;
        int r14 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        com.bytedance.ies.bullet.base.utils.logger.a.d(TAG, "===createEngine Web error:" + ((com.bytedance.ies.bullet.service.sdk.b) r5.f.f21723a).f6135c, null, 12);
    L17:
        return new i(this, r5);
    L11:
        r13 = true;
        goto L12
    L5:
        return new g(this, r5);
    }

    private final View getContentView(View r5) {
        View r10 = r5.findViewById(R.id.content);
        if ((r10 instanceof ViewGroup) == true) goto L5;
        return null;
    L5:
        return (ViewGroup) r10;
    }

    private final Uri getUriByBundle(Bundle r5) {
        String r10 = r5.getString("__x_inner_schema");
        if (r10 == null) goto L5;
        Uri r11 = Uri.parse(r10);
    L6:
        if (r11 == null) goto L8;
        return r11;
    L8:
        return Uri.EMPTY;
    L5:
        r11 = null;
        goto L6
    }

    private final void initContainerColor() {
        getContainerModel();
    }

    private final rb.b mergeContext(rb.b r5) {
        rb.b r10 = getAnnieXContext().f92h;
        if (r5 == null) goto L5;
        r10.getClass();
        Intrinsics.checkNotNullParameter(r5, "other");
        r10.f21717a.putAll(r5.f21717a);
    L5:
        return r10;
    }

    private final boolean needAdapterKeyboard() {
        if ((getEngine().b() instanceof LynxView) == false) goto L5;
        return false;
    L5:
        getContainerModel();
        return false;
    }

    private final void padAdaptation(View r5, Configuration r10, boolean r11) {
        if (r5 != null) goto L4;
        return;
    L4:
        Intrinsics.areEqual(getViewType(), VISIBLE_CHANGE_TYPE_PAGE);
        com.lynx.tasm.base.a.i(getAnnieXContext().f);
        int r12 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        com.bytedance.ies.bullet.base.utils.logger.a.g(TAG, "padAdaptation : current scenes=" + getViewType() + ",padAdapterWidth=" + this.padAdapterWidth + ",padAdapterHeight=" + this.padAdapterHeight, null, 12);
    }

    public static /* synthetic */ void padAdaptation$default(AnnieXLiteContainer r5, View r10, Configuration r11, boolean r12, int r13, Object r14) {
        if (r14 != null) goto L9;
        if ((r13 & 4) == 0) goto L6;
        r12 = false;
    L6:
        r5.padAdaptation(r10, r11, r12);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: padAdaptation");
    }

    private final void possiblyResizeChildOfContent(int r10) {
        if (needAdapterKeyboard() == false) goto L20;
        View r5 = getParentViewGroup().getRootView();
        int r11 = r5.getHeight();
        int r12 = r11 - r10;
        if (r12 == this.usableHeightPrevious) goto L18;
        View r13 = getContentView(r5);
        if (r13 == null) goto L10;
        ViewGroup.LayoutParams r14 = r13.getLayoutParams();
    L11:
        if (r14 != null) goto L13;
        return;
    L13:
        if (r10 <= (r11 / 4)) goto L15;
        r14.height = r12;
    L16:
        r13.requestLayout();
        this.usableHeightPrevious = r12;
        return;
    L15:
        r14.height = r11;
        goto L16
    L10:
        r14 = null;
        goto L11
    L18:
        return;
    }

    private final void putState(int r5) {
        if (this.parentViewGroup == null) goto L11;
        Context r10 = this.context;
        if ((r10 instanceof Activity) == false) goto L7;
        Activity r11 = (Activity) r10;
    L8:
        if (r11 == null) goto L13;
        r11.runOnUiThread(new com.bytedance.android.anniex.container.i(r5, 1, this));
        return;
    L13:
        return;
    L7:
        r11 = null;
        goto L8
    L11:
        this.stateBlockingQueue.put(Integer.valueOf(r5));
    }

    private final void sendKeyboardStatusChangeEvent(boolean r5, int r10) {
        JSONObject r11 = new JSONObject();
        r11.put("visible", r5);
        r11.put("height", r10);
        sendEvent(new com.bytedance.android.anniex.container.g(r11, 5));
        sendEvent(new com.bytedance.android.anniex.container.g(r11, 6));
    }

    private final void setBackgroundColor() {
        getContainerModel();
        Intrinsics.checkNotNull(null);
        throw null;
    }

    private final void setContainerColor() {
        getContainerModel();
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

    private final void transferToTargetState() {
    L3:
        if (this.stateBlockingQueue.isEmpty() == true) goto L5;
        changeState(this.stateBlockingQueue.take().intValue());
        goto L3
    }

    private final void updateLynxScreenMetrics() {
        View r5 = getEngine().b();
        if (r5 == null) goto L10;
        rd.e r10 = getAnnieXContext().f;
        Intrinsics.areEqual(getViewType(), VISIBLE_CHANGE_TYPE_PAGE);
        com.lynx.tasm.base.a.i(r10);
        Context r11 = r5.getContext();
        if (r11 == null) goto L11;
        xd.d r12 = v0.p(r11);
        if (r12 == null) goto L12;
        int r13 = r12.f23105a;
        int r14 = r12.f23106b;
        updateScreenMetrics(r13, r14);
        int r15 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        com.bytedance.ies.bullet.base.utils.logger.a.g(TAG, j0.f(r13, r14, "updateLynxScreenMetrics : enableIpadAdapter false , width ", " , height "), null, 12);
        return;
    L12:
        return;
    L11:
        return;
    }

    public void addKitView() {
        int r5 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        com.bytedance.ies.bullet.base.utils.logger.a.g(TAG, "===addKitView: " + getUrl(), null, 12);
        getParentViewGroup().removeAllViews();
        View r10 = getEngine().b();
        if (r10 == null) goto L6;
        getParentViewGroup().addView(r10);
        padAdaptation(r10, this.context.getResources().getConfiguration(), true);
        this.lifecycleDispatcher.d(getUrl(), this);
        return;
    }

    @Override // s3.b
    public void close() {
        int r5 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        s3.f r10 = null;
        com.bytedance.ies.bullet.base.utils.logger.a.g(TAG, "===close: " + getUrl(), null, 12);
        if (this.isNotRelease == false) goto L10;
        s3.f r11 = this.uiComponent;
        if (r11 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("uiComponent");
    L8:
        r10.a();
        return;
    L7:
        r10 = r11;
        goto L8
    }

    @Override // s3.b
    public void enterBackground() {
        this.isVisibility = false;
        getEngine().enterBackground();
    }

    @Override // s3.b
    public void enterForeground() {
        this.isVisibility = true;
        getEngine().enterForeground();
    }

    public rd.b generateSchemaData(String r5) {
        Intrinsics.checkNotNullParameter(r5, "schema");
        return getAnnieXContext().f.f21723a;
    }

    public final a4.a getAnnieXContext() {
        return (a4.a) this.annieXContext$delegate.getValue();
    }

    @Override // s3.b
    public LaunchMode getBDXLaunchMode() {
        LaunchMode r5 = (LaunchMode) new vd.a(getAnnieXContext().f.f21723a, null).f22372b;
        if (r5 == null) goto L5;
        return r5;
    L5:
        return LaunchMode.f6147b;
    }

    @Override // s3.b
    public String getBDXTag() {
        return (String) new vd.a(getAnnieXContext().f.f21723a, "bdx_tag", null).f22372b;
    }

    @Override // s3.b
    public String getBid() {
        return getAnnieXContext().f91c;
    }

    public final r3.d getBuilder() {
        return this.builder;
    }

    @Override // s3.b
    public String getContainerId() {
        return getAnnieXContext().f90b;
    }

    public final td.a getContainerModel() {
        if (this.containerModel$delegate.getValue() != null) goto L7;
        return null;
    L7:
        throw new ClassCastException();
    }

    public final boolean getContainerVisible() {
        return this.containerVisible;
    }

    public final Context getContext() {
        return this.context;
    }

    public rb.b getContextProviderFactory() {
        return getAnnieXContext().f92h;
    }

    @Override // s3.b
    public rd.b getCurrentSchema() {
        return getAnnieXContext().f.f21723a;
    }

    public String getCurrentUrl() {
        return getAnnieXContext().e;
    }

    public final x3.a getEngine() {
        return (x3.a) this.engine$delegate.getValue();
    }

    public KitType getKitType() {
        return getAnnieXContext().d;
    }

    @Override // s3.b
    public View getKitView() {
        return getEngine().b();
    }

    public final j getLifecycleDispatcher() {
        return this.lifecycleDispatcher;
    }

    public final ViewGroup getParentViewGroup() {
        ViewGroup r5 = this.parentViewGroup;
        if (r5 == null) goto L5;
        return r5;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("parentViewGroup");
        return null;
    }

    public Map<String, Long> getPerfMap() {
        return new LinkedHashMap();
    }

    public Scenes getScenes() {
        return Scenes.g;
    }

    @Override // s3.b
    public rd.b getSchemaData() {
        return getAnnieXContext().f.f21723a;
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
        return new WeakReference(getAnnieXContext().g);
    }

    public void hideLoading() {
        int r5 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        com.bytedance.ies.bullet.base.utils.logger.a.g(TAG, "===hideLoading: " + getUrl(), null, 12);
        View r10 = this.loadingView;
        if (r10 != null) goto L5;
        return;
    L5:
        r10.setVisibility(8);
    }

    public final void initUi() {
        int r5 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        com.bytedance.ies.bullet.base.utils.logger.a.g(TAG, "===initUi: " + getUrl(), null, 12);
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L5
        observerKeyboardStatusChange();     // Catch: Throwable -> L5
        putState(0);     // Catch: Throwable -> L5
        Object r11 = Result.m124constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r12 = Result.m127exceptionOrNullimpl(r11);
        if (r12 == null) goto L13;
        int r13 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        com.bytedance.ies.bullet.base.utils.logger.a.d(TAG, "initUi===>" + r12.getMessage(), null, 12);
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

    public boolean isVisibility() {
        return this.isVisibility;
    }

    @Override // s3.b
    public void loadSchema(String r5, Map<String, ? extends Object> r10) {
        Intrinsics.checkNotNullParameter(r5, "schema");
        loadSchema(r5, r10, null, this.annieLifeCycle);
    }

    public void observerKeyboardStatusChange() {
        if (Intrinsics.areEqual(getViewType(), "card") == true) goto L14;
        Context r5 = this.context;
        if ((r5 instanceof Activity) == false) goto L7;
        final Activity r10 = (Activity) r5;
    L8:
        if (r10 == null) goto L15;
        Function1<Boolean, Unit> r11 = new AnnieXLiteContainer$observerKeyboardStatusChange$1$1(r10, this);
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if ((r10 instanceof ComponentActivity) == false) goto L12;
        ((ComponentActivity) r10).getLifecycle().addObserver(com.bytedance.ies.bullet.base.utils.keyboard.a.f5240a);
    L12:
        qo.a.f(r10.getWindow(), null, r11);
        return;
    L15:
        return;
    L7:
        r10 = null;
        goto L8
    }

    public void onConfigurationChanged(Configuration r10) {
        Intrinsics.checkNotNullParameter(r10, "newConfig");
        padAdaptation$default(this, getEngine().b(), r10, false, 4, null);
        updateLynxScreenMetrics();
    }

    @Override // s3.b
    public void onVisibleChange(boolean r5, Boolean r10) {
        if (r5 != this.containerVisible) goto L5;
        return;
    L5:
        this.containerVisible = r5;
        sendEvent(new com.bytedance.android.anniex.container.h(r5, this, 1));
    }

    public void onWebScrollChanged(int r5, int r10, int r11, int r12) {
    }

    public <T> void registerWeakHolder(Class<T> r5, T r10) {
        Intrinsics.checkNotNullParameter(r5, "clazz");
        rb.b r11 = getAnnieXContext().f92h;
        if (r11 == null) goto L6;
        Intrinsics.checkNotNullParameter(r5, "clazz");
        r11.b(r5, new rb.a(r10));
        return;
    }

    @Override // s3.b
    public void release() {
        if (this.isNotRelease == true) goto L5;
        return;
    L5:
        int r5 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        com.bytedance.ies.bullet.base.utils.logger.a.g(TAG, "===release: " + getUrl(), null, 12);
        getEngine().release();
        getAnnieXContext().release();
        this.errorView = null;
        this.loadingView = null;
        this.noticeView = null;
        this.denyView = null;
        this.isNotRelease = false;
    }

    public void reload(Map<String, ? extends Object> r5) {
        if (this.loadSuccess == false) goto L10;
        int r10 = this.currentState;
        if (r10 != 5) goto L7;
    L8:
        getEngine().a();
        return;
    L7:
        if (r10 == 4) goto L8;
    L10:
        loadSchema(getUrl(), r5);
    }

    public void sendEvent(com.bytedance.ies.bullet.core.kit.bridge.f r5) {
        Intrinsics.checkNotNullParameter(r5, "event");
        getEngine().c(r5);
    }

    public final void setContainerVisible(boolean r5) {
        this.containerVisible = r5;
    }

    public final void setParentViewGroup(ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.parentViewGroup = r5;
    }

    public final void setUiComponent(s3.f r5) {
        Intrinsics.checkNotNullParameter(r5, "uiComponent");
        this.uiComponent = r5;
    }

    public void showError() {
        int r5 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        com.bytedance.ies.bullet.base.utils.logger.a.g(TAG, "===showError: " + getUrl(), null, 12);
        if (this.errorView == null) goto L5;
    L10:
        View r10 = this.errorView;
        if (r10 == null) goto L14;
        getParentViewGroup().addView(r10);
        r10.setVisibility(0);
        return;
    L14:
        return;
    L5:
        if (this.isNotRelease == false) goto L10;
        com.bytedance.ies.bullet.base.utils.logger.a.g(TAG, "create error view", null, 12);
        s3.f r11 = this.uiComponent;
        if (r11 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("uiComponent");
        r11 = null;
    L9:
        r11.b();
        this.errorView = null;
        goto L10
    }

    public void showLoading() {
        int r5 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        com.bytedance.ies.bullet.base.utils.logger.a.g(TAG, "===showLoading: " + getUrl(), null, 12);
        View r10 = this.loadingView;
        if (r10 != null) goto L5;
        return;
    L5:
        r10.setVisibility(0);
    }

    public void updateData(Map<String, ? extends Object> r5) {
        Intrinsics.checkNotNullParameter(r5, "data");
        getEngine().a(r5);
    }

    public void updateGlobalProps(Map<String, ? extends Object> r5) {
        Intrinsics.checkNotNullParameter(r5, "globalProps");
        getAnnieXContext().f93i.putAll(r5);
    }

    public void updateScreenMetrics(int r5, int r10) {
        getEngine().getClass();
    }

    public void loadSchema(String r10, Map<String, ? extends Object> r11, rb.b r12, v3.a r13) {
        Intrinsics.checkNotNullParameter(r10, "schema");
        String r5 = getAnnieXContext().f90b;
        if (r5 == null) goto L5;
        LinkedHashMap r14 = com.bytedance.android.anniex.monitor.c.f3335a;
        Intrinsics.checkNotNullParameter(r5, "sessionId");
        long r15 = System.currentTimeMillis();
        com.bytedance.android.anniex.monitor.c.q(r5, com.bytedance.android.anniex.monitor.c.f3335a).a("container_init_end", Long.valueOf(r15));
        ExecutorService r16 = com.bytedance.ies.bullet.service.monitor.d.f6039a;
        com.bytedance.ies.bullet.service.monitor.d.a(r5, "container_init_end", Long.valueOf(r15));
        Intrinsics.checkNotNullParameter(r5, "sessionId");
        Intrinsics.checkNotNullParameter(r10, "schema");
    L5:
        getEngine().b(r10, completeRenderData(r11), mergeContext(r12), this.annieLifeCycle);
    }

    public void updateData(String r5) {
        Intrinsics.checkNotNullParameter(r5, "data");
        getEngine().a(r5);
    }
}
