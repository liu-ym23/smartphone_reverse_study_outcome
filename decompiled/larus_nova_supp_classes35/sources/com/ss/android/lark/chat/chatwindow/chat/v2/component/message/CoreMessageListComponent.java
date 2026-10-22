package com.ss.android.lark.chat.chatwindow.chat.v2.component.message;

import android.content.Intent;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.larksuite.component.ui.layout.LKUIRelativeLayout;
import com.ss.android.lark.biz.im.api.ChatWindowPrepareData;
import com.ss.android.lark.biz.im.api.extension.ImExtensionType;
import com.ss.android.lark.biz.im.api.extension.chat_window.ChatWindowMessageList;
import com.ss.android.lark.biz.im.api.extension.scroll.ScrollScene;
import com.ss.android.lark.biz.im.api.x0;
import com.ss.android.lark.chat.base.view.recycleview.ItemShineManager;
import com.ss.android.lark.chat.chatwindow.biz.component.ChatBaseComponent;
import com.ss.android.lark.chat.chatwindow.biz.component.keyboard.coordinate.SceneCoordinateRecyclerView;
import com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.cell.ListMode;
import com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender.TextLayoutRender;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.decoration.MessageListDecorationController;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.data.MessageListDataFeature;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.MessageListEventDispatchFeature;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.menu.MessageListMenuFeature;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.render.MessageListRendererFeature;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.scroll.MessageListScrollFeature;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.select.MessageListMultiSelectFeature$initMultiSelector$multiSelector$1;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.titlebar.viewmodel.TitlebarViewModel;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.v;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chat.entity.message.content.AudioContent;
import com.ss.android.lark.chat.message.menu.v2.MessageActionPanelManager;
import com.ss.android.lark.chat.message.menu.v2.i0;
import com.ss.android.lark.chat.message.menu.v2.popup.PopupMenu;
import com.ss.android.lark.chat.utils.MessagePermissionUtil;
import com.ss.android.lark.chatbase.BasePageStore;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.framework.larkwidget.Widget;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.recyclerview.MultiSelector;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import w4b.u;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u0088\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 ¿\u00022\u00020\u00012\u00020\u00022\u00020\u00032\b\u0012\u0004\u0012\u00020\u00050\u00042\u00020\u0006:\u0002¿\u0002B9\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020#H\u0016J\b\u0010+\u001a\u00020,H\u0016J\r\u0010-\u001a\u00020.H\u0016¢\u0006\u0002\u0010/J\b\u0010W\u001a\u00020%H\u0016J\u0010\u0010X\u001a\u00020%2\u0006\u0010Y\u001a\u00020ZH\u0002J\b\u0010[\u001a\u00020%H\u0016J\b\u0010\\\u001a\u00020%H\u0016J\b\u0010]\u001a\u00020%H\u0016J\b\u0010^\u001a\u00020%H\u0016J\u0010\u0010c\u001a\u00020%2\u0006\u0010d\u001a\u00020\u0005H\u0016J\u0010\u0010e\u001a\u00020%2\u0006\u0010d\u001a\u00020\u0005H\u0016J\b\u0010f\u001a\u00020%H\u0016J\b\u0010g\u001a\u00020%H\u0016J\n\u0010h\u001a\u0004\u0018\u00010iH\u0016J\n\u0010j\u001a\u0004\u0018\u00010kH\u0016J\u0010\u0010l\u001a\u00020%2\u0006\u0010m\u001a\u00020.H\u0016J\u001e\u0010l\u001a\u00020%2\u0006\u0010m\u001a\u00020.2\f\u0010d\u001a\b\u0012\u0004\u0012\u00020%0nH\u0016JJ\u0010o\u001a\u00020%2\u0006\u0010p\u001a\u00020q2\u0006\u0010r\u001a\u00020.2\u0006\u0010s\u001a\u00020,2\u0006\u0010t\u001a\u00020,2\b\u0010u\u001a\u0004\u0018\u00010v2\u0016\u0010w\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010y\u0012\u0004\u0012\u00020,\u0018\u00010xH\u0016J\u0010\u0010z\u001a\u00020%2\u0006\u0010p\u001a\u00020qH\u0016J\u0010\u0010{\u001a\u00020%2\u0006\u0010p\u001a\u00020qH\u0016J\f\u0010|\u001a\u00020,*\u00020kH\u0002J\u0010\u0010}\u001a\u00020%2\u0006\u0010u\u001a\u00020~H\u0016J\u0010\u0010\u007f\u001a\u00020%2\u0006\u0010u\u001a\u00020~H\u0016J\u000b\u0010\u0080\u0001\u001a\u0004\u0018\u00010kH\u0016J'\u0010\u0081\u0001\u001a\u00020%2\u001c\u0010\u0082\u0001\u001a\u0017\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020!0 \u0012\u0004\u0012\u00020!0\u0083\u0001H\u0016J\u0012\u0010\u0084\u0001\u001a\u00020%2\u0007\u0010u\u001a\u00030\u0085\u0001H\u0016J\u0012\u0010\u0086\u0001\u001a\u00020%2\u0007\u0010u\u001a\u00030\u0087\u0001H\u0016J\u0012\u0010\u0088\u0001\u001a\u00020%2\u0007\u0010u\u001a\u00030\u0087\u0001H\u0016J\u0012\u0010\u0089\u0001\u001a\u00020%2\u0007\u0010u\u001a\u00030\u008a\u0001H\u0016J\u0012\u0010\u008b\u0001\u001a\u00020%2\u0007\u0010u\u001a\u00030\u008c\u0001H\u0016J\u0012\u0010\u008d\u0001\u001a\u00020%2\u0007\u0010u\u001a\u00030\u008e\u0001H\u0016J\u0012\u0010\u008f\u0001\u001a\u00020%2\u0007\u0010u\u001a\u00030\u008e\u0001H\u0016J\u0012\u0010\u0090\u0001\u001a\u00020%2\u0007\u0010u\u001a\u00030\u0091\u0001H\u0016J\u0012\u0010\u0092\u0001\u001a\u00020%2\u0007\u0010u\u001a\u00030\u0091\u0001H\u0016J\u0013\u0010\u0093\u0001\u001a\u00020%2\b\u0010\u0094\u0001\u001a\u00030\u0095\u0001H\u0016J\u001c\u0010\u0096\u0001\u001a\u00020%2\u0011\u0010u\u001a\r\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001b0\u0097\u0001H\u0016J\u001c\u0010\u0098\u0001\u001a\u00020%2\u0011\u0010u\u001a\r\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001b0\u0097\u0001H\u0016J\t\u0010\u0099\u0001\u001a\u00020,H\u0016J\t\u0010\u009a\u0001\u001a\u00020,H\u0016J\t\u0010\u009b\u0001\u001a\u00020,H\u0016J\u0013\u0010\u009c\u0001\u001a\u00020%2\b\u0010\u009d\u0001\u001a\u00030\u009e\u0001H\u0016J+\u0010\u009f\u0001\u001a\u00020%2\u000f\u0010 \u0001\u001a\n\u0012\u0005\u0012\u00030¢\u00010¡\u00012\u000f\u0010£\u0001\u001a\n\u0012\u0005\u0012\u00030\u009e\u00010¤\u0001H\u0016J'\u0010¥\u0001\u001a\u00020%2\u001c\u0010¦\u0001\u001a\u0017\u0012\u0013\u0012\u0011\u0012\u0005\u0012\u00030¢\u0001\u0012\u0005\u0012\u00030\u009e\u00010§\u00010\u001aH\u0016J\u0019\u0010¨\u0001\u001a\u00020%2\u000e\u0010©\u0001\u001a\t\u0012\u0005\u0012\u00030¢\u00010\u001aH\u0016J\u0012\u0010¨\u0001\u001a\u00020%2\u0007\u0010ª\u0001\u001a\u00020.H\u0016J\u0013\u0010«\u0001\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001b0\u001aH\u0016J\u0016\u0010¬\u0001\u001a\u0005\u0018\u00010\u009e\u00012\b\u0010\u00ad\u0001\u001a\u00030¢\u0001H\u0016J!\u0010®\u0001\u001a\t\u0012\u0005\u0012\u00030\u009e\u00010\u001a2\u000f\u0010¯\u0001\u001a\n\u0012\u0005\u0012\u00030¢\u00010°\u0001H\u0016J\u0013\u0010±\u0001\u001a\u00020%2\b\u0010²\u0001\u001a\u00030³\u0001H\u0016J\t\u0010´\u0001\u001a\u00020%H\u0016J\u0012\u0010µ\u0001\u001a\u00020.2\u0007\u0010¶\u0001\u001a\u00020.H\u0016J\u0013\u0010·\u0001\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001b0\u001aH\u0016J%\u0010¸\u0001\u001a\u00020%2\u0007\u0010¹\u0001\u001a\u00020.2\u0011\u0010º\u0001\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001b0\u001aH\u0016J\u001c\u0010»\u0001\u001a\u00020%2\b\u0010¼\u0001\u001a\u00030½\u00012\u0007\u0010¾\u0001\u001a\u00020.H\u0016J\n\u0010¿\u0001\u001a\u00030½\u0001H\u0016J\t\u0010À\u0001\u001a\u00020%H\u0016J\f\u0010Á\u0001\u001a\u0005\u0018\u00010Â\u0001H\u0016J\u0013\u0010Ã\u0001\u001a\u00020%2\b\u0010Ä\u0001\u001a\u00030¢\u0001H\u0016J\u0012\u0010Å\u0001\u001a\u00020%2\u0007\u0010Æ\u0001\u001a\u00020,H\u0016J\u0012\u0010Ç\u0001\u001a\u00020%2\u0007\u0010È\u0001\u001a\u00020,H\u0016J\t\u0010É\u0001\u001a\u00020,H\u0016J\u0019\u0010Ê\u0001\u001a\u00020%2\u000e\u0010Ë\u0001\u001a\t\u0012\u0002\b\u0003\u0018\u00010Ì\u0001H\u0016J\u0010\u0010Í\u0001\u001a\t\u0012\u0002\b\u0003\u0018\u00010Ì\u0001H\u0016J\u0015\u0010Î\u0001\u001a\u00020%2\n\u0010Ï\u0001\u001a\u0005\u0018\u00010Ð\u0001H\u0016J\u0012\u0010Ñ\u0001\u001a\u00020%2\u0007\u0010Ò\u0001\u001a\u00020.H\u0016J\u001b\u0010Ó\u0001\u001a\u00020%2\u0007\u0010Ô\u0001\u001a\u00020.2\u0007\u0010Õ\u0001\u001a\u00020.H\u0016J$\u0010Ö\u0001\u001a\u00020.2\u0007\u0010×\u0001\u001a\u00020.2\u0007\u0010Ø\u0001\u001a\u00020.2\u0007\u0010Õ\u0001\u001a\u00020.H\u0016J\u0019\u0010Ù\u0001\u001a\u00020%2\u000e\u0010¯\u0001\u001a\t\u0012\u0005\u0012\u00030¢\u00010\u001aH\u0016J\u0013\u0010Ú\u0001\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001b0\u001aH\u0016J\u0010\u0010Û\u0001\u001a\t\u0012\u0005\u0012\u00030¢\u00010\u001aH\u0016J\u0012\u0010Ü\u0001\u001a\u00020%2\u0007\u0010u\u001a\u00030Ý\u0001H\u0016J\u0012\u0010Þ\u0001\u001a\u00020%2\u0007\u0010u\u001a\u00030ß\u0001H\u0016J\u0012\u0010à\u0001\u001a\u00020%2\u0007\u0010w\u001a\u00030á\u0001H\u0016J\u0012\u0010â\u0001\u001a\u00020%2\u0007\u0010w\u001a\u00030á\u0001H\u0016J\t\u0010ã\u0001\u001a\u00020%H\u0016J\t\u0010ä\u0001\u001a\u00020,H\u0016J'\u0010å\u0001\u001a\u00020%2\u0007\u0010æ\u0001\u001a\u00020.2\u0007\u0010ç\u0001\u001a\u00020.2\n\u0010è\u0001\u001a\u0005\u0018\u00010é\u0001H\u0016J'\u0010ê\u0001\u001a\u00020%2\u0007\u0010æ\u0001\u001a\u00020.2\u0007\u0010ç\u0001\u001a\u00020.2\n\u0010è\u0001\u001a\u0005\u0018\u00010é\u0001H\u0016J \u0010ë\u0001\u001a\u0019\u0012\r\u0012\u000b\u0012\u0007\b\u0001\u0012\u00030ì\u00010 \u0012\u0005\u0012\u00030ì\u00010\u0083\u0001H\u0016J\u001f\u0010í\u0001\u001a\u0018\u0012\u0004\u0012\u00020y\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020y0ï\u0001\u0018\u00010î\u0001H\u0016J\u0012\u0010ð\u0001\u001a\u00020%2\u0007\u0010w\u001a\u00030ñ\u0001H\u0016J\u0012\u0010ò\u0001\u001a\u00020%2\u0007\u0010w\u001a\u00030ñ\u0001H\u0016J\u0012\u0010ó\u0001\u001a\u00020%2\u0007\u0010w\u001a\u00030ô\u0001H\u0016J\u0012\u0010õ\u0001\u001a\u00020%2\u0007\u0010w\u001a\u00030ô\u0001H\u0016J\u0019\u0010ö\u0001\u001a\u00020%2\u000e\u0010w\u001a\n\u0012\u0005\u0012\u00030ø\u00010÷\u0001H\u0016J\u0019\u0010ù\u0001\u001a\u00020%2\u000e\u0010w\u001a\n\u0012\u0005\u0012\u00030ø\u00010÷\u0001H\u0016J\t\u0010ú\u0001\u001a\u00020%H\u0016J\n\u0010û\u0001\u001a\u00030ü\u0001H\u0016J\t\u0010ý\u0001\u001a\u00020%H\u0016J\t\u0010þ\u0001\u001a\u00020.H\u0016J\t\u0010ÿ\u0001\u001a\u00020.H\u0016J\u0013\u0010\u0080\u0002\u001a\u00020%2\b\u0010Ï\u0001\u001a\u00030\u0081\u0002H\u0016J\u0013\u0010\u0082\u0002\u001a\u00020%2\b\u0010Ï\u0001\u001a\u00030\u0081\u0002H\u0016J\u0012\u0010\u0083\u0002\u001a\u00020%2\u0007\u0010u\u001a\u00030\u0084\u0002H\u0016J\u0012\u0010\u0085\u0002\u001a\u00020%2\u0007\u0010u\u001a\u00030\u0084\u0002H\u0016J\u0013\u0010\u0086\u0002\u001a\u00020%2\b\u0010\u0087\u0002\u001a\u00030¢\u0001H\u0016J\u001d\u0010\u0088\u0002\u001a\u00020%2\b\u0010\u0087\u0002\u001a\u00030¢\u00012\b\u0010\u0089\u0002\u001a\u00030\u008a\u0002H\u0016J\u0012\u0010\u008b\u0002\u001a\u00020%2\u0007\u0010u\u001a\u00030\u008c\u0002H\u0016J\u0013\u0010\u008d\u0002\u001a\u00020%2\b\u0010\u008e\u0002\u001a\u00030\u008f\u0002H\u0016J\u0013\u0010\u0090\u0002\u001a\u00020%2\b\u0010\u0091\u0002\u001a\u00030\u0092\u0002H\u0016J\u0013\u0010\u0093\u0002\u001a\u00020%2\b\u0010\u0091\u0002\u001a\u00030\u0092\u0002H\u0016J\n\u0010\u0094\u0002\u001a\u00030\u0095\u0002H\u0016J\t\u0010\u0096\u0002\u001a\u00020\u000fH\u0016J\u0012\u0010\u0097\u0002\u001a\u000b\u0012\u0007\u0012\u0005\u0018\u00010ø\u00010\u001aH\u0016J\u0012\u0010\u0098\u0002\u001a\u00020%2\u0007\u0010u\u001a\u00030\u0099\u0002H\u0016J\u0012\u0010\u009a\u0002\u001a\u00020%2\u0007\u0010u\u001a\u00030\u0099\u0002H\u0016J\u0012\u0010\u009b\u0002\u001a\u00020%2\u0007\u0010\u009c\u0002\u001a\u00020,H\u0016J\n\u0010\u009d\u0002\u001a\u00030\u009e\u0002H\u0016J\t\u0010\u009f\u0002\u001a\u00020,H\u0016J\"\u0010 \u0002\u001a\u00020%2\b\u0010¡\u0002\u001a\u00030¢\u00022\r\u0010£\u0002\u001a\b\u0012\u0004\u0012\u00020y0\u001aH\u0016J\u0019\u0010¤\u0002\u001a\u00020%2\u000e\u0010¥\u0002\u001a\t\u0012\u0004\u0012\u00020y0¦\u0002H\u0016J\u0013\u0010§\u0002\u001a\u00020%2\b\u0010¨\u0002\u001a\u00030©\u0002H\u0016J\u0019\u0010ª\u0002\u001a\u0005\u0018\u0001H«\u0002\"\u0005\b\u0000\u0010«\u0002H\u0016¢\u0006\u0003\u0010¬\u0002J\u000b\u0010\u00ad\u0002\u001a\u0004\u0018\u00010kH\u0016J5\u0010®\u0002\u001a\u0005\u0018\u00010¯\u00022\u000f\u0010°\u0002\u001a\n\u0012\u0005\u0012\u00030ø\u00010±\u00022\f\u0010²\u0002\u001a\u0007\u0012\u0002\b\u00030³\u00022\b\u0010´\u0002\u001a\u00030µ\u0002H\u0016J\u001d\u0010¶\u0002\u001a\u00020,2\b\u0010\u0087\u0002\u001a\u00030¢\u00012\b\u0010·\u0002\u001a\u00030¸\u0002H\u0016J \u0010¹\u0002\u001a\u00020%2\u000b\u0010º\u0002\u001a\u0006\u0012\u0002\b\u00030\u001b2\b\u0010·\u0002\u001a\u00030¸\u0002H\u0002J\u000b\u0010»\u0002\u001a\u0004\u0018\u00010yH\u0016J\u0015\u0010¼\u0002\u001a\u0004\u0018\u00010y2\b\u0010\u0087\u0002\u001a\u00030¢\u0001H\u0016J\f\u0010½\u0002\u001a\u0005\u0018\u00010¾\u0002H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\u0018\u001a\u0014\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001b0\u001a\u0018\u00010\u00198VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\"\u0010\u001e\u001a\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020!0 \u0012\u0004\u0012\u00020!0\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010'\u001a\u00020(8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*R\u0014\u00100\u001a\u0002018BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b2\u00103R\u0014\u00104\u001a\u0002058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b6\u00107R\u0014\u00108\u001a\u0002098BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b:\u0010;R\u0014\u0010<\u001a\u00020=8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b>\u0010?R\u0014\u0010@\u001a\u00020A8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bB\u0010CR\u0014\u0010D\u001a\u00020E8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bF\u0010GR\u0014\u0010H\u001a\u00020I8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bJ\u0010KR\u001b\u0010L\u001a\u00020M8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bP\u0010Q\u001a\u0004\bN\u0010OR\u001b\u0010R\u001a\u00020S8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bV\u0010Q\u001a\u0004\bT\u0010UR\u001a\u0010_\u001a\b\u0012\u0004\u0012\u00020\u00050`8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\ba\u0010b¨\u0006À\u0002"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/CoreMessageListComponent;", "Lcom/ss/android/lark/chat/chatwindow/biz/component/ChatBaseComponent;", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/IMessageListComponent;", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/IMessageListComponentInner;", "Lcom/ss/android/lark/biz/im/api/component/callback/IComponentCallbackManager;", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/IMessageListComponent$IListComponentCallbacks;", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/ChatSettingChangedService$OnChatSettingChangedListener;", "mContext", "Landroidx/fragment/app/FragmentActivity;", "spec", "Lcom/ss/android/lark/chat/spec/messagelist/MessageListSpec;", "chatContainer", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/push/IChatAppContainer;", "listRenderer", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/renderer/IMessageListRenderer;", "Lcom/ss/android/lark/chat/chatwindow/chat/IChatAdapter;", "viewModelFactoryProvider", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/features/data/MessageListDataFeature$IViewModelFactoryProvider;", "<init>", "(Landroidx/fragment/app/FragmentActivity;Lcom/ss/android/lark/chat/spec/messagelist/MessageListSpec;Lcom/ss/android/lark/chat/chatwindow/chat/v2/push/IChatAppContainer;Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/renderer/IMessageListRenderer;Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/features/data/MessageListDataFeature$IViewModelFactoryProvider;)V", "mMessageContext", "Lcom/ss/android/lark/chat/chatwindow/chat/ChatWindowContext;", "layoutCacheStore", "Lcom/ss/android/lark/chat/chatwindow/chat/message/ITextLayoutCacheStore;", "messageList", "Landroidx/lifecycle/MutableLiveData;", BuildConfig.FLAVOR, "Lcom/ss/android/lark/chat/vo/ChatMessageVO;", "getMessageList", "()Landroidx/lifecycle/MutableLiveData;", "cachedMessageCellParams", BuildConfig.FLAVOR, "Ljava/lang/Class;", "Lcom/ss/android/lark/biz/im/api/message/params/MessageCellParam;", "componentDependency", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/IMessageListComponent$IMessageListDependency;", "setDependency", BuildConfig.FLAVOR, "dependency", "messageListParams", "Lcom/ss/android/lark/biz/im/api/MessageListParams;", "getMessageListParams", "()Lcom/ss/android/lark/biz/im/api/MessageListParams;", "hasView", BuildConfig.FLAVOR, "getLayoutResId", BuildConfig.FLAVOR, "()Ljava/lang/Integer;", "rendererFeature", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/features/render/IMessageListRendererFeature;", "getRendererFeature", "()Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/features/render/IMessageListRendererFeature;", "menuFeature", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/features/menu/IMessageListMenuFeature;", "getMenuFeature", "()Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/features/menu/IMessageListMenuFeature;", "multiSelectFeature", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/features/select/IMessageListMultiSelectFeature;", "getMultiSelectFeature", "()Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/features/select/IMessageListMultiSelectFeature;", "eventFeature", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/features/event/IMessageListEventDispatchFeature;", "getEventFeature", "()Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/features/event/IMessageListEventDispatchFeature;", "dataFeature", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/features/data/IMessageListDataFeature;", "getDataFeature", "()Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/features/data/IMessageListDataFeature;", "cellActionFeature", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/features/action/IMessageListCellActionFeature;", "getCellActionFeature", "()Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/features/action/IMessageListCellActionFeature;", "scrollFeature", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/features/scroll/IMessageListScrollFeature;", "getScrollFeature", "()Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/features/scroll/IMessageListScrollFeature;", "featureEnv", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/features/IMessageListFeatureEnv;", "getFeatureEnv", "()Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/features/IMessageListFeatureEnv;", "featureEnv$delegate", "Lkotlin/Lazy;", "featureManager", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/features/MessageListFeatureManager;", "getFeatureManager", "()Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/features/MessageListFeatureManager;", "featureManager$delegate", "onCreate", "initMessageContext", "initData", "Lcom/ss/android/lark/chatwindow/model/data/ChatWindowInitData;", "onPause", "onResume", "onStart", "onStop", "callbacks", BuildConfig.FLAVOR, "getCallbacks", "()Ljava/util/List;", "registerCallback", "callback", "unregisterCallback", "onMessageAlignChanged", "onDestroy", "getRootLayout", "Landroid/widget/RelativeLayout;", "getMessagesRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "changeListBottomMargin", "height", "Lkotlin/Function0;", "scrollToPosition", "scene", "Lcom/ss/android/lark/biz/im/api/extension/scroll/ScrollScene;", "messagePosition", "showAnim", "toBottom", "listener", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/IMessageListComponent$OnLoadMessageStatusListener;", "interceptor", "Lkotlin/Function1;", "Lcom/ss/android/lark/chat/entity/message/MessageInfo;", "scrollToLatestMessageOfChatImmediately", "scrollToBottomIfNeed", "isActualLastItemShown", "addNewMessageListener", "Lcom/ss/android/lark/biz/im/api/listener/NewMessageListener;", "removeNewMessageListener", "getMessageListView", "setMessageCellParams", "params", BuildConfig.FLAVOR, "addSelectedMessageChangeListener", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/IMessageListComponent$ISelectedMessageChangeListener;", "addMessageListKeyEventListener", "Lcom/ss/android/lark/biz/im/api/extension/chat_window/ChatWindowMessageList$MessageListKeyEventListener;", "removeMessageListKeyEventListener", "addOnScrollListener", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "addMessageClearedListener", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/IMessageListComponent$IMessageClearedListener;", "addMessageBurnedListener", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/IMessageListComponent$IMessageBurnedListener;", "removeMessageBurnedListener", "addMessageVisibleListener", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/IMessageListComponent$IMessageVisibleListener;", "removeMessageVisibleListener", "addMessageCallbackHandler", "handler", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/MessageCallbackHandler;", "addOnItemDetectedListener", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/widget/RecyclerViewItemDetector$ItemDetectListener;", "removeOnItemDetectedListener", "isLastItemShown", "canLoadMore", "canLoadPre", "batchUpdate", "needUpdateMessage", "Lcom/ss/android/lark/chat/entity/message/IChatMessage;", "updateMsg", "key", "Lcom/ss/android/lark/biz/im/api/extension/store/ItemTwoKey;", BuildConfig.FLAVOR, "updater", "Lcom/ss/android/lark/biz/im/api/extension/store/IItemPatch;", "batchUpdateMsg", "patchProviderList", "Lcom/ss/android/lark/biz/im/api/extension/store/PatchProvider;", "invalidateMessageViews", "needInvalidateMessageIds", "needInvalidateMessagePosition", "getCurrentPageMsg", "getMsgById", "id", "getMsgListByIds", "ids", BuildConfig.FLAVOR, "serialExecute", "runnable", "Ljava/lang/Runnable;", "ensureLastPageDataLoaded", "getMsgPosByAdapterPos", "adapterPos", "getAllMsg", "enterMultiSelectMode", "adapterPosition", "selected", "changeListMode", "mode", "Lcom/ss/android/lark/chat/chatwindow/biz/component/messagelist/render/cell/ListMode;", "selectedPosition", "currentListMode", "refreshMessageList", "getMessageContext", "Lcom/ss/android/lark/chat/chatwindow/biz/component/messagelist/render/cell/IChatContext;", "onAuditedFailed", "msg", "setInterceptItemsTouch", "intercept", "setAllowItemShine", "allow", "getAllowItemShine", "setItemShineManager", "manager", "Lcom/ss/android/lark/chat/base/view/recycleview/ItemShineManager;", "getItemShineManager", "setChatWindowPreloadProvider", "provider", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/IChatWindowPreLoadTaskProvider;", "checkToClearMessages", "newFirstMsgPosition", "selectMsgFromPosition", "position", "limit", "selectMsgBetweenAdapterPositions", "startAdapterPosition", "endAdapterPosition", "selectMsgByMsgIds", "getSelectedMsgList", "getFollowingSelectMessageIds", "addAudioPlayModeChangeListener", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/IMessageListComponent$OnAudioPlayerModeListener;", "addMessageSelectModeChangeListener", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/IMessageListComponent$IMessageTipChangeListener;", "addMessageListChangeInterceptor", "Lcom/ss/android/lark/biz/im/api/MessageListChangeInterceptor;", "removeMessageListChangeInterceptor", "cancelAnim", "allowScrollMessageListOnChangeKeyboard", "handleActivityResult", "requestCode", "resultCode", Keys.API_RETURN_KEY_DATA, "Landroid/content/Intent;", "onActivityResult", "provideWidgetExport", "Lcom/ss/android/lark/framework/larkwidget/WidgetExport;", "getChatWindowDataStore", "Lcom/ss/android/lark/chatbase/BasePageStore;", "Lcom/ss/android/lark/chat/core/model/BasePageData;", "addMessagePushInterceptor", "Lcom/ss/android/lark/biz/im/api/MessagePushInterceptor;", "removeMessagePushInterceptor", "addMultiSelectMessageClickInterceptor", "Lcom/ss/android/lark/biz/im/api/extension/message/MultiSelectMessageClickInterceptor;", "removeMultiSelectMessageClickInterceptor", "addMessageActionPanelScrollStateInterceptor", "Lcom/ss/android/lark/biz/im/api/extension/chat_window/Interceptor;", BuildConfig.FLAVOR, "removeMessageActionPanelScrollStateInterceptor", "dismissActionPanel", "getMessageActionHandlerManager", "Lcom/ss/android/lark/biz/im/api/messageaction/MessageActionHandlerManager;", "notifyDataChange", "firstCompleteVisibleMessagePosition", "lastCompleteVisibleMessagePosition", "addReadMessageIdProvider", "Lcom/ss/android/lark/biz/im/api/ReadMessageIdProvider;", "removeReadMessageIdProvider", "addReadMessageListener", "Lcom/ss/android/lark/biz/im/api/IMessageReadListener;", "removeReadMessageListener", "readAudioMessage", "messageId", "prepareAudio", "successState", "Lcom/ss/android/lark/chat/entity/message/content/AudioContent$AudioState;", "addAudioDownloadListener", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/audio/AudioDownloadListener;", "updateLayoutManager", "layoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "registerAdapterDataObserver", "observer", "Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "unregisterAdapterDataObserver", "getMessageListConcatAdapter", "Lcom/ss/android/lark/chat/chatwindow/chat/IMessageListConcatAdapter;", "getChatAdapter", "getAllDisplayMessageItems", "addTitleAreaVisibilityListener", "Lcom/ss/android/lark/biz/im/api/TitleAreaVisibilityListener;", "removeTitleAreaVisibilityListener", "updateMessageReadable", "readable", "getScrollDispatcher", "Lcom/ss/android/lark/biz/im/api/extension/scroll/ScrollDispatcher;", "isNewScrollEnable", "invalidateItemDecoration", "chat", "Lcom/ss/android/lark/chat/entity/chat/Chat;", "messageInfoList", "addDataStoreDecorator", "decorator", "Lcom/ss/android/lark/chatbase/IDataStoreDataDecorator;", "onListDecorationHeightChangeEvent", "event", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/decoration/MessageListDecorationController$DecorationHeightChangeEvent;", "getClickHandler", "T", "()Ljava/lang/Object;", "getRecyclerView", "showTextSelectMenu", "Lcom/ss/android/lark/chat/chatwindow/menu/ITextSelectMenuControl;", "cell", "Lcom/ss/android/lark/blueprint/ICell;", "messageVo", "Lcom/ss/android/lark/chat/vo/AbsMessageVO;", "selectedTextRectOnWindow", "Landroid/graphics/Rect;", "tryShowMessageMenuByView", "view", "Landroid/view/View;", "syncMovableMarkdownSelectionCopyText", "item", "getTopicMessageInfo", "getMessageInfoById", "getViewModel", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/IMessageListViewModel;", "Companion", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CoreMessageListComponent extends ChatBaseComponent implements IMessageListComponent, IMessageListComponentInner, oxa.c<IMessageListComponent.a>, com.ss.android.lark.chat.chatwindow.chat.v2.component.message.b.a {
    public static final /* synthetic */ int w = 0;
    public final FragmentActivity l;
    public final t6b.o m;
    public final v n;
    public final h4b.c<com.ss.android.lark.chat.chatwindow.chat.a> o;
    public final MessageListDataFeature.a p;
    public s2b.d q;
    public final w2b.a r;
    public final Map<Class<? extends com.ss.android.lark.biz.im.api.message.params.l>, com.ss.android.lark.biz.im.api.message.params.l> s;
    public IMessageListComponent.e t;
    public final Lazy u;
    public final Lazy v;

    public static final class a {
    }

    public static final class b {
        public b() {
        }
    }

    public static final class c implements lya.a {
        public final /* synthetic */ CoreMessageListComponent a;

        public c(CoreMessageListComponent r1) {
            this.a = r1;
        }

        public final Integer a() {
            CoreMessageListComponent r0 = this.a;
            int r1 = CoreMessageListComponent.w;
            View r2 = r0.getFragment().getView();
            if (r2 != null) goto L7;
            return null;
        L7:
            return Integer.valueOf(r2.getWidth());
        }
    }

    public static final class d implements com.ss.android.lark.biz.im.api.extension.message.e {
        public final /* synthetic */ CoreMessageListComponent a;

        public final Fragment f() {
            return this.a.getFragment();
        }

        public final <T extends x1b.b> T get() {
            v r0 = this.a.n;
            Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type T of com.ss.android.lark.chat.chatwindow.chat.v2.component.message.CoreMessageListComponent.initMessageContext.<no name provided>.get");
            return r0;
        }

        public d(CoreMessageListComponent r1) {
            this.a = r1;
        }
    }

    public static final class e<T> implements Observer {
        public final /* synthetic */ CoreMessageListComponent a;

        public e(CoreMessageListComponent r1) {
            this.a = r1;
        }

        public final void onChanged(Object r4) {
            i7b.a r5 = (i7b.a) r4;
            Intrinsics.checkNotNullParameter(r5, "it");
            PerfLog.start("message_list_init_with_data", BuildConfig.FLAVOR);
            CoreMessageListComponent r0 = this.a;     // Catch: Exception -> L5
            int r1 = CoreMessageListComponent.w;     // Catch: Exception -> L5
            r0.L0(r5);     // Catch: Exception -> L5
            this.a.G0().b(r5);     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            Log.e(TitlebarViewModel.LOG_TAG, "init messageList crash", e, true);
            throw e;
        }
    }

    static {
    }

    public final boolean v0() {
        return true;
    }

    public final com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.c G0() {
        return (com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.c) this.v.getValue();
    }

    public final mya.h j5() {
        s2b.d r0 = this.q;
        if (r0 == null) goto L6;
        mya.h r1 = r0.j5();
        if (r1 == null) goto L6;
        return r1;
    L6:
        Log.e("MessageListComponent", "mMessageContext?.getMessageActionHandlerManager() returns null");
        return new mya.i();
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent
    public final x0 rY() {
        return this.m.b;
    }

    public final Map<Class<? extends com.ss.android.lark.framework.larkwidget.c>, com.ss.android.lark.framework.larkwidget.c> z0() {
        return MapsKt.mapOf(TuplesKt.to(IMessageListComponent.class, this));
    }

    public final com.ss.android.lark.biz.im.api.extension.scroll.c Ar() {
        return ((MessageListScrollFeature) J0()).m();
    }

    public final com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.data.a E0() {
        MessageListDataFeature r0 = G0().m;
        if (r0 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("dataFeature");
        return null;
    L7:
        return r0;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent
    public final SceneCoordinateRecyclerView Et() {
        return ((MessageListRendererFeature) I0()).getRecyclerView();
    }

    public final com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.a F0() {
        MessageListEventDispatchFeature r0 = G0().l;
        if (r0 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("eventFeature");
        return null;
    L7:
        return r0;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent
    public final s2b.g FX() {
        return ((MessageListRendererFeature) I0()).C();
    }

    public final e4b.a H0() {
        e4b.b r0 = G0().k;
        if (r0 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("multiSelectFeature");
        return null;
    L7:
        return r0;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponentInner
    public final a4b.b Hq() {
        a4b.d r0 = G0().n;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("cellActionFeature");
        r0 = null;
    L6:
        a4b.b r1 = r0.l();
        if (r1 != null) goto L10;
        return null;
    L10:
        return r1;
    }

    public final com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.render.a I0() {
        MessageListRendererFeature r0 = G0().i;
        if (r0 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("rendererFeature");
        return null;
    L7:
        return r0;
    }

    public final com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.scroll.a J0() {
        MessageListScrollFeature r0 = G0().o;
        if (r0 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("scrollFeature");
        return null;
    L7:
        return r0;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent
    public final void N3() {
        E0().N3();
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent
    public final List<y6b.c<?>> Oq() {
        return ((MessageListRendererFeature) I0()).t();
    }

    public final boolean Qv() {
        return ((Boolean) ((MessageListScrollFeature) J0()).f.getValue()).booleanValue();
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent
    public final boolean SP() {
        IMessageListViewModel r0 = ((MessageListDataFeature) E0()).g;
        if (r0 != null) goto L5;
        return true;
    L5:
        if (r0.canLoadMore() == true) goto L14;
        SceneCoordinateRecyclerView r1 = getRecyclerView();
        if (r1 != null) goto L9;
    L11:
        boolean r2 = false;
    L12:
        if (r2 == false) goto L14;
        return true;
    L9:
        if (zdc.h.d(r1) != true) goto L11;
        r2 = true;
    L14:
        return false;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent
    public final com.ss.android.lark.chat.chatwindow.chat.a Tc() {
        return ((MessageListRendererFeature) I0()).I();
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent
    public final RelativeLayout UI() {
        LKUIRelativeLayout r0 = ((MessageListRendererFeature) I0()).f;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mRootLayout");
        return null;
    L6:
        return r0;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponentInner
    public final void XE() {
        ((MessageListScrollFeature) J0()).a();
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent
    public final boolean canLoadMore() {
        IMessageListViewModel r0 = E0().f();
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.canLoadMore();
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent
    public final List<y6b.c<?>> gK() {
        MessageListMultiSelectFeature$initMultiSelector$multiSelector$1 r0 = ((e4b.b) H0()).c;
        if (r0 == null) goto L9;
        ArrayList r1 = new ArrayList();
        Iterator r2 = ((LinkedHashMap) ((MultiSelector) r0).b).entrySet().iterator();
    L6:
        if (r2.hasNext() == false) goto L11;
        r1.add(((Map.Entry) r2.next()).getValue());
        goto L6
    L11:
        return r1;
    L9:
        return new ArrayList();
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent
    public final MutableLiveData<List<y6b.c<?>>> getMessageList() {
        IMessageListViewModel r0 = E0().f();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getMessageList();
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponentInner
    public final RecyclerView getRecyclerView() {
        return ((MessageListRendererFeature) I0()).getRecyclerView();
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent
    public final MessageInfo getTopicMessageInfo() {
        IMessageListViewModel r0 = E0().f();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getTopicMessageInfo();
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent
    public final List<y6b.c<?>> h20() {
        return ((MessageListRendererFeature) I0()).I().getData();
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent
    public final ItemShineManager<?> oV() {
        return ((MessageListScrollFeature) J0()).d;
    }

    public final void onCreate() {
        super/*com.ss.android.lark.framework.larkwidget.Widget*/.onCreate();
        List<WeakReference<com.ss.android.lark.chat.chatwindow.chat.v2.component.message.b.a>> r0 = com.ss.android.lark.chat.chatwindow.chat.v2.component.message.b.a;
        Intrinsics.checkNotNullParameter(this, "listener");
        Iterator r1 = ((ArrayList) com.ss.android.lark.chat.chatwindow.chat.v2.component.message.b.a).iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        if (Intrinsics.areEqual(((WeakReference) r1.next()).get(), this) == false) goto L4;
    L10:
        if (((Widget) this).e != null) goto L12;
        return;
    L12:
        PerfLog.start("message_list_init", BuildConfig.FLAVOR);
        ChatCoreModule.a().getPerfEnterChatMonitor().d(true);
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.c r2 = G0();
        t6b.a r3 = (t6b.a) r2.a.b(t6b.a.class);
        b4b.b r4 = null;
        if (r3 == null) goto L54;
        Map<Class<s6b.b<?, ?>>, s6b.b<?, ?>> r5 = r2.a.a;
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type kotlin.collections.Map<java.lang.Class<*>, com.ss.android.lark.chat.spec.IFeatureSpec<*, *>>");
        LinkedHashMap r6 = (LinkedHashMap) r5;
        Object r7 = r6.get(t6b.c.class);
        if ((r7 instanceof t6b.c) == false) goto L18;
        t6b.c r8 = (t6b.c) r7;
    L19:
        if (r8 == null) goto L85;
        MessageListDataFeature r9 = new MessageListDataFeature(r8, r3.c(), r2.d, r2.e, r2.f);
        r2.h.put(com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.data.a.class, r9);
        r2.m = r9;
        Object r10 = r6.get(t6b.k.class);
        if ((r10 instanceof t6b.k) == false) goto L23;
        t6b.k r11 = (t6b.k) r10;
    L24:
        if (r11 == null) goto L83;
        MessageListRendererFeature r12 = new MessageListRendererFeature(r11, r2.c);
        r2.h.put(com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.render.a.class, r12);
        r2.i = r12;
        Object r13 = r6.get(t6b.i.class);
        if ((r13 instanceof t6b.i) == false) goto L28;
        t6b.i r14 = (t6b.i) r13;
    L29:
        if (r14 == null) goto L81;
        r2.h.put(d4b.a.class, new d4b.b(r14));
        Object r15 = r6.get(t6b.g.class);
        if ((r15 instanceof t6b.g) == false) goto L33;
        t6b.g r16 = (t6b.g) r15;
    L34:
        if (r16 == null) goto L79;
        MessageListMenuFeature r17 = new MessageListMenuFeature(r16);
        r2.h.put(com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.menu.a.class, r17);
        r2.j = r17;
        Object r18 = r6.get(t6b.m.class);
        if ((r18 instanceof t6b.m) == false) goto L38;
        t6b.m r19 = (t6b.m) r18;
    L39:
        if (r19 == null) goto L77;
        MessageListScrollFeature r20 = new MessageListScrollFeature(r19);
        r2.h.put(com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.scroll.a.class, r20);
        r2.o = r20;
        Object r21 = r6.get(t6b.e.class);
        if ((r21 instanceof t6b.e) == false) goto L43;
        t6b.e r22 = (t6b.e) r21;
    L44:
        if (r22 == null) goto L75;
        MessageListEventDispatchFeature r23 = new MessageListEventDispatchFeature(r22, r2.c);
        r2.h.put(com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.a.class, r23);
        r2.l = r23;
        Object r24 = r6.get(t6b.a.class);
        if ((r24 instanceof t6b.a) == false) goto L48;
        t6b.a r25 = (t6b.a) r24;
    L49:
        if (r25 == null) goto L73;
        b4b.b r26 = new b4b.b(r25, r2.g);
        r2.h.put(b4b.a.class, r26);
        r2.p = r26;
        e4b.b r27 = new e4b.b();
        r2.h.put(e4b.a.class, r27);
        r2.k = r27;
        a4b.d r28 = new a4b.d(r2.c);
        r2.h.put(a4b.a.class, r28);
        r2.n = r28;
        r2.h.put(c4b.a.class, new c4b.b());
        Iterator<T> r29 = r2.h.values().iterator();
    L52:
        if (r29.hasNext() == false) goto L54;
        ((com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.a) r29.next()).y(r2.b);
        goto L52
    L73:
        throw new IllegalStateException("context spec not found");
    L48:
        r25 = null;
        goto L49
    L75:
        throw new IllegalStateException("event spec not found");
    L43:
        r22 = null;
        goto L44
    L77:
        throw new IllegalStateException("scroll spec not found");
    L38:
        r19 = null;
        goto L39
    L79:
        throw new IllegalStateException("menu spec not found");
    L33:
        r16 = null;
        goto L34
    L81:
        throw new IllegalStateException("reader spec not found");
    L28:
        r14 = null;
        goto L29
    L83:
        throw new IllegalStateException("renderer spec not found");
    L23:
        r11 = null;
        goto L24
    L85:
        throw new IllegalStateException("data spec not found");
    L18:
        r8 = null;
    L54:
        ChatCoreModule.a().getPerfEnterChatMonitor().d(false);
        b4b.b r30 = G0().p;
        if (r30 != null) goto L59;
        Intrinsics.throwUninitializedPropertyAccessException("contextFeature");
        r30 = null;
    L59:
        if (Intrinsics.areEqual(r30.a.g(), Boolean.TRUE) == false) goto L70;
        b4b.b r31 = G0().p;
        if (r31 != null) goto L64;
        Intrinsics.throwUninitializedPropertyAccessException("contextFeature");
        r31 = null;
    L64:
        ChatWindowPrepareData r32 = r31.a.c().g();
        b4b.b r33 = G0().p;
        if (r33 == null) goto L67;
        r4 = r33;
    L68:
        i7b.a r34 = i7b.a.b(r4.a.c(), r32);
        Intrinsics.checkNotNull(r34);
        L0(r34);
        G0().b(r34);
        PerfLog.end("message_list_init", BuildConfig.FLAVOR);
        return;
    L67:
        Intrinsics.throwUninitializedPropertyAccessException("contextFeature");
        goto L68
    L70:
        com.ss.android.lark.chat.chatwindow.chat.v2.extension.b.b(D0(), this, new e(this));
        PerfLog.end("message_list_init", BuildConfig.FLAVOR);
        return;
    L8:
        ((ArrayList) com.ss.android.lark.chat.chatwindow.chat.v2.component.message.b.a).add(new WeakReference(this));
        goto L10
    }

    public final void onDestroy() {
        super/*com.ss.android.lark.framework.larkwidget.Widget*/.onDestroy();
        List<WeakReference<com.ss.android.lark.chat.chatwindow.chat.v2.component.message.b.a>> r0 = com.ss.android.lark.chat.chatwindow.chat.v2.component.message.b.a;
        Intrinsics.checkNotNullParameter(this, "listener");
        CollectionsKt.removeAll(com.ss.android.lark.chat.chatwindow.chat.v2.component.message.b.a, new ChatSettingChangedService$removeOnChatSettingChangedListener$1(this));
        Iterator<T> r1 = G0().h.values().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        ((com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.a) r1.next()).onDestroy();
        goto L4
    L6:
        w2b.a r2 = this.r;
        if (r2 == null) goto L9;
        r2.clearCache();
    L9:
        MessageListMenuFeature r3 = G0().j;
        if (r3 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("menuFeature");
        r3 = null;
    L13:
        s2b.c r4 = r3.c;
        if (r4 == null) goto L20;
        MessageActionPanelManager<y6b.c<?>> r5 = r4.f;
        r5.u.run();
        PopupMenu r6 = r5.i;
        if (r6 == null) goto L21;
        i0.a(r6, false, null, 7);
        return;
    L21:
        return;
    }

    public final void onPause() {
        super/*com.ss.android.lark.framework.larkwidget.Widget*/.onPause();
        Log.i(TitlebarViewModel.LOG_TAG, "onPause");
        Iterator<T> r0 = G0().h.values().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.a) r0.next()).onPause();
        goto L4
    L6:
        MessageListDataFeature r1 = G0().m;
        if (r1 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("dataFeature");
        r1 = null;
    L10:
        int r2 = com.ss.android.lark.biz.im.api.message.audit.a.a;
        Intrinsics.checkNotNullParameter(r1, "provider");
        com.ss.android.lark.biz.im.api.message.audit.f r3 = (com.ss.android.lark.biz.im.api.message.audit.f) e0c.k.a(com.larksuite.framework.utils.b.a, com.ss.android.lark.biz.im.api.message.audit.f.class);
        if (r3 != null) goto L13;
        Log.w("AuthResourceManager", "unregisterProvider but IAuthResourceUserScopeManager not available");
        return;
    L13:
        r3.Z9(r1);
    }

    public final void onResume() {
        super/*com.ss.android.lark.framework.larkwidget.Widget*/.onResume();
        Log.i(TitlebarViewModel.LOG_TAG, "onResume");
        Iterator<T> r0 = G0().h.values().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.a) r0.next()).onResume();
        goto L4
    L6:
        MessageListDataFeature r1 = G0().m;
        if (r1 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("dataFeature");
        r1 = null;
    L10:
        int r2 = com.ss.android.lark.biz.im.api.message.audit.a.a;
        Intrinsics.checkNotNullParameter(r1, "provider");
        com.ss.android.lark.biz.im.api.message.audit.f r3 = (com.ss.android.lark.biz.im.api.message.audit.f) e0c.k.a(com.larksuite.framework.utils.b.a, com.ss.android.lark.biz.im.api.message.audit.f.class);
        if (r3 != null) goto L13;
        Log.w("AuthResourceManager", "registerProvider but IAuthResourceUserScopeManager not available");
        return;
    L13:
        r3.Cb(r1);
    }

    public final void onStart() {
        super/*com.ss.android.lark.framework.larkwidget.Widget*/.onStart();
        Log.i(TitlebarViewModel.LOG_TAG, "onStart");
        Iterator<T> r0 = G0().h.values().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.a) r0.next()).onStart();
        goto L4
    }

    public final void onStop() {
        super/*com.ss.android.lark.framework.larkwidget.Widget*/.onStop();
        Log.i(TitlebarViewModel.LOG_TAG, "onStop");
        Iterator<T> r0 = G0().h.values().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.a) r0.next()).onStop();
        goto L4
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponentInner
    public final boolean pI() {
        MessageListMenuFeature r0 = G0().j;
        if (r0 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("menuFeature");
        r0 = null;
    L7:
        return r0.d;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent
    public final List<String> pP() {
        List<String> r0 = ((e4b.b) H0()).e;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return CollectionsKt.emptyList();
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent
    public final BasePageStore<MessageInfo, x4b.a<MessageInfo>> qg() {
        IMessageListViewModel r0 = ((MessageListDataFeature) E0()).g;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getDataStore();
    }

    public final Integer r0() {
        return 2131559318;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent
    public final boolean sX() {
        return ((MessageListScrollFeature) J0()).e;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent
    public final void x4() {
        ((MessageListRendererFeature) I0()).I().e().notifyDataSetChanged();
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent
    public final ListMode zO() {
        return ((e4b.b) H0()).b;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent
    public final s2b.d W2() {
        return this.q;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent
    public final void CU(ItemShineManager<?> r2) {
        ((MessageListScrollFeature) J0()).d = r2;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent
    public final void Cs(boolean r2) {
        ((MessageListScrollFeature) J0()).e = r2;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent
    public final void H5(String r2) {
        Intrinsics.checkNotNullParameter(r2, "messageId");
        IMessageListViewModel r0 = E0().f();
        if (r0 == null) goto L6;
        r0.readAudioMsg(r2);
        return;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent
    public final void IB(g r2) {
        Intrinsics.checkNotNullParameter(r2, "dependency");
        this.t = r2;
    }

    public final void L0(i7b.a r9) {
        FragmentActivity r1 = this.l;
        v r2 = this.n;
        t6b.a r3 = (t6b.a) G0().a.b(t6b.a.class);
        List<Integer> r4 = null;
        if (r3 == null) goto L5;
        m2b.a r5 = r3.d();
    L6:
        Fragment r6 = getFragment();
        if (r6 == null) goto L103;
        s2b.d r0 = new s2b.d(r1, r2, r5, r6);
        this.q = r0;
        w2b.b r7 = new w2b.b();
        r7.c(this.r);
        r0.k = r7;
        s2b.d r8 = this.q;
        if (r8 == null) goto L11;
        r8.d = r9.f;
    L11:
        if (r8 == null) goto L15;
        ChatChatter r10 = r9.h;
        if (r10 == null) goto L15;
        r8.b.getClass();
        r8.e = u2b.d.a(r10);
    L15:
        s2b.d r11 = this.q;
        if (r11 == null) goto L20;
        ChatChatter r12 = r9.g;
        if (r12 == null) goto L20;
        r11.b.getClass();
        r11.f = u2b.d.a(r12);
    L20:
        s2b.d r13 = this.q;
        if (r13 == null) goto L23;
        r13.h = r9.i;
    L23:
        if (r13 == null) goto L25;
        r13.n = r9.j;
    L25:
        if (r13 == null) goto L31;
        t6b.k r14 = G0().a();
        if (r14 == null) goto L29;
        long r15 = r14.n();
    L30:
        r13.j(r15);
        goto L31
    L29:
        r15 = -1132462081;
    L31:
        s2b.d r16 = this.q;
        if (r16 == null) goto L39;
        t6b.k r17 = G0().a();
        if (r17 == null) goto L37;
        Map<Class<? extends com.ss.android.lark.biz.im.api.message.params.l>, ? extends com.ss.android.lark.biz.im.api.message.params.l> r18 = r17.k();
        if (r18 == null) goto L37;
    L38:
        r16.h0(r18);
    L37:
        r18 = new LinkedHashMap();
    L39:
        s2b.d r19 = this.q;
        if (r19 == null) goto L42;
        r19.h0(this.s);
    L42:
        s2b.d r20 = this.q;
        if (r20 == null) goto L45;
        r20.G8(new b());
    L45:
        s2b.d r21 = this.q;
        if (r21 == null) goto L53;
        t6b.k r22 = G0().a();
        if (r22 == null) goto L51;
        Map<Class<? extends com.ss.android.lark.biz.im.api.message.params.l>, ? extends com.ss.android.lark.biz.im.api.message.params.l> r23 = r22.k();
        if (r23 == null) goto L51;
    L52:
        r21.h0(r23);
    L51:
        r23 = new LinkedHashMap();
    L53:
        s2b.d r24 = this.q;
        if (r24 == null) goto L56;
        r24.u(new c(this));
    L56:
        s2b.d r25 = this.q;
        if (r25 == null) goto L59;
        r25.l = ChatCoreModule.a().getChatDependency().q();
    L59:
        s2b.d r26 = this.q;
        if (r26 == null) goto L66;
        t6b.k r27 = G0().a();
        if (r27 == null) goto L64;
        o3b.a r28 = r27.l();
    L65:
        r26.t8(r28);
        goto L66
    L64:
        r28 = null;
    L66:
        d r29 = new d(this);
        Intrinsics.checkNotNullParameter(r29, "param");
        s2b.d r30 = this.q;
        t6b.g r31 = (t6b.g) G0().a.b(t6b.g.class);
        if (r31 == null) goto L69;
        r4 = r31.e();
    L69:
        if (r30 == null) goto L93;
        List<Integer> r32 = r4;
        if (r32 != null) goto L73;
    L76:
        boolean r33 = true;
    L77:
        if (r33 == true) goto L93;
        LinkedHashMap r34 = new LinkedHashMap();
        Map r35 = com.ss.android.lark.im.base.d.a;
        Iterator r36 = com.ss.android.lark.im.base.d.b(ImExtensionType.MESSAGE_ACTION_HANDLER_PROVIDER, com.ss.android.lark.biz.im.api.extension.message.b.class).iterator();
    L81:
        if (r36.hasNext() == false) goto L83;
        r34.putAll(((com.ss.android.lark.biz.im.api.extension.message.b) r36.next()).a());
        goto L81
    L83:
        LinkedHashMap r37 = new LinkedHashMap();
        n r38 = new n(r37);
        Iterator<T> r39 = r4.iterator();
    L85:
        if (r39.hasNext() == false) goto L92;
        com.ss.android.lark.biz.im.api.extension.message.a r40 = (com.ss.android.lark.biz.im.api.extension.message.a) r34.get(Integer.valueOf(((Number) r39.next()).intValue()));
        if (r40 == null) goto L85;
        Pair r41 = r40.a(r29);
        Class r42 = (Class) r41.component1();
        mya.g r43 = (mya.g) r41.component2();
        Object r44 = r37.get(r42);
        if (r44 != null) goto L91;
        r44 = new ArrayList();
        r37.put(r42, r44);
    L91:
        ((List) r44).add(r43);
        goto L85
    L92:
        r30.j5().e(r38);
        goto L93
    L73:
        if (r32.isEmpty() == true) goto L76;
        r33 = false;
    L93:
        t6b.k r45 = G0().a();
        if (r45 == null) goto L110;
        Map<Class<? extends mya.g>, List<mya.g>> r46 = r45.h();
        if (r46 == null) goto L111;
        s2b.d r47 = this.q;
        Intrinsics.checkNotNullParameter(r46, "handlers");
        if (r47 == null) goto L112;
        r47.j5().e(new n(r46));
        return;
    L112:
        return;
    L111:
        return;
    L110:
        return;
    L103:
        throw new IllegalArgumentException("Required value was null.".toString());
    L5:
        r5 = null;
        goto L6
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent
    public final void MH(ScrollScene r6) {
        Intrinsics.checkNotNullParameter(r6, "scene");
        MessageListScrollFeature r1 = (MessageListScrollFeature) J0();
        r1.getClass();
        Intrinsics.checkNotNullParameter(r6, "scene");
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.render.a r0 = r1.l();
        if (r0 == null) goto L9;
        SceneCoordinateRecyclerView r2 = r0.getRecyclerView();
        if (r2 == null) goto L9;
        boolean r3 = true;
        if (zdc.h.d(r2) != true) goto L9;
    L10:
        if (r3 == false) goto L13;
        com.ss.android.lark.biz.im.api.extension.scroll.a.a(r1.m(), r6, 0, false);
        return;
    L13:
        return;
    L9:
        r3 = false;
        goto L10
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent
    public final void Ml(IMessageListComponent.i r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        MessageListEventDispatchFeature r1 = (MessageListEventDispatchFeature) F0();
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, "listener");
        if (r1.l.contains(r3) == true) goto L6;
        r1.l.add(r3);
        return;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent
    public final void QE(o r3) {
        Intrinsics.checkNotNullParameter(r3, "handler");
        MessageListEventDispatchFeature r1 = (MessageListEventDispatchFeature) F0();
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, "handler");
        r1.k.add(r3);
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent
    public final int RT(int r3) {
        MessageListRendererFeature r0 = (MessageListRendererFeature) I0();
        if (r3 >= 0) goto L5;
        r0.getClass();
    L9:
        return -1;
    L5:
        if (r3 >= r0.I().getItemCount()) goto L9;
        return ((y6b.c) r0.I().getItem(r3)).n;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent
    public final void Vk(com.ss.android.lark.chat.chatwindow.chat.v2.widget.c.InterfaceC0082c<y6b.c<?>> r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        ((MessageListRendererFeature) I0()).n(r2);
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent
    public final void X70(com.ss.android.lark.chat.chatwindow.biz.plugin.a.d r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        ((MessageListDataFeature) E0()).m(r2);
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent
    public final void addOnScrollListener(RecyclerView.OnScrollListener r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        MessageListRendererFeature r1 = (MessageListRendererFeature) I0();
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, "listener");
        if (r1.g == false) goto L8;
        RecyclerView r0 = r1.d;
        if (r0 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mMessageRV");
        r0 = null;
    L7:
        r0.addOnScrollListener(r3);
        return;
    L8:
        r1.k.add(r3);
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent
    public final void batchUpdateMsg(List<? extends hya.c<String, f5b.b>> r2) {
        Intrinsics.checkNotNullParameter(r2, "patchProviderList");
        IMessageListViewModel r0 = ((MessageListDataFeature) E0()).g;
        if (r0 == null) goto L6;
        r0.batchUpdateMsg(r2);
        return;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent
    public final void cN(MessageListDecorationController.c r4) {
        Intrinsics.checkNotNullParameter(r4, "event");
        MessageListRendererFeature r1 = (MessageListRendererFeature) I0();
        r1.getClass();
        Intrinsics.checkNotNullParameter(r4, "event");
        MessageListDecorationController r2 = r1.p;
        if (r2 == null) goto L18;
        Intrinsics.checkNotNullParameter(r4, "event");
        MessageListDecorationController.d r0 = r4.b;
        Integer r3 = r0.a;
        if (r3 == null) goto L7;
        r2.d = r3.intValue();
    L7:
        Integer r5 = r0.b;
        if (r5 == null) goto L10;
        r2.e = r5.intValue();
    L10:
        Integer r6 = r0.c;
        if (r6 == null) goto L13;
        r2.f = r6.intValue();
    L13:
        Integer r7 = r0.d;
        if (r7 == null) goto L16;
        r2.g = r7.intValue();
    L16:
        r2.a(r4.a);
        return;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent
    public final void df(IMessageListComponent.g r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        MessageListEventDispatchFeature r1 = (MessageListEventDispatchFeature) F0();
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, "listener");
        if (r1.m.contains(r3) == true) goto L6;
        r1.m.add(r3);
        return;
    }

    public final void eM(jya.a r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        MessageListEventDispatchFeature r1 = (MessageListEventDispatchFeature) F0();
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, "listener");
        if (r1.s.contains(r3) == true) goto L6;
        r1.s.add(r3);
        return;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent
    public final void g6(int r2) {
        E0().g6(r2);
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent
    public final MessageInfo getMessageInfoById(String r2) {
        Intrinsics.checkNotNullParameter(r2, "messageId");
        return E0().getMessageInfoById(r2);
    }

    public final void hg(ChatWindowMessageList.a r6) {
        Intrinsics.checkNotNullParameter(r6, "listener");
        MessageListEventDispatchFeature r1 = (MessageListEventDispatchFeature) F0();
        r1.getClass();
        Intrinsics.checkNotNullParameter(r6, "listener");
        if (((ArrayList) r1.j).contains(r6) == true) goto L25;
        ((ArrayList) r1.j).add(r6);
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r0 = r1.d;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r2 = null;
        if (r0 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("env");
        r0 = null;
    L7:
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.render.a r3 = (com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.render.a) r0.b(com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.render.a.class);
        if (r3 == null) goto L12;
        boolean r4 = true;
        if (r3.v() != true) goto L12;
    L13:
        if (r4 == false) goto L15;
        r6.a();
    L15:
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r5 = r1.d;
        if (r5 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("env");
    L19:
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.render.a r7 = (com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.render.a) r2.b(com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.render.a.class);
        if (r7 == null) goto L26;
        Long r8 = r7.q();
        if (r8 == null) goto L27;
        r8.longValue();
        r6.b();
        return;
    L27:
        return;
    L26:
        return;
    L18:
        r2 = r5;
    L12:
        r4 = false;
        goto L13
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent
    public final void jX(IMessageListComponent.d r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        MessageListEventDispatchFeature r1 = (MessageListEventDispatchFeature) F0();
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, "listener");
        r1.q.add(r3);
    }

    public final void l(com.ss.android.lark.biz.im.api.extension.chat_window.e r2) {
        IMessageListComponent.a r3 = (IMessageListComponent.a) r2;
        Intrinsics.checkNotNullParameter(r3, "callback");
        ((MessageListEventDispatchFeature) F0()).l(r3);
    }

    public final void m(com.ss.android.lark.biz.im.api.extension.chat_window.e r2) {
        IMessageListComponent.a r3 = (IMessageListComponent.a) r2;
        Intrinsics.checkNotNullParameter(r3, "callback");
        ((MessageListEventDispatchFeature) F0()).m(r3);
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent
    public final void onAuditedFailed(String r2) {
        Intrinsics.checkNotNullParameter(r2, "msg");
        IMessageListViewModel r0 = ((MessageListDataFeature) E0()).g;
        if (r0 == null) goto L6;
        r0.onAuditedFailed(r2);
        return;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent
    public final void sf(ScrollScene r2) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        ((MessageListScrollFeature) J0()).F(r2);
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent
    public final void wb(List<String> r3) {
        Intrinsics.checkNotNullParameter(r3, "ids");
        e4b.b r1 = (e4b.b) H0();
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, "ids");
        List r0 = r1.e;
        if (r0 != null) goto L5;
        r0 = new ArrayList();
        r1.e = r0;
    L5:
        r0.clear();
        r0.addAll(r3);
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent
    public final MessageInfo y90(String r2) {
        Intrinsics.checkNotNullParameter(r2, "id");
        IMessageListViewModel r0 = ((MessageListDataFeature) E0()).g;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getMessageInfoById(r2);
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent
    public final void yU(int r8) {
        e4b.b r0 = (e4b.b) H0();
        MessageListMultiSelectFeature$initMultiSelector$multiSelector$1 r1 = r0.c;
        int r2 = 0;
        if (r1 != null) goto L5;
    L7:
        boolean r3 = false;
    L8:
        if (r3 == true) goto L57;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r4 = r0.a;
        com.ss.android.lark.chat.chatwindow.chat.a r5 = null;
        if (r4 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("env");
        r4 = null;
    L13:
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.render.a r6 = (com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.render.a) r4.b(com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.render.a.class);
        if (r6 == null) goto L16;
        r5 = r6.getAdapter();
    L16:
        if (r5 == null) goto L58;
        List<String> r7 = r0.e;
        if (r7 == null) goto L21;
        ((ArrayList) r7).clear();
    L21:
        MessageListMultiSelectFeature$initMultiSelector$multiSelector$1 r9 = r0.c;
        if (r9 == null) goto L54;
        ArrayList r10 = new ArrayList();
        int r11 = r5.getItemCount();
        int r12 = 0;
    L24:
        if (r8 >= r11) goto L32;
        if (r9.b(r5.getItem(r8)) == false) goto L29;
        r10.add(r5.getItem(r8));
        r12 = r12 + 1;
    L29:
        if (r12 >= 100) goto L32;
        r8 = r8 + 1;
    L32:
        int r13 = ((MultiSelector) r9).b.size();
        ((LinkedHashMap) ((MultiSelector) r9).b).clear();
        Iterator r14 = r10.iterator();
    L34:
        if (r14.hasNext() == false) goto L37;
        Object r15 = r14.next();
        ((MultiSelector) r9).b.put(Integer.valueOf(r15.hashCode()), r15);
    L37:
        if (r2 >= ((MultiSelector) r9).a.getItemCount()) goto L42;
        Object r16 = ((MultiSelector) r9).a.getItem(r2);
        if (((MultiSelector) r9).b.containsKey(Integer.valueOf(r16.hashCode())) == false) goto L41;
        ((MultiSelector) r9).c.put(r2, r16);
    L41:
        r2 = r2 + 1;
        goto L37
    L42:
        ((MultiSelector) r9).a.e().notifyDataSetChanged();
        if (r13 == ((MultiSelector) r9).b.size()) goto L55;
        MultiSelector.a r17 = ((MultiSelector) r9).e;
        if (r17 == null) goto L56;
        r17.a();
        return;
    L56:
        return;
    L55:
        return;
    L54:
        return;
    L58:
        return;
    L57:
        return;
    L5:
        if (((MultiSelector) r1).d == true) goto L7;
        r3 = true;
        goto L8
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent
    public final void z6(boolean r2) {
        E0().z6(r2);
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent
    public final void Y00(ListMode r8, int r9) {
        Intrinsics.checkNotNullParameter(r8, "mode");
        e4b.b r1 = (e4b.b) H0();
        r1.getClass();
        Intrinsics.checkNotNullParameter(r8, "mode");
        r1.b = r8;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r0 = r1.a;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r2 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("env");
        r0 = null;
    L5:
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.a r3 = (com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.a) r0.b(com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.a.class);
        if (r3 == null) goto L8;
        r3.m0(new com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.b.j(r8));
    L8:
        ListMode r4 = ListMode.NORMAL;
        boolean r5 = false;
        if (r8 != r4) goto L16;
        MessageListMultiSelectFeature$initMultiSelector$multiSelector$1 r10 = r1.c;
        if (r10 == null) goto L13;
        r10.c(false);
    L13:
        List<String> r11 = r1.e;
        if (r11 == null) goto L23;
        ((ArrayList) r11).clear();
    L23:
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r12 = r1.a;
        if (r12 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("env");
    L27:
        IMessageListComponent.e r13 = r2.getDependency();
        if (r13 == null) goto L36;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.e r14 = r13.b();
        if (r14 != null) goto L32;
        return;
    L32:
        if (r8 != r4) goto L34;
        r5 = true;
    L34:
        r14.a(new txa.a(r5));
        return;
    L36:
        return;
    L26:
        r2 = r12;
        goto L27
    L16:
        MessageListMultiSelectFeature$initMultiSelector$multiSelector$1 r6 = r1.c;
        if (r6 == null) goto L19;
        r6.c(true);
    L19:
        if (r9 < 0) goto L23;
        MessageListMultiSelectFeature$initMultiSelector$multiSelector$1 r7 = r1.c;
        if (r7 == null) goto L23;
        r7.d(r9);
        goto L23
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent
    public final void mB(String r4, AudioContent.AudioState r5) {
        Intrinsics.checkNotNullParameter(r4, "messageId");
        Intrinsics.checkNotNullParameter(r5, "successState");
        MessageListRendererFeature r0 = G0().i;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("rendererFeature");
        r0 = null;
    L6:
        r0.j();
        u r1 = MessagePermissionUtil.a;
        MessageListRendererFeature r2 = G0().i;
        if (r2 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("rendererFeature");
        r2 = null;
    L10:
        r2.j();
        IMessageListViewModel r3 = ((MessageListDataFeature) E0()).g;
        if (r3 == null) goto L14;
        r3.prepareAudioData(r4, null, null, r5);
        return;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent
    public final void updateMsg(hya.b<String> r2, hya.a<f5b.b> r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "updater");
        IMessageListViewModel r0 = ((MessageListDataFeature) E0()).g;
        if (r0 == null) goto L6;
        r0.updateMsg(r2, r3);
        return;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent
    public final r4b.a H2(com.ss.android.lark.blueprint.m<Object> r6, y6b.a<?> r7, Rect r8) {
        Intrinsics.checkNotNullParameter(r6, "cell");
        Intrinsics.checkNotNullParameter(r7, "messageVo");
        Intrinsics.checkNotNullParameter(r8, "selectedTextRectOnWindow");
        MessageListMenuFeature r1 = null;
        if ((r6 instanceof h3b.b) == false) goto L5;
        h3b.b r9 = (h3b.b) r6;
    L6:
        if (r9 != null) goto L9;
        return null;
    L9:
        if ((r7 instanceof y6b.c) == false) goto L11;
        y6b.c r10 = (y6b.c) r7;
    L12:
        if (r10 != null) goto L14;
        return null;
    L14:
        com.ss.android.lark.chat.message.menu.context.a r0 = new com.ss.android.lark.chat.message.menu.context.a(r9, r10, new Point(r8.left + (r8.width() / 2), r8.top));
        MessageListMenuFeature r11 = G0().j;
        if (r11 == null) goto L17;
        r1 = r11;
    L19:
        return r1.D(r10, r0);
    L17:
        Intrinsics.throwUninitializedPropertyAccessException("menuFeature");
        goto L19
    L11:
        r10 = null;
        goto L12
    L5:
        r9 = null;
        goto L6
    }

    public final void w0(int r3, int r4, Intent r5) {
        Iterator<T> r0 = G0().h.values().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.a) r0.next()).onActivityResult(r3, r4, r5);
        goto L4
    }

    public /* synthetic */ CoreMessageListComponent(FragmentActivity r7, t6b.o r8, v r9, h4b.b r10) {
        this(r7, r8, r9, r10, null);
    }

    public CoreMessageListComponent(FragmentActivity r2, t6b.o r3, v r4, h4b.b r5, MessageListDataFeature.a r6) {
        Intrinsics.checkNotNullParameter(r2, "mContext");
        Intrinsics.checkNotNullParameter(r3, "spec");
        Intrinsics.checkNotNullParameter(r4, "chatContainer");
        Intrinsics.checkNotNullParameter(r5, "listRenderer");
        this.l = r2;
        this.m = r3;
        this.n = r4;
        this.o = r5;
        this.p = r6;
        int r7 = com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender.e.a;
        int r8 = TextLayoutRender.j;
        int r9 = com.ss.android.lark.widget.light.g.a;
        if (FeatureGatingModule.getFeatureGatingService().isCurrentEnable("im.richtext.textlayoutrender") == true) goto L5;
        w2b.a r10 = null;
    L6:
        this.r = r10;
        this.s = new LinkedHashMap();
        this.u = LazyKt.lazy(new CoreMessageListComponent$featureEnv$2(this));
        this.v = LazyKt.lazy(new CoreMessageListComponent$featureManager$2(this));
        return;
    L5:
        r10 = new w2b.a();
        goto L6
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent
    public final void t3(ScrollScene r9, int r10, boolean r11, boolean r12, IMessageListComponent.k r13, Function1<? super MessageInfo, Boolean> r14) {
        Intrinsics.checkNotNullParameter(r9, "scene");
        ((MessageListScrollFeature) J0()).t3(r9, r10, r11, r12, r13, r14);
    }
}
