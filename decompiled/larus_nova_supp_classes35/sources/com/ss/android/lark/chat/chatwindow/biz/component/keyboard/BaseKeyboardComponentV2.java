package com.ss.android.lark.chat.chatwindow.biz.component.keyboard;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.callback.UIGetDataCallback;
import com.ss.android.lark.biz.im.api.OpenApp;
import com.ss.android.lark.biz.im.api.extension.chat_window.ChatWindowKeyboard;
import com.ss.android.lark.chat.base.view.vo.message.BaseTextContentVO;
import com.ss.android.lark.chat.base.view.vo.message.PostContentVO;
import com.ss.android.lark.chat.chatwindow.biz.component.ChatBaseComponent;
import com.ss.android.lark.chat.chatwindow.biz.component.keyboard.base.IKeyboardComponent;
import com.ss.android.lark.chat.chatwindow.biz.component.keyboard.configurator.KeyboardWrapperConfigurator;
import com.ss.android.lark.chat.chatwindow.biz.component.keyboardwrapper.IKeyboardWrapper;
import com.ss.android.lark.chat.chatwindow.chat.data.reply.ChatReplyDigestCreator;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.keyboard.KeyboardViewModel;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.v;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chat.entity.message.PartialReplyInfo;
import com.ss.android.lark.chat.entity.message.content.PostContent;
import com.ss.android.lark.chat.entity.message.content.TextContent;
import com.ss.android.lark.chat.utils.IMRichTextCopyUtils;
import com.ss.android.lark.chat.utils.x;
import com.ss.android.lark.framework.larkwidget.Widget;
import com.ss.android.lark.keyboard.KeyboardBuilder;
import com.ss.android.lark.keyboard.KeyboardScene;
import com.ss.android.lark.keyboard.base.ChatAttachmentEntity;
import com.ss.android.lark.keyboard.base.ReEditInfo;
import com.ss.android.lark.keyboard.base.n;
import com.ss.android.lark.keyboard.component.FlowKeyboardComponent;
import com.ss.android.lark.keyboard.edittext2.compat.ExtensionEditTextCompatKt;
import com.ss.android.lark.keyboard.edittext2.utils.RichTextCopyUtils;
import com.ss.android.lark.keyboard.keyboard2.BasicKeyboard;
import com.ss.android.lark.keyboard.keyboard2.KeyboardMenuItemKey;
import com.ss.android.lark.keyboard.plugin.tool.at.AtKBPlugin;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.statistics.Statistics;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.richtext.RichText;
import com.ss.android.lark.widget.richtext.RichTextElement;
import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import cya.c;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mob.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u008c\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u0000 Ü\u0001*\f\b\u0000\u0010\u0001*\u00020\u0002*\u00020\u00032\u00020\u00042\u00020\u00052\b\u0012\u0004\u0012\u00020\u00070\u0006:\u0002Ü\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010B\u001a\u00020CH\u0016J\r\u0010D\u001a\u00020EH\u0016¢\u0006\u0002\u0010FJ\b\u0010G\u001a\u00020HH\u0016J\b\u0010I\u001a\u00020\u001bH\u0002J\u0010\u0010J\u001a\u00020H2\u0006\u0010K\u001a\u00020LH\u0014J\u0010\u0010M\u001a\u00020H2\u0006\u0010K\u001a\u00020LH\u0002J\u0010\u0010N\u001a\u00020H2\u0006\u0010O\u001a\u00020\u0015H\u0014J\u0018\u0010P\u001a\u00020H2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010K\u001a\u00020LH$J\b\u0010Q\u001a\u00020EH\u0016J\b\u0010R\u001a\u00020HH\u0002J\u001a\u0010S\u001a\u00020T2\u0006\u0010\b\u001a\u00020\t2\b\u0010U\u001a\u0004\u0018\u00010VH&J\u0010\u0010W\u001a\u00020!2\u0006\u0010X\u001a\u00020YH&J\u001a\u0010Z\u001a\u00020H2\u0006\u0010U\u001a\u00020V2\b\u0010[\u001a\u0004\u0018\u00010\\H&J\u0010\u0010]\u001a\u00020H2\u0006\u0010^\u001a\u000202H\u0016J\b\u0010_\u001a\u00020HH\u0016J\u0018\u0010`\u001a\u00020H2\u0006\u0010a\u001a\u00020C2\u0006\u0010b\u001a\u00020cH\u0016J\b\u0010d\u001a\u00020HH\u0016J\b\u0010e\u001a\u00020CH\u0016J\b\u0010f\u001a\u00020CH\u0016J\u0010\u0010g\u001a\u00020H2\u0006\u0010h\u001a\u00020iH\u0016J\n\u0010j\u001a\u0004\u0018\u00010kH\u0016J\n\u0010l\u001a\u0004\u0018\u00010kH\u0016J\b\u0010m\u001a\u00020CH\u0002J\b\u0010n\u001a\u00020CH\u0016J\b\u0010o\u001a\u000202H\u0016J\b\u0010p\u001a\u000202H\u0016J\b\u0010q\u001a\u00020HH\u0016J\b\u0010r\u001a\u00020HH\u0016J\u0018\u0010s\u001a\u00020H2\u0006\u0010t\u001a\u0002022\u0006\u0010u\u001a\u000203H\u0016J\b\u0010v\u001a\u00020CH\u0016J\b\u0010w\u001a\u00020CH\u0016J\u0010\u0010x\u001a\u00020H2\u0006\u0010y\u001a\u00020-H\u0016J\u0010\u0010z\u001a\u00020H2\u0006\u0010y\u001a\u00020-H\u0016J\u0010\u0010{\u001a\u00020H2\u0006\u0010|\u001a\u00020*H\u0016J\u0010\u0010}\u001a\u00020H2\u0006\u0010|\u001a\u00020*H\u0016J\b\u0010~\u001a\u00020HH\u0016J\u001b\u0010\u007f\u001a\u00020H2\u0007\u0010\u0080\u0001\u001a\u0002022\b\u0010\u0081\u0001\u001a\u00030\u0082\u0001H\u0016J\u001c\u0010\u0083\u0001\u001a\u00020H2\u0007\u0010\u0080\u0001\u001a\u0002022\b\u0010\u0081\u0001\u001a\u00030\u0084\u0001H\u0016J \u0010\u0085\u0001\u001a\u00020H2\u0007\u0010\u0080\u0001\u001a\u0002022\f\u0010\u0081\u0001\u001a\u0007\u0012\u0002\b\u00030\u0086\u0001H\u0016J \u0010\u0087\u0001\u001a\u00020H2\u0007\u0010\u0080\u0001\u001a\u0002022\f\u0010\u0081\u0001\u001a\u0007\u0012\u0002\b\u00030\u0088\u0001H\u0016J\u001c\u0010\u0089\u0001\u001a\u00020H2\u0007\u0010\u0080\u0001\u001a\u0002022\b\u0010\u0081\u0001\u001a\u00030\u008a\u0001H\u0016J#\u0010\u008b\u0001\u001a\u00020H2\u0007\u0010\u0080\u0001\u001a\u0002022\u000f\u0010\u0081\u0001\u001a\n\u0012\u0005\u0012\u00030\u008d\u00010\u008c\u0001H\u0016J9\u0010\u008e\u0001\u001a\u00020H2\u0016\u0010\u008f\u0001\u001a\u0011\u0012\f\u0012\n\u0012\u0005\u0012\u00030\u008d\u00010\u008c\u00010\u0090\u00012\u0016\u0010\u0091\u0001\u001a\u0011\u0012\f\u0012\n\u0012\u0005\u0012\u00030\u008d\u00010\u008c\u00010\u0090\u0001H\u0016J\u0012\u0010\u0092\u0001\u001a\u00020H2\u0007\u0010\u0093\u0001\u001a\u00020;H\u0016J\u0012\u0010\u0094\u0001\u001a\u00020H2\u0007\u0010\u0093\u0001\u001a\u00020;H\u0016J\t\u0010\u0095\u0001\u001a\u00020HH\u0016J'\u0010\u0096\u0001\u001a\u00020H2\u0007\u0010\u0097\u0001\u001a\u00020E2\u0007\u0010\u0098\u0001\u001a\u00020E2\n\u0010\u0099\u0001\u001a\u0005\u0018\u00010\u009a\u0001H\u0016J\u000b\u0010\u009b\u0001\u001a\u0004\u0018\u00010\u0002H\u0016J.\u0010\u009c\u0001\u001a\u00020H2\u0007\u0010\u009d\u0001\u001a\u0002022\u0007\u0010\u009e\u0001\u001a\u0002022\b\u0010\u009f\u0001\u001a\u00030 \u00012\u0007\u0010¡\u0001\u001a\u00020EH\u0016J\t\u0010¢\u0001\u001a\u00020HH\u0016J\u0012\u0010£\u0001\u001a\u00020H2\u0007\u0010¤\u0001\u001a\u00020cH\u0016J\u001c\u0010¥\u0001\u001a\u00020H2\b\u0010¦\u0001\u001a\u00030§\u00012\u0007\u0010¨\u0001\u001a\u00020EH\u0016J\u001c\u0010©\u0001\u001a\u00020H2\b\u0010¦\u0001\u001a\u00030§\u00012\u0007\u0010ª\u0001\u001a\u00020EH\u0016J;\u0010©\u0001\u001a\u00020H2\b\u0010¦\u0001\u001a\u00030§\u00012\u0007\u0010ª\u0001\u001a\u00020E2\n\u0010«\u0001\u001a\u0005\u0018\u00010¬\u00012\u0011\u0010\u00ad\u0001\u001a\f\u0012\u0005\u0012\u00030¯\u0001\u0018\u00010®\u0001H\u0016JM\u0010©\u0001\u001a\u00020H2\b\u0010¦\u0001\u001a\u00030§\u00012\u0007\u0010ª\u0001\u001a\u00020E2\n\u0010«\u0001\u001a\u0005\u0018\u00010¬\u00012\u0007\u0010°\u0001\u001a\u00020C2\u0007\u0010±\u0001\u001a\u00020C2\u0011\u0010\u00ad\u0001\u001a\f\u0012\u0005\u0012\u00030¯\u0001\u0018\u00010®\u0001H\u0016J\u0013\u0010²\u0001\u001a\u00020H2\b\u0010¦\u0001\u001a\u00030§\u0001H\u0002J\u0013\u0010³\u0001\u001a\u00020H2\b\u0010¦\u0001\u001a\u00030§\u0001H\u0002J \u0010´\u0001\u001a\u00020H2\u0015\u0010µ\u0001\u001a\u0010\u0012\u000b\b\u0001\u0012\u0007\u0012\u0002\b\u00030·\u00010¶\u0001H\u0016J.\u0010¸\u0001\u001a\u00020H2\u0015\u0010µ\u0001\u001a\u0010\u0012\u000b\b\u0001\u0012\u0007\u0012\u0002\b\u00030·\u00010¶\u00012\f\u0010¹\u0001\u001a\u0007\u0012\u0002\b\u00030º\u0001H\u0002J-\u0010»\u0001\u001a\u00020C2\u0007\u0010¼\u0001\u001a\u0002022\u0007\u0010\u0080\u0001\u001a\u0002022\u0007\u0010½\u0001\u001a\u0002022\u0007\u0010¾\u0001\u001a\u00020CH\u0016J\f\u0010¿\u0001\u001a\u0005\u0018\u00010À\u0001H\u0016J\t\u0010Á\u0001\u001a\u00020HH\u0016J\t\u0010Â\u0001\u001a\u00020HH\u0016J\u0012\u0010Ã\u0001\u001a\u00020H2\u0007\u0010Ä\u0001\u001a\u00020CH\u0016J\f\u0010Å\u0001\u001a\u0005\u0018\u00010Æ\u0001H\u0004J\"\u0010Ç\u0001\u001a\u00020H2\u0007\u0010È\u0001\u001a\u00020E2\u000e\u0010É\u0001\u001a\t\u0012\u0004\u0012\u00020H0Ê\u0001H\u0004J\u0012\u0010Ë\u0001\u001a\u00020C2\u0007\u0010È\u0001\u001a\u00020EH\u0004J\t\u0010Ì\u0001\u001a\u00020EH\u0016J\u000b\u0010Í\u0001\u001a\u0004\u0018\u00010?H\u0016J \u0010Î\u0001\u001a\u00020H2\u0007\u0010\u0080\u0001\u001a\u0002022\f\u0010\u0081\u0001\u001a\u0007\u0012\u0002\b\u00030Ï\u0001H\u0016J\f\u0010Ð\u0001\u001a\u0005\u0018\u00010Ñ\u0001H\u0016J\u000b\u0010Ò\u0001\u001a\u0004\u0018\u00010\u0015H\u0016J!\u0010Ó\u0001\u001a\u001a\u0012\u000e\u0012\f\u0012\u0007\b\u0001\u0012\u00030Ö\u00010Õ\u0001\u0012\u0005\u0012\u00030Ö\u00010Ô\u0001H\u0016J\u0013\u0010×\u0001\u001a\u00020H2\u0007\u0010\u00ad\u0001\u001a\u00020\u0007H\u0096\u0001J\u0013\u0010Ø\u0001\u001a\u00020H2\u0007\u0010\u00ad\u0001\u001a\u00020\u0007H\u0096\u0001R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001e\u0010\u000e\u001a\u00020\u000f8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\"\u001a\u0004\u0018\u00010#X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u0014\u0010(\u001a\b\u0012\u0004\u0012\u00020*0)X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010+\u001a\b\u0012\u0004\u0012\u00020-0,X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u0082\u000e¢\u0006\u0002\n\u0000R7\u00100\u001a\u001e\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u00020301j\u000e\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u000203`48BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b5\u00106R\u0014\u00109\u001a\b\u0012\u0004\u0012\u00020;0:X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010<\u001a\u0004\u0018\u00010=X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010>\u001a\u0004\u0018\u00010?8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b@\u0010AR\u001b\u0010Ù\u0001\u001a\b\u0012\u0004\u0012\u00020\u00070)X\u0096\u0005¢\u0006\b\u001a\u0006\bÚ\u0001\u0010Û\u0001¨\u0006Ý\u0001"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/biz/component/keyboard/BaseKeyboardComponentV2;", "I", "Lcom/ss/android/lark/keyboard/plugin/input/base/ISendKeyboardEditor;", "Lcom/ss/android/lark/biz/im/api/extension/keyboard/inputstate/IHasInputState;", "Lcom/ss/android/lark/chat/chatwindow/biz/component/ChatBaseComponent;", "Lcom/ss/android/lark/chat/chatwindow/biz/component/keyboard/base/IKeyboardComponent;", "Lcom/ss/android/lark/biz/im/api/component/callback/IComponentCallbackManager;", "Lcom/ss/android/lark/biz/im/api/extension/chat_window/ChatWindowKeyboard$IKeyboardComponentCallbacks;", "chatContainer", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/push/IChatAppContainer;", "<init>", "(Lcom/ss/android/lark/chat/chatwindow/chat/v2/push/IChatAppContainer;)V", "getChatContainer", "()Lcom/ss/android/lark/chat/chatwindow/chat/v2/push/IChatAppContainer;", "mKeyboardContainer", "Landroid/widget/FrameLayout;", "getMKeyboardContainer", "()Landroid/widget/FrameLayout;", "setMKeyboardContainer", "(Landroid/widget/FrameLayout;)V", "mKeyBoard", "Lcom/ss/android/lark/keyboard/IKeyBoard;", "getMKeyBoard", "()Lcom/ss/android/lark/keyboard/IKeyBoard;", "setMKeyBoard", "(Lcom/ss/android/lark/keyboard/IKeyBoard;)V", "keyboardBuilder", "Lcom/ss/android/lark/keyboard/KeyboardBuilder;", "getKeyboardBuilder", "()Lcom/ss/android/lark/keyboard/KeyboardBuilder;", "setKeyboardBuilder", "(Lcom/ss/android/lark/keyboard/KeyboardBuilder;)V", "mKeyboardPluginFactory", "Lcom/ss/android/lark/chat/chatwindow/biz/component/keyboard/base/IKeyboardPluginFactory;", "mViewModel", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/keyboard/KeyboardViewModel;", "getMViewModel", "()Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/keyboard/KeyboardViewModel;", "setMViewModel", "(Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/keyboard/KeyboardViewModel;)V", "mKeyboardControlStatusListeners", BuildConfig.FLAVOR, "Lcom/ss/android/lark/chat/chatwindow/biz/component/keyboard/base/IKeyboardComponent$OnKeyboardControlStatusChangeListener;", "mKeyboardEventHandlers", "Ljava/util/LinkedList;", "Lcom/ss/android/lark/chat/chatwindow/biz/component/keyboard/base/IKeyboardEventHandler;", "mOpenApp", "Lcom/ss/android/lark/biz/im/api/OpenApp;", "bannedReasons", "Ljava/util/HashMap;", BuildConfig.FLAVOR, "Lcom/ss/android/lark/chat/chatwindow/biz/component/keyboardwrapper/BannedKeyboardReason;", "Lkotlin/collections/HashMap;", "getBannedReasons", "()Ljava/util/HashMap;", "bannedReasons$delegate", "Lkotlin/Lazy;", "plusPanelInterceptors", BuildConfig.FLAVOR, "Lcom/ss/android/lark/biz/im/api/extension/chat_window/ChatWindowKeyboard$PlusPanelInterceptor;", "mDelayLoadRunnable", "Ljava/lang/Runnable;", "messageSender", "Lcom/ss/android/lark/chat/chatwindow/keyboard/KeyboardMessageSender;", "getMessageSender", "()Lcom/ss/android/lark/chat/chatwindow/keyboard/KeyboardMessageSender;", "hasView", BuildConfig.FLAVOR, "getLayoutResId", BuildConfig.FLAVOR, "()Ljava/lang/Integer;", "onCreate", BuildConfig.FLAVOR, "createKeyboardBuilder", "attachKeyboardPlugin", "initData", "Lcom/ss/android/lark/chatwindow/model/data/ChatWindowInitData;", "buildKeyboard", "onKeyboardBuild", "keyboard", "onPrepareKeyboard", "getKeyboardType", "initKeyboardListener", "createChatReplyDigestCreator", "Lcom/ss/android/lark/chat/chatwindow/chat/data/reply/IReplyMsgDigestCreator;", "chat", "Lcom/ss/android/lark/chat/entity/chat/Chat;", "createKeyboardPluginFactory", "pluginContext", "Lcom/ss/android/lark/biz/im/api/extension/chat_window/ChatKeyboardPluginContext;", "setupKeyboardEnable", "chatChatter", "Lcom/ss/android/lark/chat/entity/chatter/Chatter;", "closeTypingTranslate", "chatId", "openTypingTranslate", "onEnterReEditMode", "fromDraft", "inputState", "Lcom/ss/android/lark/biz/im/api/extension/keyboard/inputstate/InputState;", "finishReplyMode", "needHideKeyBoard", "onBackPressed", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "getRootView", "Landroid/view/View;", "getContainerView", "isKeyboardBanned", "isInGeneralMode", "getReplyRootMsgId", "getReplyParentMsgId", "hideKeyboard", "showKeyboard", "bannedKeyboardShown", "reason", "banReason", "isKeyboardShown", "isKeyboardPanelShown", "bindKeyboardEventHandler", "handler", "unBindKeyboardEventHandler", "registerKeyboardControlStatusChangeListener", "listener", "unRegisterKeyboardControlStatusChangeListener", "closePanelAndSysKeyboard", "registerKBPlugin", IPortraitService.NAME, "plugin", "Lcom/ss/android/lark/keyboard/keyboard2/KeyboardMenuItem;", "registerKeyboardSwitcher", "Lcom/ss/android/lark/keyboard/base/IKeyboardSwitcherPlugin;", "registerInputBottomPlugin", "Lcom/ss/android/lark/keyboard/base/IIMInputBottomPlugin;", "registerKeyboardLogicPlugin", "Lcom/ss/android/lark/keyboard/base/IIMKeyboardLogicPlugin;", "registerSendPlugin", "Lcom/ss/android/lark/biz/im/api/extension/keyboard/ChatWindowSendPlugin;", "registerPlusItem", "Lcom/ss/android/lark/biz/im/api/extension/chat_window/IChatKeyboardPlugin;", "Lcom/ss/android/lark/chat/entity/keyboard/IPlusItem;", "updatePlusItems", "removed", BuildConfig.FLAVOR, "added", "addPlusPanelInterceptor", "interceptor", "removePlusPanelInterceptor", "onDestroy", "onActivityResult", "requestCode", "resultCode", Keys.API_RETURN_KEY_DATA, "Landroid/content/Intent;", "getInputEditor", "onRetryEditMessage", "messageId", "title", "content", "Lcom/ss/android/lark/widget/richtext/RichText;", "messageVersion", "performSaveInputState", "changeKeyboardInputState", "state", "onEditMessage", "messageInfo", "Lcom/ss/android/lark/chat/entity/message/MessageInfo;", "position", "onReplyMessage", "adapterPosition", "partialReplyInfo", "Lcom/ss/android/lark/chat/entity/message/PartialReplyInfo;", "callback", "Lcom/larksuite/framework/callback/IGetDataCallback;", "Lcom/ss/android/lark/chatwindow/model/data/ReplyInfo;", "needPrefix", "closeIme", "checkToSendRedPacketHitPoint", "onEditMessageByDraft", "onReEdit", "messageVO", "Lcom/ss/android/lark/chat/vo/AbsMessageVO;", "Lcom/ss/android/lark/chat/export/vo/ContentVO;", "appendReEditMessage", "contentVO", "Lcom/ss/android/lark/chat/base/view/vo/message/BaseTextContentVO;", "insertAt", "chatterId", "chatterOriginName", "isOutChat", "getInputStateController", "Lcom/ss/android/lark/biz/im/api/extension/keyboard/inputstate/IInputStateController;", "showSystemKeyboard", "hideSystemKeyboard", "inhibitSystemKeyboard", "shouldInhibit", "getKeyboardWrapper", "Lcom/ss/android/lark/chat/chatwindow/biz/component/keyboardwrapper/IKeyboardWrapper;", "switchKeyboardAndRun", IPortraitService.TYPE, Keys.API_PARAM_KEY_ACTION, "Lkotlin/Function0;", "isCurrentKeyboardType", "getKeyboardTopHeight", "getKeyboardMessageSender", "registerInputInnerPlugin", "Lcom/ss/android/lark/keyboard/base/inputinner/IIMInputInnerPlugin;", "getKeyboardMenu", "Lcom/ss/android/lark/keyboard/keyboard2/IKeyboardMenu;", "getKeyboard", "provideWidgetExport", BuildConfig.FLAVOR, "Ljava/lang/Class;", "Lcom/ss/android/lark/framework/larkwidget/WidgetExport;", "registerCallback", "unregisterCallback", "callbacks", "getCallbacks", "()Ljava/util/List;", "Companion", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class BaseKeyboardComponentV2<I extends mob.a & cya.c> extends ChatBaseComponent implements IKeyboardComponent, oxa.c<ChatWindowKeyboard.a> {
    public static final /* synthetic */ int v = 0;
    public final /* synthetic */ oxa.a<ChatWindowKeyboard.a> l;
    public final v m;

    @BindView(9816)
    public FrameLayout mKeyboardContainer;
    public com.ss.android.lark.keyboard.b n;
    public KeyboardBuilder.b o;
    public KeyboardViewModel p;
    public final List<IKeyboardComponent.a> q;
    public final LinkedList<j2b.a> r;
    public OpenApp s;
    public final Lazy t;
    public final Set<Object> u;

    public static final class a {
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ BaseKeyboardComponentV2<I> a;

        public b(BaseKeyboardComponentV2<I> r1) {
            this.a = r1;
        }

        public final void onChanged(Object r11) {
            i7b.a r12 = (i7b.a) r11;
            Intrinsics.checkNotNullParameter(r12, "it");
            PerfLog.start("keyboard_init_with_data", BuildConfig.FLAVOR);
            BaseKeyboardComponentV2<I> r2 = this.a;
            r2.s = r12.i;
            Chat r5 = r12.f;
            ChatChatter r6 = r12.g;
            v r7 = r2.m;
            KeyboardModelFactory r3 = new KeyboardModelFactory(r5, r6, r7, r2.G0(r7, r5), new com.ss.android.lark.chat.chatwindow.biz.component.keyboard.a(this.a));
            BaseKeyboardComponentV2<I> r4 = this.a;
            int r8 = com.ss.android.lark.chat.chatwindow.chat.v2.component.d.a;
            r4.p = (KeyboardViewModel) r4.t0(com.ss.android.lark.chat.chatwindow.chat.v2.component.d.a(KeyboardViewModel.class), KeyboardViewModel.class, r3);
            BaseKeyboardComponentV2<I> r9 = this.a;
            KeyboardBuilder.b r10 = r9.o;
            if (r10 == null) goto L29;
            r9.N0(r10, r12);
            FrameLayout r13 = r9.mKeyboardContainer;
            ViewGroup r14 = null;
            if (r13 != null) goto L8;
            Intrinsics.throwUninitializedPropertyAccessException("mKeyboardContainer");
            r13 = null;
        L8:
            com.ss.android.lark.keyboard.keyboard2.j r15 = r10.b(r13);
            r9.M0(r15);
            r9.n = r15;
            this.a.F0(r12);
            BaseKeyboardComponentV2<I> r16 = this.a;
            com.ss.android.lark.keyboard.b r17 = r16.n;
            if (r17 == null) goto L17;
        L10:
            j2b.a r18 = r16.r.pollLast();
            if (r18 == null) goto L13;
            r18.a(r17, r17.e());
            Unit r19 = Unit.INSTANCE;
        L14:
            if (r19 == null) goto L17;
        L13:
            r19 = null;
        L17:
            if (this.a.J0() == false) goto L19;
            this.a.hideKeyboard();
        L19:
            BasicKeyboard r20 = this.a.n;
            if (r20 == null) goto L26;
            Intrinsics.checkNotNullParameter(r20, "<this>");
            if ((r20 instanceof BasicKeyboard) == false) goto L24;
            r14 = r20.f.f;
        L24:
            if (r14 == null) goto L26;
            r14.setBackgroundResource(2131100549);
        L26:
            this.a.O0(r12.f, r12.g);
            PerfLog.end("keyboard_init_with_data", BuildConfig.FLAVOR);
            return;
        L29:
            throw new IllegalArgumentException("Required value was null.".toString());
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ BaseKeyboardComponentV2<I> a;

        public c(BaseKeyboardComponentV2<I> r1) {
            this.a = r1;
        }

        public final void onChanged(Object r6) {
            i7b.a r7 = (i7b.a) r6;
            this.a.s = r7.i;
            if (r7.f.isP2PChat() == false) goto L33;
            OpenApp r8 = this.a.s;
            if (r8 == null) goto L30;
            boolean r0 = false;
            if (r8.isValid() != true) goto L10;
            boolean r9 = true;
        L11:
            if (r9 == false) goto L31;
            int r10 = com.ss.android.lark.chat.chatwindow.biz.component.keyboard.c.a;
            OpenApp r11 = this.a.s;
            OpenApp.Chatable r2 = null;
            if (r11 == null) goto L15;
            OpenApp.Chatable r3 = r11.getChatable();
        L17:
            if (r3 == OpenApp.Chatable.CHATABLE) goto L24;
            if (r11 == null) goto L21;
            r2 = r11.getChatable();
        L21:
            if (r2 != OpenApp.Chatable.UNCHATABLE) goto L26;
            if (com.ss.android.lark.chat.chatwindow.biz.component.keyboard.c.a(r11) == true) goto L24;
        L26:
            if (r0 == false) goto L28;
            Log.i("BaseKeyboardComponentV2", "open app bot chatable showKeyboard");
            this.a.I();
            return;
        L28:
            Log.i("BaseKeyboardComponentV2", "open app bot unChatable hideKeyboard");
            this.a.hideKeyboard();
            return;
        L24:
            r0 = true;
            goto L26
        L15:
            r3 = null;
            goto L17
        L31:
            return;
        L10:
            r9 = false;
            goto L11
        L30:
            return;
        }
    }

    public static final class d<T> implements Observer {
        public final /* synthetic */ BaseKeyboardComponentV2<I> a;

        public d(BaseKeyboardComponentV2<I> r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            Chat r4 = (Chat) r3;
            if (r4 == null) goto L15;
            KeyboardViewModel r0 = this.a.p;
            if (r0 == null) goto L7;
            r0.updateChat(r4);
        L7:
            BaseKeyboardComponentV2<I> r1 = this.a;
            KeyboardViewModel r2 = r1.p;
            if (r2 == null) goto L12;
            MutableLiveData<Chatter> r5 = r2.getP2pChatterLiveData();
            if (r5 == null) goto L12;
            Chatter r6 = (Chatter) r5.getValue();
        L13:
            r1.O0(r4, r6);
            return;
        L12:
            r6 = null;
            goto L13
        }
    }

    static {
    }

    public abstract com.ss.android.lark.keyboard.reply.a G0(v r1, Chat r2);

    public abstract com.ss.android.lark.keyboard.factory.a H0(j2b.c r1);

    public void L0(boolean r1, cya.h r2) {
        Intrinsics.checkNotNullParameter(r2, "inputState");
    }

    public abstract void N0(KeyboardBuilder.b r1, i7b.a r2);

    public abstract void O0(Chat r1, Chatter r2);

    @Override // com.ss.android.lark.chat.chatwindow.biz.component.keyboard.base.IKeyboardComponent
    public void P3(String r1, String r2, RichText r3, int r4) {
        Intrinsics.checkNotNullParameter(r1, "messageId");
        Intrinsics.checkNotNullParameter(r2, "title");
        Intrinsics.checkNotNullParameter(r3, "content");
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.component.keyboard.base.IKeyboardComponent
    public final /* synthetic */ void m7(ChatWindowKeyboard.a r1) {
        IKeyboardComponent.CC.$default$registerKeyboardCallback(this, r1);
    }

    public final boolean v0() {
        return true;
    }

    public final boolean Hx() {
        com.ss.android.lark.keyboard.b r0 = this.n;
        if (r0 == null) goto L7;
        com.ss.android.lark.keyboard.ime.a r1 = r0.z();
        if (r1 == null) goto L7;
        return r1.y();
    L7:
        return false;
    }

    public final cya.d I0() {
        com.ss.android.lark.keyboard.b r0 = this.n;
        if (r0 == null) goto L5;
        com.ss.android.lark.keyboard.keyboard2.b r1 = r0.L();
    L6:
        cya.c r2 = (mob.a) r1;
        if ((r2 instanceof cya.c) == false) goto L9;
        cya.c r3 = r2;
    L10:
        if (r3 != null) goto L12;
        return null;
    L12:
        return r3.a();
    L9:
        r3 = null;
        goto L10
    L5:
        r1 = null;
        goto L6
    }

    public boolean J0() {
        KeyboardViewModel r0 = this.p;
        Chatter r1 = null;
        if (r0 == null) goto L5;
        Chat r2 = r0.getCurrentChat();
    L6:
        KeyboardViewModel r3 = this.p;
        if (r3 == null) goto L11;
        MutableLiveData<Chatter> r4 = r3.getP2pChatterLiveData();
        if (r4 == null) goto L11;
        r1 = (Chatter) r4.getValue();
    L11:
        int r5 = com.ss.android.lark.chat.chatwindow.biz.component.keyboard.c.a;
        if (com.ss.android.lark.chat.chatwindow.biz.component.keyboard.c.b(r2, r1, this.s) == true) goto L17;
        int r6 = com.ss.android.lark.chat.chatwindow.biz.component.keyboardwrapper.a.d;
        if (com.ss.android.lark.chat.chatwindow.biz.component.keyboardwrapper.a.C0033a.a((HashMap) this.t.getValue()) == true) goto L17;
        return false;
    L17:
        return true;
    L5:
        r2 = null;
        goto L6
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.component.keyboard.base.IKeyboardComponent
    public final int UJ() {
        com.ss.android.lark.keyboard.b r0 = this.n;
        mob.a r1 = null;
        if (r0 == null) goto L5;
        com.ss.android.lark.keyboard.keyboard2.b r2 = r0.L();
    L7:
        if ((r2 instanceof mob.a) == false) goto L9;
        r1 = (mob.a) r2;
    L9:
        if (r1 == null) goto L13;
        r1.A();
        return 0;
    L13:
        return 0;
    L5:
        r2 = null;
        goto L7
    }

    public final void Xm() {
        IKeyboardWrapper r0 = (IKeyboardWrapper) u0(IKeyboardWrapper.class);
        if (r0 != null) goto L6;
    L7:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L14;
        com.ss.android.lark.keyboard.b r2 = this.n;
        if (r2 == null) goto L15;
        com.ss.android.lark.c.c(r2);
        return;
    L15:
        return;
    L14:
        return;
    L6:
        if (r0.d0() == 0) goto L7;
        r1 = false;
        goto L9
    }

    public final boolean gI() {
        com.ss.android.lark.keyboard.b r0 = this.n;
        if (r0 == null) goto L7;
        com.ss.android.lark.keyboard.ime.a r1 = r0.z();
        if (r1 == null) goto L7;
        return r1.B();
    L7:
        return false;
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.component.keyboardwrapper.b
    public final View getRootView() {
        FrameLayout r0 = this.mKeyboardContainer;
        if (r0 == null) goto L9;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mKeyboardContainer");
        r0 = null;
    L8:
        return r0;
    L9:
        return null;
    }

    public final void hideKeyboard() {
        com.ss.android.lark.keyboard.b r0 = this.n;
        if (r0 == null) goto L5;
        com.ss.android.lark.c.b(r0);
    L5:
        Iterator r1 = ((ArrayList) this.q).iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        IKeyboardComponent.a r2 = (IKeyboardComponent.a) r1.next();
        int r3 = com.ss.android.lark.chat.chatwindow.biz.component.keyboardwrapper.a.d;
        r2.a(com.ss.android.lark.chat.chatwindow.biz.component.keyboardwrapper.a.C0033a.b((HashMap) this.t.getValue()));
        goto L7
    }

    public final Map<Class<? extends com.ss.android.lark.framework.larkwidget.c>, com.ss.android.lark.framework.larkwidget.c> z0() {
        return MapsKt.mapOf(TuplesKt.to(IKeyboardComponent.class, this));
    }

    public final void I() {
        if (J0() == false) goto L5;
        return;
    L5:
        com.ss.android.lark.keyboard.b r0 = this.n;
        if (r0 == null) goto L8;
        com.ss.android.lark.c.e(r0);
    L8:
        Iterator r1 = ((ArrayList) this.q).iterator();
    L10:
        if (r1.hasNext() == false) goto L12;
        IKeyboardComponent.a r2 = (IKeyboardComponent.a) r1.next();
        int r3 = com.ss.android.lark.chat.chatwindow.biz.component.keyboardwrapper.a.d;
        r2.a(com.ss.android.lark.chat.chatwindow.biz.component.keyboardwrapper.a.C0033a.b((HashMap) this.t.getValue()));
        goto L10
    }

    public void onCreate() {
        super/*com.ss.android.lark.framework.larkwidget.Widget*/.onCreate();
        PerfLog.start("keyboard_init", BuildConfig.FLAVOR);
        View r2 = ((Widget) this).e;
        if (r2 == null) goto L14;
        ButterKnife.bind(this, r2);
        FrameLayout r3 = this.mKeyboardContainer;
        Fragment r4 = null;
        if (r3 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mKeyboardContainer");
        r3 = null;
    L8:
        ((HashMap) d9c.a.a).put("keyboard_container", new WeakReference(r3));
        int r5 = KeyboardBuilder.g;
        Activity r6 = A0();
        com.ss.android.lark.framework.larkwidget.b r7 = ((Widget) this).a;
        if (r7 == null) goto L11;
        r4 = r7.getHostFragment();
    L11:
        Intrinsics.checkNotNullParameter(r6, "context");
        KeyboardBuilder.b r8 = new KeyboardBuilder.b(r6, r4);
        KeyboardScene r9 = KeyboardScene.ChatMain;
        Intrinsics.checkNotNullParameter(r9, "scene");
        ((KeyboardBuilder) r8).e = r9;
        Lifecycle r10 = getLifecycle();
        Intrinsics.checkNotNullParameter(r10, "lifecycle");
        ((KeyboardBuilder) r8).f = r10;
        this.o = r8;
        com.ss.android.lark.chat.chatwindow.chat.v2.extension.b.b(D0(), this, new b(this));
        D0().observe(this, new c(this));
        C0().observe(this, new d(this));
        PerfLog.end("keyboard_init", BuildConfig.FLAVOR);
        return;
    L14:
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public void onDestroy() {
        super/*com.ss.android.lark.framework.larkwidget.Widget*/.onDestroy();
        this.n = null;
    }

    public final Integer r0() {
        return 2131559316;
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.component.keyboardwrapper.b
    public final View getContainerView() {
        return ((Widget) this).d;
    }

    public final com.ss.android.lark.keyboard.b n() {
        return this.n;
    }

    public BaseKeyboardComponentV2(v r2) {
        Intrinsics.checkNotNullParameter(r2, "chatContainer");
        this.l = new oxa.a();
        this.m = r2;
        this.q = new ArrayList();
        this.r = new LinkedList();
        this.t = LazyKt.lazy(LazyThreadSafetyMode.NONE, BaseKeyboardComponentV2$bannedReasons$2.INSTANCE);
        this.u = new LinkedHashSet();
    }

    public void F0(i7b.a r8) {
        Intrinsics.checkNotNullParameter(r8, "initData");
        Fragment r2 = getFragment();
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type androidx.fragment.app.Fragment");
        Chat r4 = r8.f;
        ChatChatter r5 = r8.g;
        com.ss.android.lark.keyboard.factory.a r9 = H0(new j2b.c(r2, this.n, r4, r5, this.p));
        r9.a(this.u);
        this.u.clear();
        r9.b();
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.component.keyboard.base.IKeyboardComponent
    public final void F20(KeyboardWrapperConfigurator.e r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        ((ArrayList) this.q).add(r2);
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.component.keyboard.base.IKeyboardComponent
    public final void GA(boolean r2) {
        com.ss.android.lark.keyboard.b r0 = this.n;
        if (r0 == null) goto L8;
        com.ss.android.lark.keyboard.ime.a r1 = r0.z();
        if (r1 == null) goto L9;
        r1.setImeEnable(!r2);
        return;
    L9:
        return;
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.component.keyboard.base.IKeyboardComponent
    public final void K6(y6b.a<? extends v5b.a<?>> r8) {
        Intrinsics.checkNotNullParameter(r8, "messageVO");
        i7b.c r0 = new i7b.c();
        r0.b = com.ss.android.lark.keyboard.a.b(this.n);
        String r1 = com.ss.android.lark.keyboard.a.d(this.n);
        r0.a = r1;
        String r2 = r0.b;
        boolean r4 = false;
        if (TextUtils.isEmpty(r2) == true) goto L5;
    L8:
        boolean r3 = true;
    L9:
        v5b.a<?> r5 = r8.b();
        if ((r5 instanceof BaseTextContentVO) == true) goto L13;
        return;
    L13:
        if (TextUtils.isEmpty(r8.F()) == false) goto L15;
        E0(r8, (BaseTextContentVO) r5);
        return;
    L15:
        if (r3 == false) goto L32;
        String r6 = r8.i();
        if (r6 == null) goto L22;
        if (r6 != r2) goto L20;
    L21:
        boolean r7 = true;
    L23:
        if (r7 == false) goto L32;
        String r9 = r8.F();
        if (r9 == null) goto L30;
        if (r9 != r1) goto L28;
    L29:
        r4 = true;
        goto L30
    L28:
        if (r9.equals(r1) == true) goto L29;
    L30:
        if (r4 == false) goto L32;
        E0(r8, (BaseTextContentVO) r5);
        return;
    L20:
        if (r6.equals(r2) == true) goto L21;
    L22:
        r7 = false;
    L32:
        KeyboardViewModel r10 = this.p;
        if (r10 == null) goto L38;
        r10.getReEditReplyInfo(r8.getId(), new UIGetDataCallback(new BaseKeyboardComponentV2$onReEdit$1(this)));
        return;
    L38:
        return;
    L5:
        if (TextUtils.isEmpty(r0.a) == false) goto L8;
        r3 = false;
        goto L9
    }

    public void M0(com.ss.android.lark.keyboard.b r2) {
        Intrinsics.checkNotNullParameter(r2, "keyboard");
        r2.z().setAnimationEnable(true);
    }

    public final void P0(Function0 r2) {
        Intrinsics.checkNotNullParameter(r2, Keys.API_PARAM_KEY_ACTION);
        IKeyboardWrapper r0 = (IKeyboardWrapper) u0(IKeyboardWrapper.class);
        if (r0 != null) goto L5;
        r2.invoke();
        return;
    L5:
        r0.i0(r2);
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.component.keyboard.base.IKeyboardComponent
    public final void f6(com.ss.android.lark.chat.chatwindow.biz.component.keyboardwrapper.a r3) {
        Intrinsics.checkNotNullParameter("banned_select", "reason");
        Intrinsics.checkNotNullParameter(r3, "banReason");
        ((HashMap) this.t.getValue()).put("banned_select", r3);
        if (J0() == false) goto L5;
        hideKeyboard();
        return;
    L5:
        I();
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.component.keyboard.base.IKeyboardComponent
    public final void lD(j2b.a r3) {
        Intrinsics.checkNotNullParameter(r3, "handler");
        com.ss.android.lark.keyboard.b r0 = this.n;
        if (r0 == null) goto L5;
        r3.a(r0, r0.e());
        return;
    L5:
        this.r.add(r3);
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.component.keyboard.base.IKeyboardComponent
    public final void lS(com.ss.android.lark.chat.chatwindow.biz.component.keyboard.configurator.a r2) {
        Intrinsics.checkNotNullParameter(r2, "handler");
        this.r.remove(r2);
        com.ss.android.lark.keyboard.b r0 = this.n;
        if (r0 == null) goto L8;
        com.ss.android.lark.keyboard.event.k r1 = r0.e();
        if (r1 == null) goto L9;
        r2.t(r1);
        return;
    L9:
        return;
    }

    public final void m(com.ss.android.lark.biz.im.api.extension.chat_window.e r2) {
        ChatWindowKeyboard.a r3 = (ChatWindowKeyboard.a) r2;
        Intrinsics.checkNotNullParameter(r3, "callback");
        this.l.m(r3);
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.component.keyboard.base.IKeyboardComponent
    public final void oN(MessageInfo r22) {
        Intrinsics.checkNotNullParameter(r22, "messageInfo");
        Set<RichTextElement.RichTextTag> r3 = x.a;
        v r4 = this.m;
        Intrinsics.checkNotNullParameter(r4, "chatAppContainer");
        Intrinsics.checkNotNullParameter(r22, "messageInfo");
        cya.h.b r2 = new com.ss.android.lark.keyboard.inputstate.b();
        n r5 = ((cya.h) r2).a;
        Message r6 = r22.getMessage();
        Message.Type r7 = r6.getType();
        int r8 = -1;
        if (r7 != null) goto L5;
        int r9 = -1;
    L7:
        if (r9 == 1) goto L17;
        if (r9 == 2) goto L10;
        Log.e("KeyboardEditUtils", "onReEditMessage: invalid message type :" + r7.getNumber() + " , id : " + r6.getId());
        cya.a r10 = null;
    L22:
        if (r10 != null) goto L24;
        r2 = cya.h.b;
    L56:
        cya.i r1 = (cya.i) ((cya.h) r2).a.a(cya.i.h);
        if (r1 == null) goto L59;
        r1.f = true;
    L59:
        L0(false, r2);
        return;
    L24:
        r5.b(cya.a.c, r10);
        MessageInfo r11 = r22.getParentMessageInfo();
        PartialReplyInfo r12 = r22.getMessage().getPartialReplyInfo();
        if (r11 == null) goto L42;
        MessageInfo r13 = r22.getRootMessageInfo();
        if (r13 == null) goto L32;
        String r14 = r13.getId();
        if (r14 == null) goto L32;
        String r16 = r14;
    L33:
        Log.i("KeyboardEditUtils", "getReEditInputState: rootMsgInfo is not null, put reply info");
        String r15 = r11.getId();
        if (r15 != null) goto L36;
        String r17 = BuildConfig.FLAVOR;
    L37:
        CharSequence r18 = new ChatReplyDigestCreator(r4).a(r11.getMessageSender(), r11, false, r12);
        if (r18 != null) goto L40;
        CharSequence r19 = BuildConfig.FLAVOR;
    L41:
        r5.b(cya.i.h, new cya.i(r17, r16, r19, false, null, 80));
        goto L42
    L40:
        r19 = r18;
        goto L41
    L36:
        r17 = r15;
    L32:
        r16 = BuildConfig.FLAVOR;
    L42:
        ReEditInfo.a r20 = ReEditInfo.Companion;
        ReEditInfo r21 = new ReEditInfo(r22.getId(), r22.getMessage().getCreateTime(), false, 4, null);
        Message r23 = r22.getMessage();
        Intrinsics.checkNotNullParameter(r23, "message");
        Message.Type r24 = r23.getType();
        if (r24 == null) goto L46;
        r8 = x.a.a[r24.ordinal()];
    L46:
        if (r8 == 1) goto L50;
        if (r8 == 2) goto L49;
        List r25 = CollectionsKt.emptyList();
    L51:
        List r26 = x.a(r25);
        Iterator r27 = ((ArrayList) r26).iterator();
    L53:
        if (r27.hasNext() == false) goto L55;
        ChatAttachmentEntity r110 = (ChatAttachmentEntity) r27.next();
        r110.setSourceMessageId(r23.getId());
        r110.setSourceChatId(r23.getChatId());
        r110.setSourcePosition(r23.getPosition());
        goto L53
    L55:
        r21.setFileAttachments(new ArrayList(r26));
        Unit r28 = Unit.INSTANCE;
        r5.b(r20, r21);
        goto L56
    L49:
        r25 = ((PostContent) r23.getMessageContent()).getAttachments();
        goto L51
    L50:
        r25 = ((TextContent) r23.getMessageContent()).getAttachments();
        goto L51
    L10:
        PostContent r29 = (PostContent) r6.getMessageContent();
        RichText r30 = r29.getRichText();
        if (r30 != null) goto L13;
        r30 = com.ss.android.lark.widget.richtext.c.a();
    L13:
        String r31 = r29.getTitle();
        if (r31 != null) goto L16;
        r31 = BuildConfig.FLAVOR;
    L16:
        Intrinsics.checkNotNull(r30);
        r10 = new cya.a(r30, r31);
        goto L22
    L17:
        RichText r32 = ((TextContent) r6.getMessageContent()).getRichText();
        if (r32 != null) goto L20;
        r32 = com.ss.android.lark.widget.richtext.c.a();
    L20:
        Intrinsics.checkNotNull(r32);
        r10 = new cya.a(r32, BuildConfig.FLAVOR);
        goto L22
    L5:
        r9 = x.a.a[r7.ordinal()];
        goto L7
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.component.keyboard.base.IKeyboardComponent
    public final void qk(KeyboardWrapperConfigurator.e r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        ((ArrayList) this.q).remove(r2);
    }

    public final void y0(Configuration r3) {
        Intrinsics.checkNotNullParameter(r3, "newConfig");
        com.ss.android.lark.keyboard.b r1 = this.n;
        if (r1 == null) goto L12;
        com.ss.android.lark.keyboard.keyboard2.k r2 = r1.l();
        if (r2 == null) goto L13;
        Intrinsics.checkNotNullParameter(r3, "newConfig");
        com.ss.android.lark.keyboard.b r0 = r2.e;
        if (r0 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("keyboard");
        r0 = null;
    L10:
        r0.v().l().onConfigurationChanged(r3);
        return;
    L13:
        return;
    }

    public final void E0(y6b.a<? extends v5b.a<?>> r6, BaseTextContentVO<?> r7) {
        RichText r1 = null;
        if ((r7 instanceof PostContentVO) == false) goto L5;
        PostContentVO r0 = (PostContentVO) r7;
        RichText r2 = r0.g();
        r0.h(ChatCoreModule.a().getContext());
        RichText r3 = null;
    L6:
        IMRichTextCopyUtils r4 = IMRichTextCopyUtils.a;
        if (r2 != null) goto L10;
    L13:
        RichText r5 = RichTextCopyUtils.b(r1);
        if (this.m.C().isEnable("im.message.recall_reedit_attachment.reverse") == false) goto L16;
        List r8 = CollectionsKt.emptyList();
    L21:
        ((FlowKeyboardComponent) this).Q0(r3, r5, r8);
        return;
    L16:
        Set<RichTextElement.RichTextTag> r9 = x.a;
        List r10 = x.a(r7.f());
        Iterator r11 = ((ArrayList) r10).iterator();
    L18:
        if (r11.hasNext() == false) goto L20;
        ChatAttachmentEntity r12 = (ChatAttachmentEntity) r11.next();
        r12.setSourceMessageId(r6.getId());
        r12.setSourceChatId(r6.getChatId());
        r12.setSourcePosition(r6.A());
        goto L18
    L20:
        r8 = r10;
        goto L21
    L10:
        if (com.ss.android.lark.keyboard.edittext2.utils.d.a("messenger.message.copy") == true) goto L12;
        IMRichTextCopyUtils r13 = IMRichTextCopyUtils.a;
        IMRichTextCopyUtils.k(r2, SetsKt.mutableSetOf(new RichTextElement.RichTextTag[]{RichTextElement.RichTextTag.IMG, RichTextElement.RichTextTag.MEDIA}));
    L12:
        r1 = r2;
        goto L13
    L5:
        r3 = r7.g();
        r2 = null;
        goto L6
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.component.keyboard.base.IKeyboardComponent
    public final boolean m10(String r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, "chatterId");
        Intrinsics.checkNotNullParameter(r11, IPortraitService.NAME);
        Intrinsics.checkNotNullParameter(r12, "chatterOriginName");
        IKeyboardWrapper r2 = (IKeyboardWrapper) u0(IKeyboardWrapper.class);
        if (r2 == null) goto L5;
        r2.i0(null);
    L5:
        com.ss.android.lark.keyboard.b r3 = this.n;
        if (r3 == null) goto L20;
        com.ss.android.lark.keyboard.keyboard2.d r4 = r3.H();
        if (r4 == null) goto L20;
        Intrinsics.checkNotNullParameter(r4, "<this>");
        AtKBPlugin r7 = r4.i(KeyboardMenuItemKey.At, AtKBPlugin.class);
        if (r7 == null) goto L20;
        Intrinsics.checkNotNullParameter(r10, "chatterId");
        Intrinsics.checkNotNullParameter(r11, "chatterName");
        Intrinsics.checkNotNullParameter(r12, "chatterOriginName");
        if (r7.p == false) goto L20;
        if (r7.h == false) goto L20;
        if (r7.i == false) goto L20;
        EditText r8 = r7.n().L().c();
        ExtensionEditTextCompatKt.j(r8, r10, r11, r12, false, false, Intrinsics.areEqual(r10, r7.e.c()));
        r8.setSelection(r8.getText().length());
        r7.n().z().z();
        r8.requestFocus();
        return true;
    L20:
        return false;
    }

    public final void w0(int r2, int r3, Intent r4) {
        com.ss.android.lark.keyboard.b r0 = this.n;
        if (r0 == null) goto L12;
        com.ss.android.lark.keyboard.keyboard2.k r1 = r0.l();
        if (r1 == null) goto L13;
        com.ss.android.lark.keyboard.b r5 = r1.e;
        if (r5 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("keyboard");
        r5 = null;
    L10:
        r5.v().l().onActivityResult(r2, r3, r4);
        return;
    L13:
        return;
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.component.keyboard.base.IKeyboardComponent
    public final void oc(MessageInfo r9, int r10, PartialReplyInfo r11, IGetDataCallback<i7b.c> r12) {
        Intrinsics.checkNotNullParameter(r9, "messageInfo");
        PE(r9, r10, r11, true, false, r12);
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.component.keyboard.base.IKeyboardComponent
    public final void PE(MessageInfo r8, final int r9, final PartialReplyInfo r10, boolean r11, final boolean r12, final IGetDataCallback<i7b.c> r13) {
        Intrinsics.checkNotNullParameter(r8, "messageInfo");
        IGetDataCallback<i7b.c> r0 = new BaseKeyboardComponentV2$onReplyMessage$callback$1(r9, r10, this, r12, r13);
        r8.setPartialReplyInfo(r10);
        KeyboardViewModel r14 = this.p;
        if (r14 == null) goto L6;
        r14.getReplyInfo(r8, r11, new UIGetDataCallback(r0));
    L6:
        if (r8.getMessage().getType() != Message.Type.RED_PACKET) goto L9;
        y5c.a.a.getClass();
        Statistics.sendEvent("mobile_hongbao_reply");
        return;
    }
}
