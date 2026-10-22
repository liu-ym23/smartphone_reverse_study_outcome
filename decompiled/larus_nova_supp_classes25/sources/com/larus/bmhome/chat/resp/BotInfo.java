package com.larus.bmhome.chat.resp;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.bot.AnswerAction;
import com.larus.im.bean.bot.BotConfItem;
import com.larus.im.bean.bot.BotCreatorInfo;
import com.larus.im.bean.bot.BotDigitalHumanData;
import com.larus.im.bean.bot.BotIconImage;
import com.larus.im.bean.bot.FirstMet;
import com.larus.im.bean.bot.ModelItem;
import com.larus.im.bean.bot.SceneModelList;
import com.larus.im.bean.bot.ShareInfo;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import com.larus.utils.gson.TimeTransformAdapter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Deprecated(message = "old data flow")
@Metadata(d1 = {"\u0000\u009f\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0003\b±\u0001\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 õ\u00012\u00020\u0001:\u0002õ\u0001B\u009d\u0004\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u0010\u001a\u00020\n\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0012\u001a\u00020\n\u0012\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0018\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0018\u0012\b\b\u0002\u0010\u001a\u001a\u00020\b\u0012\b\b\u0002\u0010\u001b\u001a\u00020\n\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 \u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010%\u0012\u0010\b\u0002\u0010&\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010\u0014\u0012\u0010\b\u0002\u0010(\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010\u0014\u0012\u0010\b\u0002\u0010)\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010\u0014\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010+\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u000102\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u000106\u0012\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u00108\u001a\u0004\u0018\u000109\u0012\n\b\u0002\u0010:\u001a\u0004\u0018\u00010;\u0012\u000e\b\u0002\u0010<\u001a\b\u0012\u0004\u0012\u00020\f0\u0014\u0012\u000e\b\u0002\u0010=\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0014\u0012\b\b\u0002\u0010>\u001a\u00020\u0003¢\u0006\u0004\b?\u0010@J\f\u0010½\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010¾\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010¿\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010À\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010Á\u0001\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010LJ\u0011\u0010Â\u0001\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010QJ\f\u0010Ã\u0001\u001a\u0004\u0018\u00010\fHÆ\u0003J\f\u0010Ä\u0001\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u0011\u0010Å\u0001\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010LJ\n\u0010Æ\u0001\u001a\u00020\nHÆ\u0003J\f\u0010Ç\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\n\u0010È\u0001\u001a\u00020\nHÆ\u0003J\u0012\u0010É\u0001\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014HÆ\u0003J\f\u0010Ê\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\n\u0010Ë\u0001\u001a\u00020\u0018HÆ\u0003J\n\u0010Ì\u0001\u001a\u00020\u0018HÆ\u0003J\n\u0010Í\u0001\u001a\u00020\bHÆ\u0003J\n\u0010Î\u0001\u001a\u00020\nHÆ\u0003J\f\u0010Ï\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010Ð\u0001\u001a\u0004\u0018\u00010\u001eHÆ\u0003J\f\u0010Ñ\u0001\u001a\u0004\u0018\u00010 HÆ\u0003J\f\u0010Ò\u0001\u001a\u0004\u0018\u00010\"HÆ\u0003J\f\u0010Ó\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010Ô\u0001\u001a\u0004\u0018\u00010%HÆ\u0003J\u0012\u0010Õ\u0001\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010\u0014HÆ\u0003J\u0012\u0010Ö\u0001\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010\u0014HÆ\u0003J\u0012\u0010×\u0001\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010\u0014HÆ\u0003J\f\u0010Ø\u0001\u001a\u0004\u0018\u00010+HÆ\u0003J\f\u0010Ù\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010Ú\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010Û\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010Ü\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010Ý\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010Þ\u0001\u001a\u0004\u0018\u000102HÆ\u0003J\f\u0010ß\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010à\u0001\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010LJ\f\u0010á\u0001\u001a\u0004\u0018\u000106HÆ\u0003J\f\u0010â\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010ã\u0001\u001a\u0004\u0018\u000109HÆ\u0003J\f\u0010ä\u0001\u001a\u0004\u0018\u00010;HÆ\u0003J\u0010\u0010å\u0001\u001a\b\u0012\u0004\u0012\u00020\f0\u0014HÆ\u0003J\u0010\u0010æ\u0001\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0014HÆ\u0003J\n\u0010ç\u0001\u001a\u00020\u0003HÆ\u0003J¦\u0004\u0010è\u0001\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u0010\u001a\u00020\n2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0012\u001a\u00020\n2\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00142\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u00182\b\b\u0002\u0010\u001a\u001a\u00020\b2\b\b\u0002\u0010\u001b\u001a\u00020\n2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010$\u001a\u0004\u0018\u00010%2\u0010\b\u0002\u0010&\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010\u00142\u0010\b\u0002\u0010(\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010\u00142\u0010\b\u0002\u0010)\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010\u00142\n\b\u0002\u0010*\u001a\u0004\u0018\u00010+2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u00101\u001a\u0004\u0018\u0001022\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u00104\u001a\u0004\u0018\u00010\b2\n\b\u0002\u00105\u001a\u0004\u0018\u0001062\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u00108\u001a\u0004\u0018\u0001092\n\b\u0002\u0010:\u001a\u0004\u0018\u00010;2\u000e\b\u0002\u0010<\u001a\b\u0012\u0004\u0012\u00020\f0\u00142\u000e\b\u0002\u0010=\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00142\b\b\u0002\u0010>\u001a\u00020\u0003HÆ\u0001¢\u0006\u0003\u0010é\u0001J\u0007\u0010ê\u0001\u001a\u00020\nJ\u0016\u0010ë\u0001\u001a\u00020\b2\n\u0010ì\u0001\u001a\u0005\u0018\u00010í\u0001HÖ\u0003J\n\u0010î\u0001\u001a\u00020\nHÖ\u0001J\n\u0010ï\u0001\u001a\u00020\u0003HÖ\u0001J\u001b\u0010ð\u0001\u001a\u00030ñ\u00012\b\u0010ò\u0001\u001a\u00030ó\u00012\u0007\u0010ô\u0001\u001a\u00020\nR \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010B\"\u0004\bF\u0010DR \u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010B\"\u0004\bH\u0010DR \u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010B\"\u0004\bJ\u0010DR\"\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010O\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\"\u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010T\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR \u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR \u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R\"\u0010\u000f\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010O\u001a\u0004\b]\u0010L\"\u0004\b^\u0010NR\u001e\u0010\u0010\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bR \u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bc\u0010B\"\u0004\bd\u0010DR\u001e\u0010\u0012\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\be\u0010`\"\u0004\bf\u0010bR&\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bg\u0010h\"\u0004\bi\u0010jR \u0010\u0016\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bk\u0010B\"\u0004\bl\u0010DR\u001e\u0010\u0017\u001a\u00020\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bm\u0010n\"\u0004\bo\u0010pR\u001e\u0010\u0019\u001a\u00020\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bq\u0010n\"\u0004\br\u0010pR\u001e\u0010\u001a\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bs\u0010t\"\u0004\bu\u0010vR\u001e\u0010\u001b\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bw\u0010`\"\u0004\bx\u0010bR \u0010\u001c\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\by\u0010B\"\u0004\bz\u0010DR \u0010\u001d\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b{\u0010|\"\u0004\b}\u0010~R#\u0010\u001f\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u0087\u000e¢\u0006\u0011\n\u0000\u001a\u0005\b\u007f\u0010\u0080\u0001\"\u0006\b\u0081\u0001\u0010\u0082\u0001R$\u0010!\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0083\u0001\u0010\u0084\u0001\"\u0006\b\u0085\u0001\u0010\u0086\u0001R\"\u0010#\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0087\u0001\u0010B\"\u0005\b\u0088\u0001\u0010DR$\u0010$\u001a\u0004\u0018\u00010%8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0089\u0001\u0010\u008a\u0001\"\u0006\b\u008b\u0001\u0010\u008c\u0001R(\u0010&\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008d\u0001\u0010h\"\u0005\b\u008e\u0001\u0010jR(\u0010(\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008f\u0001\u0010h\"\u0005\b\u0090\u0001\u0010jR(\u0010)\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0091\u0001\u0010h\"\u0005\b\u0092\u0001\u0010jR$\u0010*\u001a\u0004\u0018\u00010+8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0093\u0001\u0010\u0094\u0001\"\u0006\b\u0095\u0001\u0010\u0096\u0001R\"\u0010,\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0097\u0001\u0010B\"\u0005\b\u0098\u0001\u0010DR\"\u0010-\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0099\u0001\u0010B\"\u0005\b\u009a\u0001\u0010DR\"\u0010.\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u009b\u0001\u0010B\"\u0005\b\u009c\u0001\u0010DR\"\u0010/\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u009d\u0001\u0010B\"\u0005\b\u009e\u0001\u0010DR\"\u00100\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u009f\u0001\u0010B\"\u0005\b \u0001\u0010DR$\u00101\u001a\u0004\u0018\u0001028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¡\u0001\u0010¢\u0001\"\u0006\b£\u0001\u0010¤\u0001R\"\u00103\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¥\u0001\u0010B\"\u0005\b¦\u0001\u0010DR$\u00104\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0002\u0010O\u001a\u0005\b§\u0001\u0010L\"\u0005\b¨\u0001\u0010NR$\u00105\u001a\u0004\u0018\u0001068\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b©\u0001\u0010ª\u0001\"\u0006\b«\u0001\u0010¬\u0001R\"\u00107\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u00ad\u0001\u0010B\"\u0005\b®\u0001\u0010DR$\u00108\u001a\u0004\u0018\u0001098\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¯\u0001\u0010°\u0001\"\u0006\b±\u0001\u0010²\u0001R$\u0010:\u001a\u0004\u0018\u00010;8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b³\u0001\u0010´\u0001\"\u0006\bµ\u0001\u0010¶\u0001R\"\u0010<\u001a\b\u0012\u0004\u0012\u00020\f0\u0014X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b·\u0001\u0010h\"\u0005\b¸\u0001\u0010jR\"\u0010=\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0014X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¹\u0001\u0010h\"\u0005\bº\u0001\u0010jR\u001c\u0010>\u001a\u00020\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b»\u0001\u0010B\"\u0005\b¼\u0001\u0010D¨\u0006ö\u0001"}, d2 = {"Lcom/larus/bmhome/chat/resp/BotInfo;", "Landroid/os/Parcelable;", "id", "", "name", "modelDescription", "humanDescription", "messagePush", "", "privateStatus", "", "model", "Lcom/larus/im/bean/bot/ModelItem;", "voice", "Lcom/larus/im/bean/bot/SpeakerVoice;", "muted", "botType", "botFeatureLabel", "botMode", "botConf", "", "Lcom/larus/im/bean/bot/BotConfItem;", "editPos", "createTime", "", "updateTime", "disabled", "recommendIndex", "disabledTag", "shareInfo", "Lcom/larus/im/bean/bot/ShareInfo;", "botCreatorInfo", "Lcom/larus/im/bean/bot/BotCreatorInfo;", "botStatus", "Lcom/larus/bmhome/chat/resp/BotStatus;", "bio", "conversationPage", "Lcom/larus/im/bean/bot/ConversationPage;", "answerActions", "Lcom/larus/im/bean/bot/AnswerAction;", "menuActions", "streamingAnswerActions", "iconImage", "Lcom/larus/im/bean/bot/BotIconImage;", "iconUrl", "iconUri", "bgImgUrl", "bgImgColor", "iconPrompt", "switchConfInfo", "Lcom/larus/bmhome/chat/resp/BotSwitchConfInfo;", "callerName", "callerNameSetting", "digitalHumanData", "Lcom/larus/im/bean/bot/BotDigitalHumanData;", "conversationID", "sceneModelList", "Lcom/larus/im/bean/bot/SceneModelList;", "firstMet", "Lcom/larus/im/bean/bot/FirstMet;", "modelList", "voiceList", "owner", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Lcom/larus/im/bean/bot/ModelItem;Lcom/larus/im/bean/bot/SpeakerVoice;Ljava/lang/Boolean;ILjava/lang/String;ILjava/util/List;Ljava/lang/String;JJZILjava/lang/String;Lcom/larus/im/bean/bot/ShareInfo;Lcom/larus/im/bean/bot/BotCreatorInfo;Lcom/larus/bmhome/chat/resp/BotStatus;Ljava/lang/String;Lcom/larus/im/bean/bot/ConversationPage;Ljava/util/List;Ljava/util/List;Ljava/util/List;Lcom/larus/im/bean/bot/BotIconImage;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/larus/bmhome/chat/resp/BotSwitchConfInfo;Ljava/lang/String;Ljava/lang/Boolean;Lcom/larus/im/bean/bot/BotDigitalHumanData;Ljava/lang/String;Lcom/larus/im/bean/bot/SceneModelList;Lcom/larus/im/bean/bot/FirstMet;Ljava/util/List;Ljava/util/List;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "getName", "setName", "getModelDescription", "setModelDescription", "getHumanDescription", "setHumanDescription", "getMessagePush", "()Ljava/lang/Boolean;", "setMessagePush", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getPrivateStatus", "()Ljava/lang/Integer;", "setPrivateStatus", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getModel", "()Lcom/larus/im/bean/bot/ModelItem;", "setModel", "(Lcom/larus/im/bean/bot/ModelItem;)V", "getVoice", "()Lcom/larus/im/bean/bot/SpeakerVoice;", "setVoice", "(Lcom/larus/im/bean/bot/SpeakerVoice;)V", "getMuted", "setMuted", "getBotType", "()I", "setBotType", "(I)V", "getBotFeatureLabel", "setBotFeatureLabel", "getBotMode", "setBotMode", "getBotConf", "()Ljava/util/List;", "setBotConf", "(Ljava/util/List;)V", "getEditPos", "setEditPos", "getCreateTime", "()J", "setCreateTime", "(J)V", "getUpdateTime", "setUpdateTime", "getDisabled", "()Z", "setDisabled", "(Z)V", "getRecommendIndex", "setRecommendIndex", "getDisabledTag", "setDisabledTag", "getShareInfo", "()Lcom/larus/im/bean/bot/ShareInfo;", "setShareInfo", "(Lcom/larus/im/bean/bot/ShareInfo;)V", "getBotCreatorInfo", "()Lcom/larus/im/bean/bot/BotCreatorInfo;", "setBotCreatorInfo", "(Lcom/larus/im/bean/bot/BotCreatorInfo;)V", "getBotStatus", "()Lcom/larus/bmhome/chat/resp/BotStatus;", "setBotStatus", "(Lcom/larus/bmhome/chat/resp/BotStatus;)V", "getBio", "setBio", "getConversationPage", "()Lcom/larus/im/bean/bot/ConversationPage;", "setConversationPage", "(Lcom/larus/im/bean/bot/ConversationPage;)V", "getAnswerActions", "setAnswerActions", "getMenuActions", "setMenuActions", "getStreamingAnswerActions", "setStreamingAnswerActions", "getIconImage", "()Lcom/larus/im/bean/bot/BotIconImage;", "setIconImage", "(Lcom/larus/im/bean/bot/BotIconImage;)V", "getIconUrl", "setIconUrl", "getIconUri", "setIconUri", "getBgImgUrl", "setBgImgUrl", "getBgImgColor", "setBgImgColor", "getIconPrompt", "setIconPrompt", "getSwitchConfInfo", "()Lcom/larus/bmhome/chat/resp/BotSwitchConfInfo;", "setSwitchConfInfo", "(Lcom/larus/bmhome/chat/resp/BotSwitchConfInfo;)V", "getCallerName", "setCallerName", "getCallerNameSetting", "setCallerNameSetting", "getDigitalHumanData", "()Lcom/larus/im/bean/bot/BotDigitalHumanData;", "setDigitalHumanData", "(Lcom/larus/im/bean/bot/BotDigitalHumanData;)V", "getConversationID", "setConversationID", "getSceneModelList", "()Lcom/larus/im/bean/bot/SceneModelList;", "setSceneModelList", "(Lcom/larus/im/bean/bot/SceneModelList;)V", "getFirstMet", "()Lcom/larus/im/bean/bot/FirstMet;", "setFirstMet", "(Lcom/larus/im/bean/bot/FirstMet;)V", "getModelList", "setModelList", "getVoiceList", "setVoiceList", "getOwner", "setOwner", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component39", "component40", "component41", "component42", "component43", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Lcom/larus/im/bean/bot/ModelItem;Lcom/larus/im/bean/bot/SpeakerVoice;Ljava/lang/Boolean;ILjava/lang/String;ILjava/util/List;Ljava/lang/String;JJZILjava/lang/String;Lcom/larus/im/bean/bot/ShareInfo;Lcom/larus/im/bean/bot/BotCreatorInfo;Lcom/larus/bmhome/chat/resp/BotStatus;Ljava/lang/String;Lcom/larus/im/bean/bot/ConversationPage;Ljava/util/List;Ljava/util/List;Ljava/util/List;Lcom/larus/im/bean/bot/BotIconImage;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/larus/bmhome/chat/resp/BotSwitchConfInfo;Ljava/lang/String;Ljava/lang/Boolean;Lcom/larus/im/bean/bot/BotDigitalHumanData;Ljava/lang/String;Lcom/larus/im/bean/bot/SceneModelList;Lcom/larus/im/bean/bot/FirstMet;Ljava/util/List;Ljava/util/List;Ljava/lang/String;)Lcom/larus/bmhome/chat/resp/BotInfo;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class BotInfo implements Parcelable {
    public static final Parcelable.Creator<BotInfo> CREATOR = null;
    public final transient List<ModelItem> a;

    @SerializedName("answer_actions")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private List<AnswerAction> answerActions;
    public final transient List<SpeakerVoice> b;

    @SerializedName("bg_img_avg_hue")
    private String bgImgColor;

    @SerializedName("bg_img_url")
    private String bgImgUrl;

    @SerializedName("bio")
    private String bio;

    @SerializedName("bot_conf")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private List<BotConfItem> botConf;

    @SerializedName("creator_info")
    private BotCreatorInfo botCreatorInfo;

    @SerializedName("bot_feature_label")
    private String botFeatureLabel;

    @SerializedName("bot_mode")
    private int botMode;

    @SerializedName("bot_stats")
    private BotStatus botStatus;

    @SerializedName("bot_type")
    private int botType;
    public final transient String c;

    @SerializedName("caller_name")
    private String callerName;

    @SerializedName("caller_name_setting")
    private Boolean callerNameSetting;

    @SerializedName("conversation_id")
    private String conversationID;

    @SerializedName("conversation_page")
    private com.larus.im.bean.bot.ConversationPage conversationPage;

    @SerializedName("create_time")
    @JsonAdapter(TimeTransformAdapter.class)
    private long createTime;

    @SerializedName("digital_human_data")
    private BotDigitalHumanData digitalHumanData;

    @SerializedName("disabled")
    private boolean disabled;

    @SerializedName("disabled_tag")
    private String disabledTag;

    @SerializedName("edit_pos")
    private String editPos;

    @SerializedName("first_met")
    private FirstMet firstMet;

    @SerializedName("description_for_human")
    private String humanDescription;

    @SerializedName("icon_image")
    private BotIconImage iconImage;

    @SerializedName("icon_prompt")
    private String iconPrompt;

    @SerializedName("icon_uri")
    private String iconUri;

    @SerializedName("icon_url")
    private String iconUrl;

    @SerializedName("id")
    private String id;

    @SerializedName("hover_answer_actions")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private List<AnswerAction> menuActions;

    @SerializedName("message_push")
    private Boolean messagePush;

    @SerializedName("model")
    private ModelItem model;

    @SerializedName("description_for_model")
    private String modelDescription;

    @SerializedName("muted")
    private Boolean muted;

    @SerializedName("name")
    private String name;

    @SerializedName("private_status")
    private Integer privateStatus;

    @SerializedName("recommend_index")
    private int recommendIndex;

    @SerializedName("call_model_list")
    private SceneModelList sceneModelList;

    @SerializedName("share_info")
    private ShareInfo shareInfo;

    @SerializedName("streaming_answer_actions")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private List<AnswerAction> streamingAnswerActions;

    @SerializedName("switch_conf")
    private BotSwitchConfInfo switchConfInfo;

    @SerializedName("update_time")
    @JsonAdapter(TimeTransformAdapter.class)
    private long updateTime;

    @SerializedName("voice_type")
    private SpeakerVoice voice;

    public static final class a {
    }

    public static final class b implements Parcelable.Creator<BotInfo> {
        public b() {
        }

        @Override // android.os.Parcelable.Creator
        public final BotInfo createFromParcel(Parcel r52) {
            Intrinsics.checkNotNullParameter(r52, "parcel");
            String r3 = r52.readString();
            String r4 = r52.readString();
            String r5 = r52.readString();
            String r6 = r52.readString();
            if (r52.readInt() != 0) goto L6;
            Boolean r1 = null;
        L11:
            if (r52.readInt() != 0) goto L13;
            Integer r9 = null;
        L14:
            ModelItem r10 = r52.readSerializable();
            SpeakerVoice r11 = r52.readSerializable();
            if (r52.readInt() != 0) goto L18;
            Boolean r12 = null;
        L22:
            int r13 = r52.readInt();
            String r14 = r52.readString();
            int r15 = r52.readInt();
            if (r52.readInt() != 0) goto L25;
            ArrayList r19 = null;
        L29:
            String r20 = r52.readString();
            long r21 = r52.readLong();
            long r23 = r52.readLong();
            if (r52.readInt() == 0) goto L32;
            boolean r25 = true;
        L33:
            int r26 = r52.readInt();
            String r27 = r52.readString();
            ShareInfo r28 = r52.readSerializable();
            BotCreatorInfo r29 = r52.readSerializable();
            if (r52.readInt() != 0) goto L36;
            BotStatus r2 = null;
        L37:
            BotStatus r30 = r2;
            String r31 = r52.readString();
            com.larus.im.bean.bot.ConversationPage r32 = r52.readSerializable();
            if (r52.readInt() != 0) goto L40;
            ArrayList r33 = null;
        L45:
            if (r52.readInt() != 0) goto L47;
            ArrayList r34 = null;
        L52:
            if (r52.readInt() != 0) goto L54;
            ArrayList r35 = null;
        L58:
            BotIconImage r36 = r52.readSerializable();
            String r37 = r52.readString();
            String r38 = r52.readString();
            String r39 = r52.readString();
            String r40 = r52.readString();
            String r41 = r52.readString();
            if (r52.readInt() != 0) goto L61;
            BotSwitchConfInfo r7 = null;
        L62:
            BotSwitchConfInfo r42 = r7;
            String r43 = r52.readString();
            if (r52.readInt() != 0) goto L66;
            Boolean r44 = null;
        L70:
            BotDigitalHumanData r45 = r52.readSerializable();
            String r46 = r52.readString();
            SceneModelList r48 = r52.readSerializable();
            FirstMet r49 = r52.readSerializable();
            int r8 = r52.readInt();
            ArrayList r16 = new ArrayList(r8);
            int r17 = 0;
        L71:
            if (r17 == r8) goto L73;
            r16.add(r52.readSerializable());
            r17 = r17 + 1;
            goto L71
        L73:
            int r0 = r52.readInt();
            ArrayList r18 = new ArrayList(r0);
            int r22 = 0;
        L74:
            if (r22 == r0) goto L76;
            int r110 = r0;
            r18.add(r52.readSerializable());
            r22 = r22 + 1;
            r0 = r110;
            goto L74
        L76:
            Boolean r24 = r1;
            Integer r47 = r9;
            Boolean r111 = r12;
            ArrayList r112 = r19;
            boolean r210 = r25;
            ArrayList r211 = r33;
            ArrayList r310 = r34;
            ArrayList r311 = r35;
            Boolean r410 = r44;
            return new BotInfo(r3, r4, r5, r6, r24, r47, r10, r11, r111, r13, r14, r15, r112, r20, r21, r23, r210, r26, r27, r28, r29, r30, r31, r32, r211, r310, r311, r36, r37, r38, r39, r40, r41, r42, r43, r410, r45, r46, r48, r49, r16, r18, r52.readString());
        L66:
            if (r52.readInt() == 0) goto L68;
            boolean r50 = true;
        L69:
            r44 = Boolean.valueOf(r50);
            goto L70
        L68:
            r50 = false;
            goto L69
        L61:
            r7 = BotSwitchConfInfo.CREATOR.createFromParcel(r52);
            goto L62
        L54:
            int r51 = r52.readInt();
            ArrayList r53 = new ArrayList(r51);
            int r54 = 0;
        L55:
            if (r54 == r51) goto L57;
            int r312 = r51;
            r53.add(r52.readSerializable());
            r54 = r54 + 1;
            r51 = r312;
            goto L55
        L57:
            r35 = r53;
            goto L58
        L47:
            int r55 = r52.readInt();
            ArrayList r56 = new ArrayList(r55);
            int r57 = 0;
        L48:
            if (r57 == r55) goto L50;
            int r313 = r55;
            r56.add(r52.readSerializable());
            r57 = r57 + 1;
            r55 = r313;
            goto L48
        L50:
            r34 = r56;
            goto L52
        L40:
            int r58 = r52.readInt();
            ArrayList r59 = new ArrayList(r58);
            int r60 = 0;
        L41:
            if (r60 == r58) goto L43;
            int r314 = r58;
            r59.add(r52.readSerializable());
            r60 = r60 + 1;
            r58 = r314;
            goto L41
        L43:
            r33 = r59;
            goto L45
        L36:
            r2 = BotStatus.CREATOR.createFromParcel(r52);
            goto L37
        L32:
            r25 = false;
            goto L33
        L25:
            int r61 = r52.readInt();
            ArrayList r62 = new ArrayList(r61);
            int r63 = 0;
        L26:
            if (r63 == r61) goto L28;
            int r113 = r61;
            r62.add(r52.readSerializable());
            r63 = r63 + 1;
            r61 = r113;
            goto L26
        L28:
            r19 = r62;
            goto L29
        L18:
            if (r52.readInt() == 0) goto L20;
            boolean r114 = true;
        L21:
            r12 = Boolean.valueOf(r114);
            goto L22
        L20:
            r114 = false;
            goto L21
        L13:
            r9 = Integer.valueOf(r52.readInt());
            goto L14
        L6:
            if (r52.readInt() == 0) goto L8;
            boolean r64 = true;
        L9:
            r1 = Boolean.valueOf(r64);
            goto L11
        L8:
            r64 = false;
            goto L9
        }

        @Override // android.os.Parcelable.Creator
        public final BotInfo[] newArray(int r1) {
            return new BotInfo[r1];
        }
    }

    static {
        CREATOR = new b();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof BotInfo) == true) goto L8;
        return false;
    L8:
        BotInfo r9 = (BotInfo) r8;
        if (Intrinsics.areEqual(this.id, r9.id) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.name, r9.name) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.modelDescription, r9.modelDescription) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.humanDescription, r9.humanDescription) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.messagePush, r9.messagePush) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.privateStatus, r9.privateStatus) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.model, r9.model) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.voice, r9.voice) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.muted, r9.muted) == true) goto L36;
        return false;
    L36:
        if (this.botType == r9.botType) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.botFeatureLabel, r9.botFeatureLabel) == true) goto L42;
        return false;
    L42:
        if (this.botMode == r9.botMode) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.botConf, r9.botConf) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.editPos, r9.editPos) == true) goto L51;
        return false;
    L51:
        if (this.createTime == r9.createTime) goto L54;
        return false;
    L54:
        if (this.updateTime == r9.updateTime) goto L57;
        return false;
    L57:
        if (this.disabled == r9.disabled) goto L60;
        return false;
    L60:
        if (this.recommendIndex == r9.recommendIndex) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.disabledTag, r9.disabledTag) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.shareInfo, r9.shareInfo) == true) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.botCreatorInfo, r9.botCreatorInfo) == true) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.botStatus, r9.botStatus) == true) goto L75;
        return false;
    L75:
        if (Intrinsics.areEqual(this.bio, r9.bio) == true) goto L78;
        return false;
    L78:
        if (Intrinsics.areEqual(this.conversationPage, r9.conversationPage) == true) goto L81;
        return false;
    L81:
        if (Intrinsics.areEqual(this.answerActions, r9.answerActions) == true) goto L84;
        return false;
    L84:
        if (Intrinsics.areEqual(this.menuActions, r9.menuActions) == true) goto L87;
        return false;
    L87:
        if (Intrinsics.areEqual(this.streamingAnswerActions, r9.streamingAnswerActions) == true) goto L90;
        return false;
    L90:
        if (Intrinsics.areEqual(this.iconImage, r9.iconImage) == true) goto L93;
        return false;
    L93:
        if (Intrinsics.areEqual(this.iconUrl, r9.iconUrl) == true) goto L96;
        return false;
    L96:
        if (Intrinsics.areEqual(this.iconUri, r9.iconUri) == true) goto L99;
        return false;
    L99:
        if (Intrinsics.areEqual(this.bgImgUrl, r9.bgImgUrl) == true) goto L102;
        return false;
    L102:
        if (Intrinsics.areEqual(this.bgImgColor, r9.bgImgColor) == true) goto L105;
        return false;
    L105:
        if (Intrinsics.areEqual(this.iconPrompt, r9.iconPrompt) == true) goto L108;
        return false;
    L108:
        if (Intrinsics.areEqual(this.switchConfInfo, r9.switchConfInfo) == true) goto L111;
        return false;
    L111:
        if (Intrinsics.areEqual(this.callerName, r9.callerName) == true) goto L114;
        return false;
    L114:
        if (Intrinsics.areEqual(this.callerNameSetting, r9.callerNameSetting) == true) goto L117;
        return false;
    L117:
        if (Intrinsics.areEqual(this.digitalHumanData, r9.digitalHumanData) == true) goto L120;
        return false;
    L120:
        if (Intrinsics.areEqual(this.conversationID, r9.conversationID) == true) goto L123;
        return false;
    L123:
        if (Intrinsics.areEqual(this.sceneModelList, r9.sceneModelList) == true) goto L126;
        return false;
    L126:
        if (Intrinsics.areEqual(this.firstMet, r9.firstMet) == true) goto L129;
        return false;
    L129:
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L132;
        return false;
    L132:
        if (Intrinsics.areEqual(this.b, r9.b) == true) goto L135;
        return false;
    L135:
        if (Intrinsics.areEqual(this.c, r9.c) == true) goto L137;
        return false;
    L137:
        return true;
    }

    public final int hashCode() {
        String r0 = this.id;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.name;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.modelDescription;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.humanDescription;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        Boolean r13 = this.messagePush;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        Integer r16 = this.privateStatus;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        ModelItem r19 = this.model;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        SpeakerVoice r22 = this.voice;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        Boolean r25 = this.muted;
        if (r25 != null) goto L37;
        int r26 = 0;
    L38:
        int r27 = (((r24 + r26) * 31) + this.botType) * 31;
        String r28 = this.botFeatureLabel;
        if (r28 != null) goto L41;
        int r29 = 0;
    L42:
        int r30 = (((r27 + r29) * 31) + this.botMode) * 31;
        List<BotConfItem> r31 = this.botConf;
        if (r31 != null) goto L45;
        int r32 = 0;
    L46:
        int r33 = (r30 + r32) * 31;
        String r34 = this.editPos;
        if (r34 != null) goto L49;
        int r35 = 0;
    L50:
        int r36 = (r33 + r35) * 31;
        long r37 = this.createTime;
        int r38 = (r36 + ((int) (r37 ^ (r37 >>> 32)))) * 31;
        long r39 = this.updateTime;
        int r40 = (r38 + ((int) (r39 ^ (r39 >>> 32)))) * 31;
        if (this.disabled == false) goto L53;
        int r41 = 1231;
    L54:
        int r42 = (((r40 + r41) * 31) + this.recommendIndex) * 31;
        String r43 = this.disabledTag;
        if (r43 != null) goto L57;
        int r44 = 0;
    L58:
        int r45 = (r42 + r44) * 31;
        ShareInfo r46 = this.shareInfo;
        if (r46 != null) goto L61;
        int r47 = 0;
    L62:
        int r48 = (r45 + r47) * 31;
        BotCreatorInfo r49 = this.botCreatorInfo;
        if (r49 != null) goto L65;
        int r50 = 0;
    L66:
        int r51 = (r48 + r50) * 31;
        BotStatus r52 = this.botStatus;
        if (r52 != null) goto L69;
        int r53 = 0;
    L70:
        int r54 = (r51 + r53) * 31;
        String r55 = this.bio;
        if (r55 != null) goto L73;
        int r56 = 0;
    L74:
        int r57 = (r54 + r56) * 31;
        com.larus.im.bean.bot.ConversationPage r58 = this.conversationPage;
        if (r58 != null) goto L77;
        int r59 = 0;
    L78:
        int r60 = (r57 + r59) * 31;
        List<AnswerAction> r61 = this.answerActions;
        if (r61 != null) goto L81;
        int r62 = 0;
    L82:
        int r63 = (r60 + r62) * 31;
        List<AnswerAction> r64 = this.menuActions;
        if (r64 != null) goto L85;
        int r65 = 0;
    L86:
        int r66 = (r63 + r65) * 31;
        List<AnswerAction> r67 = this.streamingAnswerActions;
        if (r67 != null) goto L89;
        int r68 = 0;
    L90:
        int r69 = (r66 + r68) * 31;
        BotIconImage r70 = this.iconImage;
        if (r70 != null) goto L93;
        int r71 = 0;
    L94:
        int r72 = (r69 + r71) * 31;
        String r73 = this.iconUrl;
        if (r73 != null) goto L97;
        int r74 = 0;
    L98:
        int r75 = (r72 + r74) * 31;
        String r76 = this.iconUri;
        if (r76 != null) goto L101;
        int r77 = 0;
    L102:
        int r78 = (r75 + r77) * 31;
        String r79 = this.bgImgUrl;
        if (r79 != null) goto L105;
        int r80 = 0;
    L106:
        int r81 = (r78 + r80) * 31;
        String r82 = this.bgImgColor;
        if (r82 != null) goto L109;
        int r83 = 0;
    L110:
        int r84 = (r81 + r83) * 31;
        String r85 = this.iconPrompt;
        if (r85 != null) goto L113;
        int r86 = 0;
    L114:
        int r87 = (r84 + r86) * 31;
        BotSwitchConfInfo r88 = this.switchConfInfo;
        if (r88 != null) goto L117;
        int r89 = 0;
    L118:
        int r90 = (r87 + r89) * 31;
        String r91 = this.callerName;
        if (r91 != null) goto L121;
        int r92 = 0;
    L122:
        int r93 = (r90 + r92) * 31;
        Boolean r94 = this.callerNameSetting;
        if (r94 != null) goto L125;
        int r95 = 0;
    L126:
        int r96 = (r93 + r95) * 31;
        BotDigitalHumanData r97 = this.digitalHumanData;
        if (r97 != null) goto L129;
        int r99 = 0;
    L130:
        int r100 = (r96 + r99) * 31;
        String r101 = this.conversationID;
        if (r101 != null) goto L133;
        int r102 = 0;
    L134:
        int r103 = (r100 + r102) * 31;
        SceneModelList r104 = this.sceneModelList;
        if (r104 != null) goto L137;
        int r105 = 0;
    L138:
        int r106 = (r103 + r105) * 31;
        FirstMet r107 = this.firstMet;
        if (r107 == null) goto L143;
        r1 = r107.hashCode();
    L143:
        return ((((((r106 + r1) * 31) + this.a.hashCode()) * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    L137:
        r105 = r104.hashCode();
        goto L138
    L133:
        r102 = r101.hashCode();
        goto L134
    L129:
        r99 = r97.hashCode();
        goto L130
    L125:
        r95 = r94.hashCode();
        goto L126
    L121:
        r92 = r91.hashCode();
        goto L122
    L117:
        r89 = r88.hashCode();
        goto L118
    L113:
        r86 = r85.hashCode();
        goto L114
    L109:
        r83 = r82.hashCode();
        goto L110
    L105:
        r80 = r79.hashCode();
        goto L106
    L101:
        r77 = r76.hashCode();
        goto L102
    L97:
        r74 = r73.hashCode();
        goto L98
    L93:
        r71 = r70.hashCode();
        goto L94
    L89:
        r68 = r67.hashCode();
        goto L90
    L85:
        r65 = r64.hashCode();
        goto L86
    L81:
        r62 = r61.hashCode();
        goto L82
    L77:
        r59 = r58.hashCode();
        goto L78
    L73:
        r56 = r55.hashCode();
        goto L74
    L69:
        r53 = r52.hashCode();
        goto L70
    L65:
        r50 = r49.hashCode();
        goto L66
    L61:
        r47 = r46.hashCode();
        goto L62
    L57:
        r44 = r43.hashCode();
        goto L58
    L53:
        r41 = 1237;
        goto L54
    L49:
        r35 = r34.hashCode();
        goto L50
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
        return "BotInfo(id=" + this.id + ", name=" + this.name + ", modelDescription=" + this.modelDescription + ", humanDescription=" + this.humanDescription + ", messagePush=" + this.messagePush + ", privateStatus=" + this.privateStatus + ", model=" + this.model + ", voice=" + this.voice + ", muted=" + this.muted + ", botType=" + this.botType + ", botFeatureLabel=" + this.botFeatureLabel + ", botMode=" + this.botMode + ", botConf=" + this.botConf + ", editPos=" + this.editPos + ", createTime=" + this.createTime + ", updateTime=" + this.updateTime + ", disabled=" + this.disabled + ", recommendIndex=" + this.recommendIndex + ", disabledTag=" + this.disabledTag + ", shareInfo=" + this.shareInfo + ", botCreatorInfo=" + this.botCreatorInfo + ", botStatus=" + this.botStatus + ", bio=" + this.bio + ", conversationPage=" + this.conversationPage + ", answerActions=" + this.answerActions + ", menuActions=" + this.menuActions + ", streamingAnswerActions=" + this.streamingAnswerActions + ", iconImage=" + this.iconImage + ", iconUrl=" + this.iconUrl + ", iconUri=" + this.iconUri + ", bgImgUrl=" + this.bgImgUrl + ", bgImgColor=" + this.bgImgColor + ", iconPrompt=" + this.iconPrompt + ", switchConfInfo=" + this.switchConfInfo + ", callerName=" + this.callerName + ", callerNameSetting=" + this.callerNameSetting + ", digitalHumanData=" + this.digitalHumanData + ", conversationID=" + this.conversationID + ", sceneModelList=" + this.sceneModelList + ", firstMet=" + this.firstMet + ", modelList=" + this.a + ", voiceList=" + this.b + ", owner=" + this.c + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r6, int r7) {
        Intrinsics.checkNotNullParameter(r6, "dest");
        r6.writeString(this.id);
        r6.writeString(this.name);
        r6.writeString(this.modelDescription);
        r6.writeString(this.humanDescription);
        Boolean r0 = this.messagePush;
        if (r0 != null) goto L5;
        r6.writeInt(0);
    L6:
        Integer r1 = this.privateStatus;
        if (r1 != null) goto L9;
        r6.writeInt(0);
    L10:
        r6.writeSerializable(this.model);
        r6.writeSerializable(this.voice);
        Boolean r2 = this.muted;
        if (r2 != null) goto L13;
        r6.writeInt(0);
    L14:
        r6.writeInt(this.botType);
        r6.writeString(this.botFeatureLabel);
        r6.writeInt(this.botMode);
        List<BotConfItem> r3 = this.botConf;
        if (r3 != null) goto L17;
        r6.writeInt(0);
    L21:
        r6.writeString(this.editPos);
        r6.writeLong(this.createTime);
        r6.writeLong(this.updateTime);
        r6.writeInt(this.disabled ? 1 : 0);
        r6.writeInt(this.recommendIndex);
        r6.writeString(this.disabledTag);
        r6.writeSerializable(this.shareInfo);
        r6.writeSerializable(this.botCreatorInfo);
        BotStatus r4 = this.botStatus;
        if (r4 != null) goto L24;
        r6.writeInt(0);
    L25:
        r6.writeString(this.bio);
        r6.writeSerializable(this.conversationPage);
        List<AnswerAction> r5 = this.answerActions;
        if (r5 != null) goto L28;
        r6.writeInt(0);
    L32:
        List<AnswerAction> r8 = this.menuActions;
        if (r8 != null) goto L35;
        r6.writeInt(0);
    L39:
        List<AnswerAction> r9 = this.streamingAnswerActions;
        if (r9 != null) goto L42;
        r6.writeInt(0);
    L46:
        r6.writeSerializable(this.iconImage);
        r6.writeString(this.iconUrl);
        r6.writeString(this.iconUri);
        r6.writeString(this.bgImgUrl);
        r6.writeString(this.bgImgColor);
        r6.writeString(this.iconPrompt);
        BotSwitchConfInfo r10 = this.switchConfInfo;
        if (r10 != null) goto L49;
        r6.writeInt(0);
    L50:
        r6.writeString(this.callerName);
        Boolean r11 = this.callerNameSetting;
        if (r11 != null) goto L53;
        r6.writeInt(0);
    L54:
        r6.writeSerializable(this.digitalHumanData);
        r6.writeString(this.conversationID);
        r6.writeSerializable(this.sceneModelList);
        r6.writeSerializable(this.firstMet);
        List<ModelItem> r12 = this.a;
        r6.writeInt(r12.size());
        Iterator<ModelItem> r13 = r12.iterator();
    L56:
        if (r13.hasNext() == false) goto L58;
        r6.writeSerializable((Serializable) r13.next());
        goto L56
    L58:
        List<SpeakerVoice> r14 = this.b;
        r6.writeInt(r14.size());
        Iterator<SpeakerVoice> r15 = r14.iterator();
    L60:
        if (r15.hasNext() == false) goto L62;
        r6.writeSerializable((Serializable) r15.next());
        goto L60
    L62:
        r6.writeString(this.c);
        return;
    L53:
        r6.writeInt(1);
        r6.writeInt(r11.booleanValue() ? 1 : 0);
        goto L54
    L49:
        r6.writeInt(1);
        r10.writeToParcel(r6, r7);
        goto L50
    L42:
        r6.writeInt(1);
        r6.writeInt(r9.size());
        Iterator<AnswerAction> r16 = r9.iterator();
    L44:
        if (r16.hasNext() == false) goto L46;
        r6.writeSerializable((Serializable) r16.next());
        goto L44
    L35:
        r6.writeInt(1);
        r6.writeInt(r8.size());
        Iterator<AnswerAction> r17 = r8.iterator();
    L37:
        if (r17.hasNext() == false) goto L39;
        r6.writeSerializable((Serializable) r17.next());
        goto L37
    L28:
        r6.writeInt(1);
        r6.writeInt(r5.size());
        Iterator<AnswerAction> r18 = r5.iterator();
    L30:
        if (r18.hasNext() == false) goto L32;
        r6.writeSerializable((Serializable) r18.next());
        goto L30
    L24:
        r6.writeInt(1);
        r4.writeToParcel(r6, r7);
        goto L25
    L17:
        r6.writeInt(1);
        r6.writeInt(r3.size());
        Iterator<BotConfItem> r19 = r3.iterator();
    L19:
        if (r19.hasNext() == false) goto L21;
        r6.writeSerializable((Serializable) r19.next());
        goto L19
    L13:
        r6.writeInt(1);
        r6.writeInt(r2.booleanValue() ? 1 : 0);
        goto L14
    L9:
        r6.writeInt(1);
        r6.writeInt(r1.intValue());
        goto L10
    L5:
        r6.writeInt(1);
        r6.writeInt(r0.booleanValue() ? 1 : 0);
        goto L6
    }

    public BotInfo() {
        Boolean r38 = Boolean.FALSE;
        AppHost.Companion r0 = AppHost.a;
        this("", "", "", "", r38, null, null, null, r38, 2, null, -1, null, "", r0.getAppClock().currentTimeMillis(), r0.getAppClock().currentTimeMillis() / ((long) 1000), false, 0, "null", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, r38, null, null, null, null, CollectionsKt.emptyList(), CollectionsKt.emptyList(), "");
    }

    public BotInfo(String r7, String r8, String r9, String r10, Boolean r11, Integer r12, ModelItem r13, SpeakerVoice r14, Boolean r15, int r16, String r17, int r18, List<BotConfItem> r19, String r20, long r21, long r23, boolean r25, int r26, String r27, ShareInfo r28, BotCreatorInfo r29, BotStatus r30, String r31, com.larus.im.bean.bot.ConversationPage r32, List<AnswerAction> r33, List<AnswerAction> r34, List<AnswerAction> r35, BotIconImage r36, String r37, String r38, String r39, String r40, String r41, BotSwitchConfInfo r42, String r43, Boolean r44, BotDigitalHumanData r45, String r46, SceneModelList r47, FirstMet r48, List<ModelItem> r49, List<SpeakerVoice> r50, String r51) {
        Intrinsics.checkNotNullParameter(r49, "modelList");
        Intrinsics.checkNotNullParameter(r50, "voiceList");
        Intrinsics.checkNotNullParameter(r51, "owner");
        this.id = r7;
        this.name = r8;
        this.modelDescription = r9;
        this.humanDescription = r10;
        this.messagePush = r11;
        this.privateStatus = r12;
        this.model = r13;
        this.voice = r14;
        this.muted = r15;
        this.botType = r16;
        this.botFeatureLabel = r17;
        this.botMode = r18;
        this.botConf = r19;
        this.editPos = r20;
        this.createTime = r21;
        this.updateTime = r23;
        this.disabled = r25;
        this.recommendIndex = r26;
        this.disabledTag = r27;
        this.shareInfo = r28;
        this.botCreatorInfo = r29;
        this.botStatus = r30;
        this.bio = r31;
        this.conversationPage = r32;
        this.answerActions = r33;
        this.menuActions = r34;
        this.streamingAnswerActions = r35;
        this.iconImage = r36;
        this.iconUrl = r37;
        this.iconUri = r38;
        this.bgImgUrl = r39;
        this.bgImgColor = r40;
        this.iconPrompt = r41;
        this.switchConfInfo = r42;
        this.callerName = r43;
        this.callerNameSetting = r44;
        this.digitalHumanData = r45;
        this.conversationID = r46;
        this.sceneModelList = r47;
        this.firstMet = r48;
        this.a = r49;
        this.b = r50;
        this.c = r51;
    }
}
