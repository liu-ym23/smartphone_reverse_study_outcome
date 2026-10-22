package com.ss.android.lark.picker.base.view.avataritem;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import b08.a;
import b08.c;
import com.bytedance.common.utility.UIUtils;
import com.larksuite.component.decoration.avatar.DecoratedAvatar;
import com.larksuite.component.ui.avatar.AvatarModel;
import com.larksuite.component.ui.avatar.v2.LarkAvatarView;
import com.larksuite.component.ui.display.manager.zoom.ZoomLevel4;
import com.larksuite.component.ui.display.manager.zoom.ZoomLevel6;
import com.larksuite.component.ui.tag.LarkNameTag;
import com.larksuite.component.universe_design.checkbox.UDCheckBox;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larksuite.framework.ui.PriorityLayout;
import com.larksuite.framework.ui.SpareLayout;
import com.larksuite.framework.utils.CollectionUtils;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.chat.entity.chatter.AvatarMedal;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.picker.base.PickerBaseModuleDependency;
import com.ss.android.lark.picker.base.utils.SearchCommonFgUtils;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.picker.base.view.avataritem.checkbox.CheckBoxBinder;
import com.ss.android.lark.picker.base.widget.utils.FakePickerAvatarCreator;
import com.ss.android.lark.search.dto.info.ExtraInfoSummary;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.EllipsizedEmojiconTextView;
import com.suite.lark.platform.component.widget_biz_userstatus.UserStatusLinearLayout;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.SortedMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;
import w3c.b;
import w3c.e;
import w3c.f;
import w3c.g;
import w3c.h;
import w3c.j;
import y9c.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000°\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 È\u00012\u00020\u00012\u00020\u0002:\u0004È\u0001É\u0001B1\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010E\u001a\u00020F2\u0006\u00101\u001a\u000202J\u000e\u0010G\u001a\u00020F2\u0006\u0010H\u001a\u00020IJ\u000e\u0010J\u001a\u00020F2\u0006\u0010K\u001a\u00020LJ\u000e\u0010M\u001a\u00020F2\u0006\u0010N\u001a\u00020OJ\u000e\u0010P\u001a\u00020F2\u0006\u0010N\u001a\u00020OJ\u0006\u0010Q\u001a\u00020FJ7\u0010R\u001a\u00020F2\b\u0010S\u001a\u0004\u0018\u00010T2\b\u0010U\u001a\u0004\u0018\u00010V2\n\b\u0002\u0010W\u001a\u0004\u0018\u00010X2\n\b\u0002\u0010Y\u001a\u0004\u0018\u00010X¢\u0006\u0002\u0010ZJ\u001c\u0010R\u001a\u00020F2\b\u0010S\u001a\u0004\u0018\u00010T2\n\b\u0002\u0010[\u001a\u0004\u0018\u00010TJ\u000e\u0010\\\u001a\u00020F2\u0006\u0010]\u001a\u00020\bJ\u0006\u0010^\u001a\u00020FJ\u000e\u0010_\u001a\u00020F2\u0006\u0010`\u001a\u00020aJ\u0010\u0010b\u001a\u00020F2\b\u0010c\u001a\u0004\u0018\u00010dJ\u0012\u0010e\u001a\u00020F2\n\u0010f\u001a\u0006\u0012\u0002\b\u00030gJ\u0012\u0010h\u001a\u00020F2\n\u0010f\u001a\u0006\u0012\u0002\b\u00030gJ\u0006\u0010i\u001a\u00020FJ\u0006\u0010j\u001a\u00020\u0000J\u000e\u0010[\u001a\u00020F2\u0006\u0010k\u001a\u00020lJ\u000e\u0010m\u001a\u00020F2\u0006\u0010n\u001a\u00020oJ\u0006\u0010p\u001a\u00020FJ\u000e\u0010q\u001a\u00020F2\u0006\u0010r\u001a\u00020sJ\u000e\u0010!\u001a\u00020F2\u0006\u0010t\u001a\u00020uJ\"\u0010v\u001a\u00020F2\u0006\u0010w\u001a\u0002002\b\b\u0002\u0010x\u001a\u00020I2\b\b\u0002\u0010y\u001a\u00020IJ\u0006\u0010z\u001a\u00020FJ\u000e\u0010{\u001a\u00020F2\u0006\u0010|\u001a\u00020}J\u000e\u0010~\u001a\u00020F2\u0006\u0010\u007f\u001a\u00020\bJ\u0007\u0010\u0080\u0001\u001a\u00020FJ\u0010\u0010\u0081\u0001\u001a\u00020F2\u0007\u0010\u0082\u0001\u001a\u00020}J\u0010\u0010\u0083\u0001\u001a\u00020F2\u0007\u0010\u0084\u0001\u001a\u00020\bJ\u001a\u0010\u0085\u0001\u001a\u00020F2\u0007\u0010\u0086\u0001\u001a\u00020\u001c2\u0006\u0010|\u001a\u00020}H\u0002J\t\u0010\u008a\u0001\u001a\u00020FH\u0002J\t\u0010\u008b\u0001\u001a\u00020\bH\u0002J\u0011\u0010\u008c\u0001\u001a\u00020F2\b\u0010\u008c\u0001\u001a\u00030\u008d\u0001J\u0011\u0010\u008e\u0001\u001a\u00020F2\b\u0010\u008f\u0001\u001a\u00030\u0090\u0001J\u0012\u0010\u0091\u0001\u001a\u00020F2\t\u0010\u0092\u0001\u001a\u0004\u0018\u00010VJ\u0010\u0010\u0093\u0001\u001a\u00020F2\u0007\u0010\u0094\u0001\u001a\u000200J\u000f\u0010\u0095\u0001\u001a\u00020F2\u0006\u0010>\u001a\u000200J\u0011\u0010\u0096\u0001\u001a\u00020F2\b\u0010\u0097\u0001\u001a\u00030\u0098\u0001J\u001a\u0010\u0096\u0001\u001a\u00020F2\b\u0010\u0097\u0001\u001a\u00030\u0098\u00012\u0007\u0010\u0099\u0001\u001a\u00020\bJ\u0010\u0010\u009a\u0001\u001a\u00020F2\u0007\u0010\u009b\u0001\u001a\u00020IJ\u001a\u0010\u009c\u0001\u001a\u00020F2\b\u0010\u009d\u0001\u001a\u00030\u009e\u00012\u0007\u0010\u009f\u0001\u001a\u00020\bJ\u0015\u0010 \u0001\u001a\u00020F2\n\u0010¡\u0001\u001a\u0005\u0018\u00010¢\u0001H\u0016J\t\u0010£\u0001\u001a\u000200H\u0014J\t\u0010¤\u0001\u001a\u000200H\u0002J\u0010\u0010¥\u0001\u001a\u00020\u00002\u0007\u0010¦\u0001\u001a\u00020\bJ\t\u0010§\u0001\u001a\u00020FH\u0002J\t\u0010¨\u0001\u001a\u00020FH\u0014J\u0007\u0010©\u0001\u001a\u00020FJ\t\u0010ª\u0001\u001a\u00020FH\u0002J\u0012\u0010«\u0001\u001a\u00020F2\u0007\u0010¬\u0001\u001a\u00020XH\u0002J\u001b\u0010\u00ad\u0001\u001a\u00020F2\u0007\u0010®\u0001\u001a\u00020\b2\u0007\u0010¯\u0001\u001a\u00020\bH\u0014J\u0015\u0010°\u0001\u001a\u00020\b*\u00020\u001c2\u0006\u0010W\u001a\u00020\bH\u0002J\u0007\u0010±\u0001\u001a\u00020XJ\u0010\u0010²\u0001\u001a\u00020F2\u0007\u0010³\u0001\u001a\u00020\bJ\u0010\u0010´\u0001\u001a\u00020F2\u0007\u0010³\u0001\u001a\u00020\bJ\u0010\u0010µ\u0001\u001a\u00020F2\u0007\u0010³\u0001\u001a\u00020\bJ\u0010\u0010¶\u0001\u001a\u00020F2\u0007\u0010³\u0001\u001a\u00020\bJ\u0012\u0010·\u0001\u001a\u00020F2\u0007\u0010³\u0001\u001a\u00020\bH\u0002J\u0010\u0010¸\u0001\u001a\u00020F2\u0007\u0010¬\u0001\u001a\u00020XJ\u0010\u0010¹\u0001\u001a\u00020F2\u0007\u0010º\u0001\u001a\u00020IJ\t\u0010»\u0001\u001a\u00020\bH\u0002J\t\u0010¼\u0001\u001a\u00020\bH\u0002J\u000b\u0010½\u0001\u001a\u00020\b*\u00020\bJ\u000b\u0010½\u0001\u001a\u00020\b*\u00020XJ\u000b\u0010¾\u0001\u001a\u00020X*\u00020XJü\u0001\u0010¿\u0001\u001a\u00020F\"\u0014\b\u0000\u0010À\u0001*\r Â\u0001*\u0005\u0018\u00010Á\u00010Á\u0001\"\u0012\b\u0001\u0010Ã\u0001*\u000b Â\u0001*\u0004\u0018\u0001000022\u0010Ä\u0001\u001a-\u0012\u000f\u0012\r Â\u0001*\u0005\u0018\u0001HÀ\u0001HÀ\u0001 Â\u0001*\u0015\u0012\u000f\u0012\r Â\u0001*\u0005\u0018\u0001HÀ\u0001HÀ\u0001\u0018\u00010g0g22\u0010Å\u0001\u001a-\u0012\u000f\u0012\r Â\u0001*\u0005\u0018\u0001HÃ\u0001HÃ\u0001 Â\u0001*\u0015\u0012\u000f\u0012\r Â\u0001*\u0005\u0018\u0001HÃ\u0001HÃ\u0001\u0018\u00010g0g2^\u0010Æ\u0001\u001aY\u0012\u0011\b\u0000\u0012\r Â\u0001*\u0005\u0018\u0001HÃ\u0001HÃ\u0001\u0012\u0011\b\u0000\u0012\r Â\u0001*\u0005\u0018\u0001HÀ\u0001HÀ\u0001 Â\u0001*+\u0012\u0011\b\u0000\u0012\r Â\u0001*\u0005\u0018\u0001HÃ\u0001HÃ\u0001\u0012\u0011\b\u0000\u0012\r Â\u0001*\u0005\u0018\u0001HÀ\u0001HÀ\u0001\u0018\u00010Ç\u00010Ç\u0001H\u0096\u0001R\u0014\u0010\t\u001a\u00020\nX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0001X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u001cX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u001cX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u001cX\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010&\u001a\u00020\u001cX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u000e\u0010+\u001a\u00020,X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u000200X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000202X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020.X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0001X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u000206X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u001eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020.X\u0082.¢\u0006\u0002\n\u0000R\u001b\u00109\u001a\u0002008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b:\u0010;R\u001b\u0010>\u001a\u0002008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b@\u0010=\u001a\u0004\b?\u0010;R\u000e\u0010A\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020DX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0087\u0001\u001a\u00030\u0088\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0089\u0001\u001a\u00030\u0088\u0001X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006Ê\u0001"}, d2 = {"Lcom/ss/android/lark/picker/base/view/avataritem/AvatarItemView;", "Landroid/widget/LinearLayout;", "Lcom/larksuite/component/ui/list/ICompositeComponent;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "compositeComponentDelegate", "Lcom/larksuite/component/ui/list/CompositeComponentDelegate;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;ILcom/larksuite/component/ui/list/CompositeComponentDelegate;)V", "getCompositeComponentDelegate", "()Lcom/larksuite/component/ui/list/CompositeComponentDelegate;", "dslRenderContainer", "checkBox", "Lcom/larksuite/component/universe_design/checkbox/UDCheckBox;", "decoratedAvatarView", "Lcom/larksuite/component/decoration/avatar/DecoratedAvatar;", "avatarView", "Lcom/larksuite/component/ui/avatar/v2/LarkAvatarView;", "getAvatarView", "()Lcom/larksuite/component/ui/avatar/v2/LarkAvatarView;", "setAvatarView", "(Lcom/larksuite/component/ui/avatar/v2/LarkAvatarView;)V", "miniAvatarView", "titleView", "Landroid/widget/TextView;", "personalStatusView", "Landroid/widget/ImageView;", "titleTailView", "Lcom/ss/android/lark/widget/EllipsizedEmojiconTextView;", "userStatus", "Lcom/suite/lark/platform/component/widget_biz_userstatus/UserStatusLinearLayout;", "subTitleView", "localTimeView", "assignTimeView", "summaryView", "getSummaryView", "()Landroid/widget/TextView;", "setSummaryView", "(Landroid/widget/TextView;)V", "extraInfoView", "Lcom/ss/android/lark/picker/base/view/avataritem/ExtraInfoView;", "bottomFrameLayout", "Landroid/widget/FrameLayout;", "divider", "Landroid/view/View;", "checkBoxModel", "Lcom/ss/android/lark/search/dto/bindermodel/CheckBoxModel;", "contentLayout", "avatarItemSubtitleContainer", "rightItemWrapper", "Landroid/view/ViewGroup;", "rightTagWrapper", "rightViewHolder", "contentView", "getContentView", "()Landroid/view/View;", "contentView$delegate", "Lkotlin/Lazy;", "bottomView", "getBottomView", "bottomView$delegate", "mOldWidthMeasureSpec", "mOldHeightMeasureSpec", "fgUtils", "Lcom/ss/android/lark/picker/base/utils/SearchCommonFgUtils;", "checkState", "", "updateCheckState", "isChecked", "", "medal", "medalModel", "Lcom/ss/android/lark/chat/entity/chatter/AvatarMedal;", "avatar", "avatarModel", "Lcom/larksuite/component/ui/avatar/AvatarModel;", "miniAvatar", "userTeamBadge", "bindAvatarWithUrl", "url", "", "placeHolder", "Landroid/graphics/drawable/Drawable;", "width", "", "height", "(Ljava/lang/String;Landroid/graphics/drawable/Drawable;Ljava/lang/Float;Ljava/lang/Float;)V", "title", "bindAvatarWithResourceID", "resourceID", "adjustAlign", "badge", "badgeModel", "Lcom/larksuite/component/ui/badge/BadgeModel;", "miniIcon", "miniIconModel", "Lcom/larksuite/component/ui/badge/miniicon/MiniIconModel;", "unBindAvatar", "modelClass", "Ljava/lang/Class;", "unBindMiniAvatar", "unBindMedal", "resetTags", "titleModel", "Lcom/ss/android/lark/search/dto/bindermodel/TitleModel;", "personalStatus", "status", "Lcom/ss/android/lark/search/dto/bindermodel/PersonalStatus;", "unbindPersonalStatus", "titleTail", "tailModel", "Lcom/ss/android/lark/search/dto/bindermodel/TitleTailModel;", "model", "Lcom/ss/android/lark/search/dto/bindermodel/UserStatusModel;", "attachRightView", "v", "just2Center", "isExpandClickArea", "removeRightView", "subTitle", "subtitleModel", "Lcom/ss/android/lark/search/dto/bindermodel/SubtitleModel;", "setSubTitleLines", "maxLines", "justCheckBoxToCenter", "summary", "summaryModel", "setSubTitleMaxLines", "maxLine", "bindTextViewWithModel", "view", "subTitleState", "Lcom/ss/android/lark/picker/base/view/avataritem/AvatarItemView$UiState;", "summaryState", "adjustAvatarTopMargin", "adjustCheckboxTopMargin", "localTime", "Lcom/ss/android/lark/search/dto/bindermodel/LocalTimeModel;", "assignTime", "time", "Lcom/ss/android/lark/search/dto/bindermodel/AssignTimeModel;", "setSubtitleTag", "drawable", "addViewToRender", "renderView", "addBottomView", "setTag", "builder", "Lcom/larksuite/component/ui/tag/LarkNameTag$Builder;", "tagMode", "showDivider", "isShow", "setExtraInfoSummary", "extraInfoSummary", "Lcom/ss/android/lark/search/dto/info/ExtraInfoSummary;", "type", "setOnClickListener", "l", "Landroid/view/View$OnClickListener;", "createContentView", "createBottomView", "applyStyle", "style", "layoutSelf", "registerBinder", "resetAllViews", "resetMiniAvatarStyle", "setMiniAvatarSize", "size", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "numOfCharsByHanziOne", "subTitleTextSize", "avatarTopMargin", "margin", "checkBoxStartMargin", "avatarStartMargin", "titleBottomMargin", "avatarMarginStart", "avatarSizeAdjust", "avatarShape", "isOval", "getTitleHeightWithZoom", "getSubTitleHeightWithZoom", "dp", "dpF", "registerModelBinder", "M", "", "kotlin.jvm.PlatformType", "V", "p0", "p1", "p2", "Lcom/larksuite/component/ui/list/IComponentBinder;", "Companion", "UiState", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public class AvatarItemView extends LinearLayout implements c {
    private static final float AVATAR_ITEM_HEIGHT = 76.0f;
    public static final float AVATAR_SIZE = 48.0f;
    private static final float CHECKBOX_LAYOUT_SIZE = 20.0f;
    private static final float CHECK_BOX_TOP_MARGIN = 26.0f;
    public static final Companion Companion = null;
    private static final float DIVIDER_HEIGHT = 0.5f;
    private static final float DRAWABLE_PADDING_4 = 4.0f;
    public static final int FIRST_VIEW_MIN_WIDTH = 86;
    public static final float LAYOUT_MARGIN_12 = 12.0f;
    public static final float LAYOUT_MARGIN_16 = 16.0f;
    private static final float LAYOUT_MARGIN_4 = 4.0f;
    public static final float LAYOUT_MARGIN_8 = 8.0f;
    public static final float MIN_AVATAR_SIZE = 22.0f;
    private static final float SUBTITLE_HEIGHT = 22.0f;
    private static final String TAG = "LarkSearch.Common.AvatarItemView";
    public static final int TAG_MODE_ALIGN_RIGHT = 2;
    public static final int TAG_MODE_TEXT_END = 1;
    private static final float TEXT_SIZE_12 = 12.0f;
    private static final float TEXT_SIZE_14 = 14.0f;
    private static final float TEXT_SIZE_17 = 17.0f;
    private static final float TITLE_HEIGHT = 24.0f;
    private static final float USER_TEAM_BADGE_ICON_SIZE = 12.0f;
    private static final float USER_TEAM_BADGE_SIZE = 24.0f;
    private TextView assignTimeView;
    private LinearLayout avatarItemSubtitleContainer;
    public LarkAvatarView avatarView;
    private FrameLayout bottomFrameLayout;
    private final Lazy bottomView$delegate;
    private UDCheckBox checkBox;
    private b checkBoxModel;
    private final a compositeComponentDelegate;
    private FrameLayout contentLayout;
    private final Lazy contentView$delegate;
    private DecoratedAvatar decoratedAvatarView;
    private View divider;
    private LinearLayout dslRenderContainer;
    private ExtraInfoView extraInfoView;
    private SearchCommonFgUtils fgUtils;
    private TextView localTimeView;
    private int mOldHeightMeasureSpec;
    private int mOldWidthMeasureSpec;
    private LarkAvatarView miniAvatarView;
    private ImageView personalStatusView;
    private ViewGroup rightItemWrapper;
    private ImageView rightTagWrapper;
    private FrameLayout rightViewHolder;
    private UiState subTitleState;
    private TextView subTitleView;
    private UiState summaryState;
    public TextView summaryView;
    private EllipsizedEmojiconTextView titleTailView;
    private TextView titleView;
    private UserStatusLinearLayout userStatus;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0016X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/ss/android/lark/picker/base/view/avataritem/AvatarItemView$Companion;", "", "<init>", "()V", "AVATAR_ITEM_HEIGHT", "", "CHECKBOX_LAYOUT_SIZE", "AVATAR_SIZE", "MIN_AVATAR_SIZE", "USER_TEAM_BADGE_SIZE", "USER_TEAM_BADGE_ICON_SIZE", "LAYOUT_MARGIN_16", "LAYOUT_MARGIN_12", "LAYOUT_MARGIN_8", "LAYOUT_MARGIN_4", "TEXT_SIZE_17", "TEXT_SIZE_14", "TEXT_SIZE_12", "DRAWABLE_PADDING_4", "DIVIDER_HEIGHT", "CHECK_BOX_TOP_MARGIN", "TAG_MODE_TEXT_END", "", "TAG_MODE_ALIGN_RIGHT", "FIRST_VIEW_MIN_WIDTH", "TAG", "", "TITLE_HEIGHT", "SUBTITLE_HEIGHT", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/picker/base/view/avataritem/AvatarItemView$UiState;", "", "<init>", "(Ljava/lang/String;I)V", "NONE", "SHOW", "HIDE", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final enum UiState extends Enum<UiState> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ UiState[] $VALUES = null;
        public static final UiState HIDE = null;
        public static final UiState NONE = null;
        public static final UiState SHOW = null;

        private static final /* synthetic */ UiState[] $values() {
            return new UiState[]{NONE, SHOW, HIDE};
        }

        public static EnumEntries<UiState> getEntries() {
            return $ENTRIES;
        }

        static {
            NONE = new UiState("NONE", 0);
            SHOW = new UiState("SHOW", 1);
            HIDE = new UiState("HIDE", 2);
            UiState[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = EnumEntriesKt.enumEntries(r0);
        }

        public static UiState[] values() {
            return (UiState[]) $VALUES.clone();
        }

        public static UiState valueOf(String r1) {
            return (UiState) r27.a.a(UiState.class, r1);
        }

        private UiState(String r1, int r2) {
            super(r1, r2);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public AvatarItemView(Context r9) {
        Intrinsics.checkNotNullParameter(r9, "context");
        this(r9, null, 0, null, 14, null);
    }

    public AvatarItemView(Context r9, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r9, "context");
        this(r9, r10, 0, null, 12, null);
    }

    public AvatarItemView(Context r9, AttributeSet r10, int r11) {
        Intrinsics.checkNotNullParameter(r9, "context");
        this(r9, r10, r11, null, 8, null);
    }

    public <M, V extends View> void registerModelBinder(Class<M> r2, Class<V> r3, b08.b<? super V, ? super M> r4) {
        this.compositeComponentDelegate.registerModelBinder(r2, r3, r4);
    }

    private final void adjustAvatarTopMargin() {
        UiState r0 = this.subTitleState;
        UiState r1 = UiState.NONE;
        if (r0 == r1) goto L12;
        UiState r2 = this.summaryState;
        if (r2 == r1) goto L13;
        UiState r3 = UiState.SHOW;
        if (r0 != r3) goto L10;
        if (r2 != r3) goto L10;
        avatarTopMargin(16);
        return;
    L10:
        avatarTopMargin(12);
        return;
    L13:
        return;
    }

    private final int adjustCheckboxTopMargin() {
        UiState r0 = this.subTitleState;
        UiState r1 = UiState.NONE;
        if (r0 == r1) goto L13;
        UiState r2 = this.summaryState;
        if (r2 == r1) goto L13;
        UiState r3 = UiState.SHOW;
        if (r0 != r3) goto L11;
        if (r2 != r3) goto L11;
        return dp(TEXT_SIZE_14) + 16;
    L11:
        return dp(TEXT_SIZE_14) + 12;
    L13:
        return dp(CHECK_BOX_TOP_MARGIN);
    }

    private final View createBottomView() {
        FrameLayout r0 = new FrameLayout(getContext());
        r0.setId(2131363678);
        r0.setVisibility(8);
        r0.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        this.bottomFrameLayout = r0;
        return r0;
    }

    private final View getBottomView() {
        return (View) this.bottomView$delegate.getValue();
    }

    private final View getContentView() {
        return (View) this.contentView$delegate.getValue();
    }

    private final int getSubTitleHeightWithZoom() {
        return (int) a08.b.a(dpF(22.0f), getContext());
    }

    private final int getTitleHeightWithZoom() {
        return (int) a08.b.a(dpF(24.0f), getContext());
    }

    private final void resetMiniAvatarStyle() {
        ImageView r0 = this.miniAvatarView;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("miniAvatarView");
        r0 = null;
    L5:
        r0.setBackground(null);
        ImageView r1 = this.miniAvatarView;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("miniAvatarView");
        r1 = null;
    L8:
        r1.setPadding(0, 0, 0, 0);
        AppCompatImageView r2 = this.miniAvatarView;
        if (r2 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("miniAvatarView");
        r2 = null;
    L11:
        r2.setImageDrawable(null);
        setMiniAvatarSize(22.0f);
    }

    public final void adjustAlign() {
        ViewGroup r0 = this.rightItemWrapper;
        FrameLayout r2 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("rightItemWrapper");
        r0 = null;
    L5:
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        if ((r1 instanceof RelativeLayout.LayoutParams) == false) goto L8;
        RelativeLayout.LayoutParams r3 = (RelativeLayout.LayoutParams) r1;
    L10:
        if (r3 == null) goto L15;
        r3.topMargin = 0;
        r3.removeRule(15);
        ViewGroup r4 = this.rightItemWrapper;
        if (r4 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("rightItemWrapper");
        r4 = null;
    L14:
        r4.setLayoutParams(r3);
    L15:
        FrameLayout r5 = this.decoratedAvatarView;
        if (r5 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("decoratedAvatarView");
        r5 = null;
    L18:
        ViewGroup.LayoutParams r6 = r5.getLayoutParams();
        if ((r6 instanceof RelativeLayout.LayoutParams) == false) goto L21;
        RelativeLayout.LayoutParams r7 = (RelativeLayout.LayoutParams) r6;
    L22:
        if (r7 == null) goto L29;
        r7.removeRule(15);
        FrameLayout r8 = this.decoratedAvatarView;
        if (r8 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("decoratedAvatarView");
    L27:
        r2.setLayoutParams(r7);
        return;
    L26:
        r2 = r8;
        goto L27
    L29:
        return;
    L21:
        r7 = null;
        goto L22
    L8:
        r3 = null;
        goto L10
    }

    public View createContentView() {
        RelativeLayout r1 = new RelativeLayout(getContext());
        r1.setId(2131363691);
        r1.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        r1.setMinimumHeight(dp(AVATAR_ITEM_HEIGHT));
        r1.setPadding(0, 0, dp(16.0f), 0);
        View r5 = new UDCheckBox(getContext());
        r5.setId(2131363679);
        r5.setVisibility(8);
        r5.setPadding(0, 0, 0, 0);
        r5.setSize(UDCheckBox.CheckBoxSize.SMALL_SIZE);
        RelativeLayout.LayoutParams r9 = new RelativeLayout.LayoutParams(dp(CHECKBOX_LAYOUT_SIZE), dp(CHECKBOX_LAYOUT_SIZE));
        r9.setMarginStart(dp(16.0f));
        r9.addRule(15);
        setGravity(16);
        r5.setLayoutParams(r9);
        r1.addView(r5);
        r5.setClickable(false);
        this.checkBox = r5;
        DecoratedAvatar r6 = new DecoratedAvatar(getContext(), null, 6, 0);
        r6.setId(2131363680);
        RelativeLayout.LayoutParams r14 = new RelativeLayout.LayoutParams(dp(48.0f), dp(48.0f));
        r14.addRule(17, 2131363679);
        r14.addRule(1, 2131363679);
        r14.addRule(15);
        r14.topMargin = dp(12.0f);
        r14.setMarginStart(dp(16.0f));
        r14.setMarginEnd(dp(12.0f));
        r6.setLayoutParams(r14);
        r1.addView(r6);
        this.decoratedAvatarView = r6;
        LarkAvatarView r2 = new LarkAvatarView(getContext());
        r2.setId(2131363676);
        r2.setScaleType(ImageView.ScaleType.CENTER_CROP);
        DecoratedAvatar r7 = this.decoratedAvatarView;
        if (r7 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("decoratedAvatarView");
        r7 = null;
    L5:
        r7.a(r2);
        setAvatarView(r2);
        LarkAvatarView r3 = new LarkAvatarView(getContext());
        r3.setId(2131363690);
        RelativeLayout.LayoutParams r8 = new RelativeLayout.LayoutParams(dp(22.0f), dp(22.0f));
        r8.addRule(19, 2131363680);
        r3.setLayoutParams(r8);
        r3.setScaleType(ImageView.ScaleType.CENTER_CROP);
        r3.setVisibility(8);
        if (yz7.a.b == true) goto L8;
    L10:
        boolean r10 = false;
    L12:
        if (r10 == false) goto L14;
        ViewGroup.LayoutParams r11 = r3.getLayoutParams();
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        ((RelativeLayout.LayoutParams) r11).addRule(15);
        r3.setTranslationY(dpF(13.0f));
    L15:
        r1.addView(r3);
        this.miniAvatarView = r3;
        FrameLayout r4 = new FrameLayout(getContext());
        r4.setId(2131363689);
        RelativeLayout.LayoutParams r13 = new RelativeLayout.LayoutParams(-1, -2);
        r13.addRule(17, 2131363680);
        r13.addRule(1, 2131363680);
        r13.addRule(0, 2131363692);
        r13.addRule(16, 2131363692);
        r13.addRule(15);
        r4.setLayoutParams(r13);
        r1.addView(r4);
        this.contentLayout = r4;
        LinearLayout r15 = new LinearLayout(getContext());
        r15.setOrientation(0);
        r15.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        r4.addView(r15);
        LinearLayout r12 = new LinearLayout(getContext());
        this.avatarItemSubtitleContainer = r12;
        r12.setId(2131363696);
        r12.setOrientation(1);
        r12.setGravity(16);
        LinearLayout.LayoutParams r16 = new LinearLayout.LayoutParams(0, -2, 1.0f);
        r16.topMargin = dp(12.0f);
        r16.bottomMargin = dp(12.0f);
        r12.setLayoutParams(r16);
        r15.addView(r12);
        LinearLayout r17 = new LinearLayout(getContext());
        r17.setId(2131363692);
        r17.setOrientation(0);
        RelativeLayout.LayoutParams r18 = new RelativeLayout.LayoutParams(-2, -2);
        r18.addRule(6, 2131363680);
        r18.addRule(21);
        r18.addRule(15);
        r18.topMargin = dp(12.0f);
        r18.setMarginStart(dp(12.0f));
        this.rightItemWrapper = r17;
        r17.setVisibility(8);
        r1.addView(r17, r18);
        FrameLayout r19 = new FrameLayout(getContext());
        LinearLayout.LayoutParams r110 = new LinearLayout.LayoutParams(-2, -2);
        this.rightViewHolder = r19;
        r17.addView(r19, r110);
        RelativeLayout r20 = new RelativeLayout(getContext());
        r20.setId(2131363701);
        r20.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        r12.addView(r20);
        PriorityLayout r21 = new PriorityLayout(getContext(), null, 6, 0);
        r21.setId(2131363694);
        RelativeLayout.LayoutParams r111 = new RelativeLayout.LayoutParams(-1, getTitleHeightWithZoom());
        r111.addRule(16, 2131363675);
        r111.addRule(0, 2131363675);
        r111.addRule(9);
        r111.addRule(15);
        r21.setLayoutParams(r111);
        r20.addView(r21);
        TextView r112 = new TextView(getContext());
        r112.setId(2131363675);
        r112.setTextSize(2, 12.0f);
        r112.setTextColor(getContext().getResources().getColor(2131103456));
        r112.setGravity(16);
        r112.setVisibility(8);
        RelativeLayout.LayoutParams r113 = new RelativeLayout.LayoutParams(-2, getTitleHeightWithZoom());
        r113.addRule(16, 2131363682);
        r113.addRule(15);
        r113.setMarginStart(dp(12.0f));
        r113.setMarginStart(dp(8.0f));
        r113.addRule(11);
        r20.addView(r112, r113);
        this.assignTimeView = r112;
        ImageView r114 = new ImageView(getContext());
        r114.setId(2131363682);
        RelativeLayout.LayoutParams r115 = new RelativeLayout.LayoutParams(-2, -2);
        r115.addRule(11);
        r115.addRule(15);
        r115.setMarginStart(dp(12.0f));
        this.rightTagWrapper = r114;
        r20.addView(r114, r115);
        SpareLayout r22 = new SpareLayout(getContext());
        if (this.fgUtils.enableFirstMinSize() == false) goto L18;
        r22.setFirstViewMinWidth(zz7.b.g(getContext(), 86));
    L18:
        PriorityLayout.LayoutParams r23 = new PriorityLayout.LayoutParams(-2, -2);
        ((FrameLayout.LayoutParams) r23).gravity = 16;
        r23.a = 10;
        r22.setLayoutParams(r23);
        r21.addView(r22);
        UserStatusLinearLayout r24 = new UserStatusLinearLayout(getContext());
        PriorityLayout.LayoutParams r116 = new PriorityLayout.LayoutParams(-1, getTitleHeightWithZoom());
        ((FrameLayout.LayoutParams) r116).gravity = 16;
        r116.a = 1;
        r116.setMarginStart(dp(8.0f));
        r24.setLayoutParams(r116);
        r24.setMaxLines(1);
        r24.setVisibility(8);
        r21.addView(r24);
        this.userStatus = r24;
        EllipsizedEmojiconTextView r25 = new EllipsizedEmojiconTextView(getContext());
        r25.setId(2131363700);
        r25.setLayoutParams(new LinearLayout.LayoutParams(-2, getTitleHeightWithZoom()));
        r25.setEllipsize(TextUtils.TruncateAt.END);
        r25.setIncludeFontPadding(false);
        r25.setGravity(16);
        r25.setMaxLines(1);
        r25.setSingleLine(true);
        r25.setTextSize(2, TEXT_SIZE_17);
        r25.setTextColor(getContext().getResources().getColor(2131106622));
        r22.addView(r25);
        this.titleView = r25;
        ImageView r26 = new ImageView(getContext());
        FrameLayout.LayoutParams r117 = new FrameLayout.LayoutParams(-2, -2);
        r117.leftMargin = dp(8.0f);
        r117.gravity = 16;
        r26.setLayoutParams(r117);
        r26.setVisibility(8);
        r22.addView(r26);
        this.personalStatusView = r26;
        EllipsizedEmojiconTextView r27 = new EllipsizedEmojiconTextView(getContext());
        r27.setId(2131363702);
        r27.setLayoutParams(new LinearLayout.LayoutParams(-2, getTitleHeightWithZoom()));
        r27.setGravity(16);
        r27.setMaxLines(1);
        r27.setSingleLine(true);
        r27.setTextSize(2, TEXT_SIZE_17);
        r27.setTextColor(getContext().getResources().getColor(2131106620));
        r22.addView(r27);
        this.titleTailView = r27;
        TextView r28 = new TextView(getContext());
        r28.setId(2131363686);
        r28.setTextSize(2, 12.0f);
        r28.setTextColor(getContext().getResources().getColor(2131103456));
        r28.setCompoundDrawablesWithIntrinsicBounds(getContext().getResources().getDrawable(2131238000), null, null, null);
        r28.setCompoundDrawablePadding(dp(4.0f));
        r28.setIncludeFontPadding(false);
        r28.setGravity(16);
        r28.setVisibility(8);
        LinearLayout.LayoutParams r29 = new LinearLayout.LayoutParams(-2, -1);
        r29.setMarginStart(dp(8.0f));
        r22.addView(r28, r29);
        this.localTimeView = r28;
        EllipsizedEmojiconTextView r30 = new EllipsizedEmojiconTextView(getContext());
        r30.setId(2131363695);
        r30.setLayoutParams(new LinearLayout.LayoutParams(-2, getSubTitleHeightWithZoom()));
        ViewGroup.LayoutParams r31 = r30.getLayoutParams();
        Intrinsics.checkNotNull(r31, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        ((LinearLayout.LayoutParams) r31).topMargin = dp(4.0f);
        r30.setIncludeFontPadding(false);
        r30.setGravity(16);
        if (this.fgUtils.enableSearchDepartment() == false) goto L21;
        r30.j = TextUtils.TruncateAt.START;
    L22:
        r30.setMaxLines(1);
        r30.setSingleLine(true);
        r30.setTextSize(2, TEXT_SIZE_14);
        r30.setTextColor(getContext().getResources().getColor(2131106620));
        r30.setVisibility(8);
        r12.addView(r30);
        this.subTitleView = r30;
        EllipsizedEmojiconTextView r32 = new EllipsizedEmojiconTextView(getContext());
        r32.setId(2131363698);
        r32.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        ViewGroup.LayoutParams r33 = r32.getLayoutParams();
        Intrinsics.checkNotNull(r33, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        ((LinearLayout.LayoutParams) r33).topMargin = dp(4.0f);
        r32.setIncludeFontPadding(false);
        r32.setGravity(16);
        r32.setEllipsize(TextUtils.TruncateAt.END);
        r32.setMaxLines(1);
        r32.setSingleLine(true);
        r32.setTextSize(2, TEXT_SIZE_14);
        r32.setTextColor(getContext().getResources().getColor(2131106620));
        r32.setVisibility(8);
        r12.addView(r32);
        setSummaryView(r32);
        ExtraInfoView r34 = new ExtraInfoView(getContext());
        r34.setId(2131363684);
        r34.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        ViewGroup.LayoutParams r35 = r34.getLayoutParams();
        Intrinsics.checkNotNull(r35, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        ((LinearLayout.LayoutParams) r35).topMargin = dp(4.0f);
        r34.setVisibility(8);
        r12.addView(r34);
        this.extraInfoView = r34;
        LinearLayout r36 = new LinearLayout(getContext());
        this.dslRenderContainer = r36;
        r36.setVisibility(8);
        LinearLayout r37 = this.dslRenderContainer;
        if (r37 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("dslRenderContainer");
        r37 = null;
    L25:
        r37.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        View r38 = this.dslRenderContainer;
        if (r38 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("dslRenderContainer");
        View r118 = null;
    L29:
        r12.addView(r118);
        View r39 = new View(getContext());
        r39.setId(2131363681);
        RelativeLayout.LayoutParams r40 = new RelativeLayout.LayoutParams(-1, dp(DIVIDER_HEIGHT));
        r40.addRule(12);
        r40.addRule(18, 2131363689);
        r40.addRule(7, 2131363689);
        r39.setLayoutParams(r40);
        r39.setBackgroundColor(getContext().getResources().getColor(2131103353));
        r1.addView(r39);
        this.divider = r39;
        registerBinder();
        return r1;
    L28:
        r118 = r38;
        goto L29
    L21:
        r30.setEllipsize(TextUtils.TruncateAt.END);
        r30.j = TextUtils.TruncateAt.END;
        goto L22
    L14:
        ViewGroup.LayoutParams r41 = r3.getLayoutParams();
        Intrinsics.checkNotNull(r41, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        ((RelativeLayout.LayoutParams) r41).addRule(8, 2131363680);
        goto L15
    L8:
        if (yz7.a.a == false) goto L10;
        r10 = true;
        goto L12
    }

    public final LarkAvatarView getAvatarView() {
        LarkAvatarView r0 = this.avatarView;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("avatarView");
        return null;
    }

    public final TextView getSummaryView() {
        TextView r0 = this.summaryView;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("summaryView");
        return null;
    }

    public final void justCheckBoxToCenter() {
        View r0 = this.checkBox;
        RelativeLayout.LayoutParams r2 = null;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("checkBox");
        r0 = null;
    L6:
        if (r0.getLayoutParams() == null) goto L16;
        View r1 = this.checkBox;
        if (r1 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("checkBox");
        r1 = null;
    L10:
        ViewGroup.LayoutParams r3 = r1.getLayoutParams();
        if ((r3 instanceof RelativeLayout.LayoutParams) == false) goto L13;
        r2 = (RelativeLayout.LayoutParams) r3;
    L13:
        if (r2 == null) goto L17;
        r2.addRule(15);
        setGravity(16);
        return;
    L17:
        return;
    }

    public final void removeRightView() {
        FrameLayout r0 = this.rightViewHolder;
        ViewGroup r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("rightViewHolder");
        r0 = null;
    L5:
        r0.removeAllViews();
        ViewGroup r2 = this.rightItemWrapper;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("rightItemWrapper");
    L9:
        r1.setVisibility(8);
        return;
    L8:
        r1 = r2;
        goto L9
    }

    public final void resetAllViews() {
        a r0 = this.compositeComponentDelegate;
        Iterator r1 = ((HashMap) r0.c).entrySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        Map.Entry r2 = (Map.Entry) r1.next();
        ((b08.b) r2.getKey()).unbind((View) r2.getValue());
        goto L4
    L6:
        ((HashMap) r0.c).clear();
        removeRightView();
        unBindAvatar(getClass());
        unBindMiniAvatar(getClass());
        unBindMedal();
        TextView r3 = this.subTitleView;
        FrameLayout r4 = null;
        if (r3 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("subTitleView");
        r3 = null;
    L9:
        r3.setVisibility(0);
        getSummaryView().setVisibility(8);
        ExtraInfoView r5 = this.extraInfoView;
        if (r5 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("extraInfoView");
        r5 = null;
    L12:
        r5.setVisibility(8);
        LinearLayout r6 = this.dslRenderContainer;
        if (r6 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("dslRenderContainer");
        r6 = null;
    L15:
        r6.removeAllViews();
        LinearLayout r7 = this.dslRenderContainer;
        if (r7 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("dslRenderContainer");
        r7 = null;
    L18:
        r7.setVisibility(8);
        FrameLayout r8 = this.decoratedAvatarView;
        if (r8 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("decoratedAvatarView");
        r8 = null;
    L21:
        r8.setVisibility(0);
        getAvatarView().setVisibility(0);
        FrameLayout r9 = this.contentLayout;
        if (r9 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("contentLayout");
        r9 = null;
    L24:
        ViewGroup.LayoutParams r10 = r9.getLayoutParams();
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        ((RelativeLayout.LayoutParams) r10).setMarginStart(0);
        FrameLayout r11 = this.bottomFrameLayout;
        if (r11 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("bottomFrameLayout");
        r11 = null;
    L27:
        r11.removeAllViews();
        FrameLayout r12 = this.bottomFrameLayout;
        if (r12 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("bottomFrameLayout");
    L31:
        r4.setVisibility(8);
        return;
    L30:
        r4 = r12;
        goto L31
    }

    public final AvatarItemView resetTags() {
        AppCompatTextView r0 = this.titleTailView;
        ImageView r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("titleTailView");
        r0 = null;
    L5:
        r0.setCompoundDrawables(null, null, null, null);
        ImageView r2 = this.rightTagWrapper;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("rightTagWrapper");
        r2 = null;
    L8:
        r2.setBackground(null);
        ImageView r3 = this.rightTagWrapper;
        if (r3 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("rightTagWrapper");
    L12:
        r1.setVisibility(8);
        return this;
    L11:
        r1 = r3;
        goto L12
    }

    public final float subTitleTextSize() {
        TextView r0 = this.subTitleView;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("subTitleView");
        r0 = null;
    L6:
        return r0.getTextSize();
    }

    public final void unBindMedal() {
        DecoratedAvatar r0 = this.decoratedAvatarView;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("decoratedAvatarView");
        r0 = null;
    L5:
        ImageView r1 = r0.a;
        if (r1 == null) goto L9;
        r1.setImageDrawable(null);
        return;
    }

    public final void unbindPersonalStatus() {
        a r0 = this.compositeComponentDelegate;
        Class<?> r1 = getClass();
        ImageView r2 = this.personalStatusView;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("personalStatusView");
        r2 = null;
    L5:
        r0.getClass();
        b08.b r3 = r0.b(r1, r2.getClass(), e.class);
        if (r3 == null) goto L9;
        r3.unbind(r2);
        return;
    }

    private final void layoutSelf() {
        if (getParent() == null) goto L11;
        int r0 = this.mOldWidthMeasureSpec;
        if (r0 == Integer.MIN_VALUE) goto L12;
        int r2 = this.mOldHeightMeasureSpec;
        if (r2 == Integer.MIN_VALUE) goto L13;
        measure(r0, r2);
        layout(getLeft(), getTop(), getRight(), getBottom());
        invalidate();
        return;
    L13:
        return;
    L12:
        return;
    }

    public void registerBinder() {
        PickerBaseModuleDependency.getDependency().registerModelBinder(this.compositeComponentDelegate);
        UDCheckBox r1 = this.checkBox;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("checkBox");
        r1 = null;
    L5:
        registerModelBinder(b.class, r1.getClass(), CheckBoxBinder.Companion.getInstance());
    }

    public final void userTeamBadge() {
        resetMiniAvatarStyle();
        setMiniAvatarSize(24.0f);
        int r0 = dp(6.0f);
        ImageView r1 = this.miniAvatarView;
        AppCompatImageView r2 = null;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("miniAvatarView");
        r1 = null;
    L5:
        r1.setVisibility(0);
        AppCompatImageView r3 = this.miniAvatarView;
        if (r3 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("miniAvatarView");
        r3 = null;
    L8:
        r3.setBackgroundResource(2131247268);
        ImageView r4 = this.miniAvatarView;
        if (r4 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("miniAvatarView");
        r4 = null;
    L11:
        r4.setPadding(r0, r0, r0, r0);
        AppCompatImageView r5 = this.miniAvatarView;
        if (r5 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("miniAvatarView");
    L15:
        r2.setImageDrawable(UDIconUtils.getIconDrawable(getContext(), 2131254840, d.c(getContext(), 2131106521)));
        return;
    L14:
        r2 = r5;
        goto L15
    }

    public final a getCompositeComponentDelegate() {
        return this.compositeComponentDelegate;
    }

    public static final /* synthetic */ View access$createBottomView(AvatarItemView r0) {
        return r0.createBottomView();
    }

    public static final /* synthetic */ LinearLayout access$getAvatarItemSubtitleContainer$p(AvatarItemView r0) {
        return r0.avatarItemSubtitleContainer;
    }

    public static final /* synthetic */ ViewGroup access$getRightItemWrapper$p(AvatarItemView r0) {
        return r0.rightItemWrapper;
    }

    public static final /* synthetic */ TextView access$getSubTitleView$p(AvatarItemView r0) {
        return r0.subTitleView;
    }

    private final void avatarMarginStart(int r3) {
        FrameLayout r0 = this.decoratedAvatarView;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("decoratedAvatarView");
        r0 = null;
    L5:
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        if ((r1 instanceof RelativeLayout.LayoutParams) == false) goto L9;
        ((RelativeLayout.LayoutParams) r1).setMarginStart(dp(r3));
        return;
    }

    private final void setMiniAvatarSize(float r5) {
        ImageView r0 = this.miniAvatarView;
        ImageView r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("miniAvatarView");
        r0 = null;
    L5:
        ViewGroup.LayoutParams r2 = r0.getLayoutParams();
        if (r2 == null) goto L17;
        int r6 = dp(r5);
        if (r2.width == r6) goto L10;
    L11:
        r2.width = r6;
        r2.height = r6;
        ImageView r7 = this.miniAvatarView;
        if (r7 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("miniAvatarView");
    L15:
        r1.setLayoutParams(r2);
        return;
    L14:
        r1 = r7;
        goto L15
    L10:
        if (r2.height != r6) goto L11;
        return;
    }

    public final void addBottomView(View r4) {
        Intrinsics.checkNotNullParameter(r4, "bottomView");
        FrameLayout r0 = this.bottomFrameLayout;
        FrameLayout r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("bottomFrameLayout");
        r0 = null;
    L5:
        r0.addView(r4);
        FrameLayout r5 = this.bottomFrameLayout;
        if (r5 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("bottomFrameLayout");
    L9:
        r1.setVisibility(0);
        return;
    L8:
        r1 = r5;
        goto L9
    }

    public final void addViewToRender(View r4) {
        Intrinsics.checkNotNullParameter(r4, "renderView");
        LinearLayout r0 = this.dslRenderContainer;
        TextView r2 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("dslRenderContainer");
        r0 = null;
    L5:
        r0.addView(r4);
        LinearLayout r5 = this.dslRenderContainer;
        if (r5 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("dslRenderContainer");
        r5 = null;
    L8:
        r5.setVisibility(0);
        TextView r6 = this.subTitleView;
        if (r6 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("subTitleView");
    L12:
        r2.setVisibility(8);
        getSummaryView().setVisibility(8);
        return;
    L11:
        r2 = r6;
        goto L12
    }

    public final AvatarItemView applyStyle(int r17) {
        TypedArray r1 = getContext().obtainStyledAttributes(r17, new int[]{2130968897, 2130969182, 2130974117, 2130974118, 2130974119, 2130974331, 2130974333, 2130974338, 2130974339, 2130974594, 2130974596});
        int r2 = r1.getDimensionPixelSize(1, dp(CHECKBOX_LAYOUT_SIZE));
        int r4 = r1.getDimensionPixelSize(0, dp(48.0f));
        int r6 = r1.getDimensionPixelSize(9, dp(24.0f));
        int r7 = r1.getDimensionPixelSize(5, dp(22.0f));
        int r8 = r1.getDimensionPixelSize(7, -2);
        float r9 = r1.getDimension(10, dpF(TEXT_SIZE_17));
        float r11 = r1.getDimension(6, dpF(TEXT_SIZE_14));
        float r10 = r1.getDimension(8, dpF(TEXT_SIZE_14));
        int r13 = (int) r1.getDimension(2, dpF(16.0f));
        int r12 = (int) r1.getDimension(3, dpF(16.0f));
        int r14 = (int) r1.getDimension(4, dpF(12.0f));
        r1.recycle();
        View r3 = this.checkBox;
        TextView r15 = null;
        if (r3 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("checkBox");
        r3 = null;
    L5:
        ViewGroup.LayoutParams r5 = r3.getLayoutParams();
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams r16 = (RelativeLayout.LayoutParams) r5;
        r16.height = r2;
        r16.width = r2;
        r16.setMarginStart(r13);
        FrameLayout r18 = this.decoratedAvatarView;
        if (r18 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("decoratedAvatarView");
        r18 = null;
    L8:
        ViewGroup.LayoutParams r19 = r18.getLayoutParams();
        Intrinsics.checkNotNull(r19, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams r20 = (RelativeLayout.LayoutParams) r19;
        r20.width = r4;
        r20.height = r4;
        r20.setMarginStart(r12);
        r20.setMarginEnd(r14);
        TextView r21 = this.titleView;
        if (r21 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("titleView");
        r21 = null;
    L11:
        float r22 = r6;
        r21.getLayoutParams().height = (int) a08.b.a(r22, r21.getContext());
        r21.setTextSize(0, a08.b.a(r9, r21.getContext()));
        TextView r23 = this.titleTailView;
        if (r23 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("titleTailView");
        r23 = null;
    L14:
        r23.getLayoutParams().height = (int) a08.b.a(r22, r23.getContext());
        Context r24 = r23.getContext();
        Intrinsics.checkNotNullParameter(r24, "context");
        if (yz7.a.b == true) goto L17;
    L19:
        boolean r25 = false;
    L20:
        if (r25 == false) goto L61;
        ZoomLevel4 r26 = zz7.b.e();
        ZoomLevel4 r27 = ZoomLevel4.NORMAL;
        if (r26 == r27) goto L61;
        Intrinsics.checkNotNullParameter(r24, "context");
        Resources r28 = r24.getResources();
        int r29 = MathKt.roundToInt((r9 / WindowDisplayMetricsOverride.apply(r28, r28.getDisplayMetrics()).density) + DIVIDER_HEIGHT);
        if (r26 != r27) goto L28;
        float r30 = ZoomLevel6.NORMAL.getMultiplier();
    L60:
        r9 = r9 * r30;
        goto L61
    L28:
        SortedMap r31 = a08.b.a;
        a08.b.a r32 = (a08.b.a) r31.get(Integer.valueOf(r29));
        if (r32 == null) goto L31;
        int r33 = r32.a(r26);
    L59:
        r30 = r33 / r29;
        goto L60
    L31:
        Iterator r34 = r31.values().iterator();
        Object r35 = null;
    L33:
        if (r34.hasNext() == false) goto L40;
        Object r110 = r34.next();
        if (((a08.b.a) r110).b >= r29) goto L37;
        boolean r111 = true;
    L38:
        if (r111 == false) goto L33;
        r35 = r110;
        goto L33
    L37:
        r111 = false;
        goto L38
    L40:
        a08.b.a r36 = (a08.b.a) r35;
        Iterator r37 = a08.b.a.values().iterator();
    L42:
        if (r37.hasNext() == false) goto L49;
        Object r112 = r37.next();
        if (((a08.b.a) r112).b <= r29) goto L46;
        boolean r113 = true;
    L47:
        if (r113 == false) goto L42;
    L50:
        a08.b.a r114 = (a08.b.a) r112;
        if (r36 == null) goto L54;
        if (r114 == null) goto L54;
        r33 = MathKt.roundToInt((((r36.a(r26) / r36.b) + (r114.a(r26) / r114.b)) / 2.0f) * r29);
    L54:
        if (r36 == null) goto L56;
        r33 = MathKt.roundToInt((r36.a(r26) / r36.b) * r29);
        goto L59
    L56:
        if (r114 == null) goto L58;
        r33 = MathKt.roundToInt((r114.a(r26) / r114.b) * r29);
        goto L59
    L58:
        r33 = r29;
        goto L59
    L46:
        r113 = false;
        goto L47
    L49:
        r112 = null;
    L61:
        r23.setTextSize(0, r9);
        TextView r38 = this.subTitleView;
        if (r38 != null) goto L64;
        Intrinsics.throwUninitializedPropertyAccessException("subTitleView");
    L65:
        r15.getLayoutParams().height = (int) a08.b.a(r7, r15.getContext());
        r15.setTextSize(0, a08.b.a(r11, r15.getContext()));
        TextView r39 = getSummaryView();
        r39.getLayoutParams().height = (int) a08.b.a(r8, r39.getContext());
        r39.setTextSize(0, a08.b.a(r10, r39.getContext()));
        return this;
    L64:
        r15 = r38;
        goto L65
    L17:
        if (yz7.a.a == false) goto L19;
        r25 = true;
        goto L20
    }

    public final void assignTime(w3c.a r4) {
        Intrinsics.checkNotNullParameter(r4, "time");
        a r0 = this.compositeComponentDelegate;
        Class<?> r1 = getClass();
        TextView r2 = this.assignTimeView;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("assignTimeView");
        r2 = null;
    L5:
        r0.a(r1, r2, r4);
    }

    public final void avatar(AvatarModel r2) {
        Intrinsics.checkNotNullParameter(r2, "avatarModel");
        getAvatarView().j(r2);
    }

    public final void avatarShape(boolean r2) {
        getAvatarView().setOval(r2);
    }

    public final void avatarSizeAdjust(float r5) {
        FrameLayout r0 = this.decoratedAvatarView;
        FrameLayout r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("decoratedAvatarView");
        r0 = null;
    L5:
        r0.getLayoutParams().width = dp(r5);
        FrameLayout r2 = this.decoratedAvatarView;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("decoratedAvatarView");
    L9:
        r1.getLayoutParams().height = dp(r5);
        return;
    L8:
        r1 = r2;
        goto L9
    }

    public final void avatarStartMargin(int r3) {
        FrameLayout r0 = this.decoratedAvatarView;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("decoratedAvatarView");
        r0 = null;
    L5:
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        if ((r1 instanceof RelativeLayout.LayoutParams) == false) goto L9;
        ((RelativeLayout.LayoutParams) r1).setMarginStart(dp(r3));
        return;
    }

    public final void avatarTopMargin(int r3) {
        FrameLayout r0 = this.decoratedAvatarView;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("decoratedAvatarView");
        r0 = null;
    L5:
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        if ((r1 instanceof RelativeLayout.LayoutParams) == false) goto L9;
        int r4 = dp(r3);
        ((RelativeLayout.LayoutParams) r1).topMargin = r4;
        return;
    }

    public final void badge(vz7.b r4) {
        Intrinsics.checkNotNullParameter(r4, "badgeModel");
        LarkAvatarView r0 = getAvatarView();
        r0.a.a(r0.getClass(), r0, r4);
    }

    public final void bindAvatarWithResourceID(int r4) {
        UIUtils.setViewVisibility(getAvatarView(), 0);
        View r0 = this.decoratedAvatarView;
        FrameLayout r2 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("decoratedAvatarView");
        r0 = null;
    L5:
        UIUtils.setViewVisibility(r0, 0);
        FrameLayout r1 = this.contentLayout;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("contentLayout");
    L9:
        ViewGroup.LayoutParams r3 = r2.getLayoutParams();
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        ((RelativeLayout.LayoutParams) r3).setMarginStart(0);
        getAvatarView().setBackgroundResource(r4);
        return;
    L8:
        r2 = r1;
        goto L9
    }

    public final void checkBoxStartMargin(int r4) {
        View r0 = this.checkBox;
        RelativeLayout.LayoutParams r2 = null;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("checkBox");
        r0 = null;
    L6:
        if (r0.getLayoutParams() == null) goto L16;
        View r1 = this.checkBox;
        if (r1 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("checkBox");
        r1 = null;
    L10:
        ViewGroup.LayoutParams r3 = r1.getLayoutParams();
        if ((r3 instanceof RelativeLayout.LayoutParams) == false) goto L13;
        r2 = (RelativeLayout.LayoutParams) r3;
    L13:
        if (r2 == null) goto L17;
        r2.setMarginStart(dp(r4));
        return;
    L17:
        return;
    }

    public final void checkState(b r4) {
        Intrinsics.checkNotNullParameter(r4, "checkBoxModel");
        if (r4.c == false) goto L5;
        avatarMarginStart(12);
    L6:
        this.checkBoxModel = r4;
        a r0 = this.compositeComponentDelegate;
        Class<?> r1 = getClass();
        View r2 = this.checkBox;
        if (r2 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("checkBox");
        r2 = null;
    L9:
        r0.a(r1, r2, r4);
        return;
    L5:
        avatarMarginStart(16);
        goto L6
    }

    public final int dp(float r1) {
        return (int) dpF(r1);
    }

    public final float dpF(float r2) {
        return j08.b.a(getContext(), r2);
    }

    public final void localTime(w3c.d r4) {
        Intrinsics.checkNotNullParameter(r4, "localTime");
        a r0 = this.compositeComponentDelegate;
        Class<?> r1 = getClass();
        TextView r2 = this.localTimeView;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("localTimeView");
        r2 = null;
    L5:
        r0.a(r1, r2, r4);
    }

    public final void medal(AvatarMedal r2) {
        Intrinsics.checkNotNullParameter(r2, "medalModel");
        String r0 = r2.getKey();
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        return;
    L11:
        if (r2.getShowSwitch() == false) goto L18;
        DecoratedAvatar r3 = this.decoratedAvatarView;
        if (r3 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("decoratedAvatarView");
        r3 = null;
    L15:
        r3.b(r2.getKey());
        return;
    L18:
        return;
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    public final void miniAvatar(AvatarModel r5) {
        Intrinsics.checkNotNullParameter(r5, "avatarModel");
        resetMiniAvatarStyle();
        ImageView r0 = this.miniAvatarView;
        LarkAvatarView r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("miniAvatarView");
        r0 = null;
    L5:
        r0.setVisibility(0);
        LarkAvatarView r2 = this.miniAvatarView;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("miniAvatarView");
    L9:
        r1.j(r5);
        return;
    L8:
        r1 = r2;
        goto L9
    }

    public final void miniIcon(wz7.d r2) {
        getAvatarView().l(r2);
    }

    public final void personalStatus(e r4) {
        Intrinsics.checkNotNullParameter(r4, "status");
        a r0 = this.compositeComponentDelegate;
        Class<?> r1 = getClass();
        ImageView r2 = this.personalStatusView;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("personalStatusView");
        r2 = null;
    L5:
        r0.a(r1, r2, r4);
    }

    public final void setAvatarView(LarkAvatarView r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.avatarView = r2;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener r2) {
        super.setOnClickListener(r2);
        View r3 = this.checkBox;
        if (r3 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("checkBox");
        r3 = null;
    L5:
        r3.setClickable(false);
    }

    public final void setSubTitleLines(int r6) {
        TextView r0 = this.subTitleView;
        RelativeLayout.LayoutParams r2 = null;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("subTitleView");
        r0 = null;
    L6:
        if ((r0 instanceof EllipsizedEmojiconTextView) == false) goto L41;
        TextView r1 = this.subTitleView;
        if (r1 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("subTitleView");
        r1 = null;
    L11:
        if (r1.getMaxLines() == r6) goto L42;
        Log.i(TAG, "set department max line");
        TextView r3 = this.subTitleView;
        if (r3 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("subTitleView");
        r3 = null;
    L15:
        r3.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        TextView r4 = this.subTitleView;
        if (r4 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("subTitleView");
        r4 = null;
    L18:
        ((EllipsizedEmojiconTextView) r4).setShouldEllipsized(false);
        TextView r5 = this.subTitleView;
        if (r5 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("subTitleView");
        r5 = null;
    L21:
        r5.setSingleLine(false);
        TextView r7 = this.subTitleView;
        if (r7 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("subTitleView");
        r7 = null;
    L24:
        r7.setMaxLines(r6);
        TextView r8 = this.subTitleView;
        if (r8 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("subTitleView");
        r8 = null;
    L27:
        r8.setEllipsize(TextUtils.TruncateAt.END);
        View r9 = this.checkBox;
        if (r9 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("checkBox");
        r9 = null;
    L31:
        if (r9.getLayoutParams() == null) goto L43;
        View r10 = this.checkBox;
        if (r10 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("checkBox");
        r10 = null;
    L35:
        ViewGroup.LayoutParams r11 = r10.getLayoutParams();
        if ((r11 instanceof RelativeLayout.LayoutParams) == false) goto L38;
        r2 = (RelativeLayout.LayoutParams) r11;
    L38:
        if (r2 == null) goto L44;
        r2.removeRule(15);
        r2.addRule(6);
        setGravity(0);
        r2.topMargin = adjustCheckboxTopMargin();
        return;
    L44:
        return;
    L43:
        return;
    L42:
        return;
    }

    public final void setSubTitleMaxLines(int r6) {
        TextView r0 = this.subTitleView;
        TextView r1 = null;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("subTitleView");
        r0 = null;
    L6:
        if ((r0 instanceof EllipsizedEmojiconTextView) == false) goto L11;
        TextView r2 = this.subTitleView;
        if (r2 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("subTitleView");
        r2 = null;
    L10:
        ((EllipsizedEmojiconTextView) r2).setShouldEllipsized(false);
    L11:
        TextView r3 = this.subTitleView;
        if (r3 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("subTitleView");
        r3 = null;
    L14:
        TextView r4 = this.subTitleView;
        if (r4 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("subTitleView");
    L18:
        r3.setText(r1.getText());
        r3.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        r3.setSingleLine(false);
        r3.setMaxLines(r6);
        r3.setEllipsize(TextUtils.TruncateAt.END);
        r3.post(new AvatarItemView$setSubTitleMaxLines$1$1(this));
        return;
    L17:
        r1 = r4;
        goto L18
    }

    public final void setSubtitleTag(Drawable r6) {
        if (r6 == null) goto L12;
        TextView r0 = this.subTitleView;
        TextView r1 = null;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("subTitleView");
        r0 = null;
    L6:
        Drawable[] r2 = r0.getCompoundDrawables();
        TextView r3 = this.subTitleView;
        if (r3 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("subTitleView");
    L10:
        r1.setCompoundDrawables(r2[0], r2[1], r6, r2[3]);
        return;
    L9:
        r1 = r3;
        goto L10
    }

    public final void setSummaryView(TextView r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.summaryView = r2;
    }

    public final void setTag(LarkNameTag.c r2) {
        Intrinsics.checkNotNullParameter(r2, "builder");
        setTag(r2, 2);
    }

    public final void showDivider(boolean r3) {
        View r0 = null;
        if (r3 == false) goto L9;
        View r4 = this.divider;
        if (r4 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("divider");
    L8:
        r0.setVisibility(0);
        return;
    L7:
        r0 = r4;
        goto L8
    L9:
        View r5 = this.divider;
        if (r5 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("divider");
    L13:
        r0.setVisibility(8);
        return;
    L12:
        r0 = r5;
        goto L13
    }

    public final void subTitle(f r7) {
        Intrinsics.checkNotNullParameter(r7, "subtitleModel");
        Float r0 = r7.f;
        TextView r3 = null;
        if (r0 == null) goto L12;
        float r1 = r0.floatValue();
        TextView r4 = this.subTitleView;
        if (r4 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("subTitleView");
        r4 = null;
    L7:
        r4.setTextSize(0, a08.b.a(r1, getContext()));
        TextView r2 = this.subTitleView;
        if (r2 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("subTitleView");
        r2 = null;
    L10:
        r2.getLayoutParams().height = -2;
    L12:
        if (r7.d == null) goto L20;
        TextView r5 = this.subTitleView;
        if (r5 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("subTitleView");
        r5 = null;
    L16:
        r5.setVisibility(0);
        TextView r6 = this.subTitleView;
        if (r6 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("subTitleView");
        r6 = null;
    L19:
        r6.setText("");
        setSubtitleTag(r7.d);
    L27:
        TextView r8 = this.subTitleView;
        if (r8 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("subTitleView");
    L32:
        if (r3.getVisibility() != 0) goto L34;
        UiState r9 = UiState.SHOW;
    L35:
        this.subTitleState = r9;
        adjustAvatarTopMargin();
        return;
    L34:
        r9 = UiState.HIDE;
        goto L35
    L30:
        r3 = r8;
        goto L32
    L20:
        TextView r10 = this.subTitleView;
        if (r10 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("subTitleView");
        r10 = null;
    L23:
        r10.setCompoundDrawables(null, null, null, null);
        TextView r11 = this.subTitleView;
        if (r11 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("subTitleView");
        r11 = null;
    L26:
        bindTextViewWithModel(r11, r7);
        goto L27
    }

    public final void summary(f r2) {
        Intrinsics.checkNotNullParameter(r2, "summaryModel");
        bindTextViewWithModel(getSummaryView(), r2);
        if (getSummaryView().getVisibility() != 0) goto L5;
        UiState r3 = UiState.SHOW;
    L6:
        this.summaryState = r3;
        adjustAvatarTopMargin();
        return;
    L5:
        r3 = UiState.HIDE;
        goto L6
    }

    public final void title(g r4) {
        Intrinsics.checkNotNullParameter(r4, "titleModel");
        a r0 = this.compositeComponentDelegate;
        Class<?> r1 = getClass();
        TextView r2 = this.titleView;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("titleView");
        r2 = null;
    L5:
        r0.a(r1, r2, r4);
    }

    public final void titleBottomMargin(int r3) {
        TextView r0 = this.titleView;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("titleView");
        r0 = null;
    L5:
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        if ((r1 instanceof RelativeLayout.LayoutParams) == false) goto L9;
        int r4 = dp(r3);
        ((RelativeLayout.LayoutParams) r1).bottomMargin = r4;
        return;
    }

    public final void titleTail(h r4) {
        Intrinsics.checkNotNullParameter(r4, "tailModel");
        a r0 = this.compositeComponentDelegate;
        Class<?> r1 = getClass();
        View r2 = this.titleTailView;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("titleTailView");
        r2 = null;
    L5:
        r0.a(r1, r2, r4);
    }

    public final void unBindAvatar(Class<?> r2) {
        Intrinsics.checkNotNullParameter(r2, "modelClass");
        getAvatarView().m(r2);
    }

    public final void unBindMiniAvatar(Class<?> r5) {
        Intrinsics.checkNotNullParameter(r5, "modelClass");
        ImageView r0 = this.miniAvatarView;
        LarkAvatarView r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("miniAvatarView");
        r0 = null;
    L5:
        r0.setVisibility(8);
        LarkAvatarView r2 = this.miniAvatarView;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("miniAvatarView");
    L9:
        r1.m(r5);
        resetMiniAvatarStyle();
        return;
    L8:
        r1 = r2;
        goto L9
    }

    public final void updateCheckState(boolean r6) {
        b r0 = this.checkBoxModel;
        b r2 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("checkBoxModel");
        r0 = null;
    L5:
        r0.a = r6;
        a r7 = this.compositeComponentDelegate;
        Class<?> r1 = getClass();
        View r3 = this.checkBox;
        if (r3 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("checkBox");
        r3 = null;
    L8:
        b r4 = this.checkBoxModel;
        if (r4 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("checkBoxModel");
    L12:
        r7.a(r1, r3, r2);
        return;
    L11:
        r2 = r4;
        goto L12
    }

    public final void userStatus(j r4) {
        Intrinsics.checkNotNullParameter(r4, "model");
        a r0 = this.compositeComponentDelegate;
        Class<?> r1 = getClass();
        View r2 = this.userStatus;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("userStatus");
        r2 = null;
    L5:
        r0.a(r1, r2, r4);
    }

    public final int dp(int r1) {
        return d.a(r1);
    }

    private final void bindTextViewWithModel(TextView r5, f r6) {
        if (TextUtils.isEmpty(r6.a) == false) goto L5;
    L18:
        r5.setVisibility(8);
        return;
    L5:
        if (r6.b == false) goto L18;
        r5.setVisibility(0);
        r5.setEllipsize(r6.g);
        if ((r5 instanceof EllipsizedEmojiconTextView) == false) goto L11;
        TextUtils.TruncateAt r1 = r6.g;
        ((EllipsizedEmojiconTextView) r5).j = r1;
    L11:
        if (r6.e == false) goto L13;
        int r0 = getContext().getResources().getColor(2131105548);
    L14:
        r5.setTextColor(r0);
        if (CollectionUtils.isEmpty(r6.c) == false) goto L17;
        r5.setText(r6.a);
        return;
    L17:
        SpannableStringBuilder r2 = new SpannableStringBuilder(r6.a);
        PickerBaseModuleDependency.getDependency().addSearchHighLightedTag(r2, r5, r6.c, r5.getContext().getResources().getColor(2131105548));
        return;
    L13:
        r0 = getContext().getResources().getColor(2131106620);
        goto L14
    }

    private final int numOfCharsByHanziOne(TextView r3, int r4) {
        return (int) ((((double) (((((r4 - dp(16.0f)) - dp(48.0f)) - dp(12.0f)) - dp(16.0f)) / r3.getPaint().measureText(r3.getContext().getResources().getText(2131911792).toString()))) * 0.9d) * ((double) 2));
    }

    public final void bindAvatarWithUrl(String r12, String r13) {
        boolean r0 = true;
        if (r12 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        FrameLayout r6 = null;
        if (r2 == false) goto L27;
        UIUtils.setViewVisibility(getAvatarView(), 0);
        View r3 = this.decoratedAvatarView;
        if (r3 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("decoratedAvatarView");
        r3 = null;
    L13:
        UIUtils.setViewVisibility(r3, 0);
        FrameLayout r4 = this.contentLayout;
        if (r4 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("contentLayout");
    L17:
        ViewGroup.LayoutParams r5 = r6.getLayoutParams();
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        ((RelativeLayout.LayoutParams) r5).setMarginStart(0);
        Drawable r7 = UIHelper.getDrawable(2131238420);
        if (r13 == null) goto L24;
        if (StringsKt.isBlank(r13) == true) goto L24;
        r0 = false;
    L24:
        if (r0 == true) goto L26;
        r7 = new BitmapDrawable(getResources(), FakePickerAvatarCreator.createNameAvatarBitmap(dp(48.0f), dp(48.0f), r13, UIHelper.getColor(2131108721)));
    L26:
        Drawable r8 = r7;
        PickerBaseModuleDependency.getDependency().loadImage(getContext(), r12, getAvatarView(), r8, r8, dp(48.0f), dp(48.0f));
        return;
    L16:
        r6 = r4;
        goto L17
    L27:
        UIUtils.setViewVisibility(getAvatarView(), 8);
        View r14 = this.decoratedAvatarView;
        if (r14 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("decoratedAvatarView");
        r14 = null;
    L30:
        UIUtils.setViewVisibility(r14, 8);
        FrameLayout r15 = this.contentLayout;
        if (r15 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("contentLayout");
    L34:
        ViewGroup.LayoutParams r16 = r6.getLayoutParams();
        Intrinsics.checkNotNull(r16, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        ((RelativeLayout.LayoutParams) r16).setMarginStart(dp(16.0f));
        return;
    L33:
        r6 = r15;
        goto L34
    L5:
        if ((!StringsKt.isBlank(r12)) != true) goto L7;
        r2 = true;
        goto L8
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
        this.mOldHeightMeasureSpec = r2;
        this.mOldWidthMeasureSpec = r1;
    }

    public final void setExtraInfoSummary(ExtraInfoSummary r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "extraInfoSummary");
        ExtraInfoView r1 = null;
        if (r5.getExtraInfoList().isEmpty() == false) goto L10;
        ExtraInfoView r7 = this.extraInfoView;
        if (r7 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("extraInfoView");
    L8:
        r1.setVisibility(8);
        return;
    L7:
        r1 = r7;
        goto L8
    L10:
        ExtraInfoView r0 = this.extraInfoView;
        if (r0 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("extraInfoView");
        r0 = null;
    L13:
        r0.setVisibility(0);
        ExtraInfoView r2 = this.extraInfoView;
        if (r2 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("extraInfoView");
    L17:
        r1.setExtraInfoSummary(r5, r6);
        return;
    L16:
        r1 = r2;
        goto L17
    }

    public final void setTag(LarkNameTag.c r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "builder");
        EllipsizedEmojiconTextView r1 = null;
        if (r5 != 2) goto L9;
        LarkNameTag r6 = r4.f();
        EllipsizedEmojiconTextView r7 = this.titleTailView;
        if (r7 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("titleTailView");
    L8:
        r6.c(r1);
        return;
    L7:
        r1 = r7;
        goto L8
    L9:
        ImageView r8 = this.rightTagWrapper;
        if (r8 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("rightTagWrapper");
        r8 = null;
    L12:
        r8.setVisibility(0);
        LarkNameTag r9 = r4.f();
        EllipsizedEmojiconTextView r10 = this.rightTagWrapper;
        if (r10 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("rightTagWrapper");
    L16:
        r9.getClass();
        Intrinsics.checkNotNullParameter(r1, "view");
        if (LarkNameTag.a(r1.getBackground(), r9.a) == true) goto L21;
        r1.setBackground(r9.b());
        return;
    L21:
        return;
    L15:
        r1 = r10;
        goto L16
    }

    public final void attachRightView(final View r5, boolean r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r5, "v");
        FrameLayout r0 = this.rightViewHolder;
        final View r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("rightViewHolder");
        r0 = null;
    L5:
        r0.addView(r5);
        ViewGroup r2 = this.rightItemWrapper;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("rightItemWrapper");
        r2 = null;
    L8:
        r2.setVisibility(0);
        if (r6 == false) goto L22;
        ViewGroup r8 = this.rightItemWrapper;
        if (r8 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("rightItemWrapper");
        r8 = null;
    L13:
        ViewGroup.LayoutParams r9 = r8.getLayoutParams();
        if ((r9 instanceof RelativeLayout.LayoutParams) == false) goto L16;
        RelativeLayout.LayoutParams r10 = (RelativeLayout.LayoutParams) r9;
    L17:
        if (r10 == null) goto L22;
        r10.topMargin = 0;
        r10.removeRule(6);
        ViewGroup r3 = this.rightItemWrapper;
        if (r3 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("rightItemWrapper");
        r3 = null;
    L21:
        r3.setLayoutParams(r10);
        goto L22
    L16:
        r10 = null;
    L22:
        if (r7 == false) goto L35;
        ViewGroup r11 = this.rightItemWrapper;
        if (r11 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("rightItemWrapper");
        r11 = null;
    L26:
        r11.setOnClickListener(new AnonymousClass3(r5));
        ViewGroup r12 = this.rightItemWrapper;
        if (r12 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("rightItemWrapper");
        r12 = null;
    L29:
        Object r13 = r12.getParent();
        if ((r13 instanceof View) == false) goto L32;
        r1 = (View) r13;
    L32:
        if (r1 == null) goto L36;
        r1.post(new AvatarItemView$attachRightView$4$1(this, r1, r5));
        return;
    L36:
        return;
    }

    public AvatarItemView(Context r2, AttributeSet r3, int r4, a r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r5, "compositeComponentDelegate");
        super(r2, r3, r4);
        this.compositeComponentDelegate = r5;
        this.contentView$delegate = LazyKt.lazy(new AvatarItemView$contentView$2(this));
        this.bottomView$delegate = LazyKt.lazy(new AvatarItemView$bottomView$2(this));
        this.mOldWidthMeasureSpec = Integer.MIN_VALUE;
        this.mOldHeightMeasureSpec = Integer.MIN_VALUE;
        this.fgUtils = new SearchCommonFgUtils();
        setBackground(r2.getDrawable(2131231778));
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(1);
        addView(getContentView());
        addView(getBottomView());
        if (r3 == null) goto L5;
        applyStyle(r3.getStyleAttribute());
    L5:
        UiState r6 = UiState.NONE;
        this.subTitleState = r6;
        this.summaryState = r6;
    }

    public final void bindAvatarWithUrl(String r9, Drawable r10, Float r11, Float r12) {
        if (r10 != null) goto L4;
        r10 = UIHelper.getDrawable(2131238420);
    L4:
        Drawable r5 = r10;
        if (r11 == null) goto L11;
        if (r12 == null) goto L11;
        FrameLayout r13 = this.decoratedAvatarView;
        if (r13 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("decoratedAvatarView");
        r13 = null;
    L10:
        ViewGroup.LayoutParams r0 = r13.getLayoutParams();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams r1 = (RelativeLayout.LayoutParams) r0;
        r1.width = UIHelper.dp2px(r11.floatValue());
        r1.height = UIHelper.dp2px(r12.floatValue());
        r1.addRule(15);
        r13.setLayoutParams(r1);
    L11:
        float r14 = 48.0f;
        if (r11 == null) goto L14;
        float r15 = r11.floatValue();
    L15:
        if (r12 == null) goto L17;
        r14 = r12.floatValue();
    L17:
        PickerBaseModuleDependency.getDependency().loadImage(getContext(), r9, getAvatarView(), r5, r5, dp(r15), dp(r14));
        return;
    L14:
        r15 = 48.0f;
        goto L15
    }

    public static /* synthetic */ void bindAvatarWithUrl$default(AvatarItemView r0, String r1, String r2, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 2) == 0) goto L6;
        r2 = null;
    L6:
        r0.bindAvatarWithUrl(r1, r2);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: bindAvatarWithUrl");
    }

    public /* synthetic */ AvatarItemView(Context r1, AttributeSet r2, int r3, a r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r5 & 4) == 0) goto L9;
        r3 = 0;
    L9:
        if ((r5 & 8) == 0) goto L11;
        r4 = new a();
    L11:
        this(r1, r2, r3, r4);
    }

    public static /* synthetic */ void attachRightView$default(AvatarItemView r0, View r1, boolean r2, boolean r3, int r4, Object r5) {
        if (r5 != null) goto L12;
        if ((r4 & 2) == 0) goto L7;
        r2 = false;
    L7:
        if ((r4 & 4) == 0) goto L9;
        r3 = true;
    L9:
        r0.attachRightView(r1, r2, r3);
        return;
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: attachRightView");
    }

    public static /* synthetic */ void bindAvatarWithUrl$default(AvatarItemView r1, String r2, Drawable r3, Float r4, Float r5, int r6, Object r7) {
        if (r7 != null) goto L12;
        if ((r6 & 4) == 0) goto L7;
        r4 = null;
    L7:
        if ((r6 & 8) == 0) goto L9;
        r5 = null;
    L9:
        r1.bindAvatarWithUrl(r2, r3, r4, r5);
        return;
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: bindAvatarWithUrl");
    }
}
