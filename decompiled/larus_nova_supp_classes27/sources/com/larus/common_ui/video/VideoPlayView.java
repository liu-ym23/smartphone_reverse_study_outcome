package com.larus.common_ui.video;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.bmhome.monitor.CommonUIMessageImageLoader;
import com.larus.bmhome.monitor.CommonUIMessageImageType;
import com.larus.common_ui.view.ActivityIndicatorView;
import com.larus.doc.sdk.impl.BuildConfig;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.image.loader.b0;
import com.larus.media.MediaLevel;
import com.larus.media.MediaOccupyStrategy;
import com.larus.media.MediaResourceManager;
import com.larus.media.MixPriority;
import com.larus.platform.api.IVideoController;
import com.larus.platform.api.l4;
import com.larus.platform.api.n0;
import com.larus.platform.api.p0;
import com.larus.utils.e1;
import com.larus.utils.j0;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.ref.WeakReference;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import v19.d7;
import v19.i5;
import v19.m5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u009c\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\bB\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0016*\u0002\u0088\u0001\b\u0016\u0018\u0000 ¢\u00022\u00020\u0001:\u000e¡\u0002¢\u0002£\u0002¤\u0002¥\u0002¦\u0002§\u0002B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0015\u001a\u00020\u0016J\u0006\u0010\u0017\u001a\u00020\u0016J\u001a\u0010m\u001a\u00020\u00162\u0006\u0010n\u001a\u00020E2\b\b\u0002\u0010o\u001a\u00020\u0010H\u0002J\u0010\u0010p\u001a\u00020\u00102\u0006\u0010q\u001a\u00020jH\u0002J-\u0010¨\u0001\u001a\u00020\u00162\u0007\u0010©\u0001\u001a\u00020\u00072\u0007\u0010ª\u0001\u001a\u00020\u00072\u0007\u0010«\u0001\u001a\u00020\u00072\u0007\u0010¬\u0001\u001a\u00020\u0007H\u0014J\u0010\u0010\u00ad\u0001\u001a\u00020\u00162\u0007\u0010®\u0001\u001a\u00020\u0010J\u0007\u0010¯\u0001\u001a\u00020\u0016J\t\u0010°\u0001\u001a\u00020\u0016H\u0014J\t\u0010±\u0001\u001a\u00020\u0016H\u0014J\u0007\u0010²\u0001\u001a\u00020\u0016JR\u0010³\u0001\u001a\u00020\u00162\t\u0010´\u0001\u001a\u0004\u0018\u00010[2\n\b\u0002\u0010U\u001a\u0004\u0018\u00010E2\u000b\b\u0002\u0010µ\u0001\u001a\u0004\u0018\u00010E2\u000b\b\u0002\u0010¶\u0001\u001a\u0004\u0018\u00010E2\u000b\b\u0002\u0010·\u0001\u001a\u0004\u0018\u00010E2\u000b\b\u0002\u0010¸\u0001\u001a\u0004\u0018\u00010EJ\u0012\u0010¹\u0001\u001a\u00020\u00162\t\u0010´\u0001\u001a\u0004\u0018\u00010[J\u0007\u0010º\u0001\u001a\u00020\u0010J{\u0010»\u0001\u001a\u00020\u00162\u000b\b\u0002\u0010¼\u0001\u001a\u0004\u0018\u00010E2\u000b\b\u0002\u0010½\u0001\u001a\u0004\u0018\u00010E2\u000b\b\u0002\u0010µ\u0001\u001a\u0004\u0018\u00010E2\u000b\b\u0002\u0010¾\u0001\u001a\u0004\u0018\u00010\u00072\u000b\b\u0002\u0010¿\u0001\u001a\u0004\u0018\u00010\u00072\u000b\b\u0002\u0010À\u0001\u001a\u0004\u0018\u00010G2\u0011\b\u0002\u0010Á\u0001\u001a\n\u0012\u0004\u0012\u00020J\u0018\u00010I2\u000b\b\u0002\u0010Â\u0001\u001a\u0004\u0018\u00010E¢\u0006\u0003\u0010Ã\u0001J\t\u0010Ä\u0001\u001a\u00020\u0016H\u0014J\u0007\u0010Å\u0001\u001a\u00020\u0016J\u0007\u0010Æ\u0001\u001a\u00020\u0016J\u0007\u0010Ç\u0001\u001a\u00020\u0010J\u000f\u0010È\u0001\u001a\u00020\u00162\u0006\u0010K\u001a\u00020\u0010J\u0012\u0010É\u0001\u001a\u00020\u00162\u0007\u0010Ê\u0001\u001a\u000207H\u0002J\t\u0010Ë\u0001\u001a\u00020\u0016H\u0002J\u0012\u0010Ì\u0001\u001a\u00020\u00162\u0007\u0010Í\u0001\u001a\u00020EH\u0002J\u0012\u0010Î\u0001\u001a\u00020\u00162\u0007\u0010Í\u0001\u001a\u00020EH\u0002J\u0012\u0010Ï\u0001\u001a\u00020\u00162\u0007\u0010Ð\u0001\u001a\u00020EH\u0002J\t\u0010Ñ\u0001\u001a\u00020\u0016H\u0002J\u0007\u0010Ò\u0001\u001a\u00020\u0016J\u0007\u0010Ó\u0001\u001a\u00020EJ\u0019\u0010Ô\u0001\u001a\u00020\u00162\u0007\u0010¿\u0001\u001a\u00020\u00072\u0007\u0010¾\u0001\u001a\u00020\u0007J\u0007\u0010Õ\u0001\u001a\u00020jJ\u0007\u0010Ö\u0001\u001a\u00020jJ\u0007\u0010×\u0001\u001a\u00020\u0016J\u0007\u0010Ø\u0001\u001a\u00020\u0016J\u001d\u0010Ü\u0001\u001a\u00020\u00162\t\b\u0002\u0010Ý\u0001\u001a\u00020\u00102\t\b\u0002\u0010Þ\u0001\u001a\u00020\u0007J\u001b\u0010ß\u0001\u001a\u00020\u00162\u0007\u0010Ý\u0001\u001a\u00020\u00102\u0007\u0010Þ\u0001\u001a\u00020\u0007H\u0002J\u001d\u0010à\u0001\u001a\u00020\u00162\t\b\u0002\u0010Ý\u0001\u001a\u00020\u00102\t\b\u0002\u0010Þ\u0001\u001a\u00020\u0007J\u0010\u0010á\u0001\u001a\u00020\u00162\u0007\u0010â\u0001\u001a\u00020\u0007J\t\u0010ã\u0001\u001a\u00020\u0010H\u0002J\t\u0010ä\u0001\u001a\u00020\u0010H\u0002J\t\u0010å\u0001\u001a\u00020\u0010H\u0002J\u0010\u0010æ\u0001\u001a\u00020\u00162\u0007\u0010ç\u0001\u001a\u00020\u0010J\u0013\u0010è\u0001\u001a\u00020\u00102\b\u0010é\u0001\u001a\u00030ê\u0001H\u0016J\u0013\u0010ë\u0001\u001a\u00020\u00102\b\u0010é\u0001\u001a\u00030ê\u0001H\u0016J\u001c\u0010ì\u0001\u001a\u00020\u00162\u0007\u0010í\u0001\u001a\u00020\u00072\n\u0010î\u0001\u001a\u0005\u0018\u00010ï\u0001J\u0007\u0010ð\u0001\u001a\u00020\u0016J\u0007\u0010ñ\u0001\u001a\u00020\u0016J\u0007\u0010ò\u0001\u001a\u00020\u0016J\u0007\u0010ó\u0001\u001a\u00020\u0016J\u000e\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020\u0007J+\u0010ô\u0001\u001a\u00020\u00162\"\u0010õ\u0001\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u00160\u0019J+\u0010ö\u0001\u001a\u00020\u00162\"\u0010õ\u0001\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u00160\u0019J,\u0010\u001e\u001a\u00020\u00162$\u0010÷\u0001\u001a\u001f\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0019J\u0012\u0010ø\u0001\u001a\u00020\u00162\t\u0010÷\u0001\u001a\u0004\u0018\u00010%J\u0007\u0010ù\u0001\u001a\u00020\u0010J\u0007\u0010ú\u0001\u001a\u00020\u0010J\u0007\u0010û\u0001\u001a\u00020\u0016J\u001c\u0010ü\u0001\u001a\u00020\u00162\u000b\b\u0002\u0010ý\u0001\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0003\u0010þ\u0001J\t\u0010ÿ\u0001\u001a\u00020\u0016H\u0002J\u0012\u0010\u0080\u0002\u001a\u00020\u00162\u0007\u0010\u0081\u0002\u001a\u00020EH\u0002J$\u0010\u0082\u0002\u001a\u00020j2\u0007\u0010\u0083\u0002\u001a\u00020j2\u0007\u0010\u0084\u0002\u001a\u00020j2\u0007\u0010\u0085\u0002\u001a\u00020\u0007H\u0002J\u0014\u0010\u0086\u0002\u001a\u00020E2\t\u0010Ð\u0001\u001a\u0004\u0018\u00010EH\u0002J\u0014\u0010\u0087\u0002\u001a\u00020E2\t\u0010½\u0001\u001a\u0004\u0018\u00010EH\u0002J\u0007\u0010\u0088\u0002\u001a\u00020\u0016J\u0007\u0010\u0089\u0002\u001a\u00020\u0016J\u001b\u0010\u008a\u0002\u001a\u00020\u00162\u0007\u0010¿\u0001\u001a\u00020\u00072\u0007\u0010¾\u0001\u001a\u00020\u0007H\u0014J\t\u0010\u008b\u0002\u001a\u00020\u0016H\u0014J\u0016\u0010\u008c\u0002\u001a\u0005\u0018\u00010\u008d\u00022\b\u0010\u008e\u0002\u001a\u00030\u008f\u0002H\u0002J\u0017\u0010\u0090\u0002\u001a\u00020\u00072\f\u0010\u0091\u0002\u001a\u00030\u0092\u0002\"\u00020\u0007H\u0002J\u0012\u0010\u0093\u0002\u001a\u00020\u00162\t\b\u0001\u0010\u0094\u0002\u001a\u00020\u0007J\u0007\u0010\u0095\u0002\u001a\u00020\u0016J\t\u0010\u0096\u0002\u001a\u00020\u0016H\u0002J\t\u0010\u0097\u0002\u001a\u00020\u0016H\u0016J\t\u0010\u0098\u0002\u001a\u00020\u0016H\u0002J\u0012\u0010\u0099\u0002\u001a\u00020\u00162\u0007\u0010\u009a\u0002\u001a\u00020wH\u0002J\t\u0010\u009b\u0002\u001a\u00020\u0010H\u0002J\u0012\u0010\u009c\u0002\u001a\u00020\u00162\u0007\u0010\u009a\u0002\u001a\u00020wH\u0002J\t\u0010\u009d\u0002\u001a\u00020\u0016H\u0002J\t\u0010\u009e\u0002\u001a\u00020\u0016H\u0002J\u001b\u0010\u009f\u0002\u001a\u00020\u00162\u0007\u0010¿\u0001\u001a\u00020\u00072\u0007\u0010¾\u0001\u001a\u00020\u0007H\u0002J\t\u0010 \u0002\u001a\u00020\u0016H\u0002R\"\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R+\u0010\u0018\u001a\u001f\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010\u001d\u001a\u001f\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R7\u0010\u001e\u001a\u001f\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0019X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010&\u001a\u00020'X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u0011\u0010,\u001a\u00020-¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u000e\u00100\u001a\u000201X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u000203X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u0004\u0018\u000105X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u00106\u001a\u000207X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u001a\u0010<\u001a\u000207X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u00109\"\u0004\b>\u0010;R\u001a\u0010?\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u0012\"\u0004\bA\u0010\u0014R\u000e\u0010B\u001a\u000207X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u000207X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010D\u001a\u0004\u0018\u00010EX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010F\u001a\u0004\u0018\u00010GX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010H\u001a\n\u0012\u0004\u0012\u00020J\u0018\u00010IX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010K\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010L\u001a\u0004\u0018\u00010EX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010M\u001a\u0004\u0018\u00010EX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR\u0010\u0010R\u001a\u0004\u0018\u00010EX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010S\u001a\u0004\u0018\u00010TX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010U\u001a\u0004\u0018\u00010EX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010V\u001a\u0004\u0018\u00010EX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010W\u001a\u0004\u0018\u00010EX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010X\u001a\u0004\u0018\u00010EX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010Y\u001a\u0004\u0018\u00010EX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010Z\u001a\u0004\u0018\u00010[X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\\\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010]\u001a\u00020^X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010_\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010`\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010a\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bb\u0010\u0012\"\u0004\bc\u0010\u0014R\u001a\u0010d\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\be\u0010\u0012\"\u0004\bf\u0010\u0014R\u000e\u0010g\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010h\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010i\u001a\u00020jX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010k\u001a\u00020jX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010l\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010r\u001a\u00020sX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010t\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010u\u001a\u0016\u0012\u0004\u0012\u00020w\u0018\u00010vj\n\u0012\u0004\u0012\u00020w\u0018\u0001`xX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010y\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010z\u001a\u000207X\u0082D¢\u0006\u0002\n\u0000R\u001a\u0010{\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b|\u0010}\"\u0004\b~\u0010\u007fR\u001d\u0010\u0080\u0001\u001a\u00020\u0007X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0081\u0001\u0010}\"\u0005\b\u0082\u0001\u0010\u007fR\u000f\u0010\u0083\u0001\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0084\u0001\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0085\u0001\u001a\u0011\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0086\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u0087\u0001\u001a\u00030\u0088\u0001X\u0082\u0004¢\u0006\u0005\n\u0003\u0010\u0089\u0001R\u0012\u0010\u008a\u0001\u001a\u0005\u0018\u00010\u008b\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u008c\u0001\u001a\u00020\u0010X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008d\u0001\u0010\u0012\"\u0005\b\u008e\u0001\u0010\u0014R\u001d\u0010\u008f\u0001\u001a\u00020\u0010X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0090\u0001\u0010\u0012\"\u0005\b\u0091\u0001\u0010\u0014R\u001d\u0010\u0092\u0001\u001a\u00020\u0010X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0093\u0001\u0010\u0012\"\u0005\b\u0094\u0001\u0010\u0014R\u000f\u0010\u0095\u0001\u001a\u00020wX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0096\u0001\u001a\u00030\u0097\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0098\u0001\u001a\u0005\u0018\u00010\u0099\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u009a\u0001\u0010\u009b\u0001\"\u0006\b\u009c\u0001\u0010\u009d\u0001R(\u0010\u009e\u0001\u001a\u000b\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u009f\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b \u0001\u0010¡\u0001\"\u0006\b¢\u0001\u0010£\u0001R\u000f\u0010¤\u0001\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010¥\u0001\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010¦\u0001\u001a\u00030§\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010Ù\u0001\u001a\u00020\u0010X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÚ\u0001\u0010\u0012\"\u0005\bÛ\u0001\u0010\u0014¨\u0006¨\u0002"}, d2 = {"Lcom/larus/common_ui/video/VideoPlayView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "Lcom/larus/common_ui/video/DisplayMode;", "displayMode", "getDisplayMode", "()Lcom/larus/common_ui/video/DisplayMode;", "enableCreationPreviewCoverLoadOpt", "", "getEnableCreationPreviewCoverLoadOpt", "()Z", "setEnableCreationPreviewCoverLoadOpt", "(Z)V", "setCenterCrop", "", "setAspectFit", "mOnBufferingUpdate", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "percent", "mOnPlayingProgressUpdate", "onPlayStatusChanged", "status", "getOnPlayStatusChanged", "()Lkotlin/jvm/functions/Function1;", "setOnPlayStatusChanged", "(Lkotlin/jvm/functions/Function1;)V", "mVideoEngineCallback", "Lcom/larus/platform/api/IFlowVideoEngineCallback;", "mVideoView", "Landroid/view/TextureView;", "getMVideoView", "()Landroid/view/TextureView;", "setMVideoView", "(Landroid/view/TextureView;)V", "mCoverView", "Lcom/facebook/drawee/view/SimpleDraweeView;", "getMCoverView", "()Lcom/facebook/drawee/view/SimpleDraweeView;", "mPlayButton", "Landroid/widget/ImageView;", "mLoadingView", "Lcom/larus/common_ui/view/ActivityIndicatorView;", "mSurface", "Landroid/view/Surface;", "mViewAspectRatio", "", "getMViewAspectRatio", "()F", "setMViewAspectRatio", "(F)V", "mVideoAspectRatio", "getMVideoAspectRatio", "setMVideoAspectRatio", "banInnerDismiss", "getBanInnerDismiss", "setBanInnerDismiss", "startX", "startY", "mVideoId", "", "coverBitmap", "Landroid/graphics/Bitmap;", "loadCoverControllerListener", "Lcom/facebook/drawee/controller/BaseControllerListener;", "", "isMuted", "mCoverThumbUrl", "mCoverImageUrl", "getMCoverImageUrl", "()Ljava/lang/String;", "setMCoverImageUrl", "(Ljava/lang/String;)V", "mMessageId", "mVideoModel", "Lcom/larus/platform/api/IFlowVideoModel;", "videoModelString", "videoLocalPath", "videoLocalUri", "videoRemotePath", "videoRemoteCacheKey", "mVideoController", "Lcom/larus/platform/api/IVideoController;", "parentSlideDirection", "currentPlaySourceType", "Lcom/larus/common_ui/video/VideoPlayView$PlaySourceType;", "hasTriedVideoModelFallback", "isPlaybackFallbackPending", "showCoverWhenPause", "getShowCoverWhenPause", "setShowCoverWhenPause", "forceRefreshSurface", "getForceRefreshSurface", "setForceRefreshSurface", "isSurfaceDestroyed", "mShouldBePlaying", "playRequestId", "", "lastLoggedDropRequestId", "hasPreparedSource", "logPlayback", "event", "debugOnly", "canStart", "requestId", "mMainHandler", "Landroid/os/Handler;", "mExecutingActions", "mPendingActions", "Ljava/util/ArrayList;", "Ljava/lang/Runnable;", "Lkotlin/collections/ArrayList;", "touchSlop", "dismissOffset", "videoWidth", "getVideoWidth", "()I", "setVideoWidth", "(I)V", "videoHeight", "getVideoHeight", "setVideoHeight", "suppressRelayoutDuringTransition", "hasDeferredRelayout", "deferredVideoSize", "Lkotlin/Pair;", "mSurfaceTextureListener", "com/larus/common_ui/video/VideoPlayView$mSurfaceTextureListener$1", "Lcom/larus/common_ui/video/VideoPlayView$mSurfaceTextureListener$1;", "mProgressUpdateTask", "Lcom/larus/common_ui/video/VideoPlayView$ProgressUpdateTask;", "ignoreClick", "getIgnoreClick", "setIgnoreClick", "forceUpdateProgress", "getForceUpdateProgress", "setForceUpdateProgress", "diablePlayButton", "getDiablePlayButton", "setDiablePlayButton", "showLoadingRunable", "mOnPreDrawListener", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "afterClickCallBack", "Lcom/larus/common_ui/video/VideoPlayView$AfterClickCallBack;", "getAfterClickCallBack", "()Lcom/larus/common_ui/video/VideoPlayView$AfterClickCallBack;", "setAfterClickCallBack", "(Lcom/larus/common_ui/video/VideoPlayView$AfterClickCallBack;)V", "dismissCallback", "Lkotlin/Function0;", "getDismissCallback", "()Lkotlin/jvm/functions/Function0;", "setDismissCallback", "(Lkotlin/jvm/functions/Function0;)V", "pausedByMediaOccupy", "skipAbandonFocusForMediaPause", "mediaApplicant", "Lcom/larus/media/model/MediaRequestApplicant;", "onSizeChanged", "w", "h", "oldw", "oldh", "setRelayoutSuppressedDuringTransition", "suppress", "flushDeferredRelayout", "onAttachedToWindow", "onDetachedFromWindow", "clearBackground", "bindVideoWithViewModel", "videoController", "localPath", "remotePath", "remoteCacheKey", "localUri", "bindVideoController", "isVideoContainsAudio", "initCover", "thumbUrl", "url", "height", "width", "bitmap", "controllerListener", "messageId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Landroid/graphics/Bitmap;Lcom/facebook/drawee/controller/BaseControllerListener;Ljava/lang/String;)V", "onLoadCoverImageBefore", "clearCover", "start", "videoIsMuted", "setIsMuted", "setVolumeFactor", "volume", "realStart", "playByLocalPath", "path", "playByRemotePath", "playByVideoModel", "videoModel", "resetSurfaceAndPlay", "retryStart", "getPlaySourceTypeForReport", "setVideoAspectRatio", "getCurrentPlaybackTime", "getDuration", "stop", BuildConfig.BUILD_TYPE, "mResumeOrPauseByUser", "getMResumeOrPauseByUser", "setMResumeOrPauseByUser", "resume", "byUser", "scene", "doResume", "pause", "setParentSlideDirection", "direction", "getParentSlideHorizontal", "getParentSlideVertical", "getParentSlideBoth", "changePlayButtonVisible", "visible", "onInterceptTouchEvent", "ev", "Landroid/view/MotionEvent;", "onTouchEvent", "seekTo", "msec", "listener", "Lcom/larus/platform/api/IFlowSeekCompletionListener;", "showLoadingWithDelay", "removeLoadingAndPlayView", "showLoading", "hideLoading", "onBufferingUpdate", "block", "onPlayingProgressUpdate", "callback", "setVideoEngineCallback", "isPlaying", "isPaused", "onSingleTap", "updateProgress", "forceProgress", "(Ljava/lang/Integer;)V", "resetProgressUpdateTask", "stopProgressUpdate", "reason", "getProgressUpdateDelay", "current", "max", "progress", "buildVideoModelLogInfo", "buildUrlLogInfo", "showCoverView", "resetViewVisible", "fitCoverImage", "setupCoverViewParams", "buildCoverResizeOptions", "Lcom/facebook/imagepipeline/common/ResizeOptions;", "config", "Lcom/larus/platform/model/chat/CreationPreviewPerformanceOptConfig;", "firstValidSize", "sizes", "", "setFallbackCoverResource", "resId", "loadCoverImage", "fitVideoSize", "fitVideoViewSize", "abandonAudioFocus", "execAction", "action", "isSurfaceValid", "enqueueAction", "execPendingActions", "clearPendingActions", "applyVideoSize", "markRelayoutDeferred", "AfterClickCallBack", "Companion", "PlaySourceType", "PlayType", "EngineListener", "ProgressUpdateTask", "GestureDetectorListener", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class VideoPlayView extends FrameLayout {
    public static final /* synthetic */ int y1 = 0;
    public String A;
    public String B;
    public IVideoController C;
    public int D;
    public PlaySourceType E;
    public boolean F;
    public boolean G;
    public boolean H;
    public boolean H0;
    public boolean I;
    public boolean J;
    public long K;
    public long L;
    public boolean L0;
    public boolean M;
    public final Handler N;
    public boolean O;
    public ArrayList<Runnable> P;
    public boolean P0;
    public final int Q;
    public final float R;
    public int S;
    public int T;
    public boolean U;
    public boolean V;
    public final com.larus.common_ui.video.c V0;
    public Pair<Integer, Integer> W;
    public com.larus.common_ui.video.b a;
    public boolean b;
    public final com.larus.common_ui.video.e b1;
    public Function1<? super Integer, Unit> c;
    public Function1<? super Integer, Unit> d;
    public n0 e;
    public TextureView f;
    public final SimpleDraweeView g;
    public a g1;
    public final ImageView h;
    public Function0<Unit> h1;
    public final ActivityIndicatorView i;
    public Surface j;
    public float k;
    public final f k0;
    public boolean k1;
    public float l;
    public boolean m;
    public float n;
    public float o;
    public String p;
    public c p0;
    public boolean p1;
    public Bitmap q;
    public BaseControllerListener<Object> r;
    public boolean s;
    public String t;
    public String u;
    public String v;
    public final com.larus.media.model.a v1;
    public p0 w;
    public String x;
    public boolean x1;
    public String y;
    public String z;

    public static final class Companion {

        @Target({ElementType.PARAMETER, ElementType.TYPE_USE})
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/larus/common_ui/video/VideoPlayView$Companion$PlayStatus;", "", "Companion", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        @kotlin.annotation.Target(allowedTargets = {AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.TYPE})
        @Retention(RetentionPolicy.SOURCE)
        @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
        public @interface PlayStatus {
            public static final a Companion = null;
            public static final int PLAY_COMPLETE = 2;
            public static final int PLAY_FAIL = 1;
            public static final int PLAY_PAUSE = 3;
            public static final int PLAY_SUCCESS = 0;

            public static final class a {
                public static final /* synthetic */ a a = null;

                static {
                    a = new a();
                }

                public a() {
                }
            }

            static {
                Companion = a.a;
            }
        }

        @Target({ElementType.PARAMETER, ElementType.TYPE_USE})
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/larus/common_ui/video/VideoPlayView$Companion$VideoParentOrientation;", "", "Companion", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        @kotlin.annotation.Target(allowedTargets = {AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.TYPE})
        @Retention(RetentionPolicy.SOURCE)
        @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
        public @interface VideoParentOrientation {
            public static final a Companion = null;
            public static final int ORIENTATION_BOTH = 3;
            public static final int ORIENTATION_HORIZONTAL = 2;
            public static final int ORIENTATION_VERTICAL = 1;

            public static final class a {
                public static final /* synthetic */ a a = null;

                static {
                    a = new a();
                }

                public a() {
                }
            }

            static {
                Companion = a.a;
            }
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/common_ui/video/VideoPlayView$PlaySourceType;", "", "<init>", "(Ljava/lang/String;I)V", "LOCAL", "DIRECT_URL", "MODEL", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum PlaySourceType extends Enum<PlaySourceType> {
        public static final PlaySourceType DIRECT_URL = null;
        public static final PlaySourceType LOCAL = null;
        public static final PlaySourceType MODEL = null;
        public static final /* synthetic */ PlaySourceType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<PlaySourceType> getEntries() {
            return b;
        }

        static {
            PlaySourceType r0 = new PlaySourceType("LOCAL", 0);
            LOCAL = r0;
            PlaySourceType r1 = new PlaySourceType("DIRECT_URL", 1);
            DIRECT_URL = r1;
            PlaySourceType r3 = new PlaySourceType("MODEL", 2);
            MODEL = r3;
            PlaySourceType[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
        }

        public static PlaySourceType[] values() {
            return (PlaySourceType[]) a.clone();
        }

        public static PlaySourceType valueOf(String r1) {
            return (PlaySourceType) r27.a.a(PlaySourceType.class, r1);
        }

        public PlaySourceType(String r1, int r2) {
            super(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0083\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/larus/common_ui/video/VideoPlayView$PlayType;", "", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface PlayType {
    }

    public interface a {
        void a(String r1);

        void onPause(String r1);
    }

    public static final class b implements n0 {
        public final WeakReference<VideoPlayView> a;
        public Integer b;

        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[PlaySourceType.values().length];
                r0[PlaySourceType.LOCAL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
            L11:
                r0[PlaySourceType.DIRECT_URL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
            L15:
                r0[PlaySourceType.MODEL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
            L6:
                a = r0;
            }
        }

        public final void onPrepare() {
        }

        public final void onPrepared() {
        }

        public final void onCompletion() {
            FLogger.a.d("VideoPlayView", "onPlaybackStateChanged: onCompletion");
            VideoPlayView r0 = this.a.get();
            if (r0 != null) goto L5;
            return;
        L5:
            r0.v(2);
            r0.P(100);
            n0 r1 = r0.e;
            if (r1 == null) goto L9;
            r1.onCompletion();
            return;
        }

        public final void onRenderStart() {
            VideoPlayView r0 = this.a.get();
            if (r0 != null) goto L5;
            return;
        L5:
            int r1 = VideoPlayView.y1;
            r0.P(null);
            r0.n();
            Function1<Integer, Unit> r2 = r0.getOnPlayStatusChanged();
            if (r2 == null) goto L8;
            r2.invoke(0);
        L8:
            n0 r3 = r0.e;
            if (r3 == null) goto L11;
            r3.onRenderStart();
        L11:
            r0.getMCoverView().setVisibility(8);
            FLogger.a.d("VideoPlayView", "onRenderStart");
        }

        public b(WeakReference<VideoPlayView> r2) {
            Intrinsics.checkNotNullParameter(r2, "viewRef");
            this.a = r2;
        }

        public static boolean e(final VideoPlayView r13) {
            if (r13.G == false) goto L6;
            return true;
        L6:
            if (r13.J == true) goto L8;
            return false;
        L8:
            PlaySourceType r0 = r13.E;
            int[] r3 = a.a;
            int r1 = r3[r0.ordinal()];
            if (r1 == 1) goto L24;
            if (r1 == 2) goto L15;
            if (r1 != 3) goto L14;
        L32:
            final PlaySourceType r12 = null;
        L33:
            if (r12 != null) goto L35;
            return false;
        L35:
            PlaySourceType r2 = PlaySourceType.MODEL;
            if (r12 == r2) goto L38;
        L40:
            final PlaySourceType r11 = r13.E;
            r13.G = true;
            int r4 = r3[r11.ordinal()];
            if (r4 == 1) goto L48;
            if (r4 == 2) goto L47;
            if (r4 != 3) goto L46;
        L49:
            if (r12 != r2) goto L51;
            r13.F = true;
        L51:
            final long r9 = r13.K;
            r13.post(new o(r13, r9, r11, r12));
            return true;
        L46:
            throw new NoWhenBranchMatchedException();
        L47:
            r13.A = null;
            goto L49
        L48:
            r13.y = null;
            r13.z = null;
            goto L49
        L38:
            if (Intrinsics.areEqual(r13.B, "") == false) goto L40;
            return false;
        L14:
            throw new NoWhenBranchMatchedException();
        L15:
            PlaySourceType r5 = PlaySourceType.MODEL;
            if (r13.F == false) goto L18;
        L20:
            boolean r7 = false;
        L21:
            if (r7 == false) goto L32;
        L31:
            r12 = r5;
            goto L33
        L18:
            if (o0.d(r13.x) == false) goto L20;
            r7 = true;
            goto L21
        L24:
            if (o0.d(r13.A) == false) goto L27;
            r5 = PlaySourceType.DIRECT_URL;
            goto L31
        L27:
            if (r13.F == true) goto L32;
            if (o0.d(r13.x) == false) goto L32;
            r5 = PlaySourceType.MODEL;
            goto L31
        }

        public final void c(int r6) {
            VideoPlayView r0 = this.a.get();
            if (r0 != null) goto L5;
            return;
        L5:
            Integer r1 = this.b;
            if (r1 != null) goto L9;
        L10:
            this.b = Integer.valueOf(r6);
            int r3 = VideoPlayView.y1;
            r0.t("engine_state=" + r6, false);
        L11:
            if (r6 != 0) goto L13;
            int r2 = VideoPlayView.y1;
            r0.O("playback stopped");
            r0.c();
        L33:
            n0 r4 = r0.e;
            if (r4 == null) goto L37;
            r4.c(r6);
            return;
        L37:
            return;
        L13:
            if (r6 != 1) goto L15;
            r0.i(false);
            r0.n();
            r0.getMCoverView().setVisibility(8);
            Function1<Integer, Unit> r5 = r0.getOnPlayStatusChanged();
            if (r5 == null) goto L31;
            r5.invoke(0);
        L31:
            r0.P(null);
            boolean r7 = x19.a.a;
            Intrinsics.checkNotNullParameter(r0, "videoView");
            x19.a.b = r0.getCurrentPlaybackTime();
            goto L33
        L15:
            if (r6 == 2) goto L21;
            if (r6 != 3) goto L33;
            int r8 = VideoPlayView.y1;
            r0.O("playback error");
            if (e(r0) == true) goto L33;
            r0.n();
            r0.v(1);
            goto L33
        L21:
            int r9 = VideoPlayView.y1;
            r0.O("playback paused");
            if (r0.getShowCoverWhenPause() == false) goto L24;
            r0.q = r0.getMVideoView().getBitmap();
            r0.s();
        L24:
            r0.v(3);
            if (r0.p1 == false) goto L27;
            r0.p1 = false;
            goto L33
        L27:
            r0.c();
            goto L33
        L9:
            if (r1.intValue() == r6) goto L11;
            goto L10
        }

        public final void d(int r6) {
            FLogger.a.i("VideoPlayView", "onLoadStateChanged: " + r6);
            VideoPlayView r0 = this.a.get();
            if (r0 != null) goto L6;
            return;
        L6:
            if (r6 != 1) goto L8;
            r0.n();
            Function1<Integer, Unit> r1 = r0.getOnPlayStatusChanged();
            if (r1 == null) goto L21;
            r1.invoke(0);
        L21:
            n0 r2 = r0.e;
            if (r2 == null) goto L25;
            r2.d(r6);
            return;
        L25:
            return;
        L8:
            if (r6 != 2) goto L10;
            r0.N.removeCallbacks(r0.V0);
            r0.N.postDelayed(r0.V0, 500);
            if (NetworkUtils.isNetworkAvailable(r0.getContext()) == true) goto L21;
            t19.s r3 = t19.s.a;
            Context r4 = r0.getContext();
            String r5 = r0.getContext().getResources().getString(2131906741);
            r3.getClass();
            t19.s.c(r4, r5);
            goto L21
        L10:
            if (r6 != 3) goto L21;
            if (e(r0) == true) goto L21;
            r0.v(1);
            r0.n();
            goto L21
        }

        public final void onVideoStatusException(int r5) {
            FLogger.a.d("VideoPlayView", "onVideoStatusException: " + r5);
            final VideoPlayView r0 = this.a.get();
            if (r0 != null) goto L6;
            return;
        L6:
            if (e(r0) == false) goto L12;
            n0 r1 = r0.e;
            if (r1 == null) goto L21;
            r1.onVideoStatusException(r5);
            return;
        L21:
            return;
        L12:
            if (r0.E != PlaySourceType.LOCAL) goto L17;
            r0.n();
            r0.v(1);
            n0 r2 = r0.e;
            if (r2 == null) goto L22;
            r2.onVideoStatusException(r5);
            return;
        L22:
            return;
        L17:
            final long r3 = r0.K;
            r0.post(new n(r0, r3));
            n0 r4 = r0.e;
            if (r4 == null) goto L23;
            r4.onVideoStatusException(r5);
            return;
        }

        public final void a(Integer r4, Integer r5) {
            FLogger.a.d("VideoPlayView", "onError: " + r4);
            VideoPlayView r0 = this.a.get();
            if (r0 != null) goto L6;
            return;
        L6:
            if (e(r0) == true) goto L11;
            r0.v(1);
            n0 r1 = r0.e;
            if (r1 == null) goto L10;
            r1.a(r4, r5);
        L10:
            r0.n();
            return;
        L11:
            n0 r2 = r0.e;
            if (r2 == null) goto L16;
            r2.a(r4, r5);
            return;
        }

        public final void b(final Integer r3, final Integer r4) {
            final VideoPlayView r0 = this.a.get();
            if (r0 != null) goto L5;
            return;
        L5:
            if (r3 == null) goto L8;
            if (r4 == null) goto L8;
            r0.post(new p(r0, r3, r4));
        L8:
            n0 r1 = r0.e;
            if (r1 == null) goto L12;
            r1.b(r3, r4);
            return;
        }
    }

    public static final class c implements Runnable {
        public final VideoPlayView a;

        @Override // java.lang.Runnable
        public final void run() {
            VideoPlayView r0 = this.a;     // Catch: Throwable -> L4
            int r1 = VideoPlayView.y1;     // Catch: Throwable -> L4
            r0.P(null);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public c(VideoPlayView r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
            this.a = r2;
        }
    }

    public /* synthetic */ class d {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[PlaySourceType.values().length];
            r0[PlaySourceType.DIRECT_URL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[PlaySourceType.LOCAL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[PlaySourceType.MODEL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public static final class e extends BaseControllerListener<Object> {
        public final /* synthetic */ VideoPlayView a;

        public e(VideoPlayView r1) {
            this.a = r1;
        }

        public final void onFailure(String r4, Throwable r5) {
            super.onFailure(r4, r5);
            FLogger.a.e("VideoPlayView", "[loadCoverImage] fail " + VideoPlayView.f(this.a.getMCoverImageUrl()));
            this.a.getMCoverView().setVisibility(8);
            BaseControllerListener<Object> r0 = this.a.r;
            if (r0 == null) goto L6;
            r0.onFailure(r4, r5);
            return;
        }

        public final void onIntermediateImageSet(String r2, Object r3) {
            super.onIntermediateImageSet(r2, r3);
            BaseControllerListener<Object> r0 = this.a.r;
            if (r0 == null) goto L6;
            r0.onIntermediateImageSet(r2, r3);
            return;
        }

        public final void onSubmit(String r2, Object r3) {
            super.onSubmit(r2, r3);
            BaseControllerListener<Object> r0 = this.a.r;
            if (r0 == null) goto L6;
            r0.onSubmit(r2, r3);
            return;
        }

        public final void onFinalImageSet(String r2, Object r3, Animatable r4) {
            super.onFinalImageSet(r2, r3, r4);
            BaseControllerListener<Object> r0 = this.a.r;
            if (r0 == null) goto L5;
            r0.onFinalImageSet(r2, r3, r4);
        L5:
            FLogger.a.i("VideoPlayView", "[loadCoverImage] success " + VideoPlayView.f(this.a.getMCoverImageUrl()));
        }
    }

    public static final class f implements TextureView.SurfaceTextureListener {
        public final /* synthetic */ VideoPlayView a;

        @Override // android.view.TextureView.SurfaceTextureListener
        public final void onSurfaceTextureSizeChanged(SurfaceTexture r1, int r2, int r3) {
            Intrinsics.checkNotNullParameter(r1, "surface");
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final void onSurfaceTextureUpdated(SurfaceTexture r2) {
            Intrinsics.checkNotNullParameter(r2, "surface");
        }

        public f(VideoPlayView r1) {
            this.a = r1;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final boolean onSurfaceTextureDestroyed(SurfaceTexture r4) {
            Intrinsics.checkNotNullParameter(r4, "surface");
            r4.release();
            Surface r5 = this.a.j;
            if (r5 == null) goto L5;
            r5.release();
        L5:
            VideoPlayView r6 = this.a;
            r6.j = null;
            r6.getClass();
            this.a.t("surface_destroyed", true);
            IVideoController r7 = this.a.C;
            if (r7 == null) goto L8;
            r7.releaseSurface();
        L8:
            this.a.s();
            FLogger.a.d("VideoPlayView", "[" + this.a.hashCode() + "], onSurfaceTextureDestroyed, vid: " + this.a.p);
            return true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final void onSurfaceTextureAvailable(SurfaceTexture r4, int r5, int r6) {
            Intrinsics.checkNotNullParameter(r4, "surface");
            VideoPlayView r7 = this.a;
            int r8 = VideoPlayView.y1;
            Surface r9 = r7.j;
            if (r9 != null) goto L5;
        L7:
            boolean r10 = false;
        L8:
            if (r10 == true) goto L10;
        L11:
            FLogger.a.d("VideoPlayView", "[" + this.a.hashCode() + "], mSurface bind, vid: " + this.a.p);
            this.a.j = new Surface(r4);
        L12:
            this.a.getClass();
            this.a.t("surface_available", true);
            VideoPlayView r11 = this.a;
            IVideoController r12 = r11.C;
            if (r12 != null) goto L15;
        L17:
            VideoPlayView r13 = this.a;
            if (r13.O == true) goto L32;
            ArrayList<Runnable> r14 = r13.P;
            if (r14 == null) goto L29;
            r13.O = true;
            Iterator r15 = new ArrayList(r14).iterator();
        L24:
            if (r15.hasNext() == false) goto L26;
            ((Runnable) r15.next()).run();
            goto L24
        L26:
            ArrayList<Runnable> r16 = r13.P;
            if (r16 == null) goto L29;
            r16.clear();
        L29:
            r13.O = false;
            return;
        L32:
            return;
        L15:
            if (r11.J == false) goto L17;
            r12.setSurface(r11.j);
            goto L17
        L10:
            if (this.a.getForceRefreshSurface() == false) goto L12;
        L5:
            if (r9.isValid() != true) goto L7;
            r10 = true;
            goto L8
        }
    }

    public static final class g implements com.larus.media.v {
        public ValueAnimator a;
        public final /* synthetic */ VideoPlayView b;

        public g(VideoPlayView r1) {
            this.b = r1;
        }

        public final boolean b(lk9.g r2) {
            Intrinsics.checkNotNullParameter(r2, "applicant");
            if (Intrinsics.areEqual(r2.getScene(), "TTS_SAMPLE") == false) goto L6;
            return true;
        L6:
            return false;
        }

        public final void e(lk9.g r1) {
            com.larus.media.v.a.d(r1);
        }

        public final void f(MediaResourceManager.a r2) {
            Intrinsics.checkNotNullParameter(r2, "event");
        }

        public final void a(lk9.g r4, final float r5) {
            Intrinsics.checkNotNullParameter(r4, "applicant");
            final VideoPlayView r0 = this.b;
            r0.N.post(new s(r0, r5, this));
            com.larus.media.v.a.f(r4, r5);
        }

        public final void d(lk9.g r2, lk9.g r3) {
            Intrinsics.checkNotNullParameter(r2, "current");
            Intrinsics.checkNotNullParameter(r3, "applicant");
            com.larus.media.v.a.c(r2, r3);
            final VideoPlayView r4 = this.b;
            r4.N.post(new r(r4, this));
        }

        public final void g(lk9.g r1, float r2) {
            com.larus.media.v.a.g(r1, r2);
        }

        public final void i(lk9.g r5, final lk9.g r6) {
            Intrinsics.checkNotNullParameter(r5, "current");
            Intrinsics.checkNotNullParameter(r6, "applicant");
            com.larus.media.v.a.e(r5, r6);
            final VideoPlayView r7 = this.b;
            final long r0 = r7.K;
            r7.N.post(new q(r7, r0, r6));
        }

        public final MediaOccupyStrategy c(lk9.g r1, lk9.g r2, int r3) {
            return com.larus.media.v.a.a(this, r1, r2, r3);
        }

        public final MediaOccupyStrategy h(lk9.g r1, lk9.g r2, int r3) {
            Intrinsics.checkNotNullParameter(r1, "current");
            Intrinsics.checkNotNullParameter(r2, "applicant");
            return MediaOccupyStrategy.PAUSE;
        }
    }

    public static final class h implements l4 {
        public final /* synthetic */ VideoPlayView a;
        public final /* synthetic */ long b;
        public final /* synthetic */ IVideoController c;
        public final /* synthetic */ String d;

        public final void a(String r6, com.larus.video.impl.sdk.a r7) {
            VideoPlayView r0 = this.a;
            long r1 = this.b;
            int r3 = VideoPlayView.y1;
            if (r0.h(r1) == false) goto L21;
            IVideoController r2 = this.c;
            VideoPlayView r4 = this.a;
            if (r2 != r4.C) goto L25;
            StringBuilder r5 = new StringBuilder("model_ready success=");
            if (r7 == null) goto L10;
            boolean r8 = true;
        L11:
            r5.append(r8);
            r4.t(r5.toString(), false);
            if (Intrinsics.areEqual(r6, this.d) == true) goto L14;
            return;
        L14:
            if (Intrinsics.areEqual(r6, this.a.x) == false) goto L23;
            if (r7 == null) goto L24;
            VideoPlayView r9 = this.a;
            IVideoController r10 = r9.C;
            if (r10 == null) goto L19;
            r10.j(r7, true);
        L19:
            r9.w = r7;
            FLogger.a.i("VideoPlayView", "[resetSurfaceAndPlay]");
            r9.G();
            return;
        L24:
            return;
        L23:
            return;
        L10:
            r8 = false;
            goto L11
        L25:
            return;
        }

        public h(VideoPlayView r1, long r2, IVideoController r4, String r5) {
            this.a = r1;
            this.b = r2;
            this.c = r4;
            this.d = r5;
        }
    }

    static {
    }

    public VideoPlayView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public VideoPlayView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final void G() {
        t("engine_play", false);
        this.M = true;
        IVideoController r0 = this.C;
        if (r0 == null) goto L5;
        r0.setSurface(this.j);
    L5:
        IVideoController r1 = this.C;
        if (r1 == null) goto L8;
        r1.p(new b(new WeakReference(this)));
    L8:
        IVideoController r2 = this.C;
        if (r2 == null) goto L12;
        r2.play();
        return;
    }

    public final void I() {
        t("retry_start", false);
        if (r() == false) goto L5;
        return;
    L5:
        this.K++;
        this.J = true;
        this.N.removeCallbacks(this.V0);
        this.N.postDelayed(this.V0, 1000);
        IVideoController r1 = this.C;
        if (r1 == null) goto L8;
        r1.stop();
    L8:
        p0 r2 = this.w;
        if (r2 == null) goto L13;
        this.E = PlaySourceType.MODEL;
        IVideoController r3 = this.C;
        if (r3 == null) goto L13;
        r3.j(r2, true);
    L13:
        IVideoController r0 = this.C;
        if (r0 == null) goto L17;
        r0.play();
        return;
    }

    public void u() {
    }

    private final boolean getParentSlideBoth() {
        if ((this.D & 3) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    private final boolean getParentSlideHorizontal() {
        if ((this.D & 2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    private final boolean getParentSlideVertical() {
        if ((this.D & 1) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    public final void E() {
        removeView(this.i);
        removeView(this.h);
    }

    public final void F() {
        c r0 = this.p0;
        O("reset");
        Integer r5 = null;
        if (this.c != null) goto L9;
        this.p0 = null;
        FLogger r1 = FLogger.a;
        StringBuilder r6 = new StringBuilder("[progressUpdate] reset skip no listener, view:");
        r6.append(hashCode());
        r6.append(", source:");
        r6.append(this.E);
        r6.append(", oldTask:");
        if (r0 == null) goto L7;
        r5 = Integer.valueOf(r0.hashCode());
    L7:
        r6.append(r5);
        r1.i("VideoPlayView", r6.toString());
        return;
    L9:
        this.p0 = new c(this);
        FLogger r2 = FLogger.a;
        StringBuilder r7 = new StringBuilder("[progressUpdate] reset, view:");
        r7.append(hashCode());
        r7.append(", source:");
        r7.append(this.E);
        r7.append(", oldTask:");
        if (r0 == null) goto L12;
        Integer r3 = Integer.valueOf(r0.hashCode());
    L13:
        r7.append(r3);
        r7.append(", newTask:");
        c r4 = this.p0;
        if (r4 == null) goto L16;
        r5 = Integer.valueOf(r4.hashCode());
    L16:
        r7.append(r5);
        r2.i("VideoPlayView", r7.toString());
        return;
    L12:
        r3 = null;
        goto L13
    }

    public final void K() {
        if (this.a != null) goto L11;
        FLogger.a.i("VideoPlayView", "init displayMode DISPLAY_MODE_ASPECT_FIT");
        com.larus.common_ui.video.b r0 = new com.larus.common_ui.video.b();
        this.a = r0;
        r0.d = this;
        r0.a();
        com.larus.common_ui.video.b r1 = this.a;
        if (r1 == null) goto L7;
        r1.c = 4;
        r1.a();
    L7:
        com.larus.common_ui.video.b r2 = this.a;
        if (r2 == null) goto L12;
        r2.e = this.f;
        r2.a();
        return;
    L12:
        return;
    }

    public void L() {
        if (this.f.getWidth() != 0) goto L5;
    L7:
        int r0 = getWidth();
        float r2 = getWidth() / this.l;
        if (Float.isNaN(r2) == false) goto L10;
        r2 = 0.0f;
    L10:
        FrameLayout.LayoutParams r3 = new FrameLayout.LayoutParams(r0, MathKt.roundToInt(r2));
        r3.gravity = 17;
        this.g.setLayoutParams(r3);
        return;
    L5:
        if (this.f.getHeight() == 0) goto L7;
        FrameLayout.LayoutParams r1 = new FrameLayout.LayoutParams(this.f.getWidth(), this.f.getHeight());
        r1.gravity = 17;
        this.g.setLayoutParams(r1);
    }

    public final void M() {
        final long r0 = this.K + 1;
        this.K = r0;
        this.J = true;
        t("start_request", false);
        if (this.s == false) goto L6;
        long r1 = this.K;
        t("start_source", false);
        this.N.postDelayed(this.V0, 1000);
        j(new m(this, r1));
        return;
    L6:
        Lazy r2 = MediaResourceManager.a;
        MediaResourceManager.m(this.v1, new k(this, r0), new l(this, r0), 0, 8);
    }

    public final void N() {
        this.K++;
        this.J = false;
        this.M = false;
        t("stop", false);
        this.k1 = false;
        this.p1 = false;
        ArrayList<Runnable> r2 = this.P;
        if (r2 == null) goto L5;
        r2.clear();
    L5:
        this.O = false;
        O("stop");
        IVideoController r1 = null;
        this.N.removeCallbacksAndMessages(null);
        this.p0 = null;
        IVideoController r0 = this.C;
        if (r0 == null) goto L8;
        r0.l();
    L8:
        IVideoController r3 = this.C;
        if (r3 != null) goto L11;
    L15:
        c();
        return;
    L11:
        if (r3.isReleased() == true) goto L13;
        r1 = r3;
    L13:
        if (r1 == null) goto L15;
        r1.stop();
        goto L15
    }

    public final void c() {
        if (this.s == false) goto L5;
        return;
    L5:
        t("focus_abandon applicant=" + this.v1.hashCode(), false);
        Lazy r0 = MediaResourceManager.a;
        MediaResourceManager.a(this.v1);
    }

    public final long getCurrentPlaybackTime() {
        IVideoController r0 = this.C;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getCurrentPlaybackTime();
    }

    public final long getDuration() {
        IVideoController r0 = this.C;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.n();
    }

    public final String getPlaySourceTypeForReport() {
        PlaySourceType r0 = this.E;
        int r1 = d.a[r0.ordinal()];
        if (r1 != 1) goto L5;
        return "direct_url";
    L5:
        if (r1 != 2) goto L7;
    L11:
        return DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL;
    L7:
        if (r1 == 3) goto L11;
        throw new NoWhenBranchMatchedException();
    }

    public void m() {
        boolean r1 = true;
        if (this.U == false) goto L6;
        this.V = true;
        return;
    L6:
        com.larus.common_ui.video.b r0 = this.a;
        FrameLayout.LayoutParams r2 = null;
        if (r0 == null) goto L9;
        Integer r3 = Integer.valueOf(r0.c);
    L10:
        float r4 = getHeight();
        float r5 = getWidth();
        float r6 = r5 / RangesKt.coerceAtLeast(r4, 1.0f);
        if (r3 == null) goto L26;
        if (r3.intValue() != 4) goto L26;
        l(-1, -1);
        ViewGroup.LayoutParams r7 = this.f.getLayoutParams();
        if ((r7 instanceof FrameLayout.LayoutParams) == false) goto L18;
        r2 = (FrameLayout.LayoutParams) r7;
    L18:
        if (r2 == null) goto L20;
        r2.gravity = 17;
    L20:
        if (r2 == null) goto L22;
        r2.width = -1;
    L22:
        if (r2 == null) goto L24;
        r2.height = -1;
    L24:
        this.f.setLayoutParams(r2);
        return;
    L26:
        if (r3 == null) goto L51;
        if (r3.intValue() != 3) goto L51;
        float r8 = this.l;
        if (r8 == 0.0f) goto L34;
        r1 = false;
    L34:
        if (r1 == false) goto L37;
        return;
    L37:
        if (r8 < r6) goto L39;
        r4 = r5 / r8;
    L40:
        ViewGroup.LayoutParams r9 = this.f.getLayoutParams();
        if ((r9 instanceof FrameLayout.LayoutParams) == false) goto L43;
        r2 = (FrameLayout.LayoutParams) r9;
    L43:
        if (r2 == null) goto L45;
        r2.gravity = 17;
    L45:
        if (r2 == null) goto L47;
        r2.width = (int) r5;
    L47:
        if (r2 == null) goto L49;
        r2.height = (int) r4;
    L49:
        this.f.setLayoutParams(r2);
        return;
    L39:
        r5 = r4 * r8;
    L51:
        if (this.k != 0.0f) goto L53;
        boolean r10 = true;
    L54:
        if (r10 == true) goto L86;
        float r11 = this.l;
        if (r11 == 0.0f) goto L59;
        r1 = false;
    L59:
        if (r1 == false) goto L62;
        return;
    L62:
        if (r11 < 1.0f) goto L65;
    L63:
        float r12 = r5 / r11;
        float r13 = r5;
    L72:
        ViewGroup.LayoutParams r14 = this.f.getLayoutParams();
        Intrinsics.checkNotNull(r14, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams r15 = (FrameLayout.LayoutParams) r14;
        if (Float.isNaN(r13) == false) goto L76;
        r13 = r5;
    L76:
        if (Float.isNaN(r12) == false) goto L78;
        r12 = r4;
    L78:
        int r16 = RangesKt.coerceAtMost(MathKt.roundToInt(r13), (int) r5);
        int r17 = RangesKt.coerceAtMost(MathKt.roundToInt(r12), (int) r4);
        l(r16, r17);
        FLogger.a.d("VideoPlayView", "containerRatio:" + r6 + ", videoRatio:" + this.l + "\ncontainerHeight:" + r4 + ",containerWidth:" + r5 + "\ndisplayHeight:" + r17 + ",displayWidth:" + r16);
        if (r15.height == r17) goto L81;
    L82:
        r15.gravity = 17;
        r15.width = r16;
        r15.height = r17;
        this.f.setLayoutParams(r15);
        this.S = r16;
        this.T = r17;
        return;
    L81:
        if (r15.width != r16) goto L82;
        return;
    L65:
        if (r11 >= 1.0f) goto L70;
        if (r11 >= r6) goto L70;
        r13 = r11 * r4;
        r12 = r4;
    L70:
        if (r11 >= 1.0f) goto L63;
        int r18 = (r11 > r6 ? 1 : (r11 == r6 ? 0 : -1));
        goto L63
    L86:
        return;
    L53:
        r10 = false;
        goto L54
    L9:
        r3 = null;
        goto L10
    }

    public final void n() {
        this.N.removeCallbacks(this.V0);
        this.i.setVisibility(8);
    }

    public final boolean q() {
        IVideoController r0 = this.C;
        if (r0 == null) goto L5;
        IVideoController.PlayType r1 = r0.d();
    L7:
        if (r1 != IVideoController.PlayType.PAUSE) goto L9;
        return true;
    L9:
        return false;
    L5:
        r1 = null;
        goto L7
    }

    public final boolean r() {
        IVideoController r0 = this.C;
        if (r0 == null) goto L5;
        IVideoController.PlayType r1 = r0.d();
    L7:
        if (r1 != IVideoController.PlayType.PLAY) goto L9;
        return true;
    L9:
        return false;
    L5:
        r1 = null;
        goto L7
    }

    /* JADX WARN: Type inference failed for: r9v0, types: [com.larus.common_ui.video.j] */
    public final void s() {
        if (this.u == null) goto L15;
        L();
        GenericDraweeHierarchy r0 = GenericDraweeHierarchyBuilder.newInstance(getResources()).build();
        this.g.setHierarchy(r0);
        Bitmap r1 = this.q;
        if (r1 == null) goto L7;
        this.g.setImageBitmap(r1);
    L14:
        this.g.setVisibility(0);
        return;
    L7:
        ImageDecodeOptions r2 = ImageDecodeOptions.newBuilder().setBitmapConfig(Bitmap.Config.RGB_565).build();
        String r3 = this.t;
        if (r3 == null) goto L12;
        Uri r4 = b0.a(r3, "chat.video_cover.thumb", false, false, 6);
        if (r4 == null) goto L12;
        ImageRequestBuilder r5 = ImageRequestBuilder.newBuilderWithSource(r4);
        r5.setResizeOptions(new ResizeOptions(i5.B(), i5.B()));
        final ImageRequest r6 = r5.setImageDecodeOptions(r2).build();
    L13:
        CommonUIMessageImageLoader.a.a(this.v, CommonUIMessageImageType.VIDEO, this.g, this.u, "chat.video_cover", null, new j(r6, this));
    L12:
        r6 = null;
        goto L13
    L15:
        this.g.setVisibility(8);
    }

    public final void x() {
        FLogger.a.d("VideoPlayView", "[onSingleTap]");
        if (this.H0 == false) goto L6;
        return;
    L6:
        if (this.J == false) goto L8;
    L16:
        z(this, 2, 1);
        a r0 = this.g1;
        if (r0 == null) goto L23;
        r0.onPause(this.p);
        return;
    L23:
        return;
    L8:
        if (r() == true) goto L16;
        if (q() == false) goto L15;
        H(this, 2, 1);
        a r1 = this.g1;
        if (r1 == null) goto L20;
        r1.a(this.p);
        return;
    L20:
        return;
    L15:
        M();
    }

    public final void D() {
        N();
        t(BuildConfig.BUILD_TYPE, false);
        IVideoController r0 = this.C;
        if (r0 == null) goto L5;
        r0.l();
    L5:
        IVideoController r1 = this.C;
        if (r1 == null) goto L9;
        r1.release();
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnPreDrawListener(this.b1);
        t("attach", true);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnPreDrawListener(this.b1);
        t("detach", true);
        com.larus.common_ui.video.b r0 = this.a;
        if (r0 == null) goto L7;
        View r1 = r0.e;
        if (r1 == null) goto L7;
        r1.removeCallbacks(r0.f);
    L7:
        N();
    }

    public final a getAfterClickCallBack() {
        return this.g1;
    }

    public final boolean getBanInnerDismiss() {
        return this.m;
    }

    public final boolean getDiablePlayButton() {
        return this.P0;
    }

    public final Function0<Unit> getDismissCallback() {
        return this.h1;
    }

    public final com.larus.common_ui.video.b getDisplayMode() {
        return this.a;
    }

    public final boolean getEnableCreationPreviewCoverLoadOpt() {
        return this.b;
    }

    public final boolean getForceRefreshSurface() {
        return this.I;
    }

    public final boolean getForceUpdateProgress() {
        return this.L0;
    }

    public final boolean getIgnoreClick() {
        return this.H0;
    }

    public final String getMCoverImageUrl() {
        return this.u;
    }

    public final SimpleDraweeView getMCoverView() {
        return this.g;
    }

    public final boolean getMResumeOrPauseByUser() {
        return this.x1;
    }

    public final float getMVideoAspectRatio() {
        return this.l;
    }

    public final TextureView getMVideoView() {
        return this.f;
    }

    public final float getMViewAspectRatio() {
        return this.k;
    }

    public final Function1<Integer, Unit> getOnPlayStatusChanged() {
        return this.d;
    }

    public final boolean getShowCoverWhenPause() {
        return this.H;
    }

    public final int getVideoHeight() {
        return this.T;
    }

    public final int getVideoWidth() {
        return this.S;
    }

    public static String f(String r2) {
        if (r2 != null) goto L4;
    L7:
        boolean r0 = true;
    L8:
        if (r0 == false) goto L12;
        return "null";
    L12:
        return "hash:" + r2.hashCode() + ", length:" + r2.length();
    L4:
        if (r2.length() == 0) goto L7;
        r0 = false;
        goto L8
    }

    public static String g(String r3) {
        if (r3 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L22;
        return "null";
    L22:
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L14
        JSONObject r4 = new JSONObject(r3);     // Catch: Throwable -> L14
        Object r0 = Result.constructor-impl("videoId:" + r4.optString("video_id") + ", duration:" + r4.optDouble("video_duration") + ", length:" + r3.length());     // Catch: Throwable -> L14
    L17:
        if (Result.exceptionOrNull-impl(r0) == null) goto L21;
        r0 = "parseFail,length:" + r3.length();
    L21:
        return (String) r0;
    L14:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r0 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L17
    L5:
        if (r3.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    public static int k(int... r5) {
        int r0 = r5.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L11;
        int r3 = r5[r2];
        boolean r4 = true;
        if (r3 > 1) goto L8;
        r4 = false;
    L8:
        if (r4 == true) goto L9;
        r2 = r2 + 1;
        goto L3
    L9:
        Integer r6 = Integer.valueOf(r3);
    L12:
        if (r6 != null) goto L14;
        return 0;
    L14:
        return r6.intValue();
    L11:
        r6 = null;
        goto L12
    }

    private final void setVolumeFactor(float r2) {
        if (this.s == false) goto L5;
        return;
    L5:
        IVideoController r0 = this.C;
        if (r0 == null) goto L9;
        r0.c(r2);
        return;
    }

    public final void A(String r4) {
        FLogger.a.i("VideoPlayView", "[playByLocalPath] path:".concat(r4));
        this.E = PlaySourceType.LOCAL;
        F();
        IVideoController r0 = this.C;
        if (r0 == null) goto L5;
        r0.setLocalURL(r4);
    L5:
        G();
    }

    public final void B(String r5) {
        FLogger.a.i("VideoPlayView", "[playByRemotePath] path:" + f(r5));
        this.E = PlaySourceType.DIRECT_URL;
        F();
        IVideoController r0 = this.C;
        if (r0 == null) goto L5;
        r0.r(r5);
    L5:
        IVideoController r1 = this.C;
        if (r1 == null) goto L11;
        String r2 = this.B;
        if (r2 != null) goto L10;
        int r3 = d7.a;
        Intrinsics.checkNotNullParameter(r5, "target");
        r2 = StringsKt.padStart(new BigInteger(1, MessageDigest.getInstance("SHA-256").digest(r5.getBytes(Charsets.UTF_8))).toString(16), 64, '0');
    L10:
        r1.setDirectUrlUseDataLoader(r5, r2);
    L11:
        G();
    }

    public final void C(String r9) {
        FLogger.a.i("VideoPlayView", "[playByVideoModel] videoModel:" + g(r9));
        if (r9.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        this.E = PlaySourceType.MODEL;
        F();
        long r3 = this.K;
        IVideoController r1 = this.C;
        if (r1 == null) goto L12;
        r1.f(r9, new h(this, r3, r1, r9));
        return;
    L12:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void J(int r4) {
        IVideoController r0 = this.C;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.d() == IVideoController.PlayType.PLAY) goto L7;
        r0.play();
    L7:
        r0.A(r4, null);
    }

    public final void O(String r5) {
        c r0 = this.p0;
        if (r0 == null) goto L12;
        removeCallbacks(r0);
        if (Intrinsics.areEqual(r5, "reset") == true) goto L13;
        FLogger r1 = FLogger.a;
        StringBuilder r2 = new StringBuilder("[progressUpdate] stop, reason:");
        r2.append(r5);
        r2.append(", view:");
        r2.append(hashCode());
        r2.append(", task:");
        r2.append(r0.hashCode());
        r2.append(", playStatus:");
        IVideoController r6 = this.C;
        if (r6 == null) goto L9;
        IVideoController.PlayType r7 = r6.d();
    L10:
        r2.append(r7);
        r2.append(", source:");
        r2.append(this.E);
        r1.i("VideoPlayView", r2.toString());
        return;
    L9:
        r7 = null;
        goto L10
    L13:
        return;
    }

    public final void P(Integer r13) {
        IVideoController.PlayType r1 = null;
        boolean r2 = true;
        int r3 = 0;
        if (this.c != null) goto L13;
        FLogger r0 = FLogger.a;
        StringBuilder r4 = new StringBuilder("[progressUpdate] skip no listener, view:");
        r4.append(hashCode());
        r4.append(", forceArg:");
        if (r13 != null) goto L8;
        r2 = false;
    L8:
        r4.append(r2);
        r4.append(", playStatus:");
        IVideoController r14 = this.C;
        if (r14 == null) goto L11;
        r1 = r14.d();
    L11:
        r4.append(r1);
        r0.d("VideoPlayView", r4.toString());
        O("no listener");
        return;
    L13:
        c r5 = this.p0;
        if (r5 != null) goto L18;
        F();
        r5 = this.p0;
        if (r5 != null) goto L18;
        return;
    L18:
        if (r13 == null) goto L20;
    L23:
        long r6 = getCurrentPlaybackTime();
        long r7 = getDuration();
        if (this.L0 == true) goto L28;
        r13 = null;
    L28:
        if (r7 == 0) goto L33;
        if (r13 == null) goto L32;
        r3 = r13.intValue();
        goto L33
    L32:
        r3 = (int) ((((long) 100) * r6) / r7);
    L33:
        Function1<? super Integer, Unit> r15 = this.c;
        if (r15 == null) goto L37;
        r15.invoke(Integer.valueOf(r3));
    L37:
        if (r() == false) goto L45;
        if (r7 > 0) goto L40;
        long r8 = 500;
    L43:
        removeCallbacks(r5);
        postDelayed(r5, r8);
        return;
    L40:
        if (r3 < 100) goto L42;
        r8 = 30;
        goto L43
    L42:
        r8 = RangesKt.coerceIn((((((long) (r3 + 1)) * r7) + 99) / 100) - r6, 30, 500);
        goto L43
    L45:
        return;
    L20:
        if (r() == true) goto L23;
        O("not playing");
    }

    public final boolean h(long r8) {
        if (r8 == this.K) goto L5;
    L14:
        boolean r1 = false;
    L15:
        if (r1 == true) goto L19;
        long r3 = this.L;
        long r5 = this.K;
        if (r3 == r5) goto L19;
        this.L = r5;
        t("drop_start callbackRequest=" + r8, false);
    L19:
        return r1;
    L5:
        if (this.J == false) goto L14;
        IVideoController r0 = this.C;
        r1 = true;
        if (r0 != null) goto L9;
    L11:
        boolean r2 = false;
    L12:
        if (r2 == false) goto L14;
    L9:
        if (r0.isReleased() == true) goto L11;
        r2 = true;
        goto L12
    }

    public final void i(boolean r2) {
        ImageView r0 = this.h;
        if (r2 == true) goto L5;
    L7:
        int r3 = 8;
    L8:
        r0.setVisibility(r3);
        return;
    L5:
        if (this.P0 == true) goto L7;
        r3 = 0;
        goto L8
    }

    public final void j(Runnable r4) {
        Surface r0 = this.j;
        if (r0 == null) goto L7;
        boolean r1 = true;
        if (r0.isValid() != true) goto L7;
    L8:
        if (r1 == false) goto L11;
        r4.run();
        return;
    L11:
        if (this.P != null) goto L13;
        this.P = new ArrayList();
    L13:
        ArrayList<Runnable> r2 = this.P;
        if (r2 == null) goto L16;
        r2.add(r4);
    L16:
        FLogger r5 = FLogger.a;
        r5.d("VideoPlayView", "[" + hashCode() + "], enqueueAction, vid: " + this.p);
        if (this.f.isAvailable() == false) goto L23;
        r5.d("VideoPlayView", "[" + hashCode() + "], mVideoView isAvailable, vid: " + this.p);
        SurfaceTexture r6 = this.f.getSurfaceTexture();
        if (r6 == null) goto L24;
        this.k0.onSurfaceTextureAvailable(r6, this.f.getWidth(), this.f.getHeight());
        return;
    L24:
        return;
    L23:
        return;
    L7:
        r1 = false;
        goto L8
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r8) {
        Intrinsics.checkNotNullParameter(r8, "ev");
        if (this.m == true) goto L5;
        int r0 = r8.getActionMasked();
        if (r0 != 0) goto L9;
        this.n = r8.getX();
        this.o = r8.getY();
        getParent().requestDisallowInterceptTouchEvent(true);
    L40:
        return super.onInterceptTouchEvent(r8);
    L9:
        if (r0 != 1) goto L11;
    L37:
        getParent().requestDisallowInterceptTouchEvent(false);
        goto L40
    L11:
        if (r0 != 2) goto L13;
        float r1 = r8.getX() - this.n;
        float r3 = r8.getY() - this.o;
        if (Math.abs(r3) > this.Q) goto L18;
    L22:
        boolean r4 = false;
    L24:
        if (Math.abs(r1) > this.Q) goto L26;
    L30:
        boolean r2 = false;
    L31:
        if (r4 == true) goto L35;
        if (r2 == true) goto L35;
        getParent().requestDisallowInterceptTouchEvent(false);
    L35:
        getParent().requestDisallowInterceptTouchEvent(true);
        return true;
    L26:
        if (Math.abs(r1) <= Math.abs(r3)) goto L30;
        if (this.D != 1) goto L30;
        r2 = true;
        goto L31
    L18:
        if (Math.abs(r3) <= Math.abs(r1)) goto L22;
        if (this.D != 0) goto L22;
        r4 = true;
        goto L24
    L13:
        if (r0 == 3) goto L37;
    L5:
        return super.onInterceptTouchEvent(r8);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r8) {
        Intrinsics.checkNotNullParameter(r8, "ev");
        if (this.m == false) goto L7;
        return super.onTouchEvent(r8);
    L7:
        if (r8.getActionMasked() != 2) goto L47;
        float r0 = r8.getX() - this.n;
        float r1 = r8.getY() - this.o;
        getParentSlideBoth();
        boolean r4 = false;
        if (Math.abs(r1) > this.Q) goto L11;
    L15:
        boolean r2 = false;
    L17:
        if (Math.abs(r0) > this.Q) goto L19;
    L23:
        boolean r3 = false;
    L24:
        if (r2 == true) goto L28;
        if (r3 == true) goto L28;
        getParent().requestDisallowInterceptTouchEvent(false);
    L28:
        getParent().requestDisallowInterceptTouchEvent(true);
        float r9 = this.R;
        if (r1 > r9) goto L31;
    L33:
        boolean r5 = false;
    L35:
        if (r0 > r9) goto L37;
    L39:
        if (r5 == true) goto L41;
        if (r4 == true) goto L41;
    L45:
        return true;
    L41:
        Function0<Unit> r10 = this.h1;
        if (r10 == null) goto L44;
        r10.invoke();
    L44:
        this.H0 = true;
        goto L45
    L37:
        if (this.D != 1) goto L39;
        r4 = true;
        goto L39
    L31:
        if (this.D != 0) goto L33;
        r5 = true;
        goto L35
    L19:
        if (Math.abs(r0) <= Math.abs(r1)) goto L23;
        if (this.D != 1) goto L23;
        r3 = true;
        goto L24
    L11:
        if (Math.abs(r1) <= Math.abs(r0)) goto L15;
        if (this.D != 0) goto L15;
        r2 = true;
    L47:
        return super.onTouchEvent(r8);
    }

    public final void setAfterClickCallBack(a r1) {
        this.g1 = r1;
    }

    public final void setBanInnerDismiss(boolean r1) {
        this.m = r1;
    }

    public final void setDiablePlayButton(boolean r1) {
        this.P0 = r1;
    }

    public final void setDismissCallback(Function0<Unit> r1) {
        this.h1 = r1;
    }

    public final void setEnableCreationPreviewCoverLoadOpt(boolean r1) {
        this.b = r1;
    }

    public final void setFallbackCoverResource(int r3) {
        L();
        GenericDraweeHierarchyBuilder r0 = GenericDraweeHierarchyBuilder.newInstance(getResources());
        r0.setActualImageScaleType(ScalingUtils.ScaleType.FIT_CENTER);
        GenericDraweeHierarchy r1 = r0.build();
        this.g.setHierarchy(r1);
        this.g.setActualImageResource(r3);
        this.g.setVisibility(0);
    }

    public final void setForceRefreshSurface(boolean r1) {
        this.I = r1;
    }

    public final void setForceUpdateProgress(boolean r1) {
        this.L0 = r1;
    }

    public final void setIgnoreClick(boolean r1) {
        this.H0 = r1;
    }

    public final void setIsMuted(boolean r2) {
        this.s = r2;
        IVideoController r0 = this.C;
        if (r0 == null) goto L6;
        r0.C(r2);
        return;
    }

    public final void setMCoverImageUrl(String r1) {
        this.u = r1;
    }

    public final void setMResumeOrPauseByUser(boolean r1) {
        this.x1 = r1;
    }

    public final void setMVideoAspectRatio(float r1) {
        this.l = r1;
    }

    public final void setMVideoView(TextureView r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.f = r2;
    }

    public final void setMViewAspectRatio(float r1) {
        this.k = r1;
    }

    public final void setOnPlayStatusChanged(Function1<? super Integer, Unit> r1) {
        this.d = r1;
    }

    public final void setParentSlideDirection(int r1) {
        this.D = r1;
    }

    public final void setRelayoutSuppressedDuringTransition(boolean r4) {
        if (this.U != r4) goto L5;
        return;
    L5:
        this.U = r4;
        if (r4 == false) goto L8;
        return;
    L8:
        if (this.V == false) goto L10;
    L12:
        Pair<Integer, Integer> r5 = this.W;
        this.V = false;
        this.W = null;
        if (r5 == null) goto L21;
        int r0 = ((Number) r5.component1()).intValue();
        int r6 = ((Number) r5.component2()).intValue();
        if (r0 == 0) goto L18;
        if (r6 == 0) goto L18;
        this.l = r0 / r6;
    L18:
        m();
        L();
        com.larus.common_ui.video.b r1 = this.a;
        if (r1 == null) goto L26;
        r1.a = r0;
        r1.b = r6;
        r1.a();
        return;
    L26:
        return;
    L21:
        m();
        com.larus.common_ui.video.b r7 = this.a;
        if (r7 == null) goto L28;
        r7.a();
        return;
    L28:
        return;
    L10:
        if (this.W != null) goto L12;
    }

    public final void setShowCoverWhenPause(boolean r1) {
        this.H = r1;
    }

    public final void setVideoEngineCallback(n0 r1) {
        this.e = r1;
    }

    public final void setVideoHeight(int r1) {
        this.T = r1;
    }

    public final void setVideoWidth(int r1) {
        this.S = r1;
    }

    public final void v(int r2) {
        Function1<? super Integer, Unit> r0 = this.d;
        if (r0 == null) goto L6;
        r0.invoke(Integer.valueOf(r2));
        return;
    }

    public final void w(Function1<? super Integer, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "block");
        this.c = r2;
        if (this.p0 != null) goto L10;
        if (this.J == false) goto L7;
    L8:
        F();
        goto L10
    L7:
        if (r() == true) goto L8;
    L10:
        if (r() == false) goto L13;
        P(null);
        return;
    }

    public static final /* synthetic */ void d(VideoPlayView r0, float r1) {
        r0.setVolumeFactor(r1);
    }

    public void l(int r5, int r6) {
        boolean r1 = true;
        if (this.k != 0.0f) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        if (this.l == 0.0f) goto L11;
        r1 = false;
    L11:
        if (r1 == false) goto L13;
        return;
    L13:
        if (this.g.getVisibility() != 0) goto L23;
        ImageView.ScaleType r2 = ImageView.ScaleType.FIT_CENTER;
        ViewGroup.LayoutParams r3 = this.g.getLayoutParams();
        r3.width = r5;
        r3.height = r6;
        this.g.setLayoutParams(r3);
        this.g.setScaleType(r2);
        if (this.u == null) goto L18;
        this.g.setVisibility(0);
        return;
    L18:
        this.g.setVisibility(8);
        return;
    L23:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void t(final String r2, boolean r3) {
        Function0 r0 = new com.larus.common_ui.video.g(r2, this);
        if (r3 == false) goto L5;
        FLogger.a.g("VideoPlayView", r0);
        return;
    L5:
        FLogger.a.i("VideoPlayView", r0);
    }

    public final void y(boolean r5, int r6) {
        this.K++;
        this.J = false;
        ArrayList<Runnable> r1 = this.P;
        if (r1 == null) goto L5;
        r1.clear();
    L5:
        this.O = false;
        if (r6 == 1) goto L8;
        this.k1 = false;
    L8:
        t("pause byUser=" + r5 + " scene=" + r6, false);
        IVideoController r0 = this.C;
        IVideoController r2 = null;
        if (r0 == null) goto L11;
        IVideoController.PlayType r3 = r0.d();
    L13:
        if (r3 != IVideoController.PlayType.PLAY) goto L17;
        Function1<? super Integer, Unit> r4 = this.d;
        if (r4 == null) goto L17;
        r4.invoke(3);
    L17:
        O("pause");
        this.x1 = r5;
        IVideoController r7 = this.C;
        if (r7 != null) goto L20;
    L24:
        if (r6 == 1) goto L26;
        c();
    L26:
        i(r5);
        n();
        return;
    L20:
        if (r7.isReleased() == true) goto L22;
        r2 = r7;
    L22:
        if (r2 == null) goto L24;
        r2.b();
        goto L24
    L11:
        r3 = null;
        goto L13
    }

    /* JADX WARN: Type inference failed for: r8v1, types: [com.larus.common_ui.video.c] */
    /* JADX WARN: Type inference failed for: r8v2, types: [com.larus.common_ui.video.e] */
    public VideoPlayView(Context r24, AttributeSet r25, int r26) {
        Intrinsics.checkNotNullParameter(r24, "context");
        super(r24, r25, r26);
        this.f = new TextureView(r24);
        SimpleDraweeView r2 = new SimpleDraweeView(r24);
        this.g = r2;
        ImageView r3 = new ImageView(r24);
        this.h = r3;
        ActivityIndicatorView r4 = new ActivityIndicatorView(r24, null);
        this.i = r4;
        this.D = 2;
        this.E = PlaySourceType.MODEL;
        this.I = true;
        this.L = -1;
        this.N = new Handler(Looper.getMainLooper());
        this.Q = ViewConfiguration.get(r24).getScaledTouchSlop();
        this.R = 150.0f;
        f r7 = new f(this);
        this.k0 = r7;
        this.V0 = new com.larus.common_ui.video.c(this);
        this.b1 = new com.larus.common_ui.video.e(this);
        this.v1 = new com.larus.media.model.a(null, "VIDEO", false, 0, 2, false, MixPriority.DEFAULT.getValue(), false, false, MediaLevel.PLAY_HIGH.getValue(), false, new g(this), 1453);
        setBackgroundColor(ContextCompat.getColor(r24, 2131103292));
        int r5 = j0.a;
        setContentDescription(j0.d(2131898850));
        r2.setAdjustViewBounds(true);
        addView(this.f, -1, -1);
        int r6 = (int) UIUtils.dip2Px(r24, 80.0f);
        int r1 = (int) UIUtils.dip2Px(r24, 32.0f);
        FrameLayout.LayoutParams r9 = new FrameLayout.LayoutParams(r1, r1);
        r9.gravity = 17;
        r4.d = true;
        r4.setColor(getResources().getColor(v19.c.b(2130972081, null, 2131103143)));
        r4.setStrokeWidth(i5.Y());
        r4.setVisibility(8);
        addView(r2, -1, -1);
        addView(r4, r9);
        this.f.setSurfaceTextureListener(r7);
        e1.d(this, new com.larus.common_ui.video.f(this));
        FrameLayout.LayoutParams r8 = new FrameLayout.LayoutParams(r6, r6);
        r8.gravity = 17;
        addView(r3, r8);
        r3.setImageResource(2131243486);
    }

    public static void H(final VideoPlayView r9, int r10, int r11) {
        if ((r11 & 1) == 0) goto L5;
        final boolean r7 = true;
    L7:
        if ((r11 & 2) == 0) goto L9;
        final int r8 = 0;
    L11:
        if (r9.M == true) goto L13;
        r9.M();
        return;
    L13:
        final long r12 = r9.K + 1;
        r9.K = r12;
        r9.J = true;
        r9.t("resume byUser=" + r7 + " scene=" + r8, false);
        if (r7 == true) goto L16;
    L20:
        r9.j(new com.larus.common_ui.video.d(r9, r9.K, r7));
        return;
    L16:
        if (r9.k1 == false) goto L20;
        if (r9.s == true) goto L20;
        Lazy r0 = MediaResourceManager.a;
        MediaResourceManager.m(r9.v1, new com.larus.common_ui.video.h(r9, r12, r7, r8), new i(r9, r12), 0, 8);
        return;
    L9:
        r8 = r10;
        goto L11
    L5:
        r7 = false;
        goto L7
    }

    public static Unit a(VideoPlayView r4, long r5, float r7) {
        if (r4.h(r5) == false) goto L5;
        r4.t("focus_success", false);
        r4.setVolumeFactor(r7);
        long r0 = r4.K;
        r4.t("start_source", false);
        r4.N.postDelayed(r4.V0, 1000);
        r4.j(new m(r4, r0));
        return Unit.INSTANCE;
    L5:
        if (r4.J == true) goto L10;
        r4.c();
    L10:
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void z(VideoPlayView r2, int r3, int r4) {
        if ((r4 & 1) == 0) goto L5;
        boolean r0 = true;
    L7:
        if ((r4 & 2) == 0) goto L9;
        r3 = 0;
    L9:
        r2.y(r0, r3);
        return;
    L5:
        r0 = false;
        goto L7
    }

    public /* synthetic */ VideoPlayView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        if (this.U == false) goto L6;
        this.V = true;
        return;
    L6:
        m();
        com.larus.common_ui.video.b r5 = this.a;
        if (r5 == null) goto L10;
        r5.a();
        return;
    }

    public static Unit b(VideoPlayView r0, long r1, boolean r3, int r4, float r5) {
        if (r0.h(r1) == false) goto L7;
        r0.k1 = false;
        r0.setVolumeFactor(r5);
        r0.j(new com.larus.common_ui.video.d(r0, r0.K, r3));
        return Unit.INSTANCE;
    L7:
        return Unit.INSTANCE;
    }

    public static void e(VideoPlayView r5, IVideoController r6, String r7, String r8, String r9, String r10, String r11, int r12) {
        String r1 = null;
        if ((r12 & 2) == 0) goto L6;
        r7 = null;
    L6:
        if ((r12 & 4) == 0) goto L9;
        r8 = null;
    L9:
        if ((r12 & 8) == 0) goto L12;
        r9 = null;
    L12:
        if ((r12 & 16) == 0) goto L15;
        r10 = null;
    L15:
        if ((r12 & 32) == 0) goto L17;
        r11 = null;
    L17:
        r5.getClass();
        if (r11 == null) goto L42;
        String r13 = StringsKt.trim(r11).toString();
        if (r13 == null) goto L42;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L23
        Object r3 = Result.constructor-impl(UriProtector.parse(r13).getScheme());     // Catch: Throwable -> L23
    L26:
        if (Result.isFailure-impl(r3) == false) goto L28;
        r3 = null;
    L28:
        String r4 = (String) r3;
        if (r4 != null) goto L31;
    L39:
        boolean r14 = false;
    L40:
        if (r14 == false) goto L42;
    L43:
        FLogger.a.i("VideoPlayView", "[bindVideoWithViewModel] localPathExists:" + m5.c(r8) + ", hasLocalUri:" + o0.d(r13) + ", hasRemotePath:" + o0.d(r9) + ", videoModel:" + g(r7));
        if (r6 == null) goto L48;
        if (r6 == r5.C) goto L48;
    L61:
        r5.N();
        r5.w = null;
    L62:
        r5.x = r7;
        if (m5.c(r8) == false) goto L65;
        r1 = r8;
    L65:
        r5.y = r1;
        r5.z = r13;
        r5.A = r9;
        r5.B = r10;
        r5.F = false;
        r5.G = false;
        r5.E = PlaySourceType.MODEL;
        r5.k = 0.0f;
        r5.g.setVisibility(0);
        r5.i(false);
        if (r6 == null) goto L71;
        r5.C = r6;
        r6.setLooping(true);
        return;
    L71:
        return;
    L48:
        if (Intrinsics.areEqual(r5.x, r7) == false) goto L61;
        String r15 = r5.y;
        if (r8 != null) goto L52;
    L54:
        String r16 = null;
    L56:
        if (Intrinsics.areEqual(r15, r16) == false) goto L61;
        if (Intrinsics.areEqual(r5.z, r13) == false) goto L61;
        if (Intrinsics.areEqual(r5.A, r9) == true) goto L62;
    L52:
        if (m5.c(r8) == false) goto L54;
        r16 = r8;
        goto L56
    L31:
        if (StringsKt.equals(r4, "content", true) == false) goto L33;
    L36:
        boolean r17 = true;
    L37:
        if (r17 != true) goto L39;
        r14 = true;
        goto L40
    L33:
        if (StringsKt.equals(r4, "file", true) == true) goto L36;
        r17 = false;
    L23:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
    L42:
        r13 = null;
        goto L43
    }

    public final void o(String r4, String r5, String r6, Integer r7, Integer r8, Bitmap r9, BaseControllerListener<Object> r10, String r11) {
        FLogger.a.i("VideoPlayView", "[initCover] thumbUrl:" + r4 + ", localPath:" + r6 + ", height:" + r7 + ", width:" + r8);
        if (r7 != null) goto L6;
    L8:
        int r0 = 0;
        if (r8 == null) goto L11;
        int r12 = r8.intValue();
    L12:
        float r13 = r12;
        if (r7 == null) goto L15;
        r0 = r7.intValue();
    L15:
        float r14 = r13 / r0;
    L16:
        this.l = r14;
        if (m5.c(r6) == true) goto L25;
        if (r6 != null) goto L20;
        String r15 = "";
    L22:
        if (m5.c(UriProtector.parse(r15).getPath()) == true) goto L25;
        this.t = r4;
    L26:
        this.u = r5;
        this.q = r9;
        this.r = r10;
        this.v = r11;
        u();
        s();
        return;
    L20:
        r15 = r6;
    L25:
        r5 = r6;
        goto L26
    L11:
        r12 = 0;
        goto L12
    L6:
        if (r7.intValue() != 0) goto L8;
        r14 = 0.0f;
        goto L16
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void p(VideoPlayView r3, String r4, String r5, String r6, Integer r7, Integer r8, Bitmap r9, BaseControllerListener r10, String r11, int r12) {
        if ((r12 & 1) == 0) goto L6;
        r4 = null;
    L6:
        if ((r12 & 2) == 0) goto L9;
        r5 = null;
    L9:
        if ((r12 & 4) == 0) goto L12;
        r6 = null;
    L12:
        if ((r12 & 8) == 0) goto L15;
        r7 = 0;
    L15:
        if ((r12 & 16) == 0) goto L18;
        r8 = 0;
    L18:
        if ((r12 & 32) == 0) goto L21;
        r9 = null;
    L21:
        if ((r12 & 64) == 0) goto L24;
        r10 = null;
    L24:
        if ((r12 & 128) == 0) goto L26;
        r11 = null;
    L26:
        r3.o(r4, r5, r6, r7, r8, r9, r10, r11);
    }
}
