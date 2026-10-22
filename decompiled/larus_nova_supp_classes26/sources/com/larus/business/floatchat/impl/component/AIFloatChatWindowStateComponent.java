package com.larus.business.floatchat.impl.component;

import android.animation.ValueAnimator;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.ability.FloatChatWindowEventType;
import com.larus.bmhome.ability.FloatChatWindowState;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.component.share.IChatMessageShareAbility;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.bmhome.view.ChatConstraintLayout;
import com.larus.bmhome.view.ShadowChatConstraintLayout;
import com.larus.business.floatchat.api.AIChatInputConfig;
import com.larus.im.bean.message.Message;
import com.larus.platform.service.p1;
import com.larus.platform.service.z2;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.ui.arch.component.external.api.provider.EmptyComponent;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.larus.ui.arch.vm.ComponentViewModel;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import org.json.JSONException;
import org.json.JSONObject;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000´\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b'\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0016*\u0002x}\u0018\u0000 \u009f\u00022\u00020\u00012\u00020\u00022\u00020\u0003:\u0002\u009f\u0002B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0087\u0001\u001a\u00020_2\u0007\u0010\u0088\u0001\u001a\u00020EH\u0016J\t\u0010\u0089\u0001\u001a\u00020_H\u0016J\t\u0010\u008a\u0001\u001a\u00020;H\u0016J\u0014\u0010\u008b\u0001\u001a\u00020_2\t\u0010\u008c\u0001\u001a\u0004\u0018\u00010XH\u0016J\t\u0010\u008d\u0001\u001a\u00020_H\u0016J\u0012\u0010\u008e\u0001\u001a\u00020_2\u0007\u0010\u008f\u0001\u001a\u00020@H\u0016J\t\u0010\u0090\u0001\u001a\u00020;H\u0016J\t\u0010\u0091\u0001\u001a\u00020;H\u0016J\t\u0010\u0092\u0001\u001a\u00020@H\u0002J\u001b\u0010\u0093\u0001\u001a\u00020_2\u0007\u0010\u0094\u0001\u001a\u00020;2\u0007\u0010\u0095\u0001\u001a\u00020;H\u0016J\n\u0010\u0096\u0001\u001a\u00030\u0097\u0001H\u0016J\t\u0010\u0098\u0001\u001a\u00020;H\u0016J\u0012\u0010\u0099\u0001\u001a\u00020_2\u0007\u0010\u009a\u0001\u001a\u00020@H\u0016J\u0013\u0010\u009b\u0001\u001a\u00020_2\b\u0010\u009c\u0001\u001a\u00030\u009d\u0001H\u0016J\u0014\u0010\u009e\u0001\u001a\u00020_2\t\u0010\u009f\u0001\u001a\u0004\u0018\u00010NH\u0016J\u0014\u0010 \u0001\u001a\u00020_2\t\u0010¡\u0001\u001a\u0004\u0018\u00010PH\u0016J\u0012\u0010¢\u0001\u001a\u00020_2\u0007\u0010£\u0001\u001a\u000207H\u0016J\u0012\u0010¤\u0001\u001a\u00020_2\u0007\u0010£\u0001\u001a\u000207H\u0016J\u0012\u0010¥\u0001\u001a\u00020_2\u0007\u0010£\u0001\u001a\u000209H\u0016J\u0012\u0010¦\u0001\u001a\u00020_2\u0007\u0010£\u0001\u001a\u000209H\u0016J \u0010§\u0001\u001a\u0005\u0018\u00010\u0097\u00012\b\u0010¨\u0001\u001a\u00030\u0097\u00012\b\u0010\u009c\u0001\u001a\u00030\u009d\u0001H\u0002J&\u0010©\u0001\u001a\u00020@2\b\u0010\u009c\u0001\u001a\u00030\u009d\u00012\b\u0010ª\u0001\u001a\u00030\u0097\u00012\u0007\u0010«\u0001\u001a\u00020RH\u0002J\u001c\u0010¬\u0001\u001a\u00020@2\b\u0010ª\u0001\u001a\u00030\u0097\u00012\u0007\u0010\u00ad\u0001\u001a\u00020;H\u0002J\t\u0010®\u0001\u001a\u00020;H\u0002J&\u0010¯\u0001\u001a\u00020@2\b\u0010¨\u0001\u001a\u00030\u0097\u00012\b\u0010ª\u0001\u001a\u00030\u0097\u00012\u0007\u0010°\u0001\u001a\u00020@H\u0002J\t\u0010±\u0001\u001a\u00020@H\u0002J\f\u0010²\u0001\u001a\u0005\u0018\u00010\u0097\u0001H\u0002J\t\u0010³\u0001\u001a\u00020_H\u0002J\t\u0010´\u0001\u001a\u00020_H\u0002J\t\u0010µ\u0001\u001a\u00020_H\u0002J\t\u0010¶\u0001\u001a\u00020_H\u0002J\t\u0010·\u0001\u001a\u00020_H\u0002J\u001b\u0010¸\u0001\u001a\u00020@2\u0007\u0010¹\u0001\u001a\u00020;2\u0007\u0010º\u0001\u001a\u00020TH\u0002J\u0012\u0010»\u0001\u001a\u00020_2\u0007\u0010¼\u0001\u001a\u00020;H\u0002J\t\u0010½\u0001\u001a\u00020_H\u0002J\u001d\u0010¾\u0001\u001a\u00020_2\u0007\u0010º\u0001\u001a\u00020T2\t\b\u0002\u0010¿\u0001\u001a\u00020@H\u0002J\u001b\u0010À\u0001\u001a\u00020_2\u0007\u0010º\u0001\u001a\u00020T2\u0007\u0010¿\u0001\u001a\u00020@H\u0002J\t\u0010Á\u0001\u001a\u00020_H\u0002J\t\u0010Â\u0001\u001a\u00020_H\u0003J\u001c\u0010Ã\u0001\u001a\u00020@2\u0007\u0010Ä\u0001\u001a\u00020L2\b\u0010\u009c\u0001\u001a\u00030Å\u0001H\u0002J.\u0010Æ\u0001\u001a\u00020@2\u0007\u0010\u0088\u0001\u001a\u00020E2\u0007\u0010Ç\u0001\u001a\u00020[2\u0007\u0010È\u0001\u001a\u00020[2\b\u0010É\u0001\u001a\u00030Ê\u0001H\u0002J\u001b\u0010Ë\u0001\u001a\u00020@2\u0007\u0010Ì\u0001\u001a\u00020[2\u0007\u0010Í\u0001\u001a\u00020;H\u0002J\t\u0010Î\u0001\u001a\u00020@H\u0002J\t\u0010Ï\u0001\u001a\u00020@H\u0002J\t\u0010Ð\u0001\u001a\u00020_H\u0002J\t\u0010Ñ\u0001\u001a\u00020_H\u0002J\u0012\u0010Ò\u0001\u001a\u00020_2\u0007\u0010Ó\u0001\u001a\u00020TH\u0002J\t\u0010Ô\u0001\u001a\u00020_H\u0002J\t\u0010Õ\u0001\u001a\u00020_H\u0002J\u0013\u0010Ö\u0001\u001a\u00020R2\b\u0010×\u0001\u001a\u00030Ø\u0001H\u0002J%\u0010Ù\u0001\u001a\u00020_2\b\u0010Ú\u0001\u001a\u00030\u0097\u00012\u0007\u0010\u00ad\u0001\u001a\u00020;2\u0007\u0010Û\u0001\u001a\u00020@H\u0002J\u0012\u0010Ü\u0001\u001a\u00020_2\u0007\u0010Ý\u0001\u001a\u00020@H\u0002J\u0012\u0010Þ\u0001\u001a\u00020_2\u0007\u0010ß\u0001\u001a\u00020;H\u0002J\u0012\u0010à\u0001\u001a\u00020_2\u0007\u0010\u00ad\u0001\u001a\u00020;H\u0002J\u0012\u0010á\u0001\u001a\u00020;2\u0007\u0010\u00ad\u0001\u001a\u00020;H\u0002J\t\u0010â\u0001\u001a\u00020@H\u0002J\u0012\u0010ã\u0001\u001a\u00020_2\u0007\u0010ä\u0001\u001a\u00020;H\u0002J\u0012\u0010å\u0001\u001a\u00020_2\u0007\u0010æ\u0001\u001a\u00020;H\u0002J\t\u0010ç\u0001\u001a\u00020_H\u0002J\u0012\u0010è\u0001\u001a\u00020_2\u0007\u0010ä\u0001\u001a\u00020;H\u0002J\u0012\u0010é\u0001\u001a\u00020_2\u0007\u0010ê\u0001\u001a\u00020;H\u0002J\u0014\u0010ë\u0001\u001a\u00020_2\t\b\u0002\u0010ì\u0001\u001a\u00020@H\u0002J\t\u0010í\u0001\u001a\u00020_H\u0002J\u0012\u0010î\u0001\u001a\u00020_2\u0007\u0010\u00ad\u0001\u001a\u00020;H\u0002J\u0012\u0010ï\u0001\u001a\u00020;2\u0007\u0010ð\u0001\u001a\u00020;H\u0002J\u0015\u0010ñ\u0001\u001a\u00020_2\n\b\u0002\u0010Ú\u0001\u001a\u00030\u0097\u0001H\u0002J\u0012\u0010ò\u0001\u001a\u00020_2\u0007\u0010\u00ad\u0001\u001a\u00020;H\u0002J\u0012\u0010ó\u0001\u001a\u00020_2\u0007\u0010ô\u0001\u001a\u00020;H\u0002J\u0012\u0010õ\u0001\u001a\u00020_2\u0007\u0010\u00ad\u0001\u001a\u00020;H\u0002J\u0012\u0010ö\u0001\u001a\u00020[2\u0007\u0010\u00ad\u0001\u001a\u00020;H\u0002J\t\u0010÷\u0001\u001a\u00020_H\u0002J\t\u0010ø\u0001\u001a\u00020_H\u0002J\t\u0010ù\u0001\u001a\u00020;H\u0002J\t\u0010ú\u0001\u001a\u00020;H\u0002J\u0019\u0010û\u0001\u001a\u0004\u0018\u00010E*\u00030ü\u00012\u0007\u0010ý\u0001\u001a\u00020;H\u0002J\u0012\u0010þ\u0001\u001a\u00020_2\u0007\u0010ä\u0001\u001a\u00020[H\u0002J\u0013\u0010ÿ\u0001\u001a\u00020[2\b\u0010Ú\u0001\u001a\u00030\u0097\u0001H\u0002J\u0012\u0010\u0080\u0002\u001a\u00020;2\u0007\u0010\u0081\u0002\u001a\u00020[H\u0002J\u001d\u0010\u0082\u0002\u001a\u00020_2\u0007\u0010º\u0001\u001a\u00020T2\t\b\u0002\u0010\u0083\u0002\u001a\u00020;H\u0002J\u0012\u0010\u0084\u0002\u001a\u00020_2\u0007\u0010\u0083\u0002\u001a\u00020;H\u0002J\u0012\u0010\u0085\u0002\u001a\u00020_2\u0007\u0010\u00ad\u0001\u001a\u00020;H\u0002J\u0012\u0010\u0086\u0002\u001a\u00020_2\u0007\u0010ß\u0001\u001a\u00020;H\u0002J\u0012\u0010\u0087\u0002\u001a\u00020_2\u0007\u0010\u00ad\u0001\u001a\u00020;H\u0002J*\u0010\u0088\u0002\u001a\u00020;2\b\u0010Ú\u0001\u001a\u00030\u0097\u00012\n\u0010\u0089\u0002\u001a\u0005\u0018\u00010\u008a\u00022\t\b\u0002\u0010\u0083\u0002\u001a\u00020;H\u0002J(\u0010\u008b\u0002\u001a\u00020;2\b\u0010Ú\u0001\u001a\u00030\u0097\u00012\n\u0010\u0089\u0002\u001a\u0005\u0018\u00010\u008a\u00022\u0007\u0010\u00ad\u0001\u001a\u00020;H\u0002J\u001c\u0010\u008c\u0002\u001a\u00020;2\b\u0010Ú\u0001\u001a\u00030\u0097\u00012\u0007\u0010\u00ad\u0001\u001a\u00020;H\u0002J\u001e\u0010\u008d\u0002\u001a\u00020_2\u0007\u0010\u008e\u0002\u001a\u00020R2\n\u0010\u0089\u0002\u001a\u0005\u0018\u00010\u008a\u0002H\u0002J\u0012\u0010\u008f\u0002\u001a\u00020T2\u0007\u0010Ó\u0001\u001a\u00020TH\u0002J \u0010\u0090\u0002\u001a\u00020;2\n\b\u0002\u0010Ú\u0001\u001a\u00030\u0097\u00012\t\b\u0002\u0010\u0083\u0002\u001a\u00020;H\u0002J\u001e\u0010\u0091\u0002\u001a\u00020;2\b\u0010Ú\u0001\u001a\u00030\u0097\u00012\t\b\u0002\u0010\u0092\u0002\u001a\u00020;H\u0002J\u001f\u0010\u0093\u0002\u001a\u00020;2\t\b\u0002\u0010\u0094\u0002\u001a\u00020@2\t\b\u0002\u0010\u0092\u0002\u001a\u00020;H\u0002J\t\u0010\u0095\u0002\u001a\u00020;H\u0002J\t\u0010\u0096\u0002\u001a\u00020;H\u0002J\u001b\u0010\u0097\u0002\u001a\u00020_2\u0007\u0010\u0098\u0002\u001a\u00020E2\u0007\u0010ß\u0001\u001a\u00020;H\u0002J\u0012\u0010\u0099\u0002\u001a\u00020;2\u0007\u0010\u0098\u0002\u001a\u00020EH\u0002J\t\u0010\u009a\u0002\u001a\u00020;H\u0002J \u0010\u009b\u0002\u001a\u00020;2\n\b\u0002\u0010Ú\u0001\u001a\u00030\u0097\u00012\t\b\u0002\u0010\u0083\u0002\u001a\u00020;H\u0002J\u0015\u0010\u009c\u0002\u001a\u00020;2\n\b\u0002\u0010Ú\u0001\u001a\u00030\u0097\u0001H\u0002J\u0010\u0010\u009d\u0002\u001a\u0004\u0018\u00010T*\u00030\u008a\u0002H\u0002J \u0010\u009e\u0002\u001a\u00020T2\n\b\u0002\u0010Ú\u0001\u001a\u00030\u0097\u00012\t\b\u0002\u0010\u0083\u0002\u001a\u00020;H\u0002R\u001d\u0010\u0006\u001a\u0004\u0018\u00010\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001d\u0010\f\u001a\u0004\u0018\u00010\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0011\u001a\u0004\u0018\u00010\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0013\u0010\u0014R\u001d\u0010\u0016\u001a\u0004\u0018\u00010\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u0018\u0010\u0019R\u001d\u0010\u001b\u001a\u0004\u0018\u00010\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u000b\u001a\u0004\b\u001d\u0010\u001eR\u001d\u0010 \u001a\u0004\u0018\u00010!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\u000b\u001a\u0004\b\"\u0010#R\u001d\u0010%\u001a\u0004\u0018\u00010&8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010\u000b\u001a\u0004\b'\u0010(R\u001d\u0010*\u001a\u0004\u0018\u00010+8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010\u000b\u001a\u0004\b,\u0010-R\u001b\u0010/\u001a\u0002008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b1\u00102R\u0014\u00105\u001a\b\u0012\u0004\u0012\u00020706X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00108\u001a\b\u0012\u0004\u0012\u00020906X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020;X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020;X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020;X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020;X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020@X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020;X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020;X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020;X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010D\u001a\u0004\u0018\u00010EX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010F\u001a\u0004\u0018\u00010GX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010H\u001a\u0004\u0018\u00010EX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010I\u001a\u0004\u0018\u00010EX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010J\u001a\u0004\u0018\u00010EX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010K\u001a\u0004\u0018\u00010LX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010M\u001a\u0004\u0018\u00010NX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010O\u001a\u0004\u0018\u00010PX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010Q\u001a\u0004\u0018\u00010RX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010S\u001a\u0004\u0018\u00010TX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010U\u001a\u00020@X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010V\u001a\u00020@X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010W\u001a\u0004\u0018\u00010XX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010Y\u001a\u00020@X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010Z\u001a\u00020[X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\\\u001a\u00020@X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010]\u001a\u0010\u0012\u0004\u0012\u00020;\u0012\u0004\u0012\u00020_\u0018\u00010^X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010`\u001a\u0016\u0012\u0004\u0012\u00020;\u0012\u0004\u0012\u00020T\u0012\u0004\u0012\u00020@\u0018\u00010aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010b\u001a\u00020;X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010c\u001a\u00020;X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010d\u001a\u00020;X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010e\u001a\u0004\u0018\u00010fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010g\u001a\u0004\u0018\u00010hX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010i\u001a\u00020@X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010j\u001a\u00020;X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010k\u001a\u00020;X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010l\u001a\u00020;X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010m\u001a\u0004\u0018\u00010nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010o\u001a\u0004\u0018\u00010nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010p\u001a\u00020;X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010q\u001a\u00020@X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010r\u001a\u00020;X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010s\u001a\u00020;X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010t\u001a\u00020;X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010u\u001a\u00020[X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010v\u001a\u00020@X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010w\u001a\u00020xX\u0082\u0004¢\u0006\u0004\n\u0002\u0010yR\u000e\u0010z\u001a\u00020{X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010|\u001a\u00020}X\u0082\u0004¢\u0006\u0004\n\u0002\u0010~R\u000f\u0010\u007f\u001a\u00030\u0080\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0081\u0001\u001a\u00030\u0080\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\u0082\u0001\u001a\u00020;X\u0096\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0083\u0001\u0010\u0084\u0001\"\u0006\b\u0085\u0001\u0010\u0086\u0001¨\u0006 \u0002"}, d2 = {"Lcom/larus/business/floatchat/impl/component/AIFloatChatWindowStateComponent;", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "Lcom/larus/bmhome/ability/IAIFloatChatFoldCoreAbility;", "Lcom/larus/bmhome/ability/IInputBottomMenuContainerAbility;", "<init>", "()V", "chatListCoreAbility", "Lcom/larus/bmhome/ability/IChatListCoreAbility;", "getChatListCoreAbility", "()Lcom/larus/bmhome/ability/IChatListCoreAbility;", "chatListCoreAbility$delegate", "Lkotlin/Lazy;", "chatInputCoreAbility", "Lcom/larus/bmhome/ability/IChatInputCoreAbility;", "getChatInputCoreAbility", "()Lcom/larus/bmhome/ability/IChatInputCoreAbility;", "chatInputCoreAbility$delegate", "coreInputAbility", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "getCoreInputAbility", "()Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "coreInputAbility$delegate", "aiChatInputConfigAbility", "Lcom/larus/business/floatchat/api/ability/IAIChatInputConfigAbility;", "getAiChatInputConfigAbility", "()Lcom/larus/business/floatchat/api/ability/IAIChatInputConfigAbility;", "aiChatInputConfigAbility$delegate", "aiChatMessageLogicAbility", "Lcom/larus/business/floatchat/api/ability/IAIChatMessageLogicAbility;", "getAiChatMessageLogicAbility", "()Lcom/larus/business/floatchat/api/ability/IAIChatMessageLogicAbility;", "aiChatMessageLogicAbility$delegate", "chatBottomFloatingCoreAbility", "Lcom/larus/bmhome/audio/IChatBottomFloatingApiAbility;", "getChatBottomFloatingCoreAbility", "()Lcom/larus/bmhome/audio/IChatBottomFloatingApiAbility;", "chatBottomFloatingCoreAbility$delegate", "chatTopFloatingButtonAbility", "Lcom/larus/bmhome/ability/IChatTopFloatingButtonAbility;", "getChatTopFloatingButtonAbility", "()Lcom/larus/bmhome/ability/IChatTopFloatingButtonAbility;", "chatTopFloatingButtonAbility$delegate", "chatMessageShareAbility", "Lcom/larus/bmhome/chat/component/share/IChatMessageShareAbility;", "getChatMessageShareAbility", "()Lcom/larus/bmhome/chat/component/share/IChatMessageShareAbility;", "chatMessageShareAbility$delegate", "stateVM", "Lcom/larus/business/floatchat/impl/component/AIFloatChatWindowStateVM;", "getStateVM", "()Lcom/larus/business/floatchat/impl/component/AIFloatChatWindowStateVM;", "stateVM$delegate", "Lcom/larus/ui/arch/vm/internal/ComponentVMLazy;", "stateListeners", "Ljava/util/concurrent/CopyOnWriteArraySet;", "Lcom/larus/bmhome/ability/FloatChatWindowStateChangeListener;", "heightListeners", "Lcom/larus/bmhome/ability/FloatChatWindowHeightChangeListener;", "dragThresholdPx", "", "minInputHeightPx", "defaultPreviewContentHeightPx", "alphaThresholdPx", "navigationBarEnabled", "", "collapsedTopHandleContainerHeightPx", "expandedTopHandleContainerHeightPx", "selectModeTopHandleContainerHeightPx", "root", "Landroid/view/View;", "chatRoot", "Lcom/larus/bmhome/view/ChatConstraintLayout;", "messageListParent", "topHandleContainer", "titleContainer", "messageList", "Landroidx/recyclerview/widget/RecyclerView;", "previewHeightProvider", "Lcom/larus/bmhome/ability/FloatChatPreviewHeightProvider;", "transitionInterceptor", "Lcom/larus/bmhome/ability/FloatChatWindowTransitionInterceptor;", "lastSnapshot", "Lcom/larus/bmhome/ability/FloatChatWindowSnapshot;", "lastReportedChatModuleShowKey", "", "isChatModuleVisible", "canExpandChatPanel", "customChatRootBg", "Landroid/graphics/drawable/Drawable;", "shouldCollapseByListDrag", "listDragStartY", "", "previewTouchInterceptorAdded", "originImePaddingUpdate", "Lkotlin/Function1;", "", "originInterruptBottomPaddingUpdate", "Lkotlin/Function2;", "bottomMenuCurrentHeight", "currentImePadding", "cachedInputContentHeight", "inputContentLayoutObserver", "Landroid/view/ViewTreeObserver;", "pendingInputLayoutHeightSync", "Ljava/lang/Runnable;", "forceInputLayoutHeightSync", "lastInputTopToBottomHeight", "lastRootHeight", "lastMeasuredWindowHeight", "rootHeightAnimator", "Landroid/animation/ValueAnimator;", "rootBackgroundAlphaAnimator", "currentRootBackgroundAlpha", "isCollapsedTopHandleAlphaDragging", "progressCollapsedHeight", "progressExpandedHeight", "progressHeightRange", "lastWindowDragProgress", "aiFloatChatSupportInteraction", "previewTouchInterceptor", "com/larus/business/floatchat/impl/component/AIFloatChatWindowStateComponent$previewTouchInterceptor$1", "Lcom/larus/business/floatchat/impl/component/AIFloatChatWindowStateComponent$previewTouchInterceptor$1;", "inputContentGlobalLayoutListener", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "inputContentAttachStateListener", "com/larus/business/floatchat/impl/component/AIFloatChatWindowStateComponent$inputContentAttachStateListener$1", "Lcom/larus/business/floatchat/impl/component/AIFloatChatWindowStateComponent$inputContentAttachStateListener$1;", "rootLayoutChangeListener", "Landroid/view/View$OnLayoutChangeListener;", "messageListLayoutChangeListener", "contentViewId", "getContentViewId", "()I", "setContentViewId", "(I)V", "onViewCreated", "view", "onFragmentViewDestroyed", "getShowPercent", "setChatRootBg", "bg", "refreshRootBackground", "setCanExpandChatPanel", "canExpand", "getMinWindowHeight", "getMaxWindowHeight", "shouldAdaptPadding", "onBottomMenuHeightChanged", "curHeight", "normalHeight", "getWindowState", "Lcom/larus/bmhome/ability/FloatChatWindowState;", "getWindowHeight", "notifyChatModuleVisibilityChanged", "visible", "dispatchWindowEvent", "event", "Lcom/larus/bmhome/ability/FloatChatWindowEvent;", "setPreviewHeightProvider", "provider", "setTransitionInterceptor", "interceptor", "addWindowStateChangeListener", "listener", "removeWindowStateChangeListener", "addWindowHeightChangeListener", "removeWindowHeightChangeListener", "reduce", "currentState", "canTransit", "targetState", "currentSnapshot", "shouldAutoExpandPreview", "heightPx", "getHalfScreenHeight", "resolveAutoExpandedFromPreviewFlag", "shouldAutoExpandFromPreview", "applyInitialWindowStateFromArguments", "getInitialWindowStateFromArguments", "bindState", "bindMessageList", "refreshMessageList", "bindImePaddingUpdate", "bindBottomPaddingUpdateInterceptor", "shouldInterruptUnstableBottomPadding", "bottomPadding", MusicAppletPage.KEY_SOURCE, "syncWindowHeightForImePadding", "imePadding", "refreshInputContentHeight", "syncWindowHeightForDynamicInputArea", "force", "syncWindowHeightNow", "syncCollapsedHeightAfterInitialLayout", "bindTopHandleDrag", "isResponsiveSelfMessageTarget", "rv", "Landroid/view/MotionEvent;", "hasClickableViewAt", "rawX", "rawY", "visibleRect", "Landroid/graphics/Rect;", "shouldCloseInputPanelByCollapsedDragDown", "deltaY", "threshold", "isImeShowing", "isBottomMenuShowing", "closeInputPanelByCollapsedDragDown", "hideIme", "hideBottomMenu", "from", "startCollapsedTopHandleAlphaDragIfNeeded", "finishCollapsedTopHandleAlphaDragIfNeeded", "applyWindowState", "vmState", "Lcom/larus/business/floatchat/impl/component/AIFloatChatWindowStateVMState;", "renderWindowState", "state", "needAnim", "applyFloatingButtonVisibility", "hide", "updateTopHandleContainerHeight", "height", "applyRootBackground", "resolveRootBackgroundAlpha", "isAlphaStyleEnabled", "setRootBackgroundAlpha", "alpha", "animateRootBackgroundAlpha", "targetAlpha", "cancelRootBackgroundAlphaAnimator", "updateRootBackgroundAlpha", "animateRootHeight", "targetHeight", "cancelRootHeightAnimator", "restoreTitleState", "initRootLayoutParams", "updateRootHeight", "resolveTopHandleContainerHeight", "rootHeightPx", "applySettledTitleContainerState", "applyTransientWindowVisualState", "settleWindowVisualStateIfHeightReached", "measuredHeightPx", "updateWindowDragProgress", "resolveWindowDragProgress", "prepareWindowProgressBounds", "clearWindowProgressBounds", "getProgressCollapsedHeight", "getProgressExpandedHeight", "findDirectChildById", "Landroid/view/ViewGroup;", "id", "updateMessageListAlpha", "getSettledMessageListAlpha", "lerpTopHandleContainerHeight", "progress", "syncCurrentWindowHeight", "inputTopToBottomHeight", "updateLastInputTopToBottomHeight", "updateLastSnapshotHeight", "dispatchMeasuredWindowHeight", "syncStateVMHeight", "resolveHeight", "anchorMessage", "Lcom/larus/im/bean/message/Message;", "resolveEffectiveHeight", "resolveShowPercent", "reportChatModuleShowIfNeeded", "snapshot", "resolveChatModuleShowActionType", "getCollapsedHeight", "getInputTopToScreenBottomHeightForState", "dynamicBottomInset", "getInputTopToScreenBottomHeight", "includeBottomMenu", "getDynamicBottomInsetHeight", "getChatRootBottomPadding", "updateCachedInputContentHeight", "inputView", "getEmptyActionBarContainerHeight", "getInputContentHeight", "getCollapsedPositiveHeight", "getTopHandleContainerHeight", "primaryMeasureId", "buildWindowDebugInfo", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AIFloatChatWindowStateComponent extends BaseContentWidget implements va8.k, va8.h0 {
    public static final /* synthetic */ int S1 = 0;
    public final int A;
    public final boolean B;
    public final int C;
    public final int D;
    public final int E;
    public View F;
    public ChatConstraintLayout G;
    public final AIFloatChatWindowStateComponent$previewTouchInterceptor$1 G1;
    public View H;
    public int H0;
    public final u0 H1;
    public View I;
    public View J;
    public RecyclerView K;
    public va8.e L;
    public int L0;
    public final c L1;
    public va8.j M;
    public final v0 M1;
    public va8.h N;
    public String O;
    public boolean P;
    public int P0;
    public final w0 P1;
    public final boolean Q;
    public int Q1;
    public boolean R;
    public float S;
    public boolean T;
    public Function1<? super Integer, Unit> U;
    public Function2<? super Integer, ? super String, Boolean> V;
    public ValueAnimator V0;
    public int W;
    public int X;
    public int Y;
    public ViewTreeObserver Z;
    public ValueAnimator b1;
    public int g1;
    public boolean h1;
    public y0 k0;
    public int k1;
    public final Lazy m;
    public final Lazy n;
    public final Lazy o;
    public final Lazy p;
    public boolean p0;
    public int p1;
    public final Lazy q;
    public final Lazy r;
    public final Lazy s;
    public final Lazy t;
    public final com.larus.ui.arch.vm.internal.l u;
    public final CopyOnWriteArraySet<va8.i> v;
    public int v1;
    public final CopyOnWriteArraySet<va8.g> w;
    public final int x;
    public float x1;
    public final int y;
    public final boolean y1;
    public final int z;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[FloatChatWindowState.values().length];
            r0[FloatChatWindowState.Preview.ordinal()] = 1;     // Catch: NoSuchFieldError -> L21
        L38:
            r0[FloatChatWindowState.Collapsed.ordinal()] = 2;     // Catch: NoSuchFieldError -> L22
        L54:
            r0[FloatChatWindowState.Expanded.ordinal()] = 3;     // Catch: NoSuchFieldError -> L23
        L8:
            a = r0;
            int[] r1 = new int[FloatChatWindowEventType.values().length];
            r1[FloatChatWindowEventType.Init.ordinal()] = 1;     // Catch: NoSuchFieldError -> L24
        L42:
            r1[FloatChatWindowEventType.SendSuccess.ordinal()] = 2;     // Catch: NoSuchFieldError -> L25
        L56:
            r1[FloatChatWindowEventType.ManualDragUp.ordinal()] = 3;     // Catch: NoSuchFieldError -> L26
        L34:
            r1[FloatChatWindowEventType.ManualDragDown.ordinal()] = 4;     // Catch: NoSuchFieldError -> L27
        L46:
            r1[FloatChatWindowEventType.BackPress.ordinal()] = 5;     // Catch: NoSuchFieldError -> L28
        L36:
            r1[FloatChatWindowEventType.MaskClick.ordinal()] = 6;     // Catch: NoSuchFieldError -> L29
        L48:
            r1[FloatChatWindowEventType.AnswerIntent.ordinal()] = 7;     // Catch: NoSuchFieldError -> L30
        L52:
            r1[FloatChatWindowEventType.RefreshPageIntent.ordinal()] = 8;     // Catch: NoSuchFieldError -> L31
        L40:
            r1[FloatChatWindowEventType.Rebound.ordinal()] = 9;     // Catch: NoSuchFieldError -> L32
        L44:
            r1[FloatChatWindowEventType.ExternalRequest.ordinal()] = 10;     // Catch: NoSuchFieldError -> L33
        L19:
            b = r1;
        }
    }

    public static final class c implements View.OnAttachStateChangeListener {
        public final /* synthetic */ AIFloatChatWindowStateComponent a;

        public c(AIFloatChatWindowStateComponent r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r3) {
            Intrinsics.checkNotNullParameter(r3, "view");
            AIFloatChatWindowStateComponent r0 = this.a;
            ViewTreeObserver r4 = r3.getViewTreeObserver();
            r4.addOnGlobalLayoutListener(this.a.H1);
            r0.Z = r4;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r3) {
            Intrinsics.checkNotNullParameter(r3, "view");
            ViewTreeObserver r4 = this.a.Z;
            if (r4 != null) goto L5;
        L10:
            this.a.Z = null;
            return;
        L5:
            if (r4.isAlive() == true) goto L8;
            r4 = null;
        L8:
            if (r4 == null) goto L10;
            r4.removeOnGlobalLayoutListener(this.a.H1);
            goto L10
        }
    }

    public static final class d implements Function0<va8.p> {
        public final /* synthetic */ AttachReceiver a;

        public d(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(va8.p.class));
        }
    }

    public static final class e implements Function0<va8.n> {
        public final /* synthetic */ AttachReceiver a;

        public e(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(va8.n.class));
        }
    }

    public static final class f implements Function0<ICoreInputAbility> {
        public final /* synthetic */ AttachReceiver a;

        public f(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(ICoreInputAbility.class));
        }
    }

    public static final class g implements Function0<ew8.a> {
        public final /* synthetic */ AttachReceiver a;

        public g(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(ew8.a.class));
        }
    }

    public static final class h implements Function0<ew8.b> {
        public final /* synthetic */ AttachReceiver a;

        public h(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(ew8.b.class));
        }
    }

    public static final class i implements Function0<xa8.a> {
        public final /* synthetic */ AttachReceiver a;

        public i(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(xa8.a.class));
        }
    }

    public static final class j implements Function0<va8.w> {
        public final /* synthetic */ AttachReceiver a;

        public j(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(va8.w.class));
        }
    }

    public static final class k implements Function0<IChatMessageShareAbility> {
        public final /* synthetic */ AttachReceiver a;

        public k(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(IChatMessageShareAbility.class));
        }
    }

    public static final class l implements Function0<LifecycleOwner> {
        public final /* synthetic */ ComponentFeature a;

        public l(ComponentFeature r1) {
            this.a = r1;
        }

        public final Object invoke() {
            return this.a;
        }
    }

    public static final class m implements Function0<ViewModelStoreOwner> {
        public final /* synthetic */ ComponentFeature a;

        public m(ComponentFeature r1) {
            this.a = r1;
        }

        public final Object invoke() {
            return this.a;
        }
    }

    public static final class n implements Function0<ViewModelProvider.Factory> {
        public static final n a = null;

        static {
            a = new n();
        }

        public n() {
        }

        public final Object invoke() {
            return new ViewModelProvider.NewInstanceFactory();
        }
    }

    static {
    }

    public final void A2() {
        if (this.T == false) goto L7;
        RecyclerView r0 = this.K;
        if (r0 == null) goto L7;
        r0.removeOnItemTouchListener(this.G1);
    L7:
        RecyclerView r1 = this.K;
        if (r1 == null) goto L10;
        r1.removeOnLayoutChangeListener(this.P1);
    L10:
        Function1<? super Integer, Unit> r2 = this.U;
        if (r2 == null) goto L15;
        ChatConstraintLayout r3 = this.G;
        if (r3 == null) goto L15;
        r3.setOnImePaddingUpdate(r2);
    L15:
        Function2<? super Integer, ? super String, Boolean> r4 = this.V;
        if (r4 == null) goto L20;
        ChatConstraintLayout r5 = this.G;
        if (r5 == null) goto L20;
        r5.setInterruptBottomPaddingUpdate(r4);
    L20:
        View r6 = this.F;
        if (r6 == null) goto L23;
        r6.removeOnAttachStateChangeListener(this.L1);
    L23:
        ViewTreeObserver r7 = this.Z;
        if (r7 != null) goto L26;
    L31:
        this.Z = null;
        y0 r8 = this.k0;
        if (r8 == null) goto L36;
        View r9 = this.F;
        if (r9 == null) goto L36;
        r9.removeCallbacks(r8);
    L36:
        this.k0 = null;
        this.p0 = false;
        ChatConstraintLayout r10 = this.F;
        if ((r10 instanceof ShadowChatConstraintLayout) == false) goto L39;
        ChatConstraintLayout r11 = (ShadowChatConstraintLayout) r10;
    L40:
        if (r11 == null) goto L42;
        r11.removeOnLayoutChangeListener(this.M1);
    L42:
        G3(false);
        E3();
        View r12 = this.F;
        if (r12 == null) goto L47;
        ViewPropertyAnimator r13 = r12.animate();
        if (r13 == null) goto L47;
        r13.cancel();
    L47:
        this.F = null;
        this.G = null;
        this.H = null;
        this.I = null;
        this.J = null;
        this.K = null;
        this.U = null;
        this.V = null;
        this.W = 0;
        this.X = 0;
        this.Y = 0;
        this.H0 = 0;
        this.P0 = 0;
        this.O = null;
        this.k1 = 0;
        this.p1 = 0;
        this.v1 = 0;
        this.x1 = Float.NaN;
        this.P = true;
        return;
    L39:
        r11 = null;
        goto L40
    L26:
        if (r7.isAlive() == true) goto L29;
        r7 = null;
    L29:
        if (r7 == null) goto L31;
        r7.removeOnGlobalLayoutListener(this.H1);
        goto L31
    }

    public final void E3() {
        ValueAnimator r0 = this.b1;
        if (r0 != null) goto L5;
        return;
    L5:
        this.b1 = null;
        r0.cancel();
    }

    public final int H3() {
        ChatConstraintLayout r0 = this.G;
        if (r0 != null) goto L5;
        return 0;
    L5:
        return RangesKt.coerceAtLeast(r0.getPaddingBottom(), 0);
    }

    public final int QK() {
        int r0 = this.y + this.C;
        Intrinsics.checkNotNullParameter(this, "<this>");
        Bundle r2 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getArguments();
        int r3 = 0;
        if (r2 == null) goto L7;
        boolean r4 = true;
        if (r2.getBoolean("adapt_padding", false) != true) goto L7;
    L8:
        if (r4 == false) goto L13;
        Intrinsics.checkNotNullParameter(this, "<this>");
        FragmentActivity r1 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getActivity();
        if (r1 == null) goto L13;
        r3 = com.larus.utils.u.b(r1);
    L13:
        return r0 + r3;
    L7:
        r4 = false;
        goto L8
    }

    public final int V3() {
        Integer r0 = Integer.valueOf(this.Y);
        if (r0.intValue() <= 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == true) goto L9;
        r0 = null;
    L9:
        if (r0 == null) goto L12;
        return r0.intValue();
    L12:
        return this.y;
    L5:
        r1 = false;
        goto L6
    }

    public final int X3() {
        int r0 = com.larus.utils.m0.a;
        int r1 = (com.larus.utils.m0.a(getContext()) - com.larus.utils.i.e(getContext())) - ((Number) i5.e0.getValue()).intValue();
        Intrinsics.checkNotNullParameter(this, "<this>");
        Bundle r2 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getArguments();
        int r3 = 0;
        if (r2 == null) goto L7;
        boolean r4 = true;
        if (r2.getBoolean("adapt_padding", false) != true) goto L7;
    L8:
        if (r4 == true) goto L14;
        Intrinsics.checkNotNullParameter(this, "<this>");
        FragmentActivity r5 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getActivity();
        if (r5 == null) goto L14;
        r3 = com.larus.utils.u.b(r5);
    L14:
        return r1 - r3;
    L7:
        r4 = false;
        goto L8
    }

    public final int Z3() {
        Integer r0 = Integer.valueOf(this.k1);
        if (r0.intValue() <= 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == true) goto L9;
        r0 = null;
    L9:
        if (r0 != null) goto L13;
        FloatChatWindowState r2 = FloatChatWindowState.Collapsed;
        int r3 = Math.max(this.X, H3());
        int r4 = this.W;
        return Q3(r2, (V3() + r3) + r4);
    L13:
        return r0.intValue();
    L5:
        r1 = false;
        goto L6
    }

    public final int a4() {
        Integer r0 = Integer.valueOf(this.p1);
        if (r0.intValue() <= 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == true) goto L9;
        r0 = null;
    L9:
        if (r0 == null) goto L12;
        return r0.intValue();
    L12:
        return X3();
    L5:
        r1 = false;
        goto L6
    }

    public final AIFloatChatWindowStateVM d4() {
        return (AIFloatChatWindowStateVM) this.u.getValue();
    }

    public final void g() {
        boolean r1 = false;
        if (this.X > 0) goto L13;
        va8.n r0 = (va8.n) this.n.getValue();
        if (r0 != null) goto L7;
    L9:
        boolean r2 = false;
    L10:
        if (r2 == true) goto L13;
        boolean r3 = false;
    L14:
        if (r3 == false) goto L23;
        ICoreInputAbility r4 = (ICoreInputAbility) this.o.getValue();
        if (r4 == null) goto L18;
        r4.qp(true);
        r1 = true;
    L18:
        if (r1 == true) goto L24;
        va8.n r5 = (va8.n) this.n.getValue();
        if (r5 == null) goto L25;
        r5.hideKeyboard();
        return;
    L25:
        return;
    L24:
        return;
    L23:
        return;
    L7:
        if (r0.w() != true) goto L9;
        r2 = true;
    L13:
        r3 = true;
        goto L14
    }

    public final boolean i4() {
        ew8.a r0 = (ew8.a) this.p.getValue();
        if (r0 == null) goto L10;
        AIChatInputConfig r1 = r0.getCurrentConfig();
        if (r1 != null) goto L7;
        return false;
    L7:
        if (r1.i != true) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    public final void j4() {
        FloatChatWindowState r0 = FloatChatWindowState.Collapsed;
        int r1 = Math.max(this.X, H3());
        int r2 = this.W;
        this.k1 = Q3(r0, (V3() + r1) + r2);
        int r3 = X3();
        this.p1 = r3;
        this.v1 = RangesKt.coerceAtLeast(r3 - this.k1, 0);
        this.x1 = Float.NaN;
    }

    public final void l4() {
        View r0 = this.F;
        if (r0 == null) goto L37;
        View r1 = r0.findViewById(2131375324);
        if (r1 != null) goto L8;
        return;
    L8:
        if ((r1 instanceof ViewStub) == false) goto L10;
        return;
    L10:
        int r2 = r1.getHeight();
        if (r2 <= 0) goto L38;
        View r3 = r1.findViewById(2131362044);
        int r4 = 0;
        if (r3 != null) goto L16;
    L35:
        this.Y = RangesKt.coerceAtLeast(r2 - r4, this.y);
        return;
    L16:
        if (r3.getVisibility() != 0) goto L35;
        RecyclerView r5 = r3.findViewById(2131362041);
        if (r5 == null) goto L23;
        RecyclerView.Adapter r6 = r5.getAdapter();
        if (r6 == null) goto L23;
        int r7 = r6.getItemCount();
    L24:
        if (r7 > 0) goto L35;
        int r8 = Math.max(r3.getHeight(), r3.getMeasuredHeight());
        if (r8 <= 0) goto L29;
        r4 = r8;
        goto L35
    L29:
        ViewGroup.LayoutParams r9 = r3.getLayoutParams();
        if ((r9 instanceof ViewGroup.MarginLayoutParams) == false) goto L32;
        ViewGroup.MarginLayoutParams r10 = (ViewGroup.MarginLayoutParams) r9;
    L33:
        if (r10 == null) goto L35;
        r4 = RangesKt.coerceAtLeast(r10.topMargin, 0);
        goto L35
    L32:
        r10 = null;
    L23:
        r7 = 0;
        goto L24
    L38:
        return;
    }

    public final void x4() {
        va8.p r0 = (va8.p) this.m.getValue();
        if (r0 == null) goto L18;
        RecyclerView r1 = r0.Ly();
        if (r1 == null) goto L20;
        RecyclerView r2 = this.K;
        if (r1 != r2) goto L10;
        return;
    L10:
        if (this.T == false) goto L13;
        if (r2 == null) goto L13;
        r2.removeOnItemTouchListener(this.G1);
    L13:
        RecyclerView r3 = this.K;
        if (r3 == null) goto L16;
        r3.removeOnLayoutChangeListener(this.P1);
    L16:
        this.K = r1;
        r1.addOnItemTouchListener(this.G1);
        r1.addOnLayoutChangeListener(this.P1);
        this.T = true;
        return;
    L20:
        return;
    }

    /* JADX WARN: Type inference failed for: r0v44, types: [com.larus.business.floatchat.impl.component.AIFloatChatWindowStateComponent$previewTouchInterceptor$1] */
    /* JADX WARN: Type inference failed for: r0v45, types: [com.larus.business.floatchat.impl.component.u0] */
    /* JADX WARN: Type inference failed for: r0v47, types: [com.larus.business.floatchat.impl.component.v0] */
    /* JADX WARN: Type inference failed for: r0v48, types: [com.larus.business.floatchat.impl.component.w0] */
    public AIFloatChatWindowStateComponent() {
        this.m = LazyKt.lazy(new d(this));
        this.n = LazyKt.lazy(new e(this));
        this.o = LazyKt.lazy(new f(this));
        this.p = LazyKt.lazy(new g(this));
        this.q = LazyKt.lazy(new h(this));
        this.r = LazyKt.lazy(new i(this));
        this.s = LazyKt.lazy(new j(this));
        this.t = LazyKt.lazy(new k(this));
        this.u = new com.larus.ui.arch.vm.internal.l(Reflection.getOrCreateKotlinClass(AIFloatChatWindowStateVM.class), Reflection.getOrCreateKotlinClass(AIFloatChatWindowStateVMState.class), new l(this), new m(this), n.a);
        this.v = new CopyOnWriteArraySet();
        this.w = new CopyOnWriteArraySet();
        this.x = i5.f0();
        this.y = i5.q0();
        this.z = ((Number) i5.M0.getValue()).intValue();
        this.A = i5.f0();
        boolean r0 = z2.a.r1();
        this.B = r0;
        this.C = i5.c();
        if (r0 == false) goto L5;
        int r1 = i5.c();
    L6:
        this.D = r1;
        this.E = ((Number) i5.X.getValue()).intValue();
        this.P = true;
        this.Q = true;
        this.g1 = 255;
        this.x1 = Float.NaN;
        this.y1 = p1.a.aiFloatChatSupportInteraction();
        this.G1 = new AIFloatChatWindowStateComponent$previewTouchInterceptor$1(this);
        this.H1 = new u0(this);
        this.L1 = new c(this);
        this.M1 = new v0(this);
        this.P1 = new w0(this);
        this.Q1 = 2131365588;
        return;
    L5:
        r1 = ((Number) i5.L.getValue()).intValue();
        goto L6
    }

    public final void IH() {
        AIFloatChatWindowStateVMState r0 = (AIFloatChatWindowStateVMState) d4().getState();
        if (r0.getState() != FloatChatWindowState.Collapsed) goto L8;
        if (r0.isDragging() == true) goto L8;
        int r1 = QK();
    L21:
        p3(r1);
        return;
    L8:
        if (r0.getHeightPx() <= 0) goto L10;
        r1 = r0.getHeightPx();
        goto L21
    L10:
        va8.h r2 = this.N;
        if (r2 == null) goto L13;
        int r3 = r2.b;
    L14:
        if (r3 <= 0) goto L17;
        if (r2 == null) goto L20;
        r1 = r2.b;
    L20:
        r1 = 0;
        goto L21
    L17:
        View r4 = this.F;
        if (r4 == null) goto L20;
        r1 = r4.getHeight();
        goto L21
    L13:
        r3 = 0;
        goto L14
    }

    public final FloatChatWindowState getWindowState() {
        return ((AIFloatChatWindowStateVMState) d4().getState()).getState();
    }

    public final int rN() {
        return ((AIFloatChatWindowStateVMState) d4().getState()).getHeightPx();
    }

    public final int U2() {
        return this.Q1;
    }

    public static /* synthetic */ void B3(AIFloatChatWindowStateComponent r1) {
        r1.z3(r1.getWindowState());
    }

    public static float c4(FloatChatWindowState r1) {
        int r2 = b.a[r1.ordinal()];
        if (r2 != 1) goto L5;
    L12:
        return 1.0f;
    L5:
        if (r2 != 2) goto L7;
        return 0.0f;
    L7:
        if (r2 == 3) goto L12;
        throw new NoWhenBranchMatchedException();
    }

    public static String k4(Message r5) {
        String r0 = r5.getMessageId();
        boolean r1 = false;
        if (r0 != null) goto L5;
    L14:
        String r6 = r5.getLocalMessageId();
        if (r6 != null) goto L17;
        return null;
    L17:
        if (r6.length() <= 0) goto L19;
        r1 = true;
    L19:
        if (r1 == true) goto L21;
        return null;
    L21:
        return r6;
    L5:
        if (r0.length() <= 0) goto L7;
        boolean r4 = true;
    L8:
        if (r4 == true) goto L11;
        r0 = null;
    L11:
        if (r0 == null) goto L14;
        return r0;
    L7:
        r4 = false;
        goto L8
    }

    public final int B4(int r5) {
        if (getWindowState() == FloatChatWindowState.Collapsed) goto L6;
        this.h1 = false;
        E3();
        return 255;
    L6:
        int r6 = r5 - QK();
        if (r6 > 0) goto L9;
        return 0;
    L9:
        int r0 = this.A;
        if (r6 < r0) goto L13;
        return 255;
    L13:
        return RangesKt.coerceIn(MathKt.roundToInt((r6 * 255.0f) / r0), 0, 255);
    }

    public final void C3(int r3) {
        float r4 = G4(r3);
        V4(r4);
        View r0 = this.J;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.B == true) goto L7;
    L9:
        int r1 = 8;
    L10:
        r0.setVisibility(r1);
        r0.setAlpha(r4);
        return;
    L7:
        if (r4 <= 0.0f) goto L9;
        r1 = 0;
        goto L10
    }

    public final va8.h D3(AIFloatChatWindowStateVMState r12) {
        FLogger r0 = FLogger.a;
        r0.i("AIFloatChatWindowStateComponent", "applyWindowState entry, state=" + r12.getState() + ", heightPx=" + r12.getHeightPx());
        final int r1 = q4(r12.getState(), r12.getAnchorMessage(), r12.getHeightPx());
        FloatChatWindowState r3 = r12.getState();
        boolean r4 = r12.getNeedAnim();
        r0.i("AIFloatChatWindowStateComponent", "renderWindowState entry, state=" + r3 + ", height=" + r1 + ", needAnim=" + r4);
        if (r3 == FloatChatWindowState.Expanded) goto L5;
        boolean r5 = true;
    L6:
        m3(r5);
        View r6 = this.F;
        Integer r8 = null;
        if (r6 == null) goto L9;
        View r7 = r6.findViewById(2131379994);
    L10:
        this.H = r7;
        int r9 = b.a[r3.ordinal()];
        if (r9 == 1) goto L21;
        if (r9 != 2) goto L14;
        View r10 = this.I;
        if (r10 == null) goto L24;
        e1.x(r10);
    L24:
        if (r4 == false) goto L38;
        if (r1 <= 0) goto L38;
        G3(false);
        j4();
        View r11 = this.F;
        if (r11 == null) goto L36;
        Integer r13 = Integer.valueOf(r11.getHeight());
        if (r13.intValue() <= 0) goto L31;
        boolean r14 = true;
    L32:
        if (r14 == false) goto L34;
        r8 = r13;
    L34:
        if (r8 == null) goto L36;
        int r15 = r8.intValue();
    L37:
        C3(r15);
        r0.i("AIFloatChatWindowStateComponent", "animateRootHeight entry, current=" + r15 + ", target=" + r1);
        final ValueAnimator r2 = ValueAnimator.ofInt(new int[]{r15, r1}).setDuration(200);
        this.V0 = r2;
        r2.addUpdateListener(new l0(r1, this));
        Intrinsics.checkNotNull(r2);
        d2a.g.c(r2, new q0(this, r2, r1));
        r2.setInterpolator(new LinearInterpolator());
        r2.start();
        h3(B4(r1));
    L39:
        r12.getState();
        va8.h r16 = new va8.h(r12.getState(), r1, F4(r1), r12.getFrom());
        this.N = r16;
        return r16;
    L31:
        r14 = false;
    L36:
        r15 = r1;
    L38:
        d5(r1);
        V4(c4(r3));
        z3(r3);
        goto L39
    L14:
        if (r9 == 3) goto L21;
        throw new NoWhenBranchMatchedException();
    L21:
        x4();
        View r17 = this.I;
        if (r17 == null) goto L24;
        e1.x(r17);
        goto L24
    L9:
        r7 = null;
        goto L10
    L5:
        r5 = false;
        goto L6
    }

    public final int F4(int r4) {
        int r0 = com.larus.utils.m0.a;
        Integer r1 = Integer.valueOf(com.larus.utils.m0.a(getContext()));
        if (r1.intValue() <= 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == true) goto L9;
        r1 = null;
    L9:
        if (r1 != null) goto L11;
        return 0;
    L11:
        return RangesKt.coerceIn(MathKt.roundToInt((r4 * 100.0f) / r1.intValue()), 0, 100);
    L5:
        r2 = false;
        goto L6
    }

    public final void G3(boolean r5) {
        ValueAnimator r0 = this.V0;
        if (r0 != null) goto L9;
        if (r5 == true) goto L6;
        return;
    L6:
        if (((AIFloatChatWindowStateVMState) d4().getState()).isDragging() == true) goto L16;
        z3(getWindowState());
        return;
    L16:
        return;
    L9:
        FLogger.a.i("AIFloatChatWindowStateComponent", "cancelRootHeightAnimator, running=" + r0.isRunning());
        this.V0 = null;
        r0.cancel();
        if (((AIFloatChatWindowStateVMState) d4().getState()).isDragging() == true) goto L17;
        if (r5 == false) goto L13;
        z3(getWindowState());
    L13:
        this.k1 = 0;
        this.p1 = 0;
        this.v1 = 0;
        this.x1 = Float.NaN;
        return;
    }

    public final float G4(int r8) {
        int r0 = Z3();
        Integer r1 = Integer.valueOf(this.v1);
        boolean r3 = true;
        if (r1.intValue() <= 0) goto L5;
        boolean r2 = true;
    L6:
        Integer r5 = null;
        if (r2 == true) goto L11;
        r1 = null;
    L11:
        if (r1 == null) goto L13;
        int r4 = r1.intValue();
    L22:
        return RangesKt.coerceIn((r8 - r0) / r4, 0.0f, 1.0f);
    L13:
        Integer r6 = Integer.valueOf(a4() - r0);
        if (r6.intValue() > 0) goto L17;
        r3 = false;
    L17:
        if (r3 == false) goto L19;
        r5 = r6;
    L19:
        if (r5 == null) goto L23;
        r4 = r5.intValue();
        goto L22
    L23:
        return 0.0f;
    L5:
        r2 = false;
        goto L6
    }

    public final void I20(va8.e r1) {
        this.L = r1;
    }

    public final void My(va8.g r4) {
        Intrinsics.checkNotNullParameter(r4, "listener");
        if (this.w.add(r4) == true) goto L5;
        return;
    L5:
        ChatConstraintLayout r0 = this.F;
        Integer r2 = null;
        if ((r0 instanceof ShadowChatConstraintLayout) == false) goto L8;
        ChatConstraintLayout r1 = (ShadowChatConstraintLayout) r0;
    L9:
        if (r1 == null) goto L19;
        Integer r3 = Integer.valueOf(r1.getHeight());
        if (r3.intValue() <= 0) goto L13;
        boolean r5 = true;
    L14:
        if (r5 == false) goto L16;
        r2 = r3;
    L16:
        if (r2 == null) goto L20;
        r4.l2(r2.intValue());
        return;
    L20:
        return;
    L13:
        r5 = false;
        goto L14
    L19:
        return;
    L8:
        r1 = null;
        goto L9
    }

    public final void Tg(va8.g r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.w.remove(r2);
    }

    public final void V4(float r4) {
        float r2 = 1.0f;
        if (getWindowState() == FloatChatWindowState.Preview) goto L6;
        r2 = RangesKt.coerceIn(r4, 0.0f, 1.0f);
    L6:
        View r5 = this.H;
        if (r5 != null) goto L12;
        View r6 = this.F;
        if (r6 == null) goto L11;
        r5 = r6.findViewById(2131379994);
        goto L12
    L11:
        r5 = null;
    L12:
        if (r5 == null) goto L15;
        r5.setAlpha(r2);
        return;
    }

    public final void W4(int r4) {
        int r5 = RangesKt.coerceIn(r4, 0, 255);
        View r0 = this.F;
        ShadowChatConstraintLayout r1 = null;
        if (r0 == null) goto L5;
        Drawable r2 = r0.getBackground();
    L6:
        if (r2 != null) goto L9;
        return;
    L9:
        if (this.g1 != r5) goto L11;
        return;
    L11:
        this.g1 = r5;
        r2.setAlpha(r5);
        Object r6 = this.F;
        if ((r6 instanceof ShadowChatConstraintLayout) == false) goto L14;
        r1 = (ShadowChatConstraintLayout) r6;
    L14:
        if (r1 == null) goto L17;
        r1.setOutwardShadowAlpha(this.g1);
        return;
    L17:
        return;
    L5:
        r2 = null;
        goto L6
    }

    public final void X2(int r1) {
        this.Q1 = r1;
    }

    public final void d5(int r9) {
        View r0 = this.F;
        if (r0 != null) goto L5;
        return;
    L5:
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        if (r1 != null) goto L8;
        return;
    L8:
        if (r9 <= 0) goto L10;
        int r2 = r9;
    L11:
        Integer r3 = Integer.valueOf(r9);
        boolean r5 = true;
        if (r3.intValue() <= 0) goto L14;
        boolean r4 = true;
    L15:
        Integer r7 = null;
        if (r4 == true) goto L19;
        r3 = null;
    L19:
        if (r3 != null) goto L29;
        r3 = Integer.valueOf(r0.getHeight());
        if (r3.intValue() <= 0) goto L24;
        boolean r6 = true;
    L25:
        if (r6 == true) goto L28;
        r3 = null;
    L28:
        if (r3 != null) goto L29;
        int r8 = 0;
    L32:
        if (r1.height != r2) goto L37;
        if (r8 <= 0) goto L37;
        if (((AIFloatChatWindowStateVMState) d4().getState()).getHeightPx() != r8) goto L37;
        boolean r10 = true;
    L38:
        if (r10 == false) goto L41;
        return;
    L41:
        if (r1.height == r2) goto L43;
        r1.height = r2;
        r0.setLayoutParams(r1);
    L43:
        Integer r11 = Integer.valueOf(r9);
        if (r11.intValue() <= 0) goto L46;
        boolean r12 = true;
    L47:
        if (r12 == false) goto L49;
        r7 = r11;
    L49:
        if (r7 == null) goto L51;
        int r13 = r7.intValue();
    L55:
        if (r13 <= 0) goto L59;
        this.L0 = r13;
        AIFloatChatWindowStateVM r14 = d4();
        getWindowState();
        r14.updateWindowHeight(r13, F4(r13));
    L59:
        if (this.B == true) goto L68;
        IChatMessageShareAbility r15 = (IChatMessageShareAbility) this.t.getValue();
        if (r15 != null) goto L63;
    L65:
        boolean r16 = false;
    L66:
        if (r16 == false) goto L68;
        int r17 = this.E;
    L85:
        View r18 = this.I;
        if (r18 == null) goto L95;
        ViewGroup.LayoutParams r19 = r18.getLayoutParams();
        if (r19 == null) goto L95;
        if (r19.height == r17) goto L95;
        r19.height = r17;
        r18.setLayoutParams(r19);
    L95:
        p3(r9);
        return;
    L63:
        if (r15.H1() != true) goto L65;
        r16 = true;
    L68:
        AIFloatChatWindowStateVMState r20 = (AIFloatChatWindowStateVMState) d4().getState();
        if (r20.getState() != FloatChatWindowState.Preview) goto L74;
        if (r20.isDragging() == true) goto L74;
        r17 = e4(r20.getState());
    L74:
        if (r20.isDragging() == true) goto L84;
        ValueAnimator r21 = this.V0;
        if (r21 != null) goto L78;
    L80:
        r5 = false;
    L81:
        if (r5 == true) goto L84;
        r17 = e4(r20.getState());
        goto L85
    L78:
        if (r21.isRunning() != true) goto L80;
    L84:
        float r22 = RangesKt.coerceIn(G4(r9), 0.0f, 1.0f);
        int r23 = this.C;
        r17 = MathKt.roundToInt(r23 + ((this.D - r23) * r22));
        goto L85
    L51:
        View r24 = this.F;
        if (r24 == null) goto L54;
        r13 = r24.getHeight();
        goto L55
    L54:
        r13 = 0;
        goto L55
    L46:
        r12 = false;
    L37:
        r10 = false;
        goto L38
    L24:
        r6 = false;
    L29:
        r8 = r3.intValue();
        goto L32
    L14:
        r4 = false;
        goto L15
    L10:
        r2 = -2;
        goto L11
    }

    public final void du(boolean r6) {
        if (this.P != r6) goto L5;
        return;
    L5:
        this.P = r6;
        Integer r0 = null;
        if (r6 == true) goto L9;
        this.O = null;
        return;
    L9:
        AIFloatChatWindowStateVMState r7 = (AIFloatChatWindowStateVMState) d4().getState();
        View r1 = this.F;
        if (r1 == null) goto L19;
        Integer r2 = Integer.valueOf(r1.getHeight());
        if (r2.intValue() <= 0) goto L14;
        boolean r3 = true;
    L15:
        if (r3 == false) goto L17;
        r0 = r2;
    L17:
        if (r0 == null) goto L19;
        int r4 = r0.intValue();
    L20:
        va8.h r5 = this.N;
        if (r5 != null) goto L23;
        FloatChatWindowState r8 = r7.getState();
        r7.getState();
        r5 = new va8.h(r8, r4, F4(r4), r7.getFrom());
    L23:
        p4(r5, r7.getAnchorMessage());
        return;
    L14:
        r3 = false;
    L19:
        r4 = r7.getHeightPx();
        goto L20
    }

    public final int e4(FloatChatWindowState r3) {
        if (this.B == true) goto L13;
        IChatMessageShareAbility r0 = (IChatMessageShareAbility) this.t.getValue();
        if (r0 != null) goto L7;
    L9:
        boolean r1 = false;
    L10:
        if (r1 == false) goto L13;
        return this.E;
    L7:
        if (r0.H1() != true) goto L9;
        r1 = true;
    L13:
        int r4 = b.a[r3.ordinal()];
        if (r4 == 1) goto L23;
        if (r4 == 2) goto L23;
        if (r4 != 3) goto L21;
        return this.D;
    L21:
        throw new NoWhenBranchMatchedException();
    L23:
        return this.C;
    }

    public final void eV(qo9.q r1) {
        this.M = r1;
    }

    public final void h3(int r5) {
        if (i4() == true) goto L6;
        E3();
        W4(255);
        return;
    L6:
        final int r6 = RangesKt.coerceIn(r5, 0, 255);
        int r1 = RangesKt.coerceIn(this.g1, 0, 255);
        if (r1 != r6) goto L17;
        ValueAnimator r3 = this.b1;
        if (r3 != null) goto L11;
    L13:
        boolean r4 = false;
    L14:
        if (r4 == true) goto L17;
        W4(r6);
        return;
    L11:
        if (r3.isRunning() != true) goto L13;
        r4 = true;
    L17:
        E3();
        final ValueAnimator r0 = ValueAnimator.ofInt(new int[]{r1, r6}).setDuration(200);
        this.b1 = r0;
        r0.addUpdateListener(new s0(this, r6));
        Intrinsics.checkNotNull(r0);
        d2a.g.c(r0, new t0(this, r0, r6));
        r0.setInterpolator(new LinearInterpolator());
        r0.start();
    }

    public final void hn(va8.f r21) {
        Intrinsics.checkNotNullParameter(r21, "event");
        FloatChatWindowState r2 = getWindowState();
        FLogger r3 = FLogger.a;
        StringBuilder r4 = new StringBuilder("dispatchWindowEvent entry, type=");
        r4.append(r21.getType());
        r4.append(", current=");
        r4.append(r2);
        r4.append(", targetArg=");
        r4.append(r21.b);
        r4.append(", anchor=");
        Message r6 = r21.c;
        FloatChatWindowState r7 = null;
        if (r6 == null) goto L5;
        String r8 = k4(r6);
    L6:
        r4.append(r8);
        r4.append(", ");
        int r9 = W3(this, r2);
        AIFloatChatWindowStateVMState r10 = (AIFloatChatWindowStateVMState) d4().getState();
        StringBuilder r11 = new StringBuilder("state=");
        r11.append(r2);
        r11.append(", rootHeight=");
        View r12 = this.F;
        if (r12 == null) goto L9;
        Integer r13 = Integer.valueOf(r12.getHeight());
    L10:
        r11.append(r13);
        r11.append(", vmHeight=");
        r11.append(r10.getHeightPx());
        r11.append(", vmState=");
        r11.append(r10.getState());
        r11.append(", lastSnapshot=");
        va8.h r14 = this.N;
        if (r14 == null) goto L13;
        FloatChatWindowState r15 = r14.a;
    L14:
        r11.append(r15);
        r11.append('/');
        va8.h r16 = this.N;
        if (r16 == null) goto L17;
        Integer r17 = Integer.valueOf(r16.b);
    L18:
        r11.append(r17);
        r11.append(", inputTopToBottom=");
        r11.append(r9);
        r11.append(", inputContent=");
        r11.append(V3());
        r11.append(", dynamicInset=");
        r11.append(Math.max(this.X, H3()));
        r11.append(", imePadding=");
        r11.append(this.X);
        r11.append(", rootPadding=");
        r11.append(H3());
        r11.append(", bottomMenu=");
        r11.append(this.W);
        r11.append(", lastInput=");
        r11.append(this.H0);
        r11.append(", pending=");
        boolean r18 = false;
        if (this.k0 == null) goto L21;
        boolean r19 = true;
    L22:
        r11.append(r19);
        r11.append(", dragging=");
        r11.append(r10.isDragging());
        r11.append(", dynamicHeightSync=");
        r11.append(r10.isDynamicHeightSync());
        r11.append(", animatorRunning=");
        ValueAnimator r20 = this.V0;
        if (r20 != null) goto L25;
    L27:
        boolean r22 = false;
    L28:
        r11.append(r22);
        r4.append(r11.toString());
        r3.i("AIFloatChatWindowStateComponent", r4.toString());
        switch(b.b[r21.getType().ordinal()]) {
            case 1: goto L58;
            case 2: goto L55;
            case 3: goto L53;
            case 4: goto L52;
            case 5: goto L51;
            case 6: goto L51;
            case 7: goto L49;
            case 8: goto L42;
            case 9: goto L57;
            case 10: goto L32;
            default: goto L31;
        };
    L32:
        FloatChatWindowState r5 = r21.b;
        if (r5 != null) goto L35;
        int r23 = -1;
    L36:
        if (r23 == (-1)) goto L40;
        if (r23 == 1) goto L39;
        r7 = r21.b;
    L59:
        if (r7 != null) goto L62;
        r3.i("AIFloatChatWindowStateComponent", "dispatchWindowEvent ignored by reduce, type=" + r21.getType() + ", current=" + r2);
        d4().updateDraggingState(false);
        z3(r2);
        return;
    L62:
        va8.h r24 = this.N;
        if (r24 != null) goto L73;
        View r25 = this.F;
        if (r25 == null) goto L67;
        int r26 = r25.getHeight();
    L68:
        va8.h r27 = this.N;
        if (r27 == null) goto L71;
        int r28 = r27.c;
    L72:
        r24 = new va8.h(r2, r26, r28, ((AIFloatChatWindowStateVMState) d4().getState()).getFrom());
        goto L73
    L71:
        r28 = ((AIFloatChatWindowStateVMState) d4().getState()).getShowPercent();
        goto L72
    L67:
        r26 = 0;
    L73:
        Message r29 = r21.c;
        if (r29 != null) goto L76;
        r29 = ((AIFloatChatWindowStateVMState) d4().getState()).getAnchorMessage();
    L76:
        va8.j r30 = this.M;
        if (r30 == null) goto L80;
        FloatChatWindowState r31 = r30.b(r21, r24, r7);
        if (r31 == null) goto L80;
    L81:
        if (r31 == r7) goto L83;
        boolean r32 = true;
    L84:
        FloatChatWindowState r110 = FloatChatWindowState.Preview;
        if (r2 == r110) goto L104;
        if (r31 != r110) goto L104;
        g();
        if (this.W > 0) goto L98;
        ICoreInputAbility r111 = (ICoreInputAbility) this.o.getValue();
        if (r111 != null) goto L92;
    L94:
        boolean r112 = false;
    L95:
        if (r112 == true) goto L98;
        boolean r113 = false;
    L99:
        if (r113 == false) goto L104;
        ICoreInputAbility r114 = (ICoreInputAbility) this.o.getValue();
        if (r114 == null) goto L104;
        r114.C1(false, true, "ai_float_chat_enter_preview");
        goto L104
    L92:
        if (r111.E50() != true) goto L94;
        r112 = true;
    L98:
        r113 = true;
    L104:
        if (r31 == FloatChatWindowState.Collapsed) goto L106;
        if (r31 == r110) goto L106;
    L116:
        int r115 = W3(this, r31);
        if (r31 != r110) goto L119;
        int r116 = V3();
    L120:
        int r117 = v4(r31, r29, r116);
        if (r32 == true) goto L129;
        if (r31 != r110) goto L126;
        int r33 = com.larus.utils.m0.a;
        if (r117 <= (com.larus.utils.m0.a(getContext()) / 2)) goto L126;
        boolean r34 = true;
    L127:
        if (r34 == false) goto L129;
        boolean r35 = true;
    L130:
        if (r35 == false) goto L132;
        r31 = FloatChatWindowState.Expanded;
        r115 = W3(this, r31);
        int r118 = v4(r31, r29, r115);
        StringBuilder r119 = new StringBuilder("dispatchWindowEvent auto expand preview, previewHeight=");
        r119.append(r117);
        r119.append(", halfScreen=");
        int r120 = com.larus.utils.m0.a;
        r119.append(com.larus.utils.m0.a(getContext()) / 2);
        r3.i("AIFloatChatWindowStateComponent", r119.toString());
        int r121 = r118;
    L135:
        if (r115 <= 0) goto L137;
        this.H0 = r115;
    L137:
        int r122 = F4(r121);
        FloatChatWindowState r123 = FloatChatWindowState.Expanded;
        if (r31 == r123) goto L140;
    L142:
        va8.j r124 = this.M;
        if (r124 == null) goto L145;
        r124.a(r21, r24);
    L145:
        boolean r125 = true;
    L146:
        if (r125 == true) goto L149;
        r3.i("AIFloatChatWindowStateComponent", "dispatchWindowEvent blocked, event=" + r21 + ", current=" + r24);
        d4().updateDraggingState(false);
        z3(r2);
        return;
    L149:
        if (r31 != r123) goto L157;
        if (r35 == true) goto L156;
        if (r2 != r123) goto L157;
        if (((AIFloatChatWindowStateVMState) d4().getState()).getAutoExpandedFromPreview() == false) goto L157;
    L156:
        r18 = true;
    L157:
        r3.i("AIFloatChatWindowStateComponent", "dispatchWindowEvent, " + r2.name() + " -> " + r31.name() + ", height=" + r121 + ", autoExpandedFromPreview=" + r18);
        d4().updateWindowState(r31, r121, r122, r21.getType().getFrom(), r21.f, r29, r18);
        return;
    L140:
        if (this.Q == true) goto L142;
        r125 = false;
        goto L146
    L132:
        if (r31 != r110) goto L134;
        r117 = RangesKt.coerceAtMost((r117 + r115) - r116, X3());
    L134:
        r121 = r117;
    L126:
        r34 = false;
    L129:
        r35 = false;
        goto L130
    L119:
        r116 = r115;
    L106:
        IChatMessageShareAbility r126 = (IChatMessageShareAbility) this.t.getValue();
        if (r126 != null) goto L109;
    L111:
        boolean r127 = false;
    L112:
        if (r127 == false) goto L116;
        r3.i("AIFloatChatWindowStateComponent", "dispatchWindowEvent exit select mode before enter " + r31);
        IChatMessageShareAbility r128 = (IChatMessageShareAbility) this.t.getValue();
        if (r128 == null) goto L116;
        r128.j();
        goto L116
    L109:
        if (r126.H1() != true) goto L111;
        r127 = true;
        goto L112
    L83:
        r32 = false;
    L80:
        r31 = r7;
        goto L81
    L39:
        r3.e("AIFloatChatWindowStateComponent", "ExternalRequest cannot target Preview, ignore event=" + r21);
        goto L59
    L40:
        r3.e("AIFloatChatWindowStateComponent", "ExternalRequest targetState cannot be null, ignore event=" + r21);
        goto L59
    L35:
        r23 = b.a[r5.ordinal()];
        goto L36
    L51:
        r7 = FloatChatWindowState.Collapsed;
        goto L59
    L52:
        r7 = FloatChatWindowState.Collapsed;
        goto L59
    L53:
        r7 = FloatChatWindowState.Expanded;
        goto L59
    L57:
        r7 = r2;
        goto L59
    L58:
        r7 = FloatChatWindowState.Collapsed;
        goto L59
    L31:
        throw new NoWhenBranchMatchedException();
    L42:
        if (r2 != FloatChatWindowState.Preview) goto L44;
    L47:
        r7 = FloatChatWindowState.Collapsed;
        goto L59
    L44:
        if (r2 == FloatChatWindowState.Expanded) goto L46;
        r7 = r2;
        goto L59
    L46:
        if (((AIFloatChatWindowStateVMState) d4().getState()).getAutoExpandedFromPreview() == true) goto L47;
        r7 = r2;
        goto L59
    L49:
        if (r2 != FloatChatWindowState.Preview) goto L161;
        r7 = FloatChatWindowState.Expanded;
        goto L59
    L161:
        r7 = r2;
        goto L59
    L55:
        if (r2 != FloatChatWindowState.Collapsed) goto L162;
        r7 = FloatChatWindowState.Preview;
        goto L59
    L162:
        r7 = r2;
        goto L59
    L25:
        if (r20.isRunning() != true) goto L27;
        r22 = true;
        goto L28
    L21:
        r19 = false;
        goto L22
    L17:
        r17 = null;
        goto L18
    L13:
        r15 = null;
        goto L14
    L9:
        r13 = null;
        goto L10
    L5:
        r8 = null;
        goto L6
    }

    public final void m3(boolean r2) {
        xa8.a r0 = (xa8.a) this.r.getValue();
        if (r0 == null) goto L5;
        r0.H9(r2);
    L5:
        va8.w r1 = (va8.w) this.s.getValue();
        if (r1 == null) goto L9;
        r1.H9(r2);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onViewCreated(final View r15) {
        Intrinsics.checkNotNullParameter(r15, "view");
        this.F = r15;
        if ((r15 instanceof ChatConstraintLayout) == false) goto L5;
        ChatConstraintLayout r0 = (ChatConstraintLayout) r15;
    L6:
        this.G = r0;
        r15.addOnAttachStateChangeListener(this.L1);
        if (r15.isAttachedToWindow() == false) goto L10;
        this.L1.onViewAttachedToWindow(r15);
    L10:
        if ((r15 instanceof ShadowChatConstraintLayout) == false) goto L12;
        ChatConstraintLayout r1 = (ShadowChatConstraintLayout) r15;
    L13:
        if (r1 == null) goto L15;
        r1.addOnLayoutChangeListener(this.M1);
    L15:
        this.H = r15.findViewById(2131379994);
        this.I = r15.findViewById(2131389157);
        if ((r15 instanceof ViewGroup) == false) goto L18;
        ViewGroup r2 = (ViewGroup) r15;
    L19:
        boolean r3 = true;
        int r4 = 0;
        if (r2 == null) goto L33;
        int r5 = r2.getChildCount();
        int r6 = 0;
    L22:
        if (r6 >= r5) goto L33;
        View r7 = r2.getChildAt(r6);
        if (r7.getId() != 2131388843) goto L26;
        boolean r8 = true;
    L27:
        if (r8 == true) goto L30;
        r7 = null;
    L30:
        if (r7 != null) goto L34;
        r6 = r6 + 1;
    L34:
        this.J = r7;
        View r9 = this.F;
        if (r9 == null) goto L37;
        ViewParent r10 = r9.getParent();
    L39:
        if ((r10 instanceof ViewGroup) == false) goto L41;
        ViewGroup r11 = (ViewGroup) r10;
    L42:
        if (r11 == null) goto L44;
        r11.setClipChildren(false);
        r11.setClipToPadding(false);
    L44:
        View r12 = this.F;
        if (r12 == null) goto L47;
        ViewGroup.LayoutParams r13 = r12.getLayoutParams();
    L49:
        if ((r13 instanceof FrameLayout.LayoutParams) == false) goto L53;
        ((FrameLayout.LayoutParams) r13).gravity = 80;
        View r14 = this.F;
        if (r14 == null) goto L60;
        r14.setLayoutParams(r13);
    L60:
        ChatConstraintLayout r16 = this.G;
        if (r16 == null) goto L64;
        this.V = r16.getInterruptBottomPaddingUpdate();
        r16.setInterruptBottomPaddingUpdate(new x0(this));
    L64:
        l4();
        ChatConstraintLayout r17 = this.G;
        if (r17 == null) goto L68;
        this.U = r17.getOnImePaddingUpdate();
        r17.setOnImePaddingUpdate(new n0(this));
    L68:
        Intrinsics.checkNotNullParameter(this, "<this>");
        Bundle r18 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getArguments();
        if (r18 == null) goto L88;
        String r19 = r18.getString("initial_window_state");
        if (r19 == null) goto L88;
        Result.Companion r20 = Result.Companion;     // Catch: Throwable -> L75
        Object r21 = Result.constructor-impl(FloatChatWindowState.valueOf(r19));     // Catch: Throwable -> L75
    L78:
        if (Result.isFailure-impl(r21) == false) goto L80;
        r21 = null;
    L80:
        FloatChatWindowState r22 = (FloatChatWindowState) r21;
        if (r22 == null) goto L88;
        if (r22 != FloatChatWindowState.Preview) goto L86;
        r3 = false;
    L86:
        if (r3 == false) goto L88;
        FloatChatWindowState r23 = r22;
    L89:
        if (r23 == null) goto L92;
        int r24 = v4(r23, null, W3(this, r23));
        AIFloatChatWindowStateVM.updateWindowState$default(d4(), r23, r24, F4(r24), FloatChatWindowEventType.Init.getFrom(), false, null, false, 64, null);
    L92:
        D3((AIFloatChatWindowStateVMState) d4().getState());
        ComponentViewModel.onEach$default(d4(), null, null, new AIFloatChatWindowStateComponent$bindState$1(this, null), 3, null);
        View r25 = this.I;
        if (r25 == null) goto L95;
        r4 = ViewConfiguration.get(r25.getContext()).getScaledTouchSlop();
    L95:
        View r26 = this.I;
        if (r26 == null) goto L98;
        r26.setOnTouchListener(new z0(this, r4));
    L98:
        x4();
        va8.p r27 = (va8.p) this.m.getValue();
        if (r27 == null) goto L101;
        r27.rW(new m0(this));
    L101:
        r15.post(new r0(this, r15));
        return;
    L75:
        th = move-exception;
        Result.Companion r28 = Result.Companion;
        r21 = Result.constructor-impl(ResultKt.createFailure(th));
    L88:
        r23 = null;
        goto L89
    L53:
        View r29 = this.F;
        if (r29 == null) goto L60;
        if (r13 == null) goto L58;
        int r30 = r13.height;
    L59:
        r29.setLayoutParams(new FrameLayout.LayoutParams(-1, r30, 80));
        goto L60
    L58:
        r30 = -2;
        goto L59
    L47:
        r13 = null;
        goto L49
    L41:
        r11 = null;
        goto L42
    L37:
        r10 = null;
        goto L39
    L26:
        r8 = false;
    L33:
        r7 = null;
        goto L34
    L18:
        r2 = null;
        goto L19
    L12:
        r1 = null;
        goto L13
    L5:
        r0 = null;
        goto L6
    }

    public final void p3(int r4) {
        boolean r1 = false;
        if (i4() == true) goto L7;
        this.h1 = false;
        E3();
        W4(255);
        return;
    L7:
        if (this.h1 == true) goto L17;
        ValueAnimator r0 = this.b1;
        if (r0 != null) goto L11;
    L13:
        if (r1 == true) goto L18;
        W4(B4(r4));
        return;
    L18:
        return;
    L11:
        if (r0.isRunning() != true) goto L13;
        r1 = true;
        goto L13
    }

    public final void xf(va8.i r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        if (this.v.contains(r2) == false) goto L5;
        return;
    L5:
        this.v.add(r2);
    }

    public final void z3(FloatChatWindowState r3) {
        View r0 = this.J;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.B == true) goto L7;
    L9:
        int r4 = 8;
    L10:
        r0.setVisibility(r4);
        r0.setAlpha(1.0f);
        return;
    L7:
        if (r3 != FloatChatWindowState.Expanded) goto L9;
        r4 = 0;
        goto L10
    }

    public final void z40(va8.i r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.v.remove(r2);
    }

    public static int W3(AIFloatChatWindowStateComponent r3, FloatChatWindowState r4) {
        int r0 = Math.max(r3.X, r3.H3());
        r3.getClass();
        int r2 = 0;
        if (r4 == FloatChatWindowState.Expanded) goto L5;
        boolean r5 = true;
    L6:
        if (r5 == false) goto L9;
        r2 = r3.W;
    L9:
        return (r3.V3() + r0) + r2;
    L5:
        r5 = false;
        goto L6
    }

    public static final void Y2(AIFloatChatWindowStateComponent r2, int r3) {
        float r0 = r2.G4(r3);
        r2.C3(r3);
        if (Float.isNaN(r2.x1) == false) goto L5;
    L7:
        r2.x1 = r0;
        Iterator<va8.i> r4 = r2.v.iterator();
    L9:
        if (r4.hasNext() == false) goto L13;
        r4.next().LS(r0);
        goto L9
    L13:
        return;
    L5:
        if (Math.abs(r0 - r2.x1) >= 0.001f) goto L7;
    }

    public final int Q3(FloatChatWindowState r5, int r6) {
        if (r6 <= 0) goto L4;
        int r7 = r6 + e4(r5);
    L5:
        Integer r8 = Integer.valueOf(r7);
        boolean r1 = false;
        if (r8.intValue() <= 0) goto L8;
        boolean r0 = true;
    L9:
        Integer r3 = null;
        if (r0 == true) goto L13;
        r8 = null;
    L13:
        if (r8 != null) goto L26;
        View r9 = this.F;
        if (r9 == null) goto L25;
        Integer r10 = Integer.valueOf(r9.getHeight());
        if (r10.intValue() <= 0) goto L20;
        r1 = true;
    L20:
        if (r1 == false) goto L22;
        r3 = r10;
    L22:
        if (r3 == null) goto L25;
        return r3.intValue();
    L25:
        return e4(r5);
    L26:
        return r8.intValue();
    L8:
        r0 = false;
        goto L9
    L4:
        r7 = -2;
        goto L5
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v2, types: [com.larus.business.floatchat.impl.component.y0, java.lang.Runnable] */
    public final void R4(final String r6, boolean r7) {
        final View r0 = this.F;
        if (r0 != 0) goto L6;
        return;
    L6:
        if (this.p0 == true) goto L10;
        if (r7 == true) goto L10;
        boolean r1 = false;
    L11:
        this.p0 = r1;
        if (this.k0 == null) goto L15;
        FLogger.a.i("AIFloatChatWindowStateComponent", r6 + " skipped, reason=pendingInputLayoutHeightSync, force=" + r7);
        return;
    L15:
        FLogger.a.i("AIFloatChatWindowStateComponent", r6 + " entry, force=" + r7);
        ?? r8 = new y0(this, r0, r6);
        this.k0 = r8;
        r0.post(r8);
        return;
    L10:
        r1 = true;
        goto L11
    }

    public final void T4(String r21, boolean r22) {
        l4();
        if (((AIFloatChatWindowStateVMState) d4().getState()).isDragging() == false) goto L5;
    L53:
        FLogger.a.i("AIFloatChatWindowStateComponent", r21 + " skipped, reason=draggingOrExpanded, force=" + r22);
        return;
    L5:
        if (getWindowState() == FloatChatWindowState.Expanded) goto L53;
        int r3 = W3(this, getWindowState());
        if (r3 > 0) goto L11;
        FLogger.a.i("AIFloatChatWindowStateComponent", r21 + " skipped, reason=invalidInputHeight, force=" + r22 + ", inputTopToBottom=" + r3);
        return;
    L11:
        if (r22 == false) goto L13;
    L16:
        FLogger r2 = FLogger.a;
        r2.i("AIFloatChatWindowStateComponent", r21 + " syncCurrentWindowHeight entry, inputTopToBottom=" + r3);
        l4();
        FloatChatWindowState r5 = getWindowState();
        FloatChatWindowState r6 = FloatChatWindowState.Preview;
        boolean r7 = true;
        int r8 = 0;
        if (r5 == r6) goto L19;
    L21:
        boolean r9 = false;
    L22:
        if (r9 == false) goto L24;
        int r10 = V3();
    L25:
        int r11 = v4(r5, ((AIFloatChatWindowStateVMState) d4().getState()).getAnchorMessage(), r10);
        if (r9 == false) goto L37;
        if (r5 != r6) goto L31;
        int r12 = com.larus.utils.m0.a;
        if (r11 <= (com.larus.utils.m0.a(getContext()) / 2)) goto L31;
        boolean r13 = true;
    L32:
        if (r13 == false) goto L36;
        StringBuilder r14 = new StringBuilder();
        r14.append(r21);
        r14.append(" dispatch rebound to auto expand preview, previewHeight=");
        r14.append(r11);
        r14.append(", halfScreen=");
        int r15 = com.larus.utils.m0.a;
        r14.append(com.larus.utils.m0.a(getContext()) / 2);
        r2.i("AIFloatChatWindowStateComponent", r14.toString());
        hn(new va8.f(FloatChatWindowEventType.Rebound, null, null, null, null, false, 30));
        if (getWindowState() == r5) goto L36;
        return;
    L36:
        r11 = RangesKt.coerceAtMost((r11 + r3) - r10, X3());
    L31:
        r13 = false;
    L37:
        if (r3 <= 0) goto L39;
        this.H0 = r3;
    L39:
        r2.i("AIFloatChatWindowStateComponent", r21 + ", state=" + r5 + ", inputArea=" + r3 + ", target=" + r11 + ", inputContent=" + V3() + ", imePadding=" + this.X + ", rootPadding=" + H3() + ", bottomMenu=" + this.W);
        G3(true);
        d5(r11);
        FloatChatWindowState r1 = getWindowState();
        Integer r4 = Integer.valueOf(r11);
        if (r4.intValue() > 0) goto L43;
        r7 = false;
    L43:
        if (r7 == true) goto L46;
        r4 = null;
    L46:
        if (r4 == null) goto L48;
        r8 = r4.intValue();
    L51:
        getWindowState();
        this.N = new va8.h(r1, r8, F4(r11), ((AIFloatChatWindowStateVMState) d4().getState()).getFrom());
        return;
    L48:
        View r16 = this.F;
        if (r16 == null) goto L51;
        r8 = r16.getHeight();
        goto L51
    L24:
        r10 = r3;
        goto L25
    L19:
        if (this.y1 == false) goto L21;
        r9 = true;
        goto L22
    L13:
        if (r3 != this.H0) goto L16;
        FLogger.a.i("AIFloatChatWindowStateComponent", r21 + " skipped, reason=sameInputHeight, force=" + r22 + ", inputTopToBottom=" + r3);
    }

    public final void p4(va8.h r8, Message r9) {
        if (this.P == true) goto L6;
        FLogger.a.i("AIFloatChatWindowStateComponent", "skip chat_module_show, chat module invisible, snapshot=" + r8);
        return;
    L6:
        String r0 = r8.d;
        if (Intrinsics.areEqual(r0, FloatChatWindowEventType.ManualDragUp.getFrom()) == false) goto L9;
    L22:
        String r1 = "slide";
    L23:
        String r3 = null;
        if (Intrinsics.areEqual(r1, "reply") == false) goto L34;
        if (r9 == null) goto L34;
        String r10 = r9.getMessageId();
        if (r10 == null) goto L34;
        if (r10.length() <= 0) goto L31;
        boolean r2 = true;
    L32:
        if (r2 == false) goto L34;
    L35:
        ew8.b r4 = (ew8.b) this.q.getValue();
        if (r4 == null) goto L38;
        r3 = r4.getPageName();
    L38:
        int r5 = RangesKt.coerceIn(MathKt.roundToInt(r8.c / 10.0f), 0, 10);
        String r11 = r8.a + '_' + r8.b + '_' + r10 + '_' + r3;
        if (Intrinsics.areEqual(this.O, r11) == false) goto L41;
        return;
    L41:
        this.O = r11;
        JSONObject r12 = new JSONObject();
        Intrinsics.checkNotNullParameter(r1, "actionType");
        Intrinsics.checkNotNullParameter(r12, "params");
        r12.put("show_level", RangesKt.coerceIn(r5, 0, 10));     // Catch: JSONException -> L48
        r12.put("action_type", r1);     // Catch: JSONException -> L48
        if (r10 == null) goto L45;
        r12.put(MusicAppletPage.KEY_MESSAGE_ID, r10);     // Catch: JSONException -> L48
    L45:
        if (r3 == null) goto L50;
        r12.put("current_page", r3);     // Catch: JSONException -> L48
    L50:
        TrackParams r13 = new TrackParams().merge(r12);
        by7.a r14 = new by7.a("chat_module_show");
        r14.a.merge(r13);
        r14.b();
        return;
    L48:
        e = move-exception;
        FLogger.a.e("ChatModuleEventHelper", "error in ChatModuleEventHelper chatModuleShow " + e.getLocalizedMessage());
        goto L50
    L31:
        r2 = false;
    L34:
        r10 = null;
        goto L35
    L9:
        if (Intrinsics.areEqual(r0, FloatChatWindowEventType.ManualDragDown.getFrom()) == true) goto L22;
        if (Intrinsics.areEqual(r0, FloatChatWindowEventType.Rebound.getFrom()) == true) goto L22;
        if (Intrinsics.areEqual(r0, FloatChatWindowEventType.SendSuccess.getFrom()) == false) goto L16;
    L21:
        r1 = "reply";
        goto L23
    L16:
        if (Intrinsics.areEqual(r0, FloatChatWindowEventType.AnswerIntent.getFrom()) == true) goto L21;
        if (Intrinsics.areEqual(r0, FloatChatWindowEventType.RefreshPageIntent.getFrom()) == true) goto L21;
        r1 = "default";
        goto L23
    }

    public final void sy(int r6, int r7) {
        final int r0 = RangesKt.coerceAtLeast(r6, 0);
        this.W = r0;
        FLogger.a.i("AIFloatChatWindowStateComponent", "onBottomMenuHeightChanged entry, cur=" + r6 + ", normal=" + r7 + ", coerced=" + r0);
        StringBuilder r1 = new StringBuilder("onBottomMenuHeightChanged, cur=");
        r1.append(r6);
        r1.append(", normal=");
        r1.append(r7);
        R4(r1.toString(), true);
        View r8 = this.F;
        if (r8 == null) goto L6;
        r8.post(new p0(this, r0));
        return;
    }

    public final int q4(FloatChatWindowState r5, Message r6, int r7) {
        Integer r8 = Integer.valueOf(r7);
        boolean r1 = false;
        if (r8.intValue() <= 0) goto L5;
        boolean r0 = true;
    L6:
        Integer r3 = null;
        if (r0 == true) goto L10;
        r8 = null;
    L10:
        if (r8 != null) goto L21;
        Integer r9 = Integer.valueOf(v4(r5, r6, W3(this, r5)));
        if (r9.intValue() <= 0) goto L15;
        r1 = true;
    L15:
        if (r1 == false) goto L17;
        r3 = r9;
    L17:
        if (r3 == null) goto L20;
        return r3.intValue();
    L20:
        return Q3(r5, W3(this, r5));
    L21:
        return r8.intValue();
    L5:
        r0 = false;
        goto L6
    }

    public final int v4(FloatChatWindowState r9, Message r10, int r11) {
        int r0 = X3();
        int r1 = b.a[r9.ordinal()];
        if (r1 != 1) goto L5;
        int r2 = Q3(r9, r11);
        va8.e r3 = this.L;
        if (r3 == null) goto L18;
        int r4 = r3.H(r10);
    L19:
        int r5 = RangesKt.coerceAtMost(RangesKt.coerceAtLeast(r2 + r4, r2), r0);
        int r6 = r4;
        int r7 = r5;
    L20:
        FLogger r8 = FLogger.a;
        StringBuilder r12 = new StringBuilder("resolveHeight, state=");
        r12.append(r9);
        r12.append(", result=");
        r12.append(r7);
        r12.append(", inputArg=");
        r12.append(r11);
        r12.append(", effectiveInput=");
        r12.append(r11);
        r12.append(", inputContent=");
        r12.append(V3());
        r12.append(", dynamicInset=");
        r12.append(Math.max(this.X, H3()));
        r12.append(", imePadding=");
        r12.append(this.X);
        r12.append(", rootPadding=");
        r12.append(H3());
        r12.append(", bottomMenu=");
        r12.append(this.W);
        r12.append(", collapsed=");
        r12.append(r2);
        r12.append(", previewList=");
        r12.append(r6);
        r12.append(", expanded=");
        r12.append(r0);
        r12.append(", anchor=");
        if (r10 == null) goto L23;
        String r13 = k4(r10);
    L24:
        r12.append(r13);
        r8.i("AIFloatChatWindowStateComponent", r12.toString());
        return r7;
    L23:
        r13 = null;
        goto L24
    L18:
        r4 = this.z;
        goto L19
    L5:
        if (r1 != 2) goto L7;
        if (r11 <= 0) goto L13;
        r7 = e4(r9) + r11;
    L14:
        r2 = 0;
        r6 = 0;
        goto L20
    L13:
        r7 = -2;
        goto L14
    L7:
        if (r1 != 3) goto L10;
        r7 = r0;
        goto L14
    L10:
        throw new NoWhenBranchMatchedException();
    }

    public static boolean h4(View r4, float r5, float r6, Rect r7) {
        if (r4.isShown() == true) goto L5;
    L27:
        return false;
    L5:
        if (r4.isEnabled() == false) goto L27;
        if (r4.getAlpha() <= 0.0f) goto L27;
        if (r4.getGlobalVisibleRect(r7) == false) goto L27;
        if (r7.contains(MathKt.roundToInt(r5), MathKt.roundToInt(r6)) == false) goto L27;
        if ((r4 instanceof ViewGroup) == false) goto L23;
        ViewGroup r0 = (ViewGroup) r4;
        int r2 = r0.getChildCount() - 1;
    L17:
        if ((-1) >= r2) goto L23;
        if (h4(r0.getChildAt(r2), r5, r6, r7) == true) goto L20;
        r2 = r2 - 1;
        goto L17
    L20:
        return true;
    L23:
        if (r4.isClickable() == false) goto L25;
        return true;
    L25:
        if (r4.hasOnClickListeners() == false) goto L27;
        return true;
    }
}
