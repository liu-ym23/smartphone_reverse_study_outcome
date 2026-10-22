package com.larksuite.component.card.component.text;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.Layout;
import android.text.TextUtils;
import android.util.LruCache;
import android.util.TypedValue;
import com.bytedance.ies.xelement.text.inlinetruncation.LynxInlineTruncationShadowNode;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.Gson;
import com.larksuite.component.card.component.text.span.UniversalCardPrefixSpanUtils;
import com.larksuite.component.card.component.udicon.UDIconContentProps;
import com.larksuite.component.card.protocol.CardData;
import com.larksuite.component.card.protocol.component.BaseComponentShareData;
import com.larksuite.component.card.protocol.data.CardAttachment;
import com.larksuite.component.card.protocol.data.CardContent;
import com.larksuite.component.ui.toast.LKUIToast;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larksuite.framework.utils.UIUtils;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.EventEmitter;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.shadow.LayoutNode;
import com.lynx.tasm.behavior.shadow.MeasureMode;
import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.card.audio.CardAudioInfo;
import com.ss.android.lark.widget.richtext.RichTextElement;
import com.ss.android.lark.widget.span.PrefixInfo;
import com.ss.android.lark.widget.span.PrefixSpan;
import com.ss.android.lark.widget.span.PrefixSpanStyle;
import com.ss.android.lark.widget.span.RecogniseSpansResult;
import com.ss.android.lark.widget.span.SpanInfo;
import com.ss.android.lark.widget.span.TextStyleInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000ì\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 ©\u00012\u00020\u00012\u00020\u0002:\u0002©\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u001b\u001a\u00020\u001cH\u0016J(\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\f2\u0006\u0010 \u001a\u00020\f2\u0006\u0010!\u001a\u00020\fH\u0016J\n\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u0010\u0010$\u001a\u00020\u001c2\u0006\u0010%\u001a\u00020&H\u0007J\u0010\u0010'\u001a\u00020\u001c2\u0006\u0010%\u001a\u00020\u0006H\u0002J\u0010\u0010(\u001a\u00020\n2\u0006\u0010%\u001a\u00020\u0006H\u0002J\u009c\u0003\u0010)\u001a\u00020\u001c2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020,0+2\u0006\u0010-\u001a\u00020\f2\u0006\u0010.\u001a\u00020/2\n\u00100\u001a\u000601j\u0002`22\u0006\u0010%\u001a\u00020\u00062\b\u00103\u001a\u0004\u0018\u0001042\u0016\u00105\u001a\u0012\u0012\u0004\u0012\u00020706j\b\u0012\u0004\u0012\u000207`82\u0016\u00109\u001a\u0012\u0012\u0004\u0012\u00020:06j\b\u0012\u0004\u0012\u00020:`82\u0016\u0010;\u001a\u0012\u0012\u0004\u0012\u00020<06j\b\u0012\u0004\u0012\u00020<`82\u0016\u0010=\u001a\u0012\u0012\u0004\u0012\u00020>06j\b\u0012\u0004\u0012\u00020>`82\u0016\u0010?\u001a\u0012\u0012\u0004\u0012\u00020@06j\b\u0012\u0004\u0012\u00020@`82\u0016\u0010A\u001a\u0012\u0012\u0004\u0012\u00020B06j\b\u0012\u0004\u0012\u00020B`82\u0016\u0010C\u001a\u0012\u0012\u0004\u0012\u00020D06j\b\u0012\u0004\u0012\u00020D`82\u0016\u0010E\u001a\u0012\u0012\u0004\u0012\u00020F06j\b\u0012\u0004\u0012\u00020F`82\u0016\u0010G\u001a\u0012\u0012\u0004\u0012\u00020H06j\b\u0012\u0004\u0012\u00020H`82\u0016\u0010I\u001a\u0012\u0012\u0004\u0012\u00020J06j\b\u0012\u0004\u0012\u00020J`82\u0016\u0010K\u001a\u0012\u0012\u0004\u0012\u00020L06j\b\u0012\u0004\u0012\u00020L`82\u0016\u0010M\u001a\u0012\u0012\u0004\u0012\u00020N06j\b\u0012\u0004\u0012\u00020N`82\u0016\u0010O\u001a\u0012\u0012\u0004\u0012\u00020P06j\b\u0012\u0004\u0012\u00020P`82\u0016\u0010Q\u001a\u0012\u0012\u0004\u0012\u00020R06j\b\u0012\u0004\u0012\u00020R`82\u0006\u0010S\u001a\u00020\fH\u0002J\u001e\u0010T\u001a\u00020\u00162\u0006\u0010U\u001a\u00020\f2\f\u0010V\u001a\b\u0012\u0004\u0012\u00020W0+H\u0002J\u001c\u0010X\u001a\u0004\u0018\u00010Y2\u0006\u0010%\u001a\u00020\u00062\b\u00103\u001a\u0004\u0018\u000104H\u0002J\u001c\u0010Z\u001a\u00020\u001c2\u0006\u0010[\u001a\u00020,2\n\u00100\u001a\u000601j\u0002`2H\u0002J\u001c\u0010\\\u001a\u000e\u0012\u0004\u0012\u00020^\u0012\u0004\u0012\u00020B0]2\u0006\u0010_\u001a\u00020WH\u0002J=\u0010`\u001a\u0004\u0018\u00010F2\b\u0010a\u001a\u0004\u0018\u00010b2\b\u0010c\u001a\u0004\u0018\u0001042\u0006\u0010d\u001a\u0002012\u0006\u0010S\u001a\u00020\f2\b\u0010e\u001a\u0004\u0018\u00010\u0016H\u0002¢\u0006\u0002\u0010fJ\u0010\u0010g\u001a\u00020\u00122\u0006\u0010h\u001a\u00020iH\u0002J\u0010\u0010j\u001a\u00020\u00122\u0006\u0010h\u001a\u00020iH\u0002JF\u0010k\u001a\u0002072\u0006\u0010l\u001a\u00020m2\u0006\u0010n\u001a\u00020\u00122\u0006\u0010o\u001a\u00020p2\n\u00100\u001a\u000601j\u0002`22\b\u0010q\u001a\u0004\u0018\u00010Y2\u0006\u0010r\u001a\u00020\u00162\u0006\u0010s\u001a\u00020\u0012H\u0002J6\u0010t\u001a\u00020J2\u0006\u0010l\u001a\u00020m2\u0006\u0010u\u001a\u00020v2\n\u00100\u001a\u000601j\u0002`22\b\u0010q\u001a\u0004\u0018\u00010Y2\u0006\u0010w\u001a\u00020\u0012H\u0002J\u0018\u0010x\u001a\u00020\f2\u0006\u0010y\u001a\u00020\f2\u0006\u0010u\u001a\u00020vH\u0002J\u0017\u0010z\u001a\u00020\f2\b\u0010{\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0002\u0010|J$\u0010}\u001a\u00020L2\u0006\u0010l\u001a\u00020m2\u0006\u0010~\u001a\u00020\u007f2\n\u00100\u001a\u000601j\u0002`2H\u0002J8\u0010\u0080\u0001\u001a\u00020@2\u0006\u0010l\u001a\u00020m2\b\u0010\u0081\u0001\u001a\u00030\u0082\u00012\n\u00100\u001a\u000601j\u0002`22\u0007\u0010\u0083\u0001\u001a\u00020\u00162\u0006\u0010S\u001a\u00020\fH\u0002J'\u0010\u0084\u0001\u001a\u00020:2\u0006\u0010l\u001a\u00020m2\b\u0010\u0085\u0001\u001a\u00030\u0086\u00012\n\u00100\u001a\u000601j\u0002`2H\u0002J\u001a\u0010\u0087\u0001\u001a\u00020\f2\u0006\u0010l\u001a\u00020m2\u0007\u0010\u0088\u0001\u001a\u00020\u0012H\u0002J!\u0010\u0089\u0001\u001a\u0004\u0018\u00010<2\b\u0010\u008a\u0001\u001a\u00030\u008b\u00012\n\u00100\u001a\u000601j\u0002`2H\u0002J0\u0010\u008c\u0001\u001a\u00020P2\u0006\u0010l\u001a\u00020m2\b\u0010\u008d\u0001\u001a\u00030\u008e\u00012\n\u00100\u001a\u000601j\u0002`22\u0007\u0010\u008f\u0001\u001a\u00020\u0016H\u0002J/\u0010\u0090\u0001\u001a\u00020R2\u0006\u0010l\u001a\u00020m2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0091\u0001\u001a\u00030\u0092\u00012\n\u00100\u001a\u000601j\u0002`2H\u0002J\u001a\u0010\u0093\u0001\u001a\u00020\f2\u0006\u0010l\u001a\u00020m2\u0007\u0010\u0094\u0001\u001a\u00020\u007fH\u0002J\u0011\u0010\u0095\u0001\u001a\u00020\f2\u0006\u0010l\u001a\u00020mH\u0002JJ\u0010\u0096\u0001\u001a\u00020\u001c2\u0006\u0010l\u001a\u00020m2\n\u00100\u001a\u000601j\u0002`22\u0007\u0010\u0097\u0001\u001a\u00020>2\u0007\u0010\u0094\u0001\u001a\u00020\u007f2\u0007\u0010\u0098\u0001\u001a\u00020\u00162\u0006\u0010w\u001a\u00020\u00122\b\b\u0002\u0010r\u001a\u00020\u0016H\u0002J\u001b\u0010\u0099\u0001\u001a\u00020\u001c2\u0007\u0010\u0097\u0001\u001a\u00020>2\u0007\u0010\u0094\u0001\u001a\u00020\u007fH\u0002J\u0013\u0010\u009a\u0001\u001a\u00020\u00122\b\u0010d\u001a\u0004\u0018\u00010\u0012H\u0002J\u0011\u0010\u009b\u0001\u001a\u00020\u00122\u0006\u0010d\u001a\u00020\u0012H\u0002J:\u0010\u009c\u0001\u001a\u00030\u009d\u00012\b\u0010\u009e\u0001\u001a\u00030\u009f\u00012\u0007\u0010 \u001a\u00030 \u00012\b\u0010¡\u0001\u001a\u00030¢\u00012\u0007\u0010!\u001a\u00030 \u00012\b\u0010£\u0001\u001a\u00030¢\u0001H\u0016J\t\u0010¤\u0001\u001a\u00020\u001cH\u0002J\t\u0010¥\u0001\u001a\u00020\fH\u0002J\u000b\u0010¦\u0001\u001a\u0004\u0018\u000104H\u0002J\f\u0010§\u0001\u001a\u0005\u0018\u00010¨\u0001H\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0018¨\u0006ª\u0001"}, d2 = {"Lcom/larksuite/component/card/component/text/UniversalCardTextShadowNode;", "Lcom/lynx/tasm/behavior/shadow/ShadowNode;", "Lcom/lynx/tasm/behavior/shadow/MeasureFunc;", "<init>", "()V", "textContent", "Lcom/larksuite/component/card/component/text/TextProps;", "textRender", "Lcom/larksuite/component/card/component/text/UniversalCardTextRender;", "spannableString", "", "contentPropsSize", "", "textColorBySpanParse", "textAttributes", "Lcom/larksuite/component/card/component/text/UniversalCardTextAttributes;", "localFontColor", "id", "", "parentId", "parentTotalTextLines", "fgInlineCodeRemoveZeroWidthSpace", "", "getFgInlineCodeRemoveZeroWidthSpace", "()Z", "fgInlineCodeRemoveZeroWidthSpace$delegate", "Lkotlin/Lazy;", "onLayoutBefore", "", "onLayout", "x", "y", "width", "height", "getExtraBundle", "", "setContent", "props", "Lcom/lynx/react/bridge/ReadableMap;", "setTextAttributes", "getSpannableString", "parseElement", "elementList", "", "Lcom/larksuite/component/card/component/text/ContentProps;", "elementIndex", "lynxContext", "Lcom/lynx/tasm/behavior/LynxContext;", "contentBuilder", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "lynxContextShareData", "Lcom/larksuite/component/card/cardcontainer/UniversalCardShareData;", "atInfos", "Ljava/util/ArrayList;", "Lcom/ss/android/lark/widget/span/AtInfo;", "Lkotlin/collections/ArrayList;", "urlInfos", "Lcom/ss/android/lark/widget/span/UrlInfo;", "emojiInfos", "Lcom/ss/android/lark/widget/span/EmojiconInfo;", "textStyleInfos", "Lcom/ss/android/lark/widget/span/TextStyleInfo;", "labelInfos", "Lcom/ss/android/lark/widget/span/LabelInfo;", "prefixInfos", "Lcom/ss/android/lark/widget/span/PrefixInfo;", "codeBlockV2Infos", "Lcom/ss/android/lark/widget/codeblock/preview/CodeBlockV2Info;", "imageInfos", "Lcom/ss/android/lark/widget/span/ImageInfo;", "alignInfos", "Lcom/ss/android/lark/widget/span/AlignInfo;", "personInfos", "Lcom/ss/android/lark/widget/span/PersonInfo;", "inlineCodeInfos", "Lcom/ss/android/lark/widget/span/InlineCodeInfo;", "spacingInfos", "Lcom/ss/android/lark/widget/span/SpacingInfo;", "numberTagInfos", "Lcom/ss/android/lark/widget/span/NumberTagInfo;", "audioInfos", "Lcom/ss/android/lark/widget/card/audio/CardAudioInfo;", "itemLeftMargin", "fixList", "index", "listElementProps", "Lcom/larksuite/component/card/component/text/ListItem;", "getAttachment", "Lcom/larksuite/component/card/protocol/data/CardAttachment;", "switchNextLine", "element", "parsePrefixSpan", "Lkotlin/Pair;", "Lcom/ss/android/lark/widget/span/PrefixSpan;", "it", "parseImageInfo", "imageProps", "Lcom/larksuite/component/card/component/image/ImageContentProps;", "shareData", "content", "translateElement", "(Lcom/larksuite/component/card/component/image/ImageContentProps;Lcom/larksuite/component/card/cardcontainer/UniversalCardShareData;Ljava/lang/StringBuilder;ILjava/lang/Boolean;)Lcom/ss/android/lark/widget/span/ImageInfo;", "getImageKey", "image", "Lcom/ss/android/lark/widget/richtext/Image;", "getImageUrl", "parseAtInfo", "context", "Landroid/content/Context;", "tag", "atInfoMap", "Lcom/larksuite/component/card/component/text/AtProps;", "attachment", "disableAtStyle", "atTag", "parsePersonInfo", "personProps", "Lcom/larksuite/component/card/component/text/PersonProps;", "textTag", "getAvatarSize", "lineHeight", "getLineHeight", "textSize", "(Ljava/lang/Integer;)I", "parseInlineCodeInfo", "inlineCodeProps", "Lcom/larksuite/component/card/component/text/PlainTextProps;", "parseLabelInfo", "tagProps", "Lcom/larksuite/component/card/component/text/TagProps;", "disableTagStyle", "parseUrlInfo", "urlInfoMap", "Lcom/larksuite/component/card/component/text/LinkProps;", "getColorResIdByToken", "color", "parseEmojInfo", "emojInfoMap", "Lcom/larksuite/component/card/component/text/EmojProps;", "parseNumberTag", "numberTagProps", "Lcom/larksuite/component/card/component/text/NumberTagProps;", "disableNumberTagStyle", "parseAudioInfo", "audioProps", "Lcom/larksuite/component/card/component/text/AudioProps;", "parseTextSize", "infoMap", "getDefaultTextSize", "parseTextStyleInfo", "textStyleInfo", "isExactlyTextStyle", "parseColorStyleInfo", "getAtContent", "getContentWithAtIfNeed", "measure", "", "node", "Lcom/lynx/tasm/behavior/shadow/LayoutNode;", "", "widthMode", "Lcom/lynx/tasm/behavior/shadow/MeasureMode;", "heightMode", "updateAvailableLines", "occupyLinesIfNeed", "getCardShareData", "getTextShareData", "Lcom/larksuite/component/card/component/text/UniversalCardTextShareData;", "Companion", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class UniversalCardTextShadowNode extends ShadowNode implements y6a.h {
    public final d A;
    public int B;
    public String C;
    public String D;
    public int E;
    public final Lazy F;
    public TextProps v;
    public u w;
    public CharSequence x;
    public int y;
    public int z;

    public static final class a {
    }

    static {
    }

    public final UniversalCardTextShareData E() {
        LynxContext r0 = ((ShadowNode) this).m;
        BaseComponentShareData r1 = null;
        if (r0 == null) goto L5;
        com.larksuite.component.card.cardcontainer.c r2 = (com.larksuite.component.card.cardcontainer.c) r0.getSharedData("card_share_data", com.larksuite.component.card.cardcontainer.c.class);
    L6:
        if (r2 != null) goto L8;
        return null;
    L8:
        cz7.a r3 = r2.e;
        String r4 = this.D;
        if (r4 != null) goto L11;
        return null;
    L11:
        String r5 = r4 + '_' + r2.c.getKey();
        r3.getClass();
        Intrinsics.checkNotNullParameter(r5, "id");
        Intrinsics.checkNotNullParameter(UniversalCardTextShareData.class, "dataClass");
        BaseComponentShareData r6 = (BaseComponentShareData) ((LinkedHashMap) r3.a).get(r5);
        if (r6 != null) goto L14;
    L17:
        Log.d("ComponentShareDataStore", "ComponentShareDataStore with id: " + r5 + ", create new");
        Object r7 = UniversalCardTextShareData.class.getConstructor(new Class[]{String.class}).newInstance(new Object[]{r5});     // Catch: Throwable -> L20
        r3.a.put(r5, (BaseComponentShareData) r7);     // Catch: Throwable -> L20
        r6 = (BaseComponentShareData) r7;     // Catch: Throwable -> L20
    L16:
        r1 = r6;
    L22:
        return (UniversalCardTextShareData) r1;
    L20:
        Log.e("ComponentShareDataStore", "getOrCreate error, id=" + r5 + ", class=" + UniversalCardTextShareData.class.getName());
        goto L22
    L14:
        if (UniversalCardTextShareData.class.isAssignableFrom(r6.getClass()) == false) goto L17;
        Log.d("ComponentShareDataStore", "ComponentShareDataStore with id: " + r5 + ", find");
        goto L16
    L5:
        r2 = null;
        goto L6
    }

    public final void g() {
        if ((this instanceof LynxInlineTruncationShadowNode) == true) goto L6;
        this.w = null;
        return;
    }

    public final Object m() {
        u r0 = this.w;
        if (r0 != null) goto L5;
        return null;
    L5:
        Layout r2 = r0.d;
        if (r2 != null) goto L8;
        return null;
    L8:
        return new c(this.v, r2, this.z, r0.g);
    }

    public UniversalCardTextShadowNode() {
        this.A = new d();
        this.E = LKUIToast.DURATION_MAX;
        this.F = LazyKt.lazy(UniversalCardTextShadowNode$fgInlineCodeRemoveZeroWidthSpace$2.INSTANCE);
        if ((this instanceof LynxInlineTruncationShadowNode) == true) goto L6;
        i(this);
        return;
    }

    public static String C(String r4) {
        if (r4 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L13;
        Log.e("MsgCardTextShadowNode", "At content is null");
        return "";
    L13:
        if (StringsKt.startsWith$default(r4, "@", false, 2, null) == false) goto L15;
        return r4;
    L15:
        return "@" + r4;
    L5:
        if (r4.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    public final Pair<PrefixSpan, PrefixInfo> I(ListItem r12) {
        RichTextElement.OLProperty.Type r0 = RichTextElement.OLProperty.Type.NUMBER;
        if (Intrinsics.areEqual(r12.getType(), "ul") == false) goto L12;
        if ((r12.getLevel() % 3) != 0) goto L8;
        PrefixSpan.Type r1 = PrefixSpan.Type.FILL_CIRCLE;
    L19:
        PrefixSpan.Type r3 = PrefixSpan.Type.LIST_NUM;
        if (r1 != r3) goto L40;
        Integer r6 = r12.getOrder();
        if (r6 != null) goto L24;
    L26:
        int r7 = 1;
    L28:
        if (UniversalCardTextPerfOpt.a() == false) goto L32;
        UniversalCardPrefixSpanUtils.a.getClass();
        Intrinsics.checkNotNullParameter(r0, "type");
        StringBuilder r8 = new StringBuilder();
        r8.append(r0.getType());
        r8.append('_');
        r8.append(r7);
        String r9 = r8.toString();
        LruCache<String, String> r10 = UniversalCardPrefixSpanUtils.b;
        String r11 = r10.get(r9);
        if (r11 != null) goto L34;
        r11 = fec.b.e(r0, r7);
        r10.put(r9, r11);
    L34:
        if (UniversalCardTextPerfOpt.a() == false) goto L39;
        UniversalCardPrefixSpanUtils r2 = UniversalCardPrefixSpanUtils.a;
        int r13 = this.A.d;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r11, "listNum");
        String r4 = r11 + '_' + r13;
        LruCache<String, Float> r14 = UniversalCardPrefixSpanUtils.c;
        Float r15 = r14.get(r4);
        if (r15 == null) goto L38;
        float r5 = r15.floatValue();
    L47:
        int r16 = r12.getLevel();
        if (UniversalCardTextPerfOpt.a() == false) goto L53;
        UniversalCardPrefixSpanUtils.a.getClass();
        Intrinsics.checkNotNullParameter(r1, "type");
        StringBuilder r17 = new StringBuilder();
        r17.append(r16);
        r17.append('_');
        r17.append(r1.ordinal());
        String r19 = r17.toString();
        LruCache<String, Float> r20 = UniversalCardPrefixSpanUtils.e;
        Float r21 = r20.get(r19);
        if (r21 == null) goto L52;
        float r110 = r21.floatValue();
    L55:
        if (UniversalCardTextPerfOpt.a() == false) goto L60;
        UniversalCardPrefixSpanUtils.a.getClass();
        Intrinsics.checkNotNullParameter(r1, "type");
        int r22 = r1.ordinal();
        LruCache<Integer, Float> r23 = UniversalCardPrefixSpanUtils.f;
        Float r24 = r23.get(Integer.valueOf(r22));
        if (r24 == null) goto L59;
        float r25 = r24.floatValue();
    L62:
        if (UniversalCardTextPerfOpt.a() == false) goto L67;
        UniversalCardPrefixSpanUtils r26 = UniversalCardPrefixSpanUtils.a;
        PrefixSpanStyle r27 = PrefixSpanStyle.NORMAL;
        r26.getClass();
        Intrinsics.checkNotNullParameter(r1, "type");
        Intrinsics.checkNotNullParameter(r27, "style");
        StringBuilder r29 = new StringBuilder();
        r29.append(r1.ordinal());
        r29.append('_');
        r29.append(r27.getValue());
        String r30 = r29.toString();
        LruCache<String, Float> r31 = UniversalCardPrefixSpanUtils.g;
        Float r32 = r31.get(r30);
        if (r32 == null) goto L66;
        float r33 = r32.floatValue();
    L69:
        if (UniversalCardTextPerfOpt.a() == false) goto L71;
        UniversalCardPrefixSpanUtils.a.getClass();
        int r34 = ((Number) UniversalCardPrefixSpanUtils.h.getValue()).intValue();
    L72:
        PrefixSpan.b r35 = new PrefixSpan.b();
        r35.a = r1;
        PrefixSpan r36 = new PrefixSpan(r35);
        PrefixInfo r111 = new PrefixInfo(r35);
        PrefixSpan.b r37 = r111.prefixParams;
        r37.b = true;
        r37.c = r110;
        r37.e = r25;
        r37.f = r33;
        r37.h = r34;
        r37.d = r5;
        if (r1 != r3) goto L75;
        r37.g = r11;
    L75:
        r37.i = true;
        return new Pair(r36, r111);
    L71:
        r34 = UIHelper.getColor(2131103404);
        goto L72
    L66:
        float r38 = fec.b.f(r1, r27);
        r31.put(r30, Float.valueOf(r38));
        r33 = r38;
        goto L69
    L67:
        r33 = fec.b.f(r1, PrefixSpanStyle.NORMAL);
        goto L69
    L59:
        float r39 = fec.b.a(r1);
        r23.put(Integer.valueOf(r22), Float.valueOf(r39));
        r25 = r39;
        goto L62
    L60:
        r25 = fec.b.a(r1);
        goto L62
    L52:
        r110 = fec.b.c(r16, r1);
        r20.put(r19, Float.valueOf(r110));
        goto L55
    L53:
        r110 = fec.b.c(r16, r1);
        goto L55
    L38:
        float r40 = fec.b.d(r11, r13);
        r14.put(r4, Float.valueOf(r40));
        r5 = r40;
        goto L47
    L39:
        r5 = fec.b.d(r11, this.A.d);
        goto L47
    L32:
        r11 = fec.b.e(r0, r7);
        Intrinsics.checkNotNull(r11);
        goto L34
    L24:
        if (r6.intValue() <= 0) goto L26;
        r7 = r6.intValue();
        goto L28
    L40:
        r11 = "";
        if (UniversalCardTextPerfOpt.a() == false) goto L46;
        UniversalCardPrefixSpanUtils.a.getClass();
        Intrinsics.checkNotNullParameter(r1, "type");
        int r41 = r1.ordinal();
        LruCache<Integer, Float> r42 = UniversalCardPrefixSpanUtils.d;
        Float r43 = r42.get(Integer.valueOf(r41));
        if (r43 == null) goto L45;
        r5 = r43.floatValue();
        goto L47
    L45:
        float r44 = fec.b.b(r1);
        r42.put(Integer.valueOf(r41), Float.valueOf(r44));
        r5 = r44;
        goto L47
    L46:
        r5 = fec.b.b(r1);
        goto L47
    L8:
        if ((r12.getLevel() % 3) != 1) goto L10;
        r1 = PrefixSpan.Type.HOLLOW_CIRCLE;
        goto L19
    L10:
        r1 = PrefixSpan.Type.FILL_RECT;
        goto L19
    L12:
        if ((r12.getLevel() % 3) != 0) goto L15;
    L18:
        r1 = PrefixSpan.Type.LIST_NUM;
        goto L19
    L15:
        if ((r12.getLevel() % 3) != 1) goto L17;
        r0 = RichTextElement.OLProperty.Type.LOWERCASE_A;
        goto L18
    L17:
        r0 = RichTextElement.OLProperty.Type.LOWERCASE_ROMAN;
        goto L18
    }

    @LynxProp(name = "props")
    public final void setContent(ReadableMap r55) {
        Intrinsics.checkNotNullParameter(r55, "props");
        TraceEvent.beginSection("UniversalCardTextShadowNode.setContent");
        Object r2 = null;
    L8:
        th = move-exception;
        Log.e("MsgCardTextShadowNode", "props from lynx transform failed", th);
        TextProps r14 = null;
    L10:
        if (r14 != null) goto L13;
        Log.e("MsgCardTextShadowNode", "setContent fail, content is empty");
        return;
    L13:
        this.v = r14;
        this.C = r14.getId();
        this.D = r14.getParentId();
        List<ContentProps> r0 = r14.getContentProps();
        if (r0 == null) goto L16;
        int r1 = r0.size();
    L17:
        this.y = r1;
        d r3 = this.A;
        r3.a = LKUIToast.DURATION_MAX;
        r3.c = false;
        Resources r4 = com.larksuite.framework.utils.b.a.getResources();
        r3.d = (int) TypedValue.applyDimension(2, 14.0f, WindowDisplayMetricsOverride.apply(r4, r4.getDisplayMetrics()));
        r3.e = 0;
        r3.f = Layout.Alignment.ALIGN_NORMAL;
        r3.g = TextUtils.TruncateAt.END;
        Resources r5 = com.larksuite.framework.utils.b.a.getResources();
        r3.h = TypedValue.applyDimension(1, 4.0f, WindowDisplayMetricsOverride.apply(r5, r5.getDisplayMetrics()));
        r3.i = 0;
        r3.j = 0;
        r3.k = 0;
        r3.l = 0;
        r3.m = false;
        Integer r6 = r14.getPaddingLeft();
        if (r6 == null) goto L20;
        this.A.i = r6.intValue();
    L20:
        Integer r7 = r14.getPaddingRight();
        if (r7 == null) goto L23;
        this.A.j = r7.intValue();
    L23:
        Integer r8 = r14.getPaddingTop();
        if (r8 == null) goto L26;
        this.A.k = r8.intValue();
    L26:
        Integer r9 = r14.getPaddingBottom();
        if (r9 == null) goto L29;
        this.A.l = r9.intValue();
    L29:
        Integer r10 = r14.getMaxLines();
        if (r10 != null) goto L32;
    L42:
        Integer r11 = r14.getTextLines();
        if (r11 != null) goto L45;
    L53:
        this.E = LKUIToast.DURATION_MAX;
    L54:
        String r12 = r14.getTextColor();
        if (r12 != null) goto L57;
    L68:
        Integer r13 = r14.getTextSize();
        if (r13 != null) goto L71;
    L79:
        String r15 = r14.getAlign();
        if (Intrinsics.areEqual(r15, "center") == false) goto L83;
        d r16 = this.A;
        Layout.Alignment r17 = Layout.Alignment.ALIGN_CENTER;
        r16.getClass();
        Intrinsics.checkNotNullParameter(r17, "<set-?>");
        r16.f = r17;
    L85:
        String r19 = r14.getEllipsize();
        if (r19 == null) goto L106;
        int r20 = r19.hashCode();
        if (r20 == (-1074341483)) goto L103;
        if (r20 == 109757538) goto L99;
        if (r20 == 839444514) goto L95;
    L104:
        d r21 = this.A;
        TextUtils.TruncateAt r22 = TextUtils.TruncateAt.END;
        r21.getClass();
        Intrinsics.checkNotNullParameter(r22, "<set-?>");
        r21.g = r22;
        goto L106
    L95:
        if (r19.equals("marquee") == false) goto L104;
        d r23 = this.A;
        TextUtils.TruncateAt r24 = TextUtils.TruncateAt.MARQUEE;
        r23.getClass();
        Intrinsics.checkNotNullParameter(r24, "<set-?>");
        r23.g = r24;
        goto L106
    L99:
        if (r19.equals("start") == false) goto L104;
        d r25 = this.A;
        TextUtils.TruncateAt r26 = TextUtils.TruncateAt.START;
        r25.getClass();
        Intrinsics.checkNotNullParameter(r26, "<set-?>");
        r25.g = r26;
        goto L106
    L103:
        if (r19.equals("middle") == false) goto L104;
        d r27 = this.A;
        TextUtils.TruncateAt r29 = TextUtils.TruncateAt.MIDDLE;
        r27.getClass();
        Intrinsics.checkNotNullParameter(r29, "<set-?>");
        r27.g = r29;
    L106:
        Float r30 = r14.getLineSpacing();
        if (r30 != null) goto L109;
    L117:
        List<ContentProps> r31 = r14.getContentProps();
        if (r31 == null) goto L131;
        Iterator<T> r32 = r31.iterator();
    L121:
        if (r32.hasNext() == false) goto L129;
        Object r33 = r32.next();
        if (((ContentProps) r33).getPersonProps() == null) goto L125;
        boolean r34 = true;
    L126:
        if (r34 == false) goto L121;
        r2 = r33;
        goto L129
    L125:
        r34 = false;
    L129:
        if (((ContentProps) r2) == null) goto L131;
        this.A.h = 0.0f;
    L131:
        LynxContext r35 = ((ShadowNode) this).m;
        if (r35 != null) goto L134;
        CharSequence r36 = "";
        UniversalCardTextShadowNode r37 = this;
    L156:
        r37.x = r36;
        q();
        TraceEvent.endSection("UniversalCardTextShadowNode.setContent");
        return;
    L134:
        ArrayList r50 = new ArrayList();
        ArrayList r39 = new ArrayList();
        ArrayList r51 = new ArrayList();
        ArrayList r110 = new ArrayList();
        ArrayList r38 = new ArrayList();
        ArrayList r310 = new ArrayList();
        ArrayList r311 = new ArrayList();
        ArrayList r312 = new ArrayList();
        ArrayList r40 = new ArrayList();
        ArrayList r45 = new ArrayList();
        ArrayList r42 = new ArrayList();
        ArrayList r313 = new ArrayList();
        ArrayList r46 = new ArrayList();
        ArrayList r47 = new ArrayList();
        com.larksuite.component.card.cardcontainer.c r210 = (com.larksuite.component.card.cardcontainer.c) r35.getSharedData("card_share_data", com.larksuite.component.card.cardcontainer.c.class);
        StringBuilder r52 = new StringBuilder();
        List<ContentProps> r211 = r14.getContentProps();
        if (r211 == null) goto L139;
        int r111 = r211.size();
        int r41 = 0;
    L137:
        if (r41 >= r111) goto L139;
        H(r211, r41, r35, r52, r14, r210, r50, r51, r38, r110, r39, r310, r311, r312, r40, r45, r42, r46, r47, 0);
        r41 = r41 + 1;
        r111 = r111;
        r14 = r14;
    L139:
        TextProps r53 = r14;
        new ArrayList();
        new ArrayList();
        ArrayList r43 = new ArrayList();
        ArrayList r44 = new ArrayList();
        new ArrayList();
        ArrayList r48 = new ArrayList();
        new ArrayList();
        new ArrayList();
        ArrayList r49 = new ArrayList();
        ArrayList r54 = new ArrayList();
        new ArrayList();
        new ArrayList();
        ArrayList r56 = new ArrayList();
        new ArrayList();
        ArrayList r57 = new ArrayList();
        new ArrayList();
        new ArrayList();
        ArrayList r59 = new ArrayList();
        new ArrayList();
        ArrayList r60 = new ArrayList();
        ArrayList r61 = new ArrayList();
        new ArrayList();
        new ArrayList();
        new ArrayList();
        List r62 = new RecogniseSpansResult(r51, r50, r43, r44, r110, r48, r312, r313, r49, r54, r38, r310, r56, r311, r57, r39, r40, r59, r42, r60, r61, r45, r46, r47, new ArrayList(), new ArrayList()).getAllSpanInfos();
        com.ss.android.lark.widget.light.e.a r63 = new com.ss.android.lark.widget.light.e.a(r35.getContext());
        r63.g = (int) zz7.b.h(getContext(), 14);
        r63.a(ty7.a.a().getLoginUserId());
        r63.c = false;
        r63.r = Boolean.FALSE;
        if (Intrinsics.areEqual(r53.getDisableAtStyle(), Boolean.TRUE) == false) goto L142;
        r63.u = 0;
        r63.v = UIUtils.getColor(getContext(), 2131106622);
        r63.t = UIUtils.getColor(getContext(), 2131106622);
        r63.s = UIUtils.getColor(getContext(), 2131106622);
    L143:
        r63.N = new com.ss.android.lark.widget.light.processor.t.a();
        r36 = com.ss.android.lark.widget.light.f.a.a.b(r35.getContext(), r52.toString(), r62, new com.ss.android.lark.widget.light.e(r63));
        if (TextUtils.isEmpty(r53.getTextColor()) == true) goto L146;
    L154:
        r37 = this;
    L155:
        Intrinsics.checkNotNull(r36);
        goto L156
    L146:
        if (r50.size() != 0) goto L154;
        if (r51.size() != 0) goto L154;
        if (r110.size() != 1) goto L154;
        if (((TextStyleInfo) ListProtector.get(r110, 0)).textColor == 0) goto L154;
        r37 = this;
        r37.z = ((TextStyleInfo) ListProtector.get(r110, 0)).textColor;
        r37.A.e = ((TextStyleInfo) ListProtector.get(r110, 0)).textColor;
        goto L155
    L142:
        r63.u = UIHelper.getColor(2131103404);
        r63.t = UIHelper.getColor(2131103449);
        goto L143
    L109:
        if (r30.floatValue() <= 0.0f) goto L111;
        boolean r64 = true;
    L112:
        if (r64 == true) goto L115;
        r30 = null;
    L115:
        if (r30 == null) goto L117;
        this.A.h = r30.floatValue();
        goto L117
    L111:
        r64 = false;
        goto L112
    L83:
        if (Intrinsics.areEqual(r15, "right") == false) goto L85;
        d r65 = this.A;
        Layout.Alignment r66 = Layout.Alignment.ALIGN_OPPOSITE;
        r65.getClass();
        Intrinsics.checkNotNullParameter(r66, "<set-?>");
        r65.f = r66;
        goto L85
    L71:
        if (r13.intValue() <= 0) goto L73;
        boolean r67 = true;
    L74:
        if (r67 == true) goto L77;
        r13 = null;
    L77:
        if (r13 == null) goto L79;
        int r68 = r13.intValue();
        this.A.d = (int) com.lynx.tasm.utils.i.b(r68, 0.0f);
        goto L79
    L73:
        r67 = false;
        goto L74
    L57:
        if (r12.length() <= 0) goto L59;
        boolean r69 = true;
    L60:
        if (r69 == true) goto L63;
        r12 = null;
    L63:
        if (r12 == null) goto L68;
        this.A.e = Color.parseColor(r12);     // Catch: Throwable -> L66
    L66:
        th = move-exception;
        Log.e("MsgCardTextShadowNode", "textColor parseColor failed", th);
        goto L68
    L59:
        r69 = false;
        goto L60
    L45:
        if (r11.intValue() <= 0) goto L47;
        boolean r70 = true;
    L48:
        if (r70 == true) goto L51;
        r11 = null;
    L51:
        if (r11 == null) goto L53;
        this.E = r11.intValue();
        goto L54
    L47:
        r70 = false;
        goto L48
    L32:
        if (r10.intValue() <= 0) goto L34;
        boolean r71 = true;
    L35:
        if (r71 == true) goto L38;
        r10 = null;
    L38:
        if (r10 == null) goto L42;
        int r72 = r10.intValue();
        d r73 = this.A;
        r73.a = r72;
        if (r72 != 1) goto L42;
        r73.c = true;
        goto L42
    L34:
        r71 = false;
        goto L35
    L16:
        r1 = 0;
        goto L17
    L4:
        if (UniversalCardTextPerfOpt.a() == false) goto L6;
        TextProps r74 = e.a.w(r55);     // Catch: Throwable -> L8
    L7:
        r14 = r74;
        goto L10
    L6:
        Gson r75 = com.larksuite.component.card.component.g.a;     // Catch: Throwable -> L8
        r74 = (TextProps) com.larksuite.component.card.component.g.c(r55, TextProps.class);     // Catch: Throwable -> L8
        goto L7
    }

    public static CardAttachment D(TextProps r0, com.larksuite.component.card.cardcontainer.c r1) {
        if (r0.isTranslate() == false) goto L10;
        if (r1 == null) goto L16;
        CardData r2 = r1.b;
        if (r2 == null) goto L16;
        CardContent r3 = r2.getTranslateContent();
        if (r3 == null) goto L16;
        return r3.getAttachment();
    L16:
        return null;
    L10:
        if (r1 == null) goto L16;
        CardData r4 = r1.b;
        if (r4 == null) goto L16;
        CardContent r5 = r4.getCardContent();
        if (r5 == null) goto L16;
        return r5.getAttachment();
    }

    public static void G(TextStyleInfo r6, PlainTextProps r7) {
        String r0 = r7.getTextBgColor();
        boolean r1 = false;
        String r3 = null;
        if (r0 != null) goto L5;
    L16:
        String r8 = r7.getTextColor();
        if (r8 != null) goto L19;
        return;
    L19:
        if (r8.length() <= 0) goto L21;
        r1 = true;
    L21:
        if (r1 == false) goto L23;
        r3 = r8;
    L23:
        if (r3 == null) goto L34;
        r6.textColor = Color.parseColor(r3);     // Catch: Throwable -> L26
        return;
    L26:
        th = move-exception;
        Log.e("MsgCardTextShadowNode", "parseColor textColor failed", th);
        return;
    L34:
        return;
    L5:
        if (r0.length() <= 0) goto L7;
        boolean r5 = true;
    L8:
        if (r5 == true) goto L11;
        r0 = null;
    L11:
        if (r0 == null) goto L16;
        r6.textBgColor = Color.parseColor(r0);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        Log.e("MsgCardTextShadowNode", "parseColor textBgColor failed", th);
        goto L16
    L7:
        r5 = false;
        goto L8
    }

    public static int J(Context r1, PlainTextProps r2) {
        if (r2.getTextSize() == null) goto L8;
        if (r2.getTextSize().intValue() <= 0) goto L8;
        return UIUtils.dp2px(r1, r2.getTextSize().intValue());
    L8:
        return (int) zz7.b.h(r1, 14);
    }

    public final void f(int r9, int r10) {
        TraceEvent.beginSection("UniversalCardTextShadowNode.onLayout");
        ((LayoutNode) this).e = false;
        if (this.w != null) goto L5;
        MeasureMode r7 = MeasureMode.EXACTLY;
        c(this, r9, r7, r10, r7);
    L5:
        TraceEvent.endSection("UniversalCardTextShadowNode.onLayout");
    }

    public final CardAudioInfo F(Context r11, String r12, AudioProps r13, StringBuilder r14) {
        CardAudioInfo r8 = new CardAudioInfo();
        boolean r9 = true;
        this.A.m = true;
        r8.setContentID(r12);
        ((SpanInfo) r8).type = 22;
        ((SpanInfo) r8).text = r13.getContent();
        int r15 = r14.toString().length();
        ((SpanInfo) r8).start = r15;
        ((SpanInfo) r8).end = r15 + ((SpanInfo) r8).text.length();
        K(r11, r14, r8, r13, false, "markdown_audio", false);
        com.larksuite.component.card.component.text.a r16 = r13.getAudioInfo();
        if (r16 == null) goto L7;
        Integer r17 = r16.e;
        if (r17 == null) goto L7;
        int r19 = r17.intValue();
    L8:
        r8.setAudioDuration(r19);
        MarkdownAudioState r110 = r13.getAudioState();
        Integer r1 = null;
        if (r110 == null) goto L11;
        String r111 = r110.getState();
    L12:
        r8.setLoadingAnim(Intrinsics.areEqual(r111, "preparing"));
        String r112 = r13.getBgColor();
        if (r112 != null) goto L58;
    L19:
        Boolean r113 = r13.getShowTime();
        if (r113 == null) goto L22;
        boolean r114 = r113.booleanValue();
    L23:
        r8.setShowTime(r114);
        UDIconContentProps r115 = r13.getIcon();
        if (r115 == null) goto L36;
        int r3 = com.larksuite.component.card.utils.d.a;
        r8.setIconResId(com.larksuite.component.card.utils.d.a(r115.getToken(), r11));
        int r2 = Color.parseColor(r115.getCustomColor());     // Catch: Throwable -> L28
    L30:
        r8.setIconColor(r2);
        Integer r116 = r115.getIconSize();
        if (r116 == null) goto L36;
        float r117 = r116.intValue();
        r8.setIconSize(UIUtils.dp2px(r11, r117));
        if (r117 < 16.0f) goto L35;
        r8.setIconTextGap(UIUtils.dp2px(r11, 4.0f));
        goto L36
    L35:
        r8.setIconTextGap(UIUtils.dp2px(r11, 2.0f));
    L28:
        th = move-exception;
        Log.e("MsgCardTextShadowNode", "parseAudioInfo iconColor failed", th);
        r2 = UIUtils.getColor(r11, 2131109000);
    L36:
        Integer r118 = r13.getOriginalTextSize();
        if (r118 != null) goto L39;
    L47:
        int r119 = (int) zz7.b.h(r11, 14);
    L48:
        r8.setOriginalTextSize(r119);
        Integer r120 = r13.getBgHeight();
        if (r120 == null) goto L51;
        r8.setBgHeight(UIUtils.dp2px(r11, r120.intValue()));
    L51:
        MarkdownAudioBgPadding r121 = r13.getBgPadding();
        if (r121 == null) goto L54;
        r8.setBgPaddingLeft(UIUtils.dp2px(r11, r121.getLeft()));
        r8.setBgPaddingRight(UIUtils.dp2px(r11, r121.getRight()));
    L54:
        r14.append(((SpanInfo) r8).text);
        return r8;
    L39:
        if (r118.intValue() > 0) goto L43;
        r9 = false;
    L43:
        if (Boolean.valueOf(r9).booleanValue() == false) goto L45;
        r1 = r118;
    L45:
        if (r1 == null) goto L47;
        r119 = Integer.valueOf(UIUtils.dp2px(r11, r1.intValue())).intValue();
        goto L48
    L22:
        r114 = false;
        goto L23
    L58:
        int r122 = Color.parseColor(r112);     // Catch: Throwable -> L16
    L18:
        r8.setBgColor(r122);
    L16:
        th = move-exception;
        Log.e("MsgCardTextShadowNode", "parseAudioInfo bgColor failed", th);
        r122 = UIUtils.getColor(r11, 2131100556);
        goto L18
    L11:
        r111 = null;
    L7:
        r19 = 0;
        goto L8
    }

    public final long c(LayoutNode r21, float r22, MeasureMode r23, float r24, MeasureMode r25) {
        float r1 = r22;
        Intrinsics.checkNotNullParameter(r21, "node");
        Intrinsics.checkNotNullParameter(r23, "widthMode");
        Intrinsics.checkNotNullParameter(r25, "heightMode");
        TraceEvent.beginSection("UniversalCardTextShadowNode.measure");
        Log.d("MsgCardTextShadowNode", "\n***************** measure start **********************\n");
        Log.i("MsgCardTextShadowNode", "\n***************** origin width: " + r1 + " height:" + r24 + "  widthMode:" + r23 + "  heightMode:" + r25 + " **********************\n");
        MeasureMode r6 = MeasureMode.UNDEFINED;
        boolean r9 = true;
        if (r23 == r6) goto L17;
        if (r25 == r6) goto L17;
        if (r1 != 0.0f) goto L8;
        boolean r11 = true;
    L9:
        if (r11 == false) goto L17;
        if (r24 != 0.0f) goto L13;
        boolean r12 = true;
    L14:
        if (r12 == false) goto L17;
        return y6a.i.b(0, 0);
    L13:
        r12 = false;
        goto L14
    L8:
        r11 = false;
    L17:
        CharSequence r15 = this.x;
        if (r15 == null) goto L20;
        MeasureMode r14 = MeasureMode.EXACTLY;
        if (r23 == r14) goto L24;
    L29:
        float r16 = 32767.0f;
    L31:
        if (r1 != 0.0f) goto L33;
        boolean r13 = true;
    L34:
        if (r13 == false) goto L37;
        if (r23 != r6) goto L37;
        MeasureMode r7 = MeasureMode.AT_MOST;
    L38:
        if (r25 == r14) goto L40;
    L45:
        float r17 = 32767.0f;
    L46:
        if (r25 == r14) goto L48;
    L53:
        MeasureMode r19 = MeasureMode.AT_MOST;
    L55:
        if (this.E != Integer.MAX_VALUE) goto L57;
        this.A.b = LKUIToast.DURATION_MAX;
    L64:
        u r110 = new u(new b(r15, this.A, r7, r19, r16, r17), this.y);
        this.w = r110;
        if (r110.f == true) goto L69;
        r9 = false;
    L69:
        if (r9 == false) goto L71;
        m7a.a r10 = new m7a.a(((LayoutNode) this).b, "renderFinshed");
        r10.a("isNeedShowMore", Boolean.TRUE);
    L72:
        LynxContext r8 = ((ShadowNode) this).m;
        if (r8 == null) goto L77;
        EventEmitter r20 = r8.getEventEmitter();
        if (r20 == null) goto L77;
        r20.sendCustomEvent(r10);
    L77:
        if (r23 == r14) goto L90;
        u r2 = this.w;
        if (r2 == null) goto L90;
        d r3 = r2.a.a.b;
        if (r2.e >= 0) goto L85;
        Layout r26 = r2.d;
        if (r26 == null) goto L85;
        r2.e = r26.getWidth();
    L85:
        int r4 = r2.e;
        if (r4 >= 0) goto L89;
        r4 = 0;
    L89:
        r1 = (r4 + r3.i) + r3.j;
    L90:
        if (r25 == r14) goto L94;
        u r5 = this.w;
        if (r5 == null) goto L94;
        d r27 = r5.a.a.b;
        float r29 = ((com.ss.android.lark.widget.light.layout.e.a(r5.d) + r27.k) + r27.l) + (r5.g * 2);
    L96:
        if (this.E != Integer.MAX_VALUE) goto L104;
        StringBuilder r30 = new StringBuilder("occupied lines, ");
        r30.append(this.C);
        r30.append(", ");
        u r31 = this.w;
        if (r31 == null) goto L102;
        Layout r32 = r31.d;
        if (r32 == null) goto L102;
        CharSequence r33 = r32.getText();
    L103:
        r30.append(r33);
        r30.append(" no totalTextLines");
        Log.d("MsgCardTextShadowNode", r30.toString());
    L126:
        char r111 = 0;
    L131:
        if (r111 != '\b') goto L136;
        u r34 = this.w;
        if (r34 == null) goto L135;
        r34.d = null;
    L135:
        float r35 = 0.0f;
    L137:
        Log.d("MsgCardTextShadowNode", "result width: " + r1 + " height: " + r35);
        Log.d("MsgCardTextShadowNode", "measure " + r15 + " , result, width: " + r1 + "  height: " + r35);
        Log.d("MsgCardTextShadowNode", "\n########################## measure end ############################\n");
        TraceEvent.endSection("UniversalCardTextShadowNode.measure");
        return y6a.i.a(r1, r35);
    L136:
        r35 = r29;
    L102:
        r33 = null;
        goto L103
    L104:
        UniversalCardTextShareData r36 = E();
        if (r36 != null) goto L113;
        StringBuilder r37 = new StringBuilder("occupied lines, ");
        r37.append(this.C);
        r37.append(", ");
        u r38 = this.w;
        if (r38 == null) goto L111;
        Layout r39 = r38.d;
        if (r39 == null) goto L111;
        CharSequence r40 = r39.getText();
    L112:
        r37.append(r40);
        r37.append(" textShareData is null");
        Log.d("MsgCardTextShadowNode", r37.toString());
    L111:
        r40 = null;
        goto L112
    L113:
        u r112 = this.w;
        if (r112 == null) goto L126;
        Layout r113 = r112.d;
        if (r113 == null) goto L126;
        String r114 = this.C;
        if (r114 == null) goto L126;
        CharSequence r115 = r113.getText();
        if (Intrinsics.areEqual(r115.toString(), UIUtils.getString(LarkContext.getApplication(), 2131891024)) == false) goto L128;
        UniversalCardTextShareData.b r41 = r36.tryOccupyLines(r114, 0);
        Log.d("MsgCardTextShadowNode", "occupied lines, " + r114 + ", " + r115 + ", " + r41);
        if (r41.b > 0) goto L126;
    L127:
        r111 = '\b';
        goto L131
    L128:
        UniversalCardTextShareData.b r42 = r36.tryOccupyLines(r114, r113.getLineCount());
        Log.d("MsgCardTextShadowNode", "occupied lines, " + r114 + ", " + r115 + ", " + r42);
        if (r42.c <= 0) goto L127;
    L94:
        r29 = r24;
        goto L96
    L71:
        r10 = new m7a.a(((LayoutNode) this).b, "renderFinshed");
        r10.a("isNeedShowMore", Boolean.FALSE);
        goto L72
    L57:
        UniversalCardTextShareData r116 = E();
        if (r116 != null) goto L60;
        this.A.b = LKUIToast.DURATION_MAX;
        goto L64
    L60:
        r116.setTotalTextLines(this.E);
        String r117 = this.C;
        if (r117 != null) goto L63;
        this.A.b = LKUIToast.DURATION_MAX;
        goto L64
    L63:
        this.A.b = r116.getAvailableLines(r117);
        goto L64
    L48:
        if (r24 != 0.0f) goto L50;
        boolean r118 = true;
    L51:
        if (r118 == true) goto L53;
        r19 = r14;
        goto L55
    L50:
        r118 = false;
        goto L51
    L40:
        if (r24 != 0.0f) goto L42;
        boolean r119 = true;
    L43:
        if (r119 == true) goto L45;
        r17 = r24;
        goto L46
    L42:
        r119 = false;
    L37:
        r7 = r23;
        goto L38
    L33:
        r13 = false;
        goto L34
    L24:
        if (r1 != 0.0f) goto L26;
        boolean r120 = true;
    L27:
        if (r120 == true) goto L29;
        r16 = r1;
        goto L31
    L26:
        r120 = false;
        goto L27
    L20:
        return y6a.i.b(0, 0);
    }

    public static /* synthetic */ void L(UniversalCardTextShadowNode r8, Context r9, StringBuilder r10, TextStyleInfo r11, PlainTextProps r12, boolean r13, String r14) {
        r8.K(r9, r10, r11, r12, r13, r14, false);
    }

    public final void K(Context r2, StringBuilder r3, TextStyleInfo r4, PlainTextProps r5, boolean r6, String r7, boolean r8) {
        r4.textSize = J(r2, r5);
        r4.maxLines = r5.getMaxLines();
        if (r6 == false) goto L6;
        ((SpanInfo) r4).type = 4;
        ((SpanInfo) r4).start = r3.toString().length();
        String r9 = r5.getContent();
        ((SpanInfo) r4).text = r9;
        ((SpanInfo) r4).end = ((SpanInfo) r4).start + r9.length();
        r3.append(((SpanInfo) r4).text);
    L6:
        if (Intrinsics.areEqual("at", r7) == false) goto L8;
    L11:
        if (r8 == false) goto L14;
        G(r4, r5);
    L14:
        if (r4.textColor == 0) goto L16;
    L22:
        List<String> r10 = r5.getTextDecoration();
        if (r10 != null) goto L25;
        return;
    L25:
        if (r10.contains("underline") == false) goto L28;
        r4.isUnderlineText = true;
    L28:
        if (r10.contains("strikethrough") == false) goto L31;
        r4.isStrikeThruText = true;
    L31:
        if (r10.contains("italic") == false) goto L34;
        r4.isItalic = true;
    L34:
        if (r10.contains("bold") == false) goto L38;
        r4.isBold = true;
        return;
    L38:
        return;
    L16:
        if (Intrinsics.areEqual("plain_text", r7) == false) goto L18;
    L19:
        int r11 = this.B;
        if (r11 == 0) goto L22;
        r4.textColor = UIUtils.getColor(r2, r11);
        goto L22
    L18:
        if (Intrinsics.areEqual("code_span", r7) == false) goto L22;
    L8:
        if (Intrinsics.areEqual("at_all", r7) == true) goto L11;
        G(r4, r5);
        goto L14
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 35131. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    public final void H(java.util.List r37, int r38, com.lynx.tasm.behavior.LynxContext r39, java.lang.StringBuilder r40, com.larksuite.component.card.component.text.TextProps r41, com.larksuite.component.card.cardcontainer.c r42, java.util.ArrayList r43, java.util.ArrayList r44, java.util.ArrayList r45, java.util.ArrayList r46, java.util.ArrayList r47, java.util.ArrayList r48, java.util.ArrayList r49, java.util.ArrayList r50, java.util.ArrayList r51, java.util.ArrayList r52, java.util.ArrayList r53, java.util.ArrayList r54, java.util.ArrayList r55, int r56) {
        /*  JADX ERROR: Simple mode code generation failed
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0000: MOVE (r15v0 ?? I:??[OBJECT, ARRAY]) = (r36v0 'this' ?? I:??[OBJECT, ARRAY] A[IMMUTABLE_TYPE, THIS]) A[DECLARE_VAR] (LINE:335544320) in method: com.larksuite.component.card.component.text.UniversalCardTextShadowNode.H(java.util.List, int, com.lynx.tasm.behavior.LynxContext, java.lang.StringBuilder, com.larksuite.component.card.component.text.TextProps, com.larksuite.component.card.cardcontainer.c, java.util.ArrayList, java.util.ArrayList, java.util.ArrayList, java.util.ArrayList, java.util.ArrayList, java.util.ArrayList, java.util.ArrayList, java.util.ArrayList, java.util.ArrayList, java.util.ArrayList, java.util.ArrayList, java.util.ArrayList, java.util.ArrayList, int):void, file: /private/tmp/nixiang/classes24.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:348)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.ArgType.getPrimitiveType()" because "type" is null
            	at jadx.core.codegen.ClassGen.useType(ClassGen.java:564)
            	at jadx.core.codegen.InsnGen.useType(InsnGen.java:269)
            	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:166)
            	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:159)
            	at jadx.core.codegen.InsnGen.assignVar(InsnGen.java:152)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:299)
            	... 31 more
            */
        /*
            Method dump skipped, instruction units count: 3513
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.larksuite.component.card.component.text.UniversalCardTextShadowNode.H(java.util.List, int, com.lynx.tasm.behavior.LynxContext, java.lang.StringBuilder, com.larksuite.component.card.component.text.TextProps, com.larksuite.component.card.cardcontainer.c, java.util.ArrayList, java.util.ArrayList, java.util.ArrayList, java.util.ArrayList, java.util.ArrayList, java.util.ArrayList, java.util.ArrayList, java.util.ArrayList, java.util.ArrayList, java.util.ArrayList, java.util.ArrayList, java.util.ArrayList, java.util.ArrayList, int):void");
    }
}
