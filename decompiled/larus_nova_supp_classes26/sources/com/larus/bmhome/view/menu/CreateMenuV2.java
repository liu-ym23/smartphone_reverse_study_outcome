package com.larus.bmhome.view.menu;

import android.R;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.Layout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.widget.TextViewCompat;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.view.screenmenu.MenuItemType;
import com.larus.bmhome.view.screenmenu.l0;
import com.larus.bmhome.view.screenmenu.m0;
import com.larus.bmhome.view.screenmenu.widget.MaxWidthLinearLayout;
import com.larus.common_res.common_ui.databinding.LarusCreateMenuItemBtnLayoutV2Binding;
import com.larus.common_res.common_ui.databinding.LarusCreateMenuItemLayoutV2Binding;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.utils.e1;
import com.larus.utils.o0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kt8.q;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000Ø\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0010\u0018\u0000 É\u00012\u00020\u0001:\u001c¼\u0001½\u0001¾\u0001¿\u0001À\u0001Á\u0001Â\u0001Ã\u0001Ä\u0001Å\u0001Æ\u0001Ç\u0001È\u0001É\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u0010\u00108\u001a\u00020%2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002JÃ\u0001\u00109\u001a\u00020 2\f\u0010:\u001a\b\u0012\u0004\u0012\u00020<0;2\b\b\u0002\u0010=\u001a\u00020\n2\b\b\u0002\u0010>\u001a\u00020\"2\b\b\u0002\u0010?\u001a\u00020\"2\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010A\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010B\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010C\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010D\u001a\u00020-2\u001e\b\u0002\u0010(\u001a\u0018\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010)\u0012\u0004\u0012\u00020%\u0018\u00010'2\u001c\b\u0002\u0010&\u001a\u0016\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020%\u0018\u00010'2\u0012\u0010E\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020%0$¢\u0006\u0002\u0010FJÃ\u0001\u0010G\u001a\u00020 2\f\u0010:\u001a\b\u0012\u0004\u0012\u00020<0;2\b\b\u0002\u0010=\u001a\u00020\n2\b\b\u0002\u0010>\u001a\u00020\"2\b\b\u0002\u0010?\u001a\u00020\"2\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010A\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010B\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010C\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010D\u001a\u00020-2\u001e\b\u0002\u0010(\u001a\u0018\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010)\u0012\u0004\u0012\u00020%\u0018\u00010'2\u001c\b\u0002\u0010&\u001a\u0016\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020%\u0018\u00010'2\u0012\u0010E\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020%0$¢\u0006\u0002\u0010FJ»\u0001\u0010H\u001a\u00020 2\f\u0010:\u001a\b\u0012\u0004\u0012\u00020<0;2\b\u0010I\u001a\u0004\u0018\u0001052\u0006\u0010=\u001a\u00020\n2\u0006\u0010>\u001a\u00020\"2\u0006\u0010?\u001a\u00020\"2\b\u0010@\u001a\u0004\u0018\u00010\n2\b\u0010A\u001a\u0004\u0018\u00010\n2\b\u0010B\u001a\u0004\u0018\u00010\n2\b\u0010C\u001a\u0004\u0018\u00010\n2\u0006\u0010D\u001a\u00020-2\u001c\u0010(\u001a\u0018\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010)\u0012\u0004\u0012\u00020%\u0018\u00010'2\u001a\u0010&\u001a\u0016\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020%\u0018\u00010'2\u0012\u0010E\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020%0$H\u0002¢\u0006\u0002\u0010JJ\u009d\u0001\u0010K\u001a\b\u0012\u0004\u0012\u00020L0;2\f\u0010:\u001a\b\u0012\u0004\u0012\u00020<0;2\u0006\u0010?\u001a\u00020\"2\b\u0010@\u001a\u0004\u0018\u00010\n2\b\u0010A\u001a\u0004\u0018\u00010\n2\b\u0010B\u001a\u0004\u0018\u00010\n2\u0006\u0010D\u001a\u00020-2\u001c\u0010(\u001a\u0018\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010)\u0012\u0004\u0012\u00020%\u0018\u00010'2\u001a\u0010&\u001a\u0016\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020%\u0018\u00010'2\u0012\u0010E\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020%0$H\u0002¢\u0006\u0002\u0010MJ#\u0010N\u001a\u00020 *\u0002052\u0006\u0010=\u001a\u00020\n2\b\u0010C\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0002\u0010OJ\u0014\u0010P\u001a\u00020\"*\u0002052\u0006\u0010>\u001a\u00020\"H\u0002J\u0018\u0010Q\u001a\u00020%2\u0006\u0010R\u001a\u00020\n2\b\u0010S\u001a\u0004\u0018\u00010<J \u0010T\u001a\u00020%2\u0006\u0010U\u001a\u00020\"2\u0010\b\u0002\u0010E\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010VJ*\u0010W\u001a\u00020%2\u0006\u0010R\u001a\u00020\n2\u0006\u0010X\u001a\u00020\"2\b\b\u0002\u0010Y\u001a\u00020\n2\b\b\u0002\u0010Z\u001a\u00020\nJ\u000e\u0010[\u001a\u00020%2\u0006\u0010\\\u001a\u00020\nJ\u000e\u0010]\u001a\u00020%2\u0006\u0010\\\u001a\u00020\nJ\u001c\u0010^\u001a\u00020%2\u0014\u0010E\u001a\u0010\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020%\u0018\u00010$J\u000e\u0010_\u001a\u00020%2\u0006\u0010R\u001a\u00020\nJ\u0010\u0010`\u001a\u0004\u0018\u00010 2\u0006\u0010R\u001a\u00020\nJ\b\u0010a\u001a\u00020\u0018H\u0002J\b\u0010b\u001a\u00020%H\u0002J\u0016\u0010c\u001a\u00020%2\f\u0010d\u001a\b\u0012\u0004\u0012\u00020L0;H\u0002J\u0010\u0010e\u001a\u00020%2\u0006\u0010f\u001a\u00020\nH\u0002J\u0016\u0010g\u001a\u00020\n2\f\u0010d\u001a\b\u0012\u0004\u0012\u00020L0;H\u0002J\u0010\u0010h\u001a\u00020\n2\u0006\u0010i\u001a\u00020LH\u0002J\u0010\u0010j\u001a\u00020\n2\u0006\u0010i\u001a\u00020LH\u0002J\u0010\u0010k\u001a\u00020\n2\u0006\u0010i\u001a\u00020LH\u0002J\u0010\u0010l\u001a\u00020\n2\u0006\u0010i\u001a\u00020LH\u0002J\f\u0010m\u001a\u00020\n*\u00020nH\u0002J\f\u0010o\u001a\u00020\n*\u00020nH\u0002J\f\u0010p\u001a\u00020\n*\u00020nH\u0002J\b\u0010q\u001a\u00020\nH\u0002J\f\u0010r\u001a\u00020\n*\u00020 H\u0002J\f\u0010s\u001a\u00020\n*\u00020 H\u0002J\u001d\u0010t\u001a\u00020\n*\u00020 2\n\b\u0002\u0010B\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0002\u0010uJ\u001d\u0010v\u001a\u00020\n*\u00020 2\n\b\u0002\u0010B\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0002\u0010uJ\f\u0010w\u001a\u00020\n*\u00020xH\u0002J4\u0010y\u001a\u00020\n*\u00020x2\u0006\u0010z\u001a\u00020\n2\u0006\u0010{\u001a\u00020\n2\u0006\u0010|\u001a\u00020\n2\u0006\u0010}\u001a\u00020\n2\u0006\u0010~\u001a\u00020\nH\u0002J\u000f\u0010\u007f\u001a\u00020\n*\u0005\u0018\u00010\u0080\u0001H\u0002J\u001a\u0010\u0081\u0001\u001a\u00020%2\u0007\u0010\u0082\u0001\u001a\u00020 2\u0006\u0010\\\u001a\u00020\nH\u0002J\t\u0010\u0083\u0001\u001a\u00020%H\u0002J\u0011\u0010\u0084\u0001\u001a\u00020%2\u0006\u0010I\u001a\u00020 H\u0002J\u0011\u0010\u0085\u0001\u001a\u00020%2\u0006\u0010I\u001a\u00020 H\u0002J\t\u0010\u0086\u0001\u001a\u00020%H\u0002J\u0011\u0010\u0087\u0001\u001a\u00020%2\u0006\u0010?\u001a\u00020\"H\u0002J\u0019\u0010\u0088\u0001\u001a\b\u0012\u0004\u0012\u00020L0;*\b\u0012\u0004\u0012\u00020<0;H\u0002J%\u0010\u0089\u0001\u001a\u00020%2\u0007\u0010\u008a\u0001\u001a\u00020x2\u0006\u0010S\u001a\u00020<2\t\u0010\u008b\u0001\u001a\u0004\u0018\u00010\u001eH\u0002J%\u0010\u008c\u0001\u001a\u00020%2\u0007\u0010\u008a\u0001\u001a\u00020x2\u0006\u0010S\u001a\u00020<2\t\u0010\u008b\u0001\u001a\u0004\u0018\u00010\u001eH\u0002J\u001a\u0010\u008d\u0001\u001a\u00020%2\u0007\u0010\u008a\u0001\u001a\u00020x2\u0006\u0010S\u001a\u00020<H\u0002J\u001e\u0010\u008e\u0001\u001a\u00020%*\u00020 2\u0006\u0010\\\u001a\u00020\n2\u0007\u0010\u008f\u0001\u001a\u00020\nH\u0002J\u0012\u0010\u0090\u0001\u001a\u00020%2\u0007\u0010\u008a\u0001\u001a\u00020xH\u0002J%\u0010\u0091\u0001\u001a\u00020%2\u0007\u0010\u008a\u0001\u001a\u00020x2\u0006\u0010S\u001a\u00020<2\t\b\u0002\u0010\u0092\u0001\u001a\u00020\"H\u0002J\u0012\u0010\u0093\u0001\u001a\u00020%2\u0007\u0010\u008a\u0001\u001a\u00020xH\u0002J\u0012\u0010\u0094\u0001\u001a\u00020\n2\u0007\u0010\u008a\u0001\u001a\u00020xH\u0002J\u0012\u0010\u0095\u0001\u001a\u00020%2\u0007\u0010\u008a\u0001\u001a\u00020xH\u0002J%\u0010\u0096\u0001\u001a\u00020%2\u0007\u0010\u008a\u0001\u001a\u00020x2\u0006\u0010S\u001a\u00020<2\t\u0010\u008b\u0001\u001a\u0004\u0018\u00010\u001eH\u0002J\u0018\u0010\u0097\u0001\u001a\u00020\"*\u00020<2\t\u0010\u008b\u0001\u001a\u0004\u0018\u00010\u001eH\u0002J\u0018\u0010\u0098\u0001\u001a\u00020\"*\u00020<2\t\u0010\u008b\u0001\u001a\u0004\u0018\u00010\u001eH\u0002J\u001a\u0010\u0099\u0001\u001a\u00020%2\u0007\u0010\u008a\u0001\u001a\u00020x2\u0006\u0010U\u001a\u00020\"H\u0002J\r\u0010\u009a\u0001\u001a\u00020\n*\u00020 H\u0002J\u001a\u0010\u009b\u0001\u001a\u00020%2\u0007\u0010\u009c\u0001\u001a\u00020n2\u0006\u0010S\u001a\u00020<H\u0002J\u001a\u0010\u009d\u0001\u001a\u00020%2\u0007\u0010\u008a\u0001\u001a\u00020x2\u0006\u0010S\u001a\u00020<H\u0002J\u0012\u0010\u009e\u0001\u001a\u00020%2\u0007\u0010\u008a\u0001\u001a\u00020xH\u0002J\r\u0010\u009f\u0001\u001a\u00020%*\u00020 H\u0002J\r\u0010 \u0001\u001a\u00020%*\u00020 H\u0002J\r\u0010¡\u0001\u001a\u00020%*\u00020 H\u0002J\r\u0010¢\u0001\u001a\u00020%*\u00020 H\u0002J$\u0010£\u0001\u001a\u00020%2\b\u0010\u008a\u0001\u001a\u00030¤\u00012\u0006\u0010S\u001a\u00020<2\u0007\u0010¥\u0001\u001a\u00020 H\u0002J+\u0010¦\u0001\u001a\u00020%2\u0007\u0010§\u0001\u001a\u00020 2\u0006\u0010S\u001a\u00020<2\u0006\u0010X\u001a\u00020\"2\u0007\u0010¥\u0001\u001a\u00020 H\u0002J\u001a\u0010¨\u0001\u001a\u00020%2\u0006\u0010S\u001a\u00020<2\u0007\u0010¥\u0001\u001a\u00020 H\u0002J\u001b\u0010©\u0001\u001a\u00020%2\b\u0010ª\u0001\u001a\u00030«\u00012\u0006\u0010i\u001a\u00020LH\u0002J\u0013\u0010¬\u0001\u001a\u0004\u0018\u00010+2\u0006\u0010i\u001a\u00020LH\u0002J\u0011\u0010\u00ad\u0001\u001a\u00020 2\u0006\u0010S\u001a\u00020<H\u0002J\u001b\u0010®\u0001\u001a\u00020%2\u0007\u0010\u0082\u0001\u001a\u00020 2\u0007\u0010¯\u0001\u001a\u00020\"H\u0002J&\u0010°\u0001\u001a\u0004\u0018\u00010\n2\n\u0010±\u0001\u001a\u0005\u0018\u00010²\u00012\u0007\u0010³\u0001\u001a\u00020\"H\u0002¢\u0006\u0003\u0010´\u0001J&\u0010µ\u0001\u001a\u00030¶\u00012\u0007\u0010·\u0001\u001a\u00020\n2\u0007\u0010¸\u0001\u001a\u00020\n2\b\u0010¹\u0001\u001a\u00030º\u0001H\u0002J\r\u0010»\u0001\u001a\u00020n*\u00020nH\u0002R\u001f\u0010\f\u001a\u00060\rR\u00020\u00008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u001f\u0010\u0012\u001a\u00060\u0013R\u00020\u00008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0017\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0011\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u001e0\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020%\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010&\u001a\u0016\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020%\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010(\u001a\u0018\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010)\u0012\u0004\u0012\u00020%\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u00101\u001a\u00020\n2\u0006\u00100\u001a\u00020\n@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0010\u00104\u001a\u0004\u0018\u000105X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u00106\u001a\u0010\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020%\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006Ê\u0001"}, d2 = {"Lcom/larus/bmhome/view/menu/CreateMenuV2;", "Lcom/larus/bmhome/view/screenmenu/widget/MaxWidthLinearLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "menuAdapter", "Lcom/larus/bmhome/view/menu/CreateMenuV2$CreateMenuAdapter;", "getMenuAdapter", "()Lcom/larus/bmhome/view/menu/CreateMenuV2$CreateMenuAdapter;", "menuAdapter$delegate", "Lkotlin/Lazy;", "menuDividerDecoration", "Lcom/larus/bmhome/view/menu/CreateMenuV2$MenuDividerDecoration;", "getMenuDividerDecoration", "()Lcom/larus/bmhome/view/menu/CreateMenuV2$MenuDividerDecoration;", "menuDividerDecoration$delegate", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "recyclerView$delegate", "loadingStates", "", "Lcom/larus/bmhome/view/menu/CreateMenuV2$LoadingState;", "maskView", "Landroid/view/View;", "lastIsDarkMode", "", "clickListener", "Lkotlin/Function1;", "", "clickWithAnchorListener", "Lkotlin/Function2;", "unEnableListener", "", "menuDividerDrawable", "Landroid/graphics/drawable/Drawable;", "currentConfig", "Lcom/larus/bmhome/view/menu/CreateMenu$Companion$MenuItemConfig;", "currentForceDark", "currentMaxWidth", "value", "currentMenuWidth", "getCurrentMenuWidth", "()I", "wrapperView", "Landroid/view/ViewGroup;", "onMenuSizeChangedListener", "hasPendingMenuSizeDispatch", "init", "prepare", "items", "", "Lcom/larus/bmhome/view/screenmenu/MenuItem;", "padding", "needMask", "forceDark", "showDividers", "minimumWidth", "maxWidth", "maxHeight", "config", "listener", "(Ljava/util/List;IZZLjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/larus/bmhome/view/menu/CreateMenu$Companion$MenuItemConfig;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;)Landroid/view/View;", "refresh", "rebuildMenuWrapper", "wrapper", "(Ljava/util/List;Landroid/view/ViewGroup;IZZLjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/larus/bmhome/view/menu/CreateMenu$Companion$MenuItemConfig;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;)Landroid/view/View;", "updateMenuContent", "Lcom/larus/bmhome/view/menu/CreateMenuV2$MenuRow;", "(Ljava/util/List;ZLjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/larus/bmhome/view/menu/CreateMenu$Companion$MenuItemConfig;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;)Ljava/util/List;", "prepareWrapper", "(Landroid/view/ViewGroup;ILjava/lang/Integer;)Landroid/view/View;", "canReuseWrapper", "updateButtonMenuItem", "id", "menu", "setMaskView", "visible", "Lkotlin/Function0;", "setMenuItemLoading", "loading", "loadingDrawableRes", "originalIconRes", "setMiniWidth", "width", "setMenuWidth", "setOnMenuSizeChangedListener", "scrollToMenuItem", "findMenuItemAnchor", "createRecyclerView", "ensureRecyclerView", "updateMenuWidth", "rows", "applyMenuWidth", "targetWidth", "resolveMenuWidth", "measureMenuRowWidth", "row", "measureHeaderMenuRowWidth", "measureDefaultMenuRowWidth", "measureButtonMenuRowWidth", "measureDesiredWidth", "Landroid/widget/TextView;", "resolveDesiredTextContentWidth", "resolveDesiredLayoutWidth", "resolveMenuWidthBudgetForMeasure", "marginStart", "marginEnd", "measureDesiredWidthIfVisible", "(Landroid/view/View;Ljava/lang/Integer;)I", "measureDesiredWidthWithLayoutParamIfVisible", "resolveRightReservedWidthWithoutTextContent", "Lcom/larus/common_res/common_ui/databinding/LarusCreateMenuItemLayoutV2Binding;", "resolveRightContainerWidthForTotalWidth", "totalWidth", "titleWidth", "titleIconWidth", "tagWidth", "blueTagWidth", "horizontalMargin", "Landroid/view/ViewGroup$MarginLayoutParams;", "updateLayoutWidth", "view", "dispatchMenuSizeChanged", "notifyMenuSizeChanged", "measureWrapper", "updateMaskLayout", "applyMenuTheme", "toMenuRows", "bindDefaultMenuItemForMeasure", "binding", "loadingState", "bindDefaultMenuItem", "applyDefaultMenuItemConfig", "updateLayoutSize", "height", "resetDefaultItemLayoutForBind", "bindTitleIcon", "loadImage", "updateMenuTextWidthForTag", "resolveTitleRowAvailableWidth", "updateRightTextWidthForRemainingSpace", "bindLeftArea", "hasLeftContent", "hasLeftContentWithoutCustomView", "updateLeftContainerVisibility", "visibleWidth", "bindRightText", "rightTextView", "bindRightArea", "ensureRightContainerVisible", "ensureWrapContentWidth", "ensureZeroWidth", "ensureLinearWeightWidth", "ensureLinearWrapContentWidth", "bindButtonMenuItem", "Lcom/larus/common_res/common_ui/databinding/LarusCreateMenuItemBtnLayoutV2Binding;", "anchorView", "bindMenuClickState", "root", "handleMenuClick", "applyRowContainerStyle", "container", "Landroid/widget/LinearLayout;", "createRowBackground", "createSectionDividerView", "setRowHidden", "hidden", "resolveMenuItemColor", "color", "Lcom/larus/bmhome/view/screenmenu/MenuItemColor;", "isDarkMode", "(Lcom/larus/bmhome/view/screenmenu/MenuItemColor;Z)Ljava/lang/Integer;", "buildButtonStateListDrawable", "Landroid/graphics/drawable/StateListDrawable;", "normalColor", "pressedColor", "cornerRadius", "", "applyHeaderTextStyle", "MaxHeightWrapper", "MaxHeightFrameLayout", "MaxHeightLinearLayout", "MaxHeightPolicy", "CreateMenuAdapter", "MenuRowDiffCallback", "DefaultViewHolder", "ButtonViewHolder", "HeaderViewHolder", "SectionDividerViewHolder", "MenuDividerDecoration", "MenuRow", "LoadingState", "Companion", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreateMenuV2 extends MaxWidthLinearLayout {
    public static final CreateMenu.a.C0051a s = null;
    public final Lazy b;
    public final Lazy c;
    public final Lazy d;
    public final Map<Integer, f> e;
    public View f;
    public boolean g;
    public Function1<? super Integer, Unit> h;
    public Function2<? super Integer, ? super View, Unit> i;
    public Function2<? super Integer, ? super String, Unit> j;
    public Drawable k;
    public CreateMenu.a.C0051a l;
    public boolean m;
    public int n;
    public int o;
    public ViewGroup p;
    public Function1<? super View, Unit> q;
    public boolean r;

    public final class a extends RecyclerView.ViewHolder {
        public final LinearLayout a;
        public final LarusCreateMenuItemBtnLayoutV2Binding b;
        public final ColorStateList c;
        public final /* synthetic */ CreateMenuV2 d;

        public a(CreateMenuV2 r2, LinearLayout r3, LarusCreateMenuItemBtnLayoutV2Binding r4) {
            Intrinsics.checkNotNullParameter(r3, "container");
            Intrinsics.checkNotNullParameter(r4, "binding");
            this.d = r2;
            super(r3);
            this.a = r3;
            this.b = r4;
            this.c = r4.b.getTextColors();
        }
    }

    public static final class b {
    }

    public final class c extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        public final List<l> a;
        public final /* synthetic */ CreateMenuV2 b;

        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[MenuItemType.values().length];
                r0[MenuItemType.BUTTON.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
            L11:
                r0[MenuItemType.HEADER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
            L15:
                r0[MenuItemType.SECTION_DIVIDER.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
            L6:
                a = r0;
            }
        }

        public final int getItemCount() {
            return ((ArrayList) this.a).size();
        }

        public c(CreateMenuV2 r1) {
            this.b = r1;
            this.a = new ArrayList();
        }

        public final int getItemViewType(int r2) {
            MenuItemType r3 = ((l) ListProtector.get(this.a, r2)).a.getType();
            int r4 = a.a[r3.ordinal()];
            if (r4 != 1) goto L5;
            return 1;
        L5:
            if (r4 != 2) goto L7;
            return 2;
        L7:
            if (r4 == 3) goto L12;
            return 0;
        L12:
            return 3;
        }

        public final void onViewRecycled(RecyclerView.ViewHolder r2) {
            Intrinsics.checkNotNullParameter(r2, "holder");
            if ((r2 instanceof d) == false) goto L5;
            ((d) r2).T3();
        L5:
            super.onViewRecycled(r2);
        }

        /* JADX WARN: Type inference failed for: r1v26, types: [android.view.ViewGroup, com.larus.bmhome.view.menu.CreateMenuV2, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r8v9, types: [android.view.ViewGroup, com.larus.bmhome.view.menu.CreateMenuV2, java.lang.Object] */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public final void onBindViewHolder(RecyclerView.ViewHolder r18, int r19) {
            Intrinsics.checkNotNullParameter(r18, "holder");
            l r2 = (l) ListProtector.get(this.a, r19);
            CharSequence r6 = "";
            if ((r18 instanceof d) == false) goto L162;
            d r0 = (d) r18;
            r0.getClass();
            Intrinsics.checkNotNullParameter(r2, "row");
            CreateMenuV2.g(r0.d, ((RecyclerView.ViewHolder) r0).itemView, r2.d);
            if (r2.d == true) goto L237;
            r0.T3();
            CreateMenuV2.e(r0.d, r0.a, r2);
            ColorStateList r3 = r0.c;
            if (r3 == null) goto L10;
            r0.b.j.setTextColor(r3);
        L10:
            f r4 = (f) ((LinkedHashMap) r0.d.e).get(Integer.valueOf(r2.a.a));
            ?? r8 = r0.d;
            LarusCreateMenuItemLayoutV2Binding r12 = r0.b;
            l0 r13 = r2.a;
            r8.getClass();
            Object r14 = r12.m.getParent();
            if ((r14 instanceof View) == false) goto L13;
            View r15 = (View) r14;
        L14:
            if (r15 == null) goto L16;
            CreateMenuV2.o(r15);
        L16:
            LinearLayout r16 = r12.m;
            ViewGroup.LayoutParams r17 = r16.getLayoutParams();
            if (r17 != null) goto L20;
        L22:
            CreateMenuV2.o(r12.j);
            r12.j.setMaxWidth(Integer.MAX_VALUE);
            CreateMenuV2.r(r12.h);
            r12.h.setMinWidth(0);
            r12.h.setMaxWidth(Integer.MAX_VALUE);
            CreateMenuV2.r(r12.g);
            r12.g.setMinimumWidth(i5.q());
            r12.g.setMinimumHeight(i5.q());
            e1.x(r12.g);
            r8.h(r12, r13);
            AppCompatTextView r5 = r12.j;
            CharSequence r110 = r13.d;
            if (r110 == null) goto L25;
        L28:
            r5.setText(r110);
            CreateMenuV2.m(r12, r13, true);
            if (o0.d(r13.u) == false) goto L31;
            e1.x(r12.i);
            r12.i.setText(r13.u);
        L33:
            if (o0.d(r13.v) == false) goto L38;
            e1.x(r12.c);
            r12.d.setText(r13.v);
            e1.o(r12.o);
            r12.n.setText("");
            if (o0.d(r13.w) == false) goto L37;
            e1.x(r12.b);
            ImageLoaderKt.v(r12.b, r13.w, "custom_actionbar_icon", null, new kt8.i());
        L42:
            Function0<View> r7 = r13.E;
            if (r7 == null) goto L45;
            View r9 = (View) r7.invoke();
        L46:
            r12.f.removeAllViews();
            if (r9 == null) goto L49;
        L57:
            r8.J(r12, true);
            if (r9 != null) goto L60;
            e1.x(r12.e);
            SimpleDraweeView r10 = r12.e;
            if (r13.M == false) goto L71;
            ImageView.ScaleType r11 = ImageView.ScaleType.FIT_CENTER;
        L72:
            r10.setScaleType(r11);
            r12.f.addView(r12.e, new FrameLayout.LayoutParams(-1, -1));
            r12.e.setImageDrawable(null);
            Integer r20 = r13.h;
            if (r20 == null) goto L76;
            r12.e.setImageResource(r20.intValue());
        L76:
            if (o0.d(r13.i) == false) goto L78;
            ImageLoaderKt.v(r12.e, r13.i, "custom_actionbar_icon", null, new kt8.o());
        L78:
            r8.l(r12.h, r13);
            if (o0.d(r13.n) == false) goto L85;
            e1.x(r12.k);
            if (r13.m == null) goto L83;
            r12.k.getHierarchy().setPlaceholderImage(r13.m.intValue());
        L83:
            ImageLoaderKt.u(r12.k, r13.n, "default_menu_text");
        L88:
            CreateMenuV2.q(r12);
            int r21 = CreateMenuV2.z(r8, r12.l);
            int r22 = r8.y(r12.o, null);
            int r111 = r8.y(r12.c, null);
            if (r22 > 0) goto L92;
            if (r111 > 0) goto L92;
        L113:
            AppCompatTextView r23 = r12.h;
            if (r23.getVisibility() != 0) goto L122;
            int r24 = CreateMenuV2.M(r12.f);
            int r25 = CreateMenuV2.x(r12.j);
            int r26 = CreateMenuV2.z(r8, r12.l);
            int r112 = r8.y(r12.o, null);
            int r113 = r8.y(r12.c, null);
            int r114 = r8.F(r12);
            int r27 = r8.o;
            CreateMenu.a.C0051a r115 = r8.l;
            int r1 = Math.min((r23.getCompoundPaddingLeft() + ((int) Math.ceil(Layout.getDesiredWidth(r23.getText(), r23.getPaint())))) + r23.getCompoundPaddingRight(), RangesKt.coerceAtLeast(((((((((r27 - r115.a) - r115.b) - r24) - CreateMenuV2.w(r12.m)) - r25) - r26) - r112) - r113) - r114, 0));
            ViewGroup.LayoutParams r28 = r23.getLayoutParams();
            if (r28 == null) goto L122;
            if (r28.width == r1) goto L122;
            r28.width = r1;
            r23.setLayoutParams(r28);
        L122:
            Integer r29 = r13.I;
            if (r29 != null) goto L128;
            Integer r30 = r13.f;
            if (r30 == null) goto L127;
            r29 = Integer.valueOf(ContextCompat.getColor(r8.getContext(), r30.intValue()));
            goto L128
        L127:
            r29 = null;
        L128:
            if (r29 == null) goto L130;
            int r31 = r29.intValue();
            r12.j.setTextColor(r31);
            r12.e.setColorFilter(r31);
            r12.k.setColorFilter(r31);
        L130:
            if (r29 != null) goto L132;
            r12.e.clearColorFilter();
            r12.k.clearColorFilter();
        L132:
            Integer r32 = r13.r;
            if (r32 == null) goto L135;
            r12.k.setColorFilter(r32.intValue());
        L135:
            final CreateMenuV2 r33 = r0.d;
            View r34 = r0.b.a;
            final l0 r35 = r2.a;
            if (r4 == null) goto L138;
            boolean r36 = true;
        L139:
            final View r37 = ((RecyclerView.ViewHolder) r0).itemView;
            r33.getClass();
            if (r36 == false) goto L142;
        L146:
            boolean r116 = false;
        L147:
            r34.setEnabled(r116);
            r34.setClickable(r116);
            if (r116 == false) goto L150;
            View.OnClickListener r38 = new kt8.n(r33, r35, r37);
        L151:
            r34.setOnClickListener(r38);
            Float r39 = r35.y;
            if (r39 == null) goto L155;
            float r40 = r39.floatValue();
        L158:
            r34.setAlpha(r40);
            if (r4 == null) goto L232;
            ObjectAnimator r41 = ObjectAnimator.ofFloat(r0.b.e, "rotation", new float[]{0.0f, 360.0f});
            r41.setDuration(1000);
            r41.setRepeatCount(-1);
            r41.setInterpolator(new LinearInterpolator());
            r41.start();
            r0.b.e.setTag(2131392492, r41);
            return;
        L232:
            return;
        L155:
            if (r35.p == false) goto L157;
            r40 = 1.0f;
            goto L158
        L157:
            r40 = 0.5f;
            goto L158
        L150:
            r38 = null;
            goto L151
        L142:
            if (r35.p == false) goto L144;
        L145:
            r116 = true;
            goto L147
        L144:
            if (r33.j == null) goto L146;
        L138:
            r36 = false;
        L92:
            int r117 = CreateMenuV2.M(r12.f);
            int r118 = r8.F(r12);
            int r42 = r8.o;
            CreateMenu.a.C0051a r119 = r8.l;
            int r43 = RangesKt.coerceAtLeast((((((((r42 - r119.a) - r119.b) - r117) - CreateMenuV2.w(r12.m)) - r118) - r21) - r22) - r111, 0);
            if (r43 <= 0) goto L113;
            r12.j.setMaxWidth(r43);
            AppCompatTextView r44 = r12.j;
            ViewGroup.LayoutParams r45 = r44.getLayoutParams();
            if ((r45 instanceof LinearLayout.LayoutParams) == false) goto L98;
            LinearLayout.LayoutParams r46 = (LinearLayout.LayoutParams) r45;
        L99:
            if (r46 == null) goto L113;
            if (r46.width == (-2)) goto L104;
            r46.width = -2;
            boolean r47 = true;
        L106:
            if (r46.weight != 0.0f) goto L108;
            boolean r48 = true;
        L109:
            if (r48 == true) goto L111;
            r46.weight = 0.0f;
            r47 = true;
        L111:
            if (r47 == false) goto L113;
            r44.setLayoutParams(r46);
            goto L113
        L108:
            r48 = false;
            goto L109
        L104:
            r47 = false;
            goto L106
        L98:
            r46 = null;
            goto L99
        L85:
            if (r13.m == null) goto L87;
            e1.x(r12.k);
            r12.k.setImageResource(r13.m.intValue());
            goto L88
        L87:
            e1.o(r12.k);
            r12.k.setImageDrawable(null);
            goto L88
        L71:
            r11 = ImageView.ScaleType.CENTER_INSIDE;
            goto L72
        L60:
            if (r9.getParent() == null) goto L67;
            ViewParent r49 = r9.getParent();
            if ((r49 instanceof ViewGroup) == false) goto L64;
            ViewGroup r50 = (ViewGroup) r49;
        L65:
            if (r50 == null) goto L67;
            r50.removeView(r9);
            goto L67
        L64:
            r50 = null;
        L67:
            e1.o(r12.e);
            r12.e.setImageDrawable(null);
            r12.f.addView(r9, new FrameLayout.LayoutParams(-1, -1));
            goto L78
        L49:
            if (r13.h == null) goto L51;
        L54:
            boolean r51 = true;
        L55:
            if (r51 == true) goto L57;
            r8.J(r12, false);
            e1.o(r12.e);
            r12.e.setImageDrawable(null);
            goto L78
        L51:
            if (o0.d(r13.i) == true) goto L54;
            r51 = false;
            goto L55
        L45:
            r9 = null;
            goto L46
        L37:
            e1.o(r12.b);
            r12.b.setImageDrawable(null);
            goto L42
        L38:
            e1.o(r12.c);
            r12.d.setText("");
            e1.o(r12.b);
            r12.b.setImageDrawable(null);
            if (o0.d(r13.x) == false) goto L41;
            r12.n.setText(r13.x);
            e1.x(r12.o);
            goto L42
        L41:
            e1.o(r12.o);
            r12.n.setText("");
            goto L42
        L31:
            e1.o(r12.i);
            r12.i.setText("");
            goto L33
        L25:
            if (r13.b == 0) goto L27;
            r110 = r8.getContext().getText(r13.b);
            goto L28
        L27:
            r110 = r13.c;
            goto L28
        L20:
            if (r17.width == 0) goto L22;
            r17.width = 0;
            r16.setLayoutParams(r17);
            goto L22
        L13:
            r15 = null;
            goto L14
        L237:
            return;
        L162:
            if ((r18 instanceof a) == false) goto L203;
            a r52 = (a) r18;
            r52.getClass();
            Intrinsics.checkNotNullParameter(r2, "row");
            CreateMenuV2.g(r52.d, ((RecyclerView.ViewHolder) r52).itemView, r2.d);
            if (r2.d == true) goto L238;
            CreateMenuV2.e(r52.d, r52.a, r2);
            ColorStateList r53 = r52.c;
            if (r53 == null) goto L169;
            r52.b.b.setTextColor(r53);
        L169:
            final ?? r54 = r52.d;
            LarusCreateMenuItemBtnLayoutV2Binding r55 = r52.b;
            final l0 r56 = r2.a;
            final View r57 = ((RecyclerView.ViewHolder) r52).itemView;
            r54.getClass();
            r55.b.setTextSize(0, r54.l.g);
            r55.b.setBackgroundResource(2131231895);
            Drawable r58 = r55.b.getBackground();
            if (r58 == null) goto L172;
            r58.clearColorFilter();
        L172:
            TextView r59 = r55.b;
            if (r56.b == 0) goto L175;
            r6 = r54.getContext().getText(r56.b);
        L179:
            r59.setText(r6);
            Integer r60 = r54.E(r56.A, r54.g);
            if (r60 == null) goto L191;
            int r61 = r60.intValue();
            Integer r62 = r54.E(r56.C, r54.g);
            if (r62 == null) goto L184;
            TextView r63 = r55.b;
            int r64 = r62.intValue();
            float r65 = r54.getContext().getResources().getDimension(v19.c.b(2130971163, r54.getContext(), 2131166696));
            GradientDrawable r66 = new GradientDrawable();
            r66.setColor(r61);
            r66.setCornerRadius(r65);
            GradientDrawable r67 = new GradientDrawable();
            r67.setColor(r64);
            r67.setCornerRadius(r65);
            StateListDrawable r68 = new StateListDrawable();
            r68.addState(new int[]{R.attr.state_pressed}, r67);
            r68.addState(new int[0], r66);
            r63.setBackground(r68);
            goto L191
        L184:
            PorterDuffColorFilter r69 = new PorterDuffColorFilter(r61, PorterDuff.Mode.SRC_IN);
            Drawable r70 = r55.b.getBackground();
            if (r70 == null) goto L187;
            Drawable r71 = r70.mutate();
        L188:
            if (r71 == null) goto L190;
            r71.setColorFilter(r69);
        L190:
            r55.b.setBackground(r71);
            goto L191
        L187:
            r71 = null;
        L191:
            Integer r72 = r54.E(r56.B, r54.g);
            if (r72 == null) goto L194;
            r55.b.setTextColor(r72.intValue());
        L194:
            r55.b.setEnabled(r56.p);
            r55.b.setOnClickListener(new kt8.j(r54, r56, r57));
            TextView r73 = r55.b;
            Float r74 = r56.y;
            if (r74 == null) goto L198;
            float r75 = r74.floatValue();
        L201:
            r73.setAlpha(r75);
            return;
        L198:
            if (r56.p == false) goto L200;
            r75 = 1.0f;
            goto L201
        L200:
            r75 = 0.5f;
            goto L201
        L175:
            String r76 = r56.c;
            if (r76 == null) goto L179;
            r6 = r76;
            goto L179
        L238:
            return;
        L203:
            if ((r18 instanceof e) == false) goto L225;
            e r77 = (e) r18;
            r77.getClass();
            Intrinsics.checkNotNullParameter(r2, "row");
            CreateMenuV2.g(r77.b, ((RecyclerView.ViewHolder) r77).itemView, r2.d);
            if (r2.d == true) goto L239;
            TextView r78 = r77.a;
            l0 r79 = r2.a;
            if (r79.b == 0) goto L210;
            CharSequence r80 = r77.b.getContext().getText(r2.a.b);
        L211:
            r78.setText(r80);
            TextView r81 = r77.a;
            Integer r82 = r2.a.I;
            if (r82 == null) goto L214;
            int r83 = r82.intValue();
        L219:
            r81.setTextColor(r83);
            TextView r84 = r77.a;
            Float r85 = r2.a.y;
            if (r85 == null) goto L222;
            float r86 = r85.floatValue();
        L223:
            r84.setAlpha(r86);
            return;
        L222:
            r86 = 1.0f;
            goto L223
        L214:
            Context r87 = r77.b.getContext();
            Integer r88 = r2.a.f;
            if (r88 == null) goto L217;
            int r89 = r88.intValue();
        L218:
            r83 = ContextCompat.getColor(r87, r89);
            goto L219
        L217:
            r89 = v19.c.b(2130972081, r77.b.getContext(), 2131103143);
            goto L218
        L210:
            r80 = r79.c;
            goto L211
        L239:
            return;
        L225:
            if ((r18 instanceof n) == false) goto L236;
            n r90 = (n) r18;
            l0 r91 = r2.a;
            r90.getClass();
            Intrinsics.checkNotNullParameter(r91, "menu");
            LinearLayoutCompat r92 = r90.a;
            CreateMenu.a.C0051a r93 = CreateMenuV2.s;
            r92.getClass();
            View r94 = new View(r92.getContext());
            Integer r95 = r91.H;
            if (r95 == null) goto L229;
            int r96 = r95.intValue();
        L230:
            r94.setLayoutParams(new RecyclerView.LayoutParams(-1, r96));
            r94.setBackgroundColor(ContextCompat.getColor(r94.getContext(), v19.c.b(2130972086, r94.getContext(), 2131103159)));
            r94.setClickable(false);
            r94.setFocusable(false);
            ((RecyclerView.ViewHolder) r90).itemView.setLayoutParams(r94.getLayoutParams());
            ((RecyclerView.ViewHolder) r90).itemView.setBackgroundColor(ContextCompat.getColor(r90.a.getContext(), v19.c.b(2130972086, r90.a.getContext(), 2131103159)));
            ((RecyclerView.ViewHolder) r90).itemView.setClickable(false);
            ((RecyclerView.ViewHolder) r90).itemView.setFocusable(false);
            return;
        L229:
            r96 = 0;
            goto L230
        }

        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
            Intrinsics.checkNotNullParameter(r4, "parent");
            if (r5 != 1) goto L5;
            LinearLayout r6 = new LinearLayout(r4.getContext());
            r6.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            LarusCreateMenuItemBtnLayoutV2Binding r7 = LarusCreateMenuItemBtnLayoutV2Binding.a(LayoutInflater.from(r4.getContext()), r6);
            return new a(this.b, r6, r7);
        L5:
            if (r5 != 2) goto L7;
            CreateMenuV2 r8 = this.b;
            TextView r0 = new TextView(r4.getContext());
            CreateMenuV2 r9 = this.b;
            r0.setId(2131379929);
            CreateMenu.a.C0051a r1 = CreateMenuV2.s;
            r9.getClass();
            CreateMenuV2.i(r0);
            return new e(r8, r0);
        L7:
            if (r5 == 3) goto L14;
            LinearLayout r10 = new LinearLayout(r4.getContext());
            r10.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            LarusCreateMenuItemLayoutV2Binding r11 = LarusCreateMenuItemLayoutV2Binding.a(LayoutInflater.from(r4.getContext()), r10);
            return new d(this.b, r10, r11);
        L14:
            return new n(this.b, new View(r4.getContext()));
        }
    }

    public final class d extends RecyclerView.ViewHolder {
        public final LinearLayout a;
        public final LarusCreateMenuItemLayoutV2Binding b;
        public final ColorStateList c;
        public final /* synthetic */ CreateMenuV2 d;

        public final void T3() {
            Object r0 = this.b.e.getTag(2131392492);
            if ((r0 instanceof ObjectAnimator) == false) goto L5;
            ObjectAnimator r1 = (ObjectAnimator) r0;
        L6:
            if (r1 == null) goto L8;
            r1.cancel();
        L8:
            this.b.e.setRotation(0.0f);
            this.b.e.setTag(2131392492, null);
            return;
        L5:
            r1 = null;
            goto L6
        }

        public d(CreateMenuV2 r2, LinearLayout r3, LarusCreateMenuItemLayoutV2Binding r4) {
            Intrinsics.checkNotNullParameter(r3, "container");
            Intrinsics.checkNotNullParameter(r4, "binding");
            this.d = r2;
            super(r3);
            this.a = r3;
            this.b = r4;
            this.c = r4.j.getTextColors();
        }
    }

    public final class e extends RecyclerView.ViewHolder {
        public final TextView a;
        public final /* synthetic */ CreateMenuV2 b;

        public e(CreateMenuV2 r2, TextView r3) {
            Intrinsics.checkNotNullParameter(r3, "textView");
            this.b = r2;
            super(r3);
            this.a = r3;
        }
    }

    public static final class f {
        public final boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if ((r3 instanceof f) == true) goto L9;
            return false;
        L9:
            ((f) r3).getClass();
            return true;
        }

        public final int hashCode() {
            return 0;
        }

        public final String toString() {
            return "LoadingState(loadingDrawableRes=0)";
        }
    }

    public final class g extends FrameLayout implements j {
        public final i a;

        @Override // com.larus.bmhome.view.menu.CreateMenuV2.j
        public final void a(Integer r2) {
            this.a.d(r2);
            requestLayout();
        }

        public g(CreateMenuV2 r2, Context r3) {
            Intrinsics.checkNotNullParameter(r3, "context");
            super(r3);
            this.a = new i(r2, this);
        }

        @Override // android.widget.FrameLayout, android.view.View
        public final void onMeasure(int r2, int r3) {
            super.onMeasure(r2, this.a.a(r3));
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        public final void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
            super.onLayout(r1, r2, r3, r4, r5);
            this.a.b();
        }
    }

    public final class h extends LinearLayout implements j {
        public final i a;

        @Override // com.larus.bmhome.view.menu.CreateMenuV2.j
        public final void a(Integer r2) {
            this.a.d(r2);
            requestLayout();
        }

        public h(CreateMenuV2 r2, Context r3) {
            Intrinsics.checkNotNullParameter(r3, "context");
            super(r3);
            this.a = new i(r2, this);
        }

        @Override // android.widget.LinearLayout, android.view.View
        public final void onMeasure(int r2, int r3) {
            super.onMeasure(r2, this.a.a(r3));
        }

        @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
        public final void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
            super.onLayout(r1, r2, r3, r4, r5);
            this.a.b();
        }
    }

    public final class i {
        public final View a;
        public final int[] b;
        public Integer c;
        public int d;
        public boolean e;
        public final /* synthetic */ CreateMenuV2 f;

        public final void b() {
            if (this.e == true) goto L5;
            return;
        L5:
            int r0 = c();
            if (r0 != Integer.MAX_VALUE) goto L8;
            return;
        L8:
            if (r0 == this.d) goto L13;
            this.d = r0;
            View r1 = this.a;
            final CreateMenuV2 r2 = this.f;
            r1.post(new q(this, r2));
            return;
        }

        public final int c() {
            Integer r1 = null;
            boolean r2 = true;
            if (this.a.isAttachedToWindow() == false) goto L22;
            this.a.getLocationOnScreen(this.b);
            Integer r0 = Integer.valueOf(this.a.getHeight());
            if (r0.intValue() <= 0) goto L8;
            boolean r4 = true;
        L9:
            if (r4 == true) goto L12;
            r0 = null;
        L12:
            if (r0 != null) goto L20;
            r0 = Integer.valueOf(this.a.getMeasuredHeight());
            if (r0.intValue() <= 0) goto L16;
            boolean r5 = true;
        L17:
            if (r5 == true) goto L20;
            r0 = null;
            goto L20
        L16:
            r5 = false;
        L20:
            if (r0 == null) goto L22;
            Integer r3 = Integer.valueOf(this.b[1] + r0.intValue());
        L23:
            if (r3 == null) goto L42;
            int r6 = r3.intValue();
            WindowInsetsCompat r7 = ViewCompat.getRootWindowInsets(this.a);
            if (r7 == null) goto L27;
            Insets r8 = r7.getInsets(WindowInsetsCompat.Type.statusBars());
        L28:
            if (r8 == null) goto L30;
            int r9 = r8.top;
        L31:
            Integer r10 = Integer.valueOf(r6 - r9);
            if (r10.intValue() > 0) goto L35;
            r2 = false;
        L35:
            if (r2 == false) goto L37;
            r1 = r10;
        L37:
            if (r1 != null) goto L43;
            return Integer.MAX_VALUE;
        L43:
            return r1.intValue();
        L30:
            r9 = RangesKt.coerceAtLeast(com.larus.utils.i.e(this.f.getContext()), 0);
            goto L31
        L27:
            r8 = null;
            goto L28
        L42:
            return this.d;
        L8:
            r4 = false;
        L22:
            r3 = null;
            goto L23
        }

        public final int a(int r4) {
            Integer r0 = this.c;
            if (r0 == null) goto L6;
            int r1 = r0.intValue();
        L9:
            CreateMenu.a.C0051a r2 = CreateMenuV2.s;
            if (r1 == Integer.MAX_VALUE) goto L18;
            int r3 = View.MeasureSpec.getMode(r4);
            int r5 = View.MeasureSpec.getSize(r4);
            if (r3 == 0) goto L17;
            r1 = Math.min(r5, r1);
        L17:
            return View.MeasureSpec.makeMeasureSpec(r1, Integer.MIN_VALUE);
        L18:
            return r4;
        L6:
            if (this.e == false) goto L8;
            r1 = c();
            goto L9
        L8:
            r1 = Integer.MAX_VALUE;
            goto L9
        }

        public final void d(Integer r5) {
            boolean r0 = true;
            Integer r2 = null;
            if (r5 != null) goto L5;
        L10:
            this.c = r2;
            if (r5 == null) goto L14;
            r0 = false;
        L14:
            this.e = r0;
            if (r0 == true) goto L18;
            this.d = Integer.MAX_VALUE;
            return;
        L18:
            return;
        L5:
            if (r5.intValue() <= 0) goto L7;
            boolean r3 = true;
        L8:
            if (r3 == false) goto L10;
            r2 = r5;
            goto L10
        L7:
            r3 = false;
            goto L8
        }

        public i(CreateMenuV2 r2, View r3) {
            Intrinsics.checkNotNullParameter(r3, "target");
            this.f = r2;
            this.a = r3;
            this.b = new int[2];
            this.d = Integer.MAX_VALUE;
            this.e = true;
        }
    }

    public interface j {
        void a(Integer r1);
    }

    public final class k extends RecyclerView.ItemDecoration {
        public final /* synthetic */ CreateMenuV2 a;

        public k(CreateMenuV2 r1) {
            this.a = r1;
        }

        public final boolean i(int r6) {
            l r0 = (l) CollectionsKt.getOrNull(CreateMenuV2.f(this.a).a, r6);
            if (r0 != null) goto L5;
        L7:
            boolean r1 = false;
        L8:
            if (r1 == true) goto L10;
            return false;
        L10:
            c r2 = CreateMenuV2.f(this.a);
            l r3 = (l) CollectionsKt.getOrNull(r2.a, r6);
            if (r3 != null) goto L14;
        L30:
            boolean r4 = false;
        L31:
            if (r4 == false) goto L33;
            return false;
        L33:
            if (r6 == 0) goto L35;
            List r7 = CollectionsKt.take(CreateMenuV2.f(this.a).a, r6);
            if ((r7 instanceof Collection) == true) goto L41;
        L43:
            Iterator r8 = r7.iterator();
        L45:
            if (r8.hasNext() == false) goto L49;
            if ((!((l) r8.next()).d) == false) goto L45;
            boolean r9 = true;
        L50:
            if (r9 == true) goto L56;
            if ((this.a.getShowDividers() & 1) != 1) goto L66;
            return true;
        L66:
            return false;
        L56:
            if ((this.a.getShowDividers() & 2) != 2) goto L67;
            return true;
        L67:
            return false;
        L49:
            r9 = false;
            goto L50
        L41:
            if (r7.isEmpty() == false) goto L43;
        L35:
            if ((this.a.getShowDividers() & 1) != 1) goto L65;
            return true;
        L65:
            return false;
        L14:
            if (r3.a.k == true) goto L29;
            List r5 = CollectionsKt.take(r2.a, r6);
            ListIterator r10 = r5.listIterator(r5.size());
        L18:
            if (r10.hasPrevious() == false) goto L22;
            Object r11 = r10.previous();
            if ((!((l) r11).d) == false) goto L18;
        L23:
            l r12 = (l) r11;
            if (r12 == null) goto L30;
            l0 r13 = r12.a;
            if (r13 == null) goto L30;
            if (r13.k != true) goto L30;
        L22:
            r11 = null;
        L29:
            r4 = true;
            goto L31
        L5:
            if (r0.d == true) goto L7;
            r1 = true;
            goto L8
        }

        public final boolean h(int r6, int r7) {
            l r0 = (l) CollectionsKt.getOrNull(CreateMenuV2.f(this.a).a, r6);
            if (r0 != null) goto L5;
        L7:
            boolean r1 = false;
        L8:
            if (r1 == true) goto L10;
            return false;
        L10:
            c r2 = CreateMenuV2.f(this.a);
            l r3 = (l) CollectionsKt.getOrNull(r2.a, r6);
            if (r3 != null) goto L14;
        L30:
            boolean r4 = false;
        L31:
            if (r4 == false) goto L34;
            return false;
        L34:
            if (r6 == (r7 - 1)) goto L50;
            List r8 = CollectionsKt.drop(CreateMenuV2.f(this.a).a, r6 + 1);
            if ((r8 instanceof Collection) == true) goto L38;
        L40:
            Iterator r9 = r8.iterator();
        L42:
            if (r9.hasNext() == false) goto L46;
            if ((!((l) r9.next()).d) == false) goto L42;
            boolean r10 = false;
        L47:
            if (r10 == true) goto L50;
            return false;
        L46:
            r10 = true;
            goto L47
        L38:
            if (r8.isEmpty() == false) goto L40;
        L50:
            if ((this.a.getShowDividers() & 4) != 4) goto L59;
            return true;
        L59:
            return false;
        L14:
            if (r3.a.k == true) goto L29;
            Iterator r5 = CollectionsKt.drop(r2.a, r6 + 1).iterator();
        L18:
            if (r5.hasNext() == false) goto L22;
            Object r11 = r5.next();
            if ((!((l) r11).d) == false) goto L18;
        L23:
            l r12 = (l) r11;
            if (r12 == null) goto L30;
            l0 r13 = r12.a;
            if (r13 == null) goto L30;
            if (r13.k != true) goto L30;
        L22:
            r11 = null;
        L29:
            r4 = true;
            goto L31
        L5:
            if (r0.d == true) goto L7;
            r1 = true;
            goto L8
        }

        public final void onDraw(Canvas r10, RecyclerView r11, RecyclerView.State r12) {
            Intrinsics.checkNotNullParameter(r10, "canvas");
            Intrinsics.checkNotNullParameter(r11, "parent");
            Intrinsics.checkNotNullParameter(r12, "state");
            Drawable r13 = this.a.k;
            if (r13 != null) goto L5;
            return;
        L5:
            RecyclerView.Adapter r0 = r11.getAdapter();
            int r1 = 0;
            if (r0 == null) goto L8;
            int r2 = r0.getItemCount();
        L9:
            int r3 = r11.getChildCount();
        L10:
            if (r1 >= r3) goto L21;
            View r4 = r11.getChildAt(r1);
            int r5 = r11.getChildAdapterPosition(r4);
            if (r5 == (-1)) goto L20;
            if (i(r5) == false) goto L18;
            int r6 = r4.getTop() - r13.getIntrinsicHeight();
            r13.setBounds(r11.getPaddingLeft(), r6, r11.getWidth() - r11.getPaddingRight(), r13.getIntrinsicHeight() + r6);
            r13.draw(r10);
        L18:
            if (h(r5, r2) == false) goto L20;
            int r7 = r4.getBottom();
            r13.setBounds(r11.getPaddingLeft(), r7, r11.getWidth() - r11.getPaddingRight(), r13.getIntrinsicHeight() + r7);
            r13.draw(r10);
        L20:
            r1 = r1 + 1;
            goto L10
        L21:
            return;
        L8:
            r2 = 0;
            goto L9
        }

        public final void getItemOffsets(Rect r2, View r3, RecyclerView r4, RecyclerView.State r5) {
            Intrinsics.checkNotNullParameter(r2, "outRect");
            Intrinsics.checkNotNullParameter(r3, "view");
            Intrinsics.checkNotNullParameter(r4, "parent");
            Intrinsics.checkNotNullParameter(r5, "state");
            Drawable r6 = this.a.k;
            if (r6 != null) goto L5;
            return;
        L5:
            int r7 = r4.getChildAdapterPosition(r3);
            if (r7 != (-1)) goto L8;
            return;
        L8:
            RecyclerView.Adapter r8 = r4.getAdapter();
            if (r8 == null) goto L11;
            int r9 = r8.getItemCount();
        L13:
            if (i(r7) == false) goto L16;
            r2.top = r6.getIntrinsicHeight();
        L16:
            if (h(r7, r9) == false) goto L19;
            r2.bottom = r6.getIntrinsicHeight();
            return;
        L19:
            return;
        L11:
            r9 = 0;
            goto L13
        }
    }

    public static final class l {
        public final l0 a;
        public final int b;
        public final int c;
        public final boolean d;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof l) == true) goto L8;
            return false;
        L8:
            l r6 = (l) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r0 = ((((this.a.hashCode() * 31) + this.b) * 31) + this.c) * 31;
            if (this.d == false) goto L5;
            int r1 = 1231;
        L7:
            return r0 + r1;
        L5:
            r1 = 1237;
            goto L7
        }

        public final String toString() {
            return "MenuRow(menu=" + this.a + ", rawIndex=" + this.b + ", rawCount=" + this.c + ", hidden=" + this.d + ')';
        }

        public l(l0 r2, int r3, int r4, boolean r5) {
            Intrinsics.checkNotNullParameter(r2, "menu");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }
    }

    public static final class m extends DiffUtil.Callback {
        public final List<l> a;
        public final List<l> b;

        public final int getNewListSize() {
            return this.b.size();
        }

        public final int getOldListSize() {
            return this.a.size();
        }

        public m(List<l> r2, List<l> r3) {
            Intrinsics.checkNotNullParameter(r2, "oldRows");
            Intrinsics.checkNotNullParameter(r3, "newRows");
            this.a = r2;
            this.b = r3;
        }

        public final boolean areContentsTheSame(int r3, int r4) {
            l r5 = (l) ListProtector.get(this.a, r3);
            l r6 = (l) ListProtector.get(this.b, r4);
            if (r5.b == r6.b) goto L5;
        L11:
            return false;
        L5:
            if (r5.c != r6.c) goto L11;
            if (r5.d != r6.d) goto L11;
            if (Intrinsics.areEqual(r5.a, r6.a) == false) goto L11;
            return true;
        }

        public final boolean areItemsTheSame(int r3, int r4) {
            l r5 = (l) ListProtector.get(this.a, r3);
            l r6 = (l) ListProtector.get(this.b, r4);
            l0 r7 = r5.a;
            if (r7.a == r6.a.a) goto L5;
        L7:
            return false;
        L5:
            if (r7.getType() != r6.a.getType()) goto L7;
            return true;
        }
    }

    public final class n extends RecyclerView.ViewHolder {
        public final /* synthetic */ CreateMenuV2 a;

        public n(CreateMenuV2 r2, View r3) {
            Intrinsics.checkNotNullParameter(r3, "itemView");
            this.a = r2;
            super(r3);
        }
    }

    public /* synthetic */ class o {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[MenuItemType.values().length];
            r0[MenuItemType.BUTTON.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[MenuItemType.HEADER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public static final class p implements ViewTreeObserver.OnPreDrawListener {
        public final /* synthetic */ ViewGroup a;
        public final /* synthetic */ CreateMenuV2 b;

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public final boolean onPreDraw() {
            ViewTreeObserver r0 = this.a.getViewTreeObserver();
            if (r0.isAlive() == false) goto L5;
            r0.removeOnPreDrawListener(this);
        L5:
            CreateMenuV2 r1 = this.b;
            r1.r = false;
            ViewGroup r2 = this.a;
            r2.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            Function1<? super View, Unit> r3 = r1.q;
            if (r3 == null) goto L10;
            r3.invoke(r2);
            return true;
        L10:
            return true;
        }

        public p(ViewGroup r1, CreateMenuV2 r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    static {
        s = new CreateMenu.a.C0051a(0, 0, i5.m(), i5.m(), i5.q(), i5.q(), i5.o(), 0, i5.j0(), 0, 643);
    }

    private final c getMenuAdapter() {
        return (c) this.b.getValue();
    }

    private final k getMenuDividerDecoration() {
        return (k) this.c.getValue();
    }

    private final RecyclerView getRecyclerView() {
        return (RecyclerView) this.d.getValue();
    }

    public final void n() {
        final ViewGroup r0 = this.p;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.requestLayout();
        getRecyclerView().requestLayout();
        if (this.r == false) goto L8;
        return;
    L8:
        this.r = true;
        r0.post(new kt8.h(r0, this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void p() {
        if (Intrinsics.areEqual(getRecyclerView().getParent(), this) == true) goto L12;
        ViewParent r0 = getRecyclerView().getParent();
        if ((r0 instanceof ViewGroup) == false) goto L7;
        ViewGroup r1 = (ViewGroup) r0;
    L8:
        if (r1 == null) goto L10;
        r1.removeView(getRecyclerView());
    L10:
        addView(getRecyclerView());
        return;
    L7:
        r1 = null;
        goto L8
    }

    public final int getCurrentMenuWidth() {
        return this.o;
    }

    public CreateMenuV2(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.b = LazyKt.lazy(new kt8.k(this));
        this.c = LazyKt.lazy(new kt8.l(this));
        this.d = LazyKt.lazy(new kt8.m(this));
        this.e = new LinkedHashMap();
        this.l = s;
        this.n = Integer.MAX_VALUE;
        v(r2);
    }

    public static int M(View r2) {
        boolean r1 = false;
        if (r2.getVisibility() == 0) goto L5;
        return 0;
    L5:
        ViewGroup.LayoutParams r3 = r2.getLayoutParams();
        if (r3 == null) goto L16;
        Integer r4 = Integer.valueOf(r3.width);
        if (r4.intValue() <= 0) goto L10;
        r1 = true;
    L10:
        if (r1 == true) goto L13;
        r4 = null;
    L13:
        if (r4 == null) goto L16;
        return r4.intValue();
    L16:
        return i5.q();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static RecyclerView d(CreateMenuV2 r4) {
        r4.getClass();
        RecyclerView r0 = new RecyclerView(r4.getContext());
        r0.setLayoutParams(new LinearLayoutCompat.LayoutParams(-1, -2));
        r0.setLayoutManager(new LinearLayoutManager(r0.getContext()));
        r0.setAdapter(r4.getMenuAdapter());
        r0.setOverScrollMode(2);
        r0.setNestedScrollingEnabled(false);
        r0.setItemAnimator(null);
        r0.addItemDecoration(r4.getMenuDividerDecoration());
        return r0;
    }

    public static final /* synthetic */ c f(CreateMenuV2 r0) {
        return r0.getMenuAdapter();
    }

    public static void i(TextView r5) {
        r5.setLayoutParams(new RecyclerView.LayoutParams(-1, i5.O()));
        r5.setPadding(i5.q(), i5.h(), i5.q(), r5.getPaddingBottom());
        r5.setGravity(8388659);
        r5.setIncludeFontPadding(false);
        r5.setMaxLines(1);
        r5.setEllipsize(TextUtils.TruncateAt.END);
        r5.setTypeface(Typeface.create("sans-serif", 0));
        r5.setTextSize(0, r5.getResources().getDimension(v19.c.b(2130972270, r5.getContext(), 2131167610)));
        TextViewCompat.setLineHeight(r5, i5.v());
        r5.setClickable(false);
        r5.setFocusable(false);
    }

    public static void o(View r6) {
        ViewGroup.LayoutParams r0 = r6.getLayoutParams();
        if ((r0 instanceof LinearLayout.LayoutParams) == false) goto L5;
        LinearLayout.LayoutParams r1 = (LinearLayout.LayoutParams) r0;
    L6:
        if (r1 != null) goto L8;
        return;
    L8:
        boolean r2 = false;
        boolean r3 = true;
        if (r1.width == 0) goto L11;
        r1.width = 0;
        boolean r4 = true;
    L13:
        if (r1.weight != 1.0f) goto L15;
        r2 = true;
    L15:
        if (r2 == true) goto L17;
        r1.weight = 1.0f;
    L18:
        if (r3 == false) goto L21;
        r6.setLayoutParams(r1);
        return;
    L21:
        return;
    L17:
        r3 = r4;
        goto L18
    L11:
        r4 = false;
        goto L13
    L5:
        r1 = null;
        goto L6
    }

    public static void q(LarusCreateMenuItemLayoutV2Binding r2) {
        r(r2.g);
        r2.g.setMinimumWidth(i5.q());
        r2.g.setMinimumHeight(i5.q());
        e1.x(r2.g);
        r2.g.requestLayout();
    }

    public static void r(View r3) {
        ViewGroup.LayoutParams r0 = r3.getLayoutParams();
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.width == (-2)) goto L9;
        r0.width = -2;
        r3.setLayoutParams(r0);
        return;
    }

    public static int u(ViewGroup.MarginLayoutParams r2) {
        int r0 = 0;
        if (r2 == null) goto L5;
        int r1 = r2.getMarginStart();
    L6:
        if (r2 == null) goto L9;
        r0 = r2.getMarginEnd();
    L9:
        return r1 + r0;
    L5:
        r1 = 0;
        goto L6
    }

    public static int w(View r1) {
        ViewGroup.LayoutParams r2 = r1.getLayoutParams();
        if ((r2 instanceof ViewGroup.MarginLayoutParams) == false) goto L5;
        ViewGroup.MarginLayoutParams r3 = (ViewGroup.MarginLayoutParams) r2;
    L6:
        if (r3 != null) goto L10;
        return 0;
    L10:
        return r3.getMarginStart();
    L5:
        r3 = null;
        goto L6
    }

    public static int x(TextView r3) {
        ViewGroup.LayoutParams r0 = r3.getLayoutParams();
        if ((r0 instanceof ViewGroup.MarginLayoutParams) == false) goto L5;
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) r0;
    L7:
        return ((r3.getCompoundPaddingLeft() + ((int) Math.ceil(Layout.getDesiredWidth(r3.getText(), r3.getPaint())))) + r3.getCompoundPaddingRight()) + u(r1);
    L5:
        r1 = null;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int A(l r14) {
        int r0 = o.a[r14.a.getType().ordinal()];
        CharSequence r1 = "";
        boolean r2 = true;
        int r3 = 0;
        if (r0 != 1) goto L5;
        LarusCreateMenuItemBtnLayoutV2Binding r4 = LarusCreateMenuItemBtnLayoutV2Binding.a(LayoutInflater.from(getContext()), new LinearLayout(getContext()));
        r4.b.setTextSize(0, this.l.g);
        TextView r5 = r4.b;
        l0 r6 = r14.a;
        if (r6.b == 0) goto L80;
        r1 = getContext().getText(r14.a.b);
    L84:
        r5.setText(r1);
        int r15 = this.l.a + x(r4.b);
        int r7 = this.l.b;
    L86:
        return r15 + r7;
    L80:
        String r16 = r6.c;
        if (r16 == null) goto L84;
        r1 = r16;
        goto L84
    L5:
        if (r0 == 2) goto L69;
        LarusCreateMenuItemLayoutV2Binding r8 = LarusCreateMenuItemLayoutV2Binding.a(LayoutInflater.from(getContext()), new LinearLayout(getContext()));
        l0 r17 = r14.a;
        f r9 = (f) ((LinkedHashMap) this.e).get(Integer.valueOf(r17.a));
        h(r8, r17);
        if (r17.E == null) goto L9;
    L18:
        boolean r10 = true;
    L19:
        J(r8, r10);
        AppCompatTextView r11 = r8.j;
        CharSequence r12 = r17.d;
        if (r12 == null) goto L22;
    L25:
        r11.setText(r12);
        m(r8, r17, false);
        if (o0.d(r17.u) == false) goto L28;
        e1.x(r8.i);
        r8.i.setText(r17.u);
    L29:
        int r13 = 8;
        if (o0.d(r17.v) == false) goto L36;
        e1.x(r8.c);
        r8.d.setText(r17.v);
        SimpleDraweeView r18 = r8.b;
        if (o0.d(r17.w) == false) goto L34;
        int r19 = 0;
    L35:
        r18.setVisibility(r19);
        e1.o(r8.o);
        r8.n.setText("");
    L40:
        l(r8.h, r17);
        SimpleDraweeView r20 = r8.k;
        if (o0.d(r17.n) == false) goto L43;
    L44:
        r13 = 0;
    L45:
        r20.setVisibility(r13);
        q(r8);
        int r110 = M(r8.f);
        int r21 = x(r8.j);
        int r22 = z(this, r8.l);
        ViewGroup.MarginLayoutParams r23 = null;
        int r24 = y(r8.o, null);
        int r25 = y(r8.c, null);
        Integer r26 = Integer.valueOf(this.n);
        int r27 = r26.intValue();
        int r111 = Integer.MAX_VALUE;
        if (r27 <= 0) goto L49;
        if (r27 == Integer.MAX_VALUE) goto L49;
    L50:
        if (r2 == true) goto L53;
        r26 = null;
    L53:
        if (r26 == null) goto L55;
        r111 = r26.intValue();
    L55:
        int r28 = F(r8);
        if (r8.h.getVisibility() != 0) goto L59;
        CreateMenu.a.C0051a r29 = this.l;
        int r112 = ((((((((r111 - r29.a) - r29.b) - M(r8.f)) - w(r8.m)) - r21) - r22) - r24) - r25) - r28;
        AppCompatTextView r30 = r8.h;
        r28 = r28 + Math.min((r30.getCompoundPaddingLeft() + ((int) Math.ceil(Layout.getDesiredWidth(r30.getText(), r30.getPaint())))) + r30.getCompoundPaddingRight(), RangesKt.coerceAtLeast(r112, 0));
    L59:
        int r31 = w(r8.m) + r110;
        ViewGroup.LayoutParams r32 = r8.m.getLayoutParams();
        if ((r32 instanceof ViewGroup.MarginLayoutParams) == false) goto L62;
        r23 = (ViewGroup.MarginLayoutParams) r32;
    L62:
        if (r23 == null) goto L64;
        int r33 = r23.getMarginEnd();
    L65:
        int r34 = (((((r31 + r33) + r21) + r22) + r24) + r25) + r28;
        if (r8.i.getVisibility() != 0) goto L68;
        r3 = (r110 + w(r8.m)) + x(r8.i);
    L68:
        r15 = this.l.a + Math.max(r34, r3);
        r7 = this.l.b;
        goto L86
    L64:
        r33 = 0;
    L49:
        r2 = false;
        goto L50
    L43:
        if (r17.m == null) goto L45;
    L34:
        r19 = 8;
        goto L35
    L36:
        e1.o(r8.c);
        r8.d.setText("");
        e1.o(r8.b);
        if (o0.d(r17.x) == false) goto L39;
        e1.x(r8.o);
        r8.n.setText(r17.x);
        goto L40
    L39:
        e1.o(r8.o);
        r8.n.setText("");
        goto L40
    L28:
        e1.o(r8.i);
        r8.i.setText("");
        goto L29
    L22:
        if (r17.b == 0) goto L24;
        r12 = getContext().getText(r17.b);
        goto L25
    L24:
        r12 = r17.c;
        goto L25
    L9:
        if (r17.h == null) goto L11;
    L14:
        boolean r35 = true;
    L15:
        if (r35 == true) goto L18;
        r10 = false;
        goto L19
    L11:
        if (o0.d(r17.i) == true) goto L14;
        r35 = false;
        goto L15
    L69:
        l0 r36 = r14.a;
        if (r36.b == 0) goto L72;
        r1 = getContext().getText(r14.a.b);
    L76:
        Intrinsics.checkNotNull(r1);
        TextView r113 = new TextView(getContext());
        i(r113);
        TextPaint r114 = r113.getPaint();
        r7 = i5.q() * 2;
        r15 = (int) Math.ceil(Layout.getDesiredWidth(r1, r114));
        goto L86
    L72:
        String r115 = r36.c;
        if (r115 == null) goto L76;
        r1 = r115;
        goto L76
    }

    public final int F(LarusCreateMenuItemLayoutV2Binding r6) {
        if (r6.g.getVisibility() == 0) goto L5;
        return 0;
    L5:
        ViewGroup.MarginLayoutParams r2 = null;
        if (r6.h.getVisibility() != 0) goto L12;
        ViewGroup.LayoutParams r0 = r6.h.getLayoutParams();
        if ((r0 instanceof ViewGroup.MarginLayoutParams) == false) goto L10;
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) r0;
    L11:
        int r3 = u(r1);
    L13:
        int r4 = z(this, r6.k);
        int r5 = RangesKt.coerceAtLeast(r6.g.getMinimumWidth(), 0);
        ViewGroup.LayoutParams r7 = r6.g.getLayoutParams();
        if ((r7 instanceof ViewGroup.MarginLayoutParams) == false) goto L17;
        r2 = (ViewGroup.MarginLayoutParams) r7;
    L17:
        return Math.max(r3 + r4, r5) + u(r2);
    L10:
        r1 = null;
        goto L11
    L12:
        r3 = 0;
        goto L13
    }

    public final void G(int r2) {
        getRecyclerView().scrollToPosition(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void L(List<l> r8) {
        ArrayList r0 = new ArrayList();
        Iterator<T> r9 = r8.iterator();
    L3:
        boolean r2 = false;
        if (r9.hasNext() == false) goto L12;
        Object r1 = r9.next();
        l r4 = (l) r1;
        if (r4.d == false) goto L8;
    L10:
        if (r2 == false) goto L3;
        r0.add(r1);
        goto L3
    L8:
        if (r4.a.getType() == MenuItemType.SECTION_DIVIDER) goto L10;
        r2 = true;
        goto L10
    L12:
        Iterator r10 = r0.iterator();
        Integer r3 = null;
        if (r10.hasNext() == true) goto L15;
        Integer r5 = null;
    L21:
        if (r5 == null) goto L23;
        int r11 = r5.intValue();
    L24:
        int r6 = RangesKt.coerceAtLeast(getMinimumWidth(), 0);
        Integer r7 = Integer.valueOf(this.n);
        int r12 = r7.intValue();
        int r13 = Integer.MAX_VALUE;
        if (r12 <= 0) goto L28;
        if (r12 == Integer.MAX_VALUE) goto L28;
        r2 = true;
    L28:
        if (r2 == false) goto L30;
        r3 = r7;
    L30:
        if (r3 == null) goto L32;
        r13 = r3.intValue();
    L32:
        int r14 = RangesKt.coerceAtMost(Math.max(r11, r6), r13);
        if (r14 > 0) goto L35;
        return;
    L35:
        k(r14);
        return;
    L23:
        r11 = 0;
        goto L24
    L15:
        r5 = Integer.valueOf(A((l) r10.next()));
    L17:
        if (r10.hasNext() == false) goto L21;
        Integer r15 = Integer.valueOf(A((l) r10.next()));
        if (r5.compareTo(r15) >= 0) goto L17;
        r5 = r15;
        goto L17
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void j(boolean r4) {
        if (r4 == false) goto L4;
        setBackgroundResource(2131238880);
        this.k = AppCompatResources.getDrawable(getContext(), 2131240111);
        return;
    L4:
        setBackgroundResource(v19.c.b(2130970627, getContext(), 2131238879));
        this.k = AppCompatResources.getDrawable(getContext(), v19.c.b(2130970952, getContext(), 2131240110));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void k(int r5) {
        this.o = r5;
        LinearLayoutCompat.LayoutParams r0 = getLayoutParams();
        if (r0 != null) goto L6;
        r0 = new LinearLayoutCompat.LayoutParams(r5, -2);
    L6:
        if (((ViewGroup.LayoutParams) r0).width == r5) goto L8;
        ((ViewGroup.LayoutParams) r0).width = r5;
        setLayoutParams(r0);
    L8:
        RecyclerView r1 = getRecyclerView();
        LinearLayoutCompat.LayoutParams r2 = r1.getLayoutParams();
        if (r2 != null) goto L12;
        r2 = new LinearLayoutCompat.LayoutParams(r5, -2);
    L12:
        if (((ViewGroup.LayoutParams) r2).width == r5) goto L14;
        ((ViewGroup.LayoutParams) r2).width = r5;
        r1.setLayoutParams(r2);
    L14:
        requestLayout();
        getRecyclerView().requestLayout();
        ViewGroup r6 = this.p;
        if (r6 == null) goto L17;
        r6.requestLayout();
    L17:
        View r7 = this.f;
        if (r7 == null) goto L37;
        ViewGroup.LayoutParams r3 = r7.getLayoutParams();
        Integer r4 = null;
        if ((r3 instanceof FrameLayout.LayoutParams) == false) goto L23;
        FrameLayout.LayoutParams r8 = (FrameLayout.LayoutParams) r3;
    L24:
        if (r8 != null) goto L26;
        r8 = new FrameLayout.LayoutParams(getWidth(), getHeight());
    L26:
        Integer r9 = Integer.valueOf(this.o);
        if (r9.intValue() <= 0) goto L29;
        boolean r10 = true;
    L30:
        if (r10 == false) goto L32;
        r4 = r9;
    L32:
        if (r4 == null) goto L34;
        int r11 = r4.intValue();
    L35:
        r8.width = r11;
        r8.height = getHeight();
        r7.setLayoutParams(r8);
        return;
    L34:
        r11 = getWidth();
        goto L35
    L29:
        r10 = false;
        goto L30
    L23:
        r8 = null;
        goto L24
    }

    public final View s(int r2) {
        RecyclerView.ViewHolder r0 = getRecyclerView().findViewHolderForAdapterPosition(r2);
        if (r0 == null) goto L6;
        View r1 = r0.itemView;
        if (r1 == null) goto L6;
        return r1;
    L6:
        RecyclerView.LayoutManager r3 = getRecyclerView().getLayoutManager();
        if (r3 != null) goto L12;
        return null;
    L12:
        return r3.findViewByPosition(r2);
    }

    public final void setMenuWidth(int r2) {
        if (r2 > 0) goto L5;
        return;
    L5:
        if (r2 <= this.n) goto L7;
        this.n = r2;
        setMaxWidth(r2);
    L7:
        k(r2);
        n();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setMiniWidth(int r1) {
        setMinimumWidth(r1);
        L(CollectionsKt.toList(getMenuAdapter().a));
        n();
    }

    public final void setOnMenuSizeChangedListener(Function1<? super View, Unit> r1) {
        this.q = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void v(Context r3) {
        setOrientation(1);
        j(false);
        setOutlineProvider(ViewOutlineProvider.BACKGROUND);
        setClipToOutline(true);
        setShowDividers(2);
        setMinimumWidth(i5.B());
        int r4 = i5.y0(v19.c.b(2130971356, null, 2131167081));
        this.n = r4;
        setMaxWidth(r4);
        setId(2131392492);
        p();
    }

    public CreateMenuV2(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.b = LazyKt.lazy(new kt8.k(this));
        this.c = LazyKt.lazy(new kt8.l(this));
        this.d = LazyKt.lazy(new kt8.m(this));
        this.e = new LinkedHashMap();
        this.l = s;
        this.n = Integer.MAX_VALUE;
        v(r2);
    }

    public static int z(CreateMenuV2 r2, SimpleDraweeView r3) {
        r2.getClass();
        int r1 = 0;
        if (r3.getVisibility() != 0) goto L17;
        ViewGroup.LayoutParams r0 = r3.getLayoutParams();
        if (r0 == null) goto L8;
        r1 = r0.width;
    L8:
        ViewGroup.MarginLayoutParams r4 = null;
        if (r1 <= 0) goto L15;
        ViewGroup.LayoutParams r5 = r3.getLayoutParams();
        if ((r5 instanceof ViewGroup.MarginLayoutParams) == false) goto L16;
        r4 = (ViewGroup.MarginLayoutParams) r5;
    L16:
        return r1 + u(r4);
    L15:
        return r2.y(r3, null);
    L17:
        return 0;
    }

    public final Integer E(m0 r2, boolean r3) {
        Object r0 = null;
        if (r3 == false) goto L6;
        if (r2 == null) goto L8;
        String r4 = r2.a;
    L9:
        if (r4 != null) goto L11;
    L14:
        boolean r5 = true;
    L15:
        if (r5 == false) goto L27;
        return null;
    L27:
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L19
        Object r7 = Result.constructor-impl(Integer.valueOf(Color.parseColor(r4)));     // Catch: Throwable -> L19
    L22:
        if (Result.isFailure-impl(r7) == true) goto L26;
        r0 = r7;
    L26:
        return (Integer) r0;
    L19:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L22
    L11:
        if (r4.length() == 0) goto L14;
        r5 = false;
    L8:
        r4 = null;
        goto L9
    L6:
        if (r2 == null) goto L8;
        r4 = r2.b;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void H(boolean r5, final Function0<Unit> r6) {
        ViewParent r0 = getParent();
        if ((r0 instanceof FrameLayout) == false) goto L5;
        FrameLayout r1 = (FrameLayout) r0;
    L6:
        if (r1 == null) goto L18;
        if (r5 == true) goto L9;
        View r7 = this.f;
        if (r7 == null) goto L21;
        e1.o(r7);
        return;
    L21:
        return;
    L9:
        if (this.f != null) goto L11;
        View r8 = new View(getContext());
        r8.setLayoutParams(new FrameLayout.LayoutParams(getWidth(), getHeight()));
        r8.setBackgroundResource(v19.c.b(2130971607, r8.getContext(), 2131240710));
        r8.setAlpha(0.5f);
        r8.setClickable(true);
        r8.setOnClickListener(new kt8.p(r6));
        this.f = r8;
        r1.addView(r8);
    L11:
        View r9 = this.f;
        if (r9 == null) goto L19;
        e1.x(r9);
        return;
    L19:
        return;
    L18:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void J(LarusCreateMenuItemLayoutV2Binding r4, boolean r5) {
        FrameLayout r0 = r4.f;
        int r1 = 0;
        if (r5 == false) goto L5;
        int r2 = 0;
    L6:
        r0.setVisibility(r2);
        ViewGroup.LayoutParams r3 = r4.m.getLayoutParams();
        if ((r3 instanceof ViewGroup.MarginLayoutParams) == false) goto L9;
        ViewGroup.MarginLayoutParams r6 = (ViewGroup.MarginLayoutParams) r3;
    L10:
        if (r6 != null) goto L12;
        return;
    L12:
        if (r5 == false) goto L15;
        r1 = this.l.i;
    L15:
        if (r6.getMarginStart() == r1) goto L18;
        r6.setMarginStart(r1);
        r4.m.setLayoutParams(r6);
        return;
    L18:
        return;
    L9:
        r6 = null;
        goto L10
    L5:
        r2 = 8;
        goto L6
    }

    public final void h(LarusCreateMenuItemLayoutV2Binding r6, l0 r7) {
        Integer r8 = r7.L;
        if (r8 == null) goto L5;
        int r9 = r8.intValue();
    L6:
        I(r6.f, r9, r9);
        I(r6.e, r9, r9);
        SimpleDraweeView r10 = r6.k;
        int r0 = this.l.f;
        I(r10, r0, r0);
        I(r6.l, i5.m(), i5.m());
        int r1 = 0;
        r6.j.setTextSize(0, this.l.g);
        r6.h.setTextSize(0, this.l.g);
        r6.i.setTextSize(0, this.l.h);
        r6.i.setMaxLines(RangesKt.coerceAtLeast(this.l.j, 1));
        AppCompatTextView r11 = r6.i;
        ConstraintLayout.LayoutParams r12 = r11.getLayoutParams();
        int r3 = -2;
        if (this.l.j <= 1) goto L9;
        int r2 = -2;
    L10:
        ((ViewGroup.LayoutParams) r12).height = r2;
        if ((r12 instanceof ConstraintLayout.LayoutParams) == false) goto L20;
        ConstraintLayout.LayoutParams r4 = r12;
        int r5 = this.l.j;
        if (r5 <= 1) goto L15;
        r3 = 0;
    L15:
        ((ViewGroup.MarginLayoutParams) r4).width = r3;
        if (r5 > 1) goto L19;
        r1 = -1;
    L19:
        r4.endToEnd = r1;
    L20:
        r11.setLayoutParams(r12);
        return;
    L9:
        r2 = i5.A();
        goto L10
    L5:
        r9 = this.l.e;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void l(AppCompatTextView r6, l0 r7) {
        String r0 = r7.F;
        if (r0 != null) goto L5;
    L8:
        boolean r3 = true;
    L10:
        if (r3 == false) goto L13;
        r(r6);
        r6.setMinWidth(0);
        r6.setMaxWidth(Integer.MAX_VALUE);
        e1.o(r6);
        r6.setText("");
        return;
    L13:
        r(r6);
        r6.setMinWidth(0);
        r6.setMaxWidth(Integer.MAX_VALUE);
        r6.setMaxLines(1);
        r6.setText(r0);
        e1.x(r6);
        r6.requestLayout();
        Integer r1 = r7.J;
        if (r1 != null) goto L19;
        Integer r8 = r7.G;
        if (r8 == null) goto L18;
        int r9 = r8.intValue();
        r1 = Integer.valueOf(ContextCompat.getColor(getContext(), r9));
        goto L19
    L18:
        r1 = null;
    L19:
        if (r1 == null) goto L21;
        r6.setTextColor(r1.intValue());
        return;
    L21:
        r6.setTextColor(ContextCompat.getColor(getContext(), v19.c.b(2130972081, getContext(), 2131103143)));
        return;
    L5:
        if (r0.length() == 0) goto L8;
        r3 = false;
        goto L10
    }

    public final void t(l0 r2, View r3) {
        if (r2.p == false) goto L10;
        Function2<? super Integer, ? super View, Unit> r0 = this.i;
        if (r0 == null) goto L7;
        r0.invoke(Integer.valueOf(r2.a), r3);
        return;
    L7:
        Function1<? super Integer, Unit> r4 = this.h;
        if (r4 == null) goto L15;
        r4.invoke(Integer.valueOf(r2.a));
        return;
    L15:
        return;
    L10:
        Function2<? super Integer, ? super String, Unit> r5 = this.j;
        if (r5 == null) goto L17;
        r5.invoke(Integer.valueOf(r2.a), r2.u);
        return;
    }

    public final int y(View r5, Integer r6) {
        if (r5.getVisibility() == 0) goto L5;
        return 0;
    L5:
        ViewGroup.MarginLayoutParams r0 = null;
        if (r6 != null) goto L18;
        r6 = Integer.valueOf(this.n);
        int r2 = r6.intValue();
        if (r2 > 0) goto L11;
    L13:
        boolean r3 = false;
    L14:
        if (r3 == true) goto L17;
        r6 = null;
    L17:
        if (r6 != null) goto L18;
        int r7 = 0;
    L20:
        r5.measure(View.MeasureSpec.makeMeasureSpec(r7, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(0, 0));
        ViewGroup.LayoutParams r8 = r5.getLayoutParams();
        if ((r8 instanceof ViewGroup.MarginLayoutParams) == false) goto L24;
        r0 = (ViewGroup.MarginLayoutParams) r8;
    L24:
        return r5.getMeasuredWidth() + u(r0);
    L11:
        if (r2 == Integer.MAX_VALUE) goto L13;
        r3 = true;
    L18:
        r7 = r6.intValue();
        goto L20
    }

    public CreateMenuV2(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.b = LazyKt.lazy(new kt8.k(this));
        this.c = LazyKt.lazy(new kt8.l(this));
        this.d = LazyKt.lazy(new kt8.m(this));
        this.e = new LinkedHashMap();
        this.l = s;
        this.n = Integer.MAX_VALUE;
        v(r2);
    }

    public static void I(View r3, int r4, int r5) {
        ViewGroup.LayoutParams r0 = r3.getLayoutParams();
        if (r0 != null) goto L5;
        return;
    L5:
        boolean r2 = true;
        if (r0.width == r4) goto L8;
        r0.width = r4;
        boolean r6 = true;
    L10:
        if (r0.height == r5) goto L12;
        r0.height = r5;
    L13:
        if (r2 == false) goto L16;
        r3.setLayoutParams(r0);
        return;
    L16:
        return;
    L12:
        r2 = r6;
        goto L13
    L8:
        r6 = false;
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void e(CreateMenuV2 r7, LinearLayout r8, l r9) {
        CreateMenu.a.C0051a r0 = r7.l;
        Integer r1 = r9.a.H;
        boolean r2 = false;
        if (r1 == null) goto L9;
        int r3 = r1.intValue();
        Integer r4 = r9.a.L;
        if (r4 == null) goto L7;
        int r5 = r4.intValue();
    L8:
        Integer r6 = Integer.valueOf(RangesKt.coerceAtLeast((r3 - r5) / 2, 0));
    L10:
        r8.setOrientation(0);
        int r10 = r0.a;
        if (r6 == null) goto L13;
        int r11 = r6.intValue();
    L14:
        int r12 = r0.b;
        if (r6 == null) goto L17;
        int r13 = r6.intValue();
    L18:
        r8.setPadding(r10, r11, r12, r13);
        MenuItemType r14 = r9.a.getType();
        MenuItemType r15 = MenuItemType.BUTTON;
        if (r14 != r15) goto L21;
        int r16 = Math.max(r0.c, r0.d);
        r8.setPadding(r8.getPaddingLeft(), r16, r8.getPaddingRight(), r16);
    L21:
        RecyclerView.LayoutParams r17 = r8.getLayoutParams();
        int r18 = -2;
        if (r17 != null) goto L24;
        r17 = new RecyclerView.LayoutParams(-1, -2);
    L24:
        l0 r19 = r9.a;
        Integer r20 = r19.H;
        if (r20 == null) goto L28;
        r18 = r20.intValue();
    L39:
        ((ViewGroup.LayoutParams) r17).height = r18;
        r8.setLayoutParams(r17);
        int r21 = r9.c;
        if (r21 == 1) goto L42;
        int r22 = r9.b;
        if (r22 != 0) goto L52;
        if (r7.m == false) goto L50;
        int r23 = 2131238907;
    L61:
        r8.setBackground(AppCompatResources.getDrawable(r7.getContext(), r23));
        return;
    L50:
        r23 = v19.c.b(2130970633, r7.getContext(), 2131238906);
        goto L61
    L52:
        if (r22 != (r21 - 1)) goto L58;
        if (r7.m == false) goto L56;
        r23 = 2131238915;
        goto L61
    L56:
        r23 = v19.c.b(2130970635, r7.getContext(), 2131238914);
        goto L61
    L58:
        if (r7.m == false) goto L60;
        r23 = 2131238923;
        goto L61
    L60:
        r23 = v19.c.b(2130970637, r7.getContext(), 2131238922);
        goto L61
    L42:
        if (r7.m == false) goto L44;
        r23 = 2131238931;
        goto L61
    L44:
        r23 = v19.c.b(2130970639, r7.getContext(), 2131238930);
        goto L61
    L28:
        if (r19.getType() == r15) goto L39;
        if (r7.l.j <= 1) goto L38;
        String r24 = r9.a.u;
        if (r24 != null) goto L34;
    L35:
        r2 = true;
    L36:
        if (r2 == true) goto L38;
    L34:
        if (r24.length() != 0) goto L36;
    L38:
        r18 = i5.d0();
        goto L39
    L17:
        r13 = r0.d;
        goto L18
    L13:
        r11 = r0.c;
        goto L14
    L7:
        r5 = r0.e;
        goto L8
    L9:
        r6 = null;
        goto L10
    }

    public static final void g(CreateMenuV2 r2, View r3, boolean r4) {
        r2.getClass();
        RecyclerView.LayoutParams r5 = r3.getLayoutParams();
        int r0 = -2;
        if (r5 != null) goto L5;
        r5 = new RecyclerView.LayoutParams(-1, -2);
    L5:
        int r1 = 0;
        if (r4 == false) goto L8;
        r0 = 0;
    L8:
        ((ViewGroup.LayoutParams) r5).height = r0;
        r3.setLayoutParams(r5);
        if (r4 == false) goto L11;
        r1 = 8;
    L11:
        r3.setVisibility(r1);
    }

    public static void m(LarusCreateMenuItemLayoutV2Binding r1, l0 r2, boolean r3) {
        if (o0.d(r2.e) == false) goto L7;
        e1.x(r1.l);
        if (r3 == false) goto L9;
        ImageLoaderKt.u(r1.l, r2.e, "default_menu_text");
        return;
    L9:
        return;
    L7:
        e1.o(r1.l);
        r1.l.setImageDrawable(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void D(ViewGroup r4, int r5, Integer r6) {
        LinearLayoutCompat.LayoutParams r0 = r4.getLayoutParams();
        if (r0 != null) goto L5;
        r0 = new LinearLayoutCompat.LayoutParams(-2, -2);
    L5:
        r4.setLayoutParams(r0);
        this.p = r4;
        j r1 = null;
        if (Intrinsics.areEqual(getParent(), r4) == true) goto L15;
        ViewParent r2 = getParent();
        if ((r2 instanceof ViewGroup) == false) goto L10;
        ViewGroup r3 = (ViewGroup) r2;
    L11:
        if (r3 == null) goto L13;
        r3.removeView(this);
    L13:
        r4.addView(this);
        goto L15
    L10:
        r3 = null;
    L15:
        if ((r4 instanceof j) == false) goto L17;
        r1 = (j) r4;
    L17:
        if (r1 == null) goto L19;
        r1.a(r6);
    L19:
        r4.setBackgroundResource(2131238838);
        r4.setPadding(r5, r5, r5, r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final List<l> K(List<l0> r1, boolean r2, Integer r3, Integer r4, Integer r5, CreateMenu.a.C0051a r6, Function2<? super Integer, ? super String, Unit> r7, Function2<? super Integer, ? super View, Unit> r8, Function1<? super Integer, Unit> r9) {
        this.j = r7;
        this.i = r8;
        this.h = r9;
        this.l = r6;
        this.m = r2;
        if (r2 == true) goto L8;
        boolean r10 = v19.h.a;
        if (v19.h.b(getContext()) == true) goto L8;
        boolean r11 = false;
    L9:
        this.g = r11;
        j(r2);
        if (r3 == null) goto L12;
        setShowDividers(r3.intValue());
    L12:
        if (r4 == null) goto L14;
        setMinimumWidth(r4.intValue());
    L14:
        if (r5 == null) goto L16;
        int r12 = r5.intValue();
        this.n = r12;
        setMaxWidth(r12);
    L16:
        ((LinkedHashMap) this.e).clear();
        p();
        ArrayList r13 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator<T> r14 = r1.iterator();
        int r15 = 0;
    L18:
        if (r14.hasNext() == false) goto L23;
        Object r16 = r14.next();
        int r17 = r15 + 1;
        if (r15 >= 0) goto L22;
        CollectionsKt.throwIndexOverflow();
    L22:
        r13.add(new l((l0) r16, r15, ((ArrayList) r1).size(), false));
        r15 = r17;
        goto L18
    L23:
        L(r13);
        c r18 = getMenuAdapter();
        r18.getClass();
        Intrinsics.checkNotNullParameter(r13, "newRows");
        DiffUtil.DiffResult r19 = DiffUtil.calculateDiff(new m(CollectionsKt.toList(r18.a), r13));
        ((ArrayList) r18.a).clear();
        ((ArrayList) r18.a).addAll(r13);
        r19.dispatchUpdatesTo(r18);
        getRecyclerView().invalidateItemDecorations();
        return r13;
    L8:
        r11 = true;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ View C(CreateMenuV2 r15, List r16, int r17, boolean r18, Integer r19, Integer r20, Integer r21, CreateMenu.a.C0051a r22, com.larus.bmhome.chat.nestedmenu.ui.l r23, Function2 r24, Function1 r25, int r26) {
        if ((r26 & 2) == 0) goto L5;
        int r4 = i5.Q();
    L7:
        if ((r26 & 4) == 0) goto L9;
        boolean r5 = false;
    L11:
        if ((r26 & 32) == 0) goto L13;
        Integer r8 = null;
    L15:
        if ((r26 & 64) == 0) goto L17;
        Integer r9 = null;
    L19:
        if ((r26 & 128) == 0) goto L21;
        Integer r10 = null;
    L23:
        if ((r26 & 256) == 0) goto L25;
        CreateMenu.a.C0051a r11 = s;
    L27:
        if ((r26 & 512) == 0) goto L29;
        com.larus.bmhome.chat.nestedmenu.ui.l r12 = null;
    L31:
        if ((r26 & 1024) == 0) goto L33;
        Function2 r13 = null;
    L35:
        return r15.B(r16, r4, r5, false, null, r8, r9, r10, r11, r12, r13, r25);
    L33:
        r13 = r24;
        goto L35
    L29:
        r12 = r23;
        goto L31
    L25:
        r11 = r22;
        goto L27
    L21:
        r10 = r21;
        goto L23
    L17:
        r9 = r20;
        goto L19
    L13:
        r8 = r19;
        goto L15
    L9:
        r5 = r18;
        goto L11
    L5:
        r4 = r17;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final View B(List<l0> r12, int r13, boolean r14, boolean r15, Integer r16, Integer r17, Integer r18, Integer r19, CreateMenu.a.C0051a r20, Function2<? super Integer, ? super String, Unit> r21, Function2<? super Integer, ? super View, Unit> r22, Function1<? super Integer, Unit> r23) {
        Intrinsics.checkNotNullParameter(r12, "items");
        Intrinsics.checkNotNullParameter(r20, "config");
        Intrinsics.checkNotNullParameter(r23, "listener");
        List<l> r0 = K(r12, r15, r16, r17, r18, r20, r21, r22, r23);
        if (r14 == false) goto L5;
        ViewGroup r1 = new g(this, getContext());
    L6:
        D(r1, r13, r19);
        L(r0);
        n();
        return r1;
    L5:
        r1 = new h(this, getContext());
        goto L6
    }
}
