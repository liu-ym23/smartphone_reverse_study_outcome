package com.larus.bmhome.chat.layout.item;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.GridLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.view.OneShotPreDrawListener;
import androidx.core.view.ViewGroupKt;
import androidx.core.widget.TextViewCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.larus.bmhome.auth.OnboardingActionCardData;
import com.larus.bmhome.auth.OnboardingActionCardItemData;
import com.larus.bmhome.chat.bean.PromptContent;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.layout.widget.MessageLoading;
import com.larus.bmhome.chat.layout.widget.PromptCellLoading;
import com.larus.bmhome.chat.layout.widget.WcbSkeletonLoadingView;
import com.larus.bmhome.chat.list.cell.prompt.WcbItemLinearLayout;
import com.larus.bmhome.chat.model.ChatDraftItem;
import com.larus.bmhome.view.TitleAvatarImageView;
import com.larus.bmhome.view.textview.impl.CustomMarkdownTextView;
import com.larus.common_ui.view.GradientMaskView;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.platform.spi.IAIChatControlTraceService;
import com.larus.suggest.impl.databinding.LarusCardSuggestGridItemBinding;
import com.larus.suggest.impl.databinding.LarusItemSuggestPromptEntryHolderBinding;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import v19.c6;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000Û\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0013\u0018\u0000 é\u00012\u00020\u00012\u00020\u0002:\u0004é\u0001ê\u0001B)\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\b\u0010f\u001a\u00020\bH\u0002J\b\u0010g\u001a\u00020\bH\u0002J\b\u0010h\u001a\u00020\bH\u0002J\b\u0010i\u001a\u00020\bH\u0002J\b\u0010j\u001a\u00020\bH\u0002J\u0010\u0010k\u001a\u00020?2\b\b\u0002\u0010l\u001a\u00020\fJ\u0016\u0010m\u001a\u00020?2\u0006\u0010n\u001a\u00020\f2\u0006\u0010o\u001a\u00020\bJ\u0010\u0010p\u001a\u00020?2\u0006\u0010q\u001a\u00020\bH\u0016J\b\u0010r\u001a\u00020?H\u0002J\u0006\u0010s\u001a\u00020?J$\u0010t\u001a\u00020?2\b\b\u0002\u0010u\u001a\u00020\f2\b\b\u0002\u0010v\u001a\u00020\b2\b\b\u0002\u0010#\u001a\u00020\fJ0\u0010w\u001a\u00020?2\b\b\u0002\u0010u\u001a\u00020\f2\b\b\u0002\u0010v\u001a\u00020\b2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'2\b\b\u0002\u0010#\u001a\u00020\fJ\u0006\u0010x\u001a\u00020?J\u0006\u0010$\u001a\u00020\fJ\u0006\u0010y\u001a\u00020\bJÂ\u0001\u0010z\u001a\u00020?2\u0006\u0010&\u001a\u00020'2\b\u00108\u001a\u0004\u0018\u0001092\b\u0010:\u001a\u0004\u0018\u00010;2\u0006\u0010{\u001a\u00020\f2\b\u0010B\u001a\u0004\u0018\u00010C2\u001e\u0010<\u001a\u001a\u0012\u0004\u0012\u00020>\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020?0=2\b\u00107\u001a\u0004\u0018\u00010,2\n\b\u0002\u0010|\u001a\u0004\u0018\u00010,2\b\b\u0002\u0010}\u001a\u00020\f2\n\b\u0002\u0010~\u001a\u0004\u0018\u00010,2\u0010\b\u0002\u0010@\u001a\n\u0012\u0004\u0012\u00020?\u0018\u00010A2\b\b\u0002\u0010u\u001a\u00020\f2\b\b\u0002\u0010v\u001a\u00020\b2\b\b\u0002\u0010#\u001a\u00020\f2\n\b\u0002\u0010\u007f\u001a\u0004\u0018\u00010\f¢\u0006\u0003\u0010\u0080\u0001J\r\u0010\u0081\u0001\u001a\u00020,*\u00020'H\u0002J\r\u0010\u0082\u0001\u001a\u00020,*\u00020'H\u0002J\u0014\u0010\u0083\u0001\u001a\u00020?2\t\b\u0002\u0010\u0084\u0001\u001a\u00020\fH\u0002J\t\u0010\u0085\u0001\u001a\u00020?H\u0002J\u0011\u0010\u0086\u0001\u001a\u00020?2\u0006\u0010n\u001a\u00020\fH\u0002J\u0011\u0010\u0087\u0001\u001a\u00020?2\u0006\u0010&\u001a\u00020'H\u0002J\t\u0010\u0088\u0001\u001a\u00020?H\u0002J\t\u0010\u0089\u0001\u001a\u00020\bH\u0002J\u0019\u0010\u008a\u0001\u001a\u00030\u008b\u00012\r\u0010\u008c\u0001\u001a\b\u0012\u0004\u0012\u00020*0)H\u0002J\t\u0010\u008d\u0001\u001a\u00020?H\u0002J\u0018\u0010\u008e\u0001\u001a\u00020?2\r\u0010\u008c\u0001\u001a\b\u0012\u0004\u0012\u00020*0)H\u0002J\u0018\u0010\u008f\u0001\u001a\u00020?2\r\u0010\u008c\u0001\u001a\b\u0012\u0004\u0012\u00020K0)H\u0002J\u001b\u0010\u0090\u0001\u001a\u00020\u00182\u0007\u0010\u0091\u0001\u001a\u00020\b2\u0007\u0010\u0092\u0001\u001a\u00020KH\u0002J\u001b\u0010\u0093\u0001\u001a\u00020\u00182\u0007\u0010\u0091\u0001\u001a\u00020\b2\u0007\u0010\u0092\u0001\u001a\u00020KH\u0002J7\u0010\u0094\u0001\u001a\u00030\u0095\u00012\u0007\u0010\u0091\u0001\u001a\u00020\b2\u0007\u0010\u0092\u0001\u001a\u00020K2\u0007\u0010\u0096\u0001\u001a\u00020,2\u0007\u0010\u0097\u0001\u001a\u00020\f2\u0007\u0010\u0098\u0001\u001a\u00020\fH\u0002J6\u0010\u0099\u0001\u001a\u00020\u00012\u0007\u0010\u0091\u0001\u001a\u00020\b2\u0007\u0010\u0092\u0001\u001a\u00020K2\u0007\u0010\u0096\u0001\u001a\u00020,2\u0007\u0010\u0097\u0001\u001a\u00020\f2\u0007\u0010\u0098\u0001\u001a\u00020\fH\u0002J\u001b\u0010\u009a\u0001\u001a\u00020\u00012\u0007\u0010\u0092\u0001\u001a\u00020K2\u0007\u0010\u0097\u0001\u001a\u00020\fH\u0002J\t\u0010\u009b\u0001\u001a\u00020?H\u0002J\u0018\u0010\u009c\u0001\u001a\u00020?2\r\u0010\u008c\u0001\u001a\b\u0012\u0004\u0012\u00020,0)H\u0002JB\u0010\u009d\u0001\u001a\u00020?2\r\u0010\u008c\u0001\u001a\b\u0012\u0004\u0012\u00020*0)2\u0006\u0010h\u001a\u00020\b2 \u0010<\u001a\u001c\u0012\u0004\u0012\u00020>\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020?\u0018\u00010=H\u0002JF\u0010\u009e\u0001\u001a\u00020?2\r\u0010\u008c\u0001\u001a\b\u0012\u0004\u0012\u00020*0)2\u0007\u0010\u009f\u0001\u001a\u00020\b2\u0007\u0010 \u0001\u001a\u00020\b2\u001a\u0010¡\u0001\u001a\u0015\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\u00180¢\u0001H\u0002J\u0018\u0010£\u0001\u001a\u00020?2\r\u0010\u008c\u0001\u001a\b\u0012\u0004\u0012\u00020*0)H\u0002J=\u0010¤\u0001\u001a\u00020?2\u0007\u0010¥\u0001\u001a\u00020\b2\b\u0010:\u001a\u0004\u0018\u00010;2\u001f\u0010<\u001a\u001b\u0012\u0005\u0012\u00030¦\u0001\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020?0=H\u0002J\u001d\u0010§\u0001\u001a\u00020?2\b\u0010¨\u0001\u001a\u00030¦\u00012\b\u0010©\u0001\u001a\u00030ª\u0001H\u0002J2\u0010I\u001a\u00020?2*\u0010<\u001a&\u0012\u0004\u0012\u00020\u0018\u0012\u0006\u0012\u0004\u0018\u00010K\u0012\u0006\u0012\u0004\u0018\u00010*\u0012\u0006\u0012\u0004\u0018\u00010L\u0012\u0004\u0012\u00020?0JJ\u001c\u0010M\u001a\u00020?2\u0014\u0010<\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010,\u0012\u0004\u0012\u00020?0NJ\u0013\u0010«\u0001\u001a\u00020\f2\b\u0010¬\u0001\u001a\u00030\u00ad\u0001H\u0016J\u001c\u0010Q\u001a\u00020?2\u0014\u0010<\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010*\u0012\u0004\u0012\u00020?0NJ\u001c\u0010R\u001a\u00020?2\u0014\u0010<\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010*\u0012\u0004\u0012\u00020?0NJ\u001c\u0010S\u001a\u00020?2\u0014\u0010<\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010*\u0012\u0004\u0012\u00020?0NJ\u0014\u0010T\u001a\u00020?2\f\u0010<\u001a\b\u0012\u0004\u0012\u00020?0AJ\u000e\u0010U\u001a\u00020?2\u0006\u0010<\u001a\u00020VJ\u000f\u0010®\u0001\u001a\u00020?2\u0006\u0010W\u001a\u00020XJ7\u0010¯\u0001\u001a\u00030\u0095\u00012\u0007\u0010°\u0001\u001a\u00020,2\t\b\u0002\u0010±\u0001\u001a\u00020\f2\t\b\u0002\u0010\u0098\u0001\u001a\u00020\f2\f\b\u0002\u0010²\u0001\u001a\u0005\u0018\u00010³\u0001H\u0002J\u0013\u0010´\u0001\u001a\u00020?2\b\u0010µ\u0001\u001a\u00030\u0095\u0001H\u0002J/\u0010¶\u0001\u001a\u00030·\u00012\u0007\u0010¸\u0001\u001a\u00020*2\u0007\u0010¹\u0001\u001a\u00020\b2\u0007\u0010\u0097\u0001\u001a\u00020\f2\b\u0010º\u0001\u001a\u00030\u008b\u0001H\u0003J\u0018\u0010»\u0001\u001a\u0005\u0018\u00010¼\u00012\n\u0010½\u0001\u001a\u0005\u0018\u00010¾\u0001H\u0002J\u001c\u0010¿\u0001\u001a\u00020?2\b\u0010À\u0001\u001a\u00030Á\u00012\u0007\u0010Â\u0001\u001a\u00020\bH\u0002J\u001a\u0010Ã\u0001\u001a\u0005\u0018\u00010Ä\u0001*\u00030¾\u00012\u0007\u0010Å\u0001\u001a\u00020,H\u0002J\u001c\u0010Æ\u0001\u001a\u00020?2\u0007\u0010Ç\u0001\u001a\u00020*2\b\u0010È\u0001\u001a\u00030·\u0001H\u0002J%\u0010É\u0001\u001a\u00020?2\b\u0010Ê\u0001\u001a\u00030Ë\u00012\t\u0010Ì\u0001\u001a\u0004\u0018\u00010,2\u0007\u0010Í\u0001\u001a\u00020\fJ\u0015\u0010Î\u0001\u001a\u0005\u0018\u00010³\u00012\u0007\u0010¸\u0001\u001a\u00020*H\u0002J\u001a\u0010Ï\u0001\u001a\u0004\u0018\u00010\b2\u0007\u0010¸\u0001\u001a\u00020*H\u0002¢\u0006\u0003\u0010Ð\u0001J\u001a\u0010Ñ\u0001\u001a\u0004\u0018\u00010\b2\u0007\u0010¸\u0001\u001a\u00020KH\u0002¢\u0006\u0003\u0010Ò\u0001J\f\u0010Ó\u0001\u001a\u0005\u0018\u00010³\u0001H\u0002J\u0015\u0010Ô\u0001\u001a\u0005\u0018\u00010³\u00012\u0007\u0010Õ\u0001\u001a\u00020\bH\u0002J*\u0010Ö\u0001\u001a\u0005\u0018\u00010³\u00012\n\u0010×\u0001\u001a\u0005\u0018\u00010Ø\u00012\n\u0010Ù\u0001\u001a\u0005\u0018\u00010Ú\u0001H\u0002¢\u0006\u0003\u0010Û\u0001J\u0018\u0010Ü\u0001\u001a\u00020?2\r\u0010Ý\u0001\u001a\b\u0012\u0004\u0012\u00020?0AH\u0002J\t\u0010Þ\u0001\u001a\u00020\bH\u0002J3\u0010ß\u0001\u001a.\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u00170\u0016j\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0017`\u001aJ\u0017\u0010à\u0001\u001a\u0012\u0012\u0004\u0012\u00020\u00180\u0016j\b\u0012\u0004\u0012\u00020\u0018`\u001aJ\u0006\u0010\u001f\u001a\u00020\fJ\u0006\u0010 \u001a\u00020\fJ\t\u0010á\u0001\u001a\u00020\u0011H\u0002J\t\u0010â\u0001\u001a\u00020\u0011H\u0002J\t\u0010ã\u0001\u001a\u00020\bH\u0002J\u000b\u0010ä\u0001\u001a\u0004\u0018\u00010eH\u0002J\t\u0010å\u0001\u001a\u00020?H\u0014J\u0015\u0010æ\u0001\u001a\u00020?2\n\u0010ç\u0001\u001a\u0005\u0018\u00010è\u0001H\u0014R\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000b\u0010\rR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0014R:\u0010\u0015\u001a.\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u00170\u0016j\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0017`\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u00180\u0016j\b\u0012\u0004\u0012\u00020\u0018`\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010(\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010.\u001a\b\u0012\u0004\u0012\u00020,0\u001d¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0010\u00100\u001a\u0004\u0018\u00010,X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u0004\u0018\u00010,X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00102\u001a\u0004\u0018\u00010,X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u000204X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u000206X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u00107\u001a\u0004\u0018\u00010,X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00108\u001a\u0004\u0018\u000109X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010:\u001a\u0004\u0018\u00010;X\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010<\u001a\u001c\u0012\u0004\u0012\u00020>\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020?\u0018\u00010=X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010@\u001a\n\u0012\u0004\u0012\u00020?\u0018\u00010AX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010B\u001a\u0004\u0018\u00010CX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010D\u001a\n\u0012\u0004\u0012\u00020?\u0018\u00010AX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR4\u0010I\u001a(\u0012\u0004\u0012\u00020\u0018\u0012\u0006\u0012\u0004\u0018\u00010K\u0012\u0006\u0012\u0004\u0018\u00010*\u0012\u0006\u0012\u0004\u0018\u00010L\u0012\u0004\u0012\u00020?\u0018\u00010JX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010M\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010,\u0012\u0004\u0012\u00020?\u0018\u00010NX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010O\u001a\u00020PX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010Q\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010*\u0012\u0004\u0012\u00020?\u0018\u00010NX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010R\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010*\u0012\u0004\u0012\u00020?\u0018\u00010NX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010S\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010*\u0012\u0004\u0012\u00020?\u0018\u00010NX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010T\u001a\n\u0012\u0004\u0012\u00020?\u0018\u00010AX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010U\u001a\u0004\u0018\u00010VX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010W\u001a\u0004\u0018\u00010XX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010Y\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010^\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R\u001a\u0010_\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u0010\r\"\u0004\b`\u0010aR\u000e\u0010b\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010c\u001a\n\u0012\u0004\u0012\u00020e\u0018\u00010dX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006ë\u0001"}, d2 = {"Lcom/larus/bmhome/chat/layout/item/PromptSpan;", "Landroid/widget/LinearLayout;", "Lcom/larus/bmhome/chat/cell/view/ContainerWidthChangeAware;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;Ljava/lang/Integer;)V", "isDarkMode", "", "()Z", "isDarkMode$delegate", "Lkotlin/Lazy;", "messageLoading", "Lcom/larus/bmhome/chat/layout/widget/MessageLoading;", "clickListener", "com/larus/bmhome/chat/layout/item/PromptSpan$clickListener$1", "Lcom/larus/bmhome/chat/layout/item/PromptSpan$clickListener$1;", "suggestViewList", "Ljava/util/ArrayList;", "Lkotlin/Pair;", "Landroid/view/View;", "Lcom/larus/bmhome/chat/layout/item/PromptSpan$Companion$PromptInfo;", "Lkotlin/collections/ArrayList;", "botViews", "markdownTextViews", "", "Lcom/larus/bmhome/view/textview/impl/CustomMarkdownTextView;", "isUseNewStyle", "isMultiOneLineStyle", "shouldFillViewportAndAlignBottom", "viewportMinHeight", "useWhiteBackground", "isLoading", "cinitIsLoad", "content", "Lcom/larus/bmhome/chat/bean/PromptContent;", "selectedCategoryChildren", "", "Lcom/larus/bmhome/chat/bean/PromptContent$SuggestItem;", "selectedCategoryTitle", "", "categorySwitchAnimationToken", "isRiskFilteredSug", "()Ljava/util/Set;", "lastContentKey", "lastContentSignature", "lastNextPulseScene", "promptSpanAppearAnimator", "Lcom/larus/bmhome/chat/layout/item/PromptSpanAppearAnimator;", "refreshAnimator", "Lcom/larus/bmhome/chat/layout/item/PromptSpanRefreshAnimator;", "actionBarKey", "cardScene", "Lcom/larus/bmhome/auth/OnboardingActionCardData$CardScene;", "cardData", "Lcom/larus/bmhome/auth/OnboardingActionCardData;", "listener", "Lkotlin/Function3;", "", "", "promptItemsUpdatedListener", "Lkotlin/Function0;", "expandBtnClickListener", "Landroid/view/View$OnClickListener;", "onSkillCardShow", "getOnSkillCardShow", "()Lkotlin/jvm/functions/Function0;", "setOnSkillCardShow", "(Lkotlin/jvm/functions/Function0;)V", "onPromptSelected", "Lkotlin/Function4;", "Lcom/larus/bmhome/chat/bean/PromptContent$SuggestV2;", "Lcom/larus/bmhome/chat/bean/PromptContent$SuggestV2ExtraForMultiAction;", "onPromptActionDown", "Lkotlin/Function1;", "promptItemTouchRect", "Landroid/graphics/Rect;", "onPromptLongClickListener", "onPromptMenuClickListener", "onWcbCategoryClickListener", "onWcbCategoryLayoutListener", "onClickSuggestBot", "Lcom/larus/bmhome/chat/layout/item/PromptSpan$OnSuggestClickListener;", "scrollListener", "Landroid/view/ViewTreeObserver$OnScrollChangedListener;", "immerseBgColor", "getImmerseBgColor", "()Ljava/lang/Integer;", "setImmerseBgColor", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "isShowExpandButton", "setShowExpandButton", "(Z)V", "containerWidthOverride", "fragmentReference", "Ljava/lang/ref/WeakReference;", "Landroidx/fragment/app/Fragment;", "defaultContainerWidth", "currentContainerWidth", "maxWidth", "maxWidthNew", "expandMaxWidth", "cinit", "forceLoad", "setViewportBottomAlignment", "enable", "minHeight", "onContainerWidthChanged", "containerWidth", "rebuildPromptViewsForContainerWidth", "setLoading", "setPromptLoading", "alignToBottomInViewport", "viewportHeight", "setWcbSkeletonLoading", "cancelLoading", "getPromptContentHeight", "setContent", "shouldCollapse", "contentKey", "animateRefresh", "nextPulseScene", "contentChanged", "(Lcom/larus/bmhome/chat/bean/PromptContent;Lcom/larus/bmhome/auth/OnboardingActionCardData$CardScene;Lcom/larus/bmhome/auth/OnboardingActionCardData;ZLandroid/view/View$OnClickListener;Lkotlin/jvm/functions/Function3;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Lkotlin/jvm/functions/Function0;ZIZLjava/lang/Boolean;)V", "refreshSignature", "refreshDebugInfo", "cancelWcbSuggestRefreshAnimation", "resetAlpha", "clearPromptViews", "updateWhiteBackground", "addWcbHeaderIfNeeded", "initPromptItemView", "getPromptSpanMaxWidth", "getPromptUIConfig", "Lcom/larus/bmhome/chat/layout/item/PromptUIConfig;", "list", "initPromptExpandButton", "setPromptListNewStyle", "setPromptListOldV2Style", "generateCreationSugByStrategy", "row", "suggest", "generateTextViewByStrategy", "getTextView", "Landroid/widget/TextView;", "itemId", "isFontBold", "needSetOnClick", "getLayoutWithTextAndIcon", "createTextViewWithIcon", "setPlaceholderStyle", "setPromptListOldStyle", "setAwemeTravelSuggestStyleV2", "setFourCardStyle", "itemWidth", "itemHeight", "createItem", "Lkotlin/Function2;", "setPromptListNewVerticalStyle", "setPromptNewCardStyle", "actionCardNumTmp", "Lcom/larus/bmhome/auth/OnboardingActionCardItemData;", "singlePromptNewCardStyle", "cardItemData", "binding", "Lcom/larus/suggest/impl/databinding/LarusCardSuggestGridItemBinding;", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "onScrollListener", "createTextView", ChatDraftItem.TYPE_TEXT, "isBold", "bg", "Landroid/graphics/drawable/Drawable;", "setTextBold", "textView", "createTextViewNewStyle", "Lcom/larus/bmhome/chat/list/cell/prompt/WcbItemLinearLayout;", "item", "textColor", "promptUIConfig", "buildDisplayRichTextSpannable", "", "richTextContent", "Lcom/google/gson/JsonObject;", "appendSkillIcon", "builder", "Landroid/text/SpannableStringBuilder;", "iconColor", "optJsonArray", "Lcom/google/gson/JsonArray;", "name", "showNotInterestedPopup", "suggestItem", "wcbItemLayout", "setAvatar", "avatar", "Lcom/larus/bmhome/view/TitleAvatarImageView;", "url", "needResize", "getBgNewStyle", "getTextColor", "(Lcom/larus/bmhome/chat/bean/PromptContent$SuggestItem;)Ljava/lang/Integer;", "getTextColorV2", "(Lcom/larus/bmhome/chat/bean/PromptContent$SuggestV2;)Ljava/lang/Integer;", "getDefaultBackground", "getNewStrokeBackground", "strokeColor", "getHighlightStrokeBackground", "colors", "", "alpha", "", "([ILjava/lang/Float;)Landroid/graphics/drawable/Drawable;", "switchCategorySuggestionsWithFade", "updateCategory", "getWcbSuggestPressColor", "getSuggestViewList", "getBotViews", "getOrCreateMessageLoading", "createLoading", "getLeftPadding", "getChatFragment", "onDetachedFromWindow", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "Companion", "OnSuggestClickListener", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class PromptSpan extends LinearLayout implements ed8.d {
    public static final int R = 0;
    public static final int S = 0;
    public static final int[] T = null;
    public static final int U = 0;
    public static final float[] V = null;
    public Function3<Object, ? super Integer, ? super View, Unit> A;
    public Function0<Unit> B;
    public View.OnClickListener C;
    public Function0<Unit> D;
    public Function4<? super View, ? super PromptContent.SuggestV2, ? super PromptContent.SuggestItem, ? super PromptContent.SuggestV2ExtraForMultiAction, Unit> E;
    public Function1<? super String, Unit> F;
    public final Rect G;
    public Function1<? super PromptContent.SuggestItem, Unit> H;
    public Function1<? super PromptContent.SuggestItem, Unit> I;
    public Function1<? super PromptContent.SuggestItem, Unit> J;
    public Function0<Unit> K;
    public b L;
    public ViewTreeObserver.OnScrollChangedListener M;
    public Integer N;
    public boolean O;
    public int P;
    public WeakReference<Fragment> Q;
    public final Lazy a;
    public MessageLoading b;
    public final y2 c;
    public final ArrayList<Pair<View, a.C0062a>> d;
    public final ArrayList<View> e;
    public final Set<CustomMarkdownTextView> f;
    public boolean g;
    public boolean h;
    public boolean i;
    public int j;
    public boolean k;
    public boolean l;
    public volatile boolean m;
    public PromptContent n;
    public List<PromptContent.SuggestItem> o;
    public String p;
    public int q;
    public final Set<String> r;
    public String s;
    public String t;
    public String u;
    public final c3 v;
    public final l3 w;
    public String x;
    public OnboardingActionCardData.CardScene y;
    public OnboardingActionCardData z;

    public static final class a {

        /* JADX INFO: renamed from: com.larus.bmhome.chat.layout.item.PromptSpan$a$a, reason: collision with other inner class name */
        public static final class C0062a {
            public final String a;
            public final String b;
            public final String c;
            public final String d;
            public final Integer e;
            public final String f;
            public final Boolean g;
            public final Boolean h;
            public final String i;
            public final String j;
            public final String k;
            public final String l;

            public C0062a() {
                this(null, null, null, null, null, null, null, null, null, null, null, null, 4095);
            }

            public final boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if ((r5 instanceof C0062a) == true) goto L8;
                return false;
            L8:
                C0062a r6 = (C0062a) r5;
                if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
                return false;
            L15:
                if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
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
                if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
                return false;
            L30:
                if (Intrinsics.areEqual(this.h, r6.h) == true) goto L33;
                return false;
            L33:
                if (Intrinsics.areEqual(this.i, r6.i) == true) goto L36;
                return false;
            L36:
                if (Intrinsics.areEqual(this.j, r6.j) == true) goto L39;
                return false;
            L39:
                if (Intrinsics.areEqual(this.k, r6.k) == true) goto L42;
                return false;
            L42:
                if (Intrinsics.areEqual(this.l, r6.l) == true) goto L44;
                return false;
            L44:
                return true;
            }

            public final int hashCode() {
                String r0 = this.a;
                int r1 = 0;
                if (r0 != null) goto L5;
                int r2 = 0;
            L6:
                int r3 = r2 * 31;
                String r4 = this.b;
                if (r4 != null) goto L9;
                int r5 = 0;
            L10:
                int r6 = (r3 + r5) * 31;
                String r7 = this.c;
                if (r7 != null) goto L13;
                int r8 = 0;
            L14:
                int r9 = (r6 + r8) * 31;
                String r10 = this.d;
                if (r10 != null) goto L17;
                int r11 = 0;
            L18:
                int r12 = (r9 + r11) * 31;
                Integer r13 = this.e;
                if (r13 != null) goto L21;
                int r14 = 0;
            L22:
                int r15 = (r12 + r14) * 31;
                String r16 = this.f;
                if (r16 != null) goto L25;
                int r17 = 0;
            L26:
                int r18 = (r15 + r17) * 31;
                Boolean r19 = this.g;
                if (r19 != null) goto L29;
                int r20 = 0;
            L30:
                int r21 = (r18 + r20) * 31;
                Boolean r22 = this.h;
                if (r22 != null) goto L33;
                int r23 = 0;
            L34:
                int r24 = (r21 + r23) * 31;
                String r25 = this.i;
                if (r25 != null) goto L37;
                int r26 = 0;
            L38:
                int r27 = (r24 + r26) * 31;
                String r28 = this.j;
                if (r28 != null) goto L41;
                int r29 = 0;
            L42:
                int r30 = (r27 + r29) * 31;
                String r31 = this.k;
                if (r31 != null) goto L45;
                int r32 = 0;
            L46:
                int r33 = (r30 + r32) * 31;
                String r34 = this.l;
                if (r34 == null) goto L51;
                r1 = r34.hashCode();
            L51:
                return r33 + r1;
            L45:
                r32 = r31.hashCode();
                goto L46
            L41:
                r29 = r28.hashCode();
                goto L42
            L37:
                r26 = r25.hashCode();
                goto L38
            L33:
                r23 = r22.hashCode();
                goto L34
            L29:
                r20 = r19.hashCode();
                goto L30
            L25:
                r17 = r16.hashCode();
                goto L26
            L21:
                r14 = r13.hashCode();
                goto L22
            L17:
                r11 = r10.hashCode();
                goto L18
            L13:
                r8 = r7.hashCode();
                goto L14
            L9:
                r5 = r4.hashCode();
                goto L10
            L5:
                r2 = r0.hashCode();
                goto L6
            }

            public final String toString() {
                return "PromptInfo(content=" + this.a + ", itemId=" + this.b + ", itemType=" + this.c + ", wcbItem=" + this.d + ", onBoardingCardType=" + this.e + ", sugBizType=" + this.f + ", isContinueAsk=" + this.g + ", hasCategory=" + this.h + ", richTextType=" + this.i + ", candidateType=" + this.j + ", categoryId=" + this.k + ", skillId=" + this.l + ')';
            }

            public C0062a(String r3, String r4, String r5, String r6, Integer r7, String r8, Boolean r9, Boolean r10, String r11, String r12, String r13, String r14, int r15) {
                if ((r15 & 1) == 0) goto L6;
                r3 = null;
            L6:
                if ((r15 & 2) == 0) goto L9;
                r4 = null;
            L9:
                if ((r15 & 4) == 0) goto L12;
                r5 = null;
            L12:
                if ((r15 & 8) == 0) goto L15;
                r6 = null;
            L15:
                if ((r15 & 16) == 0) goto L18;
                r7 = null;
            L18:
                if ((r15 & 32) == 0) goto L21;
                r8 = null;
            L21:
                if ((r15 & 64) == 0) goto L24;
                r9 = null;
            L24:
                if ((r15 & 128) == 0) goto L27;
                r10 = null;
            L27:
                if ((r15 & 256) == 0) goto L30;
                r11 = null;
            L30:
                if ((r15 & 512) == 0) goto L33;
                r12 = null;
            L33:
                if ((r15 & 1024) == 0) goto L36;
                r13 = null;
            L36:
                if ((r15 & 2048) == 0) goto L38;
                r14 = null;
            L38:
                this.a = r3;
                this.b = r4;
                this.c = r5;
                this.d = r6;
                this.e = r7;
                this.f = r8;
                this.g = r9;
                this.h = r10;
                this.i = r11;
                this.j = r12;
                this.k = r13;
                this.l = r14;
            }
        }
    }

    public interface b {
        void a(PromptContent.SuggestV2 r1, TextView r2);

        void b(PromptContent.SuggestV2 r1);
    }

    public static final class c extends c6 {
        public final /* synthetic */ PromptContent.SuggestItem c;
        public final /* synthetic */ PromptSpan d;
        public final /* synthetic */ WcbItemLinearLayout e;

        public final void a(View r8) {
            Intrinsics.checkNotNullParameter(r8, "v");
            List<PromptContent.SuggestItem> r9 = this.c.getChildCandidates();
            if (r9 != null) goto L5;
            r9 = CollectionsKt.emptyList();
        L5:
            List<PromptContent.SuggestItem> r10 = CollectionsKt.filterNotNull(r9);
            if ((!r10.isEmpty()) == false) goto L12;
            Function1<? super PromptContent.SuggestItem, Unit> r0 = this.d.J;
            if (r0 == null) goto L10;
            r0.invoke(this.c);
        L10:
            PromptSpan r1 = this.d;
            PromptContent.SuggestItem r3 = this.c;
            r1.d(true);
            r1.animate().cancel();
            int r4 = r1.q + 1;
            r1.q = r4;
            r1.o = r10;
            r1.p = r3.getSuggest();
            FLogger.a.i("WcbSugPromptSpan", "show category children, itemId:" + r3.getItemId() + ", size:" + r10.size());
            Unit r11 = Unit.INSTANCE;
            r1.f();
            r1.setAlpha(0.0f);
            r1.q();
            r1.requestLayout();
            OneShotPreDrawListener.add(r1, new b3(r1, r4, r1));
            return;
        L12:
            int r12 = gx9.o.a;
            Intrinsics.checkNotNullParameter("other", "originalSource");
            Intrinsics.checkNotNullParameter("", "messageId");
            IAIChatControlTraceService.a.Ab("other", "");
            FLogger.a.i("WcbSugPromptSpan", "doClick, content:" + g2a.d.b(this.c.getSuggest()) + ", pos:" + this.e.getTag() + ", sendingContent:" + g2a.d.b(this.c.getSendingContent()));
            Function4<? super View, ? super PromptContent.SuggestV2, ? super PromptContent.SuggestItem, ? super PromptContent.SuggestV2ExtraForMultiAction, Unit> r13 = this.d.E;
            if (r13 == null) goto L16;
            r13.invoke(this.e, null, this.c, null);
            return;
        }

        public c(PromptContent.SuggestItem r1, PromptSpan r2, WcbItemLinearLayout r3) {
            this.c = r1;
            this.d = r2;
            this.e = r3;
        }
    }

    public static final class d extends c6 {
        public final /* synthetic */ PromptSpan c;
        public final /* synthetic */ PromptContent.SuggestV2 d;
        public final /* synthetic */ TextView e;

        public final void a(View r3) {
            Intrinsics.checkNotNullParameter(r3, "v");
            b r4 = this.c.L;
            if (r4 == null) goto L6;
            PromptContent.SuggestV2 r0 = this.d;
            TextView r1 = this.e;
            Intrinsics.checkNotNull(r1);
            r4.a(r0, r1);
            return;
        }

        public d(PromptSpan r1, PromptContent.SuggestV2 r2, TextView r3) {
            this.c = r1;
            this.d = r2;
            this.e = r3;
        }
    }

    public PromptSpan(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, 0);
    }

    public PromptSpan(Context r1, AttributeSet r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        this(r1, 0);
    }

    static {
        Object r3 = null;
        R = i5.y0(v19.c.b(2130971546, null, 2131167462));
        S = i5.y0(v19.c.b(2130970962, null, 2131166639));
        int[] r2 = new int[3];
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L5
        Object r5 = Result.constructor-impl(Integer.valueOf(Color.parseColor("#FF9851")));     // Catch: Throwable -> L5
    L8:
        if (Result.isFailure-impl(r5) == false) goto L10;
        r5 = null;
    L10:
        Integer r6 = (Integer) r5;
        int r7 = -16777216;
        if (r6 == null) goto L13;
        int r8 = r6.intValue();
    L14:
        r2[0] = r8;
        Object r9 = Result.constructor-impl(Integer.valueOf(Color.parseColor("#FF6C55")));     // Catch: Throwable -> L17
    L20:
        if (Result.isFailure-impl(r9) == false) goto L22;
        r9 = null;
    L22:
        Integer r10 = (Integer) r9;
        if (r10 == null) goto L25;
        int r11 = r10.intValue();
    L26:
        r2[1] = r11;
        Object r12 = Result.constructor-impl(Integer.valueOf(Color.parseColor("#BC72FF")));     // Catch: Throwable -> L29
    L32:
        if (Result.isFailure-impl(r12) == true) goto L35;
        r3 = r12;
    L35:
        Integer r13 = (Integer) r3;
        if (r13 == null) goto L38;
        r7 = r13.intValue();
    L38:
        r2[2] = r7;
        T = r2;
        U = ColorProtector.parseColor("#FF9851");
        V = new float[]{0.0f, 0.5f, 1.0f};
        return;
    L29:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L32
    L25:
        r11 = -16777216;
    L17:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L20
    L13:
        r8 = -16777216;
    L5:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }

    private final Fragment getChatFragment() {
        WeakReference<Fragment> r0 = this.Q;
        if (r0 == null) goto L7;
        Fragment r1 = r0.get();
        if (r1 == null) goto L7;
        return r1;
    L7:
        t1a.b r2 = ei9.c.a(this);
        if (r2 == null) goto L14;
        va8.m r3 = r2.getAbility(va8.m.class);
        if (r3 == null) goto L14;
        Fragment r4 = r3.getChatFragment();
        if (r4 == null) goto L14;
        this.Q = new WeakReference(r4);
        return r4;
    L14:
        return null;
    }

    private final Drawable getDefaultBackground() {
        if (this.N == null) goto L6;
        return ContextCompat.getDrawable(getContext(), 2131239438);
    L6:
        return ContextCompat.getDrawable(getContext(), v19.c.b(2130970758, getContext(), 2131239436));
    }

    private final int getLeftPadding() {
        Lazy r0 = com.larus.bmhome.utils.z1.a;
        return com.larus.bmhome.utils.z1.f(getChatFragment());
    }

    private final MessageLoading getOrCreateMessageLoading() {
        MessageLoading r0 = this.b;
        if (r0 != null) goto L6;
        MessageLoading r1 = g();
        this.b = r1;
        return r1;
    L6:
        return r0;
    }

    private final int getPromptSpanMaxWidth() {
        Lazy r0 = com.larus.bmhome.utils.z1.a;
        if (com.larus.bmhome.utils.z1.b(0, this.N) == false) goto L6;
        return RangesKt.coerceAtLeast(j() - getResources().getDimensionPixelSize(2131167564), 0);
    L6:
        return s();
    }

    public final void f() {
        Iterator<T> r0 = this.f.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((CustomMarkdownTextView) r0.next()).a();
        goto L4
    L6:
        this.f.clear();
        removeAllViews();
        this.d.clear();
        this.e.clear();
    }

    public final MessageLoading g() {
        MessageLoading r0 = new MessageLoading(getContext());
        r0.setColor(ContextCompat.getColor(getContext(), v19.c.b(2130972079, getContext(), 2131103136)));
        int r1 = r0.getResources().getDimensionPixelSize(2131167593);
        int r2 = r0.getResources().getDimensionPixelSize(2131167593);
        r0.setPaddingRelative(r1, r0.getResources().getDimensionPixelSize(2131167596), r2, r0.getResources().getDimensionPixelSize(2131167596));
        r0.setBackground(ContextCompat.getDrawable(r0.getContext(), v19.c.b(2130970758, r0.getContext(), 2131239436)));
        return r0;
    }

    public final int j() {
        Integer r0 = Integer.valueOf(this.P);
        boolean r2 = true;
        if (r0.intValue() <= 0) goto L5;
        boolean r1 = true;
    L6:
        Integer r4 = null;
        if (r1 == true) goto L10;
        r0 = null;
    L10:
        if (r0 != null) goto L22;
        Integer r3 = Integer.valueOf(com.larus.platform.service.e2.a.f());
        if (r3.intValue() > 0) goto L16;
        r2 = false;
    L16:
        if (r2 == false) goto L18;
        r4 = r3;
    L18:
        if (r4 != null) goto L23;
        Resources r5 = getResources();
        return WindowDisplayMetricsOverride.apply(r5, r5.getDisplayMetrics()).widthPixels;
    L23:
        return r4.intValue();
    L22:
        return r0.intValue();
    L5:
        r1 = false;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v3, types: [android.content.Context, android.view.ViewGroup] */
    /* JADX WARN: Type inference failed for: r7v22, types: [com.larus.bmhome.chat.layout.item.d2] */
    public final void q() {
        boolean r1 = false;
        this.h = false;
        setShowDividers(2);
        PromptContent r3 = this.n;
        if (r3 == null) goto L188;
        ?? r5 = 0;
        int r7 = 1;
        String r8 = "";
        if (r3.getSuggestActionCardCnt() != 0) goto L7;
    L73:
        List<PromptContent.SuggestItem> r2 = r3.getSuggestItems();
        if (r2 != null) goto L76;
    L79:
        boolean r4 = true;
    L81:
        if (r4 == true) goto L161;
        List<PromptContent.SuggestItem> r6 = this.o;
        if (r6 != null) goto L88;
        List<PromptContent.SuggestItem> r9 = r3.getSuggestItems();
        if (r9 != null) goto L87;
        r9 = CollectionsKt.emptyList();
    L87:
        r6 = CollectionsKt.filterNotNull(r9);
    L88:
        ArrayList r10 = new ArrayList();
        Iterator<T> r11 = r6.iterator();
    L90:
        if (r11.hasNext() == false) goto L100;
        Object r12 = r11.next();
        String r13 = ((PromptContent.SuggestItem) r12).getItemId();
        if (r13 != null) goto L94;
    L96:
        boolean r14 = false;
    L97:
        if (r14 == true) goto L90;
        r10.add(r12);
        goto L90
    L94:
        if (this.r.contains(r13) != true) goto L96;
        r14 = true;
        goto L97
    L100:
        if (this.o == null) goto L105;
        String r15 = this.p;
        if (r15 == null) goto L116;
    L104:
        String r16 = r15;
    L118:
        if (r16.length() != 0) goto L120;
        boolean r17 = true;
    L122:
        if (r17 == true) goto L124;
    L126:
        LinearLayout r18 = new LinearLayout(getContext());
        r18.setOrientation(0);
        r18.setGravity(16);
        TextView r19 = new TextView(getContext());
        r19.setText(r16);
        r19.setGravity(16);
        r19.setMaxLines(1);
        r19.setEllipsize(TextUtils.TruncateAt.END);
        float r110 = i5.m();
        if (this.N == null) goto L129;
        boolean r111 = true;
    L130:
        we8.a.b(r19, r110, r111, null, null, 12);
        TextViewCompat.setLineHeight(r19, ((Number) i5.w.getValue()).intValue());
        r19.setTextColor(ContextCompat.getColor(r19.getContext(), v19.c.b(2130972082, r19.getContext(), 2131103146)));
        r18.addView(r19, new LinearLayout.LayoutParams(-2, i5.J()));
        if (this.o == null) goto L133;
        com.larus.utils.e1.d(r18, new b2(this));
        AppCompatImageView r20 = new AppCompatImageView(getContext());
        r20.setPadding(i5.Y(), i5.j0(), i5.j0(), i5.j0());
        r20.setImageResource(v19.c.b(2130971960, r20.getContext(), 2131242583));
        r20.setContentDescription(r20.getContext().getString(2131898809));
        r18.addView(r20, new LinearLayout.LayoutParams(i5.J(), i5.J()));
    L133:
        LinearLayout.LayoutParams r21 = new LinearLayout.LayoutParams(-2, i5.J());
        if (Intrinsics.areEqual(r3.getOnboardingDisplayStyle(), "vertical") == false) goto L136;
        r21.bottomMargin = i5.r0();
    L136:
        Unit r22 = Unit.INSTANCE;
        addView(r18, r21);
    L137:
        String r23 = r3.getOnboardingDisplayStyle();
        if (Intrinsics.areEqual(r23, "four_card") == false) goto L158;
        int r24 = getPromptSpanMaxWidth();
        getLayoutParams().width = r24;
        final Function3<Object, ? super Integer, ? super View, Unit> r25 = this.A;
        FLogger.a.i("WcbSugPromptSpan", "setAwemeTravelSuggestStyleV2");
        this.g = true;
        setPadding(getLeftPadding(), 0, 0, 0);
        int r26 = (r24 - (i5.h() * 2)) / 2;
        final int r27 = (int) (r26 * 0.75f);
        int r28 = i5.Z() + r27;
        ?? r29 = new d2(this, r27, r25);
        List r30 = CollectionsKt.take(r10, 4);
        int r31 = r30.size();
        GridLayout r32 = new GridLayout(getContext());
        int r33 = r31 % 2;
        int r34 = r31 / 2;
        if (r33 == 0) goto L143;
        r34 = r34 + 1;
    L143:
        r32.setRowCount(r34);
        r32.setColumnCount(2);
        addView(r32, new LinearLayout.LayoutParams(-1, -2));
        Iterator r35 = r30.iterator();
        int r36 = 0;
    L145:
        if (r35.hasNext() == false) goto L188;
        Object r37 = r35.next();
        int r38 = r36 + 1;
        if (r36 >= 0) goto L149;
        CollectionsKt.throwIndexOverflow();
    L149:
        PromptContent.SuggestItem r39 = (PromptContent.SuggestItem) r37;
        GridLayout.LayoutParams r112 = new GridLayout.LayoutParams();
        r112.width = r26;
        r112.height = r28;
        if ((r36 % 2) != 0) goto L152;
        int r113 = 0;
    L153:
        r112.leftMargin = r113;
        if (r36 < 2) goto L156;
        r112.topMargin = i5.h();
    L156:
        View r40 = (View) r29.invoke(Integer.valueOf(r36), r39);
        r32.addView(r40, r112);
        r40.setTag(TuplesKt.to(Integer.valueOf(r36 / r32.getColumnCount()), Integer.valueOf(r36 % r32.getColumnCount())));
        r36 = r38;
        goto L145
    L152:
        r113 = i5.h();
        goto L153
    L158:
        if (Intrinsics.areEqual(r23, "vertical") == false) goto L160;
        getLayoutParams().width = getPromptSpanMaxWidth();
        setShowDividers(0);
        setPromptListNewVerticalStyle(r10);
        goto L188
    L160:
        getLayoutParams().width = t();
        this.h = true;
        setPromptListNewStyle(r10);
        goto L188
    L129:
        r111 = false;
        goto L130
    L124:
        if (this.o != null) goto L126;
    L120:
        r17 = false;
    L116:
        r16 = "";
        goto L118
    L105:
        r15 = r3.getWcbTitle();
        Integer r41 = r3.getWcbTitleStyle();
        if (r41 != null) goto L109;
    L111:
        boolean r42 = false;
    L112:
        if (r42 == true) goto L115;
        r15 = null;
    L115:
        if (r15 != null) goto L104;
    L109:
        if (r41.intValue() != 1) goto L111;
        r42 = true;
        goto L112
    L161:
        List<PromptContent.SuggestV2> r43 = r3.getSuggestV2();
        if (r43 != null) goto L164;
    L167:
        boolean r44 = true;
    L168:
        if (r44 == true) goto L173;
        getLayoutParams().width = getPromptSpanMaxWidth();
        List<PromptContent.SuggestV2> r45 = r3.getSuggestV2();
        if (r45 != null) goto L172;
        r45 = CollectionsKt.emptyList();
    L172:
        setPromptListOldV2Style(r45);
        goto L188
    L173:
        List<String> r46 = r3.getSuggest();
        if (r46 != null) goto L176;
    L179:
        boolean r47 = true;
    L180:
        if (r47 == true) goto L186;
        getLayoutParams().width = getPromptSpanMaxWidth();
        List<String> r48 = r3.getSuggest();
        if (r48 != null) goto L184;
        r48 = CollectionsKt.emptyList();
    L184:
        setPromptListOldStyle(r48);
        goto L188
    L186:
        if (r3.isPlaceholder() == false) goto L188;
        getLayoutParams().width = getPromptSpanMaxWidth();
        FLogger.a.i("WcbSugPromptSpan", "setPlaceholderStyle");
        this.g = false;
        setPadding(getLeftPadding(), 0, 0, R);
        E(this, 0, i5.x());
        E(this, 1, i5.x());
        E(this, 2, i5.p());
        goto L188
    L176:
        if (r46.isEmpty() == true) goto L179;
        r47 = false;
        goto L180
    L164:
        if (r43.isEmpty() == true) goto L167;
        r44 = false;
        goto L168
    L76:
        if (r2.isEmpty() == true) goto L79;
        r4 = false;
        goto L81
    L7:
        if (this.y == null) goto L73;
        getLayoutParams().width = t();
        final Function3<Object, ? super Integer, ? super View, Unit> r49 = this.A;
        if (r49 == null) goto L188;
        int r50 = r3.getSuggestActionCardCnt();
        OnboardingActionCardData r114 = this.z;
        if (r114 == null) goto L15;
        List<OnboardingActionCardItemData> r115 = r114.a();
        if (r115 == null) goto L15;
        int r116 = r115.size();
    L16:
        int r51 = Math.min(r50, r116);
        Function0<Unit> r117 = this.D;
        if (r117 == null) goto L19;
        r117.invoke();
    L19:
        this.g = true;
        setPadding(0, 0, 0, 0);
        GridLayout r118 = new GridLayout(getContext());
        if ((r51 % 2) != 0) goto L22;
        int r119 = r51 / 2;
    L23:
        r118.setRowCount(r119);
        r118.setColumnCount(2);
        addView(r118, new LinearLayout.LayoutParams(-1, -2));
        final int r52 = 0;
    L24:
        if (r52 >= r51) goto L188;
        ConstraintLayout r53 = LayoutInflater.from(r118.getContext()).inflate(2131561875, r5, r1);
        int r120 = 2131365214;
        SimpleDraweeView r121 = ViewBindings.findChildViewById(r53, 2131365214);
        if (r121 == null) goto L72;
        r120 = 2131365215;
        TextView r122 = (TextView) ViewBindings.findChildViewById(r53, 2131365215);
        if (r122 == null) goto L72;
        r120 = 2131365218;
        TextView r123 = (TextView) ViewBindings.findChildViewById(r53, 2131365218);
        if (r123 == null) goto L72;
        r120 = 2131365222;
        SimpleDraweeView r124 = ViewBindings.findChildViewById(r53, 2131365222);
        if (r124 == null) goto L72;
        ConstraintLayout r54 = r53;
        LarusCardSuggestGridItemBinding r125 = new LarusCardSuggestGridItemBinding(r54, r121, r122, r123, r124);
        int r55 = r118.getResources().getDimensionPixelSize(v19.c.b(2130971227, r5, 2131166823));
        int r56 = r118.getResources().getDimensionPixelSize(v19.c.b(2130971560, r5, 2131167489));
        GridLayout.LayoutParams r126 = new GridLayout.LayoutParams();
        r126.width = r55;
        r126.height = r56;
        r126.rowSpec = GridLayout.spec(r52 / r118.getColumnCount());
        r126.columnSpec = GridLayout.spec(r52 % r118.getColumnCount());
        int r57 = r118.getResources().getDimensionPixelSize(2131167568);
        if ((r52 % r118.getColumnCount()) != (r118.getColumnCount() - r7)) goto L36;
        boolean r58 = true;
    L38:
        if ((r52 / r118.getColumnCount()) != (r118.getRowCount() - 1)) goto L40;
        boolean r59 = true;
    L41:
        int r210 = r51;
        r54.setTag(new Pair(Integer.valueOf(r52 / r118.getColumnCount()), Integer.valueOf(r52 % r118.getColumnCount())));
        if (r() == true) goto L44;
        Drawable r60 = AppCompatResources.getDrawable(getContext(), v19.c.b(2130970926, getContext(), 2131240008));
    L45:
        r121.setBackground(r60);
        if (r58 == false) goto L48;
        int r61 = 0;
    L49:
        if (r59 == false) goto L51;
        int r62 = 0;
    L52:
        r126.setMargins(r61, 0, r57, r62);
        if (r114 == null) goto L69;
        List<OnboardingActionCardItemData> r63 = r114.a();
        if (r63 == null) goto L69;
        final OnboardingActionCardItemData r64 = (OnboardingActionCardItemData) CollectionsKt.getOrNull(r63, r52);
        if (r64 == null) goto L69;
        this.d.add(new Pair(r54, new a.C0062a(r64.d(), null, null, null, null, null, null, null, null, null, null, null, 4094)));
        r121.setVisibility(8);
        String r65 = r64.q();
        if (r65 != null) goto L61;
        r65 = r8;
    L61:
        r123.setText(r65);
        r123.setVisibility(0);
        String r66 = r64.r();
        if (r66 != null) goto L64;
        r66 = r8;
    L64:
        r122.setText(r66);
        r122.setVisibility(0);
        if (r() == false) goto L67;
        ImageLoaderKt.u(r125.b, r64.j(), "on_boarding_card_icon");
    L68:
        com.larus.utils.e1.d(r54, new e2(r49, r64, r52));
    L70:
        r118.addView(r54, r126);
        r52 = r52 + 1;
        r8 = r8;
        r51 = r210;
        r1 = false;
        r5 = 0;
        r7 = 1;
        goto L24
    L67:
        ImageLoaderKt.u(r125.b, r64.o(), "on_boarding_card_icon");
    L69:
        r121.setVisibility(0);
        r123.setVisibility(8);
        r122.setVisibility(8);
        goto L70
    L51:
        r62 = r57;
        goto L52
    L48:
        r61 = r57;
        goto L49
    L44:
        r60 = AppCompatResources.getDrawable(getContext(), 2131240007);
        goto L45
    L40:
        r59 = false;
        goto L41
    L36:
        r58 = false;
    L72:
        throw new NullPointerException("Missing required view with ID: ".concat(r53.getResources().getResourceName(r120)));
    L22:
        r119 = (r51 / 2) + 1;
    L15:
        r116 = Integer.MAX_VALUE;
    L188:
        Function0<Unit> r67 = this.B;
        if (r67 == null) goto L207;
        r67.invoke();
        return;
    }

    public final boolean r() {
        return ((Boolean) this.a.getValue()).booleanValue();
    }

    private final int getWcbSuggestPressColor() {
        return v19.c.a(2130972118, getContext(), 2131103188);
    }

    public final void D() {
        MessageLoading r0 = getOrCreateMessageLoading();
        I(false);
        this.l = true;
        f();
        G(false, 0);
        setPadding(getLeftPadding(), 0, 0, R);
        addView(r0, new LinearLayout.LayoutParams(-2, -2));
        r0.c();
    }

    public final int getPromptContentHeight() {
        Iterator r0 = ViewGroupKt.getChildren(this).iterator();
        int r3 = Integer.MAX_VALUE;
        int r4 = 0;
    L4:
        if (r0.hasNext() == false) goto L26;
        View r5 = (View) r0.next();
        if (r5.getVisibility() == 8) goto L4;
        ViewGroup.LayoutParams r6 = r5.getLayoutParams();
        if ((r6 instanceof ViewGroup.MarginLayoutParams) == false) goto L10;
        ViewGroup.MarginLayoutParams r7 = (ViewGroup.MarginLayoutParams) r6;
    L11:
        int r8 = r5.getTop();
        if (r7 == null) goto L14;
        int r9 = r7.topMargin;
    L15:
        int r10 = r8 - r9;
        if (r5.getBottom() <= r5.getTop()) goto L19;
        int r11 = r5.getBottom();
    L22:
        if (r7 == null) goto L24;
        int r12 = r7.bottomMargin;
    L25:
        r3 = Math.min(r3, r10);
        r4 = Math.max(r4, r11 + r12);
        goto L4
    L24:
        r12 = 0;
        goto L25
    L19:
        if (r5.getMeasuredHeight() <= 0) goto L21;
        int r13 = r5.getTop();
        r11 = r5.getMeasuredHeight() + r13;
        goto L22
    L21:
        r11 = r5.getTop();
        goto L22
    L14:
        r9 = 0;
        goto L15
    L10:
        r7 = null;
        goto L11
    L26:
        if (r3 != Integer.MAX_VALUE) goto L29;
        return 0;
    L29:
        return RangesKt.coerceAtLeast(((r4 - r3) + getPaddingTop()) + getPaddingBottom(), 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        d(true);
        WeakReference<Fragment> r0 = this.Q;
        if (r0 == null) goto L5;
        r0.clear();
    L5:
        this.Q = null;
    }

    public final int s() {
        int r0 = j();
        com.larus.platform.service.e2 r1 = com.larus.platform.service.e2.a;
        if (r1.isPad() == false) goto L23;
        Integer r2 = Integer.valueOf(r1.d(Integer.valueOf(r0)));
        boolean r4 = true;
        if (r2.intValue() <= 0) goto L7;
        boolean r3 = true;
    L8:
        Integer r5 = null;
        if (r3 == true) goto L12;
        r2 = null;
    L12:
        if (r2 == null) goto L14;
        r0 = r2.intValue();
    L22:
        int r6 = r0 + i5.h();
    L25:
        return RangesKt.coerceAtLeast(r6, 0);
    L14:
        Integer r7 = Integer.valueOf(com.larus.platform.api.f3.a.a());
        if (r7.intValue() > 0) goto L18;
        r4 = false;
    L18:
        if (r4 == false) goto L20;
        r5 = r7;
    L20:
        if (r5 == null) goto L22;
        r0 = r5.intValue();
        goto L22
    L7:
        r3 = false;
        goto L8
    L23:
        r6 = r0 - i5.y0(2131167563);
        goto L25
    }

    public final int t() {
        int r0 = j();
        com.larus.platform.service.e2 r1 = com.larus.platform.service.e2.a;
        if (r1.isPad() == false) goto L24;
        Integer r2 = Integer.valueOf(r1.d(Integer.valueOf(r0)));
        boolean r4 = true;
        if (r2.intValue() <= 0) goto L7;
        boolean r3 = true;
    L8:
        Integer r5 = null;
        if (r3 == true) goto L12;
        r2 = null;
    L12:
        if (r2 == null) goto L14;
        r0 = r2.intValue();
    L22:
        r0 = r0 + i5.h();
        goto L24
    L14:
        Integer r6 = Integer.valueOf(com.larus.platform.api.f3.a.a());
        if (r6.intValue() > 0) goto L18;
        r4 = false;
    L18:
        if (r4 == false) goto L20;
        r5 = r6;
    L20:
        if (r5 == null) goto L22;
        r0 = r5.intValue();
        goto L22
    L7:
        r3 = false;
    L24:
        return RangesKt.coerceAtLeast(r0, 0);
    }

    public final ArrayList<View> getBotViews() {
        return this.e;
    }

    public final Integer getImmerseBgColor() {
        return this.N;
    }

    public final Function0<Unit> getOnSkillCardShow() {
        return this.D;
    }

    public final ArrayList<Pair<View, a.C0062a>> getSuggestViewList() {
        return this.d;
    }

    public static final String B(PromptContent.SuggestItem r11) {
        String r0 = null;
        if (r11 != null) goto L5;
        return null;
    L5:
        Object[] r1 = new Object[6];
        r1[0] = r11.getSuggest();
        r1[1] = r11.getItemType();
        r1[2] = r11.getItemId();
        r1[3] = Boolean.valueOf(r11.isRichText());
        r1[4] = r11.getCandidateType();
        List<PromptContent.SuggestItem> r12 = r11.getChildCandidates();
        if (r12 == null) goto L10;
        List r13 = CollectionsKt.filterNotNull(r12);
        if (r13 == null) goto L10;
        r0 = CollectionsKt.joinToString$default(r13, ",", null, null, 0, null, new o2(), 30, null);
    L10:
        r1[5] = r0;
        return CollectionsKt.joinToString$default(CollectionsKt.listOf(r1), "|", null, null, 0, null, null, 62, null);
    }

    public static int b(PromptSpan r0) {
        return r0.getPromptSpanMaxWidth();
    }

    public static r3 m(List r13) {
        boolean r1 = false;
        r3 r0 = new r3(0);
        List r14 = r13;
        if ((r14 instanceof Collection) == true) goto L5;
    L7:
        Iterator r15 = r14.iterator();
    L9:
        if (r15.hasNext() == false) goto L13;
        if (Intrinsics.areEqual(((PromptContent.SuggestItem) r15.next()).getItemType(), PromptContent.SuggestItemType.VLM.getValue()) == false) goto L9;
        r1 = true;
    L13:
        if (r1 == true) goto L15;
        return r0;
    L15:
        return new r3(i5.o(), Integer.valueOf(i5.g0()), Integer.valueOf(i5.r0()), Integer.valueOf(i5.r0()), Integer.valueOf(i5.m()), Integer.valueOf(i5.m()), Integer.valueOf(i5.h()), Integer.valueOf(i5.r0()), Integer.valueOf(i5.Y()), Integer.valueOf(i5.r0()));
    L5:
        if (r14.isEmpty() == false) goto L7;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [android.widget.LinearLayout, com.larus.bmhome.chat.layout.item.PromptSpan] */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.bmhome.chat.layout.item.PromptSpan] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r4v7, types: [android.view.View, android.widget.LinearLayout] */
    /* JADX WARN: Type inference failed for: r5v2, types: [android.view.View, android.widget.FrameLayout] */
    /* JADX WARN: Type inference failed for: r9v1, types: [android.view.View, android.widget.HorizontalScrollView] */
    private final void setPromptListNewStyle(List<PromptContent.SuggestItem> r32) {
        final ?? r0 = this;
        FLogger.a.i("WcbSugPromptSpan", "setPromptListNewStyle, size:" + r32.size());
        int r1 = 1;
        r0.g = true;
        int r2 = 0;
        r0.setPadding(0, 0, 0, 0);
        if (r32.isEmpty() == false) goto L5;
        return;
    L5:
        ArrayList r3 = new ArrayList();
        Iterator r4 = r32.iterator();
        int r5 = 0;
    L7:
        if (r4.hasNext() == false) goto L15;
        Object r6 = r4.next();
        int r7 = r5 + 1;
        if (r5 >= 0) goto L11;
        CollectionsKt.throwIndexOverflow();
    L11:
        PromptContent.SuggestItem r8 = (PromptContent.SuggestItem) r6;
        int r9 = r5 % 3;
        if (r3.size() > r9) goto L14;
        r3.add(new ArrayList());
    L14:
        ((ArrayList) ListProtector.get(r3, r9)).add(r8);
        r5 = r7;
        goto L7
    L15:
        final Ref.IntRef r10 = new Ref.IntRef();
        ?? r11 = new FrameLayout(getContext());
        r11.setPadding(0, 0, 0, R);
        int r12 = -2;
        if (r0.i == false) goto L18;
        int r13 = -2;
    L19:
        r0.addView(r11, new ViewGroup.LayoutParams(-1, r13));
        final ?? r14 = new HorizontalScrollView(getContext());
        r14.setHorizontalScrollBarEnabled(false);
        r14.setOverScrollMode(2);
        r14.getViewTreeObserver().addOnScrollChangedListener(new c2(r10, r14, r0));
        r11.addView(r14, new ViewGroup.LayoutParams(-1, r13));
        if (com.larus.platform.service.e2.a.isPad() == true) goto L22;
        GradientMaskView r15 = new GradientMaskView(getContext(), null, 6, 0);
        r11.addView(r15, new ViewGroup.LayoutParams(-1, r13));
        r15.bringToFront();
    L22:
        ?? r16 = new LinearLayout(getContext());
        r16.setOrientation(1);
        r14.addView(r16);
        r3 r17 = m(r32);
        Iterator r18 = r3.iterator();
        int r19 = 0;
        ?? r20 = r0;
    L24:
        if (r18.hasNext() == false) goto L56;
        Object r21 = r18.next();
        int r110 = r19 + 1;
        if (r19 >= 0) goto L28;
        CollectionsKt.throwIndexOverflow();
    L28:
        ArrayList r22 = (ArrayList) r21;
        LinearLayout r111 = new LinearLayout(getContext());
        r111.setOrientation(r2);
        LinearLayout.LayoutParams r112 = new LinearLayout.LayoutParams(r12, r12);
        if (r19 >= (r3.size() - r1)) goto L31;
        r112.bottomMargin = r111.getResources().getDimensionPixelSize(2131167600);
    L31:
        r16.addView(r111, r112);
        Iterator r23 = r22.iterator();
        int r113 = 0;
        ?? r24 = r20;
    L33:
        if (r23.hasNext() == false) goto L55;
        Object r114 = r23.next();
        int r115 = r113 + 1;
        if (r113 >= 0) goto L37;
        CollectionsKt.throwIndexOverflow();
    L37:
        PromptContent.SuggestItem r116 = (PromptContent.SuggestItem) r114;
        LinearLayout.LayoutParams r25 = new LinearLayout.LayoutParams(r12, r12);
        r25.setMarginEnd(getResources().getDimensionPixelSize(2131167599));
        WcbItemLinearLayout r26 = r24.i(r116, v19.c.b(2130972079, getContext(), 2131103136), r116.isFontBold(), r17);
        r26.setTag(TuplesKt.to(Integer.valueOf(r19), Integer.valueOf(r113)));
        ArrayList<Pair<View, a.C0062a>> r27 = r24.d;
        String r117 = r116.getSuggest();
        String r118 = r116.getItemId();
        String r119 = r116.getItemType();
        String r28 = r116.getWcbItem();
        String r29 = r116.getSugBizType();
        Boolean r210 = r116.isContinueAsk();
        ArrayList r30 = r3;
        if (Intrinsics.areEqual(r116.isCategoryCandidate(), Boolean.TRUE) == true) goto L49;
        List<PromptContent.SuggestItem> r31 = r116.getChildCandidates();
        if (r31 != null) goto L42;
    L45:
        boolean r33 = true;
    L46:
        if (r33 == false) goto L49;
        boolean r34 = false;
    L50:
        Boolean r211 = Boolean.valueOf(r34);
        String r212 = r116.getRichTextType();
        String r213 = r116.getRawWcbCandidateType();
        String r214 = r116.getCategoryId();
        com.larus.bmhome.chat.list.cell.prompt.j1 r35 = com.larus.bmhome.chat.list.cell.prompt.n1.b(r116);
        if (r35 == null) goto L53;
        String r215 = r35.a;
    L54:
        r27.add(new Pair(r26, new a.C0062a(r117, r118, r119, r28, null, r29, r210, r211, r212, r213, r214, r215, 16)));
        r111.addView(r26, r25);
        r24 = this;
        r113 = r115;
        r3 = r30;
        r1 = 1;
        r2 = 0;
        r12 = -2;
        goto L33
    L53:
        r215 = null;
        goto L54
    L42:
        if (r31.isEmpty() == true) goto L45;
        r33 = false;
    L49:
        r34 = true;
        goto L50
    L55:
        r20 = this;
        r19 = r110;
        goto L24
    L56:
        return;
    L18:
        r13 = -1;
        goto L19
    }

    private final void setPromptListNewVerticalStyle(List<PromptContent.SuggestItem> r25) {
        FLogger.a.i("WcbSugPromptSpan", "setPromptListNewVerticalStyle, size:" + r25.size());
        int r1 = 0;
        this.g = false;
        setPadding(getLeftPadding(), 0, 0, R);
        r3 r2 = m(r25);
        Iterator<T> r3 = r25.iterator();
        int r4 = 0;
    L3:
        boolean r6 = true;
        if (r3.hasNext() == false) goto L31;
        Object r5 = r3.next();
        int r7 = r4 + 1;
        if (r4 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        final PromptContent.SuggestItem r8 = (PromptContent.SuggestItem) r5;
        final WcbItemLinearLayout r9 = i(r8, v19.c.b(2130972079, getContext(), 2131103136), r8.isFontBold(), r2);
        r9.setTag(TuplesKt.to(Integer.valueOf(r4), Integer.valueOf(r1)));
        ArrayList<Pair<View, a.C0062a>> r10 = this.d;
        String r11 = r8.getSuggest();
        String r12 = r8.getItemId();
        String r13 = r8.getItemType();
        String r14 = r8.getWcbItem();
        String r17 = r8.getSugBizType();
        Boolean r18 = r8.isContinueAsk();
        if (Intrinsics.areEqual(r8.isCategoryCandidate(), Boolean.TRUE) == true) goto L20;
        List<PromptContent.SuggestItem> r15 = r8.getChildCandidates();
        if (r15 != null) goto L13;
    L16:
        boolean r16 = true;
    L17:
        if (r16 == false) goto L20;
        r6 = false;
        goto L20
    L13:
        if (r15.isEmpty() == true) goto L16;
        r16 = false;
    L20:
        Boolean r19 = Boolean.valueOf(r6);
        String r110 = r8.getRichTextType();
        String r20 = r8.getRawWcbCandidateType();
        String r21 = r8.getCategoryId();
        com.larus.bmhome.chat.list.cell.prompt.j1 r22 = com.larus.bmhome.chat.list.cell.prompt.n1.b(r8);
        if (r22 == null) goto L23;
        String r23 = r22.a;
    L24:
        r10.add(TuplesKt.to(r9, new a.C0062a(r11, r12, r13, r14, null, r17, r18, r19, r110, r20, r21, r23, 16)));
        if (com.larus.platform.service.z2.a.C().a() == false) goto L27;
        r9.setOnLongClickListener(new a2(this, r8, r9));
    L27:
        LinearLayout.LayoutParams r24 = new LinearLayout.LayoutParams(-2, -2);
        if (r4 <= 0) goto L30;
        r24.topMargin = i5.c();
    L30:
        Unit r26 = Unit.INSTANCE;
        addView(r9, r24);
        r4 = r7;
        r1 = 0;
        goto L3
    L23:
        r23 = null;
        goto L24
    L31:
        c3 r111 = this.v;
        PromptContent r27 = (PromptContent) r111.b.invoke();
        int r28 = ((Number) r111.c.invoke()).intValue();
        if (r111.d == false) goto L41;
        if (r27 != null) goto L35;
    L37:
        boolean r29 = false;
    L38:
        if (r29 == false) goto L41;
        if (r28 <= 0) goto L41;
        boolean r30 = true;
    L42:
        if (r30 == true) goto L44;
        r111.d = false;
        return;
    L44:
        r111.d = false;
        Iterator<T> r31 = r111.f.iterator();
    L46:
        if (r31.hasNext() == false) goto L48;
        View r32 = (View) r31.next();
        r32.animate().cancel();
        r32.setTranslationY(0.0f);
        r32.setAlpha(1.0f);
        goto L46
    L48:
        int r112 = r111.e + 1;
        r111.e = r112;
        View r33 = r111.a;
        if (r33.isAttachedToWindow() == true) goto L51;
        r33.addOnAttachStateChangeListener(new d3(r33, r112, r111));
        return;
    L51:
        if (r112 != r111.e) goto L78;
        Ref.ObjectRef r113 = new Ref.ObjectRef();
        Ref.ObjectRef r114 = new Ref.ObjectRef();
        View r34 = r111.a;
        r114.element = r34;
        ViewParent r35 = r34.getParent();
    L55:
        if ((r35 instanceof View) == false) goto L60;
        if ((r35 instanceof RecyclerView) == true) goto L58;
        r34 = r35;
        r35 = r34.getParent();
        goto L55
    L58:
        r113.element = r35;
        r114.element = r34;
    L60:
        RecyclerView r36 = (RecyclerView) r113.element;
        if (r36 == null) goto L66;
        RecyclerView.ViewHolder r37 = r36.findContainingViewHolder(r111.a);
        if (r37 == null) goto L66;
        View r38 = r37.itemView;
        if (r38 == null) goto L66;
    L67:
        r114.element = r38;
        OneShotPreDrawListener.add(r38, new f3(r38, r112, r111, r113, r114));
        return;
    L66:
        r38 = (View) r114.element;
        goto L67
    L78:
        return;
    L35:
        if (com.larus.bmhome.chat.bean.d.g0(r27) != true) goto L37;
        r29 = true;
    L41:
        r30 = false;
        goto L42
    }

    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r1v3 */
    private final void setPromptListOldStyle(List<String> r24) {
        FLogger.a.i("WcbSugPromptSpan", "setPromptListOldStyle, size:" + r24.size());
        ?? r1 = 0;
        this.g = false;
        setPadding(getLeftPadding(), 0, 0, R);
        Iterator<T> r2 = r24.iterator();
        int r3 = 0;
    L4:
        if (r2.hasNext() == false) goto L12;
        Object r4 = r2.next();
        int r5 = r3 + 1;
        if (r3 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        String r7 = (String) r4;
        if (com.larus.utils.o0.d(r7) == false) goto L11;
        TextView r6 = h(this, r7, r1, null, 14);
        r6.setTag(TuplesKt.to(Integer.valueOf(r3), Integer.valueOf(r1)));
        this.d.add(new Pair(r6, new a.C0062a(r7, null, null, null, null, null, null, null, null, null, null, null, 4094)));
        addView(r6, new LinearLayout.LayoutParams(-2, -2));
    L11:
        r3 = r5;
        r1 = 0;
        goto L4
    }

    private final void setPromptListOldV2Style(List<PromptContent.SuggestV2> r31) {
        FLogger.a.i("WcbSugPromptSpan", "setPromptListOldV2Style, size:" + r31.size());
        boolean r1 = false;
        this.g = false;
        setPadding(getLeftPadding(), 0, 0, R);
        Iterator<T> r2 = r31.iterator();
        int r3 = 0;
    L4:
        if (r2.hasNext() == false) goto L101;
        Object r4 = r2.next();
        int r5 = r3 + 1;
        if (r3 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        final PromptContent.SuggestV2 r6 = (PromptContent.SuggestV2) r4;
        String r7 = r6.getContent();
        if (r7 != null) goto L11;
    L14:
        boolean r8 = true;
    L15:
        View r9 = null;
        if (r8 == false) goto L18;
    L17:
        View r10 = r9;
    L98:
        if (r10 == null) goto L100;
        r10.setTag(2131387708, r6);
        addView(r10, new LinearLayout.LayoutParams(-2, -2));
    L100:
        r3 = r5;
        r1 = false;
        goto L4
    L18:
        Integer r11 = r6.getSuggestType();
        String r12 = "";
        if (r11 != null) goto L22;
    L41:
        Integer r13 = r6.getSuggestType();
        if (r13 != null) goto L45;
    L63:
        Integer r14 = r6.getSuggestType();
        if (r14 != null) goto L67;
    L68:
        String r15 = this.x;
        int r16 = g3.a;
        if (Intrinsics.areEqual(r15, "coco_spring_festival_2025") == true) goto L91;
        PromptContent.SuggestV2Extra r17 = r6.getSuggestV2Extra();
        if (com.larus.utils.o0.d(r6.getIconUrl()) == false) goto L83;
        String r18 = "";
        if (com.larus.utils.o0.d(r6.getDarkIconUrl()) == false) goto L83;
        if (r17 == null) goto L82;
        Long r19 = r17.getRsItemId();
        r18 = "";
        if (r19 == null) goto L82;
        String r20 = r19.toString();
        r18 = "";
        if (r20 == null) goto L82;
        r18 = r20;
    L82:
        LinearLayout r21 = k(r3, r6, r18, true);
    L60:
        r9 = r21;
    L83:
        if (r17 == null) goto L90;
        Long r22 = r17.getRsItemId();
        if (r22 == null) goto L90;
        String r23 = r22.toString();
        if (r23 == null) goto L90;
        r12 = r23;
    L90:
        r21 = p(r3, r6, r12, true);
    L91:
        final PromptContent.SuggestV2ExtraForMultiAction r24 = r6.getSuggestV2ExtForMultiAction();
        if (com.larus.utils.o0.d(r6.getIconUrl()) == true) goto L94;
    L96:
        View r25 = p(r3, r6, "", false);
    L97:
        final View r26 = r25;
        com.larus.utils.e1.d(r26, new m2(this, r26, r6, r24));
        r10 = r26;
        goto L98
    L94:
        if (com.larus.utils.o0.d(r6.getDarkIconUrl()) == false) goto L96;
        r25 = k(r3, r6, "", false);
        goto L97
    L67:
        if (r14.intValue() == 5) goto L91;
    L45:
        if (r13.intValue() != 3) goto L63;
        View r27 = LayoutInflater.from(getContext()).inflate(2131562681, null, false);
        int r28 = 2131371718;
        SimpleDraweeView r29 = ViewBindings.findChildViewById(r27, 2131371718);
        if (r29 == null) goto L62;
        r28 = 2131371721;
        TextView r30 = (TextView) ViewBindings.findChildViewById(r27, 2131371721);
        if (r30 == null) goto L62;
        LinearLayout r32 = (LinearLayout) r27;
        final LarusItemSuggestPromptEntryHolderBinding r33 = new LarusItemSuggestPromptEntryHolderBinding(r32, r29, r30);
        r30.setText(r6.getContent());
        String r34 = r6.getIconUrl();
        if (r34 == null) goto L53;
        ImageLoaderKt.y(r29, r34, "prompt_span_avatar", new v2(), 4);
        Unit r35 = Unit.INSTANCE;
        r29.setImageResource(2131241168);
    L53:
        r32.setTag(TuplesKt.to(Integer.valueOf(r3), 0));
        r32.setTag(2131388508, r6.getExtra());
        r32.setTag(2131388507, r6.getBotId());
        PromptContent.SuggestV2Extra r36 = r6.getSuggestV2Extra();
        ArrayList<Pair<View, a.C0062a>> r37 = this.d;
        String r110 = r6.getContent();
        Long r111 = "";
        if (r36 == null) goto L59;
        Long r38 = r36.getRsItemId();
        r111 = "";
        if (r38 == null) goto L59;
        r111 = r38;
    L59:
        r37.add(new Pair(r32, new a.C0062a(r110, r111.toString(), null, null, null, null, null, null, null, null, null, null, 4092)));
        r32.setOnClickListener(new w2(this, r33, r6));
        r21 = r32;
    L62:
        throw new NullPointerException("Missing required view with ID: ".concat(r27.getResources().getResourceName(r28)));
    L22:
        if (r11.intValue() != 2) goto L41;
        if (com.larus.utils.o0.d(r6.getIconUrl()) == false) goto L41;
        View r39 = LayoutInflater.from(getContext()).inflate(2131562680, this, r1);
        View r40 = r39.findViewById(2131387702);
        TextView r41 = (TextView) r39.findViewById(2131364378);
        TitleAvatarImageView r112 = r39.findViewById(2131364354);
        r39.findViewById(2131364355).a(true);
        r41.setText(r6.getContent());
        if (r112 == null) goto L31;
        String r42 = r6.getIconUrl();
        Intrinsics.checkNotNullParameter(r112, "avatar");
        GenericDraweeHierarchy r113 = r112.getHierarchy();
        if (r113 == null) goto L30;
        r113.setPlaceholderImage(v19.c.b(2130970535, getContext(), 2131102548));
    L30:
        r112.setActualImageResource(v19.c.b(2130970535, getContext(), 2131102548));
        final a3 r43 = new a3(r112);
        ImageLoaderKt.y(r112, r42, "prompt_span_avatar", new f2(r43), 4);
    L31:
        r40.setBackground(getDefaultBackground());
        b r44 = this.L;
        if (r44 == null) goto L34;
        r44.b(r6);
    L34:
        r40.setOnClickListener(new d(this, r6, r41));
        r41.setTag(2131388508, r6.getExtra());
        r41.setTag(2131388507, r6.getBotId());
        PromptContent.SuggestV2Extra r45 = r6.getSuggestV2Extra();
        ArrayList<Pair<View, a.C0062a>> r46 = this.d;
        String r114 = r6.getContent();
        Long r115 = "";
        if (r45 == null) goto L40;
        Long r47 = r45.getRsItemId();
        r115 = "";
        if (r47 == null) goto L40;
        r115 = r47;
    L40:
        r46.add(new Pair(r39, new a.C0062a(r114, r115.toString(), null, null, null, null, null, null, null, null, null, null, 4092)));
        this.e.add(r40);
        r9 = r39;
        goto L17
    L11:
        if (r7.length() == 0) goto L14;
        r8 = false;
        goto L15
    }

    private final void setTextBold(TextView r4) {
        if (Build.VERSION.SDK_INT < 28) goto L5;
        r4.setTypeface(Typeface.create(r4.getTypeface(), 500, r4.getTypeface().isItalic()));
        return;
    L5:
        r4.setTypeface(Typeface.defaultFromStyle(1));
    }

    public final void I(boolean r3) {
        if (this.k != r3) goto L5;
        return;
    L5:
        this.k = r3;
        if (r3 == false) goto L8;
        setBackgroundColor(v19.c.a(2130970529, getContext(), 2131102529));
        return;
    L8:
        setBackground(null);
    }

    @Override // ed8.d
    public final void a(int r4) {
        if (r4 > 0) goto L4;
        return;
    L4:
        if (r4 == this.P) goto L28;
        this.P = r4;
        FLogger.a.i("WcbSugPromptSpan", "onContainerWidthChanged width:" + r4);
        if (this.m == true) goto L9;
    L22:
        ViewGroup.LayoutParams r5 = getLayoutParams();
        if (r5 == null) goto L25;
        r5.width = s();
    L25:
        forceLayout();
        return;
    L9:
        if (this.l == true) goto L22;
        if (this.O == false) goto L17;
        ViewGroup.LayoutParams r6 = getLayoutParams();
        if (r6 == null) goto L25;
        r6.width = s();
        goto L25
    L17:
        if (this.n != null) goto L21;
        ViewGroup.LayoutParams r7 = getLayoutParams();
        if (r7 == null) goto L25;
        r7.width = s();
        goto L25
    L21:
        f();
        q();
        goto L25
    }

    public final CharSequence c(JsonObject r11) {
        if (r11 == null) goto L74;
        JsonElement r12 = r11.get("rich_contents");
        if (r12 != null) goto L7;
    L12:
        JsonArray r13 = null;
    L13:
        if (r13 != null) goto L16;
        return null;
    L16:
        if (r13.size() != 0) goto L18;
        return null;
    L18:
        SpannableStringBuilder r1 = new SpannableStringBuilder();
        int r2 = v19.c.a(2130970957, getContext(), 2131102626);
        Iterator r14 = r13.iterator();
    L19:
        boolean r4 = true;
        if (r14.hasNext() == false) goto L55;
        JsonElement r3 = (JsonElement) r14.next();
        if (r3 == null) goto L19;
        JsonObject r5 = r3.getAsJsonObject();
        if (r5 == null) goto L19;
        JsonElement r6 = r5.get(ChatDraftItem.TYPE_TEXT);
        if (r6 == null) goto L29;
        String r7 = r6.getAsString();
    L30:
        if (r7 != null) goto L33;
        r7 = "";
    L33:
        if (r7.length() != 0) goto L35;
        boolean r8 = true;
    L36:
        if (r8 == true) goto L19;
        JsonElement r9 = r5.get("type");
        if (r9 != null) goto L40;
    L42:
        r4 = false;
    L44:
        if (r4 == false) goto L50;
        Drawable r10 = AppCompatResources.getDrawable(getContext(), 2131242112);
        if (r10 == null) goto L50;
        Drawable r15 = r10.mutate();
        if (r15 == null) goto L50;
        r15.setColorFilter(new PorterDuffColorFilter(r2, PorterDuff.Mode.SRC_IN));
        r15.setBounds(0, 0, i5.m(), i5.m());
        int r16 = r1.length();
        r1.append("￼");
        r1.setSpan(new q(r15, i5.Y()), r16, r1.length(), 33);
    L50:
        int r17 = r1.length();
        r1.append(r7);
        int r18 = r1.length();
        if (r4 == false) goto L19;
        if (r18 <= r17) goto L19;
        r1.setSpan(new ForegroundColorSpan(r2), r17, r18, 33);
        goto L19
    L40:
        if (r9.getAsInt() != 1) goto L42;
    L35:
        r8 = false;
        goto L36
    L29:
        r7 = null;
        goto L30
    L55:
        if (r1.length() > 0) goto L58;
        r4 = false;
    L58:
        if (r4 == true) goto L60;
        return null;
    L60:
        return r1;
    L7:
        if (r12.isJsonArray() == true) goto L10;
        r12 = null;
    L10:
        if (r12 == null) goto L12;
        r13 = r12.getAsJsonArray();
        goto L13
    L74:
        return null;
    }

    public final void d(boolean r6) {
        this.w.b();
        c3 r0 = this.v;
        r0.d = false;
        r0.e++;
        List<? extends View> r1 = r0.f;
        r0.f = CollectionsKt.emptyList();
        if ((!r1.isEmpty()) == false) goto L8;
        Iterator<T> r7 = r1.iterator();
    L6:
        if (r7.hasNext() == false) goto L14;
        View r2 = (View) r7.next();
        r2.animate().cancel();
        r2.setTranslationY(0.0f);
        r2.setAlpha(1.0f);
        goto L6
    L14:
        return;
    L8:
        r0.a.animate().cancel();
        r0.a.setTranslationY(0.0f);
        if (r6 == false) goto L13;
        r0.a.setAlpha(1.0f);
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r8) {
        Intrinsics.checkNotNullParameter(r8, "event");
        Function1<? super String, Unit> r0 = this.F;
        if (r8.getActionMasked() != 0) goto L28;
        if (r0 == null) goto L28;
        Iterator r1 = CollectionsKt.take(this.d, 4).iterator();
    L6:
        String r3 = null;
        if (r1.hasNext() == false) goto L16;
        Object r2 = r1.next();
        if (((View) ((Pair) r2).component1()).getGlobalVisibleRect(this.G) == true) goto L11;
    L13:
        boolean r4 = false;
    L14:
        if (r4 == false) goto L6;
    L17:
        Pair r5 = (Pair) r2;
        FLogger r6 = FLogger.a;
        StringBuilder r7 = new StringBuilder("on action down ");
        if (r5 == null) goto L20;
        a.C0062a r9 = (a.C0062a) r5.getSecond();
    L21:
        r7.append(r9);
        r6.i("WcbSugPromptSpan", r7.toString());
        if (r5 == null) goto L28;
        a.C0062a r10 = (a.C0062a) r5.getSecond();
        if (r10 == null) goto L26;
        r3 = r10.c;
    L26:
        r0.invoke(r3);
        goto L28
    L20:
        r9 = null;
        goto L21
    L11:
        if (this.G.contains((int) r8.getRawX(), (int) r8.getRawY()) == false) goto L13;
        r4 = true;
        goto L14
    L16:
        r2 = null;
    L28:
        return super.dispatchTouchEvent(r8);
    }

    public final void e(boolean r4) {
        if (this.m == false) goto L6;
        if (r4 == true) goto L6;
        return;
    L6:
        this.m = true;
        setOrientation(1);
        setGravity(8388611);
        GradientDrawable r0 = new GradientDrawable();
        r0.setSize(1, getResources().getDimensionPixelSize(2131167600));
        setDividerDrawable(r0);
        setShowDividers(2);
        setLayoutParams(new ConstraintLayout.LayoutParams(s(), -2));
        boolean r5 = com.larus.platform.exp.t.a;
        if (com.larus.platform.exp.t.b == true) goto L10;
        this.b = g();
        return;
    }

    public final Drawable l(int r8) {
        int r0 = com.larus.utils.w0.a;
        Integer r1 = Integer.valueOf(getResources().getColor(R.color.transparent));
        Integer r2 = Integer.valueOf(getWcbSuggestPressColor());
        Integer r9 = Integer.valueOf(r8);
        Float r3 = Float.valueOf(i5.r0());
        Integer r4 = Integer.valueOf(i5.b());
        if (r1 == null) goto L5;
        int r5 = r1.intValue();
    L6:
        GradientDrawable r6 = new GradientDrawable();
        r6.setColor(r5);
        if (r9 == null) goto L13;
        r9.intValue();
        if (r4 == null) goto L11;
        int r7 = r4.intValue();
    L12:
        r6.setStroke(r7, r9.intValue());
        goto L13
    L11:
        r7 = 0;
    L13:
        if (r3 == null) goto L15;
        r6.setCornerRadius(r3.floatValue());
    L15:
        GradientDrawable r10 = new GradientDrawable();
        if (r2 == null) goto L18;
        r10.setColor(r2.intValue());
    L18:
        if (r9 == null) goto L24;
        r9.intValue();
        if (r4 == null) goto L22;
        int r11 = r4.intValue();
    L23:
        r10.setStroke(r11, r9.intValue());
        goto L24
    L22:
        r11 = 0;
    L24:
        if (r3 == null) goto L26;
        r10.setCornerRadius(r3.floatValue());
    L26:
        StateListDrawable r12 = new StateListDrawable();
        r12.addState(new int[]{R.attr.state_pressed}, r10);
        r12.addState(new int[0], r6);
        return r12;
    L5:
        r5 = 0;
        goto L6
    }

    public final Integer n(PromptContent.SuggestItem r3) {
        if (r() == false) goto L5;
        String r4 = r3.getFontColorDark();
    L6:
        Object r1 = null;
        if (com.larus.utils.o0.d(r4) == false) goto L20;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L10
        Object r5 = Result.constructor-impl(Integer.valueOf(Color.parseColor(r4)));     // Catch: Throwable -> L10
    L13:
        if (Result.isFailure-impl(r5) == true) goto L17;
        r1 = r5;
    L17:
        return (Integer) r1;
    L10:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L13
    L20:
        return null;
    L5:
        r4 = r3.getFontColorLight();
        goto L6
    }

    public final Integer o(PromptContent.SuggestV2 r3) {
        if (r() == false) goto L5;
        String r4 = r3.getFontColorDark();
    L6:
        Object r1 = null;
        if (com.larus.utils.o0.d(r4) == false) goto L20;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L10
        Object r5 = Result.constructor-impl(Integer.valueOf(Color.parseColor(r4)));     // Catch: Throwable -> L10
    L13:
        if (Result.isFailure-impl(r5) == true) goto L17;
        r1 = r5;
    L17:
        return (Integer) r1;
    L10:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L13
    L20:
        return null;
    L5:
        r4 = r3.getFontColorLight();
        goto L6
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration r4) {
        super.onConfigurationChanged(r4);
        com.larus.platform.service.e2 r0 = com.larus.platform.service.e2.a;
        Context r1 = getContext();
        if ((r1 instanceof Activity) == false) goto L5;
        Activity r2 = (Activity) r1;
    L7:
        if (r0.a(r2, r4) == false) goto L10;
        e(true);
        return;
    L10:
        return;
    L5:
        r2 = null;
        goto L7
    }

    public final void setImmerseBgColor(Integer r1) {
        this.N = r1;
    }

    public final void setOnSkillCardShow(Function0<Unit> r1) {
        this.D = r1;
    }

    public final void setShowExpandButton(boolean r1) {
        this.O = r1;
    }

    public final void u(com.larus.bmhome.chat.list.cell.prompt.r r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.F = r2;
    }

    public final void v(com.larus.bmhome.chat.list.cell.prompt.t r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.H = r2;
    }

    public final void w(com.larus.bmhome.chat.list.cell.prompt.s r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.I = r2;
    }

    public final void x(com.larus.bmhome.chat.list.cell.prompt.x r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.E = r2;
    }

    public final void y(com.larus.bmhome.chat.list.cell.prompt.u r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.J = r2;
    }

    public final void z(com.larus.bmhome.chat.list.cell.prompt.v r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.K = r2;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.larus.bmhome.chat.layout.item.r2] */
    /* JADX WARN: Type inference failed for: r0v1, types: [com.larus.bmhome.chat.layout.item.t2] */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.larus.bmhome.chat.layout.item.u2] */
    /* JADX WARN: Type inference failed for: r4v5, types: [com.larus.bmhome.chat.layout.item.q2] */
    /* JADX WARN: Type inference failed for: r4v6, types: [com.larus.bmhome.chat.layout.item.s2] */
    public PromptSpan(Context r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3);
        this.a = LazyKt.lazy(new l2(this));
        this.c = new y2(r3, this);
        this.d = new ArrayList();
        this.e = new ArrayList();
        this.f = new LinkedHashSet();
        this.r = new LinkedHashSet();
        this.v = new c3(this, new q2(this), new r2(this));
        this.w = new l3(this, new s2(this), new t2(this), new u2(this));
        this.G = new Rect();
        this.P = -1;
    }

    public static final String A(int r1, PromptContent.SuggestItem r2) {
        if (r2 == null) goto L16;
        String r3 = r2.getWcbItem();
        if (r3 == null) goto L16;
        if (r3.length() <= 0) goto L8;
        boolean r0 = true;
    L9:
        if (r0 == true) goto L12;
        r3 = null;
    L12:
        if (r3 == null) goto L16;
        String r4 = "wcb:".concat(r3);
        if (r4 == null) goto L16;
        return r4;
    L8:
        r0 = false;
    L16:
        return r1 + ":0";
    }

    public final void G(boolean r2, int r3) {
        this.i = r2;
        int r0 = 0;
        this.j = RangesKt.coerceAtLeast(r3, 0);
        if (r2 == false) goto L5;
        int r4 = 8388691;
    L6:
        setGravity(r4);
        if (r2 == true) goto L10;
        setMinimumHeight(0);
        return;
    L10:
        final int r5 = getResources().getDimensionPixelSize(2131167567);
        int r6 = this.j;
        if (r6 <= 0) goto L13;
        r0 = RangesKt.coerceAtLeast(r6 - r5, 0);
    L13:
        setMinimumHeight(r0);
        post(new x2(this, r5));
        return;
    L5:
        r4 = 8388611;
        goto L6
    }

    public static final void E(PromptSpan r20, int r21, int r22) {
        TextView r1 = h(r20, "", false, ContextCompat.getDrawable(r20.getContext(), v19.c.b(2130970761, r20.getContext(), 2131239448)), 2);
        r1.setTag(TuplesKt.to(Integer.valueOf(r21), 0));
        r20.d.add(new Pair(r1, new a.C0062a("", null, null, null, null, null, null, null, null, null, null, null, 4094)));
        r20.addView(r1, new LinearLayout.LayoutParams(r22, -2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v2, types: [android.view.View, com.larus.bmhome.chat.layout.widget.PromptCellLoading] */
    public final void F(boolean r3, int r4, boolean r5) {
        d(true);
        this.l = true;
        I(r5);
        f();
        G(r3, r4);
        setPadding(getLeftPadding(), 0, 0, R);
        ?? r6 = new PromptCellLoading(getContext(), null, 6, 0);
        r6.setLoadingStyle(2);
        addView(r6, new LinearLayout.LayoutParams(-2, -2));
    }

    public final void H(boolean r6, int r7, PromptContent r8, boolean r9) {
        FLogger.a.i("WcbLog", "[PromptSpan] span.skeleton span=" + hashCode() + " attached=" + isAttachedToWindow() + " shown=" + isShown() + " width=" + getWidth() + " height=" + getHeight() + " viewport=" + r7);
        d(true);
        this.l = true;
        I(r9);
        f();
        G(r6, r7);
        setPadding(getLeftPadding(), 0, 0, R);
        setShowDividers(0);
        Integer r10 = r8.getWcbTitleStyle();
        if (r10 != null) goto L6;
    L8:
        boolean r11 = false;
    L10:
        if (r11 == false) goto L12;
        LinearLayout r12 = new LinearLayout(getContext());
        r12.setOrientation(0);
        r12.setGravity(16);
        WcbSkeletonLoadingView r2 = new WcbSkeletonLoadingView(r12.getContext(), null, 6, 0);
        r2.setStyle(WcbSkeletonLoadingView.Style.TITLE);
        r12.addView(r2, new LinearLayout.LayoutParams(-2, -2));
        LinearLayout.LayoutParams r3 = new LinearLayout.LayoutParams(-2, i5.J());
        r3.bottomMargin = i5.r0();
        Unit r4 = Unit.INSTANCE;
        addView(r12, r3);
    L12:
        LinearLayout r13 = new LinearLayout(getContext());
        r13.setOrientation(1);
        r13.setGravity(8388611);
        int r0 = 0;
    L14:
        if (r0 >= 4) goto L19;
        WcbSkeletonLoadingView r5 = new WcbSkeletonLoadingView(getContext(), null, 6, 0);
        LinearLayout.LayoutParams r14 = new LinearLayout.LayoutParams(-2, -2);
        if (r0 <= 0) goto L18;
        r14.topMargin = i5.c();
    L18:
        Unit r15 = Unit.INSTANCE;
        r13.addView(r5, r14);
        r0 = r0 + 1;
        goto L14
    L19:
        addView(r13, new LinearLayout.LayoutParams(-2, -2));
        return;
    L6:
        if (r10.intValue() != 1) goto L8;
        r11 = true;
        goto L10
    }

    public final WcbItemLinearLayout i(PromptContent.SuggestItem r44, int r45, boolean r46, r3 r47) {
        Object r6 = null;
        final WcbItemLinearLayout r4 = new WcbItemLinearLayout(getContext(), null, 6, 0);
        r4.setOrientation(0);
        r4.setGravity(16);
        Integer r5 = r47.b;
        if (r5 == null) goto L6;
        r4.setMinimumHeight(r5.intValue());
    L6:
        if (r44.isRichText() == false) goto L8;
        final CustomMarkdownTextView r7 = new CustomMarkdownTextView(getContext(), null, 6, 0);
    L9:
        float r10 = r47.a;
        boolean r15 = true;
        if (this.N == null) goto L12;
        boolean r11 = true;
    L13:
        we8.a.b(r7, r10, r11, null, null, 12);
        if (n(r44) == null) goto L19;
        Integer r8 = n(r44);
        if (r8 == null) goto L18;
        int r0 = r8.intValue();
    L20:
        r7.setTextColor(r0);
        r7.setLineSpacing(0.0f, 1.1f);
        r44.setMarkdownContent(null);
        boolean r9 = r7 instanceof CustomMarkdownTextView;
        if (r9 == false) goto L50;
        CustomMarkdownTextView r12 = r7;
        r12.setMarkdownWidth(getPromptSpanMaxWidth());
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L38
        CharSequence r2 = c(r44.getDisplayRichTextContent());     // Catch: Throwable -> L38
        if (r2 == null) goto L26;
        r7.setText(r2);     // Catch: Throwable -> L38
    L36:
        Object r3 = Result.constructor-impl(Boolean.valueOf(r15));     // Catch: Throwable -> L38
    L40:
        Throwable r13 = Result.exceptionOrNull-impl(r3);
        if (r13 == null) goto L43;
        FLogger.a.e("WcbSugPromptSpan", "render markdown suggest failed, itemId:" + r44.getItemId(), r13);
    L43:
        Boolean r14 = Boolean.FALSE;
        if (Result.isFailure-impl(r3) == false) goto L47;
        r3 = r14;
    L47:
        if (((Boolean) r3).booleanValue() == true) goto L49;
        r12.setText(r44.getSuggest());
    L49:
        r12.setLinksClickable(false);
        r12.setMovementMethod(null);
        this.f.add(r7);
    L52:
        if (r44.isRichText() == true) goto L55;
        if (r46 == false) goto L55;
        setTextBold(r7);
    L55:
        r4.addView(r7, new LinearLayout.LayoutParams(-2, -2, 1.0f));
        Intrinsics.checkNotNullParameter(r44, "item");
        Intrinsics.checkNotNullParameter(r47, "promptUIConfig");
        boolean r16 = v19.h.a;
        if (v19.h.a(null) == false) goto L64;
        PromptContent.SuggestImageItem r17 = r44.getFrontDarkUrlItem();
        if (r17 == null) goto L61;
        String r18 = r17.getUrl();
        if (r18 == null) goto L61;
    L69:
        if (com.larus.utils.o0.d(r18) == false) goto L71;
        View r19 = new SimpleDraweeView(r4.getContext());
        r19.getHierarchy().setPlaceholderImage(2131102542);
        r19.getHierarchy().setFailureImage(2131102542);
        ImageLoaderKt.u(r19, r18, "prompt_span__front_icon_" + r44.getItemType());
        ViewGroup.MarginLayoutParams r20 = new ViewGroup.MarginLayoutParams(i5.q(), i5.q());
        r20.setMarginEnd(i5.Y());
        r4.addView(r19, 0, r20);
    L71:
        Integer r21 = r47.f;
        PromptContent.SuggestImageItem r22 = r44.getLightUrlItem();
        if (r22 == null) goto L75;
        String r23 = r22.getUrl();
        if (r23 == null) goto L75;
    L76:
        PromptContent.SuggestImageItem r24 = r44.getDarkUrlItem();
        if (r24 == null) goto L80;
        String r25 = r24.getUrl();
        if (r25 == null) goto L80;
    L82:
        if (com.larus.utils.o0.d(r23) == false) goto L102;
        View r26 = new SimpleDraweeView(r4.getContext());
        r26.getHierarchy().setPlaceholderImage(2131102542);
        r26.getHierarchy().setFailureImage(2131102542);
        String r110 = r44.getItemType();
        PromptContent.SuggestItemType r111 = PromptContent.SuggestItemType.VLM;
        if (Intrinsics.areEqual(r110, r111.getValue()) == false) goto L87;
        GenericDraweeHierarchy r112 = r26.getHierarchy();
        RoundingParams r113 = new RoundingParams();
        r113.setCornersRadius(i5.Y());
        r112.setRoundingParams(r113);
    L87:
        if (v19.h.a(null) == false) goto L91;
        if (r25 == null) goto L91;
        r23 = r25;
    L91:
        String r27 = r44.getItemType();
        if (r27 != null) goto L94;
        r27 = "0";
    L94:
        ImageLoaderKt.u(r26, r23, "prompt_span__".concat(r27));
        if (Intrinsics.areEqual(r44.getItemType(), r111.getValue()) == false) goto L97;
        Integer r28 = r47.h;
        Integer r29 = r47.j;
        ViewGroup.MarginLayoutParams r114 = new ViewGroup.MarginLayoutParams(i5.W(), i5.W());
    L98:
        if (r29 == null) goto L100;
        int r30 = r29.intValue();
    L101:
        r114.setMarginStart(r30);
        r4.addView(r26, r114);
        r21 = r28;
        goto L102
    L100:
        r30 = i5.Y();
        goto L101
    L97:
        r28 = r47.g;
        r29 = r47.i;
        r114 = new ViewGroup.MarginLayoutParams(i5.q(), i5.q());
    L102:
        Integer r31 = r47.e;
        if (r31 == null) goto L105;
        int r32 = r31.intValue();
    L106:
        if (r21 == null) goto L108;
        int r33 = r21.intValue();
    L109:
        Integer r34 = r47.c;
        if (r34 == null) goto L112;
        int r35 = r34.intValue();
    L113:
        Integer r36 = r47.d;
        if (r36 == null) goto L116;
        int r37 = r36.intValue();
    L117:
        r4.setPaddingRelative(r32, r35, r33, r37);
        if (r() == false) goto L121;
        String r38 = r44.getDarkBgColor();
        if (r38 == null) goto L121;
    L123:
        if (r() == false) goto L125;
        String r39 = r44.getStrokeColorDark();
    L127:
        if (com.larus.utils.o0.d(r38) == false) goto L139;
        if (this.N != null) goto L139;
        Result.Companion r40 = Result.Companion;     // Catch: Throwable -> L132
        Object r41 = Result.constructor-impl(Integer.valueOf(Color.parseColor(r38)));     // Catch: Throwable -> L132
    L135:
        if (Result.isFailure-impl(r41) == false) goto L137;
        r41 = null;
    L137:
        int r42 = com.larus.utils.w0.a;
        Drawable r43 = com.larus.utils.w0.a((Integer) r41, Integer.valueOf(getWcbSuggestPressColor()), Float.valueOf(i5.r0()), null);
    L155:
        r4.setBackground(r43);
        r4.setOnClickListener(new c(r44, this, r4));
        if (r9 == false) goto L158;
        r7.setOnTouchListener(new h2(r7, r4));
    L158:
        return r4;
    L132:
        th = move-exception;
        Result.Companion r48 = Result.Companion;
        r41 = Result.constructor-impl(ResultKt.createFailure(th));
    L139:
        if (com.larus.utils.o0.d(r39) == true) goto L141;
    L154:
        r43 = getDefaultBackground();
        goto L155
    L141:
        if (this.N != null) goto L154;
        Result.Companion r49 = Result.Companion;     // Catch: Throwable -> L144
        Object r50 = Result.constructor-impl(Integer.valueOf(Color.parseColor(r39)));     // Catch: Throwable -> L144
    L147:
        if (Result.isFailure-impl(r50) == true) goto L150;
        r6 = r50;
    L150:
        Integer r51 = (Integer) r6;
        if (r51 == null) goto L153;
        r51.intValue();
        r43 = l(r51.intValue());
        goto L155
    L153:
        r43 = getDefaultBackground();
    L144:
        th = move-exception;
        Result.Companion r52 = Result.Companion;
        r50 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L147
    L125:
        r39 = r44.getStrokeColorLight();
    L121:
        r38 = r44.getBgColor();
        goto L123
    L116:
        r37 = r4.getResources().getDimensionPixelSize(2131167597);
        goto L117
    L112:
        r35 = r4.getResources().getDimensionPixelSize(2131167597);
        goto L113
    L108:
        r33 = r4.getResources().getDimensionPixelSize(2131167595);
        goto L109
    L105:
        r32 = r4.getResources().getDimensionPixelSize(2131167595);
    L80:
        r25 = r44.getDarkIconUrl();
    L75:
        r23 = r44.getIconUrl();
    L61:
        PromptContent.SuggestImageItem r53 = r44.getFrontLightUrlItem();
        if (r53 == null) goto L67;
        r18 = r53.getUrl();
    L67:
        r18 = null;
        goto L69
    L64:
        PromptContent.SuggestImageItem r54 = r44.getFrontLightUrlItem();
        if (r54 == null) goto L67;
        r18 = r54.getUrl();
        goto L69
    L26:
        gw8.c.a.getClass();     // Catch: Throwable -> L38
        gw8.c r55 = gw8.c.a.b();     // Catch: Throwable -> L38
        if (r55 == null) goto L35;
        ow8.a r115 = (ow8.a) r7;     // Catch: Throwable -> L38
        String r116 = r44.getSuggest();     // Catch: Throwable -> L38
        if (r116 != null) goto L31;
        r116 = "";
    L31:
        lw8.l r56 = gw8.c.b.b(r55, r115, r116, true, new lw8.d(0, null, null, false, null, 0, null, 0.0f, null, 0, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, -33, 31));     // Catch: Throwable -> L38
        if (r56 == null) goto L35;
        r7.setMarkdown(r56);     // Catch: Throwable -> L38
        r44.setMarkdownContent(r56);     // Catch: Throwable -> L38
    L35:
        r15 = false;
    L38:
        th = move-exception;
        Result.Companion r117 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L40
    L50:
        r7.setText(r44.getSuggest());
        goto L52
    L18:
        r0 = ContextCompat.getColor(getContext(), r45);
        goto L20
    L19:
        r0 = ContextCompat.getColor(getContext(), r45);
        goto L20
    L12:
        r11 = false;
        goto L13
    L8:
        r7 = new TextView(getContext());
        goto L9
    }

    public final LinearLayout k(int r24, PromptContent.SuggestV2 r25, String r26, boolean r27) {
        LinearLayout r2 = new LinearLayout(getContext());
        r2.setGravity(16);
        PromptContent.SuggestV2ExtraForMultiAction r0 = r25.getSuggestV2ExtForMultiAction();
        Object r3 = null;
        if (r0 == null) goto L5;
        String r1 = r0.getSuggestStyle();
    L6:
        PromptContent.SuggestV2Style r4 = PromptContent.SuggestV2Style.COLORFUL;
        String r9 = "";
        if (Intrinsics.areEqual(r1, r4.getValue()) == false) goto L17;
        TextView r5 = new TextView(r2.getContext());
        float r12 = i5.m();
        if (this.N == null) goto L11;
        boolean r13 = true;
    L12:
        we8.a.b(r5, r12, r13, null, null, 12);
        r5.setLineSpacing(0.0f, 1.1f);
        String r6 = r25.getContent();
        if (r6 == null) goto L16;
        r9 = r6;
    L16:
        r5.setText(r9);
        r5.setTextColor(U);
        r5.addOnLayoutChangeListener(new z2(r5));
    L33:
        r2.addView(r5);
        if (r() == false) goto L36;
        String r7 = r25.getDarkIconUrl();
    L37:
        if (r7 == null) goto L60;
        SimpleDraweeView r8 = new SimpleDraweeView(r2.getContext());
        r8.setLayoutParams(new LinearLayout.LayoutParams(i5.m(), i5.m()));
        ViewGroup.LayoutParams r10 = r8.getLayoutParams();
        if ((r10 instanceof ViewGroup.MarginLayoutParams) == false) goto L42;
        ViewGroup.MarginLayoutParams r11 = (ViewGroup.MarginLayoutParams) r10;
    L43:
        if (r11 == null) goto L45;
        r11.leftMargin = i5.Y();
    L45:
        ImageLoaderKt.y(r8, r7, "prompt_span_avatar", new i2(), 4);
        if (Intrinsics.areEqual(r1, r4.getValue()) == true) goto L114;
    L59:
        r2.addView(r8);
        goto L60
    L114:
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L49
        Object r15 = Result.constructor-impl(Integer.valueOf(Color.parseColor("#C471EB")));     // Catch: Throwable -> L49
    L52:
        if (Result.isFailure-impl(r15) == false) goto L54;
        r15 = null;
    L54:
        Integer r16 = (Integer) r15;
        if (r16 == null) goto L57;
        int r17 = r16.intValue();
    L58:
        r8.setColorFilter(new PorterDuffColorFilter(r17, PorterDuff.Mode.SRC_ATOP));
        goto L59
    L57:
        r17 = -16777216;
    L49:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r15 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L52
    L42:
        r11 = null;
    L60:
        r2.setTag(TuplesKt.to(Integer.valueOf(r24), 0));
        r2.setTag(2131388508, r25.getExtra());
        r2.setTag(2131388507, r25.getBotId());
        this.d.add(new Pair(r2, new a.C0062a(r25.getContent(), r26, null, null, null, null, null, null, null, null, null, null, 4092)));
        if (r() == false) goto L63;
        String r19 = r25.getStrokeColorDark();
    L64:
        PromptContent.SuggestV2ExtraForMultiAction r20 = r25.getSuggestV2ExtForMultiAction();
        if (r20 == null) goto L67;
        String r21 = r20.getSuggestStyle();
    L69:
        if (com.larus.utils.o0.d(r19) == false) goto L84;
        Result.Companion r22 = Result.Companion;     // Catch: Throwable -> L72
        Object r23 = Result.constructor-impl(Integer.valueOf(Color.parseColor(r19)));     // Catch: Throwable -> L72
    L75:
        if (Result.isFailure-impl(r23) == true) goto L78;
        r3 = r23;
    L78:
        Integer r28 = (Integer) r3;
        if (r28 == null) goto L81;
        r28.intValue();
        Drawable r29 = l(r28.intValue());
    L82:
        r2.setBackground(r29);
    L104:
        int r30 = r2.getResources().getDimensionPixelSize(2131167597);
        Lazy r31 = com.larus.bmhome.utils.z1.a;
        if (com.larus.bmhome.utils.z1.b(0, this.N) == false) goto L107;
        int r32 = r2.getResources().getDimensionPixelSize(2131167594);
    L108:
        r2.setPaddingRelative(r32, r30, r32, r30);
        if (r27 == false) goto L111;
        com.larus.utils.e1.c(r2, this.c);
    L111:
        return r2;
    L107:
        r32 = r2.getResources().getDimensionPixelSize(2131167593);
        goto L108
    L81:
        r29 = getDefaultBackground();
    L72:
        th = move-exception;
        Result.Companion r33 = Result.Companion;
        r23 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L75
    L84:
        if (Intrinsics.areEqual(r21, PromptContent.SuggestV2Style.COLORFUL.getValue()) == false) goto L103;
        int[] r34 = T;
        Float r35 = Float.valueOf(0.6f);
        int r36 = com.larus.utils.w0.a;
        Integer r37 = Integer.valueOf(getResources().getColor(R.color.transparent));
        Integer r110 = Integer.valueOf(getWcbSuggestPressColor());
        Float r38 = Float.valueOf(i5.r0());
        Float r39 = Float.valueOf(i5.b());
        if (r37 == null) goto L88;
        int r111 = r37.intValue();
    L90:
        if (r39 == null) goto L92;
        float r112 = r39.floatValue();
    L93:
        if (r34 != null) goto L95;
        r34 = new int[0];
    L95:
        int[] r113 = r34;
        if (r38 == null) goto L98;
        float r114 = r38.floatValue();
    L99:
        if (r35 == null) goto L101;
        float r115 = r35.floatValue();
    L102:
        r2.setBackground(new com.larus.utils.x(r112, r113, r114, r115, r111, r110));
        goto L104
    L101:
        r115 = 1.0f;
        goto L102
    L98:
        r114 = 0.0f;
        goto L99
    L92:
        r112 = 0.0f;
        goto L93
    L88:
        r111 = 0;
        goto L90
    L103:
        r2.setBackground(getDefaultBackground());
        goto L104
    L67:
        r21 = null;
        goto L69
    L63:
        r19 = r25.getStrokeColorLight();
        goto L64
    L36:
        r7 = r25.getIconUrl();
        goto L37
    L11:
        r13 = false;
        goto L12
    L17:
        r5 = new TextView(r2.getContext());
        Integer r116 = o(r25);
        if (r116 == null) goto L21;
        r5.setTextColor(r116.intValue());
    L24:
        float r117 = i5.m();
        if (this.N == null) goto L27;
        boolean r118 = true;
    L28:
        we8.a.b(r5, r117, r118, null, null, 12);
        r5.setLineSpacing(0.0f, 1.1f);
        String r40 = r25.getContent();
        if (r40 == null) goto L32;
        r9 = r40;
    L32:
        r5.setText(r9);
        goto L33
    L27:
        r118 = false;
        goto L28
    L21:
        if (this.N == null) goto L23;
        r5.setTextColor(v19.c.a(2130972312, r2.getContext(), 2131103298));
        goto L24
    L23:
        r5.setTextColor(ContextCompat.getColor(r2.getContext(), v19.c.b(2130972079, r2.getContext(), 2131103136)));
        goto L24
    L5:
        r1 = null;
        goto L6
    }

    public final TextView p(int r22, PromptContent.SuggestV2 r23, String r24, boolean r25) {
        String r0 = r23.getContent();
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        TextView r2 = h(this, r0, r25, null, 8);
        r2.setTag(TuplesKt.to(Integer.valueOf(r22), 0));
        r2.setTag(2131388508, r23.getExtra());
        r2.setTag(2131388507, r23.getBotId());
        Integer r4 = o(r23);
        if (r4 == null) goto L8;
        r2.setTextColor(r4.intValue());
    L8:
        this.d.add(new Pair(r2, new a.C0062a(r23.getContent(), r24, null, null, null, null, null, null, null, null, null, null, 4092)));
        if (r() == false) goto L11;
        String r1 = r23.getStrokeColorDark();
    L13:
        if (com.larus.utils.o0.d(r1) == true) goto L28;
    L27:
        return r2;
    L28:
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L16
        Object r5 = Result.constructor-impl(Integer.valueOf(Color.parseColor(r1)));     // Catch: Throwable -> L16
    L19:
        if (Result.isFailure-impl(r5) == false) goto L21;
        Object r6 = null;
    L22:
        Integer r7 = (Integer) r6;
        if (r7 == null) goto L25;
        r7.intValue();
        Drawable r8 = l(r7.intValue());
    L26:
        r2.setBackground(r8);
        goto L27
    L25:
        r8 = getDefaultBackground();
        goto L26
    L21:
        r6 = r5;
    L16:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L19
    L11:
        r1 = r23.getStrokeColorLight();
        goto L13
    }

    public static TextView h(PromptSpan r9, String r10, boolean r11, Drawable r12, int r13) {
        if ((r13 & 4) == 0) goto L6;
        r11 = true;
    L6:
        if ((r13 & 8) == 0) goto L8;
        r12 = null;
    L8:
        r9.getClass();
        TextView r14 = new TextView(r9.getContext());
        if (r9.N == null) goto L11;
        r14.setTextColor(v19.c.a(2130972312, r9.getContext(), 2131103298));
    L12:
        float r3 = i5.m();
        if (r9.N == null) goto L15;
        boolean r4 = true;
    L16:
        we8.a.b(r14, r3, r4, Float.valueOf(i5.h()), null, 8);
        r14.setLineSpacing(0.0f, 1.1f);
        Lazy r0 = com.larus.bmhome.utils.z1.a;
        if (com.larus.bmhome.utils.z1.b(0, r9.N) == false) goto L19;
        r14.setPaddingRelative(r14.getResources().getDimensionPixelSize(2131167594), r14.getResources().getDimensionPixelSize(2131167597), r14.getResources().getDimensionPixelSize(2131167594), r14.getResources().getDimensionPixelSize(2131167597));
    L20:
        if (r12 != null) goto L22;
        r12 = r9.getDefaultBackground();
    L22:
        r14.setBackground(r12);
        r14.setText(r10);
        if (r11 == false) goto L25;
        com.larus.utils.e1.c(r14, r9.c);
    L25:
        return r14;
    L19:
        r14.setPaddingRelative(r14.getResources().getDimensionPixelSize(2131167593), r14.getResources().getDimensionPixelSize(2131167597), r14.getResources().getDimensionPixelSize(2131167593), r14.getResources().getDimensionPixelSize(2131167597));
        goto L20
    L15:
        r4 = false;
        goto L16
    L11:
        r14.setTextColor(ContextCompat.getColor(r9.getContext(), v19.c.b(2130972079, r9.getContext(), 2131103136)));
        goto L12
    }

    public static final void C(final PromptSpan r7, String r8, boolean r9, PromptContent r10, OnboardingActionCardData.CardScene r11, OnboardingActionCardData r12, View.OnClickListener r13, Function3<Object, ? super Integer, ? super View, Unit> r14, Function0<Unit> r15, String r16, boolean r17, int r18, boolean r19, Boolean r20, String r21, String r22) {
        MessageLoading r2 = r7.b;
        if (r2 == null) goto L5;
        r2.e.cancel();
        r2.c = false;
    L5:
        r7.l = false;
        r7.f();
        if (Intrinsics.areEqual(r8, r7.s) == false) goto L8;
        if (r9 == true) goto L8;
    L9:
        r7.n = r10;
        String r3 = null;
        r7.o = null;
        r7.p = null;
        r7.y = r11;
        r7.z = r12;
        r7.C = r13;
        r7.A = r14;
        r7.B = r15;
        r7.x = r16;
        r7.G(r17, r18);
        if (r19 == true) goto L12;
        r7.O = false;
        r7.q();
    L13:
        r7.s = r8;
        if (r20 != null) goto L16;
        r3 = r21;
    L16:
        r7.t = r3;
        r7.u = r22;
        return;
    L12:
        r7.O = true;
        r7.setPadding(0, 0, 0, 0);
        PromptExpandButton r4 = new PromptExpandButton(r7.getContext());
        com.larus.utils.e1.d(r4, new p2(r7));
        r4.setImmersedBgColor(r7.N);
        LinearLayout.LayoutParams r5 = new LinearLayout.LayoutParams(-2, -2);
        r5.setMarginStart(r7.getResources().getDimensionPixelSize(2131167568));
        r7.addView(r4, r5);
    L8:
        r7.r.clear();
        goto L9
    }
}
