package com.ss.android.lark.picker.base.widget;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.bytedance.lark.pb.basic.v1.ActionType;
import com.bytedance.lark.pb.basic.v1.DeniedReason;
import com.bytedance.lark.pb.search.v2.MailContactMeta;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.appreciablelib.AppreciableKit;
import com.ss.android.lark.appreciablelib.Biz;
import com.ss.android.lark.appreciablelib.Event;
import com.ss.android.lark.appreciablelib.Scene;
import com.ss.android.lark.base.fragment.BaseFragment;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.contact.export.Department;
import com.ss.android.lark.contact.export.EmailContact;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.picker.base.statistics.PickerTracker;
import com.ss.android.lark.picker.base.utils.SearchCommonUtils;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.picker.base.view.SearchResultView;
import com.ss.android.lark.picker.base.widget.BasePicker;
import com.ss.android.lark.picker.base.widget.business.ContactsSelectorBusiness;
import com.ss.android.lark.picker.base.widget.business.ICustomBusiness;
import com.ss.android.lark.picker.base.widget.dependency.PickerWidgetModuleDependency;
import com.ss.android.lark.picker.base.widget.itemcustomizer.CommonItemCustomizer;
import com.ss.android.lark.picker.base.widget.params.BasePickerParams;
import com.ss.android.lark.picker.base.widget.params.ChatterPickerParams;
import com.ss.android.lark.picker.base.widget.params.PickType;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporter;
import com.ss.android.lark.picker.base.widget.scenario.PermissionGroupListFragment;
import com.ss.android.lark.picker.base.widget.scenario.PersonnelTypeListFragment;
import com.ss.android.lark.picker.base.widget.utils.FG;
import com.ss.android.lark.search.dto.DataSource;
import com.ss.android.lark.search.dto.UserGroupScene;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.search.dto.info.SearchChatInfo;
import com.ss.android.lark.search.dto.info.SearchChatterInfo;
import com.ss.android.lark.search.dto.info.SearchDepartmentInfo;
import com.ss.android.lark.search.dto.info.SearchMailContactInfo;
import com.ss.android.lark.search.dto.info.SearchUserGroupInfo;
import com.ss.android.lark.search.dto.service.SearchContext;
import com.ss.android.lark.search.dto.service.Union;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.annotation.AnnotationRetention;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000è\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\bQ\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 ó\u0001*\b\b\u0000\u0010\u0001*\u00020\u0002*\u0014\b\u0001\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u00042\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0004:\u0004ó\u0001ô\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bB\u001b\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0007\u0010\u000bJ\b\u0010K\u001a\u00020LH\u0017J\u000e\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020.J\u000e\u0010N\u001a\u00020L2\u0006\u0010O\u001a\u00020:J\u0017\u0010P\u001a\u00020.2\b\u0010Q\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0002\u0010RJ\u001f\u0010S\u001a\u00020T2\u0006\u0010U\u001a\u00020T2\b\u0010Q\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0002\u0010VJ%\u0010W\u001a\u00020L2\n\b\u0002\u0010X\u001a\u0004\u0018\u00010B2\n\b\u0002\u0010Y\u001a\u0004\u0018\u00010ZH\u0004¢\u0006\u0002\u0010[J\b\u0010\\\u001a\u00020LH\u0002J\b\u0010]\u001a\u00020LH\u0002J%\u0010^\u001a\u00020L2\n\b\u0002\u0010X\u001a\u0004\u0018\u00010B2\n\b\u0002\u0010Y\u001a\u0004\u0018\u00010ZH\u0002¢\u0006\u0002\u0010[J\b\u0010_\u001a\u00020\u0012H\u0002J\b\u0010`\u001a\u00020LH\u0002J0\u0010a\u001a\u00020.2\u0006\u0010b\u001a\u00020>2\u0006\u0010c\u001a\u00020>2\u0006\u0010d\u001a\u00020:2\u0006\u0010e\u001a\u00020.2\u0006\u0010f\u001a\u00020:H\u0002J\u0010\u0010g\u001a\u00020L2\u0006\u0010h\u001a\u00020>H\u0002J\b\u0010i\u001a\u00020LH\u0002J\b\u0010j\u001a\u00020LH\u0002J\u001a\u0010k\u001a\u00020L2\u0006\u0010l\u001a\u00020:2\b\b\u0002\u0010h\u001a\u00020>H\u0004J\b\u0010s\u001a\u00020LH\u0016J\"\u0010t\u001a\u00020.2\u0006\u0010u\u001a\u00020v2\u0006\u0010e\u001a\u00020.2\b\b\u0002\u0010w\u001a\u00020:H\u0002J\u0010\u0010x\u001a\u00020y2\u0006\u0010u\u001a\u00020vH\u0002J.\u0010z\u001a\u00020.2\u0006\u0010{\u001a\u00020|2\u0006\u0010e\u001a\u00020.2\b\b\u0002\u0010w\u001a\u00020:2\n\b\u0002\u0010}\u001a\u0004\u0018\u00010>H\u0002J6\u0010~\u001a\u00020.2\b\u0010\u007f\u001a\u0004\u0018\u00010>2\t\u0010\u0080\u0001\u001a\u0004\u0018\u00010>2\u0007\u0010\u0081\u0001\u001a\u00020:2\u0006\u0010e\u001a\u00020.2\u0006\u0010f\u001a\u00020:H\u0002J#\u0010\u0082\u0001\u001a\u00020.2\b\u0010\u0083\u0001\u001a\u00030\u0084\u00012\u0006\u0010e\u001a\u00020.2\u0006\u0010f\u001a\u00020:H\u0002J\t\u0010\u0085\u0001\u001a\u00020.H\u0016J\u0016\u0010\u0086\u0001\u001a\u00028\u00012\u0007\u0010\u0087\u0001\u001a\u00020.¢\u0006\u0003\u0010\u0088\u0001J\u0016\u0010\u0089\u0001\u001a\u00028\u00012\u0007\u0010\u008a\u0001\u001a\u00020.¢\u0006\u0003\u0010\u0088\u0001J\u0016\u0010\u008b\u0001\u001a\u00028\u00012\u0007\u0010\u008c\u0001\u001a\u00020.¢\u0006\u0003\u0010\u0088\u0001J\u0016\u0010\u008d\u0001\u001a\u00028\u00012\u0007\u0010\u008e\u0001\u001a\u00020.¢\u0006\u0003\u0010\u0088\u0001J\u0012\u0010\u008f\u0001\u001a\u00020L2\u0007\u0010\u0090\u0001\u001a\u00020.H\u0007J\u0010\u0010\u0091\u0001\u001a\u00020L2\u0007\u0010\u0090\u0001\u001a\u00020.J\u0016\u0010\u0092\u0001\u001a\u00028\u00012\u0007\u0010\u0093\u0001\u001a\u00020.¢\u0006\u0003\u0010\u0088\u0001J\u0016\u0010\u0094\u0001\u001a\u00028\u00012\u0007\u0010\u0095\u0001\u001a\u00020.¢\u0006\u0003\u0010\u0088\u0001J\u001b\u0010\u0096\u0001\u001a\u00028\u00012\f\u00106\u001a\b\u0012\u0004\u0012\u00020807¢\u0006\u0003\u0010\u0097\u0001J\u001b\u0010\u0098\u0001\u001a\u00020L2\u0007\u0010\u0099\u0001\u001a\u00020.2\u0007\u0010\u009a\u0001\u001a\u00020.H\u0016J\u0007\u0010\u009b\u0001\u001a\u00020:J\n\u0010\u009c\u0001\u001a\u0005\u0018\u00010\u009d\u0001J\u0007\u0010\u009e\u0001\u001a\u00020LJ\u0018\u0010\u009f\u0001\u001a\u00028\u00012\t\u0010 \u0001\u001a\u0004\u0018\u00010>¢\u0006\u0003\u0010¡\u0001J\u001a\u0010¢\u0001\u001a\u00028\u00012\u000b\u0010£\u0001\u001a\u0006\u0012\u0002\b\u00030J¢\u0006\u0003\u0010¤\u0001J(\u0010¥\u0001\u001a\u00028\u00012\u0007\u0010¦\u0001\u001a\u00020\u00122\u0007\u0010§\u0001\u001a\u00020\u00122\u0007\u0010¨\u0001\u001a\u00020\u0012¢\u0006\u0003\u0010©\u0001J\u0007\u0010ª\u0001\u001a\u00020LJ\u0012\u0010«\u0001\u001a\u00020L2\u0007\u0010¬\u0001\u001a\u00020\u0012H\u0002J\t\u0010\u00ad\u0001\u001a\u00020LH\u0002J\u0007\u0010®\u0001\u001a\u00020LJ\u0007\u0010¯\u0001\u001a\u00020LJ\u0018\u0010°\u0001\u001a\u00020L2\u0007\u0010±\u0001\u001a\u0002082\u0006\u0010e\u001a\u00020.J\u0010\u0010²\u0001\u001a\u00020.2\u0007\u0010±\u0001\u001a\u000208J\u000f\u0010³\u0001\u001a\b\u0012\u0004\u0012\u00020>07H\u0002J\u000f\u0010´\u0001\u001a\b\u0012\u0004\u0012\u00020>07H\u0002J\u000f\u0010µ\u0001\u001a\b\u0012\u0004\u0012\u00020>07H\u0002J\u000f\u0010¶\u0001\u001a\b\u0012\u0004\u0012\u00020>07H\u0002J\u000f\u0010·\u0001\u001a\b\u0012\u0004\u0012\u00020>07H\u0002J\u001c\u0010Í\u0001\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0007\u0010Î\u0001\u001a\u00020.J\u001c\u0010Ï\u0001\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0007\u0010Ð\u0001\u001a\u00020.J\u0010\u0010Ñ\u0001\u001a\u00020L2\u0007\u0010Ð\u0001\u001a\u00020.J\u001c\u0010Ò\u0001\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0007\u0010Ó\u0001\u001a\u00020.J\u001c\u0010Ô\u0001\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0007\u0010Ó\u0001\u001a\u00020.J\u001c\u0010Õ\u0001\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0007\u0010Ó\u0001\u001a\u00020.J\u0010\u0010Ö\u0001\u001a\u00020L2\u0007\u0010Ó\u0001\u001a\u00020.J\u001c\u0010×\u0001\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0007\u0010Ø\u0001\u001a\u00020.J\u001c\u0010Ù\u0001\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0007\u0010Ú\u0001\u001a\u00020.J\u001c\u0010Û\u0001\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0007\u0010Ú\u0001\u001a\u00020.J\u001c\u0010Ü\u0001\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0007\u0010Ú\u0001\u001a\u00020.J\u0010\u0010Ý\u0001\u001a\u00020L2\u0007\u0010Ú\u0001\u001a\u00020.J\u0016\u0010á\u0001\u001a\u00028\u00012\u0007\u0010â\u0001\u001a\u00020.¢\u0006\u0003\u0010\u0088\u0001J\u0016\u0010ã\u0001\u001a\u00028\u00012\u0007\u0010ä\u0001\u001a\u00020.¢\u0006\u0003\u0010\u0088\u0001J\u0016\u0010å\u0001\u001a\u00028\u00012\u0007\u0010æ\u0001\u001a\u00020G¢\u0006\u0003\u0010ç\u0001J\u0016\u0010è\u0001\u001a\u00028\u00012\u0007\u0010é\u0001\u001a\u00020.¢\u0006\u0003\u0010\u0088\u0001J\u0016\u0010ê\u0001\u001a\u00028\u00012\u0007\u0010Ç\u0001\u001a\u00020.¢\u0006\u0003\u0010\u0088\u0001J\u0016\u0010ë\u0001\u001a\u00028\u00012\u0007\u0010ì\u0001\u001a\u00020.¢\u0006\u0003\u0010\u0088\u0001J\u001b\u0010í\u0001\u001a\u00028\u00012\n\u0010î\u0001\u001a\u0005\u0018\u00010ï\u0001H\u0016¢\u0006\u0003\u0010ð\u0001J&\u0010í\u0001\u001a\u00028\u00012\n\u0010î\u0001\u001a\u0005\u0018\u00010ï\u00012\t\b\u0002\u0010ñ\u0001\u001a\u00020.H\u0017¢\u0006\u0003\u0010ò\u0001R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u00020\u0017X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010%\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b&\u0010'R\u0010\u0010*\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020.X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020.X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020.X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020.X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020.X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020.X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020.X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00106\u001a\b\u0012\u0004\u0012\u00020807X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00109\u001a\u00020:X\u0082\u000e¢\u0006\b\n\u0000\u0012\u0004\b;\u0010<R\u000e\u0010=\u001a\u00020>X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020>X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020>X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020BX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020BX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020BX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020.X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020GX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010H\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030J0IX\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010m\u001a\u0010\u0012\u0004\u0012\u00020:\u0012\u0004\u0012\u00020L\u0018\u00010nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bo\u0010p\"\u0004\bq\u0010rR\u000f\u0010¸\u0001\u001a\u00020.X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010¹\u0001\u001a\u00020.X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010º\u0001\u001a\u00020.X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010»\u0001\u001a\u0004\u0018\u00010.X\u0082\u000e¢\u0006\u0005\n\u0003\u0010¼\u0001R\u001f\u0010½\u0001\u001a\u00020.X\u0084\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¾\u0001\u0010¿\u0001\"\u0006\bÀ\u0001\u0010Á\u0001R\u000f\u0010Â\u0001\u001a\u00020.X\u0082\u000e¢\u0006\u0002\n\u0000R\u001f\u0010Ã\u0001\u001a\u00020.X\u0084\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÄ\u0001\u0010¿\u0001\"\u0006\bÅ\u0001\u0010Á\u0001R\u000f\u0010Æ\u0001\u001a\u00020.X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010Ç\u0001\u001a\u00020.8DX\u0084\u0004¢\u0006\b\u001a\u0006\bÇ\u0001\u0010¿\u0001R$\u0010È\u0001\u001a\u0004\u0018\u00010.X\u0084\u000e¢\u0006\u0015\n\u0003\u0010¼\u0001\u001a\u0006\bÉ\u0001\u0010Ê\u0001\"\u0006\bË\u0001\u0010Ì\u0001R\u001f\u0010Þ\u0001\u001a\u00020.X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bß\u0001\u0010¿\u0001\"\u0006\bà\u0001\u0010Á\u0001¨\u0006õ\u0001"}, d2 = {"Lcom/ss/android/lark/picker/base/widget/AbsChatterPicker;", "P", "Lcom/ss/android/lark/picker/base/widget/params/ChatterPickerParams;", "PK", "Lcom/ss/android/lark/picker/base/widget/BasePicker;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mPickType", "Lcom/ss/android/lark/picker/base/widget/params/PickType;", "mContext", "mIContactHomeController", "Lcom/ss/android/lark/picker/base/widget/dependency/PickerWidgetModuleDependency$IPickerWidgetModuleDependency$IContactHomeController;", "mCustomerContactFragment", "Lcom/ss/android/lark/base/fragment/BaseFragment;", "mIEmailContactController", "Lcom/ss/android/lark/picker/base/widget/dependency/PickerWidgetModuleDependency$IPickerWidgetModuleDependency$IEmailContactController;", "mEmailContactFragment", "mIContactsSelectorController", "Lcom/ss/android/lark/picker/base/widget/dependency/PickerWidgetModuleDependency$IPickerWidgetModuleDependency$IContactsSelectorController;", "getMIContactsSelectorController", "()Lcom/ss/android/lark/picker/base/widget/dependency/PickerWidgetModuleDependency$IPickerWidgetModuleDependency$IContactsSelectorController;", "mContactsSelectorFragment", "mIDepartmentDetailController", "Lcom/ss/android/lark/picker/base/widget/dependency/PickerWidgetModuleDependency$IPickerWidgetModuleDependency$IDepartmentDetailController;", "mDepartmentDetailFragment", "mTrustPartyController", "mTrustPartyFragment", "mContactsOwnerGroupController", "Lcom/ss/android/lark/picker/base/widget/dependency/PickerWidgetModuleDependency$IPickerWidgetModuleDependency$IContactsOwnerGroupController;", "mContactsOwnerGroupFragment", "userGroupController", "Lcom/ss/android/lark/picker/base/widget/dependency/PickerWidgetModuleDependency$IPickerWidgetModuleDependency$IUserGroupController;", "userGroupFragment", "getUserGroupFragment", "()Lcom/ss/android/lark/base/fragment/BaseFragment;", "userGroupFragment$delegate", "Lkotlin/Lazy;", "mScenarioEntriesFragment", "mScenarioPersonnelTypeListFragment", "mScenarioPermissionGroupListFragment", "mIsShowMineGroupItem", "", "mIsShowOwnerGroup", "mIsExternalContactEnabled", "mIsShowDepartment", "mDisableExternalChatter", "mIsEmailContactEnabled", "mIsEmailSharedAccountEnabled", "mDisableEmailContact", "relatedContactsInfoList", "", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "mFragmentType", "", "getMFragmentType$annotations", "()V", "mInitDepartmentId", "", "mSelfId", "appreciableRptKey", "appreciableRptInitViewCost", "", "appreciableRptInitViewStart", "appreciableRptFirstRenderCost", "mIsShowTrustParty", "userGroupSceneType", "Lcom/ss/android/lark/search/dto/UserGroupScene;", "mBusinessExtensions", "", "Lcom/ss/android/lark/picker/base/widget/business/ICustomBusiness;", "attachComplete", "", "showContactList", "initOrgItemConsumer", AppbrandHostConstants.Schema_RESERVED_FIELD.VERSION, "spotLightSupportable", "pickerParams", "(Lcom/ss/android/lark/picker/base/widget/params/ChatterPickerParams;)Z", "transformByPickerParams", "Lcom/ss/android/lark/search/dto/service/SearchContext;", "searchContext", "(Lcom/ss/android/lark/search/dto/service/SearchContext;Lcom/ss/android/lark/picker/base/widget/params/ChatterPickerParams;)Lcom/ss/android/lark/search/dto/service/SearchContext;", "initOrganizationFragment", "pickerInitTime", "pickerTracker", "Lcom/ss/android/lark/picker/base/statistics/PickerTracker;", "(Ljava/lang/Long;Lcom/ss/android/lark/picker/base/statistics/PickerTracker;)V", "initFragmentForCustomer", "initFragmentForEmailContact", "initFragmentForBusiness", "initUserGroupFragment", "showUserGroupFragment", "onUserGroupPick", "userGroupId", "userGroupName", "groupType", "isSelected", "position", "showDepartmentDetailFragment", "targetId", "showTrustPartyFragment", "showContactOwnerGroupFragment", "showFragment", "fragmentType", "onFragmentTypeChangeListener", "Lkotlin/Function1;", "getOnFragmentTypeChangeListener", "()Lkotlin/jvm/functions/Function1;", "setOnFragmentTypeChangeListener", "(Lkotlin/jvm/functions/Function1;)V", "refreshDefault", "onEmailContactPick", "contact", "Lcom/ss/android/lark/contact/export/EmailContact;", "deniedReason", "parseChatterViewDataFromContact", "Lcom/ss/android/lark/search/dto/info/SearchMailContactInfo;", "onOrganizationChatterPick", "chatter", "Lcom/ss/android/lark/chat/entity/chatter/Chatter;", "enterpriseEmail", "onOrganizationDepartmentPick", "departmentId", "departmentName", "memberCount", "onOwnerGroupItemPick", "chat", "Lcom/ss/android/lark/chat/entity/chat/Chat;", "onBackPressed", "attachIsShowMineGroupItem", "isShowMineGroupItem", "(Z)Lcom/ss/android/lark/picker/base/widget/BasePicker;", "attachIsShowOwnerGroupItem", "isShowOwnerGroup", "attachIsExternalContactEnabled", "isExternalContactEnabled", "attachIsShowDepartment", "isShowDepartment", "setDisableExternalChatter", "disableExternalChatter", "setDisableExternalChatterV2", "attachIsEmailContactEnabled", "isEmailContactEnabled", "attachIsEmailSharedAccountEnabled", "isEmailSharedAccountEnabled", "setRelatedContactsInfoList", "(Ljava/util/List;)Lcom/ss/android/lark/picker/base/widget/BasePicker;", "switchMultipleStatus", "isMultiple", "isForce", "getFragmentType", "getCurDepartment", "Lcom/ss/android/lark/contact/export/Department;", "refreshCurrentDepartment", "attachInitDepartmentId", "initDepartmentId", "(Ljava/lang/String;)Lcom/ss/android/lark/picker/base/widget/BasePicker;", "attachCustomBusiness", "customBusiness", "(Lcom/ss/android/lark/picker/base/widget/business/ICustomBusiness;)Lcom/ss/android/lark/picker/base/widget/BasePicker;", "attachScenarioFragments", "entries", "personnelTypeList", "permissionGroupList", "(Lcom/ss/android/lark/base/fragment/BaseFragment;Lcom/ss/android/lark/base/fragment/BaseFragment;Lcom/ss/android/lark/base/fragment/BaseFragment;)Lcom/ss/android/lark/picker/base/widget/BasePicker;", "showScenarioEntries", "showScenarioSubPage", "fragment", "showScenarioEntriesWithExitAnimation", "showScenarioPersonnelTypeList", "showScenarioPermissionGroupList", "onScenarioItemSelectChanged", "data", "isScenarioItemSelected", "getSelectedChatterIds", "getSelectedChatIds", "getSelectedDepartmentIds", "getSelectedEmailContactIds", "getSelectedGroupIds", "mDisableSearchChatter", "addChatterFromChatBySearch", "addChatterFromChatByOrganization", "mSearchOuterGroupChat", "Ljava/lang/Boolean;", "addChatterFromDepartmentBySearch", "getAddChatterFromDepartmentBySearch", "()Z", "setAddChatterFromDepartmentBySearch", "(Z)V", "addChatterFromDepartmentByOrganization", "mIsDepartmentSelectableWhenVisible", "getMIsDepartmentSelectableWhenVisible", "setMIsDepartmentSelectableWhenVisible", "mIsCheckOrgOUPermission", "isCheckOrgOUPermission", "mIsGroupSearchableWhenVisible", "getMIsGroupSearchableWhenVisible", "()Ljava/lang/Boolean;", "setMIsGroupSearchableWhenVisible", "(Ljava/lang/Boolean;)V", "attachDisableChatter", "disableSearchChatter", "attachAddChatterFromChatAndDepartment", "addChatterFromChatAndDepartment", "setAddChatterFromChatAndDepartment", "attachAddChatterFromChat", "addChatterFromChat", "attachAddChatterFromChatBySearch", "attachAddChatterFromChatByOrganization", "setAddChatterFromChat", "attachSearchOuterGroupChat", "searchOuterGroupChat", "attachAddChatterFromDepartment", "addChatterFromDepartment", "attachAddChatterFromDepartmentBySearch", "attachAddChatterFromDepartmentByOrganization", "setAddChatterFromDepartment", "mHasEnterpriseEmail", "getMHasEnterpriseEmail", "setMHasEnterpriseEmail", "attachHasEnterpriseEmail", "hasEnterpriseEmail", "attachIsShowTrustParty", "isShowTrustParty", "attachUserGroup", "scene", "(Lcom/ss/android/lark/search/dto/UserGroupScene;)Lcom/ss/android/lark/picker/base/widget/BasePicker;", "attachIsDepartmentSelectableWhenVisible", "isDepartmentSelectableWhenVisible", "attachIsCheckOrgOUPermission", "attachIsGroupSearchableWhenVisible", "isGroupSearchableWhenVisible", "attachOnBusinessConsumeItem", "onBusinessConsumeItem", "Lcom/ss/android/lark/picker/base/view/SearchResultView$IOnBusinessConsumeItem;", "(Lcom/ss/android/lark/picker/base/view/SearchResultView$IOnBusinessConsumeItem;)Lcom/ss/android/lark/picker/base/widget/BasePicker;", "isRecursion", "(Lcom/ss/android/lark/picker/base/view/SearchResultView$IOnBusinessConsumeItem;Z)Lcom/ss/android/lark/picker/base/widget/BasePicker;", "Companion", "FragmentType", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public class AbsChatterPicker<P extends ChatterPickerParams, PK extends BasePicker<P, PK>> extends BasePicker<P, PK> {
    private static final String APPRECIABLE_RPT_FIRST_RENDER_COST = "first_render";
    private static final String APPRECIABLE_RPT_FROM_TYPE = "from_type";
    private static final String APPRECIABLE_RPT_VIEW_INIT_COST = "init_view_cost";
    public static final Companion Companion = null;
    private static final String EXTERNAL_STRUCT_DEPARTMENT_ID = "-1";
    private static final String KEY_CHAT_ID = "chat_id";
    private static final String KEY_IS_B2B_CONNECT = "b2b_connect";
    private static final String KEY_PICKER_B2B = "picker_b2b";
    private static final String TAG = "LarkSearch.SearchWidget.AbsChatterPicker";
    private boolean addChatterFromChatByOrganization;
    private boolean addChatterFromChatBySearch;
    private boolean addChatterFromDepartmentByOrganization;
    private boolean addChatterFromDepartmentBySearch;
    private long appreciableRptFirstRenderCost;
    private long appreciableRptInitViewCost;
    private long appreciableRptInitViewStart;
    private final String appreciableRptKey;
    private Set<ICustomBusiness<?>> mBusinessExtensions;
    private PickerWidgetModuleDependency.IPickerWidgetModuleDependency.IContactsOwnerGroupController mContactsOwnerGroupController;
    private BaseFragment mContactsOwnerGroupFragment;
    private BaseFragment mContactsSelectorFragment;
    private Context mContext;
    private BaseFragment mCustomerContactFragment;
    private BaseFragment mDepartmentDetailFragment;
    private boolean mDisableEmailContact;
    private boolean mDisableExternalChatter;
    private boolean mDisableSearchChatter;
    private BaseFragment mEmailContactFragment;
    private int mFragmentType;
    private boolean mHasEnterpriseEmail;
    private final PickerWidgetModuleDependency.IPickerWidgetModuleDependency.IContactHomeController mIContactHomeController;
    private final PickerWidgetModuleDependency.IPickerWidgetModuleDependency.IContactsSelectorController mIContactsSelectorController;
    private final PickerWidgetModuleDependency.IPickerWidgetModuleDependency.IDepartmentDetailController mIDepartmentDetailController;
    private final PickerWidgetModuleDependency.IPickerWidgetModuleDependency.IEmailContactController mIEmailContactController;
    private String mInitDepartmentId;
    private boolean mIsCheckOrgOUPermission;
    private boolean mIsDepartmentSelectableWhenVisible;
    private boolean mIsEmailContactEnabled;
    private boolean mIsEmailSharedAccountEnabled;
    private boolean mIsExternalContactEnabled;
    private Boolean mIsGroupSearchableWhenVisible;
    private boolean mIsShowDepartment;
    private boolean mIsShowMineGroupItem;
    private boolean mIsShowOwnerGroup;
    private boolean mIsShowTrustParty;
    private PickType mPickType;
    private BaseFragment mScenarioEntriesFragment;
    private BaseFragment mScenarioPermissionGroupListFragment;
    private BaseFragment mScenarioPersonnelTypeListFragment;
    private Boolean mSearchOuterGroupChat;
    private String mSelfId;
    private final PickerWidgetModuleDependency.IPickerWidgetModuleDependency.IDepartmentDetailController mTrustPartyController;
    private BaseFragment mTrustPartyFragment;
    private Function1<? super Integer, Unit> onFragmentTypeChangeListener;
    private List<? extends SearchBaseInfo> relatedContactsInfoList;
    private PickerWidgetModuleDependency.IPickerWidgetModuleDependency.IUserGroupController userGroupController;
    private final Lazy userGroupFragment$delegate;
    private UserGroupScene userGroupSceneType;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/picker/base/widget/AbsChatterPicker$Companion;", "", "<init>", "()V", "TAG", "", "EXTERNAL_STRUCT_DEPARTMENT_ID", "APPRECIABLE_RPT_VIEW_INIT_COST", "APPRECIABLE_RPT_FIRST_RENDER_COST", "APPRECIABLE_RPT_FROM_TYPE", "KEY_IS_B2B_CONNECT", "KEY_PICKER_B2B", "KEY_CHAT_ID", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/ss/android/lark/picker/base/widget/AbsChatterPicker$FragmentType;", "", "Companion", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface FragmentType {
        public static final Companion Companion = null;
        public static final int TYPE_CONTACTS_OWNER_GROUP = 5;
        public static final int TYPE_CONTACTS_SELECTOR = 1;
        public static final int TYPE_CUSTOMER_CONTACTS = 3;
        public static final int TYPE_DEPARTMENT_DETAIL = 2;
        public static final int TYPE_EMAIL_CONTACT = 7;
        public static final int TYPE_EMAIL_SHARED_ACCOUNT = 8;
        public static final int TYPE_SCENARIO_ENTRIES = 10;
        public static final int TYPE_SCENARIO_PERMISSION_GROUP_LIST = 12;
        public static final int TYPE_SCENARIO_PERSONNEL_TYPE_LIST = 11;
        public static final int TYPE_TRUST_PARTY = 6;
        public static final int TYPE_USER_GROUP = 9;

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/ss/android/lark/picker/base/widget/AbsChatterPicker$FragmentType$Companion;", "", "<init>", "()V", "TYPE_CONTACTS_SELECTOR", "", "TYPE_DEPARTMENT_DETAIL", "TYPE_CUSTOMER_CONTACTS", "TYPE_CONTACTS_OWNER_GROUP", "TYPE_TRUST_PARTY", "TYPE_EMAIL_CONTACT", "TYPE_EMAIL_SHARED_ACCOUNT", "TYPE_USER_GROUP", "TYPE_SCENARIO_ENTRIES", "TYPE_SCENARIO_PERSONNEL_TYPE_LIST", "TYPE_SCENARIO_PERMISSION_GROUP_LIST", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = null;
            public static final int TYPE_CONTACTS_OWNER_GROUP = 5;
            public static final int TYPE_CONTACTS_SELECTOR = 1;
            public static final int TYPE_CUSTOMER_CONTACTS = 3;
            public static final int TYPE_DEPARTMENT_DETAIL = 2;
            public static final int TYPE_EMAIL_CONTACT = 7;
            public static final int TYPE_EMAIL_SHARED_ACCOUNT = 8;
            public static final int TYPE_SCENARIO_ENTRIES = 10;
            public static final int TYPE_SCENARIO_PERMISSION_GROUP_LIST = 12;
            public static final int TYPE_SCENARIO_PERSONNEL_TYPE_LIST = 11;
            public static final int TYPE_TRUST_PARTY = 6;
            public static final int TYPE_USER_GROUP = 9;

            static {
                $$INSTANCE = new Companion();
            }

            private Companion() {
            }
        }

        static {
            Companion = Companion.$$INSTANCE;
        }
    }

    static {
        Companion = new Companion(null);
    }

    private static /* synthetic */ void getMFragmentType$annotations() {
    }

    private final List<String> getSelectedChatIds() {
        return getSelectedIdsByType(2);
    }

    private final List<String> getSelectedChatterIds() {
        return getSelectedIdsByType(1);
    }

    private final void showContactOwnerGroupFragment() {
        final P r2 = null;
        showFragment$default(this, 5, null, 2, null);
        BasePicker.OnPickerParamsLoader<P> r0 = getMOnPickerParamsLoader();
        if (r0 == null) goto L5;
        r2 = r0.onLoadPickerParams();
    L5:
        getMDefaultViewContainer().post(new RunnableC03401(r2, this));
    }

    private final void showTrustPartyFragment() {
        final P r2 = null;
        showFragment$default(this, 6, null, 2, null);
        BasePicker.OnPickerParamsLoader<P> r0 = getMOnPickerParamsLoader();
        if (r0 == null) goto L5;
        r2 = r0.onLoadPickerParams();
    L5:
        getMDefaultViewContainer().post(new RunnableC03421(this, r2));
    }

    private final void showUserGroupFragment() {
        showFragment$default(this, 9, null, 2, null);
        getMDefaultViewContainer().post(new RunnableC03431(this));
    }

    @Override // com.ss.android.lark.picker.base.widget.BasePicker
    public void attachComplete() {
        attachComplete(true);
    }

    public final void showScenarioEntries() {
        showFragment$default(this, 10, null, 2, null);
    }

    public final void showScenarioPermissionGroupList() {
        showFragment$default(this, 12, null, 2, null);
    }

    public final void showScenarioPersonnelTypeList() {
        showFragment$default(this, 11, null, 2, null);
    }

    private final List<String> getSelectedDepartmentIds() {
        return getSelectedIdsByType(17);
    }

    private final List<String> getSelectedEmailContactIds() {
        return getSelectedIdsByType(16);
    }

    private final BaseFragment getUserGroupFragment() {
        return (BaseFragment) this.userGroupFragment$delegate.getValue();
    }

    private final void initFragmentForCustomer() {
        this.mCustomerContactFragment = this.mIContactHomeController.init(true, getMIsMultiple(), false, new C03361(this)).asFragment();
    }

    private final void initFragmentForEmailContact() {
        this.mEmailContactFragment = this.mIEmailContactController.init(true, getMIsMultiple(), getMIsMultiple(), this.mPickType, new C03371(this)).asFragment();
    }

    private final BaseFragment initUserGroupFragment() {
        BaseFragment r0 = this.userGroupController.init(this.userGroupSceneType, false, getMIsMultiple(), new AbsChatterPicker$initUserGroupFragment$fragment$1(this)).asFragment();
        this.userGroupController.setOnOperationListener(new C03391(this));
        return r0;
    }

    private final void showScenarioEntriesWithExitAnimation() {
        int r0 = this.mFragmentType;
        if (r0 != 11) goto L5;
        BaseFragment r1 = this.mScenarioPersonnelTypeListFragment;
    L9:
        this.mFragmentType = 10;
        if (r1 == null) goto L14;
        BaseFragment r2 = this.mScenarioEntriesFragment;
        if (r2 == null) goto L14;
        switchFragmentWithAnimations(r1, r2, 2130772335, 2130772645);
    L14:
        Function1<? super Integer, Unit> r3 = this.onFragmentTypeChangeListener;
        if (r3 == null) goto L18;
        r3.invoke(10);
        return;
    L18:
        return;
    L5:
        if (r0 == 12) goto L7;
        r1 = null;
        goto L9
    L7:
        r1 = this.mScenarioPermissionGroupListFragment;
        goto L9
    }

    public final Department getCurDepartment() {
        return this.mIDepartmentDetailController.getCurDepartment();
    }

    public final void refreshCurrentDepartment() {
        this.mIDepartmentDetailController.refreshCurrentDepartment();
    }

    @Override // com.ss.android.lark.picker.base.widget.BasePicker
    public void refreshDefault() {
        PersonnelTypeListFragment r1 = null;
        PermissionGroupListFragment r2 = null;
        switch(this.mFragmentType) {
            case 2: goto L23;
            case 3: goto L22;
            case 4: goto L36;
            case 5: goto L19;
            case 6: goto L18;
            case 7: goto L17;
            case 8: goto L16;
            case 9: goto L15;
            case 10: goto L36;
            case 11: goto L10;
            case 12: goto L5;
            default: goto L36;
        };
    L5:
        BaseFragment r0 = this.mScenarioPermissionGroupListFragment;
        if ((r0 instanceof PermissionGroupListFragment) == false) goto L8;
        r2 = (PermissionGroupListFragment) r0;
    L8:
        if (r2 == null) goto L25;
        r2.refreshSelectedState();
        return;
    L25:
        return;
    L10:
        BaseFragment r3 = this.mScenarioPersonnelTypeListFragment;
        if ((r3 instanceof PersonnelTypeListFragment) == false) goto L13;
        r1 = (PersonnelTypeListFragment) r3;
    L13:
        if (r1 == null) goto L27;
        r1.refreshSelectedState();
        return;
    L27:
        return;
    L15:
        this.userGroupController.setSelectedUserGroup(getSelectedGroupIds());
        return;
    L16:
        this.mIEmailContactController.updateSelectedView(getSelectedEmailContactIds());
        return;
    L17:
        this.mIEmailContactController.updateSelectedView(getSelectedEmailContactIds());
        return;
    L18:
        this.mTrustPartyController.setSelectedChatters(getSelectedChatterIds());
        return;
    L19:
        PickerWidgetModuleDependency.IPickerWidgetModuleDependency.IContactsOwnerGroupController r4 = this.mContactsOwnerGroupController;
        if (r4 == null) goto L33;
        r4.setSelectChatIds(getSelectedChatIds());
        return;
    L33:
        return;
    L22:
        this.mIContactHomeController.updateSelectedView(getSelectedChatterIds());
        return;
    L23:
        this.mIDepartmentDetailController.setSelectedChatters(getSelectedChatterIds());
        this.mIDepartmentDetailController.setSelectedDepartment(getSelectedDepartmentIds());
        return;
    }

    private final List<String> getSelectedGroupIds() {
        return getSelectedIdsByType(100000028);
    }

    public final boolean isCheckOrgOUPermission() {
        List<ActionType> r0 = getPermissions();
        if (r0 == null) goto L5;
        Iterator<ActionType> r1 = r0.iterator();
    L8:
        if (r1.hasNext() == false) goto L17;
        ActionType r2 = r1.next();
        if (r2 == ActionType.INVITE_SAME_CHAT) goto L15;
        if (r2 == ActionType.INVITE_SAME_CRYPTO_CHAT) goto L24;
        if (r2 != ActionType.INVITE_SAME_CROSS_TENANT_CHAT) goto L8;
        return true;
    L24:
        return true;
    L15:
        return true;
    L17:
        return false;
    L5:
        return this.mIsCheckOrgOUPermission;
    }

    @Override // com.ss.android.lark.picker.base.widget.BasePicker
    public boolean onBackPressed() {
        if (getMIsSearch() == false) goto L6;
        BasePicker.defaultMode$default(this, false, 1, null);
        return false;
    L6:
        int r0 = this.mFragmentType;
        if (r0 != 1) goto L10;
        return true;
    L10:
        if (r0 != 2) goto L14;
        this.mIDepartmentDetailController.backToPreviousDepartment();
        return false;
    L14:
        if (r0 != 3) goto L17;
        return true;
    L17:
        if (r0 != 5) goto L21;
        showFragment$default(this, 1, null, 2, null);
        return false;
    L21:
        if (r0 != 6) goto L25;
        this.mTrustPartyController.backToPreviousDepartment();
        return false;
    L25:
        if (r0 != 9) goto L29;
        showFragment$default(this, 1, null, 2, null);
        return false;
    L29:
        if (r0 != 11) goto L33;
        showScenarioEntriesWithExitAnimation();
        return false;
    L33:
        if (r0 != 12) goto L36;
        showScenarioEntriesWithExitAnimation();
        return false;
    L36:
        return true;
    }

    public final boolean getAddChatterFromDepartmentBySearch() {
        return this.addChatterFromDepartmentBySearch;
    }

    public final int getFragmentType() {
        return this.mFragmentType;
    }

    public final boolean getMHasEnterpriseEmail() {
        return this.mHasEnterpriseEmail;
    }

    public final PickerWidgetModuleDependency.IPickerWidgetModuleDependency.IContactsSelectorController getMIContactsSelectorController() {
        return this.mIContactsSelectorController;
    }

    public final boolean getMIsDepartmentSelectableWhenVisible() {
        return this.mIsDepartmentSelectableWhenVisible;
    }

    public final Boolean getMIsGroupSearchableWhenVisible() {
        return this.mIsGroupSearchableWhenVisible;
    }

    public final Function1<Integer, Unit> getOnFragmentTypeChangeListener() {
        return this.onFragmentTypeChangeListener;
    }

    public AbsChatterPicker(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    public static final /* synthetic */ long access$getAppreciableRptFirstRenderCost$p(AbsChatterPicker r2) {
        return r2.appreciableRptFirstRenderCost;
    }

    public static final /* synthetic */ long access$getAppreciableRptInitViewCost$p(AbsChatterPicker r2) {
        return r2.appreciableRptInitViewCost;
    }

    public static final /* synthetic */ long access$getAppreciableRptInitViewStart$p(AbsChatterPicker r2) {
        return r2.appreciableRptInitViewStart;
    }

    public static final /* synthetic */ String access$getAppreciableRptKey$p(AbsChatterPicker r0) {
        return r0.appreciableRptKey;
    }

    public static final /* synthetic */ PickerWidgetModuleDependency.IPickerWidgetModuleDependency.IContactsOwnerGroupController access$getMContactsOwnerGroupController$p(AbsChatterPicker r0) {
        return r0.mContactsOwnerGroupController;
    }

    public static final /* synthetic */ boolean access$getMDisableExternalChatter$p(AbsChatterPicker r0) {
        return r0.mDisableExternalChatter;
    }

    public static final /* synthetic */ PickerWidgetModuleDependency.IPickerWidgetModuleDependency.IDepartmentDetailController access$getMIDepartmentDetailController$p(AbsChatterPicker r0) {
        return r0.mIDepartmentDetailController;
    }

    public static final /* synthetic */ PickerWidgetModuleDependency.IPickerWidgetModuleDependency.IEmailContactController access$getMIEmailContactController$p(AbsChatterPicker r0) {
        return r0.mIEmailContactController;
    }

    public static final /* synthetic */ PickerWidgetModuleDependency.IPickerWidgetModuleDependency.IDepartmentDetailController access$getMTrustPartyController$p(AbsChatterPicker r0) {
        return r0.mTrustPartyController;
    }

    public static final /* synthetic */ List access$getSelectedChatIds(AbsChatterPicker r0) {
        return r0.getSelectedChatIds();
    }

    public static final /* synthetic */ List access$getSelectedChatterIds(AbsChatterPicker r0) {
        return r0.getSelectedChatterIds();
    }

    public static final /* synthetic */ List access$getSelectedDepartmentIds(AbsChatterPicker r0) {
        return r0.getSelectedDepartmentIds();
    }

    public static final /* synthetic */ List access$getSelectedEmailContactIds(AbsChatterPicker r0) {
        return r0.getSelectedEmailContactIds();
    }

    public static final /* synthetic */ List access$getSelectedGroupIds(AbsChatterPicker r0) {
        return r0.getSelectedGroupIds();
    }

    public static final /* synthetic */ PickerWidgetModuleDependency.IPickerWidgetModuleDependency.IUserGroupController access$getUserGroupController$p(AbsChatterPicker r0) {
        return r0.userGroupController;
    }

    public static final /* synthetic */ void access$initFragmentForEmailContact(AbsChatterPicker r0) {
        r0.initFragmentForEmailContact();
    }

    public static final /* synthetic */ BaseFragment access$initUserGroupFragment(AbsChatterPicker r0) {
        return r0.initUserGroupFragment();
    }

    public static final /* synthetic */ void access$showContactOwnerGroupFragment(AbsChatterPicker r0) {
        r0.showContactOwnerGroupFragment();
    }

    public static final /* synthetic */ void access$showTrustPartyFragment(AbsChatterPicker r0) {
        r0.showTrustPartyFragment();
    }

    public static final /* synthetic */ void access$showUserGroupFragment(AbsChatterPicker r0) {
        r0.showUserGroupFragment();
    }

    private final SearchMailContactInfo parseChatterViewDataFromContact(EmailContact r6) {
        MailContactMeta.ContactType r0 = MailContactMeta.ContactType.NAME_CARD;
        if (r6.getType() == 0) goto L5;
        r0 = MailContactMeta.ContactType.fromValue(r6.getType());
    L5:
        String r2 = r6.a;
        String r3 = "";
        if (r2 != null) goto L8;
        r2 = "";
    L8:
        String r4 = r6.d;
        if (r4 != null) goto L11;
        r4 = "";
    L11:
        SearchMailContactInfo r1 = new SearchMailContactInfo(r2, r4, r0);
        String r5 = r6.a;
        if (r5 != null) goto L16;
        r5 = r6.d;
        if (r5 != null) goto L16;
    L17:
        r1.setId(r3);
        r1.setAvatarKey(r6.b);
        r1.setTitle(r6.c);
        r1.setSubTitle(r6.d);
        return r1;
    L16:
        r3 = r5;
        goto L17
    }

    private final void showDepartmentDetailFragment(final String r4) {
        showFragment(2, r4);
        BasePicker.OnPickerParamsLoader<P> r0 = getMOnPickerParamsLoader();
        if (r0 == null) goto L5;
        final P r1 = r0.onLoadPickerParams();
    L6:
        getMDefaultViewContainer().post(new RunnableC03411(this, r1, r4));
        return;
    L5:
        r1 = null;
        goto L6
    }

    private final void showScenarioSubPage(BaseFragment r4) {
        BaseFragment r0 = this.mScenarioEntriesFragment;
        if (r0 == null) goto L6;
        switchFragmentWithAnimations(r0, r4, 2130772644, 2130772335);
        return;
    }

    public final AbsChatterPicker<P, PK> attachAddChatterFromChat(boolean r1) {
        this.addChatterFromChatBySearch = r1;
        this.addChatterFromChatByOrganization = r1;
        return this;
    }

    public final AbsChatterPicker<P, PK> attachAddChatterFromChatAndDepartment(boolean r1) {
        this.addChatterFromChatBySearch = r1;
        this.addChatterFromChatByOrganization = r1;
        this.addChatterFromDepartmentBySearch = r1;
        this.addChatterFromDepartmentByOrganization = r1;
        return this;
    }

    public final AbsChatterPicker<P, PK> attachAddChatterFromChatByOrganization(boolean r1) {
        this.addChatterFromChatByOrganization = r1;
        return this;
    }

    public final AbsChatterPicker<P, PK> attachAddChatterFromChatBySearch(boolean r1) {
        this.addChatterFromChatBySearch = r1;
        return this;
    }

    public final AbsChatterPicker<P, PK> attachAddChatterFromDepartment(boolean r1) {
        this.addChatterFromDepartmentBySearch = r1;
        this.addChatterFromDepartmentByOrganization = r1;
        return this;
    }

    public final AbsChatterPicker<P, PK> attachAddChatterFromDepartmentByOrganization(boolean r1) {
        this.addChatterFromDepartmentByOrganization = r1;
        return this;
    }

    public final AbsChatterPicker<P, PK> attachAddChatterFromDepartmentBySearch(boolean r1) {
        this.addChatterFromDepartmentBySearch = r1;
        return this;
    }

    public final void attachComplete(boolean r5) {
        attachOnPickerNotify(new AnonymousClass1(this));
        super.attachComplete();
        if (r5 == false) goto L5;
        initOrganizationFragment$default(this, null, null, 3, null);
        initOrgItemConsumer(2);
    L5:
        defaultMode(getMSoftInputInitPopup());
        this.appreciableRptInitViewCost = System.currentTimeMillis() - this.appreciableRptInitViewStart;
        Log.d(TAG, "appreciableRptInitViewCost: " + this.appreciableRptInitViewCost + '.');
        post(new AnonymousClass2(this));
    }

    public final PK attachCustomBusiness(ICustomBusiness<?> r2) {
        Intrinsics.checkNotNullParameter(r2, "customBusiness");
        this.mBusinessExtensions.add(r2);
        return self();
    }

    public final AbsChatterPicker<P, PK> attachDisableChatter(boolean r1) {
        this.mDisableSearchChatter = r1;
        return this;
    }

    public final PK attachHasEnterpriseEmail(boolean r1) {
        this.mHasEnterpriseEmail = r1;
        return self();
    }

    public final PK attachInitDepartmentId(String r1) {
        if (r1 != null) goto L4;
        r1 = "";
    L4:
        this.mInitDepartmentId = r1;
        return self();
    }

    public final PK attachIsCheckOrgOUPermission(boolean r1) {
        this.mIsCheckOrgOUPermission = r1;
        return self();
    }

    public final PK attachIsDepartmentSelectableWhenVisible(boolean r1) {
        this.mIsDepartmentSelectableWhenVisible = r1;
        return self();
    }

    public final PK attachIsEmailContactEnabled(boolean r1) {
        this.mIsEmailContactEnabled = r1;
        return self();
    }

    public final PK attachIsEmailSharedAccountEnabled(boolean r1) {
        this.mIsEmailSharedAccountEnabled = r1;
        return self();
    }

    public final PK attachIsExternalContactEnabled(boolean r1) {
        this.mIsExternalContactEnabled = r1;
        return self();
    }

    public final PK attachIsGroupSearchableWhenVisible(boolean r1) {
        this.mIsGroupSearchableWhenVisible = Boolean.valueOf(r1);
        return self();
    }

    public final PK attachIsShowDepartment(boolean r1) {
        this.mIsShowDepartment = r1;
        return self();
    }

    public final PK attachIsShowMineGroupItem(boolean r1) {
        this.mIsShowMineGroupItem = r1;
        return self();
    }

    public final PK attachIsShowOwnerGroupItem(boolean r1) {
        this.mIsShowOwnerGroup = r1;
        return self();
    }

    public final PK attachIsShowTrustParty(boolean r1) {
        this.mIsShowTrustParty = r1;
        return self();
    }

    @Override // com.ss.android.lark.picker.base.widget.BasePicker
    public PK attachOnBusinessConsumeItem(SearchResultView.IOnBusinessConsumeItem r2) {
        return (PK) attachOnBusinessConsumeItem(r2, true);
    }

    public final AbsChatterPicker<P, PK> attachSearchOuterGroupChat(boolean r1) {
        this.mSearchOuterGroupChat = Boolean.valueOf(r1);
        return this;
    }

    public final PK attachUserGroup(UserGroupScene r2) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        this.userGroupSceneType = r2;
        return self();
    }

    public final void initOrgItemConsumer(int r5) {
        PickerWidgetModuleDependency.IPickerWidgetModuleDependency.IContactsOwnerGroupController r0 = this.mContactsOwnerGroupController;
        if (r0 == null) goto L5;
        r0.setItemCustomizer(new CommonItemCustomizer(r5, getItemConsumeDelegate(), C03381.INSTANCE));
    L5:
        PickerWidgetModuleDependency.IPickerWidgetModuleDependency.IDepartmentDetailController r1 = this.mIDepartmentDetailController;
        r1.setPersonItemCustomizer(new CommonItemCustomizer(r5, getItemConsumeDelegate(), AbsChatterPicker$initOrgItemConsumer$2$1.INSTANCE));
        r1.setDepartmentItemCustomizer(new CommonItemCustomizer(r5, getItemConsumeDelegate(), AbsChatterPicker$initOrgItemConsumer$2$2.INSTANCE));
        PickerWidgetModuleDependency.IPickerWidgetModuleDependency.IDepartmentDetailController r2 = this.mTrustPartyController;
        r2.setPersonItemCustomizer(new CommonItemCustomizer(r5, getItemConsumeDelegate(), AbsChatterPicker$initOrgItemConsumer$3$1.INSTANCE));
        r2.setDepartmentItemCustomizer(new CommonItemCustomizer(r5, getItemConsumeDelegate(), AbsChatterPicker$initOrgItemConsumer$3$2.INSTANCE));
    }

    public final boolean isScenarioItemSelected(SearchBaseInfo r5) {
        Intrinsics.checkNotNullParameter(r5, "data");
        List<SearchBaseInfo> r0 = getSelectedList();
        if ((r0 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r1 = r0.iterator();
    L9:
        if (r1.hasNext() == false) goto L18;
        if (Intrinsics.areEqual(((SearchBaseInfo) r1.next()).getId(), r5.getId()) == false) goto L9;
        return true;
    L18:
        return false;
    L5:
        if (r0.isEmpty() == false) goto L7;
        return false;
    }

    public final void setAddChatterFromChat(boolean r2) {
        this.addChatterFromChatBySearch = r2;
        this.addChatterFromChatByOrganization = r2;
        PickType r0 = this.mPickType;
        r0.setEnablePickChat(r2);
        this.mIDepartmentDetailController.setPickType(r0);
        PickerWidgetModuleDependency.IPickerWidgetModuleDependency.IContactsOwnerGroupController r3 = this.mContactsOwnerGroupController;
        if (r3 == null) goto L6;
        r3.setPickType(r0);
        return;
    }

    public final void setAddChatterFromChatAndDepartment(boolean r2) {
        this.addChatterFromChatBySearch = r2;
        this.addChatterFromDepartmentBySearch = r2;
        this.addChatterFromChatByOrganization = r2;
        this.addChatterFromDepartmentByOrganization = r2;
        PickType r0 = this.mPickType;
        r0.setEnablePickChat(r2);
        r0.setEnablePickDepartment(this.addChatterFromDepartmentByOrganization);
        this.mIDepartmentDetailController.setPickType(r0);
        PickerWidgetModuleDependency.IPickerWidgetModuleDependency.IContactsOwnerGroupController r3 = this.mContactsOwnerGroupController;
        if (r3 == null) goto L6;
        r3.setPickType(r0);
        return;
    }

    public final void setAddChatterFromDepartment(boolean r2) {
        this.addChatterFromDepartmentBySearch = r2;
        this.addChatterFromDepartmentByOrganization = r2;
        PickType r0 = this.mPickType;
        r0.setEnablePickDepartment(r2);
        this.mIDepartmentDetailController.setPickType(r0);
        PickerWidgetModuleDependency.IPickerWidgetModuleDependency.IContactsOwnerGroupController r3 = this.mContactsOwnerGroupController;
        if (r3 == null) goto L6;
        r3.setPickType(r0);
        return;
    }

    public final void setAddChatterFromDepartmentBySearch(boolean r1) {
        this.addChatterFromDepartmentBySearch = r1;
    }

    @Deprecated(message = "Replace by setDisableExternalChatterV2")
    public final void setDisableExternalChatter(boolean r3) {
        this.mDisableExternalChatter = r3;
        disableExternalChatter(r3);
        this.mIDepartmentDetailController.setDisableOutChatter(this.mDisableExternalChatter);
        this.mIContactsSelectorController.changeExternalContactVisibility(!r3);
    }

    public final void setDisableExternalChatterV2(boolean r3) {
        this.mDisableExternalChatter = r3;
        disableExternalChatter(r3);
        this.mIDepartmentDetailController.setDisableOutChatter(this.mDisableExternalChatter);
        this.mIContactsSelectorController.changeSectionVisibility(1040, !r3);
    }

    public final void setMHasEnterpriseEmail(boolean r1) {
        this.mHasEnterpriseEmail = r1;
    }

    public final void setMIsDepartmentSelectableWhenVisible(boolean r1) {
        this.mIsDepartmentSelectableWhenVisible = r1;
    }

    public final void setMIsGroupSearchableWhenVisible(Boolean r1) {
        this.mIsGroupSearchableWhenVisible = r1;
    }

    public final void setOnFragmentTypeChangeListener(Function1<? super Integer, Unit> r1) {
        this.onFragmentTypeChangeListener = r1;
    }

    public final PK setRelatedContactsInfoList(List<? extends SearchBaseInfo> r2) {
        Intrinsics.checkNotNullParameter(r2, "relatedContactsInfoList");
        this.relatedContactsInfoList = r2;
        return self();
    }

    public boolean spotLightSupportable(P r5) {
        if (FG.enable$default(FG.FG_SPOTLIGHT, false, 2, null) == true) goto L5;
        return false;
    L5:
        if (r5 != null) goto L7;
    L9:
        boolean r6 = false;
    L10:
        if (r6 == false) goto L14;
        return true;
    L14:
        return false;
    L7:
        if (r5.enableSpotLight() != true) goto L9;
        r6 = true;
        goto L10
    }

    @Override // com.ss.android.lark.picker.base.widget.BasePicker
    public /* bridge */ /* synthetic */ boolean spotLightSupportable(BasePickerParams r1) {
        return spotLightSupportable((ChatterPickerParams) r1);
    }

    public AbsChatterPicker(Context r8, AttributeSet r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        super(r8, r9);
        this.mPickType = new PickType();
        this.mIContactHomeController = PickerWidgetModuleDependency.getDependency().getContactHomeController();
        this.mIEmailContactController = PickerWidgetModuleDependency.getDependency().getEmailContactController();
        this.mIContactsSelectorController = PickerWidgetModuleDependency.getDependency().getContactsSelectorController();
        this.mIDepartmentDetailController = PickerWidgetModuleDependency.getDependency().getDepartmentDetailController();
        this.mTrustPartyController = PickerWidgetModuleDependency.getDependency().getDepartmentDetailController();
        this.mContactsOwnerGroupController = PickerWidgetModuleDependency.getDependency().getContactsOwnerGroupController();
        this.userGroupController = PickerWidgetModuleDependency.getDependency().getUserGroupController();
        this.userGroupFragment$delegate = LazyKt.lazy(new AbsChatterPicker$userGroupFragment$2(this));
        this.mIsShowDepartment = true;
        this.relatedContactsInfoList = new ArrayList();
        this.mFragmentType = 1;
        String r0 = "";
        this.mInitDepartmentId = "";
        this.mSelfId = "";
        this.appreciableRptInitViewCost = -1;
        this.appreciableRptInitViewStart = System.currentTimeMillis();
        this.appreciableRptFirstRenderCost = -1;
        this.userGroupSceneType = UserGroupScene.NONE;
        this.mBusinessExtensions = new LinkedHashSet();
        this.mIsCheckOrgOUPermission = true;
        Log.d(TAG, "constructor, AbsChatterPicker.");
        this.appreciableRptKey = AppreciableKit.Companion.getInstance().start(Biz.Messenger, Scene.Picker, Event.enter_picker, "", false);
        this.mContext = r8;
        String r10 = PickerWidgetModuleDependency.getDependency().getSelfId();
        if (r10 == null) goto L6;
        r0 = r10;
    L6:
        this.mSelfId = r0;
    }

    public static final /* synthetic */ void access$setAppreciableRptFirstRenderCost$p(AbsChatterPicker r0, long r1) {
        r0.appreciableRptFirstRenderCost = r1;
    }

    public static final /* synthetic */ void access$showDepartmentDetailFragment(AbsChatterPicker r0, String r1) {
        r0.showDepartmentDetailFragment(r1);
    }

    private final void initFragmentForBusiness(Long r23, PickerTracker r24) {
        this.mIContactsSelectorController.init(r23, r24, false, this.mIsShowMineGroupItem, this.mIsShowOwnerGroup, false, false, this.mIsExternalContactEnabled, this.mIsShowDepartment, this.mIsShowTrustParty, this.mIsEmailContactEnabled, this.mIsEmailSharedAccountEnabled, this.userGroupSceneType, UIUtils.getString(this.mContext, 2131891643), new AbsChatterPicker$initFragmentForBusiness$onContactsSelectorClickListener$1(this), new AbsChatterPicker$initFragmentForBusiness$onContactsSelectorViewDataListener$1(), this.relatedContactsInfoList, new AbsChatterPicker$initFragmentForBusiness$onContactsSelectorItemClickHandler$1(this));
        Set<ICustomBusiness<?>> r1 = this.mBusinessExtensions;
        ArrayList r2 = new ArrayList();
        Iterator<T> r3 = r1.iterator();
    L4:
        if (r3.hasNext() == false) goto L8;
        Object r4 = r3.next();
        if ((r4 instanceof ContactsSelectorBusiness) == false) goto L4;
        r2.add(r4);
        goto L4
    L8:
        Iterator r5 = r2.iterator();
    L10:
        if (r5.hasNext() == false) goto L12;
        ((ContactsSelectorBusiness) r5.next()).applyTo2(this.mIContactsSelectorController);
        goto L10
    L12:
        this.mContactsSelectorFragment = this.mIContactsSelectorController.asFragment();
        PickerWidgetModuleDependency.IPickerWidgetModuleDependency.IDepartmentDetailController.IOnOperationListener r6 = new AbsChatterPicker$initFragmentForBusiness$onDepartmentDetailOperationListener$1(this);
        PickerWidgetModuleDependency.IPickerWidgetModuleDependency.IContactsOwnerGroupController.IOnOperationListener r15 = new AbsChatterPicker$initFragmentForBusiness$groupOperationListener$1(this);
        BasePicker.OnPickerParamsLoader<P> r7 = getMOnPickerParamsLoader();
        BaseFragment r16 = null;
        if (r7 == null) goto L15;
        P r17 = r7.onLoadPickerParams();
    L16:
        PickType r8 = this.mPickType;
        r8.setEnablePickChatter(!this.mDisableSearchChatter);
        if (r17 == null) goto L19;
        boolean r9 = r17.needSearchOuterUser();
    L20:
        r8.setEnablePickExternalChatter(r9);
        r8.setEnablePickChat(this.addChatterFromChatByOrganization);
        boolean r18 = false;
        if (r17 == null) goto L23;
        boolean r10 = r17.enableExternalGroup();
    L24:
        r8.setEnablePickExternalChat(r10);
        if (r17 == null) goto L27;
        boolean r11 = r17.enableEmailContact();
    L28:
        r8.setEnableEmailContact(r11);
        if (this.mIsEmailSharedAccountEnabled == false) goto L35;
        if (r17 == null) goto L32;
        boolean r12 = r17.enableEmailSharedAccount();
    L33:
        if (r12 == false) goto L35;
        boolean r13 = true;
    L36:
        r8.setEnableEmailSharedAccount(r13);
        r8.setEnablePickDepartment(this.addChatterFromDepartmentByOrganization);
        if (r17 == null) goto L39;
        boolean r14 = r17.enablePublicGroup();
    L40:
        r8.setEnablePublicGroup(r14);
        if (r17 == null) goto L43;
        boolean r19 = r17.enableSecretGroup();
    L44:
        r8.setEnableSecretGroup(r19);
        if (r17 == null) goto L47;
        boolean r20 = r17.enableMeetingGroup();
    L48:
        r8.setEnableMeetingGroup(r20);
        PickerWidgetModuleDependency.IPickerWidgetModuleDependency.IDepartmentDetailController r21 = this.mIDepartmentDetailController;
        boolean r22 = getMIsMultiple();
        boolean r25 = isCheckOrgOUPermission();
        boolean r26 = !this.mIsDepartmentSelectableWhenVisible;
        List<ActionType> r27 = getPermissions();
        PickType r28 = this.mPickType;
        if (r17 == null) goto L51;
        boolean r110 = r17.ignoreSelf();
    L52:
        if (r17 == null) goto L54;
        boolean r29 = r17.needEnterpriseEmail();
    L55:
        if (r17 == null) goto L57;
        boolean r30 = r17.needPullEnterpriseEmailData();
    L58:
        this.mDepartmentDetailFragment = r21.init(r22, true, r28, r6, r25, r26, r27, true, r110, Boolean.valueOf(r29), Boolean.valueOf(r30), getMIsEnableChatPreview(), getExtras()).asFragment();
        PickerWidgetModuleDependency.IPickerWidgetModuleDependency.IDepartmentDetailController r31 = this.mTrustPartyController;
        boolean r32 = getMIsMultiple();
        List<ActionType> r33 = getPermissions();
        PickType r34 = this.mPickType;
        if (r17 == null) goto L61;
        boolean r111 = r17.ignoreSelf();
    L62:
        if (r17 == null) goto L64;
        r18 = r17.needPullEnterpriseEmailData();
    L64:
        this.mTrustPartyFragment = r31.init(r32, true, r34, r6, true, true, r33, true, r111, Boolean.FALSE, Boolean.valueOf(r18), getMIsEnableChatPreview(), getExtras()).setEnableChatPreview(getMIsEnableChatPreview()).asFragment();
        PickerWidgetModuleDependency.IPickerWidgetModuleDependency.IContactsOwnerGroupController r35 = this.mContactsOwnerGroupController;
        if (r35 == null) goto L73;
        PickerWidgetModuleDependency.IPickerWidgetModuleDependency.IContactsOwnerGroupController r36 = r35.init(getMIsMultiple(), this.mPickType, getExtras());
        if (r36 == null) goto L73;
        PickerWidgetModuleDependency.IPickerWidgetModuleDependency.IContactsOwnerGroupController r37 = r36.setGroupOperationListener(r15);
        if (r37 == null) goto L73;
        PickerWidgetModuleDependency.IPickerWidgetModuleDependency.IContactsOwnerGroupController r38 = r37.setEnableChatPreview(getMIsEnableChatPreview());
        if (r38 == null) goto L73;
        r16 = r38.asFragment();
    L73:
        this.mContactsOwnerGroupFragment = r16;
        return;
    L61:
        r111 = false;
        goto L62
    L57:
        r30 = false;
        goto L58
    L54:
        r29 = false;
        goto L55
    L51:
        r110 = false;
        goto L52
    L47:
        r20 = true;
        goto L48
    L43:
        r19 = true;
        goto L44
    L39:
        r14 = true;
        goto L40
    L32:
        r12 = false;
    L35:
        r13 = false;
        goto L36
    L27:
        r11 = false;
        goto L28
    L23:
        r10 = false;
        goto L24
    L19:
        r9 = true;
        goto L20
    L15:
        r17 = null;
        goto L16
    }

    @Deprecated(message = "onBusinessConsumeItem is Passed to child page by default, so this method is deprecated", replaceWith = @ReplaceWith(expression = "attachOnBusinessConsumeItem(SearchResultView.IOnBusinessConsumeItem?)", imports = {}))
    public PK attachOnBusinessConsumeItem(SearchResultView.IOnBusinessConsumeItem r1, boolean r2) {
        return (PK) super.attachOnBusinessConsumeItem(r1);
    }

    public final void initOrganizationFragment(Long r4, PickerTracker r5) {
        if (PickerWidgetModuleDependency.getDependency().isCustomer() == false) goto L5;
        initFragmentForCustomer();
        showFragment$default(this, 3, null, 2, null);
        return;
    L5:
        initFragmentForBusiness(r4, r5);
        if (TextUtils.isEmpty(this.mInitDepartmentId) == false) goto L8;
        showFragment$default(this, 1, null, 2, null);
        return;
    L8:
        showDepartmentDetailFragment(this.mInitDepartmentId);
    }

    public final void onScenarioItemSelectChanged(SearchBaseInfo r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "data");
        dealSelectAndDeselected(r2, r3, BasePicker.PickSourceType.CLICK);
    }

    public final void showFragment(int r7, String r8) {
        Intrinsics.checkNotNullParameter(r8, "targetId");
        this.mFragmentType = r7;
        int r0 = -1;
        String r1 = "public_picker_select_email_member_view";
        P r2 = null;
        boolean r3 = true;
        String r5 = "";
        switch(r7) {
            case 1: goto L81;
            case 2: goto L76;
            case 3: goto L75;
            case 4: goto L82;
            case 5: goto L74;
            case 6: goto L43;
            case 7: goto L29;
            case 8: goto L15;
            case 9: goto L14;
            case 10: goto L11;
            case 11: goto L8;
            case 12: goto L5;
            default: goto L82;
        };
    L5:
        BaseFragment r9 = this.mScenarioPermissionGroupListFragment;
        if (r9 == null) goto L82;
        showScenarioSubPage(r9);
        goto L82
    L8:
        BaseFragment r10 = this.mScenarioPersonnelTypeListFragment;
        if (r10 == null) goto L82;
        showScenarioSubPage(r10);
        goto L82
    L11:
        BaseFragment r11 = this.mScenarioEntriesFragment;
        if (r11 == null) goto L82;
        showFragment(r11);
        goto L82
    L14:
        showFragment(getUserGroupFragment());
        r1 = "public_picker_select_user_group_view";
    L84:
        if (r1.length() > 0) goto L87;
        r3 = false;
    L87:
        if (r3 == false) goto L89;
        PickerReporter.INSTANCE.viewReporter(r1);
    L89:
        Function1<? super Integer, Unit> r12 = this.onFragmentTypeChangeListener;
        if (r12 == null) goto L93;
        r12.invoke(Integer.valueOf(r7));
        return;
    L93:
        return;
    L15:
        BasePicker.OnPickerParamsLoader<P> r13 = getMOnPickerParamsLoader();
        if (r13 == null) goto L18;
        r2 = r13.onLoadPickerParams();
    L18:
        PickerWidgetModuleDependency.IPickerWidgetModuleDependency.IEmailContactController r14 = this.mIEmailContactController;
        if (r14 == null) goto L28;
        if (r2 == null) goto L22;
        r0 = r2.mailGroupRole();
    L22:
        if (r2 == null) goto L27;
        String r4 = r2.mailGroupId();
        if (r4 == null) goto L27;
        r5 = r4;
    L27:
        r14.setTargetMailGroupRole(r0, r5);
    L28:
        BaseFragment r15 = this.mEmailContactFragment;
        Intrinsics.checkNotNull(r15);
        showFragment(r15);
        goto L84
    L29:
        BasePicker.OnPickerParamsLoader<P> r16 = getMOnPickerParamsLoader();
        if (r16 == null) goto L32;
        r2 = r16.onLoadPickerParams();
    L32:
        PickerWidgetModuleDependency.IPickerWidgetModuleDependency.IEmailContactController r17 = this.mIEmailContactController;
        if (r17 == null) goto L42;
        if (r2 == null) goto L36;
        r0 = r2.mailGroupRole();
    L36:
        if (r2 == null) goto L41;
        String r6 = r2.mailGroupId();
        if (r6 == null) goto L41;
        r5 = r6;
    L41:
        r17.setTargetMailGroupRole(r0, r5);
    L42:
        BaseFragment r18 = this.mEmailContactFragment;
        Intrinsics.checkNotNull(r18);
        showFragment(r18);
        goto L84
    L43:
        BaseFragment r19 = this.mTrustPartyFragment;
        if (r19 == null) goto L46;
        Bundle r20 = r19.getArguments();
    L47:
        BasePicker.OnPickerParamsLoader<P> r21 = getMOnPickerParamsLoader();
        if (r21 == null) goto L50;
        r2 = r21.onLoadPickerParams();
    L50:
        if (r2 == null) goto L53;
        List<String> r22 = r2.chatIds();
        if (r22 == null) goto L53;
    L55:
        if ((!r22.isEmpty()) == true) goto L57;
    L63:
        if (r20 == null) goto L65;
        r20.putBoolean(KEY_IS_B2B_CONNECT, this.mIsShowTrustParty);
    L65:
        if (r20 == null) goto L67;
        r20.putBoolean(KEY_PICKER_B2B, true);
    L67:
        BaseFragment r23 = this.mTrustPartyFragment;
        if (r23 == null) goto L70;
        r23.setArguments(r20);
    L70:
        BaseFragment r24 = this.mTrustPartyFragment;
        if (r24 == null) goto L73;
        showFragment(r24);
    L73:
        r1 = "public_picker_select_associated_organizations_view";
        goto L84
    L57:
        if (((CharSequence) ListProtector.get(r22, 0)).length() <= 0) goto L59;
        boolean r25 = true;
    L60:
        if (r25 == false) goto L63;
        if (r20 == null) goto L63;
        r20.putString(KEY_CHAT_ID, (String) ListProtector.get(r22, 0));
        goto L63
    L59:
        r25 = false;
    L53:
        r22 = new ArrayList();
        goto L55
    L46:
        r20 = null;
        goto L47
    L74:
        BaseFragment r26 = this.mContactsOwnerGroupFragment;
        Intrinsics.checkNotNull(r26);
        showFragment(r26);
        r1 = "public_picker_select_manage_group_view";
        goto L84
    L75:
        BaseFragment r27 = this.mCustomerContactFragment;
        Intrinsics.checkNotNull(r27);
        showFragment(r27);
        goto L82
    L76:
        BaseFragment r28 = this.mDepartmentDetailFragment;
        Intrinsics.checkNotNull(r28);
        showFragment(r28);
        if (Intrinsics.areEqual(r8, EXTERNAL_STRUCT_DEPARTMENT_ID) == false) goto L79;
        String r29 = "public_picker_select_external_view";
    L80:
        r1 = r29;
        goto L84
    L79:
        r29 = "public_picker_select_architecture_member_view";
        goto L80
    L81:
        BaseFragment r30 = this.mContactsSelectorFragment;
        Intrinsics.checkNotNull(r30);
        showFragment(r30);
    L82:
        r1 = "";
        goto L84
    }

    @Override // com.ss.android.lark.picker.base.widget.BasePicker
    public void switchMultipleStatus(boolean r1, boolean r2) {
        super.switchMultipleStatus(r1, r2);
        if (PickerWidgetModuleDependency.getDependency().isCustomer() == false) goto L5;
        this.mIContactHomeController.switchMultiple(r1);
        return;
    L5:
        this.mIDepartmentDetailController.switchMultiple(r1);
        this.mIContactsSelectorController.switchMultiple(r1);
        this.userGroupController.switchMultiple(r1);
    }

    public SearchContext transformByPickerParams(SearchContext r4, P r5) {
        Intrinsics.checkNotNullParameter(r4, "searchContext");
        if (r5 != null) goto L5;
        r4.a(com.ss.android.lark.search.dto.Scene.Type.ADD_CHAT_CHATTERS);
    L35:
        return r4;
    L5:
        r5.onJobStatus();
        r4.getClass();
        if (r5.useChatterSearcher() == false) goto L10;
        r4.a(com.ss.android.lark.search.dto.Scene.Type.SEARCH_CHATTERS);
        r5.includeSecretP2pChat();
        r5.includeBot();
        r5.excludeWithoutChatUser();
        r5.excludeResignedUser();
        r4.g = r5.needSearchOuterUser();
        Intrinsics.checkNotNullParameter(this.userGroupSceneType, "<set-?>");
        r4.s = r5.excludeUnJoinedGroup();
        r5.searchScene();
        spotLightSupportable(r5);
        if (spotLightSupportable(r5) == false) goto L35;
        r5.tagName4Spotlight();
        goto L35
    L10:
        r4.a(com.ss.android.lark.search.dto.Scene.Type.ADD_CHAT_CHATTERS);
        r5.includeBot();
        ArrayList r0 = (ArrayList) r4.c;
        r0.clear();
        r0.addAll(r5.chatIds());
        r4.d = r5.checkOUPermission();
        r4.e = r5.checkSecretPermission();
        r4.g = r5.needSearchOuterUser();
        r4.h = r5.excludeOuterContact();
        r4.f = r5.checkCrossTenantAdminPermission();
        r4.m = r5.includeMailContact();
        r4.i = this.mDisableSearchChatter;
        r4.j = this.addChatterFromChatBySearch;
        r4.k = this.addChatterFromDepartmentBySearch;
        r4.l = this.mIsDepartmentSelectableWhenVisible;
        Intrinsics.checkNotNullParameter(this.userGroupSceneType, "<set-?>");
        Union r1 = r5.getOuterGroup();
        if (r1 != null) goto L22;
        Boolean r2 = this.mSearchOuterGroupChat;
        if (Intrinsics.areEqual(r2, Boolean.TRUE) == false) goto L16;
        r1 = Union.ALL;
        goto L22
    L16:
        if (Intrinsics.areEqual(r2, Boolean.FALSE) == false) goto L18;
        r1 = Union.NO;
        goto L22
    L18:
        if (r2 != null) goto L21;
        r1 = Union.NO;
        goto L22
    L21:
        throw new NoWhenBranchMatchedException();
    L22:
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        r4.o = r1;
        Boolean r3 = r5.getOnlyManageGroup();
        if (r3 == null) goto L25;
        boolean r6 = r3.booleanValue();
    L32:
        r4.n = r6;
        Intrinsics.checkNotNullParameter(r5.isInTeamId(), "<set-?>");
        r4.s = r5.excludeUnJoinedGroup();
        r5.getIncludeAI();
        r5.getMustHaveChatWithAI();
        spotLightSupportable(r5);
        if (spotLightSupportable(r5) == false) goto L35;
        r5.tagName4Spotlight();
        goto L35
    L25:
        Boolean r7 = this.mIsGroupSearchableWhenVisible;
        if (r7 == null) goto L28;
        boolean r8 = r7.booleanValue();
    L29:
        if (r8 == true) goto L31;
        r6 = true;
        goto L32
    L31:
        r6 = false;
        goto L32
    L28:
        r8 = false;
        goto L29
    }

    @Override // com.ss.android.lark.picker.base.widget.BasePicker
    public /* bridge */ /* synthetic */ SearchContext transformByPickerParams(SearchContext r1, BasePickerParams r2) {
        return transformByPickerParams(r1, (ChatterPickerParams) r2);
    }

    private final boolean onEmailContactPick(EmailContact r1, boolean r2, int r3) {
        SearchMailContactInfo r4 = parseChatterViewDataFromContact(r1);
        r4.setDataSource(DataSource.Type.RECOMMEND);
        r4.selected(!r2);
        r4.selected(r2);
        dealSelectAndDeselected(r4, r2, BasePicker.PickSourceType.CLICK);
        return true;
    }

    private final boolean onOwnerGroupItemPick(Chat r3, boolean r4, int r5) {
        Log.d(TAG, "position: " + r5);
        SearchChatInfo r0 = SearchCommonUtils.parseFromChatEntity(r3);
        r0.setDataSource(DataSource.Type.RECOMMEND);
        r0.selected(!r4);
        PickerReporter.INSTANCE.selectReporter(r3, r4, r5);
        r0.selected(r4);
        dealSelectAndDeselected(r0, r4, BasePicker.PickSourceType.CLICK);
        return true;
    }

    public final PK attachScenarioFragments(BaseFragment r2, BaseFragment r3, BaseFragment r4) {
        Intrinsics.checkNotNullParameter(r2, "entries");
        Intrinsics.checkNotNullParameter(r3, "personnelTypeList");
        Intrinsics.checkNotNullParameter(r4, "permissionGroupList");
        this.mScenarioEntriesFragment = r2;
        this.mScenarioPersonnelTypeListFragment = r3;
        this.mScenarioPermissionGroupListFragment = r4;
        return self();
    }

    public static final /* synthetic */ boolean access$onOwnerGroupItemPick(AbsChatterPicker r0, Chat r1, boolean r2, int r3) {
        return r0.onOwnerGroupItemPick(r1, r2, r3);
    }

    private final boolean onOrganizationChatterPick(Chatter r2, boolean r3, int r4, String r5) {
        DeniedReason r0 = DeniedReason.fromValue(r4);
        if (r0 == null) goto L5;
        List r1 = CollectionsKt.listOf(r0);
    L6:
        if (r5 != null) goto L8;
        r5 = "";
    L8:
        SearchChatterInfo r6 = SearchCommonUtils.parseFromChatterEntity(r2, r1, r5);
        r6.setFromOrganization(true);
        r6.setDeniedReason(r4);
        r6.selected(!r3);
        r6.setDataSource(DataSource.Type.RECOMMEND);
        r6.selected(r3);
        dealSelectAndDeselected(r6, r3, BasePicker.PickSourceType.CLICK);
        return true;
    L5:
        r1 = null;
        goto L6
    }

    public static final /* synthetic */ boolean access$onOrganizationChatterPick(AbsChatterPicker r0, Chatter r1, boolean r2, int r3, String r4) {
        return r0.onOrganizationChatterPick(r1, r2, r3, r4);
    }

    public static /* synthetic */ BasePicker attachOnBusinessConsumeItem$default(AbsChatterPicker r0, SearchResultView.IOnBusinessConsumeItem r1, boolean r2, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 2) == 0) goto L7;
        r2 = true;
    L7:
        return r0.attachOnBusinessConsumeItem(r1, r2);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: attachOnBusinessConsumeItem");
    }

    public static /* synthetic */ void initFragmentForBusiness$default(AbsChatterPicker r1, Long r2, PickerTracker r3, int r4, Object r5) {
        if (r5 != null) goto L12;
        if ((r4 & 1) == 0) goto L7;
        r2 = null;
    L7:
        if ((r4 & 2) == 0) goto L9;
        r3 = null;
    L9:
        r1.initFragmentForBusiness(r2, r3);
        return;
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: initFragmentForBusiness");
    }

    public static /* synthetic */ void initOrganizationFragment$default(AbsChatterPicker r1, Long r2, PickerTracker r3, int r4, Object r5) {
        if (r5 != null) goto L12;
        if ((r4 & 1) == 0) goto L7;
        r2 = null;
    L7:
        if ((r4 & 2) == 0) goto L9;
        r3 = null;
    L9:
        r1.initOrganizationFragment(r2, r3);
        return;
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: initOrganizationFragment");
    }

    private final boolean onOrganizationDepartmentPick(String r3, String r4, int r5, boolean r6, int r7) {
        SearchDepartmentInfo r0 = SearchCommonUtils.parseFromDepartmentId(r3);
        r0.setDataSource(DataSource.Type.RECOMMEND);
        r0.selected(!r6);
        PickerReporter.INSTANCE.selectReporter(r3, r6, r7);
        r0.selected(r6);
        r0.setTitle(r4);
        r0.setMemberCount(r5);
        dealSelectAndDeselected(r0, r6, BasePicker.PickSourceType.CLICK);
        return true;
    }

    private final boolean onUserGroupPick(String r2, String r3, int r4, boolean r5, int r6) {
        SearchUserGroupInfo r7 = SearchCommonUtils.parseFromUserGroupInfo(r2, r3, r4);
        r7.selected(!r5);
        PickerReporter.INSTANCE.selectUserGroupReporter(r2, r5, r6);
        r7.selected(r5);
        r7.setTitle(r3);
        dealSelectAndDeselected(r7, r5, BasePicker.PickSourceType.CLICK);
        return true;
    }

    public static /* synthetic */ void showFragment$default(AbsChatterPicker r0, int r1, String r2, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 2) == 0) goto L6;
        r2 = "";
    L6:
        r0.showFragment(r1, r2);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showFragment");
    }

    public static final /* synthetic */ boolean access$onOrganizationDepartmentPick(AbsChatterPicker r0, String r1, String r2, int r3, boolean r4, int r5) {
        return r0.onOrganizationDepartmentPick(r1, r2, r3, r4, r5);
    }

    public static final /* synthetic */ boolean access$onUserGroupPick(AbsChatterPicker r0, String r1, String r2, int r3, boolean r4, int r5) {
        return r0.onUserGroupPick(r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ boolean onEmailContactPick$default(AbsChatterPicker r0, EmailContact r1, boolean r2, int r3, int r4, Object r5) {
        if (r5 != null) goto L9;
        if ((r4 & 4) == 0) goto L7;
        r3 = 0;
    L7:
        return r0.onEmailContactPick(r1, r2, r3);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onEmailContactPick");
    }

    public static /* synthetic */ boolean onOrganizationChatterPick$default(AbsChatterPicker r0, Chatter r1, boolean r2, int r3, String r4, int r5, Object r6) {
        if (r6 != null) goto L12;
        if ((r5 & 4) == 0) goto L7;
        r3 = 0;
    L7:
        if ((r5 & 8) == 0) goto L10;
        r4 = null;
    L10:
        return r0.onOrganizationChatterPick(r1, r2, r3, r4);
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onOrganizationChatterPick");
    }
}
